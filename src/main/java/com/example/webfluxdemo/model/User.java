package com.example.webfluxdemo.model;

public class User {

    private Long UserID;
    private String UserName;
    private String MobilePhone;
    private String Password;
    private String FeatureValue;

    public User(){

    }

    public User(long UserID, String UserName){
        this.UserID = UserID;
        this.UserName = UserName;
    }

    public Long getUserID() {
        return UserID;
    }

    public void setUserID(Long userID) {
        UserID = userID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getMobilePhone() {
        return MobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        MobilePhone = mobilePhone;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFeatureValue() {
        return FeatureValue;
    }

    public void setFeatureValue(String featureValue) {
        FeatureValue = featureValue;
    }
}
