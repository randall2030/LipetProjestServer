package com.envcheck.tool.startnewcheck.dao;

import com.envcheck.base.bean.discharge_check_history.HistoryModuleCheck;
import com.envcheck.base.bean.discharge_check_history.HistoryModuleRepairRecord;
import com.envcheck.base.dao.IBaseDao;

import java.util.Date;

/**
 * Created by Administrator on 2016/5/5.
 */
public interface IHistoryModuleRepairRecordDao extends IBaseDao<HistoryModuleRepairRecord> {
    HistoryModuleRepairRecord getHistoryModuleRepairRecordByModuleIdAndEndPeriodTime(String id, Date endTime);
}
