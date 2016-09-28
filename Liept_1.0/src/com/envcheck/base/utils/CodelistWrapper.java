package com.envcheck.base.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by susion on 2016/6/26.
 */
public class CodelistWrapper {

    private List<String> codeList = new ArrayList<>();
    public CodelistWrapper(List list) {
        this.codeList = list;
    }

    public List<String> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<String> codeList) {
        this.codeList = codeList;
    }
}
