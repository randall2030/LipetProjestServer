package com.envcheck.android.bean;

import java.io.Serializable;

/**
 * Created by susion on 2016/5/22.
 */
public class SceneCollectModuleTask implements Serializable {

    private String type;
    private String isWarm;
    private String size;
    private String extendNumber;
    private LayoutBean layoutBean;

    public SceneCollectModuleTask(String type, String isWarm, String size, String extendNumber) {
        this.type = type;
        this.isWarm = isWarm;
        this.size = size;
        this.extendNumber = extendNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsWarm() {
        return isWarm;
    }

    public void setIsWarm(String isWarm) {
        this.isWarm = isWarm;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getExtendNumber() {
        return extendNumber;
    }

    public void setExtendNumber(String extendNumber) {
        this.extendNumber = extendNumber;
    }

    public LayoutBean getLayoutBean() {
        return layoutBean;
    }

    public void setLayoutBean(LayoutBean layoutBean) {
        this.layoutBean = layoutBean;
    }


}
