
package org_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic_Utility.WebDriverUtility;

public class Rough {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		WebDriverUtility wdlib=new WebDriverUtility(driver);
		driver.get("https://the-internet.herokuapp.com");
		wdlib.maximize(driver);
		wdlib.waitForElement(driver);
		//driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		WebElement button=driver.findElement(By.xpath("//a[text()='WYSIWYG Editor']"));
		wdlib.toScrollWindow(button);
		
		
		
		
	}

}
