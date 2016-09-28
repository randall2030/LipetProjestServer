package com.envcheck.paramsetting.checkrepairsetting.minchecktime.bean;

/**
 * Created by susion on 2016/6/5.
 */
public class SizeRange {

    private String id;
    private String minSize;
    private String maxSize;
    private int minCheckTime;


    //默认的构造器， 在关联查询时， 还是必须要进行提供的！！！
    public SizeRange(){

    }

    public SizeRange(String minSize, String maxSize, int minCheckTime) {
        this.minSize = minSize;
        this.maxSize = maxSize;
        this.minCheckTime = minCheckTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMinSize() {
        return minSize;
    }

    public void setMinSize(String minSize) {
        this.minSize = minSize;
    }

    public String getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(String maxSize) {
        this.maxSize = maxSize;
    }

    public int getMinCheckTime() {
        return minCheckTime;
    }

    public void setMinCheckTime(int minCheckTime) {
        this.minCheckTime = minCheckTime;
    }

}
