package com.envcheck.report.statistics.modulestatistics.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.utils.Constant;
import com.envcheck.base.utils.StringUtils;
import com.envcheck.report.statistics.modulestatistics.bean.PieStatisticNumber;
import com.envcheck.report.statistics.modulestatistics.bean.PieStatisticNumberWrapper;
import com.envcheck.report.statistics.modulestatistics.bean.PillarStatisticNumberWrapper;
import com.envcheck.view.moduleinfo.service.IModuleService;
import com.google.gson.Gson;
import org.apache.struts2.ServletActionContext;

import java.io.PrintWriter;
import java.util.*;

/**
 * Created by susion on 2016/5/11.
 */
public class ModuleStatisticAction extends BaseAction{

    //前台传来的过滤条件
    private IModuleService moduleService;
    private static Gson gson = new Gson();

    /**
     * 列表展示
     */
    public String listUI(){
        return "listUI";
    }


    public void statisticForDiffOrEasy() throws Exception{

        long moduleTotalNumber = moduleService.getModuleTotalNumber();
        long diffCheckModuleNumber = moduleService.getDiffCheckModuleNumber();
        long easyCheckModuleNumber = moduleService.getEasyCheckModuleNumber();

        PieStatisticNumberWrapper wrapper = new PieStatisticNumberWrapper();


        double percentLong = diffCheckModuleNumber / (double)moduleTotalNumber;
        String percentDiff  = StringUtils.formateDoubleToIntString(percentLong);

        double percentLong2 = easyCheckModuleNumber / (double)moduleTotalNumber;
        String percentEasy  = StringUtils.formateDoubleToIntString(percentLong2);

        PieStatisticNumber diffNumber = new PieStatisticNumber(diffCheckModuleNumber, "难于检测点:"+diffCheckModuleNumber+"; 占"+percentDiff);
        PieStatisticNumber easyNumber = new PieStatisticNumber(easyCheckModuleNumber, "常规检测点:"+easyCheckModuleNumber+"; 占"+percentEasy);

        wrapper.getTitles().add("常规检测点:"+diffCheckModuleNumber);
        wrapper.getTitles().add("难于检测点:"+easyCheckModuleNumber);


        wrapper.getStatisticInfo().add(easyNumber);
        wrapper.getStatisticInfo().add(diffNumber);
        String jsonStr = gson.toJson(wrapper);
        PrintWriter writer = ServletActionContext.getResponse().getWriter();
        writer.write(jsonStr);
        writer.close();
    }


    public void statisticForModuleType() throws Exception{

        long moduleTotalNumber = moduleService.getModuleTotalNumber();

        List<Long> moduleNumberByModuleTypeList = moduleService.getModuleNumberByModuleType();
        PieStatisticNumberWrapper wrapper = new PieStatisticNumberWrapper();

        wrapper.setBigTitle("密封点统计(按密封点类型): 共 "+moduleService.getModuleTotalNumber()+"个");
        wrapper.setTitles(Arrays.asList(Constant.MODULE_TYPE));

        PieStatisticNumber pieStatisticNumber;
        long number = 0;
        for(int i=0; i<moduleNumberByModuleTypeList.size(); i++){
            number = moduleNumberByModuleTypeList.get(i);

            double percentLong = number / (double)moduleTotalNumber;
            String percent  = StringUtils.formateDoubleToIntString(percentLong);

            pieStatisticNumber = new PieStatisticNumber(number, wrapper.getTitles().get(i)+":"+number+"个;占"+percent);
            wrapper.getStatisticInfo().add(pieStatisticNumber);
        }

        String jsonStr = gson.toJson(wrapper);
        PrintWriter writer = ServletActionContext.getResponse().getWriter();
        writer.write(jsonStr);
        writer.close();

    }

    public void statisticForDevice() throws Exception{

        Map<String, Long> moduleNumberByDeviceMap = moduleService.getModuleNumberByDevice();
        PillarStatisticNumberWrapper wrapper = new PillarStatisticNumberWrapper();

        wrapper.setBigTitle("密封点分布(按装置): 共 "+moduleService.getModuleTotalNumber()+"个");
        List<String> titles = wrapper.getTitles();
        List<Long> statisticInfos = wrapper.getStatisticInfo();
        List<Integer> heights = wrapper.getyHeight();

        Set<String> deviceNames = moduleNumberByDeviceMap.keySet();
        for(String name : deviceNames){
            titles.add(name);
            statisticInfos.add(moduleNumberByDeviceMap.get(name));
            heights.add(0);
        }

        String jsonStr = gson.toJson(wrapper);
        PrintWriter writer = ServletActionContext.getResponse().getWriter();
        writer.write(jsonStr);
        writer.close();

    }




    public void setModuleService(IModuleService moduleService) {
        this.moduleService = moduleService;
    }
}
