package com.envcheck.tool.batchmodifycheck.service.impl;

import com.envcheck.base.bean.Module;
import com.envcheck.base.service.impl.BaseService;
import com.envcheck.tool.batchmodifycheck.dao.IBatchModifyCheckDao;
import com.envcheck.tool.batchmodifycheck.service.IBatchModifyCheckService;
import com.envcheck.tool.batchmodifymodule.bean.ModifyModuleInfo;

import java.util.List;

/**
 * Created by Administrator on 2016/5/29.
 */
public class BatchModifyCheckService extends BaseService<Module> implements IBatchModifyCheckService{

    private IBatchModifyCheckDao batchModifyCheckDao;

    @Override
    public void batchModify(List<ModifyModuleInfo> moduleInfos) {
        batchModifyCheckDao.batchModify(moduleInfos);
    }


    public IBatchModifyCheckDao getBatchModifyCheckDao() {
        return batchModifyCheckDao;
    }
    public void setBatchModifyCheckDao(IBatchModifyCheckDao batchModifyCheckDao) {
        super.setBaseDao(batchModifyCheckDao);
        this.batchModifyCheckDao = batchModifyCheckDao;
    }


}
