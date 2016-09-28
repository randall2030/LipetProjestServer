package com.envcheck.tool.startnewcheck.service;


import com.envcheck.base.bean.discharge_check_history.HistoryModuleCheck;
import com.envcheck.base.bean.discharge_check_history.HistoryModuleRepairRecord;
import com.envcheck.base.service.IBaseService;

import java.util.Date;

/**
 * Created by Administrator on 2016/5/5.
 */
public interface IHistoryModuleRepairRecordService extends IBaseService<HistoryModuleRepairRecord> {

    HistoryModuleRepairRecord getHistoryModuleRepairRecordByModuleIdAndEndPeriodTime(String id, Date endTime);
}
