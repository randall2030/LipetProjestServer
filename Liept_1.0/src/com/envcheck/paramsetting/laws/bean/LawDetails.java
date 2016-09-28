package com.envcheck.paramsetting.laws.bean;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2016/5/30.
 */
public class LawDetails {

    //总览：
    //详情名称、过滤器、备注
    private String id;
    private Set<ModuleTypeDesc> moduleType = new HashSet<>();
    private Set<MediumStatusDesc> mediumStatus = new HashSet<>();
    private String remark;

    //检测阈值：
    //PPM、PPM首次尝试修复时间、PPM首次尝试修复单位、PPM最终尝试修复时间、PPM最终尝试修复时间单位
    private String ppmLeakThreshold;
    private String PPMFirstRepairTime;
    private String PPMFirstRepairUnit;
    private String PPMFinalRepairTime;
    private String PPMFinalRepairUnit;

    //AOV：
    //DPM、DPM首次尝试修复时间、DPM首次尝试修复单位、DPM最终尝试修复时间、DPM最终尝试修复时间单位、是否允许再次AOC验证
    private String DPM;
    private String DPMFirstRepairTime;
    private String DPMFirstRepairUnit;
    private String DPMFinalRepairTime;
    private String DPMFinalRepairUnit;
    private String allowAgainAOV;

    //第一次修复：
    //是否有一次修复机会、读数阈值、一次性修复、一次性修复单位
    private String oneToRepairChance;
    private String readingThreshold;
    private String oneToRepair;
    private String oneToRepairUnit;

    //追踪检：
    //是否追踪期限 、小时
    private String trackingPeriod;
    private String hour;

    //检测频率的常规检测：
    //序列、检测频率、是否初始、AOV
    private String list;
    private String checkFre;
    private String init;
    private String AOV;


    public Set<ModuleTypeDesc> getModuleType() {
        return moduleType;
    }

    public void setModuleType(Set<ModuleTypeDesc> moduleType) {
        this.moduleType = moduleType;
    }

    public Set<MediumStatusDesc> getMediumStatus() {
        return mediumStatus;
    }

    public void setMediumStatus(Set<MediumStatusDesc> mediumStatus) {
        this.mediumStatus = mediumStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPpmLeakThreshold() {
        return ppmLeakThreshold;
    }

    public void setPpmLeakThreshold(String ppmLeakThreshold) {
        this.ppmLeakThreshold = ppmLeakThreshold;
    }

    public String getPPMFirstRepairTime() {
        return PPMFirstRepairTime;
    }

    public void setPPMFirstRepairTime(String PPMFirstRepairTime) {
        this.PPMFirstRepairTime = PPMFirstRepairTime;
    }

    public String getPPMFirstRepairUnit() {
        return PPMFirstRepairUnit;
    }

    public void setPPMFirstRepairUnit(String PPMFirstRepairUnit) {
        this.PPMFirstRepairUnit = PPMFirstRepairUnit;
    }

    public String getPPMFinalRepairTime() {
        return PPMFinalRepairTime;
    }

    public void setPPMFinalRepairTime(String PPMFinalRepairTime) {
        this.PPMFinalRepairTime = PPMFinalRepairTime;
    }

    public String getPPMFinalRepairUnit() {
        return PPMFinalRepairUnit;
    }

    public void setPPMFinalRepairUnit(String PPMFinalRepairUnit) {
        this.PPMFinalRepairUnit = PPMFinalRepairUnit;
    }

    public String getDPM() {
        return DPM;
    }

    public void setDPM(String DPM) {
        this.DPM = DPM;
    }

    public String getDPMFirstRepairTime() {
        return DPMFirstRepairTime;
    }

    public void setDPMFirstRepairTime(String DPMFirstRepairTime) {
        this.DPMFirstRepairTime = DPMFirstRepairTime;
    }

    public String getDPMFirstRepairUnit() {
        return DPMFirstRepairUnit;
    }

    public void setDPMFirstRepairUnit(String DPMFirstRepairUnit) {
        this.DPMFirstRepairUnit = DPMFirstRepairUnit;
    }

    public String getDPMFinalRepairTime() {
        return DPMFinalRepairTime;
    }

    public void setDPMFinalRepairTime(String DPMFinalRepairTime) {
        this.DPMFinalRepairTime = DPMFinalRepairTime;
    }

    public String getDPMFinalRepairUnit() {
        return DPMFinalRepairUnit;
    }

    public void setDPMFinalRepairUnit(String DPMFinalRepairUnit) {
        this.DPMFinalRepairUnit = DPMFinalRepairUnit;
    }

    public String getAllowAgainAOV() {
        return allowAgainAOV;
    }

    public void setAllowAgainAOV(String allowAgainAOV) {
        this.allowAgainAOV = allowAgainAOV;
    }

      public String getOneToRepairChance() {
        return oneToRepairChance;
    }

    public void setOneToRepairChance(String oneToRepairChance) {
        this.oneToRepairChance = oneToRepairChance;
    }

    public String getReadingThreshold() {
        return readingThreshold;
    }

    public void setReadingThreshold(String readingThreshold) {
        this.readingThreshold = readingThreshold;
    }

    public String getOneToRepair() {
        return oneToRepair;
    }

    public void setOneToRepair(String oneToRepair) {
        this.oneToRepair = oneToRepair;
    }

    public String getOneToRepairUnit() {
        return oneToRepairUnit;
    }

    public void setOneToRepairUnit(String oneToRepairUnit) {
        this.oneToRepairUnit = oneToRepairUnit;
    }

    public String getTrackingPeriod() {
        return trackingPeriod;
    }

    public void setTrackingPeriod(String trackingPeriod) {
        this.trackingPeriod = trackingPeriod;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }
    public String getCheckFre() {
        return checkFre;
    }

    public void setCheckFre(String checkFre) {
        this.checkFre = checkFre;
    }

    public String getInit() {
        return init;
    }

    public void setInit(String init) {
        this.init = init;
    }

    public String getAOV() {
        return AOV;
    }

    public void setAOV(String AOV) {
        this.AOV = AOV;
    }

}
