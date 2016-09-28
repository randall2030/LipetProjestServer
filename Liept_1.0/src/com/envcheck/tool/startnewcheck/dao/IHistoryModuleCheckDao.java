package com.envcheck.tool.startnewcheck.dao;

import com.envcheck.base.bean.discharge_check_history.CheckPeriodRecord;
import com.envcheck.base.bean.discharge_check_history.HistoryModuleCheck;
import com.envcheck.base.dao.IBaseDao;

import java.util.Date;

/**
 * Created by Administrator on 2016/5/5.
 */
public interface IHistoryModuleCheckDao extends IBaseDao<HistoryModuleCheck> {
    HistoryModuleCheck getHistoryModuleCheckByModuleId(String id, Date endTime);
}
