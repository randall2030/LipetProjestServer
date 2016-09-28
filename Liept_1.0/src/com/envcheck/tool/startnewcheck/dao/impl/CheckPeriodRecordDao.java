package com.envcheck.tool.startnewcheck.dao.impl;

import com.envcheck.base.bean.discharge_check_history.CheckPeriodRecord;
import com.envcheck.base.dao.BaseDao;
import com.envcheck.tool.startnewcheck.dao.ICheckPeroidRecordDao;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by Administrator on 2016/8/5.
 */
public class CheckPeriodRecordDao extends BaseDao<CheckPeriodRecord> implements ICheckPeroidRecordDao {

    @Override
    public CheckPeriodRecord getCheckPeroidRecordByName(String endPeriodName) {
        String hql = "FROM CheckPeriodRecord c WHERE c.periodName=?";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        query.setString(0, endPeriodName);
        return (CheckPeriodRecord) query.uniqueResult();
    }

    @Override
    public List<String> getAllPeriodName() {
        String hql = "SELECT c.periodName FROM CheckPeriodRecord c";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        return query.list();
    }

}
