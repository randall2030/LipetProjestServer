package com.envcheck.paramsetting.checkrepairsetting.minchecktime.service;

import com.envcheck.base.service.IBaseService;
import com.envcheck.paramsetting.checkrepairsetting.densitymanage.bean.StandGasTheoryCon;
import com.envcheck.paramsetting.checkrepairsetting.minchecktime.bean.MinCheckTime;

/**
 * Created by Administrator on 2016/5/6.
 */
public interface IMinCheckTimeService extends IBaseService<MinCheckTime> {
    MinCheckTime getCurrentExecuteMinCheckTime();
}
