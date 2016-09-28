package com.envcheck.home.bean;

/**
 * Created by susion on 2016/8/3.
 */
public class TotalInfo {

    private long totalLabelNumber;
    private long totalModuleNumber;
    private long easyCheckModuleNumber;
    private long diffCheckModuleNumber;
    private long currentLeakNumber;
    private long currentDelayRepairNumber;

    public long getTotalLabelNumber() {
        return totalLabelNumber;
    }

    public void setTotalLabelNumber(long totalLabelNumber) {
        this.totalLabelNumber = totalLabelNumber;
    }

    public long getTotalModuleNumber() {
        return totalModuleNumber;
    }

    public void setTotalModuleNumber(long totalModuleNumber) {
        this.totalModuleNumber = totalModuleNumber;
    }

    public long getEasyCheckModuleNumber() {
        return easyCheckModuleNumber;
    }

    public void setEasyCheckModuleNumber(long easyCheckModuleNumber) {
        this.easyCheckModuleNumber = easyCheckModuleNumber;
    }

    public long getDiffCheckModuleNumber() {
        return diffCheckModuleNumber;
    }

    public void setDiffCheckModuleNumber(long diffCheckModuleNumber) {
        this.diffCheckModuleNumber = diffCheckModuleNumber;
    }

    public long getCurrentLeakNumber() {
        return currentLeakNumber;
    }

    public void setCurrentLeakNumber(long currentLeakNumber) {
        this.currentLeakNumber = currentLeakNumber;
    }

    public long getCurrentDelayRepairNumber() {
        return currentDelayRepairNumber;
    }

    public void setCurrentDelayRepairNumber(long currentDelayRepairNumber) {
        this.currentDelayRepairNumber = currentDelayRepairNumber;
    }
}
