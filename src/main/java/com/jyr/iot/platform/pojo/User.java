package com.jyr.iot.platform.pojo;

import java.io.Serializable;

public class User  implements Serializable {
    private Integer userId;

    private String userPhone;

    private String userPassword;

    private String userName;

    private Integer userRole;

    private Integer userCompanyId;

    private Integer userProjectId;

    private String userImg;

    private String userMail;

    private Integer userPermissionId;

    private Integer userStatus;

    private Integer userParentId;

    private String userExtend1;

    private String userExtend2;

    private String userExtend3;

    private String userExtend4;

    private String userExtend5;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    public Integer getUserCompanyId() {
        return userCompanyId;
    }

    public void setUserCompanyId(Integer userCompanyId) {
        this.userCompanyId = userCompanyId;
    }

    public Integer getUserProjectId() {
        return userProjectId;
    }

    public void setUserProjectId(Integer userProjectId) {
        this.userProjectId = userProjectId;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg == null ? null : userImg.trim();
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail == null ? null : userMail.trim();
    }

    public Integer getUserPermissionId() {
        return userPermissionId;
    }

    public void setUserPermissionId(Integer userPermissionId) {
        this.userPermissionId = userPermissionId;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getUserParentId() {
        return userParentId;
    }

    public void setUserParentId(Integer userParentId) {
        this.userParentId = userParentId;
    }

    public String getUserExtend1() {
        return userExtend1;
    }

    public void setUserExtend1(String userExtend1) {
        this.userExtend1 = userExtend1 == null ? null : userExtend1.trim();
    }

    public String getUserExtend2() {
        return userExtend2;
    }

    public void setUserExtend2(String userExtend2) {
        this.userExtend2 = userExtend2 == null ? null : userExtend2.trim();
    }

    public String getUserExtend3() {
        return userExtend3;
    }

    public void setUserExtend3(String userExtend3) {
        this.userExtend3 = userExtend3 == null ? null : userExtend3.trim();
    }

    public String getUserExtend4() {
        return userExtend4;
    }

    public void setUserExtend4(String userExtend4) {
        this.userExtend4 = userExtend4 == null ? null : userExtend4.trim();
    }

    public String getUserExtend5() {
        return userExtend5;
    }

    public void setUserExtend5(String userExtend5) {
        this.userExtend5 = userExtend5 == null ? null : userExtend5.trim();
    }
}