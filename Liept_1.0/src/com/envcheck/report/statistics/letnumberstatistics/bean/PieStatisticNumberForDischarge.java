package com.envcheck.report.statistics.letnumberstatistics.bean;

/**
 * Created by susion on 2016/6/20.
 */
public class PieStatisticNumberForDischarge {

    private float value;
    private String name;

    public PieStatisticNumberForDischarge(float value, String name) {
        this.value = value;
        this.name = name;
    }

    public PieStatisticNumberForDischarge() {
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
