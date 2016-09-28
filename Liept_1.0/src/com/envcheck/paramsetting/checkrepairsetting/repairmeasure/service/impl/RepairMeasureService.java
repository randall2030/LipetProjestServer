package com.envcheck.paramsetting.checkrepairsetting.repairmeasure.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.paramsetting.checkrepairsetting.repairmeasure.bean.RepairMeasure;
import com.envcheck.paramsetting.checkrepairsetting.repairmeasure.dao.IRepairMeasureDao;
import com.envcheck.paramsetting.checkrepairsetting.repairmeasure.service.IRepairMeasureService;

/**
 * Created by Administrator on 2016/5/6.
 */
public class RepairMeasureService extends BaseService<RepairMeasure> implements IRepairMeasureService{

    private IRepairMeasureDao repairMeasureDao;
    public IRepairMeasureDao getRepairMeasureDao() {
        return repairMeasureDao;
    }
    public void setRepairMeasureDao(IRepairMeasureDao repairMeasureDao) {
        super.setBaseDao(repairMeasureDao);
        this.repairMeasureDao = repairMeasureDao;
    }
}
