package com.xyq.model;

import java.io.Serializable;

/**
 * Created by asus on 2018/2/27.
 */
public class Reward implements Serializable{
    private int re_id;
    private int re_eid;
    private double re_money;
    private String re_time;
    private String re_reason;
    private int re_cid;

    public Reward() {
    }

    public Reward(int re_id, int re_eid, double re_money, String re_time, String re_reason, int re_cid) {
        this.re_id = re_id;
        this.re_eid = re_eid;
        this.re_money = re_money;
        this.re_time = re_time;
        this.re_reason = re_reason;
        this.re_cid = re_cid;
    }

    public int getRe_cid() {
        return re_cid;
    }

    public void setRe_cid(int re_cid) {
        this.re_cid = re_cid;
    }

    public int getRe_id() {
        return re_id;
    }

    public void setRe_id(int re_id) {
        this.re_id = re_id;
    }

    public int getRe_eid() {
        return re_eid;
    }

    public void setRe_eid(int re_eid) {
        this.re_eid = re_eid;
    }

    public double getRe_money() {
        return re_money;
    }

    public void setRe_money(double re_money) {
        this.re_money = re_money;
    }

    public String getRe_time() {
        return re_time;
    }

    public void setRe_time(String re_time) {
        this.re_time = re_time;
    }

    public String getRe_reason() {
        return re_reason;
    }

    public void setRe_reason(String re_reason) {
        this.re_reason = re_reason;
    }

    @Override
    public String toString() {
        return "Reward{" +
                "re_id=" + re_id +
                ", re_eid=" + re_eid +
                ", re_money=" + re_money +
                ", re_time='" + re_time + '\'' +
                ", re_reason='" + re_reason + '\'' +
                ", re_cid=" + re_cid +
                '}';
    }
}
