package com.envcheck.paramsetting.modifyreasonsetting.danger2check.bean;

import com.envcheck.base.bean.MainTainAbout;

/**
 * Created by susion on 2016/5/4.
 */
public class DangerToCheckReason extends MainTainAbout {

    //险于检测原因编号、险于检测原因名称、创建时间 、创建人 、更新时间 、更新

    private String id;
    private String dangerToCheckReasonNumber;
    private String dangerToCheckReasonName;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDangerToCheckReasonNumber() {
        return dangerToCheckReasonNumber;
    }

    public void setDangerToCheckReasonNumber(String dangerToCheckReasonNumber) {
        this.dangerToCheckReasonNumber = dangerToCheckReasonNumber;
    }

    public String getDangerToCheckReasonName() {
        return dangerToCheckReasonName;
    }

    public void setDangerToCheckReasonName(String dangerToCheckReasonName) {
        this.dangerToCheckReasonName = dangerToCheckReasonName;
    }
}
