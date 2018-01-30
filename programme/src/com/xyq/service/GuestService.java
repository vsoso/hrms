package com.xyq.service;

import com.xyq.model.Guest;
import com.xyq.model.Recruitment;

import java.util.List;

/**
 * Created by asus on 2018/1/26.
 */
public interface GuestService {
    void addGuest(Guest guest);
    Guest checkGuest(Guest guest);
    Guest checkGuestForName(Guest guest);
    List<Guest> getGuestByRecruitment(Recruitment recruitment);
    Guest getGuestById(int g_id);
}
