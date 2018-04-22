package com.youzou.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 葉蔵 on 2018/4/20.
 * 管理员表
 */
public class Manager implements Serializable{
    private long manId;//管理员编号
    private String manAccount;//账号 不得超过10位
    private String manPass;//密码

    public Manager() {
    }

    public Manager(String manAccount, String manPass) {
        this.manAccount = manAccount;
        this.manPass = manPass;
    }

    public Long getManId() {
        return manId;
    }

    public void setManId(Long manId) {
        this.manId = manId;
    }

    public String getManAccount() {
        return manAccount;
    }

    public void setManAccount(String manAccount) {
        this.manAccount = manAccount;
    }

    public String getManPass() {
        return manPass;
    }

    public void setManPass(String manPass) {
        this.manPass = manPass;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "manId=" + manId +
                ", manAccount='" + manAccount + '\'' +
                ", manPass='" + manPass + '\'' +
                '}';
    }
}
