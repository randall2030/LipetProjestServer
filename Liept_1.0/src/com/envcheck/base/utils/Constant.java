package com.envcheck.base.utils;

import com.envcheck.base.bean.PPMRangeBean;
import com.envcheck.base.dynamic_change_datasource.DataSourceConstant;
import com.envcheck.base.dynamic_change_datasource.DataSourceContextHolder;
import com.envcheck.base.user.bean.User;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by susion on 2016/5/18.
 */
public class Constant {
    public static final String PICTURE_BASE_DIR = "";
  public static final String TASK_DOWN_ACTION = "http://115.28.55.6:8080/Liept/scenemanage/down_check_task_downCheckTask.action" ;
//   public static final String TASK_DOWN_ACTION = "http://192.168.1.106:8080/Liept/scenemanage/down_check_task_downCheckTask.action" ;
    public static final String TASK_NAME_PRFIX = "";
    public static final String TASK_EXTRA_INFO_DIR = "ExtraInfo";
    public static final String PEAK_COMPANY = "liept";
    public static final String DATABASE_PRIFIX = "liept";
    public static final String DIVIDE_CHAR = "_";
    public static final String IMAGE_BASE_PATH = "images";

    public static  final String PEEK_USERNAME = "liept_admin";


    public static String MODULE_XLS_UP_PATH = "upload"+File.separator+ DataSourceContextHolder.getDataSourceName()+File.separator+"importExcels";
    public static String TASKS_BASE_PATH = "tasks"+File.separator+DataSourceContextHolder.getDataSourceName();
    public static String TASKS_UP_PATH = "upload"+File.separator+DataSourceContextHolder.getDataSourceName()+File.separator+"checkTask";


    public static final String EXPORT_BASE_PATH = "download"+File.separator+DataSourceContextHolder.getDataSourceName()+File.separator+"excel";

    public static final String[]  MODULE_TYPE = {"搅拌器（轴封）", "连接件（螺纹连接）", "法兰", "开口阀或开口管线", "泵（轴封）",
            "其他", "泄压设备（安全阀）", "取样连接系统", "阀门", "压缩机（轴封）"};


    //当前登录系统的user
    public static User currentUser;


    public static void setTASK_UP_PATH(String dataSourcename){
        TASKS_UP_PATH = "upload"+File.separator+dataSourcename+File.separator+"checkTask";
    }

    public static void setMODULE_XLS_UP_PATH(String dataSourcename){
        MODULE_XLS_UP_PATH = "upload"+File.separator+dataSourcename+File.separator+"importExcels";
    }


    public static void setTASKS_BASE_PATH(String dataSourcename){
         TASKS_BASE_PATH = "tasks"+File.separator+dataSourcename;
    }



    //初识化 ppm 分配的查询参数
    public static List<PPMRangeBean> ppmRanges = new ArrayList<>();
    static{
        ppmRanges.add(new PPMRangeBean(500, 1000));
        ppmRanges.add(new PPMRangeBean(1000, 2000));
        ppmRanges.add(new PPMRangeBean(2000, 5000));
        ppmRanges.add(new PPMRangeBean(5000, 10000));
        ppmRanges.add(new PPMRangeBean(10000, 50000));
        PPMRangeBean ppmRangeBean = new PPMRangeBean(-1, 50000);
        ppmRangeBean.isToptop = true;
        ppmRanges.add(ppmRangeBean);

    }



    //三种任务类型
    public static final String TASK_TYPE_COMMON_CHECK = "常规检测";
    public static final String TASK_TYPE_REPEATE_CHECK = "泄露复检";
    public static final String TASK_TYPE_EYE_CHECK = "目视检测";

    //筛选条件
    public static final String CONDITION_ALL = "all";


    //检测频率
    public static final String CHECK_FRENQUENCY_WEEK = "每周巡检";
    public static final String CHECK_FRENQUENCY_MONTH = "月度检测";
    public static final String CHECK_FRENQUENCY_SEASON = "季度检测";
    public static final String CHECK_FRENQUENCY_HALF_YEAR = "半年度检测";
    public static final String CHECK_FRENQUENCY_YEAR = "年度检测";
    public static final String CHECK_FRENQUENCY_TWO_YEAR = "两年检测";
    public static final String CHECK_FRENQUENCY_NO = "豁免";

    public static Map<String, Integer> checkFrenquencyMap = new HashMap<>();
    static {
        checkFrenquencyMap.put(CHECK_FRENQUENCY_WEEK, 7);
        checkFrenquencyMap.put(CHECK_FRENQUENCY_MONTH, 31);
        checkFrenquencyMap.put(CHECK_FRENQUENCY_SEASON, 93);
        checkFrenquencyMap.put(CHECK_FRENQUENCY_HALF_YEAR, 182);
        checkFrenquencyMap.put(CHECK_FRENQUENCY_YEAR, 365);
        checkFrenquencyMap.put(CHECK_FRENQUENCY_TWO_YEAR, 730);
        checkFrenquencyMap.put(CHECK_FRENQUENCY_NO, 0);
    }


   //导出组件的标题
    public static final Map<String, String> MODULE_TITLE = new HashMap<>();
    static{
        MODULE_TITLE.put("device","装置");
        MODULE_TITLE.put("area","区域");
        MODULE_TITLE.put("equipment","设备");
        MODULE_TITLE.put("labelNumber","标签号");
        MODULE_TITLE.put("extendNumber","扩展号");
        MODULE_TITLE.put("locationDesc","位置描述");
        MODULE_TITLE.put("modelType","组件类型");
        MODULE_TITLE.put("sizeMM","尺寸（mm）");
        MODULE_TITLE.put("yearRunTime","年运行时间（h）");
        MODULE_TITLE.put("diffToTouch","难以触及");
        MODULE_TITLE.put("diffToCheck","难于检测");
        MODULE_TITLE.put("diffToCheckReason","难于检测原因");
        MODULE_TITLE.put("dangerToCheck","险于检测");
        MODULE_TITLE.put("dangerToCheckReason","险于检测原因");
        MODULE_TITLE.put("glandNumber","密封点编码");
        MODULE_TITLE.put("mediumStatus","介质状态");
        MODULE_TITLE.put("barCode","条形码");
        MODULE_TITLE.put("imgY","图片Y坐标");
        MODULE_TITLE.put("imgX","图片X坐标");
        MODULE_TITLE.put("heatX","热点X坐标");
        MODULE_TITLE.put("heatY","热点Y坐标");
    }


    //导出检测的标题
    public static final Map<String, String> CHECK_INFO_TITLE = new HashMap<>();
    static{
        CHECK_INFO_TITLE.put("device","装置");
        CHECK_INFO_TITLE.put("area","区域");
        CHECK_INFO_TITLE.put("labelNumber","标签号");
        CHECK_INFO_TITLE.put("extendNumber","扩展号");
        CHECK_INFO_TITLE.put("locationDesc","位置描述");
        CHECK_INFO_TITLE.put("moduleType","组件类型");
        CHECK_INFO_TITLE.put("siezMM","尺寸（mm）");
        CHECK_INFO_TITLE.put("mediumStatus","介质状态");
        CHECK_INFO_TITLE.put("diffToCheck","难于检测");
        CHECK_INFO_TITLE.put("leakThreshold","泄漏阈值");
        CHECK_INFO_TITLE.put("startTime","检测日期");
        CHECK_INFO_TITLE.put("checkPerson","检测人");
        CHECK_INFO_TITLE.put("checkEquipment","检测仪器");
        CHECK_INFO_TITLE.put("backgroundPPMNumber","背景值PPM读数");
        CHECK_INFO_TITLE.put("PPMNumber","净PPM读数");
        CHECK_INFO_TITLE.put("leakSource","泄漏源");
    }


    //导出泄露的标题
    public static final Map<String, String> LEAK_INFO_TITLE = new HashMap<>();
    static{
        LEAK_INFO_TITLE.put("device","装置");
        LEAK_INFO_TITLE.put("area","区域");
        LEAK_INFO_TITLE.put("labelNumber","标签号");
        LEAK_INFO_TITLE.put("extendNumber","扩展号");
        LEAK_INFO_TITLE.put("locationDesc","位置描述");
        LEAK_INFO_TITLE.put("moduleType","组件类型");
        LEAK_INFO_TITLE.put("sizeMM","尺寸（mm）");
        LEAK_INFO_TITLE.put("mediumStatus","介质状态");
        LEAK_INFO_TITLE.put("leakThreshold","泄漏阈值");
        LEAK_INFO_TITLE.put("checkDate","检测日期");
        LEAK_INFO_TITLE.put("checkPerson","检测人");
        LEAK_INFO_TITLE.put("backgroundPPMNumber","背景值PPM读数");
        LEAK_INFO_TITLE.put("cleanPPMValue","净PPM读数");
        LEAK_INFO_TITLE.put("leakSource","泄漏源");
        LEAK_INFO_TITLE.put("repairResult","泄漏修复");
        LEAK_INFO_TITLE.put("repairNumber","维修次数");
        LEAK_INFO_TITLE.put("firstRepeateValue","首次复测值");
        LEAK_INFO_TITLE.put("firstRepeateDate","首次复测日期");
        LEAK_INFO_TITLE.put("endRepeateValue","最终复测值");
        LEAK_INFO_TITLE.put("endRepeateDate","最终复测日期");
    }

    public static final Map<String, String> LET_CACULATE_INFO = new HashMap<>();
    static{
        LET_CACULATE_INFO.put("device","装置");
        LET_CACULATE_INFO.put("area","区域");
        LET_CACULATE_INFO.put("equipment","设备");
        LET_CACULATE_INFO.put("labelNumber","标签号");
        LET_CACULATE_INFO.put("extendNumber","扩展号");
        LET_CACULATE_INFO.put("mediumStatus","介质状态");
        LET_CACULATE_INFO.put("diffToCheck","难于检查");
        LET_CACULATE_INFO.put("totalRunTime","总运行时间");
        LET_CACULATE_INFO.put("dischargeSpeed","排放速率(kg/h)");
        LET_CACULATE_INFO.put("totalLetNumber","排放量(千克)");
    }


}
