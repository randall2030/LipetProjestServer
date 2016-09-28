package com.envcheck.paramsetting.modifyreasonsetting.temp2move.action;


import com.envcheck.base.action.BaseAction;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.modifyreasonsetting.temp2move.bean.TempMoveReason;
import com.envcheck.paramsetting.modifyreasonsetting.temp2move.service.ITempMoveReasonService;

import java.net.URLDecoder;
import java.util.Date;

/**
 * Created by Administrator on 2016/5/5.
 */
public class TempMoveReasonAction extends BaseAction {

    //封装数据
    private TempMoveReason tempMoveReason;
    public TempMoveReason getTempMoveReason() {
        return tempMoveReason;
    }
    public void setTempMoveReason(TempMoveReason tempMoveReason) {
        this.tempMoveReason = tempMoveReason;
    }

    //调用业务逻辑方法
    private ITempMoveReasonService tempMoveReasonService;
    public ITempMoveReasonService getTempMoveReasonService() {
        return tempMoveReasonService;
    }
    public void setTempMoveReasonService(ITempMoveReasonService tempMoveReasonService) {
        this.tempMoveReasonService = tempMoveReasonService;
    }

    /**
     * 列表展示
     */
    public String listUI(){

        try {
            QueryHelper qh = new QueryHelper(TempMoveReason.class, "c");
            //查询
            if(tempMoveReason != null && (tempMoveReason.getTempMoveReasonName() != null ||tempMoveReason.getTempMoveReasonNumber() != null))
            {
                //条件查询
                if(tempMoveReason.getTempMoveReasonName() != null){
                    tempMoveReason.setTempMoveReasonName(URLDecoder.decode(tempMoveReason.getTempMoveReasonName(),"utf-8"));
                    qh.addConditions("c.tempMoveReasonName like ?", "%" + tempMoveReason.getTempMoveReasonName() + "%");
                }
                if (tempMoveReason.getTempMoveReasonNumber() != null){
                    tempMoveReason.setTempMoveReasonNumber(URLDecoder.decode(tempMoveReason.getTempMoveReasonNumber(),"utf-8"));
                    qh.addConditions("c.tempMoveReasonNumber like ?", "%" + tempMoveReason.getTempMoveReasonNumber() + "%");
                }
            }

            pageResult = tempMoveReasonService.getPageResult(qh,  getPageNo(), getPageSize());
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

        if(tempMoveReason != null){
            tempMoveReason.setCreateTime(new Date());
            tempMoveReason.setCreatePerson("haha");
            tempMoveReason.setModifyTime(new Date());
            tempMoveReason.setModifyPerson("haha");
            tempMoveReasonService.save(tempMoveReason);
        }
        return "list";
    }

    /**
     * 删除
     */
    public String delete(){

        if( tempMoveReason != null && tempMoveReason.getId() != null){
            tempMoveReasonService.delete(tempMoveReason.getId());
        }

        setPageNo(1);
        return "list";
    }

    /**
     * 进入修改页面
     */
    public String editUI(){
        //处理回显
        if(tempMoveReason != null && tempMoveReason.getId() != null)
        {
           tempMoveReason =  tempMoveReasonService.findById(tempMoveReason.getId());

        }

        return "editUI";
    }


    /**
     * 修改
     * @return
     */
    public String edit(){

        if(tempMoveReason != null){
            tempMoveReason.setCreateTime(tempMoveReason.getCreateTime());
            tempMoveReason.setCreatePerson(tempMoveReason.getCreatePerson());
            tempMoveReason.setModifyTime(new Date());
            tempMoveReason.setModifyPerson("haha");
            tempMoveReasonService.update(tempMoveReason);
        }

        return "list";
    }
    /**
     * 批量删除
     */
    public String deleteSelected(){

        if(selectedRow != null){
            for(String id: selectedRow){
                tempMoveReasonService.delete(id);
            }
        }

        return "list";
    }

}
