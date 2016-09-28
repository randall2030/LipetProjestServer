package com.envcheck.paramsetting.modelinfosetting.modelsubtype.bean;

import com.envcheck.base.bean.MainTainAbout;

/**
 * Created by susion on 2016/5/4.
 */
public class ModelSubType extends MainTainAbout {

    //组件子类型编号、组件子类型名称、组件类型、创建时间、创建人、更新时间、更新人
    private String id;
    private String modelSubTypeNumber;
    private String modeSubTypeName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelSubTypeNumber() {
        return modelSubTypeNumber;
    }

    public void setModelSubTypeNumber(String modelSubTypeNumber) {
        this.modelSubTypeNumber = modelSubTypeNumber;
    }

    public String getModeSubTypeName() {
        return modeSubTypeName;
    }

    public void setModeSubTypeName(String modeSubTypeName) {
        this.modeSubTypeName = modeSubTypeName;
    }
}
