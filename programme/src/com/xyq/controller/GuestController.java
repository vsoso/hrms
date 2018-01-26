package com.xyq.controller;

import com.xyq.model.Guest;
import com.xyq.service.GuestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by asus on 2018/1/26.
 */
@Controller
public class GuestController {
    @Resource
    private GuestService guestService;

    @RequestMapping("/guest")
    public String guest()throws Exception{
        return "guestlogin";
    }

    @RequestMapping("/guestregister")
    public String guestRegister()throws Exception{
        return "guestregister";
    }

    @RequestMapping("/guestRegister")
    public String guestRegister(Guest guest,HttpSession session)throws Exception{
        Guest guest1=guestService.checkGuestForName(guest);
        if(guest1!=null){
            session.setAttribute("registerResult","注册失败");
            return "guestregister";
        }else {
            session.setAttribute("registerResult","");
            guestService.addGuest(guest);
            guest1=guestService.checkGuestForName(guest);
            session.setAttribute("guest",guest1);
            return "guestmain";
        }
    }

    @RequestMapping("/guestLogin")
    public String guestLogin(Guest guest,HttpSession session)throws Exception{
        Guest guest1=guestService.checkGuest(guest);
        System.out.println(guest1);
        if(guest1==null) {
            session.setAttribute("loginResult","登录失败");
            return "guestlogin";
        }else {
            session.setAttribute("loginResult","");
            session.setAttribute("guest",guest1);
            return "guestmain";
        }
    }
}
