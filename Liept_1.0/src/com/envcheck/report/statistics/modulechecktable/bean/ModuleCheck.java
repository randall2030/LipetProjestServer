package com.envcheck.report.statistics.modulechecktable.bean;

/**
 * Created by Gao on 2016/6/3.
 */
public class ModuleCheck {


    public String value;
    public String name;

    public ModuleCheck(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
