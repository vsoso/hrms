package com.xyq.service.impl;

import com.xyq.dao.EmployeeMapper;
import com.xyq.model.Employee;
import com.xyq.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
