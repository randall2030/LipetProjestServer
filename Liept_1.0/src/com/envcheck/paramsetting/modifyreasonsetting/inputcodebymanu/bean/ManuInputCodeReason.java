package com.envcheck.paramsetting.modifyreasonsetting.inputcodebymanu.bean;

import com.envcheck.base.bean.MainTainAbout;

/**
 * Created by susion on 2016/5/4.
 */
public class ManuInputCodeReason extends MainTainAbout {

    private String id;
    private String companyCode;
    private String manuInputCodeReasonName;
    private String manuInputCodeReasonNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManuInputCodeReasonName() {
        return manuInputCodeReasonName;
    }

    public void setManuInputCodeReasonName(String manuInputCodeReasonName) {
        this.manuInputCodeReasonName = manuInputCodeReasonName;
    }

    public String getManuInputCodeReasonNumber() {
        return manuInputCodeReasonNumber;
    }

    public void setManuInputCodeReasonNumber(String manuInputCodeReasonNumber) {
        this.manuInputCodeReasonNumber = manuInputCodeReasonNumber;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
}
