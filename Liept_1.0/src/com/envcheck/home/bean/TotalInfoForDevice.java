package com.envcheck.home.bean;

/**
 * Created by susion on 2016/8/3.
 */
public class TotalInfoForDevice {

    private String deviceName;
    private long totalCheckNumber;
    private long easyCheckNumber;
    private long hasCheckNumber;
    private String checkPercent;
    private long leakNumber;
    private String leakPercent;
    private long repairNumber;
    private String repairPercent;
    private long delayRepairNumber;
    private long currentLeakNumber;
    private String currentLeakPercent;


    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public long getTotalCheckNumber() {
        return totalCheckNumber;
    }

    public void setTotalCheckNumber(long totalCheckNumber) {
        this.totalCheckNumber = totalCheckNumber;
    }

    public long getEasyCheckNumber() {
        return easyCheckNumber;
    }

    public void setEasyCheckNumber(long easyCheckNumber) {
        this.easyCheckNumber = easyCheckNumber;
    }

    public long getHasCheckNumber() {
        return hasCheckNumber;
    }

    public void setHasCheckNumber(long hasCheckNumber) {
        this.hasCheckNumber = hasCheckNumber;
    }

    public String getCheckPercent() {
        return checkPercent;
    }

    public void setCheckPercent(String checkPercent) {
        this.checkPercent = checkPercent;
    }

    public String getLeakPercent() {
        return leakPercent;
    }

    public void setLeakPercent(String leakPercent) {
        this.leakPercent = leakPercent;
    }

    public String getRepairPercent() {
        return repairPercent;
    }

    public void setRepairPercent(String repairPercent) {
        this.repairPercent = repairPercent;
    }

    public String getCurrentLeakPercent() {
        return currentLeakPercent;
    }

    public void setCurrentLeakPercent(String currentLeakPercent) {
        this.currentLeakPercent = currentLeakPercent;
    }

    public long getLeakNumber() {
        return leakNumber;
    }

    public void setLeakNumber(long leakNumber) {
        this.leakNumber = leakNumber;
    }



    public long getRepairNumber() {
        return repairNumber;
    }

    public void setRepairNumber(long repairNumber) {
        this.repairNumber = repairNumber;
    }


    public long getDelayRepairNumber() {
        return delayRepairNumber;
    }

    public void setDelayRepairNumber(long delayRepairNumber) {
        this.delayRepairNumber = delayRepairNumber;
    }

    public long getCurrentLeakNumber() {
        return currentLeakNumber;
    }

    public void setCurrentLeakNumber(long currentLeakNumber) {
        this.currentLeakNumber = currentLeakNumber;
    }


}
