package com.envcheck.paramsetting.checkrepairsetting.standrdgasmanage.bean;

import java.util.Date;

/**
 * Created by susion on 2016/5/4.
 */
public class StandGas {

    //标准气编号、公司编号、标准气名称、标准气实际浓度、有效日期、停用、停用日期、标准气理论浓度
    private String id;
    private String standGasNumber;  //来自标准气浓度管理
    private String companyNumber;  //来自公司信息
    private String standGasName;
    private int actualDensity;
    private Date validTime;
    private Boolean stopuUse;
    private Date stopTime;
    private int theoryDensity;




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

    public String getStandGasName() {
        return standGasName;
    }

    public void setStandGasName(String standGasName) {
        this.standGasName = standGasName;
    }

    public int getActualDensity() {
        return actualDensity;
    }

    public void setActualDensity(int actualDensity) {
        this.actualDensity = actualDensity;
    }

    public Date getValidTime() {
        return validTime;
    }

    public void setValidTime(Date validTime) {
        this.validTime = validTime;
    }

    public Boolean getStopuUse() {
        return stopuUse;
    }

    public void setStopuUse(Boolean stopuUse) {
        this.stopuUse = stopuUse;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public int getTheoryDensity() {
        return theoryDensity;
    }

    public void setTheoryDensity(int theoryDensity) {
        this.theoryDensity = theoryDensity;
    }


    public String getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }
}
