package com.javajaider;

public class UserModel {

    String userName;
    String fullName;
    String hashedPassword;
    String saltPassword;

    public UserModel() {
    }

    public UserModel(String userName, String fullName, String hashedPassword, String saltPassword) {
        this.userName = userName;
        this.fullName = fullName;
        this.hashedPassword = hashedPassword;
        this.saltPassword = saltPassword;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getHashedPassword() {
        return this.hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getSaltPassword() {
        return this.saltPassword;
    }

    public void setSaltPassword(String saltPassword) {
        this.saltPassword = saltPassword;
    }

    public UserModel userName(String userName) {
        setUserName(userName);
        return this;
    }

    public UserModel fullName(String fullName) {
        setFullName(fullName);
        return this;
    }

    public UserModel hashedPassword(String hashedPassword) {
        setHashedPassword(hashedPassword);
        return this;
    }

    public UserModel saltPassword(String saltPassword) {
        setSaltPassword(saltPassword);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " userName='" + getUserName() + "'" +
                ", fullName='" + getFullName() + "'" +
                ", hashedPassword='" + getHashedPassword() + "'" +
                ", saltPassword='" + getSaltPassword() + "'" +
                "}";
    }

}
