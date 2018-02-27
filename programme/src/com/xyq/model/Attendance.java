package com.xyq.model;

import java.io.Serializable;

/**
 * Created by asus on 2018/2/26.
 */
public class Attendance implements Serializable {
    private int at_id;
    private int at_eid;
    private String at_starttime;
    private String at_endtime;
    private int at_startresult;
    private int at_endresult;
    private String at_day;

    public Attendance() {
    }

    public Attendance(int at_id, int at_eid, String at_starttime, String at_endtime, int at_startresult, int at_endresult, String at_day) {
        this.at_id = at_id;
        this.at_eid = at_eid;
        this.at_starttime = at_starttime;
        this.at_endtime = at_endtime;
        this.at_startresult = at_startresult;
        this.at_endresult = at_endresult;
        this.at_day = at_day;
    }

    public int getAt_id() {
        return at_id;
    }

    public void setAt_id(int at_id) {
        this.at_id = at_id;
    }

    public int getAt_eid() {
        return at_eid;
    }

    public void setAt_eid(int at_eid) {
        this.at_eid = at_eid;
    }

    public String getAt_starttime() {
        return at_starttime;
    }

    public void setAt_starttime(String at_starttime) {
        this.at_starttime = at_starttime;
    }

    public String getAt_endtime() {
        return at_endtime;
    }

    public void setAt_endtime(String at_endtime) {
        this.at_endtime = at_endtime;
    }

    public int getAt_startresult() {
        return at_startresult;
    }

    public void setAt_startresult(int at_startresult) {
        this.at_startresult = at_startresult;
    }

    public int getAt_endresult() {
        return at_endresult;
    }

    public void setAt_endresult(int at_endresult) {
        this.at_endresult = at_endresult;
    }

    public String getAt_day() {
        return at_day;
    }

    public void setAt_day(String at_day) {
        this.at_day = at_day;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "at_id=" + at_id +
                ", at_eid=" + at_eid +
                ", at_starttime='" + at_starttime + '\'' +
                ", at_endtime='" + at_endtime + '\'' +
                ", at_startresult=" + at_startresult +
                ", at_endresult=" + at_endresult +
                ", at_day='" + at_day + '\'' +
                '}';
    }
}
