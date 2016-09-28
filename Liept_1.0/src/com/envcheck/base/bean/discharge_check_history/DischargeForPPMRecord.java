package com.envcheck.base.bean.discharge_check_history;

import java.util.Date;

/**
 * Created by susion on 2016/6/22.
 */
public class DischargeForPPMRecord {

    private String id;
    private int cleanPPMValue;
    private Date checkTime;
    private boolean endPeriodRecord;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCleanPPMValue() {
        return cleanPPMValue;
    }

    public void setCleanPPMValue(int cleanPPMValue) {
        this.cleanPPMValue = cleanPPMValue;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public boolean isEndPeriodRecord() {
        return endPeriodRecord;
    }

    public void setEndPeriodRecord(boolean endPeriodRecord) {
        this.endPeriodRecord = endPeriodRecord;
    }
}
