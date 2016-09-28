package com.envcheck.scenemanage.calibrate.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.scenemanage.calibrate.bean.CalibrationInfo;
import com.envcheck.scenemanage.calibrate.dao.ICalibrateDao;
import com.envcheck.scenemanage.calibrate.service.ICalibrateService;

/**
 * Created by Administrator on 2016/5/18.
 */
public class CalibrateService extends BaseService<CalibrationInfo> implements ICalibrateService {

    private ICalibrateDao calibrateDao;

    public ICalibrateDao getCalibrateDao() {
        return calibrateDao;
    }

    public void setCalibrateDao(ICalibrateDao calibrateDao) {
        super.setBaseDao(calibrateDao);
        this.calibrateDao = calibrateDao;
    }
}
