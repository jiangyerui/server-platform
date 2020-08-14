package com.jyr.iot.platform.pojo;

import java.io.Serializable;

public class Device implements Serializable {
    private Integer deviceId;

    private String deviceNo;

    private String deviceName;

    private Integer devicePermission;

    private String deviceType;

    private Integer deviceCompanyId;

    private Integer deviceProjectId;

    private Integer deviceCameraId;

    private Integer deviceStatus;

    private Integer deviceUseStatus;

    private Integer deviceDatatemplateId;

    private String deviceExtend1;

    private String deviceExtend2;

    private String deviceExtend3;

    private String deviceExtend4;

    private String deviceExtend5;

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo == null ? null : deviceNo.trim();
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    public Integer getDevicePermission() {
        return devicePermission;
    }

    public void setDevicePermission(Integer devicePermission) {
        this.devicePermission = devicePermission;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType == null ? null : deviceType.trim();
    }

    public Integer getDeviceCompanyId() {
        return deviceCompanyId;
    }

    public void setDeviceCompanyId(Integer deviceCompanyId) {
        this.deviceCompanyId = deviceCompanyId;
    }

    public Integer getDeviceProjectId() {
        return deviceProjectId;
    }

    public void setDeviceProjectId(Integer deviceProjectId) {
        this.deviceProjectId = deviceProjectId;
    }

    public Integer getDeviceCameraId() {
        return deviceCameraId;
    }

    public void setDeviceCameraId(Integer deviceCameraId) {
        this.deviceCameraId = deviceCameraId;
    }

    public Integer getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(Integer deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public Integer getDeviceUseStatus() {
        return deviceUseStatus;
    }

    public void setDeviceUseStatus(Integer deviceUseStatus) {
        this.deviceUseStatus = deviceUseStatus;
    }

    public Integer getDeviceDatatemplateId() {
        return deviceDatatemplateId;
    }

    public void setDeviceDatatemplateId(Integer deviceDatatemplateId) {
        this.deviceDatatemplateId = deviceDatatemplateId;
    }

    public String getDeviceExtend1() {
        return deviceExtend1;
    }

    public void setDeviceExtend1(String deviceExtend1) {
        this.deviceExtend1 = deviceExtend1 == null ? null : deviceExtend1.trim();
    }

    public String getDeviceExtend2() {
        return deviceExtend2;
    }

    public void setDeviceExtend2(String deviceExtend2) {
        this.deviceExtend2 = deviceExtend2 == null ? null : deviceExtend2.trim();
    }

    public String getDeviceExtend3() {
        return deviceExtend3;
    }

    public void setDeviceExtend3(String deviceExtend3) {
        this.deviceExtend3 = deviceExtend3 == null ? null : deviceExtend3.trim();
    }

    public String getDeviceExtend4() {
        return deviceExtend4;
    }

    public void setDeviceExtend4(String deviceExtend4) {
        this.deviceExtend4 = deviceExtend4 == null ? null : deviceExtend4.trim();
    }

    public String getDeviceExtend5() {
        return deviceExtend5;
    }

    public void setDeviceExtend5(String deviceExtend5) {
        this.deviceExtend5 = deviceExtend5 == null ? null : deviceExtend5.trim();
    }
}