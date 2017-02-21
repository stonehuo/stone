package com.kpap.basis.model;

import java.util.ArrayList;
import java.util.List;

public class IqInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public IqInfoExample() {
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

        public Criteria andJsonIncomeIsNull() {
            addCriterion("json_income is null");
            return (Criteria) this;
        }

        public Criteria andJsonIncomeIsNotNull() {
            addCriterion("json_income is not null");
            return (Criteria) this;
        }

        public Criteria andJsonIncomeEqualTo(String value) {
            addCriterion("json_income =", value, "jsonIncome");
            return (Criteria) this;
        }

        public Criteria andJsonIncomeNotEqualTo(String value) {
            addCriterion("json_income <>", value, "jsonIncome");
            return (Criteria) this;
        }

        public Criteria andJsonIncomeGreaterThan(String value) {
            addCriterion("json_income >", value, "jsonIncome");
            return (Criteria) this;
        }

        public Criteria andJsonIncomeGreaterThanOrEqualTo(String value) {
            addCriterion("json_income >=", value, "jsonIncome");
            return (Criteria) this;
        }

        public Criteria andJsonIncomeLessThan(String value) {
            addCriterion("json_income <", value, "jsonIncome");
            return (Criteria) this;
        }

        public Criteria andJsonIncomeLessThanOrEqualTo(String value) {
            addCriterion("json_income <=", value, "jsonIncome");
            return (Criteria) this;
        }

        public Criteria andJsonIncomeLike(String value) {
            addCriterion("json_income like", value, "jsonIncome");
            return (Criteria) this;
        }

        public Criteria andJsonIncomeNotLike(String value) {
            addCriterion("json_income not like", value, "jsonIncome");
            return (Criteria) this;
        }

        public Criteria andJsonIncomeIn(List<String> values) {
            addCriterion("json_income in", values, "jsonIncome");
            return (Criteria) this;
        }

        public Criteria andJsonIncomeNotIn(List<String> values) {
            addCriterion("json_income not in", values, "jsonIncome");
            return (Criteria) this;
        }

        public Criteria andJsonIncomeBetween(String value1, String value2) {
            addCriterion("json_income between", value1, value2, "jsonIncome");
            return (Criteria) this;
        }

        public Criteria andJsonIncomeNotBetween(String value1, String value2) {
            addCriterion("json_income not between", value1, value2, "jsonIncome");
            return (Criteria) this;
        }

        public Criteria andJsonIncomeAveIsNull() {
            addCriterion("json_income_ave is null");
            return (Criteria) this;
        }

        public Criteria andJsonIncomeAveIsNotNull() {
            addCriterion("json_income_ave is not null");
            return (Criteria) this;
        }

        public Criteria andJsonIncomeAveEqualTo(String value) {
            addCriterion("json_income_ave =", value, "jsonIncomeAve");
            return (Criteria) this;
        }

        public Criteria andJsonIncomeAveNotEqualTo(String value) {
            addCriterion("json_income_ave <>", value, "jsonIncomeAve");
            return (Criteria) this;
        }

        public Criteria andJsonIncomeAveGreaterThan(String value) {
            addCriterion("json_income_ave >", value, "jsonIncomeAve");
            return (Criteria) this;
        }

        public Criteria andJsonIncomeAveGreaterThanOrEqualTo(String value) {
            addCriterion("json_income_ave >=", value, "jsonIncomeAve");
            return (Criteria) this;
        }

        public Criteria andJsonIncomeAveLessThan(String value) {
            addCriterion("json_income_ave <", value, "jsonIncomeAve");
            return (Criteria) this;
        }

        public Criteria andJsonIncomeAveLessThanOrEqualTo(String value) {
            addCriterion("json_income_ave <=", value, "jsonIncomeAve");
            return (Criteria) this;
        }

        public Criteria andJsonIncomeAveLike(String value) {
            addCriterion("json_income_ave like", value, "jsonIncomeAve");
            return (Criteria) this;
        }

        public Criteria andJsonIncomeAveNotLike(String value) {
            addCriterion("json_income_ave not like", value, "jsonIncomeAve");
            return (Criteria) this;
        }

        public Criteria andJsonIncomeAveIn(List<String> values) {
            addCriterion("json_income_ave in", values, "jsonIncomeAve");
            return (Criteria) this;
        }

        public Criteria andJsonIncomeAveNotIn(List<String> values) {
            addCriterion("json_income_ave not in", values, "jsonIncomeAve");
            return (Criteria) this;
        }

        public Criteria andJsonIncomeAveBetween(String value1, String value2) {
            addCriterion("json_income_ave between", value1, value2, "jsonIncomeAve");
            return (Criteria) this;
        }

        public Criteria andJsonIncomeAveNotBetween(String value1, String value2) {
            addCriterion("json_income_ave not between", value1, value2, "jsonIncomeAve");
            return (Criteria) this;
        }

        public Criteria andJsonGrowthRateIsNull() {
            addCriterion("json_growth_rate is null");
            return (Criteria) this;
        }

        public Criteria andJsonGrowthRateIsNotNull() {
            addCriterion("json_growth_rate is not null");
            return (Criteria) this;
        }

        public Criteria andJsonGrowthRateEqualTo(String value) {
            addCriterion("json_growth_rate =", value, "jsonGrowthRate");
            return (Criteria) this;
        }

        public Criteria andJsonGrowthRateNotEqualTo(String value) {
            addCriterion("json_growth_rate <>", value, "jsonGrowthRate");
            return (Criteria) this;
        }

        public Criteria andJsonGrowthRateGreaterThan(String value) {
            addCriterion("json_growth_rate >", value, "jsonGrowthRate");
            return (Criteria) this;
        }

        public Criteria andJsonGrowthRateGreaterThanOrEqualTo(String value) {
            addCriterion("json_growth_rate >=", value, "jsonGrowthRate");
            return (Criteria) this;
        }

        public Criteria andJsonGrowthRateLessThan(String value) {
            addCriterion("json_growth_rate <", value, "jsonGrowthRate");
            return (Criteria) this;
        }

        public Criteria andJsonGrowthRateLessThanOrEqualTo(String value) {
            addCriterion("json_growth_rate <=", value, "jsonGrowthRate");
            return (Criteria) this;
        }

        public Criteria andJsonGrowthRateLike(String value) {
            addCriterion("json_growth_rate like", value, "jsonGrowthRate");
            return (Criteria) this;
        }

        public Criteria andJsonGrowthRateNotLike(String value) {
            addCriterion("json_growth_rate not like", value, "jsonGrowthRate");
            return (Criteria) this;
        }

        public Criteria andJsonGrowthRateIn(List<String> values) {
            addCriterion("json_growth_rate in", values, "jsonGrowthRate");
            return (Criteria) this;
        }

        public Criteria andJsonGrowthRateNotIn(List<String> values) {
            addCriterion("json_growth_rate not in", values, "jsonGrowthRate");
            return (Criteria) this;
        }

        public Criteria andJsonGrowthRateBetween(String value1, String value2) {
            addCriterion("json_growth_rate between", value1, value2, "jsonGrowthRate");
            return (Criteria) this;
        }

        public Criteria andJsonGrowthRateNotBetween(String value1, String value2) {
            addCriterion("json_growth_rate not between", value1, value2, "jsonGrowthRate");
            return (Criteria) this;
        }

        public Criteria andJsonGrowthRateAveIsNull() {
            addCriterion("json_growth_rate_ave is null");
            return (Criteria) this;
        }

        public Criteria andJsonGrowthRateAveIsNotNull() {
            addCriterion("json_growth_rate_ave is not null");
            return (Criteria) this;
        }

        public Criteria andJsonGrowthRateAveEqualTo(String value) {
            addCriterion("json_growth_rate_ave =", value, "jsonGrowthRateAve");
            return (Criteria) this;
        }

        public Criteria andJsonGrowthRateAveNotEqualTo(String value) {
            addCriterion("json_growth_rate_ave <>", value, "jsonGrowthRateAve");
            return (Criteria) this;
        }

        public Criteria andJsonGrowthRateAveGreaterThan(String value) {
            addCriterion("json_growth_rate_ave >", value, "jsonGrowthRateAve");
            return (Criteria) this;
        }

        public Criteria andJsonGrowthRateAveGreaterThanOrEqualTo(String value) {
            addCriterion("json_growth_rate_ave >=", value, "jsonGrowthRateAve");
            return (Criteria) this;
        }

        public Criteria andJsonGrowthRateAveLessThan(String value) {
            addCriterion("json_growth_rate_ave <", value, "jsonGrowthRateAve");
            return (Criteria) this;
        }

        public Criteria andJsonGrowthRateAveLessThanOrEqualTo(String value) {
            addCriterion("json_growth_rate_ave <=", value, "jsonGrowthRateAve");
            return (Criteria) this;
        }

        public Criteria andJsonGrowthRateAveLike(String value) {
            addCriterion("json_growth_rate_ave like", value, "jsonGrowthRateAve");
            return (Criteria) this;
        }

        public Criteria andJsonGrowthRateAveNotLike(String value) {
            addCriterion("json_growth_rate_ave not like", value, "jsonGrowthRateAve");
            return (Criteria) this;
        }

        public Criteria andJsonGrowthRateAveIn(List<String> values) {
            addCriterion("json_growth_rate_ave in", values, "jsonGrowthRateAve");
            return (Criteria) this;
        }

        public Criteria andJsonGrowthRateAveNotIn(List<String> values) {
            addCriterion("json_growth_rate_ave not in", values, "jsonGrowthRateAve");
            return (Criteria) this;
        }

        public Criteria andJsonGrowthRateAveBetween(String value1, String value2) {
            addCriterion("json_growth_rate_ave between", value1, value2, "jsonGrowthRateAve");
            return (Criteria) this;
        }

        public Criteria andJsonGrowthRateAveNotBetween(String value1, String value2) {
            addCriterion("json_growth_rate_ave not between", value1, value2, "jsonGrowthRateAve");
            return (Criteria) this;
        }

        public Criteria andJsonRatiosIsNull() {
            addCriterion("json_ratios is null");
            return (Criteria) this;
        }

        public Criteria andJsonRatiosIsNotNull() {
            addCriterion("json_ratios is not null");
            return (Criteria) this;
        }

        public Criteria andJsonRatiosEqualTo(String value) {
            addCriterion("json_ratios =", value, "jsonRatios");
            return (Criteria) this;
        }

        public Criteria andJsonRatiosNotEqualTo(String value) {
            addCriterion("json_ratios <>", value, "jsonRatios");
            return (Criteria) this;
        }

        public Criteria andJsonRatiosGreaterThan(String value) {
            addCriterion("json_ratios >", value, "jsonRatios");
            return (Criteria) this;
        }

        public Criteria andJsonRatiosGreaterThanOrEqualTo(String value) {
            addCriterion("json_ratios >=", value, "jsonRatios");
            return (Criteria) this;
        }

        public Criteria andJsonRatiosLessThan(String value) {
            addCriterion("json_ratios <", value, "jsonRatios");
            return (Criteria) this;
        }

        public Criteria andJsonRatiosLessThanOrEqualTo(String value) {
            addCriterion("json_ratios <=", value, "jsonRatios");
            return (Criteria) this;
        }

        public Criteria andJsonRatiosLike(String value) {
            addCriterion("json_ratios like", value, "jsonRatios");
            return (Criteria) this;
        }

        public Criteria andJsonRatiosNotLike(String value) {
            addCriterion("json_ratios not like", value, "jsonRatios");
            return (Criteria) this;
        }

        public Criteria andJsonRatiosIn(List<String> values) {
            addCriterion("json_ratios in", values, "jsonRatios");
            return (Criteria) this;
        }

        public Criteria andJsonRatiosNotIn(List<String> values) {
            addCriterion("json_ratios not in", values, "jsonRatios");
            return (Criteria) this;
        }

        public Criteria andJsonRatiosBetween(String value1, String value2) {
            addCriterion("json_ratios between", value1, value2, "jsonRatios");
            return (Criteria) this;
        }

        public Criteria andJsonRatiosNotBetween(String value1, String value2) {
            addCriterion("json_ratios not between", value1, value2, "jsonRatios");
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