package com.kpap.website.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.kpap.basis.dao.ComCaseMapper;
import com.kpap.basis.dao.ComDevCostMapper;
import com.kpap.basis.dao.ComInfoMapper;
import com.kpap.basis.dao.ComMapper;
import com.kpap.basis.dao.ComProductMapper;
import com.kpap.basis.dao.IqComMapper;
import com.kpap.basis.dao.IqInfoMapper;
import com.kpap.basis.dao.IqRatiosMapper;
import com.kpap.basis.excelModel.Ave;
import com.kpap.basis.excelModel.AveCollect;
import com.kpap.basis.excelModel.Balance;
import com.kpap.basis.excelModel.ComProductInfo;
import com.kpap.basis.excelModel.Income;
import com.kpap.basis.excelModel.IncomeAve;
import com.kpap.basis.excelModel.IqGrowth;
import com.kpap.basis.excelModel.IqRatiosAve;
import com.kpap.basis.excelModel.Product;
import com.kpap.basis.excelModel.ProductAve;
import com.kpap.basis.excelModel.Profit;
import com.kpap.basis.excelModel.Ratios;
import com.kpap.basis.excelModel.RatiosGrowthAve;
import com.kpap.basis.model.Com;
import com.kpap.basis.model.ComCase;
import com.kpap.basis.model.ComDevCost;
import com.kpap.basis.model.ComInfo;
import com.kpap.basis.model.ComProduct;
import com.kpap.basis.model.IqCom;
import com.kpap.basis.model.IqComExample;
import com.kpap.basis.model.IqInfo;
import com.kpap.basis.model.IqRatios;
import com.kpap.common.util.CommonUtil;
import com.kpap.website.service.IProjectExcelService;

@Service
public class ProjectExcelService implements IProjectExcelService {
	private static final Logger logger = LoggerFactory.getLogger(ProjectExcelService.class);
	@Autowired
	public ComMapper comMapper;
	
	@Autowired
	public ComInfoMapper comInfoMapper;
	
	@Autowired
	public ComProductMapper comProductMapper;
	
	@Autowired
	public ComDevCostMapper comDevCostMapper;
	
	@Autowired
	public ComCaseMapper comCaseMapper;
	
	@Autowired
	public IqComMapper iqComMapper;
	
	@Autowired
	public IqInfoMapper iqInfoMapper;
	
	@Autowired
	public IqRatiosMapper iqRatiosMapper;

	/**
	 * 解析模板报表
	 * @param proCode
	 * @param path
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRED)
	public void analysisExcel(String proCode,String type,String path) throws Exception{
        InputStream inp = null;
        Workbook workbook = null;
        try {
            inp = new FileInputStream(path);
            workbook = WorkbookFactory.create(inp);
            if("iq".equalsIgnoreCase(type)){
                IqInfo iqInfo=new IqInfo();
                iqInfo.setProCode(proCode);
                IqRatios iqRatios=new IqRatios();
                
                //IQ_1_可比公司_母公司
                Sheet sheet_0=workbook.getSheetAt(0);
                int startRow=5;
                while(true){
                	String iqComName=getStringValue(sheet_0,startRow,3);
                	if(StringUtils.isBlank(iqComName)){
                		break;
                	}
                	IqCom iqCom=new IqCom();
                	iqCom.setProCode(proCode);
                	iqCom.setName(iqComName);
                	iqCom.setExchangeTicker(getStringValue(sheet_0,startRow,4));
                	iqCom.setIpoAddress(getStringValue(sheet_0,startRow,6));
                	Double ipoTime=getDoubleValue(sheet_0,startRow,7);
                	if(ipoTime!=null){
                		iqCom.setIpoTime(DateUtil.getJavaDate(ipoTime));
                	}
                	iqCom.setRemark(getStringValue(sheet_0,startRow,12));
                	iqCom.setCreateDate(new Date());
                	iqComMapper.insertSelective(iqCom);
                	
                	startRow++;
                }
                
                //IQ_6_可比公司会计报表_利润表 _平均数
                Sheet sheet_1=workbook.getSheetAt(1);
                List<Income> incomes=getValueByBlock(sheet_1, 3, 8, Income.class);
                iqInfo.setJsonIncome(JSON.toJSONString(incomes));
                List<IncomeAve> incomeAves=getValueByBlock(sheet_1, 11, 16, IncomeAve.class);
                iqInfo.setJsonIncomeAve(JSON.toJSONString(incomeAves));
                
                //IQ_10_可比公司会计报表_利润表 _营业收入增长率
                Sheet sheet_2=workbook.getSheetAt(2);
                List<IqGrowth> iqGrowths=getValueByBlock(sheet_2, 2, 6, IqGrowth.class);
                iqInfo.setJsonGrowthRate(JSON.toJSONString(iqGrowths));
                List<IqGrowth> iqGrowthsb=getValueByBlock(sheet_2, 9, 13, IqGrowth.class);
                iqInfo.setJsonGrowthRateAve(JSON.toJSONString(iqGrowthsb));
                
                
                //IQ_12_可比公司财务比率指标_平均数
                Sheet sheet_3=workbook.getSheetAt(3);
                List<IqRatiosAve> iqRatiosAves=getValueByBlock(sheet_3, 2, 7, IqRatiosAve.class);
                iqInfo.setJsonRatios(JSON.toJSONString(iqRatiosAves));
                
                iqRatios.setProCode(proCode);
                iqRatios.setH37(getBigDecimalVal(sheet_3,36,7));
                iqRatios.setG37(getBigDecimalVal(sheet_3,36,6));
                iqRatios.setL37(getBigDecimalVal(sheet_3,36,11));
                iqRatios.setM37(getBigDecimalVal(sheet_3,36,12));
                iqRatios.setH53(getBigDecimalVal(sheet_3,52,7));
                iqRatios.setG53(getBigDecimalVal(sheet_3,52,6));
                iqRatios.setL53(getBigDecimalVal(sheet_3,52,11));
                iqRatios.setM53(getBigDecimalVal(sheet_3,52,12));
                
                iqInfoMapper.insertSelective(iqInfo);
                
                //IQ_16_可比公司会计报表-利润表_分类统计
                Sheet sheet_4=workbook.getSheetAt(4);
                AveCollect aveCollect=new AveCollect();
                Class<AveCollect> model=AveCollect.class;
        		Field[] fields=model.getFields();
        		for (Field field : fields) {
        			String fieldName=field.getName();
        			Method method=model.getMethod("set"+CommonUtil.toUpperCaseFirstOne(fieldName),Ave.class);
        			int rowNum=Integer.parseInt(fieldName.substring(1))-1;
        		 
        			Ave ave=new Ave();
        			ave.setAve(getDoubleValue(sheet_4,rowNum,10));
        			ave.setAve2(getDoubleValue(sheet_4,rowNum,11));
        			ave.setAve3(getDoubleValue(sheet_4,rowNum,12));
        			ave.setAve4(getDoubleValue(sheet_4,rowNum,13));
        			ave.setAve5(getDoubleValue(sheet_4,rowNum,14));
        			
        			method.invoke(aveCollect,ave);
        		}
        		iqRatios.setJsonAveCollect(JSON.toJSONString(aveCollect));
        		iqRatiosMapper.insertSelective(iqRatios);
            }else if("qy".equalsIgnoreCase(type)){
                Com com=new Com();
                com.setProCode(proCode);
                ComInfo comInfo=new ComInfo();
                comInfo.setProCode(proCode);
                
                //QY_2_被评估单位基本信息
                Sheet sheet_5=workbook.getSheetAt(0);
                com.setName(getStringValue(sheet_5,2,1));
                com.setAddress(getStringValue(sheet_5,2,7));
                com.setTaxRate(BigDecimal.valueOf(getDoubleValue(sheet_5,2,10)));
                com.setRepresentative(getStringValue(sheet_5,3,1));
                com.setBusScope(getStringValue(sheet_5,5,1));
                Double setupDate=getDoubleValue(sheet_5,5,8);
                if(setupDate!=null){
                	com.setSetupDate(DateUtil.getJavaDate(setupDate));
                }
                com.setBusTerm(getStringValue(sheet_5,5,10));
                com.setPhone(getStringValue(sheet_5,4,1));
                com.setEmail(getStringValue(sheet_5,4,5));
                com.setCreateDate(new Date());
                
                //QY_3_被评估单子公司表
                Sheet sheet_6=workbook.getSheetAt(1);
                List<String> subComs=new ArrayList<>();
                int rowNum=4;
                while(true){
                	String subComName=getStringValue(sheet_6, rowNum,2);
                	if(StringUtils.isNotBlank(subComName)){
                		subComs.add(subComName);
                		rowNum++;
                	}else{
                		break;
                	}
                }
                if (!subComs.isEmpty()) {
    				com.setJsonComSub(JSON.toJSONString(subComs));
    			}
                comMapper.insertSelective(com);
                
                //QY_4_被评估单位资产负债表
                Sheet sheet_7=workbook.getSheetAt(2);
                List<Balance> balances=getValueByBlock(sheet_7, 1, 6, Balance.class);
                comInfo.setJsonBalance(JSON.toJSONString(balances)); 
                
                //QY_5_被评估单位利润表
                Sheet sheet_8=workbook.getSheetAt(3);
                List<Profit> profits=getValueByBlock(sheet_8, 1, 6, Profit.class);
                comInfo.setJsonProfit(JSON.toJSONString(profits)); 
                
                //QY _6_  企业财务比率指标
                Sheet sheet_9=workbook.getSheetAt(4);
                List<Ratios> ratios=getValueByBlock(sheet_9, 1, 6, Ratios.class);
                comInfo.setJsonRatios(JSON.toJSONString(ratios));
                List<RatiosGrowthAve> ratiosGrowthAves=getValueByBlock(sheet_9, 8, 12, RatiosGrowthAve.class);
                comInfo.setJsonRatiosGrowthAve(JSON.toJSONString(ratiosGrowthAves));
                
                comInfoMapper.insertSelective(comInfo);
                
                //QY_7_被评估单位销售收入及财务指标表
                Sheet sheet_10=workbook.getSheetAt(5);
                Double productCount=getDoubleValue(sheet_10,3,1);
                if(productCount!=null){
                	if(productCount==0){
                		throw new Exception("企业产品数量不能为0");
                	}
                	for (int i = 0; i < productCount; i++) {
        				String productName=getStringValue(sheet_10,11,i*13+2);
        				if(StringUtils.isBlank(productName)){
        					throw new Exception("公司产品数量与实际填写内容不符合");
        				}
        				ComProduct comProduct=new ComProduct();
        				comProduct.setProCode(proCode);
        				comProduct.setName(productName);
        				
        				ComProductInfo comProductInfo=new ComProductInfo();
        				List<Product> products=getValueByBlock(sheet_10,(i*13+1), (i*13+6), Product.class);
        				List<ProductAve> productAves=getValueByBlock(sheet_10,(i*13+8),(i*13+12), ProductAve.class);
        				comProductInfo.setProducts(products);
        				comProductInfo.setProductAves(productAves);
        				//计算
        				List<Double> r31=new ArrayList<>();
        				for (int t=0;t<products.size();t++) {
							Product product=products.get(products.size()-t-1);
							r31.add(product.getR31());
						}
        				comProductInfo.setR31_ave(calAve(r31));
        				List<Double> r29=new ArrayList<>();
        				for (int t=0;t<products.size();t++) {
							Product product=products.get(products.size()-t-1);
							r29.add(product.getR29());
						}
        				comProductInfo.setR29_ave(calAve(r29));
        				List<Double> r30=new ArrayList<>();
        				for (int t=0;t<products.size();t++) {
							Product product=products.get(products.size()-t-1);
							r30.add(product.getR30());
						}
        				comProductInfo.setR30_ave(calAve(r30));
        				List<Double> r21=new ArrayList<>();
        				for (int t=0;t<products.size();t++) {
							Product product=products.get(products.size()-t-1);
							r21.add(product.getR21());
						}
        				comProductInfo.setR21_ave(calAve(r21));
        				List<Double> r20=new ArrayList<>();
        				for (int t=0;t<products.size();t++) {
							Product product=products.get(products.size()-t-1);
							r20.add(product.getR20());
						}
        				comProductInfo.setR20_ave(calAve(r20));
        				List<Double> r24=new ArrayList<>();
        				for (int t=0;t<products.size();t++) {
							Product product=products.get(products.size()-t-1);
							r24.add(product.getR24());
						}
        				comProductInfo.setR24_ave(calAve(r24));
        				List<Double> r33=new ArrayList<>();
        				for (int t=0;t<products.size();t++) {
							Product product=products.get(products.size()-t-1);
							r33.add(product.getR33());
						}
        				comProductInfo.setR33_ave(calAve(r33));
        				comProduct.setJsonInfo(JSON.toJSONString(comProductInfo));
        				comProductMapper.insertSelective(comProduct);
        			}
                }else{
                	throw new Exception("企业产品数量不能为空");
                }
                
                //QY_11_专利研发成本统计表
                Sheet sheet_11=workbook.getSheetAt(6);
                ComDevCost comDevCost=new ComDevCost();
                comDevCost.setProCode(proCode);
                Double startDate=getDoubleValue(sheet_11,1,1);
                Double endDate=getDoubleValue(sheet_11,2,1);
                comDevCost.setStartDate(startDate==null?null:DateUtil.getJavaDate(startDate));
                comDevCost.setEndDate(endDate==null?null:DateUtil.getJavaDate(endDate));
                comDevCost.setCycle(getBigDecimalVal(sheet_11,3,1));
                comDevCost.setE23(getBigDecimalVal(sheet_11,22,4));
                comDevCost.setF23(getBigDecimalVal(sheet_11,22,5));
                comDevCost.setC25(getBigDecimalVal(sheet_11,24,2));
                comDevCost.setC28(getBigDecimalVal(sheet_11,27,2));
                comDevCost.setC29(getBigDecimalVal(sheet_11,28,2));
                comDevCost.setC30(getBigDecimalVal(sheet_11,29,2));
                comDevCost.setC31(getBigDecimalVal(sheet_11,30,2));
                comDevCost.setC32(getBigDecimalVal(sheet_11,31,2));
                comDevCost.setC33(getBigDecimalVal(sheet_11,32,2));
                comDevCost.setC34(getBigDecimalVal(sheet_11,33,2));
                comDevCost.setC35(getBigDecimalVal(sheet_11,34,2));
                comDevCostMapper.insertSelective(comDevCost);
            }else{
                //GZ_1_国专_专利交易案例
                Sheet sheet_12=workbook.getSheetAt(0);
                Double caseCount=getDoubleValue(sheet_12,3,1);
                for (int i = 0; i < caseCount; i++) {
    				String caseName=getStringValue(sheet_12,5,2+i);
    				if(StringUtils.isBlank(caseName)){
    					throw new Exception("交易案例数量与实际填写内容不符合");
    				}
    				ComCase comCase=new ComCase();
    				comCase.setProCode(proCode);
    				comCase.setName(caseName);
    				comCase.setPatt(getStringValue(sheet_12,7,2+i));
    				comCase.setTi(getStringValue(sheet_12,8,2+i));
    				comCase.setPn(getStringValue(sheet_12,9,2+i));
    				comCase.setPatentee(getStringValue(sheet_12,10,2+i));
    				Double adDate=getDoubleValue(sheet_12,11,2+i);
    				comCase.setAd(adDate==null?null:DateUtil.getJavaDate(adDate));
    				comCase.setMarket((String)getStringValue(sheet_12,12,2+i));
    				comCase.setPrice(getBigDecimalVal(sheet_12,14,2+i));
    				Double transDate=getDoubleValue(sheet_12,15,2+i);
    				comCase.setTransDate(transDate==null?null:DateUtil.getJavaDate(transDate));
    				comCaseMapper.insertSelective(comCase);
    			}
                
                
                //ZL_1_可比公司母子公司表
                Sheet sheet_13=workbook.getSheetAt(1);
                Map<String, List<String>> iqSubComs=new HashMap<String,List<String>>();
                int beginRow=4;
                while(true){
                	String iqComName=getStringValue(sheet_13,beginRow,1);
                	String iqSubComName=getStringValue(sheet_13,beginRow,4);
                	if(StringUtils.isBlank(iqComName) || StringUtils.isBlank(iqSubComName)){
                		break;
                	}
                	if(iqSubComs.containsKey(iqComName)){
                		List<String> iqSubComNames=iqSubComs.get(iqComName);
                		iqSubComNames.add(iqSubComName);
                	}else{
                		List<String> iqSubComNames=new ArrayList<>();
                		iqSubComNames.add(iqSubComName);
                		iqSubComs.put(iqComName, iqSubComNames);
                	}
                	beginRow++;
                }
                
                IqComExample iqComExample=new IqComExample();
                iqComExample.createCriteria().andProCodeEqualTo(proCode);
                List<IqCom> iqComs=iqComMapper.selectByExample(iqComExample);
                for (IqCom iqCom : iqComs) {
    				if(iqSubComs.containsKey(iqCom.getName())){
    					List<String> iqSubComName=iqSubComs.get(iqCom.getName());
    					iqCom.setJsonComSub(JSON.toJSONString(iqSubComName));
    					iqComMapper.updateByPrimaryKeySelective(iqCom);
    				}
    			}
            }
        }catch (Exception e) {
        	e.printStackTrace();
        	logger.error("解析excel模板出错("+proCode+")："+e.getStackTrace());
        	throw e;
		} finally {
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error("关闭workbook出错("+proCode+")："+e.getStackTrace());
                    throw e;
                }
            }
            if (inp != null) {
                try {
                    inp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error("关闭InputStream出错("+proCode+")："+e.getStackTrace());
                    throw e;
                }
            }
        }
	}
	public <T> List<T> getValueByBlock(Sheet sheet,int begieCellNum,int endCellNum,Class<T> model) throws Exception{
		List<T> modelList=new ArrayList<>();
		for(int t=begieCellNum;t<=endCellNum;t++){
			T object=model.newInstance();
			modelList.add(object);
		}
		Field[] fields=model.getFields();
		for (Field field : fields) {
			String fieldName=field.getName();
			Method method=model.getMethod("set"+CommonUtil.toUpperCaseFirstOne(fieldName), field.getType());
			int rowNum=Integer.parseInt(fieldName.substring(1));
			Row row=sheet.getRow(rowNum-1);
			for (int i=begieCellNum; i <=endCellNum; i++) {
				Cell cell=row.getCell(i);
				Object value=getCellValue(cell);
				if(value!=null){
					T object=modelList.get(i-begieCellNum);
					if (field.getType()==Date.class) {
						if(value!=null && value.getClass()==Double.class){
							double doubleValue=(double)value;
							method.invoke(object, DateUtil.getJavaDate(doubleValue));
						}
					}else if(field.getType()==Double.class){
						if(value!=null && value.getClass()==Double.class){
							BigDecimal b=new  BigDecimal((double)value); 
							double doubleValue=b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
							method.invoke(object,doubleValue);
						}
					}else{
						String stringValue=String.valueOf(value);
						Constructor<?> constructor = field.getType().getConstructor(String.class);
						method.invoke(object, constructor.newInstance(stringValue));
					}
				}
			}
		}
		return modelList;
	}
	/**
	 * 返回String类型数据
	 * @param sheet
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	public String getStringValue(Sheet sheet,int rowNum,int cellNum){
		Row row=sheet.getRow(rowNum);
		Cell cell=row.getCell(cellNum);
		Object value=getCellValue(cell);
		
		if(value==null){
			return null;
		}
		if(value.getClass()==Boolean.class){
			boolean bValue=(boolean)value;
			if(bValue){
				return "true";
			}else{
				return "false";
			}
		}
		if(value.getClass()==Double.class){
			Double doubleValue=(double)value;
			return String.valueOf(doubleValue);
		}
		return (String)value;
	}
	/**
	 * 返回Double类型数据
	 * @param sheet
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	public Double getDoubleValue(Sheet sheet,int rowNum,int cellNum){
		Row row=sheet.getRow(rowNum);
		Cell cell=row.getCell(cellNum);
		Object value=getCellValue(cell);
		
		if(value==null){
			return null;
		}
		if(value.getClass()==Boolean.class){
			boolean bValue=(boolean)value;
			if(bValue){
				return (double)1.00;
			}else{
				return (double)0.00;
			}
		}
		if(value.getClass()==String.class){
			try {
				Double doubleValue=Double.valueOf((String)value);
				return doubleValue;
			} catch (NumberFormatException e) {
				return null;
			}
		}
		
		BigDecimal b=new  BigDecimal((double)value); 
		return b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	/**
	 * 返回BigDecimal类型数据
	 * @param sheet
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	public BigDecimal getBigDecimalVal(Sheet sheet,int rowNum,int cellNum){
		Double doubleValue=getDoubleValue(sheet,rowNum,cellNum);
		if(doubleValue==null){
			return null;
		}
		return BigDecimal.valueOf(doubleValue);
	}
	
	@SuppressWarnings("deprecation")
	public Object getCellValue(Cell cell){
		FormulaEvaluator evaluator=cell.getSheet().getWorkbook().getCreationHelper().createFormulaEvaluator();
        switch (cell.getCellTypeEnum()) {
        case _NONE:
            return null;
        case BLANK:
        	return null;
        case BOOLEAN:
        	return cell.getBooleanCellValue();
        case ERROR:
        	return null;
        case FORMULA:
            CellValue cellValue = evaluator.evaluate(cell);
            switch (cellValue.getCellTypeEnum()) {
            case _NONE:
            	return null;
            case BLANK:
            	return null;
            case BOOLEAN:
            	return cellValue.getBooleanValue();
            case ERROR:
            	return null;
            case NUMERIC:
            	return cellValue.getNumberValue();
            case STRING:
            	return cellValue.getStringValue();
            default:
                break;
            }
            break;
        case NUMERIC:
        	return cell.getNumericCellValue();
        case STRING:
        	return cell.getStringCellValue();
        }
        return null;
	}
	/**
	 * 计算增长率
	 * @param dataList
	 * @return
	 */
	public Ave calAve(List<Double> dataList){
		Ave ave=new Ave();
		
		Double data_0=dataList.get(0);
		Double data_1=dataList.get(1);
		Double data_2=dataList.get(2);
		Double data_3=dataList.get(3);
		Double data_4=dataList.get(4);
		Double data_5=dataList.get(5);
		
		Double data_rate_0=null;
		Double data_rate_1=null;
		Double data_rate_2=null;
		Double data_rate_3=null;
		Double data_rate_4=null;
		
		if(data_1!=null && data_0!=null && data_1!=0){
			data_rate_0=(data_0-data_1)/data_1;
		}
		if(data_2!=null && data_1!=null && data_2!=0){
			data_rate_1=(data_1-data_2)/data_2;
		}
		if(data_3!=null && data_2!=null && data_3!=0){
			data_rate_2=(data_2-data_3)/data_3;
		}
		if(data_4!=null && data_3!=null && data_4!=0){
			data_rate_3=(data_3-data_4)/data_4;
		}
		if(data_5!=null && data_4!=null && data_5!=0){
			data_rate_4=(data_4-data_5)/data_5;
		}
		
		int count=0;
		double sumVal=0;
		if(data_rate_0!=null){
			sumVal=Double.sum(sumVal,data_rate_0);
			count++;
		}
		double data_ave=sumVal;
		if(data_rate_1!=null){
			sumVal=Double.sum(sumVal,data_rate_1);
			count++;
		}
		double data_ave_2=sumVal/(count==0?1:count);
		if(data_rate_2!=null){
			sumVal=Double.sum(sumVal,data_rate_2);
			count++;
		}
		double data_ave_3=sumVal/(count==0?1:count);
		if(data_rate_3!=null){
			sumVal=Double.sum(sumVal,data_rate_3);
			count++;
		}
		double data_ave_4=sumVal/(count==0?1:count);
		if(data_rate_4!=null){
			sumVal=Double.sum(sumVal,data_rate_4);
			count++;
		}
		double data_ave_5=sumVal/(count==0?1:count);
		
		BigDecimal big_data_rate_0=new  BigDecimal(data_ave); 
		ave.setAve(big_data_rate_0.setScale(4,BigDecimal.ROUND_HALF_UP).doubleValue());
		BigDecimal big_data_rate_2=new  BigDecimal(data_ave_2); 
		ave.setAve2(big_data_rate_2.setScale(4,BigDecimal.ROUND_HALF_UP).doubleValue());
		BigDecimal big_data_rate_3=new  BigDecimal(data_ave_3); 
		ave.setAve3(big_data_rate_3.setScale(4,BigDecimal.ROUND_HALF_UP).doubleValue());
		BigDecimal big_data_rate_4=new  BigDecimal(data_ave_4); 
		ave.setAve4(big_data_rate_4.setScale(4,BigDecimal.ROUND_HALF_UP).doubleValue());
		BigDecimal big_data_rate_5=new  BigDecimal(data_ave_5); 
		ave.setAve5(big_data_rate_5.setScale(4,BigDecimal.ROUND_HALF_UP).doubleValue());
		
		return ave;
	}
}
