package com.xyq.service.impl;

import com.xyq.dao.EmployeeMapper;
import com.xyq.model.Employee;
import com.xyq.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by asus on 2018/2/1.
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeMapper employeeMapper;
    @Override
    public void addEmployee(Employee employee) {
        employeeMapper.addEmployee(employee);
    }

    @Override
    public Employee checkEmployee(Employee employee) {
        return employeeMapper.checkEmployee(employee);
    }

    @Override
    public List<Employee> getEmployee(int cid) {
        return employeeMapper.getEmployee(cid);
    }

    @Override
    public void updateEmployeeJob(Employee employee) {
        employeeMapper.updateEmployeeJob(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
    }

    @Override
    public void updateEmployeeMoney(Employee employee) {
        employeeMapper.updateEmployeeMoney(employee);
    }

    @Override
    public void updateEmployeeWorkstatus(Employee employee) {
        employeeMapper.updateEmployeeWorkstatus(employee);
    }
}
