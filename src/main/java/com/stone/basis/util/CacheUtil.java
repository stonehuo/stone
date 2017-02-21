package com.kpap.basis.util;

import java.util.HashMap;
import java.util.Map;

public class CacheUtil {
	private volatile static CacheUtil cacheUtil;
	private CacheUtil(){};
	private Map<String, Integer> adminMap = new HashMap<String, Integer>();
	
	
	public static CacheUtil getInstance(){
		if (cacheUtil==null) {
			synchronized (CacheUtil.class) {
				if (cacheUtil==null) {
					cacheUtil=new CacheUtil();
				}
			}
		}
		return cacheUtil;
	}
	public boolean addAdmin(String userCode){
        synchronized (adminMap) {
        	if(adminMap.containsKey(userCode)){
        		int count=adminMap.get(userCode);
        		if(count>=2){
        			return false;
        		}else{
        			count++;
        			adminMap.put(userCode,count);
        		}
        	}else{
        		adminMap.put(userCode,1);
        	}
        }
        return true;
	}
     public void removeAdmin(String userCode) {
         synchronized (adminMap) {
        	 Integer count=adminMap.get(userCode);
        	 if(null == count){ //解决审核员、操作员退出报错问题
        		 return;
        	 }
        	 if(count.intValue()>1){
        		 count--;
        		 adminMap.put(userCode,count);
        	 }else{
        		 adminMap.remove(userCode);
        	 }
         }
     }
     
}
