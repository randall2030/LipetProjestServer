package com.envcheck.tool.importpicture.bean;

import java.io.Serializable;

/**
 * Created by susion on 2016/4/26.
 *
 * "scaleX": 0.6027778,
 "scaleY": 0.17708333
 */
public class Point  implements Serializable{
    private float scaleX;
    private float scaleY;

    public Point(float scaleX, float scaleY) {
        this.scaleX = scaleX;
        this.scaleY = scaleY;
    }

    public float getScaleX() {
        return scaleX;
    }

    public void setScaleX(float scaleX) {
        this.scaleX = scaleX;
    }

    public float getScaleY() {
        return scaleY;
    }

    public void setScaleY(float scaleY) {
        this.scaleY = scaleY;
    }
}
