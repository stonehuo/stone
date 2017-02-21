package com.kpap.basis.model;

import com.kpap.common.annotation.TableColumn;

public class IqComPatent {
    @TableColumn(name="iq_com_id")
    public Long iqComId;

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
    public Double cltA;

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
    public Double pattA;

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
    public Double cltB;

    /**
     * 独立权利要求种类 --方法+产品
     */
    @TableColumn(name="clt_c")
    public Double cltC;

    /**
     * 专利类型--实用新型
     */
    @TableColumn(name="patt_b")
    public Double pattB;

    @TableColumn(name="pro_code")
    public String proCode;

    /**
     * 可比公司名称
     */
    @TableColumn(name="name")
    public String name;

    public Long getIqComId() {
        return iqComId;
    }

    public void setIqComId(Long iqComId) {
        this.iqComId = iqComId;
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

    public Double getCltA() {
        return cltA;
    }

    public void setCltA(Double cltA) {
        this.cltA = cltA;
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

    public Double getPattA() {
        return pattA;
    }

    public void setPattA(Double pattA) {
        this.pattA = pattA;
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

    public Double getCltB() {
        return cltB;
    }

    public void setCltB(Double cltB) {
        this.cltB = cltB;
    }

    public Double getCltC() {
        return cltC;
    }

    public void setCltC(Double cltC) {
        this.cltC = cltC;
    }

    public Double getPattB() {
        return pattB;
    }

    public void setPattB(Double pattB) {
        this.pattB = pattB;
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
}