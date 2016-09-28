package com.envcheck.view.checkinfo.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.bean.Module;
import com.envcheck.base.bean.ModuleCheck;
import com.envcheck.base.bean.discharge_check_history.DischargeForPPMRecord;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.base.utils.StringUtils;
import com.envcheck.base.utils.ViewUtils;
import com.envcheck.paramsetting.checkrepairsetting.minchecktime.bean.MinCheckTime;
import com.envcheck.paramsetting.checkrepairsetting.minchecktime.service.IMinCheckTimeService;
import com.envcheck.paramsetting.checkrepairsetting.minchecktime.service.impl.MinCheckTimeService;
import com.envcheck.paramsetting.laws.bean.Law;
import com.envcheck.paramsetting.laws.service.ILawService;
import com.envcheck.view.checkinfo.bean.CheckInfo;
import com.envcheck.view.checkinfo.bean.EditCheckInfo;
import com.envcheck.view.checkinfo.service.IModuleCheckService;
import com.envcheck.view.moduleinfo.service.IModuleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by susion on 2016/5/11.
 */
public class CheckInfoAction  extends BaseAction{

    private IModuleCheckService moduleCheckService;
    private ModuleCheck moduleCheck;
    private ILawService lawService;
    private IModuleService moduleService;
    private Module module;
    private EditCheckInfo editCheckInfo;
    private IMinCheckTimeService minCheckTimeService;

    private String clearPPMNumberStart;
    private String clearPPMNumberEnd;

    private boolean editIsLeak;

    private int editPageNo;

    public String listUI(){

        try {

            QueryHelper qh = new QueryHelper(Module.class, "m");
            qh.addConditions("m.hasCheck = ?", true);

            //条件查询
            if (module!=null) {
                QueryHelper.addBaseConditionForModule(module, qh);
            }

            try {

                if(StringUtils.notIsNullAndEmptyString(clearPPMNumberStart) && StringUtils.notIsNullAndEmptyString(clearPPMNumberEnd)
                        && (Integer.valueOf(clearPPMNumberEnd) - Integer.valueOf(clearPPMNumberStart) > 0 )){
                    qh.setWhereClause(" and m.moduleCheck.PPMNumber between "+clearPPMNumberStart+" and"+" "+clearPPMNumberEnd);
                }
            }catch (Exception e){
                throw new RuntimeException("请确保ppm范围与数值输入正确!!");
            }

            qh.addOrderByProperty("labelNumber", QueryHelper.ORDER_BY_ASC);


            pageResult = moduleService.getPageResult(qh,  getPageNo(), getPageSize());

            List<CheckInfo> checkInfoItems = new ArrayList<>();
            List<Module> moduleItems = pageResult.getItems();

            //获取法规
            List<Law> laws = lawService.getAll();
            MinCheckTime minCheckTime = minCheckTimeService.getCurrentExecuteMinCheckTime();

            //生成检测信息对象供前台展示
            ModuleCheck moduleCheck;
            CheckInfo checkInfo;
            for(Module module : moduleItems){
                checkInfo = new CheckInfo();
                moduleCheck = module.getModuleCheck();

                checkInfoItems.add(ViewUtils.getCheckInfoByModule(checkInfo, module, moduleCheck, laws, minCheckTime));
            }

            pageResult.setItems(checkInfoItems);

        } catch (Exception e) {

        }

        return "listUI";
    }



    public String editUI(){

        if(moduleCheck != null){
            moduleCheck = moduleCheckService.findById(moduleCheck.getId());
            editIsLeak = moduleCheck.getModule().isLeak();
        }

        return "editUI";
    }

    public String edit(){


        Module tempModule = module;
      /*  if(moduleCheck != null){

            Module module = moduleCheck.getModule();
            if(module.isLeak()){
                moduleCheck.setLeakSource(module.getModelType());
            }
            moduleService.update(module);
            moduleCheckService.update(moduleCheck);
        }*/

        if(editCheckInfo != null){

            moduleCheck = moduleCheckService.findById(editCheckInfo.getModuleCheckId());
            module = moduleCheck.getModule();

            setEditModuleCheck(editCheckInfo, moduleCheck, module);

            if(editIsLeak){
                moduleCheck.setLeakSource(module.getModelType());
                module.setLeak(true);
            }else {
                moduleCheck.setLeakSource("");
                module.setLeak(false);
            }
            moduleService.update(module);
            moduleCheckService.update(moduleCheck);

        }

        module = tempModule;
        return currentPageNumber();
    }

    private String currentPageNumber() {

        try {

            QueryHelper qh = new QueryHelper(Module.class, "m");
            qh.addConditions("m.hasCheck = ?", true);


            pageResult = moduleService.getPageResult(qh,  editPageNo, getPageSize());

            List<CheckInfo> checkInfoItems = new ArrayList<>();
            List<Module> moduleItems = pageResult.getItems();

            //获取法规
            List<Law> laws = lawService.getAll();
            MinCheckTime minCheckTime = minCheckTimeService.getCurrentExecuteMinCheckTime();

            //生成检测信息对象供前台展示
            ModuleCheck moduleCheck;
            CheckInfo checkInfo;
            for(Module module : moduleItems){
                checkInfo = new CheckInfo();
                moduleCheck = module.getModuleCheck();

                checkInfoItems.add(ViewUtils.getCheckInfoByModule(checkInfo, module, moduleCheck, laws, minCheckTime));
            }

            pageResult.setItems(checkInfoItems);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "listUI";
    }


    private void setEditModuleCheck(EditCheckInfo editCheckInfo, ModuleCheck moduleCheck, Module module) {

        moduleCheck.setStartTime(editCheckInfo.getStartTime());
        moduleCheck.setEndTime(editCheckInfo.getEndTime());
        moduleCheck.setCheckPerson(editCheckInfo.getCheckPerson());

        if(editCheckInfo.getPPMNumber() != moduleCheck.getPPMNumber()){

            //将组件的 PPM集合中的值更改掉
            Set<DischargeForPPMRecord> ppmRecords = module.getDischargeForPPMRecords();
            replaceOldPPMvalue(editCheckInfo.getPPMNumber(), moduleCheck.getPPMNumber(), ppmRecords);

            moduleCheck.setPPMNumber(editCheckInfo.getPPMNumber());
        }

        moduleCheck.setBackgroundPPMNumber(editCheckInfo.getBackgroundPPMNumber());
        moduleCheck.setCheckEquipment(editCheckInfo.getCheckEquipment());
    }


    private void replaceOldPPMvalue(int newNumber, int oldNumber, Set<DischargeForPPMRecord> ppmRecords) {

        for(DischargeForPPMRecord record : ppmRecords){

            if(record.getCleanPPMValue() == oldNumber){
                record.setCleanPPMValue(newNumber);
            }
        }
    }

    public String delete(){

        if(moduleCheck != null){

            ModuleCheck temp = moduleCheckService.findById(moduleCheck.getId());
            Module module = temp.getModule();

            //解除关系
            temp.setModule(null);
            module.setModuleCheck(null);
            module.setHasAllocate(false);  //可以再次检测
            module.setTaskId("-1");
            module.setLeak(false);
            module.setHasCheck(false);

            moduleCheckService.update(temp);
            moduleCheckService.delete(moduleCheck.getId());
            moduleService.update(module);

        }

        return "list";
    }


    public boolean isEditIsLeak() {
        return editIsLeak;
    }

    public void setEditIsLeak(boolean editIsLeak) {
        this.editIsLeak = editIsLeak;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public IModuleCheckService getModuleCheckService() {
        return moduleCheckService;
    }

    public void setModuleCheckService(IModuleCheckService moduleCheckService) {
        this.moduleCheckService = moduleCheckService;
    }

    public void setModuleCheck(ModuleCheck moduleCheck) {
        this.moduleCheck = moduleCheck;
    }

    public ModuleCheck getModuleCheck() {
        return moduleCheck;
    }

    public ILawService getLawService() {
        return lawService;
    }

    public void setLawService(ILawService lawService) {
        this.lawService = lawService;
    }


    public void setModuleService(IModuleService moduleService) {
        this.moduleService = moduleService;
    }



    public EditCheckInfo getEditCheckInfo() {
        return editCheckInfo;
    }

    public void setEditCheckInfo(EditCheckInfo editCheckInfo) {
        this.editCheckInfo = editCheckInfo;
    }

    public void setMinCheckTimeService(IMinCheckTimeService minCheckTimeService) {
        this.minCheckTimeService = minCheckTimeService;
    }

    public String getClearPPMNumberStart() {
        return clearPPMNumberStart;
    }

    public void setClearPPMNumberStart(String clearPPMNumberStart) {
        this.clearPPMNumberStart = clearPPMNumberStart;
    }

    public String getClearPPMNumberEnd() {
        return clearPPMNumberEnd;
    }

    public void setClearPPMNumberEnd(String clearPPMNumberEnd) {
        this.clearPPMNumberEnd = clearPPMNumberEnd;
    }

    public int getEditPageNo() {
        return editPageNo;
    }

    public void setEditPageNo(int editPageNo) {
        this.editPageNo = editPageNo;
    }
}
