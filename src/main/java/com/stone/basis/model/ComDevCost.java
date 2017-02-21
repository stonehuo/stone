package com.kpap.basis.model;

import java.math.BigDecimal;
import java.util.Date;

import com.kpap.common.annotation.TableColumn;

public class ComDevCost {
    /**
     * 项目编码
     */
    @TableColumn(name="pro_code")
    public String proCode;

    /**
     * 研发起始时间
     */
    @TableColumn(name="start_date")
    public Date startDate;

    /**
     * 研发终止时间
     */
    @TableColumn(name="end_date")
    public Date endDate;

    /**
     *  研发周期
     */
    @TableColumn(name="cycle")
    public BigDecimal cycle;

    /**
     * 研发期实际人工费
     */
    @TableColumn(name="e23")
    public BigDecimal e23;

    /**
     * 人工费-据实调整
     */
    @TableColumn(name="f23")
    public BigDecimal f23;

    /**
     * 研发期材料费
     */
    @TableColumn(name="c25")
    public BigDecimal c25;

    /**
     * 设备原值
     */
    @TableColumn(name="c28")
    public BigDecimal c28;

    /**
     * 设备经济使用年限
     */
    @TableColumn(name="c29")
    public BigDecimal c29;

    /**
     * 研发期其他费用额
     */
    @TableColumn(name="c30")
    public BigDecimal c30;

    /**
     * 研发期其差旅费额
     */
    @TableColumn(name="c31")
    public BigDecimal c31;

    /**
     * 研发期知识产权事务费
     */
    @TableColumn(name="c32")
    public BigDecimal c32;

    /**
     * 研发期场地使用费
     */
    @TableColumn(name="c33")
    public BigDecimal c33;

    /**
     * 研发期水电费
     */
    @TableColumn(name="c34")
    public BigDecimal c34;

    /**
     * 其他费用金额
     */
    @TableColumn(name="c35")
    public BigDecimal c35;

    public String getProCode() {
        return proCode;
    }

    public void setProCode(String proCode) {
        this.proCode = proCode == null ? null : proCode.trim();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getCycle() {
        return cycle;
    }

    public void setCycle(BigDecimal cycle) {
        this.cycle = cycle;
    }

    public BigDecimal getE23() {
        return e23;
    }

    public void setE23(BigDecimal e23) {
        this.e23 = e23;
    }

    public BigDecimal getF23() {
        return f23;
    }

    public void setF23(BigDecimal f23) {
        this.f23 = f23;
    }

    public BigDecimal getC25() {
        return c25;
    }

    public void setC25(BigDecimal c25) {
        this.c25 = c25;
    }

    public BigDecimal getC28() {
        return c28;
    }

    public void setC28(BigDecimal c28) {
        this.c28 = c28;
    }

    public BigDecimal getC29() {
        return c29;
    }

    public void setC29(BigDecimal c29) {
        this.c29 = c29;
    }

    public BigDecimal getC30() {
        return c30;
    }

    public void setC30(BigDecimal c30) {
        this.c30 = c30;
    }

    public BigDecimal getC31() {
        return c31;
    }

    public void setC31(BigDecimal c31) {
        this.c31 = c31;
    }

    public BigDecimal getC32() {
        return c32;
    }

    public void setC32(BigDecimal c32) {
        this.c32 = c32;
    }

    public BigDecimal getC33() {
        return c33;
    }

    public void setC33(BigDecimal c33) {
        this.c33 = c33;
    }

    public BigDecimal getC34() {
        return c34;
    }

    public void setC34(BigDecimal c34) {
        this.c34 = c34;
    }

    public BigDecimal getC35() {
        return c35;
    }

    public void setC35(BigDecimal c35) {
        this.c35 = c35;
    }
}