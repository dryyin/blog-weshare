package com.gitsck.pojo;

import java.util.ArrayList;
import java.util.List;

public class GArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GArticleExample() {
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

        public Criteria andAIdIsNull() {
            addCriterion("a_id is null");
            return (Criteria) this;
        }

        public Criteria andAIdIsNotNull() {
            addCriterion("a_id is not null");
            return (Criteria) this;
        }

        public Criteria andAIdEqualTo(Long value) {
            addCriterion("a_id =", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdNotEqualTo(Long value) {
            addCriterion("a_id <>", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdGreaterThan(Long value) {
            addCriterion("a_id >", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdGreaterThanOrEqualTo(Long value) {
            addCriterion("a_id >=", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdLessThan(Long value) {
            addCriterion("a_id <", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdLessThanOrEqualTo(Long value) {
            addCriterion("a_id <=", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdIn(List<Long> values) {
            addCriterion("a_id in", values, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdNotIn(List<Long> values) {
            addCriterion("a_id not in", values, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdBetween(Long value1, Long value2) {
            addCriterion("a_id between", value1, value2, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdNotBetween(Long value1, Long value2) {
            addCriterion("a_id not between", value1, value2, "aId");
            return (Criteria) this;
        }

        public Criteria andATitleIsNull() {
            addCriterion("a_title is null");
            return (Criteria) this;
        }

        public Criteria andATitleIsNotNull() {
            addCriterion("a_title is not null");
            return (Criteria) this;
        }

        public Criteria andATitleEqualTo(String value) {
            addCriterion("a_title =", value, "aTitle");
            return (Criteria) this;
        }

        public Criteria andATitleNotEqualTo(String value) {
            addCriterion("a_title <>", value, "aTitle");
            return (Criteria) this;
        }

        public Criteria andATitleGreaterThan(String value) {
            addCriterion("a_title >", value, "aTitle");
            return (Criteria) this;
        }

        public Criteria andATitleGreaterThanOrEqualTo(String value) {
            addCriterion("a_title >=", value, "aTitle");
            return (Criteria) this;
        }

        public Criteria andATitleLessThan(String value) {
            addCriterion("a_title <", value, "aTitle");
            return (Criteria) this;
        }

        public Criteria andATitleLessThanOrEqualTo(String value) {
            addCriterion("a_title <=", value, "aTitle");
            return (Criteria) this;
        }

        public Criteria andATitleLike(String value) {
            addCriterion("a_title like", value, "aTitle");
            return (Criteria) this;
        }

        public Criteria andATitleNotLike(String value) {
            addCriterion("a_title not like", value, "aTitle");
            return (Criteria) this;
        }

        public Criteria andATitleIn(List<String> values) {
            addCriterion("a_title in", values, "aTitle");
            return (Criteria) this;
        }

        public Criteria andATitleNotIn(List<String> values) {
            addCriterion("a_title not in", values, "aTitle");
            return (Criteria) this;
        }

        public Criteria andATitleBetween(String value1, String value2) {
            addCriterion("a_title between", value1, value2, "aTitle");
            return (Criteria) this;
        }

        public Criteria andATitleNotBetween(String value1, String value2) {
            addCriterion("a_title not between", value1, value2, "aTitle");
            return (Criteria) this;
        }

        public Criteria andAViewIsNull() {
            addCriterion("a_view is null");
            return (Criteria) this;
        }

        public Criteria andAViewIsNotNull() {
            addCriterion("a_view is not null");
            return (Criteria) this;
        }

        public Criteria andAViewEqualTo(Integer value) {
            addCriterion("a_view =", value, "aView");
            return (Criteria) this;
        }

        public Criteria andAViewNotEqualTo(Integer value) {
            addCriterion("a_view <>", value, "aView");
            return (Criteria) this;
        }

        public Criteria andAViewGreaterThan(Integer value) {
            addCriterion("a_view >", value, "aView");
            return (Criteria) this;
        }

        public Criteria andAViewGreaterThanOrEqualTo(Integer value) {
            addCriterion("a_view >=", value, "aView");
            return (Criteria) this;
        }

        public Criteria andAViewLessThan(Integer value) {
            addCriterion("a_view <", value, "aView");
            return (Criteria) this;
        }

        public Criteria andAViewLessThanOrEqualTo(Integer value) {
            addCriterion("a_view <=", value, "aView");
            return (Criteria) this;
        }

        public Criteria andAViewIn(List<Integer> values) {
            addCriterion("a_view in", values, "aView");
            return (Criteria) this;
        }

        public Criteria andAViewNotIn(List<Integer> values) {
            addCriterion("a_view not in", values, "aView");
            return (Criteria) this;
        }

        public Criteria andAViewBetween(Integer value1, Integer value2) {
            addCriterion("a_view between", value1, value2, "aView");
            return (Criteria) this;
        }

        public Criteria andAViewNotBetween(Integer value1, Integer value2) {
            addCriterion("a_view not between", value1, value2, "aView");
            return (Criteria) this;
        }

        public Criteria andKIdIsNull() {
            addCriterion("k_id is null");
            return (Criteria) this;
        }

        public Criteria andKIdIsNotNull() {
            addCriterion("k_id is not null");
            return (Criteria) this;
        }

        public Criteria andKIdEqualTo(Long value) {
            addCriterion("k_id =", value, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdNotEqualTo(Long value) {
            addCriterion("k_id <>", value, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdGreaterThan(Long value) {
            addCriterion("k_id >", value, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdGreaterThanOrEqualTo(Long value) {
            addCriterion("k_id >=", value, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdLessThan(Long value) {
            addCriterion("k_id <", value, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdLessThanOrEqualTo(Long value) {
            addCriterion("k_id <=", value, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdIn(List<Long> values) {
            addCriterion("k_id in", values, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdNotIn(List<Long> values) {
            addCriterion("k_id not in", values, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdBetween(Long value1, Long value2) {
            addCriterion("k_id between", value1, value2, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdNotBetween(Long value1, Long value2) {
            addCriterion("k_id not between", value1, value2, "kId");
            return (Criteria) this;
        }

        public Criteria andACretimeIsNull() {
            addCriterion("a_cretime is null");
            return (Criteria) this;
        }

        public Criteria andACretimeIsNotNull() {
            addCriterion("a_cretime is not null");
            return (Criteria) this;
        }

        public Criteria andACretimeEqualTo(String value) {
            addCriterion("a_cretime =", value, "aCretime");
            return (Criteria) this;
        }

        public Criteria andACretimeNotEqualTo(String value) {
            addCriterion("a_cretime <>", value, "aCretime");
            return (Criteria) this;
        }

        public Criteria andACretimeGreaterThan(String value) {
            addCriterion("a_cretime >", value, "aCretime");
            return (Criteria) this;
        }

        public Criteria andACretimeGreaterThanOrEqualTo(String value) {
            addCriterion("a_cretime >=", value, "aCretime");
            return (Criteria) this;
        }

        public Criteria andACretimeLessThan(String value) {
            addCriterion("a_cretime <", value, "aCretime");
            return (Criteria) this;
        }

        public Criteria andACretimeLessThanOrEqualTo(String value) {
            addCriterion("a_cretime <=", value, "aCretime");
            return (Criteria) this;
        }

        public Criteria andACretimeLike(String value) {
            addCriterion("a_cretime like", value, "aCretime");
            return (Criteria) this;
        }

        public Criteria andACretimeNotLike(String value) {
            addCriterion("a_cretime not like", value, "aCretime");
            return (Criteria) this;
        }

        public Criteria andACretimeIn(List<String> values) {
            addCriterion("a_cretime in", values, "aCretime");
            return (Criteria) this;
        }

        public Criteria andACretimeNotIn(List<String> values) {
            addCriterion("a_cretime not in", values, "aCretime");
            return (Criteria) this;
        }

        public Criteria andACretimeBetween(String value1, String value2) {
            addCriterion("a_cretime between", value1, value2, "aCretime");
            return (Criteria) this;
        }

        public Criteria andACretimeNotBetween(String value1, String value2) {
            addCriterion("a_cretime not between", value1, value2, "aCretime");
            return (Criteria) this;
        }

        public Criteria andAExtendsIsNull() {
            addCriterion("a_extends is null");
            return (Criteria) this;
        }

        public Criteria andAExtendsIsNotNull() {
            addCriterion("a_extends is not null");
            return (Criteria) this;
        }

        public Criteria andAExtendsEqualTo(String value) {
            addCriterion("a_extends =", value, "aExtends");
            return (Criteria) this;
        }

        public Criteria andAExtendsNotEqualTo(String value) {
            addCriterion("a_extends <>", value, "aExtends");
            return (Criteria) this;
        }

        public Criteria andAExtendsGreaterThan(String value) {
            addCriterion("a_extends >", value, "aExtends");
            return (Criteria) this;
        }

        public Criteria andAExtendsGreaterThanOrEqualTo(String value) {
            addCriterion("a_extends >=", value, "aExtends");
            return (Criteria) this;
        }

        public Criteria andAExtendsLessThan(String value) {
            addCriterion("a_extends <", value, "aExtends");
            return (Criteria) this;
        }

        public Criteria andAExtendsLessThanOrEqualTo(String value) {
            addCriterion("a_extends <=", value, "aExtends");
            return (Criteria) this;
        }

        public Criteria andAExtendsLike(String value) {
            addCriterion("a_extends like", value, "aExtends");
            return (Criteria) this;
        }

        public Criteria andAExtendsNotLike(String value) {
            addCriterion("a_extends not like", value, "aExtends");
            return (Criteria) this;
        }

        public Criteria andAExtendsIn(List<String> values) {
            addCriterion("a_extends in", values, "aExtends");
            return (Criteria) this;
        }

        public Criteria andAExtendsNotIn(List<String> values) {
            addCriterion("a_extends not in", values, "aExtends");
            return (Criteria) this;
        }

        public Criteria andAExtendsBetween(String value1, String value2) {
            addCriterion("a_extends between", value1, value2, "aExtends");
            return (Criteria) this;
        }

        public Criteria andAExtendsNotBetween(String value1, String value2) {
            addCriterion("a_extends not between", value1, value2, "aExtends");
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