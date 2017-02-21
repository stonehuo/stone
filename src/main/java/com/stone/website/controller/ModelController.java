package com.kpap.website.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.kpap.basis.excelModel.ComProductInfo;
import com.kpap.basis.model.Com;
import com.kpap.basis.model.ComDevCost;
import com.kpap.basis.model.ComProduct;
import com.kpap.basis.model.IqRatios;
import com.kpap.basis.model.Pro;
import com.kpap.basis.model.ProVal;
import com.kpap.basis.model.ProValCase;
import com.kpap.basis.model.ProValIncome;
import com.kpap.basis.model.ProValIncomeProt;
import com.kpap.common.service.IBaseService;
import com.kpap.common.util.ResultMap;
import com.kpap.website.dto.CaseItem;
import com.kpap.website.dto.Cost;
import com.kpap.website.dto.IncomeDiscountRate;
import com.kpap.website.dto.IncomeIncomeProduct;
import com.kpap.website.dto.IncomeIncomeProductC;
import com.kpap.website.dto.IncomeSeries;
import com.kpap.website.dto.IncomeShareRate;
import com.kpap.website.service.IProjectService;

@Controller
public class ModelController {
	@Autowired
	public IProjectService projectService;
	
	@Autowired
	public IBaseService baseService;
	
	/**
	 * 收益法--序列年期
	 * @return
	 */
	@RequestMapping(value="/income_series")
	public String incomeSeries(String proCode,Model model) {
		Pro pro=projectService.getProByProCode(proCode);
		model.addAttribute("project", pro);
		return "model/income_series";
	}
	/**
	 * 收益法--序列年期提交
	 * @param incomeSeries
	 * @return
	 */
	@RequestMapping(value="/series")
	public @ResponseBody ResultMap series(IncomeSeries incomeSeries){
		Long proValId=projectService.series(incomeSeries);
		return ResultMap.getDefaultResultMap("proValId", proValId);
	}
	/**
	 * 收益法--收益额汇总界面
	 * @param proValId
	 * @param proCode
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/income_income")
	public String income_income(String category,Long proValId,Model model){
		List<ProValIncome> proValIncomes=projectService.getProValIncomeByProCode(proValId);
		String proCode=proValIncomes.get(0).getProCode();
		List<ProValIncomeProt> proValIncomeProts=projectService.getProValIncomeProducts(proCode, proValId);
		model.addAttribute("proValIncomeProts", proValIncomeProts);
		model.addAttribute("proValIncomes", proValIncomes);
		model.addAttribute("proValId", proValId);
		model.addAttribute("category", category);
		model.addAttribute("proCode", proCode);
		
		return "model/income_income";
	}
	/**
	 * 收益法--收益额产品界面
	 * @param category
	 * @param proValIncomeProtId
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/income_income_product")
	public String income_income_product(String category,Long proValIncomeProtId,Model model) throws Exception{
		ProValIncomeProt proValIncomeProt=(ProValIncomeProt)baseService.selectByPrimaryKey(proValIncomeProtId, ProValIncomeProt.class.getName());
		List<ProValIncome> proValIncomes=projectService.getProValIncomeByProCode(proValIncomeProt.getProValId());
		ComProduct comProduct=(ComProduct)baseService.selectByPrimaryKey(proValIncomeProt.getProductId(), ComProduct.class.getName());
		ComProductInfo comProductInfo=JSON.parseObject(comProduct.getJsonInfo(), ComProductInfo.class);

		model.addAttribute("comProductInfo", comProductInfo);
		model.addAttribute("proValIncomes", proValIncomes);
		model.addAttribute("proValIncomeProt", proValIncomeProt);
		model.addAttribute("category", category);
		if(ProVal.category_0.equalsIgnoreCase(category)){
			IqRatios iqRatios=(IqRatios)baseService.selectByPrimaryKey(proValIncomeProt.getProCode(), IqRatios.class.getName());
			
			model.addAttribute("aveCollect", iqRatios.getJsonAveCollect());
			return "model/income_income_0";
		}else if(ProVal.category_1.equalsIgnoreCase(category)){
			IqRatios iqRatios=(IqRatios)baseService.selectByPrimaryKey(proValIncomeProt.getProCode(), IqRatios.class.getName());
			
			model.addAttribute("aveCollect", iqRatios.getJsonAveCollect());
			model.addAttribute("comProductJsonInfo", comProduct.getJsonInfo());
			return "model/income_income_1";
		}else{
			Com com=projectService.getComByProCode(proValIncomeProt.getProCode());
			BigDecimal taxRate=com.getTaxRate();
			model.addAttribute("taxRate",taxRate);
			return "model/income_income_2";
		}
		
	}
	/**
	 * 收益法--收益额产品提交(收入分成法，净利润分成法)
	 * @param incomeIncomeProduct
	 * @return
	 */
	@RequestMapping(value="/income_product")
	public @ResponseBody ResultMap income_product(IncomeIncomeProduct incomeIncomeProduct){
		projectService.incomeProduct(incomeIncomeProduct);
		return ResultMap.getDefaultResultMap();
	}
	/**
	 * 收益法--收益额产品提交(超额收益法)
	 * @param incomeIncomeProduct
	 * @return
	 */
	@RequestMapping(value="/income_product_c")
	public @ResponseBody ResultMap income_product_c(IncomeIncomeProductC incomeIncomeProductC){
		projectService.incomeProduct(incomeIncomeProductC);
		return ResultMap.getDefaultResultMap();
	}
	/**
	 * 收益法--收益额--汇总提交
	 * @param result
	 * @param category
	 * @return
	 */
	@RequestMapping(value="/income_income_next")
	public @ResponseBody ResultMap income_income_next(String proCode,String result,String result_pre,String result_rate,String category,Long proValId){
		projectService.incomeSum(proCode,result,result_pre,result_rate,category,proValId);
		return ResultMap.getDefaultResultMap();
	}
	
	/**
	 * 收益法--分成率
	 * @param category
	 * @param proCode
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/income_shareRate")
	public String incomeShareRate(String category,Long proValId,Model model){
		List<ProValIncome> proValIncomes=projectService.getProValIncomeByProCode(proValId);
		model.addAttribute("proValIncomes", proValIncomes);
		model.addAttribute("proValId", proValId);
		model.addAttribute("category", category);
		if(ProVal.category_0.equals(category)){
			return "model/share_rate_0";
		}
		return "model/share_rate_1";
	}
	/**
	 * 收益法--分成率--提交
	 * @param incomeShareRate
	 * @return
	 */
	@RequestMapping(value="/shareRate")
	public @ResponseBody ResultMap shareRate(IncomeShareRate incomeShareRate){
		projectService.shareRate(incomeShareRate);
		return ResultMap.getDefaultResultMap();
	}
	/**
	 * 收益法--折现率
	 * @param category
	 * @param proValId
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/income_discount_rate")
	public String income_discount_rate(String category,Long proValId,Model model) throws Exception{
		ProVal proVal=(ProVal)baseService.selectByPrimaryKey(proValId, ProVal.class.getName());
		IqRatios iqRatios=(IqRatios)baseService.selectByPrimaryKey(proVal.getProCode(), IqRatios.class.getName());
		
		Com com=projectService.getComByProCode(proVal.getProCode());
		BigDecimal taxRate=com.getTaxRate();
		model.addAttribute("taxRate",taxRate);
		model.addAttribute("iqRatios", iqRatios);
		model.addAttribute("category", category);
		model.addAttribute("proValId", proValId);
		model.addAttribute("proCode", proVal.getProCode());
		if(ProVal.category_0.equals(category)){
			return "model/income_discount_rate_0";
		}else{
			return "model/income_discount_rate_1";
		}
	}
	/**
	 * 收益法--折现率提交
	 * @param incomeDiscountRate
	 * @return
	 */
	@RequestMapping(value="/discount_rate")
	public @ResponseBody ResultMap discount_rate(IncomeDiscountRate incomeDiscountRate){
		BigDecimal sumResult=projectService.discount_rate(incomeDiscountRate);
		return ResultMap.getDefaultResultMap("sumResult", sumResult);
	}

	
	/**
	 * 成本法--成本重置模型界面
	 * @param proValId
	 * @param proCode
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/cost_view")
	public String cost_reset_model(String category,String proCode,Model model){
		Pro pro=projectService.getProByProCode(proCode);
		model.addAttribute("project", pro);
		ComDevCost comDevCost = projectService.getComDevCostByproCode(proCode);
		model.addAttribute("comDevCost", comDevCost);
		if(ProVal.category_4.equals(category)){
			model.addAttribute("category", ProVal.category_4);
			return "model/cost_coefficient";
		}else{
			model.addAttribute("category", ProVal.category_3);
			// 可比上市公司
			IqRatios iqRatios = projectService.getIqRatiosByproCode(proCode);
			model.addAttribute("iqRatios", iqRatios);
			return "model/cost_reset";
		}
	}
	
	/**
	 * 成本法--成本重置模型结果
	 * @param proValId
	 * @param proCode
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/cost_result")
	public @ResponseBody ResultMap cost_result(Cost cost){
		projectService.costMethod(cost);
		return ResultMap.getDefaultResultMap();
	}
	
	@RequestMapping(value="/view_cost")
	public String view_cost(Long proValId,Model model) throws Exception{
		ProVal proVal=(ProVal)baseService.selectByPrimaryKey(proValId, ProVal.class.getName());
		Cost cost=JSON.parseObject(proVal.getJsonCost(),Cost.class);
		model.addAttribute("cost", cost);
		if(ProVal.category_3.equals(proVal.getCategory())){
			return "model/view_cost_reset";
		}else{
			return "model/view_cost_coefficient";
		}
	}
	/**
	 * 收益法--收益额--产品界面
	 * @param proValIncomeProtId
	 * @param category
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/view_pro")
	public String view_pro(Long proValIncomeProtId,String category,Model model) throws Exception{
		ProValIncomeProt proValIncomeProt=(ProValIncomeProt)baseService.selectByPrimaryKey(proValIncomeProtId, ProValIncomeProt.class.getName());
		model.addAttribute("proValIncomeProt", proValIncomeProt);
		if(ProVal.category_0.equals(category) || ProVal.category_1.equals(category)){
			IncomeIncomeProduct project=JSON.parseObject(proValIncomeProt.getJson(), IncomeIncomeProduct.class);
			model.addAttribute("project", project);
			return "model/view_pro_0";
		}else{
			IncomeIncomeProductC project=JSON.parseObject(proValIncomeProt.getJson(), IncomeIncomeProductC.class);
			model.addAttribute("project", project);
			return "model/view_pro_1";
		}
	}
	/**
	 * 收益法，查看界面
	 * @param proCode
	 * @param proValId
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/view")
	public String view(String proCode,Long proValId,Model model) throws Exception{
		Pro pro=projectService.getProByProCode(proCode);
		ProVal proVal=(ProVal)baseService.selectByPrimaryKey(proValId, ProVal.class.getName());
		IncomeSeries incomeSeries=JSON.parseObject(proVal.getJsonSeriesYear(), IncomeSeries.class);
		IncomeShareRate incomeShareRate=JSON.parseObject(proVal.getJsonShareRate(), IncomeShareRate.class);
		IncomeDiscountRate incomeDiscountRate=JSON.parseObject(proVal.getJsonDiscountRate(), IncomeDiscountRate.class);
		List<ProValIncome> proValIncomes=projectService.getProValIncomeByProCode(proValId);
		List<ProValIncomeProt> proValIncomeProts=projectService.getProValIncomeProducts(proCode, proValId);
		
		model.addAttribute("proValIncomeProts", proValIncomeProts);
		model.addAttribute("pro", pro);
		model.addAttribute("proVal", proVal);
		model.addAttribute("proValIncomes", proValIncomes);
		model.addAttribute("incomeSeries", incomeSeries);
		model.addAttribute("incomeShareRate", incomeShareRate);
		model.addAttribute("incomeDiscountRate", incomeDiscountRate);
		return "model/view";
	}
	
	/**
	 * 市场法--案例汇总界面
	 * @param proValId
	 * @param proCode
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/case")
	public String market(String proCode,Long proValId,Model model){
		List<ProValCase> proValCases=projectService.getProValCases(proCode,proValId);
		model.addAttribute("proValCases", proValCases);
		model.addAttribute("proCode", proCode);
		
		return "model/case";
	}
	@RequestMapping(value="/caseItem")
	public String marketItem(String proCode,Long proValId,Long proValCaseId,Long caseId,String name,Model model){
		Pro pro=projectService.getProByProCode(proCode);
		model.addAttribute("pro", pro);
		model.addAttribute("proValCaseId", proValCaseId);
		model.addAttribute("caseId", caseId);
		model.addAttribute("name", name);
		model.addAttribute("proValId", proValId);
		
		return "model/caseItem";
	}

	@RequestMapping(value="/caseItemSubmit")
	public @ResponseBody ResultMap caseItemSubmit(CaseItem caseItem) throws Exception{
		Long proValId=projectService.caseItemSubmit(caseItem);
		return ResultMap.getDefaultResultMap("proValId", proValId);
	}
	@RequestMapping(value="/caseSubmit")
	public @ResponseBody ResultMap caseSubmit(String jsonInfo){
		projectService.caseSubmit(jsonInfo);
		return ResultMap.getDefaultResultMap();
	}
	
	@RequestMapping(value="/viewCase")
	public String viewCase(String proCode,Long proValId,Model model) throws Exception{
		ProVal proVal=(ProVal)baseService.selectByPrimaryKey(proValId, ProVal.class.getName());
		List<ProValCase> proValCases=projectService.getProValCases(proCode,proValId);
		
		model.addAttribute("proValCases", proValCases);
		model.addAttribute("proVal", proVal);
		return "model/view_case";
	}
	
	@RequestMapping(value="/viewCaseItem")
	public String viewCaseItem(Long proValCaseId,Model model) throws Exception{
		ProValCase proValCase=(ProValCase)baseService.selectByPrimaryKey(proValCaseId, ProValCase.class.getName());
		CaseItem caseItem=JSON.parseObject(proValCase.getJson(), CaseItem.class);
		model.addAttribute("proValCase", proValCase);
		model.addAttribute("caseItem", caseItem);
		return "model/view_caseitem";
	}

}
