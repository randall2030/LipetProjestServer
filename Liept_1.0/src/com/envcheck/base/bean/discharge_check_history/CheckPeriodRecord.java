package com.envcheck.base.bean.discharge_check_history;

import java.util.Date;

/**
 * Created by susion on 2016/6/22.
 */
public class CheckPeriodRecord {

    private String id;
    private Date periodEndTime;
    private String periodName;

    public String getPeriodName() {
        return periodName;
    }

    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getPeriodEndTime() {
        return periodEndTime;
    }

    public void setPeriodEndTime(Date periodEndTime) {
        this.periodEndTime = periodEndTime;
    }
}
