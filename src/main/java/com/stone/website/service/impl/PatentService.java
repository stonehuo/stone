package com.kpap.website.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.cxf.common.util.CollectionUtils;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpap.basis.constant.Const;
import com.kpap.basis.dao.ComMapper;
import com.kpap.basis.dao.ComPatentMapper;
import com.kpap.basis.dao.ComPatentSumMapper;
import com.kpap.basis.dao.IqComPatentMapper;
import com.kpap.basis.dao.IqComPatentSumMapper;
import com.kpap.basis.exception.BusinessException;
import com.kpap.basis.model.Com;
import com.kpap.basis.model.ComPatent;
import com.kpap.basis.model.ComPatentExample;
import com.kpap.basis.model.ComPatentSum;
import com.kpap.basis.model.ComPatentSumExample;
import com.kpap.basis.model.IqCom;
import com.kpap.basis.model.IqComPatent;
import com.kpap.basis.model.IqComPatentExample;
import com.kpap.basis.model.IqComPatentSum;
import com.kpap.basis.model.IqComPatentSumExample;
import com.kpap.basis.util.MD5Util;
import com.kpap.basis.util.StatisticsUtil;
import com.kpap.client.model.PatentDataInfo;
import com.kpap.client.model.PatentIndexInfo;
import com.kpap.client.model.ResultData;
import com.kpap.client.model.SectionInfo;
import com.kpap.client.service.IEvalService;
import com.kpap.client.service.impl.ClientLoginInterceptor;
import com.kpap.common.constant.CoreConst;
import com.kpap.common.util.DateUtil;
import com.kpap.website.model.PatentArrInfo;

/**
 * 
 * 专利评估接口<BR>
 *
 * @auther shenhaiwen
 * @date 2016-12-17 下午09:45:30
 */
@Service
public  class PatentService{
	
	private static final Logger logger = LoggerFactory.getLogger(PatentService.class);
	
	@Autowired
	private ComPatentSumMapper comPatentSumMapper;
	
	@Autowired
	private IqComPatentMapper iqComPatentMapper;
	
	@Autowired 
	private IqComPatentSumMapper iqComPatentSumMapper;
	
	@Autowired
	private ComPatentMapper comPatentMapper;
	
	@Autowired
	private ComMapper comMapper;
	
	public void resetPatent(String proCode){
		ComPatentExample comPatentExample=new ComPatentExample();
		comPatentExample.createCriteria().andPro_codeEqualTo(proCode);
		comPatentMapper.deleteByExample(comPatentExample);
		
		ComPatentSumExample comPatentSumExample=new ComPatentSumExample();
		comPatentSumExample.createCriteria().andPro_codeEqualTo(proCode);
		comPatentSumMapper.deleteByExample(comPatentSumExample);
		
		IqComPatentExample iqComPatentExample=new IqComPatentExample();
		iqComPatentExample.createCriteria().andProCodeEqualTo(proCode);
		iqComPatentMapper.deleteByExample(iqComPatentExample);
		
		IqComPatentSumExample iqComPatentSumExample=new IqComPatentSumExample();
		iqComPatentSumExample.createCriteria().andPro_codeEqualTo(proCode);
		iqComPatentSumMapper.deleteByExample(iqComPatentSumExample);
	}
	
	
	/***
	 * 调用中信专利局接口进行可比公司专利评分
	 * @param pa 公司名称，包括子公司，如浙江吉利汽车研究院有限公司,浙江吉利控股集团有限公司
	 * @param ipc 若没有，为空
	 * @param proCode 项目编码，可比公司
	 *  @param companyName 母公司名称
	 */
	public PatentArrInfo iqPatentEvaluation(String pa,String ipc,IqCom iqCom){
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(IEvalService.class);//注册WebService接口
		factory.setAddress(CoreConst.PATENT_URL);//设置WebService地址
		factory.getOutInterceptors().add(new ClientLoginInterceptor(CoreConst.PARENT_USERNAME,CoreConst.PARENT_PASSWORD));//设置设置用户账号及密码
		String api_key=CoreConst.PATENT_API_KEY;//分配的api_key
		String secret_key = CoreConst.PATENT_SECRET_KEY;
		String signStr = "api_key="+api_key + "date="+ DateUtil.date2Str(new Date(), DateUtil.yearMonthDayFormat) + secret_key;
		//分配的验证字符串
		String sign = MD5Util.md5Sign(signStr);
		logger.info("签名前请求字符串："+signStr+",加密后字符串:"+sign+",公司："+pa+",母公司："+iqCom.getName());
		IEvalService client = (IEvalService)factory.create();//客户端对象
		//设置客户端的配置信息，超时等.
		org.apache.cxf.endpoint.Client proxy = ClientProxy.getClient(client);
		HTTPConduit conduit = (HTTPConduit) proxy.getConduit();
		HTTPClientPolicy policy = new HTTPClientPolicy();
		policy.setConnectionTimeout(30000); //连接超时时间
		policy.setReceiveTimeout(180000);//请求超时时间.
		conduit.setClient(policy);
		ResultData info = client.loadDataFromSearch(pa,ipc, api_key, sign);//调用服务
		logger.info("返回响应码："+info.getCode()+"，响应信息："+info.getMessage());
		if(!"200".equals(info.getCode())){
			throw new BusinessException("专业评估接口请求异常："+info.getMessage());
		}
		List<PatentDataInfo> list = info.getCompanyPatent();
		PatentArrInfo patentArrInfo = getPatentArrList(list,iqCom.getName()); // 包括同一家公司的母公司和子公司
		if(patentArrInfo==null){
			return null;
		}
		patentAvgStatistic(patentArrInfo,iqCom.getProCode(),iqCom);
		return patentArrInfo;
	}
	
	/***
	 * 调用中信专利局接口进行被评估公司专利评分
	 * 
	 * @param pa 公司名称及其子公司，如浙江吉利汽车研究院有限公司
	 * @param ipc 若没有，为空
	 * @param proCode 项目编码，被评估公司
	 * @param companyName 母公司
	 */
	public void comPatentEvaluation(String pa,String ipc,Com com){
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(IEvalService.class);//注册WebService接口
		factory.setAddress(CoreConst.PATENT_URL);//设置WebService地址
		factory.getOutInterceptors().add(new ClientLoginInterceptor(CoreConst.PARENT_USERNAME,CoreConst.PARENT_PASSWORD));//设置设置用户账号及密码
		String api_key=CoreConst.PATENT_API_KEY;//分配的api_key
		String secret_key = CoreConst.PATENT_SECRET_KEY;
		String signStr = "api_key="+api_key + "date="+ DateUtil.date2Str(new Date(), DateUtil.yearMonthDayFormat) + secret_key;
		//分配的验证字符串
		String sign = MD5Util.md5Sign(signStr);
		logger.info("被评估公司签名前请求字符串："+signStr+",加密后字符串:"+sign+",公司："+pa+",母公司："+com.getName());
		
		IEvalService client = (IEvalService)factory.create();//客户端对象
		//设置客户端的配置信息，超时等.
		org.apache.cxf.endpoint.Client proxy = ClientProxy.getClient(client);
		HTTPConduit conduit = (HTTPConduit) proxy.getConduit();
		HTTPClientPolicy policy = new HTTPClientPolicy();
		policy.setConnectionTimeout(30000); //连接超时时间
		policy.setReceiveTimeout(180000);//请求超时时间.
		conduit.setClient(policy);
		ResultData info = client.loadDataFromSearch(pa,ipc, api_key, sign);//调用服务
		logger.info("返回响应码："+info.getCode()+"，响应信息："+info.getMessage());
		if(!"200".equals(info.getCode())){
			throw new BusinessException("专业评估接口请求异常："+info.getMessage());
		}
		List<PatentDataInfo> list = info.getCompanyPatent();
		if(list == null || list.size() <= 0){
			throw new BusinessException("没有获取到公司专利信息");
		}
		//每项专利数据数据库持久化
		
		int countFm=0;//发明公开专利数量
		int countSq=0;//发明授权专利数量
		int countXx=0;//实用新型专利数量
		int countWg=0;//外观设计专利数量
		for(int j=0;j<list.size();j++){
			PatentDataInfo patentDataInfo = list.get(j);
			List<PatentIndexInfo> dataList = patentDataInfo.getDataList(); //返回的专利内容及指标项内容
			if(CollectionUtils.isEmpty(dataList)){
				continue;
			}
			List<SectionInfo> sectionList = patentDataInfo.getSectionList();//专利库检索命中专利数量统计
			for(int m = 0; m < sectionList.size(); m++){
				SectionInfo sectionInfo = sectionList.get(m);
				int count=sectionInfo.getPatentCount();
				if("FM".equals(sectionInfo.getSectionName())){//发明公开：FM
					countFm = countFm+count;
				}else if("SQ".equals(sectionInfo.getSectionName())){//发明授权：SQ
					countSq=countSq+count;
				}else if("XX".equals(sectionInfo.getSectionName())){//实用新型：XX
					countXx=countXx+count;
				}else{//外观设计：WG 
					countWg=countWg+count;
				}
			}
			for(int i = 0;i< dataList.size() ; i++){
				PatentIndexInfo patentIndexInfo = dataList.get(i);
				saveComPatent(com.getProCode(), patentIndexInfo);
			}
		}
		
		Com com_update=new Com();
		com_update.setProCode(com.getProCode());
		com_update.setCountFm(countFm);
		com_update.setCountSq(countSq);
		com_update.setCountWg(countWg);
		com_update.setCountXx(countXx);
		
		comMapper.updateByPrimaryKeySelective(com_update);
	}
	/**
	 * 专利评分计算
	 * @param proCode
	 */
	public void patentCal(String proCode){
		iqComPatentStatistic(proCode);//行业统计
		comPatentStatistic(proCode);//专利评分算法实现
		
	}
	
	/**
	 * 每个获取专利数组统计信息
	 * 
	 * @param list
	 * @param companyName 母公司名称
	 * @return
	 */
	private PatentArrInfo getPatentArrList(List<PatentDataInfo> list,String companyName) {
		if(list == null || list.size() <= 0){
			logger.warn("["+companyName+"]没有获取到公司专利信息");
			return null;
		}
		
		int countIqFm=0;//发明公开专利数量
		int countIqSq=0;//发明授权专利数量
		int countIqXx=0;//实用新型专利数量
		int countIqWg=0;//外观设计专利数量
		List<PatentIndexInfo> allDataList = new ArrayList<PatentIndexInfo>();
		for(int i=0;i<list.size();i++){
			PatentDataInfo patentDataInfo = list.get(i); // 每家公司
			List<PatentIndexInfo> dataList = patentDataInfo.getDataList();//返回的专利内容及指标项内容
			// 对专利各项进行统计
			if(dataList == null || dataList.size() <= 0){
				continue;
			}
			allDataList.addAll(dataList);
			List<SectionInfo> sectionList = patentDataInfo.getSectionList();//专利库检索命中专利数量统计
			for(int m = 0; m < sectionList.size(); m++){
				SectionInfo sectionInfo = sectionList.get(m);
				int count=sectionInfo.getPatentCount();
				if("FM".equals(sectionInfo.getSectionName())){//发明公开：FM
					countIqFm = countIqFm+count;
				}else if("SQ".equals(sectionInfo.getSectionName())){//发明授权：SQ
					countIqSq=countIqSq+count;
				}else if("XX".equals(sectionInfo.getSectionName())){//实用新型：XX
					countIqXx=countIqXx+count;
				}else{//外观设计：WG 
					countIqWg=countIqWg+count;
				}
			}
		}
			int count = allDataList.size();
			if(count==0){
				logger.warn("["+companyName+"]没有获取到公司专利信息");
				return null;
			}
			int[] icln = new int[count]; // '独立权利要求数 ';
			int[] cigc = new int[count];// '被引证次数 ';
			int[] dcln = new int[count]; // '从属权利要求数 ';
			int[] ipcsc = new int[count]; // '分类号（小类）数量 ';
			int[] rmn = new int[count]; // '剩余有效期,单位为:天 ';
			int[] cipc = new int[count]; // '引证次数 ';
			int[] inco = new int[count]; // '专利技术人员投入数量 ';
			int[] plic = new int[count]; // '专利诉讼次数 ';
			int[] pcc = new int[count]; // '专利许可次数 ';
			int[] ppc = new int[count]; // ' 专利质押保全次数 ';
			int[] tcc = new int[count]; // '专利转让次数 ';
			int[] desPage = new int[count]; // '说明书页数 ';
			int[] drawPage = new int[count]; // '附图页数 ';
			int[] sfcl = new int[count]; // '专利同族覆盖国家数 ';
			int[] fajp = new int[count]; // '日韩同族 ';
			int[] faus = new int[count]; // ' 欧美同族 ';
			int[] faot = new int[count]; // '其他国家同族 ';
			int patt_a = 0; // '专利类型--发明';
			int patt_b = 0; // '专利类型--实用新型';
			int clt_a = 0; // '独立权利要求种类--产品';
			int clt_b = 0; // '独立权利要求种类 --方法';
			int clt_c = 0; // '独立权利要求种类 --方法+产品';
			for(int j=0;j< count;j++){
				PatentIndexInfo patentIndexInfo = allDataList.get(j);
				icln[j] = patentIndexInfo.getIcln();
				cigc[j] = patentIndexInfo.getCigc();
				dcln[j] = patentIndexInfo.getDcln();
				ipcsc[j] = patentIndexInfo.getIpcsc();
				rmn[j] = patentIndexInfo.getRmn();
				cipc[j] = patentIndexInfo.getCipc();
				inco[j] = patentIndexInfo.getInco();
				plic[j] = patentIndexInfo.getPlic();
				pcc[j] = patentIndexInfo.getPcc();
				ppc[j] = patentIndexInfo.getPcc();
				tcc[j] = patentIndexInfo.getIcln();
				desPage[j] = patentIndexInfo.getDesPage();
				drawPage[j] = patentIndexInfo.getDrawPage();
				sfcl[j] = patentIndexInfo.getSfcl();
				fajp[j] = patentIndexInfo.getFajp();
				faus[j] = patentIndexInfo.getFaus();
				faot[j] = patentIndexInfo.getFaot();
				// 独立权利要求种类,01产品，02方法，03方法+产品
				if("01".equals(patentIndexInfo.getClt())){//01产品
					clt_a = clt_a + 1;
				}else if("02".equals(patentIndexInfo.getClt())){//02方法
					clt_b = clt_b + 1;
				}else{//03方法+产品
					clt_c = clt_c + 1;
				}
				// 专利类型及当前权利状态, FM表示发明公开，SQ表示授权，XX表示实用新型，外观专利不在指标评估范围之内 
				if("FM".equals(patentIndexInfo.getPatt())){//发明公开
					patt_a = patt_a + 1;
				}else if("SQ".equals(patentIndexInfo.getPatt())){//表示授权
					patt_a = patt_a + 1;
				}else{//实用新型
					patt_b = patt_b + 1;
				}
			}
			PatentArrInfo patentArrInfo = new PatentArrInfo();
			patentArrInfo.setCompany(companyName);
			patentArrInfo.setPatt_a(patt_a);
			patentArrInfo.setPatt_b(patt_b);
			patentArrInfo.setIcln(icln);
			patentArrInfo.setCigc(cigc);
			patentArrInfo.setDcln(dcln);
			patentArrInfo.setIpcsc(ipcsc);
			patentArrInfo.setRmn(rmn);
			patentArrInfo.setCipc(cipc);
			patentArrInfo.setInco(inco);
			patentArrInfo.setPlic(plic);
			patentArrInfo.setPcc(pcc);
			patentArrInfo.setPpc(ppc);
			patentArrInfo.setTcc(tcc);
			patentArrInfo.setDesPage(desPage);
			patentArrInfo.setSfcl(sfcl);
			patentArrInfo.setFajp(fajp);
			patentArrInfo.setFaus(faus);
			patentArrInfo.setFaot(faot);
			patentArrInfo.setPatt_a(patt_a);
			patentArrInfo.setPatt_b(patt_b);
			patentArrInfo.setClt_a(clt_a);
			patentArrInfo.setClt_b(clt_b);
			patentArrInfo.setClt_c(clt_c);
			
			patentArrInfo.setCountIqFm(countIqFm);
			patentArrInfo.setCountIqSq(countIqSq);
			patentArrInfo.setCountIqWg(countIqWg);
			patentArrInfo.setCountIqXx(countIqXx);
			return patentArrInfo;
	}

	/**
	 * 专业行情统计
	 * 
	 * @param proCode
	 * @param count 公司个数
	 * @param patentArrList
	 */
	public void iqComPatentStatistic(String proCode) {
		IqComPatentExample example=new IqComPatentExample();
		example.createCriteria().andProCodeEqualTo(proCode);
		List<IqComPatent> iqComPatents=iqComPatentMapper.selectByExample(example);
		
		int count = iqComPatents.size();
		double[] icln = new double[count]; // '独立权利要求数 ';
		double[] cigc = new double[count];// '被引证次数 ';
		double[] dcln = new double[count]; // '从属权利要求数 ';
		double[] ipcsc = new double[count]; // '分类号（小类）数量 ';
		double[] rmn = new double[count]; // '剩余有效期,单位为:天 ';
		double[] cipc = new double[count]; // '引证次数 ';
		double[] inco = new double[count]; // '专利技术人员投入数量 ';
		double[] plic = new double[count]; // '专利诉讼次数 ';
		double[] pcc = new double[count]; // '专利许可次数 ';
		double[] ppc = new double[count]; // ' 专利质押保全次数 ';
		double[] tcc = new double[count]; // '专利转让次数 ';
		double[] desPage = new double[count]; // '说明书页数 ';
		double[] drawPage = new double[count]; // '附图页数 ';
		double[] sfcl = new double[count]; // '专利同族覆盖国家数 ';
		double[] fajp = new double[count]; // '日韩同族 ';
		double[] faus = new double[count]; // ' 欧美同族 ';
		double[] faot = new double[count]; // '其他国家同族 ';
		double[]  patt_a = new double[count]; // '专利类型--发明';
		double[]  patt_b = new double[count]; // '专利类型--实用新型';
		double[] clt_a = new double[count]; // '独立权利要求种类--产品';
		double[] clt_b = new double[count]; // '独立权利要求种类 --方法';
		double[] clt_c = new double[count]; // '独立权利要求种类 --方法+产品';
		
		// 1、可比公司统计
		for(int i=0;i<count;i++){
			IqComPatent iqComPatent = iqComPatents.get(i);
			// 每个公司：行业基础数据的获取
			icln[i] = iqComPatent.getIcln();
			cigc[i] = iqComPatent.getCigc();
			dcln[i] = iqComPatent.getDcln();
			ipcsc[i] = iqComPatent.getIpcsc();
			rmn[i] = iqComPatent.getRmn();
			cipc[i] = iqComPatent.getCipc();
			inco[i] = iqComPatent.getInco();
			plic[i] = iqComPatent.getPlic();
			pcc[i] = iqComPatent.getPcc();
			ppc[i] = iqComPatent.getPcc();
			tcc[i] = iqComPatent.getIcln();
			desPage[i] = iqComPatent.getDespage();
			drawPage[i] = iqComPatent.getDrawpage();
			sfcl[i] = iqComPatent.getSfcl();
			fajp[i] = iqComPatent.getFajp();
			faus[i] = iqComPatent.getFaus();
			faot[i] = iqComPatent.getFaot();
			patt_a[i] =iqComPatent.getPattA();
			patt_b[i] =iqComPatent.getPattB();
			clt_a[i] = iqComPatent.getCltA();
			clt_b[i] =iqComPatent.getCltB();
			clt_c[i] =iqComPatent.getCltC();
		}
		// 2、行业信息统计
		// 合计
		iqPatentSumStatistic(proCode, icln, cigc, dcln, ipcsc, rmn, cipc, inco, plic, pcc, ppc, tcc, desPage, drawPage,
				sfcl, fajp, faus, faot,patt_a,patt_b,clt_a,clt_b,clt_c);
		// 平均数
		iqPatentAvgStatistic(proCode, icln, cigc, dcln, ipcsc, rmn, cipc, inco, plic, pcc, ppc, tcc, desPage, drawPage,
				sfcl, fajp, faus, faot,patt_a,patt_b,clt_a,clt_b,clt_c);
		//方差
		iqPatentVarStatistic(proCode, icln, cigc, dcln, ipcsc, rmn, cipc, inco, plic, pcc, ppc, tcc, desPage, drawPage,
				sfcl, fajp, faus, faot,patt_a,patt_b,clt_a,clt_b,clt_c);
		//标准差
		iqPatentStaStatistic(proCode, icln, cigc, dcln, ipcsc, rmn, cipc, inco, plic, pcc, ppc, tcc, desPage, drawPage,
				sfcl, fajp, faus, faot,patt_a,patt_b,clt_a,clt_b,clt_c);
	}
	
	/***
	 * 调用中信专利局接口进行被评估公司专利评分
	 * 
	 * @param pa 公司名称及其子公司，如浙江吉利汽车研究院有限公司
	 * @param ipc 若没有，为空
	 * @param proCode 项目编码，被评估公司
	 * @param companyName 母公司
	 */
	public void comPatentStatistic(String proCode){
		ComPatentExample example=new ComPatentExample();
		example.createCriteria().andPro_codeEqualTo(proCode);
		List<ComPatent> comPatents=comPatentMapper.selectByExample(example);
		
		int count = comPatents.size();
		double[] icln = new double[count]; // '独立权利要求数 ';
		double[] cigc = new double[count];// '被引证次数 ';
		double[] dcln = new double[count]; // '从属权利要求数 ';
		double[] ipcsc = new double[count]; // '分类号（小类）数量 ';
		double[] rmn = new double[count]; // '剩余有效期,单位为:天 ';
		double[] cipc = new double[count]; // '引证次数 ';
		double[] inco = new double[count]; // '专利技术人员投入数量 ';
		double[] plic = new double[count]; // '专利诉讼次数 ';
		double[] pcc = new double[count]; // '专利许可次数 ';
		double[] ppc = new double[count]; // ' 专利质押保全次数 ';
		double[] tcc = new double[count]; // '专利转让次数 ';
		double[] desPage = new double[count]; // '说明书页数 ';
		double[] drawPage = new double[count]; // '附图页数 ';
		double[] sfcl = new double[count]; // '专利同族覆盖国家数 ';
		double[] fajp = new double[count]; // '日韩同族 ';
		double[] faus = new double[count]; // ' 欧美同族 ';
		double[] faot = new double[count]; // '其他国家同族 ';
		double patt_a =0; // '专利类型--发明';
		double patt_b =0; // '专利类型--实用新型';
		double clt_a =0; // '独立权利要求种类--产品';
		double clt_b =0; // '独立权利要求种类 --方法';
		double clt_c =0; // '独立权利要求种类 --方法+产品';
		
		for(int i=0;i<count;i++){
			ComPatent comPatent = comPatents.get(i);
			// 每个公司：行业基础数据的获取
			icln[i] = comPatent.getIcln();
			cigc[i] = comPatent.getCigc();
			dcln[i] = comPatent.getDcln();
			ipcsc[i] = comPatent.getIpcsc();
			rmn[i] = comPatent.getRmn();
			cipc[i] = comPatent.getCipc();
			inco[i] = comPatent.getInco();
			plic[i] = comPatent.getPlic();
			pcc[i] = comPatent.getPcc();
			ppc[i] = comPatent.getPcc();
			tcc[i] = comPatent.getIcln();
			desPage[i] = comPatent.getDespage();
			drawPage[i] = comPatent.getDrawpage();
			sfcl[i] = comPatent.getSfcl();
			fajp[i] = comPatent.getFajp();
			faus[i] = comPatent.getFaus();
			faot[i] = comPatent.getFaot();
			// 独立权利要求种类,01产品，02方法，03方法+产品
			if("01".equals(comPatent.getClt())){//01产品
				clt_a = clt_a + 1;
			}else if("02".equals(comPatent.getClt())){//02方法
				clt_b = clt_b + 1;
			}else{//03方法+产品
				clt_c = clt_c + 1;
			}
			// 专利类型及当前权利状态, FM表示发明公开，SQ表示授权，XX表示实用新型，外观专利不在指标评估范围之内 
			if("FM".equals(comPatent.getPatt())){//发明公开
				patt_a = patt_a + 1;
			}else if("SQ".equals(comPatent.getPatt())){//表示授权
				patt_a = patt_a + 1;
			}else{//实用新型
				patt_b = patt_b + 1;
			}
		}
		
		// 合计
		patentSumStatistic(proCode, icln, cigc, dcln, ipcsc, rmn, cipc, inco, plic, pcc, ppc, tcc, desPage, drawPage, sfcl, fajp, faus, faot, patt_a, patt_b, clt_a, clt_b, clt_c); 
		// 方差
		patentVarianceStatistic(proCode, icln, cigc, dcln, ipcsc, rmn, cipc, inco, plic, pcc, ppc, tcc, desPage, drawPage, sfcl, fajp, faus, faot);
		// 标准差
		patentStandardDevitionStatistic(proCode, icln, cigc, dcln, ipcsc, rmn, cipc, inco, plic, pcc, ppc, tcc, desPage, drawPage, sfcl, fajp, faus, faot);
		// 平均数
		ComPatentSum patentAvg=patentAvgStatistic(proCode, icln, cigc, dcln, ipcsc, rmn, cipc, inco, plic, pcc, ppc, tcc, desPage, drawPage, sfcl, fajp, faus, faot, patt_a, patt_b, clt_a, clt_b, clt_c);
		
		// 评估单位专利状况打分表:
		// 1）基础数据：行业平均数、行业标准差、被评估公司平均分、权重
		IqComPatentSumExample iqComPatentSumExample = new IqComPatentSumExample();
		iqComPatentSumExample.createCriteria().andPro_codeEqualTo(proCode).andTypeEqualTo(Const.PatentSumCost.AVG.getValue());
		List<IqComPatentSum> iqComPatentSumList = iqComPatentSumMapper.selectByExample(iqComPatentSumExample);
		if(iqComPatentSumList == null || iqComPatentSumList.size() <= 0){
			throw new BusinessException("没有获取到行业平均分，请先统计行业平均分");
		}
		IqComPatentSum iqPatentAvg = iqComPatentSumList.get(0);
		
		IqComPatentSumExample iqComPatentSumByStaExample = new IqComPatentSumExample();
		iqComPatentSumByStaExample.createCriteria().andPro_codeEqualTo(proCode).andTypeEqualTo(Const.PatentSumCost.STA.getValue());
		List<IqComPatentSum> iqComPatentStaList = iqComPatentSumMapper.selectByExample(iqComPatentSumByStaExample);
		if(iqComPatentStaList == null || iqComPatentStaList.size() <= 0){
			throw new BusinessException("没有获取到行业标准差，请先统计行业标准差");
		}
		IqComPatentSum iqPatentSta = iqComPatentStaList.get(0);
		// 被评估单位总的得分和取分
		saveComPatentSumTakeAndScore(proCode, patentAvg, iqPatentAvg, iqPatentSta);
		// 被评估单位各个专利的总得分 TODO这块代码性能待优化
		double scoreTotal = 0;
		for(int j=0;j<comPatents.size();j++){
			ComPatent comPatent = comPatents.get(j);
			double score = getComPatentScore(proCode,iqPatentAvg, iqPatentSta,comPatent);
			comPatent.setScore(score);
			scoreTotal = scoreTotal + score;
		}
		//每项专利数据数据库持久化，设置权重 得分/总得分
		double lastWeight=0;
		for(int j=0;j<comPatents.size();j++){
			ComPatent comPatent = comPatents.get(j);
			if(j==(comPatents.size()-1)){
				BigDecimal weight=BigDecimal.valueOf(1-lastWeight); 
				comPatent.setWeight(weight.doubleValue());
			}else{
				BigDecimal weight=new  BigDecimal(comPatent.getScore()/scoreTotal); 
				double doubleWeight=weight.setScale(4,BigDecimal.ROUND_HALF_UP).doubleValue();
				comPatent.setWeight(doubleWeight);
				lastWeight=lastWeight+doubleWeight;
			}
			comPatentMapper.updateByPrimaryKeySelective(comPatent);
		}
		
		Com com=new Com();
		com.setProCode(proCode);
		com.setScore(new BigDecimal(scoreTotal));
		comMapper.updateByPrimaryKeySelective(com);
		
	}
	
	
	/**
	 * 被评估单位各个专利的总得分
	 * 
	 * @param proCode
	 * @param patentAvg
	 * @param iqPatentAvg
	 * @param iqPatentSta
	 */
	private double getComPatentScore(String proCode, IqComPatentSum iqPatentAvg,
			IqComPatentSum iqPatentSta,ComPatent comPatent) {
		double score = 0;
		//独立权利要求数 
		int[] iclnGradeValue = {0,50,70,80,100,90,80,60,0};
		double icln = getPatentTake(iqPatentAvg.getIcln(),iqPatentSta.getIcln(),comPatent.getIcln(),iclnGradeValue);
		score = score + icln*0.0493;
	    // 被引证次数
		int[] cigcGradeValue = {10,20,30,40,50,60,80,100,100};
		double cigc = getPatentTake(iqPatentAvg.getCigc(),iqPatentSta.getCigc(),comPatent.getCigc(),cigcGradeValue);
		score = score +cigc*0.0822;
		// 从属权利要求数
		int[] dclnGradeValue = {0,50,70,80,100,90,80,60,0};
		double dcln = getPatentTake(iqPatentAvg.getDcln(),iqPatentSta.getDcln(),comPatent.getDcln(),dclnGradeValue);
		score = score + dcln*0.0822;
		// 01产品，02方法，03方法+产品
		String clt = comPatent.getClt();
		double cltCAvg = 0;
		double cltBAvg = 0;
		double cltAAvg = 0;
		if("03".equals(clt)){
			cltCAvg = 1;
		}
		if("02".equals(clt)){
			cltBAvg = 1;
		}
		if("01".equals(clt)){
			cltAAvg = 1;
		}
		// 独立权利要求种类： 方法和产品
		int[] cltCGradeValue = {10,20,30,40,50,60,80,100,100};
		double cltC = getPatentTake(iqPatentAvg.getClt_c(),iqPatentSta.getClt_c(),cltCAvg,cltCGradeValue);
		score = score + cltC*0.0329;
		// 独立权利要求种类： 方法
		int[] cltBGradeValue = {10,20,30,40,50,60,80,100,100};
		double cltB = getPatentTake(iqPatentAvg.getClt_b(),iqPatentSta.getClt_b(),cltBAvg,cltBGradeValue);
		score = score + cltB*0.0247;
		// 独立权利要求种类： 产品
		int[] cltAGradeValue = {10,20,30,40,50,60,80,100,100};
		double cltA = getPatentTake(iqPatentAvg.getClt_a(),iqPatentSta.getClt_a(),cltAAvg,cltAGradeValue);
		score = score + cltA*0.0164;
		 // 分类号（小类）数量
		int[] ipcscGradeValue = {10,20,30,40,50,60,80,100,100};
		double ipcsc = getPatentTake(iqPatentAvg.getIpcsc(),iqPatentSta.getIpcsc(),comPatent.getIpcsc(),ipcscGradeValue);
		score = score + ipcsc*0.0329;
		// 剩余有效期
		int[] rmnGradeValue = {10,20,30,40,50,60,80,100,100};
		double rmn = getPatentTake(iqPatentAvg.getRmn(),iqPatentSta.getRmn(),comPatent.getRmn(),rmnGradeValue);
		score = score + rmn*0.0822;
		// 引证次数
		int[] cipcGradeValue = {60,70,80,90,10,80,60,40,40};
		double cipc = getPatentTake(iqPatentAvg.getCipc(),iqPatentSta.getCipc(),comPatent.getCipc(),cipcGradeValue);
		score = score + cipc*0.0493;
		// 专利技术人员投入数量
		int[] incoGradeValue = {10,20,30,40,50,60,80,100,100};
		double inco = getPatentTake(iqPatentAvg.getInco(),iqPatentSta.getInco(),comPatent.getInco(),incoGradeValue);
		score = score + inco*0.0411;
		
		//FM表示发明公开，SQ表示授权，XX表示实用新型，外观专利不在指标评估范围之内
		String patt = comPatent.getPatt();
		double pattAAvg = 0;
		double pattBAvg = 0;
		if("FM".equals(patt) || "SQ".equals(patt)){
			pattAAvg = 1;
		}
		if("XX".equals(patt)){
			pattBAvg = 1;
		}
		// 专利类型--发明
		int[] pattAGradeValue = {10,20,30,40,50,60,80,100,100};
		double pattA = getPatentTake(iqPatentAvg.getPatt_a(),iqPatentSta.getPatt_a(),pattAAvg,pattAGradeValue);
		score = score + pattA*0.0822;
		// 专利类型--实用新型
		int[] pattBGradeValue = {10,20,30,40,50,60,80,100,100};
		double pattB = getPatentTake(iqPatentAvg.getPatt_b(),iqPatentSta.getPatt_b(),pattBAvg,pattBGradeValue);
		score = score + pattB*0.0247;
		// 专利诉讼次数
		int[] plicGradeValue = {10,20,30,40,50,60,80,100,100};
		double plic = getPatentTake(iqPatentAvg.getPlic(),iqPatentSta.getPlic(),comPatent.getPlic(),plicGradeValue);
		score = score +plic*0.0049;
		// 专利许可次数
		int[] pccGradeValue = {10,20,30,40,50,60,80,100,100};
		double pcc = getPatentTake(iqPatentAvg.getPcc(),iqPatentSta.getPcc(),comPatent.getPcc(),pccGradeValue);
		score = score +pcc*0.0822;
		//专利质押次数
		int[] ppcGradeValue = {10,20,30,40,50,60,80,100,100};
		double ppc = getPatentTake(iqPatentAvg.getPpc(),iqPatentSta.getPpc(),comPatent.getPpc(),ppcGradeValue);
		score = score +ppc*0.0329;
		//专利转让次数
		int[] tccGradeValue = {10,20,30,40,50,60,80,100,100};
		double tcc = getPatentTake(iqPatentAvg.getTcc(),iqPatentSta.getTcc(),comPatent.getTcc(),tccGradeValue);
		score = score +tcc*0.0329;
		//说明书页数
		int[] despageGradeValue = {0,50,70,80,100,90,80,60,60};
		double despage = getPatentTake(iqPatentAvg.getDespage(),iqPatentSta.getDespage(),comPatent.getDespage(),despageGradeValue);
		score = score +despage*0.0329;
		//附图页数
		int[] drawpageGradeValue = {0,50,70,80,100,90,80,60,60};
		double drawpage = getPatentTake(iqPatentAvg.getDrawpage(),iqPatentSta.getDrawpage(),comPatent.getDrawpage(),drawpageGradeValue);
		score = score +drawpage*0.0329;
		// 专利族地域种类和数量 -- 地域数量
		int[] sfclGradeValue = {10,20,30,40,50,60,80,100,100};
		double sfcl = getPatentTake(iqPatentAvg.getSfcl(),iqPatentSta.getSfcl(),comPatent.getSfcl(),sfclGradeValue);
		score = score +sfcl*0.0822;
		// 专利族地域种类和数量 -- US、EP、WO
		int[] fausGradeValue = {10,20,30,40,50,60,80,100,100};
		double faus = getPatentTake(iqPatentAvg.getFaus(),iqPatentSta.getFaus(),comPatent.getFaus(),fausGradeValue);
		score = score +faus*0.0822;
		// 专利族地域种类和数量 -- 日韩同族 
		int[] fajpGradeValue = {10,20,30,40,50,60,80,100,100};
		double fajp = getPatentTake(iqPatentAvg.getFajp(),iqPatentSta.getFajp(),comPatent.getFajp(),fajpGradeValue);
		score = score +fajp*0.0493;
		// 专利族地域种类和数量 --其他国家同族 
		int[] faotGradeValue = {10,20,30,40,50,60,80,100,100};
		double faot = getPatentTake(iqPatentAvg.getFaot(),iqPatentSta.getFaot(),comPatent.getFaot(),faotGradeValue);
		score = score +faot*0.0164;
		
		BigDecimal b=new  BigDecimal(score); 
		return b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	
	/**
	 * 被评估单位的得分和取分
	 * 
	 * @param proCode
	 * @param patentAvg
	 * @param iqPatentAvg
	 * @param iqPatentSta
	 */
	private void saveComPatentSumTakeAndScore(String proCode, ComPatentSum patentAvg, IqComPatentSum iqPatentAvg,
			IqComPatentSum iqPatentSta) {
		ComPatentSum comPatentSumAsTake = new ComPatentSum();
		comPatentSumAsTake.setPro_code(proCode);
		comPatentSumAsTake.setType(Const.PatentSumCost.TAKE.getValue());
		ComPatentSum comPatentSumAsScore = new ComPatentSum();
		comPatentSumAsScore.setPro_code(proCode);
		comPatentSumAsScore.setType(Const.PatentSumCost.SCORE.getValue());
		// 2）获取各属性得分、取分
		//独立权利要求数 
		int[] iclnGradeValue = {0,50,70,80,100,90,80,60,0};
		double icln = getPatentTake(iqPatentAvg.getIcln(),iqPatentSta.getIcln(),patentAvg.getIcln(),iclnGradeValue);
		comPatentSumAsTake.setIcln(icln);
		comPatentSumAsScore.setIcln(StatisticsUtil.getScale2Double(icln*0.0493));
	    // 被引证次数
		int[] cigcGradeValue = {10,20,30,40,50,60,80,100,100};
		double cigc = getPatentTake(iqPatentAvg.getCigc(),iqPatentSta.getCigc(),patentAvg.getCigc(),cigcGradeValue);
		comPatentSumAsTake.setCigc(cigc);
		comPatentSumAsScore.setCigc(StatisticsUtil.getScale2Double(cigc*0.0822));
		// 从属权利要求数
		int[] dclnGradeValue = {0,50,70,80,100,90,80,60,0};
		double dcln = getPatentTake(iqPatentAvg.getDcln(),iqPatentSta.getDcln(),patentAvg.getDcln(),dclnGradeValue);
		comPatentSumAsTake.setDcln(dcln);
		comPatentSumAsScore.setDcln(StatisticsUtil.getScale2Double(dcln*0.0822));
		// 独立权利要求种类： 方法和产品
		int[] cltCGradeValue = {10,20,30,40,50,60,80,100,100};
		double cltC = getPatentTake(iqPatentAvg.getClt_c(),iqPatentSta.getClt_c(),patentAvg.getClt_c(),cltCGradeValue);
		comPatentSumAsTake.setClt_c(cltC);
		comPatentSumAsScore.setClt_c(StatisticsUtil.getScale2Double(cltC*0.0329));
		// 独立权利要求种类： 方法
		int[] cltBGradeValue = {10,20,30,40,50,60,80,100,100};
		double cltB = getPatentTake(iqPatentAvg.getClt_b(),iqPatentSta.getClt_b(),patentAvg.getClt_b(),cltBGradeValue);
		comPatentSumAsTake.setClt_b(cltB);
		comPatentSumAsScore.setClt_b(StatisticsUtil.getScale2Double(cltB*0.0247));
		// 独立权利要求种类： 产品
		int[] cltAGradeValue = {10,20,30,40,50,60,80,100,100};
		double cltA = getPatentTake(iqPatentAvg.getClt_a(),iqPatentSta.getClt_a(),patentAvg.getClt_a(),cltAGradeValue);
		comPatentSumAsTake.setClt_a(cltA);
		comPatentSumAsScore.setClt_a(StatisticsUtil.getScale2Double(cltA*0.0164));		
		 // 分类号（小类）数量
		int[] ipcscGradeValue = {10,20,30,40,50,60,80,100,100};
		double ipcsc = getPatentTake(iqPatentAvg.getIpcsc(),iqPatentSta.getIpcsc(),patentAvg.getIpcsc(),ipcscGradeValue);
		comPatentSumAsTake.setIpcsc(ipcsc);
		comPatentSumAsScore.setIpcsc(StatisticsUtil.getScale2Double(ipcsc*0.0329));
		// 剩余有效期
		int[] rmnGradeValue = {10,20,30,40,50,60,80,100,100};
		double rmn = getPatentTake(iqPatentAvg.getRmn(),iqPatentSta.getRmn(),patentAvg.getRmn(),rmnGradeValue);
		comPatentSumAsTake.setRmn(rmn);
		comPatentSumAsScore.setRmn(StatisticsUtil.getScale2Double(rmn*0.0822));
		// 引证次数
		int[] cipcGradeValue = {60,70,80,90,10,80,60,40,40};
		double cipc = getPatentTake(iqPatentAvg.getCipc(),iqPatentSta.getCipc(),patentAvg.getCipc(),cipcGradeValue);
		comPatentSumAsTake.setCipc(cipc);
		comPatentSumAsScore.setCipc(StatisticsUtil.getScale2Double(cipc*0.0493));
		// 专利技术人员投入数量
		int[] incoGradeValue = {10,20,30,40,50,60,80,100,100};
		double inco = getPatentTake(iqPatentAvg.getInco(),iqPatentSta.getInco(),patentAvg.getInco(),incoGradeValue);
		comPatentSumAsTake.setInco(inco);
		comPatentSumAsScore.setInco(StatisticsUtil.getScale2Double(inco*0.0411));
		// 专利类型--发明
		int[] pattAGradeValue = {10,20,30,40,50,60,80,100,100};
		double pattA = getPatentTake(iqPatentAvg.getPatt_a(),iqPatentSta.getPatt_a(),patentAvg.getPatt_a(),pattAGradeValue);
		comPatentSumAsTake.setPatt_a(pattA);
		comPatentSumAsScore.setPatt_a(StatisticsUtil.getScale2Double(pattA*0.0822));
		// 专利类型--实用新型
		int[] pattBGradeValue = {10,20,30,40,50,60,80,100,100};
		double pattB = getPatentTake(iqPatentAvg.getPatt_b(),iqPatentSta.getPatt_a(),patentAvg.getPatt_b(),pattBGradeValue);
		comPatentSumAsTake.setPatt_b(pattB);
		comPatentSumAsScore.setPatt_b(StatisticsUtil.getScale2Double(pattB*0.0247));		
		// 专利诉讼次数
		int[] plicGradeValue = {10,20,30,40,50,60,80,100,100};
		double plic = getPatentTake(iqPatentAvg.getPlic(),iqPatentSta.getPlic(),patentAvg.getPlic(),plicGradeValue);
		comPatentSumAsTake.setPlic(plic);
		comPatentSumAsScore.setPlic(StatisticsUtil.getScale2Double(plic*0.0049));
		// 专利许可次数
		int[] pccGradeValue = {10,20,30,40,50,60,80,100,100};
		double pcc = getPatentTake(iqPatentAvg.getPcc(),iqPatentSta.getPcc(),patentAvg.getPcc(),pccGradeValue);
		comPatentSumAsTake.setPcc(pcc);
		comPatentSumAsScore.setPcc(StatisticsUtil.getScale2Double(pcc*0.0822));	
		//专利质押次数
		int[] ppcGradeValue = {10,20,30,40,50,60,80,100,100};
		double ppc = getPatentTake(iqPatentAvg.getPpc(),iqPatentSta.getPpc(),patentAvg.getPpc(),ppcGradeValue);
		comPatentSumAsTake.setPpc(ppc);
		comPatentSumAsScore.setPpc(StatisticsUtil.getScale2Double(ppc*0.0329));	
		//专利转让次数
		int[] tccGradeValue = {10,20,30,40,50,60,80,100,100};
		double tcc = getPatentTake(iqPatentAvg.getTcc(),iqPatentSta.getTcc(),patentAvg.getTcc(),tccGradeValue);
		comPatentSumAsTake.setTcc(tcc);
		comPatentSumAsScore.setTcc(StatisticsUtil.getScale2Double(tcc*0.0329));	
		//说明书页数
		int[] despageGradeValue = {0,50,70,80,100,90,80,60,60};
		double despage = getPatentTake(iqPatentAvg.getDespage(),iqPatentSta.getDespage(),patentAvg.getDespage(),despageGradeValue);
		comPatentSumAsTake.setDespage(despage);
		comPatentSumAsScore.setDespage(StatisticsUtil.getScale2Double(despage*0.0329));	
		//附图页数
		int[] drawpageGradeValue = {0,50,70,80,100,90,80,60,60};
		double drawpage = getPatentTake(iqPatentAvg.getDrawpage(),iqPatentSta.getDrawpage(),patentAvg.getDrawpage(),drawpageGradeValue);
		comPatentSumAsTake.setDrawpage(drawpage);
		comPatentSumAsScore.setDrawpage(StatisticsUtil.getScale2Double(drawpage*0.0329));			
		// 专利族地域种类和数量 -- 地域数量
		int[] sfclGradeValue = {10,20,30,40,50,60,80,100,100};
		double sfcl = getPatentTake(iqPatentAvg.getSfcl(),iqPatentSta.getSfcl(),patentAvg.getSfcl(),sfclGradeValue);
		comPatentSumAsTake.setSfcl(sfcl);
		comPatentSumAsScore.setSfcl(StatisticsUtil.getScale2Double(sfcl*0.0822));
		// 专利族地域种类和数量 -- US、EP、WO
		int[] fausGradeValue = {10,20,30,40,50,60,80,100,100};
		double faus = getPatentTake(iqPatentAvg.getFaus(),iqPatentSta.getFaus(),patentAvg.getFaus(),fausGradeValue);
		comPatentSumAsTake.setFaus(faus);
		comPatentSumAsScore.setFaus(StatisticsUtil.getScale2Double(faus*0.0822));
		// 专利族地域种类和数量 -- 日韩同族 
		int[] fajpGradeValue = {10,20,30,40,50,60,80,100,100};
		double fajp = getPatentTake(iqPatentAvg.getFajp(),iqPatentSta.getFajp(),patentAvg.getFajp(),fajpGradeValue);
		comPatentSumAsTake.setFajp(fajp);
		comPatentSumAsScore.setFajp(StatisticsUtil.getScale2Double(fajp*0.0493));		
		// 专利族地域种类和数量 --其他国家同族 
		int[] faotGradeValue = {10,20,30,40,50,60,80,100,100};
		double faot = getPatentTake(iqPatentAvg.getFaot(),iqPatentSta.getFaot(),patentAvg.getFaot(),faotGradeValue);
		comPatentSumAsTake.setFaot(faot);
		comPatentSumAsScore.setFaot(StatisticsUtil.getScale2Double(faot*0.0164));
		
		comPatentSumMapper.insertSelective(comPatentSumAsTake);
		comPatentSumMapper.insertSelective(comPatentSumAsScore);
	}
	
	
	/**
	 * 得分--内插法
	 * 
	 * @param iqPatentAvg 行业平均值
	 * @param iqPatentSta 行业标准差
	 * @param patentAvg 被评估公司平均数或者被评估公司各个专利分数
	 * @param gradeValue 等级评分
	 * @return
	 */
	public static double  getPatentTake(double iqPatentAvg,double iqPatentSta,double patentAvg,int[] gradeValue){
		double eqAvgSub1 = iqPatentAvg - iqPatentSta;
		double eqAvgSub2 = iqPatentAvg - 2 *iqPatentSta;
		double eqAvgSub3 = iqPatentAvg - 3 * iqPatentSta;
		double eqAvgAdd1 = iqPatentAvg + iqPatentSta;
		double eqAvgAdd2 = iqPatentAvg + 2 * iqPatentSta;
		double eqAvgAdd3 = iqPatentAvg + 3 * iqPatentSta;
		if(patentAvg < eqAvgSub3){
			return (double)gradeValue[0];
		}
		if(patentAvg > eqAvgAdd3){
			return (double)gradeValue[8];
		}
		if(patentAvg == eqAvgSub3){
			return (double)gradeValue[1];
		}
		if(patentAvg == eqAvgSub2){
			return (double)gradeValue[2];
		}
		if(patentAvg == eqAvgSub1){
			return (double)gradeValue[3];
		}
		if(patentAvg == iqPatentAvg){
			return (double)gradeValue[4];
		}
		if(patentAvg == eqAvgAdd1){
			return (double)gradeValue[5];
		}
		if(patentAvg == eqAvgAdd2){
			return (double)gradeValue[6];
		}
		if(patentAvg == eqAvgAdd3){
			return (double)gradeValue[7];
		}
		double value =  0 ;
		if(patentAvg < iqPatentAvg && patentAvg > eqAvgSub1){
			value = gradeValue[3] + (gradeValue[4] - gradeValue[3])/(iqPatentAvg-eqAvgSub1)*(patentAvg - eqAvgSub1);
		}
		if(patentAvg < eqAvgSub1 && patentAvg > eqAvgSub2){
			value = gradeValue[2] + (gradeValue[3] - gradeValue[2])/(eqAvgSub1-eqAvgSub2)*(patentAvg - eqAvgSub2);
		}
		if(patentAvg < eqAvgSub2 && patentAvg > eqAvgSub3){
			value = gradeValue[1] + (gradeValue[2] - gradeValue[1])/(eqAvgSub2-eqAvgSub3)*(patentAvg - eqAvgSub3);
		}
		if(patentAvg > iqPatentAvg && patentAvg < eqAvgAdd1){
			value = gradeValue[4] + (gradeValue[5] - gradeValue[4])/(eqAvgAdd1-iqPatentAvg)*(patentAvg - iqPatentAvg);
		}
		if(patentAvg > eqAvgAdd1 && patentAvg < eqAvgAdd2){
			value = gradeValue[5] + (gradeValue[6] - gradeValue[5])/(eqAvgAdd2-eqAvgAdd1)*(patentAvg - eqAvgAdd1);
		}
		if(patentAvg > eqAvgAdd2 && patentAvg < eqAvgAdd3){
			value = gradeValue[6] + (gradeValue[7] - gradeValue[6])/(eqAvgAdd3-eqAvgAdd2)*(patentAvg - eqAvgAdd2);
		}
		return StatisticsUtil.getScale2Double(value);
		
	} 

	/**
	 * 保存被评估单位专利信息
	 * 
	 * @param proCode
	 * @param patentIndexInfo
	 */
	private void saveComPatent(String proCode, PatentIndexInfo patentIndexInfo) {
		ComPatent comPatent = new ComPatent();
		comPatent.setPro_code(proCode);
		comPatent.setAd(patentIndexInfo.getAd());
		comPatent.setAn(patentIndexInfo.getAn());
		comPatent.setPn(patentIndexInfo.getPn());
		comPatent.setTi(patentIndexInfo.getTi());
		comPatent.setSic(patentIndexInfo.getSic());
		comPatent.setIcln((double)patentIndexInfo.getIcln());
		comPatent.setCigc((double)patentIndexInfo.getCigc());
		comPatent.setDcln((double)patentIndexInfo.getDcln());
		comPatent.setIpcsc((double)patentIndexInfo.getIpcsc());
		comPatent.setRmn((double)patentIndexInfo.getRmn());
		comPatent.setCipc((double)patentIndexInfo.getCipc());
		comPatent.setInco((double)patentIndexInfo.getInco());
		comPatent.setPlic((double)patentIndexInfo.getPlic());
		comPatent.setPcc((double)patentIndexInfo.getPcc());
		comPatent.setPpc((double)patentIndexInfo.getPpc());
		comPatent.setTcc((double)patentIndexInfo.getTcc());
		comPatent.setDespage((double)patentIndexInfo.getDesPage());
		comPatent.setDrawpage((double)patentIndexInfo.getDrawPage());
		comPatent.setSfcl((double)patentIndexInfo.getSfcl());
		comPatent.setFajp((double)patentIndexInfo.getFajp());
		comPatent.setFaus((double)patentIndexInfo.getFaus());
		comPatent.setFaot((double)patentIndexInfo.getFaot());
		comPatent.setClt(patentIndexInfo.getClt());
		comPatent.setPatt(patentIndexInfo.getPatt());
		
		comPatentMapper.insertSelective(comPatent);
	}
	
	
	/**
	 * 可评比公司专利属性平均数
	 * 
	 * @param patentArrInfo
	 * @param proCode
	 */
	private ComPatentSum patentAvgStatistic(String proCode, double[] icln, double[] cigc, double[] dcln, double[] ipcsc,
			double[] rmn, double[] cipc, double[] inco, double[] plic, double[] pcc, double[] ppc, double[] tcc,
			double[] desPage, double[] drawPage, double[] sfcl, double[] fajp, double[] faus, double[] faot,
			double patt_a,double patt_b,double clt_a,double clt_b,double clt_c) {
		ComPatentSum model = new ComPatentSum();
		model.setPro_code(proCode);
		model.setType(Const.PatentSumCost.AVG.getValue());
		
		model.setIcln(StatisticsUtil.getAverageAsDouble(icln));
		model.setCigc(StatisticsUtil.getAverageAsDouble(cigc));
		model.setDcln(StatisticsUtil.getAverageAsDouble(dcln));
		model.setIpcsc(StatisticsUtil.getAverageAsDouble(ipcsc));
		model.setRmn(StatisticsUtil.getAverageAsDouble(rmn));
		model.setCipc(StatisticsUtil.getAverageAsDouble(cipc));
		model.setInco(StatisticsUtil.getAverageAsDouble(inco));
		model.setPlic(StatisticsUtil.getAverageAsDouble(plic));
		model.setPcc(StatisticsUtil.getAverageAsDouble(pcc));
		model.setPpc(StatisticsUtil.getAverageAsDouble(ppc));
		model.setTcc(StatisticsUtil.getAverageAsDouble(tcc));
		model.setDespage(StatisticsUtil.getAverageAsDouble(desPage));
		model.setDrawpage(StatisticsUtil.getAverageAsDouble(drawPage));
		model.setSfcl(StatisticsUtil.getAverageAsDouble(sfcl));
		model.setFajp(StatisticsUtil.getAverageAsDouble(fajp));
		model.setFaus(StatisticsUtil.getAverageAsDouble(faus));
		model.setFaot(StatisticsUtil.getAverageAsDouble(faot));
		model.setClt_a(clt_a);
		model.setClt_b(clt_b);
		model.setClt_c(clt_c);
		model.setPatt_a(patt_a);
		model.setPatt_b(patt_b);
		
		comPatentSumMapper.insertSelective(model);
		return model;
	}
	
	
	/**
	 * 行业标准差统计
	 * 
	 * @param proCode
	 * @param icln
	 * @param cigc
	 * @param dcln
	 * @param ipcsc
	 * @param rmn
	 * @param cipc
	 * @param inco
	 * @param plic
	 * @param pcc
	 * @param ppc
	 * @param tcc
	 * @param desPage
	 * @param drawPage
	 * @param sfcl
	 * @param fajp
	 * @param faus
	 * @param faot
	 */
	private void iqPatentStaStatistic(String proCode, double[] icln, double[] cigc, double[] dcln, double[] ipcsc,
			double[] rmn, double[] cipc, double[] inco, double[] plic, double[] pcc, double[] ppc, double[] tcc,
			double[] desPage, double[] drawPage, double[] sfcl, double[] fajp, double[] faus, double[] faot,double[] patt_a,double[] patt_b
			,double[] clt_a,double[] clt_b,double[] clt_c) {
		IqComPatentSum model = new IqComPatentSum();
		model.setPro_code(proCode);
		model.setType(Const.PatentSumCost.STA.getValue());
		model.setIcln(StatisticsUtil.getStandardDevitionAsDouble(icln));
		model.setCigc(StatisticsUtil.getStandardDevitionAsDouble(cigc));
		model.setDcln(StatisticsUtil.getStandardDevitionAsDouble(dcln));
		model.setIpcsc(StatisticsUtil.getStandardDevitionAsDouble(ipcsc));
		model.setRmn(StatisticsUtil.getStandardDevitionAsDouble(rmn));
		model.setCipc(StatisticsUtil.getStandardDevitionAsDouble(cipc));
		model.setInco(StatisticsUtil.getStandardDevitionAsDouble(inco));
		model.setPlic(StatisticsUtil.getStandardDevitionAsDouble(plic));
		model.setPcc(StatisticsUtil.getStandardDevitionAsDouble(pcc));
		model.setPpc(StatisticsUtil.getStandardDevitionAsDouble(ppc));
		model.setTcc(StatisticsUtil.getStandardDevitionAsDouble(tcc));
		model.setDespage(StatisticsUtil.getStandardDevitionAsDouble(desPage));
		model.setDrawpage(StatisticsUtil.getStandardDevitionAsDouble(drawPage));
		model.setSfcl(StatisticsUtil.getStandardDevitionAsDouble(sfcl));
		model.setFajp(StatisticsUtil.getStandardDevitionAsDouble(fajp));
		model.setFaus(StatisticsUtil.getStandardDevitionAsDouble(faus));
		model.setFaot(StatisticsUtil.getStandardDevitionAsDouble(faot));
		model.setPatt_a(StatisticsUtil.getStandardDevitionAsDouble(patt_a));
		model.setPatt_b(StatisticsUtil.getStandardDevitionAsDouble(patt_b));
		model.setClt_a(StatisticsUtil.getStandardDevitionAsDouble(clt_a));
		model.setClt_b(StatisticsUtil.getStandardDevitionAsDouble(clt_b));
		model.setClt_c(StatisticsUtil.getStandardDevitionAsDouble(clt_c));
		iqComPatentSumMapper.insertSelective(model);
	}
	
	/**
	 * 行业方差统计
	 * 
	 * @param proCode
	 * @param icln
	 * @param cigc
	 * @param dcln
	 * @param ipcsc
	 * @param rmn
	 * @param cipc
	 * @param inco
	 * @param plic
	 * @param pcc
	 * @param ppc
	 * @param tcc
	 * @param desPage
	 * @param drawPage
	 * @param sfcl
	 * @param fajp
	 * @param faus
	 * @param faot
	 */
	private void iqPatentVarStatistic(String proCode, double[] icln, double[] cigc, double[] dcln, double[] ipcsc,
			double[] rmn, double[] cipc, double[] inco, double[] plic, double[] pcc, double[] ppc, double[] tcc,
			double[] desPage, double[] drawPage, double[] sfcl, double[] fajp, double[] faus, double[] faot,double[] patt_a,double[] patt_b
			,double[] clt_a,double[] clt_b,double[] clt_c) {
		IqComPatentSum model = new IqComPatentSum();
		model.setPro_code(proCode);
		model.setType(Const.PatentSumCost.VAR.getValue());
		model.setIcln(StatisticsUtil.getVarianceAsDouble(icln));
		model.setCigc(StatisticsUtil.getVarianceAsDouble(cigc));
		model.setDcln(StatisticsUtil.getVarianceAsDouble(dcln));
		model.setIpcsc(StatisticsUtil.getVarianceAsDouble(ipcsc));
		model.setRmn(StatisticsUtil.getVarianceAsDouble(rmn));
		model.setCipc(StatisticsUtil.getVarianceAsDouble(cipc));
		model.setInco(StatisticsUtil.getVarianceAsDouble(inco));
		model.setPlic(StatisticsUtil.getVarianceAsDouble(plic));
		model.setPcc(StatisticsUtil.getVarianceAsDouble(pcc));
		model.setPpc(StatisticsUtil.getVarianceAsDouble(ppc));
		model.setTcc(StatisticsUtil.getVarianceAsDouble(tcc));
		model.setDespage(StatisticsUtil.getVarianceAsDouble(desPage));
		model.setDrawpage(StatisticsUtil.getVarianceAsDouble(drawPage));
		model.setSfcl(StatisticsUtil.getVarianceAsDouble(sfcl));
		model.setFajp(StatisticsUtil.getVarianceAsDouble(fajp));
		model.setFaus(StatisticsUtil.getVarianceAsDouble(faus));
		model.setFaot(StatisticsUtil.getVarianceAsDouble(faot));
		model.setPatt_a(StatisticsUtil.getVarianceAsDouble(patt_a));
		model.setPatt_b(StatisticsUtil.getVarianceAsDouble(patt_b));
		model.setClt_a(StatisticsUtil.getVarianceAsDouble(clt_a));
		model.setClt_b(StatisticsUtil.getVarianceAsDouble(clt_b));
		model.setClt_c(StatisticsUtil.getVarianceAsDouble(clt_c));
		iqComPatentSumMapper.insertSelective(model);
	}
	
	/**
	 * 行业专利合计统计
	 * 
	 * @param proCode
	 * @param icln
	 * @param cigc
	 * @param dcln
	 * @param ipcsc
	 * @param rmn
	 * @param cipc
	 * @param inco
	 * @param plic
	 * @param pcc
	 * @param ppc
	 * @param tcc
	 * @param desPage
	 * @param drawPage
	 * @param sfcl
	 * @param fajp
	 * @param faus
	 * @param faot
	 */
	private void iqPatentSumStatistic(String proCode, double[] icln, double[] cigc, double[] dcln, double[] ipcsc,
			double[] rmn, double[] cipc, double[] inco, double[] plic, double[] pcc, double[] ppc, double[] tcc,
			double[] desPage, double[] drawPage, double[] sfcl, double[] fajp, double[] faus, double[] faot,
			double[] patt_a,double[] patt_b,double[] clt_a,double[] clt_b,double[] clt_c) {
		IqComPatentSum model = new IqComPatentSum();
		model.setPro_code(proCode);
		model.setType(Const.PatentSumCost.SUM.getValue());
		model.setIcln(StatisticsUtil.getSumAsDouble(icln));
		model.setCigc(StatisticsUtil.getSumAsDouble(cigc));
		model.setDcln(StatisticsUtil.getSumAsDouble(dcln));
		model.setIpcsc(StatisticsUtil.getSumAsDouble(ipcsc));
		model.setRmn(StatisticsUtil.getSumAsDouble(rmn));
		model.setCipc(StatisticsUtil.getSumAsDouble(cipc));
		model.setInco(StatisticsUtil.getSumAsDouble(inco));
		model.setPlic(StatisticsUtil.getSumAsDouble(plic));
		model.setPcc(StatisticsUtil.getSumAsDouble(pcc));
		model.setPpc(StatisticsUtil.getSumAsDouble(ppc));
		model.setTcc(StatisticsUtil.getSumAsDouble(tcc));
		model.setDespage(StatisticsUtil.getSumAsDouble(desPage));
		model.setDrawpage(StatisticsUtil.getSumAsDouble(drawPage));
		model.setSfcl(StatisticsUtil.getSumAsDouble(sfcl));
		model.setFajp(StatisticsUtil.getSumAsDouble(fajp));
		model.setFaus(StatisticsUtil.getSumAsDouble(faus));
		model.setFaot(StatisticsUtil.getSumAsDouble(faot));
		model.setPatt_a(StatisticsUtil.getSumAsDouble(patt_a));
		model.setPatt_b(StatisticsUtil.getSumAsDouble(patt_b));
		model.setClt_a(StatisticsUtil.getSumAsDouble(clt_a));
		model.setClt_b(StatisticsUtil.getSumAsDouble(clt_b));
		model.setClt_c(StatisticsUtil.getSumAsDouble(clt_c));
		iqComPatentSumMapper.insertSelective(model);
	}

	
	/**
	 * 行业平均数统计
	 * 
	 * @param proCode
	 * @param icln
	 * @param cigc
	 * @param dcln
	 * @param ipcsc
	 * @param rmn
	 * @param cipc
	 * @param inco
	 * @param plic
	 * @param pcc
	 * @param ppc
	 * @param tcc
	 * @param desPage
	 * @param drawPage
	 * @param sfcl
	 * @param fajp
	 * @param faus
	 * @param faot
	 */
	private void iqPatentAvgStatistic(String proCode, double[] icln, double[] cigc, double[] dcln, double[] ipcsc,
			double[] rmn, double[] cipc, double[] inco, double[] plic, double[] pcc, double[] ppc, double[] tcc,
			double[] desPage, double[] drawPage, double[] sfcl, double[] fajp, double[] faus, double[] faot,double[] patt_a,double[] patt_b
			,double[] clt_a,double[] clt_b,double[] clt_c) {
		IqComPatentSum model = new IqComPatentSum();
		model.setPro_code(proCode);
		model.setType(Const.PatentSumCost.AVG.getValue());
		model.setIcln(StatisticsUtil.getAverageAsDouble(icln));
		model.setCigc(StatisticsUtil.getAverageAsDouble(cigc));
		model.setDcln(StatisticsUtil.getAverageAsDouble(dcln));
		model.setIpcsc(StatisticsUtil.getAverageAsDouble(ipcsc));
		model.setRmn(StatisticsUtil.getAverageAsDouble(rmn));
		model.setCipc(StatisticsUtil.getAverageAsDouble(cipc));
		model.setInco(StatisticsUtil.getAverageAsDouble(inco));
		model.setPlic(StatisticsUtil.getAverageAsDouble(plic));
		model.setPcc(StatisticsUtil.getAverageAsDouble(pcc));
		model.setPpc(StatisticsUtil.getAverageAsDouble(ppc));
		model.setTcc(StatisticsUtil.getAverageAsDouble(tcc));
		model.setDespage(StatisticsUtil.getAverageAsDouble(desPage));
		model.setDrawpage(StatisticsUtil.getAverageAsDouble(drawPage));
		model.setSfcl(StatisticsUtil.getAverageAsDouble(sfcl));
		model.setFajp(StatisticsUtil.getAverageAsDouble(fajp));
		model.setFaus(StatisticsUtil.getAverageAsDouble(faus));
		model.setFaot(StatisticsUtil.getAverageAsDouble(faot));
		model.setPatt_a(StatisticsUtil.getAverageAsDouble(patt_a));
		model.setPatt_b(StatisticsUtil.getAverageAsDouble(patt_b));
		model.setClt_a(StatisticsUtil.getAverageAsDouble(clt_a));
		model.setClt_b(StatisticsUtil.getAverageAsDouble(clt_b));
		model.setClt_c(StatisticsUtil.getAverageAsDouble(clt_c));
		iqComPatentSumMapper.insertSelective(model);
	}
	
	
	/**
	 * 可评比公司专利属性平均数
	 * 
	 * @param patentArrInfo
	 * @param proCode
	 */
	private IqComPatent patentAvgStatistic(PatentArrInfo patentArrInfo, String proCode,IqCom iqCom) {
		IqComPatent model = new IqComPatent();
		model.setProCode(proCode);
		model.setIqComId(iqCom.getId());
		model.setName(iqCom.getName());
		//patentSumModel.setType(Const.PatentSumCost.AVG.getValue());
		model.setIcln(StatisticsUtil.getAverage(patentArrInfo.getIcln()));
		model.setCigc(StatisticsUtil.getAverage(patentArrInfo.getCigc()));
		model.setDcln(StatisticsUtil.getAverage(patentArrInfo.getDcln()));
		model.setIpcsc(StatisticsUtil.getAverage(patentArrInfo.getIpcsc()));
		model.setRmn(StatisticsUtil.getAverage(patentArrInfo.getRmn()));
		model.setCipc(StatisticsUtil.getAverage(patentArrInfo.getCipc()));
		model.setInco(StatisticsUtil.getAverage(patentArrInfo.getInco()));
		model.setPlic(StatisticsUtil.getAverage(patentArrInfo.getPlic()));
		model.setPcc(StatisticsUtil.getAverage(patentArrInfo.getPcc()));
		model.setPpc(StatisticsUtil.getAverage(patentArrInfo.getPpc()));
		model.setTcc(StatisticsUtil.getAverage(patentArrInfo.getTcc()));
		model.setDespage(StatisticsUtil.getAverage(patentArrInfo.getDesPage()));
		model.setDrawpage(StatisticsUtil.getAverage(patentArrInfo.getDrawPage()));
		model.setSfcl(StatisticsUtil.getAverage(patentArrInfo.getSfcl()));
		model.setFajp(StatisticsUtil.getAverage(patentArrInfo.getFajp()));
		model.setFaus(StatisticsUtil.getAverage(patentArrInfo.getFaus()));
		model.setFaot(StatisticsUtil.getAverage(patentArrInfo.getFaot()));
		model.setPattA(Double.valueOf(patentArrInfo.getPatt_a()));
		model.setPattB(Double.valueOf(patentArrInfo.getPatt_b()));
		model.setCltA(Double.valueOf(patentArrInfo.getClt_a()));
		model.setCltB(Double.valueOf(patentArrInfo.getClt_b()));
		model.setCltC(Double.valueOf(patentArrInfo.getClt_c()));
		iqComPatentMapper.insertSelective(model);
		return model;
	}
	
	
	/**
	 * 专利属性标准差
	 * 
	 * @param patentArrInfo
	 * @param proCode
	 */
	private void patentStandardDevitionStatistic(String proCode, double[] icln, double[] cigc, double[] dcln, double[] ipcsc,
			double[] rmn, double[] cipc, double[] inco, double[] plic, double[] pcc, double[] ppc, double[] tcc,
			double[] desPage, double[] drawPage, double[] sfcl, double[] fajp, double[] faus, double[] faot) {
		ComPatentSum patentSumModel = new ComPatentSum();
		patentSumModel.setPro_code(proCode);
		patentSumModel.setType(Const.PatentSumCost.STA.getValue());
		
		patentSumModel.setIcln(StatisticsUtil.getStandardDevitionAsDouble(icln));
		patentSumModel.setCigc(StatisticsUtil.getStandardDevitionAsDouble(cigc));
		patentSumModel.setDcln(StatisticsUtil.getStandardDevitionAsDouble(dcln));
		patentSumModel.setIpcsc(StatisticsUtil.getStandardDevitionAsDouble(ipcsc));
		patentSumModel.setRmn(StatisticsUtil.getStandardDevitionAsDouble(rmn));
		patentSumModel.setCipc(StatisticsUtil.getStandardDevitionAsDouble(cipc));
		patentSumModel.setInco(StatisticsUtil.getStandardDevitionAsDouble(inco));
		patentSumModel.setPlic(StatisticsUtil.getStandardDevitionAsDouble(plic));
		patentSumModel.setPcc(StatisticsUtil.getStandardDevitionAsDouble(pcc));
		patentSumModel.setPpc(StatisticsUtil.getStandardDevitionAsDouble(ppc));
		patentSumModel.setTcc(StatisticsUtil.getStandardDevitionAsDouble(tcc));
		patentSumModel.setDespage(StatisticsUtil.getStandardDevitionAsDouble(desPage));
		patentSumModel.setDrawpage(StatisticsUtil.getStandardDevitionAsDouble(drawPage));
		patentSumModel.setSfcl(StatisticsUtil.getStandardDevitionAsDouble(sfcl));
		patentSumModel.setFajp(StatisticsUtil.getStandardDevitionAsDouble(fajp));
		patentSumModel.setFaus(StatisticsUtil.getStandardDevitionAsDouble(faus));
		patentSumModel.setFaot(StatisticsUtil.getStandardDevitionAsDouble(faot));
		
		comPatentSumMapper.insertSelective(patentSumModel);
	}
	
	/**
	 * 专利属性方差
	 * 
	 * @param patentArrInfo
	 * @param proCode
	 */
	private void patentVarianceStatistic(String proCode, double[] icln, double[] cigc, double[] dcln, double[] ipcsc,
			double[] rmn, double[] cipc, double[] inco, double[] plic, double[] pcc, double[] ppc, double[] tcc,
			double[] desPage, double[] drawPage, double[] sfcl, double[] fajp, double[] faus, double[] faot) {
		ComPatentSum patentSumModel = new ComPatentSum();
		patentSumModel.setPro_code(proCode);
		patentSumModel.setType(Const.PatentSumCost.VAR.getValue());
		patentSumModel.setIcln(StatisticsUtil.getVarianceAsDouble(icln));
		patentSumModel.setCigc(StatisticsUtil.getVarianceAsDouble(cigc));
		patentSumModel.setDcln(StatisticsUtil.getVarianceAsDouble(dcln));
		patentSumModel.setIpcsc(StatisticsUtil.getVarianceAsDouble(ipcsc));
		patentSumModel.setRmn(StatisticsUtil.getVarianceAsDouble(rmn));
		patentSumModel.setCipc(StatisticsUtil.getVarianceAsDouble(cipc));
		patentSumModel.setInco(StatisticsUtil.getVarianceAsDouble(inco));
		patentSumModel.setPlic(StatisticsUtil.getVarianceAsDouble(plic));
		patentSumModel.setPcc(StatisticsUtil.getVarianceAsDouble(pcc));
		patentSumModel.setPpc(StatisticsUtil.getVarianceAsDouble(ppc));
		patentSumModel.setTcc(StatisticsUtil.getVarianceAsDouble(tcc));
		patentSumModel.setDespage(StatisticsUtil.getVarianceAsDouble(desPage));
		patentSumModel.setDrawpage(StatisticsUtil.getVarianceAsDouble(drawPage));
		patentSumModel.setSfcl(StatisticsUtil.getVarianceAsDouble(sfcl));
		patentSumModel.setFajp(StatisticsUtil.getVarianceAsDouble(fajp));
		patentSumModel.setFaus(StatisticsUtil.getVarianceAsDouble(faus));
		patentSumModel.setFaot(StatisticsUtil.getVarianceAsDouble(faot));
		
		comPatentSumMapper.insertSelective(patentSumModel);
	}
	

	

	/**
	 * 被评估公司专利属性合计
	 * 
	 * @param patentArrInfo
	 * @param proCode
	 */
	private void patentSumStatistic(String proCode, double[] icln, double[] cigc, double[] dcln, double[] ipcsc,
			double[] rmn, double[] cipc, double[] inco, double[] plic, double[] pcc, double[] ppc, double[] tcc,
			double[] desPage, double[] drawPage, double[] sfcl, double[] fajp, double[] faus, double[] faot,
			double patt_a,double patt_b,double clt_a,double clt_b,double clt_c) {
		ComPatentSum patentSumModel = new ComPatentSum();
		patentSumModel.setPro_code(proCode);
		patentSumModel.setType(Const.PatentSumCost.SUM.getValue());
		patentSumModel.setIcln(StatisticsUtil.getSumAsDouble(icln));
		patentSumModel.setCigc(StatisticsUtil.getSumAsDouble(cigc));
		patentSumModel.setDcln(StatisticsUtil.getSumAsDouble(dcln));
		patentSumModel.setIpcsc(StatisticsUtil.getSumAsDouble(ipcsc));
		patentSumModel.setRmn(StatisticsUtil.getSumAsDouble(rmn));
		patentSumModel.setCipc(StatisticsUtil.getSumAsDouble(cipc));
		patentSumModel.setInco(StatisticsUtil.getSumAsDouble(inco));
		patentSumModel.setPlic(StatisticsUtil.getSumAsDouble(plic));
		patentSumModel.setPcc(StatisticsUtil.getSumAsDouble(pcc));
		patentSumModel.setPpc(StatisticsUtil.getSumAsDouble(ppc));
		patentSumModel.setTcc(StatisticsUtil.getSumAsDouble(tcc));
		patentSumModel.setDespage(StatisticsUtil.getSumAsDouble(desPage));
		patentSumModel.setDrawpage(StatisticsUtil.getSumAsDouble(drawPage));
		patentSumModel.setSfcl(StatisticsUtil.getSumAsDouble(sfcl));
		patentSumModel.setFajp(StatisticsUtil.getSumAsDouble(fajp));
		patentSumModel.setFaus(StatisticsUtil.getSumAsDouble(faus));
		patentSumModel.setFaot(StatisticsUtil.getSumAsDouble(faot));
		patentSumModel.setClt_a(clt_a);
		patentSumModel.setClt_b(clt_b);
		patentSumModel.setClt_c(clt_c);
		patentSumModel.setPatt_a(patt_a);
		patentSumModel.setPatt_b(patt_b);
		comPatentSumMapper.insertSelective(patentSumModel);
	}
	public static void main(String[] args){
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(IEvalService.class);//注册WebService接口
		factory.setAddress(CoreConst.PATENT_URL);//设置WebService地址
		factory.getOutInterceptors().add(new ClientLoginInterceptor(CoreConst.PARENT_USERNAME,CoreConst.PARENT_PASSWORD));//设置设置用户账号及密码
		String api_key=CoreConst.PATENT_API_KEY;//分配的api_key
		String secret_key = CoreConst.PATENT_SECRET_KEY;
		String signStr = "api_key="+api_key + "date="+ DateUtil.date2Str(new Date(), DateUtil.yearMonthDayFormat) + secret_key;
		//分配的验证字符串
		String sign = MD5Util.md5Sign(signStr);
		
		IEvalService client = (IEvalService)factory.create();//客户端对象
		//设置客户端的配置信息，超时等.
		org.apache.cxf.endpoint.Client proxy = ClientProxy.getClient(client);
		HTTPConduit conduit = (HTTPConduit) proxy.getConduit();
		HTTPClientPolicy policy = new HTTPClientPolicy();
		policy.setConnectionTimeout(30000); //连接超时时间
		policy.setReceiveTimeout(180000);//请求超时时间.
		conduit.setClient(policy);
		ResultData info = client.loadDataFromSearch("北京北方微电子基地设备工艺研究中心有限责任公司,北京飞行博达电子有限公司,北京七星华创集成电路装备有限公司,北京晨晶电子有限公司,北京七一八友益电子有限责任公司,七星电子有限公司,北京七一八友晟电子有限公司,北京七星华创弗朗特电子有限公司,北京七星弗洛尔电子设备制造有限公司,北京七星华创磁电科技有限公司,北京七星宏泰电子设备有限责任公司,北京七星华创微波电子技术有限公司,北京七星昌芯集成电路设计有限公司,北京七星华创电子股份有限公司","", api_key, sign);//调用服务
		logger.info("返回响应码："+info.getCode()+"，响应信息："+info.getMessage());
		if(!"200".equals(info.getCode())){
			throw new BusinessException("专业评估接口请求异常："+info.getMessage());
		}
		List<PatentDataInfo> list = info.getCompanyPatent();
		for (int i = 0; i < list.size(); i++) {
			PatentDataInfo patentDataInfo=list.get(i);
			System.out.println("===================公司名称："+patentDataInfo.getCompany());
			List<PatentIndexInfo> patentIndexInfos=patentDataInfo.getDataList();
			for (PatentIndexInfo patentIndexInfo : patentIndexInfos) {
				System.out.println("被引证次数："+patentIndexInfo.getCigc());
			}
		}
	}
}
