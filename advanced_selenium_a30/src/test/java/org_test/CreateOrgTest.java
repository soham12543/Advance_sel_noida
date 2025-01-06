package org_test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import generic_Utility.FileUtility;
import generic_Utility.WebDriverUtility;

public class CreateOrgTest {

	public static void main(String[] args) throws IOException {
		

		/*WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));*/
		
		/*FileInputStream fis = new FileInputStream("C:\\Users\\Asus\\eclipse-workspace\\TestNG Workspace\\advanced_selenium_a30\\src\\main\\resources\\commonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
	
		String URL = pObj.getProperty("url");
		String BRO = pObj.getProperty("bro");
		String UN = pObj.getProperty("un");
		String PWD = pObj.getProperty("pwd");*/
		
		FileUtility file=new FileUtility();
		String URL = file.getDataFromPropertiesFile("url");
		String BRO = file.getDataFromPropertiesFile("bro");
		String UN = file.getDataFromPropertiesFile("un");
		String PWD = file.getDataFromPropertiesFile("pwd");
		
		
		
		//Generate random number
		/*Random random=new Random();
		int rn=random.nextInt(1000);
		System.out.println(rn);*/


		//Get ORG name by reading testscript data from excel file
		
		/*FileInputStream file1=new FileInputStream("C:\\Users\\Asus\\eclipse-workspace\\TestNG Workspace\\advanced_selenium_a30\\src\\test\\resources\\ExcelFile.xlsx");
		Workbook wb=WorkbookFactory.create(file1);
		Sheet sh=wb.getSheet("org");
		Row row=sh.getRow(1);
		Cell cell=row.getCell(0);
		String ORG=cell.toString()+rn;
		file1.close();*/
		
		String ORG=file.getDataFromExcelFile("org", 1, 0);
		
		WebDriver driver = null;

		if (BRO.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BRO.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BRO.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		
		WebDriverUtility wdlib=new WebDriverUtility(driver);
		wdlib.maximize(driver);
		wdlib.waitForElement(driver);
		

		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(ORG);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actOrgName = driver.findElement(By.className("dvHeaderText")).getText();
		System.out.println(actOrgName);
		if (actOrgName.contains(ORG)) {
			System.out.println("Verified!!!");
		}	
		driver.close();
	}
}
