package com.envcheck.view.checkinfo.dao.impl;

import com.envcheck.base.bean.ModuleCheck;
import com.envcheck.base.dao.BaseDao;
import com.envcheck.view.checkinfo.dao.IModuleCheckDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/5.
 */
public class ModuleCheckDao extends BaseDao<ModuleCheck> implements IModuleCheckDao {


    @Override
    public List<Long> getPPMAllocateByDeviceName(String deviceName) {

        List<Long> ppmAllocateList = new ArrayList<>();

        return ppmAllocateList;

    }
}
