package com.envcheck.paramsetting.modelinfosetting.equipmentmanage.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.utils.JsonUtils;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.modelinfosetting.equipmentmanage.bean.EquipmentInfo;
import com.envcheck.paramsetting.modelinfosetting.equipmentmanage.service.IEquipmentInfoService;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;


/**
 * Created by Administrator on 2016/5/7.
 */
public class EquipmentInfoAction extends BaseAction {
    //封装数据
    private EquipmentInfo equipmentInfo;

    public EquipmentInfo getEquipmentInfo() {
        return equipmentInfo;
    }

    public void setEquipmentInfo(EquipmentInfo equipmentInfo) {
        this.equipmentInfo = equipmentInfo;
    }

    //调用业务逻辑方法
    private IEquipmentInfoService equipmentInfoService;

    public IEquipmentInfoService getEquipmentInfoService() {
        return equipmentInfoService;
    }

    public void setEquipmentInfoService(IEquipmentInfoService equipmentInfoService) {
        this.equipmentInfoService = equipmentInfoService;
    }

    /**
     * 列表展示
     */
    public String listUI(){

        try {
            QueryHelper qh = new QueryHelper(EquipmentInfo.class, "c");
            //查询
            if(equipmentInfo != null && (equipmentInfo.getEquipmentNumber() != null || equipmentInfo.getEquipmentName()!=null )){
                //条件查询
                if (equipmentInfo.getEquipmentNumber() != null ){
                    equipmentInfo.setEquipmentNumber(URLDecoder.decode(equipmentInfo.getEquipmentNumber(),"utf-8"));
                    qh.addConditions("c.equipmentNumber like ?", "%" + equipmentInfo.getEquipmentNumber() + "%");
                }
                if (equipmentInfo.getEquipmentName()!=null){
                    equipmentInfo.setEquipmentName(URLDecoder.decode(equipmentInfo.getEquipmentName(),"utf-8"));
                    qh.addConditions("c.equipmentName like ?", "%" + equipmentInfo.getEquipmentName() + "%");
                }
            }

            pageResult = equipmentInfoService.getPageResult(qh,  getPageNo(), getPageSize());

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

        if(equipmentInfo != null){
        }
        return "list";
    }

    /**
     * 删除
     */
    public String delete(){

        if( equipmentInfo != null && equipmentInfo.getId() != null){
            equipmentInfoService.delete(equipmentInfo.getId());
        }

        setPageNo(1);
        return "list";
    }

    /**
     * 进入修改页面
     */
    public String editUI(){
        //处理回显
        if(equipmentInfo != null && equipmentInfo.getId() != null)
        {
           equipmentInfo =  equipmentInfoService.findById( equipmentInfo.getId());

        }

        return "editUI";
    }


    /**
     * 修改
     * @return
     */
    public String edit(){

        if(equipmentInfo != null){
            equipmentInfo.setCreateTime(equipmentInfo.getCreateTime());
            equipmentInfo.setCreatePerson(equipmentInfo.getCreatePerson());
            equipmentInfo.setModifyTime(new Date());
            equipmentInfo.setModifyPerson("haha");
            equipmentInfoService.update(equipmentInfo);
        }

        return "list";
    }
    public String deleteSelected(){

        if(selectedRow != null){
            for(String id: selectedRow){
                equipmentInfoService.delete(id);
            }
        }

        return "list";
    }
}
