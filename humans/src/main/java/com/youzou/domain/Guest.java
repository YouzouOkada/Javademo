package com.youzou.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by 葉蔵 on 2018/4/20.
 * 游客表
 */
public class Guest implements Serializable{
    private long guId;//游客编号
    private String guPhone;//游客手机号 注册时添加正则判断 ^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[0-9])|(18[0-9]))\\d{8}$
    private String guPass;//游客密码
    private Resume resume;//简历
    private List<Letter> letters;//消息

    public Guest() {
    }

    public Guest(String guPhone, String guPass) {
        this.guPhone = guPhone;
        this.guPass = guPass;
    }

    public Guest(long guId) {
        this.guId = guId;
    }

    public long getGuId() {
        return guId;
    }

    public void setGuId(long guId) {
        this.guId = guId;
    }

    public String getGuPhone() {
        return guPhone;
    }

    public void setGuPhone(String guPhone) {
        this.guPhone = guPhone;
    }

    public String getGuPass() {
        return guPass;
    }

    public void setGuPass(String guPass) {
        this.guPass = guPass;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public List<Letter> getLetters() {
        return letters;
    }

    public void setLetters(List<Letter> letters) {
        this.letters = letters;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "guId=" + guId +
                ", guPhone='" + guPhone + '\'' +
                ", guPass='" + guPass + '\'' +
                '}';
    }
}
