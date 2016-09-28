package com.envcheck.report.statistics.letnumberstatistics.bean;

import com.envcheck.report.statistics.modulestatistics.bean.PieStatisticNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by susion on 2016/6/20.
 */
public class PieStatisticNumberWrapperForDischarge {

    private List<String> titles = new ArrayList<>();
    private List<PieStatisticNumberForDischarge> statisticInfo = new ArrayList<>();


    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public List<PieStatisticNumberForDischarge> getStatisticInfo() {
        return statisticInfo;
    }

    public void setStatisticInfo(List<PieStatisticNumberForDischarge> statisticInfo) {
        this.statisticInfo = statisticInfo;
    }
}
