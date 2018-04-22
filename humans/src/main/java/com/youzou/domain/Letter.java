package com.youzou.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 葉蔵 on 2018/4/20.
 * 消息表
 */
public class Letter implements Serializable {
    private long letId;//消息编号
    private int letType;//收件人类型 0:管理员 1:员工 2:游客
    private long letRecId;//收件人编号
    private  int letStat;//消息状态
    private String letCon;//消息正文
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date letDate;//发出时间

    public Letter() {
    }

    public long getLetId() {

        return letId;
    }

    public void setLetId(long letId) {
        this.letId = letId;
    }

    public int getLetType() {
        return letType;
    }

    public void setLetType(int letType) {
        this.letType = letType;
    }

    public long getLetRecId() {
        return letRecId;
    }

    public void setLetRecId(long letRecId) {
        this.letRecId = letRecId;
    }

    public int getLetStat() {
        return letStat;
    }

    public void setLetStat(int letStat) {
        this.letStat = letStat;
    }

    public String getLetCon() {
        return letCon;
    }

    public void setLetCon(String letCon) {
        this.letCon = letCon;
    }

    public Date getLetDate() {
        return letDate;
    }

    public void setLetDate(Date letDate) {
        this.letDate = letDate;
    }

    @Override
    public String toString() {
        return "Letter{" +
                "letId=" + letId +
                ", letType=" + letType +
                ", letRecId=" + letRecId +
                ", letStat=" + letStat +
                ", letCon='" + letCon + '\'' +
                ", letDate=" + letDate +
                '}';
    }
}
