package com.kpap.basis.model;

import java.math.BigDecimal;
import java.util.Date;

import com.kpap.common.annotation.TableColumn;

public class ProValCase {
    /**
     * 主键id
     */
    @TableColumn(name="id")
    public Long id;

    /**
     * 案例id
     */
    @TableColumn(name="case_id")
    public Long caseId;

    /**
     *  项目编号
     */
    @TableColumn(name="pro_code")
    public String proCode;

    /**
     * 项目估值编号
     */
    @TableColumn(name="pro_val_id")
    public Long proValId;

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
     * 案例名称
     */
    @TableColumn(name="name")
    public String name;

    /**
     * 交易时间得分
     */
    @TableColumn(name="m1")
    public BigDecimal m1;

    /**
     * 剩余经济寿命得分
     */
    @TableColumn(name="m2")
    public BigDecimal m2;

    /**
     * 技术特性得分
     */
    @TableColumn(name="m3")
    public BigDecimal m3;

    /**
     * 其他因素得分
     */
    @TableColumn(name="m4")
    public BigDecimal m4;

    /**
     * json串
     */
    @TableColumn(name="json")
    public String json;

    /**
     * 是否完成
     */
    @TableColumn(name="is_complete")
    public Boolean isComplete;

    @TableColumn(name="create_date")
    public Date createDate;

    @TableColumn(name="modify_date")
    public Date modifyDate;

    /**
     * 交易时间系数
     */
    @TableColumn(name="m1_ratio")
    public BigDecimal m1Ratio;

    /**
     * 剩余经济寿命系数
     */
    @TableColumn(name="m2_ratio")
    public BigDecimal m2Ratio;

    /**
     * 技术特性系数
     */
    @TableColumn(name="m3_ratio")
    public BigDecimal m3Ratio;

    /**
     * 其他因素系数
     */
    @TableColumn(name="m4_ratio")
    public BigDecimal m4Ratio;

    /**
     *  权重
     */
    @TableColumn(name="weight")
    public BigDecimal weight;

    /**
     * 修正后成交价
     */
    @TableColumn(name="price_cal")
    public BigDecimal priceCal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public String getProCode() {
        return proCode;
    }

    public void setProCode(String proCode) {
        this.proCode = proCode == null ? null : proCode.trim();
    }

    public Long getProValId() {
        return proValId;
    }

    public void setProValId(Long proValId) {
        this.proValId = proValId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getM1() {
        return m1;
    }

    public void setM1(BigDecimal m1) {
        this.m1 = m1;
    }

    public BigDecimal getM2() {
        return m2;
    }

    public void setM2(BigDecimal m2) {
        this.m2 = m2;
    }

    public BigDecimal getM3() {
        return m3;
    }

    public void setM3(BigDecimal m3) {
        this.m3 = m3;
    }

    public BigDecimal getM4() {
        return m4;
    }

    public void setM4(BigDecimal m4) {
        this.m4 = m4;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json == null ? null : json.trim();
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

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public BigDecimal getM1Ratio() {
        return m1Ratio;
    }

    public void setM1Ratio(BigDecimal m1Ratio) {
        this.m1Ratio = m1Ratio;
    }

    public BigDecimal getM2Ratio() {
        return m2Ratio;
    }

    public void setM2Ratio(BigDecimal m2Ratio) {
        this.m2Ratio = m2Ratio;
    }

    public BigDecimal getM3Ratio() {
        return m3Ratio;
    }

    public void setM3Ratio(BigDecimal m3Ratio) {
        this.m3Ratio = m3Ratio;
    }

    public BigDecimal getM4Ratio() {
        return m4Ratio;
    }

    public void setM4Ratio(BigDecimal m4Ratio) {
        this.m4Ratio = m4Ratio;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getPriceCal() {
        return priceCal;
    }

    public void setPriceCal(BigDecimal priceCal) {
        this.priceCal = priceCal;
    }
}