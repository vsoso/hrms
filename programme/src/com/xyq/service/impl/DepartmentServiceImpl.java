package com.xyq.service.impl;

import com.xyq.dao.DepartmentMapper;
import com.xyq.model.Department;
import com.xyq.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by asus on 2018/2/2.
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentMapper departmentMapper;


    @Override
    public List<Department> getDepartmentByCid(int c_id) {
        return departmentMapper.getDepartmentByCid(c_id);
    }

    @Override
    public Department getDepartmentById(int d_id) {
        return departmentMapper.getDepartmentById(d_id);
    }

    @Override
    public void addDepartment(Department department) {
        departmentMapper.addDepartment(department);
    }

    @Override
    public void deleteDepartment(Department department) {
        departmentMapper.deleteDepartment(department);
    }

    @Override
    public void updateDepartment(Department department) {
        departmentMapper.updateDepartment(department);
    }
}
