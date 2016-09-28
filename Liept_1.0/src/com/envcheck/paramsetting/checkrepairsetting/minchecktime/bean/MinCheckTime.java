package com.envcheck.paramsetting.checkrepairsetting.minchecktime.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by susion on 2016/6/5.
 */
public class MinCheckTime {

    private String id;
    private String moduleType;
    private boolean execute;
    private Date createTime;
    private String createPerson;
    private Set<SizeRange> sizeRanges = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModuleType() {
        return moduleType;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
    }

    public boolean isExecute() {
        return execute;
    }

    public void setExecute(boolean execute) {
        this.execute = execute;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public Set<SizeRange> getSizeRanges() {
        return sizeRanges;
    }

    public void setSizeRanges(Set<SizeRange> sizeRanges) {
        this.sizeRanges = sizeRanges;
    }
}
