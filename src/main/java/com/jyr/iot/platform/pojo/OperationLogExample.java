package com.jyr.iot.platform.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperationLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OperationLogExample() {
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

        public Criteria andOperationIdIsNull() {
            addCriterion("operation_id is null");
            return (Criteria) this;
        }

        public Criteria andOperationIdIsNotNull() {
            addCriterion("operation_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperationIdEqualTo(Integer value) {
            addCriterion("operation_id =", value, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdNotEqualTo(Integer value) {
            addCriterion("operation_id <>", value, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdGreaterThan(Integer value) {
            addCriterion("operation_id >", value, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("operation_id >=", value, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdLessThan(Integer value) {
            addCriterion("operation_id <", value, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdLessThanOrEqualTo(Integer value) {
            addCriterion("operation_id <=", value, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdIn(List<Integer> values) {
            addCriterion("operation_id in", values, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdNotIn(List<Integer> values) {
            addCriterion("operation_id not in", values, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdBetween(Integer value1, Integer value2) {
            addCriterion("operation_id between", value1, value2, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("operation_id not between", value1, value2, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationTimeIsNull() {
            addCriterion("operation_time is null");
            return (Criteria) this;
        }

        public Criteria andOperationTimeIsNotNull() {
            addCriterion("operation_time is not null");
            return (Criteria) this;
        }

        public Criteria andOperationTimeEqualTo(Date value) {
            addCriterion("operation_time =", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeNotEqualTo(Date value) {
            addCriterion("operation_time <>", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeGreaterThan(Date value) {
            addCriterion("operation_time >", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("operation_time >=", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeLessThan(Date value) {
            addCriterion("operation_time <", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeLessThanOrEqualTo(Date value) {
            addCriterion("operation_time <=", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeIn(List<Date> values) {
            addCriterion("operation_time in", values, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeNotIn(List<Date> values) {
            addCriterion("operation_time not in", values, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeBetween(Date value1, Date value2) {
            addCriterion("operation_time between", value1, value2, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeNotBetween(Date value1, Date value2) {
            addCriterion("operation_time not between", value1, value2, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTypeIsNull() {
            addCriterion("operation_type is null");
            return (Criteria) this;
        }

        public Criteria andOperationTypeIsNotNull() {
            addCriterion("operation_type is not null");
            return (Criteria) this;
        }

        public Criteria andOperationTypeEqualTo(Integer value) {
            addCriterion("operation_type =", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeNotEqualTo(Integer value) {
            addCriterion("operation_type <>", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeGreaterThan(Integer value) {
            addCriterion("operation_type >", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("operation_type >=", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeLessThan(Integer value) {
            addCriterion("operation_type <", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeLessThanOrEqualTo(Integer value) {
            addCriterion("operation_type <=", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeIn(List<Integer> values) {
            addCriterion("operation_type in", values, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeNotIn(List<Integer> values) {
            addCriterion("operation_type not in", values, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeBetween(Integer value1, Integer value2) {
            addCriterion("operation_type between", value1, value2, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("operation_type not between", value1, value2, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationDeviceIdIsNull() {
            addCriterion("operation_device_id is null");
            return (Criteria) this;
        }

        public Criteria andOperationDeviceIdIsNotNull() {
            addCriterion("operation_device_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperationDeviceIdEqualTo(Integer value) {
            addCriterion("operation_device_id =", value, "operationDeviceId");
            return (Criteria) this;
        }

        public Criteria andOperationDeviceIdNotEqualTo(Integer value) {
            addCriterion("operation_device_id <>", value, "operationDeviceId");
            return (Criteria) this;
        }

        public Criteria andOperationDeviceIdGreaterThan(Integer value) {
            addCriterion("operation_device_id >", value, "operationDeviceId");
            return (Criteria) this;
        }

        public Criteria andOperationDeviceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("operation_device_id >=", value, "operationDeviceId");
            return (Criteria) this;
        }

        public Criteria andOperationDeviceIdLessThan(Integer value) {
            addCriterion("operation_device_id <", value, "operationDeviceId");
            return (Criteria) this;
        }

        public Criteria andOperationDeviceIdLessThanOrEqualTo(Integer value) {
            addCriterion("operation_device_id <=", value, "operationDeviceId");
            return (Criteria) this;
        }

        public Criteria andOperationDeviceIdIn(List<Integer> values) {
            addCriterion("operation_device_id in", values, "operationDeviceId");
            return (Criteria) this;
        }

        public Criteria andOperationDeviceIdNotIn(List<Integer> values) {
            addCriterion("operation_device_id not in", values, "operationDeviceId");
            return (Criteria) this;
        }

        public Criteria andOperationDeviceIdBetween(Integer value1, Integer value2) {
            addCriterion("operation_device_id between", value1, value2, "operationDeviceId");
            return (Criteria) this;
        }

        public Criteria andOperationDeviceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("operation_device_id not between", value1, value2, "operationDeviceId");
            return (Criteria) this;
        }

        public Criteria andOperationUserIdIsNull() {
            addCriterion("operation_user_id is null");
            return (Criteria) this;
        }

        public Criteria andOperationUserIdIsNotNull() {
            addCriterion("operation_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperationUserIdEqualTo(Integer value) {
            addCriterion("operation_user_id =", value, "operationUserId");
            return (Criteria) this;
        }

        public Criteria andOperationUserIdNotEqualTo(Integer value) {
            addCriterion("operation_user_id <>", value, "operationUserId");
            return (Criteria) this;
        }

        public Criteria andOperationUserIdGreaterThan(Integer value) {
            addCriterion("operation_user_id >", value, "operationUserId");
            return (Criteria) this;
        }

        public Criteria andOperationUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("operation_user_id >=", value, "operationUserId");
            return (Criteria) this;
        }

        public Criteria andOperationUserIdLessThan(Integer value) {
            addCriterion("operation_user_id <", value, "operationUserId");
            return (Criteria) this;
        }

        public Criteria andOperationUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("operation_user_id <=", value, "operationUserId");
            return (Criteria) this;
        }

        public Criteria andOperationUserIdIn(List<Integer> values) {
            addCriterion("operation_user_id in", values, "operationUserId");
            return (Criteria) this;
        }

        public Criteria andOperationUserIdNotIn(List<Integer> values) {
            addCriterion("operation_user_id not in", values, "operationUserId");
            return (Criteria) this;
        }

        public Criteria andOperationUserIdBetween(Integer value1, Integer value2) {
            addCriterion("operation_user_id between", value1, value2, "operationUserId");
            return (Criteria) this;
        }

        public Criteria andOperationUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("operation_user_id not between", value1, value2, "operationUserId");
            return (Criteria) this;
        }

        public Criteria andOperationResultIsNull() {
            addCriterion("operation_result is null");
            return (Criteria) this;
        }

        public Criteria andOperationResultIsNotNull() {
            addCriterion("operation_result is not null");
            return (Criteria) this;
        }

        public Criteria andOperationResultEqualTo(Integer value) {
            addCriterion("operation_result =", value, "operationResult");
            return (Criteria) this;
        }

        public Criteria andOperationResultNotEqualTo(Integer value) {
            addCriterion("operation_result <>", value, "operationResult");
            return (Criteria) this;
        }

        public Criteria andOperationResultGreaterThan(Integer value) {
            addCriterion("operation_result >", value, "operationResult");
            return (Criteria) this;
        }

        public Criteria andOperationResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("operation_result >=", value, "operationResult");
            return (Criteria) this;
        }

        public Criteria andOperationResultLessThan(Integer value) {
            addCriterion("operation_result <", value, "operationResult");
            return (Criteria) this;
        }

        public Criteria andOperationResultLessThanOrEqualTo(Integer value) {
            addCriterion("operation_result <=", value, "operationResult");
            return (Criteria) this;
        }

        public Criteria andOperationResultIn(List<Integer> values) {
            addCriterion("operation_result in", values, "operationResult");
            return (Criteria) this;
        }

        public Criteria andOperationResultNotIn(List<Integer> values) {
            addCriterion("operation_result not in", values, "operationResult");
            return (Criteria) this;
        }

        public Criteria andOperationResultBetween(Integer value1, Integer value2) {
            addCriterion("operation_result between", value1, value2, "operationResult");
            return (Criteria) this;
        }

        public Criteria andOperationResultNotBetween(Integer value1, Integer value2) {
            addCriterion("operation_result not between", value1, value2, "operationResult");
            return (Criteria) this;
        }

        public Criteria andOperationExtend1IsNull() {
            addCriterion("operation_extend1 is null");
            return (Criteria) this;
        }

        public Criteria andOperationExtend1IsNotNull() {
            addCriterion("operation_extend1 is not null");
            return (Criteria) this;
        }

        public Criteria andOperationExtend1EqualTo(String value) {
            addCriterion("operation_extend1 =", value, "operationExtend1");
            return (Criteria) this;
        }

        public Criteria andOperationExtend1NotEqualTo(String value) {
            addCriterion("operation_extend1 <>", value, "operationExtend1");
            return (Criteria) this;
        }

        public Criteria andOperationExtend1GreaterThan(String value) {
            addCriterion("operation_extend1 >", value, "operationExtend1");
            return (Criteria) this;
        }

        public Criteria andOperationExtend1GreaterThanOrEqualTo(String value) {
            addCriterion("operation_extend1 >=", value, "operationExtend1");
            return (Criteria) this;
        }

        public Criteria andOperationExtend1LessThan(String value) {
            addCriterion("operation_extend1 <", value, "operationExtend1");
            return (Criteria) this;
        }

        public Criteria andOperationExtend1LessThanOrEqualTo(String value) {
            addCriterion("operation_extend1 <=", value, "operationExtend1");
            return (Criteria) this;
        }

        public Criteria andOperationExtend1Like(String value) {
            addCriterion("operation_extend1 like", value, "operationExtend1");
            return (Criteria) this;
        }

        public Criteria andOperationExtend1NotLike(String value) {
            addCriterion("operation_extend1 not like", value, "operationExtend1");
            return (Criteria) this;
        }

        public Criteria andOperationExtend1In(List<String> values) {
            addCriterion("operation_extend1 in", values, "operationExtend1");
            return (Criteria) this;
        }

        public Criteria andOperationExtend1NotIn(List<String> values) {
            addCriterion("operation_extend1 not in", values, "operationExtend1");
            return (Criteria) this;
        }

        public Criteria andOperationExtend1Between(String value1, String value2) {
            addCriterion("operation_extend1 between", value1, value2, "operationExtend1");
            return (Criteria) this;
        }

        public Criteria andOperationExtend1NotBetween(String value1, String value2) {
            addCriterion("operation_extend1 not between", value1, value2, "operationExtend1");
            return (Criteria) this;
        }

        public Criteria andOperationExtend2IsNull() {
            addCriterion("operation_extend2 is null");
            return (Criteria) this;
        }

        public Criteria andOperationExtend2IsNotNull() {
            addCriterion("operation_extend2 is not null");
            return (Criteria) this;
        }

        public Criteria andOperationExtend2EqualTo(String value) {
            addCriterion("operation_extend2 =", value, "operationExtend2");
            return (Criteria) this;
        }

        public Criteria andOperationExtend2NotEqualTo(String value) {
            addCriterion("operation_extend2 <>", value, "operationExtend2");
            return (Criteria) this;
        }

        public Criteria andOperationExtend2GreaterThan(String value) {
            addCriterion("operation_extend2 >", value, "operationExtend2");
            return (Criteria) this;
        }

        public Criteria andOperationExtend2GreaterThanOrEqualTo(String value) {
            addCriterion("operation_extend2 >=", value, "operationExtend2");
            return (Criteria) this;
        }

        public Criteria andOperationExtend2LessThan(String value) {
            addCriterion("operation_extend2 <", value, "operationExtend2");
            return (Criteria) this;
        }

        public Criteria andOperationExtend2LessThanOrEqualTo(String value) {
            addCriterion("operation_extend2 <=", value, "operationExtend2");
            return (Criteria) this;
        }

        public Criteria andOperationExtend2Like(String value) {
            addCriterion("operation_extend2 like", value, "operationExtend2");
            return (Criteria) this;
        }

        public Criteria andOperationExtend2NotLike(String value) {
            addCriterion("operation_extend2 not like", value, "operationExtend2");
            return (Criteria) this;
        }

        public Criteria andOperationExtend2In(List<String> values) {
            addCriterion("operation_extend2 in", values, "operationExtend2");
            return (Criteria) this;
        }

        public Criteria andOperationExtend2NotIn(List<String> values) {
            addCriterion("operation_extend2 not in", values, "operationExtend2");
            return (Criteria) this;
        }

        public Criteria andOperationExtend2Between(String value1, String value2) {
            addCriterion("operation_extend2 between", value1, value2, "operationExtend2");
            return (Criteria) this;
        }

        public Criteria andOperationExtend2NotBetween(String value1, String value2) {
            addCriterion("operation_extend2 not between", value1, value2, "operationExtend2");
            return (Criteria) this;
        }

        public Criteria andOperationExtend3IsNull() {
            addCriterion("operation_extend3 is null");
            return (Criteria) this;
        }

        public Criteria andOperationExtend3IsNotNull() {
            addCriterion("operation_extend3 is not null");
            return (Criteria) this;
        }

        public Criteria andOperationExtend3EqualTo(String value) {
            addCriterion("operation_extend3 =", value, "operationExtend3");
            return (Criteria) this;
        }

        public Criteria andOperationExtend3NotEqualTo(String value) {
            addCriterion("operation_extend3 <>", value, "operationExtend3");
            return (Criteria) this;
        }

        public Criteria andOperationExtend3GreaterThan(String value) {
            addCriterion("operation_extend3 >", value, "operationExtend3");
            return (Criteria) this;
        }

        public Criteria andOperationExtend3GreaterThanOrEqualTo(String value) {
            addCriterion("operation_extend3 >=", value, "operationExtend3");
            return (Criteria) this;
        }

        public Criteria andOperationExtend3LessThan(String value) {
            addCriterion("operation_extend3 <", value, "operationExtend3");
            return (Criteria) this;
        }

        public Criteria andOperationExtend3LessThanOrEqualTo(String value) {
            addCriterion("operation_extend3 <=", value, "operationExtend3");
            return (Criteria) this;
        }

        public Criteria andOperationExtend3Like(String value) {
            addCriterion("operation_extend3 like", value, "operationExtend3");
            return (Criteria) this;
        }

        public Criteria andOperationExtend3NotLike(String value) {
            addCriterion("operation_extend3 not like", value, "operationExtend3");
            return (Criteria) this;
        }

        public Criteria andOperationExtend3In(List<String> values) {
            addCriterion("operation_extend3 in", values, "operationExtend3");
            return (Criteria) this;
        }

        public Criteria andOperationExtend3NotIn(List<String> values) {
            addCriterion("operation_extend3 not in", values, "operationExtend3");
            return (Criteria) this;
        }

        public Criteria andOperationExtend3Between(String value1, String value2) {
            addCriterion("operation_extend3 between", value1, value2, "operationExtend3");
            return (Criteria) this;
        }

        public Criteria andOperationExtend3NotBetween(String value1, String value2) {
            addCriterion("operation_extend3 not between", value1, value2, "operationExtend3");
            return (Criteria) this;
        }

        public Criteria andOperationExtend4IsNull() {
            addCriterion("operation_extend4 is null");
            return (Criteria) this;
        }

        public Criteria andOperationExtend4IsNotNull() {
            addCriterion("operation_extend4 is not null");
            return (Criteria) this;
        }

        public Criteria andOperationExtend4EqualTo(String value) {
            addCriterion("operation_extend4 =", value, "operationExtend4");
            return (Criteria) this;
        }

        public Criteria andOperationExtend4NotEqualTo(String value) {
            addCriterion("operation_extend4 <>", value, "operationExtend4");
            return (Criteria) this;
        }

        public Criteria andOperationExtend4GreaterThan(String value) {
            addCriterion("operation_extend4 >", value, "operationExtend4");
            return (Criteria) this;
        }

        public Criteria andOperationExtend4GreaterThanOrEqualTo(String value) {
            addCriterion("operation_extend4 >=", value, "operationExtend4");
            return (Criteria) this;
        }

        public Criteria andOperationExtend4LessThan(String value) {
            addCriterion("operation_extend4 <", value, "operationExtend4");
            return (Criteria) this;
        }

        public Criteria andOperationExtend4LessThanOrEqualTo(String value) {
            addCriterion("operation_extend4 <=", value, "operationExtend4");
            return (Criteria) this;
        }

        public Criteria andOperationExtend4Like(String value) {
            addCriterion("operation_extend4 like", value, "operationExtend4");
            return (Criteria) this;
        }

        public Criteria andOperationExtend4NotLike(String value) {
            addCriterion("operation_extend4 not like", value, "operationExtend4");
            return (Criteria) this;
        }

        public Criteria andOperationExtend4In(List<String> values) {
            addCriterion("operation_extend4 in", values, "operationExtend4");
            return (Criteria) this;
        }

        public Criteria andOperationExtend4NotIn(List<String> values) {
            addCriterion("operation_extend4 not in", values, "operationExtend4");
            return (Criteria) this;
        }

        public Criteria andOperationExtend4Between(String value1, String value2) {
            addCriterion("operation_extend4 between", value1, value2, "operationExtend4");
            return (Criteria) this;
        }

        public Criteria andOperationExtend4NotBetween(String value1, String value2) {
            addCriterion("operation_extend4 not between", value1, value2, "operationExtend4");
            return (Criteria) this;
        }

        public Criteria andOperationExtend5IsNull() {
            addCriterion("operation_extend5 is null");
            return (Criteria) this;
        }

        public Criteria andOperationExtend5IsNotNull() {
            addCriterion("operation_extend5 is not null");
            return (Criteria) this;
        }

        public Criteria andOperationExtend5EqualTo(String value) {
            addCriterion("operation_extend5 =", value, "operationExtend5");
            return (Criteria) this;
        }

        public Criteria andOperationExtend5NotEqualTo(String value) {
            addCriterion("operation_extend5 <>", value, "operationExtend5");
            return (Criteria) this;
        }

        public Criteria andOperationExtend5GreaterThan(String value) {
            addCriterion("operation_extend5 >", value, "operationExtend5");
            return (Criteria) this;
        }

        public Criteria andOperationExtend5GreaterThanOrEqualTo(String value) {
            addCriterion("operation_extend5 >=", value, "operationExtend5");
            return (Criteria) this;
        }

        public Criteria andOperationExtend5LessThan(String value) {
            addCriterion("operation_extend5 <", value, "operationExtend5");
            return (Criteria) this;
        }

        public Criteria andOperationExtend5LessThanOrEqualTo(String value) {
            addCriterion("operation_extend5 <=", value, "operationExtend5");
            return (Criteria) this;
        }

        public Criteria andOperationExtend5Like(String value) {
            addCriterion("operation_extend5 like", value, "operationExtend5");
            return (Criteria) this;
        }

        public Criteria andOperationExtend5NotLike(String value) {
            addCriterion("operation_extend5 not like", value, "operationExtend5");
            return (Criteria) this;
        }

        public Criteria andOperationExtend5In(List<String> values) {
            addCriterion("operation_extend5 in", values, "operationExtend5");
            return (Criteria) this;
        }

        public Criteria andOperationExtend5NotIn(List<String> values) {
            addCriterion("operation_extend5 not in", values, "operationExtend5");
            return (Criteria) this;
        }

        public Criteria andOperationExtend5Between(String value1, String value2) {
            addCriterion("operation_extend5 between", value1, value2, "operationExtend5");
            return (Criteria) this;
        }

        public Criteria andOperationExtend5NotBetween(String value1, String value2) {
            addCriterion("operation_extend5 not between", value1, value2, "operationExtend5");
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