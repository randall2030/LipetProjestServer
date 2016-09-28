package com.envcheck.base.bean;

/**
 * Created by susion on 2016/6/21.
 */
public class PPMRangeBean {
    public int bottomVaule;
    public int topValue;
    public boolean isToptop = false;

    public PPMRangeBean(int bottomVaule, int topValue) {
        this.bottomVaule = bottomVaule;
        this.topValue = topValue;
    }
}
