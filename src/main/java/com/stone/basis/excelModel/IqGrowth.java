package com.kpap.basis.excelModel;
/**
 * IQ_10_可比公司会计报表_利润表 _营业收入增长率  年平均增长率/几年平均数
 * @author huo
 *
 */
public class IqGrowth {
	
	//年：2011	2012	2013	2014	2015	2016
	public String r13;
	//年描述：前5年	前4年	前3年	前2年	前1年	当年
	public String r14;
	//营业收入增长率
	public Double r16;
	public String getR13() {
		return r13;
	}
	public void setR13(String r13) {
		this.r13 = r13;
	}
	public String getR14() {
		return r14;
	}
	public void setR14(String r14) {
		this.r14 = r14;
	}
	public Double getR16() {
		return r16;
	}
	public void setR16(Double r16) {
		this.r16 = r16;
	}
}
