package com.envcheck.base.bean;

/**
 * Created by susion on 2016/5/16.
 */
public class CheckTaskForModule {

    private Module module;
    private ModuleCheck moduleCheck;

    //更改与 2016-6-25 添加维修
    private ModuleRepairRecord moduleRepairRecord;


    public CheckTaskForModule(){

    }

    public CheckTaskForModule(Module module, ModuleCheck moduleCheck) {
        this.module = module;
        this.moduleCheck = moduleCheck;
    }

    public CheckTaskForModule(Module module, ModuleCheck moduleCheck, ModuleRepairRecord moduleRepairRecord) {
        this.module = module;
        this.moduleCheck = moduleCheck;
        this.moduleRepairRecord = moduleRepairRecord;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public ModuleCheck getModuleCheck() {
        return moduleCheck;
    }

    public void setModuleCheck(ModuleCheck moduleCheck) {
        this.moduleCheck = moduleCheck;
    }

    public ModuleRepairRecord getModuleRepairRecord() {
        return moduleRepairRecord;
    }

    public void setModuleRepairRecord(ModuleRepairRecord moduleRepairRecord) {
        this.moduleRepairRecord = moduleRepairRecord;
    }
}
