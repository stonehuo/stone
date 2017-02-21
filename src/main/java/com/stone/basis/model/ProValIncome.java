package com.kpap.basis.model;

import java.math.BigDecimal;
import java.util.Date;

import com.kpap.common.annotation.TableColumn;

public class ProValIncome {
    @TableColumn(name="id")
    public Long id;

    /**
     * 第几年:0--当年；1--第一年；依次类催
     */
    @TableColumn(name="next_year")
    public Integer nextYear;

    /**
     * 第几年描述
     */
    @TableColumn(name="nex_year_desc")
    public String nexYearDesc;

    /**
     * 收益额
     */
    @TableColumn(name="income")
    public BigDecimal income;

    /**
     * 调整后收益额
     */
    @TableColumn(name="income_cal")
    public BigDecimal incomeCal;

    /**
     * 所得税率
     */
    @TableColumn(name="tax_rate")
    public BigDecimal taxRate;

    /**
     * 所得税
     */
    @TableColumn(name="tax")
    public BigDecimal tax;

    /**
     * 分成率
     */
    @TableColumn(name="share_rate")
    public BigDecimal shareRate;

    /**
     * 分成率递减率
     */
    @TableColumn(name="share_decline_rate")
    public BigDecimal shareDeclineRate;

    /**
     * 调整后分成率
     */
    @TableColumn(name="share_rate_cal")
    public BigDecimal shareRateCal;

    /**
     * 折现率
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
     * 现值
     */
    @TableColumn(name="value")
    public BigDecimal value;

    /**
     * 创建时间
     */
    @TableColumn(name="create_date")
    public Date createDate;

    @TableColumn(name="modify_date")
    public Date modifyDate;

    @TableColumn(name="pro_val_id")
    public Long proValId;

    @TableColumn(name="pro_code")
    public String proCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNextYear() {
        return nextYear;
    }

    public void setNextYear(Integer nextYear) {
        this.nextYear = nextYear;
    }

    public String getNexYearDesc() {
        return nexYearDesc;
    }

    public void setNexYearDesc(String nexYearDesc) {
        this.nexYearDesc = nexYearDesc == null ? null : nexYearDesc.trim();
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public BigDecimal getIncomeCal() {
        return incomeCal;
    }

    public void setIncomeCal(BigDecimal incomeCal) {
        this.incomeCal = incomeCal;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getShareRate() {
        return shareRate;
    }

    public void setShareRate(BigDecimal shareRate) {
        this.shareRate = shareRate;
    }

    public BigDecimal getShareDeclineRate() {
        return shareDeclineRate;
    }

    public void setShareDeclineRate(BigDecimal shareDeclineRate) {
        this.shareDeclineRate = shareDeclineRate;
    }

    public BigDecimal getShareRateCal() {
        return shareRateCal;
    }

    public void setShareRateCal(BigDecimal shareRateCal) {
        this.shareRateCal = shareRateCal;
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

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Long getProValId() {
        return proValId;
    }

    public void setProValId(Long proValId) {
        this.proValId = proValId;
    }

    public String getProCode() {
        return proCode;
    }

    public void setProCode(String proCode) {
        this.proCode = proCode == null ? null : proCode.trim();
    }
}