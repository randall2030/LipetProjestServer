package com.envcheck.paramsetting.modelinfosetting.mediumstatus.bean;

import com.envcheck.base.bean.MainTainAbout;

/**
 * Created by susion on 2016/5/4.
 */
public class MediumStatus extends MainTainAbout {
    private String id;
    private String mediumNumber;
    private String mediumName;
    private String importReport;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMediumName() {
        return mediumName;
    }

    public void setMediumName(String mediumName) {
        this.mediumName = mediumName;
    }

    public String getMediumNumber() {
        return mediumNumber;
    }

    public void setMediumNumber(String mediumNumber) {
        this.mediumNumber = mediumNumber;
    }

    public String getImportReport() {
        return importReport;
    }

    public void setImportReport(String importReport) {
        this.importReport = importReport;
    }
}
