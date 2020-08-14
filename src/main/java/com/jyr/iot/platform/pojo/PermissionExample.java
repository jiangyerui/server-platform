package com.jyr.iot.platform.pojo;

import java.util.ArrayList;
import java.util.List;

public class PermissionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PermissionExample() {
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

        public Criteria andPermissionIdIsNull() {
            addCriterion("permission_id is null");
            return (Criteria) this;
        }

        public Criteria andPermissionIdIsNotNull() {
            addCriterion("permission_id is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionIdEqualTo(Integer value) {
            addCriterion("permission_id =", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotEqualTo(Integer value) {
            addCriterion("permission_id <>", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdGreaterThan(Integer value) {
            addCriterion("permission_id >", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("permission_id >=", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdLessThan(Integer value) {
            addCriterion("permission_id <", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdLessThanOrEqualTo(Integer value) {
            addCriterion("permission_id <=", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdIn(List<Integer> values) {
            addCriterion("permission_id in", values, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotIn(List<Integer> values) {
            addCriterion("permission_id not in", values, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdBetween(Integer value1, Integer value2) {
            addCriterion("permission_id between", value1, value2, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("permission_id not between", value1, value2, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionZhydIsNull() {
            addCriterion("permission_zhyd is null");
            return (Criteria) this;
        }

        public Criteria andPermissionZhydIsNotNull() {
            addCriterion("permission_zhyd is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionZhydEqualTo(Boolean value) {
            addCriterion("permission_zhyd =", value, "permissionZhyd");
            return (Criteria) this;
        }

        public Criteria andPermissionZhydNotEqualTo(Boolean value) {
            addCriterion("permission_zhyd <>", value, "permissionZhyd");
            return (Criteria) this;
        }

        public Criteria andPermissionZhydGreaterThan(Boolean value) {
            addCriterion("permission_zhyd >", value, "permissionZhyd");
            return (Criteria) this;
        }

        public Criteria andPermissionZhydGreaterThanOrEqualTo(Boolean value) {
            addCriterion("permission_zhyd >=", value, "permissionZhyd");
            return (Criteria) this;
        }

        public Criteria andPermissionZhydLessThan(Boolean value) {
            addCriterion("permission_zhyd <", value, "permissionZhyd");
            return (Criteria) this;
        }

        public Criteria andPermissionZhydLessThanOrEqualTo(Boolean value) {
            addCriterion("permission_zhyd <=", value, "permissionZhyd");
            return (Criteria) this;
        }

        public Criteria andPermissionZhydIn(List<Boolean> values) {
            addCriterion("permission_zhyd in", values, "permissionZhyd");
            return (Criteria) this;
        }

        public Criteria andPermissionZhydNotIn(List<Boolean> values) {
            addCriterion("permission_zhyd not in", values, "permissionZhyd");
            return (Criteria) this;
        }

        public Criteria andPermissionZhydBetween(Boolean value1, Boolean value2) {
            addCriterion("permission_zhyd between", value1, value2, "permissionZhyd");
            return (Criteria) this;
        }

        public Criteria andPermissionZhydNotBetween(Boolean value1, Boolean value2) {
            addCriterion("permission_zhyd not between", value1, value2, "permissionZhyd");
            return (Criteria) this;
        }

        public Criteria andPermissionDqhzIsNull() {
            addCriterion("permission_dqhz is null");
            return (Criteria) this;
        }

        public Criteria andPermissionDqhzIsNotNull() {
            addCriterion("permission_dqhz is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionDqhzEqualTo(Boolean value) {
            addCriterion("permission_dqhz =", value, "permissionDqhz");
            return (Criteria) this;
        }

        public Criteria andPermissionDqhzNotEqualTo(Boolean value) {
            addCriterion("permission_dqhz <>", value, "permissionDqhz");
            return (Criteria) this;
        }

        public Criteria andPermissionDqhzGreaterThan(Boolean value) {
            addCriterion("permission_dqhz >", value, "permissionDqhz");
            return (Criteria) this;
        }

        public Criteria andPermissionDqhzGreaterThanOrEqualTo(Boolean value) {
            addCriterion("permission_dqhz >=", value, "permissionDqhz");
            return (Criteria) this;
        }

        public Criteria andPermissionDqhzLessThan(Boolean value) {
            addCriterion("permission_dqhz <", value, "permissionDqhz");
            return (Criteria) this;
        }

        public Criteria andPermissionDqhzLessThanOrEqualTo(Boolean value) {
            addCriterion("permission_dqhz <=", value, "permissionDqhz");
            return (Criteria) this;
        }

        public Criteria andPermissionDqhzIn(List<Boolean> values) {
            addCriterion("permission_dqhz in", values, "permissionDqhz");
            return (Criteria) this;
        }

        public Criteria andPermissionDqhzNotIn(List<Boolean> values) {
            addCriterion("permission_dqhz not in", values, "permissionDqhz");
            return (Criteria) this;
        }

        public Criteria andPermissionDqhzBetween(Boolean value1, Boolean value2) {
            addCriterion("permission_dqhz between", value1, value2, "permissionDqhz");
            return (Criteria) this;
        }

        public Criteria andPermissionDqhzNotBetween(Boolean value1, Boolean value2) {
            addCriterion("permission_dqhz not between", value1, value2, "permissionDqhz");
            return (Criteria) this;
        }

        public Criteria andPermissionXfdyIsNull() {
            addCriterion("permission_xfdy is null");
            return (Criteria) this;
        }

        public Criteria andPermissionXfdyIsNotNull() {
            addCriterion("permission_xfdy is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionXfdyEqualTo(Boolean value) {
            addCriterion("permission_xfdy =", value, "permissionXfdy");
            return (Criteria) this;
        }

        public Criteria andPermissionXfdyNotEqualTo(Boolean value) {
            addCriterion("permission_xfdy <>", value, "permissionXfdy");
            return (Criteria) this;
        }

        public Criteria andPermissionXfdyGreaterThan(Boolean value) {
            addCriterion("permission_xfdy >", value, "permissionXfdy");
            return (Criteria) this;
        }

        public Criteria andPermissionXfdyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("permission_xfdy >=", value, "permissionXfdy");
            return (Criteria) this;
        }

        public Criteria andPermissionXfdyLessThan(Boolean value) {
            addCriterion("permission_xfdy <", value, "permissionXfdy");
            return (Criteria) this;
        }

        public Criteria andPermissionXfdyLessThanOrEqualTo(Boolean value) {
            addCriterion("permission_xfdy <=", value, "permissionXfdy");
            return (Criteria) this;
        }

        public Criteria andPermissionXfdyIn(List<Boolean> values) {
            addCriterion("permission_xfdy in", values, "permissionXfdy");
            return (Criteria) this;
        }

        public Criteria andPermissionXfdyNotIn(List<Boolean> values) {
            addCriterion("permission_xfdy not in", values, "permissionXfdy");
            return (Criteria) this;
        }

        public Criteria andPermissionXfdyBetween(Boolean value1, Boolean value2) {
            addCriterion("permission_xfdy between", value1, value2, "permissionXfdy");
            return (Criteria) this;
        }

        public Criteria andPermissionXfdyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("permission_xfdy not between", value1, value2, "permissionXfdy");
            return (Criteria) this;
        }

        public Criteria andPermissionSdyIsNull() {
            addCriterion("permission_sdy is null");
            return (Criteria) this;
        }

        public Criteria andPermissionSdyIsNotNull() {
            addCriterion("permission_sdy is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionSdyEqualTo(Boolean value) {
            addCriterion("permission_sdy =", value, "permissionSdy");
            return (Criteria) this;
        }

        public Criteria andPermissionSdyNotEqualTo(Boolean value) {
            addCriterion("permission_sdy <>", value, "permissionSdy");
            return (Criteria) this;
        }

        public Criteria andPermissionSdyGreaterThan(Boolean value) {
            addCriterion("permission_sdy >", value, "permissionSdy");
            return (Criteria) this;
        }

        public Criteria andPermissionSdyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("permission_sdy >=", value, "permissionSdy");
            return (Criteria) this;
        }

        public Criteria andPermissionSdyLessThan(Boolean value) {
            addCriterion("permission_sdy <", value, "permissionSdy");
            return (Criteria) this;
        }

        public Criteria andPermissionSdyLessThanOrEqualTo(Boolean value) {
            addCriterion("permission_sdy <=", value, "permissionSdy");
            return (Criteria) this;
        }

        public Criteria andPermissionSdyIn(List<Boolean> values) {
            addCriterion("permission_sdy in", values, "permissionSdy");
            return (Criteria) this;
        }

        public Criteria andPermissionSdyNotIn(List<Boolean> values) {
            addCriterion("permission_sdy not in", values, "permissionSdy");
            return (Criteria) this;
        }

        public Criteria andPermissionSdyBetween(Boolean value1, Boolean value2) {
            addCriterion("permission_sdy between", value1, value2, "permissionSdy");
            return (Criteria) this;
        }

        public Criteria andPermissionSdyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("permission_sdy not between", value1, value2, "permissionSdy");
            return (Criteria) this;
        }

        public Criteria andPermissionZnzmIsNull() {
            addCriterion("permission_znzm is null");
            return (Criteria) this;
        }

        public Criteria andPermissionZnzmIsNotNull() {
            addCriterion("permission_znzm is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionZnzmEqualTo(Boolean value) {
            addCriterion("permission_znzm =", value, "permissionZnzm");
            return (Criteria) this;
        }

        public Criteria andPermissionZnzmNotEqualTo(Boolean value) {
            addCriterion("permission_znzm <>", value, "permissionZnzm");
            return (Criteria) this;
        }

        public Criteria andPermissionZnzmGreaterThan(Boolean value) {
            addCriterion("permission_znzm >", value, "permissionZnzm");
            return (Criteria) this;
        }

        public Criteria andPermissionZnzmGreaterThanOrEqualTo(Boolean value) {
            addCriterion("permission_znzm >=", value, "permissionZnzm");
            return (Criteria) this;
        }

        public Criteria andPermissionZnzmLessThan(Boolean value) {
            addCriterion("permission_znzm <", value, "permissionZnzm");
            return (Criteria) this;
        }

        public Criteria andPermissionZnzmLessThanOrEqualTo(Boolean value) {
            addCriterion("permission_znzm <=", value, "permissionZnzm");
            return (Criteria) this;
        }

        public Criteria andPermissionZnzmIn(List<Boolean> values) {
            addCriterion("permission_znzm in", values, "permissionZnzm");
            return (Criteria) this;
        }

        public Criteria andPermissionZnzmNotIn(List<Boolean> values) {
            addCriterion("permission_znzm not in", values, "permissionZnzm");
            return (Criteria) this;
        }

        public Criteria andPermissionZnzmBetween(Boolean value1, Boolean value2) {
            addCriterion("permission_znzm between", value1, value2, "permissionZnzm");
            return (Criteria) this;
        }

        public Criteria andPermissionZnzmNotBetween(Boolean value1, Boolean value2) {
            addCriterion("permission_znzm not between", value1, value2, "permissionZnzm");
            return (Criteria) this;
        }

        public Criteria andPermissionZndyIsNull() {
            addCriterion("permission_zndy is null");
            return (Criteria) this;
        }

        public Criteria andPermissionZndyIsNotNull() {
            addCriterion("permission_zndy is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionZndyEqualTo(Boolean value) {
            addCriterion("permission_zndy =", value, "permissionZndy");
            return (Criteria) this;
        }

        public Criteria andPermissionZndyNotEqualTo(Boolean value) {
            addCriterion("permission_zndy <>", value, "permissionZndy");
            return (Criteria) this;
        }

        public Criteria andPermissionZndyGreaterThan(Boolean value) {
            addCriterion("permission_zndy >", value, "permissionZndy");
            return (Criteria) this;
        }

        public Criteria andPermissionZndyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("permission_zndy >=", value, "permissionZndy");
            return (Criteria) this;
        }

        public Criteria andPermissionZndyLessThan(Boolean value) {
            addCriterion("permission_zndy <", value, "permissionZndy");
            return (Criteria) this;
        }

        public Criteria andPermissionZndyLessThanOrEqualTo(Boolean value) {
            addCriterion("permission_zndy <=", value, "permissionZndy");
            return (Criteria) this;
        }

        public Criteria andPermissionZndyIn(List<Boolean> values) {
            addCriterion("permission_zndy in", values, "permissionZndy");
            return (Criteria) this;
        }

        public Criteria andPermissionZndyNotIn(List<Boolean> values) {
            addCriterion("permission_zndy not in", values, "permissionZndy");
            return (Criteria) this;
        }

        public Criteria andPermissionZndyBetween(Boolean value1, Boolean value2) {
            addCriterion("permission_zndy between", value1, value2, "permissionZndy");
            return (Criteria) this;
        }

        public Criteria andPermissionZndyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("permission_zndy not between", value1, value2, "permissionZndy");
            return (Criteria) this;
        }

        public Criteria andPermissionZnpdIsNull() {
            addCriterion("permission_znpd is null");
            return (Criteria) this;
        }

        public Criteria andPermissionZnpdIsNotNull() {
            addCriterion("permission_znpd is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionZnpdEqualTo(Boolean value) {
            addCriterion("permission_znpd =", value, "permissionZnpd");
            return (Criteria) this;
        }

        public Criteria andPermissionZnpdNotEqualTo(Boolean value) {
            addCriterion("permission_znpd <>", value, "permissionZnpd");
            return (Criteria) this;
        }

        public Criteria andPermissionZnpdGreaterThan(Boolean value) {
            addCriterion("permission_znpd >", value, "permissionZnpd");
            return (Criteria) this;
        }

        public Criteria andPermissionZnpdGreaterThanOrEqualTo(Boolean value) {
            addCriterion("permission_znpd >=", value, "permissionZnpd");
            return (Criteria) this;
        }

        public Criteria andPermissionZnpdLessThan(Boolean value) {
            addCriterion("permission_znpd <", value, "permissionZnpd");
            return (Criteria) this;
        }

        public Criteria andPermissionZnpdLessThanOrEqualTo(Boolean value) {
            addCriterion("permission_znpd <=", value, "permissionZnpd");
            return (Criteria) this;
        }

        public Criteria andPermissionZnpdIn(List<Boolean> values) {
            addCriterion("permission_znpd in", values, "permissionZnpd");
            return (Criteria) this;
        }

        public Criteria andPermissionZnpdNotIn(List<Boolean> values) {
            addCriterion("permission_znpd not in", values, "permissionZnpd");
            return (Criteria) this;
        }

        public Criteria andPermissionZnpdBetween(Boolean value1, Boolean value2) {
            addCriterion("permission_znpd between", value1, value2, "permissionZnpd");
            return (Criteria) this;
        }

        public Criteria andPermissionZnpdNotBetween(Boolean value1, Boolean value2) {
            addCriterion("permission_znpd not between", value1, value2, "permissionZnpd");
            return (Criteria) this;
        }

        public Criteria andPermissionZngqyIsNull() {
            addCriterion("permission_zngqy is null");
            return (Criteria) this;
        }

        public Criteria andPermissionZngqyIsNotNull() {
            addCriterion("permission_zngqy is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionZngqyEqualTo(Boolean value) {
            addCriterion("permission_zngqy =", value, "permissionZngqy");
            return (Criteria) this;
        }

        public Criteria andPermissionZngqyNotEqualTo(Boolean value) {
            addCriterion("permission_zngqy <>", value, "permissionZngqy");
            return (Criteria) this;
        }

        public Criteria andPermissionZngqyGreaterThan(Boolean value) {
            addCriterion("permission_zngqy >", value, "permissionZngqy");
            return (Criteria) this;
        }

        public Criteria andPermissionZngqyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("permission_zngqy >=", value, "permissionZngqy");
            return (Criteria) this;
        }

        public Criteria andPermissionZngqyLessThan(Boolean value) {
            addCriterion("permission_zngqy <", value, "permissionZngqy");
            return (Criteria) this;
        }

        public Criteria andPermissionZngqyLessThanOrEqualTo(Boolean value) {
            addCriterion("permission_zngqy <=", value, "permissionZngqy");
            return (Criteria) this;
        }

        public Criteria andPermissionZngqyIn(List<Boolean> values) {
            addCriterion("permission_zngqy in", values, "permissionZngqy");
            return (Criteria) this;
        }

        public Criteria andPermissionZngqyNotIn(List<Boolean> values) {
            addCriterion("permission_zngqy not in", values, "permissionZngqy");
            return (Criteria) this;
        }

        public Criteria andPermissionZngqyBetween(Boolean value1, Boolean value2) {
            addCriterion("permission_zngqy between", value1, value2, "permissionZngqy");
            return (Criteria) this;
        }

        public Criteria andPermissionZngqyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("permission_zngqy not between", value1, value2, "permissionZngqy");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend1IsNull() {
            addCriterion("permission_extend1 is null");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend1IsNotNull() {
            addCriterion("permission_extend1 is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend1EqualTo(Boolean value) {
            addCriterion("permission_extend1 =", value, "permissionExtend1");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend1NotEqualTo(Boolean value) {
            addCriterion("permission_extend1 <>", value, "permissionExtend1");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend1GreaterThan(Boolean value) {
            addCriterion("permission_extend1 >", value, "permissionExtend1");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend1GreaterThanOrEqualTo(Boolean value) {
            addCriterion("permission_extend1 >=", value, "permissionExtend1");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend1LessThan(Boolean value) {
            addCriterion("permission_extend1 <", value, "permissionExtend1");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend1LessThanOrEqualTo(Boolean value) {
            addCriterion("permission_extend1 <=", value, "permissionExtend1");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend1In(List<Boolean> values) {
            addCriterion("permission_extend1 in", values, "permissionExtend1");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend1NotIn(List<Boolean> values) {
            addCriterion("permission_extend1 not in", values, "permissionExtend1");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend1Between(Boolean value1, Boolean value2) {
            addCriterion("permission_extend1 between", value1, value2, "permissionExtend1");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend1NotBetween(Boolean value1, Boolean value2) {
            addCriterion("permission_extend1 not between", value1, value2, "permissionExtend1");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend2IsNull() {
            addCriterion("permission_extend2 is null");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend2IsNotNull() {
            addCriterion("permission_extend2 is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend2EqualTo(Boolean value) {
            addCriterion("permission_extend2 =", value, "permissionExtend2");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend2NotEqualTo(Boolean value) {
            addCriterion("permission_extend2 <>", value, "permissionExtend2");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend2GreaterThan(Boolean value) {
            addCriterion("permission_extend2 >", value, "permissionExtend2");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend2GreaterThanOrEqualTo(Boolean value) {
            addCriterion("permission_extend2 >=", value, "permissionExtend2");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend2LessThan(Boolean value) {
            addCriterion("permission_extend2 <", value, "permissionExtend2");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend2LessThanOrEqualTo(Boolean value) {
            addCriterion("permission_extend2 <=", value, "permissionExtend2");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend2In(List<Boolean> values) {
            addCriterion("permission_extend2 in", values, "permissionExtend2");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend2NotIn(List<Boolean> values) {
            addCriterion("permission_extend2 not in", values, "permissionExtend2");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend2Between(Boolean value1, Boolean value2) {
            addCriterion("permission_extend2 between", value1, value2, "permissionExtend2");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend2NotBetween(Boolean value1, Boolean value2) {
            addCriterion("permission_extend2 not between", value1, value2, "permissionExtend2");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend3IsNull() {
            addCriterion("permission_extend3 is null");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend3IsNotNull() {
            addCriterion("permission_extend3 is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend3EqualTo(Boolean value) {
            addCriterion("permission_extend3 =", value, "permissionExtend3");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend3NotEqualTo(Boolean value) {
            addCriterion("permission_extend3 <>", value, "permissionExtend3");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend3GreaterThan(Boolean value) {
            addCriterion("permission_extend3 >", value, "permissionExtend3");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend3GreaterThanOrEqualTo(Boolean value) {
            addCriterion("permission_extend3 >=", value, "permissionExtend3");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend3LessThan(Boolean value) {
            addCriterion("permission_extend3 <", value, "permissionExtend3");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend3LessThanOrEqualTo(Boolean value) {
            addCriterion("permission_extend3 <=", value, "permissionExtend3");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend3In(List<Boolean> values) {
            addCriterion("permission_extend3 in", values, "permissionExtend3");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend3NotIn(List<Boolean> values) {
            addCriterion("permission_extend3 not in", values, "permissionExtend3");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend3Between(Boolean value1, Boolean value2) {
            addCriterion("permission_extend3 between", value1, value2, "permissionExtend3");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend3NotBetween(Boolean value1, Boolean value2) {
            addCriterion("permission_extend3 not between", value1, value2, "permissionExtend3");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend4IsNull() {
            addCriterion("permission_extend4 is null");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend4IsNotNull() {
            addCriterion("permission_extend4 is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend4EqualTo(Boolean value) {
            addCriterion("permission_extend4 =", value, "permissionExtend4");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend4NotEqualTo(Boolean value) {
            addCriterion("permission_extend4 <>", value, "permissionExtend4");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend4GreaterThan(Boolean value) {
            addCriterion("permission_extend4 >", value, "permissionExtend4");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend4GreaterThanOrEqualTo(Boolean value) {
            addCriterion("permission_extend4 >=", value, "permissionExtend4");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend4LessThan(Boolean value) {
            addCriterion("permission_extend4 <", value, "permissionExtend4");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend4LessThanOrEqualTo(Boolean value) {
            addCriterion("permission_extend4 <=", value, "permissionExtend4");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend4In(List<Boolean> values) {
            addCriterion("permission_extend4 in", values, "permissionExtend4");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend4NotIn(List<Boolean> values) {
            addCriterion("permission_extend4 not in", values, "permissionExtend4");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend4Between(Boolean value1, Boolean value2) {
            addCriterion("permission_extend4 between", value1, value2, "permissionExtend4");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend4NotBetween(Boolean value1, Boolean value2) {
            addCriterion("permission_extend4 not between", value1, value2, "permissionExtend4");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend5IsNull() {
            addCriterion("permission_extend5 is null");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend5IsNotNull() {
            addCriterion("permission_extend5 is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend5EqualTo(Boolean value) {
            addCriterion("permission_extend5 =", value, "permissionExtend5");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend5NotEqualTo(Boolean value) {
            addCriterion("permission_extend5 <>", value, "permissionExtend5");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend5GreaterThan(Boolean value) {
            addCriterion("permission_extend5 >", value, "permissionExtend5");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend5GreaterThanOrEqualTo(Boolean value) {
            addCriterion("permission_extend5 >=", value, "permissionExtend5");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend5LessThan(Boolean value) {
            addCriterion("permission_extend5 <", value, "permissionExtend5");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend5LessThanOrEqualTo(Boolean value) {
            addCriterion("permission_extend5 <=", value, "permissionExtend5");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend5In(List<Boolean> values) {
            addCriterion("permission_extend5 in", values, "permissionExtend5");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend5NotIn(List<Boolean> values) {
            addCriterion("permission_extend5 not in", values, "permissionExtend5");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend5Between(Boolean value1, Boolean value2) {
            addCriterion("permission_extend5 between", value1, value2, "permissionExtend5");
            return (Criteria) this;
        }

        public Criteria andPermissionExtend5NotBetween(Boolean value1, Boolean value2) {
            addCriterion("permission_extend5 not between", value1, value2, "permissionExtend5");
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