package com.envcheck.view.leakinfo.bean;

import java.util.Date;

/**
 * Created by susion on 2016/6/12.
 */

public class LeakInfo {

    private Date checkDate;
    private String device;
    private String area;
    private String equipment;
    private String locationDesc;
    private int cleanPPMValue;
    private int leakThreshold;
    private boolean leak;
    private String moduleType;
    private int sizeMM;
    private String leakSource;
    private String checkPerson;
    private String checkEquipment;
    private boolean tempRepair;
    private boolean hasRepair;
    private Date firstRepeateDate;
    private int firstRepeateValue;
    private Date endRepeateDate;
    private int endRepeateValue;
    private boolean repairResult;

    private String markPictureSavePath;
    private String labelNumber;
    private int extendNumber;

    private String mediumStatus;
    private int backgroundPPMNumber;
    private int repairNumber;

    private String pictureLocalPath;


    public String getPictureLocalPath() {
        return pictureLocalPath;
    }

    public void setPictureLocalPath(String pictureLocalPath) {
        this.pictureLocalPath = pictureLocalPath;
    }

    public int getRepairNumber() {
        return repairNumber;
    }

    public void setRepairNumber(int repairNumber) {
        this.repairNumber = repairNumber;
    }

    public int getBackgroundPPMNumber() {
        return backgroundPPMNumber;
    }

    public void setBackgroundPPMNumber(int backgroundPPMNumber) {
        this.backgroundPPMNumber = backgroundPPMNumber;
    }

    public String getMediumStatus() {
        return mediumStatus;
    }

    public void setMediumStatus(String mediumStatus) {
        this.mediumStatus = mediumStatus;
    }

    public String getMarkPictureSavePath() {
        return markPictureSavePath;
    }

    public void setMarkPictureSavePath(String markPictureSavePath) {
        this.markPictureSavePath = markPictureSavePath;
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

    public boolean isHasRepair() {
        return hasRepair;
    }

    public void setHasRepair(boolean hasRepair) {
        this.hasRepair = hasRepair;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public boolean isRepairResult() {
        return repairResult;
    }

    public void setRepairResult(boolean repairResult) {
        this.repairResult = repairResult;
    }

    public int getFirstRepeateValue() {
        return firstRepeateValue;
    }

    public void setFirstRepeateValue(int firstRepeateValue) {
        this.firstRepeateValue = firstRepeateValue;
    }

    public int getEndRepeateValue() {
        return endRepeateValue;
    }

    public void setEndRepeateValue(int endRepeateValue) {
        this.endRepeateValue = endRepeateValue;
    }

    public Date getEndRepeateDate() {
        return endRepeateDate;
    }

    public void setEndRepeateDate(Date endRepeateDate) {
        this.endRepeateDate = endRepeateDate;
    }

    public Date getFirstRepeateDate() {
        return firstRepeateDate;
    }

    public void setFirstRepeateDate(Date firstRepeateDate) {
        this.firstRepeateDate = firstRepeateDate;
    }

    public boolean isTempRepair() {
        return tempRepair;
    }

    public void setTempRepair(boolean tempRepair) {
        this.tempRepair = tempRepair;
    }

    public String getCheckEquipment() {
        return checkEquipment;
    }

    public void setCheckEquipment(String checkEquipment) {
        this.checkEquipment = checkEquipment;
    }

    public String getCheckPerson() {
        return checkPerson;
    }

    public void setCheckPerson(String checkPerson) {
        this.checkPerson = checkPerson;
    }

    public String getLeakSource() {
        return leakSource;
    }

    public void setLeakSource(String leakSource) {
        this.leakSource = leakSource;
    }

    public int getSizeMM() {
        return sizeMM;
    }

    public void setSizeMM(int sizeMM) {
        this.sizeMM = sizeMM;
    }

    public String getModuleType() {
        return moduleType;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
    }

    public boolean isLeak() {
        return leak;
    }

    public void setLeak(boolean leak) {
        this.leak = leak;
    }

    public int getLeakThreshold() {
        return leakThreshold;
    }

    public void setLeakThreshold(int leakThreshold) {
        this.leakThreshold = leakThreshold;
    }

    public String getLocationDesc() {
        return locationDesc;
    }

    public void setLocationDesc(String locationDesc) {
        this.locationDesc = locationDesc;
    }

    public int getCleanPPMValue() {
        return cleanPPMValue;
    }

    public void setCleanPPMValue(int cleanPPMValue) {
        this.cleanPPMValue = cleanPPMValue;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
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
}
