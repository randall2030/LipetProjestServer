package com.envcheck.report.statistics.modulestatistics.service.impl;

import com.envcheck.base.bean.Module;
import com.envcheck.base.service.impl.BaseService;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.report.statistics.modulestatistics.dao.IModuleStatisticDao;
import com.envcheck.report.statistics.modulestatistics.service.IModuleStatisticService;

/**
 * Created by Administrator on 2016/6/3.
 */
public class ModuleStatisticService extends BaseService<Module> implements IModuleStatisticService {

    private IModuleStatisticDao moduleStatisticDao;

    public IModuleStatisticDao getModuleStatisticDao() {
        return moduleStatisticDao;
    }
    public void setModuleStatisticDao(IModuleStatisticDao moduleStatisticDao) {
        super.setBaseDao(moduleStatisticDao);
        this.moduleStatisticDao = moduleStatisticDao;
    }

    @Override
    public long getAllNumber(QueryHelper qh) {
        return moduleStatisticDao.getAllNumber(qh);
    }
}
