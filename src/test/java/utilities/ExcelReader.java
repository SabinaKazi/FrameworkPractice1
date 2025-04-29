package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelReader {
	
	/*
	 * "In the ExcelUtils class, we are declaring workbook and sheet as static 
	 * variables, so they can be shared across all static methods without needing 
	 * to create an object of the class.
Workbook represents the entire Excel file in memory, and Sheet represents a specific
 worksheet (like a tab) inside that workbook."
	 */
	
	
	public static Object[][] getData(String filePath, String sheetName)
	{
		 Object[][] data = null;
	//String path = System.getProperty("user.dir")+"/src/test/resources/testData/SearchData.xlsx";
		 // we use this method to get location dynamically
	try {
		
	FileInputStream fis = new FileInputStream(filePath);
	//fileinout strean ckass will Open file in reading mode and pass path of xlsx file and it will store in fis object
	// it will throgh filenotfound exception if file location is not correct or file doesnt exist 
	// for that we keep this code in try catch block
	
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	// from this file we have to extract workbook or capture workbook
	
	XSSFSheet sheet = workbook.getSheet(sheetName);
	// in the workbook multiple sheets are there and we have to extract perticular sheet by providing sheetname
	
	int rowcount = sheet.getLastRowNum();
	// using sheet object we can get total number of rows using getLastRownum methods
	
	int cellcount = sheet.getRow(0).getLastCellNum();
	// using sheet object we get row number and and in this row it will get how many cells are there using get lat cell number methods
	
	 data = new Object[rowcount-1][cellcount];
	
	for(int i = 1; i<rowcount; i++)
	{
		XSSFRow row = sheet.getRow(i);
	
		for(int j=0; j<cellcount; j++)
		{
			XSSFCell cell = row.getCell(j);
			 data[i - 1][j] = getCellValueAsString(cell);
			System.out.println(data + " | ");
		}
	}
	
	workbook.close();
	fis.close();
	
	
	}catch(IOException e)
	{
		e.printStackTrace();
		 
	}
	
	 return data;
	
	}
	
	 private static String getCellValueAsString(Cell cell) {
	        if (cell == null) {
	            return "";
	        }
	        switch (cell.getCellType()) {
	            case STRING:
	                return cell.getStringCellValue();
	            case NUMERIC:
	                if (DateUtil.isCellDateFormatted(cell)) {
	                    return cell.getDateCellValue().toString();
	                } else {
	                    return String.valueOf((long) cell.getNumericCellValue());
	                }
	            case BOOLEAN:
	                return String.valueOf(cell.getBooleanCellValue());
	            case BLANK:
	                return "";
	            default:
	                return "";
	        }
	    }
	}

/*
 * "We create new Object[rowCount-1][colCount] to store all data rows (excluding the 
 * header) and all columns from the Excel sheet. Since Excel can contain different 
 * types of data, we use Object[][] array. This array is then used to supply
 *  multiple sets of test data for data-driven testing with TestNG's @DataProvider 
 *  feature."
 *  */
