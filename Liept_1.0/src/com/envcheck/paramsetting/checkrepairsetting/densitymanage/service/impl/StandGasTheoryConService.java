package com.envcheck.paramsetting.checkrepairsetting.densitymanage.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.paramsetting.checkrepairsetting.densitymanage.bean.StandGasTheoryCon;
import com.envcheck.paramsetting.checkrepairsetting.densitymanage.dao.IStandGasTheoryConDao;
import com.envcheck.paramsetting.checkrepairsetting.densitymanage.service.IStandGasTheoryConService;

/**
 * Created by Administrator on 2016/5/6.
 */
public class StandGasTheoryConService extends BaseService<StandGasTheoryCon> implements IStandGasTheoryConService {

    private IStandGasTheoryConDao standGasTheoryConDao;
    public IStandGasTheoryConDao getStandGasTheoryConDao() {
        return standGasTheoryConDao;
    }
    public void setStandGasTheoryConDao(IStandGasTheoryConDao standGasTheoryConDao) {
        super.setBaseDao(standGasTheoryConDao);
        this.standGasTheoryConDao = standGasTheoryConDao;
    }
}
