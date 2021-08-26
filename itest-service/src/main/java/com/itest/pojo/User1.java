package com.itest.pojo;

public class User1 {
    private int userId;
    private String userNickname;
    private String userInterest;
    private String userAddress;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserInterest() {
        return userInterest;
    }

    public void setUserInterest(String userInterest) {
        this.userInterest = userInterest;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    @Override
    public String toString() {
        return "User1{" +
                "userId=" + userId +
                ", userNickname='" + userNickname + '\'' +
                ", userInterest='" + userInterest + '\'' +
                ", userAddress='" + userAddress + '\'' +
                '}';
    }

    public User1(int userId, String userNickname, String userInterest, String userAddress) {
        this.userId = userId;
        this.userNickname = userNickname;
        this.userInterest = userInterest;
        this.userAddress = userAddress;
    }

    public User1() {
    }
}
