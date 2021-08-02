package com.itest.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ChanV
 * @create 2021-08-02-16:50
 */
public class User implements Serializable {

    private int userId;

    private String userAccount;

    private String userPwd;

    private String userName;

    private String userSex;

    private String userEmail;

    private String userImage;

    private String userRole;

    private short isDeleted;

    private Date createTime;

    public User() {
    }

    public User(int userId, String userAccount, String userPwd, String userName, String userSex, String userEmail, String userImage, String userRole, short isDeleted, Date createTime) {
        this.userId = userId;
        this.userAccount = userAccount;
        this.userPwd = userPwd;
        this.userName = userName;
        this.userSex = userSex;
        this.userEmail = userEmail;
        this.userImage = userImage;
        this.userRole = userRole;
        this.isDeleted = isDeleted;
        this.createTime = createTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public short getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(short isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
