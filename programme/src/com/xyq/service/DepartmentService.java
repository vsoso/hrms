package com.xyq.service;

import com.xyq.model.Department;

import java.util.List;

/**
 * Created by asus on 2018/2/2.
 */
public interface DepartmentService {
    List<Department> getDepartment();
    Department getDepartmentById(int d_id);
    void addDepartment(Department department);
    void deleteDepartment(Department department);
    void updateDepartment(Department department);
}
