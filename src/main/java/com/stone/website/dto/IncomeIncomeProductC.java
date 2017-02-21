package com.kpap.website.dto;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class IncomeIncomeProductC{
	public Long proValIncomeProtId;
	
	//方法分类：0--收入分成法；1--净利润分成法；2--超额收益法；3--成本重置模型；4--复杂系数模型
	public String category;
	//最终结果
	public String result;
	//收益额
	public String result_pre;
	//所得税
	public String result_rate;

	//******************专利前销量单价部分********************
	//销售单价类型：0--企业自身数据；1--人工录入
	public String l_dj_type;
	//销售单价--企业自身数据
	public String l_dj_0;
	//销售单价--人工录入
	public String l_dj_1;
	
	//收入增长率类型：0--企业自身数据；1--人工录入；2--逐年手工录入
	public String l_djr_type;
	//收入增长率基数--企业自身数据
	public String l_djr_0;
	//收入增长率--人工录入
	public String l_djr_1;
	//收入增长率--逐年手工录入
	public String l_djr_2;
	
	
	//销售量类型：0--企业自身数据；1--人工录入
	public String l_xl_type;
	//销售量--企业自身数据
	public String l_xl_0;
	//销售量--人工录入
	public String l_xl_1;
	
	//销售量增长率类型：0--企业自身数据；1--人工录入；2--逐年手工录入
	public String l_xlr_type;
	//销售量增长率--企业自身数据
	public String l_xlr_0;
	//销售量增长率--手工录入
	public String l_xlr_1;
	//销售量增长率--逐年手工录入
	public String l_xlr_2;
	
	//******************专利后单价销量部分********************
	//销售单价类型：0--企业自身数据；1--人工录入
	public String dj_type;
	//销售单价--企业自身数据
	public String dj_0;
	//销售单价--人工录入
	public String dj_1;
	
	//收入增长率类型：0--企业自身数据；1--人工录入；2--逐年手工录入
	public String djr_type;
	//收入增长率基数--企业自身数据
	public String djr_0;
	//收入增长率--人工录入
	public String djr_1;
	//收入增长率--逐年手工录入
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
	
	//******************专利前成本********************
	//成本类型：0--企业自身数据；1--人工录入
	public String l_cb_type;
	//成本--企业自身数据
	public String l_cb_0;
	//成本--人工录入
	public String l_cb_1;
	
	//成本增长率类型：0--企业自身数据；1--人工录入；2--逐年手工录入
	public String l_cbr_type;
	//成本增长率基数--企业自身数据
	public String l_cbr_0;
	//成本增长率--人工录入
	public String l_cbr_1;
	//成本增长率--逐年手工录入
	public String l_cbr_2;
	
	//******************专利后成本********************
	//成本类型：0--企业自身数据；1--人工录入
	public String cb_type;
	//成本--企业自身数据
	public String cb_0;
	//成本--人工录入
	public String cb_1;
	
	//成本增长率类型：0--企业自身数据；1--人工录入；2--逐年手工录入
	public String cbr_type;
	//成本增长率基数--企业自身数据
	public String cbr_0;
	//成本增长率--人工录入
	public String cbr_1;
	//成本增长率--逐年手工录入
	public String cbr_2;
	//所得税率
	public String tax_rate;
	
	
	public String getTax_rate() {
		return tax_rate;
	}
	public void setTax_rate(String tax_rate) {
		this.tax_rate = tax_rate;
	}
	public Long getProValIncomeProtId() {
		return proValIncomeProtId;
	}
	public void setProValIncomeProtId(Long proValIncomeProtId) {
		this.proValIncomeProtId = proValIncomeProtId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getL_dj_type() {
		return l_dj_type;
	}
	public void setL_dj_type(String l_dj_type) {
		this.l_dj_type = l_dj_type;
	}
	public String getL_dj_0() {
		return l_dj_0;
	}
	public void setL_dj_0(String l_dj_0) {
		this.l_dj_0 = l_dj_0;
	}
	public String getL_dj_1() {
		return l_dj_1;
	}
	public void setL_dj_1(String l_dj_1) {
		this.l_dj_1 = l_dj_1;
	}
	public String getL_djr_type() {
		return l_djr_type;
	}
	public void setL_djr_type(String l_djr_type) {
		this.l_djr_type = l_djr_type;
	}
	public String getL_djr_0() {
		return l_djr_0;
	}
	public void setL_djr_0(String l_djr_0) {
		this.l_djr_0 = l_djr_0;
	}
	public String getL_djr_1() {
		return l_djr_1;
	}
	public void setL_djr_1(String l_djr_1) {
		this.l_djr_1 = l_djr_1;
	}
	public String getL_djr_2() {
		return l_djr_2;
	}
	public void setL_djr_2(String l_djr_2) {
		this.l_djr_2 = l_djr_2;
	}
	public String getL_xl_type() {
		return l_xl_type;
	}
	public void setL_xl_type(String l_xl_type) {
		this.l_xl_type = l_xl_type;
	}
	public String getL_xl_0() {
		return l_xl_0;
	}
	public void setL_xl_0(String l_xl_0) {
		this.l_xl_0 = l_xl_0;
	}
	public String getL_xl_1() {
		return l_xl_1;
	}
	public void setL_xl_1(String l_xl_1) {
		this.l_xl_1 = l_xl_1;
	}
	public String getL_xlr_type() {
		return l_xlr_type;
	}
	public void setL_xlr_type(String l_xlr_type) {
		this.l_xlr_type = l_xlr_type;
	}
	public String getL_xlr_0() {
		return l_xlr_0;
	}
	public void setL_xlr_0(String l_xlr_0) {
		this.l_xlr_0 = l_xlr_0;
	}
	public String getL_xlr_1() {
		return l_xlr_1;
	}
	public void setL_xlr_1(String l_xlr_1) {
		this.l_xlr_1 = l_xlr_1;
	}
	public String getL_xlr_2() {
		return l_xlr_2;
	}
	public void setL_xlr_2(String l_xlr_2) {
		this.l_xlr_2 = l_xlr_2;
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
	public String getL_cb_type() {
		return l_cb_type;
	}
	public void setL_cb_type(String l_cb_type) {
		this.l_cb_type = l_cb_type;
	}
	public String getL_cb_0() {
		return l_cb_0;
	}
	public void setL_cb_0(String l_cb_0) {
		this.l_cb_0 = l_cb_0;
	}
	public String getL_cb_1() {
		return l_cb_1;
	}
	public void setL_cb_1(String l_cb_1) {
		this.l_cb_1 = l_cb_1;
	}
	public String getL_cbr_type() {
		return l_cbr_type;
	}
	public void setL_cbr_type(String l_cbr_type) {
		this.l_cbr_type = l_cbr_type;
	}
	public String getL_cbr_0() {
		return l_cbr_0;
	}
	public void setL_cbr_0(String l_cbr_0) {
		this.l_cbr_0 = l_cbr_0;
	}
	public String getL_cbr_1() {
		return l_cbr_1;
	}
	public void setL_cbr_1(String l_cbr_1) {
		this.l_cbr_1 = l_cbr_1;
	}
	public String getL_cbr_2() {
		return l_cbr_2;
	}
	public void setL_cbr_2(String l_cbr_2) {
		this.l_cbr_2 = l_cbr_2;
	}
	public String getCb_type() {
		return cb_type;
	}
	public void setCb_type(String cb_type) {
		this.cb_type = cb_type;
	}
	public String getCb_0() {
		return cb_0;
	}
	public void setCb_0(String cb_0) {
		this.cb_0 = cb_0;
	}
	public String getCb_1() {
		return cb_1;
	}
	public void setCb_1(String cb_1) {
		this.cb_1 = cb_1;
	}
	public String getCbr_type() {
		return cbr_type;
	}
	public void setCbr_type(String cbr_type) {
		this.cbr_type = cbr_type;
	}
	public String getCbr_0() {
		return cbr_0;
	}
	public void setCbr_0(String cbr_0) {
		this.cbr_0 = cbr_0;
	}
	public String getCbr_1() {
		return cbr_1;
	}
	public void setCbr_1(String cbr_1) {
		this.cbr_1 = cbr_1;
	}
	public String getCbr_2() {
		return cbr_2;
	}
	public void setCbr_2(String cbr_2) {
		this.cbr_2 = cbr_2;
	}
	public String getResult_pre() {
		return result_pre;
	}
	public void setResult_pre(String result_pre) {
		this.result_pre = result_pre;
	}
	public String getResult_rate() {
		return result_rate;
	}
	public void setResult_rate(String result_rate) {
		this.result_rate = result_rate;
	}
	@JsonIgnore
	@JSONField(serialize = false)
	public List<KeyValue> getL_djr_2List(){
		return KeyValue.getKeyValueList(l_djr_2);
	}
	@JsonIgnore
	@JSONField(serialize = false)
	public List<KeyValue> getL_xlr_2List(){
		return KeyValue.getKeyValueList(l_xlr_2);
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
	public List<KeyValue> getL_cbr_2List(){
		return KeyValue.getKeyValueList(l_cbr_2);
	}
	@JsonIgnore
	@JSONField(serialize = false)
	public List<KeyValue> getCbr_2List(){
		return KeyValue.getKeyValueList(cbr_2);
	}
	@JsonIgnore
	@JSONField(serialize = false)
	public List<KeyValue> getResultList(){
		return KeyValue.getKeyValueListForJson(result);
	}
	
}
