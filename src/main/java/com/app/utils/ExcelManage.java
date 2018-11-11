package com.app.utils;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class ExcelManage {

    public Object[][] getExcelData(String excelLocation, String sheetName) {

        try{
            Object dataSets[][]=null;

            FileInputStream fis= new FileInputStream(new File(excelLocation) );
            XSSFWorkbook workbook= new XSSFWorkbook(fis);
            XSSFSheet sheet= workbook.getSheet(sheetName);

            //FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

            int totalNumberOfRows= sheet.getLastRowNum();
            System.out.println(totalNumberOfRows);
            int totalNumberOfColumns= sheet.getRow(0).getLastCellNum();

            dataSets = new Object[totalNumberOfRows+1][totalNumberOfColumns];


            Iterator<Row> rowIterator = sheet.iterator();
            int i=0;
            while(rowIterator.hasNext()){
                Row row= rowIterator.next();

                Iterator<Cell> cellIterator = row.cellIterator();
                int j=0;
                while(cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();

                    if (cell != null) {
                        switch (cell.getCellType()) {
                            case BOOLEAN:
                                dataSets[i][j++] = cell.getBooleanCellValue();
                                break;
                            case NUMERIC:
                                dataSets[i][j++] = cell.getNumericCellValue();
                                break;
                            case STRING:
                                dataSets[i][j++] = cell.getStringCellValue();
                                break;
                            case FORMULA:
                                dataSets[i][j++] = cell.getCellFormula();
                                break;
                            case BLANK:
                                break;
                            case ERROR:
                                dataSets[i][j++] = cell.getStringCellValue();
                                break;
                            default:
                                System.out.println("No matching data type found");
                                break;
                        }


                    }
                }
                i++;
            }

            return dataSets;

        }catch(Exception e){
            e.printStackTrace();

        }
        return null;
    }

    @Test
    public void test(){
        ExcelManage excelManage= new ExcelManage();
        String excelLocation =System.getProperty("user.dir")+"/src/main/resources/testData/testData.xlsx";

        Object[][] data = excelManage.getExcelData(excelLocation, "LoginDetails");
        System.out.println(data);
        System.out.println(data[0][0]);
        System.out.println(data[1][1]);

    }


}
