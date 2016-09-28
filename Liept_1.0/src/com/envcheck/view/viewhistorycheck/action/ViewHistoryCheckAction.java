package com.envcheck.view.viewhistorycheck.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.bean.Module;
import com.envcheck.base.bean.discharge_check_history.CheckPeriodRecord;
import com.envcheck.base.bean.discharge_check_history.DischargeForPPMRecord;
import com.envcheck.base.bean.discharge_check_history.HistoryModuleCheck;
import com.envcheck.base.bean.discharge_check_history.HistoryModuleRepairRecord;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.base.utils.StringUtils;
import com.envcheck.base.utils.ViewUtils;
import com.envcheck.paramsetting.laws.bean.Law;
import com.envcheck.paramsetting.laws.service.ILawService;
import com.envcheck.paramsetting.laws.service.impl.LawService;
import com.envcheck.tool.startnewcheck.service.ICheckPeroidRecordService;
import com.envcheck.tool.startnewcheck.service.IHistoryModuleCheckService;
import com.envcheck.tool.startnewcheck.service.IHistoryModuleRepairRecordService;
import com.envcheck.tool.startnewcheck.service.impl.CheckPeroidRecordService;
import com.envcheck.view.moduleinfo.bean.ModuleInfo;
import com.envcheck.view.moduleinfo.service.IModuleService;
import com.envcheck.view.viewhistorycheck.bean.HistoryModuleCheckInfo;
import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by susion on 2016/8/5.
 */
public class ViewHistoryCheckAction  extends BaseAction{

    private IModuleService moduleService;
    private IHistoryModuleCheckService historyModuleCheckService;
    private IHistoryModuleRepairRecordService historyModuleRepairRecordService;
    private ICheckPeroidRecordService checkPeriodRecordService;
    private ILawService lawService;
    private Module module;
    private String endPeriodName;

    private List<HistoryModuleCheckInfo> historyInfos = new ArrayList<>();


    public String listUI(){
        return "listUI";
    }

    public String selectListUI(){
        try {

            QueryHelper qh = new QueryHelper(Module.class, "m");
            //条件查询
            if (module!=null) {
                QueryHelper.addBaseConditionForModule(module, qh);
            }

          //  qh.addOrderByProperty("labelNumber", QueryHelper.ORDER_BY_ASC);

            pageResult = moduleService.getPageResult(qh,  getPageNo(), getPageSize());
            List<ModuleInfo> moduleInfoItems = new ArrayList<>();
            List<Module> moduleItems = pageResult.getItems();
            List<Law> laws = lawService.getAll();

            CheckPeriodRecord checkPeriodRecord = checkPeriodRecordService.getCheckPeroidRecordByName(endPeriodName);



            if(checkPeriodRecord != null){

                HistoryModuleCheckInfo info;
                HistoryModuleCheck historyModuleCheck;
                HistoryModuleRepairRecord historyModuleRepairRecord;

                for(Module module : moduleItems){
                    info = new HistoryModuleCheckInfo();

                    historyModuleCheck = historyModuleCheckService.getHistoryModuleCheckByModuleIdAndEndPeriodTime(module.getId(), checkPeriodRecord.getPeriodEndTime());
                    historyModuleRepairRecord = historyModuleRepairRecordService.getHistoryModuleRepairRecordByModuleIdAndEndPeriodTime(module.getId(), checkPeriodRecord.getPeriodEndTime());

                    BeanUtils.copyProperties(info, module);
                    info.setThresholdValue(StringUtils.getLeakThresholdValueFromLaw(module, ViewUtils.getLawByLawDesc(module.getLaws(), laws)));
                    info.setPeriodEndValue(getPeriodEndValue(module, checkPeriodRecord.getPeriodEndTime()));

                    if(historyModuleCheck != null && historyModuleCheck.getCheckEquipment() != null){
                        info.setCheckEquipment(historyModuleCheck.getCheckEquipment());
                        info.setCheckPerson(historyModuleCheck.getCheckPerson());
                    }


                    String absoultePicturePath = module.getPicturePath();
                    if(absoultePicturePath != null){
                        String subPath = absoultePicturePath.substring(absoultePicturePath.indexOf("images\\"));
                        String markPath = subPath.substring(0, subPath.lastIndexOf('\\'));
                        info.setMarkPictureSavePath(markPath);
                    }

                    historyInfos.add(info);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "listUI";
    }


    private int getPeriodEndValue(Module module, Date periodEndTime) {

        Set<DischargeForPPMRecord> dischargeForPPMRecords = module.getDischargeForPPMRecords();

        for(DischargeForPPMRecord record : dischargeForPPMRecords){
            if(!record.getCheckTime().before(periodEndTime) && !record.getCheckTime().after(periodEndTime)){
                return  record.getCleanPPMValue();
            }
        }

        return -1;
    }


    public void findPeriodName() throws IOException {

        List<String> periodNameList;
        periodNameList = checkPeriodRecordService.getAllPeriodName();

        Gson gson = new Gson();
        String jsonStr = gson.toJson(periodNameList);
        PrintWriter writer = ServletActionContext.getResponse().getWriter();
        writer.write(jsonStr);
        writer.close();

    }


    public void setModuleService(IModuleService moduleService) {
        this.moduleService = moduleService;
    }


    public void setHistoryModuleCheckService(IHistoryModuleCheckService historyModuleCheckService) {
        this.historyModuleCheckService = historyModuleCheckService;
    }


    public void setHistoryModuleRepairRecordService(IHistoryModuleRepairRecordService historyModuleRepairRecordService) {
        this.historyModuleRepairRecordService = historyModuleRepairRecordService;
    }


    public String getEndPeriodName() {
        return endPeriodName;
    }

    public void setEndPeriodName(String endPeriodName) {
        this.endPeriodName = endPeriodName;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public void setLawService(ILawService lawService) {
        this.lawService = lawService;
    }


    public void setCheckPeroidRecordService(ICheckPeroidRecordService checkPeroidRecordService) {
        this.checkPeriodRecordService = checkPeroidRecordService;
    }

    public List<HistoryModuleCheckInfo> getHistoryInfos() {
        return historyInfos;
    }

    public void setHistoryInfos(List<HistoryModuleCheckInfo> historyInfos) {
        this.historyInfos = historyInfos;
    }
}


