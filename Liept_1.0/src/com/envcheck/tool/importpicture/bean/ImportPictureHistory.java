package com.envcheck.tool.importpicture.bean;

import java.util.Date;

/**
 * Created by susion on 2016/5/16.
 */
public class ImportPictureHistory {

    private String id;
    private String importPictureLabelNumber;
    private int containModuleNumber;
    private Date importTime;
    private String originalPictureSavePath;
    private String markPictureSavePath;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImportPictureLabelNumber() {
        return importPictureLabelNumber;
    }

    public void setImportPictureLabelNumber(String importPictureLabelNumber) {
        this.importPictureLabelNumber = importPictureLabelNumber;
    }

    public int getContainModuleNumber() {
        return containModuleNumber;
    }

    public void setContainModuleNumber(int containModuleNumber) {
        this.containModuleNumber = containModuleNumber;
    }

    public Date getImportTime() {
        return importTime;
    }

    public void setImportTime(Date importTime) {
        this.importTime = importTime;
    }

    public String getOriginalPictureSavePath() {
        return originalPictureSavePath;
    }

    public void setOriginalPictureSavePath(String originalPictureSavePath) {
        this.originalPictureSavePath = originalPictureSavePath;
    }

    public String getMarkPictureSavePath() {
        return markPictureSavePath;
    }

    public void setMarkPictureSavePath(String markPictureSavePath) {
        this.markPictureSavePath = markPictureSavePath;
    }
}
