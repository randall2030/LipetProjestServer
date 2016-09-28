package com.envcheck.scenemanage.allocatetask.dao.impl;

import com.envcheck.android.bean.DownTaskDesc;
import com.envcheck.android.bean.DownTaskDescBig;
import com.envcheck.base.dao.BaseDao;
import com.envcheck.base.utils.Constant;
import com.envcheck.scenemanage.allocatetask.bean.Task;
import com.envcheck.scenemanage.allocatetask.dao.ITaskDao;
import org.hibernate.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/5.
 */
public class TaskDao extends BaseDao<Task> implements ITaskDao {



    @Override
    public Date getTaskCreateTime(String id) {

        String getCreateTimeHQL = "SELECT t.createTime FROM Task t WHERE t.id = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(getCreateTimeHQL);
        int index = 0;
        query.setParameter(index, id);
        return (Date) query.uniqueResult();

    }

    @Override
    public List<DownTaskDescBig> getAllDownTaskDescBigByUsername(String username) {


        List<DownTaskDescBig> resultDownTaskDescBigList = new ArrayList<>();
        //需要创建时间， 任务的本地存储路径 任务名称  组件数量
        String getDownTaskDescBigHQL = "SELECT new map(t.createTime as createTime, t.localSavePath as localSavePath," +
                                        " t.taskName as taskName, t.total as total , t.id as id)" +
                                       " FROM Task t WHERE t.user =? and t.stop=?";

        Query query = sessionFactory.getCurrentSession().createQuery(getDownTaskDescBigHQL);
        int index = 0;
        query.setParameter(index, username);
        query.setBoolean(1, false);

        List<Map>  downTaskDescBigList = query.list();  //List中又有一个List

        for(Map resultMap : downTaskDescBigList){

            DownTaskDescBig desc = new DownTaskDescBig();
            desc.setTaskCreateTime((Date) resultMap.get("createTime"));
            desc.setTaskLocalSavePath((String) resultMap.get("localSavePath"));

            DownTaskDesc downTaskDesc = new DownTaskDesc();
            downTaskDesc.setTaskName((String) resultMap.get("taskName"));
            downTaskDesc.setModuleNumber(String.valueOf(resultMap.get("total")));
            downTaskDesc.setDownUrl(Constant.TASK_DOWN_ACTION+"?task.id="+resultMap.get("id"));
            desc.setDownTaskDesc(downTaskDesc);

            resultDownTaskDescBigList.add(desc);

        }

        return resultDownTaskDescBigList;
    }

    @Override
    public String getTaskName(String id) {

        String getCreateTimeHQL = "SELECT t.taskName FROM Task t WHERE t.id = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(getCreateTimeHQL);
        int index = 0;
        query.setParameter(index, id);

        return (String) query.uniqueResult();

    }


}
