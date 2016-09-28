package com.envcheck.scenemanage.weatherparam.bean;

import java.util.Date;

/**
 * Created by susion on 2016/5/4.
 */
public class WeatherParam  {

    //公司编号、日期、温度、湿度、气压、风向、风速、备注
    private String id;
    private String companyNumber;
    private String createTime;
    private String temperature;
    private String hnmidity;
    private String press;
    private String windDirection;
    private String windSpeed;
    private String note;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getHnmidity() {
        return hnmidity;
    }

    public void setHnmidity(String hnmidity) {
        this.hnmidity = hnmidity;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
