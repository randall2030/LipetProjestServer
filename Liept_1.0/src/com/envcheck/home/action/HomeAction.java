package com.envcheck.home.action;

import com.envcheck.base.utils.StringUtils;
import com.envcheck.home.bean.TotalInfo;
import com.envcheck.home.bean.TotalInfoForDevice;
import com.envcheck.home.bean.TotalInfoForGrid;
import com.envcheck.paramsetting.modelinfosetting.devicemanage.service.IDeviceInfoService;
import com.envcheck.paramsetting.modelinfosetting.devicemanage.service.impl.DeviceInfoService;
import com.envcheck.view.moduleinfo.service.IModuleService;
import com.opensymphony.xwork2.ActionSupport;

import java.util.*;

/**
 * Created by susion on 2016/5/9.
 */
public class HomeAction extends ActionSupport {

    private TotalInfo totalInfo;
    private IModuleService moduleService;
    private List<TotalInfoForDevice> totalInfoForDevices;
    private IDeviceInfoService deviceInfoService;
    private String currentPeroid;

    private TotalInfoForGrid totalInfoForGrid;

    public String homeUI() {

        getTotalInfoData();
        getTotalInfosData();

        return "homeUI";
    }


    public String welcomeUI() {
        return "welcomeUI";
    }

    private void getTotalInfoData() {

        totalInfo = new TotalInfo();
        totalInfo.setTotalLabelNumber(moduleService.getTotalLabelNumber());
        totalInfo.setTotalModuleNumber(moduleService.getModuleTotalNumber());
        totalInfo.setEasyCheckModuleNumber(moduleService.getEasyCheckModuleNumber());
        totalInfo.setDiffCheckModuleNumber(moduleService.getDiffCheckModuleNumber());

        Map<String, Long> map = moduleService.getModuleRepairNumberByDevice();
        Set<String> strings = map.keySet();
        long totalRepair = 0;
        for (String str : strings) {
            totalRepair += map.get(str);
        }

        totalInfo.setCurrentDelayRepairNumber(moduleService.getDelayRepairNumber());

        totalInfo.setCurrentLeakNumber(moduleService.getTotalLeakNumber() - totalRepair);
    }

    public void getTotalInfosData() {

        List<String> deviceNames = deviceInfoService.getAllDeviceName();
        totalInfoForDevices = new ArrayList<>();

        totalInfoForGrid = new TotalInfoForGrid();
        totalInfoForGrid.setTotalName("总计");


        for (String deviceName : deviceNames) {

            TotalInfoForDevice info = new TotalInfoForDevice();
            info.setDeviceName(deviceName);
            long totalCheckNumber = moduleService.getTotalModuleByDevice(deviceName);
            info.setTotalCheckNumber(totalCheckNumber);
            totalInfoForGrid.setTotalCheckPoint(totalInfoForGrid.getTotalCheckPoint() + totalCheckNumber);

            info.setEasyCheckNumber(moduleService.getEasyCheckModuleNumberForDevice(deviceName));
            totalInfoForGrid.setCommonCheckPoint(totalInfoForGrid.getCommonCheckPoint() + moduleService.getEasyCheckModuleNumberForDevice(deviceName));

            long hasCheckNumber = moduleService.getcheckModuleNumberForDevice(deviceName);
            info.setHasCheckNumber(hasCheckNumber);
            totalInfoForGrid.setHasCheckPoint(totalInfoForGrid.getHasCheckPoint() + hasCheckNumber);
            if (totalCheckNumber != 0) {
                info.setCheckPercent(StringUtils.formateDoubleToIntString(hasCheckNumber / (double) totalCheckNumber));
            } else {
                info.setCheckPercent(StringUtils.formateDoubleToIntString(0.00));
            }


            long leakNumber = moduleService.getTotalLeakModuleByDevice(deviceName);
            info.setLeakNumber(leakNumber);
            totalInfoForGrid.setLeakNumber(totalInfoForGrid.getLeakNumber() + leakNumber);
            if (totalCheckNumber != 0) {
                info.setLeakPercent(StringUtils.formateDoubleToIntString(leakNumber / (double) totalCheckNumber));
            } else {
                info.setLeakPercent(StringUtils.formateDoubleToIntString(0.00));
            }


            long repairNumber = moduleService.getModuleRepairNumberForDeivce(deviceName);
            info.setRepairNumber(repairNumber);
            totalInfoForGrid.setRepairpoint(totalInfoForGrid.getRepairpoint() + repairNumber);
            if (leakNumber != 0) {
                info.setRepairPercent(StringUtils.formateDoubleToIntString(repairNumber / (double) leakNumber));
            } else {
                info.setRepairPercent(StringUtils.formateDoubleToIntString(0.00));
            }


            info.setDelayRepairNumber((long) moduleService.getDelayRepairNumberForDevice(deviceName));
            totalInfoForGrid.setDelayRepairPoint(totalInfoForGrid.getDelayRepairPoint() + (long) moduleService.getDelayRepairNumberForDevice(deviceName));

            long currentLeakNumber = leakNumber - repairNumber;
            info.setCurrentLeakNumber(currentLeakNumber);
            totalInfoForGrid.setCurrentLeakPoint(totalInfoForGrid.getCurrentLeakPoint() + currentLeakNumber);
            if (totalCheckNumber != 0) {
                info.setCurrentLeakPercent(StringUtils.formateDoubleToIntString(currentLeakNumber / (double) totalCheckNumber));
            } else {
                info.setCurrentLeakPercent(StringUtils.formateDoubleToIntString(0.00));
            }

            totalInfoForDevices.add(info);
        }

        if (deviceNames.size() == 0) {
            totalInfoForGrid.setCheckFinishPercent("0.00%");
            totalInfoForGrid.setLeakPercent("0.00%");
            totalInfoForGrid.setRepairPercent("0.00%");
            totalInfoForGrid.setCurrentLeakPercent("0.00%");

        } else {

            totalInfoForGrid.setLeakPercent(StringUtils.formateDoubleToIntString(totalInfoForGrid.getLeakNumber() / (double) totalInfoForGrid.getTotalCheckPoint()));
            totalInfoForGrid.setRepairPercent(StringUtils.formateDoubleToIntString(totalInfoForGrid.getRepairpoint() / (double) totalInfoForGrid.getLeakNumber()));
            totalInfoForGrid.setCheckFinishPercent(StringUtils.formateDoubleToIntString(totalInfoForGrid.getHasCheckPoint() / (double) totalInfoForGrid.getTotalCheckPoint()));
            totalInfoForGrid.setCurrentLeakPercent(StringUtils.formateDoubleToIntString((totalInfoForGrid.getLeakNumber() - totalInfoForGrid.getRepairpoint()) / (double) totalInfoForGrid.getTotalCheckPoint()));

        }
    }


    public String getCurrentPeroid() {
        Calendar cl = Calendar.getInstance();
        cl.setTime(new Date());

        StringBuilder builder = new StringBuilder();
        int year = cl.get(Calendar.YEAR);
        builder.append("" + year);

        int month = cl.get(Calendar.MONTH);
        if (month < 6) {
            builder.append("上半年");
        } else {
            builder.append("下半年");
        }
        builder.append("检测统计图");

        return builder.toString();
    }

    public void setCurrentPeroid(String currentPeroid) {
        this.currentPeroid = currentPeroid;
    }

    public void setModuleService(IModuleService moduleService) {
        this.moduleService = moduleService;
    }


    public TotalInfo getTotalInfo() {
        return totalInfo;
    }

    public void setTotalInfo(TotalInfo totalInfo) {
        this.totalInfo = totalInfo;
    }

    public List<TotalInfoForDevice> getTotalInfoForDevices() {
        return totalInfoForDevices;
    }

    public void setTotalInfoForDevices(List<TotalInfoForDevice> totalInfoForDevices) {
        this.totalInfoForDevices = totalInfoForDevices;
    }

    public void setDeviceInfoService(IDeviceInfoService deviceInfoService) {
        this.deviceInfoService = deviceInfoService;
    }

    public TotalInfoForGrid getTotalInfoForGrid() {
        return totalInfoForGrid;
    }

    public void setTotalInfoForGrid(TotalInfoForGrid totalInfoForGrid) {
        this.totalInfoForGrid = totalInfoForGrid;
    }
}
