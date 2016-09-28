package com.envcheck.paramsetting.modelinfosetting.areamanage.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.dynamic_change_datasource.UserContextHolder;
import com.envcheck.base.utils.JsonUtils;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.modelinfosetting.areamanage.bean.AreaInfo;
import com.envcheck.paramsetting.modelinfosetting.areamanage.service.IAreaInfoService;
import com.google.gson.Gson;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;

/**
 * Created by susion on 2016/5/8.
 */
public class AreaInfoAction  extends BaseAction{
    //封装数据
    private AreaInfo areaInfo;

    public AreaInfo getAreaInfo() {
        return areaInfo;
    }

    public void setAreaInfo(AreaInfo areaInfo) {
        this.areaInfo = areaInfo;
    }

    //调用业务逻辑方法
    private IAreaInfoService areaInfoService;

    public IAreaInfoService getAreaInfoService() {
        return areaInfoService;
    }

    public void setAreaInfoService(IAreaInfoService areaInfoService) {
        this.areaInfoService = areaInfoService;
    }



    /**
     * 查询装置名称
     */
    public void findAreaName() throws IOException {

        List<String> deviceNameList;
        deviceNameList = areaInfoService.getAllAreaName();
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
            QueryHelper qh = new QueryHelper(AreaInfo.class, "c");
            //查询
            if(areaInfo != null && (areaInfo.getAreaNumber() != null || areaInfo.getAreaName()!=null || areaInfo.getDeviceName()!=null)){
                //条件查询
                if (areaInfo.getAreaNumber() != null){
                    areaInfo.setAreaNumber(URLDecoder.decode(areaInfo.getAreaNumber(),"utf-8"));
                    qh.addConditions("c.areaNumber like ?", "%" + areaInfo.getAreaNumber() + "%");
                }
                if (areaInfo.getAreaName()!=null){
                    areaInfo.setAreaName(URLDecoder.decode(areaInfo.getAreaName(),"utf-8"));
                    qh.addConditions("c.areaName like ?", "%" + areaInfo.getAreaName() + "%");
                }
                if (areaInfo.getDeviceName()!=null){
                    areaInfo.setDeviceName(URLDecoder.decode(areaInfo.getDeviceName(),"utf-8"));
                    qh.addConditions("c.deviceName like ?", "%" + areaInfo.getDeviceName() + "%");
                }
            }

            pageResult = areaInfoService.getPageResult(qh,  getPageNo(), getPageSize());
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

        if(areaInfo != null){
            areaInfo.setCreateTime(new Date());
            areaInfo.setCreatePerson(UserContextHolder.getCurrentUser().getUsername());
            areaInfo.setModifyTime(new Date());
            areaInfo.setModifyPerson(UserContextHolder.getCurrentUser().getUsername());
            areaInfoService.save(areaInfo);
        }
        return "list";
    }

    /**
     * 删除
     */
    public String delete(){

        if( areaInfo != null && areaInfo.getId() != null){
            areaInfoService.delete(areaInfo.getId());
        }

        setPageNo(1);
        return "list";
    }

    /**
     * 进入修改页面
     */
    public String editUI(){
        //处理回显
        if(areaInfo != null && areaInfo.getId() != null)
        {
            areaInfo = areaInfoService.findById(areaInfo.getId());

        }

        return "editUI";
    }

    /**
     * 修改
     * @return
     */
    public String edit(){

        if(areaInfo != null){
            areaInfoService.update(areaInfo);
        }

        return "list";
    }

    public String deleteSelected(){

        if(selectedRow != null){
            for(String id: selectedRow){
                areaInfoService.delete(id);
            }
        }

        return "list";
    }
}
