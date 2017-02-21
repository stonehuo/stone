package com.kpap.basis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ProValCaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public ProValCaseExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andCaseIdIsNull() {
            addCriterion("case_id is null");
            return (Criteria) this;
        }

        public Criteria andCaseIdIsNotNull() {
            addCriterion("case_id is not null");
            return (Criteria) this;
        }

        public Criteria andCaseIdEqualTo(Long value) {
            addCriterion("case_id =", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotEqualTo(Long value) {
            addCriterion("case_id <>", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdGreaterThan(Long value) {
            addCriterion("case_id >", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdGreaterThanOrEqualTo(Long value) {
            addCriterion("case_id >=", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdLessThan(Long value) {
            addCriterion("case_id <", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdLessThanOrEqualTo(Long value) {
            addCriterion("case_id <=", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdIn(List<Long> values) {
            addCriterion("case_id in", values, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotIn(List<Long> values) {
            addCriterion("case_id not in", values, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdBetween(Long value1, Long value2) {
            addCriterion("case_id between", value1, value2, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotBetween(Long value1, Long value2) {
            addCriterion("case_id not between", value1, value2, "caseId");
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

        public Criteria andProValIdIsNull() {
            addCriterion("pro_val_id is null");
            return (Criteria) this;
        }

        public Criteria andProValIdIsNotNull() {
            addCriterion("pro_val_id is not null");
            return (Criteria) this;
        }

        public Criteria andProValIdEqualTo(Long value) {
            addCriterion("pro_val_id =", value, "proValId");
            return (Criteria) this;
        }

        public Criteria andProValIdNotEqualTo(Long value) {
            addCriterion("pro_val_id <>", value, "proValId");
            return (Criteria) this;
        }

        public Criteria andProValIdGreaterThan(Long value) {
            addCriterion("pro_val_id >", value, "proValId");
            return (Criteria) this;
        }

        public Criteria andProValIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pro_val_id >=", value, "proValId");
            return (Criteria) this;
        }

        public Criteria andProValIdLessThan(Long value) {
            addCriterion("pro_val_id <", value, "proValId");
            return (Criteria) this;
        }

        public Criteria andProValIdLessThanOrEqualTo(Long value) {
            addCriterion("pro_val_id <=", value, "proValId");
            return (Criteria) this;
        }

        public Criteria andProValIdIn(List<Long> values) {
            addCriterion("pro_val_id in", values, "proValId");
            return (Criteria) this;
        }

        public Criteria andProValIdNotIn(List<Long> values) {
            addCriterion("pro_val_id not in", values, "proValId");
            return (Criteria) this;
        }

        public Criteria andProValIdBetween(Long value1, Long value2) {
            addCriterion("pro_val_id between", value1, value2, "proValId");
            return (Criteria) this;
        }

        public Criteria andProValIdNotBetween(Long value1, Long value2) {
            addCriterion("pro_val_id not between", value1, value2, "proValId");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andTransDateIsNull() {
            addCriterion("trans_date is null");
            return (Criteria) this;
        }

        public Criteria andTransDateIsNotNull() {
            addCriterion("trans_date is not null");
            return (Criteria) this;
        }

        public Criteria andTransDateEqualTo(Date value) {
            addCriterionForJDBCDate("trans_date =", value, "transDate");
            return (Criteria) this;
        }

        public Criteria andTransDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("trans_date <>", value, "transDate");
            return (Criteria) this;
        }

        public Criteria andTransDateGreaterThan(Date value) {
            addCriterionForJDBCDate("trans_date >", value, "transDate");
            return (Criteria) this;
        }

        public Criteria andTransDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("trans_date >=", value, "transDate");
            return (Criteria) this;
        }

        public Criteria andTransDateLessThan(Date value) {
            addCriterionForJDBCDate("trans_date <", value, "transDate");
            return (Criteria) this;
        }

        public Criteria andTransDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("trans_date <=", value, "transDate");
            return (Criteria) this;
        }

        public Criteria andTransDateIn(List<Date> values) {
            addCriterionForJDBCDate("trans_date in", values, "transDate");
            return (Criteria) this;
        }

        public Criteria andTransDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("trans_date not in", values, "transDate");
            return (Criteria) this;
        }

        public Criteria andTransDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("trans_date between", value1, value2, "transDate");
            return (Criteria) this;
        }

        public Criteria andTransDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("trans_date not between", value1, value2, "transDate");
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

        public Criteria andM1IsNull() {
            addCriterion("m1 is null");
            return (Criteria) this;
        }

        public Criteria andM1IsNotNull() {
            addCriterion("m1 is not null");
            return (Criteria) this;
        }

        public Criteria andM1EqualTo(BigDecimal value) {
            addCriterion("m1 =", value, "m1");
            return (Criteria) this;
        }

        public Criteria andM1NotEqualTo(BigDecimal value) {
            addCriterion("m1 <>", value, "m1");
            return (Criteria) this;
        }

        public Criteria andM1GreaterThan(BigDecimal value) {
            addCriterion("m1 >", value, "m1");
            return (Criteria) this;
        }

        public Criteria andM1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("m1 >=", value, "m1");
            return (Criteria) this;
        }

        public Criteria andM1LessThan(BigDecimal value) {
            addCriterion("m1 <", value, "m1");
            return (Criteria) this;
        }

        public Criteria andM1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("m1 <=", value, "m1");
            return (Criteria) this;
        }

        public Criteria andM1In(List<BigDecimal> values) {
            addCriterion("m1 in", values, "m1");
            return (Criteria) this;
        }

        public Criteria andM1NotIn(List<BigDecimal> values) {
            addCriterion("m1 not in", values, "m1");
            return (Criteria) this;
        }

        public Criteria andM1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("m1 between", value1, value2, "m1");
            return (Criteria) this;
        }

        public Criteria andM1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("m1 not between", value1, value2, "m1");
            return (Criteria) this;
        }

        public Criteria andM2IsNull() {
            addCriterion("m2 is null");
            return (Criteria) this;
        }

        public Criteria andM2IsNotNull() {
            addCriterion("m2 is not null");
            return (Criteria) this;
        }

        public Criteria andM2EqualTo(BigDecimal value) {
            addCriterion("m2 =", value, "m2");
            return (Criteria) this;
        }

        public Criteria andM2NotEqualTo(BigDecimal value) {
            addCriterion("m2 <>", value, "m2");
            return (Criteria) this;
        }

        public Criteria andM2GreaterThan(BigDecimal value) {
            addCriterion("m2 >", value, "m2");
            return (Criteria) this;
        }

        public Criteria andM2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("m2 >=", value, "m2");
            return (Criteria) this;
        }

        public Criteria andM2LessThan(BigDecimal value) {
            addCriterion("m2 <", value, "m2");
            return (Criteria) this;
        }

        public Criteria andM2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("m2 <=", value, "m2");
            return (Criteria) this;
        }

        public Criteria andM2In(List<BigDecimal> values) {
            addCriterion("m2 in", values, "m2");
            return (Criteria) this;
        }

        public Criteria andM2NotIn(List<BigDecimal> values) {
            addCriterion("m2 not in", values, "m2");
            return (Criteria) this;
        }

        public Criteria andM2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("m2 between", value1, value2, "m2");
            return (Criteria) this;
        }

        public Criteria andM2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("m2 not between", value1, value2, "m2");
            return (Criteria) this;
        }

        public Criteria andM3IsNull() {
            addCriterion("m3 is null");
            return (Criteria) this;
        }

        public Criteria andM3IsNotNull() {
            addCriterion("m3 is not null");
            return (Criteria) this;
        }

        public Criteria andM3EqualTo(BigDecimal value) {
            addCriterion("m3 =", value, "m3");
            return (Criteria) this;
        }

        public Criteria andM3NotEqualTo(BigDecimal value) {
            addCriterion("m3 <>", value, "m3");
            return (Criteria) this;
        }

        public Criteria andM3GreaterThan(BigDecimal value) {
            addCriterion("m3 >", value, "m3");
            return (Criteria) this;
        }

        public Criteria andM3GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("m3 >=", value, "m3");
            return (Criteria) this;
        }

        public Criteria andM3LessThan(BigDecimal value) {
            addCriterion("m3 <", value, "m3");
            return (Criteria) this;
        }

        public Criteria andM3LessThanOrEqualTo(BigDecimal value) {
            addCriterion("m3 <=", value, "m3");
            return (Criteria) this;
        }

        public Criteria andM3In(List<BigDecimal> values) {
            addCriterion("m3 in", values, "m3");
            return (Criteria) this;
        }

        public Criteria andM3NotIn(List<BigDecimal> values) {
            addCriterion("m3 not in", values, "m3");
            return (Criteria) this;
        }

        public Criteria andM3Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("m3 between", value1, value2, "m3");
            return (Criteria) this;
        }

        public Criteria andM3NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("m3 not between", value1, value2, "m3");
            return (Criteria) this;
        }

        public Criteria andM4IsNull() {
            addCriterion("m4 is null");
            return (Criteria) this;
        }

        public Criteria andM4IsNotNull() {
            addCriterion("m4 is not null");
            return (Criteria) this;
        }

        public Criteria andM4EqualTo(BigDecimal value) {
            addCriterion("m4 =", value, "m4");
            return (Criteria) this;
        }

        public Criteria andM4NotEqualTo(BigDecimal value) {
            addCriterion("m4 <>", value, "m4");
            return (Criteria) this;
        }

        public Criteria andM4GreaterThan(BigDecimal value) {
            addCriterion("m4 >", value, "m4");
            return (Criteria) this;
        }

        public Criteria andM4GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("m4 >=", value, "m4");
            return (Criteria) this;
        }

        public Criteria andM4LessThan(BigDecimal value) {
            addCriterion("m4 <", value, "m4");
            return (Criteria) this;
        }

        public Criteria andM4LessThanOrEqualTo(BigDecimal value) {
            addCriterion("m4 <=", value, "m4");
            return (Criteria) this;
        }

        public Criteria andM4In(List<BigDecimal> values) {
            addCriterion("m4 in", values, "m4");
            return (Criteria) this;
        }

        public Criteria andM4NotIn(List<BigDecimal> values) {
            addCriterion("m4 not in", values, "m4");
            return (Criteria) this;
        }

        public Criteria andM4Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("m4 between", value1, value2, "m4");
            return (Criteria) this;
        }

        public Criteria andM4NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("m4 not between", value1, value2, "m4");
            return (Criteria) this;
        }

        public Criteria andJsonIsNull() {
            addCriterion("json is null");
            return (Criteria) this;
        }

        public Criteria andJsonIsNotNull() {
            addCriterion("json is not null");
            return (Criteria) this;
        }

        public Criteria andJsonEqualTo(String value) {
            addCriterion("json =", value, "json");
            return (Criteria) this;
        }

        public Criteria andJsonNotEqualTo(String value) {
            addCriterion("json <>", value, "json");
            return (Criteria) this;
        }

        public Criteria andJsonGreaterThan(String value) {
            addCriterion("json >", value, "json");
            return (Criteria) this;
        }

        public Criteria andJsonGreaterThanOrEqualTo(String value) {
            addCriterion("json >=", value, "json");
            return (Criteria) this;
        }

        public Criteria andJsonLessThan(String value) {
            addCriterion("json <", value, "json");
            return (Criteria) this;
        }

        public Criteria andJsonLessThanOrEqualTo(String value) {
            addCriterion("json <=", value, "json");
            return (Criteria) this;
        }

        public Criteria andJsonLike(String value) {
            addCriterion("json like", value, "json");
            return (Criteria) this;
        }

        public Criteria andJsonNotLike(String value) {
            addCriterion("json not like", value, "json");
            return (Criteria) this;
        }

        public Criteria andJsonIn(List<String> values) {
            addCriterion("json in", values, "json");
            return (Criteria) this;
        }

        public Criteria andJsonNotIn(List<String> values) {
            addCriterion("json not in", values, "json");
            return (Criteria) this;
        }

        public Criteria andJsonBetween(String value1, String value2) {
            addCriterion("json between", value1, value2, "json");
            return (Criteria) this;
        }

        public Criteria andJsonNotBetween(String value1, String value2) {
            addCriterion("json not between", value1, value2, "json");
            return (Criteria) this;
        }

        public Criteria andIsCompleteIsNull() {
            addCriterion("is_complete is null");
            return (Criteria) this;
        }

        public Criteria andIsCompleteIsNotNull() {
            addCriterion("is_complete is not null");
            return (Criteria) this;
        }

        public Criteria andIsCompleteEqualTo(Boolean value) {
            addCriterion("is_complete =", value, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteNotEqualTo(Boolean value) {
            addCriterion("is_complete <>", value, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteGreaterThan(Boolean value) {
            addCriterion("is_complete >", value, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_complete >=", value, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteLessThan(Boolean value) {
            addCriterion("is_complete <", value, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteLessThanOrEqualTo(Boolean value) {
            addCriterion("is_complete <=", value, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteIn(List<Boolean> values) {
            addCriterion("is_complete in", values, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteNotIn(List<Boolean> values) {
            addCriterion("is_complete not in", values, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteBetween(Boolean value1, Boolean value2) {
            addCriterion("is_complete between", value1, value2, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_complete not between", value1, value2, "isComplete");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterionForJDBCDate("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterionForJDBCDate("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterionForJDBCDate("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNull() {
            addCriterion("modify_date is null");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNotNull() {
            addCriterion("modify_date is not null");
            return (Criteria) this;
        }

        public Criteria andModifyDateEqualTo(Date value) {
            addCriterionForJDBCDate("modify_date =", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("modify_date <>", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThan(Date value) {
            addCriterionForJDBCDate("modify_date >", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("modify_date >=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThan(Date value) {
            addCriterionForJDBCDate("modify_date <", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("modify_date <=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateIn(List<Date> values) {
            addCriterionForJDBCDate("modify_date in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("modify_date not in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("modify_date between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("modify_date not between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andM1RatioIsNull() {
            addCriterion("m1_ratio is null");
            return (Criteria) this;
        }

        public Criteria andM1RatioIsNotNull() {
            addCriterion("m1_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andM1RatioEqualTo(BigDecimal value) {
            addCriterion("m1_ratio =", value, "m1Ratio");
            return (Criteria) this;
        }

        public Criteria andM1RatioNotEqualTo(BigDecimal value) {
            addCriterion("m1_ratio <>", value, "m1Ratio");
            return (Criteria) this;
        }

        public Criteria andM1RatioGreaterThan(BigDecimal value) {
            addCriterion("m1_ratio >", value, "m1Ratio");
            return (Criteria) this;
        }

        public Criteria andM1RatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("m1_ratio >=", value, "m1Ratio");
            return (Criteria) this;
        }

        public Criteria andM1RatioLessThan(BigDecimal value) {
            addCriterion("m1_ratio <", value, "m1Ratio");
            return (Criteria) this;
        }

        public Criteria andM1RatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("m1_ratio <=", value, "m1Ratio");
            return (Criteria) this;
        }

        public Criteria andM1RatioIn(List<BigDecimal> values) {
            addCriterion("m1_ratio in", values, "m1Ratio");
            return (Criteria) this;
        }

        public Criteria andM1RatioNotIn(List<BigDecimal> values) {
            addCriterion("m1_ratio not in", values, "m1Ratio");
            return (Criteria) this;
        }

        public Criteria andM1RatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("m1_ratio between", value1, value2, "m1Ratio");
            return (Criteria) this;
        }

        public Criteria andM1RatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("m1_ratio not between", value1, value2, "m1Ratio");
            return (Criteria) this;
        }

        public Criteria andM2RatioIsNull() {
            addCriterion("m2_ratio is null");
            return (Criteria) this;
        }

        public Criteria andM2RatioIsNotNull() {
            addCriterion("m2_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andM2RatioEqualTo(BigDecimal value) {
            addCriterion("m2_ratio =", value, "m2Ratio");
            return (Criteria) this;
        }

        public Criteria andM2RatioNotEqualTo(BigDecimal value) {
            addCriterion("m2_ratio <>", value, "m2Ratio");
            return (Criteria) this;
        }

        public Criteria andM2RatioGreaterThan(BigDecimal value) {
            addCriterion("m2_ratio >", value, "m2Ratio");
            return (Criteria) this;
        }

        public Criteria andM2RatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("m2_ratio >=", value, "m2Ratio");
            return (Criteria) this;
        }

        public Criteria andM2RatioLessThan(BigDecimal value) {
            addCriterion("m2_ratio <", value, "m2Ratio");
            return (Criteria) this;
        }

        public Criteria andM2RatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("m2_ratio <=", value, "m2Ratio");
            return (Criteria) this;
        }

        public Criteria andM2RatioIn(List<BigDecimal> values) {
            addCriterion("m2_ratio in", values, "m2Ratio");
            return (Criteria) this;
        }

        public Criteria andM2RatioNotIn(List<BigDecimal> values) {
            addCriterion("m2_ratio not in", values, "m2Ratio");
            return (Criteria) this;
        }

        public Criteria andM2RatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("m2_ratio between", value1, value2, "m2Ratio");
            return (Criteria) this;
        }

        public Criteria andM2RatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("m2_ratio not between", value1, value2, "m2Ratio");
            return (Criteria) this;
        }

        public Criteria andM3RatioIsNull() {
            addCriterion("m3_ratio is null");
            return (Criteria) this;
        }

        public Criteria andM3RatioIsNotNull() {
            addCriterion("m3_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andM3RatioEqualTo(BigDecimal value) {
            addCriterion("m3_ratio =", value, "m3Ratio");
            return (Criteria) this;
        }

        public Criteria andM3RatioNotEqualTo(BigDecimal value) {
            addCriterion("m3_ratio <>", value, "m3Ratio");
            return (Criteria) this;
        }

        public Criteria andM3RatioGreaterThan(BigDecimal value) {
            addCriterion("m3_ratio >", value, "m3Ratio");
            return (Criteria) this;
        }

        public Criteria andM3RatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("m3_ratio >=", value, "m3Ratio");
            return (Criteria) this;
        }

        public Criteria andM3RatioLessThan(BigDecimal value) {
            addCriterion("m3_ratio <", value, "m3Ratio");
            return (Criteria) this;
        }

        public Criteria andM3RatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("m3_ratio <=", value, "m3Ratio");
            return (Criteria) this;
        }

        public Criteria andM3RatioIn(List<BigDecimal> values) {
            addCriterion("m3_ratio in", values, "m3Ratio");
            return (Criteria) this;
        }

        public Criteria andM3RatioNotIn(List<BigDecimal> values) {
            addCriterion("m3_ratio not in", values, "m3Ratio");
            return (Criteria) this;
        }

        public Criteria andM3RatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("m3_ratio between", value1, value2, "m3Ratio");
            return (Criteria) this;
        }

        public Criteria andM3RatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("m3_ratio not between", value1, value2, "m3Ratio");
            return (Criteria) this;
        }

        public Criteria andM4RatioIsNull() {
            addCriterion("m4_ratio is null");
            return (Criteria) this;
        }

        public Criteria andM4RatioIsNotNull() {
            addCriterion("m4_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andM4RatioEqualTo(BigDecimal value) {
            addCriterion("m4_ratio =", value, "m4Ratio");
            return (Criteria) this;
        }

        public Criteria andM4RatioNotEqualTo(BigDecimal value) {
            addCriterion("m4_ratio <>", value, "m4Ratio");
            return (Criteria) this;
        }

        public Criteria andM4RatioGreaterThan(BigDecimal value) {
            addCriterion("m4_ratio >", value, "m4Ratio");
            return (Criteria) this;
        }

        public Criteria andM4RatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("m4_ratio >=", value, "m4Ratio");
            return (Criteria) this;
        }

        public Criteria andM4RatioLessThan(BigDecimal value) {
            addCriterion("m4_ratio <", value, "m4Ratio");
            return (Criteria) this;
        }

        public Criteria andM4RatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("m4_ratio <=", value, "m4Ratio");
            return (Criteria) this;
        }

        public Criteria andM4RatioIn(List<BigDecimal> values) {
            addCriterion("m4_ratio in", values, "m4Ratio");
            return (Criteria) this;
        }

        public Criteria andM4RatioNotIn(List<BigDecimal> values) {
            addCriterion("m4_ratio not in", values, "m4Ratio");
            return (Criteria) this;
        }

        public Criteria andM4RatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("m4_ratio between", value1, value2, "m4Ratio");
            return (Criteria) this;
        }

        public Criteria andM4RatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("m4_ratio not between", value1, value2, "m4Ratio");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(BigDecimal value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(BigDecimal value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(BigDecimal value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(BigDecimal value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<BigDecimal> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<BigDecimal> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andPriceCalIsNull() {
            addCriterion("price_cal is null");
            return (Criteria) this;
        }

        public Criteria andPriceCalIsNotNull() {
            addCriterion("price_cal is not null");
            return (Criteria) this;
        }

        public Criteria andPriceCalEqualTo(BigDecimal value) {
            addCriterion("price_cal =", value, "priceCal");
            return (Criteria) this;
        }

        public Criteria andPriceCalNotEqualTo(BigDecimal value) {
            addCriterion("price_cal <>", value, "priceCal");
            return (Criteria) this;
        }

        public Criteria andPriceCalGreaterThan(BigDecimal value) {
            addCriterion("price_cal >", value, "priceCal");
            return (Criteria) this;
        }

        public Criteria andPriceCalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price_cal >=", value, "priceCal");
            return (Criteria) this;
        }

        public Criteria andPriceCalLessThan(BigDecimal value) {
            addCriterion("price_cal <", value, "priceCal");
            return (Criteria) this;
        }

        public Criteria andPriceCalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price_cal <=", value, "priceCal");
            return (Criteria) this;
        }

        public Criteria andPriceCalIn(List<BigDecimal> values) {
            addCriterion("price_cal in", values, "priceCal");
            return (Criteria) this;
        }

        public Criteria andPriceCalNotIn(List<BigDecimal> values) {
            addCriterion("price_cal not in", values, "priceCal");
            return (Criteria) this;
        }

        public Criteria andPriceCalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_cal between", value1, value2, "priceCal");
            return (Criteria) this;
        }

        public Criteria andPriceCalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_cal not between", value1, value2, "priceCal");
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