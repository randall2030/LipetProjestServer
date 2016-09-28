package com.envcheck.paramsetting.checkrepairsetting.repairmeasure.bean;

import com.envcheck.base.bean.MainTainAbout;

/**
 * Created by susion on 2016/5/4.
 */
public class RepairMeasure extends MainTainAbout {

    //维修措施编号、维修措施名称、组件类型、创建时间 、创建人 、更新时间 、更新人
    private String id;
    private String repairMeasureNumber;
    private String repairMeasureName;
    private String modelType;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRepairMeasureNumber() {
        return repairMeasureNumber;
    }

    public void setRepairMeasureNumber(String repairMeasureNumber) {
        this.repairMeasureNumber = repairMeasureNumber;
    }

    public String getRepairMeasureName() {
        return repairMeasureName;
    }

    public void setRepairMeasureName(String repairMeasureName) {
        this.repairMeasureName = repairMeasureName;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }
}
