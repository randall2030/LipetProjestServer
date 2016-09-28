package com.envcheck.base.dynamic_change_datasource;

/**
 * Created by susion on 2016/6/15.
 */
public class DataSourceContextHolder {

   // public static  String dataSourceName;
    private static final ThreadLocal contextHolder = new ThreadLocal();


    public static String getDataSourceName() {
       // return dataSourceName;
        return (String) contextHolder.get();
    }

    public static void setDataSourceName(String dataSourceName) {
       // DataSourceContextHolder.dataSourceName = dataSourceName;
        contextHolder.set(dataSourceName);

    }
}
