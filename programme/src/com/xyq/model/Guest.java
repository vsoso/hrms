package com.xyq.model;

import java.io.Serializable;

/**
 * Created by asus on 2018/1/26.
 */
public class Guest implements Serializable {
    private int g_id;
    private String g_name;
    private String g_password;
    private int g_applicationstatus;

    public Guest() {
    }

    public Guest(int g_id, String g_name, String g_password, int g_applicationstatus) {
        this.g_id = g_id;
        this.g_name = g_name;
        this.g_password = g_password;
        this.g_applicationstatus = g_applicationstatus;
    }

    public int getG_id() {
        return g_id;
    }

    public void setG_id(int g_id) {
        this.g_id = g_id;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public String getG_password() {
        return g_password;
    }

    public void setG_password(String g_password) {
        this.g_password = g_password;
    }

    public int getG_applicationstatus() {
        return g_applicationstatus;
    }

    public void setG_applicationstatus(int g_applicationstatus) {
        this.g_applicationstatus = g_applicationstatus;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "g_password='" + g_password + '\'' +
                ", g_applicationstatus=" + g_applicationstatus +
                ", g_name='" + g_name + '\'' +
                ", g_id=" + g_id +
                '}';
    }
}
