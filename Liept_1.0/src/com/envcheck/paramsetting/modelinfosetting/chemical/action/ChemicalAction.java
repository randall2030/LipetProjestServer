package com.envcheck.paramsetting.modelinfosetting.chemical.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.modelinfosetting.chemical.bean.Chemical;
import com.envcheck.paramsetting.modelinfosetting.chemical.service.IChemicalService;

import java.net.URLDecoder;
import java.util.Date;

/**
 * Created by Administrator on 2016/5/7.
 */
public class ChemicalAction extends BaseAction {
    //封装数据
    private Chemical chemical;

    public Chemical getChemical() {
        return chemical;
    }

    public void setChemical(Chemical chemical) {
        this.chemical = chemical;
    }

    //调用业务逻辑方法
    private IChemicalService chemicalService;

    public IChemicalService getChemicalService() {
        return chemicalService;
    }

    public void setChemicalService(IChemicalService chemicalService) {
        this.chemicalService = chemicalService;
    }

    /**
     * 列表展示
     */
    public String listUI(){

        try {
            QueryHelper qh = new QueryHelper(Chemical.class, "c");
            //查询
            if(chemical != null &&( chemical.getChemicalNumber() != null || chemical.getChemicalName() !=null) ){
                //条件查询
                if (chemical.getChemicalNumber() != null ){
                    chemical.setChemicalNumber(URLDecoder.decode(chemical.getChemicalNumber(),"utf-8"));
                    qh.addConditions("c.chemicalNumber like ?", "%" + chemical.getChemicalNumber() + "%");
                }
                if (chemical.getChemicalName() !=null){
                    chemical.setChemicalName(URLDecoder.decode(chemical.getChemicalName(),"utf-8"));
                    qh.addConditions("c.chemicalName like ?", "%" + chemical.getChemicalName() + "%");
                }
            }

            pageResult = chemicalService.getPageResult(qh,  getPageNo(), getPageSize());
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

        if(chemical != null){
            chemicalService.save(chemical);
        }
        return "list";
    }

    /**
     * 删除
     */
    public String delete(){

        if( chemical != null && chemical.getId() != null){
            chemicalService.delete(chemical.getId());
        }

        setPageNo(1);
        return "list";
    }

    /**
     * 进入修改页面
     */
    public String editUI(){
        //处理回显
        if(chemical != null && chemical.getId() != null)
        {
          chemical = chemicalService.findById(chemical.getId());

        }

        return "editUI";
    }


    /**
     * 修改
     * @return
     */
    public String edit(){

        if(chemical != null){
            chemical.setCreateTime(chemical.getCreateTime());
            chemical.setCreatePerson(chemical.getCreatePerson());
            chemical.setModifyTime(new Date());
            chemical.setModifyPerson("haha");
            chemicalService.update(chemical);
        }

        return "list";
    }


    public String deleteSelected(){

        if(selectedRow != null){
            for(String id: selectedRow){
                chemicalService.delete(id);
            }
        }

        return "list";
    }

}
