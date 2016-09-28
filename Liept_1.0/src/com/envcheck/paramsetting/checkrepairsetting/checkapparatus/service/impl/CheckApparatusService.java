package com.envcheck.paramsetting.checkrepairsetting.checkapparatus.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.paramsetting.checkrepairsetting.checkapparatus.bean.CheckApparatus;
import com.envcheck.paramsetting.checkrepairsetting.checkapparatus.dao.ICheckApparatusDao;
import com.envcheck.paramsetting.checkrepairsetting.checkapparatus.service.ICheckApparatusService;

/**
 * Created by Administrator on 2016/5/6.
 */
public class CheckApparatusService extends BaseService<CheckApparatus> implements ICheckApparatusService {
    private ICheckApparatusDao checkApparatusDao;

    public ICheckApparatusDao getCheckApparatusDao() {
        return checkApparatusDao;
    }

    public void setCheckApparatusDao(ICheckApparatusDao checkApparatusDao) {
        super.setBaseDao(checkApparatusDao);
        this.checkApparatusDao = checkApparatusDao;
    }
}
