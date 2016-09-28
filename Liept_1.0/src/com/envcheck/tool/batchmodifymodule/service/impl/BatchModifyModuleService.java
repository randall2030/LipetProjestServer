package com.envcheck.tool.batchmodifymodule.service.impl;

import com.envcheck.base.bean.Module;
import com.envcheck.base.service.impl.BaseService;
import com.envcheck.tool.batchmodifymodule.bean.ModifyModuleInfo;
import com.envcheck.tool.batchmodifymodule.dao.IBatchModifyModuleDao;
import com.envcheck.tool.batchmodifymodule.service.IBatchModifyModuleService;

import java.util.List;

/**
 * Created by Administrator on 2016/5/27.
 */
public class BatchModifyModuleService extends BaseService<Module> implements IBatchModifyModuleService {
    private IBatchModifyModuleDao batchModifyModuleDao;

    public IBatchModifyModuleDao getBatchModifyModuleDao() {
        return batchModifyModuleDao;
    }
    public void setBatchModifyModuleDao(IBatchModifyModuleDao batchModifyModuleDao) {
        super.setBaseDao(batchModifyModuleDao);
        this.batchModifyModuleDao = batchModifyModuleDao;
    }

    @Override
    public void batchModify(List<ModifyModuleInfo> moduleInfos) {
        batchModifyModuleDao.batchModify(moduleInfos);
    }
}
