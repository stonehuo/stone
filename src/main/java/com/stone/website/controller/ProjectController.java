package com.kpap.website.controller;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.alibaba.fastjson.JSON;
import com.kpap.basis.dao.ProDcfMapper;
import com.kpap.basis.model.ComPatent;
import com.kpap.basis.model.Pro;
import com.kpap.basis.model.ProDcf;
import com.kpap.basis.model.ProDcfExample;
import com.kpap.basis.model.ProReivew;
import com.kpap.basis.model.ProVal;
import com.kpap.basis.model.ProValCase;
import com.kpap.basis.model.ProValIncome;
import com.kpap.basis.model.ProValIncomeProt;
import com.kpap.basis.model.SysUser;
import com.kpap.common.dto.SearchKey;
import com.kpap.common.service.IBaseService;
import com.kpap.common.util.CommonUtil;
import com.kpap.common.util.ResultMap;
import com.kpap.website.dto.Cost;
import com.kpap.website.dto.IncomeDiscountRate;
import com.kpap.website.dto.IncomeSeries;
import com.kpap.website.dto.IncomeShareRate;
import com.kpap.website.service.IProjectExcelService;
import com.kpap.website.service.IProjectService;
import com.kpap.website.service.IUserService;
import com.kpap.website.service.impl.ProjectExcelService;
import com.kpap.website.service.impl.ReportExportHandler;

@Controller
public class ProjectController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProjectExcelService.class);
	
	@Value("${assets.path}")
	private String assetsPath;
	
	@Autowired
	public IBaseService baseService;
	
	@Autowired
	public IProjectExcelService projectExcelService;
	
	@Autowired
	public IProjectService projectService;
	
	@Autowired
	public IUserService userService;
	
	@Autowired
	public ReportExportHandler reportExportHandler;
	
	@Autowired
	public ProDcfMapper proDcfMapper;
	
	/**
	 * 算法说明
	 * @return
	 */
	@RequestMapping(value="/description")
	public String description() {
		return "project/description";
	}
	/**
	 * 项目查看页--评估
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/evaluation")
	public String evaluation(String status,HttpSession session,Model model){
		SysUser sysUser=(SysUser)session.getAttribute("user");
		model.addAttribute("user", sysUser);
		model.addAttribute("status", status);
		return "project/evaluation";
	}
	/**
	 * 项目查看页--评价
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/evaluationPj")
	public String evaluationPj(String status,HttpSession session,Model model){
		SysUser sysUser=(SysUser)session.getAttribute("user");
		model.addAttribute("user", sysUser);
		model.addAttribute("status", status);
		return "project/evaluationPj";
	}
	/**
	 * 查看操作记录
	 * @param proValId
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/modelRecord")
	public String modelRecord(Long proValId,Model model) throws Exception{
		ProVal proVal=(ProVal)baseService.selectByPrimaryKey(proValId, ProVal.class.getName());
		if(ProVal.proGroup_0.equals(proVal.getProGroup())){
			Pro pro=projectService.getProByProCode(proVal.getProCode());
			IncomeSeries incomeSeries=JSON.parseObject(proVal.getJsonSeriesYear(), IncomeSeries.class);
			IncomeShareRate incomeShareRate=JSON.parseObject(proVal.getJsonShareRate(), IncomeShareRate.class);
			IncomeDiscountRate incomeDiscountRate=JSON.parseObject(proVal.getJsonDiscountRate(), IncomeDiscountRate.class);
			List<ProValIncome> proValIncomes=projectService.getProValIncomeByProCode(proValId);
			List<ProValIncomeProt> proValIncomeProts=projectService.getProValIncomeProducts(proVal.getProCode(), proValId);
			
			model.addAttribute("proValIncomeProts", proValIncomeProts);
			model.addAttribute("pro", pro);
			model.addAttribute("proVal", proVal);
			model.addAttribute("proValIncomes", proValIncomes);
			model.addAttribute("incomeSeries", incomeSeries);
			model.addAttribute("incomeShareRate", incomeShareRate);
			model.addAttribute("incomeDiscountRate", incomeDiscountRate);
			return "model/view"; 
		}else if(ProVal.proGroup_1.equals(proVal.getProGroup())){
			Cost cost=JSON.parseObject(proVal.getJsonCost(),Cost.class);
			model.addAttribute("cost", cost);
			if(ProVal.category_3.equals(proVal.getCategory())){
				return "model/view_cost_reset";
			}else{
				return "model/view_cost_coefficient";
			}
		}else{
			List<ProValCase> proValCases=projectService.getProValCases(proVal.getProCode(),proValId);
			
			model.addAttribute("proValCases", proValCases);
			model.addAttribute("proVal", proVal);
			return "model/view_case";
		}
	}
	/**
	 * 项目审核
	 * @param session
	 * @param proCode
	 * @param result
	 * @param conclusion
	 * @param creator
	 * @return
	 */
	@RequestMapping(value="/auditPro")
	public @ResponseBody ResultMap audit(HttpSession session,String proCode,boolean result,String conclusion,String creator){
		SysUser sysUser=(SysUser)session.getAttribute("user");
		projectService.auditPro(proCode, result, conclusion, sysUser.getUserCode(), creator);
		return ResultMap.getDefaultResultMap();
	}
	/**
	 * 获取项目审核记录
	 * @param proCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/auditRecord")
	public @ResponseBody ResultMap auditRecord(String proCode) throws Exception{
		SearchKey searchKey=new SearchKey();
		searchKey.setProCode(proCode);
		searchKey.setSort("createDate");
		List<?> lists=baseService.getRowsBySearchKey(searchKey, ProReivew.class.getName());
		return ResultMap.getDefaultResultMap("list", lists);
	}
	/**
	 * 添加报告--评估
	 * @return
	 */
	@RequestMapping(value="/newProject")
	public String newProject(HttpSession session,Model model) {
		SysUser sysUser=(SysUser)session.getAttribute("user");
		model.addAttribute("user", sysUser);
		return "project/newProject";
	}
	/**
	 * 添加报告--评价
	 * @return
	 */
	@RequestMapping(value="/newProjectPj")
	public String newProjectPj(HttpSession session,Model model) {
		SysUser sysUser=(SysUser)session.getAttribute("user");
		model.addAttribute("user", sysUser);
		return "project/newProjectPj";
	}
	/**
	 * 新建项目
	 * @param pro
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="addProject")
	public @ResponseBody ResultMap addProject(Pro pro,HttpSession session) throws Exception{
		SysUser sysUser=(SysUser)session.getAttribute("user");
		//生成项目编码
		String pre=Pro.type_0.equals(pro.getType())?"PG":"PJ";
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
		String proCode=pre+format.format(date)+CommonUtil.createRandom(true, 4);
		
		pro.setProCode(proCode);
		pro.setCreator(sysUser.getUserCode());
		pro.setCreateDate(new Date());
		
		baseService.add(pro, Pro.class.getName());
		return ResultMap.getDefaultResultMap();
	}
	
    @RequestMapping("/uploadExcel")  
    public @ResponseBody ResultMap uploadExcel(HttpServletRequest request,HttpServletResponse response){
    	String filePackage=request.getParameter("proCode");
    	String status=request.getParameter("status");
    	String type=request.getParameter("type");
    	String returnPath="";
        try {
			//创建一个通用的多部分解析器  
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
			//判断 request 是否有文件上传,即多部分请求  
			if(multipartResolver.isMultipart(request)){  
			    //转换成多部分request    
			    MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
			    //取得request中的所有文件名  
			    Iterator<String> iter = multiRequest.getFileNames();  
			    while(iter.hasNext()){
			        //取得上传文件  
			        MultipartFile file = multiRequest.getFile(iter.next());
			        if(file != null){  
			            //取得当前上传文件的文件名称  
			            String oldfileName = file.getOriginalFilename();  
			            //如果名称不为“”,说明该文件存在，否则说明该文件不存在  
			            if(oldfileName.trim() !=""){  
			            	//重命名上传后的文件名  
			                String extName = oldfileName.substring(oldfileName.lastIndexOf(".")).toLowerCase();
			                Random random =new Random();
			                String fileName = type+"_"+System.currentTimeMillis()+String.valueOf(random.nextInt(10000))+extName;
			                //定义上传路径  
			        		SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
			        		String uploadPath=formater.format(new Date())+"/";
			                String directorypath = assetsPath+filePackage+"/"+ uploadPath;
			                File directoryFile=new File(directorypath);
			                if (!directoryFile.exists()) {
			                	directoryFile.mkdirs();
							}
			                returnPath=CommonUtil.assertPath+filePackage+"/"+uploadPath+fileName;
			                File localFile = new File(directorypath+fileName);
			                file.transferTo(localFile); 
			                //判断是否重传
			                if(!Pro.status_0.equals(status) && "iq".equalsIgnoreCase(type)){
			                	projectService.resetPro(filePackage);
			                }
			                //开始处理excel
			                projectExcelService.analysisExcel(filePackage,type,directorypath+fileName);
			                if("gz".equalsIgnoreCase(type)){
			                	//更改项目状态
				                Pro pro=new Pro();
				                pro.setProCode(filePackage);
				                pro.setStatus(Pro.status_1);
				                projectService.updatePro(pro);
			                }
			            }  
			        }  
			    }  
			      
			}
		} catch (Exception e) {
			e.printStackTrace();
			projectService.resetPro(filePackage);
			return ResultMap.getResultMap(-1,"请检查模板是否正确");
		}  
        return ResultMap.getDefaultResultMap("filePath", returnPath);
    }
    
	/**
	 * 估值汇总页
	 * @return
	 */
	@RequestMapping(value="/proValCol")
	public String projectValCollect(String proCode,Model model) {
		Pro pro=projectService.getProByProCode(proCode);
		List<SysUser> auditors=userService.getAuditors();
		model.addAttribute("auditors", auditors);
		model.addAttribute("pro", pro);
		return "project/projectValCollect";
	}
	/**
	 * 提交审核界面
	 * @param proValId
	 * @param value
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/submit")
	public String submit(String proCode,Long proValId,BigDecimal value,Model model) {
		Pro pro=projectService.getProByProCode(proCode);
		model.addAttribute("proValId", proValId);
		model.addAttribute("proValue", value);
		model.addAttribute("proCode", proCode);
		model.addAttribute("actuVal", pro.getActualVal());
		model.addAttribute("auditor", pro.getAuditor());
		return "project/submit";
	}
	/**
	 * 提交审核
	 * @param proValId
	 * @param proCode
	 * @param actuVal
	 * @param auditor
	 * @return
	 */
	@RequestMapping(value="/submitResult")
	public @ResponseBody ResultMap submitResult(Long proValId,String proCode,BigDecimal value,String actuVal){
		String type=projectService.submitResult(proValId, proCode,value,actuVal);
		return ResultMap.getDefaultResultMap("type", type);
	}
	@RequestMapping(value="/weight")
	public String weight(String proCode,Model model){
		Pro pro=projectService.getProByProCode(proCode);
		List<ComPatent> comPatents=projectService.getComPatents(proCode);
		model.addAttribute("pro", pro);
		model.addAttribute("comPatents", comPatents);
		return "project/weight";
	}
	@RequestMapping(value="/weightSubmit")
	public @ResponseBody ResultMap weightSubmit(String weights,String proCode) throws Exception{
		projectService.weightSubmit(weights,proCode);
		
		long beginTime = System.currentTimeMillis();
		logger.info("=======开始生成导出报表excel==================");
		String result = "";
		try {
			result =  reportExportHandler.doExport(proCode,Pro.type_0);
		} catch (Exception e) {
			logger.error("导出订单失败：",e);
			return ResultMap.getResultMap(-1, "导出失败，原因："+e.getMessage());
		}
		String detail = "共计费时["+(System.currentTimeMillis()-beginTime)+"]ms,导出路径为："+result;
		logger.info("=======生成导出报表excel结束，"+detail+"=======");
		
		Pro pro=new Pro();
		pro.setProCode(proCode);
		pro.setStatus(Pro.status_2);
		pro.setExcelUrl(result);
		baseService.editSelective(pro, Pro.class.getName());
		
		return ResultMap.getDefaultResultMap();
	}
	@RequestMapping(value="/dcfView")
	public String dcfView(String proCode,Model model) throws Exception{
		Pro pro=projectService.getProByProCode(proCode);
		
		ProDcf proDcf_1=new ProDcf();
		ProDcf proDcf_2=new ProDcf();
		ProDcf proDcf_3=new ProDcf();
		ProDcf proDcf_4=new ProDcf();
		ProDcf proDcf_5=new ProDcf();
		ProDcf proDcf_n=new ProDcf();
		
		ProDcfExample example=new ProDcfExample();
		example.createCriteria().andProCodeEqualTo(proCode);
		List<ProDcf> proDcfs=proDcfMapper.selectByExample(example);
		
		for (ProDcf proDcf : proDcfs) {
			if("1".equals(proDcf.getYear())){
				proDcf_1=proDcf;
			}else if("2".equals(proDcf.getYear())){
				proDcf_2=proDcf;
			}else if("3".equals(proDcf.getYear())){
				proDcf_3=proDcf;
			}else if("4".equals(proDcf.getYear())){
				proDcf_4=proDcf;
			}else if("5".equals(proDcf.getYear())){
				proDcf_5=proDcf;
			}else{
				proDcf_n=proDcf;
			}
		}
		
		model.addAttribute("pro", pro);
		model.addAttribute("sagr", pro.getSagr());
		model.addAttribute("dcf", pro.getDcf());
		model.addAttribute("proDcf_1", proDcf_1);
		model.addAttribute("proDcf_2", proDcf_2);
		model.addAttribute("proDcf_3", proDcf_3);
		model.addAttribute("proDcf_4", proDcf_4);
		model.addAttribute("proDcf_5", proDcf_5);
		model.addAttribute("proDcf_n", proDcf_n);
		return "project/dcf";
	}
	@RequestMapping(value="/dcf")
	public @ResponseBody ResultMap dcf(String dataList,BigDecimal dcf,BigDecimal sagr,String proCode) throws Exception{
		projectService.dcf(dataList, dcf, sagr, proCode);
		
		long beginTime = System.currentTimeMillis();
		logger.info("=======开始生成导出报表excel==================");
		String result = "";
		try {
			result =  reportExportHandler.doExport(proCode,Pro.type_1);
		} catch (Exception e) {
			logger.error("导出订单失败：",e);
			return ResultMap.getResultMap(-1, "导出失败，原因："+e.getMessage());
		}
		String detail = "共计费时["+(System.currentTimeMillis()-beginTime)+"]ms,导出路径为："+result;
		logger.info("=======导出报表结束，"+detail+"=======");
		
		Pro pro=new Pro();
		pro.setProCode(proCode);
		pro.setStatus(Pro.status_2);
		pro.setExcelUrl(result);
		baseService.editSelective(pro, Pro.class.getName());
		
		return ResultMap.getDefaultResultMap();
	}
    @RequestMapping("/uploadReport")  
    public @ResponseBody ResultMap uploadReport(HttpServletRequest request,HttpServletResponse response){
    	String proCode=request.getParameter("proCode");
    	String auditor=request.getParameter("auditor");
        try {
			//创建一个通用的多部分解析器  
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
			//判断 request 是否有文件上传,即多部分请求  
			if(multipartResolver.isMultipart(request)){  
			    //转换成多部分request    
			    MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
			    //取得request中的所有文件名  
			    Iterator<String> iter = multiRequest.getFileNames();  
			    while(iter.hasNext()){
			        //取得上传文件  
			        MultipartFile file = multiRequest.getFile(iter.next());
			        if(file != null){  
			            //取得当前上传文件的文件名称  
			            String oldfileName = file.getOriginalFilename();  
			            //如果名称不为“”,说明该文件存在，否则说明该文件不存在  
			            if(oldfileName.trim() !=""){  
			            	//重命名上传后的文件名  
			                String extName = oldfileName.substring(oldfileName.lastIndexOf(".")).toLowerCase();
			                String fileName = proCode+"_"+System.currentTimeMillis()+extName;
			                //定义上传路径  
			        		//SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
			        		String uploadPath="report/";
			                String directorypath = assetsPath+proCode+"/"+ uploadPath;
			                File directoryFile=new File(directorypath);
			                if (!directoryFile.exists()) {
			                	directoryFile.mkdirs();
							}
			                String savePath=CommonUtil.assertPath+proCode+"/"+uploadPath+fileName;
			                File localFile = new File(directorypath+fileName);
			                file.transferTo(localFile); 
			                
			                projectService.submitAudit(proCode, auditor, savePath);
			            }  
			        }  
			    }  
			      
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.getResultMap(-1,e.getMessage());
		}  
        return ResultMap.getDefaultResultMap();
    }
}
