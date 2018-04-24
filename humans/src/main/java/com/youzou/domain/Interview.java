package com.youzou.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 葉蔵 on 2018/4/20.
 * 面试表
 */
public class Interview implements Serializable {
    private long inteId;//面试编号
    private long inteGuId;//游客编号
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date inteDate;//面试日期
    private int inteStat;//面试状态 0:未参加 1：确认参加

    public Interview() {
    }

    public long getInteId() {

        return inteId;
    }

    public void setInteId(long inteId) {
        this.inteId = inteId;
    }

    public long getInteGuId() {
        return inteGuId;
    }

    public void setInteGuId(long inteGuId) {
        this.inteGuId = inteGuId;
    }

    public Date getInteDate() {
        return inteDate;
    }

    public void setInteDate(Date inteDate) {
        this.inteDate = inteDate;
    }

    public int getInteStat() {
        return inteStat;
    }

    public void setInteStat(int inteStat) {
        this.inteStat = inteStat;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "inteId=" + inteId +
                ", inteGuId=" + inteGuId +
                ", inteDate=" + inteDate +
                ", inteStat=" + inteStat +
                '}';
    }
}
