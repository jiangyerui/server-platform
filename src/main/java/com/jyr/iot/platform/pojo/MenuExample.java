package com.jyr.iot.platform.pojo;

import java.util.ArrayList;
import java.util.List;

public class MenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MenuExample() {
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

        public Criteria andMenuIdIsNull() {
            addCriterion("menu_id is null");
            return (Criteria) this;
        }

        public Criteria andMenuIdIsNotNull() {
            addCriterion("menu_id is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIdEqualTo(Integer value) {
            addCriterion("menu_id =", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotEqualTo(Integer value) {
            addCriterion("menu_id <>", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThan(Integer value) {
            addCriterion("menu_id >", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_id >=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThan(Integer value) {
            addCriterion("menu_id <", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThanOrEqualTo(Integer value) {
            addCriterion("menu_id <=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdIn(List<Integer> values) {
            addCriterion("menu_id in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotIn(List<Integer> values) {
            addCriterion("menu_id not in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdBetween(Integer value1, Integer value2) {
            addCriterion("menu_id between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_id not between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNull() {
            addCriterion("menu_name is null");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNotNull() {
            addCriterion("menu_name is not null");
            return (Criteria) this;
        }

        public Criteria andMenuNameEqualTo(String value) {
            addCriterion("menu_name =", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotEqualTo(String value) {
            addCriterion("menu_name <>", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThan(String value) {
            addCriterion("menu_name >", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThanOrEqualTo(String value) {
            addCriterion("menu_name >=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThan(String value) {
            addCriterion("menu_name <", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThanOrEqualTo(String value) {
            addCriterion("menu_name <=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLike(String value) {
            addCriterion("menu_name like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotLike(String value) {
            addCriterion("menu_name not like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameIn(List<String> values) {
            addCriterion("menu_name in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotIn(List<String> values) {
            addCriterion("menu_name not in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameBetween(String value1, String value2) {
            addCriterion("menu_name between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotBetween(String value1, String value2) {
            addCriterion("menu_name not between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuImgIsNull() {
            addCriterion("menu_img is null");
            return (Criteria) this;
        }

        public Criteria andMenuImgIsNotNull() {
            addCriterion("menu_img is not null");
            return (Criteria) this;
        }

        public Criteria andMenuImgEqualTo(String value) {
            addCriterion("menu_img =", value, "menuImg");
            return (Criteria) this;
        }

        public Criteria andMenuImgNotEqualTo(String value) {
            addCriterion("menu_img <>", value, "menuImg");
            return (Criteria) this;
        }

        public Criteria andMenuImgGreaterThan(String value) {
            addCriterion("menu_img >", value, "menuImg");
            return (Criteria) this;
        }

        public Criteria andMenuImgGreaterThanOrEqualTo(String value) {
            addCriterion("menu_img >=", value, "menuImg");
            return (Criteria) this;
        }

        public Criteria andMenuImgLessThan(String value) {
            addCriterion("menu_img <", value, "menuImg");
            return (Criteria) this;
        }

        public Criteria andMenuImgLessThanOrEqualTo(String value) {
            addCriterion("menu_img <=", value, "menuImg");
            return (Criteria) this;
        }

        public Criteria andMenuImgLike(String value) {
            addCriterion("menu_img like", value, "menuImg");
            return (Criteria) this;
        }

        public Criteria andMenuImgNotLike(String value) {
            addCriterion("menu_img not like", value, "menuImg");
            return (Criteria) this;
        }

        public Criteria andMenuImgIn(List<String> values) {
            addCriterion("menu_img in", values, "menuImg");
            return (Criteria) this;
        }

        public Criteria andMenuImgNotIn(List<String> values) {
            addCriterion("menu_img not in", values, "menuImg");
            return (Criteria) this;
        }

        public Criteria andMenuImgBetween(String value1, String value2) {
            addCriterion("menu_img between", value1, value2, "menuImg");
            return (Criteria) this;
        }

        public Criteria andMenuImgNotBetween(String value1, String value2) {
            addCriterion("menu_img not between", value1, value2, "menuImg");
            return (Criteria) this;
        }

        public Criteria andMenuKeyIsNull() {
            addCriterion("menu_key is null");
            return (Criteria) this;
        }

        public Criteria andMenuKeyIsNotNull() {
            addCriterion("menu_key is not null");
            return (Criteria) this;
        }

        public Criteria andMenuKeyEqualTo(String value) {
            addCriterion("menu_key =", value, "menuKey");
            return (Criteria) this;
        }

        public Criteria andMenuKeyNotEqualTo(String value) {
            addCriterion("menu_key <>", value, "menuKey");
            return (Criteria) this;
        }

        public Criteria andMenuKeyGreaterThan(String value) {
            addCriterion("menu_key >", value, "menuKey");
            return (Criteria) this;
        }

        public Criteria andMenuKeyGreaterThanOrEqualTo(String value) {
            addCriterion("menu_key >=", value, "menuKey");
            return (Criteria) this;
        }

        public Criteria andMenuKeyLessThan(String value) {
            addCriterion("menu_key <", value, "menuKey");
            return (Criteria) this;
        }

        public Criteria andMenuKeyLessThanOrEqualTo(String value) {
            addCriterion("menu_key <=", value, "menuKey");
            return (Criteria) this;
        }

        public Criteria andMenuKeyLike(String value) {
            addCriterion("menu_key like", value, "menuKey");
            return (Criteria) this;
        }

        public Criteria andMenuKeyNotLike(String value) {
            addCriterion("menu_key not like", value, "menuKey");
            return (Criteria) this;
        }

        public Criteria andMenuKeyIn(List<String> values) {
            addCriterion("menu_key in", values, "menuKey");
            return (Criteria) this;
        }

        public Criteria andMenuKeyNotIn(List<String> values) {
            addCriterion("menu_key not in", values, "menuKey");
            return (Criteria) this;
        }

        public Criteria andMenuKeyBetween(String value1, String value2) {
            addCriterion("menu_key between", value1, value2, "menuKey");
            return (Criteria) this;
        }

        public Criteria andMenuKeyNotBetween(String value1, String value2) {
            addCriterion("menu_key not between", value1, value2, "menuKey");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIsNull() {
            addCriterion("menu_url is null");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIsNotNull() {
            addCriterion("menu_url is not null");
            return (Criteria) this;
        }

        public Criteria andMenuUrlEqualTo(String value) {
            addCriterion("menu_url =", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotEqualTo(String value) {
            addCriterion("menu_url <>", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlGreaterThan(String value) {
            addCriterion("menu_url >", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlGreaterThanOrEqualTo(String value) {
            addCriterion("menu_url >=", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLessThan(String value) {
            addCriterion("menu_url <", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLessThanOrEqualTo(String value) {
            addCriterion("menu_url <=", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLike(String value) {
            addCriterion("menu_url like", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotLike(String value) {
            addCriterion("menu_url not like", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIn(List<String> values) {
            addCriterion("menu_url in", values, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotIn(List<String> values) {
            addCriterion("menu_url not in", values, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlBetween(String value1, String value2) {
            addCriterion("menu_url between", value1, value2, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotBetween(String value1, String value2) {
            addCriterion("menu_url not between", value1, value2, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuActionIsNull() {
            addCriterion("menu_action is null");
            return (Criteria) this;
        }

        public Criteria andMenuActionIsNotNull() {
            addCriterion("menu_action is not null");
            return (Criteria) this;
        }

        public Criteria andMenuActionEqualTo(String value) {
            addCriterion("menu_action =", value, "menuAction");
            return (Criteria) this;
        }

        public Criteria andMenuActionNotEqualTo(String value) {
            addCriterion("menu_action <>", value, "menuAction");
            return (Criteria) this;
        }

        public Criteria andMenuActionGreaterThan(String value) {
            addCriterion("menu_action >", value, "menuAction");
            return (Criteria) this;
        }

        public Criteria andMenuActionGreaterThanOrEqualTo(String value) {
            addCriterion("menu_action >=", value, "menuAction");
            return (Criteria) this;
        }

        public Criteria andMenuActionLessThan(String value) {
            addCriterion("menu_action <", value, "menuAction");
            return (Criteria) this;
        }

        public Criteria andMenuActionLessThanOrEqualTo(String value) {
            addCriterion("menu_action <=", value, "menuAction");
            return (Criteria) this;
        }

        public Criteria andMenuActionLike(String value) {
            addCriterion("menu_action like", value, "menuAction");
            return (Criteria) this;
        }

        public Criteria andMenuActionNotLike(String value) {
            addCriterion("menu_action not like", value, "menuAction");
            return (Criteria) this;
        }

        public Criteria andMenuActionIn(List<String> values) {
            addCriterion("menu_action in", values, "menuAction");
            return (Criteria) this;
        }

        public Criteria andMenuActionNotIn(List<String> values) {
            addCriterion("menu_action not in", values, "menuAction");
            return (Criteria) this;
        }

        public Criteria andMenuActionBetween(String value1, String value2) {
            addCriterion("menu_action between", value1, value2, "menuAction");
            return (Criteria) this;
        }

        public Criteria andMenuActionNotBetween(String value1, String value2) {
            addCriterion("menu_action not between", value1, value2, "menuAction");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdIsNull() {
            addCriterion("menu_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdIsNotNull() {
            addCriterion("menu_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdEqualTo(Integer value) {
            addCriterion("menu_parent_id =", value, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdNotEqualTo(Integer value) {
            addCriterion("menu_parent_id <>", value, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdGreaterThan(Integer value) {
            addCriterion("menu_parent_id >", value, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_parent_id >=", value, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdLessThan(Integer value) {
            addCriterion("menu_parent_id <", value, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("menu_parent_id <=", value, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdIn(List<Integer> values) {
            addCriterion("menu_parent_id in", values, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdNotIn(List<Integer> values) {
            addCriterion("menu_parent_id not in", values, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdBetween(Integer value1, Integer value2) {
            addCriterion("menu_parent_id between", value1, value2, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_parent_id not between", value1, value2, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuHideIsNull() {
            addCriterion("menu_hide is null");
            return (Criteria) this;
        }

        public Criteria andMenuHideIsNotNull() {
            addCriterion("menu_hide is not null");
            return (Criteria) this;
        }

        public Criteria andMenuHideEqualTo(Boolean value) {
            addCriterion("menu_hide =", value, "menuHide");
            return (Criteria) this;
        }

        public Criteria andMenuHideNotEqualTo(Boolean value) {
            addCriterion("menu_hide <>", value, "menuHide");
            return (Criteria) this;
        }

        public Criteria andMenuHideGreaterThan(Boolean value) {
            addCriterion("menu_hide >", value, "menuHide");
            return (Criteria) this;
        }

        public Criteria andMenuHideGreaterThanOrEqualTo(Boolean value) {
            addCriterion("menu_hide >=", value, "menuHide");
            return (Criteria) this;
        }

        public Criteria andMenuHideLessThan(Boolean value) {
            addCriterion("menu_hide <", value, "menuHide");
            return (Criteria) this;
        }

        public Criteria andMenuHideLessThanOrEqualTo(Boolean value) {
            addCriterion("menu_hide <=", value, "menuHide");
            return (Criteria) this;
        }

        public Criteria andMenuHideIn(List<Boolean> values) {
            addCriterion("menu_hide in", values, "menuHide");
            return (Criteria) this;
        }

        public Criteria andMenuHideNotIn(List<Boolean> values) {
            addCriterion("menu_hide not in", values, "menuHide");
            return (Criteria) this;
        }

        public Criteria andMenuHideBetween(Boolean value1, Boolean value2) {
            addCriterion("menu_hide between", value1, value2, "menuHide");
            return (Criteria) this;
        }

        public Criteria andMenuHideNotBetween(Boolean value1, Boolean value2) {
            addCriterion("menu_hide not between", value1, value2, "menuHide");
            return (Criteria) this;
        }

        public Criteria andMenuAuthUrlIsNull() {
            addCriterion("menu_auth_url is null");
            return (Criteria) this;
        }

        public Criteria andMenuAuthUrlIsNotNull() {
            addCriterion("menu_auth_url is not null");
            return (Criteria) this;
        }

        public Criteria andMenuAuthUrlEqualTo(String value) {
            addCriterion("menu_auth_url =", value, "menuAuthUrl");
            return (Criteria) this;
        }

        public Criteria andMenuAuthUrlNotEqualTo(String value) {
            addCriterion("menu_auth_url <>", value, "menuAuthUrl");
            return (Criteria) this;
        }

        public Criteria andMenuAuthUrlGreaterThan(String value) {
            addCriterion("menu_auth_url >", value, "menuAuthUrl");
            return (Criteria) this;
        }

        public Criteria andMenuAuthUrlGreaterThanOrEqualTo(String value) {
            addCriterion("menu_auth_url >=", value, "menuAuthUrl");
            return (Criteria) this;
        }

        public Criteria andMenuAuthUrlLessThan(String value) {
            addCriterion("menu_auth_url <", value, "menuAuthUrl");
            return (Criteria) this;
        }

        public Criteria andMenuAuthUrlLessThanOrEqualTo(String value) {
            addCriterion("menu_auth_url <=", value, "menuAuthUrl");
            return (Criteria) this;
        }

        public Criteria andMenuAuthUrlLike(String value) {
            addCriterion("menu_auth_url like", value, "menuAuthUrl");
            return (Criteria) this;
        }

        public Criteria andMenuAuthUrlNotLike(String value) {
            addCriterion("menu_auth_url not like", value, "menuAuthUrl");
            return (Criteria) this;
        }

        public Criteria andMenuAuthUrlIn(List<String> values) {
            addCriterion("menu_auth_url in", values, "menuAuthUrl");
            return (Criteria) this;
        }

        public Criteria andMenuAuthUrlNotIn(List<String> values) {
            addCriterion("menu_auth_url not in", values, "menuAuthUrl");
            return (Criteria) this;
        }

        public Criteria andMenuAuthUrlBetween(String value1, String value2) {
            addCriterion("menu_auth_url between", value1, value2, "menuAuthUrl");
            return (Criteria) this;
        }

        public Criteria andMenuAuthUrlNotBetween(String value1, String value2) {
            addCriterion("menu_auth_url not between", value1, value2, "menuAuthUrl");
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