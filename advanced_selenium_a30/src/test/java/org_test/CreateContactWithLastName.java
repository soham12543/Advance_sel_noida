package org_test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic_Utility.FileUtility;
import generic_Utility.WebDriverUtility;

public class CreateContactWithLastName {

	public static void main(String[] args) throws IOException 
	{
		/*WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));*/
		
		
		
		
		//Step1) Load the Properties File
		/*FileInputStream file=new FileInputStream("C:\\Users\\Asus\\eclipse-workspace\\TestNG Workspace\\advanced_selenium_a30\\src\\main\\resources\\commonData.properties");
		Properties oBJ=new Properties();
		oBJ.load(file);

		//Step2) Get all the values
		String URL=oBJ.getProperty("url");
		String BRO=oBJ.getProperty("bro");
		String UN=oBJ.getProperty("un");
		String PASS=oBJ.getProperty("pwd");
		String LN=oBJ.getProperty("lastNAME");
		String PHNO=oBJ.getProperty("phone");*/
		
		FileUtility file=new FileUtility();
		String URL=file.getDataFromPropertiesFile("url");
		String BRO=file.getDataFromPropertiesFile("bro");
		String UN=file.getDataFromPropertiesFile("un");
		String PASS=file.getDataFromPropertiesFile("pwd");
		String PHNO=file.getDataFromPropertiesFile("phone");
		
		
		String LN=file.getDataFromExcelFile("contact", 1, 2);
		
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
		
		
		//Step4) Click on Contacts-->Select the add button
		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//Step5) Enter the Last Name-->Enter mobile no--->Click on Save button
		
		driver.findElement(By.name("lastname")).sendKeys(LN);
		driver.findElement(By.name("mobile")).sendKeys(PHNO);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//Step6) Verify the entered Last name and mobile no entered.
		
		String actMobileNo=driver.findElement(By.id("dtlview_Mobile")).getText();
		String actLastName=driver.findElement(By.id("dtlview_Last Name")).getText();
		System.out.println("Entered LastName:"+actLastName);
		System.out.println("Entered Mobile Number:"+actMobileNo);
		if(actMobileNo.contains(PHNO))
			System.out.println("Mobile number verified!!");
		if(actLastName.contains(LN))
			System.out.println("Last name verified!!");	
		
	}

}
