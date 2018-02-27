package com.xyq.service;

import com.xyq.model.Application;

import java.util.List;

/**
 * Created by asus on 2018/2/19.
 */
public interface ApplicationService {
    void addApplication(Application application);
    List<Application> getApplicationByRecruitment(int rmid);
}
