package com.xyq.dao;

import com.xyq.model.Department;

import java.util.List;

/**
 * Created by asus on 2018/2/2.
 */
public interface DepartmentMapper {
    List<Department> getDepartmentByCid(int c_id);
    Department getDepartmentById(int d_id);
    void addDepartment(Department department);
    void deleteDepartment(Department department);
    void updateDepartment(Department department);
}
