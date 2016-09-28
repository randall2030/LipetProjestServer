package com.envcheck.report.statistics.modulestatistics.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by susion on 2016/6/20.
 */
public class PieStatisticNumberWrapper {

    private String bigTitle;
    private List<String> titles = new ArrayList<>();
    private List<PieStatisticNumber> statisticInfo = new ArrayList<>();


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

    public List<PieStatisticNumber> getStatisticInfo() {
        return statisticInfo;
    }

    public void setStatisticInfo(List<PieStatisticNumber> statisticInfo) {
        this.statisticInfo = statisticInfo;
    }
}
