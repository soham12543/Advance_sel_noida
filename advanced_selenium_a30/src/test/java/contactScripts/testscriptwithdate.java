package contactScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testscriptwithdate {

	public static void main(String[] args) throws IOException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		FileInputStream file=new FileInputStream("C:\\Users\\Asus\\eclipse-workspace\\TestNG Workspace\\advanced_selenium_a30\\src\\main\\resources\\commonData.properties");
		Properties oBJ=new Properties();
		oBJ.load(file);
		String URL=oBJ.getProperty("url");
		String UN=oBJ.getProperty("un");
		String PASS=oBJ.getProperty("pwd");
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PASS);
		driver.findElement(By.id("submitButton")).click();
		
		
		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		driver.findElement(By.xpath("//img[@id='jscal_trigger_support_start_date']")).click();
		
		
	}

}
