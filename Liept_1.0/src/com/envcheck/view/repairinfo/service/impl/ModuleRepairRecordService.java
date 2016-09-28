package com.envcheck.view.repairinfo.service.impl;


import com.envcheck.base.bean.ModuleRepairRecord;
import com.envcheck.base.service.impl.BaseService;
import com.envcheck.view.repairinfo.dao.IModuleRepairRecordDao;
import com.envcheck.view.repairinfo.service.IModuleRepairRecordService;

import java.util.List;

/**
 * Created by Administrator on 2016/5/5.
 */
public class ModuleRepairRecordService extends BaseService<ModuleRepairRecord> implements IModuleRepairRecordService {

    private IModuleRepairRecordDao moduleRepairRecordDao;

    public IModuleRepairRecordDao getModuleRepairRecordDao() {
        return moduleRepairRecordDao;
    }

    public void setModuleRepairRecordDao(IModuleRepairRecordDao moduleRepairRecordDao) {
        super.setBaseDao(moduleRepairRecordDao);
        this.moduleRepairRecordDao = moduleRepairRecordDao;
    }
}
