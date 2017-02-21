package com.kpap.basis.model;

import com.kpap.common.annotation.TableColumn;

public class IqComPatentSum {
    @TableColumn(name="id")
    public Long id;

    @TableColumn(name="pro_code")
    public String pro_code;

    /**
     * 汇总类型：0--合计，1--平均数；2--方差；3--标准差
     */
    @TableColumn(name="type")
    public String type;

    /**
     * 独立权利要求数 
     */
    @TableColumn(name="icln")
    public Double icln;

    /**
     * 被引证次数 
     */
    @TableColumn(name="cigc")
    public Double cigc;

    /**
     * 从属权利要求数 
     */
    @TableColumn(name="dcln")
    public Double dcln;

    /**
     * 独立权利要求种类--产品
     */
    @TableColumn(name="clt_a")
    public Double clt_a = (double) 0;

    /**
     * 分类号（小类）数量 
     */
    @TableColumn(name="ipcsc")
    public Double ipcsc;

    /**
     * 剩余有效期,单位为:天 
     */
    @TableColumn(name="rmn")
    public Double rmn;

    /**
     * 引证次数 
     */
    @TableColumn(name="cipc")
    public Double cipc;

    /**
     * 专利技术人员投入数量 
     */
    @TableColumn(name="inco")
    public Double inco;

    /**
     * 专利类型--发明
     */
    @TableColumn(name="patt_a")
    public Double patt_a = (double) 0;

    /**
     * 专利诉讼次数 
     */
    @TableColumn(name="plic")
    public Double plic;

    /**
     * 专利许可次数 
     */
    @TableColumn(name="pcc")
    public Double pcc;

    /**
     *  专利质押保全次数 
     */
    @TableColumn(name="ppc")
    public Double ppc;

    /**
     * 专利转让次数 
     */
    @TableColumn(name="tcc")
    public Double tcc;

    /**
     * 说明书页数 
     */
    @TableColumn(name="despage")
    public Double despage;

    /**
     * 附图页数 
     */
    @TableColumn(name="drawpage")
    public Double drawpage;

    /**
     * 专利同族覆盖国家数 
     */
    @TableColumn(name="sfcl")
    public Double sfcl;

    /**
     * 日韩同族 
     */
    @TableColumn(name="fajp")
    public Double fajp;

    /**
     *  欧美同族 
     */
    @TableColumn(name="faus")
    public Double faus;

    /**
     * 其他国家同族 
     */
    @TableColumn(name="faot")
    public Double faot;

    /**
     * 独立权利要求种类 --方法
     */
    @TableColumn(name="clt_b")
    public Double clt_b = (double) 0;

    /**
     * 独立权利要求种类 --方法+产品
     */
    @TableColumn(name="clt_c")
    public Double clt_c = (double) 0;

    /**
     * 专利类型--实用新型
     */
    @TableColumn(name="patt_b")
    public Double patt_b = (double) 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPro_code() {
        return pro_code;
    }

    public void setPro_code(String pro_code) {
        this.pro_code = pro_code == null ? null : pro_code.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Double getIcln() {
        return icln;
    }

    public void setIcln(Double icln) {
        this.icln = icln;
    }

    public Double getCigc() {
        return cigc;
    }

    public void setCigc(Double cigc) {
        this.cigc = cigc;
    }

    public Double getDcln() {
        return dcln;
    }

    public void setDcln(Double dcln) {
        this.dcln = dcln;
    }

    public Double getClt_a() {
        return clt_a;
    }

    public void setClt_a(Double clt_a) {
        this.clt_a = clt_a;
    }

    public Double getIpcsc() {
        return ipcsc;
    }

    public void setIpcsc(Double ipcsc) {
        this.ipcsc = ipcsc;
    }

    public Double getRmn() {
        return rmn;
    }

    public void setRmn(Double rmn) {
        this.rmn = rmn;
    }

    public Double getCipc() {
        return cipc;
    }

    public void setCipc(Double cipc) {
        this.cipc = cipc;
    }

    public Double getInco() {
        return inco;
    }

    public void setInco(Double inco) {
        this.inco = inco;
    }

    public Double getPatt_a() {
        return patt_a;
    }

    public void setPatt_a(Double patt_a) {
        this.patt_a = patt_a;
    }

    public Double getPlic() {
        return plic;
    }

    public void setPlic(Double plic) {
        this.plic = plic;
    }

    public Double getPcc() {
        return pcc;
    }

    public void setPcc(Double pcc) {
        this.pcc = pcc;
    }

    public Double getPpc() {
        return ppc;
    }

    public void setPpc(Double ppc) {
        this.ppc = ppc;
    }

    public Double getTcc() {
        return tcc;
    }

    public void setTcc(Double tcc) {
        this.tcc = tcc;
    }

    public Double getDespage() {
        return despage;
    }

    public void setDespage(Double despage) {
        this.despage = despage;
    }

    public Double getDrawpage() {
        return drawpage;
    }

    public void setDrawpage(Double drawpage) {
        this.drawpage = drawpage;
    }

    public Double getSfcl() {
        return sfcl;
    }

    public void setSfcl(Double sfcl) {
        this.sfcl = sfcl;
    }

    public Double getFajp() {
        return fajp;
    }

    public void setFajp(Double fajp) {
        this.fajp = fajp;
    }

    public Double getFaus() {
        return faus;
    }

    public void setFaus(Double faus) {
        this.faus = faus;
    }

    public Double getFaot() {
        return faot;
    }

    public void setFaot(Double faot) {
        this.faot = faot;
    }

    public Double getClt_b() {
        return clt_b;
    }

    public void setClt_b(Double clt_b) {
        this.clt_b = clt_b;
    }

    public Double getClt_c() {
        return clt_c;
    }

    public void setClt_c(Double clt_c) {
        this.clt_c = clt_c;
    }

    public Double getPatt_b() {
        return patt_b;
    }

    public void setPatt_b(Double patt_b) {
        this.patt_b = patt_b;
    }
}