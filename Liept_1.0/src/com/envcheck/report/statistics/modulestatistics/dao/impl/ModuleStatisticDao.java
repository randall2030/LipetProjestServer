package com.envcheck.report.statistics.modulestatistics.dao.impl;

import com.envcheck.base.bean.Module;
import com.envcheck.base.dao.BaseDao;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.report.statistics.modulestatistics.dao.IModuleStatisticDao;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by Administrator on 2016/6/3.
 */
public class ModuleStatisticDao extends BaseDao<Module> implements IModuleStatisticDao {

    @Override
    public long getAllNumber(QueryHelper qh) {

        List<Object> list = qh.getQueryListParameters();

        //查询总记录
        Query queryCount = sessionFactory.getCurrentSession().createQuery(qh.getQueryCountHql());
        if(list.size()>0){
           for(int i = 0; i < list.size(); i++){
                queryCount.setParameter(i, list.get(i));
           }
        }

        long totalCount = (Long)queryCount.uniqueResult();

        return totalCount;
    }
}
