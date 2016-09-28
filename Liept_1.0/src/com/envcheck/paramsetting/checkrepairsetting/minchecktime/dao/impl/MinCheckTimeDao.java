package com.envcheck.paramsetting.checkrepairsetting.minchecktime.dao.impl;

import com.envcheck.base.dao.BaseDao;
import com.envcheck.paramsetting.checkrepairsetting.densitymanage.bean.StandGasTheoryCon;
import com.envcheck.paramsetting.checkrepairsetting.minchecktime.bean.MinCheckTime;
import com.envcheck.paramsetting.checkrepairsetting.minchecktime.dao.IMinCheckTimeDao;
import com.envcheck.paramsetting.laws.bean.Law;
import org.hibernate.Query;

/**
 * Created by Administrator on 2016/5/5.
 */
public class MinCheckTimeDao extends BaseDao<MinCheckTime> implements IMinCheckTimeDao {


    @Override
    public MinCheckTime getCurrentExecuteMinCheckTime() {
        String hql = "FROM MinCheckTime m where m.execute = true";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        return (MinCheckTime) query.uniqueResult();
    }
}
