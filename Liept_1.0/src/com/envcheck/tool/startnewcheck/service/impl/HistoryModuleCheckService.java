package com.envcheck.tool.startnewcheck.service.impl;

import com.envcheck.base.bean.discharge_check_history.CheckPeriodRecord;
import com.envcheck.base.bean.discharge_check_history.HistoryModuleCheck;
import com.envcheck.base.service.impl.BaseService;
import com.envcheck.tool.startnewcheck.dao.ICheckPeroidRecordDao;
import com.envcheck.tool.startnewcheck.dao.IHistoryModuleCheckDao;
import com.envcheck.tool.startnewcheck.service.ICheckPeroidRecordService;
import com.envcheck.tool.startnewcheck.service.IHistoryModuleCheckService;

import java.util.Date;

/**
 * Created by lighter on 2016/5/8.
 */
public class HistoryModuleCheckService extends BaseService<HistoryModuleCheck> implements IHistoryModuleCheckService {

    private IHistoryModuleCheckDao historyModuleCheckDao;

    public IHistoryModuleCheckDao getHistoryModuleCheckDao() {
        return historyModuleCheckDao;
    }

    public void setHistoryModuleCheckDao(IHistoryModuleCheckDao historyModuleCheckDao) {
        super.setBaseDao(historyModuleCheckDao);
        this.historyModuleCheckDao = historyModuleCheckDao;
    }

    @Override
    public HistoryModuleCheck getHistoryModuleCheckByModuleIdAndEndPeriodTime(String id, Date endTime) {
        return historyModuleCheckDao.getHistoryModuleCheckByModuleId(id, endTime);
    }
}
