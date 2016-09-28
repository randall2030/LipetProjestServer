package com.envcheck.base.dynamic_change_datasource;

import com.envcheck.base.user.bean.User;
import com.envcheck.base.utils.Constant;
import com.envcheck.base.utils.StringUtils;

import javax.servlet.http.HttpSession;

/**
 * Created by susion on 2016/6/19.
 */
public class ParamSettingDataSourceChangeAop {


    public void doBefore(){
        //操作前， 切换为顶级数据库
        DataSourceContextHolder.setDataSourceName(DataSourceConstant.datasourceMap.get(Constant.PEAK_COMPANY));
    }


    public void doAfter(){
        String dataSourceKey = StringUtils.getCurrentDataSourceKey(UserContextHolder.getCurrentUser());
        DataSourceContextHolder.setDataSourceName(DataSourceConstant.datasourceMap.get(dataSourceKey));
    }

}
