package com.jyr.iot.platform.pojo;

import java.util.Date;

public class OperationLog {
    private Integer operationId;

    private Date operationTime;

    private Integer operationType;

    private Integer operationDeviceId;

    private Integer operationUserId;

    private Integer operationResult;

    private String operationExtend1;

    private String operationExtend2;

    private String operationExtend3;

    private String operationExtend4;

    private String operationExtend5;

    public Integer getOperationId() {
        return operationId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }

    public Integer getOperationDeviceId() {
        return operationDeviceId;
    }

    public void setOperationDeviceId(Integer operationDeviceId) {
        this.operationDeviceId = operationDeviceId;
    }

    public Integer getOperationUserId() {
        return operationUserId;
    }

    public void setOperationUserId(Integer operationUserId) {
        this.operationUserId = operationUserId;
    }

    public Integer getOperationResult() {
        return operationResult;
    }

    public void setOperationResult(Integer operationResult) {
        this.operationResult = operationResult;
    }

    public String getOperationExtend1() {
        return operationExtend1;
    }

    public void setOperationExtend1(String operationExtend1) {
        this.operationExtend1 = operationExtend1 == null ? null : operationExtend1.trim();
    }

    public String getOperationExtend2() {
        return operationExtend2;
    }

    public void setOperationExtend2(String operationExtend2) {
        this.operationExtend2 = operationExtend2 == null ? null : operationExtend2.trim();
    }

    public String getOperationExtend3() {
        return operationExtend3;
    }

    public void setOperationExtend3(String operationExtend3) {
        this.operationExtend3 = operationExtend3 == null ? null : operationExtend3.trim();
    }

    public String getOperationExtend4() {
        return operationExtend4;
    }

    public void setOperationExtend4(String operationExtend4) {
        this.operationExtend4 = operationExtend4 == null ? null : operationExtend4.trim();
    }

    public String getOperationExtend5() {
        return operationExtend5;
    }

    public void setOperationExtend5(String operationExtend5) {
        this.operationExtend5 = operationExtend5 == null ? null : operationExtend5.trim();
    }
}