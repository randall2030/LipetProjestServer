package com.envcheck.base.utils;

import com.envcheck.base.bean.CheckTaskForLabel;
import com.envcheck.base.bean.CheckTaskForModule;
import com.envcheck.base.bean.ModuleRepairRecord;
import com.envcheck.base.bean.ModuleRepairUnit;
import com.envcheck.base.user.bean.User;
import com.envcheck.paramsetting.checkrepairsetting.checkapparatus.bean.CheckApparatusListFromServer;
import com.envcheck.paramsetting.checkrepairsetting.minchecktime.bean.MinCheckTime;
import com.envcheck.paramsetting.laws.bean.Law;
import com.envcheck.scenemanage.allocatetask.bean.Task;
import com.envcheck.scenemanage.calibrate.bean.CalibrationListFromServer;
import com.envcheck.scenemanage.weatherparam.bean.WeatherListFromServer;
import com.envcheck.scenemanage.weatherparam.bean.WeatherParam;
import com.google.gson.Gson;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by susion on 2016/5/16.
 */
public class TaskUtils {

    /*
    * 返回任务目录
    * */
    public static String createTaskDir( String taskBasePath,String taskName){

        return FileUtils.createDir(taskBasePath+File.separator+taskName);

    }

    public static String createLabelDir(String labelNumber, String taskBasePath) {
        return FileUtils.createDir(taskBasePath+File.separator+labelNumber);
    }


    public static void copyLabelPictureToTaskDir(String picturePath, String labelPath) {
        FileUtils.copyFile(picturePath, labelPath);
    }


    public static String createTaskCheckObjectForLabel(CheckTaskForLabel labelTask) {

        Gson gson = new Gson();
        //防止在生成module是又生成modulecheck，modulecheck又生成module的死循环
        for(CheckTaskForModule checkTaskForModule : labelTask.getModuleTasks()){
            checkTaskForModule.getModule().setModuleCheck(null);
            checkTaskForModule.getModuleCheck().setModule(null);
            checkTaskForModule.getModule().setModuleRepairRecord(null);

            ModuleRepairRecord moduleRepairRecord = checkTaskForModule.getModuleRepairRecord();
            if(moduleRepairRecord != null){
                moduleRepairRecord.setModule(null);
            }
        }

        return  gson.toJson(labelTask);
    }

    //指定字符编码， 将字符串写到文件中
    public static void writeCheckObjectJsonStringToLabelDir(String checkObjectJsonString, String labelPath,String currentLabel) {
        try{
            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(new File(labelPath, currentLabel+".txt")), "UTF-8");
            InputStreamReader in = new InputStreamReader(new ByteArrayInputStream(checkObjectJsonString.getBytes()));

            char[] buffer = new char[1024];
            int len = 0;

            while( (len = in.read(buffer, 0, 1024)) != -1 ){
                out.write(buffer, 0, len);
            }

            in.close();
            out.close();

        }catch (Exception e){

        }
    }


    public static void writeTaskJsonTxtToFile(String extraInfoDir, Task task) {
        Gson gson = new Gson();
        String taskJsonString  = gson.toJson(task);
        writeCheckObjectJsonStringToLabelDir(taskJsonString, extraInfoDir, "task");  //借用上面的方法
    }

    public static void writeWeatherJsonTxtToFile(String extraInfoDir, WeatherListFromServer weatherParams) {
        Gson gson = new Gson();
        String weatherJsonString  = gson.toJson(weatherParams);
        writeCheckObjectJsonStringToLabelDir(weatherJsonString, extraInfoDir, "weather");  //借用上面的方法

    }

    public static void writeCalibrationInfoJsonTxtToFile(String extraInfoDir, CalibrationListFromServer calibrationListFromServer) {
        Gson gson = new Gson();
        String weatherJsonString  = gson.toJson(calibrationListFromServer);
        writeCheckObjectJsonStringToLabelDir(weatherJsonString, extraInfoDir, "calibration");  //借用上面的方法

    }

    public static void writCheckApparatusJsonTxtToFile(String extraInfoDir, CheckApparatusListFromServer checkApparatusListFromServer) {
        Gson gson = new Gson();
        String weatherJsonString  = gson.toJson(checkApparatusListFromServer);
        writeCheckObjectJsonStringToLabelDir(weatherJsonString, extraInfoDir, "checkapparatus");  //借用上面的方法

    }

    public static void writeMinCheckTimeJsonTxtToFile(String extraInfoDir, MinCheckTime minCheckTime) {
        Gson gson = new Gson();
        String weatherJsonString  = gson.toJson(minCheckTime);
        writeCheckObjectJsonStringToLabelDir(weatherJsonString, extraInfoDir, "minchecktime");  //借用上面的方法
    }
    public static void writeLawJsonTxtToFile(String extraInfoDir, Law law) {
        Gson gson = new Gson();
        String weatherJsonString  = gson.toJson(law);
        writeCheckObjectJsonStringToLabelDir(weatherJsonString, extraInfoDir, "law");  //借用上面的方法
    }

    public static void writeUserJsonTxtToFile(String extraInfoDir, User localUser) {
        Gson gson = new Gson();
        String weatherJsonString  = gson.toJson(localUser);
        writeCheckObjectJsonStringToLabelDir(weatherJsonString, extraInfoDir, "user");  //借用上面的方法

    }
    public static CheckTaskForLabel getCheckTaskForLabelObjFromLabelPath(String labelPath, String currentLabel) {
        String checkTaskForLabelString =  FileUtils.getStringFromFile(new File(labelPath, currentLabel+".txt"));
        Gson gson = new Gson();
        return gson.fromJson(checkTaskForLabelString, CheckTaskForLabel.class);
    }

    public static String getLabelPathBylabelNumber(String taskBasePath, String currentLabelNumber) {
        return taskBasePath+File.separator+currentLabelNumber;
    }


    public static String createExtraInfoDir(String taskDir) {

        File extraInfoDir = new File(taskDir+File.separator+Constant.TASK_EXTRA_INFO_DIR);
        if(!extraInfoDir.exists()){
            extraInfoDir.mkdirs();
        }

        return extraInfoDir.getAbsolutePath();
    }


    public static ModuleRepairUnit findLatestModuleRepairUnit(ModuleRepairRecord moduleRepairRecord) {

        ModuleRepairUnit reuslt = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date mostNearDate = null;
        try {
            mostNearDate = format.parse("2010-01-01");
        }catch (Exception e){

        }

        for(ModuleRepairUnit unit : moduleRepairRecord.getRepairRecordList()){

            if(unit.getRepeateCheckDate().after(mostNearDate)){
                mostNearDate = unit.getRepairDate();
                reuslt = unit;
            }
        }

        return reuslt;
    }
}
