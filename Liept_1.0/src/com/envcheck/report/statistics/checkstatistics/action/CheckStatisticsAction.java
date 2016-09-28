package com.envcheck.report.statistics.checkstatistics.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.paramsetting.modelinfosetting.devicemanage.bean.DeviceInfo;
import com.envcheck.paramsetting.modelinfosetting.devicemanage.service.IDeviceInfoService;
import com.envcheck.report.statistics.checkstatistics.bean.StatisticWrapperForPPMAllocate;
import com.envcheck.report.statistics.modulestatistics.bean.PillarStatisticNumberWrapper;
import com.envcheck.view.checkinfo.service.IModuleCheckService;
import com.envcheck.view.moduleinfo.service.IModuleService;
import com.google.gson.Gson;
import org.apache.struts2.ServletActionContext;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Created by susion on 2016/5/11.
 */
public class CheckStatisticsAction extends BaseAction{


    public String listUI(){
        return "listUI";
    }
    private IModuleCheckService moduleCheckService;
    private IModuleService moduleService;
    private IDeviceInfoService deviceInfoService;
    private static Gson gson = new Gson();


    //按装置分类
    public void statisticForPPMAllocate() throws Exception{

        StatisticWrapperForPPMAllocate wrapper = new StatisticWrapperForPPMAllocate();
        List<DeviceInfo> deviceInfos = deviceInfoService.getAll();
        String number;
        for(DeviceInfo info : deviceInfos){
            wrapper.getDevceNames().add(info.getDeviceName());

            List<Long> ppmAllocateByDeviceName = moduleService.getPPMAllocateByDeviceName(info.getDeviceName());

            for(int i=0; i<ppmAllocateByDeviceName.size(); i++){

                if(ppmAllocateByDeviceName.get(i) == 0){
                    number = "";
                }else{
                    number = ppmAllocateByDeviceName.get(i)+"";
                }

                switch (i){
                    case 0:
                        wrapper.getPpm500To1000().add(number);
                        break;
                    case 1:
                        wrapper.getPpm1000To2000().add(number);
                        break;
                    case 2:
                        wrapper.getPpm2000To5000().add(number);
                        break;
                    case 3:
                        wrapper.getPpm5000To10000().add(number);
                        break;
                    case 4:
                        wrapper.getPpm10000To50000().add(number);
                        break;
                    case 5:
                        wrapper.getPpm5000Up().add(number);
                        break;
                }
            }
        }

        String jsonStr = gson.toJson(wrapper);
        PrintWriter writer = ServletActionContext.getResponse().getWriter();
        writer.write(jsonStr);
        writer.close();

    }

    public void statisticCheckPointByDevice() throws Exception{

        Map<String, Long> checkModuleNumberByDeviceMap = moduleService.getCheckModuleNumberByDevice();
        PillarStatisticNumberWrapper wrapper = new PillarStatisticNumberWrapper();
        List<String> titles = wrapper.getTitles();
        List<Long> statisticInfos = wrapper.getStatisticInfo();
        List<Integer> heights = wrapper.getyHeight();

        Set<String> deviceNames = checkModuleNumberByDeviceMap.keySet();
        for(String name : deviceNames){
            titles.add(name);
            statisticInfos.add(checkModuleNumberByDeviceMap.get(name));
            heights.add(0);
        }

        String jsonStr = gson.toJson(wrapper);
        PrintWriter writer = ServletActionContext.getResponse().getWriter();
        writer.write(jsonStr);
        writer.close();

    }


    public void setModuleCheckService(IModuleCheckService moduleCheckService) {
        this.moduleCheckService = moduleCheckService;
    }


    public void setDeviceInfoService(IDeviceInfoService deviceInfoService) {
        this.deviceInfoService = deviceInfoService;
    }


    public void setModuleService(IModuleService moduleService) {
        this.moduleService = moduleService;
    }
}
