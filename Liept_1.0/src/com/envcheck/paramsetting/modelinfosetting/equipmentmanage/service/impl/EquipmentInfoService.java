package com.envcheck.paramsetting.modelinfosetting.equipmentmanage.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.paramsetting.modelinfosetting.equipmentmanage.bean.EquipmentInfo;
import com.envcheck.paramsetting.modelinfosetting.equipmentmanage.dao.IEquipmentInfoDao;
import com.envcheck.paramsetting.modelinfosetting.equipmentmanage.service.IEquipmentInfoService;

/**
 * Created by Administrator on 2016/5/7.
 */
public class EquipmentInfoService extends BaseService<EquipmentInfo> implements IEquipmentInfoService{
    private IEquipmentInfoDao equipmentInfoDao;

    public IEquipmentInfoDao getEquipmentInfoDao() {
        return equipmentInfoDao;
    }

    public void setEquipmentInfoDao(IEquipmentInfoDao equipmentInfoDao) {
        super.setBaseDao(equipmentInfoDao);
        this.equipmentInfoDao = equipmentInfoDao;
    }
}
