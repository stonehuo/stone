
package com.kpap.client.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * 专利信息<BR>
 *
 * @auther shenhaiwen
 * @date 2016-12-18 下午01:49:54
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "patentIndexInfo", propOrder = {
    "ad",
    "an",
    "cigc",
    "cipc",
    "clt",
    "dcln",
    "desPage",
    "drawPage",
    "fajp",
    "faot",
    "faus",
    "icln",
    "inco",
    "ipcsc",
    "patt",
    "pcc",
    "pdt",
    "plic",
    "pn",
    "ppc",
    "rmn",
    "sfcl",
    "sic",
    "tcc",
    "ti"
})
public class PatentIndexInfo {

    protected String ad; //专利申请号
    protected String an; //专利申请日, 格式为年月日，8位数字结构
    protected int cigc; //被引证次数
    protected int cipc; //引证次数
    protected String clt; //独立权利要求种类,01产品，02方法，03方法+产品
    protected int dcln; //从属权利要求数
    protected int desPage; //说明书页数
    protected int drawPage; //附图页数
    protected int fajp; //日韩同族
    protected int faot; //其他国家同族
    protected int faus; //欧美同族
    protected int icln; //独立权利要求数
    protected int inco; //专利技术人员投入数量
    protected int ipcsc; //分类号（小类）数量
    protected String patt; //专利类型,FM表示发明公开，SQ表示授权，XX表示实用新型，外观专利不在指标评估范围之内
    protected int pcc; //专利许可次数
    protected String pdt; //专利类型及当前权利状态,00表示失效， 01表示有效
    protected int plic; //专利诉讼次数
    protected String pn; //专利公开号
    protected int ppc; //专利质押保全次数
    protected int rmn; //剩余有效期,单位为:天
    protected int sfcl; //专利同族覆盖国家数
    protected String sic; //专利分类号
    protected int tcc; //专利转让次数
    protected String ti; //专利名称

    /**
     * Gets the value of the ad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAd() {
        return ad;
    }

    /**
     * Sets the value of the ad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAd(String value) {
        this.ad = value;
    }

    /**
     * Gets the value of the an property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAn() {
        return an;
    }

    /**
     * Sets the value of the an property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAn(String value) {
        this.an = value;
    }

    /**
     * Gets the value of the cigc property.
     * 
     */
    public int getCigc() {
        return cigc;
    }

    /**
     * Sets the value of the cigc property.
     * 
     */
    public void setCigc(int value) {
        this.cigc = value;
    }

    /**
     * Gets the value of the cipc property.
     * 
     */
    public int getCipc() {
        return cipc;
    }

    /**
     * Sets the value of the cipc property.
     * 
     */
    public void setCipc(int value) {
        this.cipc = value;
    }

    /**
     * Gets the value of the clt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClt() {
        return clt;
    }

    /**
     * Sets the value of the clt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClt(String value) {
        this.clt = value;
    }

    /**
     * Gets the value of the dcln property.
     * 
     */
    public int getDcln() {
        return dcln;
    }

    /**
     * Sets the value of the dcln property.
     * 
     */
    public void setDcln(int value) {
        this.dcln = value;
    }

    /**
     * Gets the value of the desPage property.
     * 
     */
    public int getDesPage() {
        return desPage;
    }

    /**
     * Sets the value of the desPage property.
     * 
     */
    public void setDesPage(int value) {
        this.desPage = value;
    }

    /**
     * Gets the value of the drawPage property.
     * 
     */
    public int getDrawPage() {
        return drawPage;
    }

    /**
     * Sets the value of the drawPage property.
     * 
     */
    public void setDrawPage(int value) {
        this.drawPage = value;
    }

    /**
     * Gets the value of the fajp property.
     * 
     */
    public int getFajp() {
        return fajp;
    }

    /**
     * Sets the value of the fajp property.
     * 
     */
    public void setFajp(int value) {
        this.fajp = value;
    }

    /**
     * Gets the value of the faot property.
     * 
     */
    public int getFaot() {
        return faot;
    }

    /**
     * Sets the value of the faot property.
     * 
     */
    public void setFaot(int value) {
        this.faot = value;
    }

    /**
     * Gets the value of the faus property.
     * 
     */
    public int getFaus() {
        return faus;
    }

    /**
     * Sets the value of the faus property.
     * 
     */
    public void setFaus(int value) {
        this.faus = value;
    }

    /**
     * Gets the value of the icln property.
     * 
     */
    public int getIcln() {
        return icln;
    }

    /**
     * Sets the value of the icln property.
     * 
     */
    public void setIcln(int value) {
        this.icln = value;
    }

    /**
     * Gets the value of the inco property.
     * 
     */
    public int getInco() {
        return inco;
    }

    /**
     * Sets the value of the inco property.
     * 
     */
    public void setInco(int value) {
        this.inco = value;
    }

    /**
     * Gets the value of the ipcsc property.
     * 
     */
    public int getIpcsc() {
        return ipcsc;
    }

    /**
     * Sets the value of the ipcsc property.
     * 
     */
    public void setIpcsc(int value) {
        this.ipcsc = value;
    }

    /**
     * Gets the value of the patt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatt() {
        return patt;
    }

    /**
     * Sets the value of the patt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatt(String value) {
        this.patt = value;
    }

    /**
     * Gets the value of the pcc property.
     * 
     */
    public int getPcc() {
        return pcc;
    }

    /**
     * Sets the value of the pcc property.
     * 
     */
    public void setPcc(int value) {
        this.pcc = value;
    }

    /**
     * Gets the value of the pdt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPdt() {
        return pdt;
    }

    /**
     * Sets the value of the pdt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPdt(String value) {
        this.pdt = value;
    }

    /**
     * Gets the value of the plic property.
     * 
     */
    public int getPlic() {
        return plic;
    }

    /**
     * Sets the value of the plic property.
     * 
     */
    public void setPlic(int value) {
        this.plic = value;
    }

    /**
     * Gets the value of the pn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPn() {
        return pn;
    }

    /**
     * Sets the value of the pn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPn(String value) {
        this.pn = value;
    }

    /**
     * Gets the value of the ppc property.
     * 
     */
    public int getPpc() {
        return ppc;
    }

    /**
     * Sets the value of the ppc property.
     * 
     */
    public void setPpc(int value) {
        this.ppc = value;
    }

    /**
     * Gets the value of the rmn property.
     * 
     */
    public int getRmn() {
        return rmn;
    }

    /**
     * Sets the value of the rmn property.
     * 
     */
    public void setRmn(int value) {
        this.rmn = value;
    }

    /**
     * Gets the value of the sfcl property.
     * 
     */
    public int getSfcl() {
        return sfcl;
    }

    /**
     * Sets the value of the sfcl property.
     * 
     */
    public void setSfcl(int value) {
        this.sfcl = value;
    }

    /**
     * Gets the value of the sic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSic() {
        return sic;
    }

    /**
     * Sets the value of the sic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSic(String value) {
        this.sic = value;
    }

    /**
     * Gets the value of the tcc property.
     * 
     */
    public int getTcc() {
        return tcc;
    }

    /**
     * Sets the value of the tcc property.
     * 
     */
    public void setTcc(int value) {
        this.tcc = value;
    }

    /**
     * Gets the value of the ti property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTi() {
        return ti;
    }

    /**
     * Sets the value of the ti property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTi(String value) {
        this.ti = value;
    }

}
