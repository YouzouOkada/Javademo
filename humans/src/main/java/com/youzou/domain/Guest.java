package com.youzou.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
public class Guest implements Serializable{
    private long guId;
    private String guPhone;
    private String guPass;

    public Guest() {
    }

    public long getGuId() {

        return guId;
    }

    public void setGuId(long guId) {
        this.guId = guId;
    }

    public String getGuPhone() {
        return guPhone;
    }

    public void setGuPhone(String guPhone) {
        this.guPhone = guPhone;
    }

    public String getGuPass() {
        return guPass;
    }

    public void setGuPass(String guPass) {
        this.guPass = guPass;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "guId=" + guId +
                ", guPhone='" + guPhone + '\'' +
                ", guPass='" + guPass + '\'' +
                '}';
    }
}
