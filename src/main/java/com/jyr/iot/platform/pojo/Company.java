package com.jyr.iot.platform.pojo;

public class Company {
    private Integer companyId;

    private String companyName;

    private String companyIntroduce;

    private String companyImg;

    private Integer companyUserId;

    private String companyExtend1;

    private String companyExtend2;

    private String companyExtend3;

    private String companyExtend4;

    private String companyExtend5;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyIntroduce() {
        return companyIntroduce;
    }

    public void setCompanyIntroduce(String companyIntroduce) {
        this.companyIntroduce = companyIntroduce == null ? null : companyIntroduce.trim();
    }

    public String getCompanyImg() {
        return companyImg;
    }

    public void setCompanyImg(String companyImg) {
        this.companyImg = companyImg == null ? null : companyImg.trim();
    }

    public Integer getCompanyUserId() {
        return companyUserId;
    }

    public void setCompanyUserId(Integer companyUserId) {
        this.companyUserId = companyUserId;
    }

    public String getCompanyExtend1() {
        return companyExtend1;
    }

    public void setCompanyExtend1(String companyExtend1) {
        this.companyExtend1 = companyExtend1 == null ? null : companyExtend1.trim();
    }

    public String getCompanyExtend2() {
        return companyExtend2;
    }

    public void setCompanyExtend2(String companyExtend2) {
        this.companyExtend2 = companyExtend2 == null ? null : companyExtend2.trim();
    }

    public String getCompanyExtend3() {
        return companyExtend3;
    }

    public void setCompanyExtend3(String companyExtend3) {
        this.companyExtend3 = companyExtend3 == null ? null : companyExtend3.trim();
    }

    public String getCompanyExtend4() {
        return companyExtend4;
    }

    public void setCompanyExtend4(String companyExtend4) {
        this.companyExtend4 = companyExtend4 == null ? null : companyExtend4.trim();
    }

    public String getCompanyExtend5() {
        return companyExtend5;
    }

    public void setCompanyExtend5(String companyExtend5) {
        this.companyExtend5 = companyExtend5 == null ? null : companyExtend5.trim();
    }
}