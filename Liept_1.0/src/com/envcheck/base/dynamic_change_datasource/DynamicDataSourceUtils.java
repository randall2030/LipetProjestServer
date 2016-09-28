package com.envcheck.base.dynamic_change_datasource;

import com.envcheck.base.utils.StringUtils;

/**
 * Created by susion on 2016/6/28.
 */
public class DynamicDataSourceUtils {
    public static void changeToLocalDatabase() {
        //切换为本地数据库
        String dataSourceKey = StringUtils.getCurrentDataSourceKey(UserContextHolder.getCurrentUser());
        DataSourceContextHolder.setDataSourceName(DataSourceConstant.datasourceMap.get(dataSourceKey));
    }
}
