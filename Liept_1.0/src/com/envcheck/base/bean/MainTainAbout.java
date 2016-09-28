package com.envcheck.base.bean;


import java.util.Date;

/**
 * Created by susion on 2016/5/3.
 */
public class MainTainAbout {


    //创建时间、创建人、修改时间、修改人
    private Date createTime;
    private String createPerson;
    private Date modifyTime;
    private String modifyPerson;


    public Date getCreateTime() {

        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyPerson() {
        return modifyPerson;
    }

    public void setModifyPerson(String modifyPerson) {
        this.modifyPerson = modifyPerson;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }
}
