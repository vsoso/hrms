package com.xyq.service.impl;

import com.xyq.dao.GuestMapper;
import com.xyq.model.Guest;
import com.xyq.service.GuestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by asus on 2018/1/26.
 */
@Service("guestService")
public class GuestServiceImpl implements GuestService {
    @Resource
    private GuestMapper guestMapper;

    @Override
    public void addGuest(Guest guest) {
        guestMapper.addGuest(guest);
    }

    @Override
    public Guest checkGuest(Guest guest) {
        return guestMapper.checkGuest(guest);
    }

    @Override
    public Guest checkGuestForName(Guest guest) {
        return guestMapper.checkGuestForName(guest);
    }
}
