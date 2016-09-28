package com.envcheck.paramsetting.checkrepairsetting.standrdgasmanage.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.paramsetting.checkrepairsetting.standrdgasmanage.bean.StandGas;
import com.envcheck.paramsetting.checkrepairsetting.standrdgasmanage.dao.IStandGasDao;
import com.envcheck.paramsetting.checkrepairsetting.standrdgasmanage.service.IStandGasService;

/**
 * Created by Administrator on 2016/5/7.
 */
public class StandGasService extends BaseService<StandGas> implements IStandGasService{
    private IStandGasDao standGasDao;

    public IStandGasDao getStandGasDao() {
        return standGasDao;
    }

    public void setStandGasDao(IStandGasDao standGasDao) {
        super.setBaseDao(standGasDao);
        this.standGasDao = standGasDao;
    }
}
