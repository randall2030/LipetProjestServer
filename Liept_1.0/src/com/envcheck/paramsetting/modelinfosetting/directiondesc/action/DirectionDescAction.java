package com.envcheck.paramsetting.modelinfosetting.directiondesc.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.modelinfosetting.directiondesc.bean.DirectionDesc;
import com.envcheck.paramsetting.modelinfosetting.directiondesc.service.IDirectionDescService;

import java.net.URLDecoder;
import java.util.Date;

/**
 * Created by Administrator on 2016/5/7.
 */
public class DirectionDescAction extends BaseAction {
    //封装数据
    private DirectionDesc directionDesc;

    public DirectionDesc getDirectionDesc() {
        return directionDesc;
    }

    public void setDirectionDesc(DirectionDesc directionDesc) {
        this.directionDesc = directionDesc;
    }

    //调用业务逻辑方法
    private IDirectionDescService directionDescService;

    public IDirectionDescService getDirectionDescService() {
        return directionDescService;
    }

    public void setDirectionDescService(IDirectionDescService directionDescService) {
        this.directionDescService = directionDescService;
    }

    /**
     * 列表展示
     */
    public String listUI(){

        try {
            QueryHelper qh = new QueryHelper(DirectionDesc.class, "c");
            //查询
            if(directionDesc != null && (directionDesc.getDirectionDescNumber() != null || directionDesc.getDirectionDescName()!=null) ){
                //条件查询
                if (directionDesc.getDirectionDescName() != null){
                    directionDesc.setDirectionDescName(URLDecoder.decode(directionDesc.getDirectionDescName(),"utf-8"));
                    qh.addConditions("c.directionDescName like ?", "%" + directionDesc.getDirectionDescName() + "%");
                }
                if (directionDesc.getDirectionDescNumber()!=null){
                    directionDesc.setDirectionDescNumber(URLDecoder.decode(directionDesc.getDirectionDescNumber(),"utf-8"));
                    qh.addConditions("c.directionDescNumber like ?", "%" + directionDesc.getDirectionDescNumber() + "%");
                }
            }

            pageResult = directionDescService.getPageResult(qh,  getPageNo(), getPageSize());
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

        if(directionDesc != null){
            directionDesc.setCreateTime(new Date());
            directionDesc.setCreatePerson("haha");
            directionDesc.setModifyTime(new Date());
            directionDesc.setModifyPerson("haha");
            directionDescService.save(directionDesc);
        }
        return "list";
    }

    /**
     * 删除
     */
    public String delete(){

        if( directionDesc != null && directionDesc.getId() != null){
            directionDescService.delete(directionDesc.getId());
        }

        setPageNo(1);
        return "list";
    }

    /**
     * 进入修改页面
     */
    public String editUI(){
        //处理回显
        if(directionDesc != null && directionDesc.getId() != null)
        {
          directionDesc = directionDescService.findById(directionDesc.getId() );

        }

        return "editUI";
    }


    /**
     * 修改
     * @return
     */
    public String edit(){

        if(directionDesc != null){
            directionDesc.setCreateTime(directionDesc.getCreateTime());
            directionDesc.setCreatePerson(directionDesc.getCreatePerson());
            directionDesc.setModifyTime(new Date());
            directionDesc.setModifyPerson("haha");
            directionDescService.update(directionDesc);
        }

        return "list";
    }
    public String deleteSelected(){

        if(selectedRow != null){
            for(String id: selectedRow){
                directionDescService.delete(id);
            }
        }

        return "list";
    }
}
