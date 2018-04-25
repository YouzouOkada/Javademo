package com.youzou.domain;

import java.io.Serializable;

/**
 * Created by 葉蔵 on 2018/4/23.
 * 投递简历对照表
 */
public class ResRecRel implements Serializable {
    private long rrrId;//投递简历编号
    private Recruit rrrRecruit;//招聘信息
    private Resume rrrResume;//简历信息
    private int rrrStat;//投递状态 0：未邀请 1：已邀请

    public ResRecRel(long rrrRecId, long rrrResId) {
        this.rrrRecruit.setRecId(rrrRecId);
        this.rrrResume.setResId(rrrResId);
    }

    public ResRecRel() {

    }

    public long getRrrId() {

        return rrrId;
    }

    public void setRrrId(long rrrId) {
        this.rrrId = rrrId;
    }

    public Recruit getRrrRecruit() {
        return rrrRecruit;
    }

    public void setRrrRecruit(Recruit rrrRecruit) {
        this.rrrRecruit = rrrRecruit;
    }

    public Resume getRrrResume() {
        return rrrResume;
    }

    public void setRrrResume(Resume rrrResume) {
        this.rrrResume = rrrResume;
    }

    public int getRrrStat() {
        return rrrStat;
    }

    public void setRrrStat(int rrrStat) {
        this.rrrStat = rrrStat;
    }

    @Override
    public String toString() {
        return "ResRecRel{" +
                "rrrId=" + rrrId +
                ", rrrRecruit=" + rrrRecruit +
                ", rrrResume=" + rrrResume +
                ", rrrStat=" + rrrStat +
                '}';
    }
}
