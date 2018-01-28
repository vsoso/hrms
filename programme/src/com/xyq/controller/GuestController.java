package com.xyq.controller;

import com.xyq.model.Guest;
import com.xyq.model.Resume;
import com.xyq.service.GuestService;
import com.xyq.service.ResumeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by asus on 2018/1/26.
 */
@Controller
public class GuestController {
    @Resource
    private GuestService guestService;
    @Resource
    private ResumeService resumeService;

    @RequestMapping("/guest")
    public String guest()throws Exception{
        return "guestlogin";
    }

    @RequestMapping("/guestregister")
    public String guestRegister()throws Exception{
        return "guestregister";
    }

    @RequestMapping("/guestRegister")
    public String guestRegister(Guest guest, HttpSession session, HttpServletRequest request)throws Exception{
        String passRe=request.getParameter("g_passwordRe");
        if(guest.getG_name().length()>=4&&guest.getG_password().length()>=4&&guest.getG_password().equals(passRe)) {
            Guest guest1 = guestService.checkGuestForName(guest);
            if (guest1 != null) {
                session.setAttribute("registerResult", "注册失败");
                return "guestregister";
            } else {
                session.setAttribute("registerResult", "");
                guestService.addGuest(guest);
                guest1 = guestService.checkGuestForName(guest);
                session.setAttribute("guest", guest1);
                Resume resume=resumeService.getResumeByGid(guest1);
                if(resume==null){
                    session.setAttribute("resumecount",0);
                }else {
                    session.setAttribute("resumecount",1);
                }
                session.setAttribute("resume",resume);
                return "guestmain";
            }
        }else {
            session.setAttribute("registerResult", "注册失败");
            return "guestregister";
        }
    }

    @RequestMapping("/guestLogin")
    public String guestLogin(Guest guest,HttpSession session)throws Exception{
        Guest guest1=guestService.checkGuest(guest);
        if(guest1==null) {
            session.setAttribute("loginResult","登录失败");
            return "guestlogin";
        }else {
            Resume resume=resumeService.getResumeByGid(guest1);
            if(resume==null){
                session.setAttribute("resumecount",0);
            }else {
                session.setAttribute("resumecount",1);
            }
            session.setAttribute("resume",resume);
            session.setAttribute("loginResult","");
            session.setAttribute("guest",guest1);
            return "guestmain";
        }
    }

    @RequestMapping("/addResume")
    public String addResume(Resume resume,HttpSession session)throws Exception{
        Guest guest= (Guest) session.getAttribute("guest");
        resume.setR_gid(guest.getG_id());
        resumeService.addResume(resume);
        session.setAttribute("resume",resume);
        return "guestmain";
    }
}
