package com.envcheck.paramsetting.checkrepairsetting.checkapparatus.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by susion on 2016/6/13.
 */
public class CheckApparatusListFromServer {
    private List<CheckApparatus> checkApparatusList = new ArrayList<>();

    public List<CheckApparatus> getCheckApparatusList() {
        return checkApparatusList;
    }

    public void setCheckApparatusList(List<CheckApparatus> checkApparatusList) {
        this.checkApparatusList = checkApparatusList;
    }
}
