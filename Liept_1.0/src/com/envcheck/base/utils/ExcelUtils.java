package com.envcheck.base.utils;

import com.envcheck.base.bean.Module;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.jplus.hyberbin.excel.service.ImportTableService;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/**
 * Created by susion on 2016/5/17.
 */
public class ExcelUtils {

    private static String[] moduleProperty = {"device","area","equipment","labelNumber","extendNumber","pid","mainReference","mainDirection","mainDistance","mainUnit","minorReference","minorDirection","minorDistance","minorUnit",
            "floor","height","heightUnit","appendDesc","modelType","modelSubType","sizeMM","mediumStatus","productStream","productCompany","roadNumber","yearRunTime","modelBuildTime","diffToTouch","diffToCheck","diffToCheckReason","dangerToCheck","dangerToCheckReason",
            "controlEquiAndWind","controlEquiAndWindType","pressWork","leakModule","locationZXZGArea","yearTime300","warm","equipmentCode",
            "mainMedium","operatorTemperature","operatorPress","sealMedium","barCode","imgX","imgY","heatX","heatY"};


    public static List<Module> getModuleFromModuleExcel(File file)  {
        try
        {
            Workbook workbook = new HSSFWorkbook(new FileInputStream(file));
            Sheet sheet = workbook.getSheetAt(0);
            ImportTableService tableService=new ImportTableService(sheet);
            tableService.setStartRow(1);
            tableService.doImport();
            List<Module> read2 = tableService.read(moduleProperty, Module.class);

            return read2;

        }catch (Exception e){

        }

        return null;
    }



}
