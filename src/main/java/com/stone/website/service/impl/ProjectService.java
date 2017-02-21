package com.kpap.website.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.cxf.common.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kpap.basis.dao.ComCaseMapper;
import com.kpap.basis.dao.ComDevCostMapper;
import com.kpap.basis.dao.ComInfoMapper;
import com.kpap.basis.dao.ComMapper;
import com.kpap.basis.dao.ComPatentMapper;
import com.kpap.basis.dao.ComPatentSumMapper;
import com.kpap.basis.dao.ComProductMapper;
import com.kpap.basis.dao.IqComMapper;
import com.kpap.basis.dao.IqComPatentMapper;
import com.kpap.basis.dao.IqComPatentSumMapper;
import com.kpap.basis.dao.IqInfoMapper;
import com.kpap.basis.dao.IqRatiosMapper;
import com.kpap.basis.dao.ProDcfMapper;
import com.kpap.basis.dao.ProMapper;
import com.kpap.basis.dao.ProReivewMapper;
import com.kpap.basis.dao.ProValCaseMapper;
import com.kpap.basis.dao.ProValIncomeMapper;
import com.kpap.basis.dao.ProValIncomeProtMapper;
import com.kpap.basis.dao.ProValMapper;
import com.kpap.basis.model.Com;
import com.kpap.basis.model.ComCase;
import com.kpap.basis.model.ComCaseExample;
import com.kpap.basis.model.ComDevCost;
import com.kpap.basis.model.ComDevCostExample;
import com.kpap.basis.model.ComPatent;
import com.kpap.basis.model.ComPatentExample;
import com.kpap.basis.model.ComPatentSumExample;
import com.kpap.basis.model.ComProduct;
import com.kpap.basis.model.ComProductExample;
import com.kpap.basis.model.IqCom;
import com.kpap.basis.model.IqComExample;
import com.kpap.basis.model.IqComPatentSumExample;
import com.kpap.basis.model.IqRatios;
import com.kpap.basis.model.IqRatiosExample;
import com.kpap.basis.model.Pro;
import com.kpap.basis.model.ProDcf;
import com.kpap.basis.model.ProDcfExample;
import com.kpap.basis.model.ProReivew;
import com.kpap.basis.model.ProVal;
import com.kpap.basis.model.ProValCase;
import com.kpap.basis.model.ProValCaseExample;
import com.kpap.basis.model.ProValExample;
import com.kpap.basis.model.ProValIncome;
import com.kpap.basis.model.ProValIncomeExample;
import com.kpap.basis.model.ProValIncomeProt;
import com.kpap.basis.model.ProValIncomeProtExample;
import com.kpap.website.dto.CaseItem;
import com.kpap.website.dto.Cost;
import com.kpap.website.dto.IncomeDiscountRate;
import com.kpap.website.dto.IncomeIncomeProduct;
import com.kpap.website.dto.IncomeIncomeProductC;
import com.kpap.website.dto.IncomeSeries;
import com.kpap.website.dto.IncomeShareRate;
import com.kpap.website.service.IProjectService;

@Service
public class ProjectService implements IProjectService {
	private static final Logger logger = LoggerFactory.getLogger(ProjectExcelService.class);
	
	@Autowired
	public ProMapper proMapper;
	
	@Autowired
	public ProValMapper proValMapper;
	
	@Autowired
	public ProValIncomeMapper proValIncomeMapper;
	
	@Autowired
	public ProValIncomeProtMapper proValIncomeProtMapper;
	
	@Autowired
	public ComMapper comMapper;
	
	@Autowired
	public ComCaseMapper comCaseMapper;
	
	@Autowired
	public ComInfoMapper comInfoMapper;
	
	@Autowired
	public ComDevCostMapper comDevCostMapper;
	
	@Autowired
	public ComPatentMapper comPatentMapper;
	
	@Autowired
	public ComPatentSumMapper comPatentSumMapper;
	
	@Autowired
	public ComProductMapper comProductMapper;
	
	@Autowired
	public IqComMapper iqComMapper;
	
	@Autowired
	public IqInfoMapper iqInfoMapper;
	
	@Autowired
	public IqRatiosMapper iqRatiosMapper;
	
	@Autowired
	public IqComPatentMapper iqComPatentMapper;
	
	@Autowired
	public IqComPatentSumMapper iqComPatentSumMapper;
	
	@Autowired
	public ProReivewMapper proReivewMapper;
	
	@Autowired
	public ProDcfMapper proDcfMapper;
	
	@Autowired
	public ProValCaseMapper proValCaseMapper;
	
	public void updatePro(Pro pro){
		proMapper.updateByPrimaryKeySelective(pro);
	}
	/**
	 * 重传报表，重置数据
	 * @param proCode
	 */
	@Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRED)
	public void resetPro(String proCode){
		logger.info("重置项目数据("+proCode+")");
		
		Pro pro=proMapper.selectByPrimaryKey(proCode);
		pro.setIsPatent(Pro.isPatent_0);
		pro.setProValId(null);
		pro.setActualVal(null);
		pro.setReportUrl(null);
		pro.setDataSourceUrl(null);
		pro.setExcelUrl(null);
		pro.setStatus(Pro.status_0);
		proMapper.updateByPrimaryKey(pro);
		
		ProValExample proValExample=new ProValExample();
		proValExample.createCriteria().andProCodeEqualTo(proCode);
		proValMapper.deleteByExample(proValExample);
		
		ProValIncomeExample proValIncomeExample=new ProValIncomeExample();
		proValIncomeExample.createCriteria().andProCodeEqualTo(proCode);
		proValIncomeMapper.deleteByExample(proValIncomeExample);
		
		ProValIncomeProtExample proValIncomeProtExample=new ProValIncomeProtExample();
		proValIncomeProtExample.createCriteria().andProCodeEqualTo(proCode);
		proValIncomeProtMapper.deleteByExample(proValIncomeProtExample);
		
		if(Pro.type_1.equals(pro.getType())){
			ProDcfExample proDcfExample=new ProDcfExample();
			proDcfExample.createCriteria().andProCodeEqualTo(proCode);
			proDcfMapper.deleteByExample(proDcfExample);
		}
		
		ProValCaseExample proValCaseExample=new ProValCaseExample();
		proValCaseExample.createCriteria().andProCodeEqualTo(proCode);
		proValCaseMapper.deleteByExample(proValCaseExample);
		
		//删除企业报表数据
		comMapper.deleteByPrimaryKey(proCode);
		comInfoMapper.deleteByPrimaryKey(proCode);
		comDevCostMapper.deleteByPrimaryKey(proCode);
		
		ComCaseExample comCaseExample=new ComCaseExample();
		comCaseExample.createCriteria().andProCodeEqualTo(proCode);
		comCaseMapper.deleteByExample(comCaseExample);
		
		ComProductExample comProductExample=new ComProductExample();
		comProductExample.createCriteria().andProCodeEqualTo(proCode);
		comProductMapper.deleteByExample(comProductExample);
		
		ComPatentExample comPatentExample=new ComPatentExample();
		comPatentExample.createCriteria().andPro_codeEqualTo(proCode);
		comPatentMapper.deleteByExample(comPatentExample);
		
		ComPatentSumExample comPatentSumExample=new ComPatentSumExample();
		comPatentSumExample.createCriteria().andPro_codeEqualTo(proCode);
		comPatentSumMapper.deleteByExample(comPatentSumExample);
		
		//删除iq报表数据
		IqComExample iqComExample=new IqComExample();
		iqComExample.createCriteria().andProCodeEqualTo(proCode);
		List<IqCom> iqComs=iqComMapper.selectByExample(iqComExample);
		for (IqCom iqCom : iqComs) {
			iqComPatentMapper.deleteByPrimaryKey(iqCom.getId());
			iqComMapper.deleteByPrimaryKey(iqCom.getId());
		}
		
		iqInfoMapper.deleteByPrimaryKey(proCode);
		iqRatiosMapper.deleteByPrimaryKey(proCode);
		
		IqComPatentSumExample iqComPatentSumExample=new IqComPatentSumExample();
		iqComPatentSumExample.createCriteria().andPro_codeEqualTo(proCode);
		iqComPatentSumMapper.deleteByExample(iqComPatentSumExample);
	}
	
	public Pro getProByProCode(String proCode){
		Pro pro=proMapper.selectByPrimaryKey(proCode);
		return pro;
	}
	public List<ProValIncome> getProValIncomeByProCode(Long proValId){
		ProValIncomeExample example=new ProValIncomeExample();
		example.setOrderByClause(" next_year ");
		example.createCriteria().andProValIdEqualTo(proValId);
		return proValIncomeMapper.selectByExample(example);
	}
	public List<ProValIncomeProt> getProValIncomeProducts(String proCode,Long proValId){
		ProValIncomeProtExample proValIncomeProtExample=new ProValIncomeProtExample();
		proValIncomeProtExample.createCriteria().andProValIdEqualTo(proValId);
		List<ProValIncomeProt>  proValIncomeProts=proValIncomeProtMapper.selectByExample(proValIncomeProtExample);
		
		if(proValIncomeProts==null || proValIncomeProts.isEmpty()){
			ComProductExample comProductExample=new ComProductExample();
			comProductExample.createCriteria().andProCodeEqualTo(proCode);
			List<ComProduct> comProducts=comProductMapper.selectByExample(comProductExample);
			
			for (ComProduct comProduct : comProducts) {
				ProValIncomeProt proValIncomeProt=new ProValIncomeProt();
				proValIncomeProt.setName(comProduct.getName());
				proValIncomeProt.setProductId(comProduct.getId());
				proValIncomeProt.setProCode(proCode);
				proValIncomeProt.setProValId(proValId);
				proValIncomeProt.setIsComplete(false);
				proValIncomeProt.setCreateDate(new Date());
				
				proValIncomeProtMapper.insertSelective(proValIncomeProt);
				proValIncomeProts.add(proValIncomeProt);
			}
		}
		
		return proValIncomeProts;
	}
	/**
	 * 收益法--序列年期保存
	 */
	@Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRED)
	public Long series(IncomeSeries incomeSeries){
		ProVal proVal=new ProVal();
		proVal.setProGroup(ProVal.proGroup_0);
		proVal.setCategory(incomeSeries.getCategory());
		proVal.setIsComplete(false);
		proVal.setProCode(incomeSeries.getProCode());
		proVal.setCreateDate(new Date());
		proVal.setJsonSeriesYear(JSON.toJSONString(incomeSeries));
		proVal.setIncomeStep(ProVal.incomeStep_1);
		
		proValMapper.insertSelective(proVal);
		
		Pro pro=proMapper.selectByPrimaryKey(incomeSeries.getProCode());
		Date baseDate=pro.getBaseDate();
		Calendar baseDate_calendar=Calendar.getInstance();
		baseDate_calendar.setTime(baseDate);
		int month=baseDate_calendar.get(Calendar.MONTH);
		int year=baseDate_calendar.get(Calendar.YEAR);
		
		double currentVal=0.00;
		if(month<11){
			int rangeMonth=12-month-1;
			String rangeMonthDes=year+"("+(month+2)+"-"+"12)";
			BigDecimal rangeVal=BigDecimal.valueOf(rangeMonth/12.00);
			rangeVal=rangeVal.setScale(2,BigDecimal.ROUND_HALF_UP);
			
			currentVal=rangeVal.doubleValue();
			
			ProValIncome proValIncome=new ProValIncome();
			proValIncome.setProCode(incomeSeries.getProCode());
			proValIncome.setProValId(proVal.getId());
			proValIncome.setNextYear(year);
			proValIncome.setNexYearDesc(rangeMonthDes);
			proValIncome.setSeriesYear(rangeVal);
			proValIncome.setCreateDate(new Date());
			proValIncomeMapper.insertSelective(proValIncome);
		}
		 for(int t=1;(t-1)<incomeSeries.getLastYearVal();t++){
			 double nowVal=t+currentVal;
			 if(nowVal>incomeSeries.getLastYearVal()){
				 nowVal=incomeSeries.getLastYearVal();
			 }
			 int nextYear=year+t;
			 String nextYearDes=nextYear+"年";
			 
			 ProValIncome proValIncome=new ProValIncome();
			 proValIncome.setProCode(incomeSeries.getProCode());
			 proValIncome.setProValId(proVal.getId());
			 proValIncome.setNextYear(nextYear);
			 proValIncome.setNexYearDesc(nextYearDes);
			 proValIncome.setSeriesYear(BigDecimal.valueOf(nowVal));
			 proValIncome.setCreateDate(new Date());
			 proValIncomeMapper.insertSelective(proValIncome);
		 }
		 
		 return proVal.getId();
	}
	/**
	 * 收益法--分成率
	 * @param incomeShareRate
	 */
	@Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRED)
	public void shareRate(IncomeShareRate incomeShareRate){
		ProVal proVal=new ProVal();
		proVal.setId(incomeShareRate.getProValId());
		proVal.setJsonShareRate(JSON.toJSONString(incomeShareRate));
		proVal.setIncomeStep(ProVal.incomeStep_3);
		proValMapper.updateByPrimaryKeySelective(proVal);
		
		String scoreResult=incomeShareRate.getScoreResult();
		String[] array=scoreResult.split(";");
		for (String arrayItem: array) {
			String[] itemArray=arrayItem.split("_");
			ProValIncome proValIncome=proValIncomeMapper.selectByPrimaryKey(Long.valueOf(itemArray[0]));
			proValIncome.setShareRate(BigDecimal.valueOf(Double.valueOf(itemArray[1])));
			proValIncome.setShareDeclineRate(BigDecimal.valueOf(Double.valueOf(itemArray[2])));
			BigDecimal shareRateCal=BigDecimal.valueOf(Double.valueOf(itemArray[3]));
			proValIncome.setShareRateCal(shareRateCal);
			BigDecimal income=proValIncome.getIncome();
			BigDecimal incomeCal=income.multiply(shareRateCal);
			incomeCal.setScale(2,BigDecimal.ROUND_HALF_UP);
			proValIncome.setIncomeCal(incomeCal);
			proValIncome.setModifyDate(new Date());
			
			proValIncomeMapper.updateByPrimaryKeySelective(proValIncome);
		}
		
	}
	/**
	 * 收益法--收益额--产品(收入分成法，净利润分成法)
	 * @param incomeIncomeProduct
	 */
	public void incomeProduct(IncomeIncomeProduct incomeIncomeProduct){
		ProValIncomeProt proValIncomeProt=new ProValIncomeProt();
		proValIncomeProt.setId(incomeIncomeProduct.getProValIncomeProtId());
		proValIncomeProt.setIsComplete(true);
		proValIncomeProt.setJson(JSON.toJSONString(incomeIncomeProduct));
		proValIncomeProt.setResultJson(incomeIncomeProduct.getResult());
		proValIncomeProt.setModifyDate(new Date());
		
		proValIncomeProtMapper.updateByPrimaryKeySelective(proValIncomeProt);
	}
	/**
	 * 收益法--收益额--产品(超额收益法)
	 * @param incomeIncomeProduct
	 */
	public void incomeProduct(IncomeIncomeProductC incomeIncomeProductC){
		ProValIncomeProt proValIncomeProt=new ProValIncomeProt();
		proValIncomeProt.setId(incomeIncomeProductC.getProValIncomeProtId());
		proValIncomeProt.setIsComplete(true);
		proValIncomeProt.setJson(JSON.toJSONString(incomeIncomeProductC));
		proValIncomeProt.setResultJson(incomeIncomeProductC.getResult());
		proValIncomeProt.setModifyDate(new Date());
		
		proValIncomeProtMapper.updateByPrimaryKeySelective(proValIncomeProt);
	}
	/**
	 * 收益法--收益额--汇总计算
	 * @param result
	 * @param category
	 */
	public void incomeSum(String proCode,String result,String result_pre,String result_rate,String category,Long proValId){
		JSONObject jo = JSON.parseObject(result);
		Set<String> keys=jo.keySet();
		JSONObject jo_pre = JSON.parseObject(result_pre);
		JSONObject jo_rate = JSON.parseObject(result_rate);
		//获取tax_rate
		Com com=comMapper.selectByPrimaryKey(proCode);
		for (String key : keys) {
			ProValIncome proValIncome=new ProValIncome();
			proValIncome.setId(Long.valueOf(key));
			if(ProVal.category_2.equals(category)){
				proValIncome.setIncome(jo_pre.getBigDecimal(key));
				proValIncome.setIncomeCal(jo.getBigDecimal(key));
				proValIncome.setTaxRate(com.getTaxRate());
				proValIncome.setTax(jo_rate.getBigDecimal(key));
			}else{
				proValIncome.setIncome(jo.getBigDecimal(key));
			}
			proValIncome.setModifyDate(new Date());
			proValIncomeMapper.updateByPrimaryKeySelective(proValIncome);
		}
		if(ProVal.syf.contains(category)){
			ProVal proVal=new ProVal();
			proVal.setId(proValId);
			proVal.setIncomeStep(ProVal.incomeStep_2);
			proValMapper.updateByPrimaryKeySelective(proVal);
		}
	}
	public Com getComByProCode(String proCode){
		return comMapper.selectByPrimaryKey(proCode);
	}
	/**
	 * 收益法--折现率计算
	 * @param incomeDiscountRate
	 * @return
	 */
	public BigDecimal discount_rate(IncomeDiscountRate incomeDiscountRate){
		BigDecimal sumResult=new BigDecimal(0);
		BigDecimal discountRate=incomeDiscountRate.getResult();
		ProValIncomeExample example=new ProValIncomeExample();
		example.createCriteria().andProValIdEqualTo(incomeDiscountRate.getProValId());
		List<ProValIncome> proValIncomes=proValIncomeMapper.selectByExample(example);
		for (ProValIncome proValIncome : proValIncomes){
			proValIncome.setDiscountRate(discountRate);
			double double_discountFactor=(1/Math.pow(discountRate.add(BigDecimal.valueOf(1)).doubleValue(),proValIncome.getSeriesYear().doubleValue()));
			BigDecimal discountFactor=new BigDecimal(double_discountFactor); 
			discountFactor.setScale(2,BigDecimal.ROUND_HALF_UP);
			proValIncome.setDiscountFactor(discountFactor);
			BigDecimal incomeCal=proValIncome.getIncomeCal();
			BigDecimal val=incomeCal.multiply(discountFactor).setScale(2,BigDecimal.ROUND_HALF_UP);
			proValIncome.setValue(val);
			proValIncome.setModifyDate(new Date());
			proValIncomeMapper.updateByPrimaryKeySelective(proValIncome);
			sumResult=sumResult.add(val);
		}
		ProVal proVal=new ProVal();
		proVal.setId(incomeDiscountRate.getProValId());
		proVal.setValue(sumResult);
		proVal.setIsComplete(true);
		proVal.setJsonDiscountRate(JSON.toJSONString(incomeDiscountRate));
		proVal.setIncomeStep(ProVal.incomeStep_4);
		proValMapper.updateByPrimaryKeySelective(proVal);
		return sumResult;
	}
	
	@Override
	public ComDevCost getComDevCostByproCode(String proCode) {
		ComDevCostExample example = new ComDevCostExample();
		example.createCriteria().andProCodeEqualTo(proCode);
		List<ComDevCost> list = comDevCostMapper.selectByExample(example);
		if(list == null || list.size() <= 0){
			return null;
		}
		return list.get(0);
	}
	@Override
	public Long costMethod(Cost cost) {
		ProVal proVal=new ProVal();
		proVal.setProGroup(ProVal.proGroup_1);
		proVal.setCategory(cost.getCategory());
		proVal.setIsComplete(true);
		proVal.setProCode(cost.getProCode());
		proVal.setCreateDate(new Date());
		proVal.setValue(new BigDecimal(cost.getResult()));
		proVal.setJsonCost(JSON.toJSONString(cost));
		long proValId = proValMapper.insertSelective(proVal);
		return proValId;
	}
	@Override
	public IqRatios getIqRatiosByproCode(String proCode) {
		IqRatiosExample example = new IqRatiosExample();
		example.createCriteria().andProCodeEqualTo(proCode);
		List<IqRatios> list = iqRatiosMapper.selectByExample(example);
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		return list.get(0);
	}
	/**
	 * 审核项目
	 */
	public void auditPro(String proCode,boolean result,String conclusion,String auditor,String creator){
		Pro pro=new Pro();
		pro.setProCode(proCode);
		if(result){
			pro.setStatus(Pro.status_4);
		}else{
			pro.setStatus(Pro.status_5);
		}
		proMapper.updateByPrimaryKeySelective(pro);
		
		ProReivew proReivew=new ProReivew();
		proReivew.setProCode(proCode);
		proReivew.setDealType(ProReivew.dealType_1);
		proReivew.setResult(result);
		proReivew.setConclusion(conclusion);
		proReivew.setCreator(creator);
		proReivew.setAuditor(auditor);
		proReivew.setCreateDate(new Date());
		
		proReivewMapper.insertSelective(proReivew);
	}
	/**
	 * 提交实际估值
	 */
	public String submitResult(Long proValId,String proCode,BigDecimal value,String actuVal){
		Pro pro=proMapper.selectByPrimaryKey(proCode);
		pro.setProCode(proCode);
		pro.setCalVal(value);
		pro.setActualVal(actuVal);
		pro.setProValId(proValId);
		
		proMapper.updateByPrimaryKeySelective(pro);
		return pro.getType();
	}
	
	public void submitAudit(String proCode,String auditor,String savePath){
        Pro pro=proMapper.selectByPrimaryKey(proCode);
        pro.setProCode(proCode);
        pro.setReportUrl(savePath);
        pro.setAuditor(auditor);
        pro.setStatus(Pro.status_3);
        proMapper.updateByPrimaryKeySelective(pro);
        
		ProReivew proReivew=new ProReivew();
		proReivew.setProCode(proCode);
		proReivew.setDealType(ProReivew.dealType_0);
		proReivew.setCreator(pro.getCreator());
		proReivew.setCreateDate(new Date());
		proReivew.setAuditor(auditor);
		proReivew.setConclusion("实际估值："+pro.getActualVal());
		
		proReivewMapper.insertSelective(proReivew);
	}
	
	
	public List<ComPatent> getComPatents(String proCode){
		ComPatentExample example=new ComPatentExample();
		example.createCriteria().andPro_codeEqualTo(proCode);
		return comPatentMapper.selectByExample(example);
	}
	/**
	 * 评估--专利权重提交
	 * @param weights
	 */
	public void weightSubmit(String weights,String proCode){
		JSONObject jo = JSON.parseObject(weights);
		Set<String> keys=jo.keySet();
		for (String key : keys) {
			ComPatent comPatent=new ComPatent();
			comPatent.setId(Long.valueOf(key));
			comPatent.setWeight(jo.getDouble(key));
			comPatentMapper.updateByPrimaryKeySelective(comPatent);
		}
	}
	/**
	 * 评价--dcf提交
	 * @param dataList
	 * @param dcf
	 * @param sagr
	 * @param proCode
	 */
	public void dcf(String dataList,BigDecimal dcf,BigDecimal sagr,String proCode){
		ProDcfExample example=new ProDcfExample();
		example.createCriteria().andProCodeEqualTo(proCode);
		proDcfMapper.deleteByExample(example);
		
		List<ProDcf> proDcfs=JSON.parseArray(dataList, ProDcf.class);
		for (ProDcf proDcf : proDcfs) {
			proDcf.setCreateDate(new Date());
			proDcf.setProCode(proCode);
			proDcfMapper.insertSelective(proDcf);
		}
		
		Pro pro=new Pro();
		pro.setProCode(proCode);
		pro.setDcf(dcf);
		pro.setSagr(sagr);
		proMapper.updateByPrimaryKeySelective(pro);
	}
	
	public List<ProValCase> getProValCases(String proCode,Long proValId){
		if(proValId==null){
			ComCaseExample example=new ComCaseExample();
			example.createCriteria().andProCodeEqualTo(proCode);
			List<ComCase> comCases=comCaseMapper.selectByExample(example);
			
			List<ProValCase> proValCases=new ArrayList<>();
			ProValCase proValCaseSelf=new ProValCase();
			proValCaseSelf.setName("委估专利");
			proValCaseSelf.setIsComplete(false);
			proValCases.add(proValCaseSelf);
			
			for (ComCase comCase : comCases) {
				ProValCase proValCase=new ProValCase();
				proValCase.setName(comCase.getName());
				proValCase.setIsComplete(false);
				proValCase.setTransDate(comCase.getTransDate());
				proValCase.setPrice(comCase.getPrice());
				proValCase.setCaseId(comCase.getId());
				proValCases.add(proValCase);
			}
			return proValCases;
		}else{
			ProValCaseExample example=new ProValCaseExample();
			example.setOrderByClause(" id ");
			example.createCriteria().andProCodeEqualTo(proCode).andProValIdEqualTo(proValId);
			return proValCaseMapper.selectByExample(example);
		}
	}
	
	public Long caseItemSubmit(CaseItem caseItem){
		Long proValId;
		if(caseItem.getProValCaseId()==null){
			ProVal proVal=new ProVal();
			proVal.setProGroup(ProVal.proGroup_2);
			proVal.setIsComplete(false);
			proVal.setProCode(caseItem.getProCode());
			proVal.setCreateDate(new Date());
			
			proValMapper.insertSelective(proVal);
			proValId=proVal.getId();
			
			if(caseItem.getCaseId()==null){
				ProValCase proValCaseSelf=new ProValCase();
				proValCaseSelf.setName("委估专利");
				proValCaseSelf.setProCode(caseItem.getProCode());
				proValCaseSelf.setProValId(proVal.getId());
				proValCaseSelf.setIsComplete(true);
				proValCaseSelf.setM1(BigDecimal.valueOf(caseItem.getM1()));
				proValCaseSelf.setM2(BigDecimal.valueOf(caseItem.getM2()));
				proValCaseSelf.setM3(BigDecimal.valueOf(caseItem.getM3()));
				proValCaseSelf.setM4(BigDecimal.valueOf(caseItem.getM4()));
				proValCaseSelf.setCreateDate(new Date());
				proValCaseSelf.setJson(JSON.toJSONString(caseItem));
				
				proValCaseMapper.insertSelective(proValCaseSelf);
				
				ComCaseExample example=new ComCaseExample();
				example.createCriteria().andProCodeEqualTo(caseItem.getProCode());
				List<ComCase> comCases=comCaseMapper.selectByExample(example);
				for (ComCase comCase : comCases) {
					ProValCase proValCase=new ProValCase();
					proValCase.setName(comCase.getName());
					proValCase.setIsComplete(false);
					proValCase.setTransDate(comCase.getTransDate());
					proValCase.setPrice(comCase.getPrice());
					proValCase.setCaseId(comCase.getId());
					proValCase.setProCode(caseItem.getProCode());
					proValCase.setProValId(proVal.getId());
					proValCase.setCreateDate(new Date());
					proValCaseMapper.insertSelective(proValCase);
				}
				
			}else{
				ProValCase proValCaseSelf=new ProValCase();
				proValCaseSelf.setName("委估专利");
				proValCaseSelf.setIsComplete(false);
				proValCaseSelf.setProCode(caseItem.getProCode());
				proValCaseSelf.setProValId(proVal.getId());
				proValCaseMapper.insertSelective(proValCaseSelf);
				
				ComCaseExample example=new ComCaseExample();
				example.createCriteria().andProCodeEqualTo(caseItem.getProCode());
				List<ComCase> comCases=comCaseMapper.selectByExample(example);
				for (ComCase comCase : comCases) {
					ProValCase proValCase=new ProValCase();
					proValCase.setName(comCase.getName());
					proValCase.setTransDate(comCase.getTransDate());
					proValCase.setPrice(comCase.getPrice());
					proValCase.setCaseId(comCase.getId());
					proValCase.setProCode(caseItem.getProCode());
					proValCase.setProValId(proVal.getId());
					proValCase.setCreateDate(new Date());
					
					if(comCase.getId().equals(caseItem.getCaseId())){
						proValCase.setIsComplete(true);
						proValCase.setM1(BigDecimal.valueOf(caseItem.getM1()));
						proValCase.setM2(BigDecimal.valueOf(caseItem.getM2()));
						proValCase.setM3(BigDecimal.valueOf(caseItem.getM3()));
						proValCase.setM4(BigDecimal.valueOf(caseItem.getM4()));
						proValCase.setJson(JSON.toJSONString(caseItem));
					}else{
						proValCase.setIsComplete(false);
					}
					proValCaseMapper.insertSelective(proValCase);
				}
			}
		}else{
			proValId=caseItem.getProValId();
			ProValCase proValCaseSelf=new ProValCase();
			proValCaseSelf.setId(caseItem.getProValCaseId());
			proValCaseSelf.setIsComplete(true);
			proValCaseSelf.setM1(BigDecimal.valueOf(caseItem.getM1()));
			proValCaseSelf.setM2(BigDecimal.valueOf(caseItem.getM2()));
			proValCaseSelf.setM3(BigDecimal.valueOf(caseItem.getM3()));
			proValCaseSelf.setM4(BigDecimal.valueOf(caseItem.getM4()));
			proValCaseSelf.setJson(JSON.toJSONString(caseItem));
			
			proValCaseMapper.updateByPrimaryKeySelective(proValCaseSelf);
		}
		return proValId;
	}
	
	public void caseSubmit(String jsonInfo){
		List<ProValCase> proValCases=JSON.parseArray(jsonInfo, ProValCase.class);
		
		BigDecimal sum=BigDecimal.ZERO;
		ProVal proVal=new ProVal();
		for (int i=0;i<proValCases.size();i++) {
			ProValCase proValCase=proValCases.get(i);
			if(proValCase.getPriceCal()!=null){
				sum=sum.add(proValCase.getPriceCal());
			}
			
			proValCase.setModifyDate(new Date());
			proValCaseMapper.updateByPrimaryKeySelective(proValCase);
			
			if(proVal.getId()==null){
				proVal.setId(proValCase.getProValId());
			}
		}
		sum=sum.setScale(2, RoundingMode.HALF_UP);
		proVal.setValue(sum);
		proVal.setIsComplete(true);
		proValMapper.updateByPrimaryKeySelective(proVal);
		
	}
}
