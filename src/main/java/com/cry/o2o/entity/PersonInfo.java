package com.cry.o2o.entity;

import java.util.Date;

/**
 * 用户
 * @author CRY
 *
 */
public class PersonInfo {

    /**用户id*/
    private Long userId;

    /**用户名称*/
    private String name;

    /**头像*/
    private String profileImg;

    /**邮箱*/
    private String email;

    /**性别*/
    private String gender;

    /**帐号状态 0:禁止使用商城，1:允许使用商城*/
    private Integer enableStatus;

    /**1.顾客 2.店家 3.超管*/
    private Integer userType;

    /**创建时间*/
    private Date createTime;

    /**最后更新时间*/
    private Date lastEditTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PersonInfo [userId=");
        builder.append(userId);
        builder.append(", name=");
        builder.append(name);
        builder.append(", profileImg=");
        builder.append(profileImg);
        builder.append(", email=");
        builder.append(email);
        builder.append(", gender=");
        builder.append(gender);
        builder.append(", enableStatus=");
        builder.append(enableStatus);
        builder.append(", userType=");
        builder.append(userType);
        builder.append(", createTime=");
        builder.append(createTime);
        builder.append(", lastEditTime=");
        builder.append(lastEditTime);
        builder.append("]");
        return builder.toString();
    }

}
