package com.envcheck.tool.batchmodifycheck.service;

import com.envcheck.base.bean.Module;
import com.envcheck.base.service.IBaseService;
import com.envcheck.tool.batchmodifymodule.bean.ModifyModuleInfo;

import java.util.List;

/**
 * Created by Administrator on 2016/5/29.
 */
public interface IBatchModifyCheckService extends IBaseService<Module> {

    /**
     * 批量修改
     */
    public void batchModify(List<ModifyModuleInfo> moduleInfos);
}
