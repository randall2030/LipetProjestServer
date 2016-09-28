package com.envcheck.paramsetting.modelinfosetting.devicemanage.dao;

import com.envcheck.base.dao.IBaseDao;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.modelinfosetting.devicemanage.bean.DeviceInfo;

import java.util.List;

/**
 * Created by Administrator on 2016/5/5.
 */
public interface IDeviceInfoDao extends IBaseDao<DeviceInfo> {
    DeviceInfo findDeviceByDeviceName(QueryHelper helper);

    String getDeviceTypeByDeviceName(String deviceName);

    List<String> getAllDeviceName();
}
