package com.envcheck.android.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by susion on 2016/5/22.
 */
public class SceneCollectPhotoTask implements Serializable{

    private String labelNumber;
    private String flagNumber;
    private String device;
    private String area;
    private String mainEquipment;
    private String floor;
    private String mediumStatus;
    private String diff2Check;
    private String mainMedium;
    private String mainReference;
    private String upOrDown;
    private String direction;
    private String distance;
    private String height;
    private String runTime;

    //新增
    private String pidNumber;



    private List<LayoutBean> layoutBeans;

    private String LabelPhotoPath;
    private String totalPoint;


    public SceneCollectPhotoTask(String labelNumber, String flagNumber, String device, String area,
                                 String mainEquipment, String floor, String mediumStatus, String diff2Check, String mainMedium,
                                 String direction, String upOrDown, String mainReference, String distance, String height, String runTime, String pidNumber) {
        this.labelNumber = labelNumber;
        this.flagNumber = flagNumber;
        this.device = device;
        this.area = area;
        this.mainEquipment = mainEquipment;
        this.floor = floor;
        this.mediumStatus = mediumStatus;
        this.diff2Check = diff2Check;
        this.mainMedium = mainMedium;
        this.direction = direction;
        this.upOrDown = upOrDown;
        this.mainReference = mainReference;
        this.distance = distance;
        this.height = height;
        this.runTime = runTime;
        this.pidNumber = pidNumber;
    }


    public String getPidNumber() {
        return pidNumber;
    }

    public void setPidNumber(String pidNumber) {
        this.pidNumber = pidNumber;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public String getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(String totalPoint) {
        this.totalPoint = totalPoint;
    }

    public String getLabelNumber() {
        return labelNumber;
    }

    public void setLabelNumber(String labelNumber) {
        this.labelNumber = labelNumber;
    }

    public String getFlagNumber() {
        return flagNumber;
    }

    public void setFlagNumber(String flagNumber) {
        this.flagNumber = flagNumber;
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

    public String getMainEquipment() {
        return mainEquipment;
    }

    public void setMainEquipment(String mainEquipment) {
        this.mainEquipment = mainEquipment;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getMediumStatus() {
        return mediumStatus;
    }

    public void setMediumStatus(String mediumStatus) {
        this.mediumStatus = mediumStatus;
    }

    public String getDiff2Check() {
        return diff2Check;
    }

    public void setDiff2Check(String diff2Check) {
        this.diff2Check = diff2Check;
    }

    public String getMainMedium() {
        return mainMedium;
    }

    public void setMainMedium(String mainMedium) {
        this.mainMedium = mainMedium;
    }

    public String getMainReference() {
        return mainReference;
    }

    public void setMainReference(String mainReference) {
        this.mainReference = mainReference;
    }

    public String getUpOrDown() {
        return upOrDown;
    }

    public void setUpOrDown(String upOrDown) {
        this.upOrDown = upOrDown;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public List<LayoutBean> getLayoutBeans() {
        return layoutBeans;
    }

    public void setLayoutBeans(List<LayoutBean> layoutBeans) {
        this.layoutBeans = layoutBeans;
    }

    public String getLabelPhotoPath() {
        return LabelPhotoPath;
    }

    public void setLabelPhotoPath(String labelPhotoPath) {
        LabelPhotoPath = labelPhotoPath;
    }

    public void setEditInfo(String labelNumber, String flagNumber, String device, String area,
                            String mainEquipment, String floor, String mediumStatus, String diff2Check, String mainMedium, String direction, String upOrDown, String mainReference, String distance, String height, String runTime, String pidNumber) {
        this.labelNumber = labelNumber;
        this.flagNumber = flagNumber;
        this.device = device;
        this.area = area;
        this.mainEquipment = mainEquipment;
        this.floor = floor;
        this.mediumStatus = mediumStatus;
        this.diff2Check = diff2Check;
        this.mainMedium = mainMedium;
        this.direction = direction;
        this.upOrDown = upOrDown;
        this.mainReference = mainReference;
        this.distance = distance;
        this.height = height;
        this.runTime = runTime;
        this.pidNumber = pidNumber;
    }

}
