package com.envcheck.paramsetting.checkrepairsetting.minchecktime.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.paramsetting.checkrepairsetting.densitymanage.bean.StandGasTheoryCon;
import com.envcheck.paramsetting.checkrepairsetting.minchecktime.bean.MinCheckTime;
import com.envcheck.paramsetting.checkrepairsetting.minchecktime.dao.IMinCheckTimeDao;
import com.envcheck.paramsetting.checkrepairsetting.minchecktime.service.IMinCheckTimeService;

/**
 * Created by Administrator on 2016/5/6.
 */
public class MinCheckTimeService extends BaseService<MinCheckTime> implements IMinCheckTimeService {

    private IMinCheckTimeDao minCheckTimeDao;

    public IMinCheckTimeDao getMinCheckTimeDao() {
        return minCheckTimeDao;
    }

    public void setMinCheckTimeDao(IMinCheckTimeDao minCheckTimeDao) {
        super.setBaseDao(minCheckTimeDao);
        this.minCheckTimeDao = minCheckTimeDao;
    }

    @Override
    public MinCheckTime getCurrentExecuteMinCheckTime() {
        return minCheckTimeDao.getCurrentExecuteMinCheckTime();
    }
}
