package com.envcheck.paramsetting.modelinfosetting.caculatetype.bean;

import com.envcheck.base.bean.MainTainAbout;

/**
 * Created by susion on 2016/5/4.
 */
public class CaculateType extends MainTainAbout {
    //计算类别编号、计算类别名称、创建时间、创建人、更新时间、更新人
    private String id;
    private String caculateTypeNumber;
    private String caculateTypeName;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCaculateTypeNumber() {
        return caculateTypeNumber;
    }

    public void setCaculateTypeNumber(String caculateTypeNumber) {
        this.caculateTypeNumber = caculateTypeNumber;
    }

    public String getCaculateTypeName() {
        return caculateTypeName;
    }

    public void setCaculateTypeName(String caculateTypeName) {
        this.caculateTypeName = caculateTypeName;
    }
}
