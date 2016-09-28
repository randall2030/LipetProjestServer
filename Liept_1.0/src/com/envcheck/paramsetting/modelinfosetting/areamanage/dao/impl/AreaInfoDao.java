package com.envcheck.paramsetting.modelinfosetting.areamanage.dao.impl;

import com.envcheck.base.dao.BaseDao;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.modelinfosetting.areamanage.bean.AreaInfo;
import com.envcheck.paramsetting.modelinfosetting.areamanage.dao.IAreaInfoDao;
import com.envcheck.paramsetting.modelinfosetting.devicemanage.bean.DeviceInfo;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by Administrator on 2016/5/5.
 */
public class AreaInfoDao extends BaseDao<AreaInfo> implements IAreaInfoDao {
    @Override
    public List<AreaInfo> findAreaByAreaName(QueryHelper areaHelper) {


        Query query = sessionFactory.getCurrentSession().createQuery(areaHelper.getQueryListHql());
        List<Object> list = areaHelper.getQueryListParameters();

        if(list != null)
        {
            for(int i=0; i<list.size(); i++)
            {
                query.setParameter(i, list.get(i));
            }
        }

        return (List<AreaInfo>) query.list();

    }

    @Override
    public List<String> getAllAreaName() {
        String hql = "SELECT a.areaName FROM AreaInfo a";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        return query.list();
    }
}
