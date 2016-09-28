package com.envcheck.tool.batchmodifycheck.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.bean.Module;
import com.envcheck.base.bean.ModuleCheck;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.tool.batchmodifycheck.service.IBatchModifyCheckService;
import com.envcheck.tool.batchmodifymodule.bean.ModifyModuleInfo;
import org.apache.struts2.ServletActionContext;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by susion on 2016/5/11.
 */
public class BatchModifyCheckAction extends BaseAction{

    //封装数据
    private Module module;
    private ModifyModuleInfo modifyModuleInfo;
    private List<ModifyModuleInfo> modifyInfo = new ArrayList<>();

    //调用业务
    private IBatchModifyCheckService batchModifyCheckService;

    /**
     * 列表展示
     */
    public String listUI(){
        try {
            QueryHelper qh = new QueryHelper(Module.class,"m");
            //条件查询
            if (module!=null) {
                QueryHelper.addBaseConditionForModule(module, qh);
            }

            pageResult = batchModifyCheckService.getPageResult(qh,  getPageNo(), getPageSize());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "listUI";
    }

    /**
     *进入批量修改页面
     */
    public String editUI(){
        //得到选中的id
        if (selectedRow!=null){
            ServletActionContext.getRequest().getSession().setAttribute("selectedRows",selectedRow);
        }
        return "editUI";
    }

    /**
     *修改
     */
    public String edit(){

        if (module!=null) {
            //从域中  得到选中的id
            String[] selectedRows = (String[]) ServletActionContext.getRequest().getSession().getAttribute("selectedRows");
            if (selectedRows!=null){
                for (String id : selectedRows){
                    if(module.getDevice()!=null && !"".equals(module.getDevice())){
                        setInfo(id,"device",module.getDevice());
                    }
                    if(module.getArea()!=null && !"".equals(module.getArea())) {
                        setInfo(id,"area",module.getArea());
                    }
                    if(module.getEquipment()!=null && !"".equals(module.getEquipment())) {
                        setInfo(id,"equipment",module.getEquipment());
                    }
                    if(module.getLabelNumber()!=null && !"".equals(module.getLabelNumber())) {
                        setInfo(id,"labelNumber",module.getLabelNumber());
                    }
                    if(module.getExtendNumber()!=0) {
                        setInfo(id,"extendNumber",module.getExtendNumber());
                    }

                    if(module.getSizeMM()!=0) {
                        setInfo(id,"sizeMM",module.getSizeMM());
                    }

                    if(module.getPid()!=0 ) {
                        setInfo(id,"pid",module.getPid());
                    }
                    if(module.getDiffToCheck()!=null && !"".equals(module.getDiffToCheck())) {
                        setInfo(id, "diffToCheck", module.getDiffToCheck());
                    }
                    if(module.getAppendDesc()!=null && !"".equals(module.getAppendDesc())) {
                        setInfo(id,"appendDesc",module.getAppendDesc());
                    }
                    //结束时间
                    if(module.getModuleCheck().getEndTime()!=null && !"".equals(module.getModuleCheck().getEndTime())) {
                        Date endTime = module.getModuleCheck().getEndTime();
                        Module module = batchModifyCheckService.findById(id);
                        module.getModuleCheck().setEndTime(endTime);
                        batchModifyCheckService.update(module);
                    }
                    //是否延迟修复
                    if(module.getModuleCheck().getPushInDelayRepair()!=null && !"".equals(module.getModuleCheck().getPushInDelayRepair())) {
                        String pushInDelayRepair = module.getModuleCheck().getPushInDelayRepair();
                        Module module = batchModifyCheckService.findById(id);
                        module.getModuleCheck().setPushInDelayRepair(pushInDelayRepair);
                        batchModifyCheckService.update(module);
                    }
                    //组件类型编号
                    //ppm读数
                    if(module.getModuleCheck().getPPMNumber()!=0) {
                        int ppmNumber = module.getModuleCheck().getPPMNumber();
                        Module module = batchModifyCheckService.findById(id);
                        module.getModuleCheck().setPPMNumber(ppmNumber);
                        batchModifyCheckService.update(module);
                    }
                    //净ppm
                    if(module.getModuleCheck().getBackgroundPPMNumber()!=0) {
                        int backgroundPPMNumber = module.getModuleCheck().getBackgroundPPMNumber();
                        Module module = batchModifyCheckService.findById(id);
                        module.getModuleCheck().setBackgroundPPMNumber(backgroundPPMNumber);
                        batchModifyCheckService.update(module);

                    }
                    //泄漏源
                    if(module.getModuleCheck().getLeakSource()!=null && !"".equals(module.getModuleCheck().getLeakSource())) {
                        String leakSource = module.getModuleCheck().getLeakSource();
                        Module module = batchModifyCheckService.findById(id);
                        module.getModuleCheck().setLeakSource(leakSource);
                        batchModifyCheckService.update(module);
                    }
                    //泄漏
                    if(module.getModuleCheck().getLeakCheck()!=null && !"".equals(module.getModuleCheck().getLeakCheck())) {
                        String leakCheck = module.getModuleCheck().getLeakCheck();
                        Module module = batchModifyCheckService.findById(id);
                        module.getModuleCheck().setLeakCheck(leakCheck);
                        batchModifyCheckService.update(module);
                    }
                    //检测人
                    if(module.getModuleCheck().getCheckPerson()!=null && !"".equals(module.getModuleCheck().getCheckPerson())) {
                        String checkPerson = module.getModuleCheck().getCheckPerson();
                        Module module = batchModifyCheckService.findById(id);
                        module.getModuleCheck().setCheckPerson(checkPerson);
                        batchModifyCheckService.update(module);
                    }

                }
                batchModifyCheckService.batchModify(modifyInfo);
            }



        }

        return "list";
    }

    public void setInfo(String id,String name,Object obj){

        modifyModuleInfo = new ModifyModuleInfo();
        modifyModuleInfo.setId(id);
        modifyModuleInfo.setName(name);
        modifyModuleInfo.setObj(obj);
        modifyInfo.add(modifyModuleInfo);
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

    public IBatchModifyCheckService getBatchModifyCheckService() {
        return batchModifyCheckService;
    }

    public void setBatchModifyCheckService(IBatchModifyCheckService batchModifyCheckService) {
        this.batchModifyCheckService = batchModifyCheckService;
    }
}
