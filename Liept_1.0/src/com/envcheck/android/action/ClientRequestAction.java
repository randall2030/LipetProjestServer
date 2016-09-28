package com.envcheck.android.action;

import com.envcheck.android.bean.DownTaskDesc;
import com.envcheck.android.bean.DownTaskDescBig;
import com.envcheck.base.bean.*;
import com.envcheck.base.bean.discharge_check_history.DischargeForPPMRecord;
import com.envcheck.base.dynamic_change_datasource.DataSourceConstant;
import com.envcheck.base.dynamic_change_datasource.DataSourceContextHolder;
import com.envcheck.base.dynamic_change_datasource.UserContextHolder;
import com.envcheck.base.user.bean.User;
import com.envcheck.base.user.service.IUserService;
import com.envcheck.base.utils.*;
import com.envcheck.scenemanage.allocatetask.bean.Task;
import com.envcheck.scenemanage.allocatetask.service.ITaskService;
import com.envcheck.scenemanage.calibrate.bean.CalibrationInfo;
import com.envcheck.scenemanage.calibrate.bean.CalibrationListFromServer;
import com.envcheck.scenemanage.calibrate.service.ICalibrateService;
import com.envcheck.scenemanage.weatherparam.bean.WeatherListFromServer;
import com.envcheck.scenemanage.weatherparam.bean.WeatherParam;
import com.envcheck.scenemanage.weatherparam.service.IWeatherParamService;
import com.envcheck.view.checkinfo.service.IModuleCheckService;
import com.envcheck.view.moduleinfo.service.IModuleService;
import com.envcheck.view.repairinfo.service.IModuleRepairRecordService;
import com.envcheck.view.repairinfo.service.impl.ModuleRepairRecordService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.util.FileCopyUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by susion on 2016/6/5.
 */
public class ClientRequestAction extends ActionSupport {

    private String username;
    private String password;
    private IUserService userService;
    private ITaskService taskService;
    private IModuleCheckService moduleCheckService;
    private IWeatherParamService weatherParamService;
    private ICalibrateService calibrateService;
    private IModuleService moduleService;
    private IModuleRepairRecordService moduleRepairRecordService;


    private File file;
    //提交过来的file的名字
    private String fileFileName;

    //提交过来的file的MIME类型
    private String fileContentType;


    private String tempTaskPath;


    public void logIn() {

        if (username != null && password != null) {


            //切换数据库
            DataSourceContextHolder.setDataSourceName(DataSourceConstant.datasourceMap.get(Constant.PEAK_COMPANY));
            QueryHelper helper = new QueryHelper(User.class, "u");
            helper.addConditions("u.username=?", username);
            helper.addConditions("u.password=?", password);
            User user = userService.findUserByNameAndPassword(helper);

            if (user != null) {
                try {
                    PrintWriter printWriter = ServletActionContext.getResponse().getWriter();
                    if (user != null) {
                        printWriter.write("success");
                        printWriter.close();
                    } else {
                        printWriter.write("failed");
                        printWriter.close();
                    }
                } catch (Exception e) {

                }
            }

        }

    }

    public void getTaskInfo() {

        if (username != null) {
            //客户端的一次请求是可以这样切换数据库的
            DataSourceContextHolder.setDataSourceName(DataSourceConstant.datasourceMap.get(Constant.PEAK_COMPANY));
            User user = userService.findUserByName(username);
            String dataSourceName = DataSourceConstant.datasourceMap.get(StringUtils.getCurrentDataSourceKey(user));

            //切换到该user对应的数据库
            DataSourceContextHolder.setDataSourceName(dataSourceName);

            List<DownTaskDescBig> downTaskDescBigs = taskService.getAllDownTaskDescBigByUsername(username);
            ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

            if (downTaskDescBigs != null && downTaskDescBigs.size() > 0) {

                List<DownTaskDesc> downTaskDescs = new ArrayList<>();

                for (final DownTaskDescBig downTaskDescBig : downTaskDescBigs) {

                    DownTaskDesc desc = downTaskDescBig.getDownTaskDesc();
                    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date createTime = downTaskDescBig.getTaskCreateTime();
                    final String downloadFileName = Constant.TASK_NAME_PRFIX + desc.getTaskName() + "-" + format.format(createTime) + ".zip";

                    //更新URL的下载人
                    desc.setDownUrl(desc.getDownUrl()+"&username="+user.getUsername());

                    downTaskDescs.add(desc);
                    final String taskSaveLocalPath = downTaskDescBig.getTaskLocalSavePath();


                    final String taskBasePath = ServletActionContext.getServletContext().getRealPath(File.separator)
                            + File.separator+"tasks"+File.separator+dataSourceName;

                    //判断 任务压缩文件是否存在， 如果存在则不生成
                    File taskPressFile = new File(taskBasePath+File.separator+downloadFileName);
                    if(!taskPressFile.exists()){
                        cachedThreadPool.execute(new Runnable() {
                            @Override
                            public void run() {
                                FileUtils.createPreeTaskForDownload(downloadFileName, new File(taskSaveLocalPath),
                                        new File(taskBasePath));
                            }
                        });
                    }
                }

                try {
                    Gson gson = new Gson();
                    PrintWriter printWriter = ServletActionContext.getResponse().getWriter();
                    String returnString = gson.toJson(downTaskDescs);
                    printWriter.write(returnString);
                    printWriter.close();
                } catch (Exception e) {

                }

            }
        }

    }

    public void upCheckTask() throws Exception {

        if (username != null) {

            DataSourceContextHolder.setDataSourceName(DataSourceConstant.datasourceMap.get(Constant.PEAK_COMPANY));
            User user = userService.findUserByName(username);

            if (user != null) {

                String dataSourceName = DataSourceConstant.datasourceMap.get(StringUtils.getCurrentDataSourceKey(user));

                DataSourceContextHolder.setDataSourceName(dataSourceName);

                final Gson gson = new Gson();

                String upTaskPath = ServletActionContext.getServletContext().getRealPath(File.separator) + File.separator
                        +"upload"+File.separator+dataSourceName+File.separator+"checkTask";

                File upDir = new File(upTaskPath);

                if (!upDir.exists()) {
                    upDir.mkdirs();
                }

                final File targetFile = new File(upDir, fileFileName);
                FileCopyUtils.copy(file, targetFile);


                File upFileDir = new File(upTaskPath + File.separator + fileFileName.substring(0, fileFileName.indexOf('.')));

                if(upFileDir.exists()){
                    FileUtils.deleteDir(upTaskPath + File.separator + fileFileName.substring(0, fileFileName.indexOf('.')));
                }


                FileUtils.unZipFiles(targetFile, upTaskPath);

                updateCheckInfoToDatabase(gson, upFileDir);

            }

        }
    }



    private void updateCheckInfoToDatabase(Gson gson, File upFileDir) {

        Task task = null;
        File[] upLoadCheckTaskDirs = upFileDir.listFiles();

        for (File file : upLoadCheckTaskDirs) {

            if (file.isDirectory()) {

                if (file.getName().equals("ExtraInfo")) {

                    File[] extraInfoFiles = file.listFiles();

                    for (File extraFile : extraInfoFiles) {

                        if (extraFile.getName().equals("calibration.txt")) {
                            CalibrationListFromServer calibrationInfoList = gson.fromJson(FileUtils.getStringFromFile(extraFile), CalibrationListFromServer.class);
                            for (CalibrationInfo calibrationInfo : calibrationInfoList.getCalibrationInfoList()) {

                                if (calibrateService.findById(calibrationInfo.getId()) != null) {
                                    calibrateService.update(calibrationInfo);
                                } else {
                                    calibrateService.save(calibrationInfo);
                                }

                            }
                        }



                        if (extraFile.getName().equals("weather.txt")) {
                            WeatherListFromServer weatherParamList = gson.fromJson(FileUtils.getStringFromFile(extraFile), WeatherListFromServer.class);

                            for (WeatherParam weatherParam : weatherParamList.getWeatherInfoList()) {
                                String id = weatherParam.getId();
                                if(id != null){
                                    if (weatherParamService.findById(id) != null) {
                                        weatherParamService.update(weatherParam);
                                    }else{
                                        weatherParamService.save(weatherParam);
                                    }
                                }
                            }


                        }
                        if (extraFile.getName().equals("task.txt")) {
                            task = gson.fromJson(FileUtils.getStringFromFile(extraFile), Task.class);

                            if(task.getTotal() < (task.getHasCheck() + 3)){
                                task.setStop(true);
                            }
                            taskService.update(task);
                        }
                    }
                } else {
                    //检测的标签文件
                    File[] labelFiles = file.listFiles();
                    CheckTaskForLabel checkTaskForLabel;
                    for (File labelFile : labelFiles) {
                        String fileName = labelFile.getName();

                        if (fileName.substring(fileName.indexOf('.')).equals(".txt")) {
                            //解析所有检测信息， 插入到数据库
                            checkTaskForLabel = gson.fromJson(FileUtils.getStringFromFile(labelFile), CheckTaskForLabel.class);
                            List<CheckTaskForModule> moduleTasks = checkTaskForLabel.getModuleTasks();

                            for (CheckTaskForModule checkTaskForModule : moduleTasks) {
                                ModuleCheck moduleCheck = checkTaskForModule.getModuleCheck();
                                Module module = checkTaskForModule.getModule();

                                //没有进行检测 则把modulecheck对象清除, 释放任务，并使之可以重新分配
                                if (!module.isHasCheck()) {
                                    module.setTaskId("-1");
                                    module.setHasAllocate(false);
                                    module.setModuleCheck(null);
                                    moduleService.update(module);
                                    moduleCheckService.delete(moduleCheck.getId());

                                } else {

                                   if (Constant.TASK_TYPE_COMMON_CHECK.equals(task.getCheckType())) {
                                        //维护 排放相关信息
                                        DischargeForPPMRecord record = new DischargeForPPMRecord();
                                        record.setCheckTime(moduleCheck.getStartTime());
                                        record.setCleanPPMValue(moduleCheck.getPPMNumber());
                                        record.setEndPeriodRecord(false);

                                       Set<DischargeForPPMRecord> dischargeForPPMRecords = module.getDischargeForPPMRecords();
                                       if(recordNotInPPMRecords(record, dischargeForPPMRecords)){
                                           dischargeForPPMRecords.add(record);
                                       }
                                   }


                                    if(task.getCheckType().equals(Constant.TASK_TYPE_REPEATE_CHECK)){
                                        ModuleRepairRecord moduleRepairRecord = checkTaskForModule.getModuleRepairRecord();
                                        module.setModuleRepairRecord(moduleRepairRecord);
                                        DischargeForPPMRecord record = new DischargeForPPMRecord();
                                        ModuleRepairUnit unit = TaskUtils.findLatestModuleRepairUnit(moduleRepairRecord);

                                        if(unit != null){
                                            record.setCleanPPMValue(unit.getRepeateCheckValue());
                                            record.setCheckTime(unit.getRepeateCheckDate());

                                            Set<DischargeForPPMRecord> dischargeForPPMRecords = module.getDischargeForPPMRecords();
                                            if(recordNotInPPMRecords(record, dischargeForPPMRecords)){
                                                dischargeForPPMRecords.add(record);
                                            }
                                        }

                                        moduleRepairRecord.setModule(module);
                                        moduleRepairRecordService.update(moduleRepairRecord);
                                    }



                                    module.setModuleCheck(moduleCheck);
                                    moduleService.update(module);     //上传代码

                                    moduleCheck.setModule(module);
                                    moduleCheckService.update(moduleCheck);   //上传代码


                                }
                            }

                        }
                    }
                }

            }

        }


    }

    private boolean recordNotInPPMRecords(DischargeForPPMRecord record, Set<DischargeForPPMRecord> dischargeForPPMRecords) {

        String date = StringUtils.formatDate(record.getCheckTime());

        for(DischargeForPPMRecord r : dischargeForPPMRecords){
            if(date.equals(StringUtils.formatDate(r.getCheckTime()))){
                return false;
            }
        }
        return true;
    }

    public String tempUpTask(){

        String imagesRealPath = ServletActionContext.getServletContext().getRealPath(File.separator)+File.separator+ Constant.IMAGE_BASE_PATH;
        String upTaskPath = imagesRealPath + File.separator + tempTaskPath;
        File upTaskFile = new File(upTaskPath);
        Gson gson = new Gson();
        updateCheckInfoToDatabase(gson,upTaskFile);

        return "list";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public void setTaskService(ITaskService taskService) {
        this.taskService = taskService;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public void setModuleCheckService(IModuleCheckService moduleCheckService) {
        this.moduleCheckService = moduleCheckService;

    }

    public void setWeatherParamService(IWeatherParamService weatherParamService) {
        this.weatherParamService = weatherParamService;
    }

    public void setCalibrateService(ICalibrateService calibrateService) {
        this.calibrateService = calibrateService;
    }

    public String getTempTaskPath() {
        return tempTaskPath;
    }

    public void setTempTaskPath(String tempTaskPath) {
        this.tempTaskPath = tempTaskPath;
    }

    public void setModuleService(IModuleService moduleService) {
        this.moduleService = moduleService;
    }

    public void setModuleRepairRecordService(IModuleRepairRecordService moduleRepairRecordService) {
        this.moduleRepairRecordService = moduleRepairRecordService;
    }

}
