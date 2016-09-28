package com.envcheck.paramsetting.checkrepairsetting.checkapparatus.bean;

import com.envcheck.base.bean.MainTainAbout;

import java.util.Date;

/**
 * Created by susion on 2016/5/4.
 */
public class CheckApparatus{

    //序列号、检测仪器名称、最后精密校准时间、响应时间、创建时间、创建人、修改时间、修改人

    private String id;
    private String sequenceNumber;
    private String apparatusName;
    private Date lastCheckTime;
    private String reactTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getApparatusName() {
        return apparatusName;
    }

    public void setApparatusName(String apparatusName) {
        this.apparatusName = apparatusName;
    }

    public Date getLastCheckTime() {
        return lastCheckTime;
    }

    public void setLastCheckTime(Date lastCheckTime) {
        this.lastCheckTime = lastCheckTime;
    }

    public String getReactTime() {
        return reactTime;
    }

    public void setReactTime(String reactTime) {
        this.reactTime = reactTime;
    }
}
