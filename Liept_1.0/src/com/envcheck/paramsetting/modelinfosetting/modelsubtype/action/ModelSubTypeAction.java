package com.envcheck.paramsetting.modelinfosetting.modelsubtype.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.modelinfosetting.modelsubtype.bean.ModelSubType;
import com.envcheck.paramsetting.modelinfosetting.modelsubtype.service.IModelSubTypeService;

import java.net.URLDecoder;
import java.util.Date;

/**
 * Created by Administrator on 2016/5/7.
 */
public class ModelSubTypeAction extends BaseAction{
    //封装数据
    private ModelSubType modelSubType;

    public ModelSubType getModelSubType() {
        return modelSubType;
    }

    public void setModelSubType(ModelSubType modelSubType) {
        this.modelSubType = modelSubType;
    }

    //调用业务逻辑方法
    private IModelSubTypeService modelSubTypeService;

    public IModelSubTypeService getModelSubTypeService() {
        return modelSubTypeService;
    }

    public void setModelSubTypeService(IModelSubTypeService modelSubTypeService) {
        this.modelSubTypeService = modelSubTypeService;
    }

    /**
     * 列表展示
     */
    public String listUI(){

        try {
            QueryHelper qh = new QueryHelper(ModelSubType.class, "c");
            //查询
            if(modelSubType != null && (modelSubType.getModelSubTypeNumber() != null || modelSubType.getModeSubTypeName()!=null)){
                //条件查询
                if (modelSubType.getModelSubTypeNumber() != null){
                    modelSubType.setModelSubTypeNumber(URLDecoder.decode(modelSubType.getModelSubTypeNumber(),"utf-8"));
                    qh.addConditions("c.modelSubTypeNumber like ?", "%" + modelSubType.getModelSubTypeNumber() + "%");
                }
                if (modelSubType.getModeSubTypeName()!=null){
                    modelSubType.setModeSubTypeName(URLDecoder.decode(modelSubType.getModeSubTypeName(),"utf-8"));
                    qh.addConditions("c.modeSubTypeName like ?", "%" + modelSubType.getModeSubTypeName() + "%");
                }
            }

            pageResult = modelSubTypeService.getPageResult(qh,  getPageNo(), getPageSize());
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

        if(modelSubType != null){
            modelSubType.setCreateTime(new Date());
            modelSubType.setCreatePerson("haha");
            modelSubType.setModifyTime(new Date());
            modelSubType.setModifyPerson("haha");
            modelSubTypeService.save(modelSubType);
        }
        return "list";
    }

    /**
     * 删除
     */
    public String delete(){

        if( modelSubType != null && modelSubType.getId() != null){
            modelSubTypeService.delete(modelSubType.getId());
        }

        setPageNo(1);
        return "list";
    }

    /**
     * 进入修改页面
     */
    public String editUI(){
        //处理回显
        if(modelSubType != null && modelSubType.getId() != null)
        {
           modelSubType =  modelSubTypeService.findById(modelSubType.getId());
        }

        return "editUI";
    }


    /**
     * 修改
     * @return
     */
    public String edit(){

        if(modelSubType != null){
            modelSubType.setCreateTime(modelSubType.getCreateTime());
            modelSubType.setCreatePerson(modelSubType.getCreatePerson());
            modelSubType.setModifyTime(new Date());
            modelSubType.setModifyPerson("haha");
            modelSubTypeService.update(modelSubType);
        }

        return "list";
    }
    public String deleteSelected(){

        if(selectedRow != null){
            for(String id: selectedRow){
                modelSubTypeService.delete(id);
            }
        }

        return "list";
    }

}
