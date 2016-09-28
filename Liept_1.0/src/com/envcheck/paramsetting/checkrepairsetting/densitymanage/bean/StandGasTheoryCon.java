package com.envcheck.paramsetting.checkrepairsetting.densitymanage.bean;

/**
 * Created by susion on 2016/5/4.
 */
public class StandGasTheoryCon  {
    //编号、PPM、需要日常校准、需要漂移校准、类型
    private String id;
    private String number;
    private String ppm;
    private Boolean needDailyCheck;
    private Boolean needErraticCheck;
    private String type;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPpm() {
        return ppm;
    }

    public void setPpm(String ppm) {
        this.ppm = ppm;
    }

    public Boolean getNeedErraticCheck() {
        return needErraticCheck;
    }

    public void setNeedErraticCheck(Boolean needErraticCheck) {
        this.needErraticCheck = needErraticCheck;
    }

    public Boolean getNeedDailyCheck() {
        return needDailyCheck;
    }

    public void setNeedDailyCheck(Boolean needDailyCheck) {
        this.needDailyCheck = needDailyCheck;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
