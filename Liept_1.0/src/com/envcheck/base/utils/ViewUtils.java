package com.envcheck.base.utils;

import com.envcheck.base.bean.Module;
import com.envcheck.base.bean.ModuleCheck;
import com.envcheck.base.bean.ModuleRepairRecord;
import com.envcheck.base.bean.ModuleRepairUnit;
import com.envcheck.paramsetting.checkrepairsetting.minchecktime.bean.MinCheckTime;
import com.envcheck.paramsetting.checkrepairsetting.minchecktime.bean.SizeRange;
import com.envcheck.paramsetting.laws.bean.Law;
import com.envcheck.view.checkinfo.bean.CheckInfo;
import com.envcheck.view.leakinfo.bean.LeakInfo;
import com.envcheck.view.moduleinfo.bean.ModuleInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by susion on 2016/6/28.
 */
public class ViewUtils {


    public static ModuleRepairUnit getFirstRepairUnit(Set<ModuleRepairUnit> repairRecordList) {
        ModuleRepairUnit resultUnit = null;

        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date mostNearDate = format.parse("2100-01-01");

            for(ModuleRepairUnit unit : repairRecordList){

                if(unit.getRepeateCheckDate().before(mostNearDate)){
                    mostNearDate = unit.getRepairDate();
                    resultUnit = unit;
                }
            }

        }catch (Exception e){
            throw  new RuntimeException("解析日期出错");
        }

        return resultUnit;
    }

    public static ModuleRepairUnit getLastRepairUnit(Set<ModuleRepairUnit> repairRecordList) {
        ModuleRepairUnit resultUnit = null;

        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date mostNearDate = format.parse("2000-01-01");

            for(ModuleRepairUnit unit : repairRecordList){
                if(unit.getRepeateCheckDate().after(mostNearDate)){
                    mostNearDate = unit.getRepairDate();
                    resultUnit = unit;
                }
            }

        }catch (Exception e){
            throw  new RuntimeException("解析日期出错");
        }

        return resultUnit;
    }


    public static CheckInfo getCheckInfoByModule(CheckInfo checkInfo, Module module, ModuleCheck moduleCheck, List<Law> laws, MinCheckTime minCheckTime) throws ParseException {
        checkInfo.setCheckId(moduleCheck.getId());
        checkInfo.setDevice(module.getDevice());
        checkInfo.setArea(module.getArea());
        checkInfo.setLabelNumber(module.getLabelNumber());
        checkInfo.setExtendNumber(module.getExtendNumber());
        checkInfo.setLocationDesc(FileUtils.getLocationDesc(module));
        checkInfo.setPPMNumber(moduleCheck.getPPMNumber());


        checkInfo.setLeakThreshold(StringUtils.getLeakThresholdValueFromLaw(module, getLawByLawDesc(module.getLaws(), laws)));

        if(module.isLeak()){
            checkInfo.setLeak(true);
            checkInfo.setLeakSource(module.getModelType());
        }else {
            checkInfo.setLeak(false);
            checkInfo.setLeakSource("");
        }
        checkInfo.setModuleType(module.getModelType());
        checkInfo.setSiezMM(module.getSizeMM());

        checkInfo.setCheckPerson(moduleCheck.getCheckPerson());
        checkInfo.setCheckEquipment(moduleCheck.getCheckEquipment());

        checkInfo.setStartTime(StringUtils.formatDate(moduleCheck.getStartTime()));


        Random random = new Random(5);
        Calendar cl = Calendar.getInstance();
        cl.setTime(moduleCheck.getEndTime());
        cl.add(Calendar.SECOND, getMinCheckTime(module.getSizeMM(), minCheckTime)+random.nextInt(4));

        checkInfo.setEndTime(StringUtils.formatDate(cl.getTime()));



        checkInfo.setMediumStatus(module.getMediumStatus());
        checkInfo.setDiffToCheck(module.getDiffToCheck());
        checkInfo.setBackgroundPPMNumber(moduleCheck.getBackgroundPPMNumber());


        String absoultePicturePath = module.getPicturePath();
        String subPath = absoultePicturePath.substring(absoultePicturePath.indexOf("images\\"));
        String markPath = subPath.substring(0, subPath.lastIndexOf('\\'));
        checkInfo.setMarkPictureSavePath(markPath+"\\handle.jpg");

        //下轮检测时间
        checkInfo.setNextCheckTime(StringUtils.getCheckFrenquencyFromLaw(module,
                getLawByLawDesc(module.getLaws(), laws)) - daysBetween(moduleCheck.getStartTime(), new Date()));

        return checkInfo;

    }


    public static Law getLawByLawDesc(String desc, List<Law> laws) {

        for(Law law : laws){
            if(law.getLawCode().equals(desc)){
                return law;
            }
        }

        return  null;
    }

    public static LeakInfo getLeakInfoByModule(LeakInfo leakInfo, Module module, List<Law> laws) {

        ModuleCheck moduleCheck = module.getModuleCheck();
        ModuleRepairRecord moduleRepairRecord = module.getModuleRepairRecord();

        leakInfo.setCheckDate(moduleCheck.getStartTime());
        leakInfo.setDevice(module.getDevice());
        leakInfo.setArea(module.getArea());
        leakInfo.setEquipment(module.getEquipment());
        leakInfo.setLocationDesc(FileUtils.getLocationDesc(module));


        leakInfo.setCleanPPMValue(moduleCheck.getPPMNumber() >= 0 ? moduleCheck.getPPMNumber() : 0);
        leakInfo.setLeakThreshold(StringUtils.getLeakThresholdValueFromLaw(module, getLawByLawDesc(module.getLaws(), laws)));


        leakInfo.setLabelNumber(module.getLabelNumber());
        leakInfo.setExtendNumber(module.getExtendNumber());

        String absoultePicturePath = module.getPicturePath();
        String subPath = absoultePicturePath.substring(absoultePicturePath.indexOf("images\\"));
        String markPath = subPath.substring(0, subPath.lastIndexOf('\\'));
        leakInfo.setMarkPictureSavePath(markPath+"\\handle.jpg");
        leakInfo.setPictureLocalPath(absoultePicturePath.substring(0, absoultePicturePath.lastIndexOf('\\'))+"\\handle.jpg");

        if(module.isLeak()){
            leakInfo.setLeak(true);
            leakInfo.setLeakSource(module.getModelType());
            int a = 0;
        }else {
            leakInfo.setLeak(false);
            leakInfo.setLeakSource("");
        }

        leakInfo.setModuleType(module.getModelType());
        leakInfo.setSizeMM(module.getSizeMM());
        leakInfo.setLeakSource(module.getModelType());
        leakInfo.setCheckPerson(moduleCheck.getCheckPerson());
        leakInfo.setCheckEquipment(moduleCheck.getCheckEquipment());
        leakInfo.setMediumStatus(module.getMediumStatus());
        leakInfo.setBackgroundPPMNumber(moduleCheck.getBackgroundPPMNumber());

        if(moduleRepairRecord != null){

            leakInfo.setHasRepair(true);
            leakInfo.setTempRepair(moduleRepairRecord.getTempStopRepair());
            Set<ModuleRepairUnit> repairRecordList = moduleRepairRecord.getRepairRecordList();

            if(repairRecordList != null && repairRecordList.size() > 0){
                ModuleRepairUnit firstRepairUnit = ViewUtils.getFirstRepairUnit(repairRecordList);
                leakInfo.setFirstRepeateDate(firstRepairUnit.getRepeateCheckDate());
                leakInfo.setFirstRepeateValue(firstRepairUnit.getRepeateCheckValue());

                ModuleRepairUnit lastRepairUnit = ViewUtils.getLastRepairUnit(repairRecordList);
                leakInfo.setEndRepeateDate(lastRepairUnit.getRepeateCheckDate());
                leakInfo.setEndRepeateValue(lastRepairUnit.getRepeateCheckValue());
            }

            leakInfo.setRepairResult(moduleRepairRecord.getRepairResult());
            leakInfo.setRepairNumber(moduleRepairRecord.getRepairNumber());
        }else {
            leakInfo.setHasRepair(false);
        }

        return leakInfo;
    }

    public static ModuleInfo getModuleInfoByModule(ModuleInfo moduleInfo, Module module) {

        moduleInfo.setId(module.getId());
        moduleInfo.setDevice(module.getDevice());
        moduleInfo.setArea(module.getArea());
        moduleInfo.setBarCode(module.getBarCode());
        moduleInfo.setEquipment(module.getEquipment());
        moduleInfo.setGlandNumber(module.getGlandNumber());
        moduleInfo.setHeatX(module.getHeatX());
        moduleInfo.setHeatY(module.getHeatY());
        moduleInfo.setModelType(module.getModelType());
        moduleInfo.setImgX(module.getImgX());
        moduleInfo.setImgY(module.getImgY());
        moduleInfo.setExtendNumber(module.getExtendNumber());
        moduleInfo.setSizeMM(module.getSizeMM());
        moduleInfo.setLabelNumber(module.getLabelNumber());

        String absoultePicturePath = module.getPicturePath();
        String subPath = absoultePicturePath.substring(absoultePicturePath.indexOf("images\\"));
        String markPath = subPath.substring(0, subPath.lastIndexOf('\\'));
        moduleInfo.setMarkPictureSavePath(markPath+"\\handle.jpg");

        return  moduleInfo;
    }

    public static int  getMinCheckTime(int sizeMM, MinCheckTime minCheckTime) {

        Set<SizeRange> sizeRanges = minCheckTime.getSizeRanges();

        for(SizeRange range : sizeRanges){

            int maxSize = Integer.valueOf(range.getMaxSize());
            int minSize=  Integer.valueOf(range.getMinSize());

            if(sizeMM >= minSize && sizeMM <= maxSize){
                return range.getMinCheckTime();
            }
        }

        return -1;
    }

    /**
     * 计算两个日期之间相差的天数
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate,Date bdate) throws ParseException
    {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        smdate=sdf.parse(sdf.format(smdate));
        bdate=sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }
}
