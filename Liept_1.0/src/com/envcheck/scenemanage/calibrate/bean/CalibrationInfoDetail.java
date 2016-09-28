package com.envcheck.scenemanage.calibrate.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by susion on 2016/6/2.
 */
public class CalibrationInfoDetail implements Serializable {

    private String id;
    private String standGasNumber;
    private String standGasReadNumber;
    private String caculateNumber;
    private String calibrationReadNumber;
    private String responseTime;
    private String ppmThresholdNumber;
    private Date createTime;
    private boolean calibrationResult;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStandGasNumber() {
        return standGasNumber;
    }

    public void setStandGasNumber(String standGasNumber) {
        this.standGasNumber = standGasNumber;
    }

    public String getStandGasReadNumber() {
        return standGasReadNumber;
    }

    public void setStandGasReadNumber(String standGasReadNumber) {
        this.standGasReadNumber = standGasReadNumber;
    }

    public String getCaculateNumber() {
        return caculateNumber;
    }

    public void setCaculateNumber(String caculateNumber) {
        this.caculateNumber = caculateNumber;
    }

    public String getCalibrationReadNumber() {
        return calibrationReadNumber;
    }

    public void setCalibrationReadNumber(String calibrationReadNumber) {
        this.calibrationReadNumber = calibrationReadNumber;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public String getPpmThresholdNumber() {
        return ppmThresholdNumber;
    }

    public void setPpmThresholdNumber(String ppmThresholdNumber) {
        this.ppmThresholdNumber = ppmThresholdNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public boolean isCalibrationResult() {
        return calibrationResult;
    }

    public void setCalibrationResult(boolean calibrationResult) {
        this.calibrationResult = calibrationResult;
    }
}
