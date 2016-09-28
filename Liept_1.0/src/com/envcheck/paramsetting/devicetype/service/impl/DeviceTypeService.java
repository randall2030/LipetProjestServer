package com.envcheck.paramsetting.devicetype.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.paramsetting.devicetype.bean.DeviceType;
import com.envcheck.paramsetting.devicetype.dao.IDeviceTypeDao;
import com.envcheck.paramsetting.devicetype.service.IDeviceTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by susion on 2016/5/3.
 */
public class DeviceTypeService extends BaseService<DeviceType> implements IDeviceTypeService {

    private IDeviceTypeDao deviceTypeDao;

    public IDeviceTypeDao getDeviceTypeDao() {
        return deviceTypeDao;
    }

    @Resource
    public void setDeviceTypeDao(IDeviceTypeDao deviceTypeDao) {
        super.setBaseDao(deviceTypeDao);  //别忘了！！！！！！
        this.deviceTypeDao = deviceTypeDao;
    }
}
