package com.xyq.model;

import java.io.Serializable;

/**
 * Created by asus on 2018/2/26.
 */
public class Train implements Serializable {
    private int t_id;
    private int t_did;
    private int t_cid;
    private String t_time;
    private String t_address;
    private String t_train;

    public Train() {
    }

    public Train(int t_id, int t_did, int t_cid, String t_time, String t_address, String t_train) {
        this.t_id = t_id;
        this.t_did = t_did;
        this.t_cid = t_cid;
        this.t_time = t_time;
        this.t_address = t_address;
        this.t_train = t_train;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public int getT_did() {
        return t_did;
    }

    public void setT_did(int t_did) {
        this.t_did = t_did;
    }

    public String getT_time() {
        return t_time;
    }

    public void setT_time(String t_time) {
        this.t_time = t_time;
    }

    public String getT_address() {
        return t_address;
    }

    public void setT_address(String t_address) {
        this.t_address = t_address;
    }

    public String getT_train() {
        return t_train;
    }

    public void setT_train(String t_train) {
        this.t_train = t_train;
    }

    public int getT_cid() {
        return t_cid;
    }

    public void setT_cid(int t_cid) {
        this.t_cid = t_cid;
    }

    @Override
    public String toString() {
        return "Train{" +
                "t_id=" + t_id +
                ", t_did=" + t_did +
                ", t_cid=" + t_cid +
                ", t_time='" + t_time + '\'' +
                ", t_address='" + t_address + '\'' +
                ", t_train='" + t_train + '\'' +
                '}';
    }
}
