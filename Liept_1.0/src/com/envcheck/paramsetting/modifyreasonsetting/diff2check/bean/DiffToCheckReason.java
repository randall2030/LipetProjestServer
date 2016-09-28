package com.envcheck.paramsetting.modifyreasonsetting.diff2check.bean;

import com.envcheck.base.bean.MainTainAbout;

/**
 * Created by susion on 2016/5/4.
 */
public class DiffToCheckReason extends MainTainAbout {

    //难于检测原因编号、难于检测原因名称、创建时间 、创建人 、更新时间 、更新人
    private String id;
    private String diffToCheckReasonNumber;
    private String diffToCheckReasonName;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDiffToCheckReasonNumber() {
        return diffToCheckReasonNumber;
    }

    public void setDiffToCheckReasonNumber(String diffToCheckReasonNumber) {
        this.diffToCheckReasonNumber = diffToCheckReasonNumber;
    }

    public String getDiffToCheckReasonName() {
        return diffToCheckReasonName;
    }

    public void setDiffToCheckReasonName(String diffToCheckReasonName) {
        this.diffToCheckReasonName = diffToCheckReasonName;
    }
}
