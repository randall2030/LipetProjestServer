package com.envcheck.report.statistics.leakstatistics.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.utils.Constant;
import com.envcheck.base.utils.StringUtils;
import com.envcheck.report.statistics.leakstatistics.bean.PillarPercentStatisticNumberWrapper;
import com.envcheck.report.statistics.modulestatistics.bean.PieStatisticNumber;
import com.envcheck.report.statistics.modulestatistics.bean.PieStatisticNumberWrapper;
import com.envcheck.report.statistics.modulestatistics.bean.PillarStatisticNumberWrapper;
import com.envcheck.view.moduleinfo.service.IModuleService;
import com.google.gson.Gson;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by susion on 2016/5/11.
 */
public class LeakStatisticsAction extends BaseAction{


    private IModuleService moduleService;
    private static Gson gson = new Gson();


    public String listUI(){
        return "listUI";
    }


    public void statisticLeakAndLeakPercent() throws Exception{

        Map<String, Long> moduleLeakNumberByDeviceMap = moduleService.getModuleLeakNumberByDevice();
        PillarPercentStatisticNumberWrapper wrapper = getPillarPercentStatisticNumberWrapper(moduleLeakNumberByDeviceMap, false);
        returnJsonDataForChart(wrapper);

    }

    public void statisticRepairAndRepairPercent() throws Exception{

        Map<String, Long> moduleRepairNumberByDeviceMap = moduleService.getModuleRepairNumberByDevice();
        PillarPercentStatisticNumberWrapper wrapper = getPillarPercentStatisticNumberWrapper(moduleRepairNumberByDeviceMap, true);

        returnJsonDataForChart(wrapper);

    }

    private void returnJsonDataForChart(PillarPercentStatisticNumberWrapper wrapper) throws IOException {
        String jsonStr = gson.toJson(wrapper);
        PrintWriter writer = ServletActionContext.getResponse().getWriter();
        writer.write(jsonStr);
        writer.close();
    }

    private PillarPercentStatisticNumberWrapper getPillarPercentStatisticNumberWrapper(Map<String, Long> moduleRepairNumberByDeviceMap, boolean isRepair)throws Exception{

        PillarPercentStatisticNumberWrapper wrapper = new PillarPercentStatisticNumberWrapper();
        List<String> titles = wrapper.getTitles();
        List<Long> pointNumbers = wrapper.getPointNumbers();
        List<Double> percentValues = wrapper.getPercentValues();

        DecimalFormat df = new DecimalFormat("######0.00");

        Set<String> deviceNames = moduleRepairNumberByDeviceMap.keySet();

        for(String name : deviceNames){

            Long numberByDevice = moduleRepairNumberByDeviceMap.get(name);
            pointNumbers.add(numberByDevice);

            //查询装置数量， 计算泄露率/修复率
            long totalModuleNumberByDevice = 0;
            if(!isRepair){
                totalModuleNumberByDevice = moduleService.getTotalModuleByDevice(name);
            }else{
                totalModuleNumberByDevice = moduleService.getTotalLeakModuleByDevice(name);
            }

            double percentByDevice = (numberByDevice * (1.0)) / totalModuleNumberByDevice;
            percentValues.add(Double.valueOf(df.format(percentByDevice)));

            titles.add(name+":"+numberByDevice+"个 占"+StringUtils.formateDoubleToIntString(percentByDevice));

        }
        return  wrapper;
    }

    public void statisticLeakPointAllocate() throws Exception{

        long moduleTotalLeakNumber = moduleService.getTotalLeakNumber();
        List<Long> moduleNumberByModuleTypeList = moduleService.getLeakModuleNumberByModuleType();
        PieStatisticNumberWrapper wrapper = new PieStatisticNumberWrapper();
        wrapper.setBigTitle("泄漏点: 共 "+moduleService.getTotalLeakNumber()+"个");
        wrapper.setTitles(Arrays.asList(Constant.MODULE_TYPE));

        PieStatisticNumber pieStatisticNumber;
        long number = 0;
        for(int i=0; i<moduleNumberByModuleTypeList.size(); i++){

            number = moduleNumberByModuleTypeList.get(i);
            double percentLong = number / (double)moduleTotalLeakNumber;
            String percent  = StringUtils.formateDoubleToIntString(percentLong);

            pieStatisticNumber = new PieStatisticNumber(number, wrapper.getTitles().get(i)+":"+number+"个; 占"+percent);
            wrapper.getStatisticInfo().add(pieStatisticNumber);
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

