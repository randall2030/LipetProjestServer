package com.envcheck.tool.batchmodifymodule.dao.impl;

import com.envcheck.base.bean.Module;
import com.envcheck.base.dao.BaseDao;
import com.envcheck.tool.batchmodifymodule.bean.ModifyModuleInfo;
import com.envcheck.tool.batchmodifymodule.dao.IBatchModifyModuleDao;
import org.hibernate.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/27.
 */
public class BatchModifyModuleDao extends BaseDao<Module> implements IBatchModifyModuleDao {

    @Override
    public void batchModify(List<ModifyModuleInfo> moduleInfos) {

        for (ModifyModuleInfo moduleInfo : moduleInfos){
            String id = moduleInfo.getId();
            id = "'"+id+"'";
            String name = moduleInfo.getName();
            Object value = moduleInfo.getObj();
            value = "'"+value+"'";

            String hql="update Module m set m."+name+"="+value+" where id="+id;
            Query query= super.getSessionFactory().getCurrentSession().createQuery(hql);
            query.executeUpdate();
        }
    }
}
