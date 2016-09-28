package com.envcheck.view.viewhistorycheck.bean;

import java.util.Date;

/**
 * Created by susion on 2016/8/6.
 */
public class HistoryModuleCheckInfo {

    private String markPictureSavePath;
    private String device;
    private String area;
    private String equipment;
    private  String labelNumber;
    private int extendNumber;
    private String modelType;
    private int thresholdValue;
    private int periodEndValue;
    private String checkEquipment;
    private String checkPerson;

    public String getMarkPictureSavePath() {
        return markPictureSavePath;
    }

    public void setMarkPictureSavePath(String markPictureSavePath) {
        this.markPictureSavePath = markPictureSavePath;
    }

    public String getCheckPerson() {
        return checkPerson;
    }

    public void setCheckPerson(String checkPerson) {
        this.checkPerson = checkPerson;
    }

    public String getCheckEquipment() {
        return checkEquipment;
    }

    public void setCheckEquipment(String checkEquipment) {
        this.checkEquipment = checkEquipment;
    }

    public int getPeriodEndValue() {
        return periodEndValue;
    }

    public void setPeriodEndValue(int periodEndValue) {
        this.periodEndValue = periodEndValue;
    }

    public int getThresholdValue() {
        return thresholdValue;
    }

    public void setThresholdValue(int thresholdValue) {
        this.thresholdValue = thresholdValue;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public int getExtendNumber() {
        return extendNumber;
    }

    public void setExtendNumber(int extendNumber) {
        this.extendNumber = extendNumber;
    }

    public String getLabelNumber() {
        return labelNumber;
    }

    public void setLabelNumber(String labelNumber) {
        this.labelNumber = labelNumber;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }
}
