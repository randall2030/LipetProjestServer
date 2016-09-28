package com.envcheck.paramsetting.modifyreasonsetting.no2repair.bean;

import com.envcheck.base.bean.MainTainAbout;

/**
 * Created by susion on 2016/5/4.
 */
public class NoNeedRepairReason extends MainTainAbout {

    private String id;
    private String noNeedRepairReasonName;
    private String noNeedRepairReasonNumber;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNoNeedRepairReasonName() {
        return noNeedRepairReasonName;
    }

    public void setNoNeedRepairReasonName(String noNeedRepairReasonName) {
        this.noNeedRepairReasonName = noNeedRepairReasonName;
    }

    public String getNoNeedRepairReasonNumber() {
        return noNeedRepairReasonNumber;
    }

    public void setNoNeedRepairReasonNumber(String noNeedRepairReasonNumber) {
        this.noNeedRepairReasonNumber = noNeedRepairReasonNumber;
    }
}
