package com.envcheck.report.statistics.letnumberstatistics.bean;

import com.envcheck.base.bean.discharge_check_history.DischargeForPPMRecord;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by susion on 2016/6/22.
 */
public class ModuleInfoFroDischarge {

    private String moduleType;
    private String moduleMediumStatus;
    private String diffToCheck;
    private int yearRunTime;
    private String deviceName;

    private Set<DischargeForPPMRecord> dischargeForPPMRecords = new HashSet<>();


    public ModuleInfoFroDischarge(){

    }

    public ModuleInfoFroDischarge(String moduleType, Set<DischargeForPPMRecord> dischargeForPPMRecords, String deviceType, int yearRunTime, String diffToCheck, String moduleMediumStatus) {
        this.moduleType = moduleType;
        this.dischargeForPPMRecords = dischargeForPPMRecords;
        this.deviceName = deviceType;
        this.yearRunTime = yearRunTime;
        this.diffToCheck = diffToCheck;
        this.moduleMediumStatus = moduleMediumStatus;
    }


    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getYearRunTime() {
        return yearRunTime;
    }

    public void setYearRunTime(int yearRunTime) {
        this.yearRunTime = yearRunTime;
    }

    public String getDiffToCheck() {
        return diffToCheck;
    }

    public void setDiffToCheck(String diffToCheck) {
        this.diffToCheck = diffToCheck;
    }

    public String getModuleType() {
        return moduleType;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
    }

    public Set<DischargeForPPMRecord> getDischargeForPPMRecords() {
        return dischargeForPPMRecords;
    }

    public void setDischargeForPPMRecords(Set<DischargeForPPMRecord> dischargeForPPMRecords) {
        this.dischargeForPPMRecords = dischargeForPPMRecords;
    }

    public String getModuleMediumStatus() {
        return moduleMediumStatus;
    }

    public void setModuleMediumStatus(String moduleMediumStatus) {
        this.moduleMediumStatus = moduleMediumStatus;
    }
}
