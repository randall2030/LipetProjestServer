package com.envcheck.report.letcaculate.utils;

import com.envcheck.report.letcaculate.bean.DischargeFormula;
import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/15.
 */
public class DischargeFormulaConstant {

    public static Map<String, DischargeFormula> chemicalDischargeFormulaMapEasy = new HashedMap();

    //化工 计算排放速率相关常量
    static{
        chemicalDischargeFormulaMapEasy.put("泵（轴封）-轻液", new DischargeFormula(0.0199, 7.5*Math.pow(10,-6), 1.9*Math.pow(10,-5), 0.824, 50000, 0.62));
        chemicalDischargeFormulaMapEasy.put("泵（轴封）-重液", new DischargeFormula(0.00862, 7.5*Math.pow(10,-6), 1.9*Math.pow(10,-5), 0.824, 50000, 0.62));

        chemicalDischargeFormulaMapEasy.put("阀门-气体", new DischargeFormula(0.00597, 6.6*Math.pow(10,-7), 1.87*Math.pow(10,-6), 0.873, 50000, 0.110));
        chemicalDischargeFormulaMapEasy.put("阀门-轻液", new DischargeFormula(0.00403, 4.9*Math.pow(10,-7), 6.41*Math.pow(10,-6), 0.797, 50000, 0.150));
        chemicalDischargeFormulaMapEasy.put("阀门-重液", new DischargeFormula(0.00023, 6.6*Math.pow(10,-7), 1.87*Math.pow(10,-6), 0.873, 50000, 0.110));

        chemicalDischargeFormulaMapEasy.put("法兰", new DischargeFormula(0.00183, 6.1*Math.pow(10,-7), 3.05*Math.pow(10,-6), 0.885, 50000, 0.220));

        chemicalDischargeFormulaMapEasy.put("搅拌器（轴封）-轻液", new DischargeFormula(0.0199, 7.5*Math.pow(10,-6), 1.90*Math.pow(10,-5), 0.824, 50000, 0.620));

        chemicalDischargeFormulaMapEasy.put("开口阀或开口管线", new DischargeFormula(0.0017, 2.0*Math.pow(10,-6), 2.20*Math.pow(10,-6), 0.704, 50000, 0.079));
        chemicalDischargeFormulaMapEasy.put("连接件（螺纹连接）", new DischargeFormula(0.00183, 6.1*Math.pow(10,-7), 3.05*Math.pow(10,-6), 0.885, 50000, 0.220));

        chemicalDischargeFormulaMapEasy.put("泄压设备（安全阀）-气体", new DischargeFormula(0.104, 7.5*Math.pow(10,-6), 1.90*Math.pow(10,-5), 0.824, 50000, 0.620));
        chemicalDischargeFormulaMapEasy.put("压缩机（轴封）-气体", new DischargeFormula(0.228, 7.5*Math.pow(10,-6), 1.90*Math.pow(10,-5), 0.824, 50000, 0.620));

        chemicalDischargeFormulaMapEasy.put("取样连接系统", new DischargeFormula(0.015));

        chemicalDischargeFormulaMapEasy.put("其他", new DischargeFormula(0.00597, 4.0*Math.pow(10,-6), 1.36*Math.pow(10,-5), 0.589, 50000, 0.110));
    }

    public static Map<String, DischargeFormula> chemicalDischargeFormulaMapDiff = new HashedMap();
    //化工 难检 计算排放速率相关常量
    static{
        chemicalDischargeFormulaMapDiff.put("泵（轴封）-轻液", new DischargeFormula(0.0199));
        chemicalDischargeFormulaMapDiff.put("泵（轴封）-重液", new DischargeFormula(0.00862));

        chemicalDischargeFormulaMapDiff.put("阀门-气体", new DischargeFormula(0.00597));
        chemicalDischargeFormulaMapDiff.put("阀门-轻液", new DischargeFormula(0.00403));
        chemicalDischargeFormulaMapDiff.put("阀门-重液", new DischargeFormula(0.00023));

        chemicalDischargeFormulaMapDiff.put("法兰", new DischargeFormula(0.00183));

        chemicalDischargeFormulaMapDiff.put("搅拌器（轴封）-轻液", new DischargeFormula(0.0199));

        chemicalDischargeFormulaMapDiff.put("开口阀或开口管线", new DischargeFormula(0.0017));
        chemicalDischargeFormulaMapDiff.put("连接件（螺纹连接）", new DischargeFormula(0.00183));

        chemicalDischargeFormulaMapDiff.put("泄压设备（安全阀）-气体", new DischargeFormula(0.104));
        chemicalDischargeFormulaMapDiff.put("压缩机（轴封）-气体", new DischargeFormula(0.228));

        chemicalDischargeFormulaMapDiff.put("取样连接系统", new DischargeFormula(0.015));

        chemicalDischargeFormulaMapDiff.put("其他", new DischargeFormula(0.00597));
    }



    public static Map<String, DischargeFormula> oillDischargeFormulaMapEasy = new HashedMap();

    //石油  易检 计算排放速率相关常量
    static{
        oillDischargeFormulaMapEasy.put("泵（轴封）-轻液", new DischargeFormula(0.114, 2.4*Math.pow(10,-5), 5.03*Math.pow(10,-5), 0.610, 50000, 0.160));
        oillDischargeFormulaMapEasy.put("泵（轴封）-重液", new DischargeFormula(0.021, 2.4*Math.pow(10,-5), 5.03*Math.pow(10,-5), 0.610, 50000, 0.160));

        oillDischargeFormulaMapEasy.put("阀门-气体", new DischargeFormula(0.0268, 7.8*Math.pow(10,-6), 2.29*Math.pow(10,-6), 0.746, 50000, 0.140));
        oillDischargeFormulaMapEasy.put("阀门-轻液", new DischargeFormula(0.0109, 7.8*Math.pow(10,-6), 2.29*Math.pow(10,-6), 0.746, 50000, 0.140));
        oillDischargeFormulaMapEasy.put("阀门-重液", new DischargeFormula(0.00023, 7.8*Math.pow(10,-6), 2.29*Math.pow(10,-6), 0.746, 50000, 0.140));

        oillDischargeFormulaMapEasy.put("法兰", new DischargeFormula(0.00025, 3.1*Math.pow(10,-7),4.61*Math.pow(10,-6), 0.703, 50000, 0.084));

        oillDischargeFormulaMapEasy.put("搅拌器（轴封）-轻液", new DischargeFormula(0.114, 4.0*Math.pow(10,-6), 1.36*Math.pow(10,-5), 0.589, 50000, 0.110));

        oillDischargeFormulaMapEasy.put("开口阀或开口管线", new DischargeFormula(0.0023, 2.0*Math.pow(10,-6), 2.20*Math.pow(10,-6), 0.704, 50000, 0.079));
        oillDischargeFormulaMapEasy.put("连接件（螺纹连接）", new DischargeFormula(0.00025, 7.5*Math.pow(10,-6), 1.53*Math.pow(10,-6), 0.735, 50000, 0.030));

        oillDischargeFormulaMapEasy.put("泄压设备（安全阀）-气体", new DischargeFormula(0.160, 4.0*Math.pow(10,-6), 1.36*Math.pow(10,-5), 0.589, 50000, 0.110));
        oillDischargeFormulaMapEasy.put("压缩机（轴封）-气体", new DischargeFormula(0.0636,  4.0*Math.pow(10,-6), 1.36*Math.pow(10,-5), 0.589, 50000, 0.110));

        oillDischargeFormulaMapEasy.put("取样连接系统", new DischargeFormula(0.015));

        oillDischargeFormulaMapEasy.put("其他", new DischargeFormula(0.0286, 4.0*Math.pow(10,-6), 1.36*Math.pow(10,-5), 0.589, 50000, 0.110));
    }


    public static Map<String, DischargeFormula> oillDischargeFormulaMapDiff = new HashedMap();
    //石油  难检 计算排放速率相关常量

    static{
        oillDischargeFormulaMapDiff.put("泵（轴封）-轻液", new DischargeFormula(0.114));
        oillDischargeFormulaMapDiff.put("泵（轴封）-重液", new DischargeFormula(0.021));

        oillDischargeFormulaMapDiff.put("阀门-气体", new DischargeFormula(0.0268));
        oillDischargeFormulaMapDiff.put("阀门-轻液", new DischargeFormula(0.0109));
        oillDischargeFormulaMapDiff.put("阀门-重液", new DischargeFormula(0.00023));

        oillDischargeFormulaMapDiff.put("法兰", new DischargeFormula(0.00025));

        oillDischargeFormulaMapDiff.put("搅拌器（轴封）-轻液", new DischargeFormula(0.114));

        oillDischargeFormulaMapDiff.put("开口阀或开口管线", new DischargeFormula(0.0023));
        oillDischargeFormulaMapDiff.put("连接件（螺纹连接）", new DischargeFormula(0.00025));

        oillDischargeFormulaMapDiff.put("泄压设备（安全阀）-气体", new DischargeFormula(0.160));
        oillDischargeFormulaMapDiff.put("压缩机（轴封）-气体", new DischargeFormula(0.0636));

        oillDischargeFormulaMapDiff.put("取样连接系统", new DischargeFormula(0.015));

        oillDischargeFormulaMapDiff.put("其他", new DischargeFormula(0.0286));
    }


}
