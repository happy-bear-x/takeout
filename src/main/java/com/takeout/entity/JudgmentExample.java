package com.takeout.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JudgmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JudgmentExample() {
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

        public Criteria andOrdernumIsNull() {
            addCriterion("ordernum is null");
            return (Criteria) this;
        }

        public Criteria andOrdernumIsNotNull() {
            addCriterion("ordernum is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernumEqualTo(String value) {
            addCriterion("ordernum =", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotEqualTo(String value) {
            addCriterion("ordernum <>", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumGreaterThan(String value) {
            addCriterion("ordernum >", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumGreaterThanOrEqualTo(String value) {
            addCriterion("ordernum >=", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumLessThan(String value) {
            addCriterion("ordernum <", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumLessThanOrEqualTo(String value) {
            addCriterion("ordernum <=", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumLike(String value) {
            addCriterion("ordernum like", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotLike(String value) {
            addCriterion("ordernum not like", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumIn(List<String> values) {
            addCriterion("ordernum in", values, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotIn(List<String> values) {
            addCriterion("ordernum not in", values, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumBetween(String value1, String value2) {
            addCriterion("ordernum between", value1, value2, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotBetween(String value1, String value2) {
            addCriterion("ordernum not between", value1, value2, "ordernum");
            return (Criteria) this;
        }

        public Criteria andUserIsNull() {
            addCriterion("user is null");
            return (Criteria) this;
        }

        public Criteria andUserIsNotNull() {
            addCriterion("user is not null");
            return (Criteria) this;
        }

        public Criteria andUserEqualTo(String value) {
            addCriterion("user =", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotEqualTo(String value) {
            addCriterion("user <>", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThan(String value) {
            addCriterion("user >", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThanOrEqualTo(String value) {
            addCriterion("user >=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThan(String value) {
            addCriterion("user <", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThanOrEqualTo(String value) {
            addCriterion("user <=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLike(String value) {
            addCriterion("user like", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotLike(String value) {
            addCriterion("user not like", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserIn(List<String> values) {
            addCriterion("user in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotIn(List<String> values) {
            addCriterion("user not in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserBetween(String value1, String value2) {
            addCriterion("user between", value1, value2, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotBetween(String value1, String value2) {
            addCriterion("user not between", value1, value2, "user");
            return (Criteria) this;
        }

        public Criteria andShopIsNull() {
            addCriterion("shop is null");
            return (Criteria) this;
        }

        public Criteria andShopIsNotNull() {
            addCriterion("shop is not null");
            return (Criteria) this;
        }

        public Criteria andShopEqualTo(String value) {
            addCriterion("shop =", value, "shop");
            return (Criteria) this;
        }

        public Criteria andShopNotEqualTo(String value) {
            addCriterion("shop <>", value, "shop");
            return (Criteria) this;
        }

        public Criteria andShopGreaterThan(String value) {
            addCriterion("shop >", value, "shop");
            return (Criteria) this;
        }

        public Criteria andShopGreaterThanOrEqualTo(String value) {
            addCriterion("shop >=", value, "shop");
            return (Criteria) this;
        }

        public Criteria andShopLessThan(String value) {
            addCriterion("shop <", value, "shop");
            return (Criteria) this;
        }

        public Criteria andShopLessThanOrEqualTo(String value) {
            addCriterion("shop <=", value, "shop");
            return (Criteria) this;
        }

        public Criteria andShopLike(String value) {
            addCriterion("shop like", value, "shop");
            return (Criteria) this;
        }

        public Criteria andShopNotLike(String value) {
            addCriterion("shop not like", value, "shop");
            return (Criteria) this;
        }

        public Criteria andShopIn(List<String> values) {
            addCriterion("shop in", values, "shop");
            return (Criteria) this;
        }

        public Criteria andShopNotIn(List<String> values) {
            addCriterion("shop not in", values, "shop");
            return (Criteria) this;
        }

        public Criteria andShopBetween(String value1, String value2) {
            addCriterion("shop between", value1, value2, "shop");
            return (Criteria) this;
        }

        public Criteria andShopNotBetween(String value1, String value2) {
            addCriterion("shop not between", value1, value2, "shop");
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

        public Criteria andScoreEqualTo(Short value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Short value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Short value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Short value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Short value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Short value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Short> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Short> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Short value1, Short value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Short value1, Short value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andJudgeIsNull() {
            addCriterion("judge is null");
            return (Criteria) this;
        }

        public Criteria andJudgeIsNotNull() {
            addCriterion("judge is not null");
            return (Criteria) this;
        }

        public Criteria andJudgeEqualTo(String value) {
            addCriterion("judge =", value, "judge");
            return (Criteria) this;
        }

        public Criteria andJudgeNotEqualTo(String value) {
            addCriterion("judge <>", value, "judge");
            return (Criteria) this;
        }

        public Criteria andJudgeGreaterThan(String value) {
            addCriterion("judge >", value, "judge");
            return (Criteria) this;
        }

        public Criteria andJudgeGreaterThanOrEqualTo(String value) {
            addCriterion("judge >=", value, "judge");
            return (Criteria) this;
        }

        public Criteria andJudgeLessThan(String value) {
            addCriterion("judge <", value, "judge");
            return (Criteria) this;
        }

        public Criteria andJudgeLessThanOrEqualTo(String value) {
            addCriterion("judge <=", value, "judge");
            return (Criteria) this;
        }

        public Criteria andJudgeLike(String value) {
            addCriterion("judge like", value, "judge");
            return (Criteria) this;
        }

        public Criteria andJudgeNotLike(String value) {
            addCriterion("judge not like", value, "judge");
            return (Criteria) this;
        }

        public Criteria andJudgeIn(List<String> values) {
            addCriterion("judge in", values, "judge");
            return (Criteria) this;
        }

        public Criteria andJudgeNotIn(List<String> values) {
            addCriterion("judge not in", values, "judge");
            return (Criteria) this;
        }

        public Criteria andJudgeBetween(String value1, String value2) {
            addCriterion("judge between", value1, value2, "judge");
            return (Criteria) this;
        }

        public Criteria andJudgeNotBetween(String value1, String value2) {
            addCriterion("judge not between", value1, value2, "judge");
            return (Criteria) this;
        }

        public Criteria andJudgetimeIsNull() {
            addCriterion("judgetime is null");
            return (Criteria) this;
        }

        public Criteria andJudgetimeIsNotNull() {
            addCriterion("judgetime is not null");
            return (Criteria) this;
        }

        public Criteria andJudgetimeEqualTo(Date value) {
            addCriterion("judgetime =", value, "judgetime");
            return (Criteria) this;
        }

        public Criteria andJudgetimeNotEqualTo(Date value) {
            addCriterion("judgetime <>", value, "judgetime");
            return (Criteria) this;
        }

        public Criteria andJudgetimeGreaterThan(Date value) {
            addCriterion("judgetime >", value, "judgetime");
            return (Criteria) this;
        }

        public Criteria andJudgetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("judgetime >=", value, "judgetime");
            return (Criteria) this;
        }

        public Criteria andJudgetimeLessThan(Date value) {
            addCriterion("judgetime <", value, "judgetime");
            return (Criteria) this;
        }

        public Criteria andJudgetimeLessThanOrEqualTo(Date value) {
            addCriterion("judgetime <=", value, "judgetime");
            return (Criteria) this;
        }

        public Criteria andJudgetimeIn(List<Date> values) {
            addCriterion("judgetime in", values, "judgetime");
            return (Criteria) this;
        }

        public Criteria andJudgetimeNotIn(List<Date> values) {
            addCriterion("judgetime not in", values, "judgetime");
            return (Criteria) this;
        }

        public Criteria andJudgetimeBetween(Date value1, Date value2) {
            addCriterion("judgetime between", value1, value2, "judgetime");
            return (Criteria) this;
        }

        public Criteria andJudgetimeNotBetween(Date value1, Date value2) {
            addCriterion("judgetime not between", value1, value2, "judgetime");
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