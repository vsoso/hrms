package com.xyq.dao;

import com.xyq.model.Recruitment;

import java.util.List;

/**
 * Created by asus on 2018/1/28.
 */
public interface RecruitmentMapper {
    Recruitment addRecruitment(Recruitment recruitment);
    List<Recruitment> getRecruitment();
}
