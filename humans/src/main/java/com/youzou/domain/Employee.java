package com.youzou.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
public class Employee implements Serializable {
    private long empId;//员工编号
    private long empDeptId;//部门编号
    private long empPosiId;//职位编号
    private int empStat;//工作状态 0:在职 1:试用期 2:离职
    private String empLeaRea;//离职原因
    private String empPass;//密码
    private String empPhone;//手机号
    private int empAttend;//出勤天数

    public Employee() {
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public long getEmpDeptId() {
        return empDeptId;
    }

    public void setEmpDeptId(long empDeptId) {
        this.empDeptId = empDeptId;
    }

    public long getEmpPosiId() {
        return empPosiId;
    }

    public void setEmpPosiId(long empPosiId) {
        this.empPosiId = empPosiId;
    }

    public int getEmpStat() {
        return empStat;
    }

    public void setEmpStat(int empStat) {
        this.empStat = empStat;
    }

    public String getEmpLeaRea() {
        return empLeaRea;
    }

    public void setEmpLeaRea(String empLeaRea) {
        this.empLeaRea = empLeaRea;
    }

    public String getEmpPass() {
        return empPass;
    }

    public void setEmpPass(String empPass) {
        this.empPass = empPass;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public int getEmpAttend() {
        return empAttend;
    }

    public void setEmpAttend(int empAttend) {
        this.empAttend = empAttend;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empDeptId=" + empDeptId +
                ", empPosiId=" + empPosiId +
                ", empStat=" + empStat +
                ", empLeaRea='" + empLeaRea + '\'' +
                ", empPass='" + empPass + '\'' +
                ", empPhone='" + empPhone + '\'' +
                ", empAttend=" + empAttend +
                '}';
    }
}
