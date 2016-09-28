package com.envcheck.report.statistics.modulestatistics.dao;

import com.envcheck.base.bean.Module;
import com.envcheck.base.dao.IBaseDao;
import com.envcheck.base.utils.QueryHelper;

/**
 * Created by Administrator on 2016/6/3.
 */
public interface IModuleStatisticDao extends IBaseDao<Module> {
    public long getAllNumber(QueryHelper qh);
}
