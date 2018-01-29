package com.xyq.controller;

import com.xyq.model.Administer;
import com.xyq.model.Recruitment;
import com.xyq.service.AdministerService;
import com.xyq.service.RecruitmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
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
            List<Recruitment> recruitments=recruitmentService.getRecruitment();
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
}
