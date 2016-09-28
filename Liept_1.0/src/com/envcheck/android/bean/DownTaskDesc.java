package com.envcheck.android.bean;

/**
 * Created by susion on 2016/6/5.
 */
public class DownTaskDesc {

    private String taskName;
    private String moduleNumber;
    private String downUrl;


    public DownTaskDesc() {

    }


    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getModuleNumber() {
        return moduleNumber;
    }

    public void setModuleNumber(String moduleNumber) {
        this.moduleNumber = moduleNumber;
    }


    public String getDownUrl() {
        return downUrl;
    }

    public void setDownUrl(String downUrl) {
        this.downUrl = downUrl;
    }
}
