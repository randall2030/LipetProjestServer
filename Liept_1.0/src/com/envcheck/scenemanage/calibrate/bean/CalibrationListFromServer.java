package com.envcheck.scenemanage.calibrate.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by susion on 2016/6/2.
 */
public class CalibrationListFromServer implements Serializable{

    private List<CalibrationInfo> calibrationInfoList = new ArrayList<>();

    public List<CalibrationInfo> getCalibrationInfoList() {
        return calibrationInfoList;
    }

    public void setCalibrationInfoList(List<CalibrationInfo> calibrationInfoList) {
        this.calibrationInfoList = calibrationInfoList;
    }
}
