package com.envcheck.report.letcaculate.bean;

/**
 * Created by Administrator on 2016/7/13.
 */
public class LetForModule {

    private int cleanPPM;
    private String moduleType;
    private String deviceType;
    private String device;
    private String area;
    private String equipment;
    private String labelNumber;
    private int extendNumber;
    private String mediumStatus;
    private String diffToCheck;
    private double totalRunTime;
    private double totalLetNumber;
    private double dischargeSpeed;


    public double getDischargeSpeed() {
        return dischargeSpeed;
    }

    public void setDischargeSpeed(double dischargeSpeed) {
        this.dischargeSpeed = dischargeSpeed;
    }

    public int getCleanPPM() {
        return cleanPPM;
    }

    public void setCleanPPM(int cleanPPM) {
        this.cleanPPM = cleanPPM;
    }

    public String getModuleType() {
        return moduleType;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getLabelNumber() {
        return labelNumber;
    }

    public void setLabelNumber(String labelNumber) {
        this.labelNumber = labelNumber;
    }

    public int getExtendNumber() {
        return extendNumber;
    }

    public void setExtendNumber(int extendNumber) {
        this.extendNumber = extendNumber;
    }

    public String getMediumStatus() {
        return mediumStatus;
    }

    public void setMediumStatus(String mediumStatus) {
        this.mediumStatus = mediumStatus;
    }

    public String getDiffToCheck() {
        return diffToCheck;
    }

    public void setDiffToCheck(String diffToCheck) {
        this.diffToCheck = diffToCheck;
    }

    public double getTotalRunTime() {
        return totalRunTime;
    }

    public void setTotalRunTime(double totalRunTime) {
        this.totalRunTime = totalRunTime;
    }

    public double getTotalLetNumber() {
        return totalLetNumber;
    }

    public void setTotalLetNumber(double totalLetNumber) {
        this.totalLetNumber = totalLetNumber;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
}
