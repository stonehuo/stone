package com.kpap.website.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.cxf.common.util.CollectionUtils;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.kpap.basis.constant.Const;
import com.kpap.basis.dao.ComCaseMapper;
import com.kpap.basis.dao.ComInfoMapper;
import com.kpap.basis.dao.ComMapper;
import com.kpap.basis.dao.ComPatentMapper;
import com.kpap.basis.dao.ComPatentSumMapper;
import com.kpap.basis.dao.IqComMapper;
import com.kpap.basis.dao.IqComPatentMapper;
import com.kpap.basis.dao.IqComPatentSumMapper;
import com.kpap.basis.dao.IqInfoMapper;
import com.kpap.basis.dao.ProDcfMapper;
import com.kpap.basis.dao.ProMapper;
import com.kpap.basis.dao.ProValCaseMapper;
import com.kpap.basis.dao.ProValIncomeMapper;
import com.kpap.basis.dao.ProValMapper;
import com.kpap.basis.excelModel.Balance;
import com.kpap.basis.excelModel.Income;
import com.kpap.basis.excelModel.IncomeAve;
import com.kpap.basis.excelModel.IqGrowth;
import com.kpap.basis.excelModel.IqRatiosAve;
import com.kpap.basis.excelModel.Profit;
import com.kpap.basis.excelModel.Ratios;
import com.kpap.basis.excelModel.RatiosGrowthAve;
import com.kpap.basis.exception.BusinessException;
import com.kpap.basis.model.Com;
import com.kpap.basis.model.ComCase;
import com.kpap.basis.model.ComCaseExample;
import com.kpap.basis.model.ComExample;
import com.kpap.basis.model.ComInfo;
import com.kpap.basis.model.ComInfoExample;
import com.kpap.basis.model.ComPatent;
import com.kpap.basis.model.ComPatentExample;
import com.kpap.basis.model.ComPatentSum;
import com.kpap.basis.model.ComPatentSumExample;
import com.kpap.basis.model.IqCom;
import com.kpap.basis.model.IqComExample;
import com.kpap.basis.model.IqComPatent;
import com.kpap.basis.model.IqComPatentExample;
import com.kpap.basis.model.IqComPatentSum;
import com.kpap.basis.model.IqComPatentSumExample;
import com.kpap.basis.model.IqInfo;
import com.kpap.basis.model.IqInfoExample;
import com.kpap.basis.model.Pro;
import com.kpap.basis.model.ProDcf;
import com.kpap.basis.model.ProDcfExample;
import com.kpap.basis.model.ProVal;
import com.kpap.basis.model.ProValCase;
import com.kpap.basis.model.ProValCaseExample;
import com.kpap.basis.model.ProValIncome;
import com.kpap.basis.model.ProValIncomeExample;
import com.kpap.common.util.CommonUtil;
import com.kpap.common.util.DateUtil;
import com.kpap.common.util.DiskFileUtil;
import com.kpap.common.util.OfficeDocUtil;
import com.kpap.common.util.XlsCellVo;
import com.kpap.common.util.ZipDocUtil;
import com.kpap.common.util.chart.BarChart;
import com.kpap.common.util.chart.LineChart;
import com.kpap.common.util.chart.PieChart;
import com.kpap.common.util.chart.TimeSeriesChart;
import com.kpap.website.dto.Cost;

/**
 * 
 * 报告导出下载<BR>
 *
 * @auther shenhaiwen
 * @date 2016-12-11 下午10:15:09
 */
@Service 
public class ReportExportHandler {
	
	@Value("${assets.path}")
	private String assetsPath;
	
	@Autowired
	private IqComMapper iqComMapper;
	
	@Autowired 
	private IqComPatentMapper iqComPatentMapper;
	
	@Autowired
	private IqComPatentSumMapper iqComPatentSumMapper;
	
	@Autowired
	private ComPatentMapper comPatentMapper;
	
	@Autowired
	private ComPatentSumMapper comPatentSumMapper;
	
	@Autowired
	private IqInfoMapper iqInfoMapper;
	
	@Autowired
	private ComInfoMapper comInfoMapper;
	
	@Autowired
	private ComMapper comMapper;
	
	@Autowired
	private ProValIncomeMapper proValIncomeMapper;
	
	@Autowired
	private ProMapper proMapper;
	
	@Autowired 
	private ProValMapper proValMapper;
	
	@Autowired
	public ProDcfMapper proDcfMapper;
	
	@Autowired
	public ComCaseMapper comCaseMapper;
	
	@Autowired
	public ProValCaseMapper proValCaseMapper;
	
	/**
	 * 导出报告基础数据操作
	 * 
	 * @param orderList
	 * @param reportType
	 * @throws Exception 
	 */
	public String doExport(String proCode,String reportType) throws Exception{
		try{
			// 生成文件目录
			String path =CommonUtil.assertPath+proCode+"/reportExcel/" + DateUtil.getCurrentDateTimeAsInt();
			String filePath=assetsPath+proCode+"/reportExcel/"+DateUtil.getCurrentDateTimeAsInt();
			//创建文件对象
			File file = new File(filePath);
			//判断文件是否存在
			if (!file.exists()) {
				//若文件不存在则创建该文件
				file.mkdirs();
			}
			// 评价报告
			if(Pro.type_1.equals(reportType)){
				// 创建文件
				createEvaluateExcelFile(proCode, filePath);
				// 创建图片
				createEvaluatePictureFile(proCode, filePath);
			}else{ // 评估报告 
				createAssessmentExcelFile(proCode, filePath);
				createAssessmentPictureFile(proCode, filePath);
			}

			//文件全路径名
			String zipPath = filePath + ".zip";
			// 压缩目录
			ZipDocUtil.zip(filePath, zipPath, new ArrayList<Object>());
			// 返回文件全路径名称
			return path+".zip";
			
		} catch (Exception e) {
			//抛出异常
			throw e;
		}
	}
	
	/**
	 * 创建估值统计图表
	 * 
	 * @param proCode
	 * @param filePath
	 * @throws Exception 
	 */
	private void createAssessmentPictureFile(String proCode,String filePath) throws Exception{
		Com com=comMapper.selectByPrimaryKey(proCode);
		//1.行业专利数量及专利类型比率图-饼状图
		HashMap<String, Double> iqComCountBySumMap = new HashMap<String, Double>();
		iqComCountBySumMap.put("发明专利", (double)(com.getCountIqFm()+com.getCountIqSq()));
		iqComCountBySumMap.put("实用新型专利", (double)(com.getCountIqXx()));
		iqComCountBySumMap.put("外观设计专利", (double)(com.getCountIqWg()));
		PieChart pieChart = new PieChart("10.2行业专利数量及专利类型比率图",iqComCountBySumMap);
		createChartFile(pieChart.getChart(),filePath,827,472);
		
		//2.被评估公司专利数量及专利类型比率图-饼状图
		HashMap<String, Double> comCountBySumMap = new HashMap<String, Double>();
		comCountBySumMap.put("发明专利", (double)(com.getCountFm()+com.getCountSq()));
		comCountBySumMap.put("实用新型专利", (double)(com.getCountXx()));
		comCountBySumMap.put("外观设计专利", (double)(com.getCountWg()));
		PieChart pieChartWithCom = new PieChart("11.1被评估公司专利数量及专利类型比率图",comCountBySumMap);
		createChartFile(pieChartWithCom.getChart(),filePath,827,472);
		
		IqInfoExample iqInfoExample = new IqInfoExample();
    	iqInfoExample.createCriteria().andProCodeEqualTo(proCode);
    	List<IqInfo> iqInfoList = iqInfoMapper.selectByExample(iqInfoExample);
    	if(CollectionUtils.isEmpty(iqInfoList)){
    		throw new BusinessException("没有获取到项目编码["+proCode+"]的可比上市公司财务信息");
    	}
    	IqInfo iqInfo = iqInfoList.get(0);
    	
		// 3.可比公司营业收入、营业利润、利润总额、净利润柱状图-近5年-1张图
		getIqComInfoFinaProfitPicture(proCode,filePath,iqInfo,"10.1.1可比上市公司近5年的利润表合计数据");
		// 4.可比公司平均营业收入、营业利润、利润总额、净利润柱状图-近5年-1张图
		getIqComInfoFinaProfitAvePicture(proCode,filePath,iqInfo,"10.1.2可比上市公司近5年的利润表平均数据");
		// 5.可比公司营业收入增长率折线图-近5年-1张图
    	getIqInfoProductPicture(proCode,filePath,iqInfo,"10.1.3可比上市公司近5年营业收入增长率数据");
		// 6.可比公司营业收入平均增长率折线图-近5年-1张图
		getIqInfoProductAvgPicture(proCode,filePath,iqInfo,"10.1.4可比上市公司近5年营业收入平均增长率数据");
		// 7.折线图-近5年-1张图
		getIqInfoRatiosAvePicture(proCode,filePath,iqInfo,"10.1.5可比上市公司近5年财务比率指标");
	}
	
    /**
     * 创建估值Excel文件
     * 
     * @param list 
     * @param filePath
     * @throws IOException 
     */
    private String createAssessmentExcelFile(String proCode, String filePath) throws IOException{
    	//生成文件
        String fileName = getExportFileName(proCode) + ".xlsx";
        InputStream is=null;
    	String dest = null;
		try {
			//生成导出文件
	        Map<String, List<XlsCellVo>> dataMap = new HashMap<String, List<XlsCellVo>>();
	        List<XlsCellVo> cellVoList1 = new ArrayList<XlsCellVo>();
	        List<XlsCellVo> cellVoList3 = new ArrayList<XlsCellVo>();
	        List<XlsCellVo> cellVoList4 = new ArrayList<XlsCellVo>();
	        List<XlsCellVo> cellVoList5 = new ArrayList<XlsCellVo>();
	        getSummary(cellVoList1);
	        Integer  beginRow = 0;
	    	// 获取公司名称
	    	ComExample comExample = new ComExample();
	    	comExample.createCriteria().andProCodeEqualTo(proCode);
	    	List<Com> comList = comMapper.selectByExample(comExample);
	    	if(CollectionUtils.isEmpty(comList)){
	    		throw new BusinessException("没有获取到项目编码["+proCode+"]的被评估公司信息");
	    	}
	    	Com com = comList.get(0);
	        
	        // 可比公司情况
	        String title = "10.可比公司状况";
	        beginRow = getIqComInfo(proCode,cellVoList1,beginRow,title);
	        // 可比公司财务状况
	    	String incomeTitle = "10.1.1可比上市公司近5年的利润表合计数据如下";
	        String incomeAveTitle = "10.1.2可比上市公司近5年的利润表平均数据如下";
	        String iqInfoTitle = "10.1.3 可比上市公司近5年营业收入增长率数据如下";
	    	String iqInfoProductAveTitle = "10.1.4 可比上市公司近5年营业收入平均增长率数据如下";
	    	String iqInfoRatiosTitle = "10.1.5 可比上市公司近5年财务比率指标如下";
	        beginRow = getIqFinaInfo(proCode,cellVoList1,beginRow,incomeTitle,incomeAveTitle,iqInfoTitle,iqInfoProductAveTitle,iqInfoRatiosTitle);
	        // 可比公司专利状况
	        beginRow = 0;
	        title = "10.2可比公司专利状况";
	        beginRow = getIqComPatentInfo(proCode,cellVoList3,beginRow,title);
	        // 行业专利情况
	        beginRow = getIqComPatentSumInfo(proCode,cellVoList3,beginRow);
	       
	        // 被评估公司各专利状况
	        beginRow = 0;
	        title = "11.1 专利权人专利状况";
	        beginRow = getComPatentInfo(proCode,cellVoList4,beginRow,title,com);
	        // 被评估公司专利统计情况
	        beginRow = getComPatentSumInfo(proCode,cellVoList4,beginRow);
	        // 专利权人专利综合评价得分 (被评估公司)
	        title = "11.2 专利权人专利综合评价得分";
	        beginRow = getComPatentScore(proCode,cellVoList4,beginRow,title);
	        // 估值结论
	        beginRow = 0;
	    	Pro pro =proMapper.selectByPrimaryKey(proCode);
	    	ProVal proVal = proValMapper.selectByPrimaryKey(pro.getProValId()); 
	    	if(proVal == null){
	    		throw new BusinessException("没有获取到ID["+pro.getProValId()+"]的被评估公司估值信息");
	    	}
	    	// 收益法
	    	if(ProVal.proGroup_0.equals(proVal.getProGroup())){
	    		 beginRow = getProVal0ResultInfo(pro,cellVoList5,beginRow,proVal);
	    	}
	    	// 成本法
	    	if(ProVal.proGroup_1.equals(proVal.getProGroup())){
	    		beginRow=getProVal1ResultInfo(pro, cellVoList5, beginRow, proVal);
	    	}
	    	// 市场法
	    	if(ProVal.proGroup_2.equals(proVal.getProGroup())){
	    		beginRow=getProVal2ResultInfo(pro, cellVoList5, beginRow, proVal);
	    	}
	        
	        dataMap.put("IQ_可比公司财务状况", cellVoList1);
	        dataMap.put("IQ_可比公司专利状态", cellVoList3);
	        dataMap.put("被评估公司专利状况", cellVoList4);
	        dataMap.put("被评估公司估值结论", cellVoList5);
	        is = OfficeDocUtil.writeXls(dataMap,false);
			dest = filePath + File.separator + fileName;
			DiskFileUtil.saveFile(is, dest);
		} catch (Exception e) {
			throw new BusinessException(e);
		} finally {
			if (is != null) {
				is.close();
			}
		}
        return dest;
    }
    
    /**
	 * 创建评价需要的统计图表
	 * 
	 * @param proCode
	 * @param filePath
	 * @throws Exception 
	 */
	private void createEvaluatePictureFile(String proCode,String filePath) throws Exception{
		Com com=comMapper.selectByPrimaryKey(proCode);
		//1.行业专利数量及专利类型比率图-饼状图
		HashMap<String, Double> iqComCountBySumMap = new HashMap<String, Double>();
		iqComCountBySumMap.put("发明专利", (double)(com.getCountIqFm()+com.getCountIqSq()));
		iqComCountBySumMap.put("实用新型专利", (double)(com.getCountIqXx()));
		iqComCountBySumMap.put("外观设计专利", (double)(com.getCountIqWg()));
		PieChart pieChart = new PieChart("7.2行业专利数量及专利类型比率图",iqComCountBySumMap);
		createChartFile(pieChart.getChart(),filePath,827,472);
		
		//2.被评估公司专利数量及专利类型比率图-饼状图
		HashMap<String, Double> comCountBySumMap = new HashMap<String, Double>();
		comCountBySumMap.put("发明专利", (double)(com.getCountFm()+com.getCountSq()));
		comCountBySumMap.put("实用新型专利", (double)(com.getCountXx()));
		comCountBySumMap.put("外观设计专利", (double)(com.getCountWg()));
		PieChart pieChartWithCom = new PieChart("8.8.1被评估公司专利数量及专利类型比率图",comCountBySumMap);
		createChartFile(pieChartWithCom.getChart(),filePath,827,472);
		
		IqInfoExample iqInfoExample = new IqInfoExample();
		iqInfoExample.createCriteria().andProCodeEqualTo(proCode);
		List<IqInfo> iqInfoList = iqInfoMapper.selectByExample(iqInfoExample);
		if(CollectionUtils.isEmpty(iqInfoList)){
			throw new BusinessException("没有获取到项目编码["+proCode+"]的可比上市公司财务信息");
		}
		IqInfo iqInfo = iqInfoList.get(0);
		// 3.可比公司营业收入:收入、营业利润:税前利润(不包括非经常项)、利润总额:税前利润(包含非经常项)、净利润:公司净收入总额柱状图-近5年-1张图
		getIqComInfoFinaProfitPicture(proCode,filePath,iqInfo,"7.1.1可比上市公司近5年的利润表合计数据柱状图");
		// 4.可比公司平均营业收入、营业利润、利润总额、净利润柱状图-近5年-1张图
		getIqComInfoFinaProfitAvePicture(proCode,filePath,iqInfo,"7.1.2可比上市公司近5年的利润表平均数据柱状图");
		// 5.可比公司营业收入增长率折线图-近5年-1张图
		getIqInfoProductPicture(proCode,filePath,iqInfo,"7.1.3可比上市公司近5年营业收入增长率数据");
		// 6.可比公司营业收入平均增长率折线图-近5年-1张图
		getIqInfoProductAvgPicture(proCode,filePath,iqInfo,"7.1.4可比上市公司近5年营业收入平均增长率数据");
		// 7.折线图-近5年-1张图
		getIqInfoRatiosAvePicture(proCode,filePath,iqInfo,"7.1.5可比上市公司近5年财务比率指标");
		
		ComInfoExample comInfoExample = new ComInfoExample();
		comInfoExample.createCriteria().andProCodeEqualTo(proCode);
		List<ComInfo>  comInfoList =  comInfoMapper.selectByExample(comInfoExample);
		if(CollectionUtils.isEmpty(comInfoList)){
			throw new BusinessException("没有获取到项目编码["+proCode+"]的被评估公司财务信息");
		}
		ComInfo comInfo = comInfoList.get(0);
		// 9.被评估公司总资产、总负债、净资产(所有者权益) 柱状图-近5年-1张图
		getComInfoFinaHistoryPicture(proCode,filePath,comInfo);
		 //10.被评估公司营业收入、营业利润、利润总额、净利润柱状图-近5年-1张图
		getComInfoFinaProfitPicture(proCode,filePath,comInfo);
		 //11.被评估公司营业收入增长率折线图-近5年-1张图
		getComInfoRatiosPicture(proCode,filePath,comInfo);
		 //12.被评估公司营业收入平均增长率折线图-近5年-1张图
		getComInfoProductAvgPicture(proCode,filePath,comInfo);
		 // 13.被评估公司营业收入折线图-近5年-3张图
		getComInfoRatiosAvePicture(proCode,filePath,comInfo);
	}
	
	  /**
     * 可比公司营业收入、营业利润、利润总额、净利润柱状图-近5年-1张图
     * 
     * 
     * @param proCode
     * @param filePath
     * @return
     * @throws Exception 
     */
    private void  getIqComInfoFinaProfitPicture(String proCode,String filePath,IqInfo iqInfo,String title) throws Exception{
    	String json_income = iqInfo.getJsonIncome();
    	List<Income> incomeList =  JSONArray.parseArray(json_income, Income.class);
    	if(CollectionUtils.isEmpty(incomeList)){
    		throw new BusinessException("没有获取到项目编码["+proCode+"]的可比上市公司财务利润信息");
    	}
    	TreeMap<String, TreeMap<String,Double>> treeMap = new TreeMap<String, TreeMap<String,Double>>();
    	TreeMap<String,Double> valueTreeMap1 = new TreeMap<String,Double>();
    	TreeMap<String,Double> valueTreeMap2= new TreeMap<String,Double>();
    	TreeMap<String,Double> valueTreeMap3 = new TreeMap<String,Double>();
    	TreeMap<String,Double> valueTreeMap4 = new TreeMap<String,Double>();
    	for(int i=0;i<incomeList.size();i++){
    		Income profit = incomeList.get(i);
    		String year = profit.getR13().substring(0, 4);
    		valueTreeMap1.put(year, profit.getR16()); //营业收入
    		valueTreeMap2.put(year, profit.getR52()); //营业利润
    		valueTreeMap3.put(year, profit.getR64()); //利润总额
    		valueTreeMap4.put(year, profit.getR71()); //净利润
    	}
    	treeMap.put("营业收入", valueTreeMap1);
    	treeMap.put("营业利润", valueTreeMap2);
    	treeMap.put("利润总额", valueTreeMap3);
    	treeMap.put("净利润", valueTreeMap4);
    	BarChart barChart = new BarChart(title, "财务项", "数值(万元)", treeMap);
    	createChartFile(barChart.getChart(),filePath,827,472);
    }
    
	 /**
     * 可比公司平均营业收入、营业利润、利润总额、净利润柱状图-近5年-1张图
     * 
     * 
     * @param proCode
     * @param filePath
     * @return
     * @throws Exception 
     */
    private void  getIqComInfoFinaProfitAvePicture(String proCode,String filePath,IqInfo iqInfo,String title) throws Exception{
    	String json_incomeAve = iqInfo.getJsonIncomeAve();
    	List<IncomeAve> incomeList =  JSONArray.parseArray(json_incomeAve, IncomeAve.class);
    	if(CollectionUtils.isEmpty(incomeList)){
    		throw new BusinessException("没有获取到项目编码["+proCode+"]的可比上市公司财务利润信息");
    	}
    	TreeMap<String, TreeMap<String,Double>> treeMap = new TreeMap<String, TreeMap<String,Double>>();
    	TreeMap<String,Double> valueTreeMap1 = new TreeMap<String,Double>();
    	TreeMap<String,Double> valueTreeMap2= new TreeMap<String,Double>();
    	TreeMap<String,Double> valueTreeMap3 = new TreeMap<String,Double>();
    	TreeMap<String,Double> valueTreeMap4 = new TreeMap<String,Double>();
    	for(int i=0;i<incomeList.size();i++){
    		IncomeAve profit = incomeList.get(i);
    		String year = profit.getR13().substring(0, 4);
    		valueTreeMap1.put(year, profit.getR16()); //营业收入
    		valueTreeMap2.put(year, profit.getR52()); //营业利润
    		valueTreeMap3.put(year, profit.getR64()); //利润总额
    		valueTreeMap4.put(year, profit.getR71()); //净利润
    	}
    	treeMap.put("营业收入", valueTreeMap1);
    	treeMap.put("营业利润", valueTreeMap2);
    	treeMap.put("利润总额", valueTreeMap3);
    	treeMap.put("净利润", valueTreeMap4);
    	BarChart barChart = new BarChart(title, "财务项", "数值(元)", treeMap);
    	createChartFile(barChart.getChart(),filePath,827,472);
    }

	/**
	 * 创建评价Excel文件
	 * 
	 * @param list 
	 * @param filePath
	 * @throws IOException 
	 */
	private String createEvaluateExcelFile(String proCode, String filePath) throws IOException{
		//生成文件
	    String fileName = getExportFileName(proCode) + ".xlsx";
	    InputStream is=null;
		String dest = null;
		try {
			//生成导出文件
	        Map<String, List<XlsCellVo>> dataMap = new HashMap<String, List<XlsCellVo>>();
	        List<XlsCellVo> cellVoList1 = new ArrayList<XlsCellVo>();
	        List<XlsCellVo> cellVoList2 = new ArrayList<XlsCellVo>();
	        List<XlsCellVo> cellVoList3 = new ArrayList<XlsCellVo>();
	        List<XlsCellVo> cellVoList4 = new ArrayList<XlsCellVo>();
	        List<XlsCellVo> cellVoList5 = new ArrayList<XlsCellVo>();
	        getSummary(cellVoList1);
	        Integer  beginRow = 0;
	    	// 获取被评估公司
	    	Com com =comMapper.selectByPrimaryKey(proCode);
	        
	        // 可比公司情况
	        String title = "7．可比公司状况";
	        beginRow = getIqComInfo(proCode,cellVoList1,beginRow,title);
	        // 可比公司财务状况
	    	// 利润总计
	    	String incomeTitle = "7.1.1 可比上市公司近5年的利润表合计数据如下";
	        String incomeAveTitle = "7.1.2可比上市公司近5年的利润表平均数据如下";
	        String iqInfoTitle = "7.1.3 可比上市公司近5年营业收入增长率数据如下";
	    	String iqInfoProductAveTitle = "7.1.4 可比上市公司近5年营业收入平均增长率数据如下";
	    	String iqInfoRatiosTitle = "7.1.5 可比上市公司近5年财务比率指标如下";
	        beginRow = getIqFinaInfo(proCode,cellVoList1,beginRow,incomeTitle,incomeAveTitle,iqInfoTitle,iqInfoProductAveTitle,iqInfoRatiosTitle);
	        // 被评估单位财务状况
	        beginRow = 0;
	        beginRow = getComFinaInfo(proCode,cellVoList2,beginRow,com);
	        // 可比公司专利状况
	        beginRow = 0;
	        title = "7.2可比公司专利状况";
	        beginRow = getIqComPatentInfo(proCode,cellVoList3,beginRow,title);
	        // 行业专利情况
	        beginRow = getIqComPatentSumInfo(proCode,cellVoList3,beginRow);
	       
	        // 被评估公司各专利状况
	        beginRow = 0;
	        title = "8.8.1 专利权人专利状况";
	        beginRow = getComPatentInfo(proCode,cellVoList4,beginRow,title,com);
	        // 被评估公司专利统计情况
	        beginRow = getComPatentSumInfo(proCode,cellVoList4,beginRow);
	        // 专利权人专利综合评价得分 (被评估公司)
	        title = "8.8.2 专利权人专利综合评价得分";
	        beginRow = getComPatentScore(proCode,cellVoList4,beginRow,title);
	        
	        //dcf估值分析
	        beginRow = 0;
	        beginRow = getDcf(proCode,cellVoList5,beginRow);
	        
	        
	        dataMap.put("IQ_可比公司财务状况", cellVoList1);
	        dataMap.put("被评估公司财务状况", cellVoList2);
	        dataMap.put("IQ_可比公司专利状态", cellVoList3);
	        dataMap.put("被评估公司专利状况", cellVoList4);
	        dataMap.put("被评估公司估值结论", cellVoList5);
	        is = OfficeDocUtil.writeXls(dataMap,false);
			dest = filePath + File.separator + fileName;
			DiskFileUtil.saveFile(is, dest);
		} catch (Exception e) {
			throw new BusinessException(e);
		} finally {
			if (is != null) {
				is.close();
			}
		}
	    return dest;
	}

	/**
     *  收益法
     * 
     * @param proCode
     * @param cellVoList
     * @param beginRow
     * @return
     */
    private int  getProVal0ResultInfo(Pro pro, List<XlsCellVo> cellVoList,int beginRow,ProVal proVal){
    	//12.1.1收益法估值结果表
    	beginRow = getProVal0Info(pro,cellVoList,beginRow,proVal.getCategory());
    	// 12.1.2收益法各专利估值结果表
    	String title = "12.1.2收益法各专利估值结果表";
    	beginRow = getProValPatentInfo(pro,cellVoList,beginRow,title);
    	
    	return beginRow;
    }
    
	/**
     *  成本法
     * 
     * @param proCode
     * @param cellVoList
     * @param beginRow
     * @return
     */
    private int  getProVal1ResultInfo(Pro pro, List<XlsCellVo> cellVoList,int beginRow,ProVal proVal){
    	Cost cost=JSON.parseObject(proVal.getJsonCost(), Cost.class);
    	
    	cellVoList.add(new XlsCellVo(beginRow,0,"12.1.1成本法估值结果表",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
 	 	cellVoList.add(new XlsCellVo(++beginRow,0,"序号",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow,1,"项目",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow,2,"金额",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
	
		if(ProVal.category_3.equals(proVal.getCategory())){
			cellVoList.add(new XlsCellVo(++beginRow,0,"一",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow,1,"专利重置成本",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow,2,cost.getReset_0(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			
			cellVoList.add(new XlsCellVo(++beginRow,0,"1",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow,1,"其中：直接成本",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow,2,cost.getReset_2(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			
			cellVoList.add(new XlsCellVo(++beginRow,0,"2",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow,1,"      间接成本",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow,2,cost.getReset_3(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			
			cellVoList.add(new XlsCellVo(++beginRow,0,"3",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow,1,"      资金成本",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow,2,cost.getReset_4(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			
			cellVoList.add(new XlsCellVo(++beginRow,0,"4",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow,1,"      合理利润",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow,2,cost.getReset_5(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			
			cellVoList.add(new XlsCellVo(++beginRow,0,"二",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow,1,"专利贬值率",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow,2,cost.getReset_1(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			
			cellVoList.add(new XlsCellVo(++beginRow,0,"三",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow,1,"专利价值",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow,2,proVal.getValue(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		}else{
			cellVoList.add(new XlsCellVo(++beginRow,0,"一",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow,1,"专利重置成本",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow,2,"",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
			
			cellVoList.add(new XlsCellVo(++beginRow,0,"1",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow,1,"其中：研制复杂系数",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow,2,cost.getCoefficient_1(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			
			cellVoList.add(new XlsCellVo(++beginRow,0,"2",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow,1,"      专利科研成本",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow,2,cost.getCoefficient_0(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			
			cellVoList.add(new XlsCellVo(++beginRow,0,"二",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow,1,"专利贬值率",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow,2,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			
			cellVoList.add(new XlsCellVo(++beginRow,0,"三",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow,1,"专利价值",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow,2,proVal.getValue(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		}
    	
    	// 12.1.2收益法各专利估值结果表
    	String title = "12.1.2成本法各专利估值结果表";
    	beginRow = getProValPatentInfo(pro,cellVoList,beginRow,title);
    	
    	return beginRow;
    }
    
	/**
     *  市场法
     * 
     * @param proCode
     * @param cellVoList
     * @param beginRow
     * @return
     */
    private int  getProVal2ResultInfo(Pro pro, List<XlsCellVo> cellVoList,int beginRow,ProVal proVal){
    	ComCaseExample example=new ComCaseExample();
    	example.createCriteria().andProCodeEqualTo(pro.getProCode());
    	List<ComCase> comcases=comCaseMapper.selectByExample(example);
    	
    	cellVoList.add(new XlsCellVo(beginRow,0,"12.1.1专利比较因素条件说明表表",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
 	 	cellVoList.add(new XlsCellVo(++beginRow,0,"项目",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow,1,"委估专利",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		
		cellVoList.add(new XlsCellVo(beginRow+1,0,"专利类型",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+2,0,"专利名称",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+3,0,"专利号",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+4,0,"专利权人",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+5,0,"专利申请日",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+6,0,"交易市场",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+7,0,"成交价(万元)",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+8,0,"交易时间",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		
		cellVoList.add(new XlsCellVo(beginRow+1,1,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+2,1,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+3,1,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+4,1,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+5,1,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+6,1,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+7,1,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+8,1,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		
		for (int i=0;i<comcases.size();i++) {
			ComCase comCase=comcases.get(i);
			cellVoList.add(new XlsCellVo(beginRow,i+2,comCase.getName(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
			
			cellVoList.add(new XlsCellVo(beginRow+1,i+2,comCase.getPatt(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow+2,i+2,comCase.getTi(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow+3,i+2,comCase.getPn(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow+4,i+2,comCase.getPatentee(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow+5,i+2,comCase.getAd(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow+6,i+2,comCase.getMarket(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow+7,i+2,comCase.getPrice(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow+8,i+2,DateUtil.dateToString(comCase.getTransDate(),DateUtil.dataFormatPattern),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		}
		
		beginRow=beginRow+10;
		
		ProValCaseExample proValCaseExample=new ProValCaseExample();
		proValCaseExample.createCriteria().andProValIdEqualTo(proVal.getId());
		proValCaseExample.setOrderByClause(" id ");
		List<ProValCase> proValCases=proValCaseMapper.selectByExample(proValCaseExample);
		
    	cellVoList.add(new XlsCellVo(beginRow,0,"12.1.2专利比较因素条件指数表",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
 	 	cellVoList.add(new XlsCellVo(++beginRow,0,"项目",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow,1,"委估专利",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		
		cellVoList.add(new XlsCellVo(beginRow+1,0,"专利名称",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+2,0,"专利号",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+3,0,"成交价(万元)",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+4,0,"交易时间修正",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+5,0,"剩余经济寿命修正",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+6,0,"技术特性修正",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+7,0,"其他因素修正",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		
		for (int i=0;i<proValCases.size();i++) {
			ProValCase proValCase=proValCases.get(i);
			ComCase thisComCase=null;
			for (ComCase comCase : comcases) {
				if(proValCase.getCaseId()==comCase.getId()){
					thisComCase=comCase;
				}
			}
			
			cellVoList.add(new XlsCellVo(beginRow,i+1,proValCase.getName(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
			
			cellVoList.add(new XlsCellVo(beginRow+1,i+1,(thisComCase==null?"":thisComCase.getTi()),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow+2,i+1,(thisComCase==null?"":thisComCase.getPn()),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow+3,i+1,(thisComCase==null?"":thisComCase.getPrice()),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow+4,i+1,proValCase.getM1(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow+5,i+1,proValCase.getM2(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow+6,i+1,proValCase.getM3(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow+7,i+1,proValCase.getM4(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		}
		
		beginRow=beginRow+9;
		
    	cellVoList.add(new XlsCellVo(beginRow,0,"12.1.2专利比较因素条件指数表",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
 	 	cellVoList.add(new XlsCellVo(++beginRow,0,"项目",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow,1,"委估专利",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		
		cellVoList.add(new XlsCellVo(beginRow+1,0,"专利名称",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+2,0,"专利号",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+3,0,"成交价(万元)",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+4,0,"交易时间修正",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+5,0,"剩余经济寿命修正",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+6,0,"技术特性修正",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+7,0,"其他因素修正",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+8,0,"修正系数",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+9,0,"修正后成交价(万元)",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+10,0,"权重(%)",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+11,0,"专利估值(万元)",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		
		for (int i=0;i<proValCases.size();i++) {
			ProValCase proValCase=proValCases.get(i);
			ComCase thisComCase=null;
			for (ComCase comCase : comcases) {
				if(comCase.getId().equals(proValCase.getCaseId())){
					thisComCase=comCase;
				}
			}
			
			cellVoList.add(new XlsCellVo(beginRow,i+1,proValCase.getName(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
			
			cellVoList.add(new XlsCellVo(beginRow+1,i+1,(thisComCase==null?"":thisComCase.getTi()),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow+2,i+1,(thisComCase==null?"":thisComCase.getPn()),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow+3,i+1,(thisComCase==null?"":thisComCase.getPrice()),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow+4,i+1,proValCase.getM1Ratio(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow+5,i+1,proValCase.getM2Ratio(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow+6,i+1,proValCase.getM3Ratio(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow+7,i+1,proValCase.getM4Ratio(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			String m="";
			if(thisComCase!=null){
				BigDecimal bigDecimal=proValCase.getM1Ratio().multiply(proValCase.getM2Ratio()).multiply(proValCase.getM3Ratio()).multiply(proValCase.getM4Ratio());
				bigDecimal=bigDecimal.setScale(2, RoundingMode.HALF_UP);
				m=bigDecimal.toString();
			}
			cellVoList.add(new XlsCellVo(beginRow+8,i+1,m,XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow+9,i+1,proValCase.getPriceCal(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			String weight="";
			if(thisComCase!=null){
				BigDecimal bigDecimal=proValCase.getWeight().setScale(2, RoundingMode.HALF_UP);
				weight=bigDecimal.toString()+"%";
			}
			cellVoList.add(new XlsCellVo(beginRow+10,i+1,weight,XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			if(thisComCase==null){
				cellVoList.add(new XlsCellVo(beginRow+11,i+1,proVal.getValue(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			}
			
		}
		
		beginRow=beginRow+13;
		
    	String title = "12.1.4市场法各专利估值结果表";
    	beginRow = getProValPatentInfo(pro,cellVoList,beginRow,title);
		
    	return beginRow;
    }
    
    
	/**
	 * dcf估值分析
	 * @param proCode
	 * @param cellVoList
	 * @param beginRow
	 * @return
	 */
    private int  getDcf(String proCode, List<XlsCellVo> cellVoList,int beginRow){
    	Pro pro=proMapper.selectByPrimaryKey(proCode);
    	
    	cellVoList.add(new XlsCellVo(beginRow,0,"DCF估值分析",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
 	 	cellVoList.add(new XlsCellVo(++beginRow,0,"永续年增长率：",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow,1,pro.getSagr(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		
		cellVoList.add(new XlsCellVo(++beginRow,0,"年限",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+1,0,"营业收入",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+2,0,"净利润率",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+3,0,"净利润",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+4,0,"折现率WACC",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+5,0,"序列年期",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+6,0,"折现系数",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+7,0,"折现值",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+8,0,"折现值累计",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+9,0,"DCF估值",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		
		ProDcfExample proDcfExample=new ProDcfExample();
		proDcfExample.createCriteria().andProCodeEqualTo(proCode);
		List<ProDcf> proDcfs=proDcfMapper.selectByExample(proDcfExample);
		
		BigDecimal totalVal=BigDecimal.ZERO;
		for (int i=0;i<proDcfs.size();i++) {
			ProDcf proDcf=proDcfs.get(i);
			String yearDes="1".equals(proDcf.getYear())?"第一年":("2".equals(proDcf.getYear())?"第二年":("3".equals(proDcf.getYear())?"第三年":("4".equals(proDcf.getYear())?"第四年":("5".equals(proDcf.getYear())?"第五年":"永续年"))));
			cellVoList.add(new XlsCellVo(beginRow,i+1,yearDes,XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow+1,i+1,proDcf.getIncome(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow+2,i+1,proDcf.getProfitRate(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow+3,i+1,proDcf.getProfit(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow+4,i+1,proDcf.getDiscountRate(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow+5,i+1,proDcf.getSeriesYear(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow+6,i+1,proDcf.getDiscountFactor(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			cellVoList.add(new XlsCellVo(beginRow+7,i+1,proDcf.getDiscountValue(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
			
			totalVal=totalVal.add(proDcf.getDiscountValue());
		}
		cellVoList.add(new XlsCellVo(beginRow+8,1,totalVal,XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
		cellVoList.add(new XlsCellVo(beginRow+9,1,pro.getDcf(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    	
    	return beginRow+9;
    }
    
    /**
     * 专利估值结果
     * 
     * @param proCode
     * @param cellVoList
     * @param beginRow
     * @param comInfo
     * @return
     */
    private int  getProValPatentInfo(Pro pro, List<XlsCellVo> cellVoList,int beginRow,String title){
    	int beginCollumn = 0;
    	beginRow = beginRow+2;
    	cellVoList.add(new XlsCellVo(beginRow,beginCollumn,title,XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    	// 获取收益法估值总结果
    	double totalValue = pro.getCalVal().doubleValue(); 
    	
    	// 各个专利权重
    	ComPatentExample comPatentExample = new ComPatentExample();
    	comPatentExample.createCriteria().andPro_codeEqualTo(pro.getProCode());
    	List<ComPatent> comPatentList = comPatentMapper.selectByExample(comPatentExample);
    	if(CollectionUtils.isEmpty(comPatentList)){
    		throw new BusinessException("没有获取到项目编码["+pro.getProCode()+"]的被评估公司专利信息");
    	}
    	
    	ReportExportTitleHandler.getProVal0PatentCollumnTitle(cellVoList,beginRow,beginCollumn);
    	beginRow ++ ;
    	for(int i=0;i<comPatentList.size();i++){
    		 ComPatent comPatent = comPatentList.get(i);
    		 beginRow ++ ;
    		 cellVoList.add(new XlsCellVo(beginRow,beginCollumn, i+1,XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow,beginCollumn+1, comPatent.getTi()+"("+comPatent.getPn()+")",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow,beginCollumn+2,(comPatent.getWeight()*100),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//
    		 cellVoList.add(new XlsCellVo(beginRow,beginCollumn+3,(totalValue*comPatent.getWeight()) ,XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//
    	}
    	return beginRow;
    }
    
    /**
     * 12.1.1收益法估值结果表
     * 
     * @param proCode
     * @param cellVoList
     * @param beginRow
     * @param comInfo
     * @return
     */
    private int  getProVal0Info(Pro pro, List<XlsCellVo> cellVoList,int beginRow,String categroy){
    	int beginCollumn = 0;
    	cellVoList.add(new XlsCellVo(beginRow,beginCollumn,"12.1.1收益法估值结果表",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    	ProValIncomeExample proValIncomeExample = new ProValIncomeExample();
    	proValIncomeExample.createCriteria().andProCodeEqualTo(pro.getProCode());
    	List<ProValIncome> list = proValIncomeMapper.selectByExample(proValIncomeExample); 
    	if(CollectionUtils.isEmpty(list)){
    		throw new BusinessException("没有获取到项目编码["+pro.getProCode()+"]的被评估公司收益法估值结果信息");
    	}
    	ReportExportTitleHandler.getProVal0CollumnTitle(cellVoList,beginRow,beginCollumn,categroy);
    	for(int i=0;i<list.size();i++){
    		 ProValIncome proValIncome = list.get(i);
    		 beginCollumn ++ ;
    		 cellVoList.add(new XlsCellVo(beginRow+1,beginCollumn,proValIncome.getNextYear(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+2,beginCollumn,proValIncome.getIncome() ,XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 if(ProVal.category_2.equals(categroy)){//超额收益法
    			 cellVoList.add(new XlsCellVo(beginRow+3,beginCollumn,proValIncome.getTaxRate(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//
    		 }else{
    			 cellVoList.add(new XlsCellVo(beginRow+3,beginCollumn,proValIncome.getShareRate(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//
    		 }
    		 cellVoList.add(new XlsCellVo(beginRow+4,beginCollumn,proValIncome.getIncomeCal(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//
    		 cellVoList.add(new XlsCellVo(beginRow+5,beginCollumn,proValIncome.getDiscountRate(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//
    		 cellVoList.add(new XlsCellVo(beginRow+6,beginCollumn,proValIncome.getSeriesYear(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//
    		 cellVoList.add(new XlsCellVo(beginRow+7,beginCollumn,proValIncome.getDiscountFactor(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//
    		 cellVoList.add(new XlsCellVo(beginRow+8,beginCollumn,proValIncome.getValue(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//
    	}
    	cellVoList.add(new XlsCellVo(beginRow+9,1,pro.getCalVal(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//现值合计
    	cellVoList.add(new XlsCellVo(beginRow+10,1,pro.getActualVal(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//专利资产价值
    	beginRow = beginRow+10;
    	return beginRow;
    }
	
	/**
     * 被评估公司营业收入、营业利润、利润总额、净利润柱状图-近5年-1张图
     * 
     * @param proCode
     * @param filePath
     * @return
     * @throws Exception 
     */
    private void  getComInfoFinaProfitPicture(String proCode,String filePath,ComInfo comInfo) throws Exception{
    	String jsonProfit = comInfo.getJsonProfit();
    	List<Profit> list =  JSONArray.parseArray(jsonProfit, Profit.class);
    	if(CollectionUtils.isEmpty(list)){
    		throw new BusinessException("没有获取到项目编码["+proCode+"]的被评估单位历史年度经营状况信息");
    	}
    	TreeMap<String, TreeMap<String,Double>> treeMap = new TreeMap<String, TreeMap<String,Double>>();
    	TreeMap<String,Double> valueTreeMap1 = new TreeMap<String,Double>();
    	TreeMap<String,Double> valueTreeMap2= new TreeMap<String,Double>();
    	TreeMap<String,Double> valueTreeMap3 = new TreeMap<String,Double>();
    	TreeMap<String,Double> valueTreeMap4 = new TreeMap<String,Double>();
    	for(int i=0;i<list.size();i++){
    		Profit profit = list.get(i);
    		String year = profit.getR11().substring(0, 4);
    		valueTreeMap1.put(year, profit.getR16()); //营业收入
    		valueTreeMap2.put(year, profit.getR41()); //营业利润
    		valueTreeMap3.put(year, profit.getR47()); //利润总额
    		valueTreeMap4.put(year, profit.getR52()); //净利润
    	}
    	treeMap.put("营业收入", valueTreeMap1);
    	treeMap.put("营业利润", valueTreeMap2);
    	treeMap.put("利润总额", valueTreeMap3);
    	treeMap.put("净利润", valueTreeMap4);
    	BarChart barChart = new BarChart("8.7.2历史年度经营状况", "财务项", "数值(万元)", treeMap);
    	createChartFile(barChart.getChart(),filePath,827,472);
    }
	
    /**
     * 被评估公司总资产、总负债、净资产(所有者权益) 柱状图-近5年-1张图
     * 
     * @param proCode
     * @param filePath
     * @return
     * @throws Exception 
     */
    private void  getComInfoFinaHistoryPicture(String proCode,String filePath,ComInfo comInfo) throws Exception{
    	String jsonBalance = comInfo.getJsonBalance();
    	List<Balance> list =  JSONArray.parseArray(jsonBalance, Balance.class);
    	if(CollectionUtils.isEmpty(list)){
    		throw new BusinessException("没有获取到项目编码["+proCode+"]的被评估单位历史年度财务状况信息");
    	}
    	TreeMap<String, TreeMap<String,Double>> treeMap = new TreeMap<String, TreeMap<String,Double>>();
    	TreeMap<String,Double> valueTreeMap1 = new TreeMap<String,Double>();
    	TreeMap<String,Double> valueTreeMap2= new TreeMap<String,Double>();
    	TreeMap<String,Double> valueTreeMap3 = new TreeMap<String,Double>();
    	for(int i=0;i<list.size();i++){
    		Balance balance = list.get(i);
    		String year = balance.getR10().substring(0, 4);
    		valueTreeMap1.put(year, balance.getR61()); //公司总资产
    		valueTreeMap2.put(year, balance.getR104()); //总负债
    		valueTreeMap3.put(year, balance.getR119()); //净资产(所有者权益)
    	}
    	treeMap.put("总资产", valueTreeMap1);
    	treeMap.put("总负债", valueTreeMap2);
    	treeMap.put("净资产", valueTreeMap3);
    	BarChart barChart = new BarChart("8.7.1历史年度财务状况", "财务项", "数值(元)", treeMap);
    	createChartFile(barChart.getChart(),filePath,827,472);
    }
	
	
    /**
     * 可比上市公司近5年财务比率指标统计图
     * 
     * @param proCode
     * @param filePath
     * @return
     * @throws Exception 
     */
    private void  getIqInfoRatiosAvePicture(String proCode,String filePath,IqInfo iqInfo,String title) throws Exception{
    	String jsonRatios = iqInfo.getJsonRatios();
    	List<IqRatiosAve> list =  JSONArray.parseArray(jsonRatios, IqRatiosAve.class);
    	if(CollectionUtils.isEmpty(list)){
    		throw new BusinessException("没有获取到项目编码["+proCode+"]的可比上市公司近5年财务比率标信息");
    	}
    	TreeMap<String, TreeMap<Integer,Double>> treeMap1 = new TreeMap<String, TreeMap<Integer,Double>>();
    	TreeMap<String, TreeMap<Integer,Double>> treeMap2 = new TreeMap<String, TreeMap<Integer,Double>>();
    	TreeMap<String, TreeMap<Integer,Double>> treeMap3 = new TreeMap<String, TreeMap<Integer,Double>>();
    	TreeMap<String, TreeMap<Integer,Double>> treeMap4 = new TreeMap<String, TreeMap<Integer,Double>>();
    	
    	
    	TreeMap<Integer,Double> valueTreeMap1 = new TreeMap<Integer,Double>();
    	TreeMap<Integer,Double> valueTreeMap2= new TreeMap<Integer,Double>();
    	TreeMap<Integer,Double> valueTreeMap3 = new TreeMap<Integer,Double>();
    	TreeMap<Integer,Double> valueTreeMap4 = new TreeMap<Integer,Double>();
    	TreeMap<Integer,Double> valueTreeMap5 = new TreeMap<Integer,Double>();
    	TreeMap<Integer,Double> valueTreeMap6 = new TreeMap<Integer,Double>();
    	TreeMap<Integer,Double> valueTreeMap7 = new TreeMap<Integer,Double>();
    	TreeMap<Integer,Double> valueTreeMap8 = new TreeMap<Integer,Double>();
    	TreeMap<Integer,Double> valueTreeMap9 = new TreeMap<Integer,Double>();
    	TreeMap<Integer,Double> valueTreeMap10 = new TreeMap<Integer,Double>();
    	TreeMap<Integer,Double> valueTreeMap11 = new TreeMap<Integer,Double>();
    	TreeMap<Integer,Double> valueTreeMap12 = new TreeMap<Integer,Double>();
    	TreeMap<Integer,Double> valueTreeMap13 = new TreeMap<Integer,Double>();
    	TreeMap<Integer,Double> valueTreeMap14 = new TreeMap<Integer,Double>();
    	TreeMap<Integer,Double> valueTreeMap15 = new TreeMap<Integer,Double>();
    	TreeMap<Integer,Double> valueTreeMap16 = new TreeMap<Integer,Double>();
    	
    	for(int i=0;i<list.size();i++){
    		IqRatiosAve iqRatiosAve = list.get(i);
    		String year = iqRatiosAve.getR13().substring(0, 4);
    		valueTreeMap1.put(Integer.valueOf(year), iqRatiosAve.getR37());//净资产收益率ROE(%)
    		valueTreeMap2.put(Integer.valueOf(year), iqRatiosAve.getR40());//总资产报酬率ROA(%)
    		valueTreeMap3.put(Integer.valueOf(year), iqRatiosAve.getR45());//销售净利率(%)
    		valueTreeMap4.put(Integer.valueOf(year), iqRatiosAve.getR46());//销售毛利率(%)
    		
    		valueTreeMap5.put(Integer.valueOf(year), iqRatiosAve.getR71());//资产负债率(%)
    		valueTreeMap6.put(Integer.valueOf(year), iqRatiosAve.getR82());//流动比率
    		valueTreeMap7.put(Integer.valueOf(year), iqRatiosAve.getR83());//速动比率
    		valueTreeMap8.put(Integer.valueOf(year), iqRatiosAve.getR105());//存货周转率(次)
    		valueTreeMap9.put(Integer.valueOf(year), iqRatiosAve.getR106());//应收账款周转率(次)
    		valueTreeMap10.put(Integer.valueOf(year), iqRatiosAve.getR107());//流动资产周转率(次)
    		valueTreeMap11.put(Integer.valueOf(year), iqRatiosAve.getR109());//总资产周转率(次)
    		valueTreeMap12.put(Integer.valueOf(year), iqRatiosAve.getR135());//营业收入(同比增长率)(%)
    		valueTreeMap13.put(Integer.valueOf(year), iqRatiosAve.getR125());//营业利润 (同比增长率)(%)
    		valueTreeMap14.put(Integer.valueOf(year), iqRatiosAve.getR126());//利润总额(同比增长率)(%)
    		valueTreeMap15.put(Integer.valueOf(year), iqRatiosAve.getR132());//资产总计(相对年初增长率)(%)
    		valueTreeMap16.put(Integer.valueOf(year), iqRatiosAve.getR133());//归属母公司股东的权益(相对年初增长率)(%)
    	}
    	treeMap1.put("净资产收益率", valueTreeMap1);
    	treeMap1.put("总资产报酬率", valueTreeMap2);
    	treeMap1.put("销售净利率(%)", valueTreeMap3);
    	treeMap1.put("销售毛利率(%)", valueTreeMap4);
    	
    	treeMap2.put("资产负债率(%)", valueTreeMap5);
    	treeMap2.put("流动比率", valueTreeMap6);
    	treeMap2.put("速动比率", valueTreeMap7);
    	
    	treeMap3.put("存货周转率(次)", valueTreeMap8);
    	treeMap3.put("应收账款周转率(次)", valueTreeMap9);
    	treeMap3.put("流动资产周转率(次)", valueTreeMap10);
    	treeMap3.put("总资产周转率(次)", valueTreeMap11);
    	
    	treeMap4.put("营业收入(同比增长率)(%)", valueTreeMap12);
    	treeMap4.put("营业利润 (同比增长率)(%)", valueTreeMap13);
    	treeMap4.put("利润总额(同比增长率)(%)", valueTreeMap14);
    	treeMap4.put("资产总计(相对年初增长率)(%)", valueTreeMap15);
    	treeMap4.put("归属母公司股东的权益(相对年初增长率)(%)", valueTreeMap16);
    	
    	
    	TimeSeriesChart timeSeriesChart1 = new TimeSeriesChart(title+"-盈利能力", "增长率", "年份", treeMap1);
    	TimeSeriesChart timeSeriesChart2 = new TimeSeriesChart(title+"-偿债能力", "增长率", "年份", treeMap2);
    	TimeSeriesChart timeSeriesChart3 = new TimeSeriesChart(title+"-营运能力", "增长率", "年份", treeMap3);
    	TimeSeriesChart timeSeriesChart4 = new TimeSeriesChart(title+"-成长能力", "增长率", "年份", treeMap4);
    	createChartFile(timeSeriesChart1.getChart(),filePath,827,472);
    	createChartFile(timeSeriesChart2.getChart(),filePath,827,472);
    	createChartFile(timeSeriesChart3.getChart(),filePath,827,472);
    	createChartFile(timeSeriesChart4.getChart(),filePath,827,472);
    }
    
    /**
     * 被评估公司营业收入折线图
     * 
     * @param proCode
     * @param filePath
     * @return
     * @throws Exception 
     */
    private void  getComInfoRatiosAvePicture(String proCode,String filePath,ComInfo comInfo) throws Exception{
    	String jsonRatios = comInfo.getJsonRatios();
    	List<Ratios> list =  JSONArray.parseArray(jsonRatios, Ratios.class);
    	if(CollectionUtils.isEmpty(list)){
    		throw new BusinessException("没有获取到项目编码["+proCode+"]的被评估公司近5年财务比率指标信息");
    	}
    	TreeMap<String, TreeMap<Integer,Double>> treeMap1 = new TreeMap<String, TreeMap<Integer,Double>>();
    	TreeMap<String, TreeMap<Integer,Double>> treeMap2 = new TreeMap<String, TreeMap<Integer,Double>>();
    	TreeMap<String, TreeMap<Integer,Double>> treeMap3 = new TreeMap<String, TreeMap<Integer,Double>>();
    	TreeMap<String, TreeMap<Integer,Double>> treeMap4 = new TreeMap<String, TreeMap<Integer,Double>>();
    	
    	TreeMap<Integer,Double> valueTreeMap1 = new TreeMap<Integer,Double>();
    	TreeMap<Integer,Double> valueTreeMap2= new TreeMap<Integer,Double>();
    	TreeMap<Integer,Double> valueTreeMap3 = new TreeMap<Integer,Double>();
    	TreeMap<Integer,Double> valueTreeMap5 = new TreeMap<Integer,Double>();
    	TreeMap<Integer,Double> valueTreeMap6 = new TreeMap<Integer,Double>();
    	TreeMap<Integer,Double> valueTreeMap7 = new TreeMap<Integer,Double>();
    	TreeMap<Integer,Double> valueTreeMap8 = new TreeMap<Integer,Double>();
    	TreeMap<Integer,Double> valueTreeMap9 = new TreeMap<Integer,Double>();
    	TreeMap<Integer,Double> valueTreeMap10 = new TreeMap<Integer,Double>();
    	TreeMap<Integer,Double> valueTreeMap11 = new TreeMap<Integer,Double>();
    	TreeMap<Integer,Double> valueTreeMap12 = new TreeMap<Integer,Double>();
    	TreeMap<Integer,Double> valueTreeMap13 = new TreeMap<Integer,Double>();
    	TreeMap<Integer,Double> valueTreeMap14 = new TreeMap<Integer,Double>();
    	TreeMap<Integer,Double> valueTreeMap15 = new TreeMap<Integer,Double>();
    	for(int i=0;i<list.size();i++){
    		Ratios ratios = list.get(i);
    		String year = ratios.getR3().substring(0, 4);
    		valueTreeMap1.put(Integer.valueOf(year), ratios.getR7());
    		valueTreeMap2.put(Integer.valueOf(year), ratios.getR8());
    		valueTreeMap3.put(Integer.valueOf(year), ratios.getR9());
    		valueTreeMap5.put(Integer.valueOf(year), ratios.getR19());
    		valueTreeMap6.put(Integer.valueOf(year), ratios.getR21());
    		valueTreeMap7.put(Integer.valueOf(year), ratios.getR22());
    		valueTreeMap8.put(Integer.valueOf(year), ratios.getR15());
    		valueTreeMap9.put(Integer.valueOf(year), ratios.getR14());
    		valueTreeMap10.put(Integer.valueOf(year), ratios.getR16());
    		valueTreeMap11.put(Integer.valueOf(year), ratios.getR13());
    		valueTreeMap12.put(Integer.valueOf(year), ratios.getR25());
    		valueTreeMap13.put(Integer.valueOf(year), ratios.getR26());
    		valueTreeMap14.put(Integer.valueOf(year), ratios.getR27());
    		valueTreeMap15.put(Integer.valueOf(year), ratios.getR28());
    	}
    	treeMap1.put("净资产收益率(%)", valueTreeMap1);
    	treeMap1.put("总资产报酬率(%)", valueTreeMap2);
    	treeMap1.put("销售(营业)利润率(%)", valueTreeMap3);
    	
    	treeMap2.put("资产负债率(%)", valueTreeMap5);
    	treeMap2.put("流动比率", valueTreeMap6);
    	treeMap2.put("速动比率", valueTreeMap7);
    	
    	treeMap3.put("存货周转率(次)", valueTreeMap8);
    	treeMap3.put("应收账款周转率(次)", valueTreeMap9);
    	treeMap3.put("流动资产周转率(次)", valueTreeMap10);
    	treeMap3.put("总资产周转率(次)", valueTreeMap11);
    	
    	treeMap4.put("销售(营业)增长率(%)", valueTreeMap12);
    	treeMap4.put("资本保值增值率(%)", valueTreeMap13);
    	treeMap4.put("销售(营业)利润增长率(%)", valueTreeMap14);
    	treeMap4.put("总资产增长率(%)", valueTreeMap15);
    	TimeSeriesChart timeSeriesChart1 = new TimeSeriesChart("8.7.5被评估公司近5年财务比率指标-盈利能力", "增长率（%）", "年份", treeMap1);
    	TimeSeriesChart timeSeriesChart2 = new TimeSeriesChart("8.7.5被评估公司近5年财务比率指标-偿债能力", "增长率（%）", "年份", treeMap2);
    	TimeSeriesChart timeSeriesChart3 = new TimeSeriesChart("8.7.5被评估公司近5年财务比率指标-营运能力", "增长率（%）", "年份", treeMap3);
    	TimeSeriesChart timeSeriesChart4 = new TimeSeriesChart("8.7.5被评估公司近5年财务比率指标-成长能力", "增长率（%）", "年份", treeMap4);
    	createChartFile(timeSeriesChart1.getChart(),filePath,827,472);
    	createChartFile(timeSeriesChart2.getChart(),filePath,827,472);
    	createChartFile(timeSeriesChart3.getChart(),filePath,827,472);
    	createChartFile(timeSeriesChart4.getChart(),filePath,827,472);
    }
    
    
    /**
     * 被评估公司营业收入增长率折线图5年
     * 
     * @param proCode
     * @param filePath
     * @return
     * @throws Exception 
     */
    private void  getComInfoRatiosPicture(String proCode,String filePath,ComInfo comInfo) throws Exception{
    	String jsonRatios = comInfo.getJsonRatios();
    	List<Ratios> list =  JSONArray.parseArray(jsonRatios, Ratios.class);
    	if(CollectionUtils.isEmpty(list)){
    		throw new BusinessException("没有获取到项目编码["+proCode+"]的被评估公司近5年财务比率指标信息");
    	}
    	TreeMap<String, TreeMap<Integer,Double>> treeMap = new TreeMap<String, TreeMap<Integer,Double>>();
    	TreeMap<Integer,Double> valueTreeMap = new TreeMap<Integer,Double>();
    	for(int i=0;i<list.size();i++){
    		Ratios ratio = list.get(i);
    		String year = ratio.getR3().substring(0, 4);
    		valueTreeMap.put(Integer.valueOf(year), ratio.getR25()); //百分比
    	}
    	treeMap.put("被评估公司营业收入增长率", valueTreeMap);
    	TimeSeriesChart timeSeriesChart = new TimeSeriesChart("8.7.3被评估公司近5年营业收入增长率", "增长率（%）", "年份", treeMap);
    	createChartFile(timeSeriesChart.getChart(),filePath,827,472);
    }
	
    /**
     * 被评估公司营业收入平均增长率折线图
     * 
     * @param proCode
     * @param filePath
     * @return
     * @throws Exception 
     */
    private void  getComInfoProductAvgPicture(String proCode,String filePath,ComInfo comInfo) throws Exception{
    	String jsonRatiosGrowthAve = comInfo.getJsonRatiosGrowthAve();
    	List<RatiosGrowthAve> list =  JSONArray.parseArray(jsonRatiosGrowthAve, RatiosGrowthAve.class);
    	if(CollectionUtils.isEmpty(list)){
    		throw new BusinessException("没有获取到项目编码["+proCode+"]的被评估公司近5年营业收入平均增长率信息");
    	}
 
    	String[] rowKeys={"营业收入平均增长率"};
    	String[] colKeys=new String[list.size()];
    	double[][] data=new double[1][list.size()];
    	for(int i=0;i<list.size();i++){
    		RatiosGrowthAve ratiosGrowthAve = list.get(i);
    		String year = ratiosGrowthAve.getR3();
    		colKeys[i]=year;
    		data[0][i]=ratiosGrowthAve.getR25();
    	}
    	LineChart lineChart=new LineChart("8.7.4近5年营业收入平均增长率数据", "增长率(%)", "几年平均数",rowKeys, colKeys, data);
    	createChartFile(lineChart.getChart(),filePath,827,472);
    }
    /**
     * 可比公司近5年营业收入平均增长率数据统计图
     * 
     * @param proCode
     * @param filePath
     * @return
     * @throws Exception 
     */
    private void  getIqInfoProductAvgPicture(String proCode,String filePath,IqInfo iqInfo,String title) throws Exception{
    	String JsonGrowthRateAve = iqInfo.getJsonGrowthRateAve();
    	List<IqGrowth> list =  JSONArray.parseArray(JsonGrowthRateAve, IqGrowth.class);
    	if(CollectionUtils.isEmpty(list)){
    		throw new BusinessException("没有获取到项目编码["+proCode+"]的可比上市公司近5年营业收入平均增长率信息");
    	}
    	String[] rowKeys={"营业收入平均增长率"};
    	String[] colKeys=new String[list.size()];
    	double[][] data=new double[1][list.size()];
    	for(int i=0;i<list.size();i++){
    		IqGrowth iqGrowth = list.get(i);
    		String year = iqGrowth.getR13();
    		colKeys[i]=year;
    		data[0][i]=iqGrowth.getR16();
    	}
    	LineChart lineChart=new LineChart("可比上市公司近5年营业收入平均增长率-近5年", "增长率(%)", "几年平均数",rowKeys, colKeys, data);
    	createChartFile(lineChart.getChart(),filePath,827,472);
    }
	
    /**
     * 可比公司近5年营业收入增长率数据统计图
     * 
     * @param proCode
     * @param filePath
     * @return
     * @throws Exception 
     */
    private void  getIqInfoProductPicture(String proCode,String filePath,IqInfo iqInfo,String title) throws Exception{
    	String jsonGrowthRate = iqInfo.getJsonGrowthRate();
    	List<IqGrowth> list =  JSONArray.parseArray(jsonGrowthRate, IqGrowth.class);
    	if(CollectionUtils.isEmpty(list)){
    		throw new BusinessException("没有获取到项目编码["+proCode+"]的可比公司近5年财务比率指标信息");
    	}
    	TreeMap<String, TreeMap<Integer,Double>> treeMap = new TreeMap<String, TreeMap<Integer,Double>>();
    	TreeMap<Integer,Double> valueTreeMap = new TreeMap<Integer,Double>();
    	for(int i=0;i<list.size();i++){
    		IqGrowth iqGrowth = list.get(i);
    		String year = iqGrowth.getR13().substring(0, 4);
    		valueTreeMap.put(Integer.valueOf(year), iqGrowth.getR16()); //百分比
    	}
    	treeMap.put("可比公司营业收入增长率", valueTreeMap);
    	TimeSeriesChart timeSeriesChart = new TimeSeriesChart(title, "增长率（%）", "年份", treeMap);
    	createChartFile(timeSeriesChart.getChart(),filePath,827,472);
    }
	
	
	
	/**
	 * 创建图表文件
	 * 
	 * @param chart
	 * @param outputPath
	 * @param weight
	 * @param height
	 * @throws Exception
	 */
	private  void createChartFile(JFreeChart chart, String filePath, int weight, int height)throws Exception {      
        	FileOutputStream out = null;      
            File outFile = new File(filePath);      
            if (!outFile.getParentFile().exists()) {      
                outFile.getParentFile().mkdirs();      
            }
            String dest = filePath + File.separator + chart.getTitle().getText()+".jpeg";
            out = new FileOutputStream(dest);      
            // 保存为PNG      
            //ChartUtilities.writeChartAsPNG(out,chart, weight, height);   
            // 保存为JPEG      
            //ChartUtilities.writeChartAsJPEG(out, chart, weight, height);
            ChartUtilities.writeChartAsJPEG(out, 1f, chart, weight, height);
            out.flush();      
            if (out != null) {      
                try {      
                    out.close();      
                } catch (IOException e) {      
                    // do nothing      
                }      

        }      
    }

	/**
	 * 
	 * @param bills
	 * @param cellVoList
	 * @return
	 */
	private List<com.kpap.common.util.XlsCellVo> getSummary(List<XlsCellVo> cellVoList) {
		String currenTime = DateUtil.getCurrentDateTimeAsInt();
        cellVoList.add(new XlsCellVo(0,0,currenTime));
    	return cellVoList;
    }

    /**
     * 被评估公司财务情况
     * 
     * @param proCode
     * @param cellVoList
     * @param beginRow
     * @return
     */
    private int getComFinaInfo(String proCode, List<XlsCellVo> cellVoList,int beginRow,Com com){
    	ComInfoExample comInfoExample = new ComInfoExample();
    	comInfoExample.createCriteria().andProCodeEqualTo(proCode);
    	List<ComInfo>  comInfoList =  comInfoMapper.selectByExample(comInfoExample);
    	if(CollectionUtils.isEmpty(comInfoList)){
    		throw new BusinessException("没有获取到项目编码["+proCode+"]的被评估公司财务信息");
    	}
    	ComInfo comInfo = comInfoList.get(0);
    	
    	// 历史年度财务状况表 
    	String title = "8.7.1历史年度财务状况表";
    	beginRow = getComInfoHistoryFinaInfo(proCode,cellVoList,beginRow,comInfo,title);
    	// 历史年度经营状况表 
    	title = "8.7.2历史年度经营状况表";
    	beginRow = getComInfoHistoryProfitInfo(proCode,cellVoList,beginRow,comInfo,title);
    	// 被评估公司近5年营业收入增长率数据
    	title = "8.7.3"+com.getName()+"近5年营业收入增长率数据如下";
    	beginRow = getComInfoProductInfo(proCode,cellVoList,beginRow,comInfo,title);
    	// 被评估公司近5年营业收入平均增长率数据
    	title = "8.7.4"+com.getName()+"近5年营业收入平均增长率数据如下";
    	beginRow = getComInfoProductAveInfo(proCode,cellVoList,beginRow,comInfo,title);
    	// 公司近5年财务比率指标
    	title = "8.7.5"+com.getName()+"近5年财务比率指标如下";
    	beginRow = getComInfoRatiosInfo(proCode,cellVoList,beginRow,comInfo,title);
    	return beginRow;
    }
    
    /**
     * 被评估公司近5年营业收入增长率数据
     * 
     * @param proCode
     * @param cellVoList
     * @param beginRow
     * @return
     */
    private int  getComInfoProductInfo(String proCode, List<XlsCellVo> cellVoList,int beginRow,ComInfo comInfo,String title){
    	int beginCollumn = 0;
    	beginRow = beginRow+2;
    	cellVoList.add(new XlsCellVo(beginRow,beginCollumn,title,XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    	String jsonRatios = comInfo.getJsonRatios();
    	List<Ratios> list =  JSONArray.parseArray(jsonRatios, Ratios.class);
    	if(CollectionUtils.isEmpty(list)){
    		throw new BusinessException("没有获取到项目编码["+proCode+"]的被评估公司近5年财务比率指标信息");
    	}
    	ReportExportTitleHandler.getComInfoProductAveCollumnTitle(cellVoList,beginRow,beginCollumn);
    	for(int i=0;i<list.size();i++){
    		 Ratios ratios = list.get(i);
    		 beginCollumn ++ ;
    		 cellVoList.add(new XlsCellVo(beginRow+1,beginCollumn,ratios.getR3(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+2,beginCollumn,ratios.getR4() ,XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+3,beginCollumn,ratios.getR25(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//
    	}
    	beginRow = beginRow+3;
    	return beginRow;
    }
    
    /**
     * 被评估公司近5年财务比率指标
     * 
     * @param proCode
     * @param cellVoList
     * @param beginRow
     * @return
     */
    private int  getComInfoRatiosInfo(String proCode, List<XlsCellVo> cellVoList,int beginRow,ComInfo comInfo,String title){
    	int beginCollumn = 0;
    	beginRow = beginRow+2;
    	cellVoList.add(new XlsCellVo(beginRow,beginCollumn,"被评估单位历史年度经营状况表 ",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    	String jsonRatios = comInfo.getJsonRatios();
    	List<Ratios> list =  JSONArray.parseArray(jsonRatios, Ratios.class);
    	if(CollectionUtils.isEmpty(list)){
    		throw new BusinessException("没有获取到项目编码["+proCode+"]的被评估公司近5年财务比率指标信息");
    	}
    	ReportExportTitleHandler.getComInfoRationsCollumnTitle(cellVoList,beginRow,beginCollumn);
    	for(int i=0;i<list.size();i++){
    		 Ratios ratios = list.get(i);
    		 beginCollumn ++ ;
    		 cellVoList.add(new XlsCellVo(beginRow+1,beginCollumn,ratios.getR3(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+2,beginCollumn,ratios.getR4() ,XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+3,beginCollumn,"",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+4,beginCollumn,ratios.getR7(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));//一、营业总收入
    		 cellVoList.add(new XlsCellVo(beginRow+5,beginCollumn,ratios.getR8(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//营业收入
    		 cellVoList.add(new XlsCellVo(beginRow+6,beginCollumn,ratios.getR9(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //利息收入
    		 cellVoList.add(new XlsCellVo(beginRow+7,beginCollumn,ratios.getR10(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //已赚保费
    		 cellVoList.add(new XlsCellVo(beginRow+8,beginCollumn,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //手续费及佣金收入TODO
    		 cellVoList.add(new XlsCellVo(beginRow+9,beginCollumn,ratios.getR13(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));//二、营业总成本 TODO
    		 cellVoList.add(new XlsCellVo(beginRow+10,beginCollumn,ratios.getR14(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //营业成本
    		 cellVoList.add(new XlsCellVo(beginRow+11,beginCollumn,ratios.getR15(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//利息支出
    		 cellVoList.add(new XlsCellVo(beginRow+12,beginCollumn,ratios.getR16(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //手续费及佣金支出 TODO
    		 cellVoList.add(new XlsCellVo(beginRow+13,beginCollumn,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //退保金
    		 cellVoList.add(new XlsCellVo(beginRow+14,beginCollumn,ratios.getR19(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //赔付支出净额
    		 cellVoList.add(new XlsCellVo(beginRow+15,beginCollumn,ratios.getR20(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //提取保险合同准备金净额
    		 cellVoList.add(new XlsCellVo(beginRow+16,beginCollumn,ratios.getR21(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //保单红利支出
    		 cellVoList.add(new XlsCellVo(beginRow+17,beginCollumn,ratios.getR22(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //分保费用
    		 cellVoList.add(new XlsCellVo(beginRow+18,beginCollumn,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //营业税金及附加
    		 cellVoList.add(new XlsCellVo(beginRow+19,beginCollumn,ratios.getR25(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //销售费用
    		 cellVoList.add(new XlsCellVo(beginRow+20,beginCollumn,ratios.getR26(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //管理费用
    		 cellVoList.add(new XlsCellVo(beginRow+21,beginCollumn,ratios.getR27(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //财务费用
    		 cellVoList.add(new XlsCellVo(beginRow+22,beginCollumn,ratios.getR28(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //资产减值损失
    	}
    	beginRow = beginRow+22;
    	return beginRow;
    }
    
    
    /**
     * 被评估公司近5年营业收入平均增长率数据
     * 
     * @param proCode
     * @param cellVoList
     * @param beginRow
     * @return
     */
    private int  getComInfoProductAveInfo(String proCode, List<XlsCellVo> cellVoList,int beginRow,ComInfo comInfo,String title){
    	int beginCollumn = 0;
    	beginRow = beginRow+2;
    	cellVoList.add(new XlsCellVo(beginRow,beginCollumn,title,XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    	String jsonRatiosGrowthAve = comInfo.getJsonRatiosGrowthAve();
    	List<RatiosGrowthAve> list =  JSONArray.parseArray(jsonRatiosGrowthAve, RatiosGrowthAve.class);
    	if(CollectionUtils.isEmpty(list)){
    		throw new BusinessException("没有获取到项目编码["+proCode+"]的被评估公司近5年营业收入平均增长率信息");
    	}
    	ReportExportTitleHandler.getComInfoProductAveCollumnTitle(cellVoList,beginRow,beginCollumn);
    	for(int i=0;i<list.size();i++){
    		 RatiosGrowthAve avg = list.get(i);
    		 beginCollumn ++ ;
    		 cellVoList.add(new XlsCellVo(beginRow+1,beginCollumn,avg.getR3(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+2,beginCollumn,avg.getR4(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+3,beginCollumn,avg.getR25(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//
    	}
    	beginRow = beginRow+3;
    	return beginRow;
    }
    
    /**
     * 被评估单位历史年度经营状况表 
     * 
     * @param proCode
     * @param cellVoList
     * @param beginRow
     * @return
     */
    private int  getComInfoHistoryProfitInfo(String proCode, List<XlsCellVo> cellVoList,int beginRow,ComInfo comInfo,String title){
    	int beginCollumn = 0;
    	beginRow = beginRow+2;
    	cellVoList.add(new XlsCellVo(beginRow,beginCollumn,title,XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    	String jsonProfit = comInfo.getJsonProfit();
    	List<Profit> list =  JSONArray.parseArray(jsonProfit, Profit.class);
    	if(CollectionUtils.isEmpty(list)){
    		throw new BusinessException("没有获取到项目编码["+proCode+"]的被评估单位历史年度经营状况信息");
    	}
    	ReportExportTitleHandler.getcomInfoFinaCollumnTitle(cellVoList,beginRow,beginCollumn);
    	for(int i=0;i<list.size();i++){
    		 Profit profit = list.get(i);
    		 beginCollumn ++ ;
    		 cellVoList.add(new XlsCellVo(beginRow+1,beginCollumn,profit.getR11(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+2,beginCollumn,profit.getR12(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+3,beginCollumn,"",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));//"利润表(原始货币, 万元)"
    		 cellVoList.add(new XlsCellVo(beginRow+4,beginCollumn,profit.getR15(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));//一、营业总收入
    		 cellVoList.add(new XlsCellVo(beginRow+5,beginCollumn,profit.getR16(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//营业收入
    		 cellVoList.add(new XlsCellVo(beginRow+6,beginCollumn,profit.getR17(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //利息收入
    		 cellVoList.add(new XlsCellVo(beginRow+7,beginCollumn,profit.getR18(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //已赚保费
    		 cellVoList.add(new XlsCellVo(beginRow+8,beginCollumn,profit.getR19(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //手续费及佣金收入TODO
    		 cellVoList.add(new XlsCellVo(beginRow+9,beginCollumn,profit.getR20(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));//二、营业总成本 TODO
    		 cellVoList.add(new XlsCellVo(beginRow+10,beginCollumn,profit.getR21(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //营业成本
    		 cellVoList.add(new XlsCellVo(beginRow+11,beginCollumn,profit.getR22(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//利息支出
    		 cellVoList.add(new XlsCellVo(beginRow+12,beginCollumn,profit.getR23(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //手续费及佣金支出 TODO
    		 cellVoList.add(new XlsCellVo(beginRow+13,beginCollumn,profit.getR24(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //退保金
    		 cellVoList.add(new XlsCellVo(beginRow+14,beginCollumn,profit.getR25(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //赔付支出净额
    		 cellVoList.add(new XlsCellVo(beginRow+15,beginCollumn,profit.getR26(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //提取保险合同准备金净额
    		 cellVoList.add(new XlsCellVo(beginRow+16,beginCollumn,profit.getR27(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //保单红利支出
    		 cellVoList.add(new XlsCellVo(beginRow+17,beginCollumn,profit.getR28(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //分保费用
    		 cellVoList.add(new XlsCellVo(beginRow+18,beginCollumn,profit.getR29(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //营业税金及附加
    		 cellVoList.add(new XlsCellVo(beginRow+19,beginCollumn,profit.getR30(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //销售费用
    		 cellVoList.add(new XlsCellVo(beginRow+20,beginCollumn,profit.getR31(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //管理费用
    		 cellVoList.add(new XlsCellVo(beginRow+21,beginCollumn,profit.getR32(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //财务费用
    		 cellVoList.add(new XlsCellVo(beginRow+22,beginCollumn,profit.getR33(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //资产减值损失
    		 cellVoList.add(new XlsCellVo(beginRow+23,beginCollumn,profit.getR34(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));//三、其他经营收益
    		 cellVoList.add(new XlsCellVo(beginRow+24,beginCollumn,profit.getR35(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //公允价值变动净收益
    		 cellVoList.add(new XlsCellVo(beginRow+25,beginCollumn,profit.getR36(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT)); //投资净收益
    		 cellVoList.add(new XlsCellVo(beginRow+26,beginCollumn,profit.getR37(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT)); //非流动资产：
    		 cellVoList.add(new XlsCellVo(beginRow+27,beginCollumn,profit.getR38(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //汇兑净收益
    		 cellVoList.add(new XlsCellVo(beginRow+28,beginCollumn,profit.getR39(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：营业利润差额(特殊报表科目)
    		 cellVoList.add(new XlsCellVo(beginRow+29,beginCollumn,profit.getR40(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：营业利润差额(合计平衡项目)
    		 cellVoList.add(new XlsCellVo(beginRow+30,beginCollumn,profit.getR41(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//四、营业利润
    		 cellVoList.add(new XlsCellVo(beginRow+31,beginCollumn,profit.getR42(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：营业外收入
    		 cellVoList.add(new XlsCellVo(beginRow+32,beginCollumn,profit.getR43(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//减：营业外支出
    		 cellVoList.add(new XlsCellVo(beginRow+33,beginCollumn,profit.getR44(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//其中：非流动资产处置净损失
    		 cellVoList.add(new XlsCellVo(beginRow+34,beginCollumn,profit.getR45(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：利润总额差额(特殊报表科目)
    		 cellVoList.add(new XlsCellVo(beginRow+35,beginCollumn,profit.getR46(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：利润总额差额(合计平衡项目)
    		 cellVoList.add(new XlsCellVo(beginRow+36,beginCollumn,profit.getR47(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//五、利润总额
    		 cellVoList.add(new XlsCellVo(beginRow+37,beginCollumn,profit.getR48(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//减：所得税
    		 cellVoList.add(new XlsCellVo(beginRow+38,beginCollumn,profit.getR49(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：未确认的投资损失
    		 cellVoList.add(new XlsCellVo(beginRow+39,beginCollumn,profit.getR50(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：净利润差额(特殊报表科目)
    		 cellVoList.add(new XlsCellVo(beginRow+40,beginCollumn,profit.getR51(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：净利润差额(合计平衡项目)
    		 cellVoList.add(new XlsCellVo(beginRow+41,beginCollumn,profit.getR52(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//六、净利润
    		 cellVoList.add(new XlsCellVo(beginRow+42,beginCollumn,profit.getR53(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //减：少数股东损益
    		 cellVoList.add(new XlsCellVo(beginRow+43,beginCollumn,profit.getR54(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//归属于母公司所有者的净利润
    		 cellVoList.add(new XlsCellVo(beginRow+44,beginCollumn,profit.getR55(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：其他综合收益
    		 cellVoList.add(new XlsCellVo(beginRow+45,beginCollumn,profit.getR56(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//七、综合收益总额
    		 cellVoList.add(new XlsCellVo(beginRow+46,beginCollumn,profit.getR57(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//减：归属于少数股东的综合收益总额
    		 cellVoList.add(new XlsCellVo(beginRow+47,beginCollumn,profit.getR58(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//归属于母公司普通股东综合收益总额
    		 cellVoList.add(new XlsCellVo(beginRow+48,beginCollumn,profit.getR59(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));//八、每股收益
    		 cellVoList.add(new XlsCellVo(beginRow+49,beginCollumn,profit.getR60(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//(一) 基本每股收益(元)
    		 cellVoList.add(new XlsCellVo(beginRow+50,beginCollumn,profit.getR61(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//(二) 稀释每股收益(元)
    	}
    	beginRow = beginRow+51;
    	return beginRow;
    }
    
    
    /**
     * 被评估单位历史年度财务状况表 
     * 
     * @param proCode
     * @param cellVoList
     * @param beginRow
     * @return
     */
    private int  getComInfoHistoryFinaInfo(String proCode, List<XlsCellVo> cellVoList,int beginRow,ComInfo comInfo,String title){
    	int beginCollumn = 0;
    	cellVoList.add(new XlsCellVo(beginRow,beginCollumn,title,XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    	String jsonBalance = comInfo.getJsonBalance();
    	List<Balance> list =  JSONArray.parseArray(jsonBalance, Balance.class);
    	if(CollectionUtils.isEmpty(list)){
    		throw new BusinessException("没有获取到项目编码["+proCode+"]的被评估单位历史年度财务状况信息");
    	}
    	ReportExportTitleHandler.getComInfoFinaCollumnTitle(cellVoList,beginRow,beginCollumn);
    	for(int i=0;i<list.size();i++){
    		 Balance balance = list.get(i);
    		 beginCollumn ++ ;
    		 cellVoList.add(new XlsCellVo(beginRow+1,beginCollumn,balance.getR10(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+2,beginCollumn,balance.getR11() ,XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+3,beginCollumn,"",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));//"利润表(原始货币, 万元)"
    		 cellVoList.add(new XlsCellVo(beginRow+4,beginCollumn,balance.getR15(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));//一、营业总收入
    		 cellVoList.add(new XlsCellVo(beginRow+5,beginCollumn,balance.getR16(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//营业收入
    		 cellVoList.add(new XlsCellVo(beginRow+6,beginCollumn,balance.getR17(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //利息收入
    		 cellVoList.add(new XlsCellVo(beginRow+7,beginCollumn,balance.getR18(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //已赚保费
    		 cellVoList.add(new XlsCellVo(beginRow+8,beginCollumn,balance.getR19(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //手续费及佣金收入TODO
    		 cellVoList.add(new XlsCellVo(beginRow+9,beginCollumn,balance.getR20(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));//二、营业总成本 TODO
    		 cellVoList.add(new XlsCellVo(beginRow+10,beginCollumn,balance.getR21(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //营业成本
    		 cellVoList.add(new XlsCellVo(beginRow+11,beginCollumn,balance.getR22(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//利息支出
    		 cellVoList.add(new XlsCellVo(beginRow+12,beginCollumn,balance.getR23(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //手续费及佣金支出 TODO
    		 cellVoList.add(new XlsCellVo(beginRow+13,beginCollumn,balance.getR24(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //退保金
    		 cellVoList.add(new XlsCellVo(beginRow+14,beginCollumn,balance.getR25(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //赔付支出净额
    		 cellVoList.add(new XlsCellVo(beginRow+15,beginCollumn,balance.getR26(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //提取保险合同准备金净额
    		 cellVoList.add(new XlsCellVo(beginRow+16,beginCollumn,balance.getR27(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //保单红利支出
    		 cellVoList.add(new XlsCellVo(beginRow+17,beginCollumn,balance.getR28(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //分保费用
    		 cellVoList.add(new XlsCellVo(beginRow+18,beginCollumn,balance.getR29(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //营业税金及附加
    		 cellVoList.add(new XlsCellVo(beginRow+19,beginCollumn,balance.getR30(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //销售费用
    		 cellVoList.add(new XlsCellVo(beginRow+20,beginCollumn,balance.getR31(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //管理费用
    		 cellVoList.add(new XlsCellVo(beginRow+21,beginCollumn,balance.getR32(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //财务费用
    		 cellVoList.add(new XlsCellVo(beginRow+22,beginCollumn,balance.getR33(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //资产减值损失
    		 cellVoList.add(new XlsCellVo(beginRow+23,beginCollumn,balance.getR34(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));//三、其他经营收益
    		 cellVoList.add(new XlsCellVo(beginRow+24,beginCollumn,balance.getR35(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //公允价值变动净收益
    		 cellVoList.add(new XlsCellVo(beginRow+25,beginCollumn,balance.getR36(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT)); //投资净收益
    		 cellVoList.add(new XlsCellVo(beginRow+26,beginCollumn,"",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT)); //非流动资产：
    		 cellVoList.add(new XlsCellVo(beginRow+27,beginCollumn,balance.getR38(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //汇兑净收益
    		 cellVoList.add(new XlsCellVo(beginRow+28,beginCollumn,balance.getR39(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：营业利润差额(特殊报表科目)
    		 cellVoList.add(new XlsCellVo(beginRow+29,beginCollumn,balance.getR40(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：营业利润差额(合计平衡项目)
    		 cellVoList.add(new XlsCellVo(beginRow+30,beginCollumn,balance.getR41(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//四、营业利润
    		 cellVoList.add(new XlsCellVo(beginRow+31,beginCollumn,balance.getR42(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：营业外收入
    		 cellVoList.add(new XlsCellVo(beginRow+32,beginCollumn,balance.getR43(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//减：营业外支出
    		 cellVoList.add(new XlsCellVo(beginRow+33,beginCollumn,balance.getR44(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//其中：非流动资产处置净损失
    		 cellVoList.add(new XlsCellVo(beginRow+34,beginCollumn,balance.getR45(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：利润总额差额(特殊报表科目)
    		 cellVoList.add(new XlsCellVo(beginRow+35,beginCollumn,balance.getR46(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：利润总额差额(合计平衡项目)
    		 cellVoList.add(new XlsCellVo(beginRow+36,beginCollumn,balance.getR47(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//五、利润总额
    		 cellVoList.add(new XlsCellVo(beginRow+37,beginCollumn,balance.getR48(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//减：所得税
    		 cellVoList.add(new XlsCellVo(beginRow+38,beginCollumn,balance.getR49(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：未确认的投资损失
    		 cellVoList.add(new XlsCellVo(beginRow+39,beginCollumn,balance.getR50(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：净利润差额(特殊报表科目)
    		 cellVoList.add(new XlsCellVo(beginRow+40,beginCollumn,balance.getR51(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：净利润差额(合计平衡项目)
    		 cellVoList.add(new XlsCellVo(beginRow+41,beginCollumn,balance.getR52(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//六、净利润
    		 cellVoList.add(new XlsCellVo(beginRow+42,beginCollumn,balance.getR53(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //减：少数股东损益
    		 cellVoList.add(new XlsCellVo(beginRow+43,beginCollumn,balance.getR54(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//归属于母公司所有者的净利润
    		 cellVoList.add(new XlsCellVo(beginRow+44,beginCollumn,balance.getR55(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：其他综合收益
    		 cellVoList.add(new XlsCellVo(beginRow+45,beginCollumn,balance.getR56(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//七、综合收益总额
    		 cellVoList.add(new XlsCellVo(beginRow+46,beginCollumn,balance.getR57(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//减：归属于少数股东的综合收益总额
    		 cellVoList.add(new XlsCellVo(beginRow+47,beginCollumn,balance.getR58(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//归属于母公司普通股东综合收益总额
    		 cellVoList.add(new XlsCellVo(beginRow+48,beginCollumn,balance.getR59(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));//八、每股收益
    		 cellVoList.add(new XlsCellVo(beginRow+49,beginCollumn,balance.getR60(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//(一) 基本每股收益(元)
    		 cellVoList.add(new XlsCellVo(beginRow+50,beginCollumn,balance.getR61(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//(二) 稀释每股收益(元)
    		 cellVoList.add(new XlsCellVo(beginRow+51,beginCollumn,balance.getR61(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+52,beginCollumn,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//流动负债：
    		 cellVoList.add(new XlsCellVo(beginRow+53,beginCollumn,balance.getR63(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+54,beginCollumn,balance.getR64(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+55,beginCollumn,balance.getR65(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+56,beginCollumn,balance.getR66(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+57,beginCollumn,balance.getR67(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+58,beginCollumn,balance.getR68(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+59,beginCollumn,balance.getR69(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+60,beginCollumn,balance.getR70(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+61,beginCollumn,balance.getR71(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+62,beginCollumn,balance.getR72(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+63,beginCollumn,balance.getR73(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+64,beginCollumn,balance.getR74(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+65,beginCollumn,balance.getR75(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+66,beginCollumn,balance.getR76(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+67,beginCollumn,balance.getR77(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+68,beginCollumn,balance.getR78(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+69,beginCollumn,balance.getR79(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+70,beginCollumn,balance.getR80(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+71,beginCollumn,balance.getR81(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+72,beginCollumn,balance.getR82(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+73,beginCollumn,balance.getR83(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+74,beginCollumn,balance.getR84(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+75,beginCollumn,balance.getR85(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+76,beginCollumn,balance.getR86(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+77,beginCollumn,balance.getR87(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+78,beginCollumn,balance.getR88(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+79,beginCollumn,balance.getR89(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+80,beginCollumn,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+81,beginCollumn,balance.getR91(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+82,beginCollumn,balance.getR92(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+83,beginCollumn,balance.getR93(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+84,beginCollumn,balance.getR94(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+85,beginCollumn,balance.getR95(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+86,beginCollumn,balance.getR96(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+87,beginCollumn,balance.getR97(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+88,beginCollumn,balance.getR98(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+89,beginCollumn,balance.getR99(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+90,beginCollumn,balance.getR100(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+91,beginCollumn,balance.getR101(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+92,beginCollumn,balance.getR102(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+93,beginCollumn,balance.getR103(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+94,beginCollumn,balance.getR104(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+95,beginCollumn,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+96,beginCollumn,balance.getR106(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+97,beginCollumn,balance.getR107(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+98,beginCollumn,balance.getR108(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+99,beginCollumn,balance.getR109(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+100,beginCollumn,balance.getR110(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+101,beginCollumn,balance.getR111(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+102,beginCollumn,balance.getR112(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+103,beginCollumn,balance.getR113(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+104,beginCollumn,balance.getR114(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+105,beginCollumn,balance.getR115(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+106,beginCollumn,balance.getR116(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+107,beginCollumn,balance.getR117(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+108,beginCollumn,balance.getR118(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+109,beginCollumn,balance.getR119(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+110,beginCollumn,balance.getR120(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+111,beginCollumn,balance.getR121(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+112,beginCollumn,balance.getR122(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    	}
    	beginRow = beginRow+112;
    	return beginRow;
    }
    
    
    /**
     * 可比公司财务状况
     * 
     * @param proCode
     * @param cellVoList
     * @param beginRow
     * @return
     */
    private int getIqFinaInfo(String proCode, List<XlsCellVo> cellVoList,int beginRow,
    		String incomeTitle,String incomeAveTitle,String iqInfoTitle,String iqInfoProductAveTitle,String iqInfoRatiosTitle){
    	IqInfoExample iqInfoExample = new IqInfoExample();
    	iqInfoExample.createCriteria().andProCodeEqualTo(proCode);
    	List<IqInfo> iqInfoList = iqInfoMapper.selectByExample(iqInfoExample);
    	if(CollectionUtils.isEmpty(iqInfoList)){
    		throw new BusinessException("没有获取到项目编码["+proCode+"]的可比上市公司财务信息");
    	}
    	IqInfo inInfo = iqInfoList.get(0);
    	// 利润总计
        beginRow = getIqFinaIncomeInfo(proCode, cellVoList,beginRow,inInfo,incomeTitle);
    	// 利润平均值 
        beginRow = getIqFinaIncomeAveInfo(proCode, cellVoList,beginRow,inInfo,incomeAveTitle);
    	//可比上市公司近5年营业收入增长率数据
    	beginRow = getIqInfoProductInfo(proCode,cellVoList,beginRow,inInfo,iqInfoTitle);
    	// 可比上市公司近5年营业收入平均增长率数据如下
    	beginRow = getIqInfoProductAveInfo(proCode,cellVoList,beginRow,inInfo,iqInfoProductAveTitle);
    	// 可比上市公司近5年财务比率指标如下 
    	beginRow = getIqInfoRatiosInfo(proCode,cellVoList,beginRow,inInfo,iqInfoRatiosTitle);
    	return beginRow;
    }
    
    /**
     * 可比公司财务利润合计情况
     * 
     * @param proCode
     * @param cellVoList
     * @param beginRow
     * @return
     */
    private int  getIqFinaIncomeAveInfo(String proCode, List<XlsCellVo> cellVoList,int beginRow,IqInfo inInfo,String title){
    	int beginCollumn = 0;
    	beginRow = beginRow+2;
    	cellVoList.add(new XlsCellVo(beginRow,beginCollumn,title,XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    	String json_income = inInfo.getJsonIncomeAve();
    	List<IncomeAve> incomeList =  JSONArray.parseArray(json_income, IncomeAve.class);
    	if(CollectionUtils.isEmpty(incomeList)){
    		throw new BusinessException("没有获取到项目编码["+proCode+"]的可比上市公司财务利润信息");
    	}
    	ReportExportTitleHandler.getiqInfoFinaCollumnTitle(cellVoList,beginRow,beginCollumn);
    	for(int i=0;i<incomeList.size();i++){
    		 IncomeAve iqcome = incomeList.get(i);
    		 beginCollumn ++ ;
    		 cellVoList.add(new XlsCellVo(beginRow+1,beginCollumn,iqcome.getR13(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+2,beginCollumn,Const.InComeYearNameCost.valueOf_1(iqcome.getR14()).getDesc() ,XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+3,beginCollumn,"",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));//"利润表(原始货币, 万元)"
    		 cellVoList.add(new XlsCellVo(beginRow+4,beginCollumn,iqcome.getR16(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));//一、营业总收入
    		 cellVoList.add(new XlsCellVo(beginRow+5,beginCollumn,iqcome.getR17(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//营业收入
    		 cellVoList.add(new XlsCellVo(beginRow+6,beginCollumn,iqcome.getR18(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //利息收入
    		 cellVoList.add(new XlsCellVo(beginRow+7,beginCollumn,iqcome.getR19(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //已赚保费
    		 cellVoList.add(new XlsCellVo(beginRow+8,beginCollumn,iqcome.getR20(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //手续费及佣金收入TODO
    		 cellVoList.add(new XlsCellVo(beginRow+9,beginCollumn,iqcome.getR21(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//二、营业总成本 
    		 cellVoList.add(new XlsCellVo(beginRow+10,beginCollumn,iqcome.getR22(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //营业成本
    		 cellVoList.add(new XlsCellVo(beginRow+11,beginCollumn,iqcome.getR23(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//利息支出
    		 cellVoList.add(new XlsCellVo(beginRow+12,beginCollumn,iqcome.getR25(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //手续费及佣金支出 TODO
    		 cellVoList.add(new XlsCellVo(beginRow+13,beginCollumn,iqcome.getR26(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //退保金
    		 cellVoList.add(new XlsCellVo(beginRow+14,beginCollumn,iqcome.getR27(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //赔付支出净额
    		 cellVoList.add(new XlsCellVo(beginRow+15,beginCollumn,iqcome.getR28(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //提取保险合同准备金净额
    		 cellVoList.add(new XlsCellVo(beginRow+16,beginCollumn,iqcome.getR29(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //保单红利支出
    		 cellVoList.add(new XlsCellVo(beginRow+17,beginCollumn,iqcome.getR31(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //分保费用
    		 cellVoList.add(new XlsCellVo(beginRow+18,beginCollumn,iqcome.getR32(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //营业税金及附加
    		 cellVoList.add(new XlsCellVo(beginRow+19,beginCollumn,iqcome.getR33(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //销售费用
    		 cellVoList.add(new XlsCellVo(beginRow+20,beginCollumn,iqcome.getR34(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //管理费用
    		 cellVoList.add(new XlsCellVo(beginRow+21,beginCollumn,iqcome.getR35(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //财务费用
    		 cellVoList.add(new XlsCellVo(beginRow+22,beginCollumn,iqcome.getR36(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //资产减值损失
    		 cellVoList.add(new XlsCellVo(beginRow+23,beginCollumn,iqcome.getR37(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//三、其他经营收益
    		 cellVoList.add(new XlsCellVo(beginRow+24,beginCollumn,iqcome.getR38(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //公允价值变动净收益
    		 cellVoList.add(new XlsCellVo(beginRow+25,beginCollumn,iqcome.getR39(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //投资净收益
    		 cellVoList.add(new XlsCellVo(beginRow+26,beginCollumn,iqcome.getR40(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //其中：对联营企业和合营企业的投资收益
    		 cellVoList.add(new XlsCellVo(beginRow+27,beginCollumn,iqcome.getR41(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //汇兑净收益
    		 cellVoList.add(new XlsCellVo(beginRow+28,beginCollumn,iqcome.getR43(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：营业利润差额(特殊报表科目)
    		 cellVoList.add(new XlsCellVo(beginRow+29,beginCollumn,iqcome.getR45(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：营业利润差额(合计平衡项目)
    		 cellVoList.add(new XlsCellVo(beginRow+30,beginCollumn,iqcome.getR46(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//四、营业利润
    		 cellVoList.add(new XlsCellVo(beginRow+31,beginCollumn,iqcome.getR47(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：营业外收入
    		 cellVoList.add(new XlsCellVo(beginRow+32,beginCollumn,iqcome.getR49(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//减：营业外支出
    		 cellVoList.add(new XlsCellVo(beginRow+33,beginCollumn,iqcome.getR50(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//其中：非流动资产处置净损失
    		 cellVoList.add(new XlsCellVo(beginRow+34,beginCollumn,iqcome.getR51(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：利润总额差额(特殊报表科目)
    		 cellVoList.add(new XlsCellVo(beginRow+35,beginCollumn,iqcome.getR52(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：利润总额差额(合计平衡项目)
    		 cellVoList.add(new XlsCellVo(beginRow+36,beginCollumn,iqcome.getR54(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//五、利润总额
    		 cellVoList.add(new XlsCellVo(beginRow+37,beginCollumn,iqcome.getR55(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//减：所得税
    		 cellVoList.add(new XlsCellVo(beginRow+38,beginCollumn,iqcome.getR56(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：未确认的投资损失
    		 cellVoList.add(new XlsCellVo(beginRow+39,beginCollumn,iqcome.getR57(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：净利润差额(特殊报表科目)
    		 cellVoList.add(new XlsCellVo(beginRow+40,beginCollumn,iqcome.getR58(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：净利润差额(合计平衡项目)
    		 cellVoList.add(new XlsCellVo(beginRow+41,beginCollumn,iqcome.getR59(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//六、净利润
    		 cellVoList.add(new XlsCellVo(beginRow+42,beginCollumn,iqcome.getR60(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //减：少数股东损益
    		 cellVoList.add(new XlsCellVo(beginRow+43,beginCollumn,iqcome.getR61(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//归属于母公司所有者的净利润
    		 cellVoList.add(new XlsCellVo(beginRow+44,beginCollumn,iqcome.getR62(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：其他综合收益
    		 cellVoList.add(new XlsCellVo(beginRow+45,beginCollumn,iqcome.getR63(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//七、综合收益总额
    		 cellVoList.add(new XlsCellVo(beginRow+46,beginCollumn,iqcome.getR64(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//减：归属于少数股东的综合收益总额
    		 cellVoList.add(new XlsCellVo(beginRow+47,beginCollumn,iqcome.getR66(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//归属于母公司普通股东综合收益总额
    		 cellVoList.add(new XlsCellVo(beginRow+48,beginCollumn,iqcome.getR67(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//八、每股收益
    		 cellVoList.add(new XlsCellVo(beginRow+49,beginCollumn,iqcome.getR69(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//(一) 基本每股收益(元)
    		 cellVoList.add(new XlsCellVo(beginRow+50,beginCollumn,iqcome.getR70(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//(二) 稀释每股收益(元) 
    		 cellVoList.add(new XlsCellVo(beginRow+51,beginCollumn,iqcome.getR71(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+52,beginCollumn,iqcome.getR73(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+53,beginCollumn,iqcome.getR74(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
       	 	
    	}
    	beginRow = beginRow+53;
    	return beginRow;
    }
    
    
    /**
     * 可比上市公司近5年财务比率指标如下 
     * 
     * @param proCode
     * @param cellVoList
     * @param beginRow
     * @return
     */
    private int  getIqInfoRatiosInfo(String proCode, List<XlsCellVo> cellVoList,int beginRow,IqInfo inInfo,String title){
    	int beginCollumn = 0;
    	beginRow = beginRow+2;
    	cellVoList.add(new XlsCellVo(beginRow,beginCollumn,title,XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    	String jsonRatios = inInfo.getJsonRatios();
    	List<IqRatiosAve> list =  JSONArray.parseArray(jsonRatios, IqRatiosAve.class);
    	if(CollectionUtils.isEmpty(list)){
    		throw new BusinessException("没有获取到项目编码["+proCode+"]的可比上市公司近5年财务比率标信息");
    	}
    	ReportExportTitleHandler.getIqInfoRationsCollumnTitle(cellVoList,beginRow,beginCollumn);
    	for(int i=0;i<list.size();i++){
    		 IqRatiosAve ratios = list.get(i);
    		 beginCollumn ++ ;
    		 cellVoList.add(new XlsCellVo(beginRow+1,beginCollumn,ratios.getR13(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+2,beginCollumn,Const.InComeYearNameCost.valueOf_1(ratios.getR14()).getDesc() ,XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+3,beginCollumn,ratios.getR16(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));//每股指标
    		 cellVoList.add(new XlsCellVo(beginRow+4,beginCollumn,ratios.getR17(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));//一、营业总收入
    		 cellVoList.add(new XlsCellVo(beginRow+5,beginCollumn,ratios.getR18(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//营业收入
    		 cellVoList.add(new XlsCellVo(beginRow+6,beginCollumn,ratios.getR19(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //利息收入
    		 cellVoList.add(new XlsCellVo(beginRow+7,beginCollumn,ratios.getR20(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //已赚保费
    		 cellVoList.add(new XlsCellVo(beginRow+8,beginCollumn,ratios.getR21(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //手续费及佣金收入TODO
    		 cellVoList.add(new XlsCellVo(beginRow+9,beginCollumn,ratios.getR22(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));//二、营业总成本 TODO
    		 cellVoList.add(new XlsCellVo(beginRow+10,beginCollumn,ratios.getR23(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //营业成本
    		 cellVoList.add(new XlsCellVo(beginRow+11,beginCollumn,ratios.getR24(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//利息支出
    		 cellVoList.add(new XlsCellVo(beginRow+12,beginCollumn,ratios.getR25(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //手续费及佣金支出 TODO
    		 cellVoList.add(new XlsCellVo(beginRow+13,beginCollumn,ratios.getR26(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //退保金
    		 cellVoList.add(new XlsCellVo(beginRow+14,beginCollumn,ratios.getR27(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //赔付支出净额
    		 cellVoList.add(new XlsCellVo(beginRow+15,beginCollumn,ratios.getR26(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //提取保险合同准备金净额
    		 cellVoList.add(new XlsCellVo(beginRow+16,beginCollumn,ratios.getR28(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //保单红利支出
    		 cellVoList.add(new XlsCellVo(beginRow+17,beginCollumn,ratios.getR29(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //分保费用
    		 cellVoList.add(new XlsCellVo(beginRow+18,beginCollumn,ratios.getR30(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //营业税金及附加
    		 cellVoList.add(new XlsCellVo(beginRow+19,beginCollumn,ratios.getR31(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //销售费用
    		 cellVoList.add(new XlsCellVo(beginRow+20,beginCollumn,ratios.getR35(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT)); //管理费用
    		 cellVoList.add(new XlsCellVo(beginRow+21,beginCollumn,ratios.getR36(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT)); //财务费用
    		 cellVoList.add(new XlsCellVo(beginRow+22,beginCollumn,ratios.getR37(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //资产减值损失
    		 cellVoList.add(new XlsCellVo(beginRow+23,beginCollumn,ratios.getR38(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));//三、其他经营收益
    		 cellVoList.add(new XlsCellVo(beginRow+24,beginCollumn,ratios.getR39(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //公允价值变动净收益
    		 cellVoList.add(new XlsCellVo(beginRow+25,beginCollumn,ratios.getR40(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT)); //投资净收益
    		 cellVoList.add(new XlsCellVo(beginRow+26,beginCollumn,ratios.getR41(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT)); //非流动资产：
    		 cellVoList.add(new XlsCellVo(beginRow+27,beginCollumn,ratios.getR42(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //汇兑净收益
    		 cellVoList.add(new XlsCellVo(beginRow+28,beginCollumn,ratios.getR43(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：营业利润差额(特殊报表科目)
    		 cellVoList.add(new XlsCellVo(beginRow+29,beginCollumn,ratios.getR44(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：营业利润差额(合计平衡项目)
    		 cellVoList.add(new XlsCellVo(beginRow+30,beginCollumn,ratios.getR45(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//四、营业利润
    		 cellVoList.add(new XlsCellVo(beginRow+31,beginCollumn,ratios.getR46(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：营业外收入
    		 cellVoList.add(new XlsCellVo(beginRow+32,beginCollumn,ratios.getR47(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//减：营业外支出
    		 cellVoList.add(new XlsCellVo(beginRow+33,beginCollumn,ratios.getR48(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//其中：非流动资产处置净损失
    		 cellVoList.add(new XlsCellVo(beginRow+34,beginCollumn,ratios.getR49(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：利润总额差额(特殊报表科目)
    		 cellVoList.add(new XlsCellVo(beginRow+35,beginCollumn,ratios.getR50(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：利润总额差额(合计平衡项目)
    		 cellVoList.add(new XlsCellVo(beginRow+36,beginCollumn,ratios.getR51(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//五、利润总额
    		 cellVoList.add(new XlsCellVo(beginRow+37,beginCollumn,ratios.getR52(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//减：所得税
    		 cellVoList.add(new XlsCellVo(beginRow+38,beginCollumn,ratios.getR53(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：未确认的投资损失
    		 cellVoList.add(new XlsCellVo(beginRow+39,beginCollumn,ratios.getR54(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：净利润差额(特殊报表科目)
    		 cellVoList.add(new XlsCellVo(beginRow+40,beginCollumn,ratios.getR55(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：净利润差额(合计平衡项目)
    		 cellVoList.add(new XlsCellVo(beginRow+41,beginCollumn,ratios.getR56(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//六、净利润
    		 cellVoList.add(new XlsCellVo(beginRow+42,beginCollumn,ratios.getR57(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //减：少数股东损益
    		 cellVoList.add(new XlsCellVo(beginRow+43,beginCollumn,ratios.getR58(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//归属于母公司所有者的净利润
    		 cellVoList.add(new XlsCellVo(beginRow+44,beginCollumn,ratios.getR60(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：其他综合收益
    		 cellVoList.add(new XlsCellVo(beginRow+45,beginCollumn,ratios.getR61(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//七、综合收益总额
    		 cellVoList.add(new XlsCellVo(beginRow+46,beginCollumn,ratios.getR62(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//减：归属于少数股东的综合收益总额
    		 cellVoList.add(new XlsCellVo(beginRow+47,beginCollumn,ratios.getR63(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//归属于母公司普通股东综合收益总额
    		 cellVoList.add(new XlsCellVo(beginRow+48,beginCollumn,ratios.getR64(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));//八、每股收益
    		 cellVoList.add(new XlsCellVo(beginRow+49,beginCollumn,ratios.getR65(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//(一) 基本每股收益(元)
    		 cellVoList.add(new XlsCellVo(beginRow+50,beginCollumn,ratios.getR69(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));//(二) 稀释每股收益(元)
    		 cellVoList.add(new XlsCellVo(beginRow+51,beginCollumn,ratios.getR70(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+52,beginCollumn,ratios.getR71(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//流动负债：
    		 cellVoList.add(new XlsCellVo(beginRow+53,beginCollumn,ratios.getR72(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+54,beginCollumn,ratios.getR73(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+55,beginCollumn,ratios.getR74(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+56,beginCollumn,ratios.getR75(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+57,beginCollumn,ratios.getR76(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+58,beginCollumn,ratios.getR77(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+59,beginCollumn,ratios.getR78(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+60,beginCollumn,ratios.getR79(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+61,beginCollumn,ratios.getR81(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+62,beginCollumn,ratios.getR82(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+63,beginCollumn,ratios.getR83(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+64,beginCollumn,ratios.getR84(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+65,beginCollumn,ratios.getR85(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+66,beginCollumn,ratios.getR86(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+67,beginCollumn,ratios.getR87(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+68,beginCollumn,ratios.getR88(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+69,beginCollumn,ratios.getR89(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+70,beginCollumn,ratios.getR90(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+71,beginCollumn,ratios.getR91(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+72,beginCollumn,ratios.getR92(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+73,beginCollumn,ratios.getR93(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+74,beginCollumn,ratios.getR94(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+75,beginCollumn,ratios.getR95(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+76,beginCollumn,ratios.getR96(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+77,beginCollumn,ratios.getR97(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+78,beginCollumn,ratios.getR101(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+79,beginCollumn,ratios.getR102(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+80,beginCollumn,ratios.getR103(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+81,beginCollumn,ratios.getR104(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+82,beginCollumn,ratios.getR105(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+83,beginCollumn,ratios.getR106(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+84,beginCollumn,ratios.getR107(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+85,beginCollumn,ratios.getR108(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+86,beginCollumn,ratios.getR109(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+87,beginCollumn,ratios.getR113(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+88,beginCollumn,ratios.getR114(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+89,beginCollumn,ratios.getR115(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+90,beginCollumn,ratios.getR116(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+91,beginCollumn,ratios.getR117(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+92,beginCollumn,ratios.getR121(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+93,beginCollumn,ratios.getR122(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+94,beginCollumn,ratios.getR123(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+95,beginCollumn,ratios.getR124(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+96,beginCollumn,ratios.getR125(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+97,beginCollumn,ratios.getR126(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+98,beginCollumn,ratios.getR127(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+99,beginCollumn,ratios.getR128(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+100,beginCollumn,ratios.getR129(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+101,beginCollumn,ratios.getR130(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+102,beginCollumn,ratios.getR131(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+103,beginCollumn,ratios.getR132(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+104,beginCollumn,ratios.getR133(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+105,beginCollumn,ratios.getR134(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+106,beginCollumn,ratios.getR135(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    	}
    	beginRow = beginRow+105;
    	return beginRow;
    }
    

    
    
    /**
     * 可比上市公司近5年营业收入平均增长率数据
     * 
     * @param proCode
     * @param cellVoList
     * @param beginRow
     * @return
     */
    private int  getIqInfoProductAveInfo(String proCode, List<XlsCellVo> cellVoList,int beginRow,IqInfo inInfo,String title){
    	int beginCollumn = 0;
    	beginRow = beginRow+2;
    	cellVoList.add(new XlsCellVo(beginRow,beginCollumn,title,XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    	String JsonGrowthRateAve = inInfo.getJsonGrowthRateAve();
    	List<IqGrowth> list =  JSONArray.parseArray(JsonGrowthRateAve, IqGrowth.class);
    	if(CollectionUtils.isEmpty(list)){
    		throw new BusinessException("没有获取到项目编码["+proCode+"]的可比上市公司近5年营业收入平均增长率信息");
    	}
    	ReportExportTitleHandler.getComInfoProductAveCollumnTitle(cellVoList,beginRow,beginCollumn);
    	for(int i=0;i<list.size();i++){
    		 IqGrowth avg = list.get(i);
    		 beginCollumn ++ ;
    		 cellVoList.add(new XlsCellVo(beginRow+1,beginCollumn,avg.getR13(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+2,beginCollumn,avg.getR14(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+3,beginCollumn,avg.getR16(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//
    	}
    	beginRow = beginRow+3;
    	return beginRow;
    }
    
    /**
     * 可比公司近5年营业收入增长率数据
     * 
     * @param proCode
     * @param cellVoList
     * @param beginRow
     * @return
     */
    private int  getIqInfoProductInfo(String proCode, List<XlsCellVo> cellVoList,int beginRow,IqInfo inInfo,String title){
    	int beginCollumn = 0;
    	beginRow = beginRow+2;
    	cellVoList.add(new XlsCellVo(beginRow,beginCollumn,title,XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    	String jsonGrowthRate = inInfo.getJsonGrowthRate();
    	List<IqGrowth> list =  JSONArray.parseArray(jsonGrowthRate, IqGrowth.class);
    	if(CollectionUtils.isEmpty(list)){
    		throw new BusinessException("没有获取到项目编码["+proCode+"]的可比公司近5年财务比率指标信息");
    	}
    	ReportExportTitleHandler.getComInfoProductAveCollumnTitle(cellVoList,beginRow,beginCollumn);
    	for(int i=0;i<list.size();i++){
    		IqGrowth iqGrowth = list.get(i);
    		 beginCollumn ++ ;
    		 cellVoList.add(new XlsCellVo(beginRow+1,beginCollumn,iqGrowth.getR13(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+2,beginCollumn,Const.InComeYearNameCost.valueOf_1(iqGrowth.getR14()).getDesc() ,XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+3,beginCollumn,iqGrowth.getR16(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//
    	}
    	beginRow = beginRow+3;
    	return beginRow;
    }
    
    
    /**
     * 可比公司财务利润合计情况
     * 
     * @param proCode
     * @param cellVoList
     * @param beginRow
     * @return
     */
    private int  getIqFinaIncomeInfo(String proCode, List<XlsCellVo> cellVoList,int beginRow,IqInfo inInfo,String title){
    	int beginCollumn = 0;
    	beginRow = beginRow+2;
    	cellVoList.add(new XlsCellVo(beginRow,beginCollumn,title,XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    	String json_income = inInfo.getJsonIncome();
    	List<Income> incomeList =  JSONArray.parseArray(json_income, Income.class);
    	if(CollectionUtils.isEmpty(incomeList)){
    		throw new BusinessException("没有获取到项目编码["+proCode+"]的可比上市公司财务利润信息");
    	}
    	ReportExportTitleHandler.getiqInfoFinaCollumnTitle(cellVoList,beginRow,beginCollumn);
    	for(int i=0;i<incomeList.size();i++){
    		 Income iqcome = incomeList.get(i);
    		 beginCollumn ++ ;
    		 cellVoList.add(new XlsCellVo(beginRow+1,beginCollumn,iqcome.getR13(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+2,beginCollumn,Const.InComeYearNameCost.valueOf_1(iqcome.getR14()).getDesc() ,XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+3,beginCollumn,"",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));//"利润表(原始货币, 万元)"
    		 cellVoList.add(new XlsCellVo(beginRow+4,beginCollumn,iqcome.getR16(),XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));//一、营业总收入
    		 cellVoList.add(new XlsCellVo(beginRow+5,beginCollumn,iqcome.getR17(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//营业收入
    		 cellVoList.add(new XlsCellVo(beginRow+6,beginCollumn,iqcome.getR18(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //利息收入
    		 cellVoList.add(new XlsCellVo(beginRow+7,beginCollumn,iqcome.getR19(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //已赚保费
    		 cellVoList.add(new XlsCellVo(beginRow+8,beginCollumn,iqcome.getR20(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //手续费及佣金收入TODO
    		 cellVoList.add(new XlsCellVo(beginRow+9,beginCollumn,iqcome.getR21(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//二、营业总成本 
    		 cellVoList.add(new XlsCellVo(beginRow+10,beginCollumn,iqcome.getR22(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //营业成本
    		 cellVoList.add(new XlsCellVo(beginRow+11,beginCollumn,iqcome.getR23(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//利息支出
    		 cellVoList.add(new XlsCellVo(beginRow+12,beginCollumn,iqcome.getR25(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //手续费及佣金支出 TODO
    		 cellVoList.add(new XlsCellVo(beginRow+13,beginCollumn,iqcome.getR26(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //退保金
    		 cellVoList.add(new XlsCellVo(beginRow+14,beginCollumn,iqcome.getR27(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //赔付支出净额
    		 cellVoList.add(new XlsCellVo(beginRow+15,beginCollumn,iqcome.getR28(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //提取保险合同准备金净额
    		 cellVoList.add(new XlsCellVo(beginRow+16,beginCollumn,iqcome.getR29(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //保单红利支出
    		 cellVoList.add(new XlsCellVo(beginRow+17,beginCollumn,iqcome.getR31(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //分保费用
    		 cellVoList.add(new XlsCellVo(beginRow+18,beginCollumn,iqcome.getR32(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //营业税金及附加
    		 cellVoList.add(new XlsCellVo(beginRow+19,beginCollumn,iqcome.getR33(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //销售费用
    		 cellVoList.add(new XlsCellVo(beginRow+20,beginCollumn,iqcome.getR34(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //管理费用
    		 cellVoList.add(new XlsCellVo(beginRow+21,beginCollumn,iqcome.getR35(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //财务费用
    		 cellVoList.add(new XlsCellVo(beginRow+22,beginCollumn,iqcome.getR36(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //资产减值损失
    		 cellVoList.add(new XlsCellVo(beginRow+23,beginCollumn,iqcome.getR37(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//三、其他经营收益
    		 cellVoList.add(new XlsCellVo(beginRow+24,beginCollumn,iqcome.getR38(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //公允价值变动净收益
    		 cellVoList.add(new XlsCellVo(beginRow+25,beginCollumn,iqcome.getR39(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //投资净收益
    		 cellVoList.add(new XlsCellVo(beginRow+26,beginCollumn,iqcome.getR40(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //其中：对联营企业和合营企业的投资收益
    		 cellVoList.add(new XlsCellVo(beginRow+27,beginCollumn,iqcome.getR41(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //汇兑净收益
    		 cellVoList.add(new XlsCellVo(beginRow+28,beginCollumn,iqcome.getR43(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：营业利润差额(特殊报表科目)
    		 cellVoList.add(new XlsCellVo(beginRow+29,beginCollumn,iqcome.getR45(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：营业利润差额(合计平衡项目)
    		 cellVoList.add(new XlsCellVo(beginRow+30,beginCollumn,iqcome.getR46(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//四、营业利润
    		 cellVoList.add(new XlsCellVo(beginRow+31,beginCollumn,iqcome.getR47(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：营业外收入
    		 cellVoList.add(new XlsCellVo(beginRow+32,beginCollumn,iqcome.getR49(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//减：营业外支出
    		 cellVoList.add(new XlsCellVo(beginRow+33,beginCollumn,iqcome.getR50(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//其中：非流动资产处置净损失
    		 cellVoList.add(new XlsCellVo(beginRow+34,beginCollumn,iqcome.getR51(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：利润总额差额(特殊报表科目)
    		 cellVoList.add(new XlsCellVo(beginRow+35,beginCollumn,iqcome.getR52(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：利润总额差额(合计平衡项目)
    		 cellVoList.add(new XlsCellVo(beginRow+36,beginCollumn,iqcome.getR54(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//五、利润总额
    		 cellVoList.add(new XlsCellVo(beginRow+37,beginCollumn,iqcome.getR55(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//减：所得税
    		 cellVoList.add(new XlsCellVo(beginRow+38,beginCollumn,iqcome.getR56(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：未确认的投资损失
    		 cellVoList.add(new XlsCellVo(beginRow+39,beginCollumn,iqcome.getR57(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：净利润差额(特殊报表科目)
    		 cellVoList.add(new XlsCellVo(beginRow+40,beginCollumn,iqcome.getR58(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：净利润差额(合计平衡项目)
    		 cellVoList.add(new XlsCellVo(beginRow+41,beginCollumn,iqcome.getR59(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//六、净利润
    		 cellVoList.add(new XlsCellVo(beginRow+42,beginCollumn,iqcome.getR60(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //减：少数股东损益
    		 cellVoList.add(new XlsCellVo(beginRow+43,beginCollumn,iqcome.getR61(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//归属于母公司所有者的净利润
    		 cellVoList.add(new XlsCellVo(beginRow+44,beginCollumn,iqcome.getR62(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//加：其他综合收益
    		 cellVoList.add(new XlsCellVo(beginRow+45,beginCollumn,iqcome.getR63(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//七、综合收益总额
    		 cellVoList.add(new XlsCellVo(beginRow+46,beginCollumn,iqcome.getR64(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//减：归属于少数股东的综合收益总额
    		 cellVoList.add(new XlsCellVo(beginRow+47,beginCollumn,iqcome.getR66(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//归属于母公司普通股东综合收益总额
    		 cellVoList.add(new XlsCellVo(beginRow+48,beginCollumn,iqcome.getR67(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//八、每股收益
    		 cellVoList.add(new XlsCellVo(beginRow+49,beginCollumn,iqcome.getR69(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//(一) 基本每股收益(元)
    		 cellVoList.add(new XlsCellVo(beginRow+50,beginCollumn,iqcome.getR70(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//(二) 稀释每股收益(元) 
    		 cellVoList.add(new XlsCellVo(beginRow+51,beginCollumn,iqcome.getR71(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+52,beginCollumn,iqcome.getR73(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    		 cellVoList.add(new XlsCellVo(beginRow+53,beginCollumn,iqcome.getR74(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
       	 	
    	}
    	beginRow = beginRow+53;
    	return beginRow;
    }
    
    
    /**
     * 可比公司信息
     * 
     * @param proCode
     * @param cellVoList
     * @param beginRow
     * @return
     */
    private int  getIqComInfo(String proCode, List<XlsCellVo> cellVoList,int beginRow,String title){
    	int beginCollumn = 0;
    	// 获取可比公司信息
    	IqComExample iqComExample = new IqComExample();
    	iqComExample.createCriteria().andProCodeEqualTo(proCode);
    	List<IqCom> iqComList = iqComMapper.selectByExample(iqComExample);
    	if(CollectionUtils.isEmpty(iqComList)){
    		throw new BusinessException("没有获取到项目编码["+proCode+"]的可比公司信息");
    	}
    	cellVoList.add(new XlsCellVo(beginRow ++ ,beginCollumn,title,XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    	cellVoList.add(new XlsCellVo(beginRow ++ ,beginCollumn,"同行业可比上市公司共"+iqComList.size()+"家，可比上市公司明细下"));
 	 	cellVoList.add(new XlsCellVo(beginRow,beginCollumn,"序号",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
 	 	cellVoList.add(new XlsCellVo(beginRow,beginCollumn+1,"公司名称",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
 	    cellVoList.add(new XlsCellVo(beginRow,beginCollumn+2,"证券代码",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
 	    cellVoList.add(new XlsCellVo(beginRow,beginCollumn+3,"上市地点",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
 	    cellVoList.add(new XlsCellVo(beginRow,beginCollumn+4,"上市时间",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
 	    cellVoList.add(new XlsCellVo(beginRow,beginCollumn+5,"备注",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    	for(int i=0;i<iqComList.size();i++){
    		IqCom iqCom = iqComList.get(i);
    		beginRow ++ ;
       	 	cellVoList.add(new XlsCellVo(beginRow,beginCollumn,i+1,XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
       	 	cellVoList.add(new XlsCellVo(beginRow,beginCollumn+1,iqCom.getName(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //公司名称
       	 	cellVoList.add(new XlsCellVo(beginRow,beginCollumn+2,iqCom.getExchangeTicker(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); // 证券代码	 	
       	 	cellVoList.add(new XlsCellVo(beginRow,beginCollumn+3,iqCom.getIpoAddress(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //上市地点
       	 	cellVoList.add(new XlsCellVo(beginRow,beginCollumn+4,DateUtil.date2Str(iqCom.getIpoTime(), DateUtil.dataFormatPattern) ,XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); // 上市时间
       	 	cellVoList.add(new XlsCellVo(beginRow,beginCollumn+5,iqCom.getRemark(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //备注
    	}
    	return beginRow;
    }
    
    
	/**
     * 专利权人专利综合评价得分 统计
     * 
     * @param proCode 项目编码
     * @param cellVoList  单元格集合
     * @return 赋值后的单元格集合
     */
    private int getComPatentScore(String proCode, List<XlsCellVo> cellVoList,int beginRow,String title) {
    	int beginCollumn = 0 ;
    	beginRow = beginRow + 2;
    	cellVoList.add(new XlsCellVo(beginRow,beginCollumn,title,XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    	// 总计、平均分、方差、标准差
    	getComPatentScore(cellVoList,beginRow,beginCollumn);
    	getComPatentScoreByType(proCode, cellVoList, beginRow, beginCollumn, Const.PatentSumCost.AVG.getDesc(), Const.PatentSumCost.AVG.getValue());
    	getComPatentScoreByType(proCode, cellVoList, beginRow, beginCollumn+1, Const.PatentSumCost.SCORE.getDesc(), Const.PatentSumCost.SCORE.getValue());
    	beginRow = beginRow + 28;
    	return beginRow;
    }
    
    
    /**
     * 根据类别专利权人专利综合评价得分 
     * 
     * @param proCode
     * @param cellVoList
     * @param beginRow
     * @param beginCollumn
     * @param title
     * @param type
     */
	private void getComPatentScoreByType(String proCode, List<XlsCellVo> cellVoList, int beginRow, int beginCollumn,
			String title, String type) {
		// 获取行业统计平均数
    	ComPatentSumExample comPatentExample = new ComPatentSumExample();
    	comPatentExample.createCriteria().andPro_codeEqualTo(proCode).andTypeEqualTo(type);
    	List<ComPatentSum> comPatentSumList = comPatentSumMapper.selectByExample(comPatentExample);
    	if(CollectionUtils.isEmpty(comPatentSumList)){
    		throw new BusinessException("没有获取到项目编码["+proCode+"]的被评估公司的专利统计信息");
    	}
    	ComPatentSum comPatentSum = comPatentSumList.get(0);
        beginCollumn ++ ;
   	 	double score=0;
        // 进行Excel统计，第1行：各统计项，第一列：专利属性
       	 cellVoList.add(new XlsCellVo(beginRow+1,beginCollumn,title,XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
       	 cellVoList.add(new XlsCellVo(beginRow+2,beginCollumn,comPatentSum.getIcln(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
       	 cellVoList.add(new XlsCellVo(beginRow+3,beginCollumn,comPatentSum.getCigc(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"被引证次数"
       	 cellVoList.add(new XlsCellVo(beginRow+4,beginCollumn,comPatentSum.getDcln(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"从属权利要求数"
       	 cellVoList.add(new XlsCellVo(beginRow+5,beginCollumn,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"独立权利要求种类"
       	 cellVoList.add(new XlsCellVo(beginRow+6,beginCollumn,comPatentSum.getClt_c(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"方法和产品"
       	 cellVoList.add(new XlsCellVo(beginRow+7,beginCollumn,comPatentSum.getClt_a(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"方法"
       	 cellVoList.add(new XlsCellVo(beginRow+8,beginCollumn,comPatentSum.getClt_b(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//产品"
       	 cellVoList.add(new XlsCellVo(beginRow+9,beginCollumn,comPatentSum.getIpcsc(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"分类号（小类）数量"
       	 cellVoList.add(new XlsCellVo(beginRow+10,beginCollumn,comPatentSum.getRmn(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"剩余有效期"
       	 cellVoList.add(new XlsCellVo(beginRow+11,beginCollumn,comPatentSum.getCipc(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"引证次数"
       	 cellVoList.add(new XlsCellVo(beginRow+12,beginCollumn,comPatentSum.getInco(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利技术人员投入数量"
       	 cellVoList.add(new XlsCellVo(beginRow+13,beginCollumn,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利类型及当前权利状态"
       	 cellVoList.add(new XlsCellVo(beginRow+14,beginCollumn,comPatentSum.getPatt_a(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"发明"
       	 cellVoList.add(new XlsCellVo(beginRow+15,beginCollumn,comPatentSum.getPatt_b(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"实用新型"
       	 cellVoList.add(new XlsCellVo(beginRow+16,beginCollumn,comPatentSum.getPlic(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利诉讼次数"
       	 cellVoList.add(new XlsCellVo(beginRow+17,beginCollumn,comPatentSum.getPcc(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利许可次数"
       	 cellVoList.add(new XlsCellVo(beginRow+18,beginCollumn,comPatentSum.getPpc(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利质押次数"
       	 cellVoList.add(new XlsCellVo(beginRow+19,beginCollumn,comPatentSum.getTcc(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利转让次数"
       	 cellVoList.add(new XlsCellVo(beginRow+20,beginCollumn,comPatentSum.getDespage(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"说明书页数"
       	 cellVoList.add(new XlsCellVo(beginRow+21,beginCollumn,comPatentSum.getDrawpage(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"附图页数"
       	 cellVoList.add(new XlsCellVo(beginRow+22,beginCollumn,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利族地域种类和数量"
       	 cellVoList.add(new XlsCellVo(beginRow+23,beginCollumn,comPatentSum.getSfcl(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"地域数量"
       	 cellVoList.add(new XlsCellVo(beginRow+24,beginCollumn,comPatentSum.getFaus(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"US、EP、WO"
       	 cellVoList.add(new XlsCellVo(beginRow+25,beginCollumn,comPatentSum.getFajp(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"JP、KR"
       	 cellVoList.add(new XlsCellVo(beginRow+26,beginCollumn,comPatentSum.getFaot(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"其他国家或地区"
       	 if(Const.PatentSumCost.SCORE.getValue().equals(type)){
       		double scoreAsDouble = comPatentSum.getIcln() + comPatentSum.getCigc() + comPatentSum.getDcln()+comPatentSum.getClt_c()+comPatentSum.getClt_b()
                +comPatentSum.getClt_a()+comPatentSum.getIpcsc()+comPatentSum.getRmn()+comPatentSum.getCipc()+comPatentSum.getInco()
                +comPatentSum.getPatt_a()+comPatentSum.getPatt_b()+comPatentSum.getPlic()+comPatentSum.getPcc()+comPatentSum.getPpc()
                +comPatentSum.getTcc()+comPatentSum.getDespage()+comPatentSum.getDrawpage()+comPatentSum.getSfcl()+comPatentSum.getFaus()
                +comPatentSum.getFajp()+comPatentSum.getFaot();
       		score = scoreAsDouble;	  
       		cellVoList.add(new XlsCellVo(beginRow+27,1,score,XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//得分
       	 }
	}
    
    /**
     * 专利权人专利综合评价得分 属性名称
     * 
     * @param cellVoList
     * @param beginRow
     * @param beginCollumn
     */
    private void getComPatentScore(List<XlsCellVo> cellVoList,int beginRow,int beginCollumn){
   	 	 cellVoList.add(new XlsCellVo(beginRow+1,beginCollumn,"项目",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+2,beginCollumn,"独立权利要求数",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+3,beginCollumn,"被引证次数",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+4,beginCollumn,"从属权利要求数",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+5,beginCollumn,"独立权利要求种类",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+6,beginCollumn,"方法和产品",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+7,beginCollumn,"方法",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+8,beginCollumn,"产品",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+9,beginCollumn,"分类号（小类）数量",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+10,beginCollumn,"剩余有效期",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+11,beginCollumn,"引证次数",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+12,beginCollumn,"专利技术人员投入数量",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+13,beginCollumn,"专利类型及当前权利状态",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+14,beginCollumn,"发明",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+15,beginCollumn,"实用新型",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 /*cellVoList.add(new XlsCellVo(beginRow+16,beginCollumn,"外观设计",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));*/
		 cellVoList.add(new XlsCellVo(beginRow+16,beginCollumn,"专利诉讼次数",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+17,beginCollumn,"专利许可次数",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+18,beginCollumn,"专利质押次数",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+19,beginCollumn,"专利转让次数",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+20,beginCollumn,"说明书页数",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+21,beginCollumn,"附图页数",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+22,beginCollumn,"专利族地域种类和数量",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+23,beginCollumn,"地域数量",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+24,beginCollumn,"US、EP、WO",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+25,beginCollumn,"JP、KR",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+26,beginCollumn,"其他国家或地区",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
		 cellVoList.add(new XlsCellVo(beginRow+27,beginCollumn,"专利权人专利得分合计",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
   }
    
	/**
     * 被评估公司专利统计情况
     * 
     * @param proCode 项目编码
     * @param cellVoList  单元格集合
     * @return 赋值后的单元格集合
     */
    private int getComPatentSumInfo(String proCode, List<XlsCellVo> cellVoList,int beginRow) {
    	int beginCollumn = 0 ;
    	beginRow = beginRow + 2;
    	cellVoList.add(new XlsCellVo(beginRow,beginCollumn,"专利权人专利统计状况",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    	// 总计、平均分、方差、标准差
    	ReportExportTitleHandler.getComPatentTitle(cellVoList,beginRow,beginCollumn);
    	
    	comPatentSumByType(proCode, cellVoList, beginRow, beginCollumn, Const.PatentSumCost.SUM.getDesc(), Const.PatentSumCost.SUM.getValue());
    	comPatentSumByType(proCode, cellVoList, beginRow, beginCollumn+1, Const.PatentSumCost.AVG.getDesc(), Const.PatentSumCost.AVG.getValue());
    	comPatentSumByType(proCode, cellVoList, beginRow, beginCollumn+2, Const.PatentSumCost.VAR.getDesc(), Const.PatentSumCost.VAR.getValue());
    	comPatentSumByType(proCode, cellVoList, beginRow, beginCollumn+3, Const.PatentSumCost.STA.getDesc(), Const.PatentSumCost.STA.getValue());
    	beginRow = beginRow + 33;
    	return beginRow;
    }
    
    /**
     * 行业根据类别进行统计
     * 
     * @param proCode
     * @param cellVoList
     * @param beginRow
     * @param beginCollumn
     * @param title
     * @param type
     */
	private void iqComPatentSumByType(String proCode, List<XlsCellVo> cellVoList, int beginRow, int beginCollumn,
			String title, String type) {
		// 获取行业统计平均数
    	IqComPatentSumExample iqComPatentExample = new IqComPatentSumExample();
    	iqComPatentExample.createCriteria().andPro_codeEqualTo(proCode).andTypeEqualTo(type);
    	List<IqComPatentSum> iqComPatentSumList = iqComPatentSumMapper.selectByExample(iqComPatentExample);
    	if(CollectionUtils.isEmpty(iqComPatentSumList)){
    		throw new BusinessException("没有获取到项目编码["+proCode+"]的行业专利统计信息");
    	}
    	IqComPatentSum iqComPatentSum = iqComPatentSumList.get(0);
        beginCollumn ++ ;
        // 进行Excel统计，第1行：各统计项，第一列：专利属性
       	 cellVoList.add(new XlsCellVo(beginRow+1,beginCollumn,title,XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
       	 cellVoList.add(new XlsCellVo(beginRow+2,beginCollumn,iqComPatentSum.getIcln(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
       	 cellVoList.add(new XlsCellVo(beginRow+3,beginCollumn,iqComPatentSum.getCigc(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"被引证次数"
       	 cellVoList.add(new XlsCellVo(beginRow+4,beginCollumn,iqComPatentSum.getDcln(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"从属权利要求数"
       	 cellVoList.add(new XlsCellVo(beginRow+5,beginCollumn,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"独立权利要求种类"
       	 cellVoList.add(new XlsCellVo(beginRow+6,beginCollumn,iqComPatentSum.getClt_c(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"方法和产品"
       	 cellVoList.add(new XlsCellVo(beginRow+7,beginCollumn,iqComPatentSum.getClt_a(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"方法"
       	 cellVoList.add(new XlsCellVo(beginRow+8,beginCollumn,iqComPatentSum.getClt_b(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//产品"
       	 cellVoList.add(new XlsCellVo(beginRow+9,beginCollumn,iqComPatentSum.getIpcsc(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"分类号（小类）数量"
       	 cellVoList.add(new XlsCellVo(beginRow+10,beginCollumn,iqComPatentSum.getRmn(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"剩余有效期"
       	 cellVoList.add(new XlsCellVo(beginRow+11,beginCollumn,iqComPatentSum.getCipc(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"引证次数"
       	 cellVoList.add(new XlsCellVo(beginRow+12,beginCollumn,iqComPatentSum.getInco(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利技术人员投入数量"
       	 cellVoList.add(new XlsCellVo(beginRow+13,beginCollumn,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利类型及当前权利状态"
       	 cellVoList.add(new XlsCellVo(beginRow+14,beginCollumn,iqComPatentSum.getPatt_a(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"发明"
       	 cellVoList.add(new XlsCellVo(beginRow+15,beginCollumn,iqComPatentSum.getPatt_b(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"实用新型"
       	 cellVoList.add(new XlsCellVo(beginRow+16,beginCollumn,iqComPatentSum.getPlic(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利诉讼次数"
       	 cellVoList.add(new XlsCellVo(beginRow+17,beginCollumn,iqComPatentSum.getPcc(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利许可次数"
       	 cellVoList.add(new XlsCellVo(beginRow+18,beginCollumn,iqComPatentSum.getPpc(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利质押次数"
       	 cellVoList.add(new XlsCellVo(beginRow+19,beginCollumn,iqComPatentSum.getTcc(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利转让次数"
       	 cellVoList.add(new XlsCellVo(beginRow+20,beginCollumn,iqComPatentSum.getDespage(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"说明书页数"
       	 cellVoList.add(new XlsCellVo(beginRow+21,beginCollumn,iqComPatentSum.getDrawpage(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"附图页数"
       	 cellVoList.add(new XlsCellVo(beginRow+22,beginCollumn,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利族地域种类和数量"
       	 cellVoList.add(new XlsCellVo(beginRow+23,beginCollumn,iqComPatentSum.getSfcl(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"地域数量"
       	 cellVoList.add(new XlsCellVo(beginRow+24,beginCollumn,iqComPatentSum.getFaus(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"US、EP、WO"
       	 cellVoList.add(new XlsCellVo(beginRow+25,beginCollumn,iqComPatentSum.getFajp(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"JP、KR"
       	 cellVoList.add(new XlsCellVo(beginRow+26,beginCollumn,iqComPatentSum.getFaot(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"其他国家或地区"
	}
    
	/**
     * 专利权人专利状况
     * 
     * @param proCode 项目编码
     * @param cellVoList  单元格集合
     * @return 赋值后的单元格集合
     */
    private int getComPatentInfo(String proCode, List<XlsCellVo> cellVoList,int beginRow,String title,Com com) {
    	int beginCollumn = 0;
    	cellVoList.add(new XlsCellVo(beginRow,beginCollumn,title,XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    	// 获取被评估公司专利信息
    	ComPatentExample comPatentExample = new ComPatentExample();
    	comPatentExample.createCriteria().andPro_codeEqualTo(proCode);
    	List<ComPatent> comPatentList = comPatentMapper.selectByExample(comPatentExample);
    	if(CollectionUtils.isEmpty(comPatentList)){
    		throw new BusinessException("没有获取到项目编码["+proCode+"]的被评估公司专利信息");
    	}
    	String desc = com.getName() +"所拥有的专利共计"+(com.getCountFm()+com.getCountSq()+com.getCountWg()+com.getCountXx())+"项，其中发明专利"+(com.getCountFm()+com.getCountSq())+"项，实用新型专利"+com.getCountXx()+"项，外观设计专利"+com.getCountWg()+"项。"+com.getName() +"专利状况如下";
    	cellVoList.add(new XlsCellVo(++beginRow,beginCollumn,desc,XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    	
    	ReportExportTitleHandler.getComPatentTitle(cellVoList,beginRow,beginCollumn);
    	cellVoList.add(new XlsCellVo(beginRow+33,beginCollumn,"专利评价得分",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
    	
    	for(int i=0;i<comPatentList.size();i++){
    		ComPatent comPatent = comPatentList.get(i);
        	beginCollumn ++ ;
        	// 进行Excel统计，第1行：各可比公司名称，第一列：专利属性
       	 	cellVoList.add(new XlsCellVo(beginRow+1,beginCollumn,"专利"+(i+1),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
       	 	cellVoList.add(new XlsCellVo(beginRow+2,beginCollumn,comPatent.getAd(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //专利申请日
       	 	cellVoList.add(new XlsCellVo(beginRow+3,beginCollumn,comPatent.getAn(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); // 专利申请号       	 	
       	 	cellVoList.add(new XlsCellVo(beginRow+4,beginCollumn,comPatent.getPn(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //专利公开号
       	 	cellVoList.add(new XlsCellVo(beginRow+5,beginCollumn,comPatent.getPatt(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); // 专利类型
       	 	cellVoList.add(new XlsCellVo(beginRow+6,beginCollumn,comPatent.getTi(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //专利名称
       	 	cellVoList.add(new XlsCellVo(beginRow+7,beginCollumn,comPatent.getSic(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); // 专利分类号
       	 	cellVoList.add(new XlsCellVo(beginRow+8,beginCollumn,comPatent.getIcln(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); // 独立权利要求数
       	 	cellVoList.add(new XlsCellVo(beginRow+9,beginCollumn,comPatent.getCigc(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"被引证次数"
       	 	cellVoList.add(new XlsCellVo(beginRow+10,beginCollumn,comPatent.getDcln(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"从属权利要求数"
       	 	cellVoList.add(new XlsCellVo(beginRow+11,beginCollumn,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"独立权利要求种类"
       	    //独立权利要求种类： 01产品，02方法，03方法+产品
       	 	String clt = comPatent.getClt();
       	 	String cltA = "";//产品
       	 	String cltB = "";//方法
       	 	String cltC = "";//方法和产品
       	 	if("01".equals(clt)){
       	 	    cltA = "产品";
       	 	}else if("02".equals(clt)){
       	 		cltB = "方法";
       	 	}else if("03".equals(clt)){
    	 		cltC = "方法和产品";
    	 	}
       	 	cellVoList.add(new XlsCellVo(beginRow+12,beginCollumn,cltC,XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"方法和产品"
       	 	cellVoList.add(new XlsCellVo(beginRow+13,beginCollumn,cltB,XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"方法"
       	 	cellVoList.add(new XlsCellVo(beginRow+14,beginCollumn,cltA,XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//产品"
       	 	cellVoList.add(new XlsCellVo(beginRow+15,beginCollumn,comPatent.getIpcsc(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"分类号（小类）数量"
       	 	cellVoList.add(new XlsCellVo(beginRow+16,beginCollumn,comPatent.getRmn(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"剩余有效期"
       	 	cellVoList.add(new XlsCellVo(beginRow+17,beginCollumn,comPatent.getCipc(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"引证次数"
       	 	cellVoList.add(new XlsCellVo(beginRow+18,beginCollumn,comPatent.getInco(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利技术人员投入数量"
       	 	cellVoList.add(new XlsCellVo(beginRow+19,beginCollumn,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利类型及当前权利状态"
       	 	String patt = comPatent.getPatt();
       	 	String pattA = "";
       	 	String pattB = "";
       	 	if("FM".equals(patt) || "SQ".equals(patt)){
       	 	   pattA = "发明"; 
       	 	}
       	 	if("XX".equals(patt)){
     	 	   pattB = "实用新型"; 
     	 	}
       	 	
       	 	cellVoList.add(new XlsCellVo(beginRow+20,beginCollumn,pattA,XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"发明"
       	 	cellVoList.add(new XlsCellVo(beginRow+21,beginCollumn,pattB,XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"实用新型"
       	 	cellVoList.add(new XlsCellVo(beginRow+22,beginCollumn,comPatent.getPlic(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利诉讼次数"
       	 	cellVoList.add(new XlsCellVo(beginRow+23,beginCollumn,comPatent.getPcc(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利许可次数"
       	 	cellVoList.add(new XlsCellVo(beginRow+24,beginCollumn,comPatent.getPpc(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利质押次数"
       	 	cellVoList.add(new XlsCellVo(beginRow+25,beginCollumn,comPatent.getTcc(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利转让次数"
       	 	cellVoList.add(new XlsCellVo(beginRow+26,beginCollumn,comPatent.getDespage(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"说明书页数"
       	 	cellVoList.add(new XlsCellVo(beginRow+27,beginCollumn,comPatent.getDrawpage(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"附图页数"
       	 	cellVoList.add(new XlsCellVo(beginRow+28,beginCollumn,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利族地域种类和数量"
       	 	cellVoList.add(new XlsCellVo(beginRow+29,beginCollumn,comPatent.getSfcl(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"地域数量"
       	 	cellVoList.add(new XlsCellVo(beginRow+30,beginCollumn,comPatent.getFaus(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"US、EP、WO"
       	 	cellVoList.add(new XlsCellVo(beginRow+31,beginCollumn,comPatent.getFajp(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"JP、KR"
       	 	cellVoList.add(new XlsCellVo(beginRow+32,beginCollumn,comPatent.getFaot(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"其他国家或地区"
       	 	cellVoList.add(new XlsCellVo(beginRow+33,beginCollumn,comPatent.getScore() ,XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//专利评价得分
       	 	
    	}
    	beginRow = beginRow + 33;
    	return beginRow;
    }
    
    
	/**
     * 行业专利情况统计
     * 
     * @param proCode 项目编码
     * @param cellVoList  单元格集合
     * @return 赋值后的单元格集合
     */
    private int getIqComPatentSumInfo(String proCode, List<XlsCellVo> cellVoList,int beginRow) {
    	int beginCollumn = 0 ;
    	beginRow = beginRow + 2;
    	cellVoList.add(new XlsCellVo(beginRow,beginCollumn,"行业专利状况",XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    	// 总计、平均分、方差、标准差
    	ReportExportTitleHandler.getIqComPatentTitle(cellVoList,beginRow,beginCollumn);
    	iqComPatentSumByType(proCode, cellVoList, beginRow, beginCollumn, Const.PatentSumCost.SUM.getDesc(), Const.PatentSumCost.SUM.getValue());
    	iqComPatentSumByType(proCode, cellVoList, beginRow, beginCollumn+1, Const.PatentSumCost.AVG.getDesc(), Const.PatentSumCost.AVG.getValue());
    	iqComPatentSumByType(proCode, cellVoList, beginRow, beginCollumn+2, Const.PatentSumCost.VAR.getDesc(), Const.PatentSumCost.VAR.getValue());
    	iqComPatentSumByType(proCode, cellVoList, beginRow, beginCollumn+3, Const.PatentSumCost.STA.getDesc(), Const.PatentSumCost.STA.getValue());
    	beginRow = beginRow + 26;
    	return beginRow;
    }

    /**
     * 行业根据类别进行统计
     * 
     * @param proCode
     * @param cellVoList
     * @param beginRow
     * @param beginCollumn
     * @param title
     * @param type
     */
	private void comPatentSumByType(String proCode, List<XlsCellVo> cellVoList, int beginRow, int beginCollumn,
			String title, String type) {
		// 获取行业统计平均数
    	ComPatentSumExample comPatentExample = new ComPatentSumExample();
    	comPatentExample.createCriteria().andPro_codeEqualTo(proCode).andTypeEqualTo(type);
    	List<ComPatentSum> comPatentSumList = comPatentSumMapper.selectByExample(comPatentExample);
    	if(CollectionUtils.isEmpty(comPatentSumList)){
    		throw new BusinessException("没有获取到项目编码["+proCode+"]的被评估公司专利统计信息");
    	}
    	ComPatentSum comPatentSum = comPatentSumList.get(0);
        beginCollumn ++ ;
    	// 进行Excel统计，第1行：各可比公司名称，第一列：专利属性
   	 	cellVoList.add(new XlsCellVo(beginRow+1,beginCollumn,title,XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
   	 	cellVoList.add(new XlsCellVo(beginRow+2,beginCollumn,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //专利申请日
   	 	cellVoList.add(new XlsCellVo(beginRow+3,beginCollumn,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); // 专利申请号       	 	
   	 	cellVoList.add(new XlsCellVo(beginRow+4,beginCollumn,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //专利公开号
   	 	cellVoList.add(new XlsCellVo(beginRow+5,beginCollumn,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); // 专利类型
   	 	cellVoList.add(new XlsCellVo(beginRow+6,beginCollumn,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); //专利名称
   	 	cellVoList.add(new XlsCellVo(beginRow+7,beginCollumn,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); // 专利分类号
   	 	cellVoList.add(new XlsCellVo(beginRow+8,beginCollumn,comPatentSum.getIcln(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT)); // 独立权利要求数
   	 	cellVoList.add(new XlsCellVo(beginRow+9,beginCollumn,comPatentSum.getCigc(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"被引证次数"
   	 	cellVoList.add(new XlsCellVo(beginRow+10,beginCollumn,comPatentSum.getDcln(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"从属权利要求数"
   	 	cellVoList.add(new XlsCellVo(beginRow+11,beginCollumn,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"独立权利要求种类"
   	 	cellVoList.add(new XlsCellVo(beginRow+12,beginCollumn,comPatentSum.getClt_c(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"方法和产品"
   	 	cellVoList.add(new XlsCellVo(beginRow+13,beginCollumn,comPatentSum.getClt_b(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"方法"
   	 	cellVoList.add(new XlsCellVo(beginRow+14,beginCollumn,comPatentSum.getClt_a(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//产品"
   	 	cellVoList.add(new XlsCellVo(beginRow+15,beginCollumn,comPatentSum.getIpcsc(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"分类号（小类）数量"
   	 	cellVoList.add(new XlsCellVo(beginRow+16,beginCollumn,comPatentSum.getRmn(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"剩余有效期"
   	 	cellVoList.add(new XlsCellVo(beginRow+17,beginCollumn,comPatentSum.getCipc(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"引证次数"
   	 	cellVoList.add(new XlsCellVo(beginRow+18,beginCollumn,comPatentSum.getInco(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利技术人员投入数量"
   	 	cellVoList.add(new XlsCellVo(beginRow+19,beginCollumn,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利类型及当前权利状态"
   	 	cellVoList.add(new XlsCellVo(beginRow+20,beginCollumn,comPatentSum.getPatt_a(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"发明"
   	 	cellVoList.add(new XlsCellVo(beginRow+21,beginCollumn,comPatentSum.getPatt_b(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"实用新型"
   	 	cellVoList.add(new XlsCellVo(beginRow+22,beginCollumn,comPatentSum.getPlic(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利诉讼次数"
   	 	cellVoList.add(new XlsCellVo(beginRow+23,beginCollumn,comPatentSum.getPcc(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利许可次数"
   	 	cellVoList.add(new XlsCellVo(beginRow+24,beginCollumn,comPatentSum.getPpc(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利质押次数"
   	 	cellVoList.add(new XlsCellVo(beginRow+25,beginCollumn,comPatentSum.getTcc(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利转让次数"
   	 	cellVoList.add(new XlsCellVo(beginRow+26,beginCollumn,comPatentSum.getDespage(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"说明书页数"
   	 	cellVoList.add(new XlsCellVo(beginRow+27,beginCollumn,comPatentSum.getDrawpage(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"附图页数"
   	 	cellVoList.add(new XlsCellVo(beginRow+28,beginCollumn,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利族地域种类和数量"
   	 	cellVoList.add(new XlsCellVo(beginRow+29,beginCollumn,comPatentSum.getSfcl(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"地域数量"
   	 	cellVoList.add(new XlsCellVo(beginRow+30,beginCollumn,comPatentSum.getFaus(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"US、EP、WO"
   	 	cellVoList.add(new XlsCellVo(beginRow+31,beginCollumn,comPatentSum.getFajp(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"JP、KR"
   	 	cellVoList.add(new XlsCellVo(beginRow+32,beginCollumn,comPatentSum.getFaot(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"其他国家或地区"
/*   	 	String score = "";
   	 	if(Const.PatentSumCost.SUM.getValue().equals(type)){
   	 		double scoreAsDouble = comPatentSum.getIcln() + comPatentSum.getCigc() + comPatentSum.getDcln()+comPatentSum.getClt_c()+comPatentSum.getClt_b()
   	 		                       +comPatentSum.getClt_a()+comPatentSum.getIpcsc()+comPatentSum.getRmn()+comPatentSum.getCipc()+comPatentSum.getInco()
   	 		                       +comPatentSum.getPatt_a()+comPatentSum.getPatt_b()+comPatentSum.getPlic()+comPatentSum.getPcc()+comPatentSum.getPpc()
   	 		                       +comPatentSum.getTcc()+comPatentSum.getDespage()+comPatentSum.getDrawpage()+comPatentSum.getSfcl()+comPatentSum.getFaus()
   	 		                       +comPatentSum.getFajp()+comPatentSum.getFaot();
   	 		
   	 	   score = 	String.valueOf(scoreAsDouble);	
   	 	}
   	 	
   	 	cellVoList.add(new XlsCellVo(beginRow+33,beginCollumn,score));//专利评价得分
*/	}
    
    
	/**
     * 构建可比公司的平均数
     * 
     * @param proCode 项目编码
     * @param cellVoList  单元格集合
     * @return 赋值后的单元格集合
     */
    private int getIqComPatentInfo(String proCode, List<XlsCellVo> cellVoList,int beginRow,String title) {
    	int beginCollumn = 0;
    	//beginRow = beginRow+2;
    	cellVoList.add(new XlsCellVo(beginRow,beginCollumn,title,XlsCellVo.STYLE_WBOLD_HBORDER_ALEFT));
    	Com com=comMapper.selectByPrimaryKey(proCode);

    	String desc = "可比上市公司共"+com.getCountIqCom()+"家，所拥有的专利共计"+(com.getCountIqFm()+com.getCountIqSq()+com.getCountIqWg()+com.getCountIqXx())+"项，其中发明专利"+(com.getCountIqFm()+com.getCountIqSq())+"项，实用新型专利"+com.getCountIqXx()+"项，外观设计专利"+com.getCountIqWg()+"项。可比上市公司专利状况如下";
    	cellVoList.add(new XlsCellVo(++beginRow,beginCollumn,desc));
    	// 获取可比公司的专利情况
    	IqComPatentExample iqComPatentExample = new IqComPatentExample();
    	iqComPatentExample.createCriteria().andProCodeEqualTo(proCode);
    	List<IqComPatent> iqComPatentList = iqComPatentMapper.selectByExample(iqComPatentExample);
    	if(CollectionUtils.isEmpty(iqComPatentList)){
    		throw new BusinessException("没有获取到项目编码["+proCode+"]的可比公司专利统计信息");
    	}
    	ReportExportTitleHandler.getIqComPatentTitle(cellVoList,beginRow,beginCollumn);
    	for(int i=0;i<iqComPatentList.size();i++){
    		IqComPatent iqComPatent = iqComPatentList.get(i);
        	beginCollumn ++ ;
        	// 进行Excel统计，第1行：各可比公司名称，第一列：专利属性
       	 	cellVoList.add(new XlsCellVo(beginRow+1,beginCollumn,iqComPatent.getName(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
       	 	cellVoList.add(new XlsCellVo(beginRow+2,beginCollumn,iqComPatent.getIcln(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));
       	 	cellVoList.add(new XlsCellVo(beginRow+3,beginCollumn,iqComPatent.getCigc(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"被引证次数"
       	 	cellVoList.add(new XlsCellVo(beginRow+4,beginCollumn,iqComPatent.getDcln(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"从属权利要求数"
       	 	cellVoList.add(new XlsCellVo(beginRow+5,beginCollumn,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"独立权利要求种类"
       	 	cellVoList.add(new XlsCellVo(beginRow+6,beginCollumn,iqComPatent.getCltC(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"方法和产品"TODO
       	 	cellVoList.add(new XlsCellVo(beginRow+7,beginCollumn,iqComPatent.getCltB(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"方法"TODO
       	 	cellVoList.add(new XlsCellVo(beginRow+8,beginCollumn,iqComPatent.getCltA(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//产品"TODO
       	 	cellVoList.add(new XlsCellVo(beginRow+9,beginCollumn,iqComPatent.getIpcsc(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"分类号（小类）数量"
       	 	cellVoList.add(new XlsCellVo(beginRow+10,beginCollumn,iqComPatent.getRmn(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"剩余有效期"
       	 	cellVoList.add(new XlsCellVo(beginRow+11,beginCollumn,iqComPatent.getCipc(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"引证次数"
       	 	cellVoList.add(new XlsCellVo(beginRow+12,beginCollumn,iqComPatent.getInco(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利技术人员投入数量"
       	 	cellVoList.add(new XlsCellVo(beginRow+13,beginCollumn,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利类型及当前权利状态"
       	 	cellVoList.add(new XlsCellVo(beginRow+14,beginCollumn,iqComPatent.getPattA(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"发明"
       	 	cellVoList.add(new XlsCellVo(beginRow+15,beginCollumn,iqComPatent.getPattB(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"实用新型"
       	 	cellVoList.add(new XlsCellVo(beginRow+16,beginCollumn,iqComPatent.getPlic(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利诉讼次数"
       	 	cellVoList.add(new XlsCellVo(beginRow+17,beginCollumn,iqComPatent.getPcc(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利许可次数"
       	 	cellVoList.add(new XlsCellVo(beginRow+18,beginCollumn,iqComPatent.getPpc(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利质押次数"
       	 	cellVoList.add(new XlsCellVo(beginRow+19,beginCollumn,iqComPatent.getTcc(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利转让次数"
       	 	cellVoList.add(new XlsCellVo(beginRow+20,beginCollumn,iqComPatent.getDespage(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"说明书页数"
       	 	cellVoList.add(new XlsCellVo(beginRow+21,beginCollumn,iqComPatent.getDrawpage(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"附图页数"
       	 	cellVoList.add(new XlsCellVo(beginRow+22,beginCollumn,"",XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"专利族地域种类和数量"
       	 	cellVoList.add(new XlsCellVo(beginRow+23,beginCollumn,iqComPatent.getSfcl(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"地域数量"
       	 	cellVoList.add(new XlsCellVo(beginRow+24,beginCollumn,iqComPatent.getFaus(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"US、EP、WO"
       	 	cellVoList.add(new XlsCellVo(beginRow+25,beginCollumn,iqComPatent.getFajp(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"JP、KR"
       	 	cellVoList.add(new XlsCellVo(beginRow+26,beginCollumn,iqComPatent.getFaot(),XlsCellVo.STYLE_NBOLD_HBORDER_ALEFT));//"其他国家或地区"
    	}
    	beginRow = beginRow + 26;
    	return beginRow;
    }
    
	private String getExportFileName(String proCode) {
    	StringBuilder sb = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhMMss");
        String currentDateStr = sdf.format(new Date());
        sb.append(proCode);
        sb.append("_");
        sb.append(currentDateStr);
        return sb.toString();
    }
	public static void main(String[] args) throws Exception{
		ReportExportHandler reportExportHandler=new ReportExportHandler();
		HashMap<String, Double> iqComCountBySumMap = new HashMap<String, Double>();
		iqComCountBySumMap.put("发明专利", (double)50);
		iqComCountBySumMap.put("实用新型专利", (double)20);
		iqComCountBySumMap.put("外观设计专利", (double)30);
		PieChart pieChart = new PieChart("7.2行业专利数量及专利类型比率图",iqComCountBySumMap);
		reportExportHandler.createChartFile(pieChart.getChart(),"D://picture/",827,472);
	}
}
