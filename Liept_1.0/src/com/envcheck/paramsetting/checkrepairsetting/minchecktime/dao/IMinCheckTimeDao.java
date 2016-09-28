package com.envcheck.paramsetting.checkrepairsetting.minchecktime.dao;


import com.envcheck.base.dao.IBaseDao;
import com.envcheck.paramsetting.checkrepairsetting.densitymanage.bean.StandGasTheoryCon;
import com.envcheck.paramsetting.checkrepairsetting.minchecktime.bean.MinCheckTime;

/**
 * Created by Administrator on 2016/5/5.
 */
public interface IMinCheckTimeDao extends IBaseDao<MinCheckTime> {
    MinCheckTime getCurrentExecuteMinCheckTime();
}
