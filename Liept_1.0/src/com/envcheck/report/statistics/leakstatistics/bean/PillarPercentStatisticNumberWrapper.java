package com.envcheck.report.statistics.leakstatistics.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by susion on 2016/6/20.
 */
public class PillarPercentStatisticNumberWrapper {

    private List<String> titles = new ArrayList<>();
    private List<Long> pointNumbers = new ArrayList<>();
    private List<Double> percentValues = new ArrayList<>();


    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public List<Long> getPointNumbers() {
        return pointNumbers;
    }

    public void setPointNumbers(List<Long> pointNumbers) {
        this.pointNumbers = pointNumbers;
    }

    public List<Double> getPercentValues() {
        return percentValues;
    }

    public void setPercentValues(List<Double> percentValues) {
        this.percentValues = percentValues;
    }
}
