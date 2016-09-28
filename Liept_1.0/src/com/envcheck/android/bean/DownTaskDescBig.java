package com.envcheck.android.bean;

import java.util.Date;

/**
 * Created by susion on 2016/6/7.
 */
public class DownTaskDescBig {

    private Date taskCreateTime;
    private String taskLocalSavePath;
    private DownTaskDesc downTaskDesc;


    public Date getTaskCreateTime() {
        return taskCreateTime;
    }

    public void setTaskCreateTime(Date taskCreateTime) {
        this.taskCreateTime = taskCreateTime;
    }

    public String getTaskLocalSavePath() {
        return taskLocalSavePath;
    }

    public void setTaskLocalSavePath(String taskLocalSavePath) {
        this.taskLocalSavePath = taskLocalSavePath;
    }

    public DownTaskDesc getDownTaskDesc() {
        return downTaskDesc;
    }

    public void setDownTaskDesc(DownTaskDesc downTaskDesc) {
        this.downTaskDesc = downTaskDesc;
    }
}
