package com.envcheck.paramsetting.laws.bean;

/**
 * Created by susion on 2016/6/5.
 */
public class ModuleTypeDesc {

    private String id;
    private String moduleType;

    public ModuleTypeDesc(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public ModuleTypeDesc(String moduleType) {
        this.moduleType = moduleType;
    }

    public String getModuleType() {
        return moduleType;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
    }
}
