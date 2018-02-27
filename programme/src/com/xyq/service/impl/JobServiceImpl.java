package com.xyq.service.impl;

import com.xyq.dao.JobMapper;
import com.xyq.model.Department;
import com.xyq.model.Job;
import com.xyq.service.JobService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by asus on 2018/2/2.
 */
@Service("jobService")
public class JobServiceImpl implements JobService {
    @Resource
    private JobMapper jobMapper;

    @Override
    public List<Job> getJob(int j_cid) {
        return jobMapper.getJob(j_cid);
    }

    @Override
    public List<Job> getJobByDepartment(Department department) {
        return jobMapper.getJobByDepartment(department);
    }

    @Override
    public Job getJobById(int j_id) {
        return jobMapper.getJobById(j_id);
    }

    @Override
    public void addJob(Job job) {
        jobMapper.addJob(job);
    }

    @Override
    public void updateJob(Job job) {
        jobMapper.updateJob(job);
    }

    @Override
    public void deleteJob(Job job) {
        jobMapper.deleteJob(job);
    }
}
