package com.xyq.model;

import java.io.Serializable;

/**
 * Created by asus on 2018/1/28.
 */
public class Recruitment implements Serializable {
    private int rm_id;
    private int rm_cid;
    private int rm_did;
    private int rm_jid;
    private String rm_name;
    private int rm_peopleneeded;
    private String rm_requirement;
    private String rm_money;
    private String rm_workplace;
    private int rm_gid;
    private int rm_applycount;

    public Recruitment() {
    }

    public Recruitment(int rm_id, int rm_cid, int rm_did, int rm_jid, String rm_name, int rm_peopleneeded, String rm_requirement, String rm_money, String rm_workplace, int rm_gid, int rm_applycount) {
        this.rm_id = rm_id;
        this.rm_cid = rm_cid;
        this.rm_did = rm_did;
        this.rm_jid = rm_jid;
        this.rm_name = rm_name;
        this.rm_peopleneeded = rm_peopleneeded;
        this.rm_requirement = rm_requirement;
        this.rm_money = rm_money;
        this.rm_workplace = rm_workplace;
        this.rm_gid = rm_gid;
        this.rm_applycount = rm_applycount;
    }

    public int getRm_id() {
        return rm_id;
    }

    public void setRm_id(int rm_id) {
        this.rm_id = rm_id;
    }

    public int getRm_cid() {
        return rm_cid;
    }

    public void setRm_cid(int rm_cid) {
        this.rm_cid = rm_cid;
    }

    public int getRm_did() {
        return rm_did;
    }

    public void setRm_did(int rm_did) {
        this.rm_did = rm_did;
    }

    public int getRm_jid() {
        return rm_jid;
    }

    public void setRm_jid(int rm_jid) {
        this.rm_jid = rm_jid;
    }

    public String getRm_name() {
        return rm_name;
    }

    public void setRm_name(String rm_name) {
        this.rm_name = rm_name;
    }

    public int getRm_peopleneeded() {
        return rm_peopleneeded;
    }

    public void setRm_peopleneeded(int rm_peopleneeded) {
        this.rm_peopleneeded = rm_peopleneeded;
    }

    public String getRm_requirement() {
        return rm_requirement;
    }

    public void setRm_requirement(String rm_requirement) {
        this.rm_requirement = rm_requirement;
    }

    public String getRm_money() {
        return rm_money;
    }

    public void setRm_money(String rm_money) {
        this.rm_money = rm_money;
    }

    public String getRm_workplace() {
        return rm_workplace;
    }

    public void setRm_workplace(String rm_workplace) {
        this.rm_workplace = rm_workplace;
    }

    public int getRm_gid() {
        return rm_gid;
    }

    public void setRm_gid(int rm_gid) {
        this.rm_gid = rm_gid;
    }

    public int getRm_applycount() {
        return rm_applycount;
    }

    public void setRm_applycount(int rm_applycount) {
        this.rm_applycount = rm_applycount;
    }

    @Override
    public String toString() {
        return "Recruitment{" +
                "rm_id=" + rm_id +
                ", rm_cid=" + rm_cid +
                ", rm_did=" + rm_did +
                ", rm_jid=" + rm_jid +
                ", rm_name='" + rm_name + '\'' +
                ", rm_peopleneeded=" + rm_peopleneeded +
                ", rm_requirement='" + rm_requirement + '\'' +
                ", rm_money='" + rm_money + '\'' +
                ", rm_workplace='" + rm_workplace + '\'' +
                ", rm_gid=" + rm_gid +
                ", rm_applycount=" + rm_applycount +
                '}';
    }
}
