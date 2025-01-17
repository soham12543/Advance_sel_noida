package externalResources;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class WritingDataIntoExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
	  FileInputStream file=new FileInputStream("C:\\Users\\Asus\\git\\Advance_selenium\\advanced_selenium_a30\\src\\test\\resources\\ExcelFile.xlsx");
      Workbook wb= WorkbookFactory.create(file);
      Sheet sh=wb.getSheet("contact");
      Row row=sh.getRow(1);
      Cell cell=row.createCell(3);
      
      
      cell.setCellType(CellType.STRING);
      cell.setCellValue("PASS");
      
      FileOutputStream fos=new FileOutputStream("C:\\Users\\Asus\\git\\Advance_selenium\\advanced_selenium_a30\\src\\test\\resources\\ExcelFile.xlsx");
      wb.write(fos);
      System.out.println("Data Entered Successfully");
      wb.close();
      
	}

}
