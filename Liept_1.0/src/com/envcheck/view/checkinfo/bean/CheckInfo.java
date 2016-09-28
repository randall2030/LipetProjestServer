package com.envcheck.view.checkinfo.bean;

/**
 * Created by susion on 2016/6/12.
 */

public class CheckInfo {

    private String checkId;
    private String device;
    private String area;
    private String labelNumber;
    private int extendNumber;
    private int siezMM;
    private String locationDesc;
    private int PPMNumber;
    private int leakThreshold;
    private boolean leak;
    private String leakSource;
    private String moduleType;
    private String checkPerson;
    private String checkEquipment;
    private String startTime;
    private String endTime;
    private String mediumStatus;
    private String diffToCheck;
    private int backgroundPPMNumber;

    private String markPictureSavePath;

    private int nextCheckTime;


    public int getBackgroundPPMNumber() {
        return backgroundPPMNumber;
    }

    public void setBackgroundPPMNumber(int backgroundPPMNumber) {
        this.backgroundPPMNumber = backgroundPPMNumber;
    }

    public String getDiffToCheck() {
        return diffToCheck;
    }

    public void setDiffToCheck(String diffToCheck) {
        this.diffToCheck = diffToCheck;
    }

    public String getMediumStatus() {
        return mediumStatus;
    }

    public void setMediumStatus(String mediumStatus) {
        this.mediumStatus = mediumStatus;
    }

    public int getExtendNumber() {
        return extendNumber;
    }

    public void setExtendNumber(int extendNumber) {
        this.extendNumber = extendNumber;
    }

    public String getLeakSource() {
        return leakSource;
    }

    public void setLeakSource(String leakSource) {
        this.leakSource = leakSource;
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

    public String getLabelNumber() {
        return labelNumber;
    }

    public void setLabelNumber(String labelNumber) {
        this.labelNumber = labelNumber;
    }

    public String getLocationDesc() {
        return locationDesc;
    }

    public void setLocationDesc(String locationDesc) {
        this.locationDesc = locationDesc;
    }

    public int getPPMNumber() {
        return PPMNumber;
    }

    public void setPPMNumber(int PPMNumber) {
        this.PPMNumber = PPMNumber;
    }

    public int getLeakThreshold() {
        return leakThreshold;
    }

    public void setLeakThreshold(int leakThreshold) {
        this.leakThreshold = leakThreshold;
    }


    public boolean isLeak() {
        return leak;
    }

    public void setLeak(boolean leak) {
        this.leak = leak;
    }

    public String getModuleType() {
        return moduleType;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }


    public int getSiezMM() {
        return siezMM;
    }

    public void setSiezMM(int siezMM) {
        this.siezMM = siezMM;
    }

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }

    public String getMarkPictureSavePath() {
        return markPictureSavePath;
    }

    public void setMarkPictureSavePath(String markPictureSavePath) {
        this.markPictureSavePath = markPictureSavePath;
    }

    public int getNextCheckTime() {
        return nextCheckTime;
    }

    public void setNextCheckTime(int nextCheckTime) {
        this.nextCheckTime = nextCheckTime;
    }
}
