package com.kpap.website.dto;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class IncomeIncomeProduct {
	public Long proValIncomeProtId;
	
	//方法分类：0--收入分成法；1--净利润分成法；2--超额收益法；3--成本重置模型；4--复杂系数模型
	public String category;
	//最终结果
	public String result;
	//计算方法：0--营业收入；1--销量单价
	public String method;

	//******************营业收入部分********************
	//收入基数类型：0--企业自身数据；1--同行业数据；2--人工录入
	public String sr_type;
	//收入基数--企业自身数据
	public String sr_0;
	//收入基数--同行业数据类型:r18--平均数;r19--中位数;r20--最大数;r21--最小数;r23--中间区-平均;r24--高区-平均;r25--低区-平均
	public String sr_1;
	//收入基数--同行业数据
	public String sr_1_0;
	//收入基数--人工录入
	public String sr_2;
	
	//收入增长率类型：0--企业自身数据；1--同行业数据；2--人工录入；3--逐年手工录入
	public String srr_type;
	//收入增长率基数--企业自身数据
	public String srr_0;
	//收入增长率--同行业数据类型:r30--平均数;r31--中位数;r32--最大数;r33--最小数;r35--中间区-平均;r36--高区-平均;r37--低区-平均
	public String srr_1;
	//收入增长率--同行业数据
	public String srr_1_0;
	//收入增长率--人工录入
	public String srr_2;
	//收入增长率--逐年手工录入
	public String srr_3;
	
	//调整系数
	public String ratio;
	
	//******************单价销量部分********************
	//销售单价类型：0--企业自身数据；1--人工录入
	public String dj_type;
	//销售单价--企业自身数据
	public String dj_0;
	//销售单价--人工录入
	public String dj_1;
	
	//销售单价增长率类型：0--企业自身数据；1--人工录入；2--逐年手工录入
	public String djr_type;
	//销售单价增长率--企业自身数据
	public String djr_0;
	//销售单价增长率--手工录入
	public String djr_1;
	//销售单价增长率--逐年手工录入
	public String djr_2;
	
	//销售量类型：0--企业自身数据；1--人工录入
	public String xl_type;
	//销售量--企业自身数据
	public String xl_0;
	//销售量--人工录入
	public String xl_1;
	
	//销售量增长率类型：0--企业自身数据；1--人工录入；2--逐年手工录入
	public String xlr_type;
	//销售量增长率--企业自身数据
	public String xlr_0;
	//销售量增长率--手工录入
	public String xlr_1;
	//销售量增长率--逐年手工录入
	public String xlr_2;
	
	
	//利润率方法：0--毛利率；1--主营业务利润率；2--营业利润率；3--利润率；4--净利润率
	public String lrr;
	//利润率方式：0--企业自身数据；1--同行业数据；2--逐年手工录入
	public String lrr_type;
	//企业自身数据
	public String lrr_0;
	//同行业数据：r30--平均数;r31--中位数;r32--最大数;r33--最小数;r35--中间区-平均;r36--高区-平均;r37--低区-平均
	public String lrr_1;
	//同行业数据
	public String lrr_1_0;
	//逐年手工录入
	public String lrr_2;
	
	
	
	public String getSr_1_0() {
		return sr_1_0;
	}
	public void setSr_1_0(String sr_1_0) {
		this.sr_1_0 = sr_1_0;
	}
	public String getSrr_1_0() {
		return srr_1_0;
	}
	public void setSrr_1_0(String srr_1_0) {
		this.srr_1_0 = srr_1_0;
	}
	public String getRatio() {
		return ratio;
	}
	public void setRatio(String ratio) {
		this.ratio = ratio;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getLrr() {
		return lrr;
	}
	public void setLrr(String lrr) {
		this.lrr = lrr;
	}
	public String getLrr_type() {
		return lrr_type;
	}
	public void setLrr_type(String lrr_type) {
		this.lrr_type = lrr_type;
	}
	public String getLrr_0() {
		return lrr_0;
	}
	public void setLrr_0(String lrr_0) {
		this.lrr_0 = lrr_0;
	}
	public String getLrr_1() {
		return lrr_1;
	}
	public void setLrr_1(String lrr_1) {
		this.lrr_1 = lrr_1;
	}
	public String getLrr_1_0() {
		return lrr_1_0;
	}
	public void setLrr_1_0(String lrr_1_0) {
		this.lrr_1_0 = lrr_1_0;
	}
	public String getLrr_2() {
		return lrr_2;
	}
	public void setLrr_2(String lrr_2) {
		this.lrr_2 = lrr_2;
	}
	public Long getProValIncomeProtId() {
		return proValIncomeProtId;
	}
	public void setProValIncomeProtId(Long proValIncomeProtId) {
		this.proValIncomeProtId = proValIncomeProtId;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getSr_type() {
		return sr_type;
	}
	public void setSr_type(String sr_type) {
		this.sr_type = sr_type;
	}
	public String getSr_0() {
		return sr_0;
	}
	public void setSr_0(String sr_0) {
		this.sr_0 = sr_0;
	}
	public String getSr_1() {
		return sr_1;
	}
	public void setSr_1(String sr_1) {
		this.sr_1 = sr_1;
	}
	public String getSr_2() {
		return sr_2;
	}
	public void setSr_2(String sr_2) {
		this.sr_2 = sr_2;
	}
	public String getSrr_type() {
		return srr_type;
	}
	public void setSrr_type(String srr_type) {
		this.srr_type = srr_type;
	}
	public String getSrr_0() {
		return srr_0;
	}
	public void setSrr_0(String srr_0) {
		this.srr_0 = srr_0;
	}
	public String getSrr_1() {
		return srr_1;
	}
	public void setSrr_1(String srr_1) {
		this.srr_1 = srr_1;
	}
	public String getSrr_2() {
		return srr_2;
	}
	public void setSrr_2(String srr_2) {
		this.srr_2 = srr_2;
	}
	public String getSrr_3() {
		return srr_3;
	}
	public void setSrr_3(String srr_3) {
		this.srr_3 = srr_3;
	}
	public String getDj_type() {
		return dj_type;
	}
	public void setDj_type(String dj_type) {
		this.dj_type = dj_type;
	}
	public String getDj_0() {
		return dj_0;
	}
	public void setDj_0(String dj_0) {
		this.dj_0 = dj_0;
	}
	public String getDj_1() {
		return dj_1;
	}
	public void setDj_1(String dj_1) {
		this.dj_1 = dj_1;
	}
	public String getDjr_type() {
		return djr_type;
	}
	public void setDjr_type(String djr_type) {
		this.djr_type = djr_type;
	}
	public String getDjr_0() {
		return djr_0;
	}
	public void setDjr_0(String djr_0) {
		this.djr_0 = djr_0;
	}
	public String getDjr_1() {
		return djr_1;
	}
	public void setDjr_1(String djr_1) {
		this.djr_1 = djr_1;
	}
	public String getDjr_2() {
		return djr_2;
	}
	public void setDjr_2(String djr_2) {
		this.djr_2 = djr_2;
	}
	public String getXl_type() {
		return xl_type;
	}
	public void setXl_type(String xl_type) {
		this.xl_type = xl_type;
	}
	public String getXl_0() {
		return xl_0;
	}
	public void setXl_0(String xl_0) {
		this.xl_0 = xl_0;
	}
	public String getXl_1() {
		return xl_1;
	}
	public void setXl_1(String xl_1) {
		this.xl_1 = xl_1;
	}
	public String getXlr_type() {
		return xlr_type;
	}
	public void setXlr_type(String xlr_type) {
		this.xlr_type = xlr_type;
	}
	public String getXlr_0() {
		return xlr_0;
	}
	public void setXlr_0(String xlr_0) {
		this.xlr_0 = xlr_0;
	}
	public String getXlr_1() {
		return xlr_1;
	}
	public void setXlr_1(String xlr_1) {
		this.xlr_1 = xlr_1;
	}
	public String getXlr_2() {
		return xlr_2;
	}
	public void setXlr_2(String xlr_2) {
		this.xlr_2 = xlr_2;
	}
	@JsonIgnore
	@JSONField(serialize = false)
	public List<KeyValue> getSrr_3List(){
		return KeyValue.getKeyValueList(srr_3);
	}
	@JsonIgnore
	@JSONField(serialize = false)
	public List<KeyValue> getDjr_2List(){
		return KeyValue.getKeyValueList(djr_2);
	}
	@JsonIgnore
	@JSONField(serialize = false)
	public List<KeyValue> getXlr_2List(){
		return KeyValue.getKeyValueList(xlr_2);
	}
	@JsonIgnore
	@JSONField(serialize = false)
	public List<KeyValue> getResultList(){
		return KeyValue.getKeyValueListForJson(result);
	}
	@JsonIgnore
	@JSONField(serialize = false)
	public List<KeyValue> getLrr_2List(){
		return KeyValue.getKeyValueList(lrr_2);
	}
}
