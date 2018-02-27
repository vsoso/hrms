package com.xyq.service.impl;

import com.xyq.dao.SalaryMapper;
import com.xyq.model.Salary;
import com.xyq.service.SalaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by asus on 2018/2/27.
 */
@Service("salaryService")
public class SalaryServiceImpl implements SalaryService {
    @Resource
    private SalaryMapper salaryMapper;


    @Override
    public Salary getLastMonthSalaryByEid(Salary salary) {
        return salaryMapper.getLastMonthSalaryByEid(salary);
    }

    @Override
    public List<Salary> getLastMonthSalaryByCid(Salary salary) {
        return salaryMapper.getLastMonthSalaryByCid(salary);
    }

    @Override
    public void insertSalary(Salary salary) {
        salaryMapper.insertSalary(salary);
    }

    @Override
    public List<Salary> getSalaryByCid(int cid) {
        return salaryMapper.getSalaryByCid(cid);
    }

    @Override
    public List<Salary> getSalaryByEid(int eid) {
        return salaryMapper.getSalaryByEid(eid);
    }

    @Override
    public void updateSalaryStatus(Salary salary) {
        salaryMapper.updateSalaryStatus(salary);
    }
}
