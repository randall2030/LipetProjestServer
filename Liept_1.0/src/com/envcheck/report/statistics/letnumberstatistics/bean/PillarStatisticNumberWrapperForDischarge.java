package com.envcheck.report.statistics.letnumberstatistics.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by susion on 2016/6/20.
 */
public class PillarStatisticNumberWrapperForDischarge {

    private List<String> titles = new ArrayList<>();
    private List<Integer> yHeight = new ArrayList<>();
    private List<Float> statisticInfo = new ArrayList<>();


    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public List<Float> getStatisticInfo() {
        return statisticInfo;
    }

    public void setStatisticInfo(List<Float> statisticInfo) {
        this.statisticInfo = statisticInfo;
    }

    public List<Integer> getyHeight() {
        return yHeight;
    }

    public void setyHeight(List<Integer> yHeight) {
        this.yHeight = yHeight;
    }
}
