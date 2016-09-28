package com.envcheck.paramsetting.modifyreasonsetting.modelmodify.bean;

import com.envcheck.base.bean.MainTainAbout;

/**
 * Created by susion on 2016/5/4.
 */
public class ModelModifyReason extends MainTainAbout {

    //组件更改原因编号、组件更改原因名称、创建时间 、创建人 、更新时间 、更新人
    private String id;
    private String modifyReasonNumber;
    private String modifyReasonName;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModifyReasonNumber() {
        return modifyReasonNumber;
    }

    public void setModifyReasonNumber(String modifyReasonNumber) {
        this.modifyReasonNumber = modifyReasonNumber;
    }

    public String getModifyReasonName() {
        return modifyReasonName;
    }

    public void setModifyReasonName(String modifyReasonName) {
        this.modifyReasonName = modifyReasonName;
    }
}
