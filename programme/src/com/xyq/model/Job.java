package com.xyq.model;

import java.io.Serializable;

/**
 * Created by asus on 2018/2/2.
 */
public class Job implements Serializable {
    private int j_id;
    private int j_did;
    private int j_cid;
    private String j_name;
    private String j_createtime;

    public Job() {
    }

    public Job(int j_id, int j_did, int j_cid, String j_name, String j_createtime) {
        this.j_id = j_id;
        this.j_did = j_did;
        this.j_cid = j_cid;
        this.j_name = j_name;
        this.j_createtime = j_createtime;
    }

    public int getJ_id() {
        return j_id;
    }

    public void setJ_id(int j_id) {
        this.j_id = j_id;
    }

    public int getJ_did() {
        return j_did;
    }

    public void setJ_did(int j_did) {
        this.j_did = j_did;
    }

    public String getJ_createtime() {
        return j_createtime;
    }

    public void setJ_createtime(String j_createtime) {
        this.j_createtime = j_createtime;
    }

    public String getJ_name() {
        return j_name;
    }

    public void setJ_name(String j_name) {
        this.j_name = j_name;
    }

    public int getJ_cid() {
        return j_cid;
    }

    public void setJ_cid(int j_cid) {
        this.j_cid = j_cid;
    }

    @Override
    public String toString() {
        return "Job{" +
                "j_id=" + j_id +
                ", j_did=" + j_did +
                ", j_cid=" + j_cid +
                ", j_name='" + j_name + '\'' +
                ", j_createtime='" + j_createtime + '\'' +
                '}';
    }
}
