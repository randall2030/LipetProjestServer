package com.envcheck.tool.importpicture.bean;

import java.io.Serializable;

/**
 * Created by susion on 2016/4/26.
 *
 *
 */
public class LayoutBean  implements Serializable{
    private int compSize;
    private Point imgMark;
    private String markName;
    private Point textMark;

    public LayoutBean(int compSize, Point imgMark, String markName, Point textMark) {
        this.compSize = compSize;
        this.imgMark = imgMark;
        this.markName = markName;
        this.textMark = textMark;
    }

    public int getCompSize() {
        return compSize;
    }

    public void setCompSize(int compSize) {
        this.compSize = compSize;
    }

    public Point getImgMark() {
        return imgMark;
    }

    public void setImgMark(Point imgMark) {
        this.imgMark = imgMark;
    }

    public String getMarkName() {
        return markName;
    }

    public void setMarkName(String markName) {
        this.markName = markName;
    }

    public Point getTextMark() {
        return textMark;
    }

    public void setTextMark(Point textMark) {
        this.textMark = textMark;
    }
}
