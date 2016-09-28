package com.envcheck.scenemanage.weatherparam.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.scenemanage.weatherparam.bean.WeatherParam;
import com.envcheck.scenemanage.weatherparam.dao.IWeatherParamDao;
import com.envcheck.scenemanage.weatherparam.service.IWeatherParamService;

/**
 * Created by Administrator on 2016/5/18.
 */
public class WeatherParamService extends BaseService<WeatherParam> implements IWeatherParamService {
    private IWeatherParamDao weatherParamDao;

    public IWeatherParamDao getWeatherParamDao() {
        return weatherParamDao;
    }

    public void setWeatherParamDao(IWeatherParamDao weatherParamDao) {
        super.setBaseDao(weatherParamDao);
        this.weatherParamDao = weatherParamDao;
    }
}
