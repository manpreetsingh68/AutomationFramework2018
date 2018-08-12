package com.automation.Utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class ExcelReader {

    public static Object[][] getExcelData(String inputFile, String sheetName){
        Workbook workbook= null;
        try {
            System.out.println("Reading data from excel file "+inputFile);
            List<LinkedHashMap<String,String>> allRecords= new ArrayList<>();
            workbook= new XSSFWorkbook(inputFile);
            Sheet sheet= workbook.getSheet(sheetName);

            for(int i=1; i<=sheet.getLastRowNum(); i++ ){
                LinkedHashMap<String,String> map1= new LinkedHashMap<>();
                map1.put("username",getValue(sheet,i,0).toString());
                map1.put("password",getValue(sheet,i,1).toString());
                map1.put("account",getValue(sheet,i,2).toString());
                map1.put("expected balance",getValue(sheet,i,3).toString());
                allRecords.add(map1);
            }
            System.out.println("Records found in excel file "+allRecords.size());

            Object[][] arrData= new Object[allRecords.size()][1];
            for (int i=0;i< allRecords.size();i++){
                HashMap<String,String> map= allRecords.get(i);
                arrData[i][0]= map;
            }
            return arrData;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            if(workbook!=null){
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private static Object getValue(Sheet sheet, int rowIndex, int colIndex) {
        Object value =null;
        Cell c = sheet.getRow(rowIndex).getCell(colIndex);
        switch (c.getCellTypeEnum()) {
            case STRING:
                value= c.getStringCellValue();
                break;
            case NUMERIC:
                value=c.getNumericCellValue();
                break;
            case _NONE:
            case BLANK:
                value="";
                break;
            case ERROR:
                value="#ERR#";
                break;
            case BOOLEAN:
                value = c.getBooleanCellValue();
                break;
            case FORMULA:
                value= c.getCellFormula();
                break;
            default:
                break;
        }
        return value;
    }
}

