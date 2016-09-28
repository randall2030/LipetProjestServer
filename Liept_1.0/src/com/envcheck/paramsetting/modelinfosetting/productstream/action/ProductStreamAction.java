package com.envcheck.paramsetting.modelinfosetting.productstream.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.modelinfosetting.productstream.bean.ProductStream;
import com.envcheck.paramsetting.modelinfosetting.productstream.service.IProductStreamService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

import java.net.URLDecoder;
import java.util.Date;

/**
 * Created by Administrator on 2016/5/7.
 */
public class ProductStreamAction extends BaseAction {
    //封装数据
    private ProductStream productStream;

    public ProductStream getProductStream() {
        return productStream;
    }

    public void setProductStream(ProductStream productStream) {
        this.productStream = productStream;
    }

    //调用业务逻辑方法
    private IProductStreamService productStreamService;

    public IProductStreamService getProductStreamService() {
        return productStreamService;
    }

    public void setProductStreamService(IProductStreamService productStreamService) {
        this.productStreamService = productStreamService;
    }

    /**
     * 列表展示
     */
    public String listUI(){

        try {
            QueryHelper qh = new QueryHelper(ProductStream.class, "p");
            //查询
            if(productStream  != null && ( productStream.getProductStreamNumber()!=null || productStream.getProductStreamName() != null) ){

                if (productStream.getProductStreamNumber()!=null ){
                    productStream.setProductStreamNumber(URLDecoder.decode(productStream.getProductStreamNumber(),"utf-8"));
                     qh.addConditions("p.productStreamNumber like ?", "%" + productStream.getProductStreamNumber() + "%");
                }
                if (productStream.getProductStreamName() != null){
                    productStream.setProductStreamName(URLDecoder.decode(productStream.getProductStreamName(),"utf-8"));
                    qh.addConditions("p.productStreamName like ?", "%" + productStream.getProductStreamName() + "%");
                }

            }

            pageResult = productStreamService.getPageResult(qh,  getPageNo(), getPageSize());
            int a = 0;

        }catch (Exception e){

        }

        return "listUI";

    }

    /**
     * 添加
     */
    public String addUI(){
        return "addUI";
    }

    public String add(){

        if(productStreamService != null){
            productStream.setCreateTime(new Date());
            productStream.setCreatePerson("haha");
            productStream.setModifyTime(new Date());
            productStream.setModifyPerson("haha");
            productStreamService.save(productStream);
        }
        return "list";
    }

    /**
     * 删除
     */
    public String delete(){

        if( productStream != null && productStream.getId() != null){
            productStreamService.delete(productStream.getId());
        }

        setPageNo(1);
        return "list";
    }

    /**
     * 进入修改页面
     */
    public String editUI(){
        //处理回显
        if(productStream != null && productStream.getId() != null)
        {
            productStream = productStreamService.findById(productStream.getId());
        }

        return "editUI";
    }


    /**
     * 修改
     * @return
     */
    public String edit(){

        if(productStream != null){

            productStream.setModifyTime(new Date());
            productStream.setModifyPerson("haha");
            productStreamService.update(productStream);
        }

        return "list";
    }
    public String deleteSelected(){

        if(selectedRow != null){
            for(String id: selectedRow){
                productStreamService.delete(id);
            }
        }

        return "list";
    }
}
