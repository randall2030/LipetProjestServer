package com.envcheck.report.letcaculate.bean;

/**
 * Created by susion on 2016/8/14.
 */
public class MinusLetNumber {

    private String labelNumber;
    private int extendNumber;
    private String device;
    private String area;
    private double runTime;
    private double oldLetNumber;
    private double newLetNummber;
    private double minusLetNumber;


    public String getLabelNumber() {
        return labelNumber;
    }

    public void setLabelNumber(String labelNumber) {
        this.labelNumber = labelNumber;
    }

    public int getExtendNumber() {
        return extendNumber;
    }

    public void setExtendNumber(int extendNumber) {
        this.extendNumber = extendNumber;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public double getRunTime() {
        return runTime;
    }

    public void setRunTime(double runTime) {
        this.runTime = runTime;
    }

    public double getNewLetNummber() {
        return newLetNummber;
    }

    public void setNewLetNummber(double newLetNummber) {
        this.newLetNummber = newLetNummber;
    }

    public double getOldLetNumber() {
        return oldLetNumber;
    }

    public void setOldLetNumber(double oldLetNumber) {
        this.oldLetNumber = oldLetNumber;
    }

    public double getMinusLetNumber() {
        return minusLetNumber;
    }

    public void setMinusLetNumber(double minusLetNumber) {
        this.minusLetNumber = minusLetNumber;
    }
}
