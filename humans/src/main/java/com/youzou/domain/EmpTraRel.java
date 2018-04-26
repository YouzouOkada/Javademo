package com.youzou.domain;

import java.io.Serializable;

/**
 * Created by 葉蔵 on 2018/4/20.
 * 员工-培训 关系表
 */
public class EmpTraRel implements Serializable {
    private long etrId;//关系编号
    private Employee employee;//员工信息
    private Train train;//培训信息
    private int etrTraStat;//培训状态  0:未完成 1:完成

    public EmpTraRel() {
    }

    public long getEtrId() {

        return etrId;
    }

    public void setEtrId(long etrId) {
        this.etrId = etrId;
    }

    public int getEtrTraStat() {
        return etrTraStat;
    }

    public void setEtrTraStat(int etrTraStat) {
        this.etrTraStat = etrTraStat;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    @Override
    public String toString() {
        return "EmpTraRel{" +
                "etrId=" + etrId +
                ", employee=" + employee +
                ", train=" + train +
                ", etrTraStat=" + etrTraStat +
                '}';
    }
}
