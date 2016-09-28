package com.envcheck.android.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by susion on 2016/4/26.
         cannotTouch : false/true
         displayImage
             path: unhandle_photo.jpg的路径
         flagNo: Flag号对应的值
         isHidePreMark：true （隐藏预标记的点）
         layoutBeans: （标记了点的信息）
             数组中每一个点具有的属性有
             compSize：30
             imgMark （描述标记点的位置）
                 scaleX:
                 scaleY:
            markName: "（对应的序号）"
            textMark （标记点对应的文字信息的位置）
             scaleX:
             scaleY:
         mediumState: "LL" （介质的状态）
         note： “（例如）总个数：4”
         preMark(预标记点的信息)
         tagFile：这个json文件位于的路径(一次照片采集保存的信息的路径)
         tagName： 一次照片采集活动的名称
 */


public class PhotoWork implements Serializable {

    private boolean cannotTouch;
    private Map<String, String>  displayImage;  //key1:path, valu1:unhandle_photo.jpg的路径
    private String flagNo;
    private ArrayList<LayoutBean> layoutBeans;
    private String mediumState;
    private String note;
    private Map<String, String>  tagFile;  //key1:path, valu1:这个json文件位于的路径(一次照片采集保存的信息的路径)
    private String tagName;


    public boolean isCannotTouch() {
        return cannotTouch;
    }

    public void setCannotTouch(boolean cannotTouch) {
        this.cannotTouch = cannotTouch;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Map<String, String> getTagFile() {
        return tagFile;
    }

    public void setTagFile(Map<String, String> tagFile) {
        this.tagFile = tagFile;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getMediumState() {
        return mediumState;
    }

    public void setMediumState(String mediumState) {
        this.mediumState = mediumState;
    }


    public String getFlagNo() {
        return flagNo;
    }

    public void setFlagNo(String flagNo) {
        this.flagNo = flagNo;
    }

    public Map<String, String> getDisplayImage() {
        return displayImage;
    }

    public void setDisplayImage(Map<String, String> displayImage) {
        this.displayImage = displayImage;
    }


    public ArrayList<LayoutBean> getLayoutBeans() {
        return layoutBeans;
    }

    public void setLayoutBeans(ArrayList<LayoutBean> layoutBeans) {
        this.layoutBeans = layoutBeans;
    }

    @Override
    public String toString() {
        return "PhotoWork{" +
                "cannotTouch=" + cannotTouch +
                ", displayImage=" + displayImage +
                ", flagNo='" + flagNo + '\'' +
                ", layoutBeans=" + layoutBeans +
                ", mediumState='" + mediumState + '\'' +
                ", note='" + note + '\'' +
                ", tagFile=" + tagFile +
                ", tagName='" + tagName + '\'' +
                '}';
    }
}
