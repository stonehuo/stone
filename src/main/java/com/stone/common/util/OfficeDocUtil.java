package com.kpap.common.util;



import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.log4j.Logger;
import org.apache.poi.POITextExtractor;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.extractor.ExtractorFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.springframework.util.Assert;


/**
 * 
 * 微软Office文档操作实用类<BR>
 *
 * @auther shenhaiwen
 * @date 2016-12-11 下午10:34:28
 */
public class OfficeDocUtil {
	private static Logger log = Logger.getLogger(OfficeDocUtil.class);
	//字段间合并分隔符
	public static final String FIELD_DIV = "；";
	//字段内合并分隔符
	public static final String FIELD_IN_DIV = " ";
	public static final String DEFAULT_SHEET = "Sheet1";// 默认表格的名称
	public static final String DEFAULT_SHEET2 = "被评估公司财务状况";// 默认表格的名称
	public static final String DEFAULT_SHEET3 = "Sheet3";// 默认表格的名称

	public static final String BOLD_NORMAL = "0";// 样式：正常
	public static final String BOLD_WEIGHT = "1";// 样式：加粗
	
	public static final String BORDER_NULL = "0";// 样式：无边框
	public static final String BORDER_HAS = "1";// 样式：有边框
	
	public static final String ALIGN_LEFT = "-1";// 样式：左对齐
	public static final String ALIGN_CENTER = "0";// 样式：居中对齐
	public static final String ALIGN_RIGHT = "1";// 样式：右对齐
	/**
	 * 读取2007版以上的word文档
	 * @param filePath 文件路径
	 * @return 读取的2007版以上的word文档内容
	 * @throws Exception 异常
	 */
	public static String readDocx(String filePath) throws Exception{
		OPCPackage opcPackage = POIXMLDocument.openPackage(filePath);
		POIXMLTextExtractor extractor;
		String text = "";
		try {
			extractor = new XWPFWordExtractor(opcPackage);
			text = extractor.getText();
		} catch (Exception e) {
			log.error("读取doc内容文本时出错:"+e);
			//throw e;
		}
		return text;
	}
	
	
//	/**
//	 * 读取2003版以下的word文档
//	 * @param filePath 文件路径
//	 * @return 读取的2003版以下的word文档内容
//	 * @throws Exception 异常
//	 */
//	public static String readDoc(String filePath) throws Exception{
//		InputStream is = null;
//		WordExtractor extractor = null;
//		String text = "";
//		try {
//			is = new FileInputStream(filePath);
//			extractor = new WordExtractor(is);
//			text = extractor.getText();
//		} catch (Exception e) {
//			log.error("读取doc内容文本时出错："+e);
//			//throw e;
//		}
//		return text;
//	}
	
	/**
	 * 读取2003版以下的excel文档
	 * @param filePath 文件路径
	 * @return excel文档内容
	 * @throws Exception 
	 * 
	 */
	public static List<List<List<List<String>>>> readXls2(String filePath) throws Exception{
		List<List<List<List<String>>>> dataList = new ArrayList<List<List<List<String>>>>();
		POIFSFileSystem fs = new POIFSFileSystem(
			new FileInputStream(filePath)
		);
		// 创建工作簿对象
		HSSFWorkbook workBook = new HSSFWorkbook(fs);
		/*
		 * 获得Excel中工作表个数
		 */
		for (int i = 0; i < workBook.getNumberOfSheets(); i++) {
			// 创建工作表
			HSSFSheet sheet = workBook.getSheetAt(i);
			int rows = sheet.getPhysicalNumberOfRows(); // 获得行数
			List<List<List<String>>> sheetList = new ArrayList<List<List<String>>>();
			if (rows > 0) {
				List<List<String>> recordList = new ArrayList<List<String>>();
				sheet.getMargin(HSSFSheet.TopMargin);
				for (int j = 0; j < rows; j++) { // 行循环
					List<String> rowList = new ArrayList<String>();
					HSSFRow row = sheet.getRow(j);
					if (row != null) {
						int cells = row.getLastCellNum();//获得列数
						for (int k = 0; k < cells; k++) { // 列循环
							HSSFCell cell = row.getCell(k);
							String value = "";
							if (cell != null) {
								switch (cell.getCellType()) {
								case HSSFCell.CELL_TYPE_NUMERIC: // 数值型
									if (HSSFDateUtil.isCellDateFormatted(cell)) {
										//如果是date类型则 ，获取该cell的date值
										value = HSSFDateUtil.getJavaDate(
													cell.getNumericCellValue())
												.toString();
									} else {//纯数字
										value = String.valueOf(cell.getNumericCellValue());
									}
									break;
								/* 此行表示单元格的内容为string类型 */
								case HSSFCell.CELL_TYPE_STRING: // 字符串型
									value = cell.getRichStringCellValue()
											.toString();
									break;
								case HSSFCell.CELL_TYPE_FORMULA://公式型
									//读公式计算值
									value = String.valueOf(cell
											.getNumericCellValue());
									if (value.equals("NaN")) {//如果获取的数据值为非法值,则转换为获取字符串
										value = cell
												.getRichStringCellValue()
												.toString();
									}
									//cell.getCellFormula();读公式
									break;
								case HSSFCell.CELL_TYPE_BOOLEAN://布尔
									value = FIELD_IN_DIV
											+ cell.getBooleanCellValue();
									break;
								/* 此行表示该单元格值为空 */
								case HSSFCell.CELL_TYPE_BLANK: // 空值
									value = "";
									break;
								case HSSFCell.CELL_TYPE_ERROR: // 故障
									value = "";
									break;
								default:
									value = cell.getRichStringCellValue()
											.toString();
								}
							}
							rowList.add(value);
						}
					}
					recordList.add(rowList);
				}
				sheetList.add(recordList);
			}
			dataList.add(sheetList);
		}
		return dataList;
	}
	
	/**
	 * 读取2007版以上的excel文档
	 * @param filePath 文件路径
	 * @return excel文档内容
	 * @throws Exception 
	 * 
	 */
	public static List<List<List<List<String>>>> readXlsx2(String filePath) throws Exception{
		List<List<List<List<String>>>> dataList = new ArrayList<List<List<List<String>>>>();
		// 创建工作簿对象
		XSSFWorkbook workBook = new XSSFWorkbook(filePath);
		/*
		 * 获得Excel中工作表个数
		 */
		for (int i = 0; i < workBook.getNumberOfSheets(); i++) {
			// 创建工作表
			XSSFSheet sheet = workBook.getSheetAt(i);
			int rows = sheet.getLastRowNum(); // 获得行数
			List<List<List<String>>> sheetList = new ArrayList<List<List<String>>>();
			if (rows >= 0) {
				List<List<String>> recordList = new ArrayList<List<String>>();
				sheet.getMargin(HSSFSheet.TopMargin);
				for (int j = 0; j <= rows; j++) { // 行循环
					List<String> rowList = new ArrayList<String>();
					XSSFRow row = sheet.getRow(j);
					if (row != null) {
						int cells = row.getLastCellNum();//获得列数
						for (int k = 0; k < cells; k++) { // 列循环
							XSSFCell cell = row.getCell(k);
							String value = "";
							if (cell != null) {
								switch (cell.getCellType()) {
								case XSSFCell.CELL_TYPE_NUMERIC: // 数值型
									if (HSSFDateUtil.isCellDateFormatted(cell)) {
										//如果是date类型则 ，获取该cell的date值
										value = HSSFDateUtil.getJavaDate(
													cell.getNumericCellValue())
												.toString();
									} else {//纯数字
										value = String.valueOf(cell.getNumericCellValue());
									}
									break;
								/* 此行表示单元格的内容为string类型 */
								case XSSFCell.CELL_TYPE_STRING: // 字符串型
									value = cell.getRichStringCellValue()
											.toString();
									break;
								case XSSFCell.CELL_TYPE_FORMULA://公式型
									//读公式计算值
									value = String.valueOf(cell
											.getNumericCellValue());
									if (value.equals("NaN")) {//如果获取的数据值为非法值,则转换为获取字符串
										value = cell
												.getRichStringCellValue()
												.toString();
									}
									//cell.getCellFormula();读公式
									break;
								case XSSFCell.CELL_TYPE_BOOLEAN://布尔
									value = FIELD_IN_DIV
											+ cell.getBooleanCellValue();
									break;
								/* 此行表示该单元格值为空 */
								case XSSFCell.CELL_TYPE_BLANK: // 空值
									value = "";
									break;
								case HSSFCell.CELL_TYPE_ERROR: // 故障
									value = "";
									break;
								default:
									value = cell.getRichStringCellValue()
											.toString();
								}
							}
							rowList.add(value);
						}
					}
					recordList.add(rowList);
				}
				sheetList.add(recordList);
			}
			dataList.add(sheetList);
		}
		return dataList;
	}
	
	/**
	 * 读取2003版以下的excel文档
	 * @param filePath 文件路径
	 * @return 读取的2003版以下的excel文档内容
	 * 
	 */
	public static String readXls(String filePath){
		StringBuffer content = new StringBuffer();
		try{
			POIFSFileSystem fs = new POIFSFileSystem(
				new FileInputStream(filePath)
			);
			// 创建工作簿对象
			HSSFWorkbook workBook = new HSSFWorkbook(fs);
			/*
			 * 获得Excel中工作表个数
			 */
			for (int i = 0; i < workBook.getNumberOfSheets(); i++) {
				content.append(FIELD_IN_DIV).append(workBook.getSheetName(i)).append("：");
				// 创建工作表
				HSSFSheet sheet = workBook.getSheetAt(i);
				int rows = sheet.getPhysicalNumberOfRows(); // 获得行数
				if (rows > 0) {
					sheet.getMargin(HSSFSheet.TopMargin);
					for (int j = 0; j < rows; j++) { // 行循环
						HSSFRow row = sheet.getRow(j);
						if (row != null) {
							int cells = row.getLastCellNum();//获得列数
							for (int k = 0; k < cells; k++) { // 列循环
								HSSFCell cell = row.getCell(k);
								if (cell != null) {
									String value = "";
									switch (cell.getCellType()) {
									case HSSFCell.CELL_TYPE_NUMERIC: // 数值型
										if (HSSFDateUtil.isCellDateFormatted(cell)) {
											//如果是date类型则 ，获取该cell的date值
											value = HSSFDateUtil.getJavaDate(
														cell.getNumericCellValue())
													.toString();
										} else {//纯数字
											value = String.valueOf(cell.getNumericCellValue());
										}
										break;
									/* 此行表示单元格的内容为string类型 */
									case HSSFCell.CELL_TYPE_STRING: // 字符串型
										value = cell.getRichStringCellValue()
												.toString();
										break;
									case HSSFCell.CELL_TYPE_FORMULA://公式型
										//读公式计算值
										value = String.valueOf(cell
												.getNumericCellValue());
										if (value.equals("NaN")) {//如果获取的数据值为非法值,则转换为获取字符串
											value = cell
													.getRichStringCellValue()
													.toString();
										}
										//cell.getCellFormula();读公式
										break;
									case HSSFCell.CELL_TYPE_BOOLEAN://布尔
										value = FIELD_IN_DIV
												+ cell.getBooleanCellValue();
										break;
									/* 此行表示该单元格值为空 */
									case HSSFCell.CELL_TYPE_BLANK: // 空值
										value = "";
										break;
									case HSSFCell.CELL_TYPE_ERROR: // 故障
										value = "";
										break;
									default:
										value = cell.getRichStringCellValue()
												.toString();
									}
									content.append(FIELD_IN_DIV).append(value).append(FIELD_IN_DIV);
								}
							}
						}
					}
				}
			}
		} catch (IOException e){
			log.error("读取xls内容文本时出错："+e);
			//throw e;
		}
		return content.toString();
	}
	/**
	 * 读取2007版以上的excel文档
	 * @param filePath 文件路径
	 * @return 读取的2007版以上的excel文档内容
	 * @throws Exception 异常
	 */
	public static String readXlsx(String filePath) throws Exception{
		StringBuffer content = new StringBuffer();
		FileInputStream fs = null;
		try {
			// 构造 XSSFWorkbook 对象，strPath 传入文件路径
			fs = new FileInputStream(filePath);
			XSSFWorkbook xwb = new XSSFWorkbook(fs);
			// 读取第一章表格内容
			XSSFSheet sheet = xwb.getSheetAt(0);
			// 定义 row、cell
			XSSFRow row;
			XSSFCell cell;
			// 循环输出表格中的内容
			for (int i = sheet.getFirstRowNum(); i < sheet.getLastRowNum(); i++) {
				row = sheet.getRow(i);
				for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
					// 通过 row.getCell(j).toString() 获取单元格内容，
					cell = row.getCell(j);
					String cellStr = "";
					if(cell != null){
						cellStr = cell.toString();
					}
					content.append(cellStr).append(FIELD_DIV);
				}
				content.append(System.getProperty("line.separator"));
			}
		} catch (Exception e) {
			log.error("读取xlsx内容文本时出错：" + e);
			// throw e;
		} finally {
			if (null != fs){
				fs.close();
			}
		}
		return content.toString();
	}
//	/**
//	 * 读取2003版以下的ppt文档
//	 * @param filePath 文件路径
//	 * @return 读取的2003版以下的ppt文档内容
//	 * @throws Exception 异常
//	 */
//	public static String readPpt(String filePath) throws Exception{
//		StringBuffer content = new StringBuffer();
//		try{
//			//得到源文件
//			SlideShow ss = new SlideShow(new HSLFSlideShow(filePath));
//			//得到源文件中的幻灯片数量
//			Slide[] slides = ss.getSlides();
//			for (int i = 0; i < slides.length; i++) {
//				Slide sl = slides[i];
//				String title = sl.getTitle();
//				if(null!=title && !"".equals(title.trim())){
//					content.append(title).append(FIELD_IN_DIV);
//				}
//				//得到每张幻灯片中的字符串数量
//				TextRun[] tr = sl.getTextRuns();
//				for (int j = 0; j < tr.length; j++) {
//					content.append(tr[j].getText()).append(FIELD_IN_DIV);
//				}
//			}
//		} catch (Exception e){
//			log.error("读取ppt内容文本时出错："+e);
//			//throw e;
//		}
//		return content.toString();
//	}
	/**
	 * 读取2007及以上的pptx文档的内容
	 * @param filePath 文件路径
	 * @return 读取的2007版以上的pptx文档内容
	 * @throws Exception 异常
	 */
	public static String readPptx(String filePath) throws Exception{
		File inputFile = new File(filePath);
		POITextExtractor extractor = ExtractorFactory.createExtractor(inputFile);
		
		return extractor.getText();
	}
	/**
	 * 操作excel文档（兼容xls及xlsx）
	 * @param srcPath 源路径
	 * @param destPath 目标路径
	 * @param sheetName sheet名
	 * @param axisValueMap 坐标值map
	 * @throws Exception 
	 */
	public static void modifyXls(String srcPath, String destPath, 
			String sheetName, Map<Axis, Object> axisValueMap) throws Exception{
		/* 
		 * 1.读取文档
		 */
		FileInputStream fis = null;
		Workbook wb = null;
		try{
			fis = new FileInputStream(srcPath);
			if(srcPath.toLowerCase().endsWith("x")){
				wb = new XSSFWorkbook(fis);
			}else{
				wb = new HSSFWorkbook(fis);
			}
		} catch (Exception e){
			log.debug("读取excel文档时出错："+e);
			throw e;
		} finally {
			if(null!=fis) {
				fis.close();
			}
		}
		/*
		 * 2.操作文档
		 */
		//CreationHelper helper = wb.getCreationHelper();
		Sheet sheet = wb.getSheet(sheetName);
		if(null!=axisValueMap){
			//for(Axis axis : axisValueMap.keySet()){
			for(Entry<Axis, Object> entry: axisValueMap.entrySet()){
				Axis axis=entry.getKey();
				String value = axisValueMap.get(axis).toString();
				Row row = sheet.getRow(axis.getRow());
				Cell cell = row.getCell(axis.getCol());
				
				cell.setCellValue(value);
			}
		}
		/*
		 * 3.写入文档
		 */
		FileOutputStream fos = null;
		try{
			fos = new FileOutputStream(destPath);
			wb.write(fos);
		} catch (Exception e){
			log.debug("写入excel文档时出错："+e);
			throw e;
		} finally {
			if(null!=fos) {
				fos.close();
			}
		}
	}
	
	/**
	 * 通用生成Excel文件内容，并写入给定的输出流
	 * @param out 输出流
	 * @param dataMap 数据map
	 * @param isOldVer 是否旧版
	 * @throws Exception 异常
	 */
	public static void writeXls(OutputStream out,Map<String, List<XlsCellVo>> dataMap,boolean isOldVer) throws Exception{
		Workbook wb = null;
		if(isOldVer){
		    wb = new HSSFWorkbook();
		}else{
		    wb = new XSSFWorkbook();
		}
	    int colMaxLen = 0;
	    Map<String, CellStyle> styleMap = new HashMap<String, CellStyle>();
	    for(Entry<String, List<XlsCellVo>> data : dataMap.entrySet()){
	    	Sheet sheet = wb.createSheet(data.getKey());
	    	List<XlsCellVo> cellVoList = data.getValue();
	    	for(XlsCellVo cellVo : cellVoList){
	            Assert.notNull(cellVo.getX(), "单元格X坐标不能为空");
	            Assert.notNull(cellVo.getY(), "单元格X坐标不能为空");
		    	Row row = sheet.getRow(cellVo.getX());
		    	if(row == null){
		    		row = sheet.createRow(cellVo.getX());
		    	}
		    	Cell cell = row.getCell(cellVo.getY());
		    	if(cell == null){
		    		cell = row.createCell(cellVo.getY());
		    	}
		    	String value = "";
		    	if(cellVo.getValue() != null){
		    		if(cellVo.getValue().getClass()==Double.class){
		    			Double double_value=(Double)cellVo.getValue();
		    			BigDecimal b=BigDecimal.valueOf(double_value);
		    			value=b.setScale(2,BigDecimal.ROUND_HALF_UP).toString();
		    		}else{
		    			value=cellVo.getValue().toString();
		    		}
		    		
		    	}
		    	cell.setCellValue(value);
		    	if(cellVo.getBoldType() != null || cellVo.getBorderType() != null || cellVo.getAlignType() != null){
		    		String key = cellVo.getBoldType() + cellVo.getBorderType() + cellVo.getAlignType();
		    		if(!styleMap.containsKey(key)){
			    		styleMap.put(key,createExcelStyleTemp(wb, cellVo.getBoldType(), cellVo.getBorderType(), cellVo.getAlignType()));
		    		}
		    		cell.setCellStyle(styleMap.get(key));
		    	}
		    	if(cellVo.getY() > colMaxLen){
		    		colMaxLen = cellVo.getY();
		    	}
	    	}
	    	for(int i = 0; i < colMaxLen + 1; i++){
				sheet.autoSizeColumn(i);
	    	}
	    }
	    wb.write(out);
	}
	
	/**
	 * Description: 生成Excel文件内容，并写入给定的输出流
	 * @param out 
	 * @param titleRowList 
	 * @param keyList  
	 * @param dataList   
	 * @param isAutoSize 
	 * @throws Exception 
	 * @Author liufei
	 * Create Date: 2011-12-12 下午4:09:49
	 */
	public static void writeXlsx(OutputStream out, List<List<String>> titleRowList, 
			List<String> keyList, List<?> dataList, boolean isAutoSize) throws Exception{
		//创建工作簿
		XSSFWorkbook workbook = new XSSFWorkbook();
		//创建默认表格
		XSSFSheet sheet = workbook.getSheet(DEFAULT_SHEET);
		if (null == sheet){
			sheet = workbook.createSheet(DEFAULT_SHEET);
		}
		//写入表头
		XSSFCellStyle titleStyle = createExcelTitleStyle(workbook);
		for(int rowNum = 0; rowNum<titleRowList.size(); rowNum++){
			List<String> titleRow = titleRowList.get(rowNum);
			XSSFRow row = sheet.createRow(rowNum);
			for(int colNum = 0; colNum<titleRow.size(); colNum++){
				String titleCol = titleRow.get(colNum);
				
				XSSFCell cell = row.createCell(colNum);
				cell.setCellStyle(titleStyle);
				XSSFRichTextString text = new XSSFRichTextString(titleCol);
				cell.setCellValue(text);
			}
			
		}
		//写入表体
		XSSFCellStyle contentStyle = createContentStyle(workbook);
		int columnIndex = sheet.getPhysicalNumberOfRows();
		for(Object data : dataList){
			XSSFRow row = sheet.createRow(columnIndex);
			for(int colNum = 0; colNum<keyList.size(); colNum++){
				String key = keyList.get(colNum);
				Object value = PropertyUtils.getProperty(data, key);
				
				if (null != value) {
					XSSFCell cell = row.createCell(colNum);
					cell.setCellStyle(contentStyle);
					String textValue = null;
					if (value instanceof Date) {
						Date date = (Date) value;
						textValue = DateUtil.date2Str(date, null);
								
					} else {
						textValue = value.toString();
					}
					if (textValue != null) {
						cell.setCellValue(textValue);
					}
				}
			}
			++columnIndex;
		}
		
		if(isAutoSize){
			//重设单元格宽度
			for (int i = 0; i < keyList.size(); i++) {
				sheet.autoSizeColumn(i);
			}
		}
		
		workbook.write(out);
	}

	/**
	 * 通用生成Excel文件内容，并返回输入流
	 * @param dataMap 数据map
	 * @param isOldVer 是否旧版
	 * @throws Exception 异常
	 */
	public static InputStream writeXls(Map<String, List<XlsCellVo>> dataMap, boolean isOldVer) throws Exception{
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		BufferedOutputStream bout = new BufferedOutputStream(outputStream);
		writeXls(bout,dataMap,isOldVer);
		bout.close();
		byte[] bytes = outputStream.toByteArray();
		log.debug("bytes.size="+bytes.length);
		InputStream rtn = new BufferedInputStream(new ByteArrayInputStream(bytes));
		return rtn;
	}
	
	/**
	 * 
	 * Description: 生成Excel文件内容，并返回输入流
	 *
	 * @param titleRowList 
	 * @param keyList 
	 * @param dataList 
	 * @param isAutoSize 
	 * @return InputStream 
	 * @throws Exception 
	 * @Author liufei
	 * Create Date: 2011-12-20 上午10:32:32
	 */
	public static InputStream writeXlsx(List<List<String>> titleRowList, List<String> keyList, 
			List<?> dataList, boolean isAutoSize) throws Exception{
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		BufferedOutputStream bout = new BufferedOutputStream(outputStream);
		OfficeDocUtil.writeXlsx(bout,titleRowList,keyList,dataList,isAutoSize);
		bout.close();
		byte[] bytes = outputStream.toByteArray();
		log.debug("bytes.size="+bytes.length);
		InputStream rtn = new BufferedInputStream(new ByteArrayInputStream(bytes));
		return rtn;
	}
	
	/**
     * 
     * Description: 生成多表头Excel文件内容，并返回输入流
     *
     * @param titleRowList 
     * @param dataList 
     * @param isAutoSize 
     * @param sheetName
     * @return InputStream 
     * @throws Exception 
     * @Author caile
     * Create Date: 2011-12-20 上午10:32:32
     */
    public static InputStream writeXlsx(List<Object> titleRowList, List<Map<Object, List<?>>> dataList,
            String sheetName, boolean isAutoSize) throws Exception{
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BufferedOutputStream bout = new BufferedOutputStream(outputStream);
        OfficeDocUtil.writeXlsx(bout,titleRowList,dataList,sheetName,isAutoSize);
        bout.close();
        byte[] bytes = outputStream.toByteArray();
        log.debug("bytes.size="+bytes.length);
        InputStream rtn = new BufferedInputStream(new ByteArrayInputStream(bytes));
        return rtn;
    }
    /**
     * Description: 生成多表头Excel文件内容，并写入给定的输出流
     * @param out 
     * @param titleRowList 
     * @param dataList   
     * @param sheetName
     * @param isAutoSize 
     * @throws Exception 
     * @Author caile
     * Create Date: 2011-12-12 下午4:09:49
     */
    public static void writeXlsx(OutputStream out, List<Object> titleRowList, List<Map<Object, List<?>>> dataList,
            String sheetName, boolean isAutoSize) throws Exception{
        //创建工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建默认表格
        XSSFSheet sheet = workbook.getSheet(sheetName);
        if (null == sheet){
            sheet = workbook.createSheet(sheetName);
        }
        //写入标题
        XSSFCellStyle titleStyle = createExcelTitleStyle(workbook);
        XSSFRow titleRow = sheet.createRow(0);
        for(int colNum = 0; colNum<titleRowList.size(); colNum++){
            String titleCol = titleRowList.get(colNum).toString();
            XSSFCell cell = titleRow.createCell(colNum);
            cell.setCellStyle(titleStyle);
            XSSFRichTextString text = new XSSFRichTextString(titleCol);
            cell.setCellValue(text);
        }
        //写入表体
        XSSFCellStyle headStyle = createExcelTitlesStyle(workbook);
        XSSFCellStyle contentStyle = createContentsStyle(workbook);
        int columnIndex = sheet.getPhysicalNumberOfRows();
        int cellLength = 0;
        for(Map<Object, List<?>> data : dataList){
            //写入表头
            XSSFRow headRow = sheet.createRow(columnIndex);
            List<Object> headList = (List<Object>) data.get("head");
            for(int colNum = 0; colNum<headList.size(); colNum++){
                String headCol = headList.get(colNum).toString();
                XSSFCell cell = headRow.createCell(colNum);
                cell.setCellStyle(headStyle);
                XSSFRichTextString text = new XSSFRichTextString(headCol);
                cell.setCellValue(text);
            }
            columnIndex++;
            
            //写入内容
            List<List<Object>> contentList = (List<List<Object>>) data.get("content");
            cellLength = contentList.get(0).size();
            for (int rowNum = 0; rowNum < contentList.size(); rowNum++) {
                XSSFRow contentRow = sheet.createRow(columnIndex);
                List<Object> content = contentList.get(rowNum);
                for (int colNum = 0; colNum < content.size(); colNum++) {
                    String contentCol = content.get(colNum).toString();
                    XSSFCell cell = contentRow.createCell(colNum);
                    cell.setCellStyle(contentStyle);
                    XSSFRichTextString text = new XSSFRichTextString(contentCol);
                    cell.setCellValue(text);
                }
                columnIndex++;
            }
        }
        
        if(isAutoSize){
            //重设单元格宽度
            for (int i = 0; i < cellLength; i++) {
                sheet.autoSizeColumn(i);
            }
        }
        
        workbook.write(out);
    }
	
    
    /**
	 * 通用生成Excel文件内容，并返回输入流
	 * 
	 * @param dataMap
	 *            数据map
	 * @param isOldVer
	 *            是否旧版
	 * @param type
	 *            数据格式化样式集合
	 * @param y
	 *            要格式化的数值类型的y坐标集合
	 * @param list
	 *            要进行特殊格式化的信息的集合
	 * @throws Exception
	 *             异常
	 */
	public static InputStream XyewriteXls(Map<String, List<XlsCellVo>> dataMap, boolean isOldVer,Integer[] y, String[] type,List<String[]> list) throws Exception {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		BufferedOutputStream bout = new BufferedOutputStream(outputStream);
		XyewriteXls(bout, dataMap, isOldVer, y, type, list);
		bout.close();
		byte[] bytes = outputStream.toByteArray();
		log.debug("bytes.size=" + bytes.length);
		InputStream rtn = new BufferedInputStream(new ByteArrayInputStream(bytes));
		return rtn;
	}

	/**
	 * 通用生成Excel文件内容，并写入给定的输出流
	 * 
	 * @param out
	 *            输出流
	 * @param dataMap
	 *            数据map
	 * @param isOldVer
	 *            是否旧版
	 * @param type
	 *            数据格式化样式集合
	 * @param y
	 *            要格式化的数值类型的y坐标集合
	 * @param list
	 *            要进行特殊格式化的信息的集合
	 * @throws Exception
	 *             异常
	 */
	public static void XyewriteXls(OutputStream out, Map<String, List<XlsCellVo>> dataMap, boolean isOldVer, Integer[] y, String[] type,List<String[]> list) throws Exception {
		Workbook wb = null;
		if (isOldVer) {
			wb = new HSSFWorkbook();
		} else {
			wb = new XSSFWorkbook();
		}
		int colMaxLen = 0;
		for (Entry<String, List<XlsCellVo>> data : dataMap.entrySet()) {
			Sheet sheet = wb.createSheet(data.getKey());
			List<XlsCellVo> cellVoList = data.getValue();
			for (XlsCellVo cellVo : cellVoList) {
				Assert.notNull(cellVo.getX(), "单元格X坐标不能为空");
				Assert.notNull(cellVo.getY(), "单元格X坐标不能为空");
				Row row = sheet.getRow(cellVo.getX());
				if (row == null) {
					row = sheet.createRow(cellVo.getX());
				}
				Cell cell = row.getCell(cellVo.getY());
				if (cell == null) {
					cell = row.createCell(cellVo.getY());
				}
				String value = "";
				if (cellVo.getValue() != null) {
					value = cellVo.getValue().toString();
				}
				boolean flag = false;
				if(null != y && y.length > 0){
					for (int i = 0; i < y.length; i++) {
						if (cellVo.getX() != 0 && cellVo.getY().toString().equals(y[i].toString())) {
							// 数值格式化
							DecimalFormat decimalFormat = new DecimalFormat(type[i]);
							Number amountNum = decimalFormat.parse(String.valueOf(cellVo.getValue()));
							cell.setCellValue(amountNum.doubleValue());
							flag = true;
						}
					}
				}
				if(!flag){
					cell.setCellValue(value);
				}
				if (cellVo.getBoldType() != null || cellVo.getBorderType() != null || cellVo.getAlignType() != null) {
					boolean op = false;
					String[] str = null;
					if(null != list && list.size() > 0){
						for(String[] s : list){
							if(cellVo.getX() != 0 && Integer.parseInt(s[0]) == Integer.parseInt(cellVo.getY().toString())){
								op = true;
								str = s;
								break;
							}
						}
					}
					if(!op){
						XyecreateExcelStyleTemp(wb, cellVo.getBoldType(), cellVo.getBorderType(), cellVo.getAlignType(), cellVo.getY(),cellVo.getY(),"@","@",1,cell);
					}else{
						XyecreateExcelStyleTemp(wb, cellVo.getBoldType(), cellVo.getBorderType(), cellVo.getAlignType(), cellVo.getY(),Integer.parseInt(str[0]),str[1],str[2],Integer.parseInt(str[3]),cell);
					}
				}
				if (cellVo.getY() > colMaxLen) {
					colMaxLen = cellVo.getY();
				}
			}
			for (int i = 0; i < colMaxLen + 1; i++) {
				sheet.autoSizeColumn(i);
			}
		}
		wb.write(out);
	}
	/*============================== helpers ===========================*/
	/**
	 * 创建Excel标题样式
	 * 
	 * @param wb
	 *            工作簿
	 * @param boldType
	 *            字体是否加粗
	 * @param borderType
	 *            是否有边框
	 * @param alignType
	 *            对齐方式
	 * @param index
	 *            单元格Y值
	 * @param indexy
	 *            欲设置显示格式的单元格Y值
	 * @param type
	 *            单元格显示类型
	 * @param defaultValue
	 *            默认显示类型
	 * @param cellType
	 *            设置写入excel的数据类型
	 * @param cell
	 *            单元格对象
	 * @return CellStyle 样式
	 */
	protected static CellStyle XyecreateExcelStyleTemp(Workbook wb, String boldType, String borderType, String alignType, int index, int indexy,
			String type, String defaultValue, int cellType, Cell cell) {
		CellStyle style = wb.createCellStyle();
		// 默认单元格数据显示类型
		style.setDataFormat(HSSFDataFormat.getBuiltinFormat(defaultValue));
		if (index == indexy) {
			style.setDataFormat(HSSFDataFormat.getBuiltinFormat(type));
		}
		Font font = wb.createFont();
		font.setColor(IndexedColors.BLACK.getIndex());
		font.setFontName("宋体");
		font.setBoldweight(Font.BOLDWEIGHT_NORMAL);

		if (BORDER_HAS.equals(borderType)) {
			style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			style.setBorderBottom(CellStyle.BORDER_THIN);
			style.setBorderLeft(CellStyle.BORDER_THIN);
			style.setBorderRight(CellStyle.BORDER_THIN);
			style.setBorderTop(CellStyle.BORDER_THIN);
		}

		if (BOLD_WEIGHT.equals(boldType)) {
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		}

		if (ALIGN_LEFT.equals(alignType)) {
			style.setAlignment(XSSFCellStyle.ALIGN_LEFT);
		} else if (ALIGN_CENTER.equals(alignType)) {
			style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		} else if (ALIGN_RIGHT.equals(alignType)) {
			style.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
		}
		style.setFont(font);
		cell.setCellStyle(style);
		cell.setCellType(cellType);
		return style;
	}
	/**
	 * 创建Excel标题样式
	 * @param wb 工作簿
	 * @param boldType 字体是否加粗
	 * @param borderType 是否有边框
	 * @param alignType 对齐方式
	 * @return CellStyle 样式
	 */
	protected static CellStyle createExcelStyleTemp(Workbook wb, String boldType, String borderType, String alignType) {
		CellStyle style = wb.createCellStyle();
		Font font = wb.createFont();
		font.setColor(IndexedColors.BLACK.getIndex());
		font.setFontName("宋体");
		font.setBoldweight(Font.BOLDWEIGHT_NORMAL);
		
		if(BORDER_HAS.equals(borderType)){
			style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			style.setBorderBottom(CellStyle.BORDER_THIN);
			style.setBorderLeft(CellStyle.BORDER_THIN);
			style.setBorderRight(CellStyle.BORDER_THIN);
			style.setBorderTop(CellStyle.BORDER_THIN);
		}

		if(BOLD_WEIGHT.equals(boldType)){
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		}

		if(ALIGN_LEFT.equals(alignType)){
			style.setAlignment(XSSFCellStyle.ALIGN_LEFT);
		}else if(ALIGN_CENTER.equals(alignType)){
			style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		}else if(ALIGN_RIGHT.equals(alignType)){
			style.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
		}
		style.setFont(font);
		return style;
	}
	
	/**
	 * 创建Excel标题样式
	 * @param workbook 
	 * @return XSSFCellStyle s
	 */
	protected static XSSFCellStyle createExcelTitleStyle(XSSFWorkbook workbook) {
		XSSFCellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(HSSFColor.WHITE.index);
		style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		style.setBorderRight(XSSFCellStyle.BORDER_THIN);
		style.setBorderTop(XSSFCellStyle.BORDER_THIN);
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		XSSFFont font = workbook.createFont();
		font.setColor(HSSFColor.BLACK.index);
		font.setFontName("宋体");
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		style.setFont(font);
		return style;
	}
	/**
	 * 创建Excel内容样式
	 * @param workbook 
	 * @return XSSFCellStyle 
	 */
	protected static XSSFCellStyle createContentStyle(XSSFWorkbook workbook) {
		XSSFCellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(HSSFColor.WHITE.index);
		style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		style.setBorderRight(XSSFCellStyle.BORDER_THIN);
		style.setBorderTop(XSSFCellStyle.BORDER_THIN);
		//style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		XSSFFont font = workbook.createFont();
		font.setFontName("宋体");
		font.setColor(HSSFColor.BLACK.index);
		font.setBoldweight(XSSFFont.BOLDWEIGHT_NORMAL);
		//style.setWrapText(true);
		style.setFont(font);	
		return style;
	}
	/**
     * 创建多表头Excel标题样式
     * @param workbook 
     * @return XSSFCellStyle s
     */
    protected static XSSFCellStyle createExcelTitlesStyle(XSSFWorkbook workbook) {
        XSSFCellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(HSSFColor.WHITE.index);
        style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        style.setBorderRight(XSSFCellStyle.BORDER_THIN);
        style.setBorderTop(XSSFCellStyle.BORDER_THIN);
        style.setAlignment(XSSFCellStyle.ALIGN_LEFT);
        XSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.BLACK.index);
        font.setFontName("宋体");
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        style.setFont(font);
        return style;
    }
    /**
     * 创建多表头Excel内容样式
     * @param workbook 
     * @return XSSFCellStyle 
     */
    protected static XSSFCellStyle createContentsStyle(XSSFWorkbook workbook) {
        XSSFCellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(HSSFColor.WHITE.index);
        style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        style.setBorderRight(XSSFCellStyle.BORDER_THIN);
        style.setBorderTop(XSSFCellStyle.BORDER_THIN);
        style.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
        style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        XSSFFont font = workbook.createFont();
        font.setFontName("宋体");
        font.setColor(HSSFColor.BLACK.index);
        font.setBoldweight(XSSFFont.BOLDWEIGHT_NORMAL);
        //style.setWrapText(true);
        style.setFont(font);    
        return style;
    }
	/*
	public static void main(String[] args) throws Exception{
		Map<Axis, Object> avMap = new HashMap<Axis, Object>();
		avMap.put(new Axis(1,1), "刘霏");
		
		OfficeDocUtil.modifyXls("d:/tmp/workbook2.xlsx","d:/tmp/workbook2.xlsx", "Sheet0", avMap);
	}*/
	
	/**
	 * 坐标类
	 * @author liufei
	 *
	 */
	public static class Axis{
		private int row;
		private int col;
		
		/**
		 * 构造方法
		 * @param row 行
		 * @param col 列
		 */
		public Axis(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
		@Override
		public boolean equals(Object obj) {
			boolean rtn = false;
	        if (obj != null && this.getClass().isAssignableFrom(obj.getClass())) {
	        	Axis objModel = (Axis) obj;
	            rtn = new EqualsBuilder()
	                    .append(this.getRow(), objModel.getRow())
	                    .append(this.getCol(), objModel.getCol())
	                    .isEquals();
	        }
	        return rtn; 
		}
		@Override
		public int hashCode() {
			return new org.apache.commons.lang3.builder.HashCodeBuilder(17,37)
				.append(this.getRow()).append(this.getCol()).toHashCode();
		}
		@Override
		public String toString() {
			return new org.apache.commons.lang3.builder.ToStringBuilder(this).append("行：").append(this.getRow()).append("列：").append(this.getCol()).toString();
		}
		public int getRow() {
			return row;
		}
		public void setRow(int row) {
			this.row = row;
		}
		public int getCol() {
			return col;
		}
		public void setCol(int col) {
			this.col = col;
		}
	}
}
