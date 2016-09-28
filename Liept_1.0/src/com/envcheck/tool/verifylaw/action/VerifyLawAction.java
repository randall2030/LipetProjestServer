package com.envcheck.tool.verifylaw.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.bean.Module;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.laws.bean.Law;
import com.envcheck.paramsetting.laws.service.ILawService;
import com.envcheck.view.moduleinfo.service.IModuleService;

import java.util.List;

/**
 * Created by susion on 2016/5/11.
 */
public class VerifyLawAction extends BaseAction{

    private ILawService lawService;
    private IModuleService moduleService;
    private String currentLawCode;

    public String listUI(){
        Law law = lawService.getCurrentLaw();
        if(law != null){
            currentLawCode = law.getLawCode();
        }else{
            currentLawCode = "没有设置当前法规";
        }

        return "listUI";
    }



    public String verify(){

        Law law = lawService.getCurrentLaw();

        String lawCode = law.getLawCode();

        //对所有组件进行法规的设置
        QueryHelper helper  = new QueryHelper(Module.class, "m");

        //分页查询并进行 对组件设置法规

        //1.查询组件的总数
        long totalModule =  moduleService.getModuleTotalNumber();

        int i = 0;
        for(; i<=totalModule/20+1; i++){
            pageResult = moduleService.getPageResult(helper,  i, 20);
            List<Module> modules = pageResult.getItems();

            for(Module module : modules){
                //设置法规
                module.setLaws(lawCode);
                moduleService.update(module);
            }
        }

        return "list";

    }



    public String getCurrentLawCode() {
        return currentLawCode;
    }

    public void setCurrentLawCode(String currentLawCode) {
        this.currentLawCode = currentLawCode;
    }

    public void setLawService(ILawService lawService) {
        this.lawService = lawService;
    }


    public void setModuleService(IModuleService moduleService) {
        this.moduleService = moduleService;
    }
}
