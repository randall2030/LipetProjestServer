package com.envcheck.paramsetting.modelinfosetting.chemical.bean;

import com.envcheck.base.bean.MainTainAbout;

/**
 * Created by susion on 2016/5/4.
 */
public class Chemical extends MainTainAbout {

    //化学品编号、化学品名称、CAS编号、响应因子、BEN、Waster、VOC、HAP、GHG、分子式、沸点、蒸汽压、
    // 创建时间、创建人、更新

    private String id;
    private String chemicalNumber;
    private String chemicalName;
    private String casNumber;
    private String reactElement;
    private Boolean ben;
    private Boolean waster;
    private Boolean voc;
    private Boolean hap;
    private Boolean ghg;
    private String moleculeFormula;
    private String boiling;
    private String steamPress;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSteamPress() {
        return steamPress;
    }

    public void setSteamPress(String steamPress) {
        this.steamPress = steamPress;
    }

    public String getChemicalName() {
        return chemicalName;
    }

    public void setChemicalName(String chemicalName) {
        this.chemicalName = chemicalName;
    }

    public String getChemicalNumber() {
        return chemicalNumber;
    }

    public void setChemicalNumber(String chemicalNumber) {
        this.chemicalNumber = chemicalNumber;
    }

    public String getReactElement() {
        return reactElement;
    }

    public void setReactElement(String reactElement) {
        this.reactElement = reactElement;
    }

    public String getCasNumber() {
        return casNumber;
    }

    public void setCasNumber(String casNumber) {
        this.casNumber = casNumber;
    }

    public String getMoleculeFormula() {
        return moleculeFormula;
    }

    public void setMoleculeFormula(String moleculeFormula) {
        this.moleculeFormula = moleculeFormula;
    }

    public String getBoiling() {
        return boiling;
    }

    public void setBoiling(String boiling) {
        this.boiling = boiling;
    }

    public Boolean getBen() {
        return ben;
    }

    public void setBen(Boolean ben) {
        this.ben = ben;
    }

    public Boolean getWaster() {
        return waster;
    }

    public void setWaster(Boolean waster) {
        this.waster = waster;
    }

    public Boolean getVoc() {
        return voc;
    }

    public void setVoc(Boolean voc) {
        this.voc = voc;
    }

    public Boolean getHap() {
        return hap;
    }

    public void setHap(Boolean hap) {
        this.hap = hap;
    }

    public Boolean getGhg() {
        return ghg;
    }

    public void setGhg(Boolean ghg) {
        this.ghg = ghg;
    }
}
