package com.kpap.basis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class IqRatiosExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public IqRatiosExample() {
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

        public Criteria andH37IsNull() {
            addCriterion("h37 is null");
            return (Criteria) this;
        }

        public Criteria andH37IsNotNull() {
            addCriterion("h37 is not null");
            return (Criteria) this;
        }

        public Criteria andH37EqualTo(BigDecimal value) {
            addCriterion("h37 =", value, "h37");
            return (Criteria) this;
        }

        public Criteria andH37NotEqualTo(BigDecimal value) {
            addCriterion("h37 <>", value, "h37");
            return (Criteria) this;
        }

        public Criteria andH37GreaterThan(BigDecimal value) {
            addCriterion("h37 >", value, "h37");
            return (Criteria) this;
        }

        public Criteria andH37GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("h37 >=", value, "h37");
            return (Criteria) this;
        }

        public Criteria andH37LessThan(BigDecimal value) {
            addCriterion("h37 <", value, "h37");
            return (Criteria) this;
        }

        public Criteria andH37LessThanOrEqualTo(BigDecimal value) {
            addCriterion("h37 <=", value, "h37");
            return (Criteria) this;
        }

        public Criteria andH37In(List<BigDecimal> values) {
            addCriterion("h37 in", values, "h37");
            return (Criteria) this;
        }

        public Criteria andH37NotIn(List<BigDecimal> values) {
            addCriterion("h37 not in", values, "h37");
            return (Criteria) this;
        }

        public Criteria andH37Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("h37 between", value1, value2, "h37");
            return (Criteria) this;
        }

        public Criteria andH37NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("h37 not between", value1, value2, "h37");
            return (Criteria) this;
        }

        public Criteria andG37IsNull() {
            addCriterion("g37 is null");
            return (Criteria) this;
        }

        public Criteria andG37IsNotNull() {
            addCriterion("g37 is not null");
            return (Criteria) this;
        }

        public Criteria andG37EqualTo(BigDecimal value) {
            addCriterion("g37 =", value, "g37");
            return (Criteria) this;
        }

        public Criteria andG37NotEqualTo(BigDecimal value) {
            addCriterion("g37 <>", value, "g37");
            return (Criteria) this;
        }

        public Criteria andG37GreaterThan(BigDecimal value) {
            addCriterion("g37 >", value, "g37");
            return (Criteria) this;
        }

        public Criteria andG37GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("g37 >=", value, "g37");
            return (Criteria) this;
        }

        public Criteria andG37LessThan(BigDecimal value) {
            addCriterion("g37 <", value, "g37");
            return (Criteria) this;
        }

        public Criteria andG37LessThanOrEqualTo(BigDecimal value) {
            addCriterion("g37 <=", value, "g37");
            return (Criteria) this;
        }

        public Criteria andG37In(List<BigDecimal> values) {
            addCriterion("g37 in", values, "g37");
            return (Criteria) this;
        }

        public Criteria andG37NotIn(List<BigDecimal> values) {
            addCriterion("g37 not in", values, "g37");
            return (Criteria) this;
        }

        public Criteria andG37Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("g37 between", value1, value2, "g37");
            return (Criteria) this;
        }

        public Criteria andG37NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("g37 not between", value1, value2, "g37");
            return (Criteria) this;
        }

        public Criteria andL37IsNull() {
            addCriterion("l37 is null");
            return (Criteria) this;
        }

        public Criteria andL37IsNotNull() {
            addCriterion("l37 is not null");
            return (Criteria) this;
        }

        public Criteria andL37EqualTo(BigDecimal value) {
            addCriterion("l37 =", value, "l37");
            return (Criteria) this;
        }

        public Criteria andL37NotEqualTo(BigDecimal value) {
            addCriterion("l37 <>", value, "l37");
            return (Criteria) this;
        }

        public Criteria andL37GreaterThan(BigDecimal value) {
            addCriterion("l37 >", value, "l37");
            return (Criteria) this;
        }

        public Criteria andL37GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("l37 >=", value, "l37");
            return (Criteria) this;
        }

        public Criteria andL37LessThan(BigDecimal value) {
            addCriterion("l37 <", value, "l37");
            return (Criteria) this;
        }

        public Criteria andL37LessThanOrEqualTo(BigDecimal value) {
            addCriterion("l37 <=", value, "l37");
            return (Criteria) this;
        }

        public Criteria andL37In(List<BigDecimal> values) {
            addCriterion("l37 in", values, "l37");
            return (Criteria) this;
        }

        public Criteria andL37NotIn(List<BigDecimal> values) {
            addCriterion("l37 not in", values, "l37");
            return (Criteria) this;
        }

        public Criteria andL37Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("l37 between", value1, value2, "l37");
            return (Criteria) this;
        }

        public Criteria andL37NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("l37 not between", value1, value2, "l37");
            return (Criteria) this;
        }

        public Criteria andM37IsNull() {
            addCriterion("m37 is null");
            return (Criteria) this;
        }

        public Criteria andM37IsNotNull() {
            addCriterion("m37 is not null");
            return (Criteria) this;
        }

        public Criteria andM37EqualTo(BigDecimal value) {
            addCriterion("m37 =", value, "m37");
            return (Criteria) this;
        }

        public Criteria andM37NotEqualTo(BigDecimal value) {
            addCriterion("m37 <>", value, "m37");
            return (Criteria) this;
        }

        public Criteria andM37GreaterThan(BigDecimal value) {
            addCriterion("m37 >", value, "m37");
            return (Criteria) this;
        }

        public Criteria andM37GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("m37 >=", value, "m37");
            return (Criteria) this;
        }

        public Criteria andM37LessThan(BigDecimal value) {
            addCriterion("m37 <", value, "m37");
            return (Criteria) this;
        }

        public Criteria andM37LessThanOrEqualTo(BigDecimal value) {
            addCriterion("m37 <=", value, "m37");
            return (Criteria) this;
        }

        public Criteria andM37In(List<BigDecimal> values) {
            addCriterion("m37 in", values, "m37");
            return (Criteria) this;
        }

        public Criteria andM37NotIn(List<BigDecimal> values) {
            addCriterion("m37 not in", values, "m37");
            return (Criteria) this;
        }

        public Criteria andM37Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("m37 between", value1, value2, "m37");
            return (Criteria) this;
        }

        public Criteria andM37NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("m37 not between", value1, value2, "m37");
            return (Criteria) this;
        }

        public Criteria andH53IsNull() {
            addCriterion("h53 is null");
            return (Criteria) this;
        }

        public Criteria andH53IsNotNull() {
            addCriterion("h53 is not null");
            return (Criteria) this;
        }

        public Criteria andH53EqualTo(BigDecimal value) {
            addCriterion("h53 =", value, "h53");
            return (Criteria) this;
        }

        public Criteria andH53NotEqualTo(BigDecimal value) {
            addCriterion("h53 <>", value, "h53");
            return (Criteria) this;
        }

        public Criteria andH53GreaterThan(BigDecimal value) {
            addCriterion("h53 >", value, "h53");
            return (Criteria) this;
        }

        public Criteria andH53GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("h53 >=", value, "h53");
            return (Criteria) this;
        }

        public Criteria andH53LessThan(BigDecimal value) {
            addCriterion("h53 <", value, "h53");
            return (Criteria) this;
        }

        public Criteria andH53LessThanOrEqualTo(BigDecimal value) {
            addCriterion("h53 <=", value, "h53");
            return (Criteria) this;
        }

        public Criteria andH53In(List<BigDecimal> values) {
            addCriterion("h53 in", values, "h53");
            return (Criteria) this;
        }

        public Criteria andH53NotIn(List<BigDecimal> values) {
            addCriterion("h53 not in", values, "h53");
            return (Criteria) this;
        }

        public Criteria andH53Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("h53 between", value1, value2, "h53");
            return (Criteria) this;
        }

        public Criteria andH53NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("h53 not between", value1, value2, "h53");
            return (Criteria) this;
        }

        public Criteria andG53IsNull() {
            addCriterion("g53 is null");
            return (Criteria) this;
        }

        public Criteria andG53IsNotNull() {
            addCriterion("g53 is not null");
            return (Criteria) this;
        }

        public Criteria andG53EqualTo(BigDecimal value) {
            addCriterion("g53 =", value, "g53");
            return (Criteria) this;
        }

        public Criteria andG53NotEqualTo(BigDecimal value) {
            addCriterion("g53 <>", value, "g53");
            return (Criteria) this;
        }

        public Criteria andG53GreaterThan(BigDecimal value) {
            addCriterion("g53 >", value, "g53");
            return (Criteria) this;
        }

        public Criteria andG53GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("g53 >=", value, "g53");
            return (Criteria) this;
        }

        public Criteria andG53LessThan(BigDecimal value) {
            addCriterion("g53 <", value, "g53");
            return (Criteria) this;
        }

        public Criteria andG53LessThanOrEqualTo(BigDecimal value) {
            addCriterion("g53 <=", value, "g53");
            return (Criteria) this;
        }

        public Criteria andG53In(List<BigDecimal> values) {
            addCriterion("g53 in", values, "g53");
            return (Criteria) this;
        }

        public Criteria andG53NotIn(List<BigDecimal> values) {
            addCriterion("g53 not in", values, "g53");
            return (Criteria) this;
        }

        public Criteria andG53Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("g53 between", value1, value2, "g53");
            return (Criteria) this;
        }

        public Criteria andG53NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("g53 not between", value1, value2, "g53");
            return (Criteria) this;
        }

        public Criteria andL53IsNull() {
            addCriterion("l53 is null");
            return (Criteria) this;
        }

        public Criteria andL53IsNotNull() {
            addCriterion("l53 is not null");
            return (Criteria) this;
        }

        public Criteria andL53EqualTo(BigDecimal value) {
            addCriterion("l53 =", value, "l53");
            return (Criteria) this;
        }

        public Criteria andL53NotEqualTo(BigDecimal value) {
            addCriterion("l53 <>", value, "l53");
            return (Criteria) this;
        }

        public Criteria andL53GreaterThan(BigDecimal value) {
            addCriterion("l53 >", value, "l53");
            return (Criteria) this;
        }

        public Criteria andL53GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("l53 >=", value, "l53");
            return (Criteria) this;
        }

        public Criteria andL53LessThan(BigDecimal value) {
            addCriterion("l53 <", value, "l53");
            return (Criteria) this;
        }

        public Criteria andL53LessThanOrEqualTo(BigDecimal value) {
            addCriterion("l53 <=", value, "l53");
            return (Criteria) this;
        }

        public Criteria andL53In(List<BigDecimal> values) {
            addCriterion("l53 in", values, "l53");
            return (Criteria) this;
        }

        public Criteria andL53NotIn(List<BigDecimal> values) {
            addCriterion("l53 not in", values, "l53");
            return (Criteria) this;
        }

        public Criteria andL53Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("l53 between", value1, value2, "l53");
            return (Criteria) this;
        }

        public Criteria andL53NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("l53 not between", value1, value2, "l53");
            return (Criteria) this;
        }

        public Criteria andM53IsNull() {
            addCriterion("m53 is null");
            return (Criteria) this;
        }

        public Criteria andM53IsNotNull() {
            addCriterion("m53 is not null");
            return (Criteria) this;
        }

        public Criteria andM53EqualTo(BigDecimal value) {
            addCriterion("m53 =", value, "m53");
            return (Criteria) this;
        }

        public Criteria andM53NotEqualTo(BigDecimal value) {
            addCriterion("m53 <>", value, "m53");
            return (Criteria) this;
        }

        public Criteria andM53GreaterThan(BigDecimal value) {
            addCriterion("m53 >", value, "m53");
            return (Criteria) this;
        }

        public Criteria andM53GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("m53 >=", value, "m53");
            return (Criteria) this;
        }

        public Criteria andM53LessThan(BigDecimal value) {
            addCriterion("m53 <", value, "m53");
            return (Criteria) this;
        }

        public Criteria andM53LessThanOrEqualTo(BigDecimal value) {
            addCriterion("m53 <=", value, "m53");
            return (Criteria) this;
        }

        public Criteria andM53In(List<BigDecimal> values) {
            addCriterion("m53 in", values, "m53");
            return (Criteria) this;
        }

        public Criteria andM53NotIn(List<BigDecimal> values) {
            addCriterion("m53 not in", values, "m53");
            return (Criteria) this;
        }

        public Criteria andM53Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("m53 between", value1, value2, "m53");
            return (Criteria) this;
        }

        public Criteria andM53NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("m53 not between", value1, value2, "m53");
            return (Criteria) this;
        }

        public Criteria andJsonAveCollectIsNull() {
            addCriterion("json_ave_collect is null");
            return (Criteria) this;
        }

        public Criteria andJsonAveCollectIsNotNull() {
            addCriterion("json_ave_collect is not null");
            return (Criteria) this;
        }

        public Criteria andJsonAveCollectEqualTo(String value) {
            addCriterion("json_ave_collect =", value, "jsonAveCollect");
            return (Criteria) this;
        }

        public Criteria andJsonAveCollectNotEqualTo(String value) {
            addCriterion("json_ave_collect <>", value, "jsonAveCollect");
            return (Criteria) this;
        }

        public Criteria andJsonAveCollectGreaterThan(String value) {
            addCriterion("json_ave_collect >", value, "jsonAveCollect");
            return (Criteria) this;
        }

        public Criteria andJsonAveCollectGreaterThanOrEqualTo(String value) {
            addCriterion("json_ave_collect >=", value, "jsonAveCollect");
            return (Criteria) this;
        }

        public Criteria andJsonAveCollectLessThan(String value) {
            addCriterion("json_ave_collect <", value, "jsonAveCollect");
            return (Criteria) this;
        }

        public Criteria andJsonAveCollectLessThanOrEqualTo(String value) {
            addCriterion("json_ave_collect <=", value, "jsonAveCollect");
            return (Criteria) this;
        }

        public Criteria andJsonAveCollectLike(String value) {
            addCriterion("json_ave_collect like", value, "jsonAveCollect");
            return (Criteria) this;
        }

        public Criteria andJsonAveCollectNotLike(String value) {
            addCriterion("json_ave_collect not like", value, "jsonAveCollect");
            return (Criteria) this;
        }

        public Criteria andJsonAveCollectIn(List<String> values) {
            addCriterion("json_ave_collect in", values, "jsonAveCollect");
            return (Criteria) this;
        }

        public Criteria andJsonAveCollectNotIn(List<String> values) {
            addCriterion("json_ave_collect not in", values, "jsonAveCollect");
            return (Criteria) this;
        }

        public Criteria andJsonAveCollectBetween(String value1, String value2) {
            addCriterion("json_ave_collect between", value1, value2, "jsonAveCollect");
            return (Criteria) this;
        }

        public Criteria andJsonAveCollectNotBetween(String value1, String value2) {
            addCriterion("json_ave_collect not between", value1, value2, "jsonAveCollect");
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