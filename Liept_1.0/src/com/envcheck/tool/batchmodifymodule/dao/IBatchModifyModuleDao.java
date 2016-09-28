package com.envcheck.tool.batchmodifymodule.dao;

import com.envcheck.base.bean.Module;
import com.envcheck.base.dao.IBaseDao;
import com.envcheck.tool.batchmodifymodule.bean.ModifyModuleInfo;

import java.util.List;

/**
 * Created by Administrator on 2016/5/27.
 */
public interface IBatchModifyModuleDao extends IBaseDao<Module> {
    public void batchModify(List<ModifyModuleInfo> moduleInfos);
}
