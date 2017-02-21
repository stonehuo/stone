package com.kpap.basis.model;

import java.math.BigDecimal;
import java.util.Date;

import com.kpap.common.annotation.TableColumn;

public class Pro {
	/**
	 * 状态:未上传
	 */
    public static String status_0="0";
	/**
	 * 状态:未提交
	 */
    public static String status_1="1";
	/**
	 * 状态:提交估值
	 */
    public static String status_2="2";
	/**
	 * 状态:待审核
	 */
    public static String status_3="3";
	/**
	 * 状态:审核通过
	 */
    public static String status_4="4";
	/**
	 * 状态:审核不通过
	 */
    public static String status_5="5";
	/**
	 * 状态:已删除
	 */
    public static String status_6="6";
	/**
	 * 项目类型：0--评估
	 */
	public static String type_0="0";
	/**
	 * 项目类型：1--评价
	 */
	public static String type_1="1";
	
	/**
	 * 是否完成专利评分:0--未获取接口数据；
	 */
	public static String isPatent_0="0";
	/**
	 * 是否完成专利评分:1--以获取接口数据
	 */
	public static String isPatent_1="1";
	/**
	 * 是否完成专利评分:2--计算完成
	 */
	public static String isPatent_2="2";
    /**
     * 项目编码
     */
    @TableColumn(name="pro_code")
    public String proCode;

    /**
     * 项目类型：0--评估；1--评价
     */
    @TableColumn(name="type")
    public String type;

    /**
     * 项目名称
     */
    @TableColumn(name="name")
    public String name;

    /**
     * 评估基准日
     */
    @TableColumn(name="base_date")
    public Date baseDate;

    /**
     * 是否完成专利评分:0--未获取接口数据；1--以获取接口数据；2--计算完成
     */
    @TableColumn(name="is_patent")
    public String isPatent;

    /**
     * 估值id
     */
    @TableColumn(name="pro_val_id")
    public Long proValId;

    /**
     * 实际估值
     */
    @TableColumn(name="actual_val")
    public String actualVal;

    /**
     * 报告存储路径
     */
    @TableColumn(name="report_url")
    public String reportUrl;

    /**
     * 源数据excel存储路径
     */
    @TableColumn(name="data_source_url")
    public String dataSourceUrl;

    /**
     * 状态:0--未上传；1--未提交；2--未提交审核；3--待审核；4--审核通过；5--审核不通过；6--已删除
     */
    @TableColumn(name="status")
    public String status;

    /**
     * 操作员
     */
    @TableColumn(name="creator")
    public String creator;

    /**
     *  创建时间
     */
    @TableColumn(name="create_date")
    public Date createDate;

    /**
     * 审核员
     */
    @TableColumn(name="auditor")
    public String auditor;

    /**
     * 永续年增长率
     */
    @TableColumn(name="sagr")
    public BigDecimal sagr;

    /**
     * DCF值，人工录入
     */
    @TableColumn(name="dcf")
    public BigDecimal dcf;

    /**
     * excel报表存储路径
     */
    @TableColumn(name="excel_url")
    public String excelUrl;

    @TableColumn(name="cal_val")
    public BigDecimal calVal;

    public String getProCode() {
        return proCode;
    }

    public void setProCode(String proCode) {
        this.proCode = proCode == null ? null : proCode.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getBaseDate() {
        return baseDate;
    }

    public void setBaseDate(Date baseDate) {
        this.baseDate = baseDate;
    }

    public String getIsPatent() {
        return isPatent;
    }

    public void setIsPatent(String isPatent) {
        this.isPatent = isPatent == null ? null : isPatent.trim();
    }

    public Long getProValId() {
        return proValId;
    }

    public void setProValId(Long proValId) {
        this.proValId = proValId;
    }

    public String getActualVal() {
        return actualVal;
    }

    public void setActualVal(String actualVal) {
        this.actualVal = actualVal == null ? null : actualVal.trim();
    }

    public String getReportUrl() {
        return reportUrl;
    }

    public void setReportUrl(String reportUrl) {
        this.reportUrl = reportUrl == null ? null : reportUrl.trim();
    }

    public String getDataSourceUrl() {
        return dataSourceUrl;
    }

    public void setDataSourceUrl(String dataSourceUrl) {
        this.dataSourceUrl = dataSourceUrl == null ? null : dataSourceUrl.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
    }

    public BigDecimal getSagr() {
        return sagr;
    }

    public void setSagr(BigDecimal sagr) {
        this.sagr = sagr;
    }

    public BigDecimal getDcf() {
        return dcf;
    }

    public void setDcf(BigDecimal dcf) {
        this.dcf = dcf;
    }

    public String getExcelUrl() {
        return excelUrl;
    }

    public void setExcelUrl(String excelUrl) {
        this.excelUrl = excelUrl == null ? null : excelUrl.trim();
    }

    public BigDecimal getCalVal() {
        return calVal;
    }

    public void setCalVal(BigDecimal calVal) {
        this.calVal = calVal;
    }
}