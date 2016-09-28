package com.envcheck.paramsetting.modifyreasonsetting.danger2check.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.paramsetting.checkrepairsetting.checkapparatus.bean.CheckApparatus;
import com.envcheck.paramsetting.checkrepairsetting.checkapparatus.dao.ICheckApparatusDao;
import com.envcheck.paramsetting.modifyreasonsetting.danger2check.bean.DangerToCheckReason;
import com.envcheck.paramsetting.modifyreasonsetting.danger2check.dao.IDangerToCheckReasonDao;
import com.envcheck.paramsetting.modifyreasonsetting.danger2check.service.IDangerToCheckReasonService;

/**
 * Created by Administrator on 2016/5/6.
 */
public class DangerToCheckReasonService extends BaseService<DangerToCheckReason> implements IDangerToCheckReasonService {
    private IDangerToCheckReasonDao dangerToCheckReasonDao;

    public IDangerToCheckReasonDao getDangerToCheckReasonDao() {
        return dangerToCheckReasonDao;
    }

    public void setDangerToCheckReasonDao(IDangerToCheckReasonDao dangerToCheckReasonDao) {
        super.setBaseDao(dangerToCheckReasonDao);
        this.dangerToCheckReasonDao = dangerToCheckReasonDao;
    }
}
