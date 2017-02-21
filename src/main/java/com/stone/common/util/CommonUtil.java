package com.kpap.common.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;

public class CommonUtil {
	
	private static final Logger log = LoggerFactory.getLogger(CommonUtil.class);
	
	public static final String REGEX_MOBILE = "^1\\d{10}$"; //手机号验证
	public static final String REGEX_DIGIT = "^-?[0-9]+$"; //数字验证
	
	public static final String date_formatSecode="yyyy-MM-dd HH:mm:ss";
	public static final String date_formatMinute="yyyy-MM-dd HH:mm";
	public static final String date_formatDay="yyyy-MM-dd";
	
	public static final String cookieName="cookie_user";
	public static final String assertPath="/assets/";
	
	public static int calPage(int page,int rows){
		return (page-1)*rows;
	}
	
	public static String toUpperCaseFirstOne(String name) {
        char[] ch = name.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (i == 0) {
                ch[0] = Character.toUpperCase(ch[0]);
            }
        }
        StringBuffer a = new StringBuffer();
        a.append(ch);
        return a.toString();
    }
	
	public static String toLowCaseFirstOne(String name) {
        char[] ch = name.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (i == 0) {
                ch[0] = Character.toLowerCase(ch[0]);
            }
        }
        StringBuffer a = new StringBuffer();
        a.append(ch);
        return a.toString();
    }
	/**
	 * 生成手机验证码
	 * @param numberFlag  是否数字
	 * @param length  长度
	 * @return
	 */
	public static String createRandom(boolean numberFlag, int length){
		String retStr = "";
		String strTable = numberFlag ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";
		int len = strTable.length();
		boolean bDone = true;
		do {
		   retStr = "";
		   int count = 0;
		   for (int i = 0; i < length; i++) {
			   double dblR = Math.random() * len;
			   int intR = (int) Math.floor(dblR);
			   char c = strTable.charAt(intR);
			   if (('0' <= c) && (c <= '9')) {
			     count++;
			   }
			   retStr += strTable.charAt(intR);
		   }
		   if (count >= 2) {
			  bDone = false;
		   }
		} while (bDone);
		
		  return retStr;
	}
	public static String encryption_MD5(String clearText ){
		String ciphertext="";
		if (StringUtils.isNotBlank(clearText)) {
			ciphertext=DigestUtils.md5DigestAsHex(clearText.getBytes());
		}
		return ciphertext;
	}
	/**
	 * bean通用copy函数
	 * @param sourceBean
	 * @param destBeanClass
	 * @return
	 */
	public static Object copyBean(Object sourceBean,Class<?> destBeanClass){
		Class<?> sourceBeanClass=sourceBean.getClass();
		Field[] fields=sourceBeanClass.getFields();
		try {
			Object destBean=destBeanClass.newInstance();
			for (Field field : fields) {
				String fieldName=field.getName();
				try {
					String getMethodName="get"+toUpperCaseFirstOne(fieldName);
					Method method=sourceBeanClass.getMethod(getMethodName);
					Object fieldValue=method.invoke(sourceBean);
					
					String setMethodName="set"+toUpperCaseFirstOne(fieldName);
					Method destMethod=destBeanClass.getMethod(setMethodName, field.getType());
					destMethod.invoke(destBean, fieldValue);
				} catch (Exception e) {
				}
			}
			return destBean;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		} 
		return null;
	}
	/**
	 * 正则表达式通用验证
	 * @param regex
	 * @param mobile
	 * @return
	 */
	public static boolean regexCheck(String regex,String mobile){
		return Pattern.matches(regex, mobile);
	}
	/**
     * 获取当前日期是星期几
     *
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    } 
    
    /**
     * bean转换为map
     * @param obj
     * @return
     */
    public static Map<String, Object> transBean2Map(Object obj) {  
        if(obj == null){  
            return null;  
        }          
        Map<String, Object> map = new HashMap<String, Object>();  
        try {  
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
            for (PropertyDescriptor property : propertyDescriptors) {  
                String key = property.getName();  
                // 过滤class属性  
                if (!key.equals("class")) {  
                    // 得到property对应的getter方法  
                    Method getter = property.getReadMethod();  
                    Object value = getter.invoke(obj);  
 
                    map.put(key, value);  
                }  
            }  
        } catch (Exception e) {  
            e.printStackTrace();
            log.error("transBean2Map Error " + e);
        }  
        return map;  
    } 
    /**
     *  map转换为bean
     * @param map
     * @param obj
     */
    public static Object transMap2Bean2(Map<String, Object> map, Class<?> destBeanClass) {
    	Set<String> keySet=map.keySet();
		try {
			if (!keySet.isEmpty()) {
				Object destBean = destBeanClass.newInstance();
				for (String key : keySet) {
					Object value=map.get(key);
					try {
						Field field=destBeanClass.getField(key);
						if (field!=null) {
							String setMethodName="set"+toUpperCaseFirstOne(key);
							Method destMethod=destBeanClass.getMethod(setMethodName, field.getType());
							destMethod.invoke(destBean, value);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
				return destBean;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
    	return null;
    } 
    /**
     * url编码（utf-8）
     * @param source
     * @return
     */
    public static String urlEncodeUTF8(String source){
    	String result=source;
    	try {
			result=java.net.URLEncoder.encode(source,"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	return result;
    }
}
