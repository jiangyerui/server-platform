package com.jyr.iot.platform.pojo;

import java.util.ArrayList;
import java.util.List;

public class CameraExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CameraExample() {
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

        public Criteria andCameraIdIsNull() {
            addCriterion("camera_id is null");
            return (Criteria) this;
        }

        public Criteria andCameraIdIsNotNull() {
            addCriterion("camera_id is not null");
            return (Criteria) this;
        }

        public Criteria andCameraIdEqualTo(Integer value) {
            addCriterion("camera_id =", value, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdNotEqualTo(Integer value) {
            addCriterion("camera_id <>", value, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdGreaterThan(Integer value) {
            addCriterion("camera_id >", value, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("camera_id >=", value, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdLessThan(Integer value) {
            addCriterion("camera_id <", value, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdLessThanOrEqualTo(Integer value) {
            addCriterion("camera_id <=", value, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdIn(List<Integer> values) {
            addCriterion("camera_id in", values, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdNotIn(List<Integer> values) {
            addCriterion("camera_id not in", values, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdBetween(Integer value1, Integer value2) {
            addCriterion("camera_id between", value1, value2, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdNotBetween(Integer value1, Integer value2) {
            addCriterion("camera_id not between", value1, value2, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraCodeIsNull() {
            addCriterion("camera_code is null");
            return (Criteria) this;
        }

        public Criteria andCameraCodeIsNotNull() {
            addCriterion("camera_code is not null");
            return (Criteria) this;
        }

        public Criteria andCameraCodeEqualTo(String value) {
            addCriterion("camera_code =", value, "cameraCode");
            return (Criteria) this;
        }

        public Criteria andCameraCodeNotEqualTo(String value) {
            addCriterion("camera_code <>", value, "cameraCode");
            return (Criteria) this;
        }

        public Criteria andCameraCodeGreaterThan(String value) {
            addCriterion("camera_code >", value, "cameraCode");
            return (Criteria) this;
        }

        public Criteria andCameraCodeGreaterThanOrEqualTo(String value) {
            addCriterion("camera_code >=", value, "cameraCode");
            return (Criteria) this;
        }

        public Criteria andCameraCodeLessThan(String value) {
            addCriterion("camera_code <", value, "cameraCode");
            return (Criteria) this;
        }

        public Criteria andCameraCodeLessThanOrEqualTo(String value) {
            addCriterion("camera_code <=", value, "cameraCode");
            return (Criteria) this;
        }

        public Criteria andCameraCodeLike(String value) {
            addCriterion("camera_code like", value, "cameraCode");
            return (Criteria) this;
        }

        public Criteria andCameraCodeNotLike(String value) {
            addCriterion("camera_code not like", value, "cameraCode");
            return (Criteria) this;
        }

        public Criteria andCameraCodeIn(List<String> values) {
            addCriterion("camera_code in", values, "cameraCode");
            return (Criteria) this;
        }

        public Criteria andCameraCodeNotIn(List<String> values) {
            addCriterion("camera_code not in", values, "cameraCode");
            return (Criteria) this;
        }

        public Criteria andCameraCodeBetween(String value1, String value2) {
            addCriterion("camera_code between", value1, value2, "cameraCode");
            return (Criteria) this;
        }

        public Criteria andCameraCodeNotBetween(String value1, String value2) {
            addCriterion("camera_code not between", value1, value2, "cameraCode");
            return (Criteria) this;
        }

        public Criteria andCameraNameIsNull() {
            addCriterion("camera_name is null");
            return (Criteria) this;
        }

        public Criteria andCameraNameIsNotNull() {
            addCriterion("camera_name is not null");
            return (Criteria) this;
        }

        public Criteria andCameraNameEqualTo(String value) {
            addCriterion("camera_name =", value, "cameraName");
            return (Criteria) this;
        }

        public Criteria andCameraNameNotEqualTo(String value) {
            addCriterion("camera_name <>", value, "cameraName");
            return (Criteria) this;
        }

        public Criteria andCameraNameGreaterThan(String value) {
            addCriterion("camera_name >", value, "cameraName");
            return (Criteria) this;
        }

        public Criteria andCameraNameGreaterThanOrEqualTo(String value) {
            addCriterion("camera_name >=", value, "cameraName");
            return (Criteria) this;
        }

        public Criteria andCameraNameLessThan(String value) {
            addCriterion("camera_name <", value, "cameraName");
            return (Criteria) this;
        }

        public Criteria andCameraNameLessThanOrEqualTo(String value) {
            addCriterion("camera_name <=", value, "cameraName");
            return (Criteria) this;
        }

        public Criteria andCameraNameLike(String value) {
            addCriterion("camera_name like", value, "cameraName");
            return (Criteria) this;
        }

        public Criteria andCameraNameNotLike(String value) {
            addCriterion("camera_name not like", value, "cameraName");
            return (Criteria) this;
        }

        public Criteria andCameraNameIn(List<String> values) {
            addCriterion("camera_name in", values, "cameraName");
            return (Criteria) this;
        }

        public Criteria andCameraNameNotIn(List<String> values) {
            addCriterion("camera_name not in", values, "cameraName");
            return (Criteria) this;
        }

        public Criteria andCameraNameBetween(String value1, String value2) {
            addCriterion("camera_name between", value1, value2, "cameraName");
            return (Criteria) this;
        }

        public Criteria andCameraNameNotBetween(String value1, String value2) {
            addCriterion("camera_name not between", value1, value2, "cameraName");
            return (Criteria) this;
        }

        public Criteria andCameraProjectIdIsNull() {
            addCriterion("camera_project_id is null");
            return (Criteria) this;
        }

        public Criteria andCameraProjectIdIsNotNull() {
            addCriterion("camera_project_id is not null");
            return (Criteria) this;
        }

        public Criteria andCameraProjectIdEqualTo(Integer value) {
            addCriterion("camera_project_id =", value, "cameraProjectId");
            return (Criteria) this;
        }

        public Criteria andCameraProjectIdNotEqualTo(Integer value) {
            addCriterion("camera_project_id <>", value, "cameraProjectId");
            return (Criteria) this;
        }

        public Criteria andCameraProjectIdGreaterThan(Integer value) {
            addCriterion("camera_project_id >", value, "cameraProjectId");
            return (Criteria) this;
        }

        public Criteria andCameraProjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("camera_project_id >=", value, "cameraProjectId");
            return (Criteria) this;
        }

        public Criteria andCameraProjectIdLessThan(Integer value) {
            addCriterion("camera_project_id <", value, "cameraProjectId");
            return (Criteria) this;
        }

        public Criteria andCameraProjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("camera_project_id <=", value, "cameraProjectId");
            return (Criteria) this;
        }

        public Criteria andCameraProjectIdIn(List<Integer> values) {
            addCriterion("camera_project_id in", values, "cameraProjectId");
            return (Criteria) this;
        }

        public Criteria andCameraProjectIdNotIn(List<Integer> values) {
            addCriterion("camera_project_id not in", values, "cameraProjectId");
            return (Criteria) this;
        }

        public Criteria andCameraProjectIdBetween(Integer value1, Integer value2) {
            addCriterion("camera_project_id between", value1, value2, "cameraProjectId");
            return (Criteria) this;
        }

        public Criteria andCameraProjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("camera_project_id not between", value1, value2, "cameraProjectId");
            return (Criteria) this;
        }

        public Criteria andCameraUrlIsNull() {
            addCriterion("camera_url is null");
            return (Criteria) this;
        }

        public Criteria andCameraUrlIsNotNull() {
            addCriterion("camera_url is not null");
            return (Criteria) this;
        }

        public Criteria andCameraUrlEqualTo(String value) {
            addCriterion("camera_url =", value, "cameraUrl");
            return (Criteria) this;
        }

        public Criteria andCameraUrlNotEqualTo(String value) {
            addCriterion("camera_url <>", value, "cameraUrl");
            return (Criteria) this;
        }

        public Criteria andCameraUrlGreaterThan(String value) {
            addCriterion("camera_url >", value, "cameraUrl");
            return (Criteria) this;
        }

        public Criteria andCameraUrlGreaterThanOrEqualTo(String value) {
            addCriterion("camera_url >=", value, "cameraUrl");
            return (Criteria) this;
        }

        public Criteria andCameraUrlLessThan(String value) {
            addCriterion("camera_url <", value, "cameraUrl");
            return (Criteria) this;
        }

        public Criteria andCameraUrlLessThanOrEqualTo(String value) {
            addCriterion("camera_url <=", value, "cameraUrl");
            return (Criteria) this;
        }

        public Criteria andCameraUrlLike(String value) {
            addCriterion("camera_url like", value, "cameraUrl");
            return (Criteria) this;
        }

        public Criteria andCameraUrlNotLike(String value) {
            addCriterion("camera_url not like", value, "cameraUrl");
            return (Criteria) this;
        }

        public Criteria andCameraUrlIn(List<String> values) {
            addCriterion("camera_url in", values, "cameraUrl");
            return (Criteria) this;
        }

        public Criteria andCameraUrlNotIn(List<String> values) {
            addCriterion("camera_url not in", values, "cameraUrl");
            return (Criteria) this;
        }

        public Criteria andCameraUrlBetween(String value1, String value2) {
            addCriterion("camera_url between", value1, value2, "cameraUrl");
            return (Criteria) this;
        }

        public Criteria andCameraUrlNotBetween(String value1, String value2) {
            addCriterion("camera_url not between", value1, value2, "cameraUrl");
            return (Criteria) this;
        }

        public Criteria andCameraEurlIsNull() {
            addCriterion("camera_eurl is null");
            return (Criteria) this;
        }

        public Criteria andCameraEurlIsNotNull() {
            addCriterion("camera_eurl is not null");
            return (Criteria) this;
        }

        public Criteria andCameraEurlEqualTo(String value) {
            addCriterion("camera_eurl =", value, "cameraEurl");
            return (Criteria) this;
        }

        public Criteria andCameraEurlNotEqualTo(String value) {
            addCriterion("camera_eurl <>", value, "cameraEurl");
            return (Criteria) this;
        }

        public Criteria andCameraEurlGreaterThan(String value) {
            addCriterion("camera_eurl >", value, "cameraEurl");
            return (Criteria) this;
        }

        public Criteria andCameraEurlGreaterThanOrEqualTo(String value) {
            addCriterion("camera_eurl >=", value, "cameraEurl");
            return (Criteria) this;
        }

        public Criteria andCameraEurlLessThan(String value) {
            addCriterion("camera_eurl <", value, "cameraEurl");
            return (Criteria) this;
        }

        public Criteria andCameraEurlLessThanOrEqualTo(String value) {
            addCriterion("camera_eurl <=", value, "cameraEurl");
            return (Criteria) this;
        }

        public Criteria andCameraEurlLike(String value) {
            addCriterion("camera_eurl like", value, "cameraEurl");
            return (Criteria) this;
        }

        public Criteria andCameraEurlNotLike(String value) {
            addCriterion("camera_eurl not like", value, "cameraEurl");
            return (Criteria) this;
        }

        public Criteria andCameraEurlIn(List<String> values) {
            addCriterion("camera_eurl in", values, "cameraEurl");
            return (Criteria) this;
        }

        public Criteria andCameraEurlNotIn(List<String> values) {
            addCriterion("camera_eurl not in", values, "cameraEurl");
            return (Criteria) this;
        }

        public Criteria andCameraEurlBetween(String value1, String value2) {
            addCriterion("camera_eurl between", value1, value2, "cameraEurl");
            return (Criteria) this;
        }

        public Criteria andCameraEurlNotBetween(String value1, String value2) {
            addCriterion("camera_eurl not between", value1, value2, "cameraEurl");
            return (Criteria) this;
        }

        public Criteria andCameraApiKeyIsNull() {
            addCriterion("camera_api_key is null");
            return (Criteria) this;
        }

        public Criteria andCameraApiKeyIsNotNull() {
            addCriterion("camera_api_key is not null");
            return (Criteria) this;
        }

        public Criteria andCameraApiKeyEqualTo(String value) {
            addCriterion("camera_api_key =", value, "cameraApiKey");
            return (Criteria) this;
        }

        public Criteria andCameraApiKeyNotEqualTo(String value) {
            addCriterion("camera_api_key <>", value, "cameraApiKey");
            return (Criteria) this;
        }

        public Criteria andCameraApiKeyGreaterThan(String value) {
            addCriterion("camera_api_key >", value, "cameraApiKey");
            return (Criteria) this;
        }

        public Criteria andCameraApiKeyGreaterThanOrEqualTo(String value) {
            addCriterion("camera_api_key >=", value, "cameraApiKey");
            return (Criteria) this;
        }

        public Criteria andCameraApiKeyLessThan(String value) {
            addCriterion("camera_api_key <", value, "cameraApiKey");
            return (Criteria) this;
        }

        public Criteria andCameraApiKeyLessThanOrEqualTo(String value) {
            addCriterion("camera_api_key <=", value, "cameraApiKey");
            return (Criteria) this;
        }

        public Criteria andCameraApiKeyLike(String value) {
            addCriterion("camera_api_key like", value, "cameraApiKey");
            return (Criteria) this;
        }

        public Criteria andCameraApiKeyNotLike(String value) {
            addCriterion("camera_api_key not like", value, "cameraApiKey");
            return (Criteria) this;
        }

        public Criteria andCameraApiKeyIn(List<String> values) {
            addCriterion("camera_api_key in", values, "cameraApiKey");
            return (Criteria) this;
        }

        public Criteria andCameraApiKeyNotIn(List<String> values) {
            addCriterion("camera_api_key not in", values, "cameraApiKey");
            return (Criteria) this;
        }

        public Criteria andCameraApiKeyBetween(String value1, String value2) {
            addCriterion("camera_api_key between", value1, value2, "cameraApiKey");
            return (Criteria) this;
        }

        public Criteria andCameraApiKeyNotBetween(String value1, String value2) {
            addCriterion("camera_api_key not between", value1, value2, "cameraApiKey");
            return (Criteria) this;
        }

        public Criteria andCameraSecretIsNull() {
            addCriterion("camera_secret is null");
            return (Criteria) this;
        }

        public Criteria andCameraSecretIsNotNull() {
            addCriterion("camera_secret is not null");
            return (Criteria) this;
        }

        public Criteria andCameraSecretEqualTo(String value) {
            addCriterion("camera_secret =", value, "cameraSecret");
            return (Criteria) this;
        }

        public Criteria andCameraSecretNotEqualTo(String value) {
            addCriterion("camera_secret <>", value, "cameraSecret");
            return (Criteria) this;
        }

        public Criteria andCameraSecretGreaterThan(String value) {
            addCriterion("camera_secret >", value, "cameraSecret");
            return (Criteria) this;
        }

        public Criteria andCameraSecretGreaterThanOrEqualTo(String value) {
            addCriterion("camera_secret >=", value, "cameraSecret");
            return (Criteria) this;
        }

        public Criteria andCameraSecretLessThan(String value) {
            addCriterion("camera_secret <", value, "cameraSecret");
            return (Criteria) this;
        }

        public Criteria andCameraSecretLessThanOrEqualTo(String value) {
            addCriterion("camera_secret <=", value, "cameraSecret");
            return (Criteria) this;
        }

        public Criteria andCameraSecretLike(String value) {
            addCriterion("camera_secret like", value, "cameraSecret");
            return (Criteria) this;
        }

        public Criteria andCameraSecretNotLike(String value) {
            addCriterion("camera_secret not like", value, "cameraSecret");
            return (Criteria) this;
        }

        public Criteria andCameraSecretIn(List<String> values) {
            addCriterion("camera_secret in", values, "cameraSecret");
            return (Criteria) this;
        }

        public Criteria andCameraSecretNotIn(List<String> values) {
            addCriterion("camera_secret not in", values, "cameraSecret");
            return (Criteria) this;
        }

        public Criteria andCameraSecretBetween(String value1, String value2) {
            addCriterion("camera_secret between", value1, value2, "cameraSecret");
            return (Criteria) this;
        }

        public Criteria andCameraSecretNotBetween(String value1, String value2) {
            addCriterion("camera_secret not between", value1, value2, "cameraSecret");
            return (Criteria) this;
        }

        public Criteria andCameraSerialNumberIsNull() {
            addCriterion("camera_serial_number is null");
            return (Criteria) this;
        }

        public Criteria andCameraSerialNumberIsNotNull() {
            addCriterion("camera_serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andCameraSerialNumberEqualTo(String value) {
            addCriterion("camera_serial_number =", value, "cameraSerialNumber");
            return (Criteria) this;
        }

        public Criteria andCameraSerialNumberNotEqualTo(String value) {
            addCriterion("camera_serial_number <>", value, "cameraSerialNumber");
            return (Criteria) this;
        }

        public Criteria andCameraSerialNumberGreaterThan(String value) {
            addCriterion("camera_serial_number >", value, "cameraSerialNumber");
            return (Criteria) this;
        }

        public Criteria andCameraSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("camera_serial_number >=", value, "cameraSerialNumber");
            return (Criteria) this;
        }

        public Criteria andCameraSerialNumberLessThan(String value) {
            addCriterion("camera_serial_number <", value, "cameraSerialNumber");
            return (Criteria) this;
        }

        public Criteria andCameraSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("camera_serial_number <=", value, "cameraSerialNumber");
            return (Criteria) this;
        }

        public Criteria andCameraSerialNumberLike(String value) {
            addCriterion("camera_serial_number like", value, "cameraSerialNumber");
            return (Criteria) this;
        }

        public Criteria andCameraSerialNumberNotLike(String value) {
            addCriterion("camera_serial_number not like", value, "cameraSerialNumber");
            return (Criteria) this;
        }

        public Criteria andCameraSerialNumberIn(List<String> values) {
            addCriterion("camera_serial_number in", values, "cameraSerialNumber");
            return (Criteria) this;
        }

        public Criteria andCameraSerialNumberNotIn(List<String> values) {
            addCriterion("camera_serial_number not in", values, "cameraSerialNumber");
            return (Criteria) this;
        }

        public Criteria andCameraSerialNumberBetween(String value1, String value2) {
            addCriterion("camera_serial_number between", value1, value2, "cameraSerialNumber");
            return (Criteria) this;
        }

        public Criteria andCameraSerialNumberNotBetween(String value1, String value2) {
            addCriterion("camera_serial_number not between", value1, value2, "cameraSerialNumber");
            return (Criteria) this;
        }

        public Criteria andCameraRemarkIsNull() {
            addCriterion("camera_remark is null");
            return (Criteria) this;
        }

        public Criteria andCameraRemarkIsNotNull() {
            addCriterion("camera_remark is not null");
            return (Criteria) this;
        }

        public Criteria andCameraRemarkEqualTo(String value) {
            addCriterion("camera_remark =", value, "cameraRemark");
            return (Criteria) this;
        }

        public Criteria andCameraRemarkNotEqualTo(String value) {
            addCriterion("camera_remark <>", value, "cameraRemark");
            return (Criteria) this;
        }

        public Criteria andCameraRemarkGreaterThan(String value) {
            addCriterion("camera_remark >", value, "cameraRemark");
            return (Criteria) this;
        }

        public Criteria andCameraRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("camera_remark >=", value, "cameraRemark");
            return (Criteria) this;
        }

        public Criteria andCameraRemarkLessThan(String value) {
            addCriterion("camera_remark <", value, "cameraRemark");
            return (Criteria) this;
        }

        public Criteria andCameraRemarkLessThanOrEqualTo(String value) {
            addCriterion("camera_remark <=", value, "cameraRemark");
            return (Criteria) this;
        }

        public Criteria andCameraRemarkLike(String value) {
            addCriterion("camera_remark like", value, "cameraRemark");
            return (Criteria) this;
        }

        public Criteria andCameraRemarkNotLike(String value) {
            addCriterion("camera_remark not like", value, "cameraRemark");
            return (Criteria) this;
        }

        public Criteria andCameraRemarkIn(List<String> values) {
            addCriterion("camera_remark in", values, "cameraRemark");
            return (Criteria) this;
        }

        public Criteria andCameraRemarkNotIn(List<String> values) {
            addCriterion("camera_remark not in", values, "cameraRemark");
            return (Criteria) this;
        }

        public Criteria andCameraRemarkBetween(String value1, String value2) {
            addCriterion("camera_remark between", value1, value2, "cameraRemark");
            return (Criteria) this;
        }

        public Criteria andCameraRemarkNotBetween(String value1, String value2) {
            addCriterion("camera_remark not between", value1, value2, "cameraRemark");
            return (Criteria) this;
        }

        public Criteria andCameraStatusIsNull() {
            addCriterion("camera_status is null");
            return (Criteria) this;
        }

        public Criteria andCameraStatusIsNotNull() {
            addCriterion("camera_status is not null");
            return (Criteria) this;
        }

        public Criteria andCameraStatusEqualTo(Integer value) {
            addCriterion("camera_status =", value, "cameraStatus");
            return (Criteria) this;
        }

        public Criteria andCameraStatusNotEqualTo(Integer value) {
            addCriterion("camera_status <>", value, "cameraStatus");
            return (Criteria) this;
        }

        public Criteria andCameraStatusGreaterThan(Integer value) {
            addCriterion("camera_status >", value, "cameraStatus");
            return (Criteria) this;
        }

        public Criteria andCameraStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("camera_status >=", value, "cameraStatus");
            return (Criteria) this;
        }

        public Criteria andCameraStatusLessThan(Integer value) {
            addCriterion("camera_status <", value, "cameraStatus");
            return (Criteria) this;
        }

        public Criteria andCameraStatusLessThanOrEqualTo(Integer value) {
            addCriterion("camera_status <=", value, "cameraStatus");
            return (Criteria) this;
        }

        public Criteria andCameraStatusIn(List<Integer> values) {
            addCriterion("camera_status in", values, "cameraStatus");
            return (Criteria) this;
        }

        public Criteria andCameraStatusNotIn(List<Integer> values) {
            addCriterion("camera_status not in", values, "cameraStatus");
            return (Criteria) this;
        }

        public Criteria andCameraStatusBetween(Integer value1, Integer value2) {
            addCriterion("camera_status between", value1, value2, "cameraStatus");
            return (Criteria) this;
        }

        public Criteria andCameraStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("camera_status not between", value1, value2, "cameraStatus");
            return (Criteria) this;
        }

        public Criteria andCameraExtend1IsNull() {
            addCriterion("camera_extend1 is null");
            return (Criteria) this;
        }

        public Criteria andCameraExtend1IsNotNull() {
            addCriterion("camera_extend1 is not null");
            return (Criteria) this;
        }

        public Criteria andCameraExtend1EqualTo(String value) {
            addCriterion("camera_extend1 =", value, "cameraExtend1");
            return (Criteria) this;
        }

        public Criteria andCameraExtend1NotEqualTo(String value) {
            addCriterion("camera_extend1 <>", value, "cameraExtend1");
            return (Criteria) this;
        }

        public Criteria andCameraExtend1GreaterThan(String value) {
            addCriterion("camera_extend1 >", value, "cameraExtend1");
            return (Criteria) this;
        }

        public Criteria andCameraExtend1GreaterThanOrEqualTo(String value) {
            addCriterion("camera_extend1 >=", value, "cameraExtend1");
            return (Criteria) this;
        }

        public Criteria andCameraExtend1LessThan(String value) {
            addCriterion("camera_extend1 <", value, "cameraExtend1");
            return (Criteria) this;
        }

        public Criteria andCameraExtend1LessThanOrEqualTo(String value) {
            addCriterion("camera_extend1 <=", value, "cameraExtend1");
            return (Criteria) this;
        }

        public Criteria andCameraExtend1Like(String value) {
            addCriterion("camera_extend1 like", value, "cameraExtend1");
            return (Criteria) this;
        }

        public Criteria andCameraExtend1NotLike(String value) {
            addCriterion("camera_extend1 not like", value, "cameraExtend1");
            return (Criteria) this;
        }

        public Criteria andCameraExtend1In(List<String> values) {
            addCriterion("camera_extend1 in", values, "cameraExtend1");
            return (Criteria) this;
        }

        public Criteria andCameraExtend1NotIn(List<String> values) {
            addCriterion("camera_extend1 not in", values, "cameraExtend1");
            return (Criteria) this;
        }

        public Criteria andCameraExtend1Between(String value1, String value2) {
            addCriterion("camera_extend1 between", value1, value2, "cameraExtend1");
            return (Criteria) this;
        }

        public Criteria andCameraExtend1NotBetween(String value1, String value2) {
            addCriterion("camera_extend1 not between", value1, value2, "cameraExtend1");
            return (Criteria) this;
        }

        public Criteria andCameraExtend2IsNull() {
            addCriterion("camera_extend2 is null");
            return (Criteria) this;
        }

        public Criteria andCameraExtend2IsNotNull() {
            addCriterion("camera_extend2 is not null");
            return (Criteria) this;
        }

        public Criteria andCameraExtend2EqualTo(String value) {
            addCriterion("camera_extend2 =", value, "cameraExtend2");
            return (Criteria) this;
        }

        public Criteria andCameraExtend2NotEqualTo(String value) {
            addCriterion("camera_extend2 <>", value, "cameraExtend2");
            return (Criteria) this;
        }

        public Criteria andCameraExtend2GreaterThan(String value) {
            addCriterion("camera_extend2 >", value, "cameraExtend2");
            return (Criteria) this;
        }

        public Criteria andCameraExtend2GreaterThanOrEqualTo(String value) {
            addCriterion("camera_extend2 >=", value, "cameraExtend2");
            return (Criteria) this;
        }

        public Criteria andCameraExtend2LessThan(String value) {
            addCriterion("camera_extend2 <", value, "cameraExtend2");
            return (Criteria) this;
        }

        public Criteria andCameraExtend2LessThanOrEqualTo(String value) {
            addCriterion("camera_extend2 <=", value, "cameraExtend2");
            return (Criteria) this;
        }

        public Criteria andCameraExtend2Like(String value) {
            addCriterion("camera_extend2 like", value, "cameraExtend2");
            return (Criteria) this;
        }

        public Criteria andCameraExtend2NotLike(String value) {
            addCriterion("camera_extend2 not like", value, "cameraExtend2");
            return (Criteria) this;
        }

        public Criteria andCameraExtend2In(List<String> values) {
            addCriterion("camera_extend2 in", values, "cameraExtend2");
            return (Criteria) this;
        }

        public Criteria andCameraExtend2NotIn(List<String> values) {
            addCriterion("camera_extend2 not in", values, "cameraExtend2");
            return (Criteria) this;
        }

        public Criteria andCameraExtend2Between(String value1, String value2) {
            addCriterion("camera_extend2 between", value1, value2, "cameraExtend2");
            return (Criteria) this;
        }

        public Criteria andCameraExtend2NotBetween(String value1, String value2) {
            addCriterion("camera_extend2 not between", value1, value2, "cameraExtend2");
            return (Criteria) this;
        }

        public Criteria andCameraExtend3IsNull() {
            addCriterion("camera_extend3 is null");
            return (Criteria) this;
        }

        public Criteria andCameraExtend3IsNotNull() {
            addCriterion("camera_extend3 is not null");
            return (Criteria) this;
        }

        public Criteria andCameraExtend3EqualTo(String value) {
            addCriterion("camera_extend3 =", value, "cameraExtend3");
            return (Criteria) this;
        }

        public Criteria andCameraExtend3NotEqualTo(String value) {
            addCriterion("camera_extend3 <>", value, "cameraExtend3");
            return (Criteria) this;
        }

        public Criteria andCameraExtend3GreaterThan(String value) {
            addCriterion("camera_extend3 >", value, "cameraExtend3");
            return (Criteria) this;
        }

        public Criteria andCameraExtend3GreaterThanOrEqualTo(String value) {
            addCriterion("camera_extend3 >=", value, "cameraExtend3");
            return (Criteria) this;
        }

        public Criteria andCameraExtend3LessThan(String value) {
            addCriterion("camera_extend3 <", value, "cameraExtend3");
            return (Criteria) this;
        }

        public Criteria andCameraExtend3LessThanOrEqualTo(String value) {
            addCriterion("camera_extend3 <=", value, "cameraExtend3");
            return (Criteria) this;
        }

        public Criteria andCameraExtend3Like(String value) {
            addCriterion("camera_extend3 like", value, "cameraExtend3");
            return (Criteria) this;
        }

        public Criteria andCameraExtend3NotLike(String value) {
            addCriterion("camera_extend3 not like", value, "cameraExtend3");
            return (Criteria) this;
        }

        public Criteria andCameraExtend3In(List<String> values) {
            addCriterion("camera_extend3 in", values, "cameraExtend3");
            return (Criteria) this;
        }

        public Criteria andCameraExtend3NotIn(List<String> values) {
            addCriterion("camera_extend3 not in", values, "cameraExtend3");
            return (Criteria) this;
        }

        public Criteria andCameraExtend3Between(String value1, String value2) {
            addCriterion("camera_extend3 between", value1, value2, "cameraExtend3");
            return (Criteria) this;
        }

        public Criteria andCameraExtend3NotBetween(String value1, String value2) {
            addCriterion("camera_extend3 not between", value1, value2, "cameraExtend3");
            return (Criteria) this;
        }

        public Criteria andCameraExtend4IsNull() {
            addCriterion("camera_extend4 is null");
            return (Criteria) this;
        }

        public Criteria andCameraExtend4IsNotNull() {
            addCriterion("camera_extend4 is not null");
            return (Criteria) this;
        }

        public Criteria andCameraExtend4EqualTo(String value) {
            addCriterion("camera_extend4 =", value, "cameraExtend4");
            return (Criteria) this;
        }

        public Criteria andCameraExtend4NotEqualTo(String value) {
            addCriterion("camera_extend4 <>", value, "cameraExtend4");
            return (Criteria) this;
        }

        public Criteria andCameraExtend4GreaterThan(String value) {
            addCriterion("camera_extend4 >", value, "cameraExtend4");
            return (Criteria) this;
        }

        public Criteria andCameraExtend4GreaterThanOrEqualTo(String value) {
            addCriterion("camera_extend4 >=", value, "cameraExtend4");
            return (Criteria) this;
        }

        public Criteria andCameraExtend4LessThan(String value) {
            addCriterion("camera_extend4 <", value, "cameraExtend4");
            return (Criteria) this;
        }

        public Criteria andCameraExtend4LessThanOrEqualTo(String value) {
            addCriterion("camera_extend4 <=", value, "cameraExtend4");
            return (Criteria) this;
        }

        public Criteria andCameraExtend4Like(String value) {
            addCriterion("camera_extend4 like", value, "cameraExtend4");
            return (Criteria) this;
        }

        public Criteria andCameraExtend4NotLike(String value) {
            addCriterion("camera_extend4 not like", value, "cameraExtend4");
            return (Criteria) this;
        }

        public Criteria andCameraExtend4In(List<String> values) {
            addCriterion("camera_extend4 in", values, "cameraExtend4");
            return (Criteria) this;
        }

        public Criteria andCameraExtend4NotIn(List<String> values) {
            addCriterion("camera_extend4 not in", values, "cameraExtend4");
            return (Criteria) this;
        }

        public Criteria andCameraExtend4Between(String value1, String value2) {
            addCriterion("camera_extend4 between", value1, value2, "cameraExtend4");
            return (Criteria) this;
        }

        public Criteria andCameraExtend4NotBetween(String value1, String value2) {
            addCriterion("camera_extend4 not between", value1, value2, "cameraExtend4");
            return (Criteria) this;
        }

        public Criteria andCameraExtend5IsNull() {
            addCriterion("camera_extend5 is null");
            return (Criteria) this;
        }

        public Criteria andCameraExtend5IsNotNull() {
            addCriterion("camera_extend5 is not null");
            return (Criteria) this;
        }

        public Criteria andCameraExtend5EqualTo(String value) {
            addCriterion("camera_extend5 =", value, "cameraExtend5");
            return (Criteria) this;
        }

        public Criteria andCameraExtend5NotEqualTo(String value) {
            addCriterion("camera_extend5 <>", value, "cameraExtend5");
            return (Criteria) this;
        }

        public Criteria andCameraExtend5GreaterThan(String value) {
            addCriterion("camera_extend5 >", value, "cameraExtend5");
            return (Criteria) this;
        }

        public Criteria andCameraExtend5GreaterThanOrEqualTo(String value) {
            addCriterion("camera_extend5 >=", value, "cameraExtend5");
            return (Criteria) this;
        }

        public Criteria andCameraExtend5LessThan(String value) {
            addCriterion("camera_extend5 <", value, "cameraExtend5");
            return (Criteria) this;
        }

        public Criteria andCameraExtend5LessThanOrEqualTo(String value) {
            addCriterion("camera_extend5 <=", value, "cameraExtend5");
            return (Criteria) this;
        }

        public Criteria andCameraExtend5Like(String value) {
            addCriterion("camera_extend5 like", value, "cameraExtend5");
            return (Criteria) this;
        }

        public Criteria andCameraExtend5NotLike(String value) {
            addCriterion("camera_extend5 not like", value, "cameraExtend5");
            return (Criteria) this;
        }

        public Criteria andCameraExtend5In(List<String> values) {
            addCriterion("camera_extend5 in", values, "cameraExtend5");
            return (Criteria) this;
        }

        public Criteria andCameraExtend5NotIn(List<String> values) {
            addCriterion("camera_extend5 not in", values, "cameraExtend5");
            return (Criteria) this;
        }

        public Criteria andCameraExtend5Between(String value1, String value2) {
            addCriterion("camera_extend5 between", value1, value2, "cameraExtend5");
            return (Criteria) this;
        }

        public Criteria andCameraExtend5NotBetween(String value1, String value2) {
            addCriterion("camera_extend5 not between", value1, value2, "cameraExtend5");
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