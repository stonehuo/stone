package com.kpap.basis.model;

import java.util.ArrayList;
import java.util.List;

public class ComPatentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public ComPatentExample() {
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

        public Criteria andPro_codeIsNull() {
            addCriterion("pro_code is null");
            return (Criteria) this;
        }

        public Criteria andPro_codeIsNotNull() {
            addCriterion("pro_code is not null");
            return (Criteria) this;
        }

        public Criteria andPro_codeEqualTo(String value) {
            addCriterion("pro_code =", value, "pro_code");
            return (Criteria) this;
        }

        public Criteria andPro_codeNotEqualTo(String value) {
            addCriterion("pro_code <>", value, "pro_code");
            return (Criteria) this;
        }

        public Criteria andPro_codeGreaterThan(String value) {
            addCriterion("pro_code >", value, "pro_code");
            return (Criteria) this;
        }

        public Criteria andPro_codeGreaterThanOrEqualTo(String value) {
            addCriterion("pro_code >=", value, "pro_code");
            return (Criteria) this;
        }

        public Criteria andPro_codeLessThan(String value) {
            addCriterion("pro_code <", value, "pro_code");
            return (Criteria) this;
        }

        public Criteria andPro_codeLessThanOrEqualTo(String value) {
            addCriterion("pro_code <=", value, "pro_code");
            return (Criteria) this;
        }

        public Criteria andPro_codeLike(String value) {
            addCriterion("pro_code like", value, "pro_code");
            return (Criteria) this;
        }

        public Criteria andPro_codeNotLike(String value) {
            addCriterion("pro_code not like", value, "pro_code");
            return (Criteria) this;
        }

        public Criteria andPro_codeIn(List<String> values) {
            addCriterion("pro_code in", values, "pro_code");
            return (Criteria) this;
        }

        public Criteria andPro_codeNotIn(List<String> values) {
            addCriterion("pro_code not in", values, "pro_code");
            return (Criteria) this;
        }

        public Criteria andPro_codeBetween(String value1, String value2) {
            addCriterion("pro_code between", value1, value2, "pro_code");
            return (Criteria) this;
        }

        public Criteria andPro_codeNotBetween(String value1, String value2) {
            addCriterion("pro_code not between", value1, value2, "pro_code");
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

        public Criteria andScoreEqualTo(Double value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Double value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Double value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Double value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Double value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Double> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Double> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Double value1, Double value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Double value1, Double value2) {
            addCriterion("score not between", value1, value2, "score");
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

        public Criteria andWeightEqualTo(Double value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Double value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Double value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Double value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Double value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Double value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Double> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Double> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Double value1, Double value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Double value1, Double value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andAnIsNull() {
            addCriterion("an is null");
            return (Criteria) this;
        }

        public Criteria andAnIsNotNull() {
            addCriterion("an is not null");
            return (Criteria) this;
        }

        public Criteria andAnEqualTo(String value) {
            addCriterion("an =", value, "an");
            return (Criteria) this;
        }

        public Criteria andAnNotEqualTo(String value) {
            addCriterion("an <>", value, "an");
            return (Criteria) this;
        }

        public Criteria andAnGreaterThan(String value) {
            addCriterion("an >", value, "an");
            return (Criteria) this;
        }

        public Criteria andAnGreaterThanOrEqualTo(String value) {
            addCriterion("an >=", value, "an");
            return (Criteria) this;
        }

        public Criteria andAnLessThan(String value) {
            addCriterion("an <", value, "an");
            return (Criteria) this;
        }

        public Criteria andAnLessThanOrEqualTo(String value) {
            addCriterion("an <=", value, "an");
            return (Criteria) this;
        }

        public Criteria andAnLike(String value) {
            addCriterion("an like", value, "an");
            return (Criteria) this;
        }

        public Criteria andAnNotLike(String value) {
            addCriterion("an not like", value, "an");
            return (Criteria) this;
        }

        public Criteria andAnIn(List<String> values) {
            addCriterion("an in", values, "an");
            return (Criteria) this;
        }

        public Criteria andAnNotIn(List<String> values) {
            addCriterion("an not in", values, "an");
            return (Criteria) this;
        }

        public Criteria andAnBetween(String value1, String value2) {
            addCriterion("an between", value1, value2, "an");
            return (Criteria) this;
        }

        public Criteria andAnNotBetween(String value1, String value2) {
            addCriterion("an not between", value1, value2, "an");
            return (Criteria) this;
        }

        public Criteria andPnIsNull() {
            addCriterion("pn is null");
            return (Criteria) this;
        }

        public Criteria andPnIsNotNull() {
            addCriterion("pn is not null");
            return (Criteria) this;
        }

        public Criteria andPnEqualTo(String value) {
            addCriterion("pn =", value, "pn");
            return (Criteria) this;
        }

        public Criteria andPnNotEqualTo(String value) {
            addCriterion("pn <>", value, "pn");
            return (Criteria) this;
        }

        public Criteria andPnGreaterThan(String value) {
            addCriterion("pn >", value, "pn");
            return (Criteria) this;
        }

        public Criteria andPnGreaterThanOrEqualTo(String value) {
            addCriterion("pn >=", value, "pn");
            return (Criteria) this;
        }

        public Criteria andPnLessThan(String value) {
            addCriterion("pn <", value, "pn");
            return (Criteria) this;
        }

        public Criteria andPnLessThanOrEqualTo(String value) {
            addCriterion("pn <=", value, "pn");
            return (Criteria) this;
        }

        public Criteria andPnLike(String value) {
            addCriterion("pn like", value, "pn");
            return (Criteria) this;
        }

        public Criteria andPnNotLike(String value) {
            addCriterion("pn not like", value, "pn");
            return (Criteria) this;
        }

        public Criteria andPnIn(List<String> values) {
            addCriterion("pn in", values, "pn");
            return (Criteria) this;
        }

        public Criteria andPnNotIn(List<String> values) {
            addCriterion("pn not in", values, "pn");
            return (Criteria) this;
        }

        public Criteria andPnBetween(String value1, String value2) {
            addCriterion("pn between", value1, value2, "pn");
            return (Criteria) this;
        }

        public Criteria andPnNotBetween(String value1, String value2) {
            addCriterion("pn not between", value1, value2, "pn");
            return (Criteria) this;
        }

        public Criteria andPattIsNull() {
            addCriterion("patt is null");
            return (Criteria) this;
        }

        public Criteria andPattIsNotNull() {
            addCriterion("patt is not null");
            return (Criteria) this;
        }

        public Criteria andPattEqualTo(String value) {
            addCriterion("patt =", value, "patt");
            return (Criteria) this;
        }

        public Criteria andPattNotEqualTo(String value) {
            addCriterion("patt <>", value, "patt");
            return (Criteria) this;
        }

        public Criteria andPattGreaterThan(String value) {
            addCriterion("patt >", value, "patt");
            return (Criteria) this;
        }

        public Criteria andPattGreaterThanOrEqualTo(String value) {
            addCriterion("patt >=", value, "patt");
            return (Criteria) this;
        }

        public Criteria andPattLessThan(String value) {
            addCriterion("patt <", value, "patt");
            return (Criteria) this;
        }

        public Criteria andPattLessThanOrEqualTo(String value) {
            addCriterion("patt <=", value, "patt");
            return (Criteria) this;
        }

        public Criteria andPattLike(String value) {
            addCriterion("patt like", value, "patt");
            return (Criteria) this;
        }

        public Criteria andPattNotLike(String value) {
            addCriterion("patt not like", value, "patt");
            return (Criteria) this;
        }

        public Criteria andPattIn(List<String> values) {
            addCriterion("patt in", values, "patt");
            return (Criteria) this;
        }

        public Criteria andPattNotIn(List<String> values) {
            addCriterion("patt not in", values, "patt");
            return (Criteria) this;
        }

        public Criteria andPattBetween(String value1, String value2) {
            addCriterion("patt between", value1, value2, "patt");
            return (Criteria) this;
        }

        public Criteria andPattNotBetween(String value1, String value2) {
            addCriterion("patt not between", value1, value2, "patt");
            return (Criteria) this;
        }

        public Criteria andTiIsNull() {
            addCriterion("ti is null");
            return (Criteria) this;
        }

        public Criteria andTiIsNotNull() {
            addCriterion("ti is not null");
            return (Criteria) this;
        }

        public Criteria andTiEqualTo(String value) {
            addCriterion("ti =", value, "ti");
            return (Criteria) this;
        }

        public Criteria andTiNotEqualTo(String value) {
            addCriterion("ti <>", value, "ti");
            return (Criteria) this;
        }

        public Criteria andTiGreaterThan(String value) {
            addCriterion("ti >", value, "ti");
            return (Criteria) this;
        }

        public Criteria andTiGreaterThanOrEqualTo(String value) {
            addCriterion("ti >=", value, "ti");
            return (Criteria) this;
        }

        public Criteria andTiLessThan(String value) {
            addCriterion("ti <", value, "ti");
            return (Criteria) this;
        }

        public Criteria andTiLessThanOrEqualTo(String value) {
            addCriterion("ti <=", value, "ti");
            return (Criteria) this;
        }

        public Criteria andTiLike(String value) {
            addCriterion("ti like", value, "ti");
            return (Criteria) this;
        }

        public Criteria andTiNotLike(String value) {
            addCriterion("ti not like", value, "ti");
            return (Criteria) this;
        }

        public Criteria andTiIn(List<String> values) {
            addCriterion("ti in", values, "ti");
            return (Criteria) this;
        }

        public Criteria andTiNotIn(List<String> values) {
            addCriterion("ti not in", values, "ti");
            return (Criteria) this;
        }

        public Criteria andTiBetween(String value1, String value2) {
            addCriterion("ti between", value1, value2, "ti");
            return (Criteria) this;
        }

        public Criteria andTiNotBetween(String value1, String value2) {
            addCriterion("ti not between", value1, value2, "ti");
            return (Criteria) this;
        }

        public Criteria andSicIsNull() {
            addCriterion("sic is null");
            return (Criteria) this;
        }

        public Criteria andSicIsNotNull() {
            addCriterion("sic is not null");
            return (Criteria) this;
        }

        public Criteria andSicEqualTo(String value) {
            addCriterion("sic =", value, "sic");
            return (Criteria) this;
        }

        public Criteria andSicNotEqualTo(String value) {
            addCriterion("sic <>", value, "sic");
            return (Criteria) this;
        }

        public Criteria andSicGreaterThan(String value) {
            addCriterion("sic >", value, "sic");
            return (Criteria) this;
        }

        public Criteria andSicGreaterThanOrEqualTo(String value) {
            addCriterion("sic >=", value, "sic");
            return (Criteria) this;
        }

        public Criteria andSicLessThan(String value) {
            addCriterion("sic <", value, "sic");
            return (Criteria) this;
        }

        public Criteria andSicLessThanOrEqualTo(String value) {
            addCriterion("sic <=", value, "sic");
            return (Criteria) this;
        }

        public Criteria andSicLike(String value) {
            addCriterion("sic like", value, "sic");
            return (Criteria) this;
        }

        public Criteria andSicNotLike(String value) {
            addCriterion("sic not like", value, "sic");
            return (Criteria) this;
        }

        public Criteria andSicIn(List<String> values) {
            addCriterion("sic in", values, "sic");
            return (Criteria) this;
        }

        public Criteria andSicNotIn(List<String> values) {
            addCriterion("sic not in", values, "sic");
            return (Criteria) this;
        }

        public Criteria andSicBetween(String value1, String value2) {
            addCriterion("sic between", value1, value2, "sic");
            return (Criteria) this;
        }

        public Criteria andSicNotBetween(String value1, String value2) {
            addCriterion("sic not between", value1, value2, "sic");
            return (Criteria) this;
        }

        public Criteria andIclnIsNull() {
            addCriterion("icln is null");
            return (Criteria) this;
        }

        public Criteria andIclnIsNotNull() {
            addCriterion("icln is not null");
            return (Criteria) this;
        }

        public Criteria andIclnEqualTo(Double value) {
            addCriterion("icln =", value, "icln");
            return (Criteria) this;
        }

        public Criteria andIclnNotEqualTo(Double value) {
            addCriterion("icln <>", value, "icln");
            return (Criteria) this;
        }

        public Criteria andIclnGreaterThan(Double value) {
            addCriterion("icln >", value, "icln");
            return (Criteria) this;
        }

        public Criteria andIclnGreaterThanOrEqualTo(Double value) {
            addCriterion("icln >=", value, "icln");
            return (Criteria) this;
        }

        public Criteria andIclnLessThan(Double value) {
            addCriterion("icln <", value, "icln");
            return (Criteria) this;
        }

        public Criteria andIclnLessThanOrEqualTo(Double value) {
            addCriterion("icln <=", value, "icln");
            return (Criteria) this;
        }

        public Criteria andIclnIn(List<Double> values) {
            addCriterion("icln in", values, "icln");
            return (Criteria) this;
        }

        public Criteria andIclnNotIn(List<Double> values) {
            addCriterion("icln not in", values, "icln");
            return (Criteria) this;
        }

        public Criteria andIclnBetween(Double value1, Double value2) {
            addCriterion("icln between", value1, value2, "icln");
            return (Criteria) this;
        }

        public Criteria andIclnNotBetween(Double value1, Double value2) {
            addCriterion("icln not between", value1, value2, "icln");
            return (Criteria) this;
        }

        public Criteria andCigcIsNull() {
            addCriterion("cigc is null");
            return (Criteria) this;
        }

        public Criteria andCigcIsNotNull() {
            addCriterion("cigc is not null");
            return (Criteria) this;
        }

        public Criteria andCigcEqualTo(Double value) {
            addCriterion("cigc =", value, "cigc");
            return (Criteria) this;
        }

        public Criteria andCigcNotEqualTo(Double value) {
            addCriterion("cigc <>", value, "cigc");
            return (Criteria) this;
        }

        public Criteria andCigcGreaterThan(Double value) {
            addCriterion("cigc >", value, "cigc");
            return (Criteria) this;
        }

        public Criteria andCigcGreaterThanOrEqualTo(Double value) {
            addCriterion("cigc >=", value, "cigc");
            return (Criteria) this;
        }

        public Criteria andCigcLessThan(Double value) {
            addCriterion("cigc <", value, "cigc");
            return (Criteria) this;
        }

        public Criteria andCigcLessThanOrEqualTo(Double value) {
            addCriterion("cigc <=", value, "cigc");
            return (Criteria) this;
        }

        public Criteria andCigcIn(List<Double> values) {
            addCriterion("cigc in", values, "cigc");
            return (Criteria) this;
        }

        public Criteria andCigcNotIn(List<Double> values) {
            addCriterion("cigc not in", values, "cigc");
            return (Criteria) this;
        }

        public Criteria andCigcBetween(Double value1, Double value2) {
            addCriterion("cigc between", value1, value2, "cigc");
            return (Criteria) this;
        }

        public Criteria andCigcNotBetween(Double value1, Double value2) {
            addCriterion("cigc not between", value1, value2, "cigc");
            return (Criteria) this;
        }

        public Criteria andDclnIsNull() {
            addCriterion("dcln is null");
            return (Criteria) this;
        }

        public Criteria andDclnIsNotNull() {
            addCriterion("dcln is not null");
            return (Criteria) this;
        }

        public Criteria andDclnEqualTo(Double value) {
            addCriterion("dcln =", value, "dcln");
            return (Criteria) this;
        }

        public Criteria andDclnNotEqualTo(Double value) {
            addCriterion("dcln <>", value, "dcln");
            return (Criteria) this;
        }

        public Criteria andDclnGreaterThan(Double value) {
            addCriterion("dcln >", value, "dcln");
            return (Criteria) this;
        }

        public Criteria andDclnGreaterThanOrEqualTo(Double value) {
            addCriterion("dcln >=", value, "dcln");
            return (Criteria) this;
        }

        public Criteria andDclnLessThan(Double value) {
            addCriterion("dcln <", value, "dcln");
            return (Criteria) this;
        }

        public Criteria andDclnLessThanOrEqualTo(Double value) {
            addCriterion("dcln <=", value, "dcln");
            return (Criteria) this;
        }

        public Criteria andDclnIn(List<Double> values) {
            addCriterion("dcln in", values, "dcln");
            return (Criteria) this;
        }

        public Criteria andDclnNotIn(List<Double> values) {
            addCriterion("dcln not in", values, "dcln");
            return (Criteria) this;
        }

        public Criteria andDclnBetween(Double value1, Double value2) {
            addCriterion("dcln between", value1, value2, "dcln");
            return (Criteria) this;
        }

        public Criteria andDclnNotBetween(Double value1, Double value2) {
            addCriterion("dcln not between", value1, value2, "dcln");
            return (Criteria) this;
        }

        public Criteria andCltIsNull() {
            addCriterion("clt is null");
            return (Criteria) this;
        }

        public Criteria andCltIsNotNull() {
            addCriterion("clt is not null");
            return (Criteria) this;
        }

        public Criteria andCltEqualTo(String value) {
            addCriterion("clt =", value, "clt");
            return (Criteria) this;
        }

        public Criteria andCltNotEqualTo(String value) {
            addCriterion("clt <>", value, "clt");
            return (Criteria) this;
        }

        public Criteria andCltGreaterThan(String value) {
            addCriterion("clt >", value, "clt");
            return (Criteria) this;
        }

        public Criteria andCltGreaterThanOrEqualTo(String value) {
            addCriterion("clt >=", value, "clt");
            return (Criteria) this;
        }

        public Criteria andCltLessThan(String value) {
            addCriterion("clt <", value, "clt");
            return (Criteria) this;
        }

        public Criteria andCltLessThanOrEqualTo(String value) {
            addCriterion("clt <=", value, "clt");
            return (Criteria) this;
        }

        public Criteria andCltLike(String value) {
            addCriterion("clt like", value, "clt");
            return (Criteria) this;
        }

        public Criteria andCltNotLike(String value) {
            addCriterion("clt not like", value, "clt");
            return (Criteria) this;
        }

        public Criteria andCltIn(List<String> values) {
            addCriterion("clt in", values, "clt");
            return (Criteria) this;
        }

        public Criteria andCltNotIn(List<String> values) {
            addCriterion("clt not in", values, "clt");
            return (Criteria) this;
        }

        public Criteria andCltBetween(String value1, String value2) {
            addCriterion("clt between", value1, value2, "clt");
            return (Criteria) this;
        }

        public Criteria andCltNotBetween(String value1, String value2) {
            addCriterion("clt not between", value1, value2, "clt");
            return (Criteria) this;
        }

        public Criteria andIpcscIsNull() {
            addCriterion("ipcsc is null");
            return (Criteria) this;
        }

        public Criteria andIpcscIsNotNull() {
            addCriterion("ipcsc is not null");
            return (Criteria) this;
        }

        public Criteria andIpcscEqualTo(Double value) {
            addCriterion("ipcsc =", value, "ipcsc");
            return (Criteria) this;
        }

        public Criteria andIpcscNotEqualTo(Double value) {
            addCriterion("ipcsc <>", value, "ipcsc");
            return (Criteria) this;
        }

        public Criteria andIpcscGreaterThan(Double value) {
            addCriterion("ipcsc >", value, "ipcsc");
            return (Criteria) this;
        }

        public Criteria andIpcscGreaterThanOrEqualTo(Double value) {
            addCriterion("ipcsc >=", value, "ipcsc");
            return (Criteria) this;
        }

        public Criteria andIpcscLessThan(Double value) {
            addCriterion("ipcsc <", value, "ipcsc");
            return (Criteria) this;
        }

        public Criteria andIpcscLessThanOrEqualTo(Double value) {
            addCriterion("ipcsc <=", value, "ipcsc");
            return (Criteria) this;
        }

        public Criteria andIpcscIn(List<Double> values) {
            addCriterion("ipcsc in", values, "ipcsc");
            return (Criteria) this;
        }

        public Criteria andIpcscNotIn(List<Double> values) {
            addCriterion("ipcsc not in", values, "ipcsc");
            return (Criteria) this;
        }

        public Criteria andIpcscBetween(Double value1, Double value2) {
            addCriterion("ipcsc between", value1, value2, "ipcsc");
            return (Criteria) this;
        }

        public Criteria andIpcscNotBetween(Double value1, Double value2) {
            addCriterion("ipcsc not between", value1, value2, "ipcsc");
            return (Criteria) this;
        }

        public Criteria andRmnIsNull() {
            addCriterion("rmn is null");
            return (Criteria) this;
        }

        public Criteria andRmnIsNotNull() {
            addCriterion("rmn is not null");
            return (Criteria) this;
        }

        public Criteria andRmnEqualTo(Double value) {
            addCriterion("rmn =", value, "rmn");
            return (Criteria) this;
        }

        public Criteria andRmnNotEqualTo(Double value) {
            addCriterion("rmn <>", value, "rmn");
            return (Criteria) this;
        }

        public Criteria andRmnGreaterThan(Double value) {
            addCriterion("rmn >", value, "rmn");
            return (Criteria) this;
        }

        public Criteria andRmnGreaterThanOrEqualTo(Double value) {
            addCriterion("rmn >=", value, "rmn");
            return (Criteria) this;
        }

        public Criteria andRmnLessThan(Double value) {
            addCriterion("rmn <", value, "rmn");
            return (Criteria) this;
        }

        public Criteria andRmnLessThanOrEqualTo(Double value) {
            addCriterion("rmn <=", value, "rmn");
            return (Criteria) this;
        }

        public Criteria andRmnIn(List<Double> values) {
            addCriterion("rmn in", values, "rmn");
            return (Criteria) this;
        }

        public Criteria andRmnNotIn(List<Double> values) {
            addCriterion("rmn not in", values, "rmn");
            return (Criteria) this;
        }

        public Criteria andRmnBetween(Double value1, Double value2) {
            addCriterion("rmn between", value1, value2, "rmn");
            return (Criteria) this;
        }

        public Criteria andRmnNotBetween(Double value1, Double value2) {
            addCriterion("rmn not between", value1, value2, "rmn");
            return (Criteria) this;
        }

        public Criteria andCipcIsNull() {
            addCriterion("cipc is null");
            return (Criteria) this;
        }

        public Criteria andCipcIsNotNull() {
            addCriterion("cipc is not null");
            return (Criteria) this;
        }

        public Criteria andCipcEqualTo(Double value) {
            addCriterion("cipc =", value, "cipc");
            return (Criteria) this;
        }

        public Criteria andCipcNotEqualTo(Double value) {
            addCriterion("cipc <>", value, "cipc");
            return (Criteria) this;
        }

        public Criteria andCipcGreaterThan(Double value) {
            addCriterion("cipc >", value, "cipc");
            return (Criteria) this;
        }

        public Criteria andCipcGreaterThanOrEqualTo(Double value) {
            addCriterion("cipc >=", value, "cipc");
            return (Criteria) this;
        }

        public Criteria andCipcLessThan(Double value) {
            addCriterion("cipc <", value, "cipc");
            return (Criteria) this;
        }

        public Criteria andCipcLessThanOrEqualTo(Double value) {
            addCriterion("cipc <=", value, "cipc");
            return (Criteria) this;
        }

        public Criteria andCipcIn(List<Double> values) {
            addCriterion("cipc in", values, "cipc");
            return (Criteria) this;
        }

        public Criteria andCipcNotIn(List<Double> values) {
            addCriterion("cipc not in", values, "cipc");
            return (Criteria) this;
        }

        public Criteria andCipcBetween(Double value1, Double value2) {
            addCriterion("cipc between", value1, value2, "cipc");
            return (Criteria) this;
        }

        public Criteria andCipcNotBetween(Double value1, Double value2) {
            addCriterion("cipc not between", value1, value2, "cipc");
            return (Criteria) this;
        }

        public Criteria andIncoIsNull() {
            addCriterion("inco is null");
            return (Criteria) this;
        }

        public Criteria andIncoIsNotNull() {
            addCriterion("inco is not null");
            return (Criteria) this;
        }

        public Criteria andIncoEqualTo(Double value) {
            addCriterion("inco =", value, "inco");
            return (Criteria) this;
        }

        public Criteria andIncoNotEqualTo(Double value) {
            addCriterion("inco <>", value, "inco");
            return (Criteria) this;
        }

        public Criteria andIncoGreaterThan(Double value) {
            addCriterion("inco >", value, "inco");
            return (Criteria) this;
        }

        public Criteria andIncoGreaterThanOrEqualTo(Double value) {
            addCriterion("inco >=", value, "inco");
            return (Criteria) this;
        }

        public Criteria andIncoLessThan(Double value) {
            addCriterion("inco <", value, "inco");
            return (Criteria) this;
        }

        public Criteria andIncoLessThanOrEqualTo(Double value) {
            addCriterion("inco <=", value, "inco");
            return (Criteria) this;
        }

        public Criteria andIncoIn(List<Double> values) {
            addCriterion("inco in", values, "inco");
            return (Criteria) this;
        }

        public Criteria andIncoNotIn(List<Double> values) {
            addCriterion("inco not in", values, "inco");
            return (Criteria) this;
        }

        public Criteria andIncoBetween(Double value1, Double value2) {
            addCriterion("inco between", value1, value2, "inco");
            return (Criteria) this;
        }

        public Criteria andIncoNotBetween(Double value1, Double value2) {
            addCriterion("inco not between", value1, value2, "inco");
            return (Criteria) this;
        }

        public Criteria andPdtIsNull() {
            addCriterion("pdt is null");
            return (Criteria) this;
        }

        public Criteria andPdtIsNotNull() {
            addCriterion("pdt is not null");
            return (Criteria) this;
        }

        public Criteria andPdtEqualTo(String value) {
            addCriterion("pdt =", value, "pdt");
            return (Criteria) this;
        }

        public Criteria andPdtNotEqualTo(String value) {
            addCriterion("pdt <>", value, "pdt");
            return (Criteria) this;
        }

        public Criteria andPdtGreaterThan(String value) {
            addCriterion("pdt >", value, "pdt");
            return (Criteria) this;
        }

        public Criteria andPdtGreaterThanOrEqualTo(String value) {
            addCriterion("pdt >=", value, "pdt");
            return (Criteria) this;
        }

        public Criteria andPdtLessThan(String value) {
            addCriterion("pdt <", value, "pdt");
            return (Criteria) this;
        }

        public Criteria andPdtLessThanOrEqualTo(String value) {
            addCriterion("pdt <=", value, "pdt");
            return (Criteria) this;
        }

        public Criteria andPdtLike(String value) {
            addCriterion("pdt like", value, "pdt");
            return (Criteria) this;
        }

        public Criteria andPdtNotLike(String value) {
            addCriterion("pdt not like", value, "pdt");
            return (Criteria) this;
        }

        public Criteria andPdtIn(List<String> values) {
            addCriterion("pdt in", values, "pdt");
            return (Criteria) this;
        }

        public Criteria andPdtNotIn(List<String> values) {
            addCriterion("pdt not in", values, "pdt");
            return (Criteria) this;
        }

        public Criteria andPdtBetween(String value1, String value2) {
            addCriterion("pdt between", value1, value2, "pdt");
            return (Criteria) this;
        }

        public Criteria andPdtNotBetween(String value1, String value2) {
            addCriterion("pdt not between", value1, value2, "pdt");
            return (Criteria) this;
        }

        public Criteria andPlicIsNull() {
            addCriterion("plic is null");
            return (Criteria) this;
        }

        public Criteria andPlicIsNotNull() {
            addCriterion("plic is not null");
            return (Criteria) this;
        }

        public Criteria andPlicEqualTo(Double value) {
            addCriterion("plic =", value, "plic");
            return (Criteria) this;
        }

        public Criteria andPlicNotEqualTo(Double value) {
            addCriterion("plic <>", value, "plic");
            return (Criteria) this;
        }

        public Criteria andPlicGreaterThan(Double value) {
            addCriterion("plic >", value, "plic");
            return (Criteria) this;
        }

        public Criteria andPlicGreaterThanOrEqualTo(Double value) {
            addCriterion("plic >=", value, "plic");
            return (Criteria) this;
        }

        public Criteria andPlicLessThan(Double value) {
            addCriterion("plic <", value, "plic");
            return (Criteria) this;
        }

        public Criteria andPlicLessThanOrEqualTo(Double value) {
            addCriterion("plic <=", value, "plic");
            return (Criteria) this;
        }

        public Criteria andPlicIn(List<Double> values) {
            addCriterion("plic in", values, "plic");
            return (Criteria) this;
        }

        public Criteria andPlicNotIn(List<Double> values) {
            addCriterion("plic not in", values, "plic");
            return (Criteria) this;
        }

        public Criteria andPlicBetween(Double value1, Double value2) {
            addCriterion("plic between", value1, value2, "plic");
            return (Criteria) this;
        }

        public Criteria andPlicNotBetween(Double value1, Double value2) {
            addCriterion("plic not between", value1, value2, "plic");
            return (Criteria) this;
        }

        public Criteria andPccIsNull() {
            addCriterion("pcc is null");
            return (Criteria) this;
        }

        public Criteria andPccIsNotNull() {
            addCriterion("pcc is not null");
            return (Criteria) this;
        }

        public Criteria andPccEqualTo(Double value) {
            addCriterion("pcc =", value, "pcc");
            return (Criteria) this;
        }

        public Criteria andPccNotEqualTo(Double value) {
            addCriterion("pcc <>", value, "pcc");
            return (Criteria) this;
        }

        public Criteria andPccGreaterThan(Double value) {
            addCriterion("pcc >", value, "pcc");
            return (Criteria) this;
        }

        public Criteria andPccGreaterThanOrEqualTo(Double value) {
            addCriterion("pcc >=", value, "pcc");
            return (Criteria) this;
        }

        public Criteria andPccLessThan(Double value) {
            addCriterion("pcc <", value, "pcc");
            return (Criteria) this;
        }

        public Criteria andPccLessThanOrEqualTo(Double value) {
            addCriterion("pcc <=", value, "pcc");
            return (Criteria) this;
        }

        public Criteria andPccIn(List<Double> values) {
            addCriterion("pcc in", values, "pcc");
            return (Criteria) this;
        }

        public Criteria andPccNotIn(List<Double> values) {
            addCriterion("pcc not in", values, "pcc");
            return (Criteria) this;
        }

        public Criteria andPccBetween(Double value1, Double value2) {
            addCriterion("pcc between", value1, value2, "pcc");
            return (Criteria) this;
        }

        public Criteria andPccNotBetween(Double value1, Double value2) {
            addCriterion("pcc not between", value1, value2, "pcc");
            return (Criteria) this;
        }

        public Criteria andPpcIsNull() {
            addCriterion("ppc is null");
            return (Criteria) this;
        }

        public Criteria andPpcIsNotNull() {
            addCriterion("ppc is not null");
            return (Criteria) this;
        }

        public Criteria andPpcEqualTo(Double value) {
            addCriterion("ppc =", value, "ppc");
            return (Criteria) this;
        }

        public Criteria andPpcNotEqualTo(Double value) {
            addCriterion("ppc <>", value, "ppc");
            return (Criteria) this;
        }

        public Criteria andPpcGreaterThan(Double value) {
            addCriterion("ppc >", value, "ppc");
            return (Criteria) this;
        }

        public Criteria andPpcGreaterThanOrEqualTo(Double value) {
            addCriterion("ppc >=", value, "ppc");
            return (Criteria) this;
        }

        public Criteria andPpcLessThan(Double value) {
            addCriterion("ppc <", value, "ppc");
            return (Criteria) this;
        }

        public Criteria andPpcLessThanOrEqualTo(Double value) {
            addCriterion("ppc <=", value, "ppc");
            return (Criteria) this;
        }

        public Criteria andPpcIn(List<Double> values) {
            addCriterion("ppc in", values, "ppc");
            return (Criteria) this;
        }

        public Criteria andPpcNotIn(List<Double> values) {
            addCriterion("ppc not in", values, "ppc");
            return (Criteria) this;
        }

        public Criteria andPpcBetween(Double value1, Double value2) {
            addCriterion("ppc between", value1, value2, "ppc");
            return (Criteria) this;
        }

        public Criteria andPpcNotBetween(Double value1, Double value2) {
            addCriterion("ppc not between", value1, value2, "ppc");
            return (Criteria) this;
        }

        public Criteria andTccIsNull() {
            addCriterion("tcc is null");
            return (Criteria) this;
        }

        public Criteria andTccIsNotNull() {
            addCriterion("tcc is not null");
            return (Criteria) this;
        }

        public Criteria andTccEqualTo(Double value) {
            addCriterion("tcc =", value, "tcc");
            return (Criteria) this;
        }

        public Criteria andTccNotEqualTo(Double value) {
            addCriterion("tcc <>", value, "tcc");
            return (Criteria) this;
        }

        public Criteria andTccGreaterThan(Double value) {
            addCriterion("tcc >", value, "tcc");
            return (Criteria) this;
        }

        public Criteria andTccGreaterThanOrEqualTo(Double value) {
            addCriterion("tcc >=", value, "tcc");
            return (Criteria) this;
        }

        public Criteria andTccLessThan(Double value) {
            addCriterion("tcc <", value, "tcc");
            return (Criteria) this;
        }

        public Criteria andTccLessThanOrEqualTo(Double value) {
            addCriterion("tcc <=", value, "tcc");
            return (Criteria) this;
        }

        public Criteria andTccIn(List<Double> values) {
            addCriterion("tcc in", values, "tcc");
            return (Criteria) this;
        }

        public Criteria andTccNotIn(List<Double> values) {
            addCriterion("tcc not in", values, "tcc");
            return (Criteria) this;
        }

        public Criteria andTccBetween(Double value1, Double value2) {
            addCriterion("tcc between", value1, value2, "tcc");
            return (Criteria) this;
        }

        public Criteria andTccNotBetween(Double value1, Double value2) {
            addCriterion("tcc not between", value1, value2, "tcc");
            return (Criteria) this;
        }

        public Criteria andDespageIsNull() {
            addCriterion("despage is null");
            return (Criteria) this;
        }

        public Criteria andDespageIsNotNull() {
            addCriterion("despage is not null");
            return (Criteria) this;
        }

        public Criteria andDespageEqualTo(Double value) {
            addCriterion("despage =", value, "despage");
            return (Criteria) this;
        }

        public Criteria andDespageNotEqualTo(Double value) {
            addCriterion("despage <>", value, "despage");
            return (Criteria) this;
        }

        public Criteria andDespageGreaterThan(Double value) {
            addCriterion("despage >", value, "despage");
            return (Criteria) this;
        }

        public Criteria andDespageGreaterThanOrEqualTo(Double value) {
            addCriterion("despage >=", value, "despage");
            return (Criteria) this;
        }

        public Criteria andDespageLessThan(Double value) {
            addCriterion("despage <", value, "despage");
            return (Criteria) this;
        }

        public Criteria andDespageLessThanOrEqualTo(Double value) {
            addCriterion("despage <=", value, "despage");
            return (Criteria) this;
        }

        public Criteria andDespageIn(List<Double> values) {
            addCriterion("despage in", values, "despage");
            return (Criteria) this;
        }

        public Criteria andDespageNotIn(List<Double> values) {
            addCriterion("despage not in", values, "despage");
            return (Criteria) this;
        }

        public Criteria andDespageBetween(Double value1, Double value2) {
            addCriterion("despage between", value1, value2, "despage");
            return (Criteria) this;
        }

        public Criteria andDespageNotBetween(Double value1, Double value2) {
            addCriterion("despage not between", value1, value2, "despage");
            return (Criteria) this;
        }

        public Criteria andDrawpageIsNull() {
            addCriterion("drawpage is null");
            return (Criteria) this;
        }

        public Criteria andDrawpageIsNotNull() {
            addCriterion("drawpage is not null");
            return (Criteria) this;
        }

        public Criteria andDrawpageEqualTo(Double value) {
            addCriterion("drawpage =", value, "drawpage");
            return (Criteria) this;
        }

        public Criteria andDrawpageNotEqualTo(Double value) {
            addCriterion("drawpage <>", value, "drawpage");
            return (Criteria) this;
        }

        public Criteria andDrawpageGreaterThan(Double value) {
            addCriterion("drawpage >", value, "drawpage");
            return (Criteria) this;
        }

        public Criteria andDrawpageGreaterThanOrEqualTo(Double value) {
            addCriterion("drawpage >=", value, "drawpage");
            return (Criteria) this;
        }

        public Criteria andDrawpageLessThan(Double value) {
            addCriterion("drawpage <", value, "drawpage");
            return (Criteria) this;
        }

        public Criteria andDrawpageLessThanOrEqualTo(Double value) {
            addCriterion("drawpage <=", value, "drawpage");
            return (Criteria) this;
        }

        public Criteria andDrawpageIn(List<Double> values) {
            addCriterion("drawpage in", values, "drawpage");
            return (Criteria) this;
        }

        public Criteria andDrawpageNotIn(List<Double> values) {
            addCriterion("drawpage not in", values, "drawpage");
            return (Criteria) this;
        }

        public Criteria andDrawpageBetween(Double value1, Double value2) {
            addCriterion("drawpage between", value1, value2, "drawpage");
            return (Criteria) this;
        }

        public Criteria andDrawpageNotBetween(Double value1, Double value2) {
            addCriterion("drawpage not between", value1, value2, "drawpage");
            return (Criteria) this;
        }

        public Criteria andSfclIsNull() {
            addCriterion("sfcl is null");
            return (Criteria) this;
        }

        public Criteria andSfclIsNotNull() {
            addCriterion("sfcl is not null");
            return (Criteria) this;
        }

        public Criteria andSfclEqualTo(Double value) {
            addCriterion("sfcl =", value, "sfcl");
            return (Criteria) this;
        }

        public Criteria andSfclNotEqualTo(Double value) {
            addCriterion("sfcl <>", value, "sfcl");
            return (Criteria) this;
        }

        public Criteria andSfclGreaterThan(Double value) {
            addCriterion("sfcl >", value, "sfcl");
            return (Criteria) this;
        }

        public Criteria andSfclGreaterThanOrEqualTo(Double value) {
            addCriterion("sfcl >=", value, "sfcl");
            return (Criteria) this;
        }

        public Criteria andSfclLessThan(Double value) {
            addCriterion("sfcl <", value, "sfcl");
            return (Criteria) this;
        }

        public Criteria andSfclLessThanOrEqualTo(Double value) {
            addCriterion("sfcl <=", value, "sfcl");
            return (Criteria) this;
        }

        public Criteria andSfclIn(List<Double> values) {
            addCriterion("sfcl in", values, "sfcl");
            return (Criteria) this;
        }

        public Criteria andSfclNotIn(List<Double> values) {
            addCriterion("sfcl not in", values, "sfcl");
            return (Criteria) this;
        }

        public Criteria andSfclBetween(Double value1, Double value2) {
            addCriterion("sfcl between", value1, value2, "sfcl");
            return (Criteria) this;
        }

        public Criteria andSfclNotBetween(Double value1, Double value2) {
            addCriterion("sfcl not between", value1, value2, "sfcl");
            return (Criteria) this;
        }

        public Criteria andFajpIsNull() {
            addCriterion("fajp is null");
            return (Criteria) this;
        }

        public Criteria andFajpIsNotNull() {
            addCriterion("fajp is not null");
            return (Criteria) this;
        }

        public Criteria andFajpEqualTo(Double value) {
            addCriterion("fajp =", value, "fajp");
            return (Criteria) this;
        }

        public Criteria andFajpNotEqualTo(Double value) {
            addCriterion("fajp <>", value, "fajp");
            return (Criteria) this;
        }

        public Criteria andFajpGreaterThan(Double value) {
            addCriterion("fajp >", value, "fajp");
            return (Criteria) this;
        }

        public Criteria andFajpGreaterThanOrEqualTo(Double value) {
            addCriterion("fajp >=", value, "fajp");
            return (Criteria) this;
        }

        public Criteria andFajpLessThan(Double value) {
            addCriterion("fajp <", value, "fajp");
            return (Criteria) this;
        }

        public Criteria andFajpLessThanOrEqualTo(Double value) {
            addCriterion("fajp <=", value, "fajp");
            return (Criteria) this;
        }

        public Criteria andFajpIn(List<Double> values) {
            addCriterion("fajp in", values, "fajp");
            return (Criteria) this;
        }

        public Criteria andFajpNotIn(List<Double> values) {
            addCriterion("fajp not in", values, "fajp");
            return (Criteria) this;
        }

        public Criteria andFajpBetween(Double value1, Double value2) {
            addCriterion("fajp between", value1, value2, "fajp");
            return (Criteria) this;
        }

        public Criteria andFajpNotBetween(Double value1, Double value2) {
            addCriterion("fajp not between", value1, value2, "fajp");
            return (Criteria) this;
        }

        public Criteria andFausIsNull() {
            addCriterion("faus is null");
            return (Criteria) this;
        }

        public Criteria andFausIsNotNull() {
            addCriterion("faus is not null");
            return (Criteria) this;
        }

        public Criteria andFausEqualTo(Double value) {
            addCriterion("faus =", value, "faus");
            return (Criteria) this;
        }

        public Criteria andFausNotEqualTo(Double value) {
            addCriterion("faus <>", value, "faus");
            return (Criteria) this;
        }

        public Criteria andFausGreaterThan(Double value) {
            addCriterion("faus >", value, "faus");
            return (Criteria) this;
        }

        public Criteria andFausGreaterThanOrEqualTo(Double value) {
            addCriterion("faus >=", value, "faus");
            return (Criteria) this;
        }

        public Criteria andFausLessThan(Double value) {
            addCriterion("faus <", value, "faus");
            return (Criteria) this;
        }

        public Criteria andFausLessThanOrEqualTo(Double value) {
            addCriterion("faus <=", value, "faus");
            return (Criteria) this;
        }

        public Criteria andFausIn(List<Double> values) {
            addCriterion("faus in", values, "faus");
            return (Criteria) this;
        }

        public Criteria andFausNotIn(List<Double> values) {
            addCriterion("faus not in", values, "faus");
            return (Criteria) this;
        }

        public Criteria andFausBetween(Double value1, Double value2) {
            addCriterion("faus between", value1, value2, "faus");
            return (Criteria) this;
        }

        public Criteria andFausNotBetween(Double value1, Double value2) {
            addCriterion("faus not between", value1, value2, "faus");
            return (Criteria) this;
        }

        public Criteria andFaotIsNull() {
            addCriterion("faot is null");
            return (Criteria) this;
        }

        public Criteria andFaotIsNotNull() {
            addCriterion("faot is not null");
            return (Criteria) this;
        }

        public Criteria andFaotEqualTo(Double value) {
            addCriterion("faot =", value, "faot");
            return (Criteria) this;
        }

        public Criteria andFaotNotEqualTo(Double value) {
            addCriterion("faot <>", value, "faot");
            return (Criteria) this;
        }

        public Criteria andFaotGreaterThan(Double value) {
            addCriterion("faot >", value, "faot");
            return (Criteria) this;
        }

        public Criteria andFaotGreaterThanOrEqualTo(Double value) {
            addCriterion("faot >=", value, "faot");
            return (Criteria) this;
        }

        public Criteria andFaotLessThan(Double value) {
            addCriterion("faot <", value, "faot");
            return (Criteria) this;
        }

        public Criteria andFaotLessThanOrEqualTo(Double value) {
            addCriterion("faot <=", value, "faot");
            return (Criteria) this;
        }

        public Criteria andFaotIn(List<Double> values) {
            addCriterion("faot in", values, "faot");
            return (Criteria) this;
        }

        public Criteria andFaotNotIn(List<Double> values) {
            addCriterion("faot not in", values, "faot");
            return (Criteria) this;
        }

        public Criteria andFaotBetween(Double value1, Double value2) {
            addCriterion("faot between", value1, value2, "faot");
            return (Criteria) this;
        }

        public Criteria andFaotNotBetween(Double value1, Double value2) {
            addCriterion("faot not between", value1, value2, "faot");
            return (Criteria) this;
        }

        public Criteria andAdIsNull() {
            addCriterion("ad is null");
            return (Criteria) this;
        }

        public Criteria andAdIsNotNull() {
            addCriterion("ad is not null");
            return (Criteria) this;
        }

        public Criteria andAdEqualTo(String value) {
            addCriterion("ad =", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdNotEqualTo(String value) {
            addCriterion("ad <>", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdGreaterThan(String value) {
            addCriterion("ad >", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdGreaterThanOrEqualTo(String value) {
            addCriterion("ad >=", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdLessThan(String value) {
            addCriterion("ad <", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdLessThanOrEqualTo(String value) {
            addCriterion("ad <=", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdLike(String value) {
            addCriterion("ad like", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdNotLike(String value) {
            addCriterion("ad not like", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdIn(List<String> values) {
            addCriterion("ad in", values, "ad");
            return (Criteria) this;
        }

        public Criteria andAdNotIn(List<String> values) {
            addCriterion("ad not in", values, "ad");
            return (Criteria) this;
        }

        public Criteria andAdBetween(String value1, String value2) {
            addCriterion("ad between", value1, value2, "ad");
            return (Criteria) this;
        }

        public Criteria andAdNotBetween(String value1, String value2) {
            addCriterion("ad not between", value1, value2, "ad");
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