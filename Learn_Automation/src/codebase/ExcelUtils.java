package codebase;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelUtils {

    public Object[][] getDataSet(String sheetName,String fileName){
        Workbook book = null;
        try {
            if (fileName.endsWith(".xlsx")) {
                book = new XSSFWorkbook(new FileInputStream(fileName));
            } else {
                book = new HSSFWorkbook(new FileInputStream(fileName));
            }
        }catch (Exception e){e.printStackTrace();}
        Sheet sheet = book.getSheet(sheetName);
        int numberOfRows = sheet.getPhysicalNumberOfRows();
        int numberOfColumns = sheet.getRow(0).getPhysicalNumberOfCells();
        String excelArray[][] = new String[numberOfRows-1][numberOfColumns];
        int count = 0;
        Iterator<Row> iRow = sheet.rowIterator();
        iRow.next();
        while(iRow.hasNext()){
            int colCount = 0;
            Row row = iRow.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while(cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                excelArray[count][colCount] = cell.getStringCellValue();
                colCount++;
            }
            count++;
        }
        return excelArray;
    }

}

