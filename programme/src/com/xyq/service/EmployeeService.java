package com.xyq.service;

import com.xyq.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by asus on 2018/2/1.
 */

public interface EmployeeService {
    void addEmployee(Employee employee);
    Employee checkEmployee(Employee employee);
    List<Employee> getEmployee(int cid);
    void updateEmployeeJob(Employee employee);
    void updateEmployee(Employee employee);
    void updateEmployeeMoney(Employee employee);
    void updateEmployeeWorkstatus(Employee employee);
}
