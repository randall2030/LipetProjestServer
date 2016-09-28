package com.envcheck.paramsetting.modifyreasonsetting.diff2check.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.paramsetting.modifyreasonsetting.diff2check.bean.DiffToCheckReason;
import com.envcheck.paramsetting.modifyreasonsetting.diff2check.dao.IDiffToCheckReasonDao;
import com.envcheck.paramsetting.modifyreasonsetting.diff2check.service.IDiffToCheckReasonService;

/**
 * Created by Administrator on 2016/5/6.
 */
public class DiffToCheckReasonService extends BaseService<DiffToCheckReason> implements IDiffToCheckReasonService {
    private IDiffToCheckReasonDao diffToCheckReason;

    public IDiffToCheckReasonDao getDiffToCheckReasonDao() {
        return diffToCheckReason;
    }

    public void setDiffToCheckReasonDao(IDiffToCheckReasonDao diffToCheckReason) {
        super.setBaseDao(diffToCheckReason);
        this.diffToCheckReason = diffToCheckReason;
    }
}
