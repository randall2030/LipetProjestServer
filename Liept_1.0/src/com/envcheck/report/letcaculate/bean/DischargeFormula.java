package com.envcheck.report.letcaculate.bean;

/**
 * Created by Administrator on 2016/7/15.
 */
public class DischargeFormula {
    public double averageDischargeSpeed;
    public double defaultZeroDischargeSpeed;
    public double relativeFormula;
    public double cleanPPMPow;
    public int thresholdValue;
    public double thresholdSpeed;
    public double dischargeSpeed;

    public DischargeFormula(){

    }

    public DischargeFormula(double averageDischargeSpeed) {
        this.averageDischargeSpeed = averageDischargeSpeed;
    }

    public DischargeFormula(double averageDischargeSpeed, double defaultZeroDischargeSpeed, double relativeFormula, double cleanPPMPow, int thresholdValue, double thresholdSpeed) {
        this.averageDischargeSpeed = averageDischargeSpeed;
        this.defaultZeroDischargeSpeed = defaultZeroDischargeSpeed;
        this.relativeFormula = relativeFormula;
        this.cleanPPMPow = cleanPPMPow;
        this.thresholdValue = thresholdValue;
        this.thresholdSpeed = thresholdSpeed;
    }
}
