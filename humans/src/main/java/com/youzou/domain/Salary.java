package com.youzou.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 葉蔵 on 2018/4/20.
 * 薪资表
 */
public class Salary implements Serializable{
    private long salId;//工资编号
    private long salEmpId;//员工编号
    private double salBase;//基本工资
    private double salPer;//绩效奖金
    private double salOver;//加班工资
    private double salRap;//奖惩工资
    private double salSoc;//社保 基本工资的10% 此项为减法
    private double salTot;//实际工资
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date salTime;//发放时间

    public Salary() {
    }

    public long getSalId() {

        return salId;
    }

    public void setSalId(long salId) {
        this.salId = salId;
    }

    public long getSalEmpId() {
        return salEmpId;
    }

    public void setSalEmpId(long salEmpId) {
        this.salEmpId = salEmpId;
    }

    public double getSalBase() {
        return salBase;
    }

    public void setSalBase(double salBase) {
        this.salBase = salBase;
    }

    public double getSalPer() {
        return salPer;
    }

    public void setSalPer(double salPer) {
        this.salPer = salPer;
    }

    public double getSalOver() {
        return salOver;
    }

    public void setSalOver(double salOver) {
        this.salOver = salOver;
    }

    public double getSalRap() {
        return salRap;
    }

    public void setSalRap(double salRap) {
        this.salRap = salRap;
    }

    public double getSalSoc() {
        return salSoc;
    }

    public void setSalSoc(double salSoc) {
        this.salSoc = salSoc;
    }

    public double getSalTot() {
        return salTot;
    }

    public void setSalTot(double salTot) {
        this.salTot = salTot;
    }

    public Date getSalTime() {
        return salTime;
    }

    public void setSalTime(Date salTime) {
        this.salTime = salTime;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "salId=" + salId +
                ", salEmpId=" + salEmpId +
                ", salBase=" + salBase +
                ", salPer=" + salPer +
                ", salOver=" + salOver +
                ", salRap=" + salRap +
                ", salSoc=" + salSoc +
                ", salTot=" + salTot +
                ", salTime=" + salTime +
                '}';
    }
}
