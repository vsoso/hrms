package com.xyq.controller;

import com.xyq.model.*;
import com.xyq.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by asus on 2018/1/28.
 */
@Controller
public class AministerController {
    @Resource
    private AdministerService administerService;
    @Resource
    private RecruitmentService recruitmentService;
    @Resource
    private GuestService guestService;
    @Resource
    private ResumeService resumeService;
    @Resource
    private InterviewService interviewService;

    @RequestMapping("/administer")
    private String administer()throws  Exception{
        return "adminlogin";
    }

    @RequestMapping("/checkAdminister")
    private String checkAdminister(Administer administer, HttpSession session)throws  Exception{
        Administer administer1=administerService.checkAdminister(administer);
        if(administer1==null){
            session.setAttribute("loginResult","登录失败");
            return "adminlogin";
        }else{
            List<Recruitment> recruitments=recruitmentService.getRecruitmentByAdmin(administer1);
            session.setAttribute("recruitments",recruitments);
            List<Interview> interviews=interviewService.getInterviewByCid(administer1.getA_cid());
            session.setAttribute("interviews",interviews);
            List<Guest> guests=guestService.getGuest();
            session.setAttribute("guests",guests);
            List<Resume> resumes=resumeService.getResume();
            session.setAttribute("resumes",resumes);
            session.setAttribute("loginResult","");
            session.setAttribute("admin",administer1);
            return "adminmain";
        }
    }

    @RequestMapping("/addRecruitment")
    private String addrecruitment(Recruitment recruitment, HttpSession session)throws  Exception{
        Administer administer= (Administer) session.getAttribute("admin");
        recruitment.setRm_cid(administer.getA_cid());
        recruitmentService.addRecruitment(recruitment);
        List<Recruitment> recruitments=recruitmentService.getRecruitment();
        session.setAttribute("recruitments",recruitments);
        return "adminmain";
    }


    @RequestMapping("/checkRecruitment")
    private String checkRecruitment(HttpServletRequest request,HttpSession session)throws  Exception{
        int rm_id= Integer.parseInt(request.getParameter("rm_id"));
        Recruitment recruitment=recruitmentService.getRecruitmentById(rm_id);
        session.setAttribute("recruitment",recruitment);
        List<Guest> guests=guestService.getGuestByRecruitment(recruitment);
        session.setAttribute("guests",guests);
        List<Resume> resumes=resumeService.getResume();
        session.setAttribute("resumes",resumes);
        return "adminrecruitment";
    }

    @RequestMapping("/deleteRecruitment")
    private String deleteRecruitment(HttpServletRequest request,HttpSession session)throws  Exception{
        int rm_id= Integer.parseInt(request.getParameter("rm_id"));
        Recruitment recruitment=new Recruitment();
        recruitment.setRm_id(rm_id);
        recruitmentService.deleteRecruitment(recruitment);
        Administer administer= (Administer) session.getAttribute("admin");
        List<Recruitment> recruitments=recruitmentService.getRecruitmentByAdmin(administer);
        session.setAttribute("recruitments",recruitments);
        return "adminmain";
    }

    @RequestMapping("/updateRecruitment")
    private String updateRecruitment(Recruitment recruitment,HttpSession session)throws  Exception{
        recruitmentService.updateRecruitment(recruitment);
        session.setAttribute("recruitment",recruitment);
        Administer administer= (Administer) session.getAttribute("admin");
        List<Recruitment> recruitments=recruitmentService.getRecruitmentByAdmin(administer);
        session.setAttribute("recruitments",recruitments);
        return "adminrecruitment";
    }

    @RequestMapping("/checkGuest")
    private String checkGuest(HttpServletRequest request,HttpSession session)throws  Exception{
        int g_id = Integer.parseInt(request.getParameter("g_id"));
        Guest guest=new Guest();
        guest.setG_id(g_id);
        Resume resume=resumeService.getResumeByGid(guest);
        session.setAttribute("resume",resume);
        return "admintoguest";
    }

    @RequestMapping("/toadminrecruitment")
    private String toadminrecruitment()throws  Exception{
        return "adminrecruitment";
    }

    @RequestMapping("/toadminmain")
    private String toadminmain()throws  Exception{
        return "adminmain";
    }

    @RequestMapping("/addInterview")
    private String addInterview(Interview interview,HttpServletRequest request, HttpSession session)throws  Exception{
        Administer administer= (Administer) session.getAttribute("admin");
        interviewService.addInterview(interview);
        List<Interview> interviews=interviewService.getInterviewByCid(administer.getA_cid());
        session.setAttribute("interviews",interviews);
        return "adminrecruitment";
    }


    @RequestMapping("/recruitEmployee")
    private String recruitEmployee(HttpServletRequest request, HttpSession session)throws  Exception{
        int intid= Integer.parseInt(request.getParameter("intid"));
        Interview interview = new Interview();
        interview.setI_id(intid);
        interview.setI_gstatus(3);
        interviewService.updateInterviewStatus(interview);
        int gid=Integer.parseInt(request.getParameter("gid"));
        Guest guest=new Guest();
        guest.setG_id(gid);
        guest.setG_applicationstatus(1);
        guestService.updateGuestApplicationstatus(guest);
        Administer administer= (Administer) session.getAttribute("admin");
        List<Interview> interviews=interviewService.getInterviewByCid(administer.getA_cid());
        session.setAttribute("interviews",interviews);
        return "adminmain";
    }
}
