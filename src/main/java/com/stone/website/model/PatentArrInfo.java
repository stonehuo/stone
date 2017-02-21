package com.kpap.website.model;

/**
 * 专利属性数组统计
 * 
 * @author haiwenshen
 *
 */
public class PatentArrInfo {
	
	private String company; // 公司名称
	
	private int[] icln; // '独立权利要求数 ';

	private int[] cigc; // '被引证次数 ';

	private int[] dcln; // '从属权利要求数 ';

	private int[] ipcsc; // '分类号（小类）数量 ';

	private int[] rmn; // '剩余有效期,单位为:天 ';

	private int[] cipc; // '引证次数 ';

	private int[] inco; // '专利技术人员投入数量 ';

	private int[] plic; // '专利诉讼次数 ';

	private int[] pcc; // '专利许可次数 ';

	private int[] ppc; // ' 专利质押保全次数 ';

	private int[] tcc; // '专利转让次数 ';

	private int[] desPage; // '说明书页数 ';

	private int[] drawPage; // '附图页数 ';

	private int[] sfcl; // '专利同族覆盖国家数 ';

	private int[] fajp; // '日韩同族 ';

	private int[] faus; // ' 欧美同族 ';

	private int[] faot; // '其他国家同族 ';
	
	private int clt_a; // '独立权利要求种类--产品';

	private int clt_b; // '独立权利要求种类 --方法';

	private int clt_c; // '独立权利要求种类 --方法+产品';

	private int patt_b; // '专利类型--实用新型';
	
	private int patt_a; // '专利类型--发明';
	
	private int countIqFm=0;//发明公开专利数量
	private int countIqSq=0;//发明授权专利数量
	private int countIqXx=0;//实用新型专利数量
	private int countIqWg=0;//外观设计专利数量
	
	
	public int getCountIqFm() {
		return countIqFm;
	}

	public void setCountIqFm(int countIqFm) {
		this.countIqFm = countIqFm;
	}

	public int getCountIqSq() {
		return countIqSq;
	}

	public void setCountIqSq(int countIqSq) {
		this.countIqSq = countIqSq;
	}

	public int getCountIqXx() {
		return countIqXx;
	}

	public void setCountIqXx(int countIqXx) {
		this.countIqXx = countIqXx;
	}

	public int getCountIqWg() {
		return countIqWg;
	}

	public void setCountIqWg(int countIqWg) {
		this.countIqWg = countIqWg;
	}

	public int getClt_a() {
		return clt_a;
	}

	public void setClt_a(int clt_a) {
		this.clt_a = clt_a;
	}

	public int getClt_b() {
		return clt_b;
	}

	public void setClt_b(int clt_b) {
		this.clt_b = clt_b;
	}

	public int getClt_c() {
		return clt_c;
	}

	public void setClt_c(int clt_c) {
		this.clt_c = clt_c;
	}

	public int getPatt_b() {
		return patt_b;
	}

	public void setPatt_b(int patt_b) {
		this.patt_b = patt_b;
	}

	public int getPatt_a() {
		return patt_a;
	}

	public void setPatt_a(int patt_a) {
		this.patt_a = patt_a;
	}

	public int[] getIcln() {
		return icln;
	}

	public void setIcln(int[] icln) {
		this.icln = icln;
	}

	public int[] getCigc() {
		return cigc;
	}

	public void setCigc(int[] cigc) {
		this.cigc = cigc;
	}

	public int[] getDcln() {
		return dcln;
	}

	public void setDcln(int[] dcln) {
		this.dcln = dcln;
	}

	public int[] getIpcsc() {
		return ipcsc;
	}

	public void setIpcsc(int[] ipcsc) {
		this.ipcsc = ipcsc;
	}

	public int[] getRmn() {
		return rmn;
	}

	public void setRmn(int[] rmn) {
		this.rmn = rmn;
	}

	public int[] getCipc() {
		return cipc;
	}

	public void setCipc(int[] cipc) {
		this.cipc = cipc;
	}

	public int[] getInco() {
		return inco;
	}

	public void setInco(int[] inco) {
		this.inco = inco;
	}

	public int[] getPlic() {
		return plic;
	}

	public void setPlic(int[] plic) {
		this.plic = plic;
	}

	public int[] getPcc() {
		return pcc;
	}

	public void setPcc(int[] pcc) {
		this.pcc = pcc;
	}

	public int[] getPpc() {
		return ppc;
	}

	public void setPpc(int[] ppc) {
		this.ppc = ppc;
	}

	public int[] getTcc() {
		return tcc;
	}

	public void setTcc(int[] tcc) {
		this.tcc = tcc;
	}

	public int[] getDesPage() {
		return desPage;
	}

	public void setDesPage(int[] desPage) {
		this.desPage = desPage;
	}

	public int[] getDrawPage() {
		return drawPage;
	}

	public void setDrawPage(int[] drawPage) {
		this.drawPage = drawPage;
	}

	public int[] getSfcl() {
		return sfcl;
	}

	public void setSfcl(int[] sfcl) {
		this.sfcl = sfcl;
	}

	public int[] getFajp() {
		return fajp;
	}

	public void setFajp(int[] fajp) {
		this.fajp = fajp;
	}

	public int[] getFaus() {
		return faus;
	}

	public void setFaus(int[] faus) {
		this.faus = faus;
	}

	public int[] getFaot() {
		return faot;
	}

	public void setFaot(int[] faot) {
		this.faot = faot;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}
