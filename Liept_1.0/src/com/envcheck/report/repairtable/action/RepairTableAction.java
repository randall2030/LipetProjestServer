package com.envcheck.report.repairtable.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.bean.Module;
import com.envcheck.base.bean.ModuleRepairRecord;
import com.envcheck.base.bean.ModuleRepairUnit;
import com.envcheck.base.dynamic_change_datasource.UserContextHolder;
import com.envcheck.base.utils.FileUtils;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.base.utils.StringUtils;
import com.envcheck.base.utils.ViewUtils;
import com.envcheck.paramsetting.laws.bean.Law;
import com.envcheck.paramsetting.laws.service.ILawService;
import com.envcheck.paramsetting.laws.service.impl.LawService;
import com.envcheck.view.leakinfo.bean.LeakInfo;
import com.envcheck.view.moduleinfo.service.IModuleService;
import com.envcheck.view.moduleinfo.service.impl.ModuleService;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by susion on 2016/5/11.
 */
public class RepairTableAction extends BaseAction{

    private ILawService lawService;
    private String downloadFileName;
    private Module module;
    private IModuleService moduleService;
    private Date exportTime;

    public String listUI(){
        return "listUI";
    }


    public InputStream getExportRepairInfoFile() throws FileNotFoundException {


        QueryHelper qh = new QueryHelper(Module.class, "m");
        qh.addConditions("m.leak=?", true);

        if (module != null) {
            QueryHelper.addBaseConditionForModuleReport(module, qh);
        }


        List<Module> moduleItems = moduleService.getAll(qh);

        if(exportTime != null){
            moduleItems = excludeBeforeExportTimeModule(exportTime, moduleItems);
        }


        List<Law> laws = lawService.getAll();

        List<LeakInfo> leakInfoItems = new ArrayList<>();
        LeakInfo leakInfo;
        for(Module module : moduleItems){
            leakInfo = new LeakInfo();
            leakInfoItems.add(ViewUtils.getLeakInfoByModule(leakInfo, module, laws));
        }


        downloadFileName = "维修工单" + StringUtils.formatDateForExportFile(new Date()) + ".xls";
        File exportExcelFile = new File(downloadFileName);

        if (leakInfoItems.size() > 0) {
            try {
                FileUtils.exportRepairInfo(leakInfoItems, exportExcelFile, UserContextHolder.getCurrentUser().getCompanyNameCN());
            } catch (Exception e) {

                throw new RuntimeException("导出文件失败");
            }
        }

        FileInputStream inputStream = new FileInputStream(exportExcelFile);
        return inputStream;

    }

    private List<Module> excludeBeforeExportTimeModule(Date exportTime, List<Module> moduleItems) {

        List<Module> newModuleItems = new ArrayList<>();

        for(Module module : moduleItems){

            if(!exportTime.after(module.getModuleCheck().getStartTime())){
                newModuleItems.add(module);
            }

        }

        return  newModuleItems;

    }

    private Date getModuleRepairDate(Module module) {

        List<ModuleRepairUnit> repairRecordList = new ArrayList<>();
        repairRecordList.addAll(module.getModuleRepairRecord().getRepairRecordList());
        Date minDate = null;
        if(repairRecordList.size() > 0){
            minDate = repairRecordList.get(0).getRepairDate();

            for(ModuleRepairUnit unit : repairRecordList){

                if(minDate.after(unit.getRepairDate())){
                    minDate = unit.getRepairDate();
                }
            }
        }
        return minDate;
    }


    public Date getExportTime() {
        return exportTime;
    }

    public void setExportTime(Date exportTime) {
        this.exportTime = exportTime;
    }

    public String exportRepairInfo(){
        return "exportRepairInfo";
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public String getDownloadFileName() {
        try {

            downloadFileName = new String(downloadFileName.getBytes(), "ISO8859-1");
        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
        }
        return downloadFileName;

    }
    public void setDownloadFileName(String downloadFileName) {
        this.downloadFileName = downloadFileName;
    }

    public void setModuleService(IModuleService moduleService) {
        this.moduleService = moduleService;
    }


    public void setLawService(ILawService lawService) {
        this.lawService = lawService;
    }
}
