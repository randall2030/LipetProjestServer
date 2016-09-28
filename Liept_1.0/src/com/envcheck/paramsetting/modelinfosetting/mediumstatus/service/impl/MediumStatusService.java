package com.envcheck.paramsetting.modelinfosetting.mediumstatus.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.paramsetting.modelinfosetting.mediumstatus.bean.MediumStatus;
import com.envcheck.paramsetting.modelinfosetting.mediumstatus.dao.IMediumStatusDao;
import com.envcheck.paramsetting.modelinfosetting.mediumstatus.service.IMediumStatusService;

/**
 * Created by Administrator on 2016/5/7.
 */
public class MediumStatusService extends BaseService<MediumStatus> implements IMediumStatusService {
    private IMediumStatusDao mediumStatusDao;

    public IMediumStatusDao getMediumStatusDao() {
        return mediumStatusDao;
    }

    public void setMediumStatusDao(IMediumStatusDao mediumStatusDao) {
        super.setBaseDao(mediumStatusDao);
        this.mediumStatusDao = mediumStatusDao;
    }
}
