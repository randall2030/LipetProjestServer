package com.envcheck.report.statistics.checkstatistics.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by susion on 2016/6/21.
 */
public class StatisticWrapperForPPMAllocate {

    private List<String> devceNames = new ArrayList<>();
    private List<String> ppm500To1000 = new ArrayList<>();
    private List<String> ppm1000To2000 = new ArrayList<>();
    private List<String> ppm2000To5000 = new ArrayList<>();
    private List<String> ppm5000To10000 = new ArrayList<>();
    private List<String> ppm10000To50000 = new ArrayList<>();
    private List<String> ppm5000Up = new ArrayList<>();


    public List<String> getDevceNames() {
        return devceNames;
    }

    public void setDevceNames(List<String> devceNames) {
        this.devceNames = devceNames;
    }

    public List<String> getPpm500To1000() {
        return ppm500To1000;
    }

    public void setPpm500To1000(List<String> ppm500To1000) {
        this.ppm500To1000 = ppm500To1000;
    }

    public List<String> getPpm10000To50000() {
        return ppm10000To50000;
    }

    public void setPpm10000To50000(List<String> ppm10000To50000) {
        this.ppm10000To50000 = ppm10000To50000;
    }

    public List<String> getPpm5000Up() {
        return ppm5000Up;
    }

    public void setPpm5000Up(List<String> ppm5000Up) {
        this.ppm5000Up = ppm5000Up;
    }

    public List<String> getPpm5000To10000() {
        return ppm5000To10000;
    }

    public void setPpm5000To10000(List<String> ppm5000To10000) {
        this.ppm5000To10000 = ppm5000To10000;
    }

    public List<String> getPpm2000To5000() {
        return ppm2000To5000;
    }

    public void setPpm2000To5000(List<String> ppm2000To5000) {
        this.ppm2000To5000 = ppm2000To5000;
    }

    public List<String> getPpm1000To2000() {
        return ppm1000To2000;
    }

    public void setPpm1000To2000(List<String> ppm1000To2000) {
        this.ppm1000To2000 = ppm1000To2000;
    }
}
