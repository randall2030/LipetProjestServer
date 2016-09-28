package com.envcheck.view.moduleinfo.service.impl;


import com.envcheck.base.bean.Module;
import com.envcheck.base.service.impl.BaseService;
import com.envcheck.base.utils.PageResult;
import com.envcheck.report.statistics.letnumberstatistics.bean.ModuleInfoFroDischarge;
import com.envcheck.view.moduleinfo.dao.IModuleDao;
import com.envcheck.view.moduleinfo.service.IModuleService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/5.
 */
public class ModuleService extends BaseService<Module> implements IModuleService {

    private IModuleDao moduleDao;

    public IModuleDao getModuleDao() {
        return moduleDao;
    }

    @Resource
    public void setModuleDao(IModuleDao moduleDao) {
        super.setBaseDao(moduleDao);
        this.moduleDao = moduleDao;
    }

    @Override
    public Module findByLabelAndExtendNumber(String labelNumber, int extendNumber) {
        return moduleDao.findByLabelAndExtendNumber(labelNumber, extendNumber);
    }

    @Override
    public void updateByLabelAndExtendNumber(Module module) {

    }

    @Override
    public List<Module> getAllByLabelNumber(String importPictureLabelNumber) {
        return moduleDao.getAllByLabelNumber(importPictureLabelNumber);
    }

    @Override
    public PageResult getModuleNotBelongToTask(String id, int pageNo, int pageSize) {
        return moduleDao.getModuleNotBelongToTask(id, pageNo, pageSize);
    }

    @Override
    public long getModuleTotalNumber() {
        return moduleDao.getModuleTotalNumber();
    }

    @Override
    public void clearModuleWithTaskConnection(String id) {
        moduleDao.clearModuleWithTaskConnection(id);
    }

    @Override
    public long getDiffCheckModuleNumber() {
        return moduleDao.getDiffCheckModuleNumber();
    }

    @Override
    public long getEasyCheckModuleNumber() {
        return moduleDao.getEasyCheckModuleNumber();
    }

    @Override
    public List<Long> getModuleNumberByModuleType() {
        return moduleDao.getModuleNumberByModuleType();
    }

    @Override
    public Map<String, Long> getModuleNumberByDevice() {
        return moduleDao.getModuleNumberByDevice();
    }

    @Override
    public List<Long> getPPMAllocateByDeviceName(String deviceName) {
        return moduleDao.getPPMAllocateByDeviceName(deviceName);
    }

    @Override
    public Map<String, Long> getCheckModuleNumberByDevice() {
        return moduleDao.getCheckModuleNumberByDevice();
    }

    @Override
    public Map<String, Long> getModuleLeakNumberByDevice() {
        return moduleDao.getModuleLeakNumberByDevice();
    }

    @Override
    public long getTotalModuleByDevice(String name) {
        return moduleDao.getTotalModuleByDevice(name);
    }

    @Override
    public Map<String, Long> getModuleRepairNumberByDevice() {
        return moduleDao.getModuleRepairNumberByDevice();
    }

    @Override
    public long getTotalLeakModuleByDevice(String name) {
        return moduleDao.getTotalLeakModuleByDevice(name);
    }

    @Override
    public List<Long> getLeakModuleNumberByModuleType() {
        return moduleDao.getLeakModuleNumberByModuleType();
    }

    @Override
    public Map<String, Long> getCheckModuleNumberByDeviceAndTime(Date startTime, Date endTime) {
        return moduleDao.getCheckModuleNumberByDeviceAndTime(startTime, endTime);
    }

    @Override
    public Map<String, Long> getLeakModuleNumberByDeviceAndTime(Date startTime, Date endTime) {
        return moduleDao.getLeakModuleNumberByDeviceAndTime(startTime, endTime);
    }

    @Override
    public Map<String, Long> getRepairModuleNumberByDeviceAndTime(Date startTime, Date endTime) {
        return moduleDao.getRepairModuleNumberByDeviceAndTime(startTime, endTime);
    }

    @Override
    public List<ModuleInfoFroDischarge> getALLModuleInfoForDischargeByDeiveName(String deviceName) {
        return moduleDao.getALLModuleInfoForDischargeByDeiveName(deviceName);
    }

    @Override
    public List<ModuleInfoFroDischarge> getALLModuleInfoForDischargeByModuleType(String moduleType) {


        return moduleDao.getALLModuleInfoForDischargeByModuleType(moduleType);
    }

    @Override
    public long getTotalLeakNumber() {
        return moduleDao.getTotalLeakNumber();
    }

    @Override
    public long getTotalLabelNumber() {
        return moduleDao.getTotalLabelNumber();
    }

    @Override
    public long getDelayRepairNumber() {
        return moduleDao.getDelayRepairNumber();
    }

    @Override
    public long getEasyCheckModuleNumberForDevice(String deviceName) {
        return moduleDao.getEasyCheckModuleNumberForDevice(deviceName);
    }

    @Override
    public long getcheckModuleNumberForDevice(String deviceName) {
        return moduleDao.getcheckModuleNumberForDevice(deviceName);
    }

    @Override
    public long getModuleRepairNumberForDeivce(String deviceName) {
        return moduleDao.getModuleRepairNumberForDeivce(deviceName);
    }

    @Override
    public double getDelayRepairNumberForDevice(String deviceName) {
        return moduleDao.getDelayRepairNumberForDevice(deviceName);
    }

    @Override
    public List<String> getAllMediumStatus() {
        return moduleDao.getAllMediumStatus();
    }

    @Override
    public List<ModuleInfoFroDischarge> getALLModuleInfoForDischargeByMediumStatus(String mediumStatus) {
        return moduleDao.getALLModuleInfoForDischargeByMediumStatus(mediumStatus);
    }

    @Override
    public Module getARepresentModule() {
        return moduleDao.getARepresentModule();
    }

    @Override
    public List<Module> getHasRepairModule() {
        return moduleDao.getHasRepairModule();
    }

}
