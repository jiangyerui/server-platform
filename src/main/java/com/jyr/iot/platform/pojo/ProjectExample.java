package com.jyr.iot.platform.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectExample() {
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

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(Integer value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Integer value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Integer value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Integer value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Integer> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Integer> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Integer value1, Integer value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceIsNull() {
            addCriterion("project_introduce is null");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceIsNotNull() {
            addCriterion("project_introduce is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceEqualTo(String value) {
            addCriterion("project_introduce =", value, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceNotEqualTo(String value) {
            addCriterion("project_introduce <>", value, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceGreaterThan(String value) {
            addCriterion("project_introduce >", value, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("project_introduce >=", value, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceLessThan(String value) {
            addCriterion("project_introduce <", value, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceLessThanOrEqualTo(String value) {
            addCriterion("project_introduce <=", value, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceLike(String value) {
            addCriterion("project_introduce like", value, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceNotLike(String value) {
            addCriterion("project_introduce not like", value, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceIn(List<String> values) {
            addCriterion("project_introduce in", values, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceNotIn(List<String> values) {
            addCriterion("project_introduce not in", values, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceBetween(String value1, String value2) {
            addCriterion("project_introduce between", value1, value2, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceNotBetween(String value1, String value2) {
            addCriterion("project_introduce not between", value1, value2, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectCompanyIdIsNull() {
            addCriterion("project_company_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectCompanyIdIsNotNull() {
            addCriterion("project_company_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCompanyIdEqualTo(Integer value) {
            addCriterion("project_company_id =", value, "projectCompanyId");
            return (Criteria) this;
        }

        public Criteria andProjectCompanyIdNotEqualTo(Integer value) {
            addCriterion("project_company_id <>", value, "projectCompanyId");
            return (Criteria) this;
        }

        public Criteria andProjectCompanyIdGreaterThan(Integer value) {
            addCriterion("project_company_id >", value, "projectCompanyId");
            return (Criteria) this;
        }

        public Criteria andProjectCompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_company_id >=", value, "projectCompanyId");
            return (Criteria) this;
        }

        public Criteria andProjectCompanyIdLessThan(Integer value) {
            addCriterion("project_company_id <", value, "projectCompanyId");
            return (Criteria) this;
        }

        public Criteria andProjectCompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_company_id <=", value, "projectCompanyId");
            return (Criteria) this;
        }

        public Criteria andProjectCompanyIdIn(List<Integer> values) {
            addCriterion("project_company_id in", values, "projectCompanyId");
            return (Criteria) this;
        }

        public Criteria andProjectCompanyIdNotIn(List<Integer> values) {
            addCriterion("project_company_id not in", values, "projectCompanyId");
            return (Criteria) this;
        }

        public Criteria andProjectCompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("project_company_id between", value1, value2, "projectCompanyId");
            return (Criteria) this;
        }

        public Criteria andProjectCompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_company_id not between", value1, value2, "projectCompanyId");
            return (Criteria) this;
        }

        public Criteria andProjectUserIdIsNull() {
            addCriterion("project_user_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectUserIdIsNotNull() {
            addCriterion("project_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectUserIdEqualTo(Integer value) {
            addCriterion("project_user_id =", value, "projectUserId");
            return (Criteria) this;
        }

        public Criteria andProjectUserIdNotEqualTo(Integer value) {
            addCriterion("project_user_id <>", value, "projectUserId");
            return (Criteria) this;
        }

        public Criteria andProjectUserIdGreaterThan(Integer value) {
            addCriterion("project_user_id >", value, "projectUserId");
            return (Criteria) this;
        }

        public Criteria andProjectUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_user_id >=", value, "projectUserId");
            return (Criteria) this;
        }

        public Criteria andProjectUserIdLessThan(Integer value) {
            addCriterion("project_user_id <", value, "projectUserId");
            return (Criteria) this;
        }

        public Criteria andProjectUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_user_id <=", value, "projectUserId");
            return (Criteria) this;
        }

        public Criteria andProjectUserIdIn(List<Integer> values) {
            addCriterion("project_user_id in", values, "projectUserId");
            return (Criteria) this;
        }

        public Criteria andProjectUserIdNotIn(List<Integer> values) {
            addCriterion("project_user_id not in", values, "projectUserId");
            return (Criteria) this;
        }

        public Criteria andProjectUserIdBetween(Integer value1, Integer value2) {
            addCriterion("project_user_id between", value1, value2, "projectUserId");
            return (Criteria) this;
        }

        public Criteria andProjectUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_user_id not between", value1, value2, "projectUserId");
            return (Criteria) this;
        }

        public Criteria andProjectProvinceIsNull() {
            addCriterion("project_province is null");
            return (Criteria) this;
        }

        public Criteria andProjectProvinceIsNotNull() {
            addCriterion("project_province is not null");
            return (Criteria) this;
        }

        public Criteria andProjectProvinceEqualTo(String value) {
            addCriterion("project_province =", value, "projectProvince");
            return (Criteria) this;
        }

        public Criteria andProjectProvinceNotEqualTo(String value) {
            addCriterion("project_province <>", value, "projectProvince");
            return (Criteria) this;
        }

        public Criteria andProjectProvinceGreaterThan(String value) {
            addCriterion("project_province >", value, "projectProvince");
            return (Criteria) this;
        }

        public Criteria andProjectProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("project_province >=", value, "projectProvince");
            return (Criteria) this;
        }

        public Criteria andProjectProvinceLessThan(String value) {
            addCriterion("project_province <", value, "projectProvince");
            return (Criteria) this;
        }

        public Criteria andProjectProvinceLessThanOrEqualTo(String value) {
            addCriterion("project_province <=", value, "projectProvince");
            return (Criteria) this;
        }

        public Criteria andProjectProvinceLike(String value) {
            addCriterion("project_province like", value, "projectProvince");
            return (Criteria) this;
        }

        public Criteria andProjectProvinceNotLike(String value) {
            addCriterion("project_province not like", value, "projectProvince");
            return (Criteria) this;
        }

        public Criteria andProjectProvinceIn(List<String> values) {
            addCriterion("project_province in", values, "projectProvince");
            return (Criteria) this;
        }

        public Criteria andProjectProvinceNotIn(List<String> values) {
            addCriterion("project_province not in", values, "projectProvince");
            return (Criteria) this;
        }

        public Criteria andProjectProvinceBetween(String value1, String value2) {
            addCriterion("project_province between", value1, value2, "projectProvince");
            return (Criteria) this;
        }

        public Criteria andProjectProvinceNotBetween(String value1, String value2) {
            addCriterion("project_province not between", value1, value2, "projectProvince");
            return (Criteria) this;
        }

        public Criteria andProjectCityIsNull() {
            addCriterion("project_city is null");
            return (Criteria) this;
        }

        public Criteria andProjectCityIsNotNull() {
            addCriterion("project_city is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCityEqualTo(String value) {
            addCriterion("project_city =", value, "projectCity");
            return (Criteria) this;
        }

        public Criteria andProjectCityNotEqualTo(String value) {
            addCriterion("project_city <>", value, "projectCity");
            return (Criteria) this;
        }

        public Criteria andProjectCityGreaterThan(String value) {
            addCriterion("project_city >", value, "projectCity");
            return (Criteria) this;
        }

        public Criteria andProjectCityGreaterThanOrEqualTo(String value) {
            addCriterion("project_city >=", value, "projectCity");
            return (Criteria) this;
        }

        public Criteria andProjectCityLessThan(String value) {
            addCriterion("project_city <", value, "projectCity");
            return (Criteria) this;
        }

        public Criteria andProjectCityLessThanOrEqualTo(String value) {
            addCriterion("project_city <=", value, "projectCity");
            return (Criteria) this;
        }

        public Criteria andProjectCityLike(String value) {
            addCriterion("project_city like", value, "projectCity");
            return (Criteria) this;
        }

        public Criteria andProjectCityNotLike(String value) {
            addCriterion("project_city not like", value, "projectCity");
            return (Criteria) this;
        }

        public Criteria andProjectCityIn(List<String> values) {
            addCriterion("project_city in", values, "projectCity");
            return (Criteria) this;
        }

        public Criteria andProjectCityNotIn(List<String> values) {
            addCriterion("project_city not in", values, "projectCity");
            return (Criteria) this;
        }

        public Criteria andProjectCityBetween(String value1, String value2) {
            addCriterion("project_city between", value1, value2, "projectCity");
            return (Criteria) this;
        }

        public Criteria andProjectCityNotBetween(String value1, String value2) {
            addCriterion("project_city not between", value1, value2, "projectCity");
            return (Criteria) this;
        }

        public Criteria andProjectCountyIsNull() {
            addCriterion("project_county is null");
            return (Criteria) this;
        }

        public Criteria andProjectCountyIsNotNull() {
            addCriterion("project_county is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCountyEqualTo(String value) {
            addCriterion("project_county =", value, "projectCounty");
            return (Criteria) this;
        }

        public Criteria andProjectCountyNotEqualTo(String value) {
            addCriterion("project_county <>", value, "projectCounty");
            return (Criteria) this;
        }

        public Criteria andProjectCountyGreaterThan(String value) {
            addCriterion("project_county >", value, "projectCounty");
            return (Criteria) this;
        }

        public Criteria andProjectCountyGreaterThanOrEqualTo(String value) {
            addCriterion("project_county >=", value, "projectCounty");
            return (Criteria) this;
        }

        public Criteria andProjectCountyLessThan(String value) {
            addCriterion("project_county <", value, "projectCounty");
            return (Criteria) this;
        }

        public Criteria andProjectCountyLessThanOrEqualTo(String value) {
            addCriterion("project_county <=", value, "projectCounty");
            return (Criteria) this;
        }

        public Criteria andProjectCountyLike(String value) {
            addCriterion("project_county like", value, "projectCounty");
            return (Criteria) this;
        }

        public Criteria andProjectCountyNotLike(String value) {
            addCriterion("project_county not like", value, "projectCounty");
            return (Criteria) this;
        }

        public Criteria andProjectCountyIn(List<String> values) {
            addCriterion("project_county in", values, "projectCounty");
            return (Criteria) this;
        }

        public Criteria andProjectCountyNotIn(List<String> values) {
            addCriterion("project_county not in", values, "projectCounty");
            return (Criteria) this;
        }

        public Criteria andProjectCountyBetween(String value1, String value2) {
            addCriterion("project_county between", value1, value2, "projectCounty");
            return (Criteria) this;
        }

        public Criteria andProjectCountyNotBetween(String value1, String value2) {
            addCriterion("project_county not between", value1, value2, "projectCounty");
            return (Criteria) this;
        }

        public Criteria andProjectAddressIsNull() {
            addCriterion("project_address is null");
            return (Criteria) this;
        }

        public Criteria andProjectAddressIsNotNull() {
            addCriterion("project_address is not null");
            return (Criteria) this;
        }

        public Criteria andProjectAddressEqualTo(String value) {
            addCriterion("project_address =", value, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectAddressNotEqualTo(String value) {
            addCriterion("project_address <>", value, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectAddressGreaterThan(String value) {
            addCriterion("project_address >", value, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectAddressGreaterThanOrEqualTo(String value) {
            addCriterion("project_address >=", value, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectAddressLessThan(String value) {
            addCriterion("project_address <", value, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectAddressLessThanOrEqualTo(String value) {
            addCriterion("project_address <=", value, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectAddressLike(String value) {
            addCriterion("project_address like", value, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectAddressNotLike(String value) {
            addCriterion("project_address not like", value, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectAddressIn(List<String> values) {
            addCriterion("project_address in", values, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectAddressNotIn(List<String> values) {
            addCriterion("project_address not in", values, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectAddressBetween(String value1, String value2) {
            addCriterion("project_address between", value1, value2, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectAddressNotBetween(String value1, String value2) {
            addCriterion("project_address not between", value1, value2, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectLongitudeIsNull() {
            addCriterion("project_longitude is null");
            return (Criteria) this;
        }

        public Criteria andProjectLongitudeIsNotNull() {
            addCriterion("project_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andProjectLongitudeEqualTo(String value) {
            addCriterion("project_longitude =", value, "projectLongitude");
            return (Criteria) this;
        }

        public Criteria andProjectLongitudeNotEqualTo(String value) {
            addCriterion("project_longitude <>", value, "projectLongitude");
            return (Criteria) this;
        }

        public Criteria andProjectLongitudeGreaterThan(String value) {
            addCriterion("project_longitude >", value, "projectLongitude");
            return (Criteria) this;
        }

        public Criteria andProjectLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("project_longitude >=", value, "projectLongitude");
            return (Criteria) this;
        }

        public Criteria andProjectLongitudeLessThan(String value) {
            addCriterion("project_longitude <", value, "projectLongitude");
            return (Criteria) this;
        }

        public Criteria andProjectLongitudeLessThanOrEqualTo(String value) {
            addCriterion("project_longitude <=", value, "projectLongitude");
            return (Criteria) this;
        }

        public Criteria andProjectLongitudeLike(String value) {
            addCriterion("project_longitude like", value, "projectLongitude");
            return (Criteria) this;
        }

        public Criteria andProjectLongitudeNotLike(String value) {
            addCriterion("project_longitude not like", value, "projectLongitude");
            return (Criteria) this;
        }

        public Criteria andProjectLongitudeIn(List<String> values) {
            addCriterion("project_longitude in", values, "projectLongitude");
            return (Criteria) this;
        }

        public Criteria andProjectLongitudeNotIn(List<String> values) {
            addCriterion("project_longitude not in", values, "projectLongitude");
            return (Criteria) this;
        }

        public Criteria andProjectLongitudeBetween(String value1, String value2) {
            addCriterion("project_longitude between", value1, value2, "projectLongitude");
            return (Criteria) this;
        }

        public Criteria andProjectLongitudeNotBetween(String value1, String value2) {
            addCriterion("project_longitude not between", value1, value2, "projectLongitude");
            return (Criteria) this;
        }

        public Criteria andProjectLatitudeIsNull() {
            addCriterion("project_latitude is null");
            return (Criteria) this;
        }

        public Criteria andProjectLatitudeIsNotNull() {
            addCriterion("project_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andProjectLatitudeEqualTo(String value) {
            addCriterion("project_latitude =", value, "projectLatitude");
            return (Criteria) this;
        }

        public Criteria andProjectLatitudeNotEqualTo(String value) {
            addCriterion("project_latitude <>", value, "projectLatitude");
            return (Criteria) this;
        }

        public Criteria andProjectLatitudeGreaterThan(String value) {
            addCriterion("project_latitude >", value, "projectLatitude");
            return (Criteria) this;
        }

        public Criteria andProjectLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("project_latitude >=", value, "projectLatitude");
            return (Criteria) this;
        }

        public Criteria andProjectLatitudeLessThan(String value) {
            addCriterion("project_latitude <", value, "projectLatitude");
            return (Criteria) this;
        }

        public Criteria andProjectLatitudeLessThanOrEqualTo(String value) {
            addCriterion("project_latitude <=", value, "projectLatitude");
            return (Criteria) this;
        }

        public Criteria andProjectLatitudeLike(String value) {
            addCriterion("project_latitude like", value, "projectLatitude");
            return (Criteria) this;
        }

        public Criteria andProjectLatitudeNotLike(String value) {
            addCriterion("project_latitude not like", value, "projectLatitude");
            return (Criteria) this;
        }

        public Criteria andProjectLatitudeIn(List<String> values) {
            addCriterion("project_latitude in", values, "projectLatitude");
            return (Criteria) this;
        }

        public Criteria andProjectLatitudeNotIn(List<String> values) {
            addCriterion("project_latitude not in", values, "projectLatitude");
            return (Criteria) this;
        }

        public Criteria andProjectLatitudeBetween(String value1, String value2) {
            addCriterion("project_latitude between", value1, value2, "projectLatitude");
            return (Criteria) this;
        }

        public Criteria andProjectLatitudeNotBetween(String value1, String value2) {
            addCriterion("project_latitude not between", value1, value2, "projectLatitude");
            return (Criteria) this;
        }

        public Criteria andProjectImgIsNull() {
            addCriterion("project_img is null");
            return (Criteria) this;
        }

        public Criteria andProjectImgIsNotNull() {
            addCriterion("project_img is not null");
            return (Criteria) this;
        }

        public Criteria andProjectImgEqualTo(String value) {
            addCriterion("project_img =", value, "projectImg");
            return (Criteria) this;
        }

        public Criteria andProjectImgNotEqualTo(String value) {
            addCriterion("project_img <>", value, "projectImg");
            return (Criteria) this;
        }

        public Criteria andProjectImgGreaterThan(String value) {
            addCriterion("project_img >", value, "projectImg");
            return (Criteria) this;
        }

        public Criteria andProjectImgGreaterThanOrEqualTo(String value) {
            addCriterion("project_img >=", value, "projectImg");
            return (Criteria) this;
        }

        public Criteria andProjectImgLessThan(String value) {
            addCriterion("project_img <", value, "projectImg");
            return (Criteria) this;
        }

        public Criteria andProjectImgLessThanOrEqualTo(String value) {
            addCriterion("project_img <=", value, "projectImg");
            return (Criteria) this;
        }

        public Criteria andProjectImgLike(String value) {
            addCriterion("project_img like", value, "projectImg");
            return (Criteria) this;
        }

        public Criteria andProjectImgNotLike(String value) {
            addCriterion("project_img not like", value, "projectImg");
            return (Criteria) this;
        }

        public Criteria andProjectImgIn(List<String> values) {
            addCriterion("project_img in", values, "projectImg");
            return (Criteria) this;
        }

        public Criteria andProjectImgNotIn(List<String> values) {
            addCriterion("project_img not in", values, "projectImg");
            return (Criteria) this;
        }

        public Criteria andProjectImgBetween(String value1, String value2) {
            addCriterion("project_img between", value1, value2, "projectImg");
            return (Criteria) this;
        }

        public Criteria andProjectImgNotBetween(String value1, String value2) {
            addCriterion("project_img not between", value1, value2, "projectImg");
            return (Criteria) this;
        }

        public Criteria andProjectCadIsNull() {
            addCriterion("project_cad is null");
            return (Criteria) this;
        }

        public Criteria andProjectCadIsNotNull() {
            addCriterion("project_cad is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCadEqualTo(String value) {
            addCriterion("project_cad =", value, "projectCad");
            return (Criteria) this;
        }

        public Criteria andProjectCadNotEqualTo(String value) {
            addCriterion("project_cad <>", value, "projectCad");
            return (Criteria) this;
        }

        public Criteria andProjectCadGreaterThan(String value) {
            addCriterion("project_cad >", value, "projectCad");
            return (Criteria) this;
        }

        public Criteria andProjectCadGreaterThanOrEqualTo(String value) {
            addCriterion("project_cad >=", value, "projectCad");
            return (Criteria) this;
        }

        public Criteria andProjectCadLessThan(String value) {
            addCriterion("project_cad <", value, "projectCad");
            return (Criteria) this;
        }

        public Criteria andProjectCadLessThanOrEqualTo(String value) {
            addCriterion("project_cad <=", value, "projectCad");
            return (Criteria) this;
        }

        public Criteria andProjectCadLike(String value) {
            addCriterion("project_cad like", value, "projectCad");
            return (Criteria) this;
        }

        public Criteria andProjectCadNotLike(String value) {
            addCriterion("project_cad not like", value, "projectCad");
            return (Criteria) this;
        }

        public Criteria andProjectCadIn(List<String> values) {
            addCriterion("project_cad in", values, "projectCad");
            return (Criteria) this;
        }

        public Criteria andProjectCadNotIn(List<String> values) {
            addCriterion("project_cad not in", values, "projectCad");
            return (Criteria) this;
        }

        public Criteria andProjectCadBetween(String value1, String value2) {
            addCriterion("project_cad between", value1, value2, "projectCad");
            return (Criteria) this;
        }

        public Criteria andProjectCadNotBetween(String value1, String value2) {
            addCriterion("project_cad not between", value1, value2, "projectCad");
            return (Criteria) this;
        }

        public Criteria andProject3durlIsNull() {
            addCriterion("project_3durl is null");
            return (Criteria) this;
        }

        public Criteria andProject3durlIsNotNull() {
            addCriterion("project_3durl is not null");
            return (Criteria) this;
        }

        public Criteria andProject3durlEqualTo(String value) {
            addCriterion("project_3durl =", value, "project3durl");
            return (Criteria) this;
        }

        public Criteria andProject3durlNotEqualTo(String value) {
            addCriterion("project_3durl <>", value, "project3durl");
            return (Criteria) this;
        }

        public Criteria andProject3durlGreaterThan(String value) {
            addCriterion("project_3durl >", value, "project3durl");
            return (Criteria) this;
        }

        public Criteria andProject3durlGreaterThanOrEqualTo(String value) {
            addCriterion("project_3durl >=", value, "project3durl");
            return (Criteria) this;
        }

        public Criteria andProject3durlLessThan(String value) {
            addCriterion("project_3durl <", value, "project3durl");
            return (Criteria) this;
        }

        public Criteria andProject3durlLessThanOrEqualTo(String value) {
            addCriterion("project_3durl <=", value, "project3durl");
            return (Criteria) this;
        }

        public Criteria andProject3durlLike(String value) {
            addCriterion("project_3durl like", value, "project3durl");
            return (Criteria) this;
        }

        public Criteria andProject3durlNotLike(String value) {
            addCriterion("project_3durl not like", value, "project3durl");
            return (Criteria) this;
        }

        public Criteria andProject3durlIn(List<String> values) {
            addCriterion("project_3durl in", values, "project3durl");
            return (Criteria) this;
        }

        public Criteria andProject3durlNotIn(List<String> values) {
            addCriterion("project_3durl not in", values, "project3durl");
            return (Criteria) this;
        }

        public Criteria andProject3durlBetween(String value1, String value2) {
            addCriterion("project_3durl between", value1, value2, "project3durl");
            return (Criteria) this;
        }

        public Criteria andProject3durlNotBetween(String value1, String value2) {
            addCriterion("project_3durl not between", value1, value2, "project3durl");
            return (Criteria) this;
        }

        public Criteria andProjectStartTimeIsNull() {
            addCriterion("project_start_time is null");
            return (Criteria) this;
        }

        public Criteria andProjectStartTimeIsNotNull() {
            addCriterion("project_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andProjectStartTimeEqualTo(Date value) {
            addCriterion("project_start_time =", value, "projectStartTime");
            return (Criteria) this;
        }

        public Criteria andProjectStartTimeNotEqualTo(Date value) {
            addCriterion("project_start_time <>", value, "projectStartTime");
            return (Criteria) this;
        }

        public Criteria andProjectStartTimeGreaterThan(Date value) {
            addCriterion("project_start_time >", value, "projectStartTime");
            return (Criteria) this;
        }

        public Criteria andProjectStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("project_start_time >=", value, "projectStartTime");
            return (Criteria) this;
        }

        public Criteria andProjectStartTimeLessThan(Date value) {
            addCriterion("project_start_time <", value, "projectStartTime");
            return (Criteria) this;
        }

        public Criteria andProjectStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("project_start_time <=", value, "projectStartTime");
            return (Criteria) this;
        }

        public Criteria andProjectStartTimeIn(List<Date> values) {
            addCriterion("project_start_time in", values, "projectStartTime");
            return (Criteria) this;
        }

        public Criteria andProjectStartTimeNotIn(List<Date> values) {
            addCriterion("project_start_time not in", values, "projectStartTime");
            return (Criteria) this;
        }

        public Criteria andProjectStartTimeBetween(Date value1, Date value2) {
            addCriterion("project_start_time between", value1, value2, "projectStartTime");
            return (Criteria) this;
        }

        public Criteria andProjectStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("project_start_time not between", value1, value2, "projectStartTime");
            return (Criteria) this;
        }

        public Criteria andProjectExpireTimeIsNull() {
            addCriterion("project_expire_time is null");
            return (Criteria) this;
        }

        public Criteria andProjectExpireTimeIsNotNull() {
            addCriterion("project_expire_time is not null");
            return (Criteria) this;
        }

        public Criteria andProjectExpireTimeEqualTo(Date value) {
            addCriterion("project_expire_time =", value, "projectExpireTime");
            return (Criteria) this;
        }

        public Criteria andProjectExpireTimeNotEqualTo(Date value) {
            addCriterion("project_expire_time <>", value, "projectExpireTime");
            return (Criteria) this;
        }

        public Criteria andProjectExpireTimeGreaterThan(Date value) {
            addCriterion("project_expire_time >", value, "projectExpireTime");
            return (Criteria) this;
        }

        public Criteria andProjectExpireTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("project_expire_time >=", value, "projectExpireTime");
            return (Criteria) this;
        }

        public Criteria andProjectExpireTimeLessThan(Date value) {
            addCriterion("project_expire_time <", value, "projectExpireTime");
            return (Criteria) this;
        }

        public Criteria andProjectExpireTimeLessThanOrEqualTo(Date value) {
            addCriterion("project_expire_time <=", value, "projectExpireTime");
            return (Criteria) this;
        }

        public Criteria andProjectExpireTimeIn(List<Date> values) {
            addCriterion("project_expire_time in", values, "projectExpireTime");
            return (Criteria) this;
        }

        public Criteria andProjectExpireTimeNotIn(List<Date> values) {
            addCriterion("project_expire_time not in", values, "projectExpireTime");
            return (Criteria) this;
        }

        public Criteria andProjectExpireTimeBetween(Date value1, Date value2) {
            addCriterion("project_expire_time between", value1, value2, "projectExpireTime");
            return (Criteria) this;
        }

        public Criteria andProjectExpireTimeNotBetween(Date value1, Date value2) {
            addCriterion("project_expire_time not between", value1, value2, "projectExpireTime");
            return (Criteria) this;
        }

        public Criteria andProjectNotifyIsNull() {
            addCriterion("project_notify is null");
            return (Criteria) this;
        }

        public Criteria andProjectNotifyIsNotNull() {
            addCriterion("project_notify is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNotifyEqualTo(Integer value) {
            addCriterion("project_notify =", value, "projectNotify");
            return (Criteria) this;
        }

        public Criteria andProjectNotifyNotEqualTo(Integer value) {
            addCriterion("project_notify <>", value, "projectNotify");
            return (Criteria) this;
        }

        public Criteria andProjectNotifyGreaterThan(Integer value) {
            addCriterion("project_notify >", value, "projectNotify");
            return (Criteria) this;
        }

        public Criteria andProjectNotifyGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_notify >=", value, "projectNotify");
            return (Criteria) this;
        }

        public Criteria andProjectNotifyLessThan(Integer value) {
            addCriterion("project_notify <", value, "projectNotify");
            return (Criteria) this;
        }

        public Criteria andProjectNotifyLessThanOrEqualTo(Integer value) {
            addCriterion("project_notify <=", value, "projectNotify");
            return (Criteria) this;
        }

        public Criteria andProjectNotifyIn(List<Integer> values) {
            addCriterion("project_notify in", values, "projectNotify");
            return (Criteria) this;
        }

        public Criteria andProjectNotifyNotIn(List<Integer> values) {
            addCriterion("project_notify not in", values, "projectNotify");
            return (Criteria) this;
        }

        public Criteria andProjectNotifyBetween(Integer value1, Integer value2) {
            addCriterion("project_notify between", value1, value2, "projectNotify");
            return (Criteria) this;
        }

        public Criteria andProjectNotifyNotBetween(Integer value1, Integer value2) {
            addCriterion("project_notify not between", value1, value2, "projectNotify");
            return (Criteria) this;
        }

        public Criteria andProjectPermissionStatusIsNull() {
            addCriterion("project_permission_status is null");
            return (Criteria) this;
        }

        public Criteria andProjectPermissionStatusIsNotNull() {
            addCriterion("project_permission_status is not null");
            return (Criteria) this;
        }

        public Criteria andProjectPermissionStatusEqualTo(Integer value) {
            addCriterion("project_permission_status =", value, "projectPermissionStatus");
            return (Criteria) this;
        }

        public Criteria andProjectPermissionStatusNotEqualTo(Integer value) {
            addCriterion("project_permission_status <>", value, "projectPermissionStatus");
            return (Criteria) this;
        }

        public Criteria andProjectPermissionStatusGreaterThan(Integer value) {
            addCriterion("project_permission_status >", value, "projectPermissionStatus");
            return (Criteria) this;
        }

        public Criteria andProjectPermissionStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_permission_status >=", value, "projectPermissionStatus");
            return (Criteria) this;
        }

        public Criteria andProjectPermissionStatusLessThan(Integer value) {
            addCriterion("project_permission_status <", value, "projectPermissionStatus");
            return (Criteria) this;
        }

        public Criteria andProjectPermissionStatusLessThanOrEqualTo(Integer value) {
            addCriterion("project_permission_status <=", value, "projectPermissionStatus");
            return (Criteria) this;
        }

        public Criteria andProjectPermissionStatusIn(List<Integer> values) {
            addCriterion("project_permission_status in", values, "projectPermissionStatus");
            return (Criteria) this;
        }

        public Criteria andProjectPermissionStatusNotIn(List<Integer> values) {
            addCriterion("project_permission_status not in", values, "projectPermissionStatus");
            return (Criteria) this;
        }

        public Criteria andProjectPermissionStatusBetween(Integer value1, Integer value2) {
            addCriterion("project_permission_status between", value1, value2, "projectPermissionStatus");
            return (Criteria) this;
        }

        public Criteria andProjectPermissionStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("project_permission_status not between", value1, value2, "projectPermissionStatus");
            return (Criteria) this;
        }

        public Criteria andProjectUseStatusIsNull() {
            addCriterion("project_use_status is null");
            return (Criteria) this;
        }

        public Criteria andProjectUseStatusIsNotNull() {
            addCriterion("project_use_status is not null");
            return (Criteria) this;
        }

        public Criteria andProjectUseStatusEqualTo(Integer value) {
            addCriterion("project_use_status =", value, "projectUseStatus");
            return (Criteria) this;
        }

        public Criteria andProjectUseStatusNotEqualTo(Integer value) {
            addCriterion("project_use_status <>", value, "projectUseStatus");
            return (Criteria) this;
        }

        public Criteria andProjectUseStatusGreaterThan(Integer value) {
            addCriterion("project_use_status >", value, "projectUseStatus");
            return (Criteria) this;
        }

        public Criteria andProjectUseStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_use_status >=", value, "projectUseStatus");
            return (Criteria) this;
        }

        public Criteria andProjectUseStatusLessThan(Integer value) {
            addCriterion("project_use_status <", value, "projectUseStatus");
            return (Criteria) this;
        }

        public Criteria andProjectUseStatusLessThanOrEqualTo(Integer value) {
            addCriterion("project_use_status <=", value, "projectUseStatus");
            return (Criteria) this;
        }

        public Criteria andProjectUseStatusIn(List<Integer> values) {
            addCriterion("project_use_status in", values, "projectUseStatus");
            return (Criteria) this;
        }

        public Criteria andProjectUseStatusNotIn(List<Integer> values) {
            addCriterion("project_use_status not in", values, "projectUseStatus");
            return (Criteria) this;
        }

        public Criteria andProjectUseStatusBetween(Integer value1, Integer value2) {
            addCriterion("project_use_status between", value1, value2, "projectUseStatus");
            return (Criteria) this;
        }

        public Criteria andProjectUseStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("project_use_status not between", value1, value2, "projectUseStatus");
            return (Criteria) this;
        }

        public Criteria andProjectDeviceStatusIsNull() {
            addCriterion("project_device_status is null");
            return (Criteria) this;
        }

        public Criteria andProjectDeviceStatusIsNotNull() {
            addCriterion("project_device_status is not null");
            return (Criteria) this;
        }

        public Criteria andProjectDeviceStatusEqualTo(Integer value) {
            addCriterion("project_device_status =", value, "projectDeviceStatus");
            return (Criteria) this;
        }

        public Criteria andProjectDeviceStatusNotEqualTo(Integer value) {
            addCriterion("project_device_status <>", value, "projectDeviceStatus");
            return (Criteria) this;
        }

        public Criteria andProjectDeviceStatusGreaterThan(Integer value) {
            addCriterion("project_device_status >", value, "projectDeviceStatus");
            return (Criteria) this;
        }

        public Criteria andProjectDeviceStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_device_status >=", value, "projectDeviceStatus");
            return (Criteria) this;
        }

        public Criteria andProjectDeviceStatusLessThan(Integer value) {
            addCriterion("project_device_status <", value, "projectDeviceStatus");
            return (Criteria) this;
        }

        public Criteria andProjectDeviceStatusLessThanOrEqualTo(Integer value) {
            addCriterion("project_device_status <=", value, "projectDeviceStatus");
            return (Criteria) this;
        }

        public Criteria andProjectDeviceStatusIn(List<Integer> values) {
            addCriterion("project_device_status in", values, "projectDeviceStatus");
            return (Criteria) this;
        }

        public Criteria andProjectDeviceStatusNotIn(List<Integer> values) {
            addCriterion("project_device_status not in", values, "projectDeviceStatus");
            return (Criteria) this;
        }

        public Criteria andProjectDeviceStatusBetween(Integer value1, Integer value2) {
            addCriterion("project_device_status between", value1, value2, "projectDeviceStatus");
            return (Criteria) this;
        }

        public Criteria andProjectDeviceStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("project_device_status not between", value1, value2, "projectDeviceStatus");
            return (Criteria) this;
        }

        public Criteria andProjectIsOpenIsNull() {
            addCriterion("project_is_open is null");
            return (Criteria) this;
        }

        public Criteria andProjectIsOpenIsNotNull() {
            addCriterion("project_is_open is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIsOpenEqualTo(Integer value) {
            addCriterion("project_is_open =", value, "projectIsOpen");
            return (Criteria) this;
        }

        public Criteria andProjectIsOpenNotEqualTo(Integer value) {
            addCriterion("project_is_open <>", value, "projectIsOpen");
            return (Criteria) this;
        }

        public Criteria andProjectIsOpenGreaterThan(Integer value) {
            addCriterion("project_is_open >", value, "projectIsOpen");
            return (Criteria) this;
        }

        public Criteria andProjectIsOpenGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_is_open >=", value, "projectIsOpen");
            return (Criteria) this;
        }

        public Criteria andProjectIsOpenLessThan(Integer value) {
            addCriterion("project_is_open <", value, "projectIsOpen");
            return (Criteria) this;
        }

        public Criteria andProjectIsOpenLessThanOrEqualTo(Integer value) {
            addCriterion("project_is_open <=", value, "projectIsOpen");
            return (Criteria) this;
        }

        public Criteria andProjectIsOpenIn(List<Integer> values) {
            addCriterion("project_is_open in", values, "projectIsOpen");
            return (Criteria) this;
        }

        public Criteria andProjectIsOpenNotIn(List<Integer> values) {
            addCriterion("project_is_open not in", values, "projectIsOpen");
            return (Criteria) this;
        }

        public Criteria andProjectIsOpenBetween(Integer value1, Integer value2) {
            addCriterion("project_is_open between", value1, value2, "projectIsOpen");
            return (Criteria) this;
        }

        public Criteria andProjectIsOpenNotBetween(Integer value1, Integer value2) {
            addCriterion("project_is_open not between", value1, value2, "projectIsOpen");
            return (Criteria) this;
        }

        public Criteria andProjectExtend1IsNull() {
            addCriterion("project_extend1 is null");
            return (Criteria) this;
        }

        public Criteria andProjectExtend1IsNotNull() {
            addCriterion("project_extend1 is not null");
            return (Criteria) this;
        }

        public Criteria andProjectExtend1EqualTo(String value) {
            addCriterion("project_extend1 =", value, "projectExtend1");
            return (Criteria) this;
        }

        public Criteria andProjectExtend1NotEqualTo(String value) {
            addCriterion("project_extend1 <>", value, "projectExtend1");
            return (Criteria) this;
        }

        public Criteria andProjectExtend1GreaterThan(String value) {
            addCriterion("project_extend1 >", value, "projectExtend1");
            return (Criteria) this;
        }

        public Criteria andProjectExtend1GreaterThanOrEqualTo(String value) {
            addCriterion("project_extend1 >=", value, "projectExtend1");
            return (Criteria) this;
        }

        public Criteria andProjectExtend1LessThan(String value) {
            addCriterion("project_extend1 <", value, "projectExtend1");
            return (Criteria) this;
        }

        public Criteria andProjectExtend1LessThanOrEqualTo(String value) {
            addCriterion("project_extend1 <=", value, "projectExtend1");
            return (Criteria) this;
        }

        public Criteria andProjectExtend1Like(String value) {
            addCriterion("project_extend1 like", value, "projectExtend1");
            return (Criteria) this;
        }

        public Criteria andProjectExtend1NotLike(String value) {
            addCriterion("project_extend1 not like", value, "projectExtend1");
            return (Criteria) this;
        }

        public Criteria andProjectExtend1In(List<String> values) {
            addCriterion("project_extend1 in", values, "projectExtend1");
            return (Criteria) this;
        }

        public Criteria andProjectExtend1NotIn(List<String> values) {
            addCriterion("project_extend1 not in", values, "projectExtend1");
            return (Criteria) this;
        }

        public Criteria andProjectExtend1Between(String value1, String value2) {
            addCriterion("project_extend1 between", value1, value2, "projectExtend1");
            return (Criteria) this;
        }

        public Criteria andProjectExtend1NotBetween(String value1, String value2) {
            addCriterion("project_extend1 not between", value1, value2, "projectExtend1");
            return (Criteria) this;
        }

        public Criteria andProjectExtend2IsNull() {
            addCriterion("project_extend2 is null");
            return (Criteria) this;
        }

        public Criteria andProjectExtend2IsNotNull() {
            addCriterion("project_extend2 is not null");
            return (Criteria) this;
        }

        public Criteria andProjectExtend2EqualTo(String value) {
            addCriterion("project_extend2 =", value, "projectExtend2");
            return (Criteria) this;
        }

        public Criteria andProjectExtend2NotEqualTo(String value) {
            addCriterion("project_extend2 <>", value, "projectExtend2");
            return (Criteria) this;
        }

        public Criteria andProjectExtend2GreaterThan(String value) {
            addCriterion("project_extend2 >", value, "projectExtend2");
            return (Criteria) this;
        }

        public Criteria andProjectExtend2GreaterThanOrEqualTo(String value) {
            addCriterion("project_extend2 >=", value, "projectExtend2");
            return (Criteria) this;
        }

        public Criteria andProjectExtend2LessThan(String value) {
            addCriterion("project_extend2 <", value, "projectExtend2");
            return (Criteria) this;
        }

        public Criteria andProjectExtend2LessThanOrEqualTo(String value) {
            addCriterion("project_extend2 <=", value, "projectExtend2");
            return (Criteria) this;
        }

        public Criteria andProjectExtend2Like(String value) {
            addCriterion("project_extend2 like", value, "projectExtend2");
            return (Criteria) this;
        }

        public Criteria andProjectExtend2NotLike(String value) {
            addCriterion("project_extend2 not like", value, "projectExtend2");
            return (Criteria) this;
        }

        public Criteria andProjectExtend2In(List<String> values) {
            addCriterion("project_extend2 in", values, "projectExtend2");
            return (Criteria) this;
        }

        public Criteria andProjectExtend2NotIn(List<String> values) {
            addCriterion("project_extend2 not in", values, "projectExtend2");
            return (Criteria) this;
        }

        public Criteria andProjectExtend2Between(String value1, String value2) {
            addCriterion("project_extend2 between", value1, value2, "projectExtend2");
            return (Criteria) this;
        }

        public Criteria andProjectExtend2NotBetween(String value1, String value2) {
            addCriterion("project_extend2 not between", value1, value2, "projectExtend2");
            return (Criteria) this;
        }

        public Criteria andProjectExtend3IsNull() {
            addCriterion("project_extend3 is null");
            return (Criteria) this;
        }

        public Criteria andProjectExtend3IsNotNull() {
            addCriterion("project_extend3 is not null");
            return (Criteria) this;
        }

        public Criteria andProjectExtend3EqualTo(String value) {
            addCriterion("project_extend3 =", value, "projectExtend3");
            return (Criteria) this;
        }

        public Criteria andProjectExtend3NotEqualTo(String value) {
            addCriterion("project_extend3 <>", value, "projectExtend3");
            return (Criteria) this;
        }

        public Criteria andProjectExtend3GreaterThan(String value) {
            addCriterion("project_extend3 >", value, "projectExtend3");
            return (Criteria) this;
        }

        public Criteria andProjectExtend3GreaterThanOrEqualTo(String value) {
            addCriterion("project_extend3 >=", value, "projectExtend3");
            return (Criteria) this;
        }

        public Criteria andProjectExtend3LessThan(String value) {
            addCriterion("project_extend3 <", value, "projectExtend3");
            return (Criteria) this;
        }

        public Criteria andProjectExtend3LessThanOrEqualTo(String value) {
            addCriterion("project_extend3 <=", value, "projectExtend3");
            return (Criteria) this;
        }

        public Criteria andProjectExtend3Like(String value) {
            addCriterion("project_extend3 like", value, "projectExtend3");
            return (Criteria) this;
        }

        public Criteria andProjectExtend3NotLike(String value) {
            addCriterion("project_extend3 not like", value, "projectExtend3");
            return (Criteria) this;
        }

        public Criteria andProjectExtend3In(List<String> values) {
            addCriterion("project_extend3 in", values, "projectExtend3");
            return (Criteria) this;
        }

        public Criteria andProjectExtend3NotIn(List<String> values) {
            addCriterion("project_extend3 not in", values, "projectExtend3");
            return (Criteria) this;
        }

        public Criteria andProjectExtend3Between(String value1, String value2) {
            addCriterion("project_extend3 between", value1, value2, "projectExtend3");
            return (Criteria) this;
        }

        public Criteria andProjectExtend3NotBetween(String value1, String value2) {
            addCriterion("project_extend3 not between", value1, value2, "projectExtend3");
            return (Criteria) this;
        }

        public Criteria andProjectExtend4IsNull() {
            addCriterion("project_extend4 is null");
            return (Criteria) this;
        }

        public Criteria andProjectExtend4IsNotNull() {
            addCriterion("project_extend4 is not null");
            return (Criteria) this;
        }

        public Criteria andProjectExtend4EqualTo(String value) {
            addCriterion("project_extend4 =", value, "projectExtend4");
            return (Criteria) this;
        }

        public Criteria andProjectExtend4NotEqualTo(String value) {
            addCriterion("project_extend4 <>", value, "projectExtend4");
            return (Criteria) this;
        }

        public Criteria andProjectExtend4GreaterThan(String value) {
            addCriterion("project_extend4 >", value, "projectExtend4");
            return (Criteria) this;
        }

        public Criteria andProjectExtend4GreaterThanOrEqualTo(String value) {
            addCriterion("project_extend4 >=", value, "projectExtend4");
            return (Criteria) this;
        }

        public Criteria andProjectExtend4LessThan(String value) {
            addCriterion("project_extend4 <", value, "projectExtend4");
            return (Criteria) this;
        }

        public Criteria andProjectExtend4LessThanOrEqualTo(String value) {
            addCriterion("project_extend4 <=", value, "projectExtend4");
            return (Criteria) this;
        }

        public Criteria andProjectExtend4Like(String value) {
            addCriterion("project_extend4 like", value, "projectExtend4");
            return (Criteria) this;
        }

        public Criteria andProjectExtend4NotLike(String value) {
            addCriterion("project_extend4 not like", value, "projectExtend4");
            return (Criteria) this;
        }

        public Criteria andProjectExtend4In(List<String> values) {
            addCriterion("project_extend4 in", values, "projectExtend4");
            return (Criteria) this;
        }

        public Criteria andProjectExtend4NotIn(List<String> values) {
            addCriterion("project_extend4 not in", values, "projectExtend4");
            return (Criteria) this;
        }

        public Criteria andProjectExtend4Between(String value1, String value2) {
            addCriterion("project_extend4 between", value1, value2, "projectExtend4");
            return (Criteria) this;
        }

        public Criteria andProjectExtend4NotBetween(String value1, String value2) {
            addCriterion("project_extend4 not between", value1, value2, "projectExtend4");
            return (Criteria) this;
        }

        public Criteria andProjectExtend5IsNull() {
            addCriterion("project_extend5 is null");
            return (Criteria) this;
        }

        public Criteria andProjectExtend5IsNotNull() {
            addCriterion("project_extend5 is not null");
            return (Criteria) this;
        }

        public Criteria andProjectExtend5EqualTo(String value) {
            addCriterion("project_extend5 =", value, "projectExtend5");
            return (Criteria) this;
        }

        public Criteria andProjectExtend5NotEqualTo(String value) {
            addCriterion("project_extend5 <>", value, "projectExtend5");
            return (Criteria) this;
        }

        public Criteria andProjectExtend5GreaterThan(String value) {
            addCriterion("project_extend5 >", value, "projectExtend5");
            return (Criteria) this;
        }

        public Criteria andProjectExtend5GreaterThanOrEqualTo(String value) {
            addCriterion("project_extend5 >=", value, "projectExtend5");
            return (Criteria) this;
        }

        public Criteria andProjectExtend5LessThan(String value) {
            addCriterion("project_extend5 <", value, "projectExtend5");
            return (Criteria) this;
        }

        public Criteria andProjectExtend5LessThanOrEqualTo(String value) {
            addCriterion("project_extend5 <=", value, "projectExtend5");
            return (Criteria) this;
        }

        public Criteria andProjectExtend5Like(String value) {
            addCriterion("project_extend5 like", value, "projectExtend5");
            return (Criteria) this;
        }

        public Criteria andProjectExtend5NotLike(String value) {
            addCriterion("project_extend5 not like", value, "projectExtend5");
            return (Criteria) this;
        }

        public Criteria andProjectExtend5In(List<String> values) {
            addCriterion("project_extend5 in", values, "projectExtend5");
            return (Criteria) this;
        }

        public Criteria andProjectExtend5NotIn(List<String> values) {
            addCriterion("project_extend5 not in", values, "projectExtend5");
            return (Criteria) this;
        }

        public Criteria andProjectExtend5Between(String value1, String value2) {
            addCriterion("project_extend5 between", value1, value2, "projectExtend5");
            return (Criteria) this;
        }

        public Criteria andProjectExtend5NotBetween(String value1, String value2) {
            addCriterion("project_extend5 not between", value1, value2, "projectExtend5");
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