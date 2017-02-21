package com.kpap.basis.model;

import java.math.BigDecimal;
import java.util.Date;

import com.kpap.common.annotation.TableColumn;

public class ComCase {
    @TableColumn(name="id")
    public Long id;

    /**
     * 案例名称
     */
    @TableColumn(name="name")
    public String name;

    /**
     * 专利类型
     */
    @TableColumn(name="patt")
    public String patt;

    /**
     * 专利名称
     */
    @TableColumn(name="ti")
    public String ti;

    /**
     * 专利号
     */
    @TableColumn(name="pn")
    public String pn;

    /**
     * 专利权人
     */
    @TableColumn(name="patentee")
    public String patentee;

    /**
     * 专利申请日
     */
    @TableColumn(name="ad")
    public Date ad;

    /**
     * 交易市场
     */
    @TableColumn(name="market")
    public String market;

    /**
     * 成交价
     */
    @TableColumn(name="price")
    public BigDecimal price;

    /**
     * 交易时间
     */
    @TableColumn(name="trans_date")
    public Date transDate;

    /**
     * 项目编号
     */
    @TableColumn(name="pro_code")
    public String proCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPatt() {
        return patt;
    }

    public void setPatt(String patt) {
        this.patt = patt == null ? null : patt.trim();
    }

    public String getTi() {
        return ti;
    }

    public void setTi(String ti) {
        this.ti = ti == null ? null : ti.trim();
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn == null ? null : pn.trim();
    }

    public String getPatentee() {
        return patentee;
    }

    public void setPatentee(String patentee) {
        this.patentee = patentee == null ? null : patentee.trim();
    }

    public Date getAd() {
        return ad;
    }

    public void setAd(Date ad) {
        this.ad = ad;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market == null ? null : market.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public String getProCode() {
        return proCode;
    }

    public void setProCode(String proCode) {
        this.proCode = proCode == null ? null : proCode.trim();
    }
}