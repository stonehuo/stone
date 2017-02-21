package com.kpap.website.dto;

/**
 * 成本法
 * @author haiwenshen
 *
 */
public class Cost {
	
	public String proCode;
	//成本法方法：3--成本重置模型；4--复杂系数模型
	public String category;
	//估值结果
	public String result;
	

	//专利资产的重置成本
	public String reset_0;
	//专利资产的价值贬值率
	public String reset_1;
	//专利资产的重置成本 :直接成本
	public String reset_2;
	//专利资产的重置成本 :间接成本
	public String reset_3;
	//专利资产的重置成本 :资金成本
	public String reset_4;
	//专利资产的重置成本 :合理利润
	public String reset_5;
	
	
	//复杂系数模型--专利科研成本
	public String coefficient_0;
	//复杂系数模型--科研复杂系数
	public String coefficient_1;
	//复杂系数模型--人工成本
	public String coefficient_2;
	//复杂系数模型--物料设备成本
	public String coefficient_3;
	//复杂系数模型--其他成本
	public String coefficient_4;
	
	//人工费类型：0--指数调整；1--据实调整
	public String rg_type;
	//人工费：研发期实际人工费
	public String e23;
	//人工费：研发期平均工资指数
	public String rg_z_0;
	//人工费：评估基准日平均工资指数
	public String rg_z_1;
	//人工费：据实调整
	public String f23;
	
	//材料费：研发期材料费
	public String c25;
	//材料费：研发期商品零售价格指数
	public String ylsjg_z;
	//材料费：评估基准日商品零售价格指数
	public String plsjg_z;
	
	//设备分摊费类型：0--设备不可再用；1--设备可再用
	public String sbft_type;
	//设备不可再用-设备分摊费：设备原值
	public String c28;
	//设备不可再用-设备分摊费：研发期工业品出厂价格指数
	public String yccjg_z;
	//设备不可再用-设备分摊费：评估基准日工业品出厂价格指数
	public String pccjg_z;
	//设备可再用-设备分摊费：设备原值
	public String c28_1;
	//设备可再用-设备分摊费：研发期工业品出厂价格指数
	public String yccjg_z_1;
	//设备可再用-设备分摊费：评估基准日工业品出厂价格指数
	public String pccjg_z_1;
	//设备可再用-设备分摊费：研发周期
	public String devCycle;
	//设备可再用-设备分摊费：设备经济使用年限
	public String c29;
	
	//直接成本--其他费用
	public String c30;
	
	//间接成本--差旅费
	public String c31;
	//间接成本--研发期知识产权事务费
	public String c32;
	//间接成本--研发期场地使用费
	public String c33;
	//间接成本--研发期水电费
	public String c34;
	//间接成本--研发期其他费用
	public String c35;
	
	//资金成本--研发周期
	public String zj_0;
	//资金成本--贷款利率下拉选择
	public String zj_1;
	//资金成本--贷款利率下拉值
	public String zj_1_p;
	
	//合理利润类型：0--成本费用利润率（可比上市公司）；1--成本费用利润率（人工录入）;2--投入资本回报率(可比上市公司);3--投入资本回报率(企业绩效评价值-同行业 )
	public String hllrl_type;
	//合理利润--成本费用利润率（可比上市公司）
	public String hllrl_0;
	//合理利润--成本费用利润率（人工录入）
	public String hllrl_1;
	//合理利润--投入资本回报率(可比上市公司)
	public String hllrl_2;
	//合理利润--投入资本回报率(企业绩效评价值-同行业 )
	public String hllrl_3;
	
	//贬值率--法定保护年限
	public String jzbzl_0;
	//贬值率--技术寿命年限类型：0--公式计算；1--人工录入
	public String jzbzl_type;
	//贬值率(技术寿命年限)--技术更新周期
	public String jzbzl_1;
	//贬值率(技术寿命年限)--技术先进性
	public String jzbzl_2;
	//贬值率(技术寿命年限)--可替代性
	public String jzbzl_3;
	//贬值率(技术寿命年限)--技术应用的市场前景
	public String jzbzl_4;
	//贬值率(技术寿命年限)--技术应用的经济效益
	public String jzbzl_5;
	//贬值率(技术寿命年限)--技术应用的社会效益
	public String jzbzl_6;
	//贬值率(技术寿命年限)--人工录入
	public String jzbzl_7;
	//贬值率--经济寿命年限
	public String jzbzl_8;
	//专利已存在年限--专利估值基准日
	public String baseDate;
	//专利已存在年限--专利申请日
	public String applyDate;
	
	
	//科研复杂系数 --先进性
	public String kyfzxs_0;
	//科研复杂系数 --成熟性
	public String kyfzxs_1;
	//科研复杂系数 --风险性
	public String kyfzxs_2;
	
	
	public String getKyfzxs_0() {
		return kyfzxs_0;
	}
	public void setKyfzxs_0(String kyfzxs_0) {
		this.kyfzxs_0 = kyfzxs_0;
	}
	public String getKyfzxs_1() {
		return kyfzxs_1;
	}
	public void setKyfzxs_1(String kyfzxs_1) {
		this.kyfzxs_1 = kyfzxs_1;
	}
	public String getKyfzxs_2() {
		return kyfzxs_2;
	}
	public void setKyfzxs_2(String kyfzxs_2) {
		this.kyfzxs_2 = kyfzxs_2;
	}
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getReset_0() {
		return reset_0;
	}
	public void setReset_0(String reset_0) {
		this.reset_0 = reset_0;
	}
	public String getReset_1() {
		return reset_1;
	}
	public void setReset_1(String reset_1) {
		this.reset_1 = reset_1;
	}
	public String getReset_2() {
		return reset_2;
	}
	public void setReset_2(String reset_2) {
		this.reset_2 = reset_2;
	}
	public String getReset_3() {
		return reset_3;
	}
	public void setReset_3(String reset_3) {
		this.reset_3 = reset_3;
	}
	public String getReset_4() {
		return reset_4;
	}
	public void setReset_4(String reset_4) {
		this.reset_4 = reset_4;
	}
	public String getReset_5() {
		return reset_5;
	}
	public void setReset_5(String reset_5) {
		this.reset_5 = reset_5;
	}
	public String getRg_type() {
		return rg_type;
	}
	public void setRg_type(String rg_type) {
		this.rg_type = rg_type;
	}
	public String getE23() {
		return e23;
	}
	public void setE23(String e23) {
		this.e23 = e23;
	}
	public String getRg_z_0() {
		return rg_z_0;
	}
	public void setRg_z_0(String rg_z_0) {
		this.rg_z_0 = rg_z_0;
	}
	public String getRg_z_1() {
		return rg_z_1;
	}
	public void setRg_z_1(String rg_z_1) {
		this.rg_z_1 = rg_z_1;
	}
	public String getF23() {
		return f23;
	}
	public void setF23(String f23) {
		this.f23 = f23;
	}
	public String getC25() {
		return c25;
	}
	public void setC25(String c25) {
		this.c25 = c25;
	}
	public String getYlsjg_z() {
		return ylsjg_z;
	}
	public void setYlsjg_z(String ylsjg_z) {
		this.ylsjg_z = ylsjg_z;
	}
	public String getPlsjg_z() {
		return plsjg_z;
	}
	public void setPlsjg_z(String plsjg_z) {
		this.plsjg_z = plsjg_z;
	}
	public String getSbft_type() {
		return sbft_type;
	}
	public void setSbft_type(String sbft_type) {
		this.sbft_type = sbft_type;
	}
	public String getC28() {
		return c28;
	}
	public void setC28(String c28) {
		this.c28 = c28;
	}
	public String getYccjg_z() {
		return yccjg_z;
	}
	public void setYccjg_z(String yccjg_z) {
		this.yccjg_z = yccjg_z;
	}
	public String getPccjg_z() {
		return pccjg_z;
	}
	public void setPccjg_z(String pccjg_z) {
		this.pccjg_z = pccjg_z;
	}
	public String getDevCycle() {
		return devCycle;
	}
	public void setDevCycle(String devCycle) {
		this.devCycle = devCycle;
	}
	public String getC29() {
		return c29;
	}
	public void setC29(String c29) {
		this.c29 = c29;
	}
	public String getC30() {
		return c30;
	}
	public void setC30(String c30) {
		this.c30 = c30;
	}
	public String getC31() {
		return c31;
	}
	public void setC31(String c31) {
		this.c31 = c31;
	}
	public String getC32() {
		return c32;
	}
	public void setC32(String c32) {
		this.c32 = c32;
	}
	public String getC33() {
		return c33;
	}
	public void setC33(String c33) {
		this.c33 = c33;
	}
	public String getC34() {
		return c34;
	}
	public void setC34(String c34) {
		this.c34 = c34;
	}
	public String getC35() {
		return c35;
	}
	public void setC35(String c35) {
		this.c35 = c35;
	}
	public String getZj_0() {
		return zj_0;
	}
	public void setZj_0(String zj_0) {
		this.zj_0 = zj_0;
	}
	public String getZj_1() {
		return zj_1;
	}
	public void setZj_1(String zj_1) {
		this.zj_1 = zj_1;
	}
	public String getZj_1_p() {
		return zj_1_p;
	}
	public void setZj_1_p(String zj_1_p) {
		this.zj_1_p = zj_1_p;
	}
	public String getHllrl_type() {
		return hllrl_type;
	}
	public void setHllrl_type(String hllrl_type) {
		this.hllrl_type = hllrl_type;
	}
	public String getHllrl_0() {
		return hllrl_0;
	}
	public void setHllrl_0(String hllrl_0) {
		this.hllrl_0 = hllrl_0;
	}
	public String getHllrl_1() {
		return hllrl_1;
	}
	public void setHllrl_1(String hllrl_1) {
		this.hllrl_1 = hllrl_1;
	}
	public String getHllrl_2() {
		return hllrl_2;
	}
	public void setHllrl_2(String hllrl_2) {
		this.hllrl_2 = hllrl_2;
	}
	public String getHllrl_3() {
		return hllrl_3;
	}
	public void setHllrl_3(String hllrl_3) {
		this.hllrl_3 = hllrl_3;
	}
	public String getJzbzl_0() {
		return jzbzl_0;
	}
	public void setJzbzl_0(String jzbzl_0) {
		this.jzbzl_0 = jzbzl_0;
	}
	public String getJzbzl_type() {
		return jzbzl_type;
	}
	public void setJzbzl_type(String jzbzl_type) {
		this.jzbzl_type = jzbzl_type;
	}
	public String getJzbzl_1() {
		return jzbzl_1;
	}
	public void setJzbzl_1(String jzbzl_1) {
		this.jzbzl_1 = jzbzl_1;
	}
	public String getJzbzl_2() {
		return jzbzl_2;
	}
	public void setJzbzl_2(String jzbzl_2) {
		this.jzbzl_2 = jzbzl_2;
	}
	public String getJzbzl_3() {
		return jzbzl_3;
	}
	public void setJzbzl_3(String jzbzl_3) {
		this.jzbzl_3 = jzbzl_3;
	}
	public String getJzbzl_4() {
		return jzbzl_4;
	}
	public void setJzbzl_4(String jzbzl_4) {
		this.jzbzl_4 = jzbzl_4;
	}
	public String getJzbzl_5() {
		return jzbzl_5;
	}
	public void setJzbzl_5(String jzbzl_5) {
		this.jzbzl_5 = jzbzl_5;
	}
	public String getJzbzl_6() {
		return jzbzl_6;
	}
	public void setJzbzl_6(String jzbzl_6) {
		this.jzbzl_6 = jzbzl_6;
	}
	public String getJzbzl_7() {
		return jzbzl_7;
	}
	public void setJzbzl_7(String jzbzl_7) {
		this.jzbzl_7 = jzbzl_7;
	}
	public String getJzbzl_8() {
		return jzbzl_8;
	}
	public void setJzbzl_8(String jzbzl_8) {
		this.jzbzl_8 = jzbzl_8;
	}
	public String getBaseDate() {
		return baseDate;
	}
	public void setBaseDate(String baseDate) {
		this.baseDate = baseDate;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	public String getCoefficient_0() {
		return coefficient_0;
	}
	public void setCoefficient_0(String coefficient_0) {
		this.coefficient_0 = coefficient_0;
	}
	public String getCoefficient_1() {
		return coefficient_1;
	}
	public void setCoefficient_1(String coefficient_1) {
		this.coefficient_1 = coefficient_1;
	}
	public String getCoefficient_2() {
		return coefficient_2;
	}
	public void setCoefficient_2(String coefficient_2) {
		this.coefficient_2 = coefficient_2;
	}
	public String getCoefficient_3() {
		return coefficient_3;
	}
	public void setCoefficient_3(String coefficient_3) {
		this.coefficient_3 = coefficient_3;
	}
	public String getCoefficient_4() {
		return coefficient_4;
	}
	public void setCoefficient_4(String coefficient_4) {
		this.coefficient_4 = coefficient_4;
	}
	public String getC28_1() {
		return c28_1;
	}
	public void setC28_1(String c28_1) {
		this.c28_1 = c28_1;
	}
	public String getYccjg_z_1() {
		return yccjg_z_1;
	}
	public void setYccjg_z_1(String yccjg_z_1) {
		this.yccjg_z_1 = yccjg_z_1;
	}
	public String getPccjg_z_1() {
		return pccjg_z_1;
	}
	public void setPccjg_z_1(String pccjg_z_1) {
		this.pccjg_z_1 = pccjg_z_1;
	}
}
