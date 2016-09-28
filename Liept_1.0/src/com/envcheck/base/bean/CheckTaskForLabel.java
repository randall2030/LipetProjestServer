package com.envcheck.base.bean;



import com.envcheck.android.bean.LayoutBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by susion on 2016/5/16.
 */
public class CheckTaskForLabel {

    private List<CheckTaskForModule> moduleTasks = new ArrayList<>();
    List<LayoutBean> markLayoutBeans = new ArrayList<>();

    public List<CheckTaskForModule> getModuleTasks() {
        return moduleTasks;
    }

    public void setModuleTasks(List<CheckTaskForModule> moduleTasks) {
        this.moduleTasks = moduleTasks;
    }

    public List<LayoutBean> getMarkLayoutBeans() {
        return markLayoutBeans;
    }

    public void setMarkLayoutBeans(List<LayoutBean> markLayoutBeans) {
        this.markLayoutBeans = markLayoutBeans;
    }
}
