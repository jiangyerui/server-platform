package com.jyr.iot.platform.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Project {
    private Integer projectId;

    private String projectName;

    private String projectIntroduce;

    private Integer projectCompanyId;

    private Integer projectUserId;

    private String projectProvince;

    private String projectCity;

    private String projectCounty;

    private String projectAddress;

    private String projectLongitude;

    private String projectLatitude;

    private String projectImg;

    private String projectCad;

    private String project3durl;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date projectStartTime;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date projectExpireTime;

    private Integer projectNotify;

    private Integer projectPermissionStatus;

    private Integer projectUseStatus;

    private Integer projectDeviceStatus;

    private Integer projectIsOpen;

    private String projectExtend1;

    private String projectExtend2;

    private String projectExtend3;

    private String projectExtend4;

    private String projectExtend5;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectIntroduce() {
        return projectIntroduce;
    }

    public void setProjectIntroduce(String projectIntroduce) {
        this.projectIntroduce = projectIntroduce == null ? null : projectIntroduce.trim();
    }

    public Integer getProjectCompanyId() {
        return projectCompanyId;
    }

    public void setProjectCompanyId(Integer projectCompanyId) {
        this.projectCompanyId = projectCompanyId;
    }

    public Integer getProjectUserId() {
        return projectUserId;
    }

    public void setProjectUserId(Integer projectUserId) {
        this.projectUserId = projectUserId;
    }

    public String getProjectProvince() {
        return projectProvince;
    }

    public void setProjectProvince(String projectProvince) {
        this.projectProvince = projectProvince == null ? null : projectProvince.trim();
    }

    public String getProjectCity() {
        return projectCity;
    }

    public void setProjectCity(String projectCity) {
        this.projectCity = projectCity == null ? null : projectCity.trim();
    }

    public String getProjectCounty() {
        return projectCounty;
    }

    public void setProjectCounty(String projectCounty) {
        this.projectCounty = projectCounty == null ? null : projectCounty.trim();
    }

    public String getProjectAddress() {
        return projectAddress;
    }

    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress == null ? null : projectAddress.trim();
    }

    public String getProjectLongitude() {
        return projectLongitude;
    }

    public void setProjectLongitude(String projectLongitude) {
        this.projectLongitude = projectLongitude == null ? null : projectLongitude.trim();
    }

    public String getProjectLatitude() {
        return projectLatitude;
    }

    public void setProjectLatitude(String projectLatitude) {
        this.projectLatitude = projectLatitude == null ? null : projectLatitude.trim();
    }

    public String getProjectImg() {
        return projectImg;
    }

    public void setProjectImg(String projectImg) {
        this.projectImg = projectImg == null ? null : projectImg.trim();
    }

    public String getProjectCad() {
        return projectCad;
    }

    public void setProjectCad(String projectCad) {
        this.projectCad = projectCad == null ? null : projectCad.trim();
    }

    public String getProject3durl() {
        return project3durl;
    }

    public void setProject3durl(String project3durl) {
        this.project3durl = project3durl == null ? null : project3durl.trim();
    }

    public Date getProjectStartTime() {
        return projectStartTime;
    }

    public void setProjectStartTime(Date projectStartTime) {
        this.projectStartTime = projectStartTime;
    }

    public Date getProjectExpireTime() {
        return projectExpireTime;
    }

    public void setProjectExpireTime(Date projectExpireTime) {
        this.projectExpireTime = projectExpireTime;
    }

    public Integer getProjectNotify() {
        return projectNotify;
    }

    public void setProjectNotify(Integer projectNotify) {
        this.projectNotify = projectNotify;
    }

    public Integer getProjectPermissionStatus() {
        return projectPermissionStatus;
    }

    public void setProjectPermissionStatus(Integer projectPermissionStatus) {
        this.projectPermissionStatus = projectPermissionStatus;
    }

    public Integer getProjectUseStatus() {
        return projectUseStatus;
    }

    public void setProjectUseStatus(Integer projectUseStatus) {
        this.projectUseStatus = projectUseStatus;
    }

    public Integer getProjectDeviceStatus() {
        return projectDeviceStatus;
    }

    public void setProjectDeviceStatus(Integer projectDeviceStatus) {
        this.projectDeviceStatus = projectDeviceStatus;
    }

    public Integer getProjectIsOpen() {
        return projectIsOpen;
    }

    public void setProjectIsOpen(Integer projectIsOpen) {
        this.projectIsOpen = projectIsOpen;
    }

    public String getProjectExtend1() {
        return projectExtend1;
    }

    public void setProjectExtend1(String projectExtend1) {
        this.projectExtend1 = projectExtend1 == null ? null : projectExtend1.trim();
    }

    public String getProjectExtend2() {
        return projectExtend2;
    }

    public void setProjectExtend2(String projectExtend2) {
        this.projectExtend2 = projectExtend2 == null ? null : projectExtend2.trim();
    }

    public String getProjectExtend3() {
        return projectExtend3;
    }

    public void setProjectExtend3(String projectExtend3) {
        this.projectExtend3 = projectExtend3 == null ? null : projectExtend3.trim();
    }

    public String getProjectExtend4() {
        return projectExtend4;
    }

    public void setProjectExtend4(String projectExtend4) {
        this.projectExtend4 = projectExtend4 == null ? null : projectExtend4.trim();
    }

    public String getProjectExtend5() {
        return projectExtend5;
    }

    public void setProjectExtend5(String projectExtend5) {
        this.projectExtend5 = projectExtend5 == null ? null : projectExtend5.trim();
    }
}