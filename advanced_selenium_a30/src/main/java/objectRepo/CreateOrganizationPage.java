package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage 
{

	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindAll({@FindBy(xpath="(//a[text()='Organizations'])[1]"),@FindBy(linkText="Organizations")})
	private WebElement organizationsButton;
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrgButton;
	
	@FindBy(name="accountname")
	private WebElement orgNameField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(className="dvHeaderText")
	private WebElement actOrgName;
	
	@FindBy(name="industry")
	private WebElement industry;
	
	@FindBy(id="phone")
	private WebElement phone;
	
	@FindBy(id="dtlview_Industry")
	private WebElement getActIndustry;
	
	@FindBy(id="dtlview_Phone")
	private WebElement actPhoneNo;
	
	public WebElement getActPhoneNo()
	{
		return actPhoneNo;
	}
	
	
	public WebElement getPhoneNo()
	{
		return phone;
	}
	public WebElement getActIndustryName()
	{
		return getActIndustry;
	}
	
	public WebElement getIndustry()
	{
		return industry;
	}
	
	public WebElement getActOrgName()
	{
		return actOrgName;
	}

	public WebElement getOrganizationsButton() {
		return organizationsButton;
	}

	public WebElement getCreateOrgButton() {
		return createOrgButton;
	}

	public WebElement getOrgNameField() {
		return orgNameField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}	
	
}
