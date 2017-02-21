package com.kpap.website.dto;

import java.util.Date;

public class CaseItem {
	public String proCode;
	public Long proValCaseId;
	public Long caseId;
	public Long proValId;
	
	//交易时间 
	public Double m1;
	//经济寿命 
	public Double m2;
	//获利能力 
	public Double m3;
	//其他因素 
	public Double m4;
	
	//方法：0--公式计算；1--人工录入
	public String m2_val_type;
	//技术寿命年限类型：0--公式计算；1--人工录入
	public String m2_type;
	
	//法定保护年限
	public String m2_0;
	
	//技术更新周期
	public Double m2_1; 
	//技术特性评价分值-技术先进性
	public Double m2_2;
	//技术特性评价分值-可替代性
	public Double m2_3;
	//技术特性评价分值-技术应用的市场前景
	public Double m2_4;
	//技术特性评价分值-技术应用的经济效益
	public Double m2_5;
	//技术特性评价分值-技术应用的社会效益
	public Double m2_6;
	
	//技术寿命年限--人工录入
	public Double m2_7;
	
	//经济寿命年限
	public Double m2_8;
	
	//评估基准日
	public Date pgDate;
	//专利申请日
	public Date sqDate;
	
	//获利能力--技术先进性
	public Double m3_0;
	//获利能力--可替代性
	public Double m3_1;
	//获利能力--技术应用的市场前景
	public Double m3_2;
	//获利能力--技术应用的经济效益
	public Double m3_3;
	//获利能力--技术应用的社会效益
	public Double m3_4;
	
	
	public String getProCode() {
		return proCode;
	}
	public void setProCode(String proCode) {
		this.proCode = proCode;
	}
	public Long getProValCaseId() {
		return proValCaseId;
	}
	public void setProValCaseId(Long proValCaseId) {
		this.proValCaseId = proValCaseId;
	}
	public Long getCaseId() {
		return caseId;
	}
	public void setCaseId(Long caseId) {
		this.caseId = caseId;
	}
	public Long getProValId() {
		return proValId;
	}
	public void setProValId(Long proValId) {
		this.proValId = proValId;
	}
	public Double getM1() {
		return m1;
	}
	public void setM1(Double m1) {
		this.m1 = m1;
	}
	public Double getM2() {
		return m2;
	}
	public void setM2(Double m2) {
		this.m2 = m2;
	}
	public Double getM3() {
		return m3;
	}
	public void setM3(Double m3) {
		this.m3 = m3;
	}
	public Double getM4() {
		return m4;
	}
	public void setM4(Double m4) {
		this.m4 = m4;
	}
	public String getM2_val_type() {
		return m2_val_type;
	}
	public void setM2_val_type(String m2_val_type) {
		this.m2_val_type = m2_val_type;
	}
	public String getM2_type() {
		return m2_type;
	}
	public void setM2_type(String m2_type) {
		this.m2_type = m2_type;
	}
	public String getM2_0() {
		return m2_0;
	}
	public void setM2_0(String m2_0) {
		this.m2_0 = m2_0;
	}
	public Double getM2_1() {
		return m2_1;
	}
	public void setM2_1(Double m2_1) {
		this.m2_1 = m2_1;
	}
	public Double getM2_2() {
		return m2_2;
	}
	public void setM2_2(Double m2_2) {
		this.m2_2 = m2_2;
	}
	public Double getM2_3() {
		return m2_3;
	}
	public void setM2_3(Double m2_3) {
		this.m2_3 = m2_3;
	}
	public Double getM2_4() {
		return m2_4;
	}
	public void setM2_4(Double m2_4) {
		this.m2_4 = m2_4;
	}
	public Double getM2_5() {
		return m2_5;
	}
	public void setM2_5(Double m2_5) {
		this.m2_5 = m2_5;
	}
	public Double getM2_6() {
		return m2_6;
	}
	public void setM2_6(Double m2_6) {
		this.m2_6 = m2_6;
	}
	public Double getM2_7() {
		return m2_7;
	}
	public void setM2_7(Double m2_7) {
		this.m2_7 = m2_7;
	}
	public Double getM2_8() {
		return m2_8;
	}
	public void setM2_8(Double m2_8) {
		this.m2_8 = m2_8;
	}
	public Date getPgDate() {
		return pgDate;
	}
	public void setPgDate(Date pgDate) {
		this.pgDate = pgDate;
	}
	public Date getSqDate() {
		return sqDate;
	}
	public void setSqDate(Date sqDate) {
		this.sqDate = sqDate;
	}
	public Double getM3_0() {
		return m3_0;
	}
	public void setM3_0(Double m3_0) {
		this.m3_0 = m3_0;
	}
	public Double getM3_1() {
		return m3_1;
	}
	public void setM3_1(Double m3_1) {
		this.m3_1 = m3_1;
	}
	public Double getM3_2() {
		return m3_2;
	}
	public void setM3_2(Double m3_2) {
		this.m3_2 = m3_2;
	}
	public Double getM3_3() {
		return m3_3;
	}
	public void setM3_3(Double m3_3) {
		this.m3_3 = m3_3;
	}
	public Double getM3_4() {
		return m3_4;
	}
	public void setM3_4(Double m3_4) {
		this.m3_4 = m3_4;
	}
}
