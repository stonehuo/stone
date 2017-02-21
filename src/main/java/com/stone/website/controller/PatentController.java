package com.kpap.website.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.cxf.common.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.kpap.basis.dao.ComMapper;
import com.kpap.basis.dao.ComPatentSumMapper;
import com.kpap.basis.dao.IqComMapper;
import com.kpap.basis.dao.IqComPatentSumMapper;
import com.kpap.basis.model.Com;
import com.kpap.basis.model.ComExample;
import com.kpap.basis.model.ComPatentSum;
import com.kpap.basis.model.ComPatentSumExample;
import com.kpap.basis.model.IqCom;
import com.kpap.basis.model.IqComExample;
import com.kpap.basis.model.IqComPatentSum;
import com.kpap.basis.model.IqComPatentSumExample;
import com.kpap.basis.model.Pro;
import com.kpap.common.service.IBaseService;
import com.kpap.common.util.ResultMap;
import com.kpap.website.model.PatentArrInfo;
import com.kpap.website.service.IProjectService;
import com.kpap.website.service.impl.PatentService;

/**
 * 专利评估控制
 * 
 * @author haiwenshen
 *
 */
@Controller
public class PatentController {
	
	private static final Logger logger = LoggerFactory.getLogger(PatentController.class);
	
	@Autowired
	private PatentService patentService;
	
	@Autowired
	private IqComMapper iqComMapper;
	
	@Autowired
	private ComMapper comMapper;
	
	@Autowired
	private IBaseService baseService;
	
	@Autowired
	private IProjectService projectService;
	
	@Autowired
	private ComPatentSumMapper comPatentSumMapper;
	
	@Autowired
	private IqComPatentSumMapper IqComPatentSumMapper;
	
	/**
	 * 获取被评估公司，可比公司的专利信息
	 * @param proCode
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/patentInit")
	public @ResponseBody ResultMap patentInit(String proCode) throws Exception{
		patentService.resetPatent(proCode);
		//被评估公司数据
		ComExample comExample = new ComExample();
		comExample.createCriteria().andProCodeEqualTo(proCode);
		List<Com> comList = comMapper.selectByExample(comExample);
		if(CollectionUtils.isEmpty(comList)){
			return ResultMap.getResultMap(-1, "没有找到被评估公司信息");
		}
		Com com=comList.get(0);
		String companyNames = "'"+com.getName()+"'";
		String subCompanyNames = com.getJsonComSub();
		List<String> subComList = (List<String>)JSON.parse(subCompanyNames);
		if(subCompanyNames != null && subCompanyNames != "" && !CollectionUtils.isEmpty(subComList) ){
			for(int k=0;k<subComList.size();k++){
				companyNames = companyNames + "," +"'"+ subComList.get(k)+"'";
			}
		}
		patentService.comPatentEvaluation(companyNames, "",com);
		
		//可比公司数据
		IqComExample iqComExample = new IqComExample();
		iqComExample.createCriteria().andProCodeEqualTo(proCode);
		List<IqCom> iqComList = iqComMapper.selectByExample(iqComExample);
		if(iqComList == null || iqComList.size()  <= 0){
			return ResultMap.result_6;
		}
		int countIqComAvail=0;
		int countIqFm=0;//发明公开专利数量
		int countIqSq=0;//发明授权专利数量
		int countIqXx=0;//实用新型专利数量
		int countIqWg=0;//外观设计专利数量
		for(int i=0;i<iqComList.size();i++){
			String iqCompanyNames = "'"+iqComList.get(i).getName()+"'";
			String iqSubCompanyNames = iqComList.get(i).getJsonComSub();
			List<String> iqSubComList = (List<String>)JSON.parse(iqSubCompanyNames);
			if(iqSubCompanyNames != null && iqSubCompanyNames != "" && !CollectionUtils.isEmpty(iqSubComList) ){
				for(int k=0;k<iqSubComList.size();k++){
					iqCompanyNames = iqCompanyNames + ","+  "'"+ iqSubComList.get(k)+"'";
				}
			}
			PatentArrInfo patentArrInfo = patentService.iqPatentEvaluation(iqCompanyNames, "",iqComList.get(i));
			if(patentArrInfo!=null){
				countIqComAvail++;
				countIqFm=countIqFm+patentArrInfo.getCountIqFm();
				countIqSq=countIqSq+patentArrInfo.getCountIqSq();
				countIqXx=countIqXx+patentArrInfo.getCountIqXx();
				countIqWg=countIqWg+patentArrInfo.getCountIqWg();
			}
		}
		//更新iqCom信息
		Com com_upadte=new Com();
		com_upadte.setProCode(proCode);
		com_upadte.setCountIqCom(iqComList.size());
		com_upadte.setCountIqComAvail(countIqComAvail);
		com_upadte.setCountIqFm(countIqFm);
		com_upadte.setCountIqSq(countIqSq);
		com_upadte.setCountIqWg(countIqWg);
		com_upadte.setCountIqXx(countIqXx);
		baseService.editSelective(com_upadte, Com.class.getName());
		
		Pro pro=new Pro();
		pro.setProCode(proCode);
		pro.setIsPatent(Pro.isPatent_1);
		baseService.editSelective(pro, Pro.class.getName());
		
		return ResultMap.getDefaultResultMap();
	}
	/**
	 * 进入专利评分界面
	 * @param proCode
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/patentView")
	public String patentView(String proCode,String type,Model model) throws Exception{
		Com com=(Com)baseService.selectByPrimaryKey(proCode, Com.class.getName());
		Pro pro=projectService.getProByProCode(proCode);
		model.addAttribute("pro", pro);
		model.addAttribute("com", com);
		model.addAttribute("type", type);
		if(Pro.isPatent_2.equals(pro.getIsPatent())){
			ComPatentSumExample comPatentSumExample=new ComPatentSumExample();
			comPatentSumExample.createCriteria().andPro_codeEqualTo(proCode).andTypeIn(Arrays.asList("1","4","5"));
			List<ComPatentSum> comPatentSums=comPatentSumMapper.selectByExample(comPatentSumExample);
			for (ComPatentSum comPatentSum : comPatentSums) {
				model.addAttribute("1".equals(comPatentSum.getType())?"com_1":("4".equals(comPatentSum.getType())?"com_4":"com_5"), comPatentSum);
			}
			
			IqComPatentSumExample iqComPatentSumExample=new IqComPatentSumExample();
			iqComPatentSumExample.createCriteria().andPro_codeEqualTo(proCode).andTypeIn(Arrays.asList("1","3"));
			List<IqComPatentSum> iqComPatentSums=IqComPatentSumMapper.selectByExample(iqComPatentSumExample);
			for (IqComPatentSum iqComPatentSum : iqComPatentSums) {
				model.addAttribute("1".equals(iqComPatentSum.getType())?"iqCom_1":"iqCom_3", iqComPatentSum);
			}
		}
		return "project/patent";
	}
	
	@RequestMapping(value="/patentCal")
	public @ResponseBody ResultMap patentCal(String proCode) throws Exception{
		patentService.patentCal(proCode);
		Pro pro=new Pro();
		pro.setProCode(proCode);
		pro.setIsPatent(Pro.isPatent_2);
		baseService.editSelective(pro, Pro.class.getName());
		return ResultMap.getDefaultResultMap();
	}
}
