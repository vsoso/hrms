package com.xyq.service;

import com.xyq.model.Interview;

import java.util.List;

/**
 * Created by asus on 2018/1/30.
 */
public interface InterviewService {
    void addInterview(Interview interview);
    List<Interview> getInterviewByGid(int gid);
}
