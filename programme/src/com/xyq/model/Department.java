package com.xyq.model;

import java.io.Serializable;

/**
 * Created by asus on 2018/2/2.
 */
public class Department implements Serializable {
    private int d_id;
    private String d_name;
    private int d_cid;
    private String d_createtime;

    public Department() {
    }

    public Department(int d_id, String d_name, int d_cid, String d_createtime) {
        this.d_id = d_id;
        this.d_name = d_name;
        this.d_cid = d_cid;
        this.d_createtime = d_createtime;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public int getD_cid() {
        return d_cid;
    }

    public void setD_cid(int d_cid) {
        this.d_cid = d_cid;
    }

    public String getD_createtime() {
        return d_createtime;
    }

    public void setD_createtime(String d_createtime) {
        this.d_createtime = d_createtime;
    }

    @Override
    public String toString() {
        return "Department{" +
                "d_id=" + d_id +
                ", d_name='" + d_name + '\'' +
                ", d_cid=" + d_cid +
                ", d_cratetime='" + d_createtime + '\'' +
                '}';
    }
}
