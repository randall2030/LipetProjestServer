package com.envcheck.base.bean;

import java.util.Date;

/**
 * Created by susion on 2016/5/15.
 * 组件的检测信息
 */
public class ModuleCheck {

    private String id;

    //常规检测数据
    private String checkEquipment;
    private Date startTime;
    private Date endTime;
    private String checkPerson;
    private String stopServer;
    private String isSuperCheckMode;

    //仪器数据
    private String equipmentName;
    private int PPMNumber;
    private int backgroundPPMNumber;
    private int leakNumberPerMinute;
    private String dataSource;
    private String note;


    //
    private String leakCheck;
    private String leakRepair;

    //泄露数据
    private String leakSource;
    private String repairTable;
    private String repairNeed;
    private String repairNeedDesc;
    private String pumpIsRunning;

    //视频路径
    private String videoPath;

    private String informNumber;
    private String informSatus;
    private String workNumber;
    private String workStatus;



    //延迟维修
    private String pushInDelayRepair = "否";
    private Date startDelayRepairDate;
    private Date hopeRepairDate;
    private Date successRepairStopDate;
    private String authorizePerson;
    private String delayRepairReason;
    private String successRepair;
    private Date successRepairDate;

    private Module module;


    public String getIsSuperCheckMode() {
        return isSuperCheckMode;
    }

    public void setIsSuperCheckMode(String isSuperCheckMode) {
        this.isSuperCheckMode = isSuperCheckMode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCheckEquipment() {
        return checkEquipment;
    }

    public void setCheckEquipment(String checkEquipment) {
        this.checkEquipment = checkEquipment;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCheckPerson() {
        return checkPerson;
    }

    public void setCheckPerson(String checkPerson) {
        this.checkPerson = checkPerson;
    }

    public String getStopServer() {
        return stopServer;
    }

    public void setStopServer(String stopServer) {
        this.stopServer = stopServer;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public int getPPMNumber() {
        return PPMNumber;
    }

    public void setPPMNumber(int PPMNumber) {
        this.PPMNumber = PPMNumber;
    }

    public int getBackgroundPPMNumber() {
        return backgroundPPMNumber;
    }

    public void setBackgroundPPMNumber(int backgroundPPMNumber) {
        this.backgroundPPMNumber = backgroundPPMNumber;
    }

    public int getLeakNumberPerMinute() {
        return leakNumberPerMinute;
    }

    public void setLeakNumberPerMinute(int leakNumberPerMinute) {
        this.leakNumberPerMinute = leakNumberPerMinute;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getLeakCheck() {
        return leakCheck;
    }

    public void setLeakCheck(String leakCheck) {
        this.leakCheck = leakCheck;
    }

    public String getLeakRepair() {
        return leakRepair;
    }

    public void setLeakRepair(String leakRepair) {
        this.leakRepair = leakRepair;
    }

    public String getLeakSource() {
        return leakSource;
    }

    public void setLeakSource(String leakSource) {
        this.leakSource = leakSource;
    }

    public String getRepairTable() {
        return repairTable;
    }

    public void setRepairTable(String repairTable) {
        this.repairTable = repairTable;
    }

    public String getRepairNeed() {
        return repairNeed;
    }

    public void setRepairNeed(String repairNeed) {
        this.repairNeed = repairNeed;
    }

    public String getRepairNeedDesc() {
        return repairNeedDesc;
    }

    public void setRepairNeedDesc(String repairNeedDesc) {
        this.repairNeedDesc = repairNeedDesc;
    }

    public String getPumpIsRunning() {
        return pumpIsRunning;
    }

    public void setPumpIsRunning(String pumpIsRunning) {
        this.pumpIsRunning = pumpIsRunning;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getInformNumber() {
        return informNumber;
    }

    public void setInformNumber(String informNumber) {
        this.informNumber = informNumber;
    }

    public String getInformSatus() {
        return informSatus;
    }

    public void setInformSatus(String informSatus) {
        this.informSatus = informSatus;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public String getPushInDelayRepair() {
        return pushInDelayRepair;
    }

    public void setPushInDelayRepair(String pushInDelayRepair) {
        this.pushInDelayRepair = pushInDelayRepair;
    }

    public Date getStartDelayRepairDate() {
        return startDelayRepairDate;
    }

    public void setStartDelayRepairDate(Date startDelayRepairDate) {
        this.startDelayRepairDate = startDelayRepairDate;
    }

    public Date getHopeRepairDate() {
        return hopeRepairDate;
    }

    public void setHopeRepairDate(Date hopeRepairDate) {
        this.hopeRepairDate = hopeRepairDate;
    }

    public Date getSuccessRepairStopDate() {
        return successRepairStopDate;
    }

    public void setSuccessRepairStopDate(Date successRepairStopDate) {
        this.successRepairStopDate = successRepairStopDate;
    }

    public String getAuthorizePerson() {
        return authorizePerson;
    }

    public void setAuthorizePerson(String authorizePerson) {
        this.authorizePerson = authorizePerson;
    }

    public String getDelayRepairReason() {
        return delayRepairReason;
    }

    public void setDelayRepairReason(String delayRepairReason) {
        this.delayRepairReason = delayRepairReason;
    }

    public String getSuccessRepair() {
        return successRepair;
    }

    public void setSuccessRepair(String successRepair) {
        this.successRepair = successRepair;
    }

    public Date getSuccessRepairDate() {
        return successRepairDate;
    }

    public void setSuccessRepairDate(Date successRepairDate) {
        this.successRepairDate = successRepairDate;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

}
