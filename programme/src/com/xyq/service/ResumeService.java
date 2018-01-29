package com.xyq.service;

import com.xyq.model.Guest;
import com.xyq.model.Resume;

/**
 * Created by asus on 2018/1/28.
 */
public interface ResumeService {
    void addResume(Resume resume);
    Resume getResumeByGid(Guest guest);
    void updateResume(Resume resume);
    void deleteResume(Resume resume);
}
