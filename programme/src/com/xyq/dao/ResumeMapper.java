package com.xyq.dao;

import com.xyq.model.Guest;
import com.xyq.model.Resume;

import java.util.List;

/**
 * Created by asus on 2018/1/28.
 */
public interface ResumeMapper {
    void addResume(Resume resume);
    Resume getResumeByGid(Guest guest);
    void updateResume(Resume resume);
    void deleteResume(Resume resume);
}
