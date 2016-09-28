package com.envcheck.view.checkinfo.dao;

import com.envcheck.base.bean.ModuleCheck;
import com.envcheck.base.dao.IBaseDao;

import java.util.List;

/**
 * Created by Administrator on 2016/5/5.
 */
public interface IModuleCheckDao extends IBaseDao<ModuleCheck> {
    List<Long> getPPMAllocateByDeviceName(String deviceName);
}
