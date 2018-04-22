package com.youzou.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 葉蔵 on 2018/4/20.
 *部门表
 */
public class Department implements Serializable {
    private long deptId;//部门编号
    private String deptName;//部门名称
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date deptCreDate;//创建日期

    public Department() {
    }

    public long getDeptId() {

        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Date getDeptCreDate() {
        return deptCreDate;
    }

    public void setDeptCreDate(Date deptCreDate) {
        this.deptCreDate = deptCreDate;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", deptCreDate=" + deptCreDate +
                '}';
    }
}
