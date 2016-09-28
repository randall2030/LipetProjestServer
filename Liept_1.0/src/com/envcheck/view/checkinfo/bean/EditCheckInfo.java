package com.envcheck.view.checkinfo.bean;

import java.util.Date;

/**
 * Created by susion on 2016/7/8.
 */
public class EditCheckInfo {

    private String moduleCheckId;
    private Date startTime;
    private Date endTime;
    private String checkPerson;
    private String checkEquipment;
    private int PPMNumber;
    private int backgroundPPMNumber;

    public String getModuleCheckId() {
        return moduleCheckId;
    }

    public void setModuleCheckId(String moduleCheckId) {
        this.moduleCheckId = moduleCheckId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public int getPPMNumber() {
        return PPMNumber;
    }

    public void setPPMNumber(int PPMNumber) {
        this.PPMNumber = PPMNumber;
    }

    public int getBackgroundPPMNumber() {
        return backgroundPPMNumber;
    }

    public void setBackgroundPPMNumber(int backgroundPPMNumber) {
        this.backgroundPPMNumber = backgroundPPMNumber;
    }
}
