package com.xyq.dao;


import com.xyq.model.Attendance;

import java.util.List;

/**
 * Created by asus on 2018/1/28.
 */
public interface AttendanceMapper {
    void insertEndWork (Attendance attendance);
    void insertStartWork (Attendance attendance);
    void updateWork (Attendance attendance);
    List<Attendance> getAttendanceByEid(int eid);
}
