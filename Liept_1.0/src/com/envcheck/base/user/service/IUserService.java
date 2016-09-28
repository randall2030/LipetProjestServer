package com.envcheck.base.user.service;

import com.envcheck.base.service.IBaseService;
import com.envcheck.base.user.bean.User;
import com.envcheck.base.utils.QueryHelper;

import java.util.List;

/**
 * Created by Administrator on 2016/5/6.
 */
public interface IUserService extends IBaseService<User> {
    User findUserByNameAndPassword(QueryHelper helper);

    User findUserByName(String user);

    List<User> findUserByParentCompany(String parentCompany);

    User findUserByCompanyNameCn(String childPlatformName);
}

