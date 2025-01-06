package org_test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic_Utility.FileUtility;
import generic_Utility.WebDriverUtility;

public class CreateOrgandIndustryTest {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		/*WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		
		//Step1) Load the Properties File
		FileInputStream file=new FileInputStream("C:\\Users\\Asus\\eclipse-workspace\\TestNG Workspace\\advanced_selenium_a30\\src\\main\\resources\\commonData.properties");
		Properties oBJ=new Properties();
		oBJ.load(file);
		
		//Step2) Get all the values
		
		String URL=oBJ.getProperty("url");
		String BRO=oBJ.getProperty("bro");
		String UN=oBJ.getProperty("un");
		String PASS=oBJ.getProperty("pwd");
		int ran=(int)(Math.random()*999);
		String ORG=oBJ.getProperty("org")+ran;
		
		/*oBJ.setProperty("industry","Biotechnology");
		FileOutputStream fos=new FileOutputStream("C:\\Users\\Asus\\eclipse-workspace\\TestNG Workspace\\advanced_selenium_a30\\src\\main\\resources\\commonData.properties");
		oBJ.store(fos, "Added industry to property file");
		String IND=oBJ.getProperty("industry");*/		

		FileUtility file=new FileUtility();
		String URL=file.getDataFromPropertiesFile("url");
		String BRO=file.getDataFromPropertiesFile("bro");
		String UN=file.getDataFromPropertiesFile("un");
		String PASS=file.getDataFromPropertiesFile("pwd");
		String PHNO=file.getDataFromPropertiesFile("phone");
		String IND=file.getDataFromPropertiesFile("industry");
		
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
					
		
		//Step3) Login with Username and Password
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PASS);
		driver.findElement(By.id("submitButton")).click();


		//Step4) Click on Origanizations-->Select the add button
		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		
		//Step5) Enter the organization name-->Select the given industry from dopdown--->Click on Save button
		driver.findElement(By.name("accountname")).sendKeys(ORG);
		WebElement element=driver.findElement(By.name("industry"));
		/*Select dropdown=new Select(element);
		dropdown.selectByValue(IND);*/
		
		wdlib.handleDropDown(IND, element);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step6) Verify the entered Organization and selected industry
		
		String actOrgName=driver.findElement(By.id("dtlview_Organization Name")).getText();
		String actIndustryName=driver.findElement(By.id("dtlview_Industry")).getText();
		System.out.println("Selected Organization Name: "+actOrgName);
		System.out.println("Selected Industry Name: "+actIndustryName);
		if(actOrgName.contains(ORG))
			System.out.println("Organization Name Verified!!");
		if(actIndustryName.contains(IND))
			System.out.println("Industry Name Verifiied!!");
	
	}

}

