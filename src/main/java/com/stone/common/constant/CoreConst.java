package com.kpap.common.constant;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * 系统常量<BR>
 *
 * @auther shenhaiwen
 * @date 2016-12-18 下午05:09:56
 */
public final class CoreConst {
	
	public static final String FILE_SEPARATOR = File.separator;
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	public static final String PATENT_URL; // 专利接口地址
	
	public static final String PATENT_API_KEY;
	
	public static final String PATENT_SECRET_KEY;
	
	public static final String PARENT_USERNAME;
	
	public static final String PARENT_PASSWORD;
	
	public static final String CE_HOME;
	
	public static final String REPORTDATA_BASE;//存放报文文件
	
	static {
		// 初始化配置信息
		InputStream is = null;
		Properties prop = new Properties();
		try {
			is=CoreConst.class.getResourceAsStream("/my.properties");
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		String ceHome = prop.getProperty("CE_HOME");
		PATENT_URL = prop.getProperty("patent.url");
		PATENT_API_KEY = prop.getProperty("patent.api.key");
		PATENT_SECRET_KEY = prop.getProperty("patent.secret.key");
		PARENT_USERNAME = prop.getProperty("patent.username");
		PARENT_PASSWORD = prop.getProperty("patent.password");
		String userHome = System.getProperty("user.home");
		if (!userHome.endsWith(FILE_SEPARATOR)) {
			userHome += FILE_SEPARATOR;
		}
		
		REPORTDATA_BASE=userHome;
		
		if (ceHome.startsWith("/")) {
			CE_HOME = ceHome;
		} else {
			
			CE_HOME = userHome + prop.getProperty("CE_HOME");
			
		}

}}
