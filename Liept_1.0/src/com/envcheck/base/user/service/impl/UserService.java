package com.envcheck.base.user.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.base.user.bean.User;
import com.envcheck.base.user.dao.IUserDao;
import com.envcheck.base.user.service.IUserService;
import com.envcheck.base.utils.QueryHelper;

import java.util.List;

/**
 * Created by Administrator on 2016/5/6.
 */
public class UserService extends BaseService<User> implements IUserService {

    private IUserDao userDao;
    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        super.setBaseDao(userDao);
        this.userDao = userDao;
    }


    @Override
    public User findUserByNameAndPassword(QueryHelper helper) {
        return userDao.findUserByNameAndPassword(helper);
    }

    @Override
    public User findUserByName(String user) {
        return userDao.findUserByName(user);
    }

    @Override
    public List<User> findUserByParentCompany(String parentCompany) {
        return userDao.findUserByParentCompany(parentCompany);
    }

    @Override
    public User findUserByCompanyNameCn(String childPlatformName) {
        return userDao.findUserByCompanyNameCn(childPlatformName);
    }
}
