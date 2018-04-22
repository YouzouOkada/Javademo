package com.youzou.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 葉蔵 on 2018/4/20.
 * 考勤记录表
 */
public class Attend implements Serializable {
    private long atteId;//考勤编号
    private long atteEmpId;//员工编号
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date atteStart;//上班时间
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date atteOff;//下班时间
    private int atteStat;//考勤状态 0:缺勤 1:迟到早退 2:正常

    public Attend() {
    }

    public long getAtteId() {

        return atteId;
    }

    public void setAtteId(long atteId) {
        this.atteId = atteId;
    }

    public long getAtteEmpId() {
        return atteEmpId;
    }

    public void setAtteEmpId(long atteEmpId) {
        this.atteEmpId = atteEmpId;
    }

    public Date getAtteStart() {
        return atteStart;
    }

    public void setAtteStart(Date atteStart) {
        this.atteStart = atteStart;
    }

    public Date getAtteOff() {
        return atteOff;
    }

    public void setAtteOff(Date atteOff) {
        this.atteOff = atteOff;
    }

    public int getAtteStat() {
        return atteStat;
    }

    public void setAtteStat(int atteStat) {
        this.atteStat = atteStat;
    }

    @Override
    public String toString() {
        return "Attend{" +
                "atteId=" + atteId +
                ", atteEmpId=" + atteEmpId +
                ", atteStart=" + atteStart +
                ", atteOff=" + atteOff +
                ", atteStat=" + atteStat +
                '}';
    }
}
