package com.xyq.service.impl;

import com.xyq.dao.ResumeMapper;
import com.xyq.model.Guest;
import com.xyq.model.Resume;
import com.xyq.service.ResumeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by asus on 2018/1/28.
 */
@Service("resumeService")
public class ResumeServiceImpl implements ResumeService {
    @Resource
    private ResumeMapper resumeMapper;

    @Override
    public Resume addResume(Resume resume) {
        return resumeMapper.addResume(resume);
    }

    @Override
    public Resume getResumeByGid(Guest guest) {
        return getResumeByGid(guest);
    }
}
