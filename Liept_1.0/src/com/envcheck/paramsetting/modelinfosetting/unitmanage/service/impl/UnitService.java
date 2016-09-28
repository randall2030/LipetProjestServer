package com.envcheck.paramsetting.modelinfosetting.unitmanage.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.paramsetting.modelinfosetting.unitmanage.bean.Unit;
import com.envcheck.paramsetting.modelinfosetting.unitmanage.dao.IUnitDao;
import com.envcheck.paramsetting.modelinfosetting.unitmanage.service.IUnitService;

/**
 * Created by lighter on 2016/5/8.
 */
public class UnitService extends BaseService<Unit> implements IUnitService {
    private IUnitDao uintDao;

    public IUnitDao getUintDao() {
        return uintDao;
    }

    public void setUintDao(IUnitDao uintDao) {
        super.setBaseDao(uintDao);
        this.uintDao = uintDao;
    }
}
