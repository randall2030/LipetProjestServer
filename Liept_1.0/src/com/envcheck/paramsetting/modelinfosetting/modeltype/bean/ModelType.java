package com.envcheck.paramsetting.modelinfosetting.modeltype.bean;

import com.envcheck.base.bean.MainTainAbout;

/**
 * Created by susion on 2016/5/4.
 */
public class ModelType extends MainTainAbout {
    //组件类型编号、组件类型名称、计算类别、创建时间、创建人、更新时间、更新人

    private String id;
    private String modelTypeNumber;
    private String modelTypeName;
    private String caculateType;   //来自计算类别


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelTypeNumber() {
        return modelTypeNumber;
    }

    public void setModelTypeNumber(String modelTypeNumber) {
        this.modelTypeNumber = modelTypeNumber;
    }

    public String getModelTypeName() {
        return modelTypeName;
    }

    public void setModelTypeName(String modelTypeName) {
        this.modelTypeName = modelTypeName;
    }

    public String getCaculateType() {
        return caculateType;
    }

    public void setCaculateType(String caculateType) {
        this.caculateType = caculateType;
    }
}
