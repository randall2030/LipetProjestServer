package com.envcheck.report.modulefundaccount.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.bean.Module;
import com.envcheck.base.dynamic_change_datasource.UserContextHolder;
import com.envcheck.base.utils.FileUtils;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.base.utils.StringUtils;
import com.envcheck.view.moduleinfo.service.IModuleService;

import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * Created by susion on 2016/5/11.
 */
public class ModuleFundAccountAction extends BaseAction {

    private String[] exportItem;
    private Module module;
    private IModuleService moduleService;
    private String downloadFileName;

    public String listUI() {
        return "listUI";
    }

    public InputStream getExportModuleFile() {

        if (exportItem == null || exportItem.length < 1) {
            throw new RuntimeException("必须要选择导出列！");
        }

        QueryHelper qh = new QueryHelper(Module.class, "m");

        if (module != null) {
            QueryHelper.addBaseConditionForModuleReport(module, qh);
        }

        List<Module> moduleList = moduleService.getAll(qh);

        downloadFileName = "密封点基础台账"+StringUtils.formatDateForExportFile(new Date()) + ".xls";
        File exportExcelFile = new File(downloadFileName);


        if (exportItem != null && moduleList.size() > 0) {
            try {
                FileUtils.exportModuleExcel(moduleList, exportItem, exportExcelFile, UserContextHolder.getCurrentUser().getCompanyNameCN());

            } catch (Exception e) {
                throw new RuntimeException("导出文件失败");
            }
        }else{
            throw new RuntimeException("没有对应组件信息");
        }

        FileInputStream inputStream;

        try {
            inputStream  = new FileInputStream(exportExcelFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("导出文件失败");
        }

        return inputStream;
    }


    public String exportModule() {
        return "exportModuleFund";
    }


    public String[] getExportItem() {
        return exportItem;
    }

    public void setExportItem(String[] exportItem) {
        this.exportItem = exportItem;
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
}
