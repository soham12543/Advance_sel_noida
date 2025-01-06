package generic_Utility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverUtility {
	
	WebDriver driver;
	WebDriverWait wait;
	Actions act;
	
	
	public WebDriverUtility(WebDriver driver){
	    this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.act = new Actions(driver);
	}
	
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void waitForElement(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void minimize(WebDriver driver) {
		driver.manage().window().minimize();
	}
	public void handleDropDown(int index, WebElement element)
	{
		Select dropdown=new Select(element);
		dropdown.selectByIndex(index);
	}
	public void handleDropDown(String value, WebElement element)
	{
		Select dropdown=new Select(element);
		dropdown.selectByValue(value);
	}
	public void handleDropDown(WebElement element, String visibleText)
	{
		Select dropdown=new Select(element);
		dropdown.selectByVisibleText(visibleText);
	}
	public void doubleClick(WebElement element)
	{
	   act.doubleClick(element).perform();
	}
	public void rightClick(WebElement element)
	{
	   act.contextClick(element).perform();
	}
	public void dragAndDrop(WebElement src, WebElement dest)
	{
	   act.dragAndDrop(src, dest).perform();
	}
	public void clickAndHold(WebElement element)
	{
	   act.clickAndHold(element).perform();
	}
	public void mouseHover(WebElement element)
	{
		act.moveToElement(element).perform();
	}
	public void toHandleFrame(int id)
	{
		driver.switchTo().frame(id);
	}
	public void toHandleFrame(String name)
	{
		driver.switchTo().frame(name);
	}
	public void toHandleFrame(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	public void toSwitchToImmiParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	public void toSwitchToDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	public void toSwitchToAlert()
	{
		driver.switchTo().alert();
	}
	public void toSwitchToAlertandAccept()
	{
	    Alert myalert=driver.switchTo().alert();
	    myalert.accept();
	}
	public void toSwitchToAlertandDismiss()
	{
		  Alert myalert=driver.switchTo().alert();
		  myalert.dismiss();
	}
	public void toSwitchToWindow(String partialTitle)
	{
		Set<String> windowIDs=driver.getWindowHandles();
		for(String x:windowIDs)
		{
			driver.switchTo().window(x);
			if(driver.getTitle().contains(partialTitle))
				break;		
		}
	}
	public void toScrollWindow(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
