package com.envcheck.report.statistics.letnumberstatistics.utils;

import com.envcheck.report.statistics.letnumberstatistics.bean.ModuleInfoFroDischarge;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/6/7.
 */
public class DischargeRateUtils {

    /**
     * 计算排放速率
     * @param diffToCheck  是否难检
     * @param modelType    组件类型
     * @param mediumStatus 介质状态
     * @param cleanPPM     净ppm读数
     * @param deviceType   装置类型（炼油、化工）
     * @return
     */
    public static double getDischargeRate(String diffToCheck,  String modelType, String mediumStatus, int cleanPPM, String deviceType ){

        double dischargeRate = 0;

        //易检
        if ("否".equals(diffToCheck)){
            //炼油
            if ("炼油".equals(deviceType)){

                if ("泵（轴封）".equals(modelType)) {
                    dischargeRate = returnDischargeRate(cleanPPM,2.4*Math.pow(10,-5),0.16,5.03*Math.pow(10,-5)*Math.pow(cleanPPM,0.61));
                }else if ("压缩机（轴封）".equals(modelType)){
                    dischargeRate = returnDischargeRate(cleanPPM,4*Math.pow(10,-6),0.11,1.36*Math.pow(10,-5)*Math.pow(cleanPPM,0.589));
                }else if ("搅拌器（轴封）".equals(modelType)){
                    dischargeRate = returnDischargeRate(cleanPPM,4*Math.pow(10,-6),0.11,1.36*Math.pow(10,-5)*Math.pow(cleanPPM,0.589));
                }else if ("阀门".equals(modelType)){
                    dischargeRate = returnDischargeRate(cleanPPM,7.8*Math.pow(10,-6),0.14,2.29*Math.pow(10,-6)*Math.pow(cleanPPM,0.746));
                }else if ("泄压设备（安全阀）".equals(modelType)){
                    dischargeRate = returnDischargeRate(cleanPPM,4*Math.pow(10,-6),0.11,1.36*Math.pow(10,-5)*Math.pow(cleanPPM,0.589));
                }else if ("连接件（螺纹连接）".equals(modelType)){
                    dischargeRate = returnDischargeRate(cleanPPM,7.5*Math.pow(10,-6),0.03,1.53*Math.pow(10,-6)*Math.pow(cleanPPM,0.735));
                }else if ("法兰".equals(modelType)){
                    dischargeRate = returnDischargeRate(cleanPPM, 3.1*Math.pow(10,-7),0.084,4.61*Math.pow(10,-6)*Math.pow(cleanPPM,0.703));
                }else if ("开口阀或开口管线".equals(modelType)){
                    dischargeRate = returnDischargeRate(cleanPPM,2*Math.pow(10,-6),0.079,2.2*Math.pow(10,-6)*Math.pow(cleanPPM,0.704));
                }else if("取样连接系统".equals(modelType)){
                    dischargeRate = (float) 0.015;
                }else{
                    dischargeRate = returnDischargeRate(cleanPPM,4*Math.pow(10,-6),0.11,1.36*Math.pow(10,-5)*Math.pow(cleanPPM,0.589));
                }
            }
            //化工
            if ("化工".equals(deviceType)){

                if ("泵（轴封）".equals(modelType) && "轻液".equals(mediumStatus)) {
                    dischargeRate = returnDischargeRate(cleanPPM, 7.5*Math.pow(10,-6), 0.62, 1.9*Math.pow(10,-5)*Math.pow(cleanPPM,0.824));
                }else if ("泵（轴封）".equals(modelType) && "重液".equals(mediumStatus)) {
                    dischargeRate = returnDischargeRate(cleanPPM,7.5*Math.pow(10,-6),0.62, 1.9*Math.pow(10,-5)*Math.pow(cleanPPM,0.824));
                }else if ("压缩机（轴封）".equals(modelType)) {
                    dischargeRate = returnDischargeRate(cleanPPM,7.5*Math.pow(10,-6),0.62, 1.9*Math.pow(10,-5)*Math.pow(cleanPPM,0.824));
                }else if ("搅拌器（轴封）".equals(modelType)) {
                    dischargeRate = returnDischargeRate(cleanPPM,7.5*Math.pow(10,-6),0.62, 1.9*Math.pow(10,-5)*Math.pow(cleanPPM,0.824));
                }else if ("泄压设备（安全阀）".equals(modelType)) {
                    dischargeRate = returnDischargeRate(cleanPPM,7.5*Math.pow(10,-6),0.62, 1.9*Math.pow(10,-5)*Math.pow(cleanPPM,0.824));
                }else if ("阀门".equals(modelType) && "气体".equals(mediumStatus)) {
                    dischargeRate = returnDischargeRate(cleanPPM,6.6*Math.pow(10,-7),0.11, 1.87*Math.pow(10,-6)*Math.pow(cleanPPM,0.873));
                }else if ("阀门".equals(modelType) && "轻液".equals(mediumStatus)) {
                    dischargeRate = returnDischargeRate(cleanPPM,4.9*Math.pow(10,-7),0.15, 6.41*Math.pow(10,-6)*Math.pow(cleanPPM,0.797));
                }else if ("阀门".equals(modelType) && "重液".equals(mediumStatus)) {
                    dischargeRate = returnDischargeRate(cleanPPM,4.9*Math.pow(10,-7),0.15, 6.41*Math.pow(10,-6)*Math.pow(cleanPPM,0.797));
                }else if ("法兰".equals(modelType) || "连接件（螺纹连接）".equals(modelType)) {
                    dischargeRate = returnDischargeRate(cleanPPM, 6.1*Math.pow(10,-7), 0.22, 3.05*Math.pow(10,-6)*Math.pow(cleanPPM,0.885));
                }else if ("开口阀或开口管线".equals(modelType)) {
                    dischargeRate = returnDischargeRate(cleanPPM,2*Math.pow(10,-6),0.079, 2.2*Math.pow(10,-6)*Math.pow(cleanPPM,0.704));
                }else if("取样连接系统".equals(modelType)){
                    dischargeRate = 0.015;
                }else {
                    dischargeRate = returnDischargeRate(cleanPPM,4*Math.pow(10,-6),0.11,1.36*Math.pow(10,-5)*Math.pow(cleanPPM,0.589));
                }
            }
        }

        //难检
        if ("是".equals(diffToCheck)) {
            //炼油
            if ("炼油".equals(deviceType)) {

                if ("阀门".equals(modelType) && "气体".equals(mediumStatus)) {
                    dischargeRate = 0.0268;
                }else if ("阀门".equals(modelType) && "轻液".equals(mediumStatus)) {
                    dischargeRate = 0.0109;
                }else if ("阀门".equals(modelType) && "重液".equals(mediumStatus)) {
                    dischargeRate = 0.00023;
                }else if ("泵（轴封）".equals(modelType) && "轻液".equals(mediumStatus)) {
                    dischargeRate = 0.114;
                }else if ("泵（轴封）".equals(modelType) && "重液".equals(mediumStatus)) {
                    dischargeRate =  0.021;
                }else if ("压缩机（轴封）".equals(modelType) && "气体".equals(mediumStatus)) {
                    dischargeRate = 0.636;
                }else if ("搅拌器（轴封）".equals(modelType) && "轻液".equals(mediumStatus)) {
                    dischargeRate = 0.114;
                }else if ("泄压设备（安全阀）".equals(modelType) && "气体".equals(mediumStatus)) {
                    dischargeRate = 0.16;
                }else if ("法兰".equals(modelType) || "连接件（螺纹连接）".equals(modelType)) {
                    dischargeRate = 0.00025;
                }else if ("开口阀或开口管线".equals(modelType)) {
                    dischargeRate = 0.0023;
                }else if ("取样连接系统".equals(modelType)) {
                    dischargeRate = 0.015;
                }else {
                    dischargeRate = 0.0268;
                }

            }
            //化工
            if ("化工".equals(deviceType)) {

                if ("阀门".equals(modelType) && "气体".equals(mediumStatus)) {
                    dischargeRate = 0.00597;
                }else if ("阀门".equals(modelType) && "轻液".equals(mediumStatus)) {
                    dischargeRate = 0.00403;
                }else if ("阀门".equals(modelType) && "重液".equals(mediumStatus)) {
                    dischargeRate = 0.00023;
                }else if ("泵（轴封）".equals(modelType) && "轻液".equals(mediumStatus)) {
                    dischargeRate = 0.0199;
                }else if ("泵（轴封）".equals(modelType) && "重液".equals(mediumStatus)) {
                    dischargeRate = 0.00862;
                }else if ("压缩机（轴封）".equals(modelType) && "气体".equals(mediumStatus)) {
                    dischargeRate = 0.228;
                }else if ("搅拌器（轴封）".equals(modelType) && "轻液".equals(mediumStatus)) {
                    dischargeRate = 0.0199;
                }else if ("泄压设备（安全阀）".equals(modelType) && "气体".equals(mediumStatus)) {
                    dischargeRate = 0.104;
                }else if ("法兰".equals(modelType) || "连接件（螺纹连接）".equals(modelType)) {
                    dischargeRate = 0.00183;
                }else if ("开口阀或开口管线".equals(modelType)) {
                    dischargeRate = 0.0017;
                }else if ("取样连接系统".equals(modelType)) {
                    dischargeRate = 0.015;
                }else {
                    dischargeRate = 0.00597;
                }
            }
        }
        return dischargeRate;
    }

    /**
     * 返回排放率
     * @param cleanPPM  净ppm
     * @param d1        净ppm  0~1
     * @param d2        净ppm  大于50000
     * @param d3        净ppm  1~50000
     * @return
     */
    private static double returnDischargeRate(int cleanPPM, double d1, double d2, double d3){

        double dischargeRate = 0;
        if(cleanPPM < 1){
            dischargeRate = d1;
        }else if (cleanPPM>=50000){
            dischargeRate = d2;
        }else if (cleanPPM>=1 && cleanPPM<50000){
            dischargeRate = d3;
        }

        return dischargeRate;
    }


}
