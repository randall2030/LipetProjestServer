package com.envcheck.tool.batchmodifymodule.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.bean.Module;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.base.utils.StringUtils;
import com.envcheck.tool.batchmodifymodule.bean.ModifyModuleInfo;
import com.envcheck.tool.batchmodifymodule.service.IBatchModifyModuleService;
import com.envcheck.view.moduleinfo.service.IModuleService;
import com.envcheck.view.moduleinfo.service.impl.ModuleService;
import org.apache.struts2.ServletActionContext;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by susion on 2016/5/11.
 */
public class BatchModifyModuleAction extends BaseAction {

    //封装数据
    private Module module;
    private ModifyModuleInfo modifyModuleInfo;
    private IModuleService moduleService;


    private String modifyDevice;
    private String modifySizeMM;
    private String modifyPIDNumber;
    private String modifyModuleType;
    private String modifyEquipment;

    /**
     * 列表展示
     */
    public String listUI() {

        QueryHelper qh = new QueryHelper(Module.class, "m");
        //条件查询
        if (module != null) {
            QueryHelper.addBaseConditionForBathModityModule(module, qh);
        }

        pageResult = moduleService.getPageResult(qh, getPageNo(), getPageSize());

        return "listUI";
    }


    public String modifyDevice() {


        if (StringUtils.notIsNullAndEmptyString(modifyDevice)) {
            List<Module> modifyModules = getModifyModules();
            for (Module modifyModule : modifyModules) {
                modifyModule.setDevice(modifyDevice);
                moduleService.update(modifyModule);
            }
        }

        return "list";
    }


    public String modifySizeMM() {

        try {
            if (StringUtils.notIsNullAndEmptyString(modifySizeMM)) {

                List<Module> modifyModules = getModifyModules();
                for (Module modifyModule : modifyModules) {
                    modifyModule.setSizeMM(Integer.valueOf(modifySizeMM));
                    moduleService.update(modifyModule);
                }

            }
        } catch (Exception e) {
            throw new RuntimeException("请输入数字");
        }

        return "list";
    }


    public String modifyPIDNumber() {

        try {
            if (StringUtils.notIsNullAndEmptyString(modifyPIDNumber)) {

                List<Module> modifyModules = getModifyModules();
                for (Module modifyModule : modifyModules) {
                    modifyModule.setPid(Integer.valueOf(modifyPIDNumber));
                    moduleService.update(modifyModule);
                }

            }
        } catch (Exception e) {
            throw new RuntimeException("请输入数字");
        }

        return "list";
    }


    public String modifyModuleType() {


        if (StringUtils.notIsNullAndEmptyString(modifyModuleType)) {

            List<Module> modifyModules = getModifyModules();
            for (Module modifyModule : modifyModules) {
                modifyModule.setModelType(modifyModuleType);
                moduleService.update(modifyModule);
            }

        }

        return "list";
    }


    public String modifyEquipment() {


        if (StringUtils.notIsNullAndEmptyString(modifyEquipment)) {
            List<Module> modifyModules = getModifyModules();
            for (Module modifyModule : modifyModules) {
                modifyModule.setEquipment(modifyEquipment);
                moduleService.update(modifyModule);
            }

        }

        return "list";
    }

    private List<Module> getModifyModules() {

        QueryHelper qh = new QueryHelper(Module.class, "m");

        if (module != null) {
            QueryHelper.addBaseConditionForBathModityModule(module, qh);
        }

        return moduleService.getAll(qh);
    }


    public String getModifyEquipment() {
        return modifyEquipment;
    }

    public void setModifyEquipment(String modifyEquipment) {
        this.modifyEquipment = modifyEquipment;
    }

    public String getModifyModuleType() {
        return modifyModuleType;
    }

    public void setModifyModuleType(String modifyModuleType) {
        this.modifyModuleType = modifyModuleType;
    }

    public String getModifyPIDNumber() {
        return modifyPIDNumber;
    }

    public void setModifyPIDNumber(String modifyPIDNumber) {
        this.modifyPIDNumber = modifyPIDNumber;
    }

    public String getModifySizeMM() {
        return modifySizeMM;
    }

    public void setModifySizeMM(String modifySizeMM) {
        this.modifySizeMM = modifySizeMM;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public ModifyModuleInfo getModifyModuleInfo() {
        return modifyModuleInfo;
    }

    public void setModifyModuleInfo(ModifyModuleInfo modifyModuleInfo) {
        this.modifyModuleInfo = modifyModuleInfo;
    }


    public String getModifyDevice() {
        return modifyDevice;
    }

    public void setModifyDevice(String modifyDevice) {
        this.modifyDevice = modifyDevice;
    }

    public void setModuleService(IModuleService moduleService) {
        this.moduleService = moduleService;
    }
}
