package com.envcheck.base.company.dao;

import com.envcheck.base.company.bean.Company;
import com.envcheck.base.dao.IBaseDao;
import com.envcheck.base.user.bean.User;
import com.envcheck.base.utils.QueryHelper;

import java.util.List;

/**
 * Created by Administrator on 2016/5/5.
 */
public interface ICompanyDao extends IBaseDao<Company> {

    List<String> getParentSimpleNameList();

    List<String> getCompanySimpleNameList();

    List<String> getCompanyCNNameList();

    String getSimpleNameByCompanyNameCn(String companyNameCn);
}

