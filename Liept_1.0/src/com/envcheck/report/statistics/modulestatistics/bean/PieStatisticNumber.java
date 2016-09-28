package com.envcheck.report.statistics.modulestatistics.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by susion on 2016/6/20.
 */
public class PieStatisticNumber {

    private long value;
    private String name;

    public PieStatisticNumber(long value, String name) {
        this.value = value;
        this.name = name;
    }

    public PieStatisticNumber() {
    }


    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
