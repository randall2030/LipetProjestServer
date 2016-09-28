package com.envcheck.paramsetting.modelinfosetting.unitmanage.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.modelinfosetting.unitmanage.bean.Unit;
import com.envcheck.paramsetting.modelinfosetting.unitmanage.service.IUnitService;

import java.net.URLDecoder;
import java.util.Date;

/**
 * Created by lighter on 2016/5/8.
 */
public class UnitAction extends BaseAction {
    //封装数据
    private Unit unit;

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
    //调用业务逻辑方法
    private IUnitService unitService;

    public IUnitService getUnitService() {
        return unitService;
    }

    public void setUnitService(IUnitService unitService) {
        this.unitService = unitService;
    }

    //列表展示
    /**
     * 列表展示
     */
    public String listUI(){

        try {
            QueryHelper qh = new QueryHelper(Unit.class, "c");
            //查询
            if(unit  != null && (unit.getUnitNumber() != null || unit.getUnitName()!=null)){
                //条件查询
                if (unit.getUnitNumber() != null){
                    unit.setUnitNumber(URLDecoder.decode(unit.getUnitNumber(),"utf-8"));
                    qh.addConditions("c.unitNumber like ?", "%" + unit.getUnitNumber() + "%");
                }
                if (unit.getUnitName()!=null){
                    unit.setUnitName(URLDecoder.decode(unit.getUnitName(),"utf-8"));
                    qh.addConditions("c.unitName like ?", "%" + unit.getUnitName() + "%");
                }
            }

            pageResult = unitService.getPageResult(qh,  getPageNo(), getPageSize());

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

        if(unit != null){
            unit.setCreateTime(new Date());
            unit.setCreatePerson("haha");
            unit.setModifyTime(new Date());
            unit.setModifyPerson("haha");
            unitService.save(unit);
        }
        return "list";
    }

    /**
     * 删除
     */
    public String delete(){

        if( unit != null && unit.getId() != null){
            unitService.delete(unit.getId());
        }

        setPageNo(1);
        return "list";
    }

    /**
     * 进入修改页面
     */
    public String editUI(){
        //处理回显
        if(unit != null && unit.getId() != null)
        {
          unit =  unitService.findById(unit.getId());

        }

        return "editUI";
    }


    /**
     * 修改
     * @return
     */
    public String edit(){

        if(unit != null){
            unit.setCreateTime(unit.getCreateTime());
            unit.setCreatePerson(unit.getCreatePerson());
            unit.setModifyTime(new Date());
            unit.setModifyPerson("haha");
            unitService.update(unit);
        }

        return "list";
    }
    public String deleteSelected(){

        if(selectedRow != null){
            for(String id: selectedRow){
                unitService.delete(id);
            }
        }

        return "list";
    }
}

