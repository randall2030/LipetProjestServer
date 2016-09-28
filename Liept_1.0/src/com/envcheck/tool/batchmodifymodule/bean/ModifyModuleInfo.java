package com.envcheck.tool.batchmodifymodule.bean;

/**
 * Created by Administrator on 2016/5/28.
 */
public class ModifyModuleInfo {

    //需要修改的id   需要修改的字段   值
    private String id;
    private String name;
    private Object obj;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
