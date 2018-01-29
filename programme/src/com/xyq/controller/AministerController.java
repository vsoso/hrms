package com.xyq.controller;

import com.xyq.model.Administer;
import com.xyq.model.Guest;
import com.xyq.model.Recruitment;
import com.xyq.service.AdministerService;
import com.xyq.service.GuestService;
import com.xyq.service.RecruitmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
