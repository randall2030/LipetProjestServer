package com.envcheck.paramsetting.modifyreasonsetting.modelmodify.action;


import com.envcheck.base.action.BaseAction;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.modifyreasonsetting.modelmodify.service.IModelModifyReasonService;
import com.envcheck.paramsetting.modifyreasonsetting.modelmodify.bean.ModelModifyReason;

import java.net.URLDecoder;
import java.util.Date;

/**
 * Created by Administrator on 2016/5/5.
 */
public class ModelModifyReasonAction extends BaseAction {

    //封装数据
    private ModelModifyReason modelModifyReason;
    public ModelModifyReason getModelModifyReason() {
        return modelModifyReason;
    }
    public void setModelModifyReason(ModelModifyReason modelModifyReason) {
        this.modelModifyReason = modelModifyReason;
    }

    //调用业务逻辑方法
    private IModelModifyReasonService modelModifyReasonService;
    public IModelModifyReasonService getModelModifyReasonService() {
        return modelModifyReasonService;
    }
    public void setModelModifyReasonService(IModelModifyReasonService modelModifyReasonService) {
        this.modelModifyReasonService = modelModifyReasonService;
    }

    /**
     * 列表展示
     */
    public String listUI(){

        try {
            QueryHelper qh = new QueryHelper(ModelModifyReason.class, "c");
            //查询
            if(modelModifyReason != null && (modelModifyReason.getModifyReasonName() != null ||modelModifyReason.getModifyReasonNumber() != null))
            {
                //条件查询
                if (modelModifyReason.getModifyReasonName() != null){
                    modelModifyReason.setModifyReasonName(URLDecoder.decode(modelModifyReason.getModifyReasonName(),"utf-8"));
                    qh.addConditions("c.modifyReasonName like ?", "%" + modelModifyReason.getModifyReasonName() + "%");
                }
                if (modelModifyReason.getModifyReasonNumber() != null){
                    modelModifyReason.setModifyReasonNumber(URLDecoder.decode(modelModifyReason.getModifyReasonNumber(),"utf-8"));
                    qh.addConditions("c.modifyReasonNumber like ?", "%" + modelModifyReason.getModifyReasonNumber() + "%");
                }
            }

            pageResult = modelModifyReasonService.getPageResult(qh,  getPageNo(), getPageSize());
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

        if(modelModifyReason != null){
            modelModifyReason.setCreateTime(new Date());
            modelModifyReason.setCreatePerson("haha");
            modelModifyReason.setModifyTime(new Date());
            modelModifyReason.setModifyPerson("haha");
            modelModifyReasonService.save(modelModifyReason);
        }
        return "list";
    }

    /**
     * 删除
     */
    public String delete(){

        if( modelModifyReason != null && modelModifyReason.getId() != null){
            modelModifyReasonService.delete(modelModifyReason.getId());
        }

        setPageNo(1);
        return "list";
    }

    /**
     * 进入修改页面
     */
    public String editUI(){
        //处理回显
        if(modelModifyReason != null && modelModifyReason.getId() != null)
        {
          modelModifyReason =  modelModifyReasonService.findById(modelModifyReason.getId());

        }

        return "editUI";
    }


    /**
     * 修改
     * @return
     */
    public String edit(){

        if(modelModifyReason != null){
            modelModifyReason.setCreateTime(modelModifyReason.getCreateTime());
            modelModifyReason.setCreatePerson(modelModifyReason.getCreatePerson());
            modelModifyReason.setModifyTime(new Date());
            modelModifyReason.setModifyPerson("haha");
            modelModifyReasonService.update(modelModifyReason);
        }

        return "list";
    }
    /**
     * 批量删除
     */
    public String deleteSelected(){

        if(selectedRow != null){
            for(String id: selectedRow){
                modelModifyReasonService.delete(id);
            }
        }

        return "list";
    }

}
