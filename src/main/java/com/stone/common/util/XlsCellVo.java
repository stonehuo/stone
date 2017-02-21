package com.kpap.common.util;


import java.util.HashMap;
import java.util.Map;

/**
 * 
 * excel值对象<BR>
 *
 * @auther shenhaiwen
 * @date 2016-12-11 下午10:21:02
 */
public class XlsCellVo {
	private Integer x;
	private Integer y;
	private Object value;
	private String boldType;
	private String borderType;
	private String alignType;
	private String styleType;
	public static final String STYLE_WBOLD_HBORDER_ALEFT =  "0";//加粗_边框_居左
	public static final String STYLE_WBOLD_HBORDER_ACENTER =  "1";
	public static final String STYLE_WBOLD_HBORDER_ARIGHT =  "2";
	public static final String STYLE_NBOLD_HBORDER_ALEFT =  "3";//正常_边框_居左
	public static final String STYLE_NBOLD_HBORDER_ACENTER =  "4";
	public static final String STYLE_NBOLD_HBORDER_ARIGHT =  "5";
	
	private static final Map<String, String> STYLE_MAP = new HashMap<String, String>();
	static {
		STYLE_MAP.put(STYLE_WBOLD_HBORDER_ALEFT, "1,1,-1");
		STYLE_MAP.put(STYLE_WBOLD_HBORDER_ACENTER, "1,1,0");
		STYLE_MAP.put(STYLE_WBOLD_HBORDER_ARIGHT, "1,1,1");
		STYLE_MAP.put(STYLE_NBOLD_HBORDER_ALEFT, "0,1,-1");
		STYLE_MAP.put(STYLE_NBOLD_HBORDER_ACENTER, "0,1,0");
		STYLE_MAP.put(STYLE_NBOLD_HBORDER_ARIGHT, "0,1,1");
	}
	
	public XlsCellVo(){};
	//无样式构造方法
	public XlsCellVo(Integer x,Integer y,Object value){
		this.x = x;
		this.y = y;
		this.value = value;
	};
	/**
	 * 使用加粗，边框，对齐方式的构造方法
	 * @param x 坐标x
	 * @param y 坐标y
	 * @param value 单元格值
	 * @param boldType 字体粗细类型
	 * @param borderType  边框有误类型
	 * @param alignType 对齐方式类型
	 */
	public XlsCellVo(Integer x,Integer y,Object value, String boldType, String borderType, String alignType){
		this.x = x;
		this.y = y;
		this.value = value;
		this.boldType = boldType;
		this.borderType = borderType;
		this.alignType = alignType;
	};
	/**
	 * 使用默认提供样式类型或自定义样式（格式要求：加粗,边框,对齐方式。如："1,1,-1"）
	 * @param x 坐标x
	 * @param y 坐标y
	 * @param value 单元格值
	 * @param styleType 样式类型
	 */
	public XlsCellVo(Integer x,Integer y,Object value, String styleType){
		if(styleType != null){
			String[] styleArr = styleType.split(",");
			if(STYLE_MAP.containsKey(styleType)){
				styleArr = STYLE_MAP.get(styleType).split(",");
			}
			this.x = x;
			this.y = y;
			this.value = value;
			if(styleArr.length == 3){
				this.boldType = styleArr[0];
				this.borderType = styleArr[1];
				this.alignType = styleArr[2];
			}
		}else{
			this.x = x;
			this.y = y;
			this.value = value;
		}
	};
	
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public String getBoldType() {
		return boldType;
	}
	public void setBoldType(String boldType) {
		this.boldType = boldType;
	}
	public String getBorderType() {
		return borderType;
	}
	public void setBorderType(String borderType) {
		this.borderType = borderType;
	}
	public String getAlignType() {
		return alignType;
	}
	public void setAlignType(String alignType) {
		this.alignType = alignType;
	}
	public String getStyleType() {
		return styleType;
	}
	public void setStyleType(String styleType) {
		this.styleType = styleType;
	}
	
}
