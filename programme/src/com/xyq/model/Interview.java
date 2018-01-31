package com.xyq.model;

import com.mysql.fabric.xmlrpc.base.Data;

import java.io.Serializable;

/**
 * Created by asus on 2018/1/30.
 */
public class Interview implements Serializable {
    private int i_id;
    private int i_gid;
    private String i_interviewtime;
    private String i_interviewaddress;
    private int i_rmid;
    private int i_gstatus;
    private int i_result;
    private int i_cid;

    public Interview() {
    }

    public int getI_cid() {
        return i_cid;
    }

    public void setI_cid(int i_cid) {
        this.i_cid = i_cid;
    }

    public Interview(int i_id, int i_gid, String i_interviewtime, String i_interviewaddress, int i_rmid, int i_gstatus, int i_result, int i_cid) {

        this.i_id = i_id;
        this.i_gid = i_gid;
        this.i_interviewtime = i_interviewtime;
        this.i_interviewaddress = i_interviewaddress;
        this.i_rmid = i_rmid;
        this.i_gstatus = i_gstatus;
        this.i_result = i_result;
        this.i_cid = i_cid;
    }

    public int getI_id() {
        return i_id;
    }

    public void setI_id(int i_id) {
        this.i_id = i_id;
    }

    public int getI_gid() {
        return i_gid;
    }

    public void setI_gid(int i_gid) {
        this.i_gid = i_gid;
    }

    public String getI_interviewtime() {
        return i_interviewtime;
    }

    public void setI_interviewtime(String i_interviewtime) {
        this.i_interviewtime = i_interviewtime;
    }

    public String getI_interviewaddress() {
        return i_interviewaddress;
    }

    public void setI_interviewaddress(String i_interviewaddress) {
        this.i_interviewaddress = i_interviewaddress;
    }

    public int getI_rmid() {
        return i_rmid;
    }

    public void setI_rmid(int i_rmid) {
        this.i_rmid = i_rmid;
    }

    public int getI_gstatus() {
        return i_gstatus;
    }

    public void setI_gstatus(int i_gstatus) {
        this.i_gstatus = i_gstatus;
    }

    public int getI_result() {
        return i_result;
    }

    public void setI_result(int i_result) {
        this.i_result = i_result;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "i_id=" + i_id +
                ", i_gid=" + i_gid +
                ", i_interviewtime=" + i_interviewtime +
                ", i_interviewaddress='" + i_interviewaddress + '\'' +
                ", i_rmid=" + i_rmid +
                ", i_gstatus=" + i_gstatus +
                ", i_result=" + i_result +
                '}';
    }
}
