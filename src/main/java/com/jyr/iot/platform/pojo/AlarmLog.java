package com.jyr.iot.platform.pojo;

import java.io.Serializable;
import java.util.Date;

public class AlarmLog implements Serializable {
    private Integer alarmId;

    private Date alarmTime;

    private Integer alarmCompanyId;

    private Integer alarmProjectId;

    private Integer alarmDeviceId;

    private Integer alarmL;

    private String alarmName;

    private Integer alarmType;

    private Integer alarmValue;

    private Integer alarmStatus;

    private String alarmSolveResult;

    private Date alarmSolveTime;

    private Integer alarmUserId;

    private String alarmExtend1;

    private String alarmExtend2;

    private String alarmExtend3;

    private String alarmExtend4;

    private String alarmExtend5;

    public Integer getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(Integer alarmId) {
        this.alarmId = alarmId;
    }

    public Date getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(Date alarmTime) {
        this.alarmTime = alarmTime;
    }

    public Integer getAlarmCompanyId() {
        return alarmCompanyId;
    }

    public void setAlarmCompanyId(Integer alarmCompanyId) {
        this.alarmCompanyId = alarmCompanyId;
    }

    public Integer getAlarmProjectId() {
        return alarmProjectId;
    }

    public void setAlarmProjectId(Integer alarmProjectId) {
        this.alarmProjectId = alarmProjectId;
    }

    public Integer getAlarmDeviceId() {
        return alarmDeviceId;
    }

    public void setAlarmDeviceId(Integer alarmDeviceId) {
        this.alarmDeviceId = alarmDeviceId;
    }

    public Integer getAlarmL() {
        return alarmL;
    }

    public void setAlarmL(Integer alarmL) {
        this.alarmL = alarmL;
    }

    public String getAlarmName() {
        return alarmName;
    }

    public void setAlarmName(String alarmName) {
        this.alarmName = alarmName == null ? null : alarmName.trim();
    }

    public Integer getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(Integer alarmType) {
        this.alarmType = alarmType;
    }

    public Integer getAlarmValue() {
        return alarmValue;
    }

    public void setAlarmValue(Integer alarmValue) {
        this.alarmValue = alarmValue;
    }

    public Integer getAlarmStatus() {
        return alarmStatus;
    }

    public void setAlarmStatus(Integer alarmStatus) {
        this.alarmStatus = alarmStatus;
    }

    public String getAlarmSolveResult() {
        return alarmSolveResult;
    }

    public void setAlarmSolveResult(String alarmSolveResult) {
        this.alarmSolveResult = alarmSolveResult == null ? null : alarmSolveResult.trim();
    }

    public Date getAlarmSolveTime() {
        return alarmSolveTime;
    }

    public void setAlarmSolveTime(Date alarmSolveTime) {
        this.alarmSolveTime = alarmSolveTime;
    }

    public Integer getAlarmUserId() {
        return alarmUserId;
    }

    public void setAlarmUserId(Integer alarmUserId) {
        this.alarmUserId = alarmUserId;
    }

    public String getAlarmExtend1() {
        return alarmExtend1;
    }

    public void setAlarmExtend1(String alarmExtend1) {
        this.alarmExtend1 = alarmExtend1 == null ? null : alarmExtend1.trim();
    }

    public String getAlarmExtend2() {
        return alarmExtend2;
    }

    public void setAlarmExtend2(String alarmExtend2) {
        this.alarmExtend2 = alarmExtend2 == null ? null : alarmExtend2.trim();
    }

    public String getAlarmExtend3() {
        return alarmExtend3;
    }

    public void setAlarmExtend3(String alarmExtend3) {
        this.alarmExtend3 = alarmExtend3 == null ? null : alarmExtend3.trim();
    }

    public String getAlarmExtend4() {
        return alarmExtend4;
    }

    public void setAlarmExtend4(String alarmExtend4) {
        this.alarmExtend4 = alarmExtend4 == null ? null : alarmExtend4.trim();
    }

    public String getAlarmExtend5() {
        return alarmExtend5;
    }

    public void setAlarmExtend5(String alarmExtend5) {
        this.alarmExtend5 = alarmExtend5 == null ? null : alarmExtend5.trim();
    }
}