package com.envcheck.paramsetting.modelinfosetting.devicemanage.dao.impl;

import com.envcheck.base.dao.BaseDao;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.modelinfosetting.devicemanage.bean.DeviceInfo;
import com.envcheck.paramsetting.modelinfosetting.devicemanage.dao.IDeviceInfoDao;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by Administrator on 2016/5/5.
 */
public class DeviceInfoDao extends BaseDao<DeviceInfo> implements IDeviceInfoDao {
    @Override
    public DeviceInfo findDeviceByDeviceName(QueryHelper helper) {

        Query query = sessionFactory.getCurrentSession().createQuery(helper.getQueryListHql());
        List<Object> list = helper.getQueryListParameters();

        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                query.setParameter(i, list.get(i));
            }
        }

        return (DeviceInfo) query.uniqueResult();
    }

    @Override
    public String getDeviceTypeByDeviceName(String deviceName) {

        String hql = "SELECT d.deviceType FROM DeviceInfo d WHERE d.deviceName=?";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        query.setString(0, deviceName);

        return (String) query.uniqueResult();

    }

    @Override
    public List<String> getAllDeviceName() {
        String hql = "SELECT d.deviceName FROM DeviceInfo d";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        return query.list();
    }
}
