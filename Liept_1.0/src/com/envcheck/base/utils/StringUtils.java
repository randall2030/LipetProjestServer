package com.envcheck.base.utils;

import com.envcheck.base.bean.Module;
import com.envcheck.base.bean.ModuleRepairUnit;
import com.envcheck.base.user.bean.User;
import com.envcheck.paramsetting.laws.bean.Law;
import com.envcheck.paramsetting.laws.bean.LawDetails;
import com.envcheck.paramsetting.laws.bean.MediumStatusDesc;
import com.envcheck.paramsetting.laws.bean.ModuleTypeDesc;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by susion on 2016/6/3.
 */
public class StringUtils {


    private static final int LEAK_THRESHOLD = 1;
    private static final int CHECK_FRENQUENCY = 2;


    public static String getLabelNumberLast4Bit(String labelNumber) {

        if(labelNumber != null && labelNumber.length() > 5){

            char[] temp = labelNumber.toCharArray();
            StringBuilder builder = new StringBuilder();

            for(int i=temp.length-1; i > temp.length-5; i--){  //取后4位
                builder.insert(0, temp[i]);
            }

            return builder.toString();

        }

        return null;
    }




    public static String changeModuleTypeToLetter(String moduleType) {


        if(moduleType.equals("搅拌器（轴封）")){
            return "A";
        }
        if(moduleType.equals("连接件（螺纹连接）")){
            return "C";
        }
        if(moduleType.equals("法兰")){
            return "F";
        }
        if(moduleType.equals("开口阀或开口管线")){
            return "O";
        }
        if(moduleType.equals("泵（轴封）")){
            return "P";
        }
        if(moduleType.equals("其他")){
            return "Q";
        }
        if(moduleType.equals("泄压设备（安全阀）")){
            return "R";
        }
        if(moduleType.equals("取样连接系统")){
            return "S";
        }
        if(moduleType.equals("阀门")){
            return "V";
        }

        if(moduleType.equals("压缩机（轴封）")){
            return "Y";
        }

        return null;
    }

    public static String changeMediumStatusToLetter(String mediumStatus) {

        if (mediumStatus.equals("气体")){
            return "G";
        }

        if(mediumStatus.equals("轻液")){
            return "L";
        }

        if(mediumStatus.equals("重液")){
            return "H";
        }

        return null;
    }


    public static String formatDate(Date date) {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        return format.format(date);
    }

    public static int getLeakThresholdValueFromLaw(Module module, Law law) {
        try {
            return Integer.valueOf(getCheckInfoFromLaw(module, law, LEAK_THRESHOLD));
        }catch (Exception e){
            return 0;
        }
    }


    public static int getCheckFrenquencyFromLaw(Module module, Law law){
        if(law == null){
            return  93;
        }
        return Constant.checkFrenquencyMap.get(getCheckInfoFromLaw(module, law, CHECK_FRENQUENCY));
    }



    public static String getCheckInfoFromLaw(Module module, Law law, int type){

        Set<LawDetails> lawDetails = law.getLawDetails();


        String moduleType = module.getModelType();
        String mediumStatus = module.getMediumStatus();

        for(LawDetails detail : lawDetails){

            Set<MediumStatusDesc> status = detail.getMediumStatus();
            Set<ModuleTypeDesc> types = detail.getModuleType();

            if(containMediumStatus(mediumStatus, status) && containModuleType(moduleType,types)){

                if(type == LEAK_THRESHOLD){
                    return detail.getPpmLeakThreshold();
                }

                if(type == CHECK_FRENQUENCY){
                    return detail.getCheckFre();
                }
            }
        }

        return null;
    }

    private static boolean containModuleType(String moduleType, Set<ModuleTypeDesc> types) {

        for(ModuleTypeDesc desc : types){
            if(desc.getModuleType().equals(moduleType)){
                return true;
            }
        }
        return false;
    }

    private static boolean containMediumStatus(String mediumStatus, Set<MediumStatusDesc> status) {

        for(MediumStatusDesc desc : status){
            if(desc.getMediumStatus().equals(mediumStatus)){
                return true;
            }
        }
        return false;
    }

    public static String getCurrentDataSourceKey(User user) {

        String mapKey = Constant.DATABASE_PRIFIX + Constant.DIVIDE_CHAR;

        if(user.getParentCompany() != null && !user.getParentCompany().trim().equals("")){
            mapKey =  mapKey+user.getParentCompany()+Constant.DIVIDE_CHAR+user.getCompany();
        }else {
            mapKey = mapKey + user.getCompany();
        }

        return  mapKey;
    }

    public static boolean notIsNullAndEmptyString(String device) {

        if(device != null && !device.trim().equals("")){
            return true;
        }
        return false;
    }

    public static String formatDateForExportFile(Date date) {

        DateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");

        return format.format(date);
    }

    public static String formateDoubleToIntString(double percentLong) {

        if(percentLong == 0)
            return "0.00%";
        return new DecimalFormat("#.##%").format(percentLong);
    }

    public static Date formateDateForEndTime(String endTime){

        SimpleDateFormat formate = new SimpleDateFormat("yyyy/MM/dd 上午hh:mm:ss");
        try {
            return  formate.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return  null;
    }
}
