package com.xyq.service;

import com.xyq.model.Administer;
import com.xyq.model.Recruitment;

import java.util.List;

/**
 * Created by asus on 2018/1/28.
 */
public interface RecruitmentService {
    void addRecruitment(Recruitment recruitment);
    List<Recruitment> getRecruitment();
    List<Recruitment> getRecruitmentByAdmin(Administer administer);
    void updateRecruitment(Recruitment recruitment);
    Recruitment getRecruitmentById(int rm_id);
    void deleteRecruitment(Recruitment recruitment);
}
