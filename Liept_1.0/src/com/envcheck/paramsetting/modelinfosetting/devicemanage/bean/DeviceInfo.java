package com.envcheck.paramsetting.modelinfosetting.devicemanage.bean;

import com.envcheck.base.bean.MainTainAbout;

/**
 * Created by susion on 2016/5/4.
 */
public class DeviceInfo {

    // 装置编号、装置名称、装置类型、部门名称、创建时间、创建人、修改时间、修改人、套数
    private String id;
    private String deviceNumber;
    private String deviceName;
    private String deviceType;  //来自于装置类型表
    private String sequenceNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getSequenceNumber() {
        return sequenceNumber;
    }
    public void setSequenceNumber(String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }
}
