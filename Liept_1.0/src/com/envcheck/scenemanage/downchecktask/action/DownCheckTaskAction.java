package com.envcheck.scenemanage.downchecktask.action;

import com.envcheck.android.bean.DownTaskDesc;
import com.envcheck.base.action.BaseAction;
import com.envcheck.base.dynamic_change_datasource.DataSourceConstant;
import com.envcheck.base.dynamic_change_datasource.DataSourceContextHolder;
import com.envcheck.base.dynamic_change_datasource.UserContextHolder;
import com.envcheck.base.user.bean.User;
import com.envcheck.base.user.service.IUserService;
import com.envcheck.base.user.service.impl.UserService;
import com.envcheck.base.utils.Constant;
import com.envcheck.base.utils.FileUtils;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.base.utils.StringUtils;
import com.envcheck.paramsetting.devicetype.service.IDeviceTypeService;
import com.envcheck.paramsetting.devicetype.service.impl.DeviceTypeService;
import com.envcheck.paramsetting.modelinfosetting.devicemanage.service.IDeviceInfoService;
import com.envcheck.scenemanage.allocatetask.bean.Task;
import com.envcheck.scenemanage.allocatetask.service.ITaskService;
import com.envcheck.scenemanage.allocatetask.service.impl.TaskService;
import com.envcheck.view.checkinfo.service.IModuleCheckService;
import com.envcheck.view.checkinfo.service.impl.ModuleCheckService;
import com.envcheck.view.moduleinfo.service.IModuleService;
import com.envcheck.view.moduleinfo.service.impl.ModuleService;
import org.apache.struts2.ServletActionContext;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by susion on 2016/5/11.
 */
public class DownCheckTaskAction extends BaseAction{

    private ITaskService taskService;
    private IUserService userService;
    private Task task;
    private String downloadFileName;
    private String username;


    public String listUI(){

        QueryHelper qh = new QueryHelper(Task.class, "t");

        pageResult = taskService.getPageResult(qh,  getPageNo(), getPageSize());

        return "listUI";
    }

    public InputStream getTaskZipFile(){

        try {
            //生成检测任务
            if(task != null){
                //客户端的一次请求是可以这样切换数据库的
                DataSourceContextHolder.setDataSourceName(DataSourceConstant.datasourceMap.get(Constant.PEAK_COMPANY));
                User user = userService.findUserByName(username);
                UserContextHolder.setCurrentUser(user);
                DataSourceContextHolder.setDataSourceName(DataSourceConstant.datasourceMap.get(StringUtils.getCurrentDataSourceKey(user)));

                String taskBasePath = ServletActionContext.getServletContext().getRealPath(File.separator)+File.separator
                        +"tasks"+File.separator+DataSourceContextHolder.getDataSourceName();


                Date taskCreateTime  = taskService.getTaskCreateTime(this.task.getId());
                String taskName = taskService.getTaskName(this.task.getId());
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                downloadFileName = Constant.TASK_NAME_PRFIX+taskName+"-"+format.format(taskCreateTime)+".zip";
                return new FileInputStream(taskBasePath+File.separator+downloadFileName);

            }

        }catch (Exception e){

        }

        return null;
    }



    public String downCheckTask(){
        return "downCheckTask";
    }

    /** 提供转换编码后的供下载用的文件名 */
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


    public void setTaskService(ITaskService taskService) {
        this.taskService = taskService;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
}
