package com.jyr.iot.platform.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AlarmLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AlarmLogExample() {
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

        public Criteria andAlarmIdIsNull() {
            addCriterion("alarm_id is null");
            return (Criteria) this;
        }

        public Criteria andAlarmIdIsNotNull() {
            addCriterion("alarm_id is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmIdEqualTo(Integer value) {
            addCriterion("alarm_id =", value, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdNotEqualTo(Integer value) {
            addCriterion("alarm_id <>", value, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdGreaterThan(Integer value) {
            addCriterion("alarm_id >", value, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("alarm_id >=", value, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdLessThan(Integer value) {
            addCriterion("alarm_id <", value, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdLessThanOrEqualTo(Integer value) {
            addCriterion("alarm_id <=", value, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdIn(List<Integer> values) {
            addCriterion("alarm_id in", values, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdNotIn(List<Integer> values) {
            addCriterion("alarm_id not in", values, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdBetween(Integer value1, Integer value2) {
            addCriterion("alarm_id between", value1, value2, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdNotBetween(Integer value1, Integer value2) {
            addCriterion("alarm_id not between", value1, value2, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeIsNull() {
            addCriterion("alarm_time is null");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeIsNotNull() {
            addCriterion("alarm_time is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeEqualTo(Date value) {
            addCriterion("alarm_time =", value, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeNotEqualTo(Date value) {
            addCriterion("alarm_time <>", value, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeGreaterThan(Date value) {
            addCriterion("alarm_time >", value, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("alarm_time >=", value, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeLessThan(Date value) {
            addCriterion("alarm_time <", value, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeLessThanOrEqualTo(Date value) {
            addCriterion("alarm_time <=", value, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeIn(List<Date> values) {
            addCriterion("alarm_time in", values, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeNotIn(List<Date> values) {
            addCriterion("alarm_time not in", values, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeBetween(Date value1, Date value2) {
            addCriterion("alarm_time between", value1, value2, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeNotBetween(Date value1, Date value2) {
            addCriterion("alarm_time not between", value1, value2, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmCompanyIdIsNull() {
            addCriterion("alarm_company_id is null");
            return (Criteria) this;
        }

        public Criteria andAlarmCompanyIdIsNotNull() {
            addCriterion("alarm_company_id is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmCompanyIdEqualTo(Integer value) {
            addCriterion("alarm_company_id =", value, "alarmCompanyId");
            return (Criteria) this;
        }

        public Criteria andAlarmCompanyIdNotEqualTo(Integer value) {
            addCriterion("alarm_company_id <>", value, "alarmCompanyId");
            return (Criteria) this;
        }

        public Criteria andAlarmCompanyIdGreaterThan(Integer value) {
            addCriterion("alarm_company_id >", value, "alarmCompanyId");
            return (Criteria) this;
        }

        public Criteria andAlarmCompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("alarm_company_id >=", value, "alarmCompanyId");
            return (Criteria) this;
        }

        public Criteria andAlarmCompanyIdLessThan(Integer value) {
            addCriterion("alarm_company_id <", value, "alarmCompanyId");
            return (Criteria) this;
        }

        public Criteria andAlarmCompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("alarm_company_id <=", value, "alarmCompanyId");
            return (Criteria) this;
        }

        public Criteria andAlarmCompanyIdIn(List<Integer> values) {
            addCriterion("alarm_company_id in", values, "alarmCompanyId");
            return (Criteria) this;
        }

        public Criteria andAlarmCompanyIdNotIn(List<Integer> values) {
            addCriterion("alarm_company_id not in", values, "alarmCompanyId");
            return (Criteria) this;
        }

        public Criteria andAlarmCompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("alarm_company_id between", value1, value2, "alarmCompanyId");
            return (Criteria) this;
        }

        public Criteria andAlarmCompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("alarm_company_id not between", value1, value2, "alarmCompanyId");
            return (Criteria) this;
        }

        public Criteria andAlarmProjectIdIsNull() {
            addCriterion("alarm_project_id is null");
            return (Criteria) this;
        }

        public Criteria andAlarmProjectIdIsNotNull() {
            addCriterion("alarm_project_id is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmProjectIdEqualTo(Integer value) {
            addCriterion("alarm_project_id =", value, "alarmProjectId");
            return (Criteria) this;
        }

        public Criteria andAlarmProjectIdNotEqualTo(Integer value) {
            addCriterion("alarm_project_id <>", value, "alarmProjectId");
            return (Criteria) this;
        }

        public Criteria andAlarmProjectIdGreaterThan(Integer value) {
            addCriterion("alarm_project_id >", value, "alarmProjectId");
            return (Criteria) this;
        }

        public Criteria andAlarmProjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("alarm_project_id >=", value, "alarmProjectId");
            return (Criteria) this;
        }

        public Criteria andAlarmProjectIdLessThan(Integer value) {
            addCriterion("alarm_project_id <", value, "alarmProjectId");
            return (Criteria) this;
        }

        public Criteria andAlarmProjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("alarm_project_id <=", value, "alarmProjectId");
            return (Criteria) this;
        }

        public Criteria andAlarmProjectIdIn(List<Integer> values) {
            addCriterion("alarm_project_id in", values, "alarmProjectId");
            return (Criteria) this;
        }

        public Criteria andAlarmProjectIdNotIn(List<Integer> values) {
            addCriterion("alarm_project_id not in", values, "alarmProjectId");
            return (Criteria) this;
        }

        public Criteria andAlarmProjectIdBetween(Integer value1, Integer value2) {
            addCriterion("alarm_project_id between", value1, value2, "alarmProjectId");
            return (Criteria) this;
        }

        public Criteria andAlarmProjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("alarm_project_id not between", value1, value2, "alarmProjectId");
            return (Criteria) this;
        }

        public Criteria andAlarmDeviceIdIsNull() {
            addCriterion("alarm_device_id is null");
            return (Criteria) this;
        }

        public Criteria andAlarmDeviceIdIsNotNull() {
            addCriterion("alarm_device_id is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmDeviceIdEqualTo(Integer value) {
            addCriterion("alarm_device_id =", value, "alarmDeviceId");
            return (Criteria) this;
        }

        public Criteria andAlarmDeviceIdNotEqualTo(Integer value) {
            addCriterion("alarm_device_id <>", value, "alarmDeviceId");
            return (Criteria) this;
        }

        public Criteria andAlarmDeviceIdGreaterThan(Integer value) {
            addCriterion("alarm_device_id >", value, "alarmDeviceId");
            return (Criteria) this;
        }

        public Criteria andAlarmDeviceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("alarm_device_id >=", value, "alarmDeviceId");
            return (Criteria) this;
        }

        public Criteria andAlarmDeviceIdLessThan(Integer value) {
            addCriterion("alarm_device_id <", value, "alarmDeviceId");
            return (Criteria) this;
        }

        public Criteria andAlarmDeviceIdLessThanOrEqualTo(Integer value) {
            addCriterion("alarm_device_id <=", value, "alarmDeviceId");
            return (Criteria) this;
        }

        public Criteria andAlarmDeviceIdIn(List<Integer> values) {
            addCriterion("alarm_device_id in", values, "alarmDeviceId");
            return (Criteria) this;
        }

        public Criteria andAlarmDeviceIdNotIn(List<Integer> values) {
            addCriterion("alarm_device_id not in", values, "alarmDeviceId");
            return (Criteria) this;
        }

        public Criteria andAlarmDeviceIdBetween(Integer value1, Integer value2) {
            addCriterion("alarm_device_id between", value1, value2, "alarmDeviceId");
            return (Criteria) this;
        }

        public Criteria andAlarmDeviceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("alarm_device_id not between", value1, value2, "alarmDeviceId");
            return (Criteria) this;
        }

        public Criteria andAlarmLIsNull() {
            addCriterion("alarm_l is null");
            return (Criteria) this;
        }

        public Criteria andAlarmLIsNotNull() {
            addCriterion("alarm_l is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmLEqualTo(Integer value) {
            addCriterion("alarm_l =", value, "alarmL");
            return (Criteria) this;
        }

        public Criteria andAlarmLNotEqualTo(Integer value) {
            addCriterion("alarm_l <>", value, "alarmL");
            return (Criteria) this;
        }

        public Criteria andAlarmLGreaterThan(Integer value) {
            addCriterion("alarm_l >", value, "alarmL");
            return (Criteria) this;
        }

        public Criteria andAlarmLGreaterThanOrEqualTo(Integer value) {
            addCriterion("alarm_l >=", value, "alarmL");
            return (Criteria) this;
        }

        public Criteria andAlarmLLessThan(Integer value) {
            addCriterion("alarm_l <", value, "alarmL");
            return (Criteria) this;
        }

        public Criteria andAlarmLLessThanOrEqualTo(Integer value) {
            addCriterion("alarm_l <=", value, "alarmL");
            return (Criteria) this;
        }

        public Criteria andAlarmLIn(List<Integer> values) {
            addCriterion("alarm_l in", values, "alarmL");
            return (Criteria) this;
        }

        public Criteria andAlarmLNotIn(List<Integer> values) {
            addCriterion("alarm_l not in", values, "alarmL");
            return (Criteria) this;
        }

        public Criteria andAlarmLBetween(Integer value1, Integer value2) {
            addCriterion("alarm_l between", value1, value2, "alarmL");
            return (Criteria) this;
        }

        public Criteria andAlarmLNotBetween(Integer value1, Integer value2) {
            addCriterion("alarm_l not between", value1, value2, "alarmL");
            return (Criteria) this;
        }

        public Criteria andAlarmNameIsNull() {
            addCriterion("alarm_name is null");
            return (Criteria) this;
        }

        public Criteria andAlarmNameIsNotNull() {
            addCriterion("alarm_name is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmNameEqualTo(String value) {
            addCriterion("alarm_name =", value, "alarmName");
            return (Criteria) this;
        }

        public Criteria andAlarmNameNotEqualTo(String value) {
            addCriterion("alarm_name <>", value, "alarmName");
            return (Criteria) this;
        }

        public Criteria andAlarmNameGreaterThan(String value) {
            addCriterion("alarm_name >", value, "alarmName");
            return (Criteria) this;
        }

        public Criteria andAlarmNameGreaterThanOrEqualTo(String value) {
            addCriterion("alarm_name >=", value, "alarmName");
            return (Criteria) this;
        }

        public Criteria andAlarmNameLessThan(String value) {
            addCriterion("alarm_name <", value, "alarmName");
            return (Criteria) this;
        }

        public Criteria andAlarmNameLessThanOrEqualTo(String value) {
            addCriterion("alarm_name <=", value, "alarmName");
            return (Criteria) this;
        }

        public Criteria andAlarmNameLike(String value) {
            addCriterion("alarm_name like", value, "alarmName");
            return (Criteria) this;
        }

        public Criteria andAlarmNameNotLike(String value) {
            addCriterion("alarm_name not like", value, "alarmName");
            return (Criteria) this;
        }

        public Criteria andAlarmNameIn(List<String> values) {
            addCriterion("alarm_name in", values, "alarmName");
            return (Criteria) this;
        }

        public Criteria andAlarmNameNotIn(List<String> values) {
            addCriterion("alarm_name not in", values, "alarmName");
            return (Criteria) this;
        }

        public Criteria andAlarmNameBetween(String value1, String value2) {
            addCriterion("alarm_name between", value1, value2, "alarmName");
            return (Criteria) this;
        }

        public Criteria andAlarmNameNotBetween(String value1, String value2) {
            addCriterion("alarm_name not between", value1, value2, "alarmName");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeIsNull() {
            addCriterion("alarm_type is null");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeIsNotNull() {
            addCriterion("alarm_type is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeEqualTo(Integer value) {
            addCriterion("alarm_type =", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeNotEqualTo(Integer value) {
            addCriterion("alarm_type <>", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeGreaterThan(Integer value) {
            addCriterion("alarm_type >", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("alarm_type >=", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeLessThan(Integer value) {
            addCriterion("alarm_type <", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeLessThanOrEqualTo(Integer value) {
            addCriterion("alarm_type <=", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeIn(List<Integer> values) {
            addCriterion("alarm_type in", values, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeNotIn(List<Integer> values) {
            addCriterion("alarm_type not in", values, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeBetween(Integer value1, Integer value2) {
            addCriterion("alarm_type between", value1, value2, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("alarm_type not between", value1, value2, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmValueIsNull() {
            addCriterion("alarm_value is null");
            return (Criteria) this;
        }

        public Criteria andAlarmValueIsNotNull() {
            addCriterion("alarm_value is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmValueEqualTo(Integer value) {
            addCriterion("alarm_value =", value, "alarmValue");
            return (Criteria) this;
        }

        public Criteria andAlarmValueNotEqualTo(Integer value) {
            addCriterion("alarm_value <>", value, "alarmValue");
            return (Criteria) this;
        }

        public Criteria andAlarmValueGreaterThan(Integer value) {
            addCriterion("alarm_value >", value, "alarmValue");
            return (Criteria) this;
        }

        public Criteria andAlarmValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("alarm_value >=", value, "alarmValue");
            return (Criteria) this;
        }

        public Criteria andAlarmValueLessThan(Integer value) {
            addCriterion("alarm_value <", value, "alarmValue");
            return (Criteria) this;
        }

        public Criteria andAlarmValueLessThanOrEqualTo(Integer value) {
            addCriterion("alarm_value <=", value, "alarmValue");
            return (Criteria) this;
        }

        public Criteria andAlarmValueIn(List<Integer> values) {
            addCriterion("alarm_value in", values, "alarmValue");
            return (Criteria) this;
        }

        public Criteria andAlarmValueNotIn(List<Integer> values) {
            addCriterion("alarm_value not in", values, "alarmValue");
            return (Criteria) this;
        }

        public Criteria andAlarmValueBetween(Integer value1, Integer value2) {
            addCriterion("alarm_value between", value1, value2, "alarmValue");
            return (Criteria) this;
        }

        public Criteria andAlarmValueNotBetween(Integer value1, Integer value2) {
            addCriterion("alarm_value not between", value1, value2, "alarmValue");
            return (Criteria) this;
        }

        public Criteria andAlarmStatusIsNull() {
            addCriterion("alarm_status is null");
            return (Criteria) this;
        }

        public Criteria andAlarmStatusIsNotNull() {
            addCriterion("alarm_status is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmStatusEqualTo(Integer value) {
            addCriterion("alarm_status =", value, "alarmStatus");
            return (Criteria) this;
        }

        public Criteria andAlarmStatusNotEqualTo(Integer value) {
            addCriterion("alarm_status <>", value, "alarmStatus");
            return (Criteria) this;
        }

        public Criteria andAlarmStatusGreaterThan(Integer value) {
            addCriterion("alarm_status >", value, "alarmStatus");
            return (Criteria) this;
        }

        public Criteria andAlarmStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("alarm_status >=", value, "alarmStatus");
            return (Criteria) this;
        }

        public Criteria andAlarmStatusLessThan(Integer value) {
            addCriterion("alarm_status <", value, "alarmStatus");
            return (Criteria) this;
        }

        public Criteria andAlarmStatusLessThanOrEqualTo(Integer value) {
            addCriterion("alarm_status <=", value, "alarmStatus");
            return (Criteria) this;
        }

        public Criteria andAlarmStatusIn(List<Integer> values) {
            addCriterion("alarm_status in", values, "alarmStatus");
            return (Criteria) this;
        }

        public Criteria andAlarmStatusNotIn(List<Integer> values) {
            addCriterion("alarm_status not in", values, "alarmStatus");
            return (Criteria) this;
        }

        public Criteria andAlarmStatusBetween(Integer value1, Integer value2) {
            addCriterion("alarm_status between", value1, value2, "alarmStatus");
            return (Criteria) this;
        }

        public Criteria andAlarmStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("alarm_status not between", value1, value2, "alarmStatus");
            return (Criteria) this;
        }

        public Criteria andAlarmSolveResultIsNull() {
            addCriterion("alarm_solve_result is null");
            return (Criteria) this;
        }

        public Criteria andAlarmSolveResultIsNotNull() {
            addCriterion("alarm_solve_result is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmSolveResultEqualTo(String value) {
            addCriterion("alarm_solve_result =", value, "alarmSolveResult");
            return (Criteria) this;
        }

        public Criteria andAlarmSolveResultNotEqualTo(String value) {
            addCriterion("alarm_solve_result <>", value, "alarmSolveResult");
            return (Criteria) this;
        }

        public Criteria andAlarmSolveResultGreaterThan(String value) {
            addCriterion("alarm_solve_result >", value, "alarmSolveResult");
            return (Criteria) this;
        }

        public Criteria andAlarmSolveResultGreaterThanOrEqualTo(String value) {
            addCriterion("alarm_solve_result >=", value, "alarmSolveResult");
            return (Criteria) this;
        }

        public Criteria andAlarmSolveResultLessThan(String value) {
            addCriterion("alarm_solve_result <", value, "alarmSolveResult");
            return (Criteria) this;
        }

        public Criteria andAlarmSolveResultLessThanOrEqualTo(String value) {
            addCriterion("alarm_solve_result <=", value, "alarmSolveResult");
            return (Criteria) this;
        }

        public Criteria andAlarmSolveResultLike(String value) {
            addCriterion("alarm_solve_result like", value, "alarmSolveResult");
            return (Criteria) this;
        }

        public Criteria andAlarmSolveResultNotLike(String value) {
            addCriterion("alarm_solve_result not like", value, "alarmSolveResult");
            return (Criteria) this;
        }

        public Criteria andAlarmSolveResultIn(List<String> values) {
            addCriterion("alarm_solve_result in", values, "alarmSolveResult");
            return (Criteria) this;
        }

        public Criteria andAlarmSolveResultNotIn(List<String> values) {
            addCriterion("alarm_solve_result not in", values, "alarmSolveResult");
            return (Criteria) this;
        }

        public Criteria andAlarmSolveResultBetween(String value1, String value2) {
            addCriterion("alarm_solve_result between", value1, value2, "alarmSolveResult");
            return (Criteria) this;
        }

        public Criteria andAlarmSolveResultNotBetween(String value1, String value2) {
            addCriterion("alarm_solve_result not between", value1, value2, "alarmSolveResult");
            return (Criteria) this;
        }

        public Criteria andAlarmSolveTimeIsNull() {
            addCriterion("alarm_solve_time is null");
            return (Criteria) this;
        }

        public Criteria andAlarmSolveTimeIsNotNull() {
            addCriterion("alarm_solve_time is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmSolveTimeEqualTo(Date value) {
            addCriterion("alarm_solve_time =", value, "alarmSolveTime");
            return (Criteria) this;
        }

        public Criteria andAlarmSolveTimeNotEqualTo(Date value) {
            addCriterion("alarm_solve_time <>", value, "alarmSolveTime");
            return (Criteria) this;
        }

        public Criteria andAlarmSolveTimeGreaterThan(Date value) {
            addCriterion("alarm_solve_time >", value, "alarmSolveTime");
            return (Criteria) this;
        }

        public Criteria andAlarmSolveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("alarm_solve_time >=", value, "alarmSolveTime");
            return (Criteria) this;
        }

        public Criteria andAlarmSolveTimeLessThan(Date value) {
            addCriterion("alarm_solve_time <", value, "alarmSolveTime");
            return (Criteria) this;
        }

        public Criteria andAlarmSolveTimeLessThanOrEqualTo(Date value) {
            addCriterion("alarm_solve_time <=", value, "alarmSolveTime");
            return (Criteria) this;
        }

        public Criteria andAlarmSolveTimeIn(List<Date> values) {
            addCriterion("alarm_solve_time in", values, "alarmSolveTime");
            return (Criteria) this;
        }

        public Criteria andAlarmSolveTimeNotIn(List<Date> values) {
            addCriterion("alarm_solve_time not in", values, "alarmSolveTime");
            return (Criteria) this;
        }

        public Criteria andAlarmSolveTimeBetween(Date value1, Date value2) {
            addCriterion("alarm_solve_time between", value1, value2, "alarmSolveTime");
            return (Criteria) this;
        }

        public Criteria andAlarmSolveTimeNotBetween(Date value1, Date value2) {
            addCriterion("alarm_solve_time not between", value1, value2, "alarmSolveTime");
            return (Criteria) this;
        }

        public Criteria andAlarmUserIdIsNull() {
            addCriterion("alarm_user_id is null");
            return (Criteria) this;
        }

        public Criteria andAlarmUserIdIsNotNull() {
            addCriterion("alarm_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmUserIdEqualTo(Integer value) {
            addCriterion("alarm_user_id =", value, "alarmUserId");
            return (Criteria) this;
        }

        public Criteria andAlarmUserIdNotEqualTo(Integer value) {
            addCriterion("alarm_user_id <>", value, "alarmUserId");
            return (Criteria) this;
        }

        public Criteria andAlarmUserIdGreaterThan(Integer value) {
            addCriterion("alarm_user_id >", value, "alarmUserId");
            return (Criteria) this;
        }

        public Criteria andAlarmUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("alarm_user_id >=", value, "alarmUserId");
            return (Criteria) this;
        }

        public Criteria andAlarmUserIdLessThan(Integer value) {
            addCriterion("alarm_user_id <", value, "alarmUserId");
            return (Criteria) this;
        }

        public Criteria andAlarmUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("alarm_user_id <=", value, "alarmUserId");
            return (Criteria) this;
        }

        public Criteria andAlarmUserIdIn(List<Integer> values) {
            addCriterion("alarm_user_id in", values, "alarmUserId");
            return (Criteria) this;
        }

        public Criteria andAlarmUserIdNotIn(List<Integer> values) {
            addCriterion("alarm_user_id not in", values, "alarmUserId");
            return (Criteria) this;
        }

        public Criteria andAlarmUserIdBetween(Integer value1, Integer value2) {
            addCriterion("alarm_user_id between", value1, value2, "alarmUserId");
            return (Criteria) this;
        }

        public Criteria andAlarmUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("alarm_user_id not between", value1, value2, "alarmUserId");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend1IsNull() {
            addCriterion("alarm_extend1 is null");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend1IsNotNull() {
            addCriterion("alarm_extend1 is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend1EqualTo(String value) {
            addCriterion("alarm_extend1 =", value, "alarmExtend1");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend1NotEqualTo(String value) {
            addCriterion("alarm_extend1 <>", value, "alarmExtend1");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend1GreaterThan(String value) {
            addCriterion("alarm_extend1 >", value, "alarmExtend1");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend1GreaterThanOrEqualTo(String value) {
            addCriterion("alarm_extend1 >=", value, "alarmExtend1");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend1LessThan(String value) {
            addCriterion("alarm_extend1 <", value, "alarmExtend1");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend1LessThanOrEqualTo(String value) {
            addCriterion("alarm_extend1 <=", value, "alarmExtend1");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend1Like(String value) {
            addCriterion("alarm_extend1 like", value, "alarmExtend1");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend1NotLike(String value) {
            addCriterion("alarm_extend1 not like", value, "alarmExtend1");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend1In(List<String> values) {
            addCriterion("alarm_extend1 in", values, "alarmExtend1");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend1NotIn(List<String> values) {
            addCriterion("alarm_extend1 not in", values, "alarmExtend1");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend1Between(String value1, String value2) {
            addCriterion("alarm_extend1 between", value1, value2, "alarmExtend1");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend1NotBetween(String value1, String value2) {
            addCriterion("alarm_extend1 not between", value1, value2, "alarmExtend1");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend2IsNull() {
            addCriterion("alarm_extend2 is null");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend2IsNotNull() {
            addCriterion("alarm_extend2 is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend2EqualTo(String value) {
            addCriterion("alarm_extend2 =", value, "alarmExtend2");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend2NotEqualTo(String value) {
            addCriterion("alarm_extend2 <>", value, "alarmExtend2");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend2GreaterThan(String value) {
            addCriterion("alarm_extend2 >", value, "alarmExtend2");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend2GreaterThanOrEqualTo(String value) {
            addCriterion("alarm_extend2 >=", value, "alarmExtend2");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend2LessThan(String value) {
            addCriterion("alarm_extend2 <", value, "alarmExtend2");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend2LessThanOrEqualTo(String value) {
            addCriterion("alarm_extend2 <=", value, "alarmExtend2");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend2Like(String value) {
            addCriterion("alarm_extend2 like", value, "alarmExtend2");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend2NotLike(String value) {
            addCriterion("alarm_extend2 not like", value, "alarmExtend2");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend2In(List<String> values) {
            addCriterion("alarm_extend2 in", values, "alarmExtend2");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend2NotIn(List<String> values) {
            addCriterion("alarm_extend2 not in", values, "alarmExtend2");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend2Between(String value1, String value2) {
            addCriterion("alarm_extend2 between", value1, value2, "alarmExtend2");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend2NotBetween(String value1, String value2) {
            addCriterion("alarm_extend2 not between", value1, value2, "alarmExtend2");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend3IsNull() {
            addCriterion("alarm_extend3 is null");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend3IsNotNull() {
            addCriterion("alarm_extend3 is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend3EqualTo(String value) {
            addCriterion("alarm_extend3 =", value, "alarmExtend3");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend3NotEqualTo(String value) {
            addCriterion("alarm_extend3 <>", value, "alarmExtend3");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend3GreaterThan(String value) {
            addCriterion("alarm_extend3 >", value, "alarmExtend3");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend3GreaterThanOrEqualTo(String value) {
            addCriterion("alarm_extend3 >=", value, "alarmExtend3");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend3LessThan(String value) {
            addCriterion("alarm_extend3 <", value, "alarmExtend3");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend3LessThanOrEqualTo(String value) {
            addCriterion("alarm_extend3 <=", value, "alarmExtend3");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend3Like(String value) {
            addCriterion("alarm_extend3 like", value, "alarmExtend3");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend3NotLike(String value) {
            addCriterion("alarm_extend3 not like", value, "alarmExtend3");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend3In(List<String> values) {
            addCriterion("alarm_extend3 in", values, "alarmExtend3");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend3NotIn(List<String> values) {
            addCriterion("alarm_extend3 not in", values, "alarmExtend3");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend3Between(String value1, String value2) {
            addCriterion("alarm_extend3 between", value1, value2, "alarmExtend3");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend3NotBetween(String value1, String value2) {
            addCriterion("alarm_extend3 not between", value1, value2, "alarmExtend3");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend4IsNull() {
            addCriterion("alarm_extend4 is null");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend4IsNotNull() {
            addCriterion("alarm_extend4 is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend4EqualTo(String value) {
            addCriterion("alarm_extend4 =", value, "alarmExtend4");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend4NotEqualTo(String value) {
            addCriterion("alarm_extend4 <>", value, "alarmExtend4");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend4GreaterThan(String value) {
            addCriterion("alarm_extend4 >", value, "alarmExtend4");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend4GreaterThanOrEqualTo(String value) {
            addCriterion("alarm_extend4 >=", value, "alarmExtend4");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend4LessThan(String value) {
            addCriterion("alarm_extend4 <", value, "alarmExtend4");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend4LessThanOrEqualTo(String value) {
            addCriterion("alarm_extend4 <=", value, "alarmExtend4");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend4Like(String value) {
            addCriterion("alarm_extend4 like", value, "alarmExtend4");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend4NotLike(String value) {
            addCriterion("alarm_extend4 not like", value, "alarmExtend4");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend4In(List<String> values) {
            addCriterion("alarm_extend4 in", values, "alarmExtend4");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend4NotIn(List<String> values) {
            addCriterion("alarm_extend4 not in", values, "alarmExtend4");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend4Between(String value1, String value2) {
            addCriterion("alarm_extend4 between", value1, value2, "alarmExtend4");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend4NotBetween(String value1, String value2) {
            addCriterion("alarm_extend4 not between", value1, value2, "alarmExtend4");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend5IsNull() {
            addCriterion("alarm_extend5 is null");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend5IsNotNull() {
            addCriterion("alarm_extend5 is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend5EqualTo(String value) {
            addCriterion("alarm_extend5 =", value, "alarmExtend5");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend5NotEqualTo(String value) {
            addCriterion("alarm_extend5 <>", value, "alarmExtend5");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend5GreaterThan(String value) {
            addCriterion("alarm_extend5 >", value, "alarmExtend5");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend5GreaterThanOrEqualTo(String value) {
            addCriterion("alarm_extend5 >=", value, "alarmExtend5");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend5LessThan(String value) {
            addCriterion("alarm_extend5 <", value, "alarmExtend5");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend5LessThanOrEqualTo(String value) {
            addCriterion("alarm_extend5 <=", value, "alarmExtend5");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend5Like(String value) {
            addCriterion("alarm_extend5 like", value, "alarmExtend5");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend5NotLike(String value) {
            addCriterion("alarm_extend5 not like", value, "alarmExtend5");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend5In(List<String> values) {
            addCriterion("alarm_extend5 in", values, "alarmExtend5");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend5NotIn(List<String> values) {
            addCriterion("alarm_extend5 not in", values, "alarmExtend5");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend5Between(String value1, String value2) {
            addCriterion("alarm_extend5 between", value1, value2, "alarmExtend5");
            return (Criteria) this;
        }

        public Criteria andAlarmExtend5NotBetween(String value1, String value2) {
            addCriterion("alarm_extend5 not between", value1, value2, "alarmExtend5");
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