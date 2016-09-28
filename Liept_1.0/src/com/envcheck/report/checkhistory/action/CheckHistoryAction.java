package com.envcheck.report.checkhistory.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.bean.Module;
import com.envcheck.base.bean.ModuleCheck;
import com.envcheck.base.dynamic_change_datasource.UserContextHolder;
import com.envcheck.base.utils.FileUtils;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.base.utils.StringUtils;
import com.envcheck.base.utils.ViewUtils;
import com.envcheck.paramsetting.checkrepairsetting.minchecktime.bean.MinCheckTime;
import com.envcheck.paramsetting.checkrepairsetting.minchecktime.service.IMinCheckTimeService;
import com.envcheck.paramsetting.checkrepairsetting.minchecktime.service.impl.MinCheckTimeService;
import com.envcheck.paramsetting.laws.bean.Law;
import com.envcheck.paramsetting.laws.service.ILawService;
import com.envcheck.view.checkinfo.bean.CheckInfo;
import com.envcheck.view.moduleinfo.service.IModuleService;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by susion on 2016/5/11.
 */
public class CheckHistoryAction extends BaseAction{

    private ILawService lawService;
    private String[] exportItem; 
    private String downloadFileName;
    private Module module;
    private IModuleService moduleService;
    private IMinCheckTimeService minCheckTimeService;

    public String listUI(){
        return "listUI";
    }


    public InputStream getExportCheckInfoFile() throws FileNotFoundException, ParseException {

        if (exportItem == null || exportItem.length < 1) {
            throw new RuntimeException("必须要选择导出列！");
        }

        QueryHelper qh = new QueryHelper(Module.class, "m");
        qh.addConditions("m.hasCheck=?", true);

        if (module != null) {
            QueryHelper.addBaseConditionForModuleReport(module, qh);
        }

        List<Module> moduleItems = moduleService.getAll(qh);


        //获取法规
        List<Law> laws = lawService.getAll();
        MinCheckTime minCheckTime = minCheckTimeService.getCurrentExecuteMinCheckTime();

        List<CheckInfo> checkInfoItems = new ArrayList<>();
        ModuleCheck moduleCheck;
        CheckInfo checkInfo;

        for(Module module : moduleItems) {
            checkInfo = new CheckInfo();
            moduleCheck = module.getModuleCheck();
            checkInfoItems.add(ViewUtils.getCheckInfoByModule(checkInfo, module, moduleCheck, laws, minCheckTime));
        }


        downloadFileName = "检测历史"+StringUtils.formatDateForExportFile(new Date()) + ".xlsx";
        File exportExcelFile = new File(downloadFileName);

        if (exportItem != null && checkInfoItems.size() > 0) {
            try {
                FileUtils.exportCheckInfo(checkInfoItems, exportItem, exportExcelFile, UserContextHolder.getCurrentUser().getCompanyNameCN());
            } catch (Exception e) {

                throw new RuntimeException("导出文件失败");
            }
        }else{
            throw new RuntimeException("无对应组件");
        }


        FileInputStream inputStream = new FileInputStream(exportExcelFile);
        return inputStream;

    }

    public String exportCheckInfo(){
        return "exportCheckInfo";
    }


    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public String[] getExportItem() {
        return exportItem;
    }

    public void setExportItem(String[] exportItem) {
        this.exportItem = exportItem;
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




    public void setLawService(ILawService lawService) {
        this.lawService = lawService;
    }


    public void setModuleService(IModuleService moduleService) {
        this.moduleService = moduleService;
    }

    public void setMinCheckTimeService(IMinCheckTimeService minCheckTimeService) {
        this.minCheckTimeService = minCheckTimeService;
    }
}
