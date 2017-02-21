package com.kpap.basis.model;

import java.math.BigDecimal;

import com.kpap.common.annotation.TableColumn;

public class IqRatios {
    @TableColumn(name="pro_code")
    public String proCode;

    /**
     * iq12(当年)
     */
    @TableColumn(name="h37")
    public BigDecimal h37;

    /**
     * iq12(前一年)
     */
    @TableColumn(name="g37")
    public BigDecimal g37;

    /**
     * iq12(前二年平均)
     */
    @TableColumn(name="l37")
    public BigDecimal l37;

    /**
     * iq12(前三年平均)
     */
    @TableColumn(name="m37")
    public BigDecimal m37;

    /**
     * iq12(当年)
     */
    @TableColumn(name="h53")
    public BigDecimal h53;

    /**
     * iq12(前一年)
     */
    @TableColumn(name="g53")
    public BigDecimal g53;

    /**
     * iq12(前二年平均)
     */
    @TableColumn(name="l53")
    public BigDecimal l53;

    /**
     * iq12(前三年平均)
     */
    @TableColumn(name="m53")
    public BigDecimal m53;

    /**
     * IQ16,K-O
     */
    @TableColumn(name="json_ave_collect")
    public String jsonAveCollect;

    public String getProCode() {
        return proCode;
    }

    public void setProCode(String proCode) {
        this.proCode = proCode == null ? null : proCode.trim();
    }

    public BigDecimal getH37() {
        return h37;
    }

    public void setH37(BigDecimal h37) {
        this.h37 = h37;
    }

    public BigDecimal getG37() {
        return g37;
    }

    public void setG37(BigDecimal g37) {
        this.g37 = g37;
    }

    public BigDecimal getL37() {
        return l37;
    }

    public void setL37(BigDecimal l37) {
        this.l37 = l37;
    }

    public BigDecimal getM37() {
        return m37;
    }

    public void setM37(BigDecimal m37) {
        this.m37 = m37;
    }

    public BigDecimal getH53() {
        return h53;
    }

    public void setH53(BigDecimal h53) {
        this.h53 = h53;
    }

    public BigDecimal getG53() {
        return g53;
    }

    public void setG53(BigDecimal g53) {
        this.g53 = g53;
    }

    public BigDecimal getL53() {
        return l53;
    }

    public void setL53(BigDecimal l53) {
        this.l53 = l53;
    }

    public BigDecimal getM53() {
        return m53;
    }

    public void setM53(BigDecimal m53) {
        this.m53 = m53;
    }

    public String getJsonAveCollect() {
        return jsonAveCollect;
    }

    public void setJsonAveCollect(String jsonAveCollect) {
        this.jsonAveCollect = jsonAveCollect == null ? null : jsonAveCollect.trim();
    }
}