package com.xyq.dao;

import com.xyq.model.Guest;
import com.xyq.model.Recruitment;

import java.util.List;

/**
 * Created by asus on 2018/1/26.
 */
public interface GuestMapper {
    void addGuest(Guest guest);
    Guest checkGuest(Guest guest);
    Guest checkGuestForName(Guest guest);
    List<Guest> getGuestByRecruitment(Recruitment recruitment);
    List<Guest> getGuest();
    Guest getGuestById(int g_id);
    void updateGuestApplicationstatus(Guest guest);
}
