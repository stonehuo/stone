package com.kpap.website.service;

import java.math.BigDecimal;
import java.util.List;

import com.kpap.basis.model.Com;
import com.kpap.basis.model.ComDevCost;
import com.kpap.basis.model.ComPatent;
import com.kpap.basis.model.IqRatios;
import com.kpap.basis.model.Pro;
import com.kpap.basis.model.ProValCase;
import com.kpap.basis.model.ProValIncome;
import com.kpap.basis.model.ProValIncomeProt;
import com.kpap.website.dto.CaseItem;
import com.kpap.website.dto.Cost;
import com.kpap.website.dto.IncomeDiscountRate;
import com.kpap.website.dto.IncomeIncomeProduct;
import com.kpap.website.dto.IncomeIncomeProductC;
import com.kpap.website.dto.IncomeSeries;
import com.kpap.website.dto.IncomeShareRate;

public interface IProjectService {
	public void updatePro(Pro pro);
	public void resetPro(String proCode);
	public Pro getProByProCode(String proCode);
	public Long series(IncomeSeries incomeSeries);
	public List<ProValIncome> getProValIncomeByProCode(Long proValId);
	public void shareRate(IncomeShareRate incomeShareRate);
	public List<ProValIncomeProt> getProValIncomeProducts(String proCode,Long proValId);
	public void incomeProduct(IncomeIncomeProduct incomeIncomeProduct);
	public void incomeProduct(IncomeIncomeProductC incomeIncomeProductC);
	public Com getComByProCode(String proCode);
	public void incomeSum(String proCode,String result,String result_pre,String result_rate,String category,Long proValId);
	public BigDecimal discount_rate(IncomeDiscountRate incomeDiscountRate);
	/**
	 * 提交审核结果
	 * @param proCode
	 * @param result
	 * @param conclusion
	 * @param auditor
	 * @param creator
	 */
	public void auditPro(String proCode,boolean result,String conclusion,String auditor,String creator);
	
	/**
	 * 根据项目编码获取专利研发成本
	 * 
	 * @param proCode
	 * @return
	 */
	public ComDevCost getComDevCostByproCode(String proCode);
	
	/**
	 * 成本法模型结果
	 * 
	 * @param value
	 * @param proCode
	 * @return
	 */
	public Long costMethod(Cost cost);
	
	public IqRatios getIqRatiosByproCode(String proCode);
	public String submitResult(Long proValId,String proCode,BigDecimal value,String actuVal);
	public List<ComPatent> getComPatents(String proCode);
	public void weightSubmit(String weights,String proCode);
	public void dcf(String dataList,BigDecimal dcf,BigDecimal sagr,String proCode);
	public void submitAudit(String proCode,String auditor,String savePath);
	public List<ProValCase> getProValCases(String proCode,Long proValId);
	public Long caseItemSubmit(CaseItem caseItem);
	public void caseSubmit(String jsonInfo);
}
