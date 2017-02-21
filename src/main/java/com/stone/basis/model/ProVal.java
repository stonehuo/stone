package com.kpap.basis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.kpap.common.annotation.TableColumn;

public class ProVal {
	/**
	 * 收益法
	 */
	public static List<String> syf=new ArrayList<>(Arrays.asList("0","1","2"));
	/**
	 * 序列年期
	 */
	public static Short incomeStep_1=1;
	/**
	 * 收益额
	 */
	public static Short incomeStep_2=2;
	/**
	 * 分成率
	 */
	public static Short incomeStep_3=3;
	/**
	 * 折现率
	 */
	public static Short incomeStep_4=4;
	
	/**
	 * 模型分组：收益法
	 */
	public static String proGroup_0="0";
	/**
	 * 模型分组：成本法
	 */
	public static String proGroup_1="1";
	/**
	 * 模型分组：市场法
	 */
	public static String proGroup_2="2";
	/**
	 * 方法分类：收入分成法
	 */
	public static String category_0="0";
	/**
	 * 方法分类：净利润分成法
	 */
	public static String category_1="1";
	/**
	 * 方法分类：超额收益法
	 */
	public static String category_2="2";
	/**
	 * 方法分类：成本重置模型
	 */
	public static String category_3="3";
	/**
	 * 方法分类：复杂系数模型
	 */
	public static String category_4="4";
	
	
	
	
	
    /**
     * 主键id，自增长
     */
    @TableColumn(name="id")
    public Long id;

    /**
     * 模型分组：0--收益法；1--成本法；2--市场法
     */
    @TableColumn(name="pro_group")
    public String proGroup;

    /**
     * 方法分类：0--收入分成法；1--净利润分成法；2--超额收益法；3--成本重置模型；4--复杂系数模型
     */
    @TableColumn(name="category")
    public String category;

    /**
     * 估值
     */
    @TableColumn(name="value")
    public BigDecimal value;

    /**
     * 是否完成
     */
    @TableColumn(name="is_complete")
    public Boolean isComplete;

    /**
     * 创建时间
     */
    @TableColumn(name="create_date")
    public Date createDate;

    @TableColumn(name="pro_code")
    public String proCode;

    @TableColumn(name="json_cost")
    public String jsonCost;

    @TableColumn(name="json_market")
    public String jsonMarket;

    /**
     * 序列年期json串
     */
    @TableColumn(name="json_series_year")
    public String jsonSeriesYear;

    /**
     * 分成率json串
     */
    @TableColumn(name="json_share_rate")
    public String jsonShareRate;

    /**
     * 折现率json串
     */
    @TableColumn(name="json_discount_rate")
    public String jsonDiscountRate;

    @TableColumn(name="income_step")
    public Short incomeStep;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProGroup() {
        return proGroup;
    }

    public void setProGroup(String proGroup) {
        this.proGroup = proGroup == null ? null : proGroup.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Boolean getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(Boolean isComplete) {
        this.isComplete = isComplete;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getProCode() {
        return proCode;
    }

    public void setProCode(String proCode) {
        this.proCode = proCode == null ? null : proCode.trim();
    }

    public String getJsonCost() {
        return jsonCost;
    }

    public void setJsonCost(String jsonCost) {
        this.jsonCost = jsonCost == null ? null : jsonCost.trim();
    }

    public String getJsonMarket() {
        return jsonMarket;
    }

    public void setJsonMarket(String jsonMarket) {
        this.jsonMarket = jsonMarket == null ? null : jsonMarket.trim();
    }

    public String getJsonSeriesYear() {
        return jsonSeriesYear;
    }

    public void setJsonSeriesYear(String jsonSeriesYear) {
        this.jsonSeriesYear = jsonSeriesYear == null ? null : jsonSeriesYear.trim();
    }

    public String getJsonShareRate() {
        return jsonShareRate;
    }

    public void setJsonShareRate(String jsonShareRate) {
        this.jsonShareRate = jsonShareRate == null ? null : jsonShareRate.trim();
    }

    public String getJsonDiscountRate() {
        return jsonDiscountRate;
    }

    public void setJsonDiscountRate(String jsonDiscountRate) {
        this.jsonDiscountRate = jsonDiscountRate == null ? null : jsonDiscountRate.trim();
    }

    public Short getIncomeStep() {
        return incomeStep;
    }

    public void setIncomeStep(Short incomeStep) {
        this.incomeStep = incomeStep;
    }
}