package com.envcheck.base.company.service.impl;

import com.envcheck.base.company.bean.Company;
import com.envcheck.base.company.dao.ICompanyDao;
import com.envcheck.base.company.service.ICompanyService;
import com.envcheck.base.service.impl.BaseService;
import com.envcheck.base.user.bean.User;
import com.envcheck.base.user.dao.IUserDao;
import com.envcheck.base.user.service.IUserService;
import com.envcheck.base.utils.QueryHelper;

import java.util.List;

/**
 * Created by Administrator on 2016/5/6.
 */
public class CompanyService extends BaseService<Company> implements ICompanyService {

    private ICompanyDao companyDao;

    public ICompanyDao getCompanyDao() {
        return companyDao;
    }

    public void setCompanyDao(ICompanyDao companyDao) {
        super.setBaseDao(companyDao);
        this.companyDao = companyDao;
    }

    @Override
    public List<String> getParentSimpleNameList() {
        return companyDao.getParentSimpleNameList();
    }

    @Override
    public List<String> getCompanySimpleNameList() {
        return companyDao.getCompanySimpleNameList();
    }

    @Override
    public List<String> getCompanyCNNameList() {
        return companyDao.getCompanyCNNameList();
    }

    @Override
    public String getSimpleNameByCompanyNameCn(String companyNameCn) {
        return companyDao.getSimpleNameByCompanyNameCn(companyNameCn);
    }
}
