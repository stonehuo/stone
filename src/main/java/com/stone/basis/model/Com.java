package com.kpap.basis.model;

import java.math.BigDecimal;
import java.util.Date;

import com.kpap.common.annotation.TableColumn;

public class Com {
    /**
     * 主键id
     */
    @TableColumn(name="pro_code")
    public String proCode;

    /**
     * 公司名称
     */
    @TableColumn(name="name")
    public String name;

    /**
     * 注册地址
     */
    @TableColumn(name="address")
    public String address;

    /**
     * 法人代表
     */
    @TableColumn(name="representative ")
    public String representative;

    /**
     * 经营范围
     */
    @TableColumn(name="bus_scope")
    public String busScope;

    /**
     * 成了日期
     */
    @TableColumn(name="setup_date")
    public Date setupDate;

    /**
     * 营业期限
     */
    @TableColumn(name="bus_term")
    public String busTerm;

    /**
     * 所得税率
     */
    @TableColumn(name="tax_rate")
    public BigDecimal taxRate;

    /**
     * 办公电话
     */
    @TableColumn(name="phone")
    public String phone;

    /**
     * 邮箱
     */
    @TableColumn(name="email")
    public String email;

    @TableColumn(name="create_date")
    public Date createDate;

    /**
     * 子公司名称列表
     */
    @TableColumn(name="json_com_sub")
    public String jsonComSub;

    /**
     * 发明公开专利数量
     */
    @TableColumn(name="count_fm")
    public Integer countFm;

    /**
     * 发明授权专利数量
     */
    @TableColumn(name="count_sq")
    public Integer countSq;

    /**
     * 实用新型专利数量
     */
    @TableColumn(name="count_xx")
    public Integer countXx;

    /**
     * 外观设计专利数量
     */
    @TableColumn(name="count_wg")
    public Integer countWg;

    /**
     * 被评估公司的专利评分
     */
    @TableColumn(name="score")
    public BigDecimal score;

    /**
     * 可比公司数量
     */
    @TableColumn(name="count_iq_com")
    public Integer countIqCom;

    /**
     * 可用可比公司数量
     */
    @TableColumn(name="count_iq_com_avail")
    public Integer countIqComAvail;

    /**
     * 发明公开专利数量
     */
    @TableColumn(name="count_iq_fm")
    public Integer countIqFm;

    /**
     * 发明授权专利数量
     */
    @TableColumn(name="count_iq_sq")
    public Integer countIqSq;

    /**
     * 实用新型专利数量
     */
    @TableColumn(name="count_iq_xx")
    public Integer countIqXx;

    /**
     * 外观设计专利数量
     */
    @TableColumn(name="count_iq_wg")
    public Integer countIqWg;

    public String getProCode() {
        return proCode;
    }

    public void setProCode(String proCode) {
        this.proCode = proCode == null ? null : proCode.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative == null ? null : representative.trim();
    }

    public String getBusScope() {
        return busScope;
    }

    public void setBusScope(String busScope) {
        this.busScope = busScope == null ? null : busScope.trim();
    }

    public Date getSetupDate() {
        return setupDate;
    }

    public void setSetupDate(Date setupDate) {
        this.setupDate = setupDate;
    }

    public String getBusTerm() {
        return busTerm;
    }

    public void setBusTerm(String busTerm) {
        this.busTerm = busTerm == null ? null : busTerm.trim();
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getJsonComSub() {
        return jsonComSub;
    }

    public void setJsonComSub(String jsonComSub) {
        this.jsonComSub = jsonComSub == null ? null : jsonComSub.trim();
    }

    public Integer getCountFm() {
        return countFm;
    }

    public void setCountFm(Integer countFm) {
        this.countFm = countFm;
    }

    public Integer getCountSq() {
        return countSq;
    }

    public void setCountSq(Integer countSq) {
        this.countSq = countSq;
    }

    public Integer getCountXx() {
        return countXx;
    }

    public void setCountXx(Integer countXx) {
        this.countXx = countXx;
    }

    public Integer getCountWg() {
        return countWg;
    }

    public void setCountWg(Integer countWg) {
        this.countWg = countWg;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Integer getCountIqCom() {
        return countIqCom;
    }

    public void setCountIqCom(Integer countIqCom) {
        this.countIqCom = countIqCom;
    }

    public Integer getCountIqComAvail() {
        return countIqComAvail;
    }

    public void setCountIqComAvail(Integer countIqComAvail) {
        this.countIqComAvail = countIqComAvail;
    }

    public Integer getCountIqFm() {
        return countIqFm;
    }

    public void setCountIqFm(Integer countIqFm) {
        this.countIqFm = countIqFm;
    }

    public Integer getCountIqSq() {
        return countIqSq;
    }

    public void setCountIqSq(Integer countIqSq) {
        this.countIqSq = countIqSq;
    }

    public Integer getCountIqXx() {
        return countIqXx;
    }

    public void setCountIqXx(Integer countIqXx) {
        this.countIqXx = countIqXx;
    }

    public Integer getCountIqWg() {
        return countIqWg;
    }

    public void setCountIqWg(Integer countIqWg) {
        this.countIqWg = countIqWg;
    }
}