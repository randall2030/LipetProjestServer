package com.envcheck.paramsetting.modifyreasonsetting.temp2move.bean;

import com.envcheck.base.bean.MainTainAbout;

/**
 * Created by susion on 2016/5/4.
 */
public class TempMoveReason extends MainTainAbout {

    private String id;
    private String tempMoveReasonNumber;
    private String tempMoveReasonName;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTempMoveReasonNumber() {
        return tempMoveReasonNumber;
    }

    public void setTempMoveReasonNumber(String tempMoveReasonNumber) {
        this.tempMoveReasonNumber = tempMoveReasonNumber;
    }

    public String getTempMoveReasonName() {
        return tempMoveReasonName;
    }

    public void setTempMoveReasonName(String tempMoveReasonName) {
        this.tempMoveReasonName = tempMoveReasonName;
    }
}
