package com.kpap.website.dto;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class KeyValue {
	public String key;
	public String value;
	public Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public KeyValue(String key,String value){
		this.key=key;
		this.value=value;
	}
	public KeyValue(){}
	
	public static List<KeyValue> getKeyValueList(String content){
		List<KeyValue> keyValues=new ArrayList<>();
		String[] list=content.split(";");
		for (String m : list) {
			String[] n=m.split("_");
			KeyValue keyValue=new KeyValue(n[0], n[1]);
			keyValues.add(keyValue);
		}
		return keyValues;
	}
	public static List<KeyValue> getKeyValueListForJson(String content){
		List<KeyValue> keyValues=new ArrayList<>();
		JSONArray jsonArray = JSON.parseArray(content);
		for(int t=0;t<jsonArray.size();t++){
			KeyValue keyValue=jsonArray.getObject(t, KeyValue.class);
			keyValues.add(keyValue);
		}
		return keyValues;
	}
}
