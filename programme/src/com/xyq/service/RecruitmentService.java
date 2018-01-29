package com.xyq.service;

import com.xyq.model.Recruitment;

import java.util.List;

/**
 * Created by asus on 2018/1/28.
 */
public interface RecruitmentService {
    void addRecruitment(Recruitment recruitment);
    List<Recruitment> getRecruitment();
}
