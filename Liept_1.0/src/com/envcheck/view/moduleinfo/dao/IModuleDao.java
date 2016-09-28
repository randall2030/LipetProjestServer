package com.envcheck.view.moduleinfo.dao;

import com.envcheck.base.bean.Module;
import com.envcheck.base.dao.IBaseDao;
import com.envcheck.base.utils.PageResult;
import com.envcheck.report.statistics.letnumberstatistics.bean.ModuleInfoFroDischarge;
import com.envcheck.scenemanage.allocatetask.bean.Task;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/5.
 */
public interface IModuleDao extends IBaseDao<Module> {
    Module findByLabelAndExtendNumber(String labelNumber, int extendNumber);

    List<Module> getAllByLabelNumber(String importPictureLabelNumber);

    PageResult getModuleNotBelongToTask(String id, int pageNo, int pageSize);

    long getModuleTotalNumber();

    void clearModuleWithTaskConnection(String id);

    long getDiffCheckModuleNumber();

    long getEasyCheckModuleNumber();

    List<Long> getModuleNumberByModuleType();

    Map<String, Long> getModuleNumberByDevice();

    List<Long> getPPMAllocateByDeviceName(String deviceName);

    Map<String,Long> getCheckModuleNumberByDevice();

    Map<String,Long> getModuleLeakNumberByDevice();

    long getTotalModuleByDevice(String name);

    long getTotalLeakModuleByDevice(String name);

    Map<String,Long> getModuleRepairNumberByDevice();

    List<Long> getLeakModuleNumberByModuleType();


    Map<String,Long> getCheckModuleNumberByDeviceAndTime(Date startTime, Date endTime);


    Map<String,Long> getLeakModuleNumberByDeviceAndTime(Date startTime, Date endTime);

    Map<String,Long> getRepairModuleNumberByDeviceAndTime(Date startTime, Date endTime);

    List<ModuleInfoFroDischarge> getALLModuleInfoForDischargeByDeiveName(String deviceName);

    List<ModuleInfoFroDischarge> getALLModuleInfoForDischargeByModuleType(String moduleType);

    long getTotalLeakNumber();

    long getTotalLabelNumber();

    long getDelayRepairNumber();

    long getEasyCheckModuleNumberForDevice(String deiveceName);

    long getcheckModuleNumberForDevice(String deviceName);

    long getModuleRepairNumberForDeivce(String deviceName);

    double getDelayRepairNumberForDevice(String deviceName);

    List<String> getAllMediumStatus();

    List<ModuleInfoFroDischarge> getALLModuleInfoForDischargeByMediumStatus(String mediumStatus);

    Module getARepresentModule();

    List<Module> getHasRepairModule();
}



