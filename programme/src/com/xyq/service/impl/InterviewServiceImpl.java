package com.xyq.service.impl;

import com.xyq.dao.InterviewMapper;
import com.xyq.model.Interview;
import com.xyq.service.InterviewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by asus on 2018/1/30.
 */
@Service("interviewService")
public class InterviewServiceImpl implements InterviewService {
    @Resource
    private InterviewMapper interviewMapper;
    @Override
    public void addInterview(Interview interview) {
        interviewMapper.addInterview(interview);
    }

    @Override
    public List<Interview> getInterviewByGid(int gid) {
        return interviewMapper.getInterviewByGid(gid);
    }

    @Override
    public void updateInterviewStatus(Interview interview) {
        interviewMapper.updateInterviewStatus(interview);
    }
}
