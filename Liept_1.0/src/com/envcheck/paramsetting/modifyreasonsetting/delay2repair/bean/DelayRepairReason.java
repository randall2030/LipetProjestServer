package com.envcheck.paramsetting.modifyreasonsetting.delay2repair.bean;

import com.envcheck.base.bean.MainTainAbout;

/**
 * Created by susion on 2016/5/4.
 */
public class DelayRepairReason extends MainTainAbout {

    private String id;
    private String delayRepairReasonName;
    private String delayRepairReasonNumber;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDelayRepairReasonName() {
        return delayRepairReasonName;
    }

    public void setDelayRepairReasonName(String delayRepairReasonName) {
        this.delayRepairReasonName = delayRepairReasonName;
    }

    public String getDelayRepairReasonNumber() {
        return delayRepairReasonNumber;
    }

    public void setDelayRepairReasonNumber(String delayRepairReasonNumber) {
        this.delayRepairReasonNumber = delayRepairReasonNumber;
    }
}
