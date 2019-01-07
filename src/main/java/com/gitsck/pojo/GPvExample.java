package com.gitsck.pojo;

import java.util.ArrayList;
import java.util.List;

public class GPvExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GPvExample() {
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

        public Criteria andPvIdIsNull() {
            addCriterion("pv_id is null");
            return (Criteria) this;
        }

        public Criteria andPvIdIsNotNull() {
            addCriterion("pv_id is not null");
            return (Criteria) this;
        }

        public Criteria andPvIdEqualTo(Long value) {
            addCriterion("pv_id =", value, "pvId");
            return (Criteria) this;
        }

        public Criteria andPvIdNotEqualTo(Long value) {
            addCriterion("pv_id <>", value, "pvId");
            return (Criteria) this;
        }

        public Criteria andPvIdGreaterThan(Long value) {
            addCriterion("pv_id >", value, "pvId");
            return (Criteria) this;
        }

        public Criteria andPvIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pv_id >=", value, "pvId");
            return (Criteria) this;
        }

        public Criteria andPvIdLessThan(Long value) {
            addCriterion("pv_id <", value, "pvId");
            return (Criteria) this;
        }

        public Criteria andPvIdLessThanOrEqualTo(Long value) {
            addCriterion("pv_id <=", value, "pvId");
            return (Criteria) this;
        }

        public Criteria andPvIdIn(List<Long> values) {
            addCriterion("pv_id in", values, "pvId");
            return (Criteria) this;
        }

        public Criteria andPvIdNotIn(List<Long> values) {
            addCriterion("pv_id not in", values, "pvId");
            return (Criteria) this;
        }

        public Criteria andPvIdBetween(Long value1, Long value2) {
            addCriterion("pv_id between", value1, value2, "pvId");
            return (Criteria) this;
        }

        public Criteria andPvIdNotBetween(Long value1, Long value2) {
            addCriterion("pv_id not between", value1, value2, "pvId");
            return (Criteria) this;
        }

        public Criteria andPvDateIsNull() {
            addCriterion("pv_date is null");
            return (Criteria) this;
        }

        public Criteria andPvDateIsNotNull() {
            addCriterion("pv_date is not null");
            return (Criteria) this;
        }

        public Criteria andPvDateEqualTo(String value) {
            addCriterion("pv_date =", value, "pvDate");
            return (Criteria) this;
        }

        public Criteria andPvDateNotEqualTo(String value) {
            addCriterion("pv_date <>", value, "pvDate");
            return (Criteria) this;
        }

        public Criteria andPvDateGreaterThan(String value) {
            addCriterion("pv_date >", value, "pvDate");
            return (Criteria) this;
        }

        public Criteria andPvDateGreaterThanOrEqualTo(String value) {
            addCriterion("pv_date >=", value, "pvDate");
            return (Criteria) this;
        }

        public Criteria andPvDateLessThan(String value) {
            addCriterion("pv_date <", value, "pvDate");
            return (Criteria) this;
        }

        public Criteria andPvDateLessThanOrEqualTo(String value) {
            addCriterion("pv_date <=", value, "pvDate");
            return (Criteria) this;
        }

        public Criteria andPvDateLike(String value) {
            addCriterion("pv_date like", value, "pvDate");
            return (Criteria) this;
        }

        public Criteria andPvDateNotLike(String value) {
            addCriterion("pv_date not like", value, "pvDate");
            return (Criteria) this;
        }

        public Criteria andPvDateIn(List<String> values) {
            addCriterion("pv_date in", values, "pvDate");
            return (Criteria) this;
        }

        public Criteria andPvDateNotIn(List<String> values) {
            addCriterion("pv_date not in", values, "pvDate");
            return (Criteria) this;
        }

        public Criteria andPvDateBetween(String value1, String value2) {
            addCriterion("pv_date between", value1, value2, "pvDate");
            return (Criteria) this;
        }

        public Criteria andPvDateNotBetween(String value1, String value2) {
            addCriterion("pv_date not between", value1, value2, "pvDate");
            return (Criteria) this;
        }

        public Criteria andPvIsNull() {
            addCriterion("pv is null");
            return (Criteria) this;
        }

        public Criteria andPvIsNotNull() {
            addCriterion("pv is not null");
            return (Criteria) this;
        }

        public Criteria andPvEqualTo(Integer value) {
            addCriterion("pv =", value, "pv");
            return (Criteria) this;
        }

        public Criteria andPvNotEqualTo(Integer value) {
            addCriterion("pv <>", value, "pv");
            return (Criteria) this;
        }

        public Criteria andPvGreaterThan(Integer value) {
            addCriterion("pv >", value, "pv");
            return (Criteria) this;
        }

        public Criteria andPvGreaterThanOrEqualTo(Integer value) {
            addCriterion("pv >=", value, "pv");
            return (Criteria) this;
        }

        public Criteria andPvLessThan(Integer value) {
            addCriterion("pv <", value, "pv");
            return (Criteria) this;
        }

        public Criteria andPvLessThanOrEqualTo(Integer value) {
            addCriterion("pv <=", value, "pv");
            return (Criteria) this;
        }

        public Criteria andPvIn(List<Integer> values) {
            addCriterion("pv in", values, "pv");
            return (Criteria) this;
        }

        public Criteria andPvNotIn(List<Integer> values) {
            addCriterion("pv not in", values, "pv");
            return (Criteria) this;
        }

        public Criteria andPvBetween(Integer value1, Integer value2) {
            addCriterion("pv between", value1, value2, "pv");
            return (Criteria) this;
        }

        public Criteria andPvNotBetween(Integer value1, Integer value2) {
            addCriterion("pv not between", value1, value2, "pv");
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