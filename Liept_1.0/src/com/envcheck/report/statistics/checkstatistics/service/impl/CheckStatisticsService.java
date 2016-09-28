package com.envcheck.report.statistics.checkstatistics.service.impl;

import com.envcheck.base.bean.ModuleCheck;
import com.envcheck.base.service.impl.BaseService;
import com.envcheck.report.statistics.checkstatistics.dao.ICheckStatisticsDao;
import com.envcheck.report.statistics.checkstatistics.service.ICheckStatisticsService;

/**
 * Created by Administrator on 2016/6/5.
 */
public class CheckStatisticsService extends BaseService<ModuleCheck> implements ICheckStatisticsService {

    private ICheckStatisticsDao checkStatisticsDao;

    public ICheckStatisticsDao getCheckStatisticsDao() {
        return checkStatisticsDao;
    }
    public void setCheckStatisticsDao(ICheckStatisticsDao checkStatisticsDao) {
        super.setBaseDao(checkStatisticsDao);
        this.checkStatisticsDao = checkStatisticsDao;
    }
}
