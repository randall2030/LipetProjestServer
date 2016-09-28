package com.envcheck.paramsetting.laws.bean;

/**
 * Created by susion on 2016/6/5.
 */
public class MediumStatusDesc {

    private String id;
    private String mediumStatus;

    public MediumStatusDesc(){

    }

    public MediumStatusDesc(String mediumStatus) {
        this.mediumStatus = mediumStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMediumStatus() {
        return mediumStatus;
    }

    public void setMediumStatus(String mediumStatus) {
        this.mediumStatus = mediumStatus;
    }
}
