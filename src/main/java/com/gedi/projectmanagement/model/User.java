package com.gedi.projectmanagement.model;

public class User {
    private Integer userId;

    private String uTeleNumber;

    private String uName;

    private String uDepartment;

    private String uSign;

    private Integer uStatus;

    public User() {
    }

    public User(Integer userId, String uTeleNumber, String uName, String uDepartment, String uSign, Integer uStatus) {
        this.userId = userId;
        this.uTeleNumber = uTeleNumber;
        this.uName = uName;
        this.uDepartment = uDepartment;
        this.uSign = uSign;
        this.uStatus = uStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getuTeleNumber() {
        return uTeleNumber;
    }

    public void setuTeleNumber(String uTeleNumber) {
        this.uTeleNumber = uTeleNumber;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuDepartment() {
        return uDepartment;
    }

    public void setuDepartment(String uDepartment) {
        this.uDepartment = uDepartment;
    }

    public String getuSign() {
        return uSign;
    }

    public void setuSign(String uSign) {
        this.uSign = uSign;
    }

    public Integer getuStatus() {
        return uStatus;
    }

    public void setuStatus(Integer uStatus) {
        this.uStatus = uStatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", uTeleNumber='" + uTeleNumber + '\'' +
                ", uName='" + uName + '\'' +
                ", uDepartment='" + uDepartment + '\'' +
                ", uSign='" + uSign + '\'' +
                ", uStatus=" + uStatus +
                '}';
    }
}