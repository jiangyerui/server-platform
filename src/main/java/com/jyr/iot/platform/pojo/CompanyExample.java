package com.jyr.iot.platform.pojo;

import java.util.ArrayList;
import java.util.List;

public class CompanyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyExample() {
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

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(Integer value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(Integer value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(Integer value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(Integer value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<Integer> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<Integer> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroduceIsNull() {
            addCriterion("company_introduce is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroduceIsNotNull() {
            addCriterion("company_introduce is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroduceEqualTo(String value) {
            addCriterion("company_introduce =", value, "companyIntroduce");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroduceNotEqualTo(String value) {
            addCriterion("company_introduce <>", value, "companyIntroduce");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroduceGreaterThan(String value) {
            addCriterion("company_introduce >", value, "companyIntroduce");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("company_introduce >=", value, "companyIntroduce");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroduceLessThan(String value) {
            addCriterion("company_introduce <", value, "companyIntroduce");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroduceLessThanOrEqualTo(String value) {
            addCriterion("company_introduce <=", value, "companyIntroduce");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroduceLike(String value) {
            addCriterion("company_introduce like", value, "companyIntroduce");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroduceNotLike(String value) {
            addCriterion("company_introduce not like", value, "companyIntroduce");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroduceIn(List<String> values) {
            addCriterion("company_introduce in", values, "companyIntroduce");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroduceNotIn(List<String> values) {
            addCriterion("company_introduce not in", values, "companyIntroduce");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroduceBetween(String value1, String value2) {
            addCriterion("company_introduce between", value1, value2, "companyIntroduce");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroduceNotBetween(String value1, String value2) {
            addCriterion("company_introduce not between", value1, value2, "companyIntroduce");
            return (Criteria) this;
        }

        public Criteria andCompanyImgIsNull() {
            addCriterion("company_img is null");
            return (Criteria) this;
        }

        public Criteria andCompanyImgIsNotNull() {
            addCriterion("company_img is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyImgEqualTo(String value) {
            addCriterion("company_img =", value, "companyImg");
            return (Criteria) this;
        }

        public Criteria andCompanyImgNotEqualTo(String value) {
            addCriterion("company_img <>", value, "companyImg");
            return (Criteria) this;
        }

        public Criteria andCompanyImgGreaterThan(String value) {
            addCriterion("company_img >", value, "companyImg");
            return (Criteria) this;
        }

        public Criteria andCompanyImgGreaterThanOrEqualTo(String value) {
            addCriterion("company_img >=", value, "companyImg");
            return (Criteria) this;
        }

        public Criteria andCompanyImgLessThan(String value) {
            addCriterion("company_img <", value, "companyImg");
            return (Criteria) this;
        }

        public Criteria andCompanyImgLessThanOrEqualTo(String value) {
            addCriterion("company_img <=", value, "companyImg");
            return (Criteria) this;
        }

        public Criteria andCompanyImgLike(String value) {
            addCriterion("company_img like", value, "companyImg");
            return (Criteria) this;
        }

        public Criteria andCompanyImgNotLike(String value) {
            addCriterion("company_img not like", value, "companyImg");
            return (Criteria) this;
        }

        public Criteria andCompanyImgIn(List<String> values) {
            addCriterion("company_img in", values, "companyImg");
            return (Criteria) this;
        }

        public Criteria andCompanyImgNotIn(List<String> values) {
            addCriterion("company_img not in", values, "companyImg");
            return (Criteria) this;
        }

        public Criteria andCompanyImgBetween(String value1, String value2) {
            addCriterion("company_img between", value1, value2, "companyImg");
            return (Criteria) this;
        }

        public Criteria andCompanyImgNotBetween(String value1, String value2) {
            addCriterion("company_img not between", value1, value2, "companyImg");
            return (Criteria) this;
        }

        public Criteria andCompanyUserIdIsNull() {
            addCriterion("company_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyUserIdIsNotNull() {
            addCriterion("company_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyUserIdEqualTo(Integer value) {
            addCriterion("company_user_id =", value, "companyUserId");
            return (Criteria) this;
        }

        public Criteria andCompanyUserIdNotEqualTo(Integer value) {
            addCriterion("company_user_id <>", value, "companyUserId");
            return (Criteria) this;
        }

        public Criteria andCompanyUserIdGreaterThan(Integer value) {
            addCriterion("company_user_id >", value, "companyUserId");
            return (Criteria) this;
        }

        public Criteria andCompanyUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_user_id >=", value, "companyUserId");
            return (Criteria) this;
        }

        public Criteria andCompanyUserIdLessThan(Integer value) {
            addCriterion("company_user_id <", value, "companyUserId");
            return (Criteria) this;
        }

        public Criteria andCompanyUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("company_user_id <=", value, "companyUserId");
            return (Criteria) this;
        }

        public Criteria andCompanyUserIdIn(List<Integer> values) {
            addCriterion("company_user_id in", values, "companyUserId");
            return (Criteria) this;
        }

        public Criteria andCompanyUserIdNotIn(List<Integer> values) {
            addCriterion("company_user_id not in", values, "companyUserId");
            return (Criteria) this;
        }

        public Criteria andCompanyUserIdBetween(Integer value1, Integer value2) {
            addCriterion("company_user_id between", value1, value2, "companyUserId");
            return (Criteria) this;
        }

        public Criteria andCompanyUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("company_user_id not between", value1, value2, "companyUserId");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend1IsNull() {
            addCriterion("company_extend1 is null");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend1IsNotNull() {
            addCriterion("company_extend1 is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend1EqualTo(String value) {
            addCriterion("company_extend1 =", value, "companyExtend1");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend1NotEqualTo(String value) {
            addCriterion("company_extend1 <>", value, "companyExtend1");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend1GreaterThan(String value) {
            addCriterion("company_extend1 >", value, "companyExtend1");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend1GreaterThanOrEqualTo(String value) {
            addCriterion("company_extend1 >=", value, "companyExtend1");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend1LessThan(String value) {
            addCriterion("company_extend1 <", value, "companyExtend1");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend1LessThanOrEqualTo(String value) {
            addCriterion("company_extend1 <=", value, "companyExtend1");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend1Like(String value) {
            addCriterion("company_extend1 like", value, "companyExtend1");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend1NotLike(String value) {
            addCriterion("company_extend1 not like", value, "companyExtend1");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend1In(List<String> values) {
            addCriterion("company_extend1 in", values, "companyExtend1");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend1NotIn(List<String> values) {
            addCriterion("company_extend1 not in", values, "companyExtend1");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend1Between(String value1, String value2) {
            addCriterion("company_extend1 between", value1, value2, "companyExtend1");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend1NotBetween(String value1, String value2) {
            addCriterion("company_extend1 not between", value1, value2, "companyExtend1");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend2IsNull() {
            addCriterion("company_extend2 is null");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend2IsNotNull() {
            addCriterion("company_extend2 is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend2EqualTo(String value) {
            addCriterion("company_extend2 =", value, "companyExtend2");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend2NotEqualTo(String value) {
            addCriterion("company_extend2 <>", value, "companyExtend2");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend2GreaterThan(String value) {
            addCriterion("company_extend2 >", value, "companyExtend2");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend2GreaterThanOrEqualTo(String value) {
            addCriterion("company_extend2 >=", value, "companyExtend2");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend2LessThan(String value) {
            addCriterion("company_extend2 <", value, "companyExtend2");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend2LessThanOrEqualTo(String value) {
            addCriterion("company_extend2 <=", value, "companyExtend2");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend2Like(String value) {
            addCriterion("company_extend2 like", value, "companyExtend2");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend2NotLike(String value) {
            addCriterion("company_extend2 not like", value, "companyExtend2");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend2In(List<String> values) {
            addCriterion("company_extend2 in", values, "companyExtend2");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend2NotIn(List<String> values) {
            addCriterion("company_extend2 not in", values, "companyExtend2");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend2Between(String value1, String value2) {
            addCriterion("company_extend2 between", value1, value2, "companyExtend2");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend2NotBetween(String value1, String value2) {
            addCriterion("company_extend2 not between", value1, value2, "companyExtend2");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend3IsNull() {
            addCriterion("company_extend3 is null");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend3IsNotNull() {
            addCriterion("company_extend3 is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend3EqualTo(String value) {
            addCriterion("company_extend3 =", value, "companyExtend3");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend3NotEqualTo(String value) {
            addCriterion("company_extend3 <>", value, "companyExtend3");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend3GreaterThan(String value) {
            addCriterion("company_extend3 >", value, "companyExtend3");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend3GreaterThanOrEqualTo(String value) {
            addCriterion("company_extend3 >=", value, "companyExtend3");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend3LessThan(String value) {
            addCriterion("company_extend3 <", value, "companyExtend3");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend3LessThanOrEqualTo(String value) {
            addCriterion("company_extend3 <=", value, "companyExtend3");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend3Like(String value) {
            addCriterion("company_extend3 like", value, "companyExtend3");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend3NotLike(String value) {
            addCriterion("company_extend3 not like", value, "companyExtend3");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend3In(List<String> values) {
            addCriterion("company_extend3 in", values, "companyExtend3");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend3NotIn(List<String> values) {
            addCriterion("company_extend3 not in", values, "companyExtend3");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend3Between(String value1, String value2) {
            addCriterion("company_extend3 between", value1, value2, "companyExtend3");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend3NotBetween(String value1, String value2) {
            addCriterion("company_extend3 not between", value1, value2, "companyExtend3");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend4IsNull() {
            addCriterion("company_extend4 is null");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend4IsNotNull() {
            addCriterion("company_extend4 is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend4EqualTo(String value) {
            addCriterion("company_extend4 =", value, "companyExtend4");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend4NotEqualTo(String value) {
            addCriterion("company_extend4 <>", value, "companyExtend4");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend4GreaterThan(String value) {
            addCriterion("company_extend4 >", value, "companyExtend4");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend4GreaterThanOrEqualTo(String value) {
            addCriterion("company_extend4 >=", value, "companyExtend4");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend4LessThan(String value) {
            addCriterion("company_extend4 <", value, "companyExtend4");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend4LessThanOrEqualTo(String value) {
            addCriterion("company_extend4 <=", value, "companyExtend4");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend4Like(String value) {
            addCriterion("company_extend4 like", value, "companyExtend4");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend4NotLike(String value) {
            addCriterion("company_extend4 not like", value, "companyExtend4");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend4In(List<String> values) {
            addCriterion("company_extend4 in", values, "companyExtend4");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend4NotIn(List<String> values) {
            addCriterion("company_extend4 not in", values, "companyExtend4");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend4Between(String value1, String value2) {
            addCriterion("company_extend4 between", value1, value2, "companyExtend4");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend4NotBetween(String value1, String value2) {
            addCriterion("company_extend4 not between", value1, value2, "companyExtend4");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend5IsNull() {
            addCriterion("company_extend5 is null");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend5IsNotNull() {
            addCriterion("company_extend5 is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend5EqualTo(String value) {
            addCriterion("company_extend5 =", value, "companyExtend5");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend5NotEqualTo(String value) {
            addCriterion("company_extend5 <>", value, "companyExtend5");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend5GreaterThan(String value) {
            addCriterion("company_extend5 >", value, "companyExtend5");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend5GreaterThanOrEqualTo(String value) {
            addCriterion("company_extend5 >=", value, "companyExtend5");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend5LessThan(String value) {
            addCriterion("company_extend5 <", value, "companyExtend5");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend5LessThanOrEqualTo(String value) {
            addCriterion("company_extend5 <=", value, "companyExtend5");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend5Like(String value) {
            addCriterion("company_extend5 like", value, "companyExtend5");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend5NotLike(String value) {
            addCriterion("company_extend5 not like", value, "companyExtend5");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend5In(List<String> values) {
            addCriterion("company_extend5 in", values, "companyExtend5");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend5NotIn(List<String> values) {
            addCriterion("company_extend5 not in", values, "companyExtend5");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend5Between(String value1, String value2) {
            addCriterion("company_extend5 between", value1, value2, "companyExtend5");
            return (Criteria) this;
        }

        public Criteria andCompanyExtend5NotBetween(String value1, String value2) {
            addCriterion("company_extend5 not between", value1, value2, "companyExtend5");
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