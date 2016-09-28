package com.envcheck.scenemanage.allocatetask.bean;

import com.envcheck.base.bean.MainTainAbout;

import java.util.Date;

/**
 * Created by susion on 2016/5/4.
 */
public class Task extends MainTainAbout{

    //装置、区域、任务名称、已检测、泄露/未修复、DOR、合计、检测类型、计划类型、年度、 期间、
    //开始日期、结束日期、是否结束、创建人、创建时间、更新时间 、更新人

    private String id;
    private String device;
    private String area;
    private String taskName;
    private int hasCheck;
    private int leak;
    private int dor;
    private int total;
    private String checkType;
    private String planType;
    private int year;
    private int intervalTime;
    private Date startTime;
    private Date endTime;
    private boolean stop = false;
    private String localSavePath;
    private String user;
    private boolean userPrivate;


    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public int getIntervalTime() {
        return intervalTime;
    }

    public void setIntervalTime(int intervalTime) {
        this.intervalTime = intervalTime;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getDor() {
        return dor;
    }

    public void setDor(int dor) {
        this.dor = dor;
    }

    public int getLeak() {
        return leak;
    }

    public void setLeak(int leak) {
        this.leak = leak;
    }

    public int getHasCheck() {
        return hasCheck;
    }

    public void setHasCheck(int hasCheck) {
        this.hasCheck = hasCheck;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLocalSavePath() {
        return localSavePath;
    }

    public void setLocalSavePath(String localSavePath) {
        this.localSavePath = localSavePath;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isUserPrivate() {
        return userPrivate;
    }

    public void setUserPrivate(boolean userPrivate) {
        this.userPrivate = userPrivate;
    }
}
