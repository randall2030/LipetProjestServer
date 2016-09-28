package com.envcheck.android.bean;

import java.io.Serializable;

/**
 * Created by susion on 2016/4/26.
 *
 *
 */
public class LayoutBean  implements Serializable{
    private Point imgMark;
    private Point textMark;

    public LayoutBean( Point imgMark,Point textMark) {
        this.imgMark = imgMark;
        this.textMark = textMark;
    }

    public Point getImgMark() {
        return imgMark;
    }

    public void setImgMark(Point imgMark) {
        this.imgMark = imgMark;
    }


    public Point getTextMark() {
        return textMark;
    }

    public void setTextMark(Point textMark) {
        this.textMark = textMark;
    }
}
