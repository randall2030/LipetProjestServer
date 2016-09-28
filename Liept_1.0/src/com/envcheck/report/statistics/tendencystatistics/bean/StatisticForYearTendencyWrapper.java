package com.envcheck.report.statistics.tendencystatistics.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by susion on 2016/6/21.
 */
public class StatisticForYearTendencyWrapper {

    private List<String> yearNames = new ArrayList<>();
    private List<StatisticForDeviceTendency> deviceToNumberList = new ArrayList<>();


    public List<String> getYearNames() {
        return yearNames;
    }

    public void setYearNames(List<String> yearNames) {
        this.yearNames = yearNames;
    }

    public List<StatisticForDeviceTendency> getDeviceToNumberList() {
        return deviceToNumberList;
    }

    public void setDeviceToNumberList(List<StatisticForDeviceTendency> deviceToNumberList) {
        this.deviceToNumberList = deviceToNumberList;
    }
}
