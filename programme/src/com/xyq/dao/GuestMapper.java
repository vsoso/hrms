package com.xyq.dao;

import com.xyq.model.Guest;

/**
 * Created by asus on 2018/1/26.
 */
public interface GuestMapper {
    void addGuest(Guest guest);
    Guest checkGuest(Guest guest);
    Guest checkGuestForName(Guest guest);
}
