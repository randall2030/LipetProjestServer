package com.envcheck.base.bean;

import java.util.Date;

/**
 * Created by susion on 2016/6/25.
 * 组件维修详细记录
 */
public class ModuleRepairUnit {


    private String id;
    private Date repairDate;
    private String repairPerson;
    private String repairMeasure;
    private Date repeateCheckDate;
    private int repeateCheckValue;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(Date repairDate) {
        this.repairDate = repairDate;
    }

    public String getRepairPerson() {
        return repairPerson;
    }

    public void setRepairPerson(String repairPerson) {
        this.repairPerson = repairPerson;
    }

    public String getRepairMeasure() {
        return repairMeasure;
    }

    public void setRepairMeasure(String repairMeasure) {
        this.repairMeasure = repairMeasure;
    }

    public Date getRepeateCheckDate() {
        return repeateCheckDate;
    }

    public void setRepeateCheckDate(Date repeateCheckDate) {
        this.repeateCheckDate = repeateCheckDate;
    }

    public int getRepeateCheckValue() {
        return repeateCheckValue;
    }

    public void setRepeateCheckValue(int repeateCheckValue) {
        this.repeateCheckValue = repeateCheckValue;
    }
}
