package com.envcheck.scenemanage.calibrate.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.scenemanage.calibrate.bean.CalibrationInfo;
import com.envcheck.scenemanage.calibrate.bean.CalibrationInfoDetail;
import com.envcheck.scenemanage.calibrate.dao.ICalibrateDao;
import com.envcheck.scenemanage.calibrate.dao.ICalibrateDetailDao;
import com.envcheck.scenemanage.calibrate.service.ICalibrateDetailService;
import com.envcheck.scenemanage.calibrate.service.ICalibrateService;

/**
 * Created by Administrator on 2016/5/18.
 */
public class CalibrateDetailService extends BaseService<CalibrationInfoDetail> implements ICalibrateDetailService {

    private ICalibrateDetailDao calibrateDetailDao;

    public ICalibrateDetailDao getCalibrateDetailDao() {
        return calibrateDetailDao;
    }

    public void setCalibrateDetailDao(ICalibrateDetailDao calibrateDetailDao) {
        super.setBaseDao(calibrateDetailDao);
        this.calibrateDetailDao = calibrateDetailDao;
    }
}
