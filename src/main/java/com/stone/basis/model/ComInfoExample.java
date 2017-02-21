package com.kpap.basis.model;

import java.util.ArrayList;
import java.util.List;

public class ComInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public ComInfoExample() {
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

        public Criteria andJsonBalanceIsNull() {
            addCriterion("json_balance is null");
            return (Criteria) this;
        }

        public Criteria andJsonBalanceIsNotNull() {
            addCriterion("json_balance is not null");
            return (Criteria) this;
        }

        public Criteria andJsonBalanceEqualTo(String value) {
            addCriterion("json_balance =", value, "jsonBalance");
            return (Criteria) this;
        }

        public Criteria andJsonBalanceNotEqualTo(String value) {
            addCriterion("json_balance <>", value, "jsonBalance");
            return (Criteria) this;
        }

        public Criteria andJsonBalanceGreaterThan(String value) {
            addCriterion("json_balance >", value, "jsonBalance");
            return (Criteria) this;
        }

        public Criteria andJsonBalanceGreaterThanOrEqualTo(String value) {
            addCriterion("json_balance >=", value, "jsonBalance");
            return (Criteria) this;
        }

        public Criteria andJsonBalanceLessThan(String value) {
            addCriterion("json_balance <", value, "jsonBalance");
            return (Criteria) this;
        }

        public Criteria andJsonBalanceLessThanOrEqualTo(String value) {
            addCriterion("json_balance <=", value, "jsonBalance");
            return (Criteria) this;
        }

        public Criteria andJsonBalanceLike(String value) {
            addCriterion("json_balance like", value, "jsonBalance");
            return (Criteria) this;
        }

        public Criteria andJsonBalanceNotLike(String value) {
            addCriterion("json_balance not like", value, "jsonBalance");
            return (Criteria) this;
        }

        public Criteria andJsonBalanceIn(List<String> values) {
            addCriterion("json_balance in", values, "jsonBalance");
            return (Criteria) this;
        }

        public Criteria andJsonBalanceNotIn(List<String> values) {
            addCriterion("json_balance not in", values, "jsonBalance");
            return (Criteria) this;
        }

        public Criteria andJsonBalanceBetween(String value1, String value2) {
            addCriterion("json_balance between", value1, value2, "jsonBalance");
            return (Criteria) this;
        }

        public Criteria andJsonBalanceNotBetween(String value1, String value2) {
            addCriterion("json_balance not between", value1, value2, "jsonBalance");
            return (Criteria) this;
        }

        public Criteria andJsonProfitIsNull() {
            addCriterion("\"json_ profit\" is null");
            return (Criteria) this;
        }

        public Criteria andJsonProfitIsNotNull() {
            addCriterion("\"json_ profit\" is not null");
            return (Criteria) this;
        }

        public Criteria andJsonProfitEqualTo(String value) {
            addCriterion("\"json_ profit\" =", value, "jsonProfit");
            return (Criteria) this;
        }

        public Criteria andJsonProfitNotEqualTo(String value) {
            addCriterion("\"json_ profit\" <>", value, "jsonProfit");
            return (Criteria) this;
        }

        public Criteria andJsonProfitGreaterThan(String value) {
            addCriterion("\"json_ profit\" >", value, "jsonProfit");
            return (Criteria) this;
        }

        public Criteria andJsonProfitGreaterThanOrEqualTo(String value) {
            addCriterion("\"json_ profit\" >=", value, "jsonProfit");
            return (Criteria) this;
        }

        public Criteria andJsonProfitLessThan(String value) {
            addCriterion("\"json_ profit\" <", value, "jsonProfit");
            return (Criteria) this;
        }

        public Criteria andJsonProfitLessThanOrEqualTo(String value) {
            addCriterion("\"json_ profit\" <=", value, "jsonProfit");
            return (Criteria) this;
        }

        public Criteria andJsonProfitLike(String value) {
            addCriterion("\"json_ profit\" like", value, "jsonProfit");
            return (Criteria) this;
        }

        public Criteria andJsonProfitNotLike(String value) {
            addCriterion("\"json_ profit\" not like", value, "jsonProfit");
            return (Criteria) this;
        }

        public Criteria andJsonProfitIn(List<String> values) {
            addCriterion("\"json_ profit\" in", values, "jsonProfit");
            return (Criteria) this;
        }

        public Criteria andJsonProfitNotIn(List<String> values) {
            addCriterion("\"json_ profit\" not in", values, "jsonProfit");
            return (Criteria) this;
        }

        public Criteria andJsonProfitBetween(String value1, String value2) {
            addCriterion("\"json_ profit\" between", value1, value2, "jsonProfit");
            return (Criteria) this;
        }

        public Criteria andJsonProfitNotBetween(String value1, String value2) {
            addCriterion("\"json_ profit\" not between", value1, value2, "jsonProfit");
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

        public Criteria andJsonRatiosGrowthAveIsNull() {
            addCriterion("json_ratios_growth_ave is null");
            return (Criteria) this;
        }

        public Criteria andJsonRatiosGrowthAveIsNotNull() {
            addCriterion("json_ratios_growth_ave is not null");
            return (Criteria) this;
        }

        public Criteria andJsonRatiosGrowthAveEqualTo(String value) {
            addCriterion("json_ratios_growth_ave =", value, "jsonRatiosGrowthAve");
            return (Criteria) this;
        }

        public Criteria andJsonRatiosGrowthAveNotEqualTo(String value) {
            addCriterion("json_ratios_growth_ave <>", value, "jsonRatiosGrowthAve");
            return (Criteria) this;
        }

        public Criteria andJsonRatiosGrowthAveGreaterThan(String value) {
            addCriterion("json_ratios_growth_ave >", value, "jsonRatiosGrowthAve");
            return (Criteria) this;
        }

        public Criteria andJsonRatiosGrowthAveGreaterThanOrEqualTo(String value) {
            addCriterion("json_ratios_growth_ave >=", value, "jsonRatiosGrowthAve");
            return (Criteria) this;
        }

        public Criteria andJsonRatiosGrowthAveLessThan(String value) {
            addCriterion("json_ratios_growth_ave <", value, "jsonRatiosGrowthAve");
            return (Criteria) this;
        }

        public Criteria andJsonRatiosGrowthAveLessThanOrEqualTo(String value) {
            addCriterion("json_ratios_growth_ave <=", value, "jsonRatiosGrowthAve");
            return (Criteria) this;
        }

        public Criteria andJsonRatiosGrowthAveLike(String value) {
            addCriterion("json_ratios_growth_ave like", value, "jsonRatiosGrowthAve");
            return (Criteria) this;
        }

        public Criteria andJsonRatiosGrowthAveNotLike(String value) {
            addCriterion("json_ratios_growth_ave not like", value, "jsonRatiosGrowthAve");
            return (Criteria) this;
        }

        public Criteria andJsonRatiosGrowthAveIn(List<String> values) {
            addCriterion("json_ratios_growth_ave in", values, "jsonRatiosGrowthAve");
            return (Criteria) this;
        }

        public Criteria andJsonRatiosGrowthAveNotIn(List<String> values) {
            addCriterion("json_ratios_growth_ave not in", values, "jsonRatiosGrowthAve");
            return (Criteria) this;
        }

        public Criteria andJsonRatiosGrowthAveBetween(String value1, String value2) {
            addCriterion("json_ratios_growth_ave between", value1, value2, "jsonRatiosGrowthAve");
            return (Criteria) this;
        }

        public Criteria andJsonRatiosGrowthAveNotBetween(String value1, String value2) {
            addCriterion("json_ratios_growth_ave not between", value1, value2, "jsonRatiosGrowthAve");
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