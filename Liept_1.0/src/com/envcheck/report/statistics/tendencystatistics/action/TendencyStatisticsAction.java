package com.envcheck.report.statistics.tendencystatistics.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.report.statistics.tendencystatistics.bean.StatisticForDeviceTendency;
import com.envcheck.report.statistics.tendencystatistics.bean.StatisticForYearTendencyWrapper;
import com.envcheck.view.moduleinfo.service.IModuleService;
import com.google.gson.Gson;
import org.apache.struts2.ServletActionContext;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by susion on 2016/5/11.
 */
public class TendencyStatisticsAction extends BaseAction{

    private static final String START_TIME = "startTime";
    private static final String END_TIME = "endTime";
    Calendar calendar = Calendar.getInstance();
    private IModuleService moduleService;
    private Gson gson = new Gson();


    public String listUI(){
        return "listUI";
    }


    public void statisticCheckTendency() throws Exception{  //如何抽取成这样的？

        StatisticForYearTendencyWrapper wrapper = new StatisticForYearTendencyWrapper();
        Map<String, Date> times = getStartTimeAndEndTime(wrapper);
        Map<String, Long> resultMap = moduleService.getCheckModuleNumberByDeviceAndTime(times.get(START_TIME), times.get(END_TIME));
        productStatisticByResultMap(resultMap, wrapper);

    }


    public void statisticLeakTendency()  throws Exception{

        StatisticForYearTendencyWrapper wrapper = new StatisticForYearTendencyWrapper();
        Map<String, Date> times = getStartTimeAndEndTime(wrapper);
        Map<String, Long> resultMap = moduleService.getLeakModuleNumberByDeviceAndTime(times.get(START_TIME), times.get(END_TIME));
        productStatisticByResultMap(resultMap, wrapper);

    }


    public void statisticRepairTendency()  throws Exception{
        StatisticForYearTendencyWrapper wrapper = new StatisticForYearTendencyWrapper();
        Map<String, Date> times = getStartTimeAndEndTime(wrapper);
        Map<String, Long> resultMap = moduleService.getRepairModuleNumberByDeviceAndTime(times.get(START_TIME), times.get(END_TIME));
        productStatisticByResultMap(resultMap, wrapper);
    }

    public Map<String,Date> getStartTimeAndEndTime(StatisticForYearTendencyWrapper wrapper) throws  Exception{
        calendar.setTime(new Date());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Map<String, Date> resultTime = new HashMap<>();
        Date startTime;
        Date endTime;
        if(month < 6){  //上半年
            startTime = format.parse(year + "-01" + "-01");
            endTime = format.parse(year + "-06" + "-30");
            wrapper.getYearNames().add(year+"上半年");
        }else{
            startTime = format.parse(year + "-07" + "-01");
            endTime = format.parse(year + "-12" + "-30");
            wrapper.getYearNames().add(year+"下半年");
        }

        resultTime.put(START_TIME, startTime);
        resultTime.put(END_TIME, endTime);

        return resultTime;
    }

    private void productStatisticByResultMap(Map<String, Long> resultMap, StatisticForYearTendencyWrapper wrapper) throws Exception{

        StatisticForDeviceTendency deviceTendency;
        Set<String> deviceNames = resultMap.keySet();
        for(String deviceName : deviceNames){
            deviceTendency = new StatisticForDeviceTendency();
            deviceTendency.setName(deviceName);
            deviceTendency.getData().add(resultMap.get(deviceName));
            deviceTendency.setType("bar");
            wrapper.getDeviceToNumberList().add(deviceTendency);
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
