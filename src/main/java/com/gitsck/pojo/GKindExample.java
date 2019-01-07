package com.gitsck.pojo;

import java.util.ArrayList;
import java.util.List;

public class GKindExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GKindExample() {
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

        public Criteria andKParentIsNull() {
            addCriterion("k_parent is null");
            return (Criteria) this;
        }

        public Criteria andKParentIsNotNull() {
            addCriterion("k_parent is not null");
            return (Criteria) this;
        }

        public Criteria andKParentEqualTo(Long value) {
            addCriterion("k_parent =", value, "kParent");
            return (Criteria) this;
        }

        public Criteria andKParentNotEqualTo(Long value) {
            addCriterion("k_parent <>", value, "kParent");
            return (Criteria) this;
        }

        public Criteria andKParentGreaterThan(Long value) {
            addCriterion("k_parent >", value, "kParent");
            return (Criteria) this;
        }

        public Criteria andKParentGreaterThanOrEqualTo(Long value) {
            addCriterion("k_parent >=", value, "kParent");
            return (Criteria) this;
        }

        public Criteria andKParentLessThan(Long value) {
            addCriterion("k_parent <", value, "kParent");
            return (Criteria) this;
        }

        public Criteria andKParentLessThanOrEqualTo(Long value) {
            addCriterion("k_parent <=", value, "kParent");
            return (Criteria) this;
        }

        public Criteria andKParentIn(List<Long> values) {
            addCriterion("k_parent in", values, "kParent");
            return (Criteria) this;
        }

        public Criteria andKParentNotIn(List<Long> values) {
            addCriterion("k_parent not in", values, "kParent");
            return (Criteria) this;
        }

        public Criteria andKParentBetween(Long value1, Long value2) {
            addCriterion("k_parent between", value1, value2, "kParent");
            return (Criteria) this;
        }

        public Criteria andKParentNotBetween(Long value1, Long value2) {
            addCriterion("k_parent not between", value1, value2, "kParent");
            return (Criteria) this;
        }

        public Criteria andKIsparentIsNull() {
            addCriterion("k_isparent is null");
            return (Criteria) this;
        }

        public Criteria andKIsparentIsNotNull() {
            addCriterion("k_isparent is not null");
            return (Criteria) this;
        }

        public Criteria andKIsparentEqualTo(Integer value) {
            addCriterion("k_isparent =", value, "kIsparent");
            return (Criteria) this;
        }

        public Criteria andKIsparentNotEqualTo(Integer value) {
            addCriterion("k_isparent <>", value, "kIsparent");
            return (Criteria) this;
        }

        public Criteria andKIsparentGreaterThan(Integer value) {
            addCriterion("k_isparent >", value, "kIsparent");
            return (Criteria) this;
        }

        public Criteria andKIsparentGreaterThanOrEqualTo(Integer value) {
            addCriterion("k_isparent >=", value, "kIsparent");
            return (Criteria) this;
        }

        public Criteria andKIsparentLessThan(Integer value) {
            addCriterion("k_isparent <", value, "kIsparent");
            return (Criteria) this;
        }

        public Criteria andKIsparentLessThanOrEqualTo(Integer value) {
            addCriterion("k_isparent <=", value, "kIsparent");
            return (Criteria) this;
        }

        public Criteria andKIsparentIn(List<Integer> values) {
            addCriterion("k_isparent in", values, "kIsparent");
            return (Criteria) this;
        }

        public Criteria andKIsparentNotIn(List<Integer> values) {
            addCriterion("k_isparent not in", values, "kIsparent");
            return (Criteria) this;
        }

        public Criteria andKIsparentBetween(Integer value1, Integer value2) {
            addCriterion("k_isparent between", value1, value2, "kIsparent");
            return (Criteria) this;
        }

        public Criteria andKIsparentNotBetween(Integer value1, Integer value2) {
            addCriterion("k_isparent not between", value1, value2, "kIsparent");
            return (Criteria) this;
        }

        public Criteria andKTextIsNull() {
            addCriterion("k_text is null");
            return (Criteria) this;
        }

        public Criteria andKTextIsNotNull() {
            addCriterion("k_text is not null");
            return (Criteria) this;
        }

        public Criteria andKTextEqualTo(String value) {
            addCriterion("k_text =", value, "kText");
            return (Criteria) this;
        }

        public Criteria andKTextNotEqualTo(String value) {
            addCriterion("k_text <>", value, "kText");
            return (Criteria) this;
        }

        public Criteria andKTextGreaterThan(String value) {
            addCriterion("k_text >", value, "kText");
            return (Criteria) this;
        }

        public Criteria andKTextGreaterThanOrEqualTo(String value) {
            addCriterion("k_text >=", value, "kText");
            return (Criteria) this;
        }

        public Criteria andKTextLessThan(String value) {
            addCriterion("k_text <", value, "kText");
            return (Criteria) this;
        }

        public Criteria andKTextLessThanOrEqualTo(String value) {
            addCriterion("k_text <=", value, "kText");
            return (Criteria) this;
        }

        public Criteria andKTextLike(String value) {
            addCriterion("k_text like", value, "kText");
            return (Criteria) this;
        }

        public Criteria andKTextNotLike(String value) {
            addCriterion("k_text not like", value, "kText");
            return (Criteria) this;
        }

        public Criteria andKTextIn(List<String> values) {
            addCriterion("k_text in", values, "kText");
            return (Criteria) this;
        }

        public Criteria andKTextNotIn(List<String> values) {
            addCriterion("k_text not in", values, "kText");
            return (Criteria) this;
        }

        public Criteria andKTextBetween(String value1, String value2) {
            addCriterion("k_text between", value1, value2, "kText");
            return (Criteria) this;
        }

        public Criteria andKTextNotBetween(String value1, String value2) {
            addCriterion("k_text not between", value1, value2, "kText");
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