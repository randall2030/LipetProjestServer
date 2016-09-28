package com.envcheck.paramsetting.modelinfosetting.caculatetype.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.utils.JsonUtils;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.modelinfosetting.caculatetype.bean.CaculateType;
import com.envcheck.paramsetting.modelinfosetting.caculatetype.service.ICaculateTypeService;

import java.net.URLDecoder;
import java.util.Date;

/**
 * Created by Administrator on 2016/5/7.
 */
public class CaculateTypeAction extends BaseAction {
    //封装数据
    private CaculateType caculateType;

    public CaculateType getCaculateType() {
        return caculateType;
    }

    public void setCaculateType(CaculateType caculateType) {
        this.caculateType = caculateType;
    }

    //调用业务逻辑方法
    private ICaculateTypeService caculateTypeService;

    public ICaculateTypeService getCaculateTypeService() {
        return caculateTypeService;
    }

    public void setCaculateTypeService(ICaculateTypeService caculateTypeService) {
        this.caculateTypeService = caculateTypeService;
    }

    /**
     * 列表展示
     */
    public String listUI(){

        try {
            QueryHelper qh = new QueryHelper(CaculateType.class, "c");
            //查询
            if(caculateType != null && (caculateType.getCaculateTypeNumber() != null || caculateType.getCaculateTypeName() !=null) ){
                //条件查询
                if (caculateType.getCaculateTypeNumber() != null){
                    caculateType.setCaculateTypeNumber(URLDecoder.decode(caculateType.getCaculateTypeNumber(),"utf-8"));
                    qh.addConditions("c.caculateTypeNumber like ?", "%" + caculateType.getCaculateTypeNumber() + "%");
                }
                if (caculateType.getCaculateTypeName() !=null){
                    caculateType.setCaculateTypeName(URLDecoder.decode(caculateType.getCaculateTypeName(),"utf-8"));
                    qh.addConditions("c.caculateTypeName like ?", "%" + caculateType.getCaculateTypeName() + "%");
                }
            }

            pageResult = caculateTypeService.getPageResult(qh,  getPageNo(), getPageSize());
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

        if(caculateType != null){
            caculateType.setCreateTime(new Date());
            caculateType.setCreatePerson("haha");
            caculateType.setModifyTime(new Date());
            caculateType.setModifyPerson("haha");
            caculateTypeService.save(caculateType);
        }
        return "list";
    }

    /**
     * 删除
     */
    public String delete(){

        if( caculateType != null && caculateType.getId() != null){
            caculateTypeService.delete(caculateType.getId());
        }

        setPageNo(1);
        return "list";
    }

    /**
     * 进入修改页面
     */
    public String editUI(){
        //处理回显
        if(caculateType != null && caculateType.getId() != null)
        {
          caculateType = caculateTypeService.findById(caculateType.getId());
        }
        return "editUI";
    }


    /**
     * 修改
     * @return
     */
    public String edit(){

        if(caculateType != null){
            caculateType.setCreateTime(caculateType.getCreateTime());
            caculateType.setCreatePerson(caculateType.getCreatePerson());
            caculateType.setModifyTime(new Date());
            caculateType.setModifyPerson("haha");
            caculateTypeService.update(caculateType);
        }

        return "list";
    }

    public String deleteSelected(){

        if(selectedRow != null){
            for(String id: selectedRow){
                caculateTypeService.delete(id);
            }
        }

        return "list";
    }
}
