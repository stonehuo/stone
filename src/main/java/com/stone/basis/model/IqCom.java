package com.kpap.basis.model;

import java.util.Date;

import com.kpap.common.annotation.TableColumn;

/**
 * 可比公司基本信息
 * 
 * @author haiwenshen
 *
 */
public class IqCom {
    @TableColumn(name="id")
    public Long id;

    @TableColumn(name="pro_code")
    public String proCode;

    /**
     * 公司名称
     */
    @TableColumn(name="name")
    public String name;

    /**
     * 证券代码
     */
    @TableColumn(name="exchange_ticker")
    public String exchangeTicker;

    /**
     * 上市地点
     */
    @TableColumn(name="ipo_address")
    public String ipoAddress;

    /**
     * 备注
     */
    @TableColumn(name="remark")
    public String remark;

    /**
     * 创建时间
     */
    @TableColumn(name="create_date")
    public Date createDate;

    /**
     * 可比公司子公司名称列表
     */
    @TableColumn(name="json_com_sub")
    public String jsonComSub;

    @TableColumn(name="ipo_time")
    public Date ipoTime;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getExchangeTicker() {
        return exchangeTicker;
    }

    public void setExchangeTicker(String exchangeTicker) {
        this.exchangeTicker = exchangeTicker == null ? null : exchangeTicker.trim();
    }

    public String getIpoAddress() {
        return ipoAddress;
    }

    public void setIpoAddress(String ipoAddress) {
        this.ipoAddress = ipoAddress == null ? null : ipoAddress.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public Date getIpoTime() {
        return ipoTime;
    }

    public void setIpoTime(Date ipoTime) {
        this.ipoTime = ipoTime;
    }
}