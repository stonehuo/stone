package com.kpap.basis.model;

import java.util.Date;

import com.kpap.common.annotation.TableColumn;

public class ProReivew {
	/**
	 * 0--提交审核
	 */
	public static String dealType_0="0";
	/**
	 * 1--审核
	 */
	public static String dealType_1="1";
    /**
     * 主键id，自增长
     */
    @TableColumn(name="id")
    public Long id;

    /**
     * 项目编码
     */
    @TableColumn(name="pro_code")
    public String proCode;

    /**
     * 审核人
     */
    @TableColumn(name="auditor")
    public String auditor;

    /**
     * 审核结果
     */
    @TableColumn(name="result")
    public Boolean result;

    /**
     * 审核结论
     */
    @TableColumn(name="conclusion")
    public String conclusion;

    /**
     * 创建时间
     */
    @TableColumn(name="create_date")
    public Date createDate;

    /**
     * 0--提交审核；1--审核
     */
    @TableColumn(name="deal_type")
    public String dealType;

    @TableColumn(name="creator")
    public String creator;

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

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion == null ? null : conclusion.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType == null ? null : dealType.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }
}