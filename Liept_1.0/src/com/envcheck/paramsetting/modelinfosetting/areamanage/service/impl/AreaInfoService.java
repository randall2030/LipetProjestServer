package com.envcheck.paramsetting.modelinfosetting.areamanage.service.impl;

import com.envcheck.base.dynamic_change_datasource.DataSourceConstant;
import com.envcheck.base.dynamic_change_datasource.DataSourceContextHolder;
import com.envcheck.base.dynamic_change_datasource.DynamicDataSourceUtils;
import com.envcheck.base.dynamic_change_datasource.UserContextHolder;
import com.envcheck.base.service.impl.BaseService;
import com.envcheck.base.utils.Constant;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.base.utils.StringUtils;
import com.envcheck.paramsetting.modelinfosetting.areamanage.bean.AreaInfo;
import com.envcheck.paramsetting.modelinfosetting.areamanage.dao.IAreaInfoDao;
import com.envcheck.paramsetting.modelinfosetting.areamanage.service.IAreaInfoService;

import java.util.List;

/**
 * Created by Administrator on 2016/5/7.
 */
public class AreaInfoService extends BaseService<AreaInfo> implements IAreaInfoService{
    private IAreaInfoDao areaInfoDao;

    public IAreaInfoDao getAreaInfoDao() {
        return areaInfoDao;
    }

    public void setAreaInfoDao(IAreaInfoDao areaInfoDao) {
        super.setBaseDao(areaInfoDao);
        this.areaInfoDao = areaInfoDao;
    }

    @Override
    public List<AreaInfo> findAreaByAreaName(QueryHelper areaHelper) {
        DynamicDataSourceUtils.changeToLocalDatabase();
        return areaInfoDao.findAreaByAreaName(areaHelper);
    }

    @Override
    public List<String> getAllAreaName() {
        DynamicDataSourceUtils.changeToLocalDatabase();
        return areaInfoDao.getAllAreaName();
    }
}
