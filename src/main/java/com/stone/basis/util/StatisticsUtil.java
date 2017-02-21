package com.kpap.basis.util;

import java.math.BigDecimal;

/**
 * 统计工具类，包括计算总和、平均值、标准差、方差
 * 
 * @author haiwenshen
 */
public class StatisticsUtil {
	
	 /**
	  * 求给定双精度数组中值的和
	  * 
	  * @param array
	  *            输入数据数组
	  * @return 运算结果
	  */
	 public static double getSum(int[] array) {
		 if (array == null || array.length == 0)
			 return 0;
		 int num = array.length;
		 double sum =  0 ;
		 for (int i = 0; i < num; i++) {
			 sum = sum + array[i];
		 }
		 return getScale2Double(sum); 
	 }
	 
	 /**
	  * 求给定双精度数组中值的和
	  * 
	  * @param array
	  *            输入数据数组
	  * @return 运算结果
	  */
	 public static double getSumAsDouble(double[] array) {
		 if (array == null || array.length == 0)
			 return 0;
		 int num = array.length;
		 double sum =  0 ;
		 for (int i = 0; i < num; i++) {
			 sum = sum + array[i];
		 }
		 return getScale2Double(sum);
	 }
	
	
	/**
	 * 获取平均值
	 * 
	 * @param array
	 * @return
	 */
	public static double getAverage(int[]  array){
		if(array == null || array.length <= 0){
			return 0;
		}
        double sum = 0;
        int num = array.length;
        for(int i = 0;i < num;i++){
            sum += array[i];
        }
        return getScale2Double(sum/num);
    }
	
	/**
	 * 获取平均值
	 * 
	 * @param array
	 * @return
	 */
	public static double getAverageAsDouble(double[]  array){
		if(array == null || array.length <= 0){
    		return 0;
    	}
		double sum = 0;
		int num = array.length;
        for(int i = 0;i < num;i++){
            sum += array[i];
        }
        return getScale2Double(sum/num);
    }
	
	/**
	 * 获取标准差
	 * 
	 * @param array
	 * @return
	 */
    public static double getStandardDevition(int[]  array){
    	if(array == null || array.length <= 0){
    		return 0;
    	}
        double sum = 0;
        int num = array.length;
        double avg = getAverage(array);
        for(int i = 0;i < num;i++){
            sum += ((double)array[i] -avg) * (array[i] -avg);
        }
        sum=Math.sqrt(sum /(num-1));
        return getScale2Double(sum);
    }
    
	/**
	 * 获取标准差
	 * 
	 * @param array
	 * @return
	 */
    public static double getStandardDevitionAsDouble(double[]  array){
    	if(array == null || array.length <= 0){
    		return 0;
    	}
        double sum = 0;
        int num = array.length;
        double avg = getAverageAsDouble(array);
        for(int i = 0;i < num;i++){
            sum += ((double)array[i] -avg) * (array[i] -avg);
        }
        sum=Math.sqrt(sum /(num-1));
        return getScale2Double(sum);
    }
    
    /**
     * 求给定双精度数组中值的方差
     * 
     * @param array
     *            输入数据数组
     * @return 运算结果
     */
    public static double getVariance(int[]  array) {
    	if(array == null || array.length <= 0){
    		return 0;
    	}
        double sum = 0;
        int num = array.length;
        double avg = getAverage(array);
        for(int i = 0;i < num;i++){
            sum += ((double)array[i] -avg) * (array[i] -avg);
        }
        sum=sum /(num-1);
        return getScale2Double(sum);
    }
    
    /**
     * 求给定双精度数组中值的方差
     * 
     * @param array
     *            输入数据数组
     * @return 运算结果
     */
    public static double getVarianceAsDouble(double[]  array) {
    	if(array == null || array.length <= 0){
    		return 0;
    	}
        double sum = 0;
        int num = array.length;
        double avg = getAverageAsDouble(array);
        for(int i = 0;i < num;i++){
            sum += ((double)array[i] -avg) * (array[i] -avg);
        }
        sum=sum /(num-1);
        return getScale2Double(sum);
    }
    
    /**
     * 求给定双精度数组中值的平方和
     * 
     * @param array
     *            输入数据数组
     * @return 运算结果
     */
    public static double getSquareSumAsDouble(double[] array) {
    	if(array==null||array.length==0)
    		return 0;
    	int len=array.length;
    	double sqrsum = 0.0;
    	for (int i = 0; i <len; i++) {
    		sqrsum = sqrsum + array[i] * array[i];
    	} 
    	return getScale2Double(sqrsum);
    }
    
    /**
     * 求给定双精度数组中值的平方和
     * 
     * @param array
     *            输入数据数组
     * @return 运算结果
     */
    public static double getSquareSum(int[] array) {
    	if(array==null||array.length==0)
    		return 0;
    	int len=array.length;
    	double sqrsum = 0.0;
    	for (int i = 0; i <len; i++) {
    		sqrsum = sqrsum + array[i] * array[i];
    	} 
    	return getScale2Double(sqrsum);
    }
    
    /**
     * double四舍五入保留两位小数
     * 
     * @param value
     * @return
     */
    public static double getScale2Double(double value){
    	BigDecimal  bd = new BigDecimal(value);  
		return bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
    }
    
    /**
     * double不保留小数
     * 
     * @param value
     * @return
     */
    public static double getScaleDouble(double value){
    	BigDecimal  bd = new BigDecimal(value);  
		return bd.setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue();  
    }
    
    public static void main(String[] args){
    	double[] demo={407,3387,5,52,7,84,67,601,39,2190};
    	int[] demoint={30,24,26,33,45};
    	System.out.println(getVarianceAsDouble(demo));
    	//System.out.println(getVariance(demoint));
    	System.out.println(getStandardDevitionAsDouble(demo));
    	//System.out.println(getStandardDevition(demoint));
    }

}
