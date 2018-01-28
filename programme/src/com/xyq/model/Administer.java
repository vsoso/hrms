package com.xyq.model;

import java.io.Serializable;

/**
 * Created by asus on 2018/1/28.
 */
public class Administer implements Serializable{
    private int a_id;
    private String a_name;
    private String a_password;
    private int a_cid;

    public Administer() {
    }

    public Administer(int a_id, String a_name, String a_password, int a_cid) {
        this.a_id = a_id;
        this.a_name = a_name;
        this.a_password = a_password;
        this.a_cid = a_cid;
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public String getA_password() {
        return a_password;
    }

    public void setA_password(String a_password) {
        this.a_password = a_password;
    }

    public int getA_cid() {
        return a_cid;
    }

    public void setA_cid(int a_cid) {
        this.a_cid = a_cid;
    }

    @Override
    public String toString() {
        return "Administer{" +
                "a_id=" + a_id +
                ", a_name='" + a_name + '\'' +
                ", a_password='" + a_password + '\'' +
                ", a_cid=" + a_cid +
                '}';
    }
}
