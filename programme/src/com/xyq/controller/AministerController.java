package com.xyq.controller;

import com.mysql.fabric.xmlrpc.base.Data;
import com.xyq.model.*;
import com.xyq.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Resource
    private EmployeeService employeeService;
    @Resource
    private ApplicationService applicationService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private JobService jobService;
    @Resource
    private TrainService trainService;
    @Resource
    private RewardService rewardService;
    @Resource
    private SalaryService salaryService;
    @Resource
    private AttendanceService attendanceService;

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
            List<Department> departments=departmentService.getDepartmentByCid(administer1.getA_cid());
            session.setAttribute("depts",departments);
            List<Job> jobs=jobService.getJob(administer1.getA_cid());
            session.setAttribute("jobs",jobs);
            List<Employee> employees=employeeService.getEmployee(administer1.getA_cid());
            session.setAttribute("employees",employees);
            List<Train> trains=trainService.getTrain(administer1.getA_cid());
            session.setAttribute("trains",trains);
            List<Salary> salaries=salaryService.getSalaryByCid(administer1.getA_cid());
            session.setAttribute("allSalaries",salaries);
            List<Reward> rewards=rewardService.getRewardByCid(administer1.getA_cid());
            session.setAttribute("rewards",rewards);
            session.setAttribute("loginResult","");
            session.setAttribute("admin",administer1);
            return "adminmain";
        }
    }

    @RequestMapping("/addRecruitment")
    private String addrecruitment(Recruitment recruitment,HttpSession session)throws  Exception{
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
        List<Guest> guests=guestService.getGuest();
        session.setAttribute("guests",guests);
        List<Application> applications=applicationService.getApplicationByRecruitment(rm_id);
        session.setAttribute("applications",applications);
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
        Employee employee=new Employee();
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYY-MM-dd");
        String hiretime=simpleDateFormat.format(date);
        employee.setE_hiretime(hiretime);
        Guest guest1=guestService.getGuestById(gid);
        employee.setE_name(guest1.getG_name());
        employee.setE_password(guest1.getG_password());
        employee.setE_workstatus(1);
        Resume resume=resumeService.getResumeByGid(guest1);
        employee.setE_realname(resume.getR_name());
        employee.setE_age(resume.getR_age());
        employee.setE_ethnicity(resume.getR_ethnicity());
        employee.setE_phone(resume.getR_phone());
        employee.setE_marrige(resume.getR_marrige());
        employee.setE_address(resume.getR_address());
        employee.setE_cid(administer.getA_cid());
        int rm_id= Integer.parseInt(request.getParameter("rec"));
        Recruitment recruitment=recruitmentService.getRecruitmentById(rm_id);
        employee.setE_did(recruitment.getRm_did());
        employee.setE_jid(recruitment.getRm_jid());
        employee.setE_basicwage(0);
        employee.setE_workstarttime("9:00");
        employee.setE_workendtime("18:00");
        employeeService.addEmployee(employee);
        List<Employee> employees=employeeService.getEmployee(administer.getA_cid());
        session.setAttribute("employees",employees);
        return "adminmain";
    }

    @RequestMapping("/deleteDepartment")
    private String deleteDepartment(Department department,HttpSession session)throws  Exception{
        departmentService.deleteDepartment(department);
        Administer administer= (Administer) session.getAttribute("admin");
        List<Department> departments=departmentService.getDepartmentByCid(administer.getA_cid());
        session.setAttribute("depts",departments);
        return "adminmain";
    }

    @RequestMapping("/addDepartment")
    private String addDepartment(Department department,HttpSession session)throws  Exception{
        Administer administer= (Administer) session.getAttribute("admin");
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYY-MM-dd");
        String createtime=simpleDateFormat.format(date);
        department.setD_createtime(createtime);
        department.setD_cid(administer.getA_cid());
        List<Department> departments=departmentService.getDepartmentByCid(administer.getA_cid());
        boolean flag=true;
        for (Department dep:departments){
            if(dep.getD_name().equals(department.getD_name())){
                flag=false;
                break;
            }
        }
        if (flag) {
            departmentService.addDepartment(department);
        }
        departments=departmentService.getDepartmentByCid(administer.getA_cid());
        session.setAttribute("depts",departments);
        return "adminmain";
    }

    @RequestMapping("/updateDepartment")
    private String updateDepartment(Department department,HttpSession session)throws  Exception{
        Administer administer= (Administer) session.getAttribute("admin");
        departmentService.updateDepartment(department);
        List<Department> departments=departmentService.getDepartmentByCid(administer.getA_cid());
        session.setAttribute("depts",departments);
        return "adminmain";
    }

    @RequestMapping("/addJob")
    private String addJob(Job job,HttpSession session)throws  Exception{
        Administer administer= (Administer) session.getAttribute("admin");
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYY-MM-dd");
        String createtime=simpleDateFormat.format(date);
        job.setJ_createtime(createtime);
        job.setJ_cid(administer.getA_cid());
        List<Job> jobs=jobService.getJob(administer.getA_cid());
        boolean flag=true;
        for (Job jo:jobs){
            if(jo.getJ_name().equals(job.getJ_name())&&jo.getJ_did()==job.getJ_did()){
                flag=false;
                break;
            }
        }
        if (flag) {
            jobService.addJob(job);
        }
        jobs=jobService.getJob(administer.getA_cid());
        session.setAttribute("jobs",jobs);
        return "adminmain";
    }

    @RequestMapping("/updateJob")
    private String updateJob(Job job,HttpSession session)throws  Exception{
        Administer administer= (Administer) session.getAttribute("admin");
        jobService.updateJob(job);
        List<Job> jobs=jobService.getJob(administer.getA_cid());
        session.setAttribute("jobs",jobs);
        return "adminmain";
    }

    @RequestMapping("/deleteJob")
    private String deleteJob(Job job,HttpSession session)throws  Exception{
        Administer administer= (Administer) session.getAttribute("admin");
        jobService.deleteJob(job);
        List<Job> jobs=jobService.getJob(administer.getA_cid());
        session.setAttribute("jobs",jobs);
        return "adminmain";
    }

    @RequestMapping("/getJobByDept")
    private @ResponseBody List<Job> getJobByDept(int d)throws Exception{
        Department department=new Department();
        department.setD_id(d);
        List<Job> jobs=jobService.getJobByDepartment(department);
        return jobs;
    }

    @RequestMapping("/updateEmployeeJob")
    private String updateEmployeeJob(Employee employee,HttpSession session)throws  Exception{
        employeeService.updateEmployeeJob(employee);
        Administer administer= (Administer) session.getAttribute("admin");
        List<Employee> employees=employeeService.getEmployee(administer.getA_cid());
        session.setAttribute("employees",employees);
        return "adminmain";
    }

    @RequestMapping("/updateEmpMoney")
    private String updateEmpMoney(Employee employee,HttpSession session)throws  Exception{
        employeeService.updateEmployeeMoney(employee);
        Administer administer= (Administer) session.getAttribute("admin");
        List<Employee> employees=employeeService.getEmployee(administer.getA_cid());
        session.setAttribute("employees",employees);
        return "adminmain";
    }

    @RequestMapping("/updateEmpWorkStatus")
    private String updateEmpWorkStatus(Employee employee,HttpSession session)throws  Exception{
        employee.setE_workstatus(2);
        employeeService.updateEmployeeWorkstatus(employee);
        Administer administer= (Administer) session.getAttribute("admin");
        List<Employee> employees=employeeService.getEmployee(administer.getA_cid());
        session.setAttribute("employees",employees);
        return "adminmain";
    }

    @RequestMapping("/fireEmployee")
    private String fireEmployee(Employee employee,HttpSession session)throws  Exception{
        employee.setE_workstatus(0);
        employeeService.updateEmployeeWorkstatus(employee);
        List<Guest> guests=guestService.getGuest();
        for (Guest guest:guests) {
            if(guest.getG_name().equals(employee.getE_name())){
                guest.setG_applicationstatus(0);
                guestService.updateGuestApplicationstatus(guest);
                break;
            }
        }
        Administer administer= (Administer) session.getAttribute("admin");
        List<Employee> employees=employeeService.getEmployee(administer.getA_cid());
        session.setAttribute("employees",employees);
        return "adminmain";
    }

    @RequestMapping("/deleteTrain")
    private String deleteTrain(Train train,HttpSession session)throws  Exception{
        Administer administer= (Administer) session.getAttribute("admin");
        trainService.deleteTrain(train);
        List<Train> trains=trainService.getTrain(administer.getA_cid());
        session.setAttribute("trains",trains);
        return "adminmain";
    }

    @RequestMapping("/addTrain")
    private String addTrain(Train train,HttpSession session)throws  Exception{
        Administer administer= (Administer) session.getAttribute("admin");
        train.setT_cid(administer.getA_cid());
        trainService.addTrain(train);
        List<Train> trains=trainService.getTrain(administer.getA_cid());
        session.setAttribute("trains",trains);
        return "adminmain";
    }

    @RequestMapping("/updateTrain")
    private String updateTrain(Train train,HttpSession session)throws  Exception{
        Administer administer= (Administer) session.getAttribute("admin");
        trainService.updateTrain(train);
        List<Train> trains=trainService.getTrain(administer.getA_cid());
        session.setAttribute("trains",trains);
        return "adminmain";
    }

    @RequestMapping("/rewardEmployee")
    private @ResponseBody String rewardEmployee(Reward reward,HttpSession session)throws  Exception{
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYY-MM-dd");
        String re_time=simpleDateFormat.format(date);
        reward.setRe_time(re_time);
        rewardService.insertReward(reward);
        List<Reward> rewards=rewardService.getRewardByCid(reward.getRe_cid());
        session.setAttribute("rewards",rewards);
        return "";
    }

    @RequestMapping("/getLastSalaryByEid")
    private @ResponseBody String getLastSalaryByEid(Salary salary,HttpSession session)throws  Exception{
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYY");
        int year= Integer.parseInt(simpleDateFormat.format(date));
        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("MM");
        int month= Integer.parseInt(simpleDateFormat1.format(date));
        if(month==1){
            year--;
            month=12;
        }else {
            month--;
        }
        String s_date;
        if (month<10) {
            s_date = year + "-0" + month;
        }else {
            s_date = year + "-" + month;
        }
        salary.setS_date(s_date);
        Salary salary1=salaryService.getLastMonthSalaryByEid(salary);
        if(salary1!=null){
            return "already";
        }
        return "";
    }

    @RequestMapping("/accountSalary")
    private @ResponseBody String accountSalary(Salary salary,HttpSession session)throws  Exception{
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYY");
        int year= Integer.parseInt(simpleDateFormat.format(date));
        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("MM");
        int month= Integer.parseInt(simpleDateFormat1.format(date));
        if(month==1){
            year--;
            month=12;
        }else {
            month--;
        }
        String s_date;
        if (month<10) {
            s_date = year + "-0" + month;
        }else {
            s_date = year + "-" + month;
        }
        salary.setS_date(s_date);
        Salary salary1=salaryService.getLastMonthSalaryByEid(salary);
        if(salary1==null){
            int workstatus=0;
            List<Employee> employees=employeeService.getEmployee(salary.getS_cid());
            for (Employee employee:employees){
                if(employee.getE_id()==salary.getS_eid()){
                    salary.setS_basic(employee.getE_basicwage());//
                    workstatus=employee.getE_workstatus();
                }
            }
            List<Reward> rewards=rewardService.getRewardByEid(salary.getS_eid());
            for (Reward reward:rewards){
                if(reward.getRe_time().contains(s_date)){
                    salary.setS_reward(salary.getS_reward()+reward.getRe_money());
                }
            }
            List<Attendance> attendances=attendanceService.getAttendanceByEid(salary.getS_eid());
            int att0=22-attendances.size();
            int att2=0;
            int att3=0;
            for(Attendance attendance:attendances){
                if(attendance.getAt_day().contains(s_date)){
                    if(attendance.getAt_endresult()==0){
                        att0++;
                        break;
                    }else if(attendance.getAt_startresult()==0){
                        att0++;
                        break;
                    }else if(attendance.getAt_startresult()==2){
                        att2++;
                    }else if(attendance.getAt_startresult()==3){
                        att3++;
                    }else if(attendance.getAt_endresult()==2){
                        att2++;
                    }else if(attendance.getAt_endresult()==3){
                        att3++;
                    }
                }
            }
            salary.setS_bonus(salary.getS_basic()*(0.8*att2+0.5*att3+1*att0)/22);
            salary.setS_status(1);
            salary.setS_money(salary.getS_basic()-salary.getS_bonus()+salary.getS_reward());
            if (workstatus==1){
                salary.setS_money((salary.getS_basic()*0.8-salary.getS_bonus()+salary.getS_reward())*0.88);
            }else {
                salary.setS_money((salary.getS_basic()-salary.getS_bonus()+salary.getS_reward())*0.88);
            }
            if(salary.getS_money()<0){
                salary.setS_money(0);
            }
            salaryService.insertSalary(salary);
        }
        return "";
    }

    @RequestMapping("/checkEmployeeAttendance")
    private String checkEmployeeAttendance(Employee employee,HttpSession session)throws  Exception{
        List<Attendance> attendances=attendanceService.getAttendanceByEid(employee.getE_id());
        session.setAttribute("attendances",attendances);
        return "admincheckatt";
    }

    @RequestMapping("/replyQuestionSalary")
    private @ResponseBody String replyQuestionSalary(Reward reward,Salary salary,HttpSession session)throws  Exception{
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYY-MM-dd");
        String re_time=simpleDateFormat.format(date);
        reward.setRe_time(re_time);
        rewardService.insertReward(reward);
        List<Reward> rewards=rewardService.getRewardByCid(reward.getRe_cid());
        session.setAttribute("rewards",rewards);
        salary.setS_status(2);
        salaryService.updateSalaryStatus(salary);
        Administer administer= (Administer) session.getAttribute("admin");
        List<Salary> salaries=salaryService.getSalaryByCid(administer.getA_cid());
        session.setAttribute("allSalaries",salaries);
        return "";
    }
}
