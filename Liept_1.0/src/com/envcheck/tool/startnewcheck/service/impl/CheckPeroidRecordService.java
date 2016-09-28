package com.envcheck.tool.startnewcheck.service.impl;

import com.envcheck.base.bean.discharge_check_history.CheckPeriodRecord;
import com.envcheck.base.service.impl.BaseService;
import com.envcheck.paramsetting.modelinfosetting.unitmanage.bean.Unit;
import com.envcheck.paramsetting.modelinfosetting.unitmanage.dao.IUnitDao;
import com.envcheck.paramsetting.modelinfosetting.unitmanage.service.IUnitService;
import com.envcheck.tool.startnewcheck.dao.ICheckPeroidRecordDao;
import com.envcheck.tool.startnewcheck.service.ICheckPeroidRecordService;

import java.util.List;

/**
 * Created by lighter on 2016/5/8.
 */
public class CheckPeroidRecordService extends BaseService<CheckPeriodRecord> implements ICheckPeroidRecordService {

    private ICheckPeroidRecordDao checkPeroidRecordDao;

    public ICheckPeroidRecordDao getCheckPeroidRecordDao() {
        return checkPeroidRecordDao;
    }

    public void setCheckPeroidRecordDao(ICheckPeroidRecordDao checkPeroidRecordDao) {
        super.setBaseDao(checkPeroidRecordDao);
        this.checkPeroidRecordDao = checkPeroidRecordDao;
    }

    @Override
    public CheckPeriodRecord getCheckPeroidRecordByName(String endPeriodName) {
        return checkPeroidRecordDao.getCheckPeroidRecordByName(endPeriodName);
    }

    @Override
    public List<String> getAllPeriodName() {
        return checkPeroidRecordDao.getAllPeriodName();
    }
}
