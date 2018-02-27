package com.xyq.service.impl;

import com.xyq.dao.ApplicationMapper;
import com.xyq.model.Application;
import com.xyq.service.ApplicationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by asus on 2018/2/19.
 */
@Service("applicationService")
public class ApplicationServiceImpl implements ApplicationService{
    @Resource
    private ApplicationMapper applicationMapper;

    @Override
    public void addApplication(Application application) {
        applicationMapper.addApplication(application);
    }

    @Override
    public List<Application> getApplicationByRecruitment(int rmid) {
        return applicationMapper.getApplicationByRecruitment(rmid);
    }
}
