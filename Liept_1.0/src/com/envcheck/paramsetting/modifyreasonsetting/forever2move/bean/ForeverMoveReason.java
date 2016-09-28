package com.envcheck.paramsetting.modifyreasonsetting.forever2move.bean;

import com.envcheck.base.bean.MainTainAbout;

/**
 * Created by susion on 2016/5/4.
 */
public class ForeverMoveReason extends MainTainAbout {

    private String id;
    private String foreverMoveReasonName;
    private String foreverMoveReasonNumber;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getForeverMoveReasonName() {
        return foreverMoveReasonName;
    }

    public void setForeverMoveReasonName(String foreverMoveReasonName) {
        this.foreverMoveReasonName = foreverMoveReasonName;
    }

    public String getForeverMoveReasonNumber() {
        return foreverMoveReasonNumber;
    }

    public void setForeverMoveReasonNumber(String foreverMoveReasonNumber) {
        this.foreverMoveReasonNumber = foreverMoveReasonNumber;
    }
}
