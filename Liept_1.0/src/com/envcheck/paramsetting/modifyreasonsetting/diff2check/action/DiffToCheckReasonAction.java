package com.envcheck.paramsetting.modifyreasonsetting.diff2check.action;


import com.envcheck.base.action.BaseAction;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.modifyreasonsetting.diff2check.bean.DiffToCheckReason;
import com.envcheck.paramsetting.modifyreasonsetting.diff2check.service.IDiffToCheckReasonService;

import java.net.URLDecoder;
import java.util.Date;

/**
 * Created by Administrator on 2016/5/5.
 */
public class DiffToCheckReasonAction extends BaseAction {

    //封装数据
    private DiffToCheckReason diffToCheckReason;
    public DiffToCheckReason getDiffToCheckReason() {
        return diffToCheckReason;
    }
    public void setDiffToCheckReason(DiffToCheckReason diffToCheckReason) {
        this.diffToCheckReason = diffToCheckReason;
    }

    //调用业务逻辑方法
    private IDiffToCheckReasonService diffToCheckReasonService;
    public IDiffToCheckReasonService getDiffToCheckReasonService() {
        return diffToCheckReasonService;
    }
    public void setDiffToCheckReasonService(IDiffToCheckReasonService diffToCheckReasonService) {
        this.diffToCheckReasonService = diffToCheckReasonService;
    }

    /**
     * 列表展示
     */
    public String listUI(){

        try {
            QueryHelper qh = new QueryHelper(DiffToCheckReason.class, "c");
            //查询
            if(diffToCheckReason != null && (diffToCheckReason.getDiffToCheckReasonName() != null ||diffToCheckReason.getDiffToCheckReasonNumber() != null))
            {
                //条件查询
                if (diffToCheckReason.getDiffToCheckReasonName() != null){
                    diffToCheckReason.setDiffToCheckReasonName(URLDecoder.decode(diffToCheckReason.getDiffToCheckReasonName(),"utf-8"));
                    qh.addConditions("c.diffToCheckReasonName like ?", "%" + diffToCheckReason.getDiffToCheckReasonName() + "%");
                }
                if (diffToCheckReason.getDiffToCheckReasonNumber() != null){
                    diffToCheckReason.setDiffToCheckReasonNumber(URLDecoder.decode(diffToCheckReason.getDiffToCheckReasonNumber(),"utf-8"));
                    qh.addConditions("c.diffToCheckReasonNumber like ?", "%" + diffToCheckReason.getDiffToCheckReasonNumber() + "%");
                }
            }

            pageResult = diffToCheckReasonService.getPageResult(qh,  getPageNo(), getPageSize());
            int a = 0;

        }catch (Exception e){

        }

        return "listUI";

    }

    /**
     * 跳转到添加页面
     */
    public String addUI(){
        return "addUI";
    }

    /**
     * 保存添加
     * @return
     */
    public String add(){

        if(diffToCheckReason != null){
            diffToCheckReason.setCreateTime(new Date());
            diffToCheckReason.setCreatePerson("haha");
            diffToCheckReason.setModifyTime(new Date());
            diffToCheckReason.setModifyPerson("haha");
            diffToCheckReasonService.save(diffToCheckReason);
        }
        return "list";
    }

    /**
     * 删除
     */
    public String delete(){

        if( diffToCheckReason != null && diffToCheckReason.getId() != null){
            diffToCheckReasonService.delete(diffToCheckReason.getId());
        }

        setPageNo(1);
        return "list";
    }

    /**
     * 进入修改页面
     */
    public String editUI(){
        //处理回显
        if(diffToCheckReason != null && diffToCheckReason.getId() != null)
        {
         diffToCheckReason =  diffToCheckReasonService.findById(diffToCheckReason.getId());

        }

        return "editUI";
    }


    /**
     * 修改
     * @return
     */
    public String edit(){

        if(diffToCheckReason != null){
            diffToCheckReason.setCreateTime(diffToCheckReason.getCreateTime());
            diffToCheckReason.setCreatePerson(diffToCheckReason.getCreatePerson());
            diffToCheckReason.setModifyTime(new Date());
            diffToCheckReason.setModifyPerson("haha");
            diffToCheckReasonService.update(diffToCheckReason);
        }

        return "list";
    }

    /**
     * 批量删除
     */
    public String deleteSelected(){

        if(selectedRow != null){
            for(String id: selectedRow){
                diffToCheckReasonService.delete(id);
            }
        }

        return "list";
    }



}
