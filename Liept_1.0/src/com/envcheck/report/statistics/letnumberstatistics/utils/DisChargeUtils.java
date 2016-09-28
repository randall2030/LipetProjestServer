package com.envcheck.report.statistics.letnumberstatistics.utils;

import com.envcheck.base.bean.discharge_check_history.DischargeForPPMRecord;
import com.envcheck.report.statistics.letnumberstatistics.bean.ModuleInfoFroDischarge;
import freemarker.template.utility.DateUtil;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by susion on 2016/6/22.
 *
 */
public class DisChargeUtils {



   // 一个组件排放量 =  排放速率 * 运行时间
    public static double caculateModuleDischarge(String deviceType, Date startTime, Date endTime, ModuleInfoFroDischarge moduleInfoForDischarge) throws Exception{

        double dischargeForModule = 0;
        double dischargeRate;

        //根据组件检测时间点判断计算类型
        Set<DischargeForPPMRecord> dischargeForPPMRecords = moduleInfoForDischarge.getDischargeForPPMRecords();
        List<DischargeForPPMRecord> orderDischargePPMRecords = translateSetToListAndOrder(dischargeForPPMRecords);

        DischargeForPPMRecord firstRecord = orderDischargePPMRecords.get(0);
        DischargeForPPMRecord lastRecord = orderDischargePPMRecords.get(orderDischargePPMRecords.size() - 1);

        if(startTime.after(lastRecord.getCheckTime())){   //startTime - endTime 之间的排放量 按最后一个点进行计算

            dischargeRate = DischargeRateUtils.getDischargeRate(moduleInfoForDischarge.getDiffToCheck(), moduleInfoForDischarge.getModuleType(),
                    moduleInfoForDischarge.getModuleMediumStatus(), lastRecord.getCleanPPMValue(), deviceType);

            dischargeForModule = dischargeRate * getRunTime(startTime, endTime, moduleInfoForDischarge.getYearRunTime());  // kg/h * h --> kg

            return dischargeForModule;
        }

        if(endTime.before(firstRecord.getCheckTime())){  //startTime - endTime 之间的排放量 按第一个点进行计算

            dischargeRate = DischargeRateUtils.getDischargeRate(moduleInfoForDischarge.getDiffToCheck(), moduleInfoForDischarge.getModuleType(),
                    moduleInfoForDischarge.getModuleMediumStatus(), firstRecord.getCleanPPMValue(), deviceType);

            dischargeForModule = dischargeRate * getRunTime(startTime, endTime, moduleInfoForDischarge.getYearRunTime());

            return dischargeForModule;
        }


        Date currentTime = startTime;
        Date checkTime;
        DischargeForPPMRecord record;
        for(int i=0; i<orderDischargePPMRecords.size(); i++){

            record = orderDischargePPMRecords.get(i);
            checkTime = record.getCheckTime();
            double totalRuntime =  getRunTime(currentTime, checkTime, moduleInfoForDischarge.getYearRunTime());

            if(checkTime.before(currentTime))
                continue;

            if(checkTime.after(currentTime) && checkTime.before(endTime)){

                if(i > 0){  //前面有点
                    dischargeForModule = caculateForRecord(deviceType, moduleInfoForDischarge, dischargeForModule, orderDischargePPMRecords, record, i, totalRuntime);
                }else{
                    dischargeRate = DischargeRateUtils.getDischargeRate(moduleInfoForDischarge.getDiffToCheck(), moduleInfoForDischarge.getModuleType(),
                            moduleInfoForDischarge.getModuleMediumStatus(), orderDischargePPMRecords.get(i).getCleanPPMValue(), deviceType);
                    dischargeForModule += (dischargeRate * totalRuntime);

                }

            }

            if(checkTime.after(endTime) && i > 0){
                dischargeForModule = caculateForRecord(deviceType, moduleInfoForDischarge, dischargeForModule, orderDischargePPMRecords, record, i, totalRuntime);
            }

            currentTime = checkTime;
        }

        if(currentTime.before(endTime)){

            double totalRuntime =  getRunTime(currentTime, endTime, moduleInfoForDischarge.getYearRunTime());

            dischargeRate = DischargeRateUtils.getDischargeRate(moduleInfoForDischarge.getDiffToCheck(), moduleInfoForDischarge.getModuleType(),
                    moduleInfoForDischarge.getModuleMediumStatus(), lastRecord.getCleanPPMValue(), deviceType);
            dischargeForModule += ( dischargeRate * totalRuntime );
        }


        return dischargeForModule;

    }

    private static double caculateForRecord(String deviceType, ModuleInfoFroDischarge moduleInfoForDischarge, double dischargeForModule,
                                            List<DischargeForPPMRecord> orderDischargePPMRecords, DischargeForPPMRecord record, int i, double totalRuntime) {

        double dischargeRate;

        if(record.isEndPeriodRecord()){  //按中点法进行计算

            double dischargeRateFirst = DischargeRateUtils.getDischargeRate(moduleInfoForDischarge.getDiffToCheck(), moduleInfoForDischarge.getModuleType(),
                    moduleInfoForDischarge.getModuleMediumStatus(), orderDischargePPMRecords.get(i-1).getCleanPPMValue(), deviceType);
            double dischargeRateSecond =  DischargeRateUtils.getDischargeRate(moduleInfoForDischarge.getDiffToCheck(), moduleInfoForDischarge.getModuleType(),
                    moduleInfoForDischarge.getModuleMediumStatus(), orderDischargePPMRecords.get(i).getCleanPPMValue(), deviceType);

            dischargeForModule += (dischargeRateFirst * totalRuntime / 2 );
            dischargeForModule += (dischargeRateSecond * totalRuntime / 2 );
        }else{

            dischargeRate = DischargeRateUtils.getDischargeRate(moduleInfoForDischarge.getDiffToCheck(), moduleInfoForDischarge.getModuleType(),
                    moduleInfoForDischarge.getModuleMediumStatus(), orderDischargePPMRecords.get(i-1).getCleanPPMValue(), deviceType);
            dischargeForModule += ( dischargeRate * totalRuntime);

        }

        return dischargeForModule;
    }



    private static List<DischargeForPPMRecord> translateSetToListAndOrder(Set<DischargeForPPMRecord> dischargeForPPMRecords) {

        List<DischargeForPPMRecord> resultList = new ArrayList<>();

        for(DischargeForPPMRecord record : dischargeForPPMRecords){
            resultList.add(record);
        }

        Collections.sort(resultList, new DateComparator());

        return resultList;

    }

    public static double getRunTime(Date startTime, Date endTime, int yearRunTime) {
        long days = getDays(startTime, endTime);
        return days * runHours(yearRunTime);
    }

    private static long getDays(Date startTime, Date endTime) {
        long diff = endTime.getTime() - startTime.getTime();
        long days = diff / (1000 * 60 * 60 * 24);
        return  days;
    }

    private static double runHours(int yearRunTime) {
        double  scale = yearRunTime / 365.0;
        return scale * 24;
    }

}
