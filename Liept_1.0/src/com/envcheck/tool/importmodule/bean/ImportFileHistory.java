package com.envcheck.tool.importmodule.bean;

import java.util.Date;

/**
 * Created by susion on 2016/5/16.
 */
public class ImportFileHistory {

    private String id;
    private String importFileName;
    private int newDataNumber;
    private int modifyDataNumber;
    private int discardDataNumber;
    private String createPerson;
    private Date createTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImportFileName() {
        return importFileName;
    }

    public void setImportFileName(String importFileName) {
        this.importFileName = importFileName;
    }

    public int getNewDataNumber() {
        return newDataNumber;
    }

    public void setNewDataNumber(int newDataNumber) {
        this.newDataNumber = newDataNumber;
    }

    public int getModifyDataNumber() {
        return modifyDataNumber;
    }

    public void setModifyDataNumber(int modifyDataNumber) {
        this.modifyDataNumber = modifyDataNumber;
    }

    public int getDiscardDataNumber() {
        return discardDataNumber;
    }

    public void setDiscardDataNumber(int discardDataNumber) {
        this.discardDataNumber = discardDataNumber;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
