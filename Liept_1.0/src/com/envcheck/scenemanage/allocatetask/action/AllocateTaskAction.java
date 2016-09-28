package com.envcheck.scenemanage.allocatetask.action;

import com.envcheck.android.bean.LayoutBean;
import com.envcheck.android.bean.Point;
import com.envcheck.base.action.BaseAction;
import com.envcheck.base.bean.*;
import com.envcheck.base.dynamic_change_datasource.DataSourceContextHolder;
import com.envcheck.base.dynamic_change_datasource.UserContextHolder;
import com.envcheck.base.user.bean.User;
import com.envcheck.base.utils.*;
import com.envcheck.paramsetting.checkrepairsetting.checkapparatus.bean.CheckApparatus;
import com.envcheck.paramsetting.checkrepairsetting.checkapparatus.bean.CheckApparatusListFromServer;
import com.envcheck.paramsetting.checkrepairsetting.checkapparatus.service.ICheckApparatusService;
import com.envcheck.paramsetting.checkrepairsetting.minchecktime.bean.MinCheckTime;
import com.envcheck.paramsetting.checkrepairsetting.minchecktime.service.IMinCheckTimeService;
import com.envcheck.paramsetting.laws.bean.Law;
import com.envcheck.paramsetting.laws.service.ILawService;
import com.envcheck.scenemanage.allocatetask.bean.Task;
import com.envcheck.scenemanage.allocatetask.bean.TaskConditionSelect;
import com.envcheck.scenemanage.allocatetask.service.ITaskService;
import com.envcheck.scenemanage.calibrate.bean.CalibrationListFromServer;
import com.envcheck.scenemanage.weatherparam.bean.WeatherListFromServer;
import com.envcheck.view.checkinfo.service.IModuleCheckService;
import com.envcheck.view.moduleinfo.service.IModuleService;
import com.envcheck.view.repairinfo.service.IModuleRepairRecordService;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by susion on 2016/5/11.
 */

public class AllocateTaskAction extends BaseAction{

    private ITaskService taskService;
    private IModuleService moduleService;
    private IModuleCheckService moduleCheckService;
    private ILawService lawService;
    private ICheckApparatusService checkApparatusService;
    private IMinCheckTimeService minCheckTimeService;
    private IModuleRepairRecordService moduleRepairRecordService;

    private Module module;
    private Task task;
    private TaskConditionSelect selectCondition;

    // for add module to task
    private String labelPath;
    private CheckTaskForLabel labelTask;
    private String currentLabel;

    /**
     *列表展示
     */
    public String listUI(){

        try {

            QueryHelper qh = new QueryHelper(Task.class, "t");
            //查询
            if(task != null){
                if (!"全部".equals(task.getCheckType())){
                    task.setCheckType(URLDecoder.decode(task.getCheckType(),"utf-8"));
                    qh.addConditions("t.checkType = ?", task.getCheckType());
                }
            }

            pageResult = taskService.getPageResult(qh,  getPageNo(), getPageSize());

        }catch (Exception e){

        }
        return "listUI";
    }

    public String addUI(){
        return "addUI";
    }

    /**
     * 添加
     */
    public String add(){

        if(task != null){

            //设置创建人
           // User currentUser = Constant.currentUser;
            User currentUser = UserContextHolder.getCurrentUser();
            if(currentUser != null){
                task.setCreatePerson(currentUser.getUsername());
                task.setModifyPerson(currentUser.getUsername());
            }

            task.setHasCheck(0);
            task.setLeak(0);

            task.setDor(0);
            task.setTotal(0);
            task.setCreateTime(new Date());
            task.setModifyTime(new Date());


            //获得当前登录系统的user 信息
            task.setUser(currentUser.getUsername());

            String currentDataSourceKey = StringUtils.getCurrentDataSourceKey(currentUser);
            Constant.setTASKS_BASE_PATH(currentDataSourceKey);
            //生成对应的任务文件夹
            String taskBasePath = ServletActionContext.getServletContext().getRealPath(File.separator)+File.separator+Constant.TASKS_BASE_PATH;
            String taskDir = TaskUtils.createTaskDir(taskBasePath, task.getTaskName());

            task.setLocalSavePath(taskDir);
            taskService.save(task);

            String extraInfoDir = TaskUtils.createExtraInfoDir(taskDir);

            //创建一个任务所需要的基本信息json文件
            TaskUtils.writeTaskJsonTxtToFile(extraInfoDir, task);

            //需要客户端填写的天气五参数， 仪器校准等。。预备json文件
            WeatherListFromServer weatherParams  = new WeatherListFromServer();
            TaskUtils.writeWeatherJsonTxtToFile(extraInfoDir, weatherParams);

            CalibrationListFromServer calibrationListFromServer = new CalibrationListFromServer();
            TaskUtils.writeCalibrationInfoJsonTxtToFile(extraInfoDir, calibrationListFromServer);

            //校准仪器
            QueryHelper qhC = new QueryHelper(CheckApparatus.class, "c");
            List<CheckApparatus> checkApparatuses = checkApparatusService.getAll(qhC);

            CheckApparatusListFromServer checkApparatusListFromServer = new CheckApparatusListFromServer();
            List<CheckApparatus> list = checkApparatusListFromServer.getCheckApparatusList();

            for(CheckApparatus apparatus : checkApparatuses){
                list.add(apparatus);
            }

            TaskUtils.writCheckApparatusJsonTxtToFile(extraInfoDir, checkApparatusListFromServer);


            //最小检测时间 和 法规信息
            MinCheckTime minCheckTime = minCheckTimeService.getCurrentExecuteMinCheckTime();
            TaskUtils.writeMinCheckTimeJsonTxtToFile(extraInfoDir, minCheckTime);

            Module representModule = moduleService.getARepresentModule();

            String lawCode = representModule.getLaws();
            Law law =  lawService.getLawByLawCode(lawCode);

            TaskUtils.writeLawJsonTxtToFile(extraInfoDir, law);

            //任务检测人信息
            TaskUtils.writeUserJsonTxtToFile(extraInfoDir, currentUser);

        }

        return "list";
    }



    public String addModules(){

        task = taskService.findById(task.getId());

        //判断是否已经有压缩的任务文件存在
        Date taskCreateTime  = taskService.getTaskCreateTime(task.getId());
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String zipFileName =  Constant.TASK_NAME_PRFIX+task.getTaskName()+"-"+format.format(taskCreateTime)+".zip";
        String taskBasePath = ServletActionContext.getServletContext().getRealPath(File.separator)+File.separator
                +"tasks"+File.separator+DataSourceContextHolder.getDataSourceName();

        File taskPressFile = new File(taskBasePath, zipFileName);
        if(taskPressFile.exists()){
            taskPressFile.delete();
        }

        if(selectedRow != null){

            Module module0 = moduleService.findById(selectedRow[0]);            //对第一个组件特殊处理
            currentLabel = module0.getLabelNumber();

            addModuleToTaskForFirtstModule(module0);

            Module module;
            for(int i=0; i<selectedRow.length; i++){
                module = moduleService.findById(selectedRow[i]);
                addModuleToTaskForModule(module);
            }

            //肯定还会剩一个没有生成
            String checkObjectJsonString = TaskUtils.createTaskCheckObjectForLabel(labelTask);
            TaskUtils.writeCheckObjectJsonStringToLabelDir(checkObjectJsonString, labelPath, currentLabel);

            //更新任务内包含组件数量
            task.setTotal(task.getTotal() + selectedRow.length);

            if(task.getCheckType().equals(Constant.TASK_TYPE_REPEATE_CHECK)){
                task.setLeak(task.getTotal());
            }
            taskService.update(task);

            //更新task的描述文件， 组件总数
            String taskDir = task.getLocalSavePath();
            TaskUtils.writeTaskJsonTxtToFile(taskDir+File.separator+ Constant.TASK_EXTRA_INFO_DIR, task);
        }

        return "list";
    }

    private void addModuleToTaskForModule(Module module) {

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        //将这个组件和任务建立关系
        module.setTaskId(task.getId());
        module.setHasAllocate(true);

        //将ModuleCheck和Module建立联系, 并保存ModuleCheck
        if( module.getModuleCheck() == null){
            ModuleCheck moduleCheck = new ModuleCheck();
            moduleCheck.setModule(module);

            //TODO: 设置ModuleCheck的一些参数
            moduleCheck.setStartTime(new Date());
            moduleCheck.setEndTime(task.getEndTime());


            moduleCheckService.save(moduleCheck);
            module.setModuleCheck(moduleCheck);
        }

        if(Constant.TASK_TYPE_REPEATE_CHECK.equals(task.getCheckType())){  //如果是泄露复检， 则需要添加维修对象

            if(module.getModuleRepairRecord() == null){
                ModuleRepairRecord moduleRepairRecord = new ModuleRepairRecord();
                moduleRepairRecord.setModule(module);
                moduleRepairRecord.setTempStopRepair(false);

                moduleRepairRecordService.save(moduleRepairRecord);
                module.setModuleRepairRecord(moduleRepairRecord);
            }

        }

        moduleService.update(module);      //不能重复建立联系  so， 在点击任务选择组件时，不应该展示已经添加的组件

        //在该Task的目录生成标签号文件夹， 并把标签号图片放入其中， 并生成描述检测集合的json文件
        if(!currentLabel.equals(module.getLabelNumber())){  //说明Label变化了
            //保存好前一个label的处理
            String checkObjectJsonString = TaskUtils.createTaskCheckObjectForLabel(labelTask);
            TaskUtils.writeCheckObjectJsonStringToLabelDir(checkObjectJsonString, labelPath, currentLabel);

            //为下一个Label做准备
            currentLabel = module.getLabelNumber();

            if(FileUtils.isDirExists(TaskUtils.getLabelPathBylabelNumber(task.getLocalSavePath(), currentLabel))){
                labelPath = TaskUtils.getLabelPathBylabelNumber(task.getLocalSavePath(), currentLabel);
                //将txt文件转成 CheckTaskForLabel 对象， 然后继续添加组件
                labelTask = TaskUtils.getCheckTaskForLabelObjFromLabelPath(labelPath, currentLabel);
            }else{
                labelPath = TaskUtils.createLabelDir(module.getLabelNumber(), task.getLocalSavePath());



                final String tempPicturePath = module.getPicturePath();
                final String tempLabelPath = labelPath;
                cachedThreadPool.execute(new Runnable() {
                    @Override
                    public void run() {  //开启子线程去拷贝图片
                        TaskUtils.copyLabelPictureToTaskDir(tempPicturePath, tempLabelPath+ File.separator+"unhandle.jpg");
                    }
                });

                labelTask = new CheckTaskForLabel();
            }
        }

        if(Constant.TASK_TYPE_REPEATE_CHECK.equals(task.getCheckType())){  //复检应把维修信息添加上
            labelTask.getModuleTasks().add(new CheckTaskForModule(module, module.getModuleCheck(), module.getModuleRepairRecord()));
        }else{
            labelTask.getModuleTasks().add(new CheckTaskForModule(module, module.getModuleCheck()));
        }

        labelTask.getMarkLayoutBeans().add(new LayoutBean(new Point(module.getImgX(), module.getImgY()),
                new Point(module.getHeatX(), module.getHeatY())));

    }

    private void addModuleToTaskForFirtstModule(Module module0) {

        if(FileUtils.isDirExists(TaskUtils.getLabelPathBylabelNumber(task.getLocalSavePath(), currentLabel))){
            //将txt文件转成 CheckTaskForLabel 对象， 然后继续添加组件
            labelPath = TaskUtils.getLabelPathBylabelNumber(task.getLocalSavePath(), currentLabel);
            labelTask = TaskUtils.getCheckTaskForLabelObjFromLabelPath(labelPath, currentLabel);
        }else{
            labelPath = TaskUtils.createLabelDir(module0.getLabelNumber(), task.getLocalSavePath());
            TaskUtils.copyLabelPictureToTaskDir(module0.getPicturePath(), labelPath + File.separator+"unhandle.jpg");
            labelTask = new CheckTaskForLabel();
        }
    }

    public String doQuicklySelectModules(){

        task = taskService.findById(task.getId());

        if(selectCondition != null){

            QueryHelper qh = new QueryHelper(Module.class, "m");

            addConditionForTaskType(qh);
            addConditionForQuickFilter(qh);



            if(task.getCheckType().equals(Constant.TASK_TYPE_REPEATE_CHECK)){  //可能是二次复检， 去除已经成功修复的
                pageResult = moduleService.getPageResult(qh,  1, 200);
                setPageItemsForLeakCheck();
            }else {
                pageResult = moduleService.getPageResult(qh,  1, selectCondition.getSelectNumber());
            }

            List<Module> moduleList = pageResult.getItems();

            if(moduleList != null && moduleList.size() > 0){

                currentLabel = moduleList.get(0).getLabelNumber();
                addModuleToTaskForFirtstModule(moduleList.get(0));

                for(int i=0; i<moduleList.size(); i++){
                    addModuleToTaskForModule(moduleList.get(i));
                }

                //肯定还会剩一个没有生成
                String checkObjectJsonString = TaskUtils.createTaskCheckObjectForLabel(labelTask);
                TaskUtils.writeCheckObjectJsonStringToLabelDir(checkObjectJsonString, labelPath, currentLabel);

                //更新任务内包含组件数量
                task.setTotal(task.getTotal() + moduleList.size());

                if(task.getCheckType().equals(Constant.TASK_TYPE_REPEATE_CHECK)){
                    task.setLeak(task.getTotal());
                }
                taskService.update(task);

                //更新task的描述文件， 组件总数
                String taskDir = task.getLocalSavePath();
                TaskUtils.writeTaskJsonTxtToFile(taskDir+File.separator+ Constant.TASK_EXTRA_INFO_DIR, task);

            }
        }

        return "list";
    }

    public String selectModuleUI(){

        task = taskService.findById(task.getId());
        if(task.isStop()){
            return "list";  //任务已经结束
        }

        QueryHelper qh = new QueryHelper(Module.class, "m");

        addConditionForTaskType(qh);

        addConditionForQuickFilter(qh);

        if(task.getCheckType().equals(Constant.TASK_TYPE_REPEATE_CHECK)){
            setPageSize(200);
        }

        pageResult = moduleService.getPageResult(qh,  getPageNo(), getPageSize());

        if(task.getCheckType().equals(Constant.TASK_TYPE_REPEATE_CHECK)){  //可能是二次复检， 去除已经成功修复的
            setPageItemsForLeakCheck();
        }

        return "selectModuleUI";

    }

    private void setPageItemsForLeakCheck() {
        List<Module> items = pageResult.getItems();
        List<Module> newModules = new ArrayList<>();

        for(Module module : items){
            ModuleRepairRecord moduleRepairRecord = module.getModuleRepairRecord();
            if( moduleRepairRecord != null){
                if(moduleRepairRecord.getRepairResult()){  //已经修复，则不添加的集合中
                    continue;
                }
            }
            newModules.add(module);
        }

        pageResult.setItems(newModules);
        pageResult.setTotalCount(newModules.size());
    }

    private void addConditionForQuickFilter(QueryHelper qh) {

        if(selectCondition != null){
            if(StringUtils.notIsNullAndEmptyString(selectCondition.getDevice()) && !Constant.CONDITION_ALL.equals(selectCondition.getDevice())){
                qh.addConditions("m.device = ?", selectCondition.getDevice());
            }

            if(StringUtils.notIsNullAndEmptyString(selectCondition.getArea()) && !Constant.CONDITION_ALL.equals(selectCondition.getArea())){
                qh.addConditions("m.area = ?", selectCondition.getArea());
            }
        }
    }


    private void addConditionForTaskType(QueryHelper qh) {

        String checkType = task.getCheckType();

        if(checkType.equals(Constant.TASK_TYPE_COMMON_CHECK)){  //常规检测
            qh.addConditions("m.hasCheck = ?", false);
            qh.addConditions("m.taskId <> ?", task.getId());
            qh.addConditions("m.hasAllocate = ?", false);
            qh.addConditions("m.diffToCheck = ?", "否");
        }


        if(checkType.equals(Constant.TASK_TYPE_REPEATE_CHECK)){  //泄露检测
            qh.addConditions("m.taskId <> ?", task.getId());
            // qh.addConditions("m.hasAllocate = ?", false);  即使分配了， 如果泄露， 还是可以去复检
            qh.addConditions("m.leak = ?", true);
            qh.addConditions("m.diffToCheck = ?", "否");
        }


        if(checkType.equals(Constant.TASK_TYPE_EYE_CHECK)){  //目视检测
            qh.addConditions("m.hasCheck = ?", false);
            qh.addConditions("m.taskId <> ?", task.getId());
            qh.addConditions("m.hasAllocate = ?", false);
            qh.addConditions("m.diffToCheck = ?", "是");
        }
    }


    /**
     * 删除
     */
    public String delete(){
        if( task != null && task.getId() != null){

            String id = task.getId();
            //在删除任务前， 应解除与组件的关系, 清除组件的 has_allocate 和task_id字段
            moduleService.clearModuleWithTaskConnection(task.getId());
            task = taskService.findById(id);

            //删除任务对应的文件
            FileUtils.deleteDir(task.getLocalSavePath());
            //查看任务下是否有对应的压缩文件有的话也删除
            Date taskCreateTime  = taskService.getTaskCreateTime(task.getId());
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String taskBasePath = ServletActionContext.getServletContext().getRealPath(File.separator)+File.separator+"tasks"+File.separator+ DataSourceContextHolder.getDataSourceName();
            String taskZipFilepath = Constant.TASK_NAME_PRFIX+task.getTaskName()+"-"+format.format(taskCreateTime)+".zip";

            File taskZipFile = new File(taskBasePath+File.separator+taskZipFilepath);
            if(taskZipFile.exists()){
                taskZipFile.delete();
            }

            taskService.delete(id);

        }
        setPageNo(1);
        return "list";
    }

    /**
     * 进入修改页面
     */
    public String editUI(){
        //处理回显
        if(task != null && task.getId() != null)
        {
            task = taskService.findById(task.getId());
        }

        return "editUI";
    }

    /**
     * 修改
     */
    public String edit(){

        if(task != null){
            taskService.update(task);
        }

        return "list";
    }

    /**
     * 删除
     */
    public String deleteSelected(){

        if(selectedRow != null){
            for(String id: selectedRow){
                taskService.delete(id);
            }
        }

        return "list";
    }

    public TaskConditionSelect getSelectCondition() {
        return selectCondition;
    }

    public void setSelectCondition(TaskConditionSelect selectCondition) {
        this.selectCondition = selectCondition;
    }

    public ITaskService getTaskService() {
        return taskService;
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

    public IModuleService getModuleService() {
        return moduleService;
    }

    public void setModuleService(IModuleService moduleService) {
        this.moduleService = moduleService;
    }

    public void setModuleCheckService(IModuleCheckService moduleCheckService) {
        this.moduleCheckService = moduleCheckService;
    }

    public void setLawService(ILawService lawService) {
        this.lawService =lawService;
    }



    public void setCheckApparatusService(ICheckApparatusService checkApparatusService) {
        this.checkApparatusService = checkApparatusService;
    }


    public void setMinCheckTimeService(IMinCheckTimeService minCheckTimeService) {
        this.minCheckTimeService = minCheckTimeService;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public void setModuleRepairRecordService(IModuleRepairRecordService moduleRepairRecordService) {
        this.moduleRepairRecordService = moduleRepairRecordService;
    }
}
