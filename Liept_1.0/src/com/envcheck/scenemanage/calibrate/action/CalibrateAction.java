package com.envcheck.scenemanage.calibrate.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.scenemanage.calibrate.bean.CalibrationInfo;
import com.envcheck.scenemanage.calibrate.service.ICalibrateService;
import com.envcheck.scenemanage.calibrate.service.impl.CalibrateService;
import com.envcheck.scenemanage.weatherparam.bean.WeatherParam;


import java.net.URLDecoder;

/**
 * Created by susion on 2016/5/11.
 */
public class CalibrateAction extends BaseAction{

    private ICalibrateService calibrateService;
    private CalibrationInfo calibrationInfo;

    /**
     *列表展示
     */
    public String listUI(){


        QueryHelper qh = new QueryHelper(CalibrationInfo.class, "c");
        //查询

       if(calibrationInfo != null )

        {
        }

        pageResult = calibrateService.getPageResult(qh,  getPageNo(), getPageSize());

        return "listUI";
    }


    public void setCalibrateService(ICalibrateService calibrateService) {
        this.calibrateService = calibrateService;
    }

    public void setCalibrationInfo(CalibrationInfo calibrationInfo) {
        this.calibrationInfo = calibrationInfo;
    }

    public CalibrationInfo getCalibrationInfo() {
        return calibrationInfo;
    }
}
