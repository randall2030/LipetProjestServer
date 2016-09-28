package com.envcheck.report.statistics.tendencystatistics.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by susion on 2016/6/21.
 */
public class StatisticForDeviceTendency {

    private String name;
    private String type;
    private List<Long> data = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getData() {
        return data;
    }

    public void setData(List<Long> data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
