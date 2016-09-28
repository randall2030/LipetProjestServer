package com.envcheck.paramsetting.checkrepairsetting.revealsrc.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.checkrepairsetting.revealsrc.bean.RevealSource;
import com.envcheck.paramsetting.checkrepairsetting.revealsrc.service.IRevealSourceService;

import java.net.URLDecoder;
import java.util.Date;

/**
 * Created by Administrator on 2016/5/7.
 */
public class RevealSourceAction extends BaseAction {
    //封装数据
    private RevealSource revealSource;
    public RevealSource getRevealSource() {
        return revealSource;
    }
    public void setRevealSource(RevealSource revealSource) {
        this.revealSource = revealSource;
    }

    //调用业务逻辑方法
    private IRevealSourceService revealSourceService;
    public IRevealSourceService getRevealSourceService() {
        return revealSourceService;
    }
    public void setRevealSourceService(IRevealSourceService revealSourceService) {
        this.revealSourceService = revealSourceService;
    }

    /**
     * 列表展示
     */
    public String listUI(){

        try {
            QueryHelper qh = new QueryHelper(RevealSource.class, "c");
            //查询
            if(revealSource != null && (revealSource.getRevealSrcNumber() != null || revealSource.getRevealSrcName()!=null ||revealSource.getModelType()!=null) ){
                //查询条件
                if (revealSource.getRevealSrcNumber() != null){
                    revealSource.setRevealSrcNumber(URLDecoder.decode(revealSource.getRevealSrcNumber(), "utf8"));
                    qh.addConditions("c.revealSrcNumber like ?", "%" + revealSource.getRevealSrcNumber() + "%");
                }
                if (revealSource.getRevealSrcName()!=null){
                    revealSource.setRevealSrcName(URLDecoder.decode(revealSource.getRevealSrcName(),"utf-8"));
                    qh.addConditions("c.revealSrcName like ?", "%" + revealSource.getRevealSrcName() + "%");
                }
            }

            pageResult = revealSourceService.getPageResult(qh,  getPageNo(), getPageSize());
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
        if(revealSource != null){
            revealSource.setCreateTime(new Date());
            revealSource.setCreatePerson("haha");
            revealSource.setModifyTime(new Date());
            revealSource.setModifyPerson("haha");
            revealSourceService.save(revealSource);
        }
        return "list";
    }

    /**
     * 删除
     */
    public String delete(){

        if( revealSource != null && revealSource.getId() != null){
            revealSourceService.delete(revealSource.getId());
        }

        setPageNo(1);
        return "list";
    }

    /**
     * 进入修改页面
     */
    public String editUI(){
        //处理回显
        if(revealSource != null && revealSource.getId() != null)
        {
            revealSource = revealSourceService.findById(revealSource.getId());
        }

        return "editUI";
    }


    /**
     * 修改
     * @return
     */
    public String edit(){

        if(revealSource != null){
            revealSource.setCreateTime(revealSource.getCreateTime());
            revealSource.setCreatePerson(revealSource.getCreatePerson());
            revealSource.setModifyTime(new Date());
            revealSource.setModifyPerson("haha");
            revealSourceService.update(revealSource);
        }

        return "list";
    }
    /**
     * 批量删除
     */
    public String deleteSelected(){

        if(selectedRow != null){
            for(String id: selectedRow){
                revealSourceService.delete(id);
            }
        }

        return "list";
    }

}
