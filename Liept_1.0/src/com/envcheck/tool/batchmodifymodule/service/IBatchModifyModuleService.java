package com.envcheck.tool.batchmodifymodule.service;

import com.envcheck.base.bean.Module;
import com.envcheck.base.service.IBaseService;
import com.envcheck.tool.batchmodifymodule.bean.ModifyModuleInfo;

import java.util.List;

/**
 * Created by Administrator on 2016/5/27.
 */
public interface IBatchModifyModuleService extends IBaseService<Module> {

    /**
     * 批量修改
     */
    public void batchModify(List<ModifyModuleInfo> moduleInfos);

}
