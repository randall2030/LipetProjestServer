package com.envcheck.paramsetting.modelinfosetting.areamanage.service;

import com.envcheck.base.service.IBaseService;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.modelinfosetting.areamanage.bean.AreaInfo;

import java.util.List;

/**
 * Created by Administrator on 2016/5/7.
 */
public interface IAreaInfoService extends IBaseService<AreaInfo> {

    List<AreaInfo> findAreaByAreaName(QueryHelper areaHelper);

    List<String> getAllAreaName();
}
