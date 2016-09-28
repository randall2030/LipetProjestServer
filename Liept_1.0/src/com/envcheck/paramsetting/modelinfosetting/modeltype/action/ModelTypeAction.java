package com.envcheck.paramsetting.modelinfosetting.modeltype.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.utils.JsonUtils;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.modelinfosetting.modeltype.bean.ModelType;
import com.envcheck.paramsetting.modelinfosetting.modeltype.service.IModelTypeService;

import java.net.URLDecoder;
import java.util.Date;

/**
 * Created by Administrator on 2016/5/7.
 */
public class ModelTypeAction extends BaseAction {
    //封装数据
    private ModelType modelType;

    public ModelType getModelType() {
        return modelType;
    }

    public void setModelType(ModelType modelType) {
        this.modelType = modelType;
    }

    //调用业务逻辑方法
    private IModelTypeService modelTypeService;
    public IModelTypeService getModelTypeService() {
        return modelTypeService;
    }
    public void setModelTypeService(IModelTypeService modelTypeService) {
        this.modelTypeService = modelTypeService;
    }


    /**
     * 列表展示
     */
    public String listUI(){

        try {
            QueryHelper qh = new QueryHelper(ModelType.class, "c");
            //查询
            if(modelType != null && (modelType.getModelTypeNumber() != null || modelType.getModelTypeName()!=null ||modelType.getCaculateType()!=null)){
                //查询条件
                if (modelType.getModelTypeNumber() != null){
                    modelType.setModelTypeNumber(URLDecoder.decode(modelType.getModelTypeNumber(),"utf-8"));
                    qh.addConditions("c.modelTypeNumber like ?", "%" + modelType.getModelTypeNumber() + "%");
                }
                if (modelType.getModelTypeName()!=null){
                    modelType.setModelTypeName(URLDecoder.decode(modelType.getModelTypeName(),"utf-8"));
                    qh.addConditions("c.modelTypeName like ?", "%" + modelType.getModelTypeName() + "%");
                }
                if (modelType.getCaculateType()!=null){
                    modelType.setCaculateType(URLDecoder.decode(modelType.getCaculateType(),"utf-8"));
                    qh.addConditions("c.caculateType like ?", "%" + modelType.getCaculateType() + "%");
                }
            }

            pageResult = modelTypeService.getPageResult(qh,  getPageNo(), getPageSize());
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

        if(modelType != null){
            modelType.setCreateTime(new Date());
            modelType.setCreatePerson("haha");
            modelType.setModifyTime(new Date());
            modelType.setModifyPerson("haha");
            modelTypeService.save(modelType);
        }
        return "list";
    }

    /**
     * 删除
     */
    public String delete(){

        if( modelType != null && modelType.getId() != null){
            modelTypeService.delete(modelType.getId());
        }

        setPageNo(1);
        return "list";
    }

    /**
     * 进入修改页面
     */
    public String editUI(){
        //处理回显
        if(modelType != null && modelType.getId() != null)
        {
           modelType = modelTypeService.findById(modelType.getId());
        }

        return "editUI";
    }


    /**
     * 修改
     * @return
     */
    public String edit(){

        if(modelType != null){
            modelType.setCreateTime(modelType.getCreateTime());
            modelType.setCreatePerson(modelType.getCreatePerson());
            modelType.setModifyTime(new Date());
            modelType.setModifyPerson("haha");
            modelTypeService.update(modelType);
        }

        return "list";
    }
    public String deleteSelected(){

        if(selectedRow != null){
            for(String id: selectedRow){
                modelTypeService.delete(id);
            }
        }

        return "list";
    }
}
