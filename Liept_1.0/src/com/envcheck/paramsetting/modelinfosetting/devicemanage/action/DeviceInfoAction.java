package com.envcheck.paramsetting.modelinfosetting.devicemanage.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.dynamic_change_datasource.UserContextHolder;
import com.envcheck.base.utils.JsonUtils;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.modelinfosetting.devicemanage.bean.DeviceInfo;
import com.envcheck.paramsetting.modelinfosetting.devicemanage.service.IDeviceInfoService;
import com.google.gson.Gson;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/5/7.
 */
public class DeviceInfoAction extends BaseAction {
    //封装数据
    private DeviceInfo deviceInfo;

    public DeviceInfo getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(DeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    //调用业务逻辑方法
    private IDeviceInfoService deviceInfoService;

    public IDeviceInfoService getDeviceInfoService() {
        return deviceInfoService;
    }

    public void setDeviceInfoService(IDeviceInfoService deviceInfoService) {
        this.deviceInfoService = deviceInfoService;
    }

    /**
     * 查询装置名称
     */
    public void findDeviceName() throws IOException {

        List<String> deviceNameList;
        deviceNameList = deviceInfoService.getAllDeviceName();

        Gson gson = new Gson();
        String jsonStr = gson.toJson(deviceNameList);
        PrintWriter writer = ServletActionContext.getResponse().getWriter();
        writer.write(jsonStr);
        writer.close();

    }
    /**
     * 列表展示
     */
    public String listUI(){

        try {
            QueryHelper qh = new QueryHelper(DeviceInfo.class, "c");
            //查询
            if(deviceInfo != null && (deviceInfo.getDeviceNumber() != null || deviceInfo.getDeviceName()!=null || deviceInfo.getDeviceType()!=null) ){
                //条件查询
                if (deviceInfo.getDeviceNumber() != null){
                    deviceInfo.setDeviceNumber(URLDecoder.decode(deviceInfo.getDeviceNumber(),"utf-8"));
                     qh.addConditions("c.deviceNumber like ?", "%" + deviceInfo.getDeviceNumber() + "%");
                }
                if (deviceInfo.getDeviceName()!=null){
                    deviceInfo.setDeviceName(URLDecoder.decode(deviceInfo.getDeviceName(),"utf-8"));
                    qh.addConditions("c.deviceName like ?", "%" + deviceInfo.getDeviceName() + "%");
                }
                if (deviceInfo.getDeviceType()!=null){
                    deviceInfo.setDeviceType(URLDecoder.decode(deviceInfo.getDeviceType(),"utf-8"));
                    qh.addConditions("c.deviceType like ?", "%" + deviceInfo.getDeviceType() + "%");
                }
            }

            pageResult = deviceInfoService.getPageResult(qh,  getPageNo(), getPageSize());
            int a = 0;

        }catch (Exception e){

        }

        return "listUI";

    }

    /**
     * 添加
     */
    public String addUI(){
        return "addUI";
    }

    public String add(){

        if(deviceInfo != null){
            deviceInfoService.save(deviceInfo);
        }
        return "list";
    }

    /**
     * 删除
     */
    public String delete(){

        if( deviceInfo != null && deviceInfo.getId() != null){
            deviceInfoService.delete(deviceInfo.getId());
        }

        setPageNo(1);
        return "list";
    }

    /**
     * 进入修改页面
     */
    public String editUI(){
        //处理回显
        if(deviceInfo != null && deviceInfo.getId() != null)
        {

           deviceInfo =  deviceInfoService.findById(deviceInfo.getId());
        }

        return "editUI";
    }


    /**
     * 修改
     * @return
     */
    public String edit(){

        if(deviceInfo != null){
            deviceInfoService.update(deviceInfo);
        }


        return "list";
    }


    public String deleteSelected(){

        if(selectedRow != null){
            for(String id: selectedRow){
                deviceInfoService.delete(id);
            }
        }

        return "list";
    }
}
