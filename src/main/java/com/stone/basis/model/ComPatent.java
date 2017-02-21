package com.kpap.basis.model;

import com.kpap.common.annotation.TableColumn;

public class ComPatent {
    @TableColumn(name="id")
    public Long id;

    /**
     * 公司id
     */
    @TableColumn(name="pro_code")
    public String pro_code;

    /**
     * 专利评分
     */
    @TableColumn(name="score")
    public Double score;

    /**
     * 专利权重
     */
    @TableColumn(name="weight")
    public Double weight;

    /**
     * 专利申请号 
     */
    @TableColumn(name="an")
    public String an;

    /**
     * 专利公开号
     */
    @TableColumn(name="pn")
    public String pn;

    /**
     * 专利类型:FM-发明公开;SQ-授权;XX-实用新型
     */
    @TableColumn(name="patt")
    public String patt;

    /**
     * 专利名称
     */
    @TableColumn(name="ti")
    public String ti;

    /**
     * 专利分类号 
     */
    @TableColumn(name="sic")
    public String sic;

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
     * 独立权利要求种类： 01产品，02方法，03方法+产品 
     */
    @TableColumn(name="clt")
    public String clt;

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
     * 专利类型及当前权利状态 
     */
    @TableColumn(name="pdt")
    public String pdt;

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
     * 专利申请日，格式为年月日，8位数字结构 
     */
    @TableColumn(name="ad")
    public String ad;

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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getAn() {
        return an;
    }

    public void setAn(String an) {
        this.an = an == null ? null : an.trim();
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn == null ? null : pn.trim();
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

    public String getSic() {
        return sic;
    }

    public void setSic(String sic) {
        this.sic = sic == null ? null : sic.trim();
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

    public String getClt() {
        return clt;
    }

    public void setClt(String clt) {
        this.clt = clt == null ? null : clt.trim();
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

    public String getPdt() {
        return pdt;
    }

    public void setPdt(String pdt) {
        this.pdt = pdt == null ? null : pdt.trim();
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

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad == null ? null : ad.trim();
    }
}