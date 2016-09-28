package com.envcheck.report.letcaculate.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.bean.Module;
import com.envcheck.base.bean.ModuleRepairUnit;
import com.envcheck.base.dynamic_change_datasource.UserContextHolder;
import com.envcheck.base.utils.*;
import com.envcheck.paramsetting.modelinfosetting.devicemanage.bean.DeviceInfo;
import com.envcheck.paramsetting.modelinfosetting.devicemanage.service.IDeviceInfoService;
import com.envcheck.report.letcaculate.bean.LetForModule;
import com.envcheck.report.letcaculate.bean.MinusLetNumber;
import com.envcheck.report.letcaculate.bean.TotalInfoForMinusLetNumber;
import com.envcheck.report.statistics.letnumberstatistics.bean.ModuleInfoFroDischarge;
import com.envcheck.report.statistics.letnumberstatistics.bean.PieStatisticNumberForDischarge;
import com.envcheck.report.statistics.letnumberstatistics.bean.PieStatisticNumberWrapperForDischarge;
import com.envcheck.report.statistics.letnumberstatistics.bean.PillarStatisticNumberWrapperForDischarge;
import com.envcheck.report.statistics.letnumberstatistics.utils.DisChargeUtils;
import com.envcheck.report.statistics.letnumberstatistics.utils.DischargeRateUtils;
import com.envcheck.view.moduleinfo.bean.ModuleInfo;
import com.envcheck.view.moduleinfo.service.IModuleService;
import com.envcheck.view.moduleinfo.service.impl.ModuleService;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by susion on 2016/5/11.
 */
public class LetCaculateAction extends BaseAction{

    private IDeviceInfoService deviceInfoService;
    private IModuleService moduleService;
    private Date startTime;
    private  Date endTime;
    private String downloadFileName;
    private Module module;

    private String endTimeStr;

    public String listUI(){
        return "listUI";
    }

    public InputStream getExportLetCaculateInfoFile() throws Exception {


        QueryHelper qh = new QueryHelper(Module.class, "m");
        //条件查询
        if (module!=null) {
            QueryHelper.addBaseConditionForModuleLetCaculate(module, qh);
           qh.setWhereClause(" and size(m.dischargeForPPMRecords) > 0");
        }

        List<Module> moduleList = moduleService.getAll(qh);
        List<LetForModule> letForModules = new ArrayList<>();


        LetForModule letForModule;
        for(Module m : moduleList){
            letForModule = new LetForModule();
            setLetForModule(letForModule, m);
            letForModules.add(letForModule);
        }


        downloadFileName = "组件排放计算"+StringUtils.formatDateForExportFile(new Date()) + ".xls";

        File exportExcelFile = new File(downloadFileName);
        String startTimeStr = StringUtils.formatDate(startTime);
        String endTimeStr = StringUtils.formatDate(endTime);


        FileUtils.exportLetCaculate(letForModules, startTimeStr, endTimeStr, exportExcelFile, UserContextHolder.getCurrentUser().getCompanyNameCN());

        FileInputStream inputStream = new FileInputStream(exportExcelFile);
        return inputStream;
    }

    private void setLetForModule(LetForModule letForModule, Module m) throws Exception {
        letForModule.setTotalLetNumber(caculateLetNumberForModule(m));
        letForModule.setDevice(m.getDevice());
        letForModule.setArea(m.getArea());

        if(m.getDiffToCheck().equals("是")){
            throw  new RuntimeException("难检点暂时不能够导出！");
        }
        letForModule.setDiffToCheck(m.getDiffToCheck());
        letForModule.setEquipment(m.getEquipment());
        letForModule.setLabelNumber(m.getLabelNumber());
        letForModule.setExtendNumber(m.getExtendNumber());
        letForModule.setMediumStatus(m.getMediumStatus());
        letForModule.setTotalRunTime(DisChargeUtils.getRunTime(startTime, endTime, m.getYearRunTime()));
        letForModule.setDeviceType(deviceInfoService.getDeviceTypeByDeviceName(m.getDevice()));
        letForModule.setModuleType(m.getModelType());

        letForModule.setCleanPPM( m.getModuleCheck() != null && m.getModuleCheck().getPPMNumber() > 0 ? m.getModuleCheck().getPPMNumber() : 0);
        letForModule.setDischargeSpeed(DischargeRateUtils.getDischargeRate(letForModule.getDiffToCheck(), letForModule.getModuleType(),
                        letForModule.getMediumStatus(), letForModule.getCleanPPM(), letForModule.getDeviceType()));
    }

    private double caculateLetNumberForModule(Module m) throws Exception {

        String deviceType = deviceInfoService.getDeviceTypeByDeviceName(m.getDevice());
        ModuleInfoFroDischarge moduleInfoForDischarge = new ModuleInfoFroDischarge(m.getModelType(), m.getDischargeForPPMRecords(),
                m.getDevice(), m.getYearRunTime(), m.getDiffToCheck(), m.getMediumStatus());

        return  DisChargeUtils.caculateModuleDischarge(deviceType, startTime, endTime, moduleInfoForDischarge);
    }



    public InputStream getExportLetCaculateInfoFileForDevice() throws Exception {

        PillarStatisticNumberWrapperForDischarge deviceWrapper  = getDeiviceWrapper();
        PieStatisticNumberWrapperForDischarge moduleTypeWrapper = getModuleTypeWrapper();

        downloadFileName = "装置-密封点类型"+StringUtils.formatDateForExportFile(new Date()) + ".xls";
        File exportExcelFile = new File(downloadFileName);

        if (deviceWrapper != null && moduleTypeWrapper != null) {
            try {
                FileUtils.exportLetCaculateForDevice(deviceWrapper, moduleTypeWrapper, exportExcelFile, UserContextHolder.getCurrentUser().getCompanyNameCN());
            } catch (Exception e) {

                throw new RuntimeException("导出文件失败");
            }
        }

        FileInputStream inputStream = new FileInputStream(exportExcelFile);
        return inputStream;

    }

    public InputStream getExportLetCaculateInfoForMediumStatus() throws Exception{

        PieStatisticNumberWrapperForDischarge mediumStatusWrapper = getMediumStatusWrapper();

        downloadFileName =  "导出减排量"+StringUtils.formatDateForExportFile(new Date()) + ".xls";
        File exportExcelFile = new File(downloadFileName);

        if (mediumStatusWrapper != null) {
            try {
                FileUtils.exportLetCaculateForDevice(mediumStatusWrapper, exportExcelFile, UserContextHolder.getCurrentUser().getCompanyNameCN());
            } catch (Exception e) {

                throw new RuntimeException("导出文件失败");
            }
        }

        FileInputStream inputStream = new FileInputStream(exportExcelFile);
        return inputStream;
    }

    public InputStream getExportMinusLetReport() throws Exception{


        downloadFileName = StringUtils.formatDateForExportFile(new Date()) + ".xls";
        File exportExcelFile = new File(downloadFileName);


        List<MinusLetNumber> minusLetNumbers = new ArrayList<>();
        List<Module> repairModules = moduleService.getHasRepairModule();
        TotalInfoForMinusLetNumber totalInfo = new TotalInfoForMinusLetNumber();
        MinusLetNumber minusLetNumber;
        String deviceType;
        double oldLetNumber;
        double newLetNumber;

        if(repairModules != null){

            for(Module module : repairModules){
                minusLetNumber = new MinusLetNumber();

                minusLetNumber.setLabelNumber(module.getLabelNumber());
                minusLetNumber.setExtendNumber(module.getExtendNumber());
                minusLetNumber.setDevice(module.getDevice());
                minusLetNumber.setArea(module.getArea());

                minusLetNumber.setRunTime(DisChargeUtils.getRunTime(startTime, endTime, module.getYearRunTime()));

                deviceType = deviceInfoService.getDeviceTypeByDeviceName(module.getDevice());
                double oldDischargeRate = DischargeRateUtils.getDischargeRate(module.getDiffToCheck(), module.getModelType(),
                        module.getMediumStatus(), module.getModuleCheck().getPPMNumber(), deviceType);
                oldLetNumber = oldDischargeRate * minusLetNumber.getRunTime();
                minusLetNumber.setOldLetNumber(oldLetNumber);
                totalInfo.totalOldLetNumber += oldLetNumber;




                ModuleInfoFroDischarge infoFroDischarge = new ModuleInfoFroDischarge();
                infoFroDischarge.setModuleType(module.getModelType());
                infoFroDischarge.setDeviceName(module.getDevice());
                infoFroDischarge.setDiffToCheck(module.getDiffToCheck());
                infoFroDischarge.setDischargeForPPMRecords(module.getDischargeForPPMRecords());
                infoFroDischarge.setModuleMediumStatus(module.getMediumStatus());
                infoFroDischarge.setYearRunTime(module.getYearRunTime());


                newLetNumber = DisChargeUtils.caculateModuleDischarge(deviceType, startTime, endTime, infoFroDischarge);
                totalInfo.totalNewLetNumber += newLetNumber;


                minusLetNumber.setNewLetNummber(newLetNumber);
                minusLetNumber.setMinusLetNumber(oldLetNumber - newLetNumber);
                minusLetNumbers.add(minusLetNumber);

            }

        }

        try {
            FileUtils.exportMinusLetNumber(minusLetNumbers, exportExcelFile, UserContextHolder.getCurrentUser().getCompanyNameCN(), totalInfo);
        } catch (Exception e) {

            throw new RuntimeException("导出文件失败");
        }


        FileInputStream inputStream = new FileInputStream(exportExcelFile);
        return inputStream;
    }

    public String exportLetCaculate(){
        return  "letCaculateInfo";
    }

    public String exportLetCaculateForDevice(){
        return  "letCaculateInfoForDevice";
    }

    public String exportLetCaculateForMediumStatus(){
        return  "letCaculateInfoForMediumStatus";
    }

    public String exportMinusLetReport(){
        return "minusLetReport";
    }


    public void setDeviceInfoService(IDeviceInfoService deviceInfoService) {
        this.deviceInfoService = deviceInfoService;
    }


    public void setModuleService(IModuleService moduleService) {
        this.moduleService = moduleService;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getEndTimeStr() {
        return endTimeStr;
    }

    public void setEndTimeStr(String endTimeStr) {
        this.endTimeStr = endTimeStr;
        endTime = StringUtils.formateDateForEndTime(endTimeStr);
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDownloadFileName() {
        try {

            downloadFileName = new String(downloadFileName.getBytes(), "ISO8859-1");
        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
        }
        return downloadFileName;

    }

    public void setDownloadFileName(String downloadFileName) {
        this.downloadFileName = downloadFileName;
    }

    public PillarStatisticNumberWrapperForDischarge getDeiviceWrapper() throws Exception {

        PillarStatisticNumberWrapperForDischarge deviceWrapper = new PillarStatisticNumberWrapperForDischarge();
        List<String> deviceTitle = deviceWrapper.getTitles();
        List<Float> statisticInfos = deviceWrapper.getStatisticInfo();
        List<DeviceInfo> devices = deviceInfoService.getAll();
        List<ModuleInfoFroDischarge> moduleInfoFroDischarges;
        float dischargeForDevice;

        for(DeviceInfo deviceInfo : devices){
            dischargeForDevice = 0;
            deviceTitle.add(deviceInfo.getDeviceName());

            //得到这个装置下的所有  moduleInfoFroDischarge
            moduleInfoFroDischarges = moduleService.getALLModuleInfoForDischargeByDeiveName(deviceInfo.getDeviceName());
            for(ModuleInfoFroDischarge discharge : moduleInfoFroDischarges){
                dischargeForDevice += DisChargeUtils.caculateModuleDischarge(deviceInfo.getDeviceType(), startTime, endTime, discharge);
            }

            statisticInfos.add(dischargeForDevice);
        }
        return deviceWrapper;
    }


    public PieStatisticNumberWrapperForDischarge getModuleTypeWrapper() throws Exception {

        PieStatisticNumberWrapperForDischarge moduleTypeWrapper = new PieStatisticNumberWrapperForDischarge();
        moduleTypeWrapper.setTitles(Arrays.asList(Constant.MODULE_TYPE));
        PieStatisticNumberForDischarge pieStatisticNumber;

        List<String> titles = moduleTypeWrapper.getTitles();
        List<ModuleInfoFroDischarge> moduleInfoFroDischarges;
        float dischargeForDevice;


        for(String moduleType : titles){
            dischargeForDevice = 0;
            moduleInfoFroDischarges = moduleService.getALLModuleInfoForDischargeByModuleType(moduleType);

            for(ModuleInfoFroDischarge discharge : moduleInfoFroDischarges){

                String deviceType = deviceInfoService.getDeviceTypeByDeviceName(discharge.getDeviceName());
                dischargeForDevice += DisChargeUtils.caculateModuleDischarge(deviceType, startTime, endTime, discharge);
            }
            pieStatisticNumber = new PieStatisticNumberForDischarge(dischargeForDevice, moduleType);
            moduleTypeWrapper.getStatisticInfo().add(pieStatisticNumber);
        }
        return moduleTypeWrapper;
    }

    public PieStatisticNumberWrapperForDischarge getMediumStatusWrapper() throws Exception {
        PieStatisticNumberWrapperForDischarge wrapper = new PieStatisticNumberWrapperForDischarge();
        List<String> mediumStatuses = moduleService.getAllMediumStatus();
        wrapper.setTitles(mediumStatuses);


        PieStatisticNumberForDischarge pieStatisticNumber;
        List<ModuleInfoFroDischarge> moduleInfoFroDischarges;
        float dischargeForDevice;

        for(String mediumStatus : mediumStatuses){

            dischargeForDevice = 0;

            moduleInfoFroDischarges = moduleService.getALLModuleInfoForDischargeByMediumStatus(mediumStatus);

            for(ModuleInfoFroDischarge discharge : moduleInfoFroDischarges){
                String deviceType = deviceInfoService.getDeviceTypeByDeviceName(discharge.getDeviceName());
                dischargeForDevice += DisChargeUtils.caculateModuleDischarge(deviceType, startTime, endTime, discharge);
            }

            pieStatisticNumber = new PieStatisticNumberForDischarge(dischargeForDevice, mediumStatus);
            wrapper.getStatisticInfo().add(pieStatisticNumber);

        }

        return wrapper;

    }
}
