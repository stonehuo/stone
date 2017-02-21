package com.kpap.basis.model;

import com.kpap.common.annotation.TableColumn;

public class IqInfo {
    @TableColumn(name="pro_code")
    public String proCode;

    /**
     * 可比上市公司近5年的利润表合计数据(IQ6  B~G列)
     */
    @TableColumn(name="json_income")
    public String jsonIncome;

    /**
     * 可比上市公司近5年的利润表平均数(IQ6   J~O)
     */
    @TableColumn(name="json_income_ave")
    public String jsonIncomeAve;

    /**
     * 可比上市公司近5年营业收入增长率(IQ10  16行 C~G)
     */
    @TableColumn(name="json_growth_rate")
    public String jsonGrowthRate;

    /**
     * 可比上市公司近5年营业收入平均增长率(IQ10  16行  J~N)
     */
    @TableColumn(name="json_growth_rate_ave")
    public String jsonGrowthRateAve;

    /**
     * 可比上市公司近5年财务比率指标(IQ12   C~H列)
     */
    @TableColumn(name="json_ratios")
    public String jsonRatios;

    public String getProCode() {
        return proCode;
    }

    public void setProCode(String proCode) {
        this.proCode = proCode == null ? null : proCode.trim();
    }

    public String getJsonIncome() {
        return jsonIncome;
    }

    public void setJsonIncome(String jsonIncome) {
        this.jsonIncome = jsonIncome == null ? null : jsonIncome.trim();
    }

    public String getJsonIncomeAve() {
        return jsonIncomeAve;
    }

    public void setJsonIncomeAve(String jsonIncomeAve) {
        this.jsonIncomeAve = jsonIncomeAve == null ? null : jsonIncomeAve.trim();
    }

    public String getJsonGrowthRate() {
        return jsonGrowthRate;
    }

    public void setJsonGrowthRate(String jsonGrowthRate) {
        this.jsonGrowthRate = jsonGrowthRate == null ? null : jsonGrowthRate.trim();
    }

    public String getJsonGrowthRateAve() {
        return jsonGrowthRateAve;
    }

    public void setJsonGrowthRateAve(String jsonGrowthRateAve) {
        this.jsonGrowthRateAve = jsonGrowthRateAve == null ? null : jsonGrowthRateAve.trim();
    }

    public String getJsonRatios() {
        return jsonRatios;
    }

    public void setJsonRatios(String jsonRatios) {
        this.jsonRatios = jsonRatios == null ? null : jsonRatios.trim();
    }
}