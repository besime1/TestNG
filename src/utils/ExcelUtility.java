package utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

// We need to import Apache POI libraries for this to work.

public class ExcelUtility {
    public static String projectPath;
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

    private int colsCount() {
        return sheet.getRow(0).getLastCellNum();       // This method will return total count of columns.
    }

     String getCell(int rowIndex, int columnIndex) {      // This method will read from a cell based on the index of given row and column .
        return sheet.getRow(rowIndex).getCell(columnIndex).toString();
    }

    public static Object[][] readFromExcel(String filePath, String sheetName) {
        getFilePath(filePath);
        getSheet(sheetName);

        int rows = rowCount();
        int cols = colsCount();

        Object[][] data = new Object[rows-1][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //String cellValue=   sheet.getRow(i).getCell(j).toString();
                // data[i][j]= getCell(i,j)=sheet.getRow(i).getCell(j).toString();
               // String cellValue= getCell(i,j)
                data[i-1][j]= getCell(i,j);
            }
        }
        return data;
    }

}