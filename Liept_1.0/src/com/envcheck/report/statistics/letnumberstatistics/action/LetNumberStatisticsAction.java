package com.envcheck.report.statistics.letnumberstatistics.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.utils.Constant;
import com.envcheck.base.utils.StringUtils;
import com.envcheck.paramsetting.modelinfosetting.devicemanage.bean.DeviceInfo;
import com.envcheck.paramsetting.modelinfosetting.devicemanage.service.IDeviceInfoService;
import com.envcheck.report.statistics.letnumberstatistics.bean.ModuleInfoFroDischarge;
import com.envcheck.report.statistics.letnumberstatistics.bean.PieStatisticNumberForDischarge;
import com.envcheck.report.statistics.letnumberstatistics.bean.PieStatisticNumberWrapperForDischarge;
import com.envcheck.report.statistics.letnumberstatistics.bean.PillarStatisticNumberWrapperForDischarge;
import com.envcheck.report.statistics.letnumberstatistics.utils.DisChargeUtils;
import com.envcheck.view.moduleinfo.service.IModuleService;
import com.google.gson.Gson;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by susion on 2016/5/11.
 *
 */
public class LetNumberStatisticsAction extends BaseAction{


    private  Date startTime;
    private  Date endTime;

    private String endTimeStr;

    private IDeviceInfoService deviceInfoService;
    private IModuleService moduleService;
    private Gson gson = new Gson();


    public String listUI(){
        return "listUI";
    }


    //组件排放量statisticForDevice
    public void statisticForDevice() throws Exception{

        PillarStatisticNumberWrapperForDischarge wrapper = new PillarStatisticNumberWrapperForDischarge();
        List<String> titles = wrapper.getTitles();
        List<Float> statisticInfos = wrapper.getStatisticInfo();
        List<Integer> heights = wrapper.getyHeight();

        List<DeviceInfo> devices = deviceInfoService.getAll();

        List<ModuleInfoFroDischarge> moduleInfoFroDischarges;
        float dischargeForDevice;

        for(DeviceInfo deviceInfo : devices){
            dischargeForDevice = 0;

            titles.add(deviceInfo.getDeviceName());
            heights.add(0);

            //得到这个装置下的所有  moduleInfoFroDischarge
            moduleInfoFroDischarges = moduleService.getALLModuleInfoForDischargeByDeiveName(deviceInfo.getDeviceName());

            for(ModuleInfoFroDischarge discharge : moduleInfoFroDischarges){
                dischargeForDevice += DisChargeUtils.caculateModuleDischarge(deviceInfo.getDeviceType(), startTime, endTime, discharge);
            }

            statisticInfos.add(dischargeForDevice);
        }

        String jsonStr = gson.toJson(wrapper);
        PrintWriter writer = ServletActionContext.getResponse().getWriter();
        writer.write(jsonStr);
        writer.close();

    }


    //装置排放量
    public void statisticForModuleType() throws Exception{

        PieStatisticNumberWrapperForDischarge wrapper = new PieStatisticNumberWrapperForDischarge();
        wrapper.setTitles(Arrays.asList(Constant.MODULE_TYPE));
        PieStatisticNumberForDischarge pieStatisticNumber;

        List<String> titles = wrapper.getTitles();
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
            wrapper.getStatisticInfo().add(pieStatisticNumber);
        }


        String jsonStr = gson.toJson(wrapper);
        PrintWriter writer = ServletActionContext.getResponse().getWriter();
        writer.write(jsonStr);
        writer.close();

    }

    public void statisticForMediumStatus() throws Exception {   //MediumStatus 拼错了   应该是 主要介质  mainMedium
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

        String jsonStr = gson.toJson(wrapper);
        PrintWriter writer = ServletActionContext.getResponse().getWriter();
        writer.write(jsonStr);
        writer.close();

    }


    public String getEndTimeStr() {
        return endTimeStr;
    }

    public void setEndTimeStr(String endTimeStr) {
        this.endTimeStr = endTimeStr;
        endTime = StringUtils.formateDateForEndTime(endTimeStr);
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

    public void setDeviceInfoService(IDeviceInfoService deviceInfoService) {
        this.deviceInfoService = deviceInfoService;
    }


    public void setModuleService(IModuleService moduleService) {
        this.moduleService = moduleService;
    }
}
