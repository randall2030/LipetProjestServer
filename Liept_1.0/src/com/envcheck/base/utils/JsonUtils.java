package com.envcheck.base.utils;

import com.google.gson.Gson;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Administrator on 2016/5/24.
 */
public class JsonUtils {

    public static void toJson(List list){
        try {

            HttpServletResponse response = ServletActionContext.getResponse();
            //编码设置
            response.setContentType("text/html;charset=UTF-8");

            PrintWriter pw = response.getWriter();
            Gson gson = new Gson();

            CodelistWrapper codelistWrapper = new CodelistWrapper(list);
            String json = gson.toJson(codelistWrapper);
            pw.write(json);
            pw.flush();
            pw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
