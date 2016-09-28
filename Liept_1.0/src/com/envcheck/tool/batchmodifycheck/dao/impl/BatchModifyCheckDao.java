package com.envcheck.tool.batchmodifycheck.dao.impl;

import com.envcheck.base.bean.Module;
import com.envcheck.base.dao.BaseDao;
import com.envcheck.tool.batchmodifycheck.dao.IBatchModifyCheckDao;
import com.envcheck.tool.batchmodifymodule.bean.ModifyModuleInfo;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by Administrator on 2016/5/29.
 */
public class BatchModifyCheckDao extends BaseDao<Module> implements IBatchModifyCheckDao{
    @Override
    public void batchModify(List<ModifyModuleInfo> moduleInfos) {

        String hql;
        for (ModifyModuleInfo moduleInfo : moduleInfos){
            String id = moduleInfo.getId();
            id = "'"+id+"'";
            String name = moduleInfo.getName();
            Object value = moduleInfo.getObj();
            value = "'"+value+"'";

            hql="update Module m set m."+name+"="+value+" where id="+id;
            Query query= super.getSessionFactory().getCurrentSession().createQuery(hql);
            query.executeUpdate();


        }
    }
}
