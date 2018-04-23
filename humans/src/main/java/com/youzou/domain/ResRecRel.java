package com.youzou.domain;

import java.io.Serializable;

/**
 * Created by 葉蔵 on 2018/4/23.
 * 投递简历对照表
 */
public class ResRecRel implements Serializable {
    private long rrrId;//投递简历编号
    private long rrrRecId;//职位编号
    private long rrrResId;//简历编号

    public ResRecRel(long rrrRecId, long rrrResId) {
        this.rrrRecId = rrrRecId;
        this.rrrResId = rrrResId;
    }

    public ResRecRel() {

    }

    public long getRrrId() {

        return rrrId;
    }

    public void setRrrId(long rrrId) {
        this.rrrId = rrrId;
    }

    public long getRrrRecId() {
        return rrrRecId;
    }

    public void setRrrRecId(long rrrRecId) {
        this.rrrRecId = rrrRecId;
    }

    public long getRrrResId() {
        return rrrResId;
    }

    public void setRrrResId(long rrrResId) {
        this.rrrResId = rrrResId;
    }

    @Override
    public String toString() {
        return "ResRecRel{" +
                "rrrId=" + rrrId +
                ", rrrRecId=" + rrrRecId +
                ", rrrResId=" + rrrResId +
                '}';
    }
}
