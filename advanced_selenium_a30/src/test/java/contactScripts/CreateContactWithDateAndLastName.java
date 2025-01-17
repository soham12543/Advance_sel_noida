package contactScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic_Utility.FileUtility;
import generic_Utility.JavaUtility;
import generic_Utility.WebDriverUtility;
import objectRepo.CreateContactClass;
import objectRepo.LoginPage;

public class CreateContactWithDateAndLastName {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		
		//Step1) Load commonData through properties file
		
		FileUtility file=new FileUtility();
		String URL=file.getDataFromPropertiesFile("url");
		String BRO=file.getDataFromPropertiesFile("bro");
		String UN=file.getDataFromPropertiesFile("un");
		String PASS=file.getDataFromPropertiesFile("pwd");
		
		
		//Step2) Load test script data fromm excel file
        String LN=file.getDataFromExcelFile("contact", 1, 2);
		
        
        //Step3) Launch the browser according to properties file
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
		
		//Step4) Use WebDriver utility object to access the WebDriver methods
		
		WebDriverUtility wdlib=new WebDriverUtility(driver);
		wdlib.maximize(driver);
		wdlib.waitForElement(driver);
		
		
		//Step5) Use POM classes of LoginPage and ContactPage to get the required locators
		LoginPage lp=new LoginPage(driver);
		CreateContactClass cp=new CreateContactClass(driver);
		
		
		//Step6) Launch the browser
		driver.get(URL);
		
		
		//Step7) Login to the Vtiger website
		lp.getUsername().sendKeys(UN);
		lp.getPassword().sendKeys(PASS);
		lp.getSubmitButton().click();
		
		//Step8) Click ob Contacts--->Create Contact
		cp.getContactsButton().click();
		cp.getCreateContactButton().click();
		
		//Step9) Enter LastName and scroll towards the date section
		Thread.sleep(2000);
		cp.getLastNameField().sendKeys(LN);
		Thread.sleep(2000);
		WebElement supportStartDateButton=cp.getSupportStartDateButton();
		wdlib.toScrollWindow(supportStartDateButton);
		
		//Step10) Get the current date and added new date from JavaUtility Class methods
		JavaUtility ju=new JavaUtility();
		String currentDate=ju.currentdate();
		String newAddedDate=ju.newAddedDate(30); //date after added 30 days
		
		//Step11) Send the current date and added new date to the respective fields and save the contact info
		Thread.sleep(2000);
		cp.getSupportStartDateField().clear();
		cp.getSupportStartDateField().sendKeys(currentDate);
		Thread.sleep(2000);
		cp.getSupportEndDateField().clear();
		cp.getSupportEndDateField().sendKeys(newAddedDate);
		Thread.sleep(2000);
		cp.getSaveButton().click();
		

		
	}

}
