package com.xyq.service.impl;

import com.xyq.dao.AttendanceMapper;
import com.xyq.model.Attendance;
import com.xyq.service.AttendanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by asus on 2018/2/26.
 */
@Service("attendanceService")
public class AttendanceServiceImpl implements AttendanceService {
    @Resource
    private AttendanceMapper attendanceMapper;


    @Override
    public void insertEndWork(Attendance attendance) {
        attendanceMapper.insertEndWork(attendance);
    }

    @Override
    public void insertStartWork(Attendance attendance) {
        attendanceMapper.insertStartWork(attendance);
    }

    @Override
    public void updateWork(Attendance attendance) {
        attendanceMapper.updateWork(attendance);
    }

    @Override
    public List<Attendance> getAttendanceByEid(int eid) {
        return attendanceMapper.getAttendanceByEid(eid);
    }
}
