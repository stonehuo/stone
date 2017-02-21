package com.kpap.basis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ComExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public ComExample() {
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

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andRepresentativeIsNull() {
            addCriterion("\"representative \" is null");
            return (Criteria) this;
        }

        public Criteria andRepresentativeIsNotNull() {
            addCriterion("\"representative \" is not null");
            return (Criteria) this;
        }

        public Criteria andRepresentativeEqualTo(String value) {
            addCriterion("\"representative \" =", value, "representative");
            return (Criteria) this;
        }

        public Criteria andRepresentativeNotEqualTo(String value) {
            addCriterion("\"representative \" <>", value, "representative");
            return (Criteria) this;
        }

        public Criteria andRepresentativeGreaterThan(String value) {
            addCriterion("\"representative \" >", value, "representative");
            return (Criteria) this;
        }

        public Criteria andRepresentativeGreaterThanOrEqualTo(String value) {
            addCriterion("\"representative \" >=", value, "representative");
            return (Criteria) this;
        }

        public Criteria andRepresentativeLessThan(String value) {
            addCriterion("\"representative \" <", value, "representative");
            return (Criteria) this;
        }

        public Criteria andRepresentativeLessThanOrEqualTo(String value) {
            addCriterion("\"representative \" <=", value, "representative");
            return (Criteria) this;
        }

        public Criteria andRepresentativeLike(String value) {
            addCriterion("\"representative \" like", value, "representative");
            return (Criteria) this;
        }

        public Criteria andRepresentativeNotLike(String value) {
            addCriterion("\"representative \" not like", value, "representative");
            return (Criteria) this;
        }

        public Criteria andRepresentativeIn(List<String> values) {
            addCriterion("\"representative \" in", values, "representative");
            return (Criteria) this;
        }

        public Criteria andRepresentativeNotIn(List<String> values) {
            addCriterion("\"representative \" not in", values, "representative");
            return (Criteria) this;
        }

        public Criteria andRepresentativeBetween(String value1, String value2) {
            addCriterion("\"representative \" between", value1, value2, "representative");
            return (Criteria) this;
        }

        public Criteria andRepresentativeNotBetween(String value1, String value2) {
            addCriterion("\"representative \" not between", value1, value2, "representative");
            return (Criteria) this;
        }

        public Criteria andBusScopeIsNull() {
            addCriterion("bus_scope is null");
            return (Criteria) this;
        }

        public Criteria andBusScopeIsNotNull() {
            addCriterion("bus_scope is not null");
            return (Criteria) this;
        }

        public Criteria andBusScopeEqualTo(String value) {
            addCriterion("bus_scope =", value, "busScope");
            return (Criteria) this;
        }

        public Criteria andBusScopeNotEqualTo(String value) {
            addCriterion("bus_scope <>", value, "busScope");
            return (Criteria) this;
        }

        public Criteria andBusScopeGreaterThan(String value) {
            addCriterion("bus_scope >", value, "busScope");
            return (Criteria) this;
        }

        public Criteria andBusScopeGreaterThanOrEqualTo(String value) {
            addCriterion("bus_scope >=", value, "busScope");
            return (Criteria) this;
        }

        public Criteria andBusScopeLessThan(String value) {
            addCriterion("bus_scope <", value, "busScope");
            return (Criteria) this;
        }

        public Criteria andBusScopeLessThanOrEqualTo(String value) {
            addCriterion("bus_scope <=", value, "busScope");
            return (Criteria) this;
        }

        public Criteria andBusScopeLike(String value) {
            addCriterion("bus_scope like", value, "busScope");
            return (Criteria) this;
        }

        public Criteria andBusScopeNotLike(String value) {
            addCriterion("bus_scope not like", value, "busScope");
            return (Criteria) this;
        }

        public Criteria andBusScopeIn(List<String> values) {
            addCriterion("bus_scope in", values, "busScope");
            return (Criteria) this;
        }

        public Criteria andBusScopeNotIn(List<String> values) {
            addCriterion("bus_scope not in", values, "busScope");
            return (Criteria) this;
        }

        public Criteria andBusScopeBetween(String value1, String value2) {
            addCriterion("bus_scope between", value1, value2, "busScope");
            return (Criteria) this;
        }

        public Criteria andBusScopeNotBetween(String value1, String value2) {
            addCriterion("bus_scope not between", value1, value2, "busScope");
            return (Criteria) this;
        }

        public Criteria andSetupDateIsNull() {
            addCriterion("setup_date is null");
            return (Criteria) this;
        }

        public Criteria andSetupDateIsNotNull() {
            addCriterion("setup_date is not null");
            return (Criteria) this;
        }

        public Criteria andSetupDateEqualTo(Date value) {
            addCriterionForJDBCDate("setup_date =", value, "setupDate");
            return (Criteria) this;
        }

        public Criteria andSetupDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("setup_date <>", value, "setupDate");
            return (Criteria) this;
        }

        public Criteria andSetupDateGreaterThan(Date value) {
            addCriterionForJDBCDate("setup_date >", value, "setupDate");
            return (Criteria) this;
        }

        public Criteria andSetupDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("setup_date >=", value, "setupDate");
            return (Criteria) this;
        }

        public Criteria andSetupDateLessThan(Date value) {
            addCriterionForJDBCDate("setup_date <", value, "setupDate");
            return (Criteria) this;
        }

        public Criteria andSetupDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("setup_date <=", value, "setupDate");
            return (Criteria) this;
        }

        public Criteria andSetupDateIn(List<Date> values) {
            addCriterionForJDBCDate("setup_date in", values, "setupDate");
            return (Criteria) this;
        }

        public Criteria andSetupDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("setup_date not in", values, "setupDate");
            return (Criteria) this;
        }

        public Criteria andSetupDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("setup_date between", value1, value2, "setupDate");
            return (Criteria) this;
        }

        public Criteria andSetupDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("setup_date not between", value1, value2, "setupDate");
            return (Criteria) this;
        }

        public Criteria andBusTermIsNull() {
            addCriterion("bus_term is null");
            return (Criteria) this;
        }

        public Criteria andBusTermIsNotNull() {
            addCriterion("bus_term is not null");
            return (Criteria) this;
        }

        public Criteria andBusTermEqualTo(String value) {
            addCriterion("bus_term =", value, "busTerm");
            return (Criteria) this;
        }

        public Criteria andBusTermNotEqualTo(String value) {
            addCriterion("bus_term <>", value, "busTerm");
            return (Criteria) this;
        }

        public Criteria andBusTermGreaterThan(String value) {
            addCriterion("bus_term >", value, "busTerm");
            return (Criteria) this;
        }

        public Criteria andBusTermGreaterThanOrEqualTo(String value) {
            addCriterion("bus_term >=", value, "busTerm");
            return (Criteria) this;
        }

        public Criteria andBusTermLessThan(String value) {
            addCriterion("bus_term <", value, "busTerm");
            return (Criteria) this;
        }

        public Criteria andBusTermLessThanOrEqualTo(String value) {
            addCriterion("bus_term <=", value, "busTerm");
            return (Criteria) this;
        }

        public Criteria andBusTermLike(String value) {
            addCriterion("bus_term like", value, "busTerm");
            return (Criteria) this;
        }

        public Criteria andBusTermNotLike(String value) {
            addCriterion("bus_term not like", value, "busTerm");
            return (Criteria) this;
        }

        public Criteria andBusTermIn(List<String> values) {
            addCriterion("bus_term in", values, "busTerm");
            return (Criteria) this;
        }

        public Criteria andBusTermNotIn(List<String> values) {
            addCriterion("bus_term not in", values, "busTerm");
            return (Criteria) this;
        }

        public Criteria andBusTermBetween(String value1, String value2) {
            addCriterion("bus_term between", value1, value2, "busTerm");
            return (Criteria) this;
        }

        public Criteria andBusTermNotBetween(String value1, String value2) {
            addCriterion("bus_term not between", value1, value2, "busTerm");
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

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
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

        public Criteria andJsonComSubIsNull() {
            addCriterion("json_com_sub is null");
            return (Criteria) this;
        }

        public Criteria andJsonComSubIsNotNull() {
            addCriterion("json_com_sub is not null");
            return (Criteria) this;
        }

        public Criteria andJsonComSubEqualTo(String value) {
            addCriterion("json_com_sub =", value, "jsonComSub");
            return (Criteria) this;
        }

        public Criteria andJsonComSubNotEqualTo(String value) {
            addCriterion("json_com_sub <>", value, "jsonComSub");
            return (Criteria) this;
        }

        public Criteria andJsonComSubGreaterThan(String value) {
            addCriterion("json_com_sub >", value, "jsonComSub");
            return (Criteria) this;
        }

        public Criteria andJsonComSubGreaterThanOrEqualTo(String value) {
            addCriterion("json_com_sub >=", value, "jsonComSub");
            return (Criteria) this;
        }

        public Criteria andJsonComSubLessThan(String value) {
            addCriterion("json_com_sub <", value, "jsonComSub");
            return (Criteria) this;
        }

        public Criteria andJsonComSubLessThanOrEqualTo(String value) {
            addCriterion("json_com_sub <=", value, "jsonComSub");
            return (Criteria) this;
        }

        public Criteria andJsonComSubLike(String value) {
            addCriterion("json_com_sub like", value, "jsonComSub");
            return (Criteria) this;
        }

        public Criteria andJsonComSubNotLike(String value) {
            addCriterion("json_com_sub not like", value, "jsonComSub");
            return (Criteria) this;
        }

        public Criteria andJsonComSubIn(List<String> values) {
            addCriterion("json_com_sub in", values, "jsonComSub");
            return (Criteria) this;
        }

        public Criteria andJsonComSubNotIn(List<String> values) {
            addCriterion("json_com_sub not in", values, "jsonComSub");
            return (Criteria) this;
        }

        public Criteria andJsonComSubBetween(String value1, String value2) {
            addCriterion("json_com_sub between", value1, value2, "jsonComSub");
            return (Criteria) this;
        }

        public Criteria andJsonComSubNotBetween(String value1, String value2) {
            addCriterion("json_com_sub not between", value1, value2, "jsonComSub");
            return (Criteria) this;
        }

        public Criteria andCountFmIsNull() {
            addCriterion("count_fm is null");
            return (Criteria) this;
        }

        public Criteria andCountFmIsNotNull() {
            addCriterion("count_fm is not null");
            return (Criteria) this;
        }

        public Criteria andCountFmEqualTo(Integer value) {
            addCriterion("count_fm =", value, "countFm");
            return (Criteria) this;
        }

        public Criteria andCountFmNotEqualTo(Integer value) {
            addCriterion("count_fm <>", value, "countFm");
            return (Criteria) this;
        }

        public Criteria andCountFmGreaterThan(Integer value) {
            addCriterion("count_fm >", value, "countFm");
            return (Criteria) this;
        }

        public Criteria andCountFmGreaterThanOrEqualTo(Integer value) {
            addCriterion("count_fm >=", value, "countFm");
            return (Criteria) this;
        }

        public Criteria andCountFmLessThan(Integer value) {
            addCriterion("count_fm <", value, "countFm");
            return (Criteria) this;
        }

        public Criteria andCountFmLessThanOrEqualTo(Integer value) {
            addCriterion("count_fm <=", value, "countFm");
            return (Criteria) this;
        }

        public Criteria andCountFmIn(List<Integer> values) {
            addCriterion("count_fm in", values, "countFm");
            return (Criteria) this;
        }

        public Criteria andCountFmNotIn(List<Integer> values) {
            addCriterion("count_fm not in", values, "countFm");
            return (Criteria) this;
        }

        public Criteria andCountFmBetween(Integer value1, Integer value2) {
            addCriterion("count_fm between", value1, value2, "countFm");
            return (Criteria) this;
        }

        public Criteria andCountFmNotBetween(Integer value1, Integer value2) {
            addCriterion("count_fm not between", value1, value2, "countFm");
            return (Criteria) this;
        }

        public Criteria andCountSqIsNull() {
            addCriterion("count_sq is null");
            return (Criteria) this;
        }

        public Criteria andCountSqIsNotNull() {
            addCriterion("count_sq is not null");
            return (Criteria) this;
        }

        public Criteria andCountSqEqualTo(Integer value) {
            addCriterion("count_sq =", value, "countSq");
            return (Criteria) this;
        }

        public Criteria andCountSqNotEqualTo(Integer value) {
            addCriterion("count_sq <>", value, "countSq");
            return (Criteria) this;
        }

        public Criteria andCountSqGreaterThan(Integer value) {
            addCriterion("count_sq >", value, "countSq");
            return (Criteria) this;
        }

        public Criteria andCountSqGreaterThanOrEqualTo(Integer value) {
            addCriterion("count_sq >=", value, "countSq");
            return (Criteria) this;
        }

        public Criteria andCountSqLessThan(Integer value) {
            addCriterion("count_sq <", value, "countSq");
            return (Criteria) this;
        }

        public Criteria andCountSqLessThanOrEqualTo(Integer value) {
            addCriterion("count_sq <=", value, "countSq");
            return (Criteria) this;
        }

        public Criteria andCountSqIn(List<Integer> values) {
            addCriterion("count_sq in", values, "countSq");
            return (Criteria) this;
        }

        public Criteria andCountSqNotIn(List<Integer> values) {
            addCriterion("count_sq not in", values, "countSq");
            return (Criteria) this;
        }

        public Criteria andCountSqBetween(Integer value1, Integer value2) {
            addCriterion("count_sq between", value1, value2, "countSq");
            return (Criteria) this;
        }

        public Criteria andCountSqNotBetween(Integer value1, Integer value2) {
            addCriterion("count_sq not between", value1, value2, "countSq");
            return (Criteria) this;
        }

        public Criteria andCountXxIsNull() {
            addCriterion("count_xx is null");
            return (Criteria) this;
        }

        public Criteria andCountXxIsNotNull() {
            addCriterion("count_xx is not null");
            return (Criteria) this;
        }

        public Criteria andCountXxEqualTo(Integer value) {
            addCriterion("count_xx =", value, "countXx");
            return (Criteria) this;
        }

        public Criteria andCountXxNotEqualTo(Integer value) {
            addCriterion("count_xx <>", value, "countXx");
            return (Criteria) this;
        }

        public Criteria andCountXxGreaterThan(Integer value) {
            addCriterion("count_xx >", value, "countXx");
            return (Criteria) this;
        }

        public Criteria andCountXxGreaterThanOrEqualTo(Integer value) {
            addCriterion("count_xx >=", value, "countXx");
            return (Criteria) this;
        }

        public Criteria andCountXxLessThan(Integer value) {
            addCriterion("count_xx <", value, "countXx");
            return (Criteria) this;
        }

        public Criteria andCountXxLessThanOrEqualTo(Integer value) {
            addCriterion("count_xx <=", value, "countXx");
            return (Criteria) this;
        }

        public Criteria andCountXxIn(List<Integer> values) {
            addCriterion("count_xx in", values, "countXx");
            return (Criteria) this;
        }

        public Criteria andCountXxNotIn(List<Integer> values) {
            addCriterion("count_xx not in", values, "countXx");
            return (Criteria) this;
        }

        public Criteria andCountXxBetween(Integer value1, Integer value2) {
            addCriterion("count_xx between", value1, value2, "countXx");
            return (Criteria) this;
        }

        public Criteria andCountXxNotBetween(Integer value1, Integer value2) {
            addCriterion("count_xx not between", value1, value2, "countXx");
            return (Criteria) this;
        }

        public Criteria andCountWgIsNull() {
            addCriterion("count_wg is null");
            return (Criteria) this;
        }

        public Criteria andCountWgIsNotNull() {
            addCriterion("count_wg is not null");
            return (Criteria) this;
        }

        public Criteria andCountWgEqualTo(Integer value) {
            addCriterion("count_wg =", value, "countWg");
            return (Criteria) this;
        }

        public Criteria andCountWgNotEqualTo(Integer value) {
            addCriterion("count_wg <>", value, "countWg");
            return (Criteria) this;
        }

        public Criteria andCountWgGreaterThan(Integer value) {
            addCriterion("count_wg >", value, "countWg");
            return (Criteria) this;
        }

        public Criteria andCountWgGreaterThanOrEqualTo(Integer value) {
            addCriterion("count_wg >=", value, "countWg");
            return (Criteria) this;
        }

        public Criteria andCountWgLessThan(Integer value) {
            addCriterion("count_wg <", value, "countWg");
            return (Criteria) this;
        }

        public Criteria andCountWgLessThanOrEqualTo(Integer value) {
            addCriterion("count_wg <=", value, "countWg");
            return (Criteria) this;
        }

        public Criteria andCountWgIn(List<Integer> values) {
            addCriterion("count_wg in", values, "countWg");
            return (Criteria) this;
        }

        public Criteria andCountWgNotIn(List<Integer> values) {
            addCriterion("count_wg not in", values, "countWg");
            return (Criteria) this;
        }

        public Criteria andCountWgBetween(Integer value1, Integer value2) {
            addCriterion("count_wg between", value1, value2, "countWg");
            return (Criteria) this;
        }

        public Criteria andCountWgNotBetween(Integer value1, Integer value2) {
            addCriterion("count_wg not between", value1, value2, "countWg");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(BigDecimal value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(BigDecimal value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(BigDecimal value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(BigDecimal value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<BigDecimal> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<BigDecimal> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andCountIqComIsNull() {
            addCriterion("count_iq_com is null");
            return (Criteria) this;
        }

        public Criteria andCountIqComIsNotNull() {
            addCriterion("count_iq_com is not null");
            return (Criteria) this;
        }

        public Criteria andCountIqComEqualTo(Integer value) {
            addCriterion("count_iq_com =", value, "countIqCom");
            return (Criteria) this;
        }

        public Criteria andCountIqComNotEqualTo(Integer value) {
            addCriterion("count_iq_com <>", value, "countIqCom");
            return (Criteria) this;
        }

        public Criteria andCountIqComGreaterThan(Integer value) {
            addCriterion("count_iq_com >", value, "countIqCom");
            return (Criteria) this;
        }

        public Criteria andCountIqComGreaterThanOrEqualTo(Integer value) {
            addCriterion("count_iq_com >=", value, "countIqCom");
            return (Criteria) this;
        }

        public Criteria andCountIqComLessThan(Integer value) {
            addCriterion("count_iq_com <", value, "countIqCom");
            return (Criteria) this;
        }

        public Criteria andCountIqComLessThanOrEqualTo(Integer value) {
            addCriterion("count_iq_com <=", value, "countIqCom");
            return (Criteria) this;
        }

        public Criteria andCountIqComIn(List<Integer> values) {
            addCriterion("count_iq_com in", values, "countIqCom");
            return (Criteria) this;
        }

        public Criteria andCountIqComNotIn(List<Integer> values) {
            addCriterion("count_iq_com not in", values, "countIqCom");
            return (Criteria) this;
        }

        public Criteria andCountIqComBetween(Integer value1, Integer value2) {
            addCriterion("count_iq_com between", value1, value2, "countIqCom");
            return (Criteria) this;
        }

        public Criteria andCountIqComNotBetween(Integer value1, Integer value2) {
            addCriterion("count_iq_com not between", value1, value2, "countIqCom");
            return (Criteria) this;
        }

        public Criteria andCountIqComAvailIsNull() {
            addCriterion("count_iq_com_avail is null");
            return (Criteria) this;
        }

        public Criteria andCountIqComAvailIsNotNull() {
            addCriterion("count_iq_com_avail is not null");
            return (Criteria) this;
        }

        public Criteria andCountIqComAvailEqualTo(Integer value) {
            addCriterion("count_iq_com_avail =", value, "countIqComAvail");
            return (Criteria) this;
        }

        public Criteria andCountIqComAvailNotEqualTo(Integer value) {
            addCriterion("count_iq_com_avail <>", value, "countIqComAvail");
            return (Criteria) this;
        }

        public Criteria andCountIqComAvailGreaterThan(Integer value) {
            addCriterion("count_iq_com_avail >", value, "countIqComAvail");
            return (Criteria) this;
        }

        public Criteria andCountIqComAvailGreaterThanOrEqualTo(Integer value) {
            addCriterion("count_iq_com_avail >=", value, "countIqComAvail");
            return (Criteria) this;
        }

        public Criteria andCountIqComAvailLessThan(Integer value) {
            addCriterion("count_iq_com_avail <", value, "countIqComAvail");
            return (Criteria) this;
        }

        public Criteria andCountIqComAvailLessThanOrEqualTo(Integer value) {
            addCriterion("count_iq_com_avail <=", value, "countIqComAvail");
            return (Criteria) this;
        }

        public Criteria andCountIqComAvailIn(List<Integer> values) {
            addCriterion("count_iq_com_avail in", values, "countIqComAvail");
            return (Criteria) this;
        }

        public Criteria andCountIqComAvailNotIn(List<Integer> values) {
            addCriterion("count_iq_com_avail not in", values, "countIqComAvail");
            return (Criteria) this;
        }

        public Criteria andCountIqComAvailBetween(Integer value1, Integer value2) {
            addCriterion("count_iq_com_avail between", value1, value2, "countIqComAvail");
            return (Criteria) this;
        }

        public Criteria andCountIqComAvailNotBetween(Integer value1, Integer value2) {
            addCriterion("count_iq_com_avail not between", value1, value2, "countIqComAvail");
            return (Criteria) this;
        }

        public Criteria andCountIqFmIsNull() {
            addCriterion("count_iq_fm is null");
            return (Criteria) this;
        }

        public Criteria andCountIqFmIsNotNull() {
            addCriterion("count_iq_fm is not null");
            return (Criteria) this;
        }

        public Criteria andCountIqFmEqualTo(Integer value) {
            addCriterion("count_iq_fm =", value, "countIqFm");
            return (Criteria) this;
        }

        public Criteria andCountIqFmNotEqualTo(Integer value) {
            addCriterion("count_iq_fm <>", value, "countIqFm");
            return (Criteria) this;
        }

        public Criteria andCountIqFmGreaterThan(Integer value) {
            addCriterion("count_iq_fm >", value, "countIqFm");
            return (Criteria) this;
        }

        public Criteria andCountIqFmGreaterThanOrEqualTo(Integer value) {
            addCriterion("count_iq_fm >=", value, "countIqFm");
            return (Criteria) this;
        }

        public Criteria andCountIqFmLessThan(Integer value) {
            addCriterion("count_iq_fm <", value, "countIqFm");
            return (Criteria) this;
        }

        public Criteria andCountIqFmLessThanOrEqualTo(Integer value) {
            addCriterion("count_iq_fm <=", value, "countIqFm");
            return (Criteria) this;
        }

        public Criteria andCountIqFmIn(List<Integer> values) {
            addCriterion("count_iq_fm in", values, "countIqFm");
            return (Criteria) this;
        }

        public Criteria andCountIqFmNotIn(List<Integer> values) {
            addCriterion("count_iq_fm not in", values, "countIqFm");
            return (Criteria) this;
        }

        public Criteria andCountIqFmBetween(Integer value1, Integer value2) {
            addCriterion("count_iq_fm between", value1, value2, "countIqFm");
            return (Criteria) this;
        }

        public Criteria andCountIqFmNotBetween(Integer value1, Integer value2) {
            addCriterion("count_iq_fm not between", value1, value2, "countIqFm");
            return (Criteria) this;
        }

        public Criteria andCountIqSqIsNull() {
            addCriterion("count_iq_sq is null");
            return (Criteria) this;
        }

        public Criteria andCountIqSqIsNotNull() {
            addCriterion("count_iq_sq is not null");
            return (Criteria) this;
        }

        public Criteria andCountIqSqEqualTo(Integer value) {
            addCriterion("count_iq_sq =", value, "countIqSq");
            return (Criteria) this;
        }

        public Criteria andCountIqSqNotEqualTo(Integer value) {
            addCriterion("count_iq_sq <>", value, "countIqSq");
            return (Criteria) this;
        }

        public Criteria andCountIqSqGreaterThan(Integer value) {
            addCriterion("count_iq_sq >", value, "countIqSq");
            return (Criteria) this;
        }

        public Criteria andCountIqSqGreaterThanOrEqualTo(Integer value) {
            addCriterion("count_iq_sq >=", value, "countIqSq");
            return (Criteria) this;
        }

        public Criteria andCountIqSqLessThan(Integer value) {
            addCriterion("count_iq_sq <", value, "countIqSq");
            return (Criteria) this;
        }

        public Criteria andCountIqSqLessThanOrEqualTo(Integer value) {
            addCriterion("count_iq_sq <=", value, "countIqSq");
            return (Criteria) this;
        }

        public Criteria andCountIqSqIn(List<Integer> values) {
            addCriterion("count_iq_sq in", values, "countIqSq");
            return (Criteria) this;
        }

        public Criteria andCountIqSqNotIn(List<Integer> values) {
            addCriterion("count_iq_sq not in", values, "countIqSq");
            return (Criteria) this;
        }

        public Criteria andCountIqSqBetween(Integer value1, Integer value2) {
            addCriterion("count_iq_sq between", value1, value2, "countIqSq");
            return (Criteria) this;
        }

        public Criteria andCountIqSqNotBetween(Integer value1, Integer value2) {
            addCriterion("count_iq_sq not between", value1, value2, "countIqSq");
            return (Criteria) this;
        }

        public Criteria andCountIqXxIsNull() {
            addCriterion("count_iq_xx is null");
            return (Criteria) this;
        }

        public Criteria andCountIqXxIsNotNull() {
            addCriterion("count_iq_xx is not null");
            return (Criteria) this;
        }

        public Criteria andCountIqXxEqualTo(Integer value) {
            addCriterion("count_iq_xx =", value, "countIqXx");
            return (Criteria) this;
        }

        public Criteria andCountIqXxNotEqualTo(Integer value) {
            addCriterion("count_iq_xx <>", value, "countIqXx");
            return (Criteria) this;
        }

        public Criteria andCountIqXxGreaterThan(Integer value) {
            addCriterion("count_iq_xx >", value, "countIqXx");
            return (Criteria) this;
        }

        public Criteria andCountIqXxGreaterThanOrEqualTo(Integer value) {
            addCriterion("count_iq_xx >=", value, "countIqXx");
            return (Criteria) this;
        }

        public Criteria andCountIqXxLessThan(Integer value) {
            addCriterion("count_iq_xx <", value, "countIqXx");
            return (Criteria) this;
        }

        public Criteria andCountIqXxLessThanOrEqualTo(Integer value) {
            addCriterion("count_iq_xx <=", value, "countIqXx");
            return (Criteria) this;
        }

        public Criteria andCountIqXxIn(List<Integer> values) {
            addCriterion("count_iq_xx in", values, "countIqXx");
            return (Criteria) this;
        }

        public Criteria andCountIqXxNotIn(List<Integer> values) {
            addCriterion("count_iq_xx not in", values, "countIqXx");
            return (Criteria) this;
        }

        public Criteria andCountIqXxBetween(Integer value1, Integer value2) {
            addCriterion("count_iq_xx between", value1, value2, "countIqXx");
            return (Criteria) this;
        }

        public Criteria andCountIqXxNotBetween(Integer value1, Integer value2) {
            addCriterion("count_iq_xx not between", value1, value2, "countIqXx");
            return (Criteria) this;
        }

        public Criteria andCountIqWgIsNull() {
            addCriterion("count_iq_wg is null");
            return (Criteria) this;
        }

        public Criteria andCountIqWgIsNotNull() {
            addCriterion("count_iq_wg is not null");
            return (Criteria) this;
        }

        public Criteria andCountIqWgEqualTo(Integer value) {
            addCriterion("count_iq_wg =", value, "countIqWg");
            return (Criteria) this;
        }

        public Criteria andCountIqWgNotEqualTo(Integer value) {
            addCriterion("count_iq_wg <>", value, "countIqWg");
            return (Criteria) this;
        }

        public Criteria andCountIqWgGreaterThan(Integer value) {
            addCriterion("count_iq_wg >", value, "countIqWg");
            return (Criteria) this;
        }

        public Criteria andCountIqWgGreaterThanOrEqualTo(Integer value) {
            addCriterion("count_iq_wg >=", value, "countIqWg");
            return (Criteria) this;
        }

        public Criteria andCountIqWgLessThan(Integer value) {
            addCriterion("count_iq_wg <", value, "countIqWg");
            return (Criteria) this;
        }

        public Criteria andCountIqWgLessThanOrEqualTo(Integer value) {
            addCriterion("count_iq_wg <=", value, "countIqWg");
            return (Criteria) this;
        }

        public Criteria andCountIqWgIn(List<Integer> values) {
            addCriterion("count_iq_wg in", values, "countIqWg");
            return (Criteria) this;
        }

        public Criteria andCountIqWgNotIn(List<Integer> values) {
            addCriterion("count_iq_wg not in", values, "countIqWg");
            return (Criteria) this;
        }

        public Criteria andCountIqWgBetween(Integer value1, Integer value2) {
            addCriterion("count_iq_wg between", value1, value2, "countIqWg");
            return (Criteria) this;
        }

        public Criteria andCountIqWgNotBetween(Integer value1, Integer value2) {
            addCriterion("count_iq_wg not between", value1, value2, "countIqWg");
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