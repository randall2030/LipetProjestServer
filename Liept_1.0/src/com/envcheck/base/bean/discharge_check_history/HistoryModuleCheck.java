package com.envcheck.base.bean.discharge_check_history;

import com.envcheck.base.bean.ModuleCheck;

import java.util.Date;

/**
 * Created by susion on 2016/6/22.
 */
public class HistoryModuleCheck {

    private String id;

    private String moduleId;   //对应的组件ID
    private Date endPeriodTime;


    //组件检测信息
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


    private String pushInDelayRepair;

    private Date startDelayRepairDate;
    private Date hopeRepairDate;
    private Date successRepairStopDate;
    private String authorizePerson;
    private String delayRepairReason;
    private String successRepair;
    private Date successRepairDate;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public Date getEndPeriodTime() {
        return endPeriodTime;
    }

    public void setEndPeriodTime(Date endPeriodTime) {
        this.endPeriodTime = endPeriodTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getCheckEquipment() {
        return checkEquipment;
    }

    public void setCheckEquipment(String checkEquipment) {
        this.checkEquipment = checkEquipment;
    }

    public Date getSuccessRepairDate() {
        return successRepairDate;
    }

    public void setSuccessRepairDate(Date successRepairDate) {
        this.successRepairDate = successRepairDate;
    }

    public String getSuccessRepair() {
        return successRepair;
    }

    public void setSuccessRepair(String successRepair) {
        this.successRepair = successRepair;
    }

    public String getDelayRepairReason() {
        return delayRepairReason;
    }

    public void setDelayRepairReason(String delayRepairReason) {
        this.delayRepairReason = delayRepairReason;
    }

    public String getAuthorizePerson() {
        return authorizePerson;
    }

    public void setAuthorizePerson(String authorizePerson) {
        this.authorizePerson = authorizePerson;
    }

    public Date getSuccessRepairStopDate() {
        return successRepairStopDate;
    }

    public void setSuccessRepairStopDate(Date successRepairStopDate) {
        this.successRepairStopDate = successRepairStopDate;
    }

    public Date getHopeRepairDate() {
        return hopeRepairDate;
    }

    public void setHopeRepairDate(Date hopeRepairDate) {
        this.hopeRepairDate = hopeRepairDate;
    }

    public Date getStartDelayRepairDate() {
        return startDelayRepairDate;
    }

    public void setStartDelayRepairDate(Date startDelayRepairDate) {
        this.startDelayRepairDate = startDelayRepairDate;
    }

    public String getPushInDelayRepair() {
        return pushInDelayRepair;
    }

    public void setPushInDelayRepair(String pushInDelayRepair) {
        this.pushInDelayRepair = pushInDelayRepair;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }

    public String getInformSatus() {
        return informSatus;
    }

    public void setInformSatus(String informSatus) {
        this.informSatus = informSatus;
    }

    public String getInformNumber() {
        return informNumber;
    }

    public void setInformNumber(String informNumber) {
        this.informNumber = informNumber;
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

    public String getRepairNeedDesc() {
        return repairNeedDesc;
    }

    public void setRepairNeedDesc(String repairNeedDesc) {
        this.repairNeedDesc = repairNeedDesc;
    }

    public String getRepairNeed() {
        return repairNeed;
    }

    public void setRepairNeed(String repairNeed) {
        this.repairNeed = repairNeed;
    }

    public String getRepairTable() {
        return repairTable;
    }

    public void setRepairTable(String repairTable) {
        this.repairTable = repairTable;
    }

    public String getLeakSource() {
        return leakSource;
    }

    public void setLeakSource(String leakSource) {
        this.leakSource = leakSource;
    }

    public String getLeakRepair() {
        return leakRepair;
    }

    public void setLeakRepair(String leakRepair) {
        this.leakRepair = leakRepair;
    }

    public String getLeakCheck() {
        return leakCheck;
    }

    public void setLeakCheck(String leakCheck) {
        this.leakCheck = leakCheck;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public int getLeakNumberPerMinute() {
        return leakNumberPerMinute;
    }

    public void setLeakNumberPerMinute(int leakNumberPerMinute) {
        this.leakNumberPerMinute = leakNumberPerMinute;
    }

    public int getBackgroundPPMNumber() {
        return backgroundPPMNumber;
    }

    public void setBackgroundPPMNumber(int backgroundPPMNumber) {
        this.backgroundPPMNumber = backgroundPPMNumber;
    }

    public int getPPMNumber() {
        return PPMNumber;
    }

    public void setPPMNumber(int PPMNumber) {
        this.PPMNumber = PPMNumber;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getIsSuperCheckMode() {
        return isSuperCheckMode;
    }

    public void setIsSuperCheckMode(String isSuperCheckMode) {
        this.isSuperCheckMode = isSuperCheckMode;
    }

    public String getStopServer() {
        return stopServer;
    }

    public void setStopServer(String stopServer) {
        this.stopServer = stopServer;
    }

    public String getCheckPerson() {
        return checkPerson;
    }

    public void setCheckPerson(String checkPerson) {
        this.checkPerson = checkPerson;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
