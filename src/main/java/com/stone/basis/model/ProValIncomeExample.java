package com.kpap.basis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProValIncomeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public ProValIncomeExample() {
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

        public Criteria andNextYearIsNull() {
            addCriterion("next_year is null");
            return (Criteria) this;
        }

        public Criteria andNextYearIsNotNull() {
            addCriterion("next_year is not null");
            return (Criteria) this;
        }

        public Criteria andNextYearEqualTo(Integer value) {
            addCriterion("next_year =", value, "nextYear");
            return (Criteria) this;
        }

        public Criteria andNextYearNotEqualTo(Integer value) {
            addCriterion("next_year <>", value, "nextYear");
            return (Criteria) this;
        }

        public Criteria andNextYearGreaterThan(Integer value) {
            addCriterion("next_year >", value, "nextYear");
            return (Criteria) this;
        }

        public Criteria andNextYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("next_year >=", value, "nextYear");
            return (Criteria) this;
        }

        public Criteria andNextYearLessThan(Integer value) {
            addCriterion("next_year <", value, "nextYear");
            return (Criteria) this;
        }

        public Criteria andNextYearLessThanOrEqualTo(Integer value) {
            addCriterion("next_year <=", value, "nextYear");
            return (Criteria) this;
        }

        public Criteria andNextYearIn(List<Integer> values) {
            addCriterion("next_year in", values, "nextYear");
            return (Criteria) this;
        }

        public Criteria andNextYearNotIn(List<Integer> values) {
            addCriterion("next_year not in", values, "nextYear");
            return (Criteria) this;
        }

        public Criteria andNextYearBetween(Integer value1, Integer value2) {
            addCriterion("next_year between", value1, value2, "nextYear");
            return (Criteria) this;
        }

        public Criteria andNextYearNotBetween(Integer value1, Integer value2) {
            addCriterion("next_year not between", value1, value2, "nextYear");
            return (Criteria) this;
        }

        public Criteria andNexYearDescIsNull() {
            addCriterion("nex_year_desc is null");
            return (Criteria) this;
        }

        public Criteria andNexYearDescIsNotNull() {
            addCriterion("nex_year_desc is not null");
            return (Criteria) this;
        }

        public Criteria andNexYearDescEqualTo(String value) {
            addCriterion("nex_year_desc =", value, "nexYearDesc");
            return (Criteria) this;
        }

        public Criteria andNexYearDescNotEqualTo(String value) {
            addCriterion("nex_year_desc <>", value, "nexYearDesc");
            return (Criteria) this;
        }

        public Criteria andNexYearDescGreaterThan(String value) {
            addCriterion("nex_year_desc >", value, "nexYearDesc");
            return (Criteria) this;
        }

        public Criteria andNexYearDescGreaterThanOrEqualTo(String value) {
            addCriterion("nex_year_desc >=", value, "nexYearDesc");
            return (Criteria) this;
        }

        public Criteria andNexYearDescLessThan(String value) {
            addCriterion("nex_year_desc <", value, "nexYearDesc");
            return (Criteria) this;
        }

        public Criteria andNexYearDescLessThanOrEqualTo(String value) {
            addCriterion("nex_year_desc <=", value, "nexYearDesc");
            return (Criteria) this;
        }

        public Criteria andNexYearDescLike(String value) {
            addCriterion("nex_year_desc like", value, "nexYearDesc");
            return (Criteria) this;
        }

        public Criteria andNexYearDescNotLike(String value) {
            addCriterion("nex_year_desc not like", value, "nexYearDesc");
            return (Criteria) this;
        }

        public Criteria andNexYearDescIn(List<String> values) {
            addCriterion("nex_year_desc in", values, "nexYearDesc");
            return (Criteria) this;
        }

        public Criteria andNexYearDescNotIn(List<String> values) {
            addCriterion("nex_year_desc not in", values, "nexYearDesc");
            return (Criteria) this;
        }

        public Criteria andNexYearDescBetween(String value1, String value2) {
            addCriterion("nex_year_desc between", value1, value2, "nexYearDesc");
            return (Criteria) this;
        }

        public Criteria andNexYearDescNotBetween(String value1, String value2) {
            addCriterion("nex_year_desc not between", value1, value2, "nexYearDesc");
            return (Criteria) this;
        }

        public Criteria andIncomeIsNull() {
            addCriterion("income is null");
            return (Criteria) this;
        }

        public Criteria andIncomeIsNotNull() {
            addCriterion("income is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeEqualTo(BigDecimal value) {
            addCriterion("income =", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotEqualTo(BigDecimal value) {
            addCriterion("income <>", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThan(BigDecimal value) {
            addCriterion("income >", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("income >=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThan(BigDecimal value) {
            addCriterion("income <", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("income <=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeIn(List<BigDecimal> values) {
            addCriterion("income in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotIn(List<BigDecimal> values) {
            addCriterion("income not in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("income between", value1, value2, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("income not between", value1, value2, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeCalIsNull() {
            addCriterion("income_cal is null");
            return (Criteria) this;
        }

        public Criteria andIncomeCalIsNotNull() {
            addCriterion("income_cal is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeCalEqualTo(BigDecimal value) {
            addCriterion("income_cal =", value, "incomeCal");
            return (Criteria) this;
        }

        public Criteria andIncomeCalNotEqualTo(BigDecimal value) {
            addCriterion("income_cal <>", value, "incomeCal");
            return (Criteria) this;
        }

        public Criteria andIncomeCalGreaterThan(BigDecimal value) {
            addCriterion("income_cal >", value, "incomeCal");
            return (Criteria) this;
        }

        public Criteria andIncomeCalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("income_cal >=", value, "incomeCal");
            return (Criteria) this;
        }

        public Criteria andIncomeCalLessThan(BigDecimal value) {
            addCriterion("income_cal <", value, "incomeCal");
            return (Criteria) this;
        }

        public Criteria andIncomeCalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("income_cal <=", value, "incomeCal");
            return (Criteria) this;
        }

        public Criteria andIncomeCalIn(List<BigDecimal> values) {
            addCriterion("income_cal in", values, "incomeCal");
            return (Criteria) this;
        }

        public Criteria andIncomeCalNotIn(List<BigDecimal> values) {
            addCriterion("income_cal not in", values, "incomeCal");
            return (Criteria) this;
        }

        public Criteria andIncomeCalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("income_cal between", value1, value2, "incomeCal");
            return (Criteria) this;
        }

        public Criteria andIncomeCalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("income_cal not between", value1, value2, "incomeCal");
            return (Criteria) this;
        }

        public Criteria andTaxRateIsNull() {
            addCriterion("tax_rate is null");
            return (Criteria) this;
        }

        public Criteria andTaxRateIsNotNull() {
            addCriterion("tax_rate is not null");
            return (Criteria) this;
        }

        public Criteria andTaxRateEqualTo(BigDecimal value) {
            addCriterion("tax_rate =", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateNotEqualTo(BigDecimal value) {
            addCriterion("tax_rate <>", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateGreaterThan(BigDecimal value) {
            addCriterion("tax_rate >", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_rate >=", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateLessThan(BigDecimal value) {
            addCriterion("tax_rate <", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_rate <=", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateIn(List<BigDecimal> values) {
            addCriterion("tax_rate in", values, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateNotIn(List<BigDecimal> values) {
            addCriterion("tax_rate not in", values, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_rate between", value1, value2, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_rate not between", value1, value2, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxIsNull() {
            addCriterion("tax is null");
            return (Criteria) this;
        }

        public Criteria andTaxIsNotNull() {
            addCriterion("tax is not null");
            return (Criteria) this;
        }

        public Criteria andTaxEqualTo(BigDecimal value) {
            addCriterion("tax =", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxNotEqualTo(BigDecimal value) {
            addCriterion("tax <>", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxGreaterThan(BigDecimal value) {
            addCriterion("tax >", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax >=", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxLessThan(BigDecimal value) {
            addCriterion("tax <", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax <=", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxIn(List<BigDecimal> values) {
            addCriterion("tax in", values, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxNotIn(List<BigDecimal> values) {
            addCriterion("tax not in", values, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax between", value1, value2, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax not between", value1, value2, "tax");
            return (Criteria) this;
        }

        public Criteria andShareRateIsNull() {
            addCriterion("share_rate is null");
            return (Criteria) this;
        }

        public Criteria andShareRateIsNotNull() {
            addCriterion("share_rate is not null");
            return (Criteria) this;
        }

        public Criteria andShareRateEqualTo(BigDecimal value) {
            addCriterion("share_rate =", value, "shareRate");
            return (Criteria) this;
        }

        public Criteria andShareRateNotEqualTo(BigDecimal value) {
            addCriterion("share_rate <>", value, "shareRate");
            return (Criteria) this;
        }

        public Criteria andShareRateGreaterThan(BigDecimal value) {
            addCriterion("share_rate >", value, "shareRate");
            return (Criteria) this;
        }

        public Criteria andShareRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("share_rate >=", value, "shareRate");
            return (Criteria) this;
        }

        public Criteria andShareRateLessThan(BigDecimal value) {
            addCriterion("share_rate <", value, "shareRate");
            return (Criteria) this;
        }

        public Criteria andShareRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("share_rate <=", value, "shareRate");
            return (Criteria) this;
        }

        public Criteria andShareRateIn(List<BigDecimal> values) {
            addCriterion("share_rate in", values, "shareRate");
            return (Criteria) this;
        }

        public Criteria andShareRateNotIn(List<BigDecimal> values) {
            addCriterion("share_rate not in", values, "shareRate");
            return (Criteria) this;
        }

        public Criteria andShareRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("share_rate between", value1, value2, "shareRate");
            return (Criteria) this;
        }

        public Criteria andShareRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("share_rate not between", value1, value2, "shareRate");
            return (Criteria) this;
        }

        public Criteria andShareDeclineRateIsNull() {
            addCriterion("share_decline_rate is null");
            return (Criteria) this;
        }

        public Criteria andShareDeclineRateIsNotNull() {
            addCriterion("share_decline_rate is not null");
            return (Criteria) this;
        }

        public Criteria andShareDeclineRateEqualTo(BigDecimal value) {
            addCriterion("share_decline_rate =", value, "shareDeclineRate");
            return (Criteria) this;
        }

        public Criteria andShareDeclineRateNotEqualTo(BigDecimal value) {
            addCriterion("share_decline_rate <>", value, "shareDeclineRate");
            return (Criteria) this;
        }

        public Criteria andShareDeclineRateGreaterThan(BigDecimal value) {
            addCriterion("share_decline_rate >", value, "shareDeclineRate");
            return (Criteria) this;
        }

        public Criteria andShareDeclineRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("share_decline_rate >=", value, "shareDeclineRate");
            return (Criteria) this;
        }

        public Criteria andShareDeclineRateLessThan(BigDecimal value) {
            addCriterion("share_decline_rate <", value, "shareDeclineRate");
            return (Criteria) this;
        }

        public Criteria andShareDeclineRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("share_decline_rate <=", value, "shareDeclineRate");
            return (Criteria) this;
        }

        public Criteria andShareDeclineRateIn(List<BigDecimal> values) {
            addCriterion("share_decline_rate in", values, "shareDeclineRate");
            return (Criteria) this;
        }

        public Criteria andShareDeclineRateNotIn(List<BigDecimal> values) {
            addCriterion("share_decline_rate not in", values, "shareDeclineRate");
            return (Criteria) this;
        }

        public Criteria andShareDeclineRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("share_decline_rate between", value1, value2, "shareDeclineRate");
            return (Criteria) this;
        }

        public Criteria andShareDeclineRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("share_decline_rate not between", value1, value2, "shareDeclineRate");
            return (Criteria) this;
        }

        public Criteria andShareRateCalIsNull() {
            addCriterion("share_rate_cal is null");
            return (Criteria) this;
        }

        public Criteria andShareRateCalIsNotNull() {
            addCriterion("share_rate_cal is not null");
            return (Criteria) this;
        }

        public Criteria andShareRateCalEqualTo(BigDecimal value) {
            addCriterion("share_rate_cal =", value, "shareRateCal");
            return (Criteria) this;
        }

        public Criteria andShareRateCalNotEqualTo(BigDecimal value) {
            addCriterion("share_rate_cal <>", value, "shareRateCal");
            return (Criteria) this;
        }

        public Criteria andShareRateCalGreaterThan(BigDecimal value) {
            addCriterion("share_rate_cal >", value, "shareRateCal");
            return (Criteria) this;
        }

        public Criteria andShareRateCalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("share_rate_cal >=", value, "shareRateCal");
            return (Criteria) this;
        }

        public Criteria andShareRateCalLessThan(BigDecimal value) {
            addCriterion("share_rate_cal <", value, "shareRateCal");
            return (Criteria) this;
        }

        public Criteria andShareRateCalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("share_rate_cal <=", value, "shareRateCal");
            return (Criteria) this;
        }

        public Criteria andShareRateCalIn(List<BigDecimal> values) {
            addCriterion("share_rate_cal in", values, "shareRateCal");
            return (Criteria) this;
        }

        public Criteria andShareRateCalNotIn(List<BigDecimal> values) {
            addCriterion("share_rate_cal not in", values, "shareRateCal");
            return (Criteria) this;
        }

        public Criteria andShareRateCalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("share_rate_cal between", value1, value2, "shareRateCal");
            return (Criteria) this;
        }

        public Criteria andShareRateCalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("share_rate_cal not between", value1, value2, "shareRateCal");
            return (Criteria) this;
        }

        public Criteria andDiscountRateIsNull() {
            addCriterion("discount_rate is null");
            return (Criteria) this;
        }

        public Criteria andDiscountRateIsNotNull() {
            addCriterion("discount_rate is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountRateEqualTo(BigDecimal value) {
            addCriterion("discount_rate =", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateNotEqualTo(BigDecimal value) {
            addCriterion("discount_rate <>", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateGreaterThan(BigDecimal value) {
            addCriterion("discount_rate >", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_rate >=", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateLessThan(BigDecimal value) {
            addCriterion("discount_rate <", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_rate <=", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateIn(List<BigDecimal> values) {
            addCriterion("discount_rate in", values, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateNotIn(List<BigDecimal> values) {
            addCriterion("discount_rate not in", values, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_rate between", value1, value2, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_rate not between", value1, value2, "discountRate");
            return (Criteria) this;
        }

        public Criteria andSeriesYearIsNull() {
            addCriterion("series_year is null");
            return (Criteria) this;
        }

        public Criteria andSeriesYearIsNotNull() {
            addCriterion("series_year is not null");
            return (Criteria) this;
        }

        public Criteria andSeriesYearEqualTo(BigDecimal value) {
            addCriterion("series_year =", value, "seriesYear");
            return (Criteria) this;
        }

        public Criteria andSeriesYearNotEqualTo(BigDecimal value) {
            addCriterion("series_year <>", value, "seriesYear");
            return (Criteria) this;
        }

        public Criteria andSeriesYearGreaterThan(BigDecimal value) {
            addCriterion("series_year >", value, "seriesYear");
            return (Criteria) this;
        }

        public Criteria andSeriesYearGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("series_year >=", value, "seriesYear");
            return (Criteria) this;
        }

        public Criteria andSeriesYearLessThan(BigDecimal value) {
            addCriterion("series_year <", value, "seriesYear");
            return (Criteria) this;
        }

        public Criteria andSeriesYearLessThanOrEqualTo(BigDecimal value) {
            addCriterion("series_year <=", value, "seriesYear");
            return (Criteria) this;
        }

        public Criteria andSeriesYearIn(List<BigDecimal> values) {
            addCriterion("series_year in", values, "seriesYear");
            return (Criteria) this;
        }

        public Criteria andSeriesYearNotIn(List<BigDecimal> values) {
            addCriterion("series_year not in", values, "seriesYear");
            return (Criteria) this;
        }

        public Criteria andSeriesYearBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("series_year between", value1, value2, "seriesYear");
            return (Criteria) this;
        }

        public Criteria andSeriesYearNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("series_year not between", value1, value2, "seriesYear");
            return (Criteria) this;
        }

        public Criteria andDiscountFactorIsNull() {
            addCriterion("discount_factor is null");
            return (Criteria) this;
        }

        public Criteria andDiscountFactorIsNotNull() {
            addCriterion("discount_factor is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountFactorEqualTo(BigDecimal value) {
            addCriterion("discount_factor =", value, "discountFactor");
            return (Criteria) this;
        }

        public Criteria andDiscountFactorNotEqualTo(BigDecimal value) {
            addCriterion("discount_factor <>", value, "discountFactor");
            return (Criteria) this;
        }

        public Criteria andDiscountFactorGreaterThan(BigDecimal value) {
            addCriterion("discount_factor >", value, "discountFactor");
            return (Criteria) this;
        }

        public Criteria andDiscountFactorGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_factor >=", value, "discountFactor");
            return (Criteria) this;
        }

        public Criteria andDiscountFactorLessThan(BigDecimal value) {
            addCriterion("discount_factor <", value, "discountFactor");
            return (Criteria) this;
        }

        public Criteria andDiscountFactorLessThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_factor <=", value, "discountFactor");
            return (Criteria) this;
        }

        public Criteria andDiscountFactorIn(List<BigDecimal> values) {
            addCriterion("discount_factor in", values, "discountFactor");
            return (Criteria) this;
        }

        public Criteria andDiscountFactorNotIn(List<BigDecimal> values) {
            addCriterion("discount_factor not in", values, "discountFactor");
            return (Criteria) this;
        }

        public Criteria andDiscountFactorBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_factor between", value1, value2, "discountFactor");
            return (Criteria) this;
        }

        public Criteria andDiscountFactorNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_factor not between", value1, value2, "discountFactor");
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

        public Criteria andModifyDateIsNull() {
            addCriterion("modify_date is null");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNotNull() {
            addCriterion("modify_date is not null");
            return (Criteria) this;
        }

        public Criteria andModifyDateEqualTo(Date value) {
            addCriterion("modify_date =", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotEqualTo(Date value) {
            addCriterion("modify_date <>", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThan(Date value) {
            addCriterion("modify_date >", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_date >=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThan(Date value) {
            addCriterion("modify_date <", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThanOrEqualTo(Date value) {
            addCriterion("modify_date <=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateIn(List<Date> values) {
            addCriterion("modify_date in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotIn(List<Date> values) {
            addCriterion("modify_date not in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateBetween(Date value1, Date value2) {
            addCriterion("modify_date between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotBetween(Date value1, Date value2) {
            addCriterion("modify_date not between", value1, value2, "modifyDate");
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