
package org_test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic_Utility.WebDriverUtility;

public class Rough {

	public static void main(String[] args) throws IOException 
	{
		WebDriver driver=new ChromeDriver();
		WebDriverUtility wdlib=new WebDriverUtility(driver);
		driver.get("https://the-internet.herokuapp.com");
		wdlib.maximize(driver);
		wdlib.waitForElement(driver);
		//driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		WebElement button=driver.findElement(By.xpath("//a[text()='WYSIWYG Editor']"));
		wdlib.toScrollWindow(button);
		
		String path="C:\\Users\\Asus\\git\\Advance_selenium\\advanced_selenium_a30\\src\\main\\resources\\NewFile.properties";
	    FileOutputStream fos=new FileOutputStream("C:\\Users\\Asus\\git\\Advance_selenium\\advanced_selenium_a30\\src\\main\\resources\\NewFile.properties");
	    Properties oBJ=new Properties();
	    oBJ.setProperty("browser", "chrome");
	    oBJ.store(fos,"Added");
	    
		
		
		
		
	}

}
