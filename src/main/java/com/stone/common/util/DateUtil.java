package com.kpap.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;


public class DateUtil {
    public static final String formatPattern = "yyyy-MM-dd HH:mm:ss";
    public static final String dataFormatPattern = "yyyy-MM-dd";
    public static final String yearMonthFormat = "yyyy-MM";
    public static final String yearMonthDayFormat = "yyyyMMdd";
      
    /** 
     * 获取当前日期 
     * @return 
     */  
    public static String getCurrentDate(){  
        SimpleDateFormat format = new SimpleDateFormat(formatPattern);        
        return format.format(new Date());  
    }  
      
    /** 
     * 获取制定毫秒数之前的日期 
     * @param timeDiff 
     * @return 
     */  
    public static String getDesignatedDate(long timeDiff){  
        SimpleDateFormat format = new SimpleDateFormat(formatPattern);  
        long nowTime = System.currentTimeMillis();  
        long designTime = nowTime - timeDiff;         
        return format.format(designTime);  
    }  
      
    /** 
     *  
     * 获取前几天的日期 
     */  
    public static String getPrefixDate(String count){  
        Calendar cal = Calendar.getInstance();  
        int day = 0-Integer.parseInt(count);  
        cal.add(Calendar.DATE,day);   // int amount   代表天数  
        Date datNew = cal.getTime();   
        SimpleDateFormat format = new SimpleDateFormat(formatPattern);  
        return format.format(datNew);  
    }  
    /** 
     * 日期转换成字符串 
     * @param date 
     * @return 
     */  
	public static String dateToString(Date date,String dateFormate){ 
		String dateString="";
		if (date!=null) {
	        try {
				SimpleDateFormat format = new SimpleDateFormat(dateFormate);
				dateString=format.format(date);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
        return dateString;
    }  
    /** 
     * 字符串转换日期 
     * @param str 
     * @return 
     */  
    public static Date stringToDate(String str,String dateFormate){
    	if (StringUtils.isBlank(dateFormate)) {
    		dateFormate=formatPattern;
		}
        SimpleDateFormat format = new SimpleDateFormat(dateFormate);  
        if(!str.equals("") && str!=null){  
            try {  
                return format.parse(str);  
            } catch (ParseException e) {
            	e.printStackTrace();
            }  
        }  
        return null;  
    }  
    //java中怎样计算两个时间如：“21:57”和“08:20”相差的分钟数、小时数 java计算两个时间差小时 分钟 秒 .  
    public void timeSubtract(){  
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
        Date begin = null;   
        Date end = null;   
        try {   
	        begin = dfs.parse("2004-01-02 11:30:24");   
	        end = dfs.parse("2004-03-26 13:31:40");   
        } catch (ParseException e) {   
        	e.printStackTrace();   
        }   
  
        long between = (end.getTime() - begin.getTime()) / 1000;// 除以1000是为了转换成秒   
  
        long day1 = between / (24 * 3600);   
        long hour1 = between % (24 * 3600) / 3600;   
        long minute1 = between % 3600 / 60;   
        long second1 = between % 60;   
        System.out.println("" + day1 + "天" + hour1 + "小时" + minute1 + "分"+ second1 + "秒");   
    }
    /**
     * 获取两个日期之间的天数
     * @param startDate
     * @param endDate
     * @return
     */
    public static Long getDaysBetween(Date startDate, Date endDate) {  
        Calendar fromCalendar = Calendar.getInstance();  
        fromCalendar.setTime(startDate);  
        fromCalendar.set(Calendar.HOUR_OF_DAY, 0);  
        fromCalendar.set(Calendar.MINUTE, 0);  
        fromCalendar.set(Calendar.SECOND, 0);  
        fromCalendar.set(Calendar.MILLISECOND, 0);  
  
        Calendar toCalendar = Calendar.getInstance();  
        toCalendar.setTime(endDate);  
        toCalendar.set(Calendar.HOUR_OF_DAY, 0);  
        toCalendar.set(Calendar.MINUTE, 0);  
        toCalendar.set(Calendar.SECOND, 0);  
        toCalendar.set(Calendar.MILLISECOND, 0);  
        long time = (toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / (1000 * 60 * 60 * 24);
        return time;  
    }
    public static String getWeek(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");  
        String week = sdf.format(date);  
        return week;  
    }
    
    
	/**
	 * 功能描述：以String的方式返回当前的日期+时间
	 * 
	 * @param sDateData
	 * @return
	 */
	public static String getCurrentDateTimeAsInt() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		return String.valueOf(dateFormat.format(new Date()));
	}
	
	/**
	 * 将日期格式化为字符串
	 * @param date 日期
	 * @param pattern 格式
	 * @return 格式化后的日期串
	 */
	public static String date2Str(Date date, String pattern){
		if(null==date) {
			return null;
		}
		if(null==pattern) {
			pattern = "yyyy-MM-dd";
		}
		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern(pattern);
		return format.format(date);
	}
    public static void main(String[] args) throws Exception{
    	Date startDate=DateUtils.parseDate("2016-05-27 13:56:50",formatPattern);
    	Date endDate=DateUtils.parseDate("2016-05-26 13:56:50",formatPattern);
    	System.out.println(getDaysBetween(startDate, endDate));
    	System.out.println(Math.ceil((getDaysBetween(startDate, endDate)+1)/7.0));
    	System.out.println(DateUtils.addDays(startDate, 3));
    	System.out.println(getWeek(startDate));
    }
}
