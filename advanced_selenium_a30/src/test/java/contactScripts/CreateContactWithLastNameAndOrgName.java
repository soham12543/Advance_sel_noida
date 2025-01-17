package contactScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic_Utility.FileUtility;
import objectRepo.CreateContactClass;
import objectRepo.CreateOrganizationPage;
import objectRepo.LoginPage;

public class CreateContactWithLastNameAndOrgName {

	public static void main(String[] args) throws IOException, AWTException, FileNotFoundException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Step1) Load the Properties File
		/*FileInputStream file = new FileInputStream(
		"C:\\Users\\Asus\\eclipse-workspace\\TestNG Workspace\\advanced_selenium_a30\\src\\main\\resources\\commonData.properties");
		Properties oBJ = new Properties();
		oBJ.load(file);
	

		// Step2) Get all the values
		String URL = oBJ.getProperty("url");
		String BRO = oBJ.getProperty("bro");
		String UN = oBJ.getProperty("un");
		String PASS = oBJ.getProperty("pwd");*/
		
		FileUtility file=new FileUtility();
		String URL=file.getDataFromPropertiesFile("url");
		String BRO=file.getDataFromPropertiesFile("bro");
		String UN=file.getDataFromPropertiesFile("un");
		String PASS=file.getDataFromPropertiesFile("pwd");

		
        //Get ORG name by reading testscript data from excel file
		
		/*FileInputStream file1=new FileInputStream("C:\\Users\\Asus\\eclipse-workspace\\TestNG Workspace\\advanced_selenium_a30\\src\\test\\resources\\ExcelFile.xlsx");
		Workbook wb=WorkbookFactory.create(file1);
		Sheet sh=wb.getSheet("org");
		Row row=sh.getRow(1);
		Cell cell=row.getCell(0);
		String ORG=cell.toString()+rn;
		file1.close();*/
		
		
		
		//GET LAST name by reading testscript data from excel file
		/*FileInputStream file2=new FileInputStream("C:\\Users\\Asus\\eclipse-workspace\\TestNG Workspace\\advanced_selenium_a30\\src\\test\\resources\\ExcelFile.xlsx");
		Workbook wb1=WorkbookFactory.create(file2);
		Sheet sh1=wb.getSheet("contact");
		Row row1=sh1.getRow(1);
		String LN=row1.getCell(2).toString()+rn;
		file2.close();*/
		
		String ORG=file.getDataFromExcelFile("org", 1, 0);
		String LN=file.getDataFromExcelFile("contact", 1, 2);
		

		LoginPage lp=new LoginPage(driver);
		CreateContactClass cp=new CreateContactClass(driver);
		CreateOrganizationPage op=new CreateOrganizationPage(driver);
		
		
		driver.get(URL);
		
		// Step3) Login with Username and Password
		/*mywait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user_name"))).sendKeys(UN);
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user_password"))).sendKeys(PASS);
		mywait.until(ExpectedConditions.elementToBeClickable(By.id("submitButton"))).click();*/

		lp.getUsername().sendKeys(UN);
		lp.getPassword().sendKeys(PASS);
		lp.getSubmitButton().click();
		
		
		//Create an Organiztion
		
		op.getOrganizationsButton().click();
		op.getCreateOrgButton().click();
		op.getOrgNameField().sendKeys(ORG);
		op.getSaveButton().click();

		
		// Step4) Click on Contacts-->Select the add button
		/*mywait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='tabUnSelected']//a[text()='Contacts']")))
				.click();
		mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@title='Create Contact...']"))).click();*/

//		explicit wait
		cp.getContactsButton().click();
		cp.getCreateContactButton().click();
	

		// Step5) Enter the Last Name-->Enter ORG NAME--->Click on Save button

		/*mywait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastname"))).sendKeys(LN);
//		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.name("account_name"))).sendKeys(ORG);*/
	
		
		cp.getLastNameField().sendKeys(LN);
		String parentID = driver.getWindowHandle();

		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@title='Select'])[1]"))).click();

		Set<String> IDs = driver.getWindowHandles();
		IDs.remove(parentID);

		for (String id : IDs) {
			driver.switchTo().window(id);
			if (driver.getCurrentUrl().contains("module=Accounts&action"))
			{
			   driver.findElement(By.id("search_txt")).sendKeys(ORG);
		       driver.findElement(By.name("search")).click();
		       driver.findElement(By.linkText(ORG)).click();
				break;
			}
		}
		driver.findElement(By.id("search_txt")).sendKeys(ORG);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(ORG)).click();

		driver.switchTo().window(parentID);
	}
}
