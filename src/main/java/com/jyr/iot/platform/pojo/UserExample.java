package com.jyr.iot.platform.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNull() {
            addCriterion("user_phone is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNotNull() {
            addCriterion("user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneEqualTo(String value) {
            addCriterion("user_phone =", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotEqualTo(String value) {
            addCriterion("user_phone <>", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThan(String value) {
            addCriterion("user_phone >", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("user_phone >=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThan(String value) {
            addCriterion("user_phone <", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("user_phone <=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLike(String value) {
            addCriterion("user_phone like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotLike(String value) {
            addCriterion("user_phone not like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIn(List<String> values) {
            addCriterion("user_phone in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotIn(List<String> values) {
            addCriterion("user_phone not in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneBetween(String value1, String value2) {
            addCriterion("user_phone between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotBetween(String value1, String value2) {
            addCriterion("user_phone not between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNull() {
            addCriterion("user_password is null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNotNull() {
            addCriterion("user_password is not null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordEqualTo(String value) {
            addCriterion("user_password =", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotEqualTo(String value) {
            addCriterion("user_password <>", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThan(String value) {
            addCriterion("user_password >", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("user_password >=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThan(String value) {
            addCriterion("user_password <", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThanOrEqualTo(String value) {
            addCriterion("user_password <=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLike(String value) {
            addCriterion("user_password like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotLike(String value) {
            addCriterion("user_password not like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIn(List<String> values) {
            addCriterion("user_password in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotIn(List<String> values) {
            addCriterion("user_password not in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordBetween(String value1, String value2) {
            addCriterion("user_password between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotBetween(String value1, String value2) {
            addCriterion("user_password not between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserRoleIsNull() {
            addCriterion("user_role is null");
            return (Criteria) this;
        }

        public Criteria andUserRoleIsNotNull() {
            addCriterion("user_role is not null");
            return (Criteria) this;
        }

        public Criteria andUserRoleEqualTo(Integer value) {
            addCriterion("user_role =", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleNotEqualTo(Integer value) {
            addCriterion("user_role <>", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleGreaterThan(Integer value) {
            addCriterion("user_role >", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_role >=", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleLessThan(Integer value) {
            addCriterion("user_role <", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleLessThanOrEqualTo(Integer value) {
            addCriterion("user_role <=", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleIn(List<Integer> values) {
            addCriterion("user_role in", values, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleNotIn(List<Integer> values) {
            addCriterion("user_role not in", values, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleBetween(Integer value1, Integer value2) {
            addCriterion("user_role between", value1, value2, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleNotBetween(Integer value1, Integer value2) {
            addCriterion("user_role not between", value1, value2, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserCompanyIdIsNull() {
            addCriterion("user_company_id is null");
            return (Criteria) this;
        }

        public Criteria andUserCompanyIdIsNotNull() {
            addCriterion("user_company_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserCompanyIdEqualTo(Integer value) {
            addCriterion("user_company_id =", value, "userCompanyId");
            return (Criteria) this;
        }

        public Criteria andUserCompanyIdNotEqualTo(Integer value) {
            addCriterion("user_company_id <>", value, "userCompanyId");
            return (Criteria) this;
        }

        public Criteria andUserCompanyIdGreaterThan(Integer value) {
            addCriterion("user_company_id >", value, "userCompanyId");
            return (Criteria) this;
        }

        public Criteria andUserCompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_company_id >=", value, "userCompanyId");
            return (Criteria) this;
        }

        public Criteria andUserCompanyIdLessThan(Integer value) {
            addCriterion("user_company_id <", value, "userCompanyId");
            return (Criteria) this;
        }

        public Criteria andUserCompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_company_id <=", value, "userCompanyId");
            return (Criteria) this;
        }

        public Criteria andUserCompanyIdIn(List<Integer> values) {
            addCriterion("user_company_id in", values, "userCompanyId");
            return (Criteria) this;
        }

        public Criteria andUserCompanyIdNotIn(List<Integer> values) {
            addCriterion("user_company_id not in", values, "userCompanyId");
            return (Criteria) this;
        }

        public Criteria andUserCompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("user_company_id between", value1, value2, "userCompanyId");
            return (Criteria) this;
        }

        public Criteria andUserCompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_company_id not between", value1, value2, "userCompanyId");
            return (Criteria) this;
        }

        public Criteria andUserProjectIdIsNull() {
            addCriterion("user_project_id is null");
            return (Criteria) this;
        }

        public Criteria andUserProjectIdIsNotNull() {
            addCriterion("user_project_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserProjectIdEqualTo(Integer value) {
            addCriterion("user_project_id =", value, "userProjectId");
            return (Criteria) this;
        }

        public Criteria andUserProjectIdNotEqualTo(Integer value) {
            addCriterion("user_project_id <>", value, "userProjectId");
            return (Criteria) this;
        }

        public Criteria andUserProjectIdGreaterThan(Integer value) {
            addCriterion("user_project_id >", value, "userProjectId");
            return (Criteria) this;
        }

        public Criteria andUserProjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_project_id >=", value, "userProjectId");
            return (Criteria) this;
        }

        public Criteria andUserProjectIdLessThan(Integer value) {
            addCriterion("user_project_id <", value, "userProjectId");
            return (Criteria) this;
        }

        public Criteria andUserProjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_project_id <=", value, "userProjectId");
            return (Criteria) this;
        }

        public Criteria andUserProjectIdIn(List<Integer> values) {
            addCriterion("user_project_id in", values, "userProjectId");
            return (Criteria) this;
        }

        public Criteria andUserProjectIdNotIn(List<Integer> values) {
            addCriterion("user_project_id not in", values, "userProjectId");
            return (Criteria) this;
        }

        public Criteria andUserProjectIdBetween(Integer value1, Integer value2) {
            addCriterion("user_project_id between", value1, value2, "userProjectId");
            return (Criteria) this;
        }

        public Criteria andUserProjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_project_id not between", value1, value2, "userProjectId");
            return (Criteria) this;
        }

        public Criteria andUserImgIsNull() {
            addCriterion("user_img is null");
            return (Criteria) this;
        }

        public Criteria andUserImgIsNotNull() {
            addCriterion("user_img is not null");
            return (Criteria) this;
        }

        public Criteria andUserImgEqualTo(String value) {
            addCriterion("user_img =", value, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgNotEqualTo(String value) {
            addCriterion("user_img <>", value, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgGreaterThan(String value) {
            addCriterion("user_img >", value, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgGreaterThanOrEqualTo(String value) {
            addCriterion("user_img >=", value, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgLessThan(String value) {
            addCriterion("user_img <", value, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgLessThanOrEqualTo(String value) {
            addCriterion("user_img <=", value, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgLike(String value) {
            addCriterion("user_img like", value, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgNotLike(String value) {
            addCriterion("user_img not like", value, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgIn(List<String> values) {
            addCriterion("user_img in", values, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgNotIn(List<String> values) {
            addCriterion("user_img not in", values, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgBetween(String value1, String value2) {
            addCriterion("user_img between", value1, value2, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgNotBetween(String value1, String value2) {
            addCriterion("user_img not between", value1, value2, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserMailIsNull() {
            addCriterion("user_mail is null");
            return (Criteria) this;
        }

        public Criteria andUserMailIsNotNull() {
            addCriterion("user_mail is not null");
            return (Criteria) this;
        }

        public Criteria andUserMailEqualTo(String value) {
            addCriterion("user_mail =", value, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailNotEqualTo(String value) {
            addCriterion("user_mail <>", value, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailGreaterThan(String value) {
            addCriterion("user_mail >", value, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailGreaterThanOrEqualTo(String value) {
            addCriterion("user_mail >=", value, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailLessThan(String value) {
            addCriterion("user_mail <", value, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailLessThanOrEqualTo(String value) {
            addCriterion("user_mail <=", value, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailLike(String value) {
            addCriterion("user_mail like", value, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailNotLike(String value) {
            addCriterion("user_mail not like", value, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailIn(List<String> values) {
            addCriterion("user_mail in", values, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailNotIn(List<String> values) {
            addCriterion("user_mail not in", values, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailBetween(String value1, String value2) {
            addCriterion("user_mail between", value1, value2, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailNotBetween(String value1, String value2) {
            addCriterion("user_mail not between", value1, value2, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserPermissionIdIsNull() {
            addCriterion("user_permission_id is null");
            return (Criteria) this;
        }

        public Criteria andUserPermissionIdIsNotNull() {
            addCriterion("user_permission_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserPermissionIdEqualTo(Integer value) {
            addCriterion("user_permission_id =", value, "userPermissionId");
            return (Criteria) this;
        }

        public Criteria andUserPermissionIdNotEqualTo(Integer value) {
            addCriterion("user_permission_id <>", value, "userPermissionId");
            return (Criteria) this;
        }

        public Criteria andUserPermissionIdGreaterThan(Integer value) {
            addCriterion("user_permission_id >", value, "userPermissionId");
            return (Criteria) this;
        }

        public Criteria andUserPermissionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_permission_id >=", value, "userPermissionId");
            return (Criteria) this;
        }

        public Criteria andUserPermissionIdLessThan(Integer value) {
            addCriterion("user_permission_id <", value, "userPermissionId");
            return (Criteria) this;
        }

        public Criteria andUserPermissionIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_permission_id <=", value, "userPermissionId");
            return (Criteria) this;
        }

        public Criteria andUserPermissionIdIn(List<Integer> values) {
            addCriterion("user_permission_id in", values, "userPermissionId");
            return (Criteria) this;
        }

        public Criteria andUserPermissionIdNotIn(List<Integer> values) {
            addCriterion("user_permission_id not in", values, "userPermissionId");
            return (Criteria) this;
        }

        public Criteria andUserPermissionIdBetween(Integer value1, Integer value2) {
            addCriterion("user_permission_id between", value1, value2, "userPermissionId");
            return (Criteria) this;
        }

        public Criteria andUserPermissionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_permission_id not between", value1, value2, "userPermissionId");
            return (Criteria) this;
        }

        public Criteria andUserStatusIsNull() {
            addCriterion("user_status is null");
            return (Criteria) this;
        }

        public Criteria andUserStatusIsNotNull() {
            addCriterion("user_status is not null");
            return (Criteria) this;
        }

        public Criteria andUserStatusEqualTo(Integer value) {
            addCriterion("user_status =", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotEqualTo(Integer value) {
            addCriterion("user_status <>", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusGreaterThan(Integer value) {
            addCriterion("user_status >", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_status >=", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusLessThan(Integer value) {
            addCriterion("user_status <", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusLessThanOrEqualTo(Integer value) {
            addCriterion("user_status <=", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusIn(List<Integer> values) {
            addCriterion("user_status in", values, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotIn(List<Integer> values) {
            addCriterion("user_status not in", values, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusBetween(Integer value1, Integer value2) {
            addCriterion("user_status between", value1, value2, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("user_status not between", value1, value2, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserParentIdIsNull() {
            addCriterion("user_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andUserParentIdIsNotNull() {
            addCriterion("user_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserParentIdEqualTo(Integer value) {
            addCriterion("user_parent_id =", value, "userParentId");
            return (Criteria) this;
        }

        public Criteria andUserParentIdNotEqualTo(Integer value) {
            addCriterion("user_parent_id <>", value, "userParentId");
            return (Criteria) this;
        }

        public Criteria andUserParentIdGreaterThan(Integer value) {
            addCriterion("user_parent_id >", value, "userParentId");
            return (Criteria) this;
        }

        public Criteria andUserParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_parent_id >=", value, "userParentId");
            return (Criteria) this;
        }

        public Criteria andUserParentIdLessThan(Integer value) {
            addCriterion("user_parent_id <", value, "userParentId");
            return (Criteria) this;
        }

        public Criteria andUserParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_parent_id <=", value, "userParentId");
            return (Criteria) this;
        }

        public Criteria andUserParentIdIn(List<Integer> values) {
            addCriterion("user_parent_id in", values, "userParentId");
            return (Criteria) this;
        }

        public Criteria andUserParentIdNotIn(List<Integer> values) {
            addCriterion("user_parent_id not in", values, "userParentId");
            return (Criteria) this;
        }

        public Criteria andUserParentIdBetween(Integer value1, Integer value2) {
            addCriterion("user_parent_id between", value1, value2, "userParentId");
            return (Criteria) this;
        }

        public Criteria andUserParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_parent_id not between", value1, value2, "userParentId");
            return (Criteria) this;
        }

        public Criteria andUserExtend1IsNull() {
            addCriterion("user_extend1 is null");
            return (Criteria) this;
        }

        public Criteria andUserExtend1IsNotNull() {
            addCriterion("user_extend1 is not null");
            return (Criteria) this;
        }

        public Criteria andUserExtend1EqualTo(String value) {
            addCriterion("user_extend1 =", value, "userExtend1");
            return (Criteria) this;
        }

        public Criteria andUserExtend1NotEqualTo(String value) {
            addCriterion("user_extend1 <>", value, "userExtend1");
            return (Criteria) this;
        }

        public Criteria andUserExtend1GreaterThan(String value) {
            addCriterion("user_extend1 >", value, "userExtend1");
            return (Criteria) this;
        }

        public Criteria andUserExtend1GreaterThanOrEqualTo(String value) {
            addCriterion("user_extend1 >=", value, "userExtend1");
            return (Criteria) this;
        }

        public Criteria andUserExtend1LessThan(String value) {
            addCriterion("user_extend1 <", value, "userExtend1");
            return (Criteria) this;
        }

        public Criteria andUserExtend1LessThanOrEqualTo(String value) {
            addCriterion("user_extend1 <=", value, "userExtend1");
            return (Criteria) this;
        }

        public Criteria andUserExtend1Like(String value) {
            addCriterion("user_extend1 like", value, "userExtend1");
            return (Criteria) this;
        }

        public Criteria andUserExtend1NotLike(String value) {
            addCriterion("user_extend1 not like", value, "userExtend1");
            return (Criteria) this;
        }

        public Criteria andUserExtend1In(List<String> values) {
            addCriterion("user_extend1 in", values, "userExtend1");
            return (Criteria) this;
        }

        public Criteria andUserExtend1NotIn(List<String> values) {
            addCriterion("user_extend1 not in", values, "userExtend1");
            return (Criteria) this;
        }

        public Criteria andUserExtend1Between(String value1, String value2) {
            addCriterion("user_extend1 between", value1, value2, "userExtend1");
            return (Criteria) this;
        }

        public Criteria andUserExtend1NotBetween(String value1, String value2) {
            addCriterion("user_extend1 not between", value1, value2, "userExtend1");
            return (Criteria) this;
        }

        public Criteria andUserExtend2IsNull() {
            addCriterion("user_extend2 is null");
            return (Criteria) this;
        }

        public Criteria andUserExtend2IsNotNull() {
            addCriterion("user_extend2 is not null");
            return (Criteria) this;
        }

        public Criteria andUserExtend2EqualTo(String value) {
            addCriterion("user_extend2 =", value, "userExtend2");
            return (Criteria) this;
        }

        public Criteria andUserExtend2NotEqualTo(String value) {
            addCriterion("user_extend2 <>", value, "userExtend2");
            return (Criteria) this;
        }

        public Criteria andUserExtend2GreaterThan(String value) {
            addCriterion("user_extend2 >", value, "userExtend2");
            return (Criteria) this;
        }

        public Criteria andUserExtend2GreaterThanOrEqualTo(String value) {
            addCriterion("user_extend2 >=", value, "userExtend2");
            return (Criteria) this;
        }

        public Criteria andUserExtend2LessThan(String value) {
            addCriterion("user_extend2 <", value, "userExtend2");
            return (Criteria) this;
        }

        public Criteria andUserExtend2LessThanOrEqualTo(String value) {
            addCriterion("user_extend2 <=", value, "userExtend2");
            return (Criteria) this;
        }

        public Criteria andUserExtend2Like(String value) {
            addCriterion("user_extend2 like", value, "userExtend2");
            return (Criteria) this;
        }

        public Criteria andUserExtend2NotLike(String value) {
            addCriterion("user_extend2 not like", value, "userExtend2");
            return (Criteria) this;
        }

        public Criteria andUserExtend2In(List<String> values) {
            addCriterion("user_extend2 in", values, "userExtend2");
            return (Criteria) this;
        }

        public Criteria andUserExtend2NotIn(List<String> values) {
            addCriterion("user_extend2 not in", values, "userExtend2");
            return (Criteria) this;
        }

        public Criteria andUserExtend2Between(String value1, String value2) {
            addCriterion("user_extend2 between", value1, value2, "userExtend2");
            return (Criteria) this;
        }

        public Criteria andUserExtend2NotBetween(String value1, String value2) {
            addCriterion("user_extend2 not between", value1, value2, "userExtend2");
            return (Criteria) this;
        }

        public Criteria andUserExtend3IsNull() {
            addCriterion("user_extend3 is null");
            return (Criteria) this;
        }

        public Criteria andUserExtend3IsNotNull() {
            addCriterion("user_extend3 is not null");
            return (Criteria) this;
        }

        public Criteria andUserExtend3EqualTo(String value) {
            addCriterion("user_extend3 =", value, "userExtend3");
            return (Criteria) this;
        }

        public Criteria andUserExtend3NotEqualTo(String value) {
            addCriterion("user_extend3 <>", value, "userExtend3");
            return (Criteria) this;
        }

        public Criteria andUserExtend3GreaterThan(String value) {
            addCriterion("user_extend3 >", value, "userExtend3");
            return (Criteria) this;
        }

        public Criteria andUserExtend3GreaterThanOrEqualTo(String value) {
            addCriterion("user_extend3 >=", value, "userExtend3");
            return (Criteria) this;
        }

        public Criteria andUserExtend3LessThan(String value) {
            addCriterion("user_extend3 <", value, "userExtend3");
            return (Criteria) this;
        }

        public Criteria andUserExtend3LessThanOrEqualTo(String value) {
            addCriterion("user_extend3 <=", value, "userExtend3");
            return (Criteria) this;
        }

        public Criteria andUserExtend3Like(String value) {
            addCriterion("user_extend3 like", value, "userExtend3");
            return (Criteria) this;
        }

        public Criteria andUserExtend3NotLike(String value) {
            addCriterion("user_extend3 not like", value, "userExtend3");
            return (Criteria) this;
        }

        public Criteria andUserExtend3In(List<String> values) {
            addCriterion("user_extend3 in", values, "userExtend3");
            return (Criteria) this;
        }

        public Criteria andUserExtend3NotIn(List<String> values) {
            addCriterion("user_extend3 not in", values, "userExtend3");
            return (Criteria) this;
        }

        public Criteria andUserExtend3Between(String value1, String value2) {
            addCriterion("user_extend3 between", value1, value2, "userExtend3");
            return (Criteria) this;
        }

        public Criteria andUserExtend3NotBetween(String value1, String value2) {
            addCriterion("user_extend3 not between", value1, value2, "userExtend3");
            return (Criteria) this;
        }

        public Criteria andUserExtend4IsNull() {
            addCriterion("user_extend4 is null");
            return (Criteria) this;
        }

        public Criteria andUserExtend4IsNotNull() {
            addCriterion("user_extend4 is not null");
            return (Criteria) this;
        }

        public Criteria andUserExtend4EqualTo(String value) {
            addCriterion("user_extend4 =", value, "userExtend4");
            return (Criteria) this;
        }

        public Criteria andUserExtend4NotEqualTo(String value) {
            addCriterion("user_extend4 <>", value, "userExtend4");
            return (Criteria) this;
        }

        public Criteria andUserExtend4GreaterThan(String value) {
            addCriterion("user_extend4 >", value, "userExtend4");
            return (Criteria) this;
        }

        public Criteria andUserExtend4GreaterThanOrEqualTo(String value) {
            addCriterion("user_extend4 >=", value, "userExtend4");
            return (Criteria) this;
        }

        public Criteria andUserExtend4LessThan(String value) {
            addCriterion("user_extend4 <", value, "userExtend4");
            return (Criteria) this;
        }

        public Criteria andUserExtend4LessThanOrEqualTo(String value) {
            addCriterion("user_extend4 <=", value, "userExtend4");
            return (Criteria) this;
        }

        public Criteria andUserExtend4Like(String value) {
            addCriterion("user_extend4 like", value, "userExtend4");
            return (Criteria) this;
        }

        public Criteria andUserExtend4NotLike(String value) {
            addCriterion("user_extend4 not like", value, "userExtend4");
            return (Criteria) this;
        }

        public Criteria andUserExtend4In(List<String> values) {
            addCriterion("user_extend4 in", values, "userExtend4");
            return (Criteria) this;
        }

        public Criteria andUserExtend4NotIn(List<String> values) {
            addCriterion("user_extend4 not in", values, "userExtend4");
            return (Criteria) this;
        }

        public Criteria andUserExtend4Between(String value1, String value2) {
            addCriterion("user_extend4 between", value1, value2, "userExtend4");
            return (Criteria) this;
        }

        public Criteria andUserExtend4NotBetween(String value1, String value2) {
            addCriterion("user_extend4 not between", value1, value2, "userExtend4");
            return (Criteria) this;
        }

        public Criteria andUserExtend5IsNull() {
            addCriterion("user_extend5 is null");
            return (Criteria) this;
        }

        public Criteria andUserExtend5IsNotNull() {
            addCriterion("user_extend5 is not null");
            return (Criteria) this;
        }

        public Criteria andUserExtend5EqualTo(String value) {
            addCriterion("user_extend5 =", value, "userExtend5");
            return (Criteria) this;
        }

        public Criteria andUserExtend5NotEqualTo(String value) {
            addCriterion("user_extend5 <>", value, "userExtend5");
            return (Criteria) this;
        }

        public Criteria andUserExtend5GreaterThan(String value) {
            addCriterion("user_extend5 >", value, "userExtend5");
            return (Criteria) this;
        }

        public Criteria andUserExtend5GreaterThanOrEqualTo(String value) {
            addCriterion("user_extend5 >=", value, "userExtend5");
            return (Criteria) this;
        }

        public Criteria andUserExtend5LessThan(String value) {
            addCriterion("user_extend5 <", value, "userExtend5");
            return (Criteria) this;
        }

        public Criteria andUserExtend5LessThanOrEqualTo(String value) {
            addCriterion("user_extend5 <=", value, "userExtend5");
            return (Criteria) this;
        }

        public Criteria andUserExtend5Like(String value) {
            addCriterion("user_extend5 like", value, "userExtend5");
            return (Criteria) this;
        }

        public Criteria andUserExtend5NotLike(String value) {
            addCriterion("user_extend5 not like", value, "userExtend5");
            return (Criteria) this;
        }

        public Criteria andUserExtend5In(List<String> values) {
            addCriterion("user_extend5 in", values, "userExtend5");
            return (Criteria) this;
        }

        public Criteria andUserExtend5NotIn(List<String> values) {
            addCriterion("user_extend5 not in", values, "userExtend5");
            return (Criteria) this;
        }

        public Criteria andUserExtend5Between(String value1, String value2) {
            addCriterion("user_extend5 between", value1, value2, "userExtend5");
            return (Criteria) this;
        }

        public Criteria andUserExtend5NotBetween(String value1, String value2) {
            addCriterion("user_extend5 not between", value1, value2, "userExtend5");
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