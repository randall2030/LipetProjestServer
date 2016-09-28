package com.envcheck.scenemanage.allocatetask.service.impl;


import com.envcheck.android.bean.DownTaskDescBig;
import com.envcheck.base.service.impl.BaseService;
import com.envcheck.scenemanage.allocatetask.bean.Task;
import com.envcheck.scenemanage.allocatetask.dao.ITaskDao;
import com.envcheck.scenemanage.allocatetask.service.ITaskService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/5/5.
 */
public class TaskService extends BaseService<Task> implements ITaskService {

    private ITaskDao taskDao;

    public ITaskDao getTaskDao() {

        return taskDao;
    }

    @Resource
    public void setTaskDao(ITaskDao taskDao) {
        super.setBaseDao(taskDao);  //别忘了！！！！！！
        this.taskDao = taskDao;
    }

    @Override
    public Date getTaskCreateTime(String id) {
        return taskDao.getTaskCreateTime(id);
    }

    @Override
    public List<DownTaskDescBig> getAllDownTaskDescBigByUsername(String username) {
        return taskDao.getAllDownTaskDescBigByUsername(username);
    }

    @Override
    public String getTaskName(String id) {
        return taskDao.getTaskName(id);
    }

}
