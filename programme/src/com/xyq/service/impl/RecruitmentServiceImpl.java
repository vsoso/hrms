package com.xyq.service.impl;

import com.xyq.dao.RecruitmentMapper;
import com.xyq.model.Administer;
import com.xyq.model.Recruitment;
import com.xyq.service.RecruitmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by asus on 2018/1/28.
 */
@Service("recruitmentService")
public class RecruitmentServiceImpl implements RecruitmentService {
    @Resource
    private RecruitmentMapper recruitmentMapper;

    @Override
    public void addRecruitment(Recruitment recruitment) {
         recruitmentMapper.addRecruitment(recruitment);
    }

    @Override
    public List<Recruitment> getRecruitment() {
        return recruitmentMapper.getRecruitment();
    }

    @Override
    public List<Recruitment> getRecruitmentByAdmin(Administer administer) {
        return recruitmentMapper.getRecruitmentByAdmin(administer);
    }

    @Override
    public void updateRecruitment(Recruitment recruitment) {
        recruitmentMapper.updateRecruitment(recruitment);
    }

    @Override
    public Recruitment getRecruitmentById(int rm_id) {
        return recruitmentMapper.getRecruitmentById(rm_id);
    }

    @Override
    public void deleteRecruitment(Recruitment recruitment) {
        recruitmentMapper.deleteRecruitment(recruitment);
    }
}
