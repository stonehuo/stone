package com.kpap.basis.model;

import java.util.ArrayList;
import java.util.List;

public class IqComPatentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public IqComPatentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimitStart(int limitStart) {
        this.limitStart=limitStart;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(int limitEnd) {
        this.limitEnd=limitEnd;
    }

    public int getLimitEnd() {
        return limitEnd;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIqComIdIsNull() {
            addCriterion("iq_com_id is null");
            return (Criteria) this;
        }

        public Criteria andIqComIdIsNotNull() {
            addCriterion("iq_com_id is not null");
            return (Criteria) this;
        }

        public Criteria andIqComIdEqualTo(Long value) {
            addCriterion("iq_com_id =", value, "iqComId");
            return (Criteria) this;
        }

        public Criteria andIqComIdNotEqualTo(Long value) {
            addCriterion("iq_com_id <>", value, "iqComId");
            return (Criteria) this;
        }

        public Criteria andIqComIdGreaterThan(Long value) {
            addCriterion("iq_com_id >", value, "iqComId");
            return (Criteria) this;
        }

        public Criteria andIqComIdGreaterThanOrEqualTo(Long value) {
            addCriterion("iq_com_id >=", value, "iqComId");
            return (Criteria) this;
        }

        public Criteria andIqComIdLessThan(Long value) {
            addCriterion("iq_com_id <", value, "iqComId");
            return (Criteria) this;
        }

        public Criteria andIqComIdLessThanOrEqualTo(Long value) {
            addCriterion("iq_com_id <=", value, "iqComId");
            return (Criteria) this;
        }

        public Criteria andIqComIdIn(List<Long> values) {
            addCriterion("iq_com_id in", values, "iqComId");
            return (Criteria) this;
        }

        public Criteria andIqComIdNotIn(List<Long> values) {
            addCriterion("iq_com_id not in", values, "iqComId");
            return (Criteria) this;
        }

        public Criteria andIqComIdBetween(Long value1, Long value2) {
            addCriterion("iq_com_id between", value1, value2, "iqComId");
            return (Criteria) this;
        }

        public Criteria andIqComIdNotBetween(Long value1, Long value2) {
            addCriterion("iq_com_id not between", value1, value2, "iqComId");
            return (Criteria) this;
        }

        public Criteria andIclnIsNull() {
            addCriterion("icln is null");
            return (Criteria) this;
        }

        public Criteria andIclnIsNotNull() {
            addCriterion("icln is not null");
            return (Criteria) this;
        }

        public Criteria andIclnEqualTo(Double value) {
            addCriterion("icln =", value, "icln");
            return (Criteria) this;
        }

        public Criteria andIclnNotEqualTo(Double value) {
            addCriterion("icln <>", value, "icln");
            return (Criteria) this;
        }

        public Criteria andIclnGreaterThan(Double value) {
            addCriterion("icln >", value, "icln");
            return (Criteria) this;
        }

        public Criteria andIclnGreaterThanOrEqualTo(Double value) {
            addCriterion("icln >=", value, "icln");
            return (Criteria) this;
        }

        public Criteria andIclnLessThan(Double value) {
            addCriterion("icln <", value, "icln");
            return (Criteria) this;
        }

        public Criteria andIclnLessThanOrEqualTo(Double value) {
            addCriterion("icln <=", value, "icln");
            return (Criteria) this;
        }

        public Criteria andIclnIn(List<Double> values) {
            addCriterion("icln in", values, "icln");
            return (Criteria) this;
        }

        public Criteria andIclnNotIn(List<Double> values) {
            addCriterion("icln not in", values, "icln");
            return (Criteria) this;
        }

        public Criteria andIclnBetween(Double value1, Double value2) {
            addCriterion("icln between", value1, value2, "icln");
            return (Criteria) this;
        }

        public Criteria andIclnNotBetween(Double value1, Double value2) {
            addCriterion("icln not between", value1, value2, "icln");
            return (Criteria) this;
        }

        public Criteria andCigcIsNull() {
            addCriterion("cigc is null");
            return (Criteria) this;
        }

        public Criteria andCigcIsNotNull() {
            addCriterion("cigc is not null");
            return (Criteria) this;
        }

        public Criteria andCigcEqualTo(Double value) {
            addCriterion("cigc =", value, "cigc");
            return (Criteria) this;
        }

        public Criteria andCigcNotEqualTo(Double value) {
            addCriterion("cigc <>", value, "cigc");
            return (Criteria) this;
        }

        public Criteria andCigcGreaterThan(Double value) {
            addCriterion("cigc >", value, "cigc");
            return (Criteria) this;
        }

        public Criteria andCigcGreaterThanOrEqualTo(Double value) {
            addCriterion("cigc >=", value, "cigc");
            return (Criteria) this;
        }

        public Criteria andCigcLessThan(Double value) {
            addCriterion("cigc <", value, "cigc");
            return (Criteria) this;
        }

        public Criteria andCigcLessThanOrEqualTo(Double value) {
            addCriterion("cigc <=", value, "cigc");
            return (Criteria) this;
        }

        public Criteria andCigcIn(List<Double> values) {
            addCriterion("cigc in", values, "cigc");
            return (Criteria) this;
        }

        public Criteria andCigcNotIn(List<Double> values) {
            addCriterion("cigc not in", values, "cigc");
            return (Criteria) this;
        }

        public Criteria andCigcBetween(Double value1, Double value2) {
            addCriterion("cigc between", value1, value2, "cigc");
            return (Criteria) this;
        }

        public Criteria andCigcNotBetween(Double value1, Double value2) {
            addCriterion("cigc not between", value1, value2, "cigc");
            return (Criteria) this;
        }

        public Criteria andDclnIsNull() {
            addCriterion("dcln is null");
            return (Criteria) this;
        }

        public Criteria andDclnIsNotNull() {
            addCriterion("dcln is not null");
            return (Criteria) this;
        }

        public Criteria andDclnEqualTo(Double value) {
            addCriterion("dcln =", value, "dcln");
            return (Criteria) this;
        }

        public Criteria andDclnNotEqualTo(Double value) {
            addCriterion("dcln <>", value, "dcln");
            return (Criteria) this;
        }

        public Criteria andDclnGreaterThan(Double value) {
            addCriterion("dcln >", value, "dcln");
            return (Criteria) this;
        }

        public Criteria andDclnGreaterThanOrEqualTo(Double value) {
            addCriterion("dcln >=", value, "dcln");
            return (Criteria) this;
        }

        public Criteria andDclnLessThan(Double value) {
            addCriterion("dcln <", value, "dcln");
            return (Criteria) this;
        }

        public Criteria andDclnLessThanOrEqualTo(Double value) {
            addCriterion("dcln <=", value, "dcln");
            return (Criteria) this;
        }

        public Criteria andDclnIn(List<Double> values) {
            addCriterion("dcln in", values, "dcln");
            return (Criteria) this;
        }

        public Criteria andDclnNotIn(List<Double> values) {
            addCriterion("dcln not in", values, "dcln");
            return (Criteria) this;
        }

        public Criteria andDclnBetween(Double value1, Double value2) {
            addCriterion("dcln between", value1, value2, "dcln");
            return (Criteria) this;
        }

        public Criteria andDclnNotBetween(Double value1, Double value2) {
            addCriterion("dcln not between", value1, value2, "dcln");
            return (Criteria) this;
        }

        public Criteria andCltAIsNull() {
            addCriterion("clt_a is null");
            return (Criteria) this;
        }

        public Criteria andCltAIsNotNull() {
            addCriterion("clt_a is not null");
            return (Criteria) this;
        }

        public Criteria andCltAEqualTo(Double value) {
            addCriterion("clt_a =", value, "cltA");
            return (Criteria) this;
        }

        public Criteria andCltANotEqualTo(Double value) {
            addCriterion("clt_a <>", value, "cltA");
            return (Criteria) this;
        }

        public Criteria andCltAGreaterThan(Double value) {
            addCriterion("clt_a >", value, "cltA");
            return (Criteria) this;
        }

        public Criteria andCltAGreaterThanOrEqualTo(Double value) {
            addCriterion("clt_a >=", value, "cltA");
            return (Criteria) this;
        }

        public Criteria andCltALessThan(Double value) {
            addCriterion("clt_a <", value, "cltA");
            return (Criteria) this;
        }

        public Criteria andCltALessThanOrEqualTo(Double value) {
            addCriterion("clt_a <=", value, "cltA");
            return (Criteria) this;
        }

        public Criteria andCltAIn(List<Double> values) {
            addCriterion("clt_a in", values, "cltA");
            return (Criteria) this;
        }

        public Criteria andCltANotIn(List<Double> values) {
            addCriterion("clt_a not in", values, "cltA");
            return (Criteria) this;
        }

        public Criteria andCltABetween(Double value1, Double value2) {
            addCriterion("clt_a between", value1, value2, "cltA");
            return (Criteria) this;
        }

        public Criteria andCltANotBetween(Double value1, Double value2) {
            addCriterion("clt_a not between", value1, value2, "cltA");
            return (Criteria) this;
        }

        public Criteria andIpcscIsNull() {
            addCriterion("ipcsc is null");
            return (Criteria) this;
        }

        public Criteria andIpcscIsNotNull() {
            addCriterion("ipcsc is not null");
            return (Criteria) this;
        }

        public Criteria andIpcscEqualTo(Double value) {
            addCriterion("ipcsc =", value, "ipcsc");
            return (Criteria) this;
        }

        public Criteria andIpcscNotEqualTo(Double value) {
            addCriterion("ipcsc <>", value, "ipcsc");
            return (Criteria) this;
        }

        public Criteria andIpcscGreaterThan(Double value) {
            addCriterion("ipcsc >", value, "ipcsc");
            return (Criteria) this;
        }

        public Criteria andIpcscGreaterThanOrEqualTo(Double value) {
            addCriterion("ipcsc >=", value, "ipcsc");
            return (Criteria) this;
        }

        public Criteria andIpcscLessThan(Double value) {
            addCriterion("ipcsc <", value, "ipcsc");
            return (Criteria) this;
        }

        public Criteria andIpcscLessThanOrEqualTo(Double value) {
            addCriterion("ipcsc <=", value, "ipcsc");
            return (Criteria) this;
        }

        public Criteria andIpcscIn(List<Double> values) {
            addCriterion("ipcsc in", values, "ipcsc");
            return (Criteria) this;
        }

        public Criteria andIpcscNotIn(List<Double> values) {
            addCriterion("ipcsc not in", values, "ipcsc");
            return (Criteria) this;
        }

        public Criteria andIpcscBetween(Double value1, Double value2) {
            addCriterion("ipcsc between", value1, value2, "ipcsc");
            return (Criteria) this;
        }

        public Criteria andIpcscNotBetween(Double value1, Double value2) {
            addCriterion("ipcsc not between", value1, value2, "ipcsc");
            return (Criteria) this;
        }

        public Criteria andRmnIsNull() {
            addCriterion("rmn is null");
            return (Criteria) this;
        }

        public Criteria andRmnIsNotNull() {
            addCriterion("rmn is not null");
            return (Criteria) this;
        }

        public Criteria andRmnEqualTo(Double value) {
            addCriterion("rmn =", value, "rmn");
            return (Criteria) this;
        }

        public Criteria andRmnNotEqualTo(Double value) {
            addCriterion("rmn <>", value, "rmn");
            return (Criteria) this;
        }

        public Criteria andRmnGreaterThan(Double value) {
            addCriterion("rmn >", value, "rmn");
            return (Criteria) this;
        }

        public Criteria andRmnGreaterThanOrEqualTo(Double value) {
            addCriterion("rmn >=", value, "rmn");
            return (Criteria) this;
        }

        public Criteria andRmnLessThan(Double value) {
            addCriterion("rmn <", value, "rmn");
            return (Criteria) this;
        }

        public Criteria andRmnLessThanOrEqualTo(Double value) {
            addCriterion("rmn <=", value, "rmn");
            return (Criteria) this;
        }

        public Criteria andRmnIn(List<Double> values) {
            addCriterion("rmn in", values, "rmn");
            return (Criteria) this;
        }

        public Criteria andRmnNotIn(List<Double> values) {
            addCriterion("rmn not in", values, "rmn");
            return (Criteria) this;
        }

        public Criteria andRmnBetween(Double value1, Double value2) {
            addCriterion("rmn between", value1, value2, "rmn");
            return (Criteria) this;
        }

        public Criteria andRmnNotBetween(Double value1, Double value2) {
            addCriterion("rmn not between", value1, value2, "rmn");
            return (Criteria) this;
        }

        public Criteria andCipcIsNull() {
            addCriterion("cipc is null");
            return (Criteria) this;
        }

        public Criteria andCipcIsNotNull() {
            addCriterion("cipc is not null");
            return (Criteria) this;
        }

        public Criteria andCipcEqualTo(Double value) {
            addCriterion("cipc =", value, "cipc");
            return (Criteria) this;
        }

        public Criteria andCipcNotEqualTo(Double value) {
            addCriterion("cipc <>", value, "cipc");
            return (Criteria) this;
        }

        public Criteria andCipcGreaterThan(Double value) {
            addCriterion("cipc >", value, "cipc");
            return (Criteria) this;
        }

        public Criteria andCipcGreaterThanOrEqualTo(Double value) {
            addCriterion("cipc >=", value, "cipc");
            return (Criteria) this;
        }

        public Criteria andCipcLessThan(Double value) {
            addCriterion("cipc <", value, "cipc");
            return (Criteria) this;
        }

        public Criteria andCipcLessThanOrEqualTo(Double value) {
            addCriterion("cipc <=", value, "cipc");
            return (Criteria) this;
        }

        public Criteria andCipcIn(List<Double> values) {
            addCriterion("cipc in", values, "cipc");
            return (Criteria) this;
        }

        public Criteria andCipcNotIn(List<Double> values) {
            addCriterion("cipc not in", values, "cipc");
            return (Criteria) this;
        }

        public Criteria andCipcBetween(Double value1, Double value2) {
            addCriterion("cipc between", value1, value2, "cipc");
            return (Criteria) this;
        }

        public Criteria andCipcNotBetween(Double value1, Double value2) {
            addCriterion("cipc not between", value1, value2, "cipc");
            return (Criteria) this;
        }

        public Criteria andIncoIsNull() {
            addCriterion("inco is null");
            return (Criteria) this;
        }

        public Criteria andIncoIsNotNull() {
            addCriterion("inco is not null");
            return (Criteria) this;
        }

        public Criteria andIncoEqualTo(Double value) {
            addCriterion("inco =", value, "inco");
            return (Criteria) this;
        }

        public Criteria andIncoNotEqualTo(Double value) {
            addCriterion("inco <>", value, "inco");
            return (Criteria) this;
        }

        public Criteria andIncoGreaterThan(Double value) {
            addCriterion("inco >", value, "inco");
            return (Criteria) this;
        }

        public Criteria andIncoGreaterThanOrEqualTo(Double value) {
            addCriterion("inco >=", value, "inco");
            return (Criteria) this;
        }

        public Criteria andIncoLessThan(Double value) {
            addCriterion("inco <", value, "inco");
            return (Criteria) this;
        }

        public Criteria andIncoLessThanOrEqualTo(Double value) {
            addCriterion("inco <=", value, "inco");
            return (Criteria) this;
        }

        public Criteria andIncoIn(List<Double> values) {
            addCriterion("inco in", values, "inco");
            return (Criteria) this;
        }

        public Criteria andIncoNotIn(List<Double> values) {
            addCriterion("inco not in", values, "inco");
            return (Criteria) this;
        }

        public Criteria andIncoBetween(Double value1, Double value2) {
            addCriterion("inco between", value1, value2, "inco");
            return (Criteria) this;
        }

        public Criteria andIncoNotBetween(Double value1, Double value2) {
            addCriterion("inco not between", value1, value2, "inco");
            return (Criteria) this;
        }

        public Criteria andPattAIsNull() {
            addCriterion("patt_a is null");
            return (Criteria) this;
        }

        public Criteria andPattAIsNotNull() {
            addCriterion("patt_a is not null");
            return (Criteria) this;
        }

        public Criteria andPattAEqualTo(Double value) {
            addCriterion("patt_a =", value, "pattA");
            return (Criteria) this;
        }

        public Criteria andPattANotEqualTo(Double value) {
            addCriterion("patt_a <>", value, "pattA");
            return (Criteria) this;
        }

        public Criteria andPattAGreaterThan(Double value) {
            addCriterion("patt_a >", value, "pattA");
            return (Criteria) this;
        }

        public Criteria andPattAGreaterThanOrEqualTo(Double value) {
            addCriterion("patt_a >=", value, "pattA");
            return (Criteria) this;
        }

        public Criteria andPattALessThan(Double value) {
            addCriterion("patt_a <", value, "pattA");
            return (Criteria) this;
        }

        public Criteria andPattALessThanOrEqualTo(Double value) {
            addCriterion("patt_a <=", value, "pattA");
            return (Criteria) this;
        }

        public Criteria andPattAIn(List<Double> values) {
            addCriterion("patt_a in", values, "pattA");
            return (Criteria) this;
        }

        public Criteria andPattANotIn(List<Double> values) {
            addCriterion("patt_a not in", values, "pattA");
            return (Criteria) this;
        }

        public Criteria andPattABetween(Double value1, Double value2) {
            addCriterion("patt_a between", value1, value2, "pattA");
            return (Criteria) this;
        }

        public Criteria andPattANotBetween(Double value1, Double value2) {
            addCriterion("patt_a not between", value1, value2, "pattA");
            return (Criteria) this;
        }

        public Criteria andPlicIsNull() {
            addCriterion("plic is null");
            return (Criteria) this;
        }

        public Criteria andPlicIsNotNull() {
            addCriterion("plic is not null");
            return (Criteria) this;
        }

        public Criteria andPlicEqualTo(Double value) {
            addCriterion("plic =", value, "plic");
            return (Criteria) this;
        }

        public Criteria andPlicNotEqualTo(Double value) {
            addCriterion("plic <>", value, "plic");
            return (Criteria) this;
        }

        public Criteria andPlicGreaterThan(Double value) {
            addCriterion("plic >", value, "plic");
            return (Criteria) this;
        }

        public Criteria andPlicGreaterThanOrEqualTo(Double value) {
            addCriterion("plic >=", value, "plic");
            return (Criteria) this;
        }

        public Criteria andPlicLessThan(Double value) {
            addCriterion("plic <", value, "plic");
            return (Criteria) this;
        }

        public Criteria andPlicLessThanOrEqualTo(Double value) {
            addCriterion("plic <=", value, "plic");
            return (Criteria) this;
        }

        public Criteria andPlicIn(List<Double> values) {
            addCriterion("plic in", values, "plic");
            return (Criteria) this;
        }

        public Criteria andPlicNotIn(List<Double> values) {
            addCriterion("plic not in", values, "plic");
            return (Criteria) this;
        }

        public Criteria andPlicBetween(Double value1, Double value2) {
            addCriterion("plic between", value1, value2, "plic");
            return (Criteria) this;
        }

        public Criteria andPlicNotBetween(Double value1, Double value2) {
            addCriterion("plic not between", value1, value2, "plic");
            return (Criteria) this;
        }

        public Criteria andPccIsNull() {
            addCriterion("pcc is null");
            return (Criteria) this;
        }

        public Criteria andPccIsNotNull() {
            addCriterion("pcc is not null");
            return (Criteria) this;
        }

        public Criteria andPccEqualTo(Double value) {
            addCriterion("pcc =", value, "pcc");
            return (Criteria) this;
        }

        public Criteria andPccNotEqualTo(Double value) {
            addCriterion("pcc <>", value, "pcc");
            return (Criteria) this;
        }

        public Criteria andPccGreaterThan(Double value) {
            addCriterion("pcc >", value, "pcc");
            return (Criteria) this;
        }

        public Criteria andPccGreaterThanOrEqualTo(Double value) {
            addCriterion("pcc >=", value, "pcc");
            return (Criteria) this;
        }

        public Criteria andPccLessThan(Double value) {
            addCriterion("pcc <", value, "pcc");
            return (Criteria) this;
        }

        public Criteria andPccLessThanOrEqualTo(Double value) {
            addCriterion("pcc <=", value, "pcc");
            return (Criteria) this;
        }

        public Criteria andPccIn(List<Double> values) {
            addCriterion("pcc in", values, "pcc");
            return (Criteria) this;
        }

        public Criteria andPccNotIn(List<Double> values) {
            addCriterion("pcc not in", values, "pcc");
            return (Criteria) this;
        }

        public Criteria andPccBetween(Double value1, Double value2) {
            addCriterion("pcc between", value1, value2, "pcc");
            return (Criteria) this;
        }

        public Criteria andPccNotBetween(Double value1, Double value2) {
            addCriterion("pcc not between", value1, value2, "pcc");
            return (Criteria) this;
        }

        public Criteria andPpcIsNull() {
            addCriterion("ppc is null");
            return (Criteria) this;
        }

        public Criteria andPpcIsNotNull() {
            addCriterion("ppc is not null");
            return (Criteria) this;
        }

        public Criteria andPpcEqualTo(Double value) {
            addCriterion("ppc =", value, "ppc");
            return (Criteria) this;
        }

        public Criteria andPpcNotEqualTo(Double value) {
            addCriterion("ppc <>", value, "ppc");
            return (Criteria) this;
        }

        public Criteria andPpcGreaterThan(Double value) {
            addCriterion("ppc >", value, "ppc");
            return (Criteria) this;
        }

        public Criteria andPpcGreaterThanOrEqualTo(Double value) {
            addCriterion("ppc >=", value, "ppc");
            return (Criteria) this;
        }

        public Criteria andPpcLessThan(Double value) {
            addCriterion("ppc <", value, "ppc");
            return (Criteria) this;
        }

        public Criteria andPpcLessThanOrEqualTo(Double value) {
            addCriterion("ppc <=", value, "ppc");
            return (Criteria) this;
        }

        public Criteria andPpcIn(List<Double> values) {
            addCriterion("ppc in", values, "ppc");
            return (Criteria) this;
        }

        public Criteria andPpcNotIn(List<Double> values) {
            addCriterion("ppc not in", values, "ppc");
            return (Criteria) this;
        }

        public Criteria andPpcBetween(Double value1, Double value2) {
            addCriterion("ppc between", value1, value2, "ppc");
            return (Criteria) this;
        }

        public Criteria andPpcNotBetween(Double value1, Double value2) {
            addCriterion("ppc not between", value1, value2, "ppc");
            return (Criteria) this;
        }

        public Criteria andTccIsNull() {
            addCriterion("tcc is null");
            return (Criteria) this;
        }

        public Criteria andTccIsNotNull() {
            addCriterion("tcc is not null");
            return (Criteria) this;
        }

        public Criteria andTccEqualTo(Double value) {
            addCriterion("tcc =", value, "tcc");
            return (Criteria) this;
        }

        public Criteria andTccNotEqualTo(Double value) {
            addCriterion("tcc <>", value, "tcc");
            return (Criteria) this;
        }

        public Criteria andTccGreaterThan(Double value) {
            addCriterion("tcc >", value, "tcc");
            return (Criteria) this;
        }

        public Criteria andTccGreaterThanOrEqualTo(Double value) {
            addCriterion("tcc >=", value, "tcc");
            return (Criteria) this;
        }

        public Criteria andTccLessThan(Double value) {
            addCriterion("tcc <", value, "tcc");
            return (Criteria) this;
        }

        public Criteria andTccLessThanOrEqualTo(Double value) {
            addCriterion("tcc <=", value, "tcc");
            return (Criteria) this;
        }

        public Criteria andTccIn(List<Double> values) {
            addCriterion("tcc in", values, "tcc");
            return (Criteria) this;
        }

        public Criteria andTccNotIn(List<Double> values) {
            addCriterion("tcc not in", values, "tcc");
            return (Criteria) this;
        }

        public Criteria andTccBetween(Double value1, Double value2) {
            addCriterion("tcc between", value1, value2, "tcc");
            return (Criteria) this;
        }

        public Criteria andTccNotBetween(Double value1, Double value2) {
            addCriterion("tcc not between", value1, value2, "tcc");
            return (Criteria) this;
        }

        public Criteria andDespageIsNull() {
            addCriterion("despage is null");
            return (Criteria) this;
        }

        public Criteria andDespageIsNotNull() {
            addCriterion("despage is not null");
            return (Criteria) this;
        }

        public Criteria andDespageEqualTo(Double value) {
            addCriterion("despage =", value, "despage");
            return (Criteria) this;
        }

        public Criteria andDespageNotEqualTo(Double value) {
            addCriterion("despage <>", value, "despage");
            return (Criteria) this;
        }

        public Criteria andDespageGreaterThan(Double value) {
            addCriterion("despage >", value, "despage");
            return (Criteria) this;
        }

        public Criteria andDespageGreaterThanOrEqualTo(Double value) {
            addCriterion("despage >=", value, "despage");
            return (Criteria) this;
        }

        public Criteria andDespageLessThan(Double value) {
            addCriterion("despage <", value, "despage");
            return (Criteria) this;
        }

        public Criteria andDespageLessThanOrEqualTo(Double value) {
            addCriterion("despage <=", value, "despage");
            return (Criteria) this;
        }

        public Criteria andDespageIn(List<Double> values) {
            addCriterion("despage in", values, "despage");
            return (Criteria) this;
        }

        public Criteria andDespageNotIn(List<Double> values) {
            addCriterion("despage not in", values, "despage");
            return (Criteria) this;
        }

        public Criteria andDespageBetween(Double value1, Double value2) {
            addCriterion("despage between", value1, value2, "despage");
            return (Criteria) this;
        }

        public Criteria andDespageNotBetween(Double value1, Double value2) {
            addCriterion("despage not between", value1, value2, "despage");
            return (Criteria) this;
        }

        public Criteria andDrawpageIsNull() {
            addCriterion("drawpage is null");
            return (Criteria) this;
        }

        public Criteria andDrawpageIsNotNull() {
            addCriterion("drawpage is not null");
            return (Criteria) this;
        }

        public Criteria andDrawpageEqualTo(Double value) {
            addCriterion("drawpage =", value, "drawpage");
            return (Criteria) this;
        }

        public Criteria andDrawpageNotEqualTo(Double value) {
            addCriterion("drawpage <>", value, "drawpage");
            return (Criteria) this;
        }

        public Criteria andDrawpageGreaterThan(Double value) {
            addCriterion("drawpage >", value, "drawpage");
            return (Criteria) this;
        }

        public Criteria andDrawpageGreaterThanOrEqualTo(Double value) {
            addCriterion("drawpage >=", value, "drawpage");
            return (Criteria) this;
        }

        public Criteria andDrawpageLessThan(Double value) {
            addCriterion("drawpage <", value, "drawpage");
            return (Criteria) this;
        }

        public Criteria andDrawpageLessThanOrEqualTo(Double value) {
            addCriterion("drawpage <=", value, "drawpage");
            return (Criteria) this;
        }

        public Criteria andDrawpageIn(List<Double> values) {
            addCriterion("drawpage in", values, "drawpage");
            return (Criteria) this;
        }

        public Criteria andDrawpageNotIn(List<Double> values) {
            addCriterion("drawpage not in", values, "drawpage");
            return (Criteria) this;
        }

        public Criteria andDrawpageBetween(Double value1, Double value2) {
            addCriterion("drawpage between", value1, value2, "drawpage");
            return (Criteria) this;
        }

        public Criteria andDrawpageNotBetween(Double value1, Double value2) {
            addCriterion("drawpage not between", value1, value2, "drawpage");
            return (Criteria) this;
        }

        public Criteria andSfclIsNull() {
            addCriterion("sfcl is null");
            return (Criteria) this;
        }

        public Criteria andSfclIsNotNull() {
            addCriterion("sfcl is not null");
            return (Criteria) this;
        }

        public Criteria andSfclEqualTo(Double value) {
            addCriterion("sfcl =", value, "sfcl");
            return (Criteria) this;
        }

        public Criteria andSfclNotEqualTo(Double value) {
            addCriterion("sfcl <>", value, "sfcl");
            return (Criteria) this;
        }

        public Criteria andSfclGreaterThan(Double value) {
            addCriterion("sfcl >", value, "sfcl");
            return (Criteria) this;
        }

        public Criteria andSfclGreaterThanOrEqualTo(Double value) {
            addCriterion("sfcl >=", value, "sfcl");
            return (Criteria) this;
        }

        public Criteria andSfclLessThan(Double value) {
            addCriterion("sfcl <", value, "sfcl");
            return (Criteria) this;
        }

        public Criteria andSfclLessThanOrEqualTo(Double value) {
            addCriterion("sfcl <=", value, "sfcl");
            return (Criteria) this;
        }

        public Criteria andSfclIn(List<Double> values) {
            addCriterion("sfcl in", values, "sfcl");
            return (Criteria) this;
        }

        public Criteria andSfclNotIn(List<Double> values) {
            addCriterion("sfcl not in", values, "sfcl");
            return (Criteria) this;
        }

        public Criteria andSfclBetween(Double value1, Double value2) {
            addCriterion("sfcl between", value1, value2, "sfcl");
            return (Criteria) this;
        }

        public Criteria andSfclNotBetween(Double value1, Double value2) {
            addCriterion("sfcl not between", value1, value2, "sfcl");
            return (Criteria) this;
        }

        public Criteria andFajpIsNull() {
            addCriterion("fajp is null");
            return (Criteria) this;
        }

        public Criteria andFajpIsNotNull() {
            addCriterion("fajp is not null");
            return (Criteria) this;
        }

        public Criteria andFajpEqualTo(Double value) {
            addCriterion("fajp =", value, "fajp");
            return (Criteria) this;
        }

        public Criteria andFajpNotEqualTo(Double value) {
            addCriterion("fajp <>", value, "fajp");
            return (Criteria) this;
        }

        public Criteria andFajpGreaterThan(Double value) {
            addCriterion("fajp >", value, "fajp");
            return (Criteria) this;
        }

        public Criteria andFajpGreaterThanOrEqualTo(Double value) {
            addCriterion("fajp >=", value, "fajp");
            return (Criteria) this;
        }

        public Criteria andFajpLessThan(Double value) {
            addCriterion("fajp <", value, "fajp");
            return (Criteria) this;
        }

        public Criteria andFajpLessThanOrEqualTo(Double value) {
            addCriterion("fajp <=", value, "fajp");
            return (Criteria) this;
        }

        public Criteria andFajpIn(List<Double> values) {
            addCriterion("fajp in", values, "fajp");
            return (Criteria) this;
        }

        public Criteria andFajpNotIn(List<Double> values) {
            addCriterion("fajp not in", values, "fajp");
            return (Criteria) this;
        }

        public Criteria andFajpBetween(Double value1, Double value2) {
            addCriterion("fajp between", value1, value2, "fajp");
            return (Criteria) this;
        }

        public Criteria andFajpNotBetween(Double value1, Double value2) {
            addCriterion("fajp not between", value1, value2, "fajp");
            return (Criteria) this;
        }

        public Criteria andFausIsNull() {
            addCriterion("faus is null");
            return (Criteria) this;
        }

        public Criteria andFausIsNotNull() {
            addCriterion("faus is not null");
            return (Criteria) this;
        }

        public Criteria andFausEqualTo(Double value) {
            addCriterion("faus =", value, "faus");
            return (Criteria) this;
        }

        public Criteria andFausNotEqualTo(Double value) {
            addCriterion("faus <>", value, "faus");
            return (Criteria) this;
        }

        public Criteria andFausGreaterThan(Double value) {
            addCriterion("faus >", value, "faus");
            return (Criteria) this;
        }

        public Criteria andFausGreaterThanOrEqualTo(Double value) {
            addCriterion("faus >=", value, "faus");
            return (Criteria) this;
        }

        public Criteria andFausLessThan(Double value) {
            addCriterion("faus <", value, "faus");
            return (Criteria) this;
        }

        public Criteria andFausLessThanOrEqualTo(Double value) {
            addCriterion("faus <=", value, "faus");
            return (Criteria) this;
        }

        public Criteria andFausIn(List<Double> values) {
            addCriterion("faus in", values, "faus");
            return (Criteria) this;
        }

        public Criteria andFausNotIn(List<Double> values) {
            addCriterion("faus not in", values, "faus");
            return (Criteria) this;
        }

        public Criteria andFausBetween(Double value1, Double value2) {
            addCriterion("faus between", value1, value2, "faus");
            return (Criteria) this;
        }

        public Criteria andFausNotBetween(Double value1, Double value2) {
            addCriterion("faus not between", value1, value2, "faus");
            return (Criteria) this;
        }

        public Criteria andFaotIsNull() {
            addCriterion("faot is null");
            return (Criteria) this;
        }

        public Criteria andFaotIsNotNull() {
            addCriterion("faot is not null");
            return (Criteria) this;
        }

        public Criteria andFaotEqualTo(Double value) {
            addCriterion("faot =", value, "faot");
            return (Criteria) this;
        }

        public Criteria andFaotNotEqualTo(Double value) {
            addCriterion("faot <>", value, "faot");
            return (Criteria) this;
        }

        public Criteria andFaotGreaterThan(Double value) {
            addCriterion("faot >", value, "faot");
            return (Criteria) this;
        }

        public Criteria andFaotGreaterThanOrEqualTo(Double value) {
            addCriterion("faot >=", value, "faot");
            return (Criteria) this;
        }

        public Criteria andFaotLessThan(Double value) {
            addCriterion("faot <", value, "faot");
            return (Criteria) this;
        }

        public Criteria andFaotLessThanOrEqualTo(Double value) {
            addCriterion("faot <=", value, "faot");
            return (Criteria) this;
        }

        public Criteria andFaotIn(List<Double> values) {
            addCriterion("faot in", values, "faot");
            return (Criteria) this;
        }

        public Criteria andFaotNotIn(List<Double> values) {
            addCriterion("faot not in", values, "faot");
            return (Criteria) this;
        }

        public Criteria andFaotBetween(Double value1, Double value2) {
            addCriterion("faot between", value1, value2, "faot");
            return (Criteria) this;
        }

        public Criteria andFaotNotBetween(Double value1, Double value2) {
            addCriterion("faot not between", value1, value2, "faot");
            return (Criteria) this;
        }

        public Criteria andCltBIsNull() {
            addCriterion("clt_b is null");
            return (Criteria) this;
        }

        public Criteria andCltBIsNotNull() {
            addCriterion("clt_b is not null");
            return (Criteria) this;
        }

        public Criteria andCltBEqualTo(Double value) {
            addCriterion("clt_b =", value, "cltB");
            return (Criteria) this;
        }

        public Criteria andCltBNotEqualTo(Double value) {
            addCriterion("clt_b <>", value, "cltB");
            return (Criteria) this;
        }

        public Criteria andCltBGreaterThan(Double value) {
            addCriterion("clt_b >", value, "cltB");
            return (Criteria) this;
        }

        public Criteria andCltBGreaterThanOrEqualTo(Double value) {
            addCriterion("clt_b >=", value, "cltB");
            return (Criteria) this;
        }

        public Criteria andCltBLessThan(Double value) {
            addCriterion("clt_b <", value, "cltB");
            return (Criteria) this;
        }

        public Criteria andCltBLessThanOrEqualTo(Double value) {
            addCriterion("clt_b <=", value, "cltB");
            return (Criteria) this;
        }

        public Criteria andCltBIn(List<Double> values) {
            addCriterion("clt_b in", values, "cltB");
            return (Criteria) this;
        }

        public Criteria andCltBNotIn(List<Double> values) {
            addCriterion("clt_b not in", values, "cltB");
            return (Criteria) this;
        }

        public Criteria andCltBBetween(Double value1, Double value2) {
            addCriterion("clt_b between", value1, value2, "cltB");
            return (Criteria) this;
        }

        public Criteria andCltBNotBetween(Double value1, Double value2) {
            addCriterion("clt_b not between", value1, value2, "cltB");
            return (Criteria) this;
        }

        public Criteria andCltCIsNull() {
            addCriterion("clt_c is null");
            return (Criteria) this;
        }

        public Criteria andCltCIsNotNull() {
            addCriterion("clt_c is not null");
            return (Criteria) this;
        }

        public Criteria andCltCEqualTo(Double value) {
            addCriterion("clt_c =", value, "cltC");
            return (Criteria) this;
        }

        public Criteria andCltCNotEqualTo(Double value) {
            addCriterion("clt_c <>", value, "cltC");
            return (Criteria) this;
        }

        public Criteria andCltCGreaterThan(Double value) {
            addCriterion("clt_c >", value, "cltC");
            return (Criteria) this;
        }

        public Criteria andCltCGreaterThanOrEqualTo(Double value) {
            addCriterion("clt_c >=", value, "cltC");
            return (Criteria) this;
        }

        public Criteria andCltCLessThan(Double value) {
            addCriterion("clt_c <", value, "cltC");
            return (Criteria) this;
        }

        public Criteria andCltCLessThanOrEqualTo(Double value) {
            addCriterion("clt_c <=", value, "cltC");
            return (Criteria) this;
        }

        public Criteria andCltCIn(List<Double> values) {
            addCriterion("clt_c in", values, "cltC");
            return (Criteria) this;
        }

        public Criteria andCltCNotIn(List<Double> values) {
            addCriterion("clt_c not in", values, "cltC");
            return (Criteria) this;
        }

        public Criteria andCltCBetween(Double value1, Double value2) {
            addCriterion("clt_c between", value1, value2, "cltC");
            return (Criteria) this;
        }

        public Criteria andCltCNotBetween(Double value1, Double value2) {
            addCriterion("clt_c not between", value1, value2, "cltC");
            return (Criteria) this;
        }

        public Criteria andPattBIsNull() {
            addCriterion("patt_b is null");
            return (Criteria) this;
        }

        public Criteria andPattBIsNotNull() {
            addCriterion("patt_b is not null");
            return (Criteria) this;
        }

        public Criteria andPattBEqualTo(Double value) {
            addCriterion("patt_b =", value, "pattB");
            return (Criteria) this;
        }

        public Criteria andPattBNotEqualTo(Double value) {
            addCriterion("patt_b <>", value, "pattB");
            return (Criteria) this;
        }

        public Criteria andPattBGreaterThan(Double value) {
            addCriterion("patt_b >", value, "pattB");
            return (Criteria) this;
        }

        public Criteria andPattBGreaterThanOrEqualTo(Double value) {
            addCriterion("patt_b >=", value, "pattB");
            return (Criteria) this;
        }

        public Criteria andPattBLessThan(Double value) {
            addCriterion("patt_b <", value, "pattB");
            return (Criteria) this;
        }

        public Criteria andPattBLessThanOrEqualTo(Double value) {
            addCriterion("patt_b <=", value, "pattB");
            return (Criteria) this;
        }

        public Criteria andPattBIn(List<Double> values) {
            addCriterion("patt_b in", values, "pattB");
            return (Criteria) this;
        }

        public Criteria andPattBNotIn(List<Double> values) {
            addCriterion("patt_b not in", values, "pattB");
            return (Criteria) this;
        }

        public Criteria andPattBBetween(Double value1, Double value2) {
            addCriterion("patt_b between", value1, value2, "pattB");
            return (Criteria) this;
        }

        public Criteria andPattBNotBetween(Double value1, Double value2) {
            addCriterion("patt_b not between", value1, value2, "pattB");
            return (Criteria) this;
        }

        public Criteria andProCodeIsNull() {
            addCriterion("pro_code is null");
            return (Criteria) this;
        }

        public Criteria andProCodeIsNotNull() {
            addCriterion("pro_code is not null");
            return (Criteria) this;
        }

        public Criteria andProCodeEqualTo(String value) {
            addCriterion("pro_code =", value, "proCode");
            return (Criteria) this;
        }

        public Criteria andProCodeNotEqualTo(String value) {
            addCriterion("pro_code <>", value, "proCode");
            return (Criteria) this;
        }

        public Criteria andProCodeGreaterThan(String value) {
            addCriterion("pro_code >", value, "proCode");
            return (Criteria) this;
        }

        public Criteria andProCodeGreaterThanOrEqualTo(String value) {
            addCriterion("pro_code >=", value, "proCode");
            return (Criteria) this;
        }

        public Criteria andProCodeLessThan(String value) {
            addCriterion("pro_code <", value, "proCode");
            return (Criteria) this;
        }

        public Criteria andProCodeLessThanOrEqualTo(String value) {
            addCriterion("pro_code <=", value, "proCode");
            return (Criteria) this;
        }

        public Criteria andProCodeLike(String value) {
            addCriterion("pro_code like", value, "proCode");
            return (Criteria) this;
        }

        public Criteria andProCodeNotLike(String value) {
            addCriterion("pro_code not like", value, "proCode");
            return (Criteria) this;
        }

        public Criteria andProCodeIn(List<String> values) {
            addCriterion("pro_code in", values, "proCode");
            return (Criteria) this;
        }

        public Criteria andProCodeNotIn(List<String> values) {
            addCriterion("pro_code not in", values, "proCode");
            return (Criteria) this;
        }

        public Criteria andProCodeBetween(String value1, String value2) {
            addCriterion("pro_code between", value1, value2, "proCode");
            return (Criteria) this;
        }

        public Criteria andProCodeNotBetween(String value1, String value2) {
            addCriterion("pro_code not between", value1, value2, "proCode");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}