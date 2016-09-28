package com.envcheck.base.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by susion on 2016/5/15.
 */
public class ModuleRepairRecord {

    private String id;

    private int repairNumber;
    private Boolean repairResult = false;
    private Boolean tempStopRepair;  //延迟修复

    //维修记录列表
    private Set<ModuleRepairUnit> repairRecordList = new HashSet<>();


    private Module module;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Boolean getTempStopRepair() {
        return tempStopRepair;
    }

    public void setTempStopRepair(Boolean tempStopRepair) {
        this.tempStopRepair = tempStopRepair;
    }

    public Boolean getRepairResult() {
        return repairResult;
    }

    public void setRepairResult(Boolean repairResult) {
        this.repairResult = repairResult;
    }


    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }


    public int getRepairNumber() {
        return repairNumber;
    }

    public void setRepairNumber(int repairNumber) {
        this.repairNumber = repairNumber;
    }

    public Set<ModuleRepairUnit> getRepairRecordList() {
        return repairRecordList;
    }

    public void setRepairRecordList(Set<ModuleRepairUnit> repairRecordList) {
        this.repairRecordList = repairRecordList;
    }
}
