package com.xyq.model;

import java.io.Serializable;

/**
 * Created by asus on 2018/2/19.
 */
public class Application implements Serializable{
    private int ap_id;
    private int ap_rmid;
    private int ap_gid;

    public Application() {
    }

    public Application(int ap_id, int ap_rmid, int ap_gid) {
        this.ap_id = ap_id;
        this.ap_rmid = ap_rmid;
        this.ap_gid = ap_gid;
    }

    public int getAp_id() {
        return ap_id;
    }

    public void setAp_id(int ap_id) {
        this.ap_id = ap_id;
    }

    public int getAp_rmid() {
        return ap_rmid;
    }

    public void setAp_rmid(int ap_rmid) {
        this.ap_rmid = ap_rmid;
    }

    public int getAp_gid() {
        return ap_gid;
    }

    public void setAp_gid(int ap_gid) {
        this.ap_gid = ap_gid;
    }

    @Override
    public String toString() {
        return "Application{" +
                "ap_id=" + ap_id +
                ", ap_rmid=" + ap_rmid +
                ", ap_gid=" + ap_gid +
                '}';
    }
}
