package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage 
{
	
	public LogoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
  @FindBy(xpath="(//img[@style='padding: 0px;padding-left:5px'])[1]")
  private WebElement signOutIcon;
  
  @FindBy(xpath="//a[normalize-space()='Sign Out']")
  private WebElement signOutButton;

public WebElement getSignOutIcon() {
	return signOutIcon;
}

public WebElement getSignOutButton() {
	return signOutButton;
}



  
}
