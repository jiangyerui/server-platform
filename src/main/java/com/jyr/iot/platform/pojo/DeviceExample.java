package com.jyr.iot.platform.pojo;

import java.util.ArrayList;
import java.util.List;

public class DeviceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceExample() {
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

        public Criteria andDeviceIdIsNull() {
            addCriterion("device_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("device_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdEqualTo(Integer value) {
            addCriterion("device_id =", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualTo(Integer value) {
            addCriterion("device_id <>", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThan(Integer value) {
            addCriterion("device_id >", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_id >=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThan(Integer value) {
            addCriterion("device_id <", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(Integer value) {
            addCriterion("device_id <=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIn(List<Integer> values) {
            addCriterion("device_id in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotIn(List<Integer> values) {
            addCriterion("device_id not in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdBetween(Integer value1, Integer value2) {
            addCriterion("device_id between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("device_id not between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceNoIsNull() {
            addCriterion("device_no is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNoIsNotNull() {
            addCriterion("device_no is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNoEqualTo(String value) {
            addCriterion("device_no =", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoNotEqualTo(String value) {
            addCriterion("device_no <>", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoGreaterThan(String value) {
            addCriterion("device_no >", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoGreaterThanOrEqualTo(String value) {
            addCriterion("device_no >=", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoLessThan(String value) {
            addCriterion("device_no <", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoLessThanOrEqualTo(String value) {
            addCriterion("device_no <=", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoLike(String value) {
            addCriterion("device_no like", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoNotLike(String value) {
            addCriterion("device_no not like", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoIn(List<String> values) {
            addCriterion("device_no in", values, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoNotIn(List<String> values) {
            addCriterion("device_no not in", values, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoBetween(String value1, String value2) {
            addCriterion("device_no between", value1, value2, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoNotBetween(String value1, String value2) {
            addCriterion("device_no not between", value1, value2, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIsNull() {
            addCriterion("device_name is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIsNotNull() {
            addCriterion("device_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameEqualTo(String value) {
            addCriterion("device_name =", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotEqualTo(String value) {
            addCriterion("device_name <>", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThan(String value) {
            addCriterion("device_name >", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThanOrEqualTo(String value) {
            addCriterion("device_name >=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThan(String value) {
            addCriterion("device_name <", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThanOrEqualTo(String value) {
            addCriterion("device_name <=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLike(String value) {
            addCriterion("device_name like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotLike(String value) {
            addCriterion("device_name not like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIn(List<String> values) {
            addCriterion("device_name in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotIn(List<String> values) {
            addCriterion("device_name not in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameBetween(String value1, String value2) {
            addCriterion("device_name between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotBetween(String value1, String value2) {
            addCriterion("device_name not between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDevicePermissionIsNull() {
            addCriterion("device_permission is null");
            return (Criteria) this;
        }

        public Criteria andDevicePermissionIsNotNull() {
            addCriterion("device_permission is not null");
            return (Criteria) this;
        }

        public Criteria andDevicePermissionEqualTo(Integer value) {
            addCriterion("device_permission =", value, "devicePermission");
            return (Criteria) this;
        }

        public Criteria andDevicePermissionNotEqualTo(Integer value) {
            addCriterion("device_permission <>", value, "devicePermission");
            return (Criteria) this;
        }

        public Criteria andDevicePermissionGreaterThan(Integer value) {
            addCriterion("device_permission >", value, "devicePermission");
            return (Criteria) this;
        }

        public Criteria andDevicePermissionGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_permission >=", value, "devicePermission");
            return (Criteria) this;
        }

        public Criteria andDevicePermissionLessThan(Integer value) {
            addCriterion("device_permission <", value, "devicePermission");
            return (Criteria) this;
        }

        public Criteria andDevicePermissionLessThanOrEqualTo(Integer value) {
            addCriterion("device_permission <=", value, "devicePermission");
            return (Criteria) this;
        }

        public Criteria andDevicePermissionIn(List<Integer> values) {
            addCriterion("device_permission in", values, "devicePermission");
            return (Criteria) this;
        }

        public Criteria andDevicePermissionNotIn(List<Integer> values) {
            addCriterion("device_permission not in", values, "devicePermission");
            return (Criteria) this;
        }

        public Criteria andDevicePermissionBetween(Integer value1, Integer value2) {
            addCriterion("device_permission between", value1, value2, "devicePermission");
            return (Criteria) this;
        }

        public Criteria andDevicePermissionNotBetween(Integer value1, Integer value2) {
            addCriterion("device_permission not between", value1, value2, "devicePermission");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIsNull() {
            addCriterion("device_type is null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIsNotNull() {
            addCriterion("device_type is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeEqualTo(String value) {
            addCriterion("device_type =", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotEqualTo(String value) {
            addCriterion("device_type <>", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeGreaterThan(String value) {
            addCriterion("device_type >", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("device_type >=", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLessThan(String value) {
            addCriterion("device_type <", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLessThanOrEqualTo(String value) {
            addCriterion("device_type <=", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLike(String value) {
            addCriterion("device_type like", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotLike(String value) {
            addCriterion("device_type not like", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIn(List<String> values) {
            addCriterion("device_type in", values, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotIn(List<String> values) {
            addCriterion("device_type not in", values, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeBetween(String value1, String value2) {
            addCriterion("device_type between", value1, value2, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotBetween(String value1, String value2) {
            addCriterion("device_type not between", value1, value2, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceCompanyIdIsNull() {
            addCriterion("device_company_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceCompanyIdIsNotNull() {
            addCriterion("device_company_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceCompanyIdEqualTo(Integer value) {
            addCriterion("device_company_id =", value, "deviceCompanyId");
            return (Criteria) this;
        }

        public Criteria andDeviceCompanyIdNotEqualTo(Integer value) {
            addCriterion("device_company_id <>", value, "deviceCompanyId");
            return (Criteria) this;
        }

        public Criteria andDeviceCompanyIdGreaterThan(Integer value) {
            addCriterion("device_company_id >", value, "deviceCompanyId");
            return (Criteria) this;
        }

        public Criteria andDeviceCompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_company_id >=", value, "deviceCompanyId");
            return (Criteria) this;
        }

        public Criteria andDeviceCompanyIdLessThan(Integer value) {
            addCriterion("device_company_id <", value, "deviceCompanyId");
            return (Criteria) this;
        }

        public Criteria andDeviceCompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("device_company_id <=", value, "deviceCompanyId");
            return (Criteria) this;
        }

        public Criteria andDeviceCompanyIdIn(List<Integer> values) {
            addCriterion("device_company_id in", values, "deviceCompanyId");
            return (Criteria) this;
        }

        public Criteria andDeviceCompanyIdNotIn(List<Integer> values) {
            addCriterion("device_company_id not in", values, "deviceCompanyId");
            return (Criteria) this;
        }

        public Criteria andDeviceCompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("device_company_id between", value1, value2, "deviceCompanyId");
            return (Criteria) this;
        }

        public Criteria andDeviceCompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("device_company_id not between", value1, value2, "deviceCompanyId");
            return (Criteria) this;
        }

        public Criteria andDeviceProjectIdIsNull() {
            addCriterion("device_project_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceProjectIdIsNotNull() {
            addCriterion("device_project_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceProjectIdEqualTo(Integer value) {
            addCriterion("device_project_id =", value, "deviceProjectId");
            return (Criteria) this;
        }

        public Criteria andDeviceProjectIdNotEqualTo(Integer value) {
            addCriterion("device_project_id <>", value, "deviceProjectId");
            return (Criteria) this;
        }

        public Criteria andDeviceProjectIdGreaterThan(Integer value) {
            addCriterion("device_project_id >", value, "deviceProjectId");
            return (Criteria) this;
        }

        public Criteria andDeviceProjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_project_id >=", value, "deviceProjectId");
            return (Criteria) this;
        }

        public Criteria andDeviceProjectIdLessThan(Integer value) {
            addCriterion("device_project_id <", value, "deviceProjectId");
            return (Criteria) this;
        }

        public Criteria andDeviceProjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("device_project_id <=", value, "deviceProjectId");
            return (Criteria) this;
        }

        public Criteria andDeviceProjectIdIn(List<Integer> values) {
            addCriterion("device_project_id in", values, "deviceProjectId");
            return (Criteria) this;
        }

        public Criteria andDeviceProjectIdNotIn(List<Integer> values) {
            addCriterion("device_project_id not in", values, "deviceProjectId");
            return (Criteria) this;
        }

        public Criteria andDeviceProjectIdBetween(Integer value1, Integer value2) {
            addCriterion("device_project_id between", value1, value2, "deviceProjectId");
            return (Criteria) this;
        }

        public Criteria andDeviceProjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("device_project_id not between", value1, value2, "deviceProjectId");
            return (Criteria) this;
        }

        public Criteria andDeviceCameraIdIsNull() {
            addCriterion("device_camera_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceCameraIdIsNotNull() {
            addCriterion("device_camera_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceCameraIdEqualTo(Integer value) {
            addCriterion("device_camera_id =", value, "deviceCameraId");
            return (Criteria) this;
        }

        public Criteria andDeviceCameraIdNotEqualTo(Integer value) {
            addCriterion("device_camera_id <>", value, "deviceCameraId");
            return (Criteria) this;
        }

        public Criteria andDeviceCameraIdGreaterThan(Integer value) {
            addCriterion("device_camera_id >", value, "deviceCameraId");
            return (Criteria) this;
        }

        public Criteria andDeviceCameraIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_camera_id >=", value, "deviceCameraId");
            return (Criteria) this;
        }

        public Criteria andDeviceCameraIdLessThan(Integer value) {
            addCriterion("device_camera_id <", value, "deviceCameraId");
            return (Criteria) this;
        }

        public Criteria andDeviceCameraIdLessThanOrEqualTo(Integer value) {
            addCriterion("device_camera_id <=", value, "deviceCameraId");
            return (Criteria) this;
        }

        public Criteria andDeviceCameraIdIn(List<Integer> values) {
            addCriterion("device_camera_id in", values, "deviceCameraId");
            return (Criteria) this;
        }

        public Criteria andDeviceCameraIdNotIn(List<Integer> values) {
            addCriterion("device_camera_id not in", values, "deviceCameraId");
            return (Criteria) this;
        }

        public Criteria andDeviceCameraIdBetween(Integer value1, Integer value2) {
            addCriterion("device_camera_id between", value1, value2, "deviceCameraId");
            return (Criteria) this;
        }

        public Criteria andDeviceCameraIdNotBetween(Integer value1, Integer value2) {
            addCriterion("device_camera_id not between", value1, value2, "deviceCameraId");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIsNull() {
            addCriterion("device_status is null");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIsNotNull() {
            addCriterion("device_status is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusEqualTo(Integer value) {
            addCriterion("device_status =", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotEqualTo(Integer value) {
            addCriterion("device_status <>", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusGreaterThan(Integer value) {
            addCriterion("device_status >", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_status >=", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusLessThan(Integer value) {
            addCriterion("device_status <", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusLessThanOrEqualTo(Integer value) {
            addCriterion("device_status <=", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIn(List<Integer> values) {
            addCriterion("device_status in", values, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotIn(List<Integer> values) {
            addCriterion("device_status not in", values, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusBetween(Integer value1, Integer value2) {
            addCriterion("device_status between", value1, value2, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("device_status not between", value1, value2, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceUseStatusIsNull() {
            addCriterion("device_use_status is null");
            return (Criteria) this;
        }

        public Criteria andDeviceUseStatusIsNotNull() {
            addCriterion("device_use_status is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceUseStatusEqualTo(Integer value) {
            addCriterion("device_use_status =", value, "deviceUseStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceUseStatusNotEqualTo(Integer value) {
            addCriterion("device_use_status <>", value, "deviceUseStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceUseStatusGreaterThan(Integer value) {
            addCriterion("device_use_status >", value, "deviceUseStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceUseStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_use_status >=", value, "deviceUseStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceUseStatusLessThan(Integer value) {
            addCriterion("device_use_status <", value, "deviceUseStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceUseStatusLessThanOrEqualTo(Integer value) {
            addCriterion("device_use_status <=", value, "deviceUseStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceUseStatusIn(List<Integer> values) {
            addCriterion("device_use_status in", values, "deviceUseStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceUseStatusNotIn(List<Integer> values) {
            addCriterion("device_use_status not in", values, "deviceUseStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceUseStatusBetween(Integer value1, Integer value2) {
            addCriterion("device_use_status between", value1, value2, "deviceUseStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceUseStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("device_use_status not between", value1, value2, "deviceUseStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceDatatemplateIdIsNull() {
            addCriterion("device_datatemplate_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceDatatemplateIdIsNotNull() {
            addCriterion("device_datatemplate_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceDatatemplateIdEqualTo(Integer value) {
            addCriterion("device_datatemplate_id =", value, "deviceDatatemplateId");
            return (Criteria) this;
        }

        public Criteria andDeviceDatatemplateIdNotEqualTo(Integer value) {
            addCriterion("device_datatemplate_id <>", value, "deviceDatatemplateId");
            return (Criteria) this;
        }

        public Criteria andDeviceDatatemplateIdGreaterThan(Integer value) {
            addCriterion("device_datatemplate_id >", value, "deviceDatatemplateId");
            return (Criteria) this;
        }

        public Criteria andDeviceDatatemplateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_datatemplate_id >=", value, "deviceDatatemplateId");
            return (Criteria) this;
        }

        public Criteria andDeviceDatatemplateIdLessThan(Integer value) {
            addCriterion("device_datatemplate_id <", value, "deviceDatatemplateId");
            return (Criteria) this;
        }

        public Criteria andDeviceDatatemplateIdLessThanOrEqualTo(Integer value) {
            addCriterion("device_datatemplate_id <=", value, "deviceDatatemplateId");
            return (Criteria) this;
        }

        public Criteria andDeviceDatatemplateIdIn(List<Integer> values) {
            addCriterion("device_datatemplate_id in", values, "deviceDatatemplateId");
            return (Criteria) this;
        }

        public Criteria andDeviceDatatemplateIdNotIn(List<Integer> values) {
            addCriterion("device_datatemplate_id not in", values, "deviceDatatemplateId");
            return (Criteria) this;
        }

        public Criteria andDeviceDatatemplateIdBetween(Integer value1, Integer value2) {
            addCriterion("device_datatemplate_id between", value1, value2, "deviceDatatemplateId");
            return (Criteria) this;
        }

        public Criteria andDeviceDatatemplateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("device_datatemplate_id not between", value1, value2, "deviceDatatemplateId");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend1IsNull() {
            addCriterion("device_extend1 is null");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend1IsNotNull() {
            addCriterion("device_extend1 is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend1EqualTo(String value) {
            addCriterion("device_extend1 =", value, "deviceExtend1");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend1NotEqualTo(String value) {
            addCriterion("device_extend1 <>", value, "deviceExtend1");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend1GreaterThan(String value) {
            addCriterion("device_extend1 >", value, "deviceExtend1");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend1GreaterThanOrEqualTo(String value) {
            addCriterion("device_extend1 >=", value, "deviceExtend1");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend1LessThan(String value) {
            addCriterion("device_extend1 <", value, "deviceExtend1");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend1LessThanOrEqualTo(String value) {
            addCriterion("device_extend1 <=", value, "deviceExtend1");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend1Like(String value) {
            addCriterion("device_extend1 like", value, "deviceExtend1");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend1NotLike(String value) {
            addCriterion("device_extend1 not like", value, "deviceExtend1");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend1In(List<String> values) {
            addCriterion("device_extend1 in", values, "deviceExtend1");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend1NotIn(List<String> values) {
            addCriterion("device_extend1 not in", values, "deviceExtend1");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend1Between(String value1, String value2) {
            addCriterion("device_extend1 between", value1, value2, "deviceExtend1");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend1NotBetween(String value1, String value2) {
            addCriterion("device_extend1 not between", value1, value2, "deviceExtend1");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend2IsNull() {
            addCriterion("device_extend2 is null");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend2IsNotNull() {
            addCriterion("device_extend2 is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend2EqualTo(String value) {
            addCriterion("device_extend2 =", value, "deviceExtend2");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend2NotEqualTo(String value) {
            addCriterion("device_extend2 <>", value, "deviceExtend2");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend2GreaterThan(String value) {
            addCriterion("device_extend2 >", value, "deviceExtend2");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend2GreaterThanOrEqualTo(String value) {
            addCriterion("device_extend2 >=", value, "deviceExtend2");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend2LessThan(String value) {
            addCriterion("device_extend2 <", value, "deviceExtend2");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend2LessThanOrEqualTo(String value) {
            addCriterion("device_extend2 <=", value, "deviceExtend2");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend2Like(String value) {
            addCriterion("device_extend2 like", value, "deviceExtend2");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend2NotLike(String value) {
            addCriterion("device_extend2 not like", value, "deviceExtend2");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend2In(List<String> values) {
            addCriterion("device_extend2 in", values, "deviceExtend2");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend2NotIn(List<String> values) {
            addCriterion("device_extend2 not in", values, "deviceExtend2");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend2Between(String value1, String value2) {
            addCriterion("device_extend2 between", value1, value2, "deviceExtend2");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend2NotBetween(String value1, String value2) {
            addCriterion("device_extend2 not between", value1, value2, "deviceExtend2");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend3IsNull() {
            addCriterion("device_extend3 is null");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend3IsNotNull() {
            addCriterion("device_extend3 is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend3EqualTo(String value) {
            addCriterion("device_extend3 =", value, "deviceExtend3");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend3NotEqualTo(String value) {
            addCriterion("device_extend3 <>", value, "deviceExtend3");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend3GreaterThan(String value) {
            addCriterion("device_extend3 >", value, "deviceExtend3");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend3GreaterThanOrEqualTo(String value) {
            addCriterion("device_extend3 >=", value, "deviceExtend3");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend3LessThan(String value) {
            addCriterion("device_extend3 <", value, "deviceExtend3");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend3LessThanOrEqualTo(String value) {
            addCriterion("device_extend3 <=", value, "deviceExtend3");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend3Like(String value) {
            addCriterion("device_extend3 like", value, "deviceExtend3");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend3NotLike(String value) {
            addCriterion("device_extend3 not like", value, "deviceExtend3");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend3In(List<String> values) {
            addCriterion("device_extend3 in", values, "deviceExtend3");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend3NotIn(List<String> values) {
            addCriterion("device_extend3 not in", values, "deviceExtend3");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend3Between(String value1, String value2) {
            addCriterion("device_extend3 between", value1, value2, "deviceExtend3");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend3NotBetween(String value1, String value2) {
            addCriterion("device_extend3 not between", value1, value2, "deviceExtend3");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend4IsNull() {
            addCriterion("device_extend4 is null");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend4IsNotNull() {
            addCriterion("device_extend4 is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend4EqualTo(String value) {
            addCriterion("device_extend4 =", value, "deviceExtend4");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend4NotEqualTo(String value) {
            addCriterion("device_extend4 <>", value, "deviceExtend4");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend4GreaterThan(String value) {
            addCriterion("device_extend4 >", value, "deviceExtend4");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend4GreaterThanOrEqualTo(String value) {
            addCriterion("device_extend4 >=", value, "deviceExtend4");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend4LessThan(String value) {
            addCriterion("device_extend4 <", value, "deviceExtend4");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend4LessThanOrEqualTo(String value) {
            addCriterion("device_extend4 <=", value, "deviceExtend4");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend4Like(String value) {
            addCriterion("device_extend4 like", value, "deviceExtend4");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend4NotLike(String value) {
            addCriterion("device_extend4 not like", value, "deviceExtend4");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend4In(List<String> values) {
            addCriterion("device_extend4 in", values, "deviceExtend4");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend4NotIn(List<String> values) {
            addCriterion("device_extend4 not in", values, "deviceExtend4");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend4Between(String value1, String value2) {
            addCriterion("device_extend4 between", value1, value2, "deviceExtend4");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend4NotBetween(String value1, String value2) {
            addCriterion("device_extend4 not between", value1, value2, "deviceExtend4");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend5IsNull() {
            addCriterion("device_extend5 is null");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend5IsNotNull() {
            addCriterion("device_extend5 is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend5EqualTo(String value) {
            addCriterion("device_extend5 =", value, "deviceExtend5");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend5NotEqualTo(String value) {
            addCriterion("device_extend5 <>", value, "deviceExtend5");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend5GreaterThan(String value) {
            addCriterion("device_extend5 >", value, "deviceExtend5");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend5GreaterThanOrEqualTo(String value) {
            addCriterion("device_extend5 >=", value, "deviceExtend5");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend5LessThan(String value) {
            addCriterion("device_extend5 <", value, "deviceExtend5");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend5LessThanOrEqualTo(String value) {
            addCriterion("device_extend5 <=", value, "deviceExtend5");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend5Like(String value) {
            addCriterion("device_extend5 like", value, "deviceExtend5");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend5NotLike(String value) {
            addCriterion("device_extend5 not like", value, "deviceExtend5");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend5In(List<String> values) {
            addCriterion("device_extend5 in", values, "deviceExtend5");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend5NotIn(List<String> values) {
            addCriterion("device_extend5 not in", values, "deviceExtend5");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend5Between(String value1, String value2) {
            addCriterion("device_extend5 between", value1, value2, "deviceExtend5");
            return (Criteria) this;
        }

        public Criteria andDeviceExtend5NotBetween(String value1, String value2) {
            addCriterion("device_extend5 not between", value1, value2, "deviceExtend5");
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