package com.envcheck.paramsetting.modifyreasonsetting.no2repair.action;


import com.envcheck.base.action.BaseAction;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.modifyreasonsetting.no2repair.bean.NoNeedRepairReason;
import com.envcheck.paramsetting.modifyreasonsetting.no2repair.service.INoNeedRepairReasonService;

import java.net.URLDecoder;
import java.util.Date;

/**
 * Created by Administrator on 2016/5/5.
 */
public class NoNeedRepairReasonAction extends BaseAction {

    //封装数据
    private NoNeedRepairReason noNeedRepairReason;
    public NoNeedRepairReason getNoNeedRepairReason() {
        return noNeedRepairReason;
    }
    public void setNoNeedRepairReason(NoNeedRepairReason noNeedRepairReason) {
        this.noNeedRepairReason = noNeedRepairReason;
    }

    //调用业务逻辑方法
    private INoNeedRepairReasonService noNeedRepairReasonService;
    public INoNeedRepairReasonService getNoNeedRepairReasonService() {
        return noNeedRepairReasonService;
    }
    public void setNoNeedRepairReasonService(INoNeedRepairReasonService noNeedRepairReasonService) {
        this.noNeedRepairReasonService = noNeedRepairReasonService;
    }

    /**
     * 列表展示
     */
    public String listUI(){

        try {
            QueryHelper qh = new QueryHelper(NoNeedRepairReason.class, "c");
            //查询
            if(noNeedRepairReason != null && (noNeedRepairReason.getNoNeedRepairReasonName() != null ||noNeedRepairReason.getNoNeedRepairReasonNumber() != null))
            {
                //条件查询
                if (noNeedRepairReason.getNoNeedRepairReasonName() != null){
                    noNeedRepairReason.setNoNeedRepairReasonName(URLDecoder.decode(noNeedRepairReason.getNoNeedRepairReasonName(),"utf-8"));
                    qh.addConditions("c.noNeedRepairReasonName like ?", "%" + noNeedRepairReason.getNoNeedRepairReasonName() + "%");
                }
                if (noNeedRepairReason.getNoNeedRepairReasonNumber() != null){
                    noNeedRepairReason.setNoNeedRepairReasonNumber(URLDecoder.decode(noNeedRepairReason.getNoNeedRepairReasonNumber(),"utf-8"));
                    qh.addConditions("c.noNeedRepairReasonNumber like ?", "%" + noNeedRepairReason.getNoNeedRepairReasonNumber() + "%");
                }
            }

            pageResult = noNeedRepairReasonService.getPageResult(qh,  getPageNo(), getPageSize());
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

        if(noNeedRepairReason != null){
            noNeedRepairReason.setCreateTime(new Date());
            noNeedRepairReason.setCreatePerson("haha");
            noNeedRepairReason.setModifyTime(new Date());
            noNeedRepairReason.setModifyPerson("haha");
            noNeedRepairReasonService.save(noNeedRepairReason);
        }
        return "list";
    }

    /**
     * 删除
     */
    public String delete(){

        if( noNeedRepairReason != null && noNeedRepairReason.getId() != null){
            noNeedRepairReasonService.delete(noNeedRepairReason.getId());
        }

        setPageNo(1);
        return "list";
    }

    /**
     * 进入修改页面
     */
    public String editUI(){
        //处理回显
        if(noNeedRepairReason != null && noNeedRepairReason.getId() != null)
        {
            noNeedRepairReason = noNeedRepairReasonService.findById(this.noNeedRepairReason.getId());
        }

        return "editUI";
    }


    /**
     * 修改
     * @return
     */
    public String edit(){

        if(noNeedRepairReason != null){
            noNeedRepairReason.setCreateTime(noNeedRepairReason.getCreateTime());
            noNeedRepairReason.setCreatePerson(noNeedRepairReason.getCreatePerson());
            noNeedRepairReason.setModifyTime(new Date());
            noNeedRepairReason.setModifyPerson("haha");
            noNeedRepairReasonService.update(noNeedRepairReason);
        }

        return "list";
    }
    /**
     * 批量删除
     */
    public String deleteSelected(){

        if(selectedRow != null){
            for(String id: selectedRow){
                noNeedRepairReasonService.delete(id);
            }
        }

        return "list";
    }


}
