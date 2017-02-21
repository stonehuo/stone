package com.kpap.basis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProValExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public ProValExample() {
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

        public Criteria andProGroupIsNull() {
            addCriterion("pro_group is null");
            return (Criteria) this;
        }

        public Criteria andProGroupIsNotNull() {
            addCriterion("pro_group is not null");
            return (Criteria) this;
        }

        public Criteria andProGroupEqualTo(String value) {
            addCriterion("pro_group =", value, "proGroup");
            return (Criteria) this;
        }

        public Criteria andProGroupNotEqualTo(String value) {
            addCriterion("pro_group <>", value, "proGroup");
            return (Criteria) this;
        }

        public Criteria andProGroupGreaterThan(String value) {
            addCriterion("pro_group >", value, "proGroup");
            return (Criteria) this;
        }

        public Criteria andProGroupGreaterThanOrEqualTo(String value) {
            addCriterion("pro_group >=", value, "proGroup");
            return (Criteria) this;
        }

        public Criteria andProGroupLessThan(String value) {
            addCriterion("pro_group <", value, "proGroup");
            return (Criteria) this;
        }

        public Criteria andProGroupLessThanOrEqualTo(String value) {
            addCriterion("pro_group <=", value, "proGroup");
            return (Criteria) this;
        }

        public Criteria andProGroupLike(String value) {
            addCriterion("pro_group like", value, "proGroup");
            return (Criteria) this;
        }

        public Criteria andProGroupNotLike(String value) {
            addCriterion("pro_group not like", value, "proGroup");
            return (Criteria) this;
        }

        public Criteria andProGroupIn(List<String> values) {
            addCriterion("pro_group in", values, "proGroup");
            return (Criteria) this;
        }

        public Criteria andProGroupNotIn(List<String> values) {
            addCriterion("pro_group not in", values, "proGroup");
            return (Criteria) this;
        }

        public Criteria andProGroupBetween(String value1, String value2) {
            addCriterion("pro_group between", value1, value2, "proGroup");
            return (Criteria) this;
        }

        public Criteria andProGroupNotBetween(String value1, String value2) {
            addCriterion("pro_group not between", value1, value2, "proGroup");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andValueIsNull() {
            addCriterion("value is null");
            return (Criteria) this;
        }

        public Criteria andValueIsNotNull() {
            addCriterion("value is not null");
            return (Criteria) this;
        }

        public Criteria andValueEqualTo(BigDecimal value) {
            addCriterion("value =", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotEqualTo(BigDecimal value) {
            addCriterion("value <>", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThan(BigDecimal value) {
            addCriterion("value >", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("value >=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThan(BigDecimal value) {
            addCriterion("value <", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("value <=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueIn(List<BigDecimal> values) {
            addCriterion("value in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotIn(List<BigDecimal> values) {
            addCriterion("value not in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("value between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("value not between", value1, value2, "value");
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
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
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

        public Criteria andJsonCostIsNull() {
            addCriterion("json_cost is null");
            return (Criteria) this;
        }

        public Criteria andJsonCostIsNotNull() {
            addCriterion("json_cost is not null");
            return (Criteria) this;
        }

        public Criteria andJsonCostEqualTo(String value) {
            addCriterion("json_cost =", value, "jsonCost");
            return (Criteria) this;
        }

        public Criteria andJsonCostNotEqualTo(String value) {
            addCriterion("json_cost <>", value, "jsonCost");
            return (Criteria) this;
        }

        public Criteria andJsonCostGreaterThan(String value) {
            addCriterion("json_cost >", value, "jsonCost");
            return (Criteria) this;
        }

        public Criteria andJsonCostGreaterThanOrEqualTo(String value) {
            addCriterion("json_cost >=", value, "jsonCost");
            return (Criteria) this;
        }

        public Criteria andJsonCostLessThan(String value) {
            addCriterion("json_cost <", value, "jsonCost");
            return (Criteria) this;
        }

        public Criteria andJsonCostLessThanOrEqualTo(String value) {
            addCriterion("json_cost <=", value, "jsonCost");
            return (Criteria) this;
        }

        public Criteria andJsonCostLike(String value) {
            addCriterion("json_cost like", value, "jsonCost");
            return (Criteria) this;
        }

        public Criteria andJsonCostNotLike(String value) {
            addCriterion("json_cost not like", value, "jsonCost");
            return (Criteria) this;
        }

        public Criteria andJsonCostIn(List<String> values) {
            addCriterion("json_cost in", values, "jsonCost");
            return (Criteria) this;
        }

        public Criteria andJsonCostNotIn(List<String> values) {
            addCriterion("json_cost not in", values, "jsonCost");
            return (Criteria) this;
        }

        public Criteria andJsonCostBetween(String value1, String value2) {
            addCriterion("json_cost between", value1, value2, "jsonCost");
            return (Criteria) this;
        }

        public Criteria andJsonCostNotBetween(String value1, String value2) {
            addCriterion("json_cost not between", value1, value2, "jsonCost");
            return (Criteria) this;
        }

        public Criteria andJsonMarketIsNull() {
            addCriterion("json_market is null");
            return (Criteria) this;
        }

        public Criteria andJsonMarketIsNotNull() {
            addCriterion("json_market is not null");
            return (Criteria) this;
        }

        public Criteria andJsonMarketEqualTo(String value) {
            addCriterion("json_market =", value, "jsonMarket");
            return (Criteria) this;
        }

        public Criteria andJsonMarketNotEqualTo(String value) {
            addCriterion("json_market <>", value, "jsonMarket");
            return (Criteria) this;
        }

        public Criteria andJsonMarketGreaterThan(String value) {
            addCriterion("json_market >", value, "jsonMarket");
            return (Criteria) this;
        }

        public Criteria andJsonMarketGreaterThanOrEqualTo(String value) {
            addCriterion("json_market >=", value, "jsonMarket");
            return (Criteria) this;
        }

        public Criteria andJsonMarketLessThan(String value) {
            addCriterion("json_market <", value, "jsonMarket");
            return (Criteria) this;
        }

        public Criteria andJsonMarketLessThanOrEqualTo(String value) {
            addCriterion("json_market <=", value, "jsonMarket");
            return (Criteria) this;
        }

        public Criteria andJsonMarketLike(String value) {
            addCriterion("json_market like", value, "jsonMarket");
            return (Criteria) this;
        }

        public Criteria andJsonMarketNotLike(String value) {
            addCriterion("json_market not like", value, "jsonMarket");
            return (Criteria) this;
        }

        public Criteria andJsonMarketIn(List<String> values) {
            addCriterion("json_market in", values, "jsonMarket");
            return (Criteria) this;
        }

        public Criteria andJsonMarketNotIn(List<String> values) {
            addCriterion("json_market not in", values, "jsonMarket");
            return (Criteria) this;
        }

        public Criteria andJsonMarketBetween(String value1, String value2) {
            addCriterion("json_market between", value1, value2, "jsonMarket");
            return (Criteria) this;
        }

        public Criteria andJsonMarketNotBetween(String value1, String value2) {
            addCriterion("json_market not between", value1, value2, "jsonMarket");
            return (Criteria) this;
        }

        public Criteria andJsonSeriesYearIsNull() {
            addCriterion("json_series_year is null");
            return (Criteria) this;
        }

        public Criteria andJsonSeriesYearIsNotNull() {
            addCriterion("json_series_year is not null");
            return (Criteria) this;
        }

        public Criteria andJsonSeriesYearEqualTo(String value) {
            addCriterion("json_series_year =", value, "jsonSeriesYear");
            return (Criteria) this;
        }

        public Criteria andJsonSeriesYearNotEqualTo(String value) {
            addCriterion("json_series_year <>", value, "jsonSeriesYear");
            return (Criteria) this;
        }

        public Criteria andJsonSeriesYearGreaterThan(String value) {
            addCriterion("json_series_year >", value, "jsonSeriesYear");
            return (Criteria) this;
        }

        public Criteria andJsonSeriesYearGreaterThanOrEqualTo(String value) {
            addCriterion("json_series_year >=", value, "jsonSeriesYear");
            return (Criteria) this;
        }

        public Criteria andJsonSeriesYearLessThan(String value) {
            addCriterion("json_series_year <", value, "jsonSeriesYear");
            return (Criteria) this;
        }

        public Criteria andJsonSeriesYearLessThanOrEqualTo(String value) {
            addCriterion("json_series_year <=", value, "jsonSeriesYear");
            return (Criteria) this;
        }

        public Criteria andJsonSeriesYearLike(String value) {
            addCriterion("json_series_year like", value, "jsonSeriesYear");
            return (Criteria) this;
        }

        public Criteria andJsonSeriesYearNotLike(String value) {
            addCriterion("json_series_year not like", value, "jsonSeriesYear");
            return (Criteria) this;
        }

        public Criteria andJsonSeriesYearIn(List<String> values) {
            addCriterion("json_series_year in", values, "jsonSeriesYear");
            return (Criteria) this;
        }

        public Criteria andJsonSeriesYearNotIn(List<String> values) {
            addCriterion("json_series_year not in", values, "jsonSeriesYear");
            return (Criteria) this;
        }

        public Criteria andJsonSeriesYearBetween(String value1, String value2) {
            addCriterion("json_series_year between", value1, value2, "jsonSeriesYear");
            return (Criteria) this;
        }

        public Criteria andJsonSeriesYearNotBetween(String value1, String value2) {
            addCriterion("json_series_year not between", value1, value2, "jsonSeriesYear");
            return (Criteria) this;
        }

        public Criteria andJsonShareRateIsNull() {
            addCriterion("json_share_rate is null");
            return (Criteria) this;
        }

        public Criteria andJsonShareRateIsNotNull() {
            addCriterion("json_share_rate is not null");
            return (Criteria) this;
        }

        public Criteria andJsonShareRateEqualTo(String value) {
            addCriterion("json_share_rate =", value, "jsonShareRate");
            return (Criteria) this;
        }

        public Criteria andJsonShareRateNotEqualTo(String value) {
            addCriterion("json_share_rate <>", value, "jsonShareRate");
            return (Criteria) this;
        }

        public Criteria andJsonShareRateGreaterThan(String value) {
            addCriterion("json_share_rate >", value, "jsonShareRate");
            return (Criteria) this;
        }

        public Criteria andJsonShareRateGreaterThanOrEqualTo(String value) {
            addCriterion("json_share_rate >=", value, "jsonShareRate");
            return (Criteria) this;
        }

        public Criteria andJsonShareRateLessThan(String value) {
            addCriterion("json_share_rate <", value, "jsonShareRate");
            return (Criteria) this;
        }

        public Criteria andJsonShareRateLessThanOrEqualTo(String value) {
            addCriterion("json_share_rate <=", value, "jsonShareRate");
            return (Criteria) this;
        }

        public Criteria andJsonShareRateLike(String value) {
            addCriterion("json_share_rate like", value, "jsonShareRate");
            return (Criteria) this;
        }

        public Criteria andJsonShareRateNotLike(String value) {
            addCriterion("json_share_rate not like", value, "jsonShareRate");
            return (Criteria) this;
        }

        public Criteria andJsonShareRateIn(List<String> values) {
            addCriterion("json_share_rate in", values, "jsonShareRate");
            return (Criteria) this;
        }

        public Criteria andJsonShareRateNotIn(List<String> values) {
            addCriterion("json_share_rate not in", values, "jsonShareRate");
            return (Criteria) this;
        }

        public Criteria andJsonShareRateBetween(String value1, String value2) {
            addCriterion("json_share_rate between", value1, value2, "jsonShareRate");
            return (Criteria) this;
        }

        public Criteria andJsonShareRateNotBetween(String value1, String value2) {
            addCriterion("json_share_rate not between", value1, value2, "jsonShareRate");
            return (Criteria) this;
        }

        public Criteria andJsonDiscountRateIsNull() {
            addCriterion("json_discount_rate is null");
            return (Criteria) this;
        }

        public Criteria andJsonDiscountRateIsNotNull() {
            addCriterion("json_discount_rate is not null");
            return (Criteria) this;
        }

        public Criteria andJsonDiscountRateEqualTo(String value) {
            addCriterion("json_discount_rate =", value, "jsonDiscountRate");
            return (Criteria) this;
        }

        public Criteria andJsonDiscountRateNotEqualTo(String value) {
            addCriterion("json_discount_rate <>", value, "jsonDiscountRate");
            return (Criteria) this;
        }

        public Criteria andJsonDiscountRateGreaterThan(String value) {
            addCriterion("json_discount_rate >", value, "jsonDiscountRate");
            return (Criteria) this;
        }

        public Criteria andJsonDiscountRateGreaterThanOrEqualTo(String value) {
            addCriterion("json_discount_rate >=", value, "jsonDiscountRate");
            return (Criteria) this;
        }

        public Criteria andJsonDiscountRateLessThan(String value) {
            addCriterion("json_discount_rate <", value, "jsonDiscountRate");
            return (Criteria) this;
        }

        public Criteria andJsonDiscountRateLessThanOrEqualTo(String value) {
            addCriterion("json_discount_rate <=", value, "jsonDiscountRate");
            return (Criteria) this;
        }

        public Criteria andJsonDiscountRateLike(String value) {
            addCriterion("json_discount_rate like", value, "jsonDiscountRate");
            return (Criteria) this;
        }

        public Criteria andJsonDiscountRateNotLike(String value) {
            addCriterion("json_discount_rate not like", value, "jsonDiscountRate");
            return (Criteria) this;
        }

        public Criteria andJsonDiscountRateIn(List<String> values) {
            addCriterion("json_discount_rate in", values, "jsonDiscountRate");
            return (Criteria) this;
        }

        public Criteria andJsonDiscountRateNotIn(List<String> values) {
            addCriterion("json_discount_rate not in", values, "jsonDiscountRate");
            return (Criteria) this;
        }

        public Criteria andJsonDiscountRateBetween(String value1, String value2) {
            addCriterion("json_discount_rate between", value1, value2, "jsonDiscountRate");
            return (Criteria) this;
        }

        public Criteria andJsonDiscountRateNotBetween(String value1, String value2) {
            addCriterion("json_discount_rate not between", value1, value2, "jsonDiscountRate");
            return (Criteria) this;
        }

        public Criteria andIncomeStepIsNull() {
            addCriterion("income_step is null");
            return (Criteria) this;
        }

        public Criteria andIncomeStepIsNotNull() {
            addCriterion("income_step is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeStepEqualTo(Short value) {
            addCriterion("income_step =", value, "incomeStep");
            return (Criteria) this;
        }

        public Criteria andIncomeStepNotEqualTo(Short value) {
            addCriterion("income_step <>", value, "incomeStep");
            return (Criteria) this;
        }

        public Criteria andIncomeStepGreaterThan(Short value) {
            addCriterion("income_step >", value, "incomeStep");
            return (Criteria) this;
        }

        public Criteria andIncomeStepGreaterThanOrEqualTo(Short value) {
            addCriterion("income_step >=", value, "incomeStep");
            return (Criteria) this;
        }

        public Criteria andIncomeStepLessThan(Short value) {
            addCriterion("income_step <", value, "incomeStep");
            return (Criteria) this;
        }

        public Criteria andIncomeStepLessThanOrEqualTo(Short value) {
            addCriterion("income_step <=", value, "incomeStep");
            return (Criteria) this;
        }

        public Criteria andIncomeStepIn(List<Short> values) {
            addCriterion("income_step in", values, "incomeStep");
            return (Criteria) this;
        }

        public Criteria andIncomeStepNotIn(List<Short> values) {
            addCriterion("income_step not in", values, "incomeStep");
            return (Criteria) this;
        }

        public Criteria andIncomeStepBetween(Short value1, Short value2) {
            addCriterion("income_step between", value1, value2, "incomeStep");
            return (Criteria) this;
        }

        public Criteria andIncomeStepNotBetween(Short value1, Short value2) {
            addCriterion("income_step not between", value1, value2, "incomeStep");
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