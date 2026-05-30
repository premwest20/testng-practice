package fullPracticeMay;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtil  {
	
	public void readExcel() throws IOException{
	
	FileInputStream fs = new FileInputStream("C:\\Users\\premw\\eclipse-workspace\\testng-framework\\src\\TestData.xlsx");
	XSSFWorkbook wb = new XSSFWorkbook(fs);
	XSSFSheet sheet = wb.getSheet("Sheet1");
	
	XSSFRow row = sheet.getRow(0);
	XSSFCell cell = row.getCell(0);
	
	System.out.println(cell.getStringCellValue());
	
	wb.close();
	}

}
