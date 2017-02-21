package com.kpap.basis.model;

import java.math.BigDecimal;
import java.util.Date;

import com.kpap.common.annotation.TableColumn;

public class ProDcf {
    @TableColumn(name="id")
    public Long id;

    @TableColumn(name="pro_code")
    public String proCode;

    /**
     * 年限：1--第一年，2--第二年，3--第三年，4--第四年，5--第五年，N--永续年
     */
    @TableColumn(name="year")
    public String year;

    /**
     * 营业收入
     */
    @TableColumn(name="income")
    public BigDecimal income;

    /**
     * 净利润率
     */
    @TableColumn(name="profit_rate")
    public BigDecimal profitRate;

    /**
     * 净利润
     */
    @TableColumn(name="profit")
    public BigDecimal profit;

    /**
     * 折现率WACC
     */
    @TableColumn(name="discount_rate")
    public BigDecimal discountRate;

    /**
     * 序列年期
     */
    @TableColumn(name="series_year")
    public BigDecimal seriesYear;

    /**
     * 折现系数
     */
    @TableColumn(name="discount_factor")
    public BigDecimal discountFactor;

    /**
     * 折现值
     */
    @TableColumn(name="discount_value")
    public BigDecimal discountValue;

    /**
     * 创建日期
     */
    @TableColumn(name="create_date")
    public Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProCode() {
        return proCode;
    }

    public void setProCode(String proCode) {
        this.proCode = proCode == null ? null : proCode.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public BigDecimal getProfitRate() {
        return profitRate;
    }

    public void setProfitRate(BigDecimal profitRate) {
        this.profitRate = profitRate;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(BigDecimal discountRate) {
        this.discountRate = discountRate;
    }

    public BigDecimal getSeriesYear() {
        return seriesYear;
    }

    public void setSeriesYear(BigDecimal seriesYear) {
        this.seriesYear = seriesYear;
    }

    public BigDecimal getDiscountFactor() {
        return discountFactor;
    }

    public void setDiscountFactor(BigDecimal discountFactor) {
        this.discountFactor = discountFactor;
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(BigDecimal discountValue) {
        this.discountValue = discountValue;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}