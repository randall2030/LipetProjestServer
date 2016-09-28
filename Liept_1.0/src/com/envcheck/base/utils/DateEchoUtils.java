package com.envcheck.base.utils;

import org.apache.struts2.ServletActionContext;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/5/26.
 */
public class DateEchoUtils {

    /**
     * 格式化时间的工具
     * @param list：时间数组    name:seesion域的属性名字
     */
    public static void dateEcho(List<Date> list,String name){

        List<String> dateList = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for(Date date : list){
            if (date!=null){
                String format = dateFormat.format(date);
                dateList.add(format);
            }else {
                dateList.add(null);
            }
        }

        ServletActionContext.getRequest().setAttribute(name,dateList);
    }
}
