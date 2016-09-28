package com.envcheck.scenemanage.weatherparam.bean;

import com.envcheck.scenemanage.calibrate.bean.CalibrationInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by susion on 2016/6/4.
 */
public class WeatherListFromServer {

    private List<WeatherParam> weatherInfoList = new ArrayList<>();

    public List<WeatherParam> getWeatherInfoList() {
        return weatherInfoList;
    }

    public void setWeatherInfoList(List<WeatherParam> weatherInfoList) {
        this.weatherInfoList = weatherInfoList;
    }
}
