package com.youzou.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 葉蔵 on 2018/4/20.
 * 简历表
 */
public class Resume implements Serializable {
    private long resId;//简历编号
    private long resGuId;//游客编号
    private String resName;//姓名
    private int resGend;//性别 0:男 1:女
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date resBirth;//出生日期
    private String resPhone;//手机号 成为员工时登陆用
    private String resEmail;//电子邮箱 ^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$
    private String resLoc;//籍贯
    private int resEdu;//教育经历 0:博士 1:硕士 2:本科 3:大专 4:高中/高职 5:初中/中专 6:小学及以下
    private int resExp;//工作年限
    private String resDesc;//自我描述

    public Resume() {
    }

    public long getResId() {

        return resId;
    }

    public void setResId(long resId) {
        this.resId = resId;
    }

    public long getResGuId() {
        return resGuId;
    }

    public void setResGuId(long resGuId) {
        this.resGuId = resGuId;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public int getResGend() {
        return resGend;
    }

    public void setResGend(int resGend) {
        this.resGend = resGend;
    }

    public Date getResBirth() {
        return resBirth;
    }

    public void setResBirth(Date resBirth) {
        this.resBirth = resBirth;
    }

    public String getResPhone() {
        return resPhone;
    }

    public void setResPhone(String resPhone) {
        this.resPhone = resPhone;
    }

    public String getResEmail() {
        return resEmail;
    }

    public void setResEmail(String resEmail) {
        this.resEmail = resEmail;
    }

    public String getResLoc() {
        return resLoc;
    }

    public void setResLoc(String resLoc) {
        this.resLoc = resLoc;
    }

    public int getResEdu() {
        return resEdu;
    }

    public void setResEdu(int resEdu) {
        this.resEdu = resEdu;
    }

    public int getResExp() {
        return resExp;
    }

    public void setResExp(int resExp) {
        this.resExp = resExp;
    }

    public String getResDesc() {
        return resDesc;
    }

    public void setResDesc(String resDesc) {
        this.resDesc = resDesc;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "resId=" + resId +
                ", resGuId=" + resGuId +
                ", resName='" + resName + '\'' +
                ", resGend=" + resGend +
                ", resBirth=" + resBirth +
                ", resPhone='" + resPhone + '\'' +
                ", resEmail='" + resEmail + '\'' +
                ", resLoc='" + resLoc + '\'' +
                ", resEdu=" + resEdu +
                ", resExp=" + resExp +
                ", resDesc='" + resDesc + '\'' +
                '}';
    }
}
