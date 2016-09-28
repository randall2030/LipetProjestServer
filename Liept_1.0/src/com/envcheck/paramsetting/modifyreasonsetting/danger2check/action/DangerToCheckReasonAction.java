package com.envcheck.paramsetting.modifyreasonsetting.danger2check.action;


import com.envcheck.base.action.BaseAction;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.modifyreasonsetting.danger2check.bean.DangerToCheckReason;
import com.envcheck.paramsetting.modifyreasonsetting.danger2check.service.IDangerToCheckReasonService;

import java.net.URLDecoder;
import java.util.Date;

/**
 * Created by Administrator on 2016/5/5.
 */
public class DangerToCheckReasonAction extends BaseAction {

    //封装数据
    private DangerToCheckReason dangerToCheckReason;
    public DangerToCheckReason getDangerToCheckReason() {
        return dangerToCheckReason;
    }
    public void setDangerToCheckReason(DangerToCheckReason dangerToCheckReason) {
        this.dangerToCheckReason = dangerToCheckReason;
    }

    //调用业务逻辑方法
    private IDangerToCheckReasonService dangerToCheckReasonService;
    public IDangerToCheckReasonService getDangerToCheckReasonService() {
        return dangerToCheckReasonService;
    }
    public void setDangerToCheckReasonService(IDangerToCheckReasonService dangerToCheckReasonService) {
        this.dangerToCheckReasonService = dangerToCheckReasonService;
    }

    /**
     * 列表展示
     */
    public String listUI(){

        try {
            QueryHelper qh = new QueryHelper(DangerToCheckReason.class, "d");
            //查询
            if(dangerToCheckReason != null && (dangerToCheckReason.getDangerToCheckReasonNumber() != null || dangerToCheckReason.getDangerToCheckReasonName() != null ))
            {
                //条件查询
                if (dangerToCheckReason.getDangerToCheckReasonNumber() != null){
                    dangerToCheckReason.setDangerToCheckReasonNumber(URLDecoder.decode(dangerToCheckReason.getDangerToCheckReasonNumber(),"utf-8"));
                    qh.addConditions("d.dangerToCheckReasonNumber like ?", "%" + dangerToCheckReason.getDangerToCheckReasonNumber() + "%");
                }
                if(dangerToCheckReason.getDangerToCheckReasonName() != null){
                    dangerToCheckReason.setDangerToCheckReasonName(URLDecoder.decode(dangerToCheckReason.getDangerToCheckReasonName(),"utf-8"));
                    qh.addConditions("d.dangerToCheckReasonName like ?", "%" + dangerToCheckReason.getDangerToCheckReasonName() + "%");
                }
            }

            pageResult = dangerToCheckReasonService.getPageResult(qh,  getPageNo(), getPageSize());
            //int a = 0;

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

        if(dangerToCheckReason != null){
            dangerToCheckReason.setCreateTime(new Date());
            dangerToCheckReason.setCreatePerson("haha");
            dangerToCheckReason.setModifyTime(new Date());
            dangerToCheckReason.setModifyPerson("haha");
            dangerToCheckReasonService.save(dangerToCheckReason);
        }
        return "list";
    }

    /**
     * 删除
     */
    public String delete(){

        if( dangerToCheckReason != null && dangerToCheckReason.getId() != null){
            dangerToCheckReasonService.delete(dangerToCheckReason.getId());
        }

        setPageNo(1);
        return "list";
    }

    /**
     * 进入修改页面
     */
    public String editUI(){
        //处理回显
        if(dangerToCheckReason != null && dangerToCheckReason.getId() != null)
        {
            dangerToCheckReason = dangerToCheckReasonService.findById(dangerToCheckReason.getId());


        }

        return "editUI";
    }


    /**
     * 修改
     * @return
     */
    public String edit(){

        if(dangerToCheckReason != null){
            dangerToCheckReason.setCreateTime(dangerToCheckReason.getCreateTime());
            dangerToCheckReason.setCreatePerson(dangerToCheckReason.getCreatePerson());
            dangerToCheckReason.setModifyTime(new Date());
            dangerToCheckReason.setModifyPerson("haha");
            dangerToCheckReasonService.update(dangerToCheckReason);
        }

        return "list";
    }

    /**
     * 批量删除
     */
    public String deleteSelected(){

        if(selectedRow != null){
            for(String id: selectedRow){
                dangerToCheckReasonService.delete(id);
            }
        }

        return "list";
    }

}
