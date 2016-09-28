package com.envcheck.tool.importmodule.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.bean.Module;
import com.envcheck.base.dynamic_change_datasource.UserContextHolder;
import com.envcheck.base.exception.SysException;
import com.envcheck.base.utils.Constant;
import com.envcheck.base.utils.ExcelUtils;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.base.utils.StringUtils;
import com.envcheck.paramsetting.modelinfosetting.areamanage.bean.AreaInfo;
import com.envcheck.paramsetting.modelinfosetting.areamanage.service.IAreaInfoService;
import com.envcheck.paramsetting.modelinfosetting.devicemanage.bean.DeviceInfo;
import com.envcheck.paramsetting.modelinfosetting.devicemanage.service.IDeviceInfoService;
import com.envcheck.tool.importmodule.bean.ImportFileHistory;
import com.envcheck.tool.importmodule.service.IImportFileHistoryService;
import com.envcheck.view.moduleinfo.service.IModuleService;
import org.apache.struts2.ServletActionContext;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by susion on 2016/5/11.
 */
public class ImportModuleAction extends BaseAction{

    //Struts文件上传要求必须这样
    private File importModuleExcelFile;
    private String importModuleExcelFileFileName;
    private String importModuleExcelFileContentType;

    //装置管理和区域管理的Service
    private IDeviceInfoService deviceInfoService;
    private IAreaInfoService areaInfoService;

    private IModuleService moduleService;
    private IImportFileHistoryService importFileHistoryService;
    private List<Module> importModules = new ArrayList<>();

    public String listUI(){

        QueryHelper qh = new QueryHelper(ImportFileHistory.class, "d");  //d是表的别名

        pageResult = importFileHistoryService.getPageResult(qh,  getPageNo(), getPageSize());

        return "listUI";
    }


    public String importModuleFromExcel(){
        try
        {
            if(importModuleExcelFile != null)
            {
                String upDir = ServletActionContext.getServletContext().getRealPath(File.separator) + File.separator+ Constant.MODULE_XLS_UP_PATH;  //项目的根目录
                File upDirFile = new File(upDir);
                if(!upDirFile.exists()){
                    upDirFile.mkdirs();
                }

                File targetFile = new File(upDir, importModuleExcelFileFileName);
                FileCopyUtils.copy(importModuleExcelFile, targetFile);

                importModules = ExcelUtils.getModuleFromModuleExcel(targetFile);


                int newDataNmber = 0;
                int modifyDataNumber = 0;
                Module tempModule;
                for(Module module : importModules){

                    if( (tempModule = moduleService.findByLabelAndExtendNumber(module.getLabelNumber(), module.getExtendNumber())) != null){
                       module.setId(tempModule.getId());
                        module.setTaskId("-1");
                        setGlandNumber(module);
                        moduleService.update(module);
                        modifyDataNumber++;
                    }else{
                        setGlandNumber(module);
                        newDataNmber++;
                        moduleService.save(module);
                    }

                }


                //TODO:保存importFileHistory对象
                ImportFileHistory importFileHistory = new ImportFileHistory();
                importFileHistory.setImportFileName(importModuleExcelFileFileName);
                importFileHistory.setDiscardDataNumber(0);
                importFileHistory.setModifyDataNumber(modifyDataNumber);
                importFileHistory.setNewDataNumber(newDataNmber);
                importFileHistory.setCreateTime(new Date());
                importFileHistory.setCreatePerson(UserContextHolder.getCurrentUser().getUsername());
                importFileHistoryService.save(importFileHistory);

            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return "list";
    }

    private void setGlandNumber(Module module){

        StringBuilder builder = new StringBuilder();

        //装置名称和套数
        QueryHelper deviceHelper = new QueryHelper(DeviceInfo.class, "d");
        deviceHelper.addConditions("d.deviceName = ?", module.getDevice());
        DeviceInfo deviceInfo = deviceInfoService.findDeviceByDeviceName(deviceHelper);

        if(deviceInfo == null){
            throw  new RuntimeException("无对应装置信息");
        }

        builder.append(deviceInfo.getDeviceNumber());
        builder.append(deviceInfo.getSequenceNumber());


        //区域编码
        QueryHelper areaHelper = new QueryHelper(AreaInfo.class, "a");
        areaHelper.addConditions("a.areaName = ?", module.getArea());
        List<AreaInfo> areaInfos = areaInfoService.findAreaByAreaName(areaHelper);

        AreaInfo areaInfo = null;

        if(areaInfos != null){

            for(AreaInfo info : areaInfos){
                if(module.getDevice().equals(info.getDeviceName())){
                    areaInfo = info;
                }
            }
        }

        if(areaInfo == null){
            throw  new RuntimeException("无对应区域信息");
        }
        builder.append(areaInfo.getAreaNumber());

        //平台
        int floor=  (int)module.getFloor();
        if(floor < 10){
            builder.append("0"+floor);
        }else{
            builder.append(floor+"");
        }


        //编码
        builder.append(StringUtils.getLabelNumberLast4Bit(module.getLabelNumber()));

        //扩展号 = 密封点类型 + 数字
        builder.append(StringUtils.changeModuleTypeToLetter(module.getModelType()));

        int extendNumber = module.getExtendNumber() + 1;  //从1开始
        if(extendNumber < 10){
            builder.append("0"+extendNumber);
        }else{
            builder.append(extendNumber+"");
        }

        //液体状态
        builder.append(StringUtils.changeMediumStatusToLetter(module.getMediumStatus()));

        module.setGlandNumber(builder.toString());

    }


    public File getImportModuleExcelFile() {
        return importModuleExcelFile;
    }

    public void setImportModuleExcelFile(File importModuleExcelFile) {
        this.importModuleExcelFile = importModuleExcelFile;
    }

    public String getImportModuleExcelFileFileName() {
        return importModuleExcelFileFileName;
    }

    public void setImportModuleExcelFileFileName(String importModuleExcelFileFileName) {
        this.importModuleExcelFileFileName = importModuleExcelFileFileName;
    }

    public String getImportModuleExcelFileContentType() {
        return importModuleExcelFileContentType;
    }

    public void setImportModuleExcelFileContentType(String importModuleExcelFileContentType) {
        this.importModuleExcelFileContentType = importModuleExcelFileContentType;
    }

    public void setModuleService(IModuleService moduleService) {
        this.moduleService = moduleService;
    }

    public void setImportFileHistoryService(IImportFileHistoryService importFileHistoryService) {
        this.importFileHistoryService = importFileHistoryService;
    }


    public void setDeviceInfoService(IDeviceInfoService deviceInfoService) {
        this.deviceInfoService = deviceInfoService;
    }


    public void setAreaInfoService(IAreaInfoService areaInfoService) {

        this.areaInfoService = areaInfoService;
    }
}
