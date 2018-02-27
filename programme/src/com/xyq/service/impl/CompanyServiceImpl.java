package com.xyq.service.impl;

import com.xyq.dao.CompanyMapper;
import com.xyq.model.Company;
import com.xyq.service.CompanyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by asus on 2018/1/30.
 */
@Service("companyService")
public class CompanyServiceImpl implements CompanyService {
    @Resource
    private CompanyMapper companyMapper;
    @Override
    public List<Company> getCompany() {
        return companyMapper.getCompany();
    }

    @Override
    public Company getCompanyByCid(int cid) {
        return companyMapper.getCompanyByCid(cid);
    }
}
