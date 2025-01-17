package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{

	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="user_name")
	private WebElement username;
	
	@FindBy(name="user_password")
	private WebElement password;
	
	@FindBy(id="submitButton")
	private WebElement submitButton;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
		
}
