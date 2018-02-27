package com.xyq.dao;

import com.xyq.model.Department;
import com.xyq.model.Job;

import java.util.List;

/**
 * Created by asus on 2018/2/2.
 */
public interface JobMapper {
    List<Job> getJob(int j_cid);
    List<Job> getJobByDepartment(Department department);
    Job getJobById(int j_id);
    void addJob(Job job);
    void updateJob(Job job);
    void deleteJob(Job job);
}
