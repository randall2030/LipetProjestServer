package com.envcheck.view.delayrepairinfo.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.bean.Module;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.base.utils.ViewUtils;
import com.envcheck.paramsetting.laws.bean.Law;
import com.envcheck.paramsetting.laws.service.ILawService;
import com.envcheck.view.leakinfo.bean.LeakInfo;
import com.envcheck.view.moduleinfo.service.IModuleService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by susion on 2016/5/11.
 */
public class DelayRepairInfoAction extends BaseAction {

    private IModuleService moduleService;
    private ILawService lawService;
    private Module module;
    private List<LeakInfo> delayRepairInfos = new ArrayList<>();

    /**
     * 列表展示
     */
    public String listUI(){

        try {

            QueryHelper qh = new QueryHelper(Module.class, "m");
            qh.addConditions("m.hasCheck = ?", true);
            qh.addConditions("m.leak = ?", true);
            qh.addConditions("m.moduleRepairRecord.repairResult = ?", false);

            if(module != null){
                QueryHelper.addBaseConditionForModule(module, qh);
            }

            qh.setWhereClause("and m.moduleRepairRecord is not null");
            pageResult = moduleService.getPageResult(qh,  getPageNo(), getPageSize());
            List<Module> moduleCheckItems = pageResult.getItems();

            //获取法规
            List<Law> laws = lawService.getAll();

            //生成检测信息对象供前台展示
            LeakInfo leakInfo;
            for(Module module : moduleCheckItems){
                leakInfo = new LeakInfo();
                delayRepairInfos.add(ViewUtils.getLeakInfoByModule(leakInfo, module, laws));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "listUI";
    }


    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }


    public List<LeakInfo> getDelayRepairInfos() {
        return delayRepairInfos;
    }

    public void setDelayRepairInfos(List<LeakInfo> delayRepairInfos) {
        this.delayRepairInfos = delayRepairInfos;
    }


    public void setModuleService(IModuleService moduleService) {
        this.moduleService = moduleService;
    }


    public void setLawService(ILawService lawService) {
        this.lawService = lawService;
    }
}
