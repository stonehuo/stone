package com.kpap.common.util;

import java.util.HashMap;
import java.util.Map;

public class ResultMap {
	private int dealFlag=0;
	private String message="Success";
	private Map<String, Object> paras=new HashMap<String, Object>();
	
	public static ResultMap result_1=ResultMap.getResultMap(1, "登录超时");
	public static ResultMap result_2=ResultMap.getResultMap(2, "用户名或密码错误");
	public static ResultMap result_3=ResultMap.getResultMap(3, "旧密码错误");
	public static ResultMap result_4=ResultMap.getResultMap(4, "登录名已存在");
	public static ResultMap result_5=ResultMap.getResultMap(5, "管理员同时登录不能超过两次");
	public static ResultMap result_6=ResultMap.getResultMap(6, "没有找到可比公司");
	
	public int getDealFlag() {
		return dealFlag;
	}
	public void setDealFlag(int dealFlag) {
		this.dealFlag = dealFlag;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Map<String, Object> getParas() {
		return paras;
	}
	public void setParas(Map<String, Object> paras) {
		this.paras = paras;
	}
	public ResultMap addParas(String key,Object value){
		paras.put(key, value);
		return this;
	}
	public static ResultMap getDefaultResultMap(){
		ResultMap resultMap=new ResultMap();
		return resultMap;
	}
	public static ResultMap getDefaultResultMap(Map<String, Object> paras){
		ResultMap resultMap=new ResultMap();
		resultMap.setParas(paras);
		return resultMap;
	}
	public static ResultMap getDefaultResultMap(String key,Object value){
		ResultMap resultMap=new ResultMap();
		resultMap.getParas().put(key, value);
		
		return resultMap;
	}
	public static ResultMap getDefaultResultMap(int dealFlag,String message,String key,Object value){
		ResultMap resultMap=new ResultMap();
		resultMap.setDealFlag(dealFlag);
		resultMap.setMessage(message);
		resultMap.addParas(key, value);
		return resultMap;
	}
	public static ResultMap getResultMap(int dealFlag,String message){
		ResultMap resultMap=new ResultMap();
		resultMap.setDealFlag(dealFlag);
		resultMap.setMessage(message);
		return resultMap;
	}
	public static ResultMap getResultMap(int dealFlag,String message,Map<String, Object> paras){
		ResultMap resultMap=new ResultMap();
		resultMap.setDealFlag(dealFlag);
		resultMap.setMessage(message);
		resultMap.setParas(paras);
		return resultMap;
	}
}
