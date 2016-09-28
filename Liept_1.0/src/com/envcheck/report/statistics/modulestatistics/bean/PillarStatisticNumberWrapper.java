package com.envcheck.report.statistics.modulestatistics.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by susion on 2016/6/20.
 */
public class PillarStatisticNumberWrapper {

    private String bigTitle;
    private List<String> titles = new ArrayList<>();
    private List<Integer> yHeight = new ArrayList<>();
    private List<Long> statisticInfo = new ArrayList<>();


    public String getBigTitle() {
        return bigTitle;
    }

    public void setBigTitle(String bigTitle) {
        this.bigTitle = bigTitle;
    }

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public List<Long> getStatisticInfo() {
        return statisticInfo;
    }

    public void setStatisticInfo(List<Long> statisticInfo) {
        this.statisticInfo = statisticInfo;
    }

    public List<Integer> getyHeight() {
        return yHeight;
    }

    public void setyHeight(List<Integer> yHeight) {
        this.yHeight = yHeight;
    }
}
