package com.kpap.website.service;

import java.util.Date;
import java.util.List;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.kpap.basis.exception.BusinessException;
import com.kpap.basis.util.MD5Util;
import com.kpap.client.model.PatentDataInfo;
import com.kpap.client.model.PatentIndexInfo;
import com.kpap.client.model.ResultData;
import com.kpap.client.model.SectionInfo;
import com.kpap.client.service.IEvalService;
import com.kpap.client.service.impl.ClientLoginInterceptor;
import com.kpap.common.constant.CoreConst;
import com.kpap.common.util.DateUtil;

/**
 * 
 * 中信专利评估接口<BR>
 *
 * @auther shenhaiwen
 * @date 2016-12-17 下午09:45:30
 */
@Service
public  class ChinaCiticService {
	
	private static final Logger logger = LoggerFactory.getLogger(ChinaCiticService.class);
	
	/***
	 * 调用专利局接口进行专利评分
	 * 
	 * @param pa
	 * @param ipc 若没有，为空
	 */
	public void patentEvaluation(String pa,String ipc){
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(IEvalService.class);//注册WebService接口
		factory.setAddress(CoreConst.PATENT_URL);//设置WebService地址
		factory.getOutInterceptors().add(new ClientLoginInterceptor(CoreConst.PARENT_USERNAME,CoreConst.PARENT_PASSWORD));//设置设置用户账号及密码
		String api_key=CoreConst.PATENT_API_KEY;//分配的api_key
		String secret_key = CoreConst.PATENT_SECRET_KEY;
		String signStr = "api_key="+api_key + "date="+ DateUtil.date2Str(new Date(), DateUtil.yearMonthDayFormat) + secret_key;
		//分配的验证字符串
		String sign = MD5Util.md5Sign(signStr);
		logger.info("签名前请求字符串："+signStr+",加密后字符串:"+sign);
		IEvalService client = (IEvalService)factory.create();//客户端对象
		ResultData info = client.loadDataFromSearch(pa,ipc, api_key, sign);//调用服务
		logger.info("返回响应码："+info.getCode()+"，响应信息："+info.getMessage());
		if(!"200".equals(info.getCode())){
			throw new BusinessException("专业评估接口请求异常："+info.getMessage());
		}
		List<PatentDataInfo> list = info.getCompanyPatent();
		if(list == null || list.size() <= 0){
			throw new BusinessException("没有获取到公司专利信息");
		} 
		for(int i=0;i<list.size();i++){
			PatentDataInfo patentDataInfo = list.get(i);
			String company = patentDataInfo.getCompany(); //公司名称
			List<PatentIndexInfo> dataList = patentDataInfo.getDataList();//返回的专利内容及指标项内容
			List<SectionInfo> sectionList = patentDataInfo.getSectionList();//专利库检索命中专利数量统计
			// TODO
		} 
	}
	
	public static void main(String[] args) {
		ChinaCiticService service = new ChinaCiticService();
		String pa="浙江吉利汽车研究院有限公司,浙江吉利控股集团有限公司";//专利权人,多个公司名称中间使用英文逗号分隔
		String ipc="H02M%";//分类号
		service.patentEvaluation(pa,ipc);
		System.out.println("-----");
	}
	

}
