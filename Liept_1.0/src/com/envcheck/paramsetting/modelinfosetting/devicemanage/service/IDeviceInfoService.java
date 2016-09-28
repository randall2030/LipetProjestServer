package com.envcheck.paramsetting.modelinfosetting.devicemanage.service;

import com.envcheck.base.service.IBaseService;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.modelinfosetting.devicemanage.bean.DeviceInfo;

import java.util.List;

/**
 * Created by Administrator on 2016/5/7.
 */
public interface IDeviceInfoService extends IBaseService<DeviceInfo> {
    DeviceInfo findDeviceByDeviceName(QueryHelper helper);

    String getDeviceTypeByDeviceName(String deviceName);

    List<String> getAllDeviceName();
}
