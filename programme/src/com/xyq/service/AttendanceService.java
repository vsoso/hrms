package com.xyq.service;

import com.xyq.model.Attendance;

import java.util.List;

/**
 * Created by asus on 2018/2/26.
 */
public interface AttendanceService {
    void insertEndWork (Attendance attendance);
    void insertStartWork (Attendance attendance);
    void updateWork (Attendance attendance);
    List<Attendance> getAttendanceByEid(int eid);
}
