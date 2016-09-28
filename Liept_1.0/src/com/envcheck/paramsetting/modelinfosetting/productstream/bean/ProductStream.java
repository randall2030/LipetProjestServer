package com.envcheck.paramsetting.modelinfosetting.productstream.bean;

import com.envcheck.base.bean.MainTainAbout;

/**
 * Created by susion on 2016/5/4.
 */
public class ProductStream extends MainTainAbout {

    //产品流编号、产品流名称、响应因子、Waster Waster百分比、VOC百分比、HAP百分比、BEN百分比、GHG百分比、CCL4百分比、乙醛、氯苯、
    //三氯乙烷、苊
    // 创建时间、创建人、更新时间、更新人

    private String id;
    private String productStreamNumber;
    private String productStreamName;
    private String reactElement;
    private String wasterPercent;
    private String vocPercent;
    private String hapPercent;

    private String benPercent;
    private String ghgPercent;
    private String ccl4Percent;
    private String ethylalPercent;
    private String chlorobenzolPercent;
    private String trichloroethanePercent;
    private String acenaphthenePercent;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductStreamNumber() {
        return productStreamNumber;
    }

    public void setProductStreamNumber(String productStreamNumber) {
        this.productStreamNumber = productStreamNumber;
    }

    public String getProductStreamName() {
        return productStreamName;
    }

    public void setProductStreamName(String productStreamName) {
        this.productStreamName = productStreamName;
    }

    public String getReactElement() {
        return reactElement;
    }

    public void setReactElement(String reactElement) {
        this.reactElement = reactElement;
    }

    public String getWasterPercent() {
        return wasterPercent;
    }

    public void setWasterPercent(String wasterPercent) {
        this.wasterPercent = wasterPercent;
    }

    public String getVocPercent() {
        return vocPercent;
    }

    public void setVocPercent(String vocPercent) {
        this.vocPercent = vocPercent;
    }

    public String getHapPercent() {
        return hapPercent;
    }

    public void setHapPercent(String hapPercent) {
        this.hapPercent = hapPercent;
    }

    public String getBenPercent() {
        return benPercent;
    }

    public void setBenPercent(String benPercent) {
        this.benPercent = benPercent;
    }

    public String getGhgPercent() {
        return ghgPercent;
    }

    public void setGhgPercent(String ghgPercent) {
        this.ghgPercent = ghgPercent;
    }

    public String getCcl4Percent() {
        return ccl4Percent;
    }

    public void setCcl4Percent(String ccl4Percent) {
        this.ccl4Percent = ccl4Percent;
    }

    public String getEthylalPercent() {
        return ethylalPercent;
    }

    public void setEthylalPercent(String ethylalPercent) {
        this.ethylalPercent = ethylalPercent;
    }

    public String getChlorobenzolPercent() {
        return chlorobenzolPercent;
    }

    public void setChlorobenzolPercent(String chlorobenzolPercent) {
        this.chlorobenzolPercent = chlorobenzolPercent;
    }

    public String getTrichloroethanePercent() {
        return trichloroethanePercent;
    }

    public void setTrichloroethanePercent(String trichloroethanePercent) {
        this.trichloroethanePercent = trichloroethanePercent;
    }

    public String getAcenaphthenePercent() {
        return acenaphthenePercent;
    }

    public void setAcenaphthenePercent(String acenaphthenePercent) {
        this.acenaphthenePercent = acenaphthenePercent;
    }
}
