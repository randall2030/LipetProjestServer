package com.envcheck.paramsetting.modifyreasonsetting.delay2repair.action;


import com.envcheck.base.action.BaseAction;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.modifyreasonsetting.delay2repair.bean.DelayRepairReason;
import com.envcheck.paramsetting.modifyreasonsetting.delay2repair.service.IDelayRepairReasonService;

import java.net.URLDecoder;
import java.util.Date;

/**
 * Created by Administrator on 2016/5/5.
 */
public class DelayRepairReasonAction extends BaseAction {

    //封装数据
    private DelayRepairReason delayRepairReason;
    public DelayRepairReason getDelayRepairReason() {
        return delayRepairReason;
    }
    public void setDelayRepairReason(DelayRepairReason delayRepairReason) {
        this.delayRepairReason = delayRepairReason;
    }

    //调用业务逻辑方法
    private IDelayRepairReasonService delayRepairReasonService;
    public IDelayRepairReasonService getDelayRepairReasonService() {
        return delayRepairReasonService;
    }
    public void setDelayRepairReasonService(IDelayRepairReasonService delayRepairReasonService) {
        this.delayRepairReasonService = delayRepairReasonService;
    }

    /**
     * 列表展示
     */
    public String listUI(){

        try {
            QueryHelper qh = new QueryHelper(DelayRepairReason.class, "c");
            //查询
            if(delayRepairReason != null && (delayRepairReason.getDelayRepairReasonName() != null ||delayRepairReason.getDelayRepairReasonNumber() != null))
            {
               if (delayRepairReason.getDelayRepairReasonName() != null){
                   delayRepairReason.setDelayRepairReasonName(URLDecoder.decode(delayRepairReason.getDelayRepairReasonName(),"utf-8"));
                   qh.addConditions("c.delayRepairReasonName like ?", "%" + delayRepairReason.getDelayRepairReasonName() + "%");
               }
                if (delayRepairReason.getDelayRepairReasonNumber() != null){
                    delayRepairReason.setDelayRepairReasonNumber(URLDecoder.decode(delayRepairReason.getDelayRepairReasonNumber(),"utf-8"));
                    qh.addConditions("c.delayRepairReasonNumber like ?", "%" + delayRepairReason.getDelayRepairReasonNumber() + "%");
               }
            }

            pageResult = delayRepairReasonService.getPageResult(qh,  getPageNo(), getPageSize());
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

        if(delayRepairReason != null){
            delayRepairReason.setCreateTime(new Date());
            delayRepairReason.setCreatePerson("haha");
            delayRepairReason.setModifyTime(new Date());
            delayRepairReason.setModifyPerson("haha");
            delayRepairReasonService.save(delayRepairReason);
        }
        return "list";
    }

    /**
     * 删除
     */
    public String delete(){

        if( delayRepairReason != null && delayRepairReason.getId() != null){
            delayRepairReasonService.delete(delayRepairReason.getId());
        }

        setPageNo(1);
        return "list";
    }

    /**
     * 进入修改页面
     */
    public String editUI(){
        //处理回显
        if(delayRepairReason != null && delayRepairReason.getId() != null)
        {
            delayRepairReason =  delayRepairReasonService.findById(delayRepairReason.getId());
        }

        return "editUI";
    }


    /**
     * 修改
     * @return
     */
    public String edit(){

        if(delayRepairReason != null){
            delayRepairReason.setCreateTime(delayRepairReason.getCreateTime());
            delayRepairReason.setCreatePerson(delayRepairReason.getCreatePerson());
            delayRepairReason.setModifyTime(new Date());
            delayRepairReason.setModifyPerson("haha");
            delayRepairReasonService.update(delayRepairReason);
        }

        return "list";
    }
    /**
     * 批量删除
     */
    public String deleteSelected(){

        if(selectedRow != null){
            for(String id: selectedRow){
                delayRepairReasonService.delete(id);
            }
        }

        return "list";
    }


}
