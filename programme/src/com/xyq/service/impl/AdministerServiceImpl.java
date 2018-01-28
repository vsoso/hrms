package com.xyq.service.impl;

import com.xyq.dao.AdministerMapper;
import com.xyq.model.Administer;
import com.xyq.service.AdministerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by asus on 2018/1/28.
 */
@Service("administerService")
public class AdministerServiceImpl implements AdministerService {
    @Resource
    private AdministerMapper administerMapper;

    @Override
    public Administer checkAdminister(Administer administer) {
        return administerMapper.checkAdminister(administer);
    }
}
