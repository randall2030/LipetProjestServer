package com.envcheck.paramsetting.checkrepairsetting.standrdgasmanage.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.utils.DateEchoUtils;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.checkrepairsetting.standrdgasmanage.bean.StandGas;
import com.envcheck.paramsetting.checkrepairsetting.standrdgasmanage.service.IStandGasService;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/5/7.
 */
public class StandGasAction extends BaseAction {
    //封装数据
    private StandGas standGas;

    //调用业务逻辑方法
    private IStandGasService standGasService;
    /**
     * 列表展示
     */
    public String listUI(){

        try {
            QueryHelper qh = new QueryHelper(StandGas.class, "c");
            //查询
            if(standGas != null && (standGas.getStandGasNumber() != null||standGas.getCompanyNumber()!=null ||standGas.getStopuUse()!=null )){
                //查询条件
                if (standGas.getStandGasNumber() != null){
                    standGas.setStandGasNumber(URLDecoder.decode(standGas.getStandGasNumber(),"utf-8"));
                     qh.addConditions("c.standGasNumber like ?", "%" + standGas.getStandGasNumber() + "%");
                }
                if (standGas.getCompanyNumber()!=null){
                    standGas.setCompanyNumber(URLDecoder.decode(standGas.getCompanyNumber(),"utf-8"));
                    qh.addConditions("c.companyNumber like ?", "%" + standGas.getCompanyNumber() + "%");
                }
                if (standGas.getStopuUse()!=null){
                    qh.addConditions("c.stopuUse like ?", "%" + standGas.getStopuUse() + "%");
                }
            }

            pageResult = standGasService.getPageResult(qh,  getPageNo(), getPageSize());
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

        if(standGas != null){
            //如果停用  设置停用时间
            Boolean bl = standGas.getStopuUse();
            if (bl==true){
                standGas.setStopTime(new Date());
            }
            standGasService.save(this.standGas);
        }
        return "list";
    }

    /**
     * 删除
     */
    public String delete(){

        if( standGas != null && standGas.getId() != null){
            standGasService.delete(standGas.getId());
        }

        setPageNo(1);
        return "list";
    }

    /**
     * 进入修改页面
     */
    public String editUI(){
        //处理回显
        if(standGas != null && standGas.getId() != null)
        {
           standGas =  standGasService.findById(standGas.getId());
            //时间回显
            List<Date> list = new ArrayList<>();
            list.add(standGas.getValidTime());
            DateEchoUtils.dateEcho(list,"validTime");
        }

        return "editUI";
    }


    /**
     * 修改
     * @return
     */
    public String edit(){

        if(standGas != null){
            //如果停用  设置停用时间
            Boolean bl = standGas.getStopuUse();
            if (bl==true){
                standGas.setStopTime(new Date());
            }
            standGasService.update(standGas);
        }

        return "list";
    }
    /**
     * 批量删除
     */
    public String deleteSelected(){

        if(selectedRow != null){
            for(String id: selectedRow){
                standGasService.delete(id);
            }
        }

        return "list";
    }

    public StandGas getStandGas() {
        return standGas;
    }
    public void setStandGas(StandGas standGas) {
        this.standGas = standGas;
    }

    public IStandGasService getStandGasService() {
        return standGasService;
    }
    public void setStandGasService(IStandGasService standGasService) {
        this.standGasService = standGasService;
    }


}
