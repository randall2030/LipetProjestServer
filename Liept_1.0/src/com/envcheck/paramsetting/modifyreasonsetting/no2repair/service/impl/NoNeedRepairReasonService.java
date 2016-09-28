package com.envcheck.paramsetting.modifyreasonsetting.no2repair.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.paramsetting.modifyreasonsetting.no2repair.bean.NoNeedRepairReason;
import com.envcheck.paramsetting.modifyreasonsetting.no2repair.dao.INoNeedRepairReasonDao;
import com.envcheck.paramsetting.modifyreasonsetting.no2repair.service.INoNeedRepairReasonService;

/**
 * Created by Administrator on 2016/5/6.
 */
public class NoNeedRepairReasonService extends BaseService<NoNeedRepairReason> implements INoNeedRepairReasonService {
    private INoNeedRepairReasonDao noNeedRepairReasonDao;

    public INoNeedRepairReasonDao getNoNeedRepairReasonDao() {
        return noNeedRepairReasonDao;
    }

    public void setNoNeedRepairReasonDao(INoNeedRepairReasonDao noNeedRepairReasonDao) {
        super.setBaseDao(noNeedRepairReasonDao);
        this.noNeedRepairReasonDao = noNeedRepairReasonDao;
    }
}
