package generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility 
{

	public String getDataFromPropertiesFile(String key) throws IOException
	{
		FileInputStream file = new FileInputStream(
				"C:\\Users\\Asus\\git\\Advance_selenium\\advanced_selenium_a30\\src\\main\\resources\\commonData.properties");
		Properties oBJ = new Properties();
		oBJ.load(file);
		return oBJ.getProperty(key);
	}
	
	public String getDataFromExcelFile(String sheet, int rowNum, int cellNum) throws IOException {
		FileInputStream file1=new FileInputStream("C:\\Users\\Asus\\git\\Advance_selenium\\advanced_selenium_a30\\src\\test\\resources\\ExcelFile.xlsx");
		Workbook wb = WorkbookFactory.create(file1);
		Sheet sh = wb.getSheet(sheet);
		Row row = sh.getRow(rowNum);
		String data="";
		int random = JavaUtility.generateRandomNumer();
		data = row.getCell(cellNum).getStringCellValue() + random;
		return data;
    }
	
	public String getDataFromExcelFileWithoutRandomNo(String sheet, int rowNum, int cellNum) throws IOException {
		FileInputStream file1=new FileInputStream("C:\\Users\\Asus\\git\\Advance_selenium\\advanced_selenium_a30\\src\\test\\resources\\ExcelFile.xlsx");
		Workbook wb = WorkbookFactory.create(file1);
		Sheet sh = wb.getSheet(sheet);
		Row row = sh.getRow(rowNum);
		String data=row.getCell(cellNum).getStringCellValue();
		return data;
    }
}
