package com.envcheck.paramsetting.modifyreasonsetting.inputcodebymanu.action;


import com.envcheck.base.action.BaseAction;
import com.envcheck.base.dynamic_change_datasource.UserContextHolder;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.modifyreasonsetting.inputcodebymanu.bean.ManuInputCodeReason;
import com.envcheck.paramsetting.modifyreasonsetting.inputcodebymanu.service.IManuInputCodeReasonService;

import java.net.URLDecoder;
import java.util.Date;

/**
 * Created by Administrator on 2016/5/5.
 */
public class ManuInputCodeAction extends BaseAction {

    //封装数据
    private ManuInputCodeReason manuInputCodeReason;
    //调用业务逻辑方法
    private IManuInputCodeReasonService manuInputCodeReasonService;


    /**
     * 列表展示
     */
    public String listUI(){

        try {
            QueryHelper qh = new QueryHelper(ManuInputCodeReason.class, "m");
            //查询
            if(manuInputCodeReason != null && (manuInputCodeReason.getManuInputCodeReasonName() != null ||manuInputCodeReason.getManuInputCodeReasonNumber() != null))
            {
                if (manuInputCodeReason.getManuInputCodeReasonName() != null){
                    manuInputCodeReason.setManuInputCodeReasonName(URLDecoder.decode(manuInputCodeReason.getManuInputCodeReasonName(),"utf-8"));
                    qh.addConditions("m.manuInputCodeReasonName like ?", "%" + manuInputCodeReason.getManuInputCodeReasonName() + "%");
                }
                if (manuInputCodeReason.getManuInputCodeReasonNumber() != null){
                    manuInputCodeReason.setManuInputCodeReasonNumber(URLDecoder.decode(manuInputCodeReason.getManuInputCodeReasonNumber(),"utf-8"));
                    qh.addConditions("m.manuInputCodeReasonNumber like ?", "%" + manuInputCodeReason.getManuInputCodeReasonNumber() + "%");
                }
            }

            pageResult = manuInputCodeReasonService.getPageResult(qh,  getPageNo(), getPageSize());
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

        if(manuInputCodeReason != null){
            manuInputCodeReason.setCreateTime(new Date());
            manuInputCodeReason.setCreatePerson(UserContextHolder.getCurrentUser().getUsername());
            manuInputCodeReason.setModifyTime(new Date());
            manuInputCodeReason.setModifyPerson(UserContextHolder.getCurrentUser().getUsername());
            manuInputCodeReasonService.save(manuInputCodeReason);
        }
        return "list";
    }

    /**
     * 删除
     */
    public String delete(){

        if( manuInputCodeReason != null && manuInputCodeReason.getId() != null){
            manuInputCodeReasonService.delete(manuInputCodeReason.getId());
        }

        setPageNo(1);
        return "list";
    }

    /**
     * 进入修改页面
     */
    public String editUI(){
        //处理回显
        if(manuInputCodeReason != null && manuInputCodeReason.getId() != null)
        {
            manuInputCodeReason = manuInputCodeReasonService.findById(manuInputCodeReason.getId());

        }

        return "editUI";
    }


    /**
     * 修改
     * @return
     */
    public String edit(){

        if(manuInputCodeReason != null){
            manuInputCodeReason.setCreateTime(manuInputCodeReason.getCreateTime());
            manuInputCodeReason.setCreatePerson(manuInputCodeReason.getCreatePerson());
            manuInputCodeReason.setModifyTime(new Date());
            manuInputCodeReason.setModifyPerson(UserContextHolder.getCurrentUser().getUsername());
            manuInputCodeReasonService.update(manuInputCodeReason);
        }

        return "list";
    }
    /**
     * 批量删除
     */
    public String deleteSelected(){

        if(selectedRow != null){
            for(String id: selectedRow){
                manuInputCodeReasonService.delete(id);
            }
        }

        return "list";
    }
    public ManuInputCodeReason getManuInputCodeReason() {
        return manuInputCodeReason;
    }
    public void setManuInputCodeReason(ManuInputCodeReason manuInputCodeReason) {
        this.manuInputCodeReason = manuInputCodeReason;
    }
    public IManuInputCodeReasonService getManuInputCodeReasonService() {
        return manuInputCodeReasonService;
    }
    public void setManuInputCodeReasonService(IManuInputCodeReasonService manuInputCodeReasonService) {
        this.manuInputCodeReasonService = manuInputCodeReasonService;
    }
}
