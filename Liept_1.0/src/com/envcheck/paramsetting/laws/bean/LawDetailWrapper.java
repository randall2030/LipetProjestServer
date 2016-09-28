package com.envcheck.paramsetting.laws.bean;

/**
 * Created by susion on 2016/6/19.
 */
public class LawDetailWrapper {

    private String lawDetailId;
    private String detailName;
    private String ppmLeakThreshold;
    private String ppmCheckFren;
    private String dpmLeakThreshold;
    private String aovCheckFren;


    public String getLawDetailId() {
        return lawDetailId;
    }

    public void setLawDetailId(String lawDetailId) {
        this.lawDetailId = lawDetailId;
    }

    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }

    public String getPpmLeakThreshold() {
        return ppmLeakThreshold;
    }

    public void setPpmLeakThreshold(String ppmLeakThreshold) {
        this.ppmLeakThreshold = ppmLeakThreshold;
    }

    public String getPpmCheckFren() {
        return ppmCheckFren;
    }

    public void setPpmCheckFren(String ppmCheckFren) {
        this.ppmCheckFren = ppmCheckFren;
    }

    public String getDpmLeakThreshold() {
        return dpmLeakThreshold;
    }

    public void setDpmLeakThreshold(String dpmLeakThreshold) {
        this.dpmLeakThreshold = dpmLeakThreshold;
    }

    public String getAovCheckFren() {
        return aovCheckFren;
    }

    public void setAovCheckFren(String aovCheckFren) {
        this.aovCheckFren = aovCheckFren;
    }
}
