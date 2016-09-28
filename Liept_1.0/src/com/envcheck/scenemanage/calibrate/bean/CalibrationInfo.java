package com.envcheck.scenemanage.calibrate.bean;

import java.io.Serializable;
import java.util.*;

/**
 * Created by susion on 2016/5/30.
 */
public class CalibrationInfo implements Serializable {

    private String id;
    private String equipmentNumber;  //校准仪器
    private String checkPerson;
    private Date calibrationTime;
    private boolean dailyCalibrationResult;
    private boolean driftCalibrationResult;

    private Set<CalibrationInfoDetail> dailyCalibrationInfos = new HashSet<>();
    private Set<CalibrationInfoDetail> driftCalibrationInfos = new HashSet<>();


    public CalibrationInfo(String id, String equipmentNumber, String checkPerson, Date calibrationTime, boolean dailyCalibrationResult, boolean driftCalibrationResult, Set<CalibrationInfoDetail> dailyCalibrationInfos, Set<CalibrationInfoDetail> driftCalibrationInfos) {
        this.id = id;
        this.equipmentNumber = equipmentNumber;
        this.checkPerson = checkPerson;
        this.calibrationTime = calibrationTime;
        this.dailyCalibrationResult = dailyCalibrationResult;
        this.driftCalibrationResult = driftCalibrationResult;
        this.dailyCalibrationInfos = dailyCalibrationInfos;
        this.driftCalibrationInfos = driftCalibrationInfos;
    }

    public CalibrationInfo() {

    }

    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }

    public String getCheckPerson() {
        return checkPerson;
    }

    public void setCheckPerson(String checkPerson) {
        this.checkPerson = checkPerson;
    }

    public Date getCalibrationTime() {
        return calibrationTime;
    }

    public void setCalibrationTime(Date calibrationTime) {
        this.calibrationTime = calibrationTime;
    }

    public boolean isDailyCalibrationResult() {
        return dailyCalibrationResult;
    }

    public void setDailyCalibrationResult(boolean dailyCalibrationResult) {
        this.dailyCalibrationResult = dailyCalibrationResult;
    }

    public boolean isDriftCalibrationResult() {
        return driftCalibrationResult;
    }

    public void setDriftCalibrationResult(boolean driftCalibrationResult) {
        this.driftCalibrationResult = driftCalibrationResult;
    }


    public Set<CalibrationInfoDetail> getDailyCalibrationInfos() {
        return dailyCalibrationInfos;
    }

    public void setDailyCalibrationInfos(Set<CalibrationInfoDetail> dailyCalibrationInfos) {
        this.dailyCalibrationInfos = dailyCalibrationInfos;
    }

    public Set<CalibrationInfoDetail> getDriftCalibrationInfos() {
        return driftCalibrationInfos;
    }

    public void setDriftCalibrationInfos(Set<CalibrationInfoDetail> driftCalibrationInfos) {
        this.driftCalibrationInfos = driftCalibrationInfos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
