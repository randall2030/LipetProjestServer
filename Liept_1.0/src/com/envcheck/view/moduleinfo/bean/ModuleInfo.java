package com.envcheck.view.moduleinfo.bean;

/**
 * Created by susion on 2016/7/4.
 */
public class ModuleInfo {


    private String id;
    private String device;

    private String area;

    private String equipment;

    private  String labelNumber;
    private int extendNumber;

    private String modelType;
    private int sizeMM;

    private String barCode;
    private float imgX;
    private float imgY;
    private float heatX;
    private float heatY;
    private String glandNumber;
    private String markPictureSavePath;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getMarkPictureSavePath() {
        return markPictureSavePath;
    }

    public void setMarkPictureSavePath(String markPictureSavePath) {
        this.markPictureSavePath = markPictureSavePath;
    }

    public String getGlandNumber() {
        return glandNumber;
    }

    public void setGlandNumber(String glandNumber) {
        this.glandNumber = glandNumber;
    }

    public float getHeatX() {
        return heatX;
    }

    public void setHeatX(float heatX) {
        this.heatX = heatX;
    }

    public float getHeatY() {
        return heatY;
    }

    public void setHeatY(float heatY) {
        this.heatY = heatY;
    }

    public float getImgY() {
        return imgY;
    }

    public void setImgY(float imgY) {
        this.imgY = imgY;
    }

    public float getImgX() {
        return imgX;
    }

    public void setImgX(float imgX) {
        this.imgX = imgX;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public int getSizeMM() {
        return sizeMM;
    }

    public void setSizeMM(int sizeMM) {
        this.sizeMM = sizeMM;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public int getExtendNumber() {
        return extendNumber;
    }

    public void setExtendNumber(int extendNumber) {
        this.extendNumber = extendNumber;
    }

    public String getLabelNumber() {
        return labelNumber;
    }

    public void setLabelNumber(String labelNumber) {
        this.labelNumber = labelNumber;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
