package com.envcheck.base.bean.discharge_check_history;

import com.envcheck.base.bean.Module;

import java.util.Date;

/**
 * Created by susion on 2016/6/22.
 */
public class HistoryModuleRepairRecord {

    private String id;

    private String moduleId;   //对应的组件ID
    private Date endPeriodTime;

    private int repairNumber;
    private Date firstRepairDate;
    private String firstRepairPerson;
    private String firstRepairMeasure;

    private Date firstRepeateCheckDate;
    private int firstRepeateCheckValue;

    private Date endRepairDate;
    private String endRepairPerson;
    private String endRepairMeasure;

    private Date endRepeateCheckDate;
    private int endtRepeateCheckValue;

    private Boolean repairResult = false;
    private Boolean tempStopRepair;




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public Date getEndPeriodTime() {
        return endPeriodTime;
    }

    public void setEndPeriodTime(Date endPeriodTime) {
        this.endPeriodTime = endPeriodTime;
    }

    public int getRepairNumber() {
        return repairNumber;
    }

    public void setRepairNumber(int repairNumber) {
        this.repairNumber = repairNumber;
    }

    public Date getFirstRepairDate() {
        return firstRepairDate;
    }

    public void setFirstRepairDate(Date firstRepairDate) {
        this.firstRepairDate = firstRepairDate;
    }

    public String getFirstRepairPerson() {
        return firstRepairPerson;
    }

    public void setFirstRepairPerson(String firstRepairPerson) {
        this.firstRepairPerson = firstRepairPerson;
    }

    public String getFirstRepairMeasure() {
        return firstRepairMeasure;
    }

    public void setFirstRepairMeasure(String firstRepairMeasure) {
        this.firstRepairMeasure = firstRepairMeasure;
    }

    public int getFirstRepeateCheckValue() {
        return firstRepeateCheckValue;
    }

    public void setFirstRepeateCheckValue(int firstRepeateCheckValue) {
        this.firstRepeateCheckValue = firstRepeateCheckValue;
    }

    public Date getFirstRepeateCheckDate() {
        return firstRepeateCheckDate;
    }

    public void setFirstRepeateCheckDate(Date firstRepeateCheckDate) {
        this.firstRepeateCheckDate = firstRepeateCheckDate;
    }

    public Date getEndRepairDate() {
        return endRepairDate;
    }

    public void setEndRepairDate(Date endRepairDate) {
        this.endRepairDate = endRepairDate;
    }

    public String getEndRepairPerson() {
        return endRepairPerson;
    }

    public void setEndRepairPerson(String endRepairPerson) {
        this.endRepairPerson = endRepairPerson;
    }

    public String getEndRepairMeasure() {
        return endRepairMeasure;
    }

    public void setEndRepairMeasure(String endRepairMeasure) {
        this.endRepairMeasure = endRepairMeasure;
    }

    public Date getEndRepeateCheckDate() {
        return endRepeateCheckDate;
    }

    public void setEndRepeateCheckDate(Date endRepeateCheckDate) {
        this.endRepeateCheckDate = endRepeateCheckDate;
    }

    public int getEndtRepeateCheckValue() {
        return endtRepeateCheckValue;
    }

    public void setEndtRepeateCheckValue(int endtRepeateCheckValue) {
        this.endtRepeateCheckValue = endtRepeateCheckValue;
    }

    public Boolean getRepairResult() {
        return repairResult;
    }

    public void setRepairResult(Boolean repairResult) {
        this.repairResult = repairResult;
    }

    public Boolean getTempStopRepair() {
        return tempStopRepair;
    }

    public void setTempStopRepair(Boolean tempStopRepair) {
        this.tempStopRepair = tempStopRepair;
    }
}
