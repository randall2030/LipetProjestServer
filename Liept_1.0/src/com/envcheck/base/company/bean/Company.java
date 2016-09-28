package com.envcheck.base.company.bean;

import java.util.Date;

/**
 * Created by susion on 2016/6/26.
 */
public class Company {

    private String id;  //编号
    private String companyName;  //公司名称
    private String companySimpleName;  //公司简称
    private String parentCompany;  //父公司
    private String parentCompanySimpleName;  //父公司简称
    private Date   buildDate;  //创建日期
    private String registerAsset;  //注册资本（好像基本没用啊）
    private String industryCode;  //工业编码（好像也没什么软用）
    private String companyAddress;  //公司地址（真没用过哎）
    private String lawRepresent;  //法人代表（好像是这么说的，但也没什么软用）
    private String lawRepresentPhone;  //法人代表（更没什么软用）
    private String lawFax;  //法人传真（同上）
    private String environmentPerson; //没用
    private String environmentPersonPhone;  //没用
    private String environmentPersonFax;  //，没用
    private Date ldarStartTime;  //开始检时间
    private int checkPoint;  //检测点数
    private String mainMaterial;  //
    private String middleMaterial;  //
    private String mainProduct;  //
    private String note;  //


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanySimpleName() {
        return companySimpleName;
    }

    public void setCompanySimpleName(String companySimpleName) {
        this.companySimpleName = companySimpleName;
    }

    public String getParentCompanySimpleName() {
        return parentCompanySimpleName;
    }

    public void setParentCompanySimpleName(String parentCompanySimpleName) {
        this.parentCompanySimpleName = parentCompanySimpleName;
    }

    public String getParentCompany() {
        return parentCompany;
    }

    public void setParentCompany(String parentCompany) {
        this.parentCompany = parentCompany;
    }

    public String getRegisterAsset() {
        return registerAsset;
    }

    public void setRegisterAsset(String registerAsset) {
        this.registerAsset = registerAsset;
    }

    public Date getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(Date buildDate) {
        this.buildDate = buildDate;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    public String getLawRepresent() {
        return lawRepresent;
    }

    public void setLawRepresent(String lawRepresent) {
        this.lawRepresent = lawRepresent;
    }

    public String getLawRepresentPhone() {
        return lawRepresentPhone;
    }

    public void setLawRepresentPhone(String lawRepresentPhone) {
        this.lawRepresentPhone = lawRepresentPhone;
    }

    public String getLawFax() {
        return lawFax;
    }

    public void setLawFax(String lawFax) {
        this.lawFax = lawFax;
    }

    public String getEnvironmentPerson() {
        return environmentPerson;
    }

    public void setEnvironmentPerson(String environmentPerson) {
        this.environmentPerson = environmentPerson;
    }

    public String getEnvironmentPersonPhone() {
        return environmentPersonPhone;
    }

    public void setEnvironmentPersonPhone(String environmentPersonPhone) {
        this.environmentPersonPhone = environmentPersonPhone;
    }

    public String getEnvironmentPersonFax() {
        return environmentPersonFax;
    }

    public void setEnvironmentPersonFax(String environmentPersonFax) {
        this.environmentPersonFax = environmentPersonFax;
    }

    public Date getLdarStartTime() {
        return ldarStartTime;
    }

    public void setLdarStartTime(Date ldarStartTime) {
        this.ldarStartTime = ldarStartTime;
    }

    public int getCheckPoint() {
        return checkPoint;
    }

    public void setCheckPoint(int checkPoint) {
        this.checkPoint = checkPoint;
    }

    public String getMainMaterial() {
        return mainMaterial;
    }

    public void setMainMaterial(String mainMaterial) {
        this.mainMaterial = mainMaterial;
    }

    public String getMiddleMaterial() {
        return middleMaterial;
    }

    public void setMiddleMaterial(String middleMaterial) {
        this.middleMaterial = middleMaterial;
    }

    public String getMainProduct() {
        return mainProduct;
    }

    public void setMainProduct(String mainProduct) {
        this.mainProduct = mainProduct;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
