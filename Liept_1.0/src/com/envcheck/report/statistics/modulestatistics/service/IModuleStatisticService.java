package com.envcheck.report.statistics.modulestatistics.service;

import com.envcheck.base.bean.Module;
import com.envcheck.base.service.IBaseService;
import com.envcheck.base.utils.QueryHelper;

/**
 * Created by Administrator on 2016/6/3.
 */
public interface IModuleStatisticService extends IBaseService<Module> {
    public long getAllNumber(QueryHelper qh);
}
