package com.envcheck.paramsetting.checkrepairsetting.checkfren.bean;

import com.envcheck.base.bean.MainTainAbout;

import java.util.Date;

/**
 * Created by susion on 2016/5/4.
 */
public class CheckFrequency extends MainTainAbout {

    //检测频率编号、检测频率名称、豁免频率、最小检测间隔、仪器检测开始日期、AOV检测开始日期、日、月、年、
    // 创建时间、创建人、更新时间、更新人
    private String id;
    private String checkFrequencyNumber;
    private String checkFrequencyName;
    private Boolean exemptFrequency;
    private String minCheckInterval;
    private Date apparatusStartDate;
    private Date aovStartDate;
    private String day;
    private String month;
    private String year;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Date getAovStartDate() {
        return aovStartDate;
    }

    public void setAovStartDate(Date aovStartDate) {
        this.aovStartDate = aovStartDate;
    }

    public Date getApparatusStartDate() {
        return apparatusStartDate;
    }

    public void setApparatusStartDate(Date apparatusStartDate) {
        this.apparatusStartDate = apparatusStartDate;
    }

    public String getMinCheckInterval() {
        return minCheckInterval;
    }

    public void setMinCheckInterval(String minCheckInterval) {
        this.minCheckInterval = minCheckInterval;
    }

    public Boolean getExemptFrequency() {
        return exemptFrequency;
    }

    public void setExemptFrequency(Boolean exemptFrequency) {
        this.exemptFrequency = exemptFrequency;
    }

    public String getCheckFrequencyName() {
        return checkFrequencyName;
    }

    public void setCheckFrequencyName(String checkFrequencyName) {
        this.checkFrequencyName = checkFrequencyName;
    }

    public String getCheckFrequencyNumber() {
        return checkFrequencyNumber;
    }

    public void setCheckFrequencyNumber(String checkFrequencyNumber) {
        this.checkFrequencyNumber = checkFrequencyNumber;
    }
}
