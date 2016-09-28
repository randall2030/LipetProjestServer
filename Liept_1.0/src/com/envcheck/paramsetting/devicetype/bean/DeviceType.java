package com.envcheck.paramsetting.devicetype.bean;

import com.envcheck.base.bean.MainTainAbout;

/**
 * Created by susion on 2016/5/4.
 */
public class DeviceType extends MainTainAbout {
    //装置类型编号、类型、装置类型名称、创建时间、创建人、更新时间、更新人
    private String id;
    private String deviceTypeNumber;  //   55
    private String type;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceTypeNumber() {
        return deviceTypeNumber;
    }

    public void setDeviceTypeNumber(String deviceTypeNumber) {
        this.deviceTypeNumber = deviceTypeNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
