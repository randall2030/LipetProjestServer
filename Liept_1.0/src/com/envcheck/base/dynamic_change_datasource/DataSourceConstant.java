package com.envcheck.base.dynamic_change_datasource;

import com.envcheck.base.utils.Constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by susion on 2016/6/15.
 */
public class DataSourceConstant {

    public static Map<String, String> datasourceMap = new HashMap<>();

    static{
        /*
        * 初识化数据库必须配置这里
        * key:Constant.DATABASE_PRIFIX + Constant.DIVIDE_CHAR+{父公司简称 + Constant.DIVIDE_CHAR+}+子公司简称
        * value: 对应的数据库名称
        * */
        datasourceMap.put(Constant.PEAK_COMPANY, "liept");
        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"yght", "liept_yght");  //阳谷华泰
        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"zgwd"+Constant.DIVIDE_CHAR+"hxhx", "liept_zgwd_hxhx");
        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"ylhg", "liept_ylhg");    //  元立科技！！！！
        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"xhblg", "liept_xhblg");  //新华百里高
        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"tysh", "liept_tysh");  //腾宇石化
        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"xhwb", "liept_xhwb");  // 新华万博


        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"jbgm", "liept_jbgm");  //金霸工贸
        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"qlhg", "liept_qlhg");  //齐龙化工


        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"laxny", "liept_laxny");  //山东雷奥新能源
        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"xdhg", "liept_xdhg");  //潍坊先达化工
        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"ylkj", "liept_ylkj");  //山东元立科技股份有限公司
        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"lbhg", "liept_lbhg");  //潍坊绿霸化工


        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"ljddsgm", "liept_ljddsgm");  //潍坊绿霸化工


        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"sdjfyzx", "liept_sdjfyzx");//山东杰富意振兴化工
        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"wfzxrs", "liept_wfzxrs");  //潍坊振兴日升化工
        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"wfmjhg", "liept_wfmjhg");  //潍坊门捷化工有限公司

        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"sdxwsswkj", "liept_sdxwsswkj");  // 山东祥维斯生物科技股份有限公司
        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"wfsshg", "liept_wfsshg");  //潍坊尚舜化工有限公司
        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"sdwfsgwdhg", "liept_sdwfsgwdhg");  //山东潍坊寿光卫东化工有限公司
        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"zbwqhg", "liept_zbwqhg");  //淄博伟强化工有限公司

        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"zbhrxcl", "liept_zbhrxcl");  //淄博鸿润新材料有限公司
        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"sdtsxj", "liept_sdtsxj");  //山东天说橡胶有限公司


        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"zbswhg", "liept_zbswhg");  //淄博三威化工
        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"zbadmgfz", "liept_zbadmgfz");  //淄博奥得美高分子材料有限公司
        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"dfhgzjc", "liept_dfhgzjc");  //桓台县田庄镇东方化工助剂厂

        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"hthsgm", "liept_hthsgm");  //桓台和顺工贸有限公司
        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"sdjdhg", "liept_sdjdhg");  //山东金典化工有限公司


        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"pyhcdz", "liept_pyhcdz");    //濮阳惠成电子材料股份有限公司

        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"pyydhg", "liept_pyydhg");    //濮阳市远东化工有限公司
        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"pyshdhg", "liept_pyshdhg");  //濮阳盛华德化工有限公司
        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"dyhygl", "liept_dyhygl");    //东营华亚国联航空燃料有限公司

        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"fxhfdz", "liept_fxhfdz");    //范县恒丰电子绝缘有限公司

        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"fxgfjx", "liept_fxgfjx");    //范县国丰精细化工有限公司

        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"hnlrny", "liept_hnlrny");    //河南龙润能源科技有限公司

        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"httsxg", "liept_httsxg");    //桓台县唐山镇旭光助剂厂

        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"zbfsjxhg", "liept_zbfsjxhg");  //淄博傅山精细化工有限公司
        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"sdsthg", "liept_sdsthg");      //山东仕通化工有限公司

        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"zbfsjh", "liept_zbfsjh");     //淄博市傅山焦化有限责任公司

        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"hnjhny", "liept_hnjhny");    //河南省佳化能源股份有限公司

        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"zbxgrq", "liept_zbxgrq");    //淄博鑫港燃气有限公司
        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"zbxgjxh", "liept_zbxgjxh");    //淄博鑫港精细化工有限公司
        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"pybdlhx", "liept_pybdlhx");    //濮阳班德路化学有限公司


        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"htfzhg", "liept_htfzhg");    //桓台县富中化工有限公司
        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"zblbgm", "liept_zblbgm");    //淄博玲宝工贸有限公司

        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"pyrssysz", "liept_pyrssysz");    //濮阳市瑞森石油树脂有限公司


        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"sdsshg", "liept_sdsshg");    //山东尚舜化工有限公司
        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"hzxfdhg", "liept_hzxfdhg");    //菏泽鑫丰德化工股份有限公司
        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"sdydlhg", "liept_sdydlhg");    //山东易达利化工有限公司
        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"sdgyhg", "liept_sdgyhg");    //山东国耀化工科技有限公司






        // 测试
        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"test", "liept_test");
        datasourceMap.put(Constant.PEAK_COMPANY+Constant.DIVIDE_CHAR+"fyny", "liept_fyny");
    }
}
