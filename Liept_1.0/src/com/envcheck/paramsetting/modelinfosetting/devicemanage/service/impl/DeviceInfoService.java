package com.envcheck.paramsetting.modelinfosetting.devicemanage.service.impl;

import com.envcheck.base.dynamic_change_datasource.DataSourceConstant;
import com.envcheck.base.dynamic_change_datasource.DataSourceContextHolder;
import com.envcheck.base.dynamic_change_datasource.DynamicDataSourceUtils;
import com.envcheck.base.dynamic_change_datasource.UserContextHolder;
import com.envcheck.base.service.impl.BaseService;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.base.utils.StringUtils;
import com.envcheck.paramsetting.modelinfosetting.devicemanage.bean.DeviceInfo;
import com.envcheck.paramsetting.modelinfosetting.devicemanage.dao.IDeviceInfoDao;
import com.envcheck.paramsetting.modelinfosetting.devicemanage.service.IDeviceInfoService;

import java.util.List;

/**
 * Created by Administrator on 2016/5/7.
 */
public class DeviceInfoService extends BaseService<DeviceInfo> implements IDeviceInfoService {
    private IDeviceInfoDao deviceInfoDao;

    public IDeviceInfoDao getDeviceInfoDao() {
        return deviceInfoDao;
    }

    public void setDeviceInfoDao(IDeviceInfoDao deviceInfoDao) {
        super.setBaseDao(deviceInfoDao);
        this.deviceInfoDao = deviceInfoDao;
    }

    @Override
    public DeviceInfo findDeviceByDeviceName(QueryHelper helper) {
        DynamicDataSourceUtils.changeToLocalDatabase();
        return deviceInfoDao.findDeviceByDeviceName(helper);
    }

    @Override
    public String getDeviceTypeByDeviceName(String deviceName) {

        //切换为本地数据库
        DynamicDataSourceUtils.changeToLocalDatabase();

        return deviceInfoDao.getDeviceTypeByDeviceName(deviceName);
    }

    @Override
    public List<String> getAllDeviceName() {
        //切换为本地数据库
        DynamicDataSourceUtils.changeToLocalDatabase();
        return deviceInfoDao.getAllDeviceName();
    }

}
