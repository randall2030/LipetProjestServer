package com.envcheck.report.modulepictureaccount.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.bean.Module;
import com.envcheck.base.dynamic_change_datasource.UserContextHolder;
import com.envcheck.base.utils.FileUtils;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.base.utils.StringUtils;
import com.envcheck.view.moduleinfo.service.IModuleService;
import com.envcheck.view.moduleinfo.service.impl.ModuleService;

import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * Created by susion on 2016/5/11.
 */
public class ModulePictureAccountAction extends BaseAction{

    private String downloadFileName;
    private Module module;
    private IModuleService moduleService;

    public String listUI(){
        return "listUI";
    }


    public InputStream  getExportModulePictureFile() throws FileNotFoundException {

        QueryHelper qh = new QueryHelper(Module.class, "m");

        if (module != null) {
            QueryHelper.addBaseConditionForModuleReport(module, qh);
        }

        List<Module> moduleList = moduleService.getAll(qh);
        downloadFileName = "组件图片台账"+StringUtils.formatDateForExportFile(new Date()) + ".xls";
        File exportExcelFile = new File(downloadFileName);

        if (moduleList.size() > 0) {
            try {
                FileUtils.exportModulePictureExcel(moduleList, exportExcelFile, UserContextHolder.getCurrentUser().getCompanyNameCN());
            } catch (Exception e) {

                throw new RuntimeException("导出文件失败");
            }
        }

        FileInputStream inputStream = new FileInputStream(exportExcelFile);
        return inputStream;
    }


    public String exportModulePicture(){
        return "exportModulePictureInfo";
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

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }


    public void setModuleService(IModuleService moduleService) {
        this.moduleService = moduleService;
    }
}
