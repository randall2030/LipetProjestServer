package com.envcheck.paramsetting.devicetype.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.devicetype.bean.DeviceType;
import com.envcheck.paramsetting.devicetype.service.IDeviceTypeService;

import java.net.URLDecoder;

/**
 * Created by susion on 2016/5/5.
 */
public class DeviceTypeAction extends BaseAction {

    private IDeviceTypeService deviceTypeService;
    private DeviceType deviceType;


    public String listUI(){

        try {

            QueryHelper qh = new QueryHelper(DeviceType.class, "d");

            if(deviceType != null && deviceType.getDeviceTypeNumber() != null)
            {
                if(deviceType.getDeviceTypeNumber() != null){
                    deviceType.setDeviceTypeNumber(URLDecoder.decode(deviceType.getDeviceTypeNumber(),"utf-8"));
                    qh.addConditions("d.deviceTypeNumber like ?", "%" + deviceType.getDeviceTypeNumber() + "%");
                }
            }

            pageResult = deviceTypeService.getPageResult(qh,  getPageNo(), getPageSize());

        }catch (Exception e){

        }

        return "listUI";

    }

    public String addUI(){
        return "addUI";
    }

    public String add(){
        if(deviceType != null){
            deviceTypeService.save(deviceType);
        }
        return "list";
    }

    public String delete(){
        if( deviceType != null && deviceType.getId() != null){
            String id = deviceType.getId();
            deviceTypeService.delete(id);
        }
        setPageNo(1);
        return "list";
    }

    public String editUI(){
        //处理回显
        if(deviceType != null && deviceType.getId() != null)
        {
            deviceType = deviceTypeService.findById(deviceType.getId());
        }

        return "editUI";
    }


    public String edit(){

        if(deviceType != null){
            deviceTypeService.update(deviceType);
        }

        return "list";
    }

    public String deleteSelected(){

        if(selectedRow != null){
            for(String id: selectedRow){
                deviceTypeService.delete(id);
            }
        }

        return "list";
    }



    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public IDeviceTypeService getDeviceTypeService() {
        return deviceTypeService;
    }

    public void setDeviceTypeService(IDeviceTypeService deviceTypeService) {
        this.deviceTypeService = deviceTypeService;
    }
}
