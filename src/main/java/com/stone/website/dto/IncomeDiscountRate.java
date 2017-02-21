package com.kpap.website.dto;

import java.math.BigDecimal;

public class IncomeDiscountRate {
	public Long proValId;
	
	//方法分类：0--收入分成法；1--净利润分成法；2--超额收益法；3--成本重置模型；4--复杂系数模型
	public String category;
	//最终结果
	public BigDecimal result;
	//计算方法：0--加权平均资本成本WACCBT ；1--Ri(推荐) ；2--风险加和 ；3--行业平均收益率 ；4--人工录入 
	public String method;
	
	//------------------方式一加权平均资本成本WACCBT------------------------------
	//无风险收益率类型
	public String a_rf_type;
	//国债到期收益率--类型：0--到期日5年及以上；1--到期日10年及以上
	public String a_rf_0;
	//国债到期收益率
	public String a_rf_0_p;
	//国债票面利率--类型：0--到期日5年及以上；1--到期日10年及以上
	public String a_rf_1;
	//国债票面利率
	public String a_rf_1_p;
	//市场报酬率--类型：0--前5年；1--前10年；2--评估基准日当年；3--前N年
	public String a_erp_0;
	//市场报酬率
	public String a_erp_0_p;
	//特定风险调整系数--类型：1.00--1.00%；1.50--1.50%；2.00--2.00%；2.50--2.50%；3.00--3.00%；3.50--3.50%；4.00--4.00%；5.00--5.00%；N--人工录入
	public String a_rs_0;
	//特定风险调整系数
	public String a_rs_0_p;
	//行业的平均风险系数--类型：0--前5年；1--前10年；2--评估基准日当年；3--前N年
	public String a_b_0;
	//行业的平均风险系数
	public String a_b_0_p;
	//所得税率
	public String a_tax_rate;
	//权益资本比重--类型：0--来源于CPIQ报表；1--人工录入
	public String a_e_0;
	//权益资本比重
	public String a_e_0_p;
	//债务资本比重--类型：0--来源于CPIQ报表；1--人工录入
	public String a_d_0;
	//债务资本比重
	public String a_d_0_p;
	//债务资本成本--类型：0--5年期以上银行贷款利率；1--人工录入
	public String a_rd_0;
	//债务资本成本
	public String a_rd_0_p;
	
	//------------------方式二Ri(推荐) ------------------------------
	//无风险收益率类型
	public String b_rf_type;
	//国债到期收益率--类型：0--到期日5年及以上；1--到期日10年及以上
	public String b_rf_0;
	//国债到期收益率
	public String b_rf_0_p;
	//国债票面利率--类型：0--到期日5年及以上；1--到期日10年及以上
	public String b_rf_1;
	//国债票面利率
	public String b_rf_1_p;
	//市场报酬率--类型：0--前5年；1--前10年；2--评估基准日当年；3--前N年
	public String b_erp_0;
	//市场报酬率
	public String b_erp_0_p;
	//特定风险调整系数--类型：1.00--1.00%；1.50--1.50%；2.00--2.00%；2.50--2.50%；3.00--3.00%；3.50--3.50%；4.00--4.00%；5.00--5.00%；N--人工录入
	public String b_rs_0;
	//特定风险调整系数
	public String b_rs_0_p;
	//行业的平均风险系数--类型：0--前5年；1--前10年；2--评估基准日当年；3--前N年
	public String b_b_0;
	//行业的平均风险系数
	public String b_b_0_p;
	//所得税率
	public String b_tax_rate;
	//权益资本比重--类型：0--来源于CPIQ报表；1--人工录入
	public String b_e_0;
	//权益资本比重
	public String b_e_0_p;
	//债务资本比重--类型：0--来源于CPIQ报表；1--人工录入
	public String b_d_0;
	//债务资本比重
	public String b_d_0_p;
	//债务资本成本--类型：0--5年期以上银行贷款利率；1--人工录入
	public String b_rd_0;
	//债务资本成本
	public String b_rd_0_p;
	
	//流动资产（资金）占全部资产比例--类型：0--来源于CPIQ报表；1--人工录入
	public String b_other_0;
	//流动资产（资金）占全部资产比例
	public String b_other_0_p;
	//固定资产（资金）占全部资产比例--类型：0--来源于CPIQ报表；1--人工录入
	public String b_other_1;
	//固定资产（资金）占全部资产比例
	public String b_other_1_p;
	//投资流动资产（资金）期望回报率--类型：0--6个月以内贷款利率；1--6个月~1年贷款利率；2--1年~3年贷款利率；3--3~5年贷款利率；4--5年以上贷款利率
	public String b_other_2;
	//投资流动资产（资金）期望回报率
	public String b_other_2_p;
	//投资固定资产（资金）期望回报率--类型：0--6个月以内贷款利率；1--6个月~1年贷款利率；2--1年~3年贷款利率；3--3~5年贷款利率；4--5年以上贷款利率
	public String b_other_3;
	//投资固定资产（资金）期望回报率
	public String b_other_3_p;
	//无形资产（资金）占全部资产比例--类型：0--来源于CPIQ报表；1--人工录入
	public String b_other_4;
	//无形资产（资金）占全部资产比例
	public String b_other_4_p;
	
	//------------------方式三风险加和 ------------------------------
	//无风险收益率类型：0--国债到期收益率；1--国债票面利率
	public String c_rf_type;
	//国债到期收益率--类型：0--到期日5年及以上；1--到期日10年及以上
	public String c_rf_0;
	//国债到期收益率
	public String c_rf_0_p;
	//国债票面利率--类型：0--到期日5年及以上；1--到期日10年及以上
	public String c_rf_1;
	//国债票面利率
	public String c_rf_1_p;
	
	//市场容量风险
	public String c_other_0;
	//市场现有竞争风险
	public String c_other_1;
	//市场潜在竞争风险-规模经济性
	public String c_other_2;
	//市场潜在竞争风险-投资额及转换费用
	public String c_other_3;
	//市场潜在竞争风险-销售网络
	public String c_other_4;
	//技术转化风险
	public String c_other_5;
	//技术替代风险
	public String c_other_6;
	//技术权利风险
	public String c_other_7;
	//技术整合风险
	public String c_other_8;
	//销售服务风险
	public String c_other_9;
	//质量管理风险
	public String c_other_10;
	//技术开发风险
	public String c_other_11;
	//融资风险
	public String c_other_12;
	//流动资金风险
	public String c_other_13;
	//其他风险
	public String c_other_14;
	
	//------------------方式四行业平均收益率------------------------------
	//行业平均收益率类型：0--可比上市公司；1--企业绩效评价值-同行业平均值
	public String d_type;
	//可比上市公司
	public String d_0;
	//企业绩效评价值-同行业平均值类型：0--当年；1--前一年；2--前二年平均；3--前三年平均
	public String d_1;
	//企业绩效评价值-同行业平均值
	public String d_1_0;
	
	//------------------方式五人工录入------------------------------
	public String e;

	public Long getProValId() {
		return proValId;
	}

	public void setProValId(Long proValId) {
		this.proValId = proValId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BigDecimal getResult() {
		return result;
	}

	public void setResult(BigDecimal result) {
		this.result = result;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getA_rf_type() {
		return a_rf_type;
	}

	public void setA_rf_type(String a_rf_type) {
		this.a_rf_type = a_rf_type;
	}

	public String getA_rf_0() {
		return a_rf_0;
	}

	public void setA_rf_0(String a_rf_0) {
		this.a_rf_0 = a_rf_0;
	}

	public String getA_rf_0_p() {
		return a_rf_0_p;
	}

	public void setA_rf_0_p(String a_rf_0_p) {
		this.a_rf_0_p = a_rf_0_p;
	}

	public String getA_rf_1() {
		return a_rf_1;
	}

	public void setA_rf_1(String a_rf_1) {
		this.a_rf_1 = a_rf_1;
	}

	public String getA_rf_1_p() {
		return a_rf_1_p;
	}

	public void setA_rf_1_p(String a_rf_1_p) {
		this.a_rf_1_p = a_rf_1_p;
	}

	public String getA_erp_0() {
		return a_erp_0;
	}

	public void setA_erp_0(String a_erp_0) {
		this.a_erp_0 = a_erp_0;
	}

	public String getA_erp_0_p() {
		return a_erp_0_p;
	}

	public void setA_erp_0_p(String a_erp_0_p) {
		this.a_erp_0_p = a_erp_0_p;
	}

	public String getA_rs_0() {
		return a_rs_0;
	}

	public void setA_rs_0(String a_rs_0) {
		this.a_rs_0 = a_rs_0;
	}

	public String getA_rs_0_p() {
		return a_rs_0_p;
	}

	public void setA_rs_0_p(String a_rs_0_p) {
		this.a_rs_0_p = a_rs_0_p;
	}

	public String getA_b_0() {
		return a_b_0;
	}

	public void setA_b_0(String a_b_0) {
		this.a_b_0 = a_b_0;
	}

	public String getA_b_0_p() {
		return a_b_0_p;
	}

	public void setA_b_0_p(String a_b_0_p) {
		this.a_b_0_p = a_b_0_p;
	}

	public String getA_tax_rate() {
		return a_tax_rate;
	}

	public void setA_tax_rate(String a_tax_rate) {
		this.a_tax_rate = a_tax_rate;
	}

	public String getA_e_0() {
		return a_e_0;
	}

	public void setA_e_0(String a_e_0) {
		this.a_e_0 = a_e_0;
	}

	public String getA_e_0_p() {
		return a_e_0_p;
	}

	public void setA_e_0_p(String a_e_0_p) {
		this.a_e_0_p = a_e_0_p;
	}

	public String getA_d_0() {
		return a_d_0;
	}

	public void setA_d_0(String a_d_0) {
		this.a_d_0 = a_d_0;
	}

	public String getA_d_0_p() {
		return a_d_0_p;
	}

	public void setA_d_0_p(String a_d_0_p) {
		this.a_d_0_p = a_d_0_p;
	}

	public String getA_rd_0() {
		return a_rd_0;
	}

	public void setA_rd_0(String a_rd_0) {
		this.a_rd_0 = a_rd_0;
	}

	public String getA_rd_0_p() {
		return a_rd_0_p;
	}

	public void setA_rd_0_p(String a_rd_0_p) {
		this.a_rd_0_p = a_rd_0_p;
	}

	public String getB_rf_type() {
		return b_rf_type;
	}

	public void setB_rf_type(String b_rf_type) {
		this.b_rf_type = b_rf_type;
	}

	public String getB_rf_0() {
		return b_rf_0;
	}

	public void setB_rf_0(String b_rf_0) {
		this.b_rf_0 = b_rf_0;
	}

	public String getB_rf_0_p() {
		return b_rf_0_p;
	}

	public void setB_rf_0_p(String b_rf_0_p) {
		this.b_rf_0_p = b_rf_0_p;
	}

	public String getB_rf_1() {
		return b_rf_1;
	}

	public void setB_rf_1(String b_rf_1) {
		this.b_rf_1 = b_rf_1;
	}

	public String getB_rf_1_p() {
		return b_rf_1_p;
	}

	public void setB_rf_1_p(String b_rf_1_p) {
		this.b_rf_1_p = b_rf_1_p;
	}

	public String getB_erp_0() {
		return b_erp_0;
	}

	public void setB_erp_0(String b_erp_0) {
		this.b_erp_0 = b_erp_0;
	}

	public String getB_erp_0_p() {
		return b_erp_0_p;
	}

	public void setB_erp_0_p(String b_erp_0_p) {
		this.b_erp_0_p = b_erp_0_p;
	}

	public String getB_rs_0() {
		return b_rs_0;
	}

	public void setB_rs_0(String b_rs_0) {
		this.b_rs_0 = b_rs_0;
	}

	public String getB_rs_0_p() {
		return b_rs_0_p;
	}

	public void setB_rs_0_p(String b_rs_0_p) {
		this.b_rs_0_p = b_rs_0_p;
	}

	public String getB_b_0() {
		return b_b_0;
	}

	public void setB_b_0(String b_b_0) {
		this.b_b_0 = b_b_0;
	}

	public String getB_b_0_p() {
		return b_b_0_p;
	}

	public void setB_b_0_p(String b_b_0_p) {
		this.b_b_0_p = b_b_0_p;
	}

	public String getB_tax_rate() {
		return b_tax_rate;
	}

	public void setB_tax_rate(String b_tax_rate) {
		this.b_tax_rate = b_tax_rate;
	}

	public String getB_e_0() {
		return b_e_0;
	}

	public void setB_e_0(String b_e_0) {
		this.b_e_0 = b_e_0;
	}

	public String getB_e_0_p() {
		return b_e_0_p;
	}

	public void setB_e_0_p(String b_e_0_p) {
		this.b_e_0_p = b_e_0_p;
	}

	public String getB_d_0() {
		return b_d_0;
	}

	public void setB_d_0(String b_d_0) {
		this.b_d_0 = b_d_0;
	}

	public String getB_d_0_p() {
		return b_d_0_p;
	}

	public void setB_d_0_p(String b_d_0_p) {
		this.b_d_0_p = b_d_0_p;
	}

	public String getB_rd_0() {
		return b_rd_0;
	}

	public void setB_rd_0(String b_rd_0) {
		this.b_rd_0 = b_rd_0;
	}

	public String getB_rd_0_p() {
		return b_rd_0_p;
	}

	public void setB_rd_0_p(String b_rd_0_p) {
		this.b_rd_0_p = b_rd_0_p;
	}

	public String getB_other_0() {
		return b_other_0;
	}

	public void setB_other_0(String b_other_0) {
		this.b_other_0 = b_other_0;
	}

	public String getB_other_0_p() {
		return b_other_0_p;
	}

	public void setB_other_0_p(String b_other_0_p) {
		this.b_other_0_p = b_other_0_p;
	}

	public String getB_other_1() {
		return b_other_1;
	}

	public void setB_other_1(String b_other_1) {
		this.b_other_1 = b_other_1;
	}

	public String getB_other_1_p() {
		return b_other_1_p;
	}

	public void setB_other_1_p(String b_other_1_p) {
		this.b_other_1_p = b_other_1_p;
	}

	public String getB_other_2() {
		return b_other_2;
	}

	public void setB_other_2(String b_other_2) {
		this.b_other_2 = b_other_2;
	}

	public String getB_other_2_p() {
		return b_other_2_p;
	}

	public void setB_other_2_p(String b_other_2_p) {
		this.b_other_2_p = b_other_2_p;
	}

	public String getB_other_3() {
		return b_other_3;
	}

	public void setB_other_3(String b_other_3) {
		this.b_other_3 = b_other_3;
	}

	public String getB_other_3_p() {
		return b_other_3_p;
	}

	public void setB_other_3_p(String b_other_3_p) {
		this.b_other_3_p = b_other_3_p;
	}

	public String getB_other_4() {
		return b_other_4;
	}

	public void setB_other_4(String b_other_4) {
		this.b_other_4 = b_other_4;
	}

	public String getB_other_4_p() {
		return b_other_4_p;
	}

	public void setB_other_4_p(String b_other_4_p) {
		this.b_other_4_p = b_other_4_p;
	}

	public String getC_rf_type() {
		return c_rf_type;
	}

	public void setC_rf_type(String c_rf_type) {
		this.c_rf_type = c_rf_type;
	}

	public String getC_rf_0() {
		return c_rf_0;
	}

	public void setC_rf_0(String c_rf_0) {
		this.c_rf_0 = c_rf_0;
	}

	public String getC_rf_0_p() {
		return c_rf_0_p;
	}

	public void setC_rf_0_p(String c_rf_0_p) {
		this.c_rf_0_p = c_rf_0_p;
	}

	public String getC_rf_1() {
		return c_rf_1;
	}

	public void setC_rf_1(String c_rf_1) {
		this.c_rf_1 = c_rf_1;
	}

	public String getC_rf_1_p() {
		return c_rf_1_p;
	}

	public void setC_rf_1_p(String c_rf_1_p) {
		this.c_rf_1_p = c_rf_1_p;
	}

	public String getC_other_0() {
		return c_other_0;
	}

	public void setC_other_0(String c_other_0) {
		this.c_other_0 = c_other_0;
	}

	public String getC_other_1() {
		return c_other_1;
	}

	public void setC_other_1(String c_other_1) {
		this.c_other_1 = c_other_1;
	}

	public String getC_other_2() {
		return c_other_2;
	}

	public void setC_other_2(String c_other_2) {
		this.c_other_2 = c_other_2;
	}

	public String getC_other_3() {
		return c_other_3;
	}

	public void setC_other_3(String c_other_3) {
		this.c_other_3 = c_other_3;
	}

	public String getC_other_4() {
		return c_other_4;
	}

	public void setC_other_4(String c_other_4) {
		this.c_other_4 = c_other_4;
	}

	public String getC_other_5() {
		return c_other_5;
	}

	public void setC_other_5(String c_other_5) {
		this.c_other_5 = c_other_5;
	}

	public String getC_other_6() {
		return c_other_6;
	}

	public void setC_other_6(String c_other_6) {
		this.c_other_6 = c_other_6;
	}

	public String getC_other_7() {
		return c_other_7;
	}

	public void setC_other_7(String c_other_7) {
		this.c_other_7 = c_other_7;
	}

	public String getC_other_8() {
		return c_other_8;
	}

	public void setC_other_8(String c_other_8) {
		this.c_other_8 = c_other_8;
	}

	public String getC_other_9() {
		return c_other_9;
	}

	public void setC_other_9(String c_other_9) {
		this.c_other_9 = c_other_9;
	}

	public String getC_other_10() {
		return c_other_10;
	}

	public void setC_other_10(String c_other_10) {
		this.c_other_10 = c_other_10;
	}

	public String getC_other_11() {
		return c_other_11;
	}

	public void setC_other_11(String c_other_11) {
		this.c_other_11 = c_other_11;
	}

	public String getC_other_12() {
		return c_other_12;
	}

	public void setC_other_12(String c_other_12) {
		this.c_other_12 = c_other_12;
	}

	public String getC_other_13() {
		return c_other_13;
	}

	public void setC_other_13(String c_other_13) {
		this.c_other_13 = c_other_13;
	}

	public String getC_other_14() {
		return c_other_14;
	}

	public void setC_other_14(String c_other_14) {
		this.c_other_14 = c_other_14;
	}

	public String getD_type() {
		return d_type;
	}

	public void setD_type(String d_type) {
		this.d_type = d_type;
	}

	public String getD_0() {
		return d_0;
	}

	public void setD_0(String d_0) {
		this.d_0 = d_0;
	}

	public String getD_1() {
		return d_1;
	}

	public void setD_1(String d_1) {
		this.d_1 = d_1;
	}

	public String getD_1_0() {
		return d_1_0;
	}

	public void setD_1_0(String d_1_0) {
		this.d_1_0 = d_1_0;
	}

	public String getE() {
		return e;
	}

	public void setE(String e) {
		this.e = e;
	}
}
