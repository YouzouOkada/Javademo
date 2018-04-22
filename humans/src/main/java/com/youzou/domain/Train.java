package com.youzou.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 葉蔵 on 2018/4/20.
 * 培训表
 */
public class Train implements Serializable {
    private long traId;//培训编号
    private String traTheme;//培训主题
    private String traCon;//培训内容
    private int traCount;//培训人数
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date traStart;//开始时间
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date traEnd;//结束时间
    private String traLoc;//培训地点

    public Train() {
    }

    public long getTraId() {

        return traId;
    }

    public void setTraId(long traId) {
        this.traId = traId;
    }

    public String getTraTheme() {
        return traTheme;
    }

    public void setTraTheme(String traTheme) {
        this.traTheme = traTheme;
    }

    public String getTraCon() {
        return traCon;
    }

    public void setTraCon(String traCon) {
        this.traCon = traCon;
    }

    public int getTraCount() {
        return traCount;
    }

    public void setTraCount(int traCount) {
        this.traCount = traCount;
    }

    public Date getTraStart() {
        return traStart;
    }

    public void setTraStart(Date traStart) {
        this.traStart = traStart;
    }

    public Date getTraEnd() {
        return traEnd;
    }

    public void setTraEnd(Date traEnd) {
        this.traEnd = traEnd;
    }

    public String getTraLoc() {
        return traLoc;
    }

    public void setTraLoc(String traLoc) {
        this.traLoc = traLoc;
    }

    @Override
    public String toString() {
        return "Train{" +
                "traId=" + traId +
                ", traTheme='" + traTheme + '\'' +
                ", traCon='" + traCon + '\'' +
                ", traCount=" + traCount +
                ", traStart=" + traStart +
                ", traEnd=" + traEnd +
                ", traLoc='" + traLoc + '\'' +
                '}';
    }
}
