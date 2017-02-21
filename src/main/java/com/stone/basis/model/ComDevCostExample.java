package com.kpap.basis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ComDevCostExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public ComDevCostExample() {
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

        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterionForJDBCDate("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterionForJDBCDate("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andCycleIsNull() {
            addCriterion("cycle is null");
            return (Criteria) this;
        }

        public Criteria andCycleIsNotNull() {
            addCriterion("cycle is not null");
            return (Criteria) this;
        }

        public Criteria andCycleEqualTo(BigDecimal value) {
            addCriterion("cycle =", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleNotEqualTo(BigDecimal value) {
            addCriterion("cycle <>", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleGreaterThan(BigDecimal value) {
            addCriterion("cycle >", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cycle >=", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleLessThan(BigDecimal value) {
            addCriterion("cycle <", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cycle <=", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleIn(List<BigDecimal> values) {
            addCriterion("cycle in", values, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleNotIn(List<BigDecimal> values) {
            addCriterion("cycle not in", values, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cycle between", value1, value2, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cycle not between", value1, value2, "cycle");
            return (Criteria) this;
        }

        public Criteria andE23IsNull() {
            addCriterion("e23 is null");
            return (Criteria) this;
        }

        public Criteria andE23IsNotNull() {
            addCriterion("e23 is not null");
            return (Criteria) this;
        }

        public Criteria andE23EqualTo(BigDecimal value) {
            addCriterion("e23 =", value, "e23");
            return (Criteria) this;
        }

        public Criteria andE23NotEqualTo(BigDecimal value) {
            addCriterion("e23 <>", value, "e23");
            return (Criteria) this;
        }

        public Criteria andE23GreaterThan(BigDecimal value) {
            addCriterion("e23 >", value, "e23");
            return (Criteria) this;
        }

        public Criteria andE23GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("e23 >=", value, "e23");
            return (Criteria) this;
        }

        public Criteria andE23LessThan(BigDecimal value) {
            addCriterion("e23 <", value, "e23");
            return (Criteria) this;
        }

        public Criteria andE23LessThanOrEqualTo(BigDecimal value) {
            addCriterion("e23 <=", value, "e23");
            return (Criteria) this;
        }

        public Criteria andE23In(List<BigDecimal> values) {
            addCriterion("e23 in", values, "e23");
            return (Criteria) this;
        }

        public Criteria andE23NotIn(List<BigDecimal> values) {
            addCriterion("e23 not in", values, "e23");
            return (Criteria) this;
        }

        public Criteria andE23Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("e23 between", value1, value2, "e23");
            return (Criteria) this;
        }

        public Criteria andE23NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("e23 not between", value1, value2, "e23");
            return (Criteria) this;
        }

        public Criteria andF23IsNull() {
            addCriterion("f23 is null");
            return (Criteria) this;
        }

        public Criteria andF23IsNotNull() {
            addCriterion("f23 is not null");
            return (Criteria) this;
        }

        public Criteria andF23EqualTo(BigDecimal value) {
            addCriterion("f23 =", value, "f23");
            return (Criteria) this;
        }

        public Criteria andF23NotEqualTo(BigDecimal value) {
            addCriterion("f23 <>", value, "f23");
            return (Criteria) this;
        }

        public Criteria andF23GreaterThan(BigDecimal value) {
            addCriterion("f23 >", value, "f23");
            return (Criteria) this;
        }

        public Criteria andF23GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("f23 >=", value, "f23");
            return (Criteria) this;
        }

        public Criteria andF23LessThan(BigDecimal value) {
            addCriterion("f23 <", value, "f23");
            return (Criteria) this;
        }

        public Criteria andF23LessThanOrEqualTo(BigDecimal value) {
            addCriterion("f23 <=", value, "f23");
            return (Criteria) this;
        }

        public Criteria andF23In(List<BigDecimal> values) {
            addCriterion("f23 in", values, "f23");
            return (Criteria) this;
        }

        public Criteria andF23NotIn(List<BigDecimal> values) {
            addCriterion("f23 not in", values, "f23");
            return (Criteria) this;
        }

        public Criteria andF23Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("f23 between", value1, value2, "f23");
            return (Criteria) this;
        }

        public Criteria andF23NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("f23 not between", value1, value2, "f23");
            return (Criteria) this;
        }

        public Criteria andC25IsNull() {
            addCriterion("c25 is null");
            return (Criteria) this;
        }

        public Criteria andC25IsNotNull() {
            addCriterion("c25 is not null");
            return (Criteria) this;
        }

        public Criteria andC25EqualTo(BigDecimal value) {
            addCriterion("c25 =", value, "c25");
            return (Criteria) this;
        }

        public Criteria andC25NotEqualTo(BigDecimal value) {
            addCriterion("c25 <>", value, "c25");
            return (Criteria) this;
        }

        public Criteria andC25GreaterThan(BigDecimal value) {
            addCriterion("c25 >", value, "c25");
            return (Criteria) this;
        }

        public Criteria andC25GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("c25 >=", value, "c25");
            return (Criteria) this;
        }

        public Criteria andC25LessThan(BigDecimal value) {
            addCriterion("c25 <", value, "c25");
            return (Criteria) this;
        }

        public Criteria andC25LessThanOrEqualTo(BigDecimal value) {
            addCriterion("c25 <=", value, "c25");
            return (Criteria) this;
        }

        public Criteria andC25In(List<BigDecimal> values) {
            addCriterion("c25 in", values, "c25");
            return (Criteria) this;
        }

        public Criteria andC25NotIn(List<BigDecimal> values) {
            addCriterion("c25 not in", values, "c25");
            return (Criteria) this;
        }

        public Criteria andC25Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("c25 between", value1, value2, "c25");
            return (Criteria) this;
        }

        public Criteria andC25NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("c25 not between", value1, value2, "c25");
            return (Criteria) this;
        }

        public Criteria andC28IsNull() {
            addCriterion("c28 is null");
            return (Criteria) this;
        }

        public Criteria andC28IsNotNull() {
            addCriterion("c28 is not null");
            return (Criteria) this;
        }

        public Criteria andC28EqualTo(BigDecimal value) {
            addCriterion("c28 =", value, "c28");
            return (Criteria) this;
        }

        public Criteria andC28NotEqualTo(BigDecimal value) {
            addCriterion("c28 <>", value, "c28");
            return (Criteria) this;
        }

        public Criteria andC28GreaterThan(BigDecimal value) {
            addCriterion("c28 >", value, "c28");
            return (Criteria) this;
        }

        public Criteria andC28GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("c28 >=", value, "c28");
            return (Criteria) this;
        }

        public Criteria andC28LessThan(BigDecimal value) {
            addCriterion("c28 <", value, "c28");
            return (Criteria) this;
        }

        public Criteria andC28LessThanOrEqualTo(BigDecimal value) {
            addCriterion("c28 <=", value, "c28");
            return (Criteria) this;
        }

        public Criteria andC28In(List<BigDecimal> values) {
            addCriterion("c28 in", values, "c28");
            return (Criteria) this;
        }

        public Criteria andC28NotIn(List<BigDecimal> values) {
            addCriterion("c28 not in", values, "c28");
            return (Criteria) this;
        }

        public Criteria andC28Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("c28 between", value1, value2, "c28");
            return (Criteria) this;
        }

        public Criteria andC28NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("c28 not between", value1, value2, "c28");
            return (Criteria) this;
        }

        public Criteria andC29IsNull() {
            addCriterion("c29 is null");
            return (Criteria) this;
        }

        public Criteria andC29IsNotNull() {
            addCriterion("c29 is not null");
            return (Criteria) this;
        }

        public Criteria andC29EqualTo(BigDecimal value) {
            addCriterion("c29 =", value, "c29");
            return (Criteria) this;
        }

        public Criteria andC29NotEqualTo(BigDecimal value) {
            addCriterion("c29 <>", value, "c29");
            return (Criteria) this;
        }

        public Criteria andC29GreaterThan(BigDecimal value) {
            addCriterion("c29 >", value, "c29");
            return (Criteria) this;
        }

        public Criteria andC29GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("c29 >=", value, "c29");
            return (Criteria) this;
        }

        public Criteria andC29LessThan(BigDecimal value) {
            addCriterion("c29 <", value, "c29");
            return (Criteria) this;
        }

        public Criteria andC29LessThanOrEqualTo(BigDecimal value) {
            addCriterion("c29 <=", value, "c29");
            return (Criteria) this;
        }

        public Criteria andC29In(List<BigDecimal> values) {
            addCriterion("c29 in", values, "c29");
            return (Criteria) this;
        }

        public Criteria andC29NotIn(List<BigDecimal> values) {
            addCriterion("c29 not in", values, "c29");
            return (Criteria) this;
        }

        public Criteria andC29Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("c29 between", value1, value2, "c29");
            return (Criteria) this;
        }

        public Criteria andC29NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("c29 not between", value1, value2, "c29");
            return (Criteria) this;
        }

        public Criteria andC30IsNull() {
            addCriterion("c30 is null");
            return (Criteria) this;
        }

        public Criteria andC30IsNotNull() {
            addCriterion("c30 is not null");
            return (Criteria) this;
        }

        public Criteria andC30EqualTo(BigDecimal value) {
            addCriterion("c30 =", value, "c30");
            return (Criteria) this;
        }

        public Criteria andC30NotEqualTo(BigDecimal value) {
            addCriterion("c30 <>", value, "c30");
            return (Criteria) this;
        }

        public Criteria andC30GreaterThan(BigDecimal value) {
            addCriterion("c30 >", value, "c30");
            return (Criteria) this;
        }

        public Criteria andC30GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("c30 >=", value, "c30");
            return (Criteria) this;
        }

        public Criteria andC30LessThan(BigDecimal value) {
            addCriterion("c30 <", value, "c30");
            return (Criteria) this;
        }

        public Criteria andC30LessThanOrEqualTo(BigDecimal value) {
            addCriterion("c30 <=", value, "c30");
            return (Criteria) this;
        }

        public Criteria andC30In(List<BigDecimal> values) {
            addCriterion("c30 in", values, "c30");
            return (Criteria) this;
        }

        public Criteria andC30NotIn(List<BigDecimal> values) {
            addCriterion("c30 not in", values, "c30");
            return (Criteria) this;
        }

        public Criteria andC30Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("c30 between", value1, value2, "c30");
            return (Criteria) this;
        }

        public Criteria andC30NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("c30 not between", value1, value2, "c30");
            return (Criteria) this;
        }

        public Criteria andC31IsNull() {
            addCriterion("c31 is null");
            return (Criteria) this;
        }

        public Criteria andC31IsNotNull() {
            addCriterion("c31 is not null");
            return (Criteria) this;
        }

        public Criteria andC31EqualTo(BigDecimal value) {
            addCriterion("c31 =", value, "c31");
            return (Criteria) this;
        }

        public Criteria andC31NotEqualTo(BigDecimal value) {
            addCriterion("c31 <>", value, "c31");
            return (Criteria) this;
        }

        public Criteria andC31GreaterThan(BigDecimal value) {
            addCriterion("c31 >", value, "c31");
            return (Criteria) this;
        }

        public Criteria andC31GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("c31 >=", value, "c31");
            return (Criteria) this;
        }

        public Criteria andC31LessThan(BigDecimal value) {
            addCriterion("c31 <", value, "c31");
            return (Criteria) this;
        }

        public Criteria andC31LessThanOrEqualTo(BigDecimal value) {
            addCriterion("c31 <=", value, "c31");
            return (Criteria) this;
        }

        public Criteria andC31In(List<BigDecimal> values) {
            addCriterion("c31 in", values, "c31");
            return (Criteria) this;
        }

        public Criteria andC31NotIn(List<BigDecimal> values) {
            addCriterion("c31 not in", values, "c31");
            return (Criteria) this;
        }

        public Criteria andC31Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("c31 between", value1, value2, "c31");
            return (Criteria) this;
        }

        public Criteria andC31NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("c31 not between", value1, value2, "c31");
            return (Criteria) this;
        }

        public Criteria andC32IsNull() {
            addCriterion("c32 is null");
            return (Criteria) this;
        }

        public Criteria andC32IsNotNull() {
            addCriterion("c32 is not null");
            return (Criteria) this;
        }

        public Criteria andC32EqualTo(BigDecimal value) {
            addCriterion("c32 =", value, "c32");
            return (Criteria) this;
        }

        public Criteria andC32NotEqualTo(BigDecimal value) {
            addCriterion("c32 <>", value, "c32");
            return (Criteria) this;
        }

        public Criteria andC32GreaterThan(BigDecimal value) {
            addCriterion("c32 >", value, "c32");
            return (Criteria) this;
        }

        public Criteria andC32GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("c32 >=", value, "c32");
            return (Criteria) this;
        }

        public Criteria andC32LessThan(BigDecimal value) {
            addCriterion("c32 <", value, "c32");
            return (Criteria) this;
        }

        public Criteria andC32LessThanOrEqualTo(BigDecimal value) {
            addCriterion("c32 <=", value, "c32");
            return (Criteria) this;
        }

        public Criteria andC32In(List<BigDecimal> values) {
            addCriterion("c32 in", values, "c32");
            return (Criteria) this;
        }

        public Criteria andC32NotIn(List<BigDecimal> values) {
            addCriterion("c32 not in", values, "c32");
            return (Criteria) this;
        }

        public Criteria andC32Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("c32 between", value1, value2, "c32");
            return (Criteria) this;
        }

        public Criteria andC32NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("c32 not between", value1, value2, "c32");
            return (Criteria) this;
        }

        public Criteria andC33IsNull() {
            addCriterion("c33 is null");
            return (Criteria) this;
        }

        public Criteria andC33IsNotNull() {
            addCriterion("c33 is not null");
            return (Criteria) this;
        }

        public Criteria andC33EqualTo(BigDecimal value) {
            addCriterion("c33 =", value, "c33");
            return (Criteria) this;
        }

        public Criteria andC33NotEqualTo(BigDecimal value) {
            addCriterion("c33 <>", value, "c33");
            return (Criteria) this;
        }

        public Criteria andC33GreaterThan(BigDecimal value) {
            addCriterion("c33 >", value, "c33");
            return (Criteria) this;
        }

        public Criteria andC33GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("c33 >=", value, "c33");
            return (Criteria) this;
        }

        public Criteria andC33LessThan(BigDecimal value) {
            addCriterion("c33 <", value, "c33");
            return (Criteria) this;
        }

        public Criteria andC33LessThanOrEqualTo(BigDecimal value) {
            addCriterion("c33 <=", value, "c33");
            return (Criteria) this;
        }

        public Criteria andC33In(List<BigDecimal> values) {
            addCriterion("c33 in", values, "c33");
            return (Criteria) this;
        }

        public Criteria andC33NotIn(List<BigDecimal> values) {
            addCriterion("c33 not in", values, "c33");
            return (Criteria) this;
        }

        public Criteria andC33Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("c33 between", value1, value2, "c33");
            return (Criteria) this;
        }

        public Criteria andC33NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("c33 not between", value1, value2, "c33");
            return (Criteria) this;
        }

        public Criteria andC34IsNull() {
            addCriterion("c34 is null");
            return (Criteria) this;
        }

        public Criteria andC34IsNotNull() {
            addCriterion("c34 is not null");
            return (Criteria) this;
        }

        public Criteria andC34EqualTo(BigDecimal value) {
            addCriterion("c34 =", value, "c34");
            return (Criteria) this;
        }

        public Criteria andC34NotEqualTo(BigDecimal value) {
            addCriterion("c34 <>", value, "c34");
            return (Criteria) this;
        }

        public Criteria andC34GreaterThan(BigDecimal value) {
            addCriterion("c34 >", value, "c34");
            return (Criteria) this;
        }

        public Criteria andC34GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("c34 >=", value, "c34");
            return (Criteria) this;
        }

        public Criteria andC34LessThan(BigDecimal value) {
            addCriterion("c34 <", value, "c34");
            return (Criteria) this;
        }

        public Criteria andC34LessThanOrEqualTo(BigDecimal value) {
            addCriterion("c34 <=", value, "c34");
            return (Criteria) this;
        }

        public Criteria andC34In(List<BigDecimal> values) {
            addCriterion("c34 in", values, "c34");
            return (Criteria) this;
        }

        public Criteria andC34NotIn(List<BigDecimal> values) {
            addCriterion("c34 not in", values, "c34");
            return (Criteria) this;
        }

        public Criteria andC34Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("c34 between", value1, value2, "c34");
            return (Criteria) this;
        }

        public Criteria andC34NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("c34 not between", value1, value2, "c34");
            return (Criteria) this;
        }

        public Criteria andC35IsNull() {
            addCriterion("c35 is null");
            return (Criteria) this;
        }

        public Criteria andC35IsNotNull() {
            addCriterion("c35 is not null");
            return (Criteria) this;
        }

        public Criteria andC35EqualTo(BigDecimal value) {
            addCriterion("c35 =", value, "c35");
            return (Criteria) this;
        }

        public Criteria andC35NotEqualTo(BigDecimal value) {
            addCriterion("c35 <>", value, "c35");
            return (Criteria) this;
        }

        public Criteria andC35GreaterThan(BigDecimal value) {
            addCriterion("c35 >", value, "c35");
            return (Criteria) this;
        }

        public Criteria andC35GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("c35 >=", value, "c35");
            return (Criteria) this;
        }

        public Criteria andC35LessThan(BigDecimal value) {
            addCriterion("c35 <", value, "c35");
            return (Criteria) this;
        }

        public Criteria andC35LessThanOrEqualTo(BigDecimal value) {
            addCriterion("c35 <=", value, "c35");
            return (Criteria) this;
        }

        public Criteria andC35In(List<BigDecimal> values) {
            addCriterion("c35 in", values, "c35");
            return (Criteria) this;
        }

        public Criteria andC35NotIn(List<BigDecimal> values) {
            addCriterion("c35 not in", values, "c35");
            return (Criteria) this;
        }

        public Criteria andC35Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("c35 between", value1, value2, "c35");
            return (Criteria) this;
        }

        public Criteria andC35NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("c35 not between", value1, value2, "c35");
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