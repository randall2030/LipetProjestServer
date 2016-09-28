package com.envcheck.view.checkinfo.service.impl;


import com.envcheck.base.bean.ModuleCheck;
import com.envcheck.base.service.impl.BaseService;
import com.envcheck.view.checkinfo.dao.IModuleCheckDao;
import com.envcheck.view.checkinfo.service.IModuleCheckService;

import java.util.List;

/**
 * Created by Administrator on 2016/5/5.
 */
public class ModuleCheckService extends BaseService<ModuleCheck> implements IModuleCheckService {

    private IModuleCheckDao moduleCheckDao;

    public IModuleCheckDao getModuleCheckDao() {
        return moduleCheckDao;
    }

    public void setModuleCheckDao(IModuleCheckDao moduleCheckDao) {
        super.setBaseDao(moduleCheckDao);
        this.moduleCheckDao = moduleCheckDao;
    }

    @Override
    public List<Long> getPPMAllocateByDeviceName(String deviceName) {
        return  moduleCheckDao.getPPMAllocateByDeviceName(deviceName);
    }
}
