package com.kpap.basis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class IqComExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public IqComExample() {
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

        public Criteria andExchangeTickerIsNull() {
            addCriterion("exchange_ticker is null");
            return (Criteria) this;
        }

        public Criteria andExchangeTickerIsNotNull() {
            addCriterion("exchange_ticker is not null");
            return (Criteria) this;
        }

        public Criteria andExchangeTickerEqualTo(String value) {
            addCriterion("exchange_ticker =", value, "exchangeTicker");
            return (Criteria) this;
        }

        public Criteria andExchangeTickerNotEqualTo(String value) {
            addCriterion("exchange_ticker <>", value, "exchangeTicker");
            return (Criteria) this;
        }

        public Criteria andExchangeTickerGreaterThan(String value) {
            addCriterion("exchange_ticker >", value, "exchangeTicker");
            return (Criteria) this;
        }

        public Criteria andExchangeTickerGreaterThanOrEqualTo(String value) {
            addCriterion("exchange_ticker >=", value, "exchangeTicker");
            return (Criteria) this;
        }

        public Criteria andExchangeTickerLessThan(String value) {
            addCriterion("exchange_ticker <", value, "exchangeTicker");
            return (Criteria) this;
        }

        public Criteria andExchangeTickerLessThanOrEqualTo(String value) {
            addCriterion("exchange_ticker <=", value, "exchangeTicker");
            return (Criteria) this;
        }

        public Criteria andExchangeTickerLike(String value) {
            addCriterion("exchange_ticker like", value, "exchangeTicker");
            return (Criteria) this;
        }

        public Criteria andExchangeTickerNotLike(String value) {
            addCriterion("exchange_ticker not like", value, "exchangeTicker");
            return (Criteria) this;
        }

        public Criteria andExchangeTickerIn(List<String> values) {
            addCriterion("exchange_ticker in", values, "exchangeTicker");
            return (Criteria) this;
        }

        public Criteria andExchangeTickerNotIn(List<String> values) {
            addCriterion("exchange_ticker not in", values, "exchangeTicker");
            return (Criteria) this;
        }

        public Criteria andExchangeTickerBetween(String value1, String value2) {
            addCriterion("exchange_ticker between", value1, value2, "exchangeTicker");
            return (Criteria) this;
        }

        public Criteria andExchangeTickerNotBetween(String value1, String value2) {
            addCriterion("exchange_ticker not between", value1, value2, "exchangeTicker");
            return (Criteria) this;
        }

        public Criteria andIpoAddressIsNull() {
            addCriterion("ipo_address is null");
            return (Criteria) this;
        }

        public Criteria andIpoAddressIsNotNull() {
            addCriterion("ipo_address is not null");
            return (Criteria) this;
        }

        public Criteria andIpoAddressEqualTo(String value) {
            addCriterion("ipo_address =", value, "ipoAddress");
            return (Criteria) this;
        }

        public Criteria andIpoAddressNotEqualTo(String value) {
            addCriterion("ipo_address <>", value, "ipoAddress");
            return (Criteria) this;
        }

        public Criteria andIpoAddressGreaterThan(String value) {
            addCriterion("ipo_address >", value, "ipoAddress");
            return (Criteria) this;
        }

        public Criteria andIpoAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ipo_address >=", value, "ipoAddress");
            return (Criteria) this;
        }

        public Criteria andIpoAddressLessThan(String value) {
            addCriterion("ipo_address <", value, "ipoAddress");
            return (Criteria) this;
        }

        public Criteria andIpoAddressLessThanOrEqualTo(String value) {
            addCriterion("ipo_address <=", value, "ipoAddress");
            return (Criteria) this;
        }

        public Criteria andIpoAddressLike(String value) {
            addCriterion("ipo_address like", value, "ipoAddress");
            return (Criteria) this;
        }

        public Criteria andIpoAddressNotLike(String value) {
            addCriterion("ipo_address not like", value, "ipoAddress");
            return (Criteria) this;
        }

        public Criteria andIpoAddressIn(List<String> values) {
            addCriterion("ipo_address in", values, "ipoAddress");
            return (Criteria) this;
        }

        public Criteria andIpoAddressNotIn(List<String> values) {
            addCriterion("ipo_address not in", values, "ipoAddress");
            return (Criteria) this;
        }

        public Criteria andIpoAddressBetween(String value1, String value2) {
            addCriterion("ipo_address between", value1, value2, "ipoAddress");
            return (Criteria) this;
        }

        public Criteria andIpoAddressNotBetween(String value1, String value2) {
            addCriterion("ipo_address not between", value1, value2, "ipoAddress");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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

        public Criteria andIpoTimeIsNull() {
            addCriterion("ipo_time is null");
            return (Criteria) this;
        }

        public Criteria andIpoTimeIsNotNull() {
            addCriterion("ipo_time is not null");
            return (Criteria) this;
        }

        public Criteria andIpoTimeEqualTo(Date value) {
            addCriterionForJDBCDate("ipo_time =", value, "ipoTime");
            return (Criteria) this;
        }

        public Criteria andIpoTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("ipo_time <>", value, "ipoTime");
            return (Criteria) this;
        }

        public Criteria andIpoTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("ipo_time >", value, "ipoTime");
            return (Criteria) this;
        }

        public Criteria andIpoTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ipo_time >=", value, "ipoTime");
            return (Criteria) this;
        }

        public Criteria andIpoTimeLessThan(Date value) {
            addCriterionForJDBCDate("ipo_time <", value, "ipoTime");
            return (Criteria) this;
        }

        public Criteria andIpoTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ipo_time <=", value, "ipoTime");
            return (Criteria) this;
        }

        public Criteria andIpoTimeIn(List<Date> values) {
            addCriterionForJDBCDate("ipo_time in", values, "ipoTime");
            return (Criteria) this;
        }

        public Criteria andIpoTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("ipo_time not in", values, "ipoTime");
            return (Criteria) this;
        }

        public Criteria andIpoTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ipo_time between", value1, value2, "ipoTime");
            return (Criteria) this;
        }

        public Criteria andIpoTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ipo_time not between", value1, value2, "ipoTime");
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