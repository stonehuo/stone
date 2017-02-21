package com.kpap.basis.model;

import com.kpap.common.annotation.TableColumn;

public class ComProduct {
    /**
     *  主键id
     */
    @TableColumn(name="id")
    public Long id;

    /**
     * 项目编码
     */
    @TableColumn(name="pro_code")
    public String proCode;

    /**
     * 产品名称
     */
    @TableColumn(name="name")
    public String name;

    /**
     * 产品详细信息
     */
    @TableColumn(name="json_info")
    public String jsonInfo;

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

    public String getJsonInfo() {
        return jsonInfo;
    }

    public void setJsonInfo(String jsonInfo) {
        this.jsonInfo = jsonInfo == null ? null : jsonInfo.trim();
    }
}