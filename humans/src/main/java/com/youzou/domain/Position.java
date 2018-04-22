package com.youzou.domain;

import java.io.Serializable;

/**
 * Created by 葉蔵 on 2018/4/20.
 * 职位表
 */
public class Position implements Serializable {
    private long posiId;//职位编号
    private long posiDeptId;//部门编号
    private String posiName;//职位名称
    private double posiBaseSal;//基本工资

    public Position() {
    }

    public long getPosiId() {

        return posiId;
    }

    public void setPosiId(long posiId) {
        this.posiId = posiId;
    }

    public long getPosiDeptId() {
        return posiDeptId;
    }

    public void setPosiDeptId(long posiDeptId) {
        this.posiDeptId = posiDeptId;
    }

    public String getPosiName() {
        return posiName;
    }

    public void setPosiName(String posiName) {
        this.posiName = posiName;
    }

    public double getPosiBaseSal() {
        return posiBaseSal;
    }

    public void setPosiBaseSal(double posiBaseSal) {
        this.posiBaseSal = posiBaseSal;
    }

    @Override
    public String toString() {
        return "Position{" +
                "posiId=" + posiId +
                ", posiDeptId=" + posiDeptId +
                ", posiName='" + posiName + '\'' +
                ", posiBaseSal=" + posiBaseSal +
                '}';
    }
}
