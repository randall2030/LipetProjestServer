package com.envcheck.paramsetting.laws.bean;

import com.envcheck.base.bean.MainTainAbout;

import java.util.*;

/**
 * Created by susion on 2016/5/3.
 */
public class Law extends MainTainAbout {
    //法规代码、法规描述、备注、当前法规(是否为当前法规)
    private String id;
    private String lawCode;
    private String lawDesc;
    private String lawRemark;
    private boolean currentLaw;



    //一条法规 对应 多个详情
    private Set<LawDetails> lawDetails = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLawCode() {
        return lawCode;
    }
    public void setLawCode(String lawCode) {
        this.lawCode = lawCode;
    }

    public String getLawRemark() {
        return lawRemark;
    }

    public void setLawRemark(String lawRemark) {
        this.lawRemark = lawRemark;
    }

    public String getLawDesc() {
        return lawDesc;
    }

    public void setLawDesc(String lawDesc) {
        this.lawDesc = lawDesc;
    }

    public boolean isCurrentLaw() {
        return currentLaw;
    }

    public void setCurrentLaw(boolean currentLaw) {
        this.currentLaw = currentLaw;
    }

    public Set<LawDetails> getLawDetails() {
        return lawDetails;
    }

    public void setLawDetails(Set<LawDetails> lawDetails) {
        this.lawDetails = lawDetails;
    }

}
