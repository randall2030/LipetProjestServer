package com.envcheck.paramsetting.modifyreasonsetting.temp2move.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.paramsetting.modifyreasonsetting.temp2move.bean.TempMoveReason;
import com.envcheck.paramsetting.modifyreasonsetting.temp2move.dao.ITempMoveReasonDao;
import com.envcheck.paramsetting.modifyreasonsetting.temp2move.service.ITempMoveReasonService;

/**
 * Created by Administrator on 2016/5/6.
 */
public class TempMoveReasonService extends BaseService<TempMoveReason> implements ITempMoveReasonService {
    private ITempMoveReasonDao tempMoveReasonDao;

    public ITempMoveReasonDao getTempMoveReasonDao() {
        return tempMoveReasonDao;
    }

    public void setTempMoveReasonDao(ITempMoveReasonDao tempMoveReasonDao) {
        super.setBaseDao(tempMoveReasonDao);
        this.tempMoveReasonDao = tempMoveReasonDao;
    }
}
