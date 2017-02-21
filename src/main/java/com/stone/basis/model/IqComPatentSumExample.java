package com.kpap.basis.model;

import java.util.ArrayList;
import java.util.List;

public class IqComPatentSumExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public IqComPatentSumExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPro_codeIsNull() {
            addCriterion("pro_code is null");
            return (Criteria) this;
        }

        public Criteria andPro_codeIsNotNull() {
            addCriterion("pro_code is not null");
            return (Criteria) this;
        }

        public Criteria andPro_codeEqualTo(String value) {
            addCriterion("pro_code =", value, "pro_code");
            return (Criteria) this;
        }

        public Criteria andPro_codeNotEqualTo(String value) {
            addCriterion("pro_code <>", value, "pro_code");
            return (Criteria) this;
        }

        public Criteria andPro_codeGreaterThan(String value) {
            addCriterion("pro_code >", value, "pro_code");
            return (Criteria) this;
        }

        public Criteria andPro_codeGreaterThanOrEqualTo(String value) {
            addCriterion("pro_code >=", value, "pro_code");
            return (Criteria) this;
        }

        public Criteria andPro_codeLessThan(String value) {
            addCriterion("pro_code <", value, "pro_code");
            return (Criteria) this;
        }

        public Criteria andPro_codeLessThanOrEqualTo(String value) {
            addCriterion("pro_code <=", value, "pro_code");
            return (Criteria) this;
        }

        public Criteria andPro_codeLike(String value) {
            addCriterion("pro_code like", value, "pro_code");
            return (Criteria) this;
        }

        public Criteria andPro_codeNotLike(String value) {
            addCriterion("pro_code not like", value, "pro_code");
            return (Criteria) this;
        }

        public Criteria andPro_codeIn(List<String> values) {
            addCriterion("pro_code in", values, "pro_code");
            return (Criteria) this;
        }

        public Criteria andPro_codeNotIn(List<String> values) {
            addCriterion("pro_code not in", values, "pro_code");
            return (Criteria) this;
        }

        public Criteria andPro_codeBetween(String value1, String value2) {
            addCriterion("pro_code between", value1, value2, "pro_code");
            return (Criteria) this;
        }

        public Criteria andPro_codeNotBetween(String value1, String value2) {
            addCriterion("pro_code not between", value1, value2, "pro_code");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andClt_aIsNull() {
            addCriterion("clt_a is null");
            return (Criteria) this;
        }

        public Criteria andClt_aIsNotNull() {
            addCriterion("clt_a is not null");
            return (Criteria) this;
        }

        public Criteria andClt_aEqualTo(Double value) {
            addCriterion("clt_a =", value, "clt_a");
            return (Criteria) this;
        }

        public Criteria andClt_aNotEqualTo(Double value) {
            addCriterion("clt_a <>", value, "clt_a");
            return (Criteria) this;
        }

        public Criteria andClt_aGreaterThan(Double value) {
            addCriterion("clt_a >", value, "clt_a");
            return (Criteria) this;
        }

        public Criteria andClt_aGreaterThanOrEqualTo(Double value) {
            addCriterion("clt_a >=", value, "clt_a");
            return (Criteria) this;
        }

        public Criteria andClt_aLessThan(Double value) {
            addCriterion("clt_a <", value, "clt_a");
            return (Criteria) this;
        }

        public Criteria andClt_aLessThanOrEqualTo(Double value) {
            addCriterion("clt_a <=", value, "clt_a");
            return (Criteria) this;
        }

        public Criteria andClt_aIn(List<Double> values) {
            addCriterion("clt_a in", values, "clt_a");
            return (Criteria) this;
        }

        public Criteria andClt_aNotIn(List<Double> values) {
            addCriterion("clt_a not in", values, "clt_a");
            return (Criteria) this;
        }

        public Criteria andClt_aBetween(Double value1, Double value2) {
            addCriterion("clt_a between", value1, value2, "clt_a");
            return (Criteria) this;
        }

        public Criteria andClt_aNotBetween(Double value1, Double value2) {
            addCriterion("clt_a not between", value1, value2, "clt_a");
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

        public Criteria andPatt_aIsNull() {
            addCriterion("patt_a is null");
            return (Criteria) this;
        }

        public Criteria andPatt_aIsNotNull() {
            addCriterion("patt_a is not null");
            return (Criteria) this;
        }

        public Criteria andPatt_aEqualTo(Double value) {
            addCriterion("patt_a =", value, "patt_a");
            return (Criteria) this;
        }

        public Criteria andPatt_aNotEqualTo(Double value) {
            addCriterion("patt_a <>", value, "patt_a");
            return (Criteria) this;
        }

        public Criteria andPatt_aGreaterThan(Double value) {
            addCriterion("patt_a >", value, "patt_a");
            return (Criteria) this;
        }

        public Criteria andPatt_aGreaterThanOrEqualTo(Double value) {
            addCriterion("patt_a >=", value, "patt_a");
            return (Criteria) this;
        }

        public Criteria andPatt_aLessThan(Double value) {
            addCriterion("patt_a <", value, "patt_a");
            return (Criteria) this;
        }

        public Criteria andPatt_aLessThanOrEqualTo(Double value) {
            addCriterion("patt_a <=", value, "patt_a");
            return (Criteria) this;
        }

        public Criteria andPatt_aIn(List<Double> values) {
            addCriterion("patt_a in", values, "patt_a");
            return (Criteria) this;
        }

        public Criteria andPatt_aNotIn(List<Double> values) {
            addCriterion("patt_a not in", values, "patt_a");
            return (Criteria) this;
        }

        public Criteria andPatt_aBetween(Double value1, Double value2) {
            addCriterion("patt_a between", value1, value2, "patt_a");
            return (Criteria) this;
        }

        public Criteria andPatt_aNotBetween(Double value1, Double value2) {
            addCriterion("patt_a not between", value1, value2, "patt_a");
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

        public Criteria andClt_bIsNull() {
            addCriterion("clt_b is null");
            return (Criteria) this;
        }

        public Criteria andClt_bIsNotNull() {
            addCriterion("clt_b is not null");
            return (Criteria) this;
        }

        public Criteria andClt_bEqualTo(Double value) {
            addCriterion("clt_b =", value, "clt_b");
            return (Criteria) this;
        }

        public Criteria andClt_bNotEqualTo(Double value) {
            addCriterion("clt_b <>", value, "clt_b");
            return (Criteria) this;
        }

        public Criteria andClt_bGreaterThan(Double value) {
            addCriterion("clt_b >", value, "clt_b");
            return (Criteria) this;
        }

        public Criteria andClt_bGreaterThanOrEqualTo(Double value) {
            addCriterion("clt_b >=", value, "clt_b");
            return (Criteria) this;
        }

        public Criteria andClt_bLessThan(Double value) {
            addCriterion("clt_b <", value, "clt_b");
            return (Criteria) this;
        }

        public Criteria andClt_bLessThanOrEqualTo(Double value) {
            addCriterion("clt_b <=", value, "clt_b");
            return (Criteria) this;
        }

        public Criteria andClt_bIn(List<Double> values) {
            addCriterion("clt_b in", values, "clt_b");
            return (Criteria) this;
        }

        public Criteria andClt_bNotIn(List<Double> values) {
            addCriterion("clt_b not in", values, "clt_b");
            return (Criteria) this;
        }

        public Criteria andClt_bBetween(Double value1, Double value2) {
            addCriterion("clt_b between", value1, value2, "clt_b");
            return (Criteria) this;
        }

        public Criteria andClt_bNotBetween(Double value1, Double value2) {
            addCriterion("clt_b not between", value1, value2, "clt_b");
            return (Criteria) this;
        }

        public Criteria andClt_cIsNull() {
            addCriterion("clt_c is null");
            return (Criteria) this;
        }

        public Criteria andClt_cIsNotNull() {
            addCriterion("clt_c is not null");
            return (Criteria) this;
        }

        public Criteria andClt_cEqualTo(Double value) {
            addCriterion("clt_c =", value, "clt_c");
            return (Criteria) this;
        }

        public Criteria andClt_cNotEqualTo(Double value) {
            addCriterion("clt_c <>", value, "clt_c");
            return (Criteria) this;
        }

        public Criteria andClt_cGreaterThan(Double value) {
            addCriterion("clt_c >", value, "clt_c");
            return (Criteria) this;
        }

        public Criteria andClt_cGreaterThanOrEqualTo(Double value) {
            addCriterion("clt_c >=", value, "clt_c");
            return (Criteria) this;
        }

        public Criteria andClt_cLessThan(Double value) {
            addCriterion("clt_c <", value, "clt_c");
            return (Criteria) this;
        }

        public Criteria andClt_cLessThanOrEqualTo(Double value) {
            addCriterion("clt_c <=", value, "clt_c");
            return (Criteria) this;
        }

        public Criteria andClt_cIn(List<Double> values) {
            addCriterion("clt_c in", values, "clt_c");
            return (Criteria) this;
        }

        public Criteria andClt_cNotIn(List<Double> values) {
            addCriterion("clt_c not in", values, "clt_c");
            return (Criteria) this;
        }

        public Criteria andClt_cBetween(Double value1, Double value2) {
            addCriterion("clt_c between", value1, value2, "clt_c");
            return (Criteria) this;
        }

        public Criteria andClt_cNotBetween(Double value1, Double value2) {
            addCriterion("clt_c not between", value1, value2, "clt_c");
            return (Criteria) this;
        }

        public Criteria andPatt_bIsNull() {
            addCriterion("patt_b is null");
            return (Criteria) this;
        }

        public Criteria andPatt_bIsNotNull() {
            addCriterion("patt_b is not null");
            return (Criteria) this;
        }

        public Criteria andPatt_bEqualTo(Double value) {
            addCriterion("patt_b =", value, "patt_b");
            return (Criteria) this;
        }

        public Criteria andPatt_bNotEqualTo(Double value) {
            addCriterion("patt_b <>", value, "patt_b");
            return (Criteria) this;
        }

        public Criteria andPatt_bGreaterThan(Double value) {
            addCriterion("patt_b >", value, "patt_b");
            return (Criteria) this;
        }

        public Criteria andPatt_bGreaterThanOrEqualTo(Double value) {
            addCriterion("patt_b >=", value, "patt_b");
            return (Criteria) this;
        }

        public Criteria andPatt_bLessThan(Double value) {
            addCriterion("patt_b <", value, "patt_b");
            return (Criteria) this;
        }

        public Criteria andPatt_bLessThanOrEqualTo(Double value) {
            addCriterion("patt_b <=", value, "patt_b");
            return (Criteria) this;
        }

        public Criteria andPatt_bIn(List<Double> values) {
            addCriterion("patt_b in", values, "patt_b");
            return (Criteria) this;
        }

        public Criteria andPatt_bNotIn(List<Double> values) {
            addCriterion("patt_b not in", values, "patt_b");
            return (Criteria) this;
        }

        public Criteria andPatt_bBetween(Double value1, Double value2) {
            addCriterion("patt_b between", value1, value2, "patt_b");
            return (Criteria) this;
        }

        public Criteria andPatt_bNotBetween(Double value1, Double value2) {
            addCriterion("patt_b not between", value1, value2, "patt_b");
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