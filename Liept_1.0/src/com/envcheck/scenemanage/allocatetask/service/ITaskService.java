package com.envcheck.scenemanage.allocatetask.service;


import com.envcheck.android.bean.DownTaskDescBig;
import com.envcheck.base.service.IBaseService;
import com.envcheck.scenemanage.allocatetask.bean.Task;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/5/5.
 */
public interface ITaskService extends IBaseService<Task> {
    Date getTaskCreateTime(String id);
    List<DownTaskDescBig> getAllDownTaskDescBigByUsername(String username);

    String getTaskName(String id);
}
