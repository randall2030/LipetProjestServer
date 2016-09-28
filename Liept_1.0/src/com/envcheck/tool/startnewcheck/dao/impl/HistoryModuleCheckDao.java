package com.envcheck.tool.startnewcheck.dao.impl;

import com.envcheck.base.bean.discharge_check_history.CheckPeriodRecord;
import com.envcheck.base.bean.discharge_check_history.HistoryModuleCheck;
import com.envcheck.base.dao.BaseDao;
import com.envcheck.tool.startnewcheck.dao.ICheckPeroidRecordDao;
import com.envcheck.tool.startnewcheck.dao.IHistoryModuleCheckDao;
import org.hibernate.Query;

import java.util.Date;

/**
 * Created by Administrator on 2016/5/5.
 */
public class HistoryModuleCheckDao extends BaseDao<HistoryModuleCheck> implements IHistoryModuleCheckDao {

    @Override
    public HistoryModuleCheck getHistoryModuleCheckByModuleId(String id, Date endTime) {
        String hql = "FROM HistoryModuleCheck m WHERE m.moduleId=?";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        query.setString(0, id);
     //   query.setDate(1, endTime);

        return (HistoryModuleCheck) query.uniqueResult();
    }
}
