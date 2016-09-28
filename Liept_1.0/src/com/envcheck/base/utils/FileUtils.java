package com.envcheck.base.utils;

import com.envcheck.base.bean.Module;
import com.envcheck.base.dynamic_change_datasource.UserContextHolder;
import com.envcheck.report.letcaculate.bean.DischargeFormula;
import com.envcheck.report.letcaculate.bean.LetForModule;
import com.envcheck.report.letcaculate.bean.MinusLetNumber;
import com.envcheck.report.letcaculate.bean.TotalInfoForMinusLetNumber;
import com.envcheck.report.letcaculate.utils.DischargeFormulaConstant;
import com.envcheck.report.statistics.letnumberstatistics.bean.PieStatisticNumberForDischarge;
import com.envcheck.report.statistics.letnumberstatistics.bean.PieStatisticNumberWrapperForDischarge;
import com.envcheck.report.statistics.letnumberstatistics.bean.PillarStatisticNumberWrapperForDischarge;
import com.envcheck.report.statistics.letnumberstatistics.utils.DischargeRateUtils;
import com.envcheck.view.checkinfo.bean.CheckInfo;
import com.envcheck.view.leakinfo.bean.LeakInfo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.examples.html.HSSFHtmlHelper;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * Created by susion on 2016/5/16.
 */
public class FileUtils {

    private static final int EXPORT_MODULE_INFO = 1;
    private static final int EXPORT_CHECK_INFO = 2;
    private static final int EXPORT_LEAK_INFO = 3;
    private static final int EXPORT_LET_CACULATE_INFO = 4;

    public static String createDir(String path) {
        File dir = new File(path);
        if(!dir.exists()){
            dir.mkdir();
        }
        return dir.getAbsolutePath();
    }

    public static void copyFile(String srcPath, String destPath) {

        try {
            File srcFile = new File(srcPath);
            FileInputStream in = new FileInputStream(srcFile);
            FileOutputStream out = new FileOutputStream(new File(destPath));

            byte[] buff = new byte[1024];
            int len = 0;

            while( (len = in.read(buff)) !=  -1){
                out.write(buff, 0, len);
            }

            in.close();
            out.close();

        }catch (Exception e){

        }


    }




    public static String getStringFromFile(File file) {
        try{
            StringBuilder sb = new StringBuilder();
            readToBuffer(sb, file);
            return sb.toString();

        }catch (Exception e){

        }
        return null;
    }


    public static void readToBuffer(StringBuilder buffer, File file) throws IOException {
        InputStream is = new FileInputStream(file);
        String line; // 用来保存每行读取的内容
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));  //指定字符编码
        line = reader.readLine(); // 读取第一行
        while (line != null) { // 如果 line 为空说明读完了
            buffer.append(line); // 将读到的内容添加到 buffer 中
            buffer.append("\n"); // 添加换行符
            line = reader.readLine(); // 读取下一行
        }
        reader.close();
        is.close();
    }


    public static void createPreeTaskForDownload(String pressFileName, File needToPressDir, File pressOutTargetDir) {

        try {

            ZipOutputStream zipOutFile = new ZipOutputStream(new FileOutputStream(pressOutTargetDir+File.separator+pressFileName));
            recursivePressFile(zipOutFile, needToPressDir, needToPressDir.getName());
            zipOutFile.close();

        }catch (Exception e){

        }

    }

    private static void recursivePressFile(ZipOutputStream zipOutFile, File needToPressDir, String needToPressDirName) throws IOException {

        File[] files = needToPressDir.listFiles();

        for(File file : files){
            if(file.isDirectory()){
                recursivePressFile(zipOutFile, file, needToPressDirName+File.separator+file.getName());  //构成目录的父子关系
            }else{
                pressFile(zipOutFile, file, needToPressDirName);
            }
        }
    }

    private static void pressFile(ZipOutputStream zipOutFile, File file, String parentDirName) throws IOException {

        FileInputStream inputStream = new FileInputStream(file);
        zipOutFile.putNextEntry(new ZipEntry(parentDirName+File.separator+file.getName()));

        byte[] buff = new byte[1024];
        int len = 0;

        while( (len = inputStream.read(buff)) !=  -1){
            zipOutFile.write(buff, 0, len);
        }

        inputStream.close();
    }

    public static boolean isDirExists(String labelPath) {

        File dir = new File(labelPath);

        return dir.exists();
    }


    public static void unZipFiles(File zipFile, String destDirPath) {
        try {

            File destDir = new File(destDirPath);

            if (!destDir.exists()) {
                destDir.mkdirs();
            }

            ZipFile zip = new ZipFile(zipFile);

            for (Enumeration entries = zip.entries(); entries.hasMoreElements(); ) {

                ZipEntry entry = (ZipEntry) entries.nextElement();
                String zipEntryName = entry.getName();
                InputStream in = zip.getInputStream(entry);


                //解决路径不兼容的问题
                String outPath = (destDirPath + File.separator+zipEntryName).replace('/', '\\');
                //判断路径是否存在,不存在则创建文件路径
                File file = new File(outPath.substring(0, outPath.lastIndexOf('\\')));

                if (!file.exists()) {
                    file.mkdirs();
                }

                OutputStream out = new FileOutputStream(new File(outPath));

                byte[] buf1 = new byte[1024];
                int len;
                while ((len = in.read(buf1)) > 0) {
                    out.write(buf1, 0, len);
                }
                in.close();
                out.close();
            }

        } catch (Exception e) {

        }
    }

    public static void deleteDir(String path) {

        File deleteFileFir = new File(path);

        if (deleteFileFir.exists() && deleteFileFir.isDirectory()) {
            for (File file : deleteFileFir.listFiles()) {
                recurisiveDeleteDir(file);
            }
        }

        deleteFileFir.delete();
    }

    public static void recurisiveDeleteDir(File recusivelyFile) {

        if (recusivelyFile.isDirectory()) {
            for (File file : recusivelyFile.listFiles()) {
                recurisiveDeleteDir(file);
            }
            recusivelyFile.delete();
        } else {
            recusivelyFile.delete();
        }
    }

    public static void exportModuleExcel(List<Module> moduleList,  String[] exportItem, File writeFileName, String companyName) throws IllegalAccessException, NoSuchFieldException, IOException {

        XSSFWorkbook  workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("module");
        Class<Module> moduleClass = Module.class;
        int rowNumber = 0;

        createTitleRow(workbook, sheet, "组件基础台账报表", rowNumber, rowNumber, rowNumber, 0, exportItem.length-1);
        rowNumber++;

        createTitleRow(workbook, sheet, companyName, rowNumber, rowNumber, rowNumber, 0, exportItem.length-1);
        rowNumber++;

        createHeadTitle(workbook, sheet, rowNumber, exportItem, EXPORT_MODULE_INFO);
        rowNumber++;

        for(Module module : moduleList) {

            if(module != null){

                Row moduleRow = createItemRow(workbook, sheet, rowNumber, exportItem.length);

                for (int i=0; i<exportItem.length; i++) {
                    String item = exportItem[i];

                    if(item.equals("locationDesc")){
                        moduleRow.getCell(i).setCellValue(getLocationDesc(module));
                        continue;
                    }

                    Field declaredField = moduleClass.getDeclaredField(item);
                    declaredField.setAccessible(true);
                    Object o = declaredField.get(module);
                    if(o != null){
                        if(item.equals("sizeMM") || item.equals("yearRunTime")){
                            int value = (int) o;
                            moduleRow.getCell(i).setCellValue(value);
                        }else if( item.equals("extendNumber") ){
                            int value = (int) o;
                            moduleRow.getCell(i).setCellValue(value+1);
                        }else if(item.equals("imgX") || item.equals("imgY") || item.equals("heatX") || item.equals("heatY") ){
                            float value = (float) o;
                            moduleRow.getCell(i).setCellValue(value);
                        }else{
                            String value = (String) o;
                            if(value != null){
                                moduleRow.getCell(i).setCellValue(value);
                            }
                        }
                    }
                }

                rowNumber++;
            }
        }

        rowNumber++;

        for(int i=0; i<exportItem.length; i++){
            sheet.autoSizeColumn(i);
        }

        FileOutputStream out = new FileOutputStream(writeFileName);

        try {
            workbook.write(out);
        } finally {
            out.close();
        }
        workbook.close();

    }

    public static String getLocationDesc(Module module) {

        StringBuilder builder = new StringBuilder();

        builder.append("设备名称:"+module.getEquipment()+" 位于"+(int)module.getFloor()+"层"+module.getMainReference()+" ");
        if(StringUtils.notIsNullAndEmptyString(module.getMainDirection())){
            builder.append(module.getMainDirection());
        }
        builder.append(" "+(int)module.getMainDistance()+"米处;");

        return  builder.toString();
    }

    public static void exportCheckInfo(List<CheckInfo> checkInfoItems, String[] exportItem, File exportExcelFile, String companyNameCN) throws IllegalAccessException, NoSuchFieldException, IOException  {
        XSSFWorkbook  workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("module");
        Class<CheckInfo> checkInfoClass = CheckInfo.class;
        int rowNumber = 0;

        createTitleRow(workbook, sheet, "检测历史报告", rowNumber, rowNumber, rowNumber, 0, exportItem.length-1);
        rowNumber++;

        createTitleRow(workbook, sheet, companyNameCN, rowNumber, rowNumber, rowNumber, 0, exportItem.length-1);
        rowNumber++;

        createHeadTitle(workbook, sheet, rowNumber, exportItem, EXPORT_CHECK_INFO);
        rowNumber++;

        for(CheckInfo checkInfo : checkInfoItems) {

            Row moduleRow = createItemRow(workbook, sheet, rowNumber, exportItem.length);

            for (int i=0; i<exportItem.length; i++) {
                String item = exportItem[i];

                if(item.equals("locationDesc")){
                    moduleRow.getCell(i).setCellValue(checkInfo.getLocationDesc());
                    continue;
                }

                Field declaredField = checkInfoClass.getDeclaredField(item);
                declaredField.setAccessible(true);
                Object o = declaredField.get(checkInfo);

                if(item.equals("extendNumber") || item.equals("siezMM") || item.equals("PPMNumber") || item.equals("leakThreshold") || item.equals("backgroundPPMNumber")){
                    int value = (int) o;
                    if(item.equals("extendNumber")){
                        moduleRow.getCell(i).setCellValue(value+1);
                    }else{
                        moduleRow.getCell(i).setCellValue(value);
                    }
                }else if(item.equals("leak")){
                    boolean flag = (boolean) o;
                    if(flag){
                        moduleRow.getCell(i).setCellValue("泄露");
                    }else{
                        moduleRow.getCell(i).setCellValue("不泄露");
                    }
                }else{
                    String value = (String) o;
                    moduleRow.getCell(i).setCellValue(value);
                }
            }
            rowNumber++;
        }

        for(int i=0; i<exportItem.length; i++){
            sheet.autoSizeColumn(i);
        }

        FileOutputStream out = new FileOutputStream(exportExcelFile);

        try {
            workbook.write(out);
        } finally {
            out.close();
        }
        workbook.close();

    }

    public static void exportLeakInfo(List<LeakInfo> leakInfoItems, String[] exportItem, File exportExcelFile, String companyNameCN) throws IllegalAccessException, NoSuchFieldException, IOException {

        XSSFWorkbook  workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("module");

        sheet.setAutobreaks(true);

        Class<LeakInfo> leakInfoClass = LeakInfo.class;
        int rowNumber = 0;

        createTitleRow(workbook, sheet, "泄露历史报告", rowNumber, rowNumber, rowNumber, 0, exportItem.length-1);
        rowNumber++;

        createTitleRow(workbook, sheet, companyNameCN, rowNumber, rowNumber, rowNumber, 0, exportItem.length-1);
        rowNumber++;

        createHeadTitle(workbook, sheet, rowNumber, exportItem, EXPORT_LEAK_INFO);
        rowNumber++;

        for(LeakInfo leakInfo : leakInfoItems) {

            Row moduleRow = createItemRow(workbook, sheet, rowNumber, exportItem.length);
            setLeakInfoToExcelRow(exportItem, leakInfoClass, leakInfo, moduleRow);
            rowNumber++;
        }

        for(int i=0; i<exportItem.length; i++){
            sheet.autoSizeColumn(i);
        }


        FileOutputStream out = new FileOutputStream(exportExcelFile);

        try {
            workbook.write(out);
        } finally {
            out.close();
        }
        workbook.close();


    }

    public static void exportRepairInfo(List<LeakInfo> leakInfoItems,File exportExcelFile, String companyNameCN) throws IOException, NoSuchFieldException, IllegalAccessException {

        String[] exportItemBase = {"device", "area","labelNumber","extendNumber","locationDesc","moduleType","sizeMM","mediumStatus"};
        String[] exportItemCheckItem ={"leakThreshold","checkDate","checkPerson","backgroundPPMNumber","cleanPPMValue","leakSource","repairResult","repairNumber"};
        String[] exportItemRepeateItem = {"firstRepeateValue","firstRepeateDate","endRepeateValue","endRepeateDate"}; //维修日期， 维修人

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("module");
        //XSSFPatriarch drawing = sheet.createDrawingPatriarch();
        Drawing drawing = sheet.createDrawingPatriarch();

        int rowNumber = 0;
        createTitleRow(workbook, sheet, "LDAR维修工单", rowNumber, rowNumber, rowNumber, 0, exportItemBase.length-1);
        rowNumber++;

        createTitleRow(workbook, sheet, companyNameCN, rowNumber, rowNumber, rowNumber, 0, exportItemBase.length-1);
        rowNumber++;
        rowNumber++;

        for(LeakInfo leakInfo : leakInfoItems) {
            rowNumber = createRepairInfo(workbook, sheet, rowNumber, leakInfo, exportItemBase, exportItemCheckItem, exportItemRepeateItem, drawing);
            rowNumber++;
        }


       for(int i=0; i<exportItemBase.length; i++){
           sheet.autoSizeColumn(i);
       }

        FileOutputStream out = new FileOutputStream(exportExcelFile);
        try {
            workbook.write(out);
        } finally {
            out.close();
            workbook.close();
        }
    }


    public static void exportLetCaculate(List<LetForModule> letForModules, String startTimeStr, String endTimeStr, File exportExcelFile, String companyNameCN) throws IOException, IllegalAccessException, NoSuchFieldException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("module");
        Class<LetForModule> letForModuleClass = LetForModule.class;
        String[] exportItem = {"device", "area", "equipment", "labelNumber", "extendNumber", "mediumStatus", "diffToCheck", "totalRunTime", "dischargeSpeed", "totalLetNumber"};
        String[] dischargeFormule = {"平均排放速率（kg/h/排放源)", "默认零值排放速率（kg/h/排放源)", "相关方程（kg/h/排放源)", "净检测值SV的指数", "超限阈值（PPM)", "超阈限定排放速率（kg/h/排放源)"};

        int rowNumber = 0;
        rowNumber = createTitleRow(workbook, sheet, startTimeStr+"-"+endTimeStr+" 排放量统计", rowNumber, rowNumber, rowNumber, 0,  exportItem.length + dischargeFormule.length);
        rowNumber++;
        createTitleRow(workbook, sheet, companyNameCN, rowNumber, rowNumber, rowNumber, 0, exportItem.length + dischargeFormule.length);//  计算排放相关的参数
        rowNumber++;

        Row headTitle = createHeadTitle(workbook, sheet, rowNumber, exportItem, EXPORT_LET_CACULATE_INFO); //计算排放相关的参数标题头
        for(int i=0; i<dischargeFormule.length; i++){
            XSSFCellStyle headStyle = createCellStyle(workbook, (short)9);
            Cell cell = headTitle.createCell(i+exportItem.length);
            cell.setCellStyle(headStyle);
            cell.setCellValue(dischargeFormule[i]);
        }

        rowNumber++;


        for(LetForModule letForModule : letForModules){

            Row letForModuleRow = createItemRow(workbook, sheet, rowNumber, exportItem.length+dischargeFormule.length);

            for (int i=0; i<exportItem.length; i++) {

                String item = exportItem[i];
                Field declaredField = letForModuleClass.getDeclaredField(item);
                declaredField.setAccessible(true);
                Object o = declaredField.get(letForModule);

                if(o != null){
                    if(item.equals("extendNumber") ){
                        int value = (int) o;
                        letForModuleRow.getCell(i).setCellValue(value+1);
                    }else if(item.equals("totalRunTime") || item.equals("totalLetNumber") || item.equals("dischargeSpeed")){
                        double value = (double) o;
                        letForModuleRow.getCell(i).setCellValue(value);
                    } else{
                        String value = (String) o;
                        if(value != null){
                            letForModuleRow.getCell(i).setCellValue(value);
                        }
                    }
                }
            }

            DischargeFormula dischargeFormula = null;

            if("化工".equals(letForModule.getDeviceType())){

                if("否".equals(letForModule.getDiffToCheck())){
                    dischargeFormula = getDischargeFormula(letForModule, DischargeFormulaConstant.chemicalDischargeFormulaMapEasy);
                }else{
                    dischargeFormula = getDischargeFormula(letForModule, DischargeFormulaConstant.chemicalDischargeFormulaMapDiff);

                }

            }

            if("炼油".equals(letForModule.getDeviceType())){

                if("否".equals(letForModule.getDiffToCheck())){
                    dischargeFormula = getDischargeFormula(letForModule, DischargeFormulaConstant.oillDischargeFormulaMapEasy);
                }else{
                    dischargeFormula = getDischargeFormula(letForModule, DischargeFormulaConstant.oillDischargeFormulaMapDiff);
                }
            }

            if(dischargeFormula != null){

//                dischargeFormula.dischargeSpeed = DischargeRateUtils.getDischargeRate(letForModule.getDiffToCheck(), letForModule.getModuleType(),
//                        letForModule.getMediumStatus(), letForModule.getCleanPPM(),letForModule.getDeviceType());
//                letForModuleRow.getCell(exportItem.length+0).setCellValue(dischargeFormula.dischargeSpeed);
                letForModuleRow.getCell(exportItem.length+0).setCellValue(dischargeFormula.averageDischargeSpeed);
                letForModuleRow.getCell(exportItem.length+1).setCellValue(dischargeFormula.defaultZeroDischargeSpeed);
                letForModuleRow.getCell(exportItem.length+2).setCellValue(dischargeFormula.relativeFormula);
                letForModuleRow.getCell(exportItem.length+3).setCellValue(dischargeFormula.cleanPPMPow);
                letForModuleRow.getCell(exportItem.length+4).setCellValue(dischargeFormula.thresholdValue);
                letForModuleRow.getCell(exportItem.length+5).setCellValue(dischargeFormula.thresholdSpeed);
            }

            rowNumber++;
        }

        FileOutputStream out = new FileOutputStream(exportExcelFile);
        try {
            workbook.write(out);
        } finally {
            out.close();
        }
        workbook.close();
    }

    public static void exportLetCaculateForDevice(PillarStatisticNumberWrapperForDischarge deviceWrapper, PieStatisticNumberWrapperForDischarge moduleTypeWrapper, File exportExcelFile, String companyNameCN) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("module");

        int rowNumber = 0;
        rowNumber = createTitleRow(workbook, sheet, "排放量统计", rowNumber, rowNumber, rowNumber, 0,  1);
        rowNumber++;
        createTitleRow(workbook, sheet, companyNameCN, rowNumber, rowNumber, rowNumber, 0, 1);
        rowNumber++;

        createTitleRow(workbook, sheet, "按装置(千克)", rowNumber, rowNumber, rowNumber, 0, 1);
        rowNumber++;
        rowNumber = setLetRow(workbook, sheet, rowNumber, deviceWrapper.getTitles(), deviceWrapper.getStatisticInfo());
        rowNumber++;

        createTitleRow(workbook, sheet, "按组件类型(千克)", rowNumber, rowNumber, rowNumber, 0, 1);
        rowNumber++;
        rowNumber = setLetRowFoeModuleType(workbook, sheet, rowNumber, moduleTypeWrapper.getTitles(), moduleTypeWrapper.getStatisticInfo());

        FileOutputStream out = new FileOutputStream(exportExcelFile);
        try {
            workbook.write(out);
        } finally {
            out.close();
        }
        workbook.close();


    }

    public static void exportLetCaculateForDevice(PieStatisticNumberWrapperForDischarge mediumStatusWrapper, File exportExcelFile, String companyNameCN) throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("module");

        int rowNumber = 0;
        rowNumber = createTitleRow(workbook, sheet, "排放量统计", rowNumber, rowNumber, rowNumber, 0,  1);
        rowNumber++;
        createTitleRow(workbook, sheet, companyNameCN, rowNumber, rowNumber, rowNumber, 0, 1);
        rowNumber++;

        createTitleRow(workbook, sheet, "按物料类型", rowNumber, rowNumber, rowNumber, 0, 1);
        rowNumber++;
        rowNumber = setLetRowFoeModuleType(workbook, sheet, rowNumber, mediumStatusWrapper.getTitles(), mediumStatusWrapper.getStatisticInfo());

        FileOutputStream out = new FileOutputStream(exportExcelFile);
        try {
            workbook.write(out);
        } finally {
            out.close();
        }
        workbook.close();

    }

    public static void exportMinusLetNumber(List<MinusLetNumber> minusLetNumbers, File exportExcelFile, String companyNameCN, TotalInfoForMinusLetNumber totalInfo) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("module");
        String[] title2 = {"标签号", "扩展号", "装置", "区域", "运行时间(h)", "原排放量(kg)","修复后的排放量(kg)", "减排量(kg)"};
        int rowNumber = 0;
        rowNumber = createTitleRow(workbook, sheet, "修复密封点的减排量", rowNumber, rowNumber, rowNumber, 0, title2.length - 1);
        rowNumber++;
        createTitleRow(workbook, sheet, companyNameCN, rowNumber, rowNumber, rowNumber, 0, title2.length - 1);
        rowNumber++;
        createRepairInfoTitleRow(workbook, sheet, rowNumber, title2);
        rowNumber++;

        for(MinusLetNumber minusLetNumber : minusLetNumbers){
            Row row = createItemRow(workbook, sheet, rowNumber,title2.length);
            row.getCell(0).setCellValue(minusLetNumber.getLabelNumber());
            row.getCell(1).setCellValue(minusLetNumber.getExtendNumber());
            row.getCell(2).setCellValue(minusLetNumber.getDevice());
            row.getCell(3).setCellValue(minusLetNumber.getArea());
            row.getCell(4).setCellValue(minusLetNumber.getRunTime());
            row.getCell(5).setCellValue(minusLetNumber.getOldLetNumber());
            row.getCell(6).setCellValue(minusLetNumber.getNewLetNummber());
            row.getCell(7).setCellValue(minusLetNumber.getMinusLetNumber());
            rowNumber++;
        }


        //设置减排量的总的统计信息
        Row row = createItemRow(workbook, sheet, rowNumber,title2.length);
        row.getCell(0).setCellValue("总计");
        row.getCell(5).setCellValue(totalInfo.totalOldLetNumber);
        row.getCell(6).setCellValue(totalInfo.totalNewLetNumber);
        row.getCell(7).setCellValue(totalInfo.totalOldLetNumber - totalInfo.totalNewLetNumber);


        FileOutputStream out = new FileOutputStream(exportExcelFile);
        try {
            workbook.write(out);
        } finally {
            out.close();
        }
        workbook.close();

    }


    private static DischargeFormula getDischargeFormula(LetForModule letForModule, Map<String, DischargeFormula> dischargeFormulaMap) {
        DischargeFormula dischargeFormula;
        dischargeFormula = dischargeFormulaMap.get(letForModule.getModuleType() + "-" + letForModule.getMediumStatus());
        if(dischargeFormula == null){
            dischargeFormula = dischargeFormulaMap.get(letForModule.getModuleType());
            if(dischargeFormula == null){
                dischargeFormula = dischargeFormulaMap.get("其他");
            }
        }
        return dischargeFormula;
    }

    private static int createRepairInfo(XSSFWorkbook workbook, XSSFSheet sheet, int rowNumber, LeakInfo leakInfo, String[] exportItemBase, String[] exportItemCheckItem, String[] exportItemRepeateItem, Drawing drawing) throws NoSuchFieldException, IllegalAccessException, IOException {

        Class<LeakInfo> leakInfoClass = LeakInfo.class;
        String[] title = {"装置", "区域", "标签号", "扩展号", "位置描述", "组件类型", "尺寸(mm)", "介质状态"};
        createRepairInfoTitleRow(workbook, sheet, rowNumber, title);
        rowNumber++;
        Row baseRow = createItemRow(workbook, sheet, rowNumber, exportItemBase.length);
        setLeakInfoToExcelRow(exportItemBase, leakInfoClass, leakInfo, baseRow);
        rowNumber++;

        String[] title2 = {"泄露阈值", "检测日期", "检测人", "PPM背景值", "净PPM值", "泄露源", "维修结果", "维修次数"};
        createRepairInfoTitleRow(workbook, sheet, rowNumber, title2);
        rowNumber++;
        Row checkRow = createItemRow(workbook, sheet, rowNumber, exportItemCheckItem.length);
        setLeakInfoToExcelRow(exportItemCheckItem, leakInfoClass, leakInfo, checkRow);
        rowNumber++;

        String[] title3 = {"维修日期", "维修人", "首次复测值", "首次复测日期", "最终复测值", "最终复测日期"};
        createRepairInfoTitleRow(workbook, sheet, rowNumber, title3);

        rowNumber++;
        Row reperateRow = createItemRow(workbook, sheet, rowNumber, exportItemRepeateItem.length+2);
        setLeakInfoToRepeateExcelRow(exportItemRepeateItem, leakInfoClass, leakInfo, reperateRow);
        rowNumber++;
        rowNumber++;

        File pictureFile = new File(leakInfo.getPictureLocalPath());

        if(pictureFile.exists()){
            byte[] bytes = getBytesFormImageFile(pictureFile);
            CreationHelper helper = workbook.getCreationHelper();
            ClientAnchor anchor = helper.createClientAnchor();
            anchor.setCol1(1);
            anchor.setRow1(rowNumber);
            anchor.setCol2(6);
            anchor.setRow2(rowNumber+28);
            anchor.setDx1(0);
            anchor.setDx2(0);
            anchor.setDy1(0);
            anchor.setDy2(0);
            drawing.createPicture(anchor, workbook.addPicture(bytes, XSSFWorkbook.PICTURE_TYPE_JPEG));
        }

        return  rowNumber+29;
    }

    private static byte[] getBytesFormImageFile(File file) throws IOException {
        byte[] picData = new byte[(int)file.length()];
        byte[] bytes = new byte[(int)file.length()];
        InputStream input = new BufferedInputStream(new FileInputStream(file));
        FileInputStream picIn = new FileInputStream( file );
        picIn.read( picData );
        try {
            int offset = 0;
            int read = -1;
            while((read = input.read()) != -1)
                bytes[offset++] = (byte)read;
        } finally {
            input.close();
        }
        return bytes;
    }

    private static void createRepairInfoTitleRow(XSSFWorkbook workbook, XSSFSheet sheet, int rowNumber, String[] title) {
        Row sheetRow = sheet.createRow(rowNumber);
        for(int i=0;i<title.length;i++){
            XSSFCellStyle headStyle = createCellStyle(workbook, (short)9);
            Cell cell = sheetRow.createCell(i);
            cell.setCellStyle(headStyle);
            cell.setCellValue(title[i]);

        }
    }


    private static void setLeakInfoToExcelRow(String[] exportItem, Class<LeakInfo> leakInfoClass, LeakInfo leakInfo, Row moduleRow) throws NoSuchFieldException, IllegalAccessException {

        for (int i=0; i<exportItem.length; i++) {
            String item = exportItem[i];

            if(item.equals("locationDesc")){
                moduleRow.getCell(i).setCellValue(leakInfo.getLocationDesc());
                continue;
            }

            Field declaredField = leakInfoClass.getDeclaredField(item);
            declaredField.setAccessible(true);
            Object o = declaredField.get(leakInfo);

            if(o != null){

                if(item.equals("extendNumber") || item.equals("sizeMM") || item.equals("cleanPPMValue") || item.equals("leakThreshold") || item.equals("backgroundPPMNumber")
                        || item.equals("repairNumber") || item.equals("firstRepeateValue") || item.equals("endRepeateValue")){
                    int value = (int) o;
                    if(item.equals("extendNumber")){
                        moduleRow.getCell(i).setCellValue(value+1);
                    }else{
                        moduleRow.getCell(i).setCellValue(value);
                    }
                }else if(item.equals("leak") || item.equals("tempRepair") || item.equals("hasRepair") || item.equals("repairResult") ){
                    boolean flag = (boolean) o;
                    if(flag){
                        moduleRow.getCell(i).setCellValue("是");
                    }else{
                        moduleRow.getCell(i).setCellValue("否");
                    }
                }else if(item.equals("checkDate") || item.equals("firstRepeateDate") || item.equals("endRepeateDate")){
                    if(o != null){
                        Date date = (Date) o;
                        String dateStr = StringUtils.formatDate(date);
                        moduleRow.getCell(i).setCellValue(dateStr);
                    }
                }else{
                    if(o != null){
                        String value = (String) o;
                        moduleRow.getCell(i).setCellValue(value);
                    }
                }
            }
        }
    }

    private static void setLeakInfoToRepeateExcelRow(String[] exportItemBase, Class<LeakInfo> leakInfoClass, LeakInfo leakInfo, Row reperateRow) throws NoSuchFieldException, IllegalAccessException {

        if(leakInfo.isHasRepair()){
            if(leakInfo.getFirstRepeateDate() != null){
                reperateRow.getCell(0).setCellValue(StringUtils.formatDate(leakInfo.getFirstRepeateDate()));
                reperateRow.getCell(1).setCellValue(UserContextHolder.getCurrentUser().getCompanyNameCN()+"维修人");
            }

            for (int i=0; i<exportItemBase.length; i++) {
                String item = exportItemBase[i];
                Field declaredField = leakInfoClass.getDeclaredField(item);
                declaredField.setAccessible(true);
                Object o = declaredField.get(leakInfo);

                if(o != null){
                    if(item.equals("firstRepeateValue") || item.equals("endRepeateValue")){
                        int value = (int) o;
                        reperateRow.getCell(i+2).setCellValue(value);
                    }else if(item.equals("firstRepeateDate") || item.equals("endRepeateDate")){
                        if(o != null){
                            Date date = (Date) o;
                            String dateStr = StringUtils.formatDate(date);
                            reperateRow.getCell(i+2).setCellValue(dateStr);
                        }
                    }
                }
            }

        }
    }

    private static Row createHeadTitle(XSSFWorkbook workbook, XSSFSheet sheet, int rowNumber, String[] exportItem, int type) {
        Row sheetRow = sheet.createRow(rowNumber);

        for(int i=0;i<exportItem.length;i++){
            XSSFCellStyle headStyle = createCellStyle(workbook, (short)9);
            Cell cell = sheetRow.createCell(i);
            cell.setCellStyle(headStyle);

            switch (type){
                case EXPORT_MODULE_INFO:
                    cell.setCellValue(Constant.MODULE_TITLE.get(exportItem[i]));
                    break;
                case EXPORT_CHECK_INFO:
                    cell.setCellValue(Constant.CHECK_INFO_TITLE.get(exportItem[i]));
                    break;
                case EXPORT_LEAK_INFO:
                    cell.setCellValue(Constant.LEAK_INFO_TITLE.get(exportItem[i]));
                    break;
                case EXPORT_LET_CACULATE_INFO:
                    cell.setCellValue(Constant.LET_CACULATE_INFO.get(exportItem[i]));
                    break;
            }
        }

        return  sheetRow;
    }

    private static int createTitleRow(XSSFWorkbook workbook, XSSFSheet sheet, String title, int rowNumber, int startX, int endX, int startY, int endY) {

       XSSFCellStyle headStyle = createCellStyle(workbook, (short)13);
        sheet.addMergedRegion(new CellRangeAddress(startX, endX, startY, endY));  //必须要先合并
        XSSFRow titleRow = sheet.createRow(rowNumber);
        XSSFCell titleRowCell = titleRow.createCell(startY);  //......
        titleRowCell.setCellStyle(headStyle);
        titleRowCell.setCellValue(title);

        return rowNumber;
    }



    public static Row createItemRow(XSSFWorkbook workbook, Sheet sheet, int row, int length){

        Row sheetRow = sheet.createRow(row);
        for(int i=0;i<length;i++){
           // XSSFCellStyle itemStyle = createCellStyle(workbook, (short) 0);
            Cell cell = sheetRow.createCell(i);
          //  cell.setCellStyle(itemStyle);
        }
        return sheetRow;
    }

    private static XSSFCellStyle createCellStyle(XSSFWorkbook workbook, short fontSize) {

        XSSFCellStyle cellStyle = workbook.createCellStyle();

        cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        if(fontSize != 0){
            XSSFFont font = workbook.createFont();
            font.setBold(true);
            font.setFontHeightInPoints(fontSize);
            cellStyle.setFont(font);
        }else{
        }

        return cellStyle;

    }


    public static void exportModulePictureExcel(List<Module> moduleList, File exportExcelFile, String companyNameCN) throws IOException, NoSuchFieldException, IllegalAccessException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("module");
        Drawing drawing = sheet.createDrawingPatriarch();

        int rowNumber = 0;
        createTitleRow(workbook, sheet, "组件图片台账报告", rowNumber, rowNumber, rowNumber, 0,  5);
        rowNumber++;

        createTitleRow(workbook, sheet, companyNameCN, rowNumber, rowNumber, rowNumber, 0, 5);
        rowNumber++;
        rowNumber++;

        String[] exportItem = {"labelNumber", "locationDesc", "device", "area"};
        String lastLabel = "0";
        for(Module module : moduleList){
            if(!module.getLabelNumber().equals(lastLabel)){
                rowNumber = createModulePictureInfo(workbook, sheet, rowNumber, module, drawing, exportItem);
                rowNumber++;
            }
            lastLabel = module.getLabelNumber();
        }

        FileOutputStream out = new FileOutputStream(exportExcelFile);
        try {
            workbook.write(out);
        } finally {
            out.close();
        }
        workbook.close();


    }

    private static int createModulePictureInfo(XSSFWorkbook workbook, XSSFSheet sheet, int rowNumber, Module module, Drawing drawing, String[] exportItem) throws IOException, NoSuchFieldException, IllegalAccessException {

        Class<Module> moduleClass = Module.class;
        String[] title2 = {"标签号", "位置描述","装置", "区域"};
        createRepairInfoTitleRow(workbook, sheet, rowNumber, title2);
        rowNumber++;
        Row modulePictureRow = createItemRow(workbook, sheet, rowNumber, exportItem.length);
        setModulePictureInfoToExcelRow(exportItem, module, modulePictureRow, moduleClass);
        rowNumber++;

        if(module.getPicturePath() != null){

            String filePath = module.getPicturePath().substring(0, module.getPicturePath().lastIndexOf("\\"))+"\\handle.jpg";
            File pictureFile = new File(filePath);
            if(pictureFile.exists()){
                byte[] bytes = getBytesFormImageFile(pictureFile);
                CreationHelper helper = workbook.getCreationHelper();
                ClientAnchor anchor = helper.createClientAnchor();
                anchor.setCol1(0);
                anchor.setRow1(rowNumber);
                anchor.setCol2(6);
                anchor.setRow2(rowNumber+30);

                drawing.createPicture(anchor, workbook.addPicture(bytes, XSSFWorkbook.PICTURE_TYPE_JPEG));
            }

        }

        return  rowNumber+31;
    }

    private static void setModulePictureInfoToExcelRow(String[] exportItem, Module module, Row modulePictureRow, Class<Module> moduleClass) throws NoSuchFieldException, IllegalAccessException {

        for (int i=0; i<exportItem.length; i++) {
            String item = exportItem[i];

            if(item.equals("locationDesc")){
                modulePictureRow.getCell(i).setCellValue(getLocationDesc(module));
                continue;
            }
            Field declaredField = moduleClass.getDeclaredField(item);
            declaredField.setAccessible(true);
            Object o = declaredField.get(module);

            String value = (String) o;
            modulePictureRow.getCell(i).setCellValue(value);

        }
    }


    private static int setLetRowFoeModuleType(XSSFWorkbook workbook, XSSFSheet sheet, int rowNumber, List<String> titles, List<PieStatisticNumberForDischarge> statisticInfo) {
        for(int i=0; i<titles.size(); i++){
            String deviceTitle = titles.get(i);
            Row itemRow = createItemRow(workbook, sheet, rowNumber, 2);
            itemRow.getCell(0).setCellValue(deviceTitle);
            itemRow.getCell(1).setCellValue(statisticInfo.get(i).getValue());
            rowNumber++;
        }
        return  rowNumber;
    }

    private static int setLetRow(XSSFWorkbook workbook, XSSFSheet sheet, int rowNumber, List<String> titles, List<Float> statisticInfo) {

        for(int i=0; i<titles.size(); i++){
            String deviceTitle = titles.get(i);
            Row itemRow = createItemRow(workbook, sheet, rowNumber, 2);
            itemRow.getCell(0).setCellValue(deviceTitle);
            itemRow.getCell(1).setCellValue(statisticInfo.get(i));
            rowNumber++;
        }

        return  rowNumber;
    }



}
