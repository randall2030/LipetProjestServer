package com.envcheck.base.bean;


import com.envcheck.base.bean.discharge_check_history.DischargeForPPMRecord;
import org.jplus.hyberbin.excel.annotation.ExcelColumnGroup;
import org.jplus.hyberbin.excel.annotation.ExcelVoConfig;
import org.jplus.hyberbin.excel.annotation.Lang;
import org.jplus.hyberbin.excel.bean.BaseExcelVo;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by susion on 2016/5/4.
 * 组件！！！
 */
@ExcelVoConfig
public class Module extends BaseExcelVo {

    //装置 区域	设备	标签号	扩展号	PID图号	主要参考物	方向	距离	单位	次要参考物	方向	距离	单位	楼层	高度	高度单位
    // 附加描述	组件类型	组件子类型	尺寸(mm)	介质状态	产品流	生产厂家	路径号	年运行时间(h)	 组件安装日期
    //位置描述  法规
    private String id;

    //是否泄露
    private boolean leak = false;
    //是否检测
    private boolean hasCheck = false;

    //所属任务
    private String taskId = "-1";
    private boolean hasAllocate = false;

    @Lang(value = "装置")//Excel导出的配置
    private String device;
    @Lang(value = "区域")//Excel导出的配置
    private String area;
    @Lang(value = "设备")//Excel导出的配置
    private String equipment;
    @Lang(value = "标签号")//Excel导出的配置
    private  String labelNumber;
    @Lang(value = "扩展号")
    private int extendNumber;
    @Lang(value = "PID图号")
    private int pid;
    @Lang(value = "主要参考物")
    private String mainReference;
    @Lang(value = "方向")
    private String mainDirection;
    @Lang(value = "距离")
    private float mainDistance;
    @Lang(value = "单位")
    private String mainUnit;
    @Lang(value = "次要参考物")
    private String minorReference;
    @Lang(value = "方向")
    private String minorDirection;
    @Lang(value = "距离")
    private float minorDistance;
    @Lang(value = "单位")
    private String minorUnit;
    @Lang(value = "楼层")
    private float floor;
    @Lang(value = "高度")
    private float height;
    @Lang(value = "高度单位")
    private String heightUnit;
    @Lang(value = "附加描述")
    private String appendDesc;
    @Lang(value = "组件类型")
    private String modelType;
    @Lang(value = "组件子类型")
    private String modelSubType;
    @Lang(value = "尺寸(mm)")
    private int sizeMM = 0;
    @Lang(value = "介质状态")
    private String mediumStatus;
    @Lang(value = "产品流")
    private String productStream;
    @Lang(value = "生产厂家")
    private String productCompany;
    @Lang(value = "路径号")
    private String roadNumber;
    @Lang(value = "年运行时间(h)")
    private int yearRunTime;
    @Lang(value = "组件安装日期")
    private Date modelBuildTime;
    @Lang(value = "位置描述")
    private String positionDesc;
    @Lang(value = "法规")
    private String laws;

    // 难以触及	难于检测	难于检测原因	险于检测	险于检测原因	控制设备和密闭通风系统	控制设备和密闭通风系统类型
    // 设备负压作业	低泄漏组件	位于装卸料站储罐区	年排放时间少于300h
    // 组件是否保温	设备编码	主要介质	操作温度/°C	操作压力/MPa	密封材质	条形码	图片X坐标	图片Y坐标
    // 热点X坐标	热点Y坐标
    @Lang(value = "难以触及")
    private String diffToTouch = "否";
    @Lang(value = "难于检测")
    private String diffToCheck = "否";
    @Lang(value = "难于检测原因")
    private String diffToCheckReason;
    @Lang(value = "险于检测")
    private String dangerToCheck = "否";
    @Lang(value = "险于检测原因")
    private String dangerToCheckReason;
    @Lang(value = "控制设备和密闭通风系统")
    private String controlEquiAndWind;
    @Lang(value = "控制设备和密闭通风系统类型")
    private String controlEquiAndWindType;
    @Lang(value = "设备负压作业")
    private String pressWork;
    @Lang(value = "低泄漏组件")
    private String leakModule;
    @Lang(value = "位于装卸料站储罐区")
    private String locationZXZGArea;
    @Lang(value = "年排放时间少于300h")
    private String yearTime300;
    @Lang(value = "组件是否保温")
    private String warm;
    @Lang(value = "设备编码")
    private String equipmentCode;
    @Lang(value = "主要介质")
    private String mainMedium;
    @Lang(value = "操作温度/°C")
    private String operatorTemperature;
    @Lang(value = "操作压力/MPa")
    private String operatorPress;
    @Lang(value = "密封材质")
    private String sealMedium;
    @Lang(value = "条形码")
    private String barCode;
    @Lang(value = "图片X坐标")
    private float imgX;
    @Lang(value = "图片Y坐标")
    private float imgY;
    @Lang(value = "热点X坐标")
    private float heatX;
    @Lang(value = "热点Y坐标")
    private float heatY;

    //检测频率  是否暂时移除  是否永久移除  永久移除原因  永久移除服务时间 图片 变更管理ID   GPS的x y z
    @Lang(value = "是否暂时移除")
    private String tempToMove="否";
    @Lang(value = "是否永久移除")
    private String foreverToMove="否";
    @Lang(value = "永久移除原因")
    private String foreverToMoveReason;
    @Lang(value = "永久移除服务时间")
    private Date foreverToMoveTime;
    @Lang(value = "图片")
    private String picturePath;
    @Lang(value = "变更管理ID")
    private String changeManageID;
    @Lang(value = "GPS X坐标")
    private Float gpsX;
    @Lang(value = "GPS Y坐标")
    private Float gpsY;
    @Lang(value = "GPS Z坐标")
    private Float gpsZ;

    //密封点编码
    @Lang(value = "密封点编码")
    private String glandNumber;

    //关联 组件检测 和组件维修记录
    private ModuleCheck moduleCheck;
    private ModuleRepairRecord moduleRepairRecord;


    //计算排放量保留的数值
    private Set<DischargeForPPMRecord> dischargeForPPMRecords = new HashSet<>();

    @ExcelColumnGroup(type = String.class)
    private List<String> baseArray;
    @ExcelColumnGroup(type = InnerVo.class)
    private List<InnerVo> innerVoArray;


    public Set<DischargeForPPMRecord> getDischargeForPPMRecords() {
        return dischargeForPPMRecords;
    }

    public void setDischargeForPPMRecords(Set<DischargeForPPMRecord> dischargeForPPMRecords) {
        this.dischargeForPPMRecords = dischargeForPPMRecords;
    }



    public boolean isHasCheck() {
        return hasCheck;
    }

    public void setHasCheck(boolean hasCheck) {
        this.hasCheck = hasCheck;
    }

    public boolean isHasAllocate() {
        return hasAllocate;
    }

    public void setHasAllocate(boolean hasAllocate) {
        this.hasAllocate = hasAllocate;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public boolean isLeak() {
        return leak;
    }

    public void setLeak(boolean leak) {
        this.leak = leak;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getLabelNumber() {
        return labelNumber;
    }

    public void setLabelNumber(String labelNumber) {
        this.labelNumber = labelNumber;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getExtendNumber() {
        return extendNumber;
    }

    public void setExtendNumber(int extendNumber) {
        this.extendNumber = extendNumber;
    }

    public String getMainReference() {
        return mainReference;
    }

    public void setMainReference(String mainReference) {
        this.mainReference = mainReference;
    }

    public String getMainDirection() {
        return mainDirection;
    }

    public void setMainDirection(String mainDirection) {
        this.mainDirection = mainDirection;
    }

    public String getMainUnit() {
        return mainUnit;
    }

    public void setMainUnit(String mainUnit) {
        this.mainUnit = mainUnit;
    }

    public String getHeightUnit() {
        return heightUnit;
    }

    public void setHeightUnit(String heightUnit) {
        this.heightUnit = heightUnit;
    }

    public String getMinorUnit() {
        return minorUnit;
    }

    public void setMinorUnit(String minorUnit) {
        this.minorUnit = minorUnit;
    }

    public float getMinorDistance() {
        return minorDistance;
    }

    public void setMinorDistance(float minorDistance) {
        this.minorDistance = minorDistance;
    }

    public String getMinorDirection() {
        return minorDirection;
    }

    public void setMinorDirection(String minorDirection) {
        this.minorDirection = minorDirection;
    }

    public String getMinorReference() {
        return minorReference;
    }

    public void setMinorReference(String minorReference) {
        this.minorReference = minorReference;
    }

    public float getMainDistance() {
        return mainDistance;
    }

    public void setMainDistance(float mainDistance) {
        this.mainDistance = mainDistance;
    }

    public float getFloor() {
        return floor;
    }

    public void setFloor(float floor) {
        this.floor = floor;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getAppendDesc() {
        return appendDesc;
    }

    public void setAppendDesc(String appendDesc) {
        this.appendDesc = appendDesc;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public String getModelSubType() {
        return modelSubType;
    }

    public void setModelSubType(String modelSubType) {
        this.modelSubType = modelSubType;
    }

    public int getSizeMM() {
        return sizeMM;
    }

    public void setSizeMM(int sizeMM) {
        this.sizeMM = sizeMM;
    }

    public String getMediumStatus() {
        return mediumStatus;
    }

    public void setMediumStatus(String mediumStatus) {
        this.mediumStatus = mediumStatus;
    }

    public String getProductStream() {
        return productStream;
    }

    public void setProductStream(String productStream) {
        this.productStream = productStream;
    }

    public String getProductCompany() {
        return productCompany;
    }

    public void setProductCompany(String productCompany) {
        this.productCompany = productCompany;
    }

    public String getRoadNumber() {
        return roadNumber;
    }

    public void setRoadNumber(String roadNumber) {
        this.roadNumber = roadNumber;
    }

    public int getYearRunTime() {
        return yearRunTime;
    }

    public void setYearRunTime(int yearRunTime) {
        this.yearRunTime = yearRunTime;
    }

    public Date getModelBuildTime() {
        return modelBuildTime;
    }

    public void setModelBuildTime(Date modelBuildTime) {
        this.modelBuildTime = modelBuildTime;
    }

    public String getDiffToTouch() {
        return diffToTouch;
    }

    public void setDiffToTouch(String diffToTouch) {
        this.diffToTouch = diffToTouch;
    }

    public String getDiffToCheck() {
        return diffToCheck;
    }

    public void setDiffToCheck(String diffToCheck) {
        this.diffToCheck = diffToCheck;
    }

    public String getDiffToCheckReason() {
        return diffToCheckReason;
    }

    public void setDiffToCheckReason(String diffToCheckReason) {
        this.diffToCheckReason = diffToCheckReason;
    }

    public String getDangerToCheck() {
        return dangerToCheck;
    }

    public void setDangerToCheck(String dangerToCheck) {
        this.dangerToCheck = dangerToCheck;
    }

    public String getDangerToCheckReason() {
        return dangerToCheckReason;
    }

    public void setDangerToCheckReason(String dangerToCheckReason) {
        this.dangerToCheckReason = dangerToCheckReason;
    }

    public String getControlEquiAndWind() {
        return controlEquiAndWind;
    }

    public void setControlEquiAndWind(String controlEquiAndWind) {
        this.controlEquiAndWind = controlEquiAndWind;
    }

    public String getControlEquiAndWindType() {
        return controlEquiAndWindType;
    }

    public void setControlEquiAndWindType(String controlEquiAndWindType) {
        this.controlEquiAndWindType = controlEquiAndWindType;
    }

    public String getPressWork() {
        return pressWork;
    }

    public void setPressWork(String pressWork) {
        this.pressWork = pressWork;
    }

    public String getLeakModule() {
        return leakModule;
    }

    public void setLeakModule(String leakModule) {
        this.leakModule = leakModule;
    }

    public String getLocationZXZGArea() {
        return locationZXZGArea;
    }

    public void setLocationZXZGArea(String locationZXZGArea) {
        this.locationZXZGArea = locationZXZGArea;
    }

    public String getYearTime300() {
        return yearTime300;
    }

    public void setYearTime300(String yearTime300) {
        this.yearTime300 = yearTime300;
    }

    public String getWarm() {
        return warm;
    }

    public void setWarm(String warm) {
        this.warm = warm;
    }

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode;
    }

    public String getMainMedium() {
        return mainMedium;
    }

    public void setMainMedium(String mainMedium) {
        this.mainMedium = mainMedium;
    }

    public String getOperatorTemperature() {
        return operatorTemperature;
    }

    public void setOperatorTemperature(String operatorTemperature) {
        this.operatorTemperature = operatorTemperature;
    }

    public String getOperatorPress() {
        return operatorPress;
    }

    public void setOperatorPress(String operatorPress) {
        this.operatorPress = operatorPress;
    }

    public String getSealMedium() {
        return sealMedium;
    }

    public void setSealMedium(String sealMedium) {
        this.sealMedium = sealMedium;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public float getImgX() {
        return imgX;
    }

    public void setImgX(float imgX) {
        this.imgX = imgX;
    }

    public float getImgY() {
        return imgY;
    }

    public void setImgY(float imgY) {
        this.imgY = imgY;
    }

    public float getHeatX() {
        return heatX;
    }

    public void setHeatX(float heatX) {
        this.heatX = heatX;
    }

    public float getHeatY() {
        return heatY;
    }

    public void setHeatY(float heatY) {
        this.heatY = heatY;
    }



    public ModuleCheck getModuleCheck() {
        return moduleCheck;
    }

    public void setModuleCheck(ModuleCheck moduleCheck) {
        this.moduleCheck = moduleCheck;
    }

    public ModuleRepairRecord getModuleRepairRecord() {
        return moduleRepairRecord;
    }

    public void setModuleRepairRecord(ModuleRepairRecord moduleRepairRecord) {
        this.moduleRepairRecord = moduleRepairRecord;
    }

    public List<String> getBaseArray() {
        return baseArray;
    }

    public void setBaseArray(List<String> baseArray) {
        this.baseArray = baseArray;
    }

    public List<InnerVo> getInnerVoArray() {
        return innerVoArray;
    }

    public void setInnerVoArray(List<InnerVo> innerVoArray) {
        this.innerVoArray = innerVoArray;
    }



    public String getTempToMove() {
        return tempToMove;
    }

    public void setTempToMove(String tempToMove) {
        this.tempToMove = tempToMove;
    }

    public String getForeverToMove() {
        return foreverToMove;
    }

    public void setForeverToMove(String foreverToMove) {
        this.foreverToMove = foreverToMove;
    }

    public String getForeverToMoveReason() {
        return foreverToMoveReason;
    }

    public void setForeverToMoveReason(String foreverToMoveReason) {
        this.foreverToMoveReason = foreverToMoveReason;
    }

    public Date getForeverToMoveTime() {
        return foreverToMoveTime;
    }

    public void setForeverToMoveTime(Date foreverToMoveTime) {
        this.foreverToMoveTime = foreverToMoveTime;
    }

    public String getChangeManageID() {
        return changeManageID;
    }

    public void setChangeManageID(String changeManageID) {
        this.changeManageID = changeManageID;
    }

    public Float getGpsX() {
        return gpsX;
    }

    public void setGpsX(Float gpsX) {
        this.gpsX = gpsX;
    }

    public Float getGpsY() {
        return gpsY;
    }

    public void setGpsY(Float gpsY) {
        this.gpsY = gpsY;
    }

    public Float getGpsZ() {
        return gpsZ;
    }

    public void setGpsZ(Float gpsZ) {
        this.gpsZ = gpsZ;
    }

    public String getLaws() {
        return laws;
    }
    public void setLaws(String laws) {
        this.laws = laws;
    }

    public String getPositionDesc() {
        return positionDesc;
    }

    public void setPositionDesc(String positionDesc) {
        this.positionDesc = positionDesc;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    @Override
    public int getHashVal() {
        return 0;
    }

    public String getGlandNumber() {
        return glandNumber;
    }

    public void setGlandNumber(String glandNumber) {
        this.glandNumber = glandNumber;
    }
}
