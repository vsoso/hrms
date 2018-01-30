package com.xyq.dao;

import com.xyq.model.Interview;

import java.util.List;

/**
 * Created by asus on 2018/1/30.
 */
public interface InterviewMapper {
    void addInterview(Interview interview);
    List<Interview> getInterviewByGid(int gid);
}
