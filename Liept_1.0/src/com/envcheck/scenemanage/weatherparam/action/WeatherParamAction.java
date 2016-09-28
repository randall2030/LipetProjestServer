package com.envcheck.scenemanage.weatherparam.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.scenemanage.weatherparam.bean.WeatherParam;
import com.envcheck.scenemanage.weatherparam.service.IWeatherParamService;

import java.net.URLDecoder;

/**
 * Created by susion on 2016/5/11.
 */
public class WeatherParamAction extends BaseAction{
    //封装数据
    private WeatherParam weatherParam;
    //调用业务逻辑方法
    private IWeatherParamService weatherParamService;


    public String listUI(){

        QueryHelper qh = new QueryHelper(WeatherParam.class, "w");
        //查询

      /*  if(weatherParam != null && (weatherParam.getCompanyNumber() != null || weatherParam.getDate() != null))
        {
            //条件查询
            if (weatherParam.getCompanyNumber() != null){
                qh.addConditions("w.companyNumber like ?", "%" + weatherParam.getCompanyNumber() + "%");
            }
            if (weatherParam.getDate() != null){
                qh.addConditions("w.date = ?", "%" + weatherParam.getDate() + "%");
            }
        }*/



        pageResult = weatherParamService.getPageResult(qh,  getPageNo(), getPageSize());

        return "listUI";
    }

    public WeatherParam getWeatherParam() {
        return weatherParam;
    }
    public void setWeatherParam(WeatherParam weatherParam) {
        this.weatherParam = weatherParam;
    }
    public IWeatherParamService getWeatherParamService() {
        return weatherParamService;
    }
    public void setWeatherParamService(IWeatherParamService weatherParamService) {
        this.weatherParamService = weatherParamService;
    }
}
