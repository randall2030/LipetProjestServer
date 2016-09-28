package com.envcheck.paramsetting.checkrepairsetting.checkapparatus.action;


import com.envcheck.base.action.BaseAction;
import com.envcheck.base.utils.DateEchoUtils;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.checkrepairsetting.checkapparatus.bean.CheckApparatus;
import com.envcheck.paramsetting.checkrepairsetting.checkapparatus.service.ICheckApparatusService;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/5/5.
 */
public class CheckApparatusAction extends BaseAction {

    //封装数据
    private CheckApparatus checkApparatus;
    public CheckApparatus getCheckApparatus() {
        return checkApparatus;
    }
    public void setCheckApparatus(CheckApparatus checkApparatus) {
        this.checkApparatus = checkApparatus;
    }

    //调用业务逻辑方法
    private ICheckApparatusService checkApparatusService;
    public ICheckApparatusService getCheckApparatusService() {
        return checkApparatusService;
    }
    public void setCheckApparatusService(ICheckApparatusService checkApparatusService) {
        this.checkApparatusService = checkApparatusService;
    }

    /**
     * 列表展示
     */
    public String listUI(){

        try {
            QueryHelper qh = new QueryHelper(CheckApparatus.class, "c");
            //查询
            if(checkApparatus != null && (checkApparatus.getSequenceNumber() != null || checkApparatus.getApparatusName() != null))
            {
                //条件查询
                if (checkApparatus.getSequenceNumber() != null){
                    checkApparatus.setSequenceNumber(URLDecoder.decode(checkApparatus.getSequenceNumber(),"utf-8"));
                    qh.addConditions("c.sequenceNumber like ?", "%" + checkApparatus.getSequenceNumber() + "%");
                }
                if (checkApparatus.getApparatusName() != null){
                    checkApparatus.setApparatusName(URLDecoder.decode(checkApparatus.getApparatusName(),"utf-8"));
                    qh.addConditions("c.apparatusName like ?", "%" + checkApparatus.getApparatusName() + "%");
                }
            }

            pageResult = checkApparatusService.getPageResult(qh,  getPageNo(), getPageSize());

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

        if(checkApparatus != null){

            checkApparatusService.save(checkApparatus);
        }
        return "list";
    }

    /**
     * 删除
     */
    public String delete(){

        if( checkApparatus != null && checkApparatus.getId() != null){
            checkApparatusService.delete(checkApparatus.getId());
        }

        setPageNo(1);
        return "list";
    }

    /**
     * 进入修改页面
     */
    public String editUI(){
        //处理回显
        if(checkApparatus != null && checkApparatus.getId() != null)
        {
          checkApparatus = checkApparatusService.findById(checkApparatus.getId());
            //时间回显
            List<Date> list = new ArrayList<>();
            list.add(checkApparatus.getLastCheckTime());
            DateEchoUtils.dateEcho(list,"checkTime");
        }

        return "editUI";
    }


    /**
     * 修改
     * @return
     */
    public String edit(){

        if(checkApparatus != null){
            checkApparatusService.update(checkApparatus);
        }

        return "list";
    }
    /**
     * 批量删除
     */
    public String deleteSelected(){

        if(selectedRow != null){
            for(String id: selectedRow){
                checkApparatusService.delete(id);
            }
        }

        return "list";
    }

}
