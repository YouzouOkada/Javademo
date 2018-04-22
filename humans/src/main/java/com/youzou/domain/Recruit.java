package com.youzou.domain;

import java.io.Serializable;

/**
 * Created by 葉蔵 on 2018/4/20.
 * 招聘信息表
 */
public class Recruit implements Serializable {
    private long recId;//招聘信息编号
    private String recPosiName;//职位
    private double recSal;//工资
    private String recDeal;//待遇
    private int recNum;//招聘人数 默认1
    private String recReq;//条件

    public Recruit() {
    }

    public long getRecId() {

        return recId;
    }

    public void setRecId(long recId) {
        this.recId = recId;
    }

    public String getRecPosiName() {
        return recPosiName;
    }

    public void setRecPosiName(String recPosiName) {
        this.recPosiName = recPosiName;
    }

    public double getRecSal() {
        return recSal;
    }

    public void setRecSal(double recSal) {
        this.recSal = recSal;
    }

    public String getRecDeal() {
        return recDeal;
    }

    public void setRecDeal(String recDeal) {
        this.recDeal = recDeal;
    }

    public int getRecNum() {
        return recNum;
    }

    public void setRecNum(int recNum) {
        this.recNum = recNum;
    }

    public String getRecReq() {
        return recReq;
    }

    public void setRecReq(String recReq) {
        this.recReq = recReq;
    }

    @Override
    public String toString() {
        return "Recruit{" +
                "recId=" + recId +
                ", recPosiName='" + recPosiName + '\'' +
                ", recSal=" + recSal +
                ", recDeal='" + recDeal + '\'' +
                ", recNum=" + recNum +
                ", recReq='" + recReq + '\'' +
                '}';
    }
}
