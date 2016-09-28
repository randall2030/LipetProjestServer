package com.envcheck.paramsetting.modifyreasonsetting.forever2move.action;


import com.envcheck.base.action.BaseAction;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.modifyreasonsetting.forever2move.bean.ForeverMoveReason;
import com.envcheck.paramsetting.modifyreasonsetting.forever2move.service.IForeverMoveReasonService;

import java.net.URLDecoder;
import java.util.Date;

/**
 * Created by Administrator on 2016/5/5.
 */
public class ForeverMoveReasonAction extends BaseAction {

    //封装数据
    private ForeverMoveReason foreverMoveReason;
    public ForeverMoveReason getForeverMoveReason() {
        return foreverMoveReason;
    }
    public void setForeverMoveReason(ForeverMoveReason foreverMoveReason) {
        this.foreverMoveReason = foreverMoveReason;
    }

    //调用业务逻辑方法
    private IForeverMoveReasonService foreverMoveReasonService;
    public IForeverMoveReasonService getForeverMoveReasonService() {
        return foreverMoveReasonService;
    }
    public void setForeverMoveReasonService(IForeverMoveReasonService foreverMoveReasonService) {
        this.foreverMoveReasonService = foreverMoveReasonService;
    }

    /**
     * 列表展示
     */
    public String listUI(){

        try {
            QueryHelper qh = new QueryHelper(ForeverMoveReason.class, "c");
            //查询
            if(foreverMoveReason != null && (foreverMoveReason.getForeverMoveReasonName() != null ||foreverMoveReason.getForeverMoveReasonNumber() != null))
            {
                //条件查询
                if (foreverMoveReason.getForeverMoveReasonName() != null){
                    foreverMoveReason.setForeverMoveReasonName(URLDecoder.decode(foreverMoveReason.getForeverMoveReasonName(),"utf-8"));
                    qh.addConditions("c.foreverMoveReasonName like ?", "%" + foreverMoveReason.getForeverMoveReasonName() + "%");
                }
                if (foreverMoveReason.getForeverMoveReasonNumber() != null){
                    foreverMoveReason.setForeverMoveReasonNumber(URLDecoder.decode(foreverMoveReason.getForeverMoveReasonNumber(),"utf-8"));
                    qh.addConditions("c.foreverMoveReasonNumber like ?", "%" + foreverMoveReason.getForeverMoveReasonNumber() + "%");
                }
            }

            pageResult = foreverMoveReasonService.getPageResult(qh,  getPageNo(), getPageSize());
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

        if(foreverMoveReason != null){
            foreverMoveReason.setCreateTime(new Date());
            foreverMoveReason.setCreatePerson("haha");
            foreverMoveReason.setModifyTime(new Date());
            foreverMoveReason.setModifyPerson("haha");
            foreverMoveReasonService.save(foreverMoveReason);
        }
        return "list";
    }

    /**
     * 删除
     */
    public String delete(){

        if( foreverMoveReason != null && foreverMoveReason.getId() != null){
            foreverMoveReasonService.delete(foreverMoveReason.getId());
        }

        setPageNo(1);
        return "list";
    }

    /**
     * 进入修改页面
     */
    public String editUI(){
        //处理回显
        if(foreverMoveReason != null && foreverMoveReason.getId() != null)
        {
         foreverMoveReason = foreverMoveReasonService.findById(foreverMoveReason.getId() );

        }

        return "editUI";
    }


    /**
     * 修改
     * @return
     */
    public String edit(){

        if(foreverMoveReason != null){
            foreverMoveReason.setCreateTime(foreverMoveReason.getCreateTime());
            foreverMoveReason.setCreatePerson(foreverMoveReason.getCreatePerson());
            foreverMoveReason.setModifyTime(new Date());
            foreverMoveReason.setModifyPerson("haha");
            foreverMoveReasonService.update(foreverMoveReason);
        }

        return "list";
    }
    /**
     * 批量删除
     */
    public String deleteSelected(){

        if(selectedRow != null){
            for(String id: selectedRow){
                foreverMoveReasonService.delete(id);
            }
        }

        return "list";
    }

}
