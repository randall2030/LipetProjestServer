package com.envcheck.paramsetting.checkrepairsetting.revealsrc.bean;

import com.envcheck.base.bean.MainTainAbout;

/**
 * Created by susion on 2016/5/4.
 */
public class RevealSource extends MainTainAbout {

    //泄漏源编号、泄漏源名称、组件类型 、创建时间 、创建人 、更新时间 、更新人

    private String id;
    private String revealSrcNumber;
    private String revealSrcName;
    private String modelType;  //来自组件类型\


    public String getRevealSrcNumber() {
        return revealSrcNumber;
    }

    public void setRevealSrcNumber(String revealSrcNumber) {
        this.revealSrcNumber = revealSrcNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public String getRevealSrcName() {
        return revealSrcName;
    }

    public void setRevealSrcName(String revealSrcName) {
        this.revealSrcName = revealSrcName;
    }
}
