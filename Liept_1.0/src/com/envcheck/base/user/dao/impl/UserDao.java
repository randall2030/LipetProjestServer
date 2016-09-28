package com.envcheck.base.user.dao.impl;

import com.envcheck.base.dao.BaseDao;
import com.envcheck.base.user.bean.User;
import com.envcheck.base.user.dao.IUserDao;
import com.envcheck.base.utils.QueryHelper;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by Administrator on 2016/5/5.
 */
public class UserDao extends BaseDao<User> implements IUserDao {

    @Override
    public User findUserByNameAndPassword(QueryHelper helper) {

        Query query = sessionFactory.getCurrentSession().createQuery(helper.getQueryListHql());
        List<Object> list = helper.getQueryListParameters();

        if(list != null)
        {
            for(int i=0; i<list.size(); i++)
            {
                query.setParameter(i, list.get(i));
            }
        }
        return (User) query.uniqueResult();
    }

    @Override
    public User findUserByName(String user) {

        QueryHelper helper = new QueryHelper(User.class, "u");
        helper.addConditions("u.username=?", user);

        Query query = sessionFactory.getCurrentSession().createQuery(helper.getQueryListHql());
        List<Object> list = helper.getQueryListParameters();

        if(list != null)
        {
            for(int i=0; i<list.size(); i++)
            {
                query.setParameter(i, list.get(i));
            }
        }
        return (User) query.uniqueResult();
    }

    @Override
    public List<User> findUserByParentCompany(String parentCompany) {


        QueryHelper helper = new QueryHelper(User.class, "u");
        helper.addConditions("u.parentCompany=?", parentCompany);

        Query query = sessionFactory.getCurrentSession().createQuery(helper.getQueryListHql());
        List<Object> list = helper.getQueryListParameters();

        if(list != null)
        {
            for(int i=0; i<list.size(); i++)
            {
                query.setParameter(i, list.get(i));
            }
        }

        return query.list();

    }

    @Override
    public User findUserByCompanyNameCn(String childPlatformName) {
        QueryHelper helper = new QueryHelper(User.class, "u");
        helper.addConditions("u.companyNameCN=?", childPlatformName);

        Query query = sessionFactory.getCurrentSession().createQuery(helper.getQueryListHql());
        List<Object> list = helper.getQueryListParameters();

        if(list != null)
        {
            for(int i=0; i<list.size(); i++)
            {
                query.setParameter(i, list.get(i));
            }
        }
        List resultList = query.list();

        if(resultList != null && resultList.size() > 0){
            return (User) resultList.get(0);
        }

        return null;
    }
}
