package com.kpap.basis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ProExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public ProExample() {
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

        public Criteria andBaseDateIsNull() {
            addCriterion("base_date is null");
            return (Criteria) this;
        }

        public Criteria andBaseDateIsNotNull() {
            addCriterion("base_date is not null");
            return (Criteria) this;
        }

        public Criteria andBaseDateEqualTo(Date value) {
            addCriterionForJDBCDate("base_date =", value, "baseDate");
            return (Criteria) this;
        }

        public Criteria andBaseDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("base_date <>", value, "baseDate");
            return (Criteria) this;
        }

        public Criteria andBaseDateGreaterThan(Date value) {
            addCriterionForJDBCDate("base_date >", value, "baseDate");
            return (Criteria) this;
        }

        public Criteria andBaseDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("base_date >=", value, "baseDate");
            return (Criteria) this;
        }

        public Criteria andBaseDateLessThan(Date value) {
            addCriterionForJDBCDate("base_date <", value, "baseDate");
            return (Criteria) this;
        }

        public Criteria andBaseDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("base_date <=", value, "baseDate");
            return (Criteria) this;
        }

        public Criteria andBaseDateIn(List<Date> values) {
            addCriterionForJDBCDate("base_date in", values, "baseDate");
            return (Criteria) this;
        }

        public Criteria andBaseDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("base_date not in", values, "baseDate");
            return (Criteria) this;
        }

        public Criteria andBaseDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("base_date between", value1, value2, "baseDate");
            return (Criteria) this;
        }

        public Criteria andBaseDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("base_date not between", value1, value2, "baseDate");
            return (Criteria) this;
        }

        public Criteria andIsPatentIsNull() {
            addCriterion("is_patent is null");
            return (Criteria) this;
        }

        public Criteria andIsPatentIsNotNull() {
            addCriterion("is_patent is not null");
            return (Criteria) this;
        }

        public Criteria andIsPatentEqualTo(String value) {
            addCriterion("is_patent =", value, "isPatent");
            return (Criteria) this;
        }

        public Criteria andIsPatentNotEqualTo(String value) {
            addCriterion("is_patent <>", value, "isPatent");
            return (Criteria) this;
        }

        public Criteria andIsPatentGreaterThan(String value) {
            addCriterion("is_patent >", value, "isPatent");
            return (Criteria) this;
        }

        public Criteria andIsPatentGreaterThanOrEqualTo(String value) {
            addCriterion("is_patent >=", value, "isPatent");
            return (Criteria) this;
        }

        public Criteria andIsPatentLessThan(String value) {
            addCriterion("is_patent <", value, "isPatent");
            return (Criteria) this;
        }

        public Criteria andIsPatentLessThanOrEqualTo(String value) {
            addCriterion("is_patent <=", value, "isPatent");
            return (Criteria) this;
        }

        public Criteria andIsPatentLike(String value) {
            addCriterion("is_patent like", value, "isPatent");
            return (Criteria) this;
        }

        public Criteria andIsPatentNotLike(String value) {
            addCriterion("is_patent not like", value, "isPatent");
            return (Criteria) this;
        }

        public Criteria andIsPatentIn(List<String> values) {
            addCriterion("is_patent in", values, "isPatent");
            return (Criteria) this;
        }

        public Criteria andIsPatentNotIn(List<String> values) {
            addCriterion("is_patent not in", values, "isPatent");
            return (Criteria) this;
        }

        public Criteria andIsPatentBetween(String value1, String value2) {
            addCriterion("is_patent between", value1, value2, "isPatent");
            return (Criteria) this;
        }

        public Criteria andIsPatentNotBetween(String value1, String value2) {
            addCriterion("is_patent not between", value1, value2, "isPatent");
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

        public Criteria andActualValIsNull() {
            addCriterion("actual_val is null");
            return (Criteria) this;
        }

        public Criteria andActualValIsNotNull() {
            addCriterion("actual_val is not null");
            return (Criteria) this;
        }

        public Criteria andActualValEqualTo(String value) {
            addCriterion("actual_val =", value, "actualVal");
            return (Criteria) this;
        }

        public Criteria andActualValNotEqualTo(String value) {
            addCriterion("actual_val <>", value, "actualVal");
            return (Criteria) this;
        }

        public Criteria andActualValGreaterThan(String value) {
            addCriterion("actual_val >", value, "actualVal");
            return (Criteria) this;
        }

        public Criteria andActualValGreaterThanOrEqualTo(String value) {
            addCriterion("actual_val >=", value, "actualVal");
            return (Criteria) this;
        }

        public Criteria andActualValLessThan(String value) {
            addCriterion("actual_val <", value, "actualVal");
            return (Criteria) this;
        }

        public Criteria andActualValLessThanOrEqualTo(String value) {
            addCriterion("actual_val <=", value, "actualVal");
            return (Criteria) this;
        }

        public Criteria andActualValLike(String value) {
            addCriterion("actual_val like", value, "actualVal");
            return (Criteria) this;
        }

        public Criteria andActualValNotLike(String value) {
            addCriterion("actual_val not like", value, "actualVal");
            return (Criteria) this;
        }

        public Criteria andActualValIn(List<String> values) {
            addCriterion("actual_val in", values, "actualVal");
            return (Criteria) this;
        }

        public Criteria andActualValNotIn(List<String> values) {
            addCriterion("actual_val not in", values, "actualVal");
            return (Criteria) this;
        }

        public Criteria andActualValBetween(String value1, String value2) {
            addCriterion("actual_val between", value1, value2, "actualVal");
            return (Criteria) this;
        }

        public Criteria andActualValNotBetween(String value1, String value2) {
            addCriterion("actual_val not between", value1, value2, "actualVal");
            return (Criteria) this;
        }

        public Criteria andReportUrlIsNull() {
            addCriterion("report_url is null");
            return (Criteria) this;
        }

        public Criteria andReportUrlIsNotNull() {
            addCriterion("report_url is not null");
            return (Criteria) this;
        }

        public Criteria andReportUrlEqualTo(String value) {
            addCriterion("report_url =", value, "reportUrl");
            return (Criteria) this;
        }

        public Criteria andReportUrlNotEqualTo(String value) {
            addCriterion("report_url <>", value, "reportUrl");
            return (Criteria) this;
        }

        public Criteria andReportUrlGreaterThan(String value) {
            addCriterion("report_url >", value, "reportUrl");
            return (Criteria) this;
        }

        public Criteria andReportUrlGreaterThanOrEqualTo(String value) {
            addCriterion("report_url >=", value, "reportUrl");
            return (Criteria) this;
        }

        public Criteria andReportUrlLessThan(String value) {
            addCriterion("report_url <", value, "reportUrl");
            return (Criteria) this;
        }

        public Criteria andReportUrlLessThanOrEqualTo(String value) {
            addCriterion("report_url <=", value, "reportUrl");
            return (Criteria) this;
        }

        public Criteria andReportUrlLike(String value) {
            addCriterion("report_url like", value, "reportUrl");
            return (Criteria) this;
        }

        public Criteria andReportUrlNotLike(String value) {
            addCriterion("report_url not like", value, "reportUrl");
            return (Criteria) this;
        }

        public Criteria andReportUrlIn(List<String> values) {
            addCriterion("report_url in", values, "reportUrl");
            return (Criteria) this;
        }

        public Criteria andReportUrlNotIn(List<String> values) {
            addCriterion("report_url not in", values, "reportUrl");
            return (Criteria) this;
        }

        public Criteria andReportUrlBetween(String value1, String value2) {
            addCriterion("report_url between", value1, value2, "reportUrl");
            return (Criteria) this;
        }

        public Criteria andReportUrlNotBetween(String value1, String value2) {
            addCriterion("report_url not between", value1, value2, "reportUrl");
            return (Criteria) this;
        }

        public Criteria andDataSourceUrlIsNull() {
            addCriterion("data_source_url is null");
            return (Criteria) this;
        }

        public Criteria andDataSourceUrlIsNotNull() {
            addCriterion("data_source_url is not null");
            return (Criteria) this;
        }

        public Criteria andDataSourceUrlEqualTo(String value) {
            addCriterion("data_source_url =", value, "dataSourceUrl");
            return (Criteria) this;
        }

        public Criteria andDataSourceUrlNotEqualTo(String value) {
            addCriterion("data_source_url <>", value, "dataSourceUrl");
            return (Criteria) this;
        }

        public Criteria andDataSourceUrlGreaterThan(String value) {
            addCriterion("data_source_url >", value, "dataSourceUrl");
            return (Criteria) this;
        }

        public Criteria andDataSourceUrlGreaterThanOrEqualTo(String value) {
            addCriterion("data_source_url >=", value, "dataSourceUrl");
            return (Criteria) this;
        }

        public Criteria andDataSourceUrlLessThan(String value) {
            addCriterion("data_source_url <", value, "dataSourceUrl");
            return (Criteria) this;
        }

        public Criteria andDataSourceUrlLessThanOrEqualTo(String value) {
            addCriterion("data_source_url <=", value, "dataSourceUrl");
            return (Criteria) this;
        }

        public Criteria andDataSourceUrlLike(String value) {
            addCriterion("data_source_url like", value, "dataSourceUrl");
            return (Criteria) this;
        }

        public Criteria andDataSourceUrlNotLike(String value) {
            addCriterion("data_source_url not like", value, "dataSourceUrl");
            return (Criteria) this;
        }

        public Criteria andDataSourceUrlIn(List<String> values) {
            addCriterion("data_source_url in", values, "dataSourceUrl");
            return (Criteria) this;
        }

        public Criteria andDataSourceUrlNotIn(List<String> values) {
            addCriterion("data_source_url not in", values, "dataSourceUrl");
            return (Criteria) this;
        }

        public Criteria andDataSourceUrlBetween(String value1, String value2) {
            addCriterion("data_source_url between", value1, value2, "dataSourceUrl");
            return (Criteria) this;
        }

        public Criteria andDataSourceUrlNotBetween(String value1, String value2) {
            addCriterion("data_source_url not between", value1, value2, "dataSourceUrl");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
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

        public Criteria andAuditorIsNull() {
            addCriterion("auditor is null");
            return (Criteria) this;
        }

        public Criteria andAuditorIsNotNull() {
            addCriterion("auditor is not null");
            return (Criteria) this;
        }

        public Criteria andAuditorEqualTo(String value) {
            addCriterion("auditor =", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotEqualTo(String value) {
            addCriterion("auditor <>", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorGreaterThan(String value) {
            addCriterion("auditor >", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorGreaterThanOrEqualTo(String value) {
            addCriterion("auditor >=", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLessThan(String value) {
            addCriterion("auditor <", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLessThanOrEqualTo(String value) {
            addCriterion("auditor <=", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLike(String value) {
            addCriterion("auditor like", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotLike(String value) {
            addCriterion("auditor not like", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorIn(List<String> values) {
            addCriterion("auditor in", values, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotIn(List<String> values) {
            addCriterion("auditor not in", values, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorBetween(String value1, String value2) {
            addCriterion("auditor between", value1, value2, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotBetween(String value1, String value2) {
            addCriterion("auditor not between", value1, value2, "auditor");
            return (Criteria) this;
        }

        public Criteria andSagrIsNull() {
            addCriterion("sagr is null");
            return (Criteria) this;
        }

        public Criteria andSagrIsNotNull() {
            addCriterion("sagr is not null");
            return (Criteria) this;
        }

        public Criteria andSagrEqualTo(BigDecimal value) {
            addCriterion("sagr =", value, "sagr");
            return (Criteria) this;
        }

        public Criteria andSagrNotEqualTo(BigDecimal value) {
            addCriterion("sagr <>", value, "sagr");
            return (Criteria) this;
        }

        public Criteria andSagrGreaterThan(BigDecimal value) {
            addCriterion("sagr >", value, "sagr");
            return (Criteria) this;
        }

        public Criteria andSagrGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sagr >=", value, "sagr");
            return (Criteria) this;
        }

        public Criteria andSagrLessThan(BigDecimal value) {
            addCriterion("sagr <", value, "sagr");
            return (Criteria) this;
        }

        public Criteria andSagrLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sagr <=", value, "sagr");
            return (Criteria) this;
        }

        public Criteria andSagrIn(List<BigDecimal> values) {
            addCriterion("sagr in", values, "sagr");
            return (Criteria) this;
        }

        public Criteria andSagrNotIn(List<BigDecimal> values) {
            addCriterion("sagr not in", values, "sagr");
            return (Criteria) this;
        }

        public Criteria andSagrBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sagr between", value1, value2, "sagr");
            return (Criteria) this;
        }

        public Criteria andSagrNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sagr not between", value1, value2, "sagr");
            return (Criteria) this;
        }

        public Criteria andDcfIsNull() {
            addCriterion("dcf is null");
            return (Criteria) this;
        }

        public Criteria andDcfIsNotNull() {
            addCriterion("dcf is not null");
            return (Criteria) this;
        }

        public Criteria andDcfEqualTo(BigDecimal value) {
            addCriterion("dcf =", value, "dcf");
            return (Criteria) this;
        }

        public Criteria andDcfNotEqualTo(BigDecimal value) {
            addCriterion("dcf <>", value, "dcf");
            return (Criteria) this;
        }

        public Criteria andDcfGreaterThan(BigDecimal value) {
            addCriterion("dcf >", value, "dcf");
            return (Criteria) this;
        }

        public Criteria andDcfGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dcf >=", value, "dcf");
            return (Criteria) this;
        }

        public Criteria andDcfLessThan(BigDecimal value) {
            addCriterion("dcf <", value, "dcf");
            return (Criteria) this;
        }

        public Criteria andDcfLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dcf <=", value, "dcf");
            return (Criteria) this;
        }

        public Criteria andDcfIn(List<BigDecimal> values) {
            addCriterion("dcf in", values, "dcf");
            return (Criteria) this;
        }

        public Criteria andDcfNotIn(List<BigDecimal> values) {
            addCriterion("dcf not in", values, "dcf");
            return (Criteria) this;
        }

        public Criteria andDcfBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dcf between", value1, value2, "dcf");
            return (Criteria) this;
        }

        public Criteria andDcfNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dcf not between", value1, value2, "dcf");
            return (Criteria) this;
        }

        public Criteria andExcelUrlIsNull() {
            addCriterion("excel_url is null");
            return (Criteria) this;
        }

        public Criteria andExcelUrlIsNotNull() {
            addCriterion("excel_url is not null");
            return (Criteria) this;
        }

        public Criteria andExcelUrlEqualTo(String value) {
            addCriterion("excel_url =", value, "excelUrl");
            return (Criteria) this;
        }

        public Criteria andExcelUrlNotEqualTo(String value) {
            addCriterion("excel_url <>", value, "excelUrl");
            return (Criteria) this;
        }

        public Criteria andExcelUrlGreaterThan(String value) {
            addCriterion("excel_url >", value, "excelUrl");
            return (Criteria) this;
        }

        public Criteria andExcelUrlGreaterThanOrEqualTo(String value) {
            addCriterion("excel_url >=", value, "excelUrl");
            return (Criteria) this;
        }

        public Criteria andExcelUrlLessThan(String value) {
            addCriterion("excel_url <", value, "excelUrl");
            return (Criteria) this;
        }

        public Criteria andExcelUrlLessThanOrEqualTo(String value) {
            addCriterion("excel_url <=", value, "excelUrl");
            return (Criteria) this;
        }

        public Criteria andExcelUrlLike(String value) {
            addCriterion("excel_url like", value, "excelUrl");
            return (Criteria) this;
        }

        public Criteria andExcelUrlNotLike(String value) {
            addCriterion("excel_url not like", value, "excelUrl");
            return (Criteria) this;
        }

        public Criteria andExcelUrlIn(List<String> values) {
            addCriterion("excel_url in", values, "excelUrl");
            return (Criteria) this;
        }

        public Criteria andExcelUrlNotIn(List<String> values) {
            addCriterion("excel_url not in", values, "excelUrl");
            return (Criteria) this;
        }

        public Criteria andExcelUrlBetween(String value1, String value2) {
            addCriterion("excel_url between", value1, value2, "excelUrl");
            return (Criteria) this;
        }

        public Criteria andExcelUrlNotBetween(String value1, String value2) {
            addCriterion("excel_url not between", value1, value2, "excelUrl");
            return (Criteria) this;
        }

        public Criteria andCalValIsNull() {
            addCriterion("cal_val is null");
            return (Criteria) this;
        }

        public Criteria andCalValIsNotNull() {
            addCriterion("cal_val is not null");
            return (Criteria) this;
        }

        public Criteria andCalValEqualTo(BigDecimal value) {
            addCriterion("cal_val =", value, "calVal");
            return (Criteria) this;
        }

        public Criteria andCalValNotEqualTo(BigDecimal value) {
            addCriterion("cal_val <>", value, "calVal");
            return (Criteria) this;
        }

        public Criteria andCalValGreaterThan(BigDecimal value) {
            addCriterion("cal_val >", value, "calVal");
            return (Criteria) this;
        }

        public Criteria andCalValGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cal_val >=", value, "calVal");
            return (Criteria) this;
        }

        public Criteria andCalValLessThan(BigDecimal value) {
            addCriterion("cal_val <", value, "calVal");
            return (Criteria) this;
        }

        public Criteria andCalValLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cal_val <=", value, "calVal");
            return (Criteria) this;
        }

        public Criteria andCalValIn(List<BigDecimal> values) {
            addCriterion("cal_val in", values, "calVal");
            return (Criteria) this;
        }

        public Criteria andCalValNotIn(List<BigDecimal> values) {
            addCriterion("cal_val not in", values, "calVal");
            return (Criteria) this;
        }

        public Criteria andCalValBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cal_val between", value1, value2, "calVal");
            return (Criteria) this;
        }

        public Criteria andCalValNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cal_val not between", value1, value2, "calVal");
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