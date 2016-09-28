package com.envcheck.tool.importpicture.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.bean.Module;
import com.envcheck.base.exception.SysException;
import com.envcheck.base.utils.Constant;
import com.envcheck.base.utils.ExcelUtils;
import com.envcheck.base.utils.FileUtils;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.devicetype.bean.DeviceType;
import com.envcheck.tool.importmodule.bean.ImportFileHistory;
import com.envcheck.tool.importmodule.service.IImportFileHistoryService;
import com.envcheck.tool.importpicture.bean.ImportPictureHistory;
import com.envcheck.tool.importpicture.service.IImportPictureHistoryService;
import com.envcheck.view.moduleinfo.service.IModuleService;
import com.envcheck.view.moduleinfo.service.impl.ModuleService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by susion on 2016/5/11.
 */
public class ImportPictureAction extends BaseAction{

    private IImportPictureHistoryService importPictureHistoryService;
    private IModuleService moduleService;
    private String picturePath;

    public String listUI(){

        QueryHelper qh = new QueryHelper(ImportPictureHistory.class, "i");  //d是表的别名

        pageResult = importPictureHistoryService.getPageResult(qh,  getPageNo(), getPageSize());

        return "listUI";
    }


    public String importPicture() throws SysException {

        String imagesRealPath = ServletActionContext.getServletContext().getRealPath(File.separator)+File.separator+ Constant.IMAGE_BASE_PATH;
        String parentDirPath = imagesRealPath + File.separator + picturePath;
        File parentDir = new File(parentDirPath);

        if(picturePath == null){
            throw  new RuntimeException("图片路径不正确");
        }

        if(picturePath != null){

            File[] labelDirs = parentDir.listFiles();
            ImportPictureHistory pictureHistory = null;

            for(File labelDir : labelDirs){
                if(labelDir.isDirectory() && labelDir.listFiles().length != 0){

                    File[] labelFiles = labelDir.listFiles();
                    pictureHistory = new ImportPictureHistory();

                    Gson gson = new Gson();
                    for(File file : labelFiles){
                        if(file.getName().equals("handle.jpg")){
                            String tempPath = picturePath+File.separator+labelDir.getName()+File.separator+"handle.jpg";
                            pictureHistory.setMarkPictureSavePath(tempPath);
                        }

                        if(file.getName().equals("unhandle.jpg")){
                            pictureHistory.setOriginalPictureSavePath(picturePath+File.separator+labelDir.getName()+File.separator+"unhandle.jpg");
                        }
                    }


                    pictureHistory.setImportTime(new Date());
                    pictureHistory.setImportPictureLabelNumber(labelDir.getName());


                    //将图片与组件相关联
                    List<Module> modules = moduleService.getAllByLabelNumber(pictureHistory.getImportPictureLabelNumber());
                    for(Module module : modules){
                        module.setPicturePath(imagesRealPath+File.separator +pictureHistory.getOriginalPictureSavePath());  //将组件的图片设置为 unhandle.jpg
                        moduleService.update(module);
                    }

                    pictureHistory.setContainModuleNumber(modules.size());

                    //判断是更新还是 直接保存
                    ImportPictureHistory historyByLabel = importPictureHistoryService.findPictureHistoryByLabel(pictureHistory.getImportPictureLabelNumber());
                    if( historyByLabel != null){
                        // importPictureHistoryService.update(historyByLabel);
                    }else{
                        importPictureHistoryService.save(pictureHistory);
                    }

                }
            }
        }

        return "list";
    }



    public IImportPictureHistoryService getImportPictureHistoryService() {
        return importPictureHistoryService;
    }

    public void setImportPictureHistoryService(IImportPictureHistoryService importPictureHistoryService) {
        this.importPictureHistoryService = importPictureHistoryService;
    }


    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }


    public void setModuleService(IModuleService moduleService) {
        this.moduleService = moduleService;
    }
}
