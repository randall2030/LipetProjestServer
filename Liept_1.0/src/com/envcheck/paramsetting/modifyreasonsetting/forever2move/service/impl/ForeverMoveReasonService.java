package com.envcheck.paramsetting.modifyreasonsetting.forever2move.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.paramsetting.modifyreasonsetting.forever2move.bean.ForeverMoveReason;
import com.envcheck.paramsetting.modifyreasonsetting.forever2move.dao.IForeverMoveReasonDao;
import com.envcheck.paramsetting.modifyreasonsetting.forever2move.bean.ForeverMoveReason;

/**
 * Created by Administrator on 2016/5/6.
 */
public class ForeverMoveReasonService extends BaseService<ForeverMoveReason> implements com.envcheck.paramsetting.modifyreasonsetting.forever2move.service.IForeverMoveReasonService {
    private IForeverMoveReasonDao foreverMoveReasonDao;

    public IForeverMoveReasonDao getForeverMoveReasonDao() {
        return foreverMoveReasonDao;
    }

    public void setForeverMoveReasonDao(IForeverMoveReasonDao foreverMoveReasonDao) {
        super.setBaseDao(foreverMoveReasonDao);
        this.foreverMoveReasonDao = foreverMoveReasonDao;
    }
}
