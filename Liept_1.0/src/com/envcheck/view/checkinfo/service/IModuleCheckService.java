package com.envcheck.view.checkinfo.service;


import com.envcheck.base.bean.ModuleCheck;
import com.envcheck.base.service.IBaseService;

import java.util.List;

/**
 * Created by Administrator on 2016/5/5.
 */
public interface IModuleCheckService extends IBaseService<ModuleCheck> {
    List<Long> getPPMAllocateByDeviceName(String deviceName);
}
