package com.envcheck.paramsetting.checkrepairsetting.repairmeasure.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.checkrepairsetting.repairmeasure.bean.RepairMeasure;
import com.envcheck.paramsetting.checkrepairsetting.repairmeasure.service.IRepairMeasureService;

import java.net.URLDecoder;
import java.util.Date;


/**
 * Created by Administrator on 2016/5/6.
 */
public class RepairMeasureAction extends BaseAction {
    //封装数据
    private RepairMeasure repairMeasure;

    public RepairMeasure getRepairMeasure() {
        return repairMeasure;
    }
    public void setRepairMeasure(RepairMeasure repairMeasure) {
        this.repairMeasure = repairMeasure;
    }

    //调用业务逻辑方法
    private IRepairMeasureService repairMeasureService;
    public IRepairMeasureService getRepairMeasureService() {
        return repairMeasureService;
    }
    public void setRepairMeasureService(IRepairMeasureService repairMeasureService) {
        this.repairMeasureService = repairMeasureService;
    }

    /**
     * 列表展示
     */
    public String listUI(){

        try {
            QueryHelper qh = new QueryHelper(RepairMeasure.class, "c");
            //查询
            if(repairMeasure != null && (repairMeasure.getRepairMeasureNumber() != null || repairMeasure.getRepairMeasureName() != null ||repairMeasure.getModelType() != null) ){

                //条件查询
                if (repairMeasure.getRepairMeasureNumber() != null){
                    repairMeasure.setRepairMeasureNumber(URLDecoder.decode(repairMeasure.getRepairMeasureNumber(),"utf-8"));
                     qh.addConditions("c.repairMeasureNumber like ?", "%" + repairMeasure.getRepairMeasureNumber() + "%");
                }
                if (repairMeasure.getRepairMeasureName()!=null){
                    repairMeasure.setRepairMeasureName(URLDecoder.decode(repairMeasure.getRepairMeasureName(),"utf-8"));
                    qh.addConditions("c.repairMeasureName like ?", "%" + repairMeasure.getRepairMeasureName() + "%");
                }
                if (repairMeasure.getModelType()!=null){
                    repairMeasure.setModelType(URLDecoder.decode(repairMeasure.getModelType(),"utf-8"));
                    qh.addConditions("c.modelType like ?", "%" + repairMeasure.getModelType() + "%");
                }
            }

            pageResult = repairMeasureService.getPageResult(qh,  getPageNo(), getPageSize());

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

        if(repairMeasure != null){
            repairMeasure.setCreateTime(new Date());
            repairMeasure.setCreatePerson("haha");
            repairMeasure.setModifyTime(new Date());
            repairMeasure.setModifyPerson("haha");
            repairMeasureService.save(repairMeasure);
        }
        return "list";
    }

    /**
     * 删除
     */
    public String delete(){

        if( repairMeasure != null && repairMeasure.getId() != null){
            repairMeasureService.delete(repairMeasure.getId());
        }

        setPageNo(1);
        return "list";
    }

    /**
     * 进入修改页面
     */
    public String editUI(){
        //处理回显
        if(repairMeasure != null && repairMeasure.getId() != null)
        {
           repairMeasure = repairMeasureService.findById(repairMeasure.getId());
        }

        return "editUI";
    }


    /**
     * 修改
     * @return
     */
    public String edit(){

        if(repairMeasure != null){
            repairMeasure.setCreateTime(repairMeasure.getCreateTime());
            repairMeasure.setCreatePerson(repairMeasure.getCreatePerson());
            repairMeasure.setModifyTime(new Date());
            repairMeasure.setModifyPerson("haha");
            repairMeasureService.update(repairMeasure);
        }

        return "list";
    }
    /**
     * 批量删除
     */
    public String deleteSelected(){

        if(selectedRow != null){
            for(String id: selectedRow){
                repairMeasureService.delete(id);
            }
        }

        return "list";
    }


}
