package com.envcheck.paramsetting.modelinfosetting.areamanage.dao;

import com.envcheck.base.dao.IBaseDao;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.modelinfosetting.areamanage.bean.AreaInfo;

import java.util.List;

/**
 * Created by Administrator on 2016/5/5.
 */
public interface IAreaInfoDao extends IBaseDao<AreaInfo> {
    List<AreaInfo> findAreaByAreaName(QueryHelper areaHelper);

    List<String> getAllAreaName();
}
