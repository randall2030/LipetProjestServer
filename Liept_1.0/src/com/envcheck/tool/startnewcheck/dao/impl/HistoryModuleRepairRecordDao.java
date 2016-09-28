package com.envcheck.tool.startnewcheck.dao.impl;

import com.envcheck.base.bean.discharge_check_history.HistoryModuleRepairRecord;
import com.envcheck.base.dao.BaseDao;
import com.envcheck.tool.startnewcheck.dao.IHistoryModuleRepairRecordDao;
import org.hibernate.Query;

import java.util.Date;

/**
 * Created by Administrator on 2016/5/5.
 */
public class HistoryModuleRepairRecordDao extends BaseDao<HistoryModuleRepairRecord> implements IHistoryModuleRepairRecordDao {

    @Override
    public HistoryModuleRepairRecord getHistoryModuleRepairRecordByModuleIdAndEndPeriodTime(String id, Date endTime) {
        String hql = "FROM HistoryModuleRepairRecord m WHERE m.moduleId=?";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        query.setString(0, id);
       // query.setDate(1, endTime);
        return (HistoryModuleRepairRecord) query.uniqueResult();
    }
}
