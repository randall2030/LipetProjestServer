package com.envcheck.paramsetting.modelinfosetting.mediumstatus.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.modelinfosetting.mediumstatus.bean.MediumStatus;
import com.envcheck.paramsetting.modelinfosetting.mediumstatus.service.IMediumStatusService;

import java.net.URLDecoder;
import java.util.Date;

/**
 * Created by Administrator on 2016/5/7.
 */
public class MediumStatusAction extends BaseAction {
    //封装数据
    private MediumStatus mediumStatus;

    public MediumStatus getMediumStatus() {
        return mediumStatus;
    }

    public void setMediumStatus(MediumStatus mediumStatus) {
        this.mediumStatus = mediumStatus;
    }

    //调用业务逻辑方法
    private IMediumStatusService mediumStatusService;

    public IMediumStatusService getMediumStatusService() {
        return mediumStatusService;
    }

    public void setMediumStatusService(IMediumStatusService mediumStatusService) {
        this.mediumStatusService = mediumStatusService;
    }

    /**
     * 列表展示
     */
    public String listUI(){

        try {
            QueryHelper qh = new QueryHelper(MediumStatus.class, "c");
            //查询
            if(mediumStatus != null && (mediumStatus.getMediumNumber() != null || mediumStatus.getMediumName() !=null )){
                //条件查询
                if (mediumStatus.getMediumNumber() != null){
                    mediumStatus.setMediumNumber(URLDecoder.decode(mediumStatus.getMediumNumber(),"utf-8"));
                    qh.addConditions("c.mediumNumber like ?", "%" + mediumStatus.getMediumNumber() + "%");
                }
                if (mediumStatus.getMediumName() !=null){
                    mediumStatus.setMediumName(URLDecoder.decode(mediumStatus.getMediumName(),"utf-8"));
                    qh.addConditions("c.mediumName like ?", "%" + mediumStatus.getMediumName() + "%");
                }
            }

            pageResult = mediumStatusService.getPageResult(qh,  getPageNo(), getPageSize());
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

        if(mediumStatus != null){
            mediumStatus.setCreateTime(new Date());
            mediumStatus.setCreatePerson("haha");
            mediumStatus.setModifyTime(new Date());
            mediumStatus.setModifyPerson("haha");
            mediumStatusService.save(mediumStatus);
        }
        return "list";
    }

    /**
     * 删除
     */
    public String delete(){

        if( mediumStatus != null && mediumStatus.getId() != null){
            mediumStatusService.delete(mediumStatus.getId());
        }

        setPageNo(1);
        return "list";
    }

    /**
     * 进入修改页面
     */
    public String editUI(){
        //处理回显
        if(mediumStatus != null && mediumStatus.getId() != null)
        {
         mediumStatus =  mediumStatusService.findById( mediumStatus.getId());
        }

        return "editUI";
    }


    /**
     * 修改
     * @return
     */
    public String edit(){

        if(mediumStatus != null){
            mediumStatus.setCreateTime(mediumStatus.getCreateTime());
            mediumStatus.setCreatePerson(mediumStatus.getCreatePerson());
            mediumStatus.setModifyTime(new Date());
            mediumStatus.setModifyPerson("haha");
            mediumStatusService.update(mediumStatus);
        }

        return "list";
    }
    public String deleteSelected(){

        if(selectedRow != null){
            for(String id: selectedRow){
                mediumStatusService.delete(id);
            }
        }

        return "list";
    }

}
