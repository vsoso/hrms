package com.xyq.model;

import java.io.Serializable;

/**
 * Created by asus on 2018/1/31.
 */
public class Employee implements Serializable {
    private int e_id;
    private String e_name;
    private String e_password;
    private String e_realname;
    private int age;
    private String e_ethnicity;
    private int phone;
    private String e_marrige;
    private String e_address;
    private String e_hiretime;
    private int e_cid;
    private int e_did;
    private int e_jid;
    private double e_basicwage;
    private String e_workstarttime;
    private String e_workendtime;
    private int e_workstatus;

    public Employee() {
    }

    public Employee(int e_id, String e_name, String e_password, String e_realname, int age, String e_ethnicity, int phone, String e_marrige, String e_address, String e_hiretime, int e_cid, int e_did, int e_jid, double e_basicwage, String e_workstarttime, String e_workendtime, int e_workstatus) {
        this.e_id = e_id;
        this.e_name = e_name;
        this.e_password = e_password;
        this.e_realname = e_realname;
        this.age = age;
        this.e_ethnicity = e_ethnicity;
        this.phone = phone;
        this.e_marrige = e_marrige;
        this.e_address = e_address;
        this.e_hiretime = e_hiretime;
        this.e_cid = e_cid;
        this.e_did = e_did;
        this.e_jid = e_jid;
        this.e_basicwage = e_basicwage;
        this.e_workstarttime = e_workstarttime;
        this.e_workendtime = e_workendtime;
        this.e_workstatus = e_workstatus;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getE_password() {
        return e_password;
    }

    public void setE_password(String e_password) {
        this.e_password = e_password;
    }

    public String getE_realname() {
        return e_realname;
    }

    public void setE_realname(String e_realname) {
        this.e_realname = e_realname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getE_ethnicity() {
        return e_ethnicity;
    }

    public void setE_ethnicity(String e_ethnicity) {
        this.e_ethnicity = e_ethnicity;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getE_marrige() {
        return e_marrige;
    }

    public void setE_marrige(String e_marrige) {
        this.e_marrige = e_marrige;
    }

    public String getE_address() {
        return e_address;
    }

    public void setE_address(String e_address) {
        this.e_address = e_address;
    }

    public String getE_hiretime() {
        return e_hiretime;
    }

    public void setE_hiretime(String e_hiretime) {
        this.e_hiretime = e_hiretime;
    }

    public int getE_cid() {
        return e_cid;
    }

    public void setE_cid(int e_cid) {
        this.e_cid = e_cid;
    }

    public int getE_did() {
        return e_did;
    }

    public void setE_did(int e_did) {
        this.e_did = e_did;
    }

    public int getE_jid() {
        return e_jid;
    }

    public void setE_jid(int e_jid) {
        this.e_jid = e_jid;
    }

    public double getE_basicwage() {
        return e_basicwage;
    }

    public void setE_basicwage(double e_basicwage) {
        this.e_basicwage = e_basicwage;
    }

    public String getE_workstarttime() {
        return e_workstarttime;
    }

    public void setE_workstarttime(String e_workstarttime) {
        this.e_workstarttime = e_workstarttime;
    }

    public String getE_workendtime() {
        return e_workendtime;
    }

    public void setE_workendtime(String e_workendtime) {
        this.e_workendtime = e_workendtime;
    }

    public int getE_workstatus() {
        return e_workstatus;
    }

    public void setE_workstatus(int e_workstatus) {
        this.e_workstatus = e_workstatus;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "e_id=" + e_id +
                ", e_name='" + e_name + '\'' +
                ", e_password='" + e_password + '\'' +
                ", e_realname='" + e_realname + '\'' +
                ", age=" + age +
                ", e_ethnicity='" + e_ethnicity + '\'' +
                ", phone=" + phone +
                ", e_marrige='" + e_marrige + '\'' +
                ", e_address='" + e_address + '\'' +
                ", e_hiretime='" + e_hiretime + '\'' +
                ", e_cid=" + e_cid +
                ", e_did=" + e_did +
                ", e_jid=" + e_jid +
                ", e_basicwage=" + e_basicwage +
                ", e_workstarttime='" + e_workstarttime + '\'' +
                ", e_workendtime='" + e_workendtime + '\'' +
                ", e_workstatus=" + e_workstatus +
                '}';
    }
}
