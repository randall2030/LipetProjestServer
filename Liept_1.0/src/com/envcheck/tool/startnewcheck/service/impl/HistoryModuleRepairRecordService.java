package com.envcheck.tool.startnewcheck.service.impl;

import com.envcheck.base.bean.discharge_check_history.HistoryModuleCheck;
import com.envcheck.base.bean.discharge_check_history.HistoryModuleRepairRecord;
import com.envcheck.base.service.impl.BaseService;
import com.envcheck.tool.startnewcheck.dao.IHistoryModuleCheckDao;
import com.envcheck.tool.startnewcheck.dao.IHistoryModuleRepairRecordDao;
import com.envcheck.tool.startnewcheck.service.IHistoryModuleCheckService;
import com.envcheck.tool.startnewcheck.service.IHistoryModuleRepairRecordService;

import java.util.Date;

/**
 * Created by lighter on 2016/5/8.
 */
public class HistoryModuleRepairRecordService extends BaseService<HistoryModuleRepairRecord> implements IHistoryModuleRepairRecordService {

    private IHistoryModuleRepairRecordDao historyModuleRepairRecordDao;

    public IHistoryModuleRepairRecordDao getHistoryModuleRepairRecordDao() {
        return historyModuleRepairRecordDao;
    }

    public void setHistoryModuleRepairRecordDao(IHistoryModuleRepairRecordDao historyModuleRepairRecordDao) {
        super.setBaseDao(historyModuleRepairRecordDao);
        this.historyModuleRepairRecordDao = historyModuleRepairRecordDao;
    }

    @Override
    public HistoryModuleRepairRecord getHistoryModuleRepairRecordByModuleIdAndEndPeriodTime(String id,Date endTime) {
        return historyModuleRepairRecordDao.getHistoryModuleRepairRecordByModuleIdAndEndPeriodTime(id, endTime);
    }
}
