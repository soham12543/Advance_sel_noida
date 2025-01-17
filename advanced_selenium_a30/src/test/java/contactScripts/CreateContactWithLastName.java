package contactScripts;

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
import objectRepo.CreateContactClass;
import objectRepo.LoginPage;

public class CreateContactWithLastName {

	public static void main(String[] args) throws IOException 
	{
		/*WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));*/
		
		
		/*FileInputStream file=new FileInputStream("C:\\Users\\Asus\\eclipse-workspace\\TestNG Workspace\\advanced_selenium_a30\\src\\main\\resources\\commonData.properties");
		Properties oBJ=new Properties();
		oBJ.load(file);

		String URL=oBJ.getProperty("url");
		String BRO=oBJ.getProperty("bro");
		String UN=oBJ.getProperty("un");
		String PASS=oBJ.getProperty("pwd");
		String LN=oBJ.getProperty("lastNAME");
		String PHNO=oBJ.getProperty("phone");*/
		
		
		//Step1) Load commonData through properties file
		
		FileUtility file=new FileUtility();
		String URL=file.getDataFromPropertiesFile("url");
		String BRO=file.getDataFromPropertiesFile("bro");
		String UN=file.getDataFromPropertiesFile("un");
		String PASS=file.getDataFromPropertiesFile("pwd");
		String PHNO=file.getDataFromPropertiesFile("phone");
		
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
		/*driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PASS);
		driver.findElement(By.id("submitButton")).click();*/
		
		
		//Step7) Login to the Vtiger website
		lp.getUsername().sendKeys(UN);
		lp.getPassword().sendKeys(PASS);
		lp.getSubmitButton().click();
		
	
		/*driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();*/
		
		
		//Step8) Click ob Contacts--->Create Contact
		cp.getContactsButton().click();
		cp.getCreateContactButton().click();
	
		
		
		
		/*driver.findElement(By.name("lastname")).sendKeys(LN);
		driver.findElement(By.name("mobile")).sendKeys(PHNO);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();*/
		
		
		//Step9) Enter the Last Name-->Enter mobile no--->Click on Save button
		cp.getLastNameField().sendKeys(LN);
		cp.getMobileTextField().sendKeys(PHNO);
		cp.getSaveButton().click();

		
		
		/*String actMobileNo=driver.findElement(By.id("dtlview_Mobile")).getText();
		String actLastName=driver.findElement(By.id("dtlview_Last Name")).getText();
		System.out.println("Entered LastName:"+actLastName);
		System.out.println("Entered Mobile Number:"+actMobileNo);
		if(actMobileNo.contains(PHNO))
			System.out.println("Mobile number verified!!");
		if(actLastName.contains(LN))
			System.out.println("Last name verified!!");	*/
		
		//Step6) Verify the entered Last name and mobile no entered.
		
		String actMobileNo=cp.getActMobileNo().getText();
		String actLastName=cp.getActLastName().getText();
		System.out.println("Entered LastName:"+actLastName);
		System.out.println("Entered Mobile Number:"+actMobileNo);
		if(actMobileNo.contains(PHNO))
			System.out.println("Mobile number verified!!");
		if(actLastName.contains(LN))
			System.out.println("Last name verified!!");
		
		
	}

}
