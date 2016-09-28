package com.envcheck.report.leakhistory.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.bean.Module;
import com.envcheck.base.bean.ModuleCheck;
import com.envcheck.base.dynamic_change_datasource.UserContextHolder;
import com.envcheck.base.utils.FileUtils;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.base.utils.StringUtils;
import com.envcheck.base.utils.ViewUtils;
import com.envcheck.paramsetting.laws.bean.Law;
import com.envcheck.paramsetting.laws.service.ILawService;
import com.envcheck.paramsetting.laws.service.impl.LawService;
import com.envcheck.view.checkinfo.bean.CheckInfo;
import com.envcheck.view.leakinfo.bean.LeakInfo;
import com.envcheck.view.moduleinfo.service.IModuleService;
import com.envcheck.view.moduleinfo.service.impl.ModuleService;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by susion on 2016/5/11.
 */
public class LeakHistoryAction extends BaseAction{

    private ILawService lawService;
    private String[] exportItem;
    private String downloadFileName;
    private Module module;
    private IModuleService moduleService;


    public String listUI(){
        return "listUI";
    }

    public InputStream getExportLeakInfoFile() throws FileNotFoundException {

        if (exportItem == null || exportItem.length < 1) {
            throw new RuntimeException("必须要选择导出列！");
        }

        QueryHelper qh = new QueryHelper(Module.class, "m");
        qh.addConditions("m.leak=?", true);

        if (module != null) {
            QueryHelper.addBaseConditionForModuleReport(module, qh);
        }

        List<Module> moduleItems = moduleService.getAll(qh);


        List<Law> laws = lawService.getAll();
        List<LeakInfo> leakInfoItems = new ArrayList<>();
        LeakInfo leakInfo;
        for(Module module : moduleItems){
            leakInfo = new LeakInfo();
            leakInfoItems.add(ViewUtils.getLeakInfoByModule(leakInfo, module, laws));
        }


        downloadFileName = "泄露历史"+StringUtils.formatDateForExportFile(new Date()) + ".xls";
        File exportExcelFile = new File(downloadFileName);

        if (exportItem != null && leakInfoItems.size() > 0) {
            try {
                FileUtils.exportLeakInfo(leakInfoItems, exportItem, exportExcelFile, UserContextHolder.getCurrentUser().getCompanyNameCN());
            } catch (Exception e) {

                throw new RuntimeException("导出文件失败");
            }
        }

        FileInputStream inputStream = new FileInputStream(exportExcelFile);
        return inputStream;

    }


    public String exportLeakInfo(){
        return "exportLeakInfo";
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

    public String[] getExportItem() {
        return exportItem;
    }

    public void setExportItem(String[] exportItem) {
        this.exportItem = exportItem;
    }

    public void setModuleService(IModuleService moduleService) {
        this.moduleService = moduleService;
    }


    public void setLawService(ILawService lawService) {
        this.lawService = lawService;
    }
}
