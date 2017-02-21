package com.kpap.basis.excelModel;
/**
 * 财务比率指标平均增长率
 * @author huo
 *
 */
public class RatiosGrowthAve {
	
	//年：2011	2012	2013	2014	2015	2016
	public String r3;
	//年描述：前5年	前4年	前3年	前2年	前1年	当年
	public String r4;
	//销售(营业)增长率(%)
	public Double r25;
	
	public String getR3() {
		return r3;
	}
	public void setR3(String r3) {
		this.r3 = r3;
	}
	public String getR4() {
		return r4;
	}
	public void setR4(String r4) {
		this.r4 = r4;
	}
	public Double getR25() {
		return r25;
	}
	public void setR25(Double r25) {
		this.r25 = r25;
	}
}
