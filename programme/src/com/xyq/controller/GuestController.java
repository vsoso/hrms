package com.xyq.controller;

import com.xyq.model.Guest;
import com.xyq.model.Recruitment;
import com.xyq.model.Resume;
import com.xyq.service.GuestService;
import com.xyq.service.RecruitmentService;
import com.xyq.service.ResumeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by asus on 2018/1/26.
 */
@Controller
public class GuestController {
    @Resource
    private GuestService guestService;
    @Resource
    private ResumeService resumeService;
    @Resource
    private RecruitmentService recruitmentService;

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
                List<Recruitment> recruitments=recruitmentService.getRecruitment();
                session.setAttribute("recruitments",recruitments);
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
            List<Recruitment> recruitments=recruitmentService.getRecruitment();
            session.setAttribute("recruitments",recruitments);
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
        session.setAttribute("resumecount",1);
        session.setAttribute("resume",resume);
        return "guestmain";
    }

    @RequestMapping("/updateResume")
    public String updateResume(Resume resume,HttpSession session)throws Exception{
        Guest guest= (Guest) session.getAttribute("guest");
        resume.setR_gid(guest.getG_id());
        resumeService.updateResume(resume);
        session.setAttribute("resume",resume);
        return "guestmain";
    }

    @RequestMapping("/deleteResume")
    public String deleteResume(HttpSession session)throws Exception{
        Guest guest= (Guest) session.getAttribute("guest");
        Resume resume=new Resume();
        resume.setR_gid(guest.getG_id());
        resumeService.deleteResume(resume);
        session.setAttribute("resumecount",0);
        return "guestmain";
    }

    @RequestMapping("/seeRecruitment")
    public String seeRecruitment(HttpServletRequest request,HttpSession session)throws Exception{
        int rm_id= Integer.parseInt(request.getParameter("rm_id"));
        List<Recruitment> recruitments=recruitmentService.getRecruitment();
        for (Recruitment recruitment:recruitments){
            if(recruitment.getRm_id()==rm_id){
                session.setAttribute("recruitment",recruitment);
            }
        }
        return "guestrecruitment";
    }

    @RequestMapping("/toGuestMain")
    public String toGuestMain(HttpServletRequest request,HttpSession session)throws Exception{
        return "guestmain";
    }

    @RequestMapping("/applyForJob")
    public String applyForJob(HttpServletRequest request,HttpSession session)throws Exception{
        Recruitment recruitment= (Recruitment) session.getAttribute("recruitment");
        Guest guest= (Guest) session.getAttribute("guest");
        recruitment.setRm_gid(guest.getG_id());
        Recruitment recruitment1=recruitment;
        int applycount=recruitment1.getRm_applycount();
        recruitment.setRm_applycount(0);
        recruitmentService.addRecruitment(recruitment);
        recruitment1.setRm_applycount(applycount+1);
        recruitment1.setRm_gid(0);
        recruitmentService.updateRecruitment(recruitment1);
        return "guestmain";
    }
}
