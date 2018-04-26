package com.youzou.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by 葉蔵 on 2018/4/20.
 * 员工表
 */
public class Employee implements Serializable {
    private long empId;//员工编号
    private long empDeptId;//部门编号
    private long empPosiId;//职位编号
    private int empStat;//工作状态 0:在职 1:试用期 2:离职
    private String empLeaRea;//离职原因 emp_stat=2才有，其他情况为空
    private String empPass;//密码 同游客密码
    private String empPhone;//手机号 简历中手机号
    private int empAttend;//出勤天数
    private Guest guest;//原始游客信息
    private List<Letter> letters;//消息
    private Resume resume;//员工简历
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date empJoinDate;//入职日期

    public Employee() {
    }

    public Employee(String empPass, String empPhone) {
        this.empPass = empPass;
        this.empPhone = empPhone;
    }

    public Employee(long empId) {
        this.empId = empId;
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

    public List<Letter> getLetters() {
        return letters;
    }

    public void setLetters(List<Letter> letters) {
        this.letters = letters;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public Date getEmpJoinDate() {
        return empJoinDate;
    }

    public void setEmpJoinDate(Date empJoinDate) {
        this.empJoinDate = empJoinDate;
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
                ", guest=" + guest +
                ", letters=" + letters +
                ", empJoinDate=" + empJoinDate +
                '}';
    }
}
