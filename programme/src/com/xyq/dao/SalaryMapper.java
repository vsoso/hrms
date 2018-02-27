package com.xyq.dao;

import com.xyq.model.Salary;

import java.util.List;

/**
 * Created by asus on 2018/2/27.
 */
public interface SalaryMapper {
    Salary getLastMonthSalaryByEid(Salary salary);
    List<Salary> getLastMonthSalaryByCid(Salary salary);
    List<Salary> getSalaryByCid(int cid);
    List<Salary> getSalaryByEid(int eid);
    void insertSalary(Salary salary);
    void updateSalaryStatus(Salary salary);
}
