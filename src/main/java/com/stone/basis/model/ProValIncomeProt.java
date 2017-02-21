package com.kpap.basis.model;

import java.util.Date;

import com.kpap.common.annotation.TableColumn;

public class ProValIncomeProt {
    /**
     * 主键id，自增长
     */
    @TableColumn(name="id")
    public Long id;

    /**
     * 产品名称
     */
    @TableColumn(name="name")
    public String name;

    /**
     * 操作json串
     */
    @TableColumn(name="json")
    public String json;

    /**
     * 创建时间
     */
    @TableColumn(name="result_json")
    public String resultJson;

    @TableColumn(name="pro_code")
    public String proCode;

    @TableColumn(name="is_complete")
    public Boolean isComplete;

    @TableColumn(name="pro_val_id")
    public Long proValId;

    /**
     * 创建时间
     */
    @TableColumn(name="create_date")
    public Date createDate;

    @TableColumn(name="modify_date")
    public Date modifyDate;

    @TableColumn(name="product_id")
    public Long productId;

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

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json == null ? null : json.trim();
    }

    public String getResultJson() {
        return resultJson;
    }

    public void setResultJson(String resultJson) {
        this.resultJson = resultJson == null ? null : resultJson.trim();
    }

    public String getProCode() {
        return proCode;
    }

    public void setProCode(String proCode) {
        this.proCode = proCode == null ? null : proCode.trim();
    }

    public Boolean getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(Boolean isComplete) {
        this.isComplete = isComplete;
    }

    public Long getProValId() {
        return proValId;
    }

    public void setProValId(Long proValId) {
        this.proValId = proValId;
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}