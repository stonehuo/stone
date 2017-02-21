package com.kpap.website.dto;

import java.util.Date;

public class IncomeSeries {
	public String proCode;
	public String category;
	//方法：0--公式计算；1--人工录入
	public String method;
	//技术寿命年限类型：0--公式计算；1--人工录入
	public String tLifeType;
	
	//法定保护年限
	public String fdLife;
	
	//技术更新周期
	public Double tLife_1; 
	//技术特性评价分值-技术先进性
	public Double tLife_2;
	//技术特性评价分值-可替代性
	public Double tLife_3;
	//技术特性评价分值-技术应用的市场前景
	public Double tLife_4;
	//技术特性评价分值-技术应用的经济效益
	public Double tLife_5;
	//技术特性评价分值-技术应用的社会效益
	public Double tLife_6;
	
	//技术寿命年限
	public Double tLife;
	
	//经济寿命年限
	public Double eLife;
	
	//专利经济寿命年限=MIN(法定保护年限,技术寿命年限,经济寿命年限)
	public Double zljjLife;
	
	//专利申请日
	public Date sqDate;
	
	//专利剩余经济寿命年限
	public Double lastYearVal;
	

	public String getProCode() {
		return proCode;
	}

	public void setProCode(String proCode) {
		this.proCode = proCode;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String gettLifeType() {
		return tLifeType;
	}

	public void settLifeType(String tLifeType) {
		this.tLifeType = tLifeType;
	}

	public String getFdLife() {
		return fdLife;
	}

	public void setFdLife(String fdLife) {
		this.fdLife = fdLife;
	}

	public Double gettLife_1() {
		return tLife_1;
	}

	public void settLife_1(Double tLife_1) {
		this.tLife_1 = tLife_1;
	}

	public Double gettLife_2() {
		return tLife_2;
	}

	public void settLife_2(Double tLife_2) {
		this.tLife_2 = tLife_2;
	}

	public Double gettLife_3() {
		return tLife_3;
	}

	public void settLife_3(Double tLife_3) {
		this.tLife_3 = tLife_3;
	}

	public Double gettLife_4() {
		return tLife_4;
	}

	public void settLife_4(Double tLife_4) {
		this.tLife_4 = tLife_4;
	}

	public Double gettLife_5() {
		return tLife_5;
	}

	public void settLife_5(Double tLife_5) {
		this.tLife_5 = tLife_5;
	}

	public Double gettLife_6() {
		return tLife_6;
	}

	public void settLife_6(Double tLife_6) {
		this.tLife_6 = tLife_6;
	}

	public Double gettLife() {
		return tLife;
	}

	public void settLife(Double tLife) {
		this.tLife = tLife;
	}

	public Double geteLife() {
		return eLife;
	}

	public void seteLife(Double eLife) {
		this.eLife = eLife;
	}

	public Double getZljjLife() {
		return zljjLife;
	}

	public void setZljjLife(Double zljjLife) {
		this.zljjLife = zljjLife;
	}

	public Date getSqDate() {
		return sqDate;
	}

	public void setSqDate(Date sqDate) {
		this.sqDate = sqDate;
	}

	public Double getLastYearVal() {
		return lastYearVal;
	}

	public void setLastYearVal(Double lastYearVal) {
		this.lastYearVal = lastYearVal;
	}
}
