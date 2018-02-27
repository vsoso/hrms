package com.xyq.model;

import java.io.Serializable;

/**
 * Created by asus on 2018/2/27.
 */
public class Salary implements Serializable{
    private int s_id;
    private int s_eid;
    private double s_bonus;
    private String s_date;
    private int s_status;
    private int s_cid;
    private double s_money;
    private double s_reward;
    private double s_basic;

    public Salary() {
    }

    public Salary(int s_id, int s_eid, double s_bonus, String s_date, int s_status, int s_cid, double s_money, double s_reward, double s_basic) {
        this.s_id = s_id;
        this.s_eid = s_eid;
        this.s_bonus = s_bonus;
        this.s_date = s_date;
        this.s_status = s_status;
        this.s_cid = s_cid;
        this.s_money = s_money;
        this.s_reward = s_reward;
        this.s_basic = s_basic;
    }

    public double getS_basic() {
        return s_basic;
    }

    public void setS_basic(double s_basic) {
        this.s_basic = s_basic;
    }

    public double getS_reward() {
        return s_reward;
    }

    public void setS_reward(double s_reward) {
        this.s_reward = s_reward;
    }

    public double getS_money() {

        return s_money;
    }

    public void setS_money(double s_money) {
        this.s_money = s_money;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public int getS_eid() {
        return s_eid;
    }

    public void setS_eid(int s_eid) {
        this.s_eid = s_eid;
    }

    public double getS_bonus() {
        return s_bonus;
    }

    public void setS_bonus(double s_bonus) {
        this.s_bonus = s_bonus;
    }

    public String getS_date() {
        return s_date;
    }

    public void setS_date(String s_date) {
        this.s_date = s_date;
    }

    public int getS_status() {
        return s_status;
    }

    public void setS_status(int s_status) {
        this.s_status = s_status;
    }

    public int getS_cid() {
        return s_cid;
    }

    public void setS_cid(int s_cid) {
        this.s_cid = s_cid;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "s_id=" + s_id +
                ", s_eid=" + s_eid +
                ", s_bonus=" + s_bonus +
                ", s_date='" + s_date + '\'' +
                ", s_status=" + s_status +
                ", s_cid=" + s_cid +
                ", s_money=" + s_money +
                ", s_reward=" + s_reward +
                ", s_basic=" + s_basic +
                '}';
    }
}
