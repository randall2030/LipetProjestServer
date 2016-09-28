package com.envcheck.view.moduleinfo.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.bean.CheckTaskForLabel;
import com.envcheck.base.bean.CheckTaskForModule;
import com.envcheck.base.bean.Module;
import com.envcheck.base.bean.ModuleCheck;
import com.envcheck.base.utils.DateEchoUtils;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.base.utils.TaskUtils;
import com.envcheck.base.utils.ViewUtils;
import com.envcheck.paramsetting.modelinfosetting.equipmentmanage.bean.EquipmentInfo;
import com.envcheck.paramsetting.modelinfosetting.equipmentmanage.service.IEquipmentInfoService;
import com.envcheck.paramsetting.modelinfosetting.equipmentmanage.service.impl.EquipmentInfoService;
import com.envcheck.scenemanage.allocatetask.bean.Task;
import com.envcheck.view.checkinfo.bean.CheckInfo;
import com.envcheck.view.moduleinfo.bean.ModuleInfo;
import com.envcheck.view.moduleinfo.service.IModuleService;
import org.apache.struts2.ServletActionContext;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by susion on 2016/5/11.
 */
public class ModuleInfoAction extends BaseAction{

    private IModuleService moduleService;
    private Module module;

    public String listUI(){
        try {

            QueryHelper qh = new QueryHelper(Module.class, "m");
            //条件查询
            if (module!=null) {
                QueryHelper.addBaseConditionForModule(module, qh);
            }

            qh.addOrderByProperty("labelNumber", QueryHelper.ORDER_BY_ASC);

            pageResult = moduleService.getPageResult(qh,  getPageNo(), getPageSize());
            List<ModuleInfo> moduleInfoItems = new ArrayList<>();
            List<Module> moduleItems = pageResult.getItems();


            //生成检测信息对象供前台展示
            ModuleInfo moduleInfo;
            for(Module module : moduleItems){
                moduleInfo = new ModuleInfo();
                moduleInfoItems.add(ViewUtils.getModuleInfoByModule(moduleInfo, module));
            }

            pageResult.setItems(moduleInfoItems);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "listUI";
    }

    public String addUI(){
        return "addUI";
    }

    public String add(){

        if(module != null){
            moduleService.save(module);
        }
        return "list";
    }

    public String delete(){
        if( module != null && module.getId() != null){
            moduleService.delete(module.getId());
        }
        setPageNo(1);
        return "list";
    }

    public String editUI(){

        if(module != null && module.getId() != null)
        {
            module = moduleService.findById(module.getId());
        }

        return "editUI";
    }


    public String edit(){
        if(module != null){

            Module oldModule = moduleService.findById(module.getId());

            module.setModuleCheck(oldModule.getModuleCheck());
            module.setModuleRepairRecord(oldModule.getModuleRepairRecord());
            module.setDischargeForPPMRecords(oldModule.getDischargeForPPMRecords());

            moduleService.update(module);
        }
        return "list";
    }


    public IModuleService getModuleService() {
        return moduleService;
    }

    public void setModuleService(IModuleService moduleService) {
        this.moduleService = moduleService;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
