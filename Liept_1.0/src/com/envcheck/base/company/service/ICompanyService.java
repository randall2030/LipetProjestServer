package com.envcheck.base.company.service;

import com.envcheck.base.company.bean.Company;
import com.envcheck.base.service.IBaseService;
import com.envcheck.base.user.bean.User;
import com.envcheck.base.utils.QueryHelper;

import java.util.List;

/**
 * Created by Administrator on 2016/5/6.
 */
public interface ICompanyService extends IBaseService<Company> {

    List<String> getParentSimpleNameList();

    List<String> getCompanySimpleNameList();

    List<String> getCompanyCNNameList();

    String getSimpleNameByCompanyNameCn(String companyNameCn);
}

