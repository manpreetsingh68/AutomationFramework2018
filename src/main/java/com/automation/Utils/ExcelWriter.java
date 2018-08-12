package com.automation.Utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ExcelWriter {
    public static void saveResult(String filePath,String sheetName,List<String> status, int colNo) {
        Workbook workbook= null;
        try {
            workbook= new XSSFWorkbook(filePath);
            Sheet sheet= workbook.getSheet(sheetName);

            for (int i=1; i<= status.size();i++){
                Row row= sheet.getRow(i);
                if(row == null ){
                    row= sheet.createRow(i);
                }
                Cell cell= row.getCell(colNo);
                if(cell == null){
                    cell= row.createCell(colNo);
                }
                cell.setCellValue(status.get(i-1));

            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to save result in excel file",e);
        }
        finally {
            if(workbook!= null){
                //save the workbook
                try {
                    OutputStream os= new FileOutputStream(filePath+"_output.xlsx");
                    workbook.write(os);
                    workbook.close();
                    Files.delete(Paths.get(filePath));
                    Files.move(Paths.get(filePath+"_output.xlsx"),Paths.get(filePath));

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
