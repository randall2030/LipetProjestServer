package com.envcheck.paramsetting.modifyreasonsetting.inputcodebymanu.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.paramsetting.modifyreasonsetting.inputcodebymanu.bean.ManuInputCodeReason;
import com.envcheck.paramsetting.modifyreasonsetting.inputcodebymanu.dao.IManuInputCodeReasonDao;
import com.envcheck.paramsetting.modifyreasonsetting.inputcodebymanu.service.IManuInputCodeReasonService;

/**
 * Created by Administrator on 2016/5/6.
 */
public class ManuInputCodeReasonService extends BaseService<ManuInputCodeReason> implements IManuInputCodeReasonService {
    private IManuInputCodeReasonDao manuInputCodeReasonDao;

    public IManuInputCodeReasonDao getManuInputCodeReasonDao() {
        return manuInputCodeReasonDao;
    }

    public void setManuInputCodeReasonDao(IManuInputCodeReasonDao manuInputCodeReasonDao) {
        super.setBaseDao(manuInputCodeReasonDao);
        this.manuInputCodeReasonDao = manuInputCodeReasonDao;
    }
}
