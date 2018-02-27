package com.xyq.dao;

import com.xyq.model.Employee;

import java.util.List;

/**
 * Created by asus on 2018/2/1.
 */
public interface EmployeeMapper {
    void addEmployee(Employee employee);
    Employee checkEmployee(Employee employee);
    List<Employee> getEmployee(int cid);
    void updateEmployeeJob(Employee employee);
    void updateEmployee(Employee employee);
    void updateEmployeeMoney(Employee employee);
    void updateEmployeeWorkstatus(Employee employee);
}
