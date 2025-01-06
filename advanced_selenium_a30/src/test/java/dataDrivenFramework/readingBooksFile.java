package dataDrivenFramework;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readingBooksFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Asus\\eclipse-workspace\\TestNG Workspace\\advanced_selenium_a30\\src\\test\\resources\\BooksFile.xlsx");
        Workbook wb=WorkbookFactory.create(file);
        Sheet sh=wb.getSheet("Sheet1");
        int numrows=sh.getLastRowNum();
        int colrows=sh.getRow(1).getLastCellNum();
        System.out.println(numrows);//rows are counted from 0
        System.out.println(colrows);//cells are counted from 1
        for(int i=0;i<=numrows;i++)
        {
        	Row currentrow=sh.getRow(i);
        	for(int j=0;j<colrows;j++)
        	{
        		Cell c=currentrow.getCell(j);
        		System.out.print(c.toString()+"             ");
        	}
        	System.out.println();
        }
        
        		
	}

}
