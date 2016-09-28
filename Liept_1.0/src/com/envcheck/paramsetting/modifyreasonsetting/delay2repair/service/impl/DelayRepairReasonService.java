package com.envcheck.paramsetting.modifyreasonsetting.delay2repair.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.paramsetting.modifyreasonsetting.danger2check.bean.DangerToCheckReason;
import com.envcheck.paramsetting.modifyreasonsetting.danger2check.dao.IDangerToCheckReasonDao;
import com.envcheck.paramsetting.modifyreasonsetting.delay2repair.bean.DelayRepairReason;
import com.envcheck.paramsetting.modifyreasonsetting.delay2repair.dao.IDelayRepairReasonDao;
import com.envcheck.paramsetting.modifyreasonsetting.delay2repair.service.IDelayRepairReasonService;

/**
 * Created by Administrator on 2016/5/6.
 */
public class DelayRepairReasonService extends BaseService<DelayRepairReason> implements IDelayRepairReasonService {
    private IDelayRepairReasonDao delayRepairReasonDao;

    public IDelayRepairReasonDao getDelayRepairReasonDao() {
        return delayRepairReasonDao;
    }

    public void setDelayRepairReasonDao(IDelayRepairReasonDao delayRepairReasonDao) {
        super.setBaseDao(delayRepairReasonDao);
        this.delayRepairReasonDao = delayRepairReasonDao;
    }
}
