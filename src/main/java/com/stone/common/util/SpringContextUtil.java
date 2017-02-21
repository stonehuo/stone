package com.kpap.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;


@Service
public class SpringContextUtil implements ApplicationContextAware{
	
	private static ApplicationContext   applicationContext;
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		SpringContextUtil.applicationContext = applicationContext;
	}
	
	public static ApplicationContext getAppilcationContext(){
		return applicationContext;
	}
	
	public static Object getBean(String name) throws Exception{
		try{
			return applicationContext.getBean(name);
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	public static Object getBean(String name,Class requiredType){
		return applicationContext.getBean(name, requiredType);
	}
}