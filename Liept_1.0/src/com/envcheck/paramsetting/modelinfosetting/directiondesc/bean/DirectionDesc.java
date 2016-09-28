package com.envcheck.paramsetting.modelinfosetting.directiondesc.bean;

import com.envcheck.base.bean.MainTainAbout;

/**
 * Created by susion on 2016/5/4.
 */
public class DirectionDesc extends MainTainAbout {

    //描述方位编号、描述方位名称、创建时间、创建人、更新时间、更新人
    private String id;
    private String directionDescNumber;
    private String directionDescName;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDirectionDescNumber() {
        return directionDescNumber;
    }

    public void setDirectionDescNumber(String directionDescNumber) {
        this.directionDescNumber = directionDescNumber;
    }

    public String getDirectionDescName() {
        return directionDescName;
    }

    public void setDirectionDescName(String directionDescName) {
        this.directionDescName = directionDescName;
    }
}
