package com.xyq.controller;

import com.xyq.model.*;
import com.xyq.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by asus on 2018/2/1.
 */
@Controller
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;
    @Resource
    private CompanyService companyService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private JobService jobService;
    @Resource
    private TrainService trainService;
    @Resource
    private AttendanceService attendanceService;
    @Resource
    private RewardService rewardService;
    @Resource
    private SalaryService salaryService;

    @RequestMapping("/employee")
    private String employee()throws Exception{
        return "employeelogin";
    }

    @RequestMapping("/checkEmployee")
    private String checkEmployee(Employee employee, HttpSession session)throws  Exception{
        Employee employee1=employeeService.checkEmployee(employee);
        if(employee1==null){
            session.setAttribute("loginResult","登录失败");
            return "employeelogin";
        }else{
            session.setAttribute("loginResult","");
            session.setAttribute("employee",employee1);
            List<Company> companies=companyService.getCompany();
            session.setAttribute("companies",companies);
            List<Department> departments=departmentService.getDepartmentByCid(employee1.getE_cid());
            session.setAttribute("depts",departments);
            List<Job> jobs=jobService.getJob(employee1.getE_cid());
            session.setAttribute("jobs",jobs);
            List<Train> trains=trainService.getTrainByDid(employee1.getE_did());
            session.setAttribute("trains",trains);
            List<Attendance> attendances=attendanceService.getAttendanceByEid(employee1.getE_id());
            session.setAttribute("attendances",attendances);
            List<Reward> rewards=rewardService.getRewardByEid(employee1.getE_id());
            session.setAttribute("rewards",rewards);
            List<Salary> salaries=salaryService.getSalaryByEid(employee1.getE_id());
            session.setAttribute("salaries",salaries);
            List<Employee> employees=employeeService.getEmployee(employee1.getE_cid());
            session.setAttribute("employees",employees);
            return "employeemain";
        }
    }

    @RequestMapping("/updateEmployee")
    private String updateEmployee(Employee employee, HttpSession session)throws  Exception{
        employeeService.updateEmployee(employee);
        Employee employee1=employeeService.checkEmployee(employee);
        session.setAttribute("employee",employee1);
        return "employeemain";
    }

    @RequestMapping("/questionSalary")
    private String questionSalary(Salary salary, HttpSession session)throws  Exception{
        salary.setS_status(0);
        salaryService.updateSalaryStatus(salary);
        List<Salary> salaries=salaryService.getSalaryByEid(salary.getS_eid());
        session.setAttribute("salaries",salaries);
        return "employeemain";
    }

    @RequestMapping("/startWork")
    private String startWork(Attendance attendance,HttpSession session)throws  Exception{
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYY-MM-dd");
        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("HH:mm:ss");
        String at_day=simpleDateFormat.format(date);
        String at_starttime=simpleDateFormat1.format(date);
        attendance.setAt_day(at_day);
        attendance.setAt_starttime(at_starttime);
        Date starttime=simpleDateFormat1.parse(at_starttime);
        Date stime=simpleDateFormat1.parse("00:00:00");
        int time= (int) (starttime.getTime()-stime.getTime());
        if(time<=32400000){
            attendance.setAt_startresult(1);
        }else if(32400000<time&&time<=36000000){
            attendance.setAt_startresult(2);
        }else if(36000000<time&&time<=43200000){
            attendance.setAt_startresult(3);
        }else {
            attendance.setAt_startresult(0);
        }
        List<Attendance> attendances=attendanceService.getAttendanceByEid(attendance.getAt_eid());
        boolean result=true;
        for (Attendance att:attendances){
            if(att.getAt_day().equals(at_day)){
                att.setAt_starttime(at_starttime);
                att.setAt_startresult(attendance.getAt_startresult());
                att.setAt_endtime("");
                att.setAt_endresult(0);
                attendanceService.updateWork(att);
                result=false;
            }
        }
        if(result) {
            attendanceService.insertStartWork(attendance);
        }
        List<Attendance> attendances1=attendanceService.getAttendanceByEid(attendance.getAt_eid());
        session.setAttribute("attendances",attendances1);
        return "employeemain";
    }

    @RequestMapping("/endWork")
    private String endWork(Attendance attendance,HttpSession session)throws  Exception{
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYY-MM-dd");
        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("HH:mm:ss");
        String at_day=simpleDateFormat.format(date);
        String at_endtime=simpleDateFormat1.format(date);
        attendance.setAt_day(at_day);
        attendance.setAt_endtime(at_endtime);
        Date endtime=simpleDateFormat1.parse(at_endtime);
        Date stime=simpleDateFormat1.parse("00:00:00");
        int time= (int) (endtime.getTime()-stime.getTime());
        if(time<54000000){
            attendance.setAt_endresult(0);
        }else if(54000000<=time&&time<61200000){
            attendance.setAt_endresult(3);
        }else if(61200000<=time&&time<64800000){
            attendance.setAt_endresult(2);
        }else {
            attendance.setAt_endresult(1);
        }
        List<Attendance> attendances=attendanceService.getAttendanceByEid(attendance.getAt_eid());
        boolean result=true;
        for (Attendance att:attendances){
            if(att.getAt_day().equals(at_day)){
                att.setAt_endtime(at_endtime);
                att.setAt_endresult(attendance.getAt_endresult());
                att.setAt_starttime("");
                att.setAt_endresult(0);
                attendanceService.updateWork(att);
                result=false;
            }
        }
        if(result) {
            attendanceService.insertEndWork(attendance);
        }
        List<Attendance> attendances1=attendanceService.getAttendanceByEid(attendance.getAt_eid());
        session.setAttribute("attendances",attendances1);
        return "employeemain";
    }
}
