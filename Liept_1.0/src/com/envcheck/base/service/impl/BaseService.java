package com.envcheck.base.service.impl;

import com.envcheck.base.dao.BaseDao;
import com.envcheck.base.dao.IBaseDao;
import com.envcheck.base.dynamic_change_datasource.DataSourceConstant;
import com.envcheck.base.dynamic_change_datasource.DataSourceContextHolder;
import com.envcheck.base.dynamic_change_datasource.UserContextHolder;
import com.envcheck.base.service.IBaseService;
import com.envcheck.base.user.bean.User;
import com.envcheck.base.utils.Constant;
import com.envcheck.base.utils.PageResult;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.base.utils.StringUtils;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import static com.envcheck.base.utils.Constant.currentUser;

/**
 * Created by susion on 2016/5/3.
 */
public class BaseService<T> implements IBaseService<T> {

    private final Class<T> clazz;
    private IBaseDao baseDao;

    public BaseService(){
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Override
    public void delete(String id){
        changgeDatasourceBefore();

        if(!canExecuteOperation()){
            throw new RuntimeException("无操作权限， 请向系统管理员申请");
        }

        baseDao.delete(id);
        changgeDatasourceAfter();
    }

    @Override
    public T findById(String id) {
        changgeDatasourceBefore();
        T t = (T) baseDao.findById(id);
        changgeDatasourceAfter();
        return t;

    }

    @Override
    public List<T> getAll() {
        changgeDatasourceBefore();
        List all = baseDao.getAll();
        changgeDatasourceAfter();
        return all;
    }

    @Override
    public void save(T entity){
        changgeDatasourceBefore();

        if(!canExecuteOperation()){
            throw new RuntimeException("无操作权限， 请向系统管理员申请");
        }

        baseDao.save(entity);
        changgeDatasourceAfter();
    }

    @Override
    public void update(T entity){
        changgeDatasourceBefore();

        if(!canExecuteOperation()){
            throw new RuntimeException("无操作权限， 请向系统管理员申请");
        }

        baseDao.update(entity);
        changgeDatasourceAfter();
    }


    @Override
    public List<T> getAll(QueryHelper qh) {
        changgeDatasourceBefore();
        List all = baseDao.getAll(qh);
        changgeDatasourceAfter();
        return all;
    }

    //分页查询
    public PageResult getPageResult(QueryHelper qh, int pageNo, int pageSize)
    {
        changgeDatasourceBefore();
        PageResult pageResult = baseDao.getPageResult(qh, pageNo, pageSize);
        changgeDatasourceAfter();
        return  pageResult;
    }

    public IBaseDao getBaseDao() {
        return baseDao;
    }

    public void setBaseDao(IBaseDao baseDao) {
        this.baseDao = baseDao;
    }

    public void changgeDatasourceBefore(){

        String currentClazzName = clazz.getName();

        String dataSourceName = DataSourceContextHolder.getDataSourceName();
        User user = UserContextHolder.getCurrentUser();

        if(currentClazzName.contains("paramsetting")){

            if(!currentClazzName.contains("areamanage") && !currentClazzName.contains("devicemanage")){  //这两个模块不共享顶级数据库
                //切换数据库   一次请求是可以这样切换数据库的
                DataSourceContextHolder.setDataSourceName(DataSourceConstant.datasourceMap.get(Constant.PEAK_COMPANY));
            }
        }
    }

    public void changgeDatasourceAfter(){

        String currentClazzName = clazz.getName();

        if(currentClazzName.contains("paramsetting")){
            //切换数据库   一次请求是可以这样切换数据库的！！！！   其实这段代码是没有必要有的！！！
            String dataSourceKey = StringUtils.getCurrentDataSourceKey(UserContextHolder.getCurrentUser());
            DataSourceContextHolder.setDataSourceName(DataSourceConstant.datasourceMap.get(dataSourceKey));
        }
    }


    public boolean canExecuteOperation(){

        //判断操作的是否为参数设置下的全局模块， 如果是， 则只有系统用户可操作
        String currentClazzName = clazz.getName();

        User currentUser = UserContextHolder.getCurrentUser();

        if(currentUser != null){
            if(currentUser.isVisitPrivilege()){

                if(currentClazzName.contains("paramsetting")){  //想操作全局模块， 必须是系统用户
                    if(!currentClazzName.contains("areamanage") && !currentClazzName.contains("devicemanage")){
                        if(!"liept".equals(currentUser.getParentCompany()) || !"liept".equals(currentUser.getCompany())){
                            return false;
                        }
                    }
                }

                return  true;
            }
        }

        return false;

    }

}
