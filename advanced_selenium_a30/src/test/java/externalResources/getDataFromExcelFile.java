package externalResources;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class getDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
	  //Step1) Get the representation object of the physical file
		FileInputStream fis=new FileInputStream("C:\\Users\\Asus\\eclipse-workspace\\TestNG Workspace\\advanced_selenium_a30\\src\\test\\resources\\ExcelFile.xlsx");
		
		//Step2) By using create() method of WorkBook factory, open the workbook in read mode
		Workbook wb=WorkbookFactory.create(fis);
		
		//Step3) By using getSheet(), Get control of sheet
		Sheet sh=wb.getSheet("org");
		
		//Step4) By using getRow() get control of row
		Row row=sh.getRow(1);
		
		//Step5) By using getCell() get control of cell
		Cell cell=row.getCell(0);
		
		//Step6) By using getStringCellValue() fetch the value of the cell
		
		String orgname=cell.getStringCellValue();
		System.out.println(orgname);
		

	}

}
