package utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// We need to import Apache POI libraries for this to work.

public class ExcelUtility1 {
    // Order: 1. filePath, 2.Workbook, 3.Sheet, 4.Rows & Cols, 5.Cell (For each step we will create a method).
    String projectPath = System.getProperty("user.dir");
    FileInputStream fileInputStream;
    Workbook workbook;
    Sheet sheet;
    void getFilePath(String filePath) {
        try {
            fileInputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void getSheet(String sheetName) {
        sheet = workbook.getSheet(sheetName);
    }

    int rowCount() {
        return sheet.getPhysicalNumberOfRows();           // This method will return total count of rows.
    }

    int colsCount() {
        return sheet.getRow(0).getLastCellNum();       // This method will return total count of columns.
    }

}
