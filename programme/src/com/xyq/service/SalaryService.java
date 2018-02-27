package com.xyq.service;

import com.xyq.model.Salary;

import java.util.List;

/**
 * Created by asus on 2018/2/27.
 */
public interface SalaryService {
    Salary getLastMonthSalaryByEid(Salary salary);
    List<Salary> getLastMonthSalaryByCid(Salary salary);
    void insertSalary(Salary salary);
    List<Salary> getSalaryByCid(int cid);
    List<Salary> getSalaryByEid(int eid);
    void updateSalaryStatus(Salary salary);
}
