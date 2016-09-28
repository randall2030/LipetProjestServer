package com.envcheck.view.leakinfo.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.bean.Module;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.base.utils.ViewUtils;
import com.envcheck.paramsetting.laws.bean.Law;
import com.envcheck.paramsetting.laws.service.ILawService;
import com.envcheck.view.checkinfo.service.IModuleCheckService;
import com.envcheck.view.leakinfo.bean.LeakInfo;
import com.envcheck.view.moduleinfo.service.IModuleService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by susion on 2016/5/11.
 */
public class LeakInfoAction  extends BaseAction{

    private IModuleService moduleService;
    private IModuleCheckService moduleCheckService;
    private ILawService lawService;
    private Module module;
    private List<LeakInfo> leakInfos = new ArrayList<>();

    public String listUI(){
        try {

            QueryHelper qh = new QueryHelper(Module.class, "m");
            qh.addConditions("m.hasCheck = ?", true);
            qh.addConditions("m.leak = ?", true);

            if(module != null){
                QueryHelper.addBaseConditionForModule(module, qh);
            }

            pageResult = moduleService.getPageResult(qh,  getPageNo(), getPageSize());
            List<Module> moduleCheckItems = pageResult.getItems();

            //获取法规
            List<Law> laws = lawService.getAll();

            //生成检测信息对象供前台展示
            LeakInfo leakInfo;
            for(Module module : moduleCheckItems){
                leakInfo = new LeakInfo();
                leakInfos.add(ViewUtils.getLeakInfoByModule(leakInfo, module, laws));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "listUI";

    }


    public List<LeakInfo> getLeakInfos() {
        return leakInfos;
    }

    public void setLeakInfos(List<LeakInfo> leakInfos) {
        this.leakInfos = leakInfos;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public void setModuleService(IModuleService moduleService) {
        this.moduleService = moduleService;
    }


    public void setModuleCheckService(IModuleCheckService moduleCheckService) {
        this.moduleCheckService = moduleCheckService;
    }


    public void setLawService(ILawService lawService) {
        this.lawService = lawService;
    }
}
