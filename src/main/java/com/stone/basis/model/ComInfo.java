package com.kpap.basis.model;

import com.kpap.common.annotation.TableColumn;

public class ComInfo {
    /**
     * 项目编码
     */
    @TableColumn(name="pro_code")
    public String proCode;

    /**
     * 企业资产负债表json（QY4）
     */
    @TableColumn(name="json_balance")
    public String jsonBalance;

    /**
     * 企业利润表（QY5 B~G）
     */
    @TableColumn(name="json_ profit")
    public String jsonProfit;

    /**
     * 企业财务比率指标（QY6  B~G）
     */
    @TableColumn(name="json_ratios")
    public String jsonRatios;

    /**
     * 企业近5年营业收入平均增长率（QY6  25行  I~M）
     */
    @TableColumn(name="json_ratios_growth_ave")
    public String jsonRatiosGrowthAve;

    public String getProCode() {
        return proCode;
    }

    public void setProCode(String proCode) {
        this.proCode = proCode == null ? null : proCode.trim();
    }

    public String getJsonBalance() {
        return jsonBalance;
    }

    public void setJsonBalance(String jsonBalance) {
        this.jsonBalance = jsonBalance == null ? null : jsonBalance.trim();
    }

    public String getJsonProfit() {
        return jsonProfit;
    }

    public void setJsonProfit(String jsonProfit) {
        this.jsonProfit = jsonProfit == null ? null : jsonProfit.trim();
    }

    public String getJsonRatios() {
        return jsonRatios;
    }

    public void setJsonRatios(String jsonRatios) {
        this.jsonRatios = jsonRatios == null ? null : jsonRatios.trim();
    }

    public String getJsonRatiosGrowthAve() {
        return jsonRatiosGrowthAve;
    }

    public void setJsonRatiosGrowthAve(String jsonRatiosGrowthAve) {
        this.jsonRatiosGrowthAve = jsonRatiosGrowthAve == null ? null : jsonRatiosGrowthAve.trim();
    }
}