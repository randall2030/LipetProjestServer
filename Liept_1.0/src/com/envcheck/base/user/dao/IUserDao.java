package com.envcheck.base.user.dao;

import com.envcheck.base.dao.IBaseDao;
import com.envcheck.base.user.bean.User;
import com.envcheck.base.utils.QueryHelper;

import java.util.List;

/**
 * Created by Administrator on 2016/5/5.
 */
public interface IUserDao extends IBaseDao<User> {

    User findUserByNameAndPassword(QueryHelper helper);

    User findUserByName(String user);

    List<User> findUserByParentCompany(String parentCompany);

    User findUserByCompanyNameCn(String childPlatformName);
}

