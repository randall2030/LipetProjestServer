package com.envcheck.paramsetting.checkrepairsetting.densitymanage.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.utils.JsonUtils;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.checkrepairsetting.densitymanage.bean.StandGasTheoryCon;
import com.envcheck.paramsetting.checkrepairsetting.densitymanage.service.IStandGasTheoryConService;

import java.net.URLDecoder;

/**
 * Created by Administrator on 2016/5/6.
 */
public class StandGasTheoryConAction extends BaseAction {
    //封装数据
    private StandGasTheoryCon standGasTheoryCon;
    public StandGasTheoryCon getStandGasTheoryCon() {
        return standGasTheoryCon;
    }
    public void setStandGasTheoryCon(StandGasTheoryCon standGasTheoryCon) {
        this.standGasTheoryCon = standGasTheoryCon;
    }

    //调用业务逻辑方法
    private IStandGasTheoryConService standGasTheoryConService;
    public IStandGasTheoryConService getStandGasTheoryConService() {
        return standGasTheoryConService;
    }
    public void setStandGasTheoryConService(IStandGasTheoryConService standGasTheoryConService) {
        this.standGasTheoryConService = standGasTheoryConService;
    }


    /**
     * 列表展示
     */
    public String listUI(){

        try {
            QueryHelper qh = new QueryHelper(StandGasTheoryCon.class, "c");
            //查询
            if(standGasTheoryCon != null && standGasTheoryCon.getNumber() != null ){
                //条件查询
                if (standGasTheoryCon.getNumber() != null){
                    standGasTheoryCon.setNumber(URLDecoder.decode(standGasTheoryCon.getNumber(),"utf-8"));
                    qh.addConditions("c.number like ?", "%" + standGasTheoryCon.getNumber() + "%");
                }
            }

            pageResult = standGasTheoryConService.getPageResult(qh,  getPageNo(), getPageSize());
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

        if(standGasTheoryCon != null){
            standGasTheoryConService.save(standGasTheoryCon);
        }
        return "list";
    }

    /**
     * 删除
     */
    public String delete(){

        if( standGasTheoryCon != null && standGasTheoryCon.getId() != null){
            standGasTheoryConService.delete(standGasTheoryCon.getId());
        }

        setPageNo(1);
        return "list";
    }

    /**
     * 进入修改页面
     */
    public String editUI(){
        //处理回显
        if(standGasTheoryCon != null && standGasTheoryCon.getId() != null)
        {
           standGasTheoryCon =  standGasTheoryConService.findById(standGasTheoryCon.getId());

        }

        return "editUI";
    }


    /**
     * 修改
     * @return
     */
    public String edit(){

        if(standGasTheoryCon != null){
            standGasTheoryConService.update(standGasTheoryCon);
        }

        return "list";
    }
    /**
     * 批量删除
     */
    public String deleteSelected(){

        if(selectedRow != null){
            for(String id: selectedRow){
                standGasTheoryConService.delete(id);
            }
        }

        return "list";
    }

}
