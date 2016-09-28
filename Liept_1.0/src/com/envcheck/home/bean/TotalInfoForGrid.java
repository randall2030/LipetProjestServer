package com.envcheck.home.bean;

/**
 * Created by susion on 2016/8/22.
 */
public class TotalInfoForGrid {

    private String totalName;
    private long totalCheckPoint;

    //装置	总检测点数	常规检测点	已检	检测完成率	泄露点数	泄露率	修复点数	修复率
    // 延迟修复点数	当前泄露点数	当前泄露率
    private long commonCheckPoint;
    private long hasCheckPoint;
    private String checkFinishPercent;
    private long leakNumber;
    private String leakPercent;
    private long repairpoint;
    private String repairPercent;
    private long delayRepairPoint;
    private long currentLeakPoint;
    private String currentLeakPercent;


    public String getTotalName() {
        return totalName;
    }

    public void setTotalName(String totalName) {
        this.totalName = totalName;
    }

    public long getCommonCheckPoint() {
        return commonCheckPoint;
    }

    public void setCommonCheckPoint(long commonCheckPoint) {
        this.commonCheckPoint = commonCheckPoint;
    }

    public long getTotalCheckPoint() {
        return totalCheckPoint;
    }

    public void setTotalCheckPoint(long totalCheckPoint) {
        this.totalCheckPoint = totalCheckPoint;
    }

    public long getHasCheckPoint() {
        return hasCheckPoint;
    }

    public void setHasCheckPoint(long hasCheckPoint) {
        this.hasCheckPoint = hasCheckPoint;
    }

    public long getLeakNumber() {
        return leakNumber;
    }

    public void setLeakNumber(long leakNumber) {
        this.leakNumber = leakNumber;
    }



    public long getRepairpoint() {
        return repairpoint;
    }

    public void setRepairpoint(long repairpoint) {
        this.repairpoint = repairpoint;
    }



    public long getDelayRepairPoint() {
        return delayRepairPoint;
    }

    public void setDelayRepairPoint(long delayRepairPoint) {
        this.delayRepairPoint = delayRepairPoint;
    }

    public long getCurrentLeakPoint() {
        return currentLeakPoint;
    }

    public void setCurrentLeakPoint(long currentLeakPoint) {
        this.currentLeakPoint = currentLeakPoint;
    }

    public String getCheckFinishPercent() {
        return checkFinishPercent;
    }

    public void setCheckFinishPercent(String checkFinishPercent) {
        this.checkFinishPercent = checkFinishPercent;
    }

    public String getCurrentLeakPercent() {
        return currentLeakPercent;
    }

    public void setCurrentLeakPercent(String currentLeakPercent) {
        this.currentLeakPercent = currentLeakPercent;
    }

    public String getRepairPercent() {
        return repairPercent;
    }

    public void setRepairPercent(String repairPercent) {
        this.repairPercent = repairPercent;
    }

    public String getLeakPercent() {
        return leakPercent;
    }

    public void setLeakPercent(String leakPercent) {
        this.leakPercent = leakPercent;
    }
}
