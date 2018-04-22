package com.youzou.domain;

import java.io.Serializable;

/**
 * Created by 葉蔵 on 2018/4/20.
 * 员工-培训 关系表
 */
public class EmpTraRel implements Serializable {
    private long etrId;//关系编号
    private long etrEmpId;//员工编号
    private long etrTraId;//培训编号
    private int etrTraStat;//培训状态  0:未完成 1:完成

    public EmpTraRel() {
    }

    public long getEtrId() {

        return etrId;
    }

    public void setEtrId(long etrId) {
        this.etrId = etrId;
    }

    public long getEtrEmpId() {
        return etrEmpId;
    }

    public void setEtrEmpId(long etrEmpId) {
        this.etrEmpId = etrEmpId;
    }

    public long getEtrTraId() {
        return etrTraId;
    }

    public void setEtrTraId(long etrTraId) {
        this.etrTraId = etrTraId;
    }

    public int getEtrTraStat() {
        return etrTraStat;
    }

    public void setEtrTraStat(int etrTraStat) {
        this.etrTraStat = etrTraStat;
    }

    @Override
    public String toString() {
        return "EmpTraRel{" +
                "etrId=" + etrId +
                ", etrEmpId=" + etrEmpId +
                ", etrTraId=" + etrTraId +
                ", etrTraStat=" + etrTraStat +
                '}';
    }
}
