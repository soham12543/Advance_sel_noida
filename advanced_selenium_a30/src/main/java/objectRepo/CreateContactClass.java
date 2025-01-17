package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactClass {
	WebDriver driver ;
	
	public CreateContactClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[text()='Contacts'])[1]")
	private WebElement contactsButton;

	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContactButton;

	@FindBy(name = "lastname")
	private WebElement lastNameField;

	@FindBy(name = "mobile")
	private WebElement mobileTextField;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	@FindBy(id = "dtlview_Mobile")
	private WebElement actMobileNo;

	@FindBy(id = "dtlview_Last Name")
	private WebElement actLastName;

	@FindBy(xpath = "//img[@id='jscal_trigger_support_start_date']")
	private WebElement supportStartDate;

	@FindBy(name = "support_start_date")
	private WebElement supportStartDateField;

	@FindBy(name = "support_end_date")
	private WebElement supportEndDateField;

	public WebElement getSupportEndDateField() {
		return supportEndDateField;
	}

	public WebElement getSupportStartDateField() {
		return supportStartDateField;
	}

	public WebElement getSupportStartDateButton() {
		return supportStartDate;
	}

	public WebElement getActLastName() {
		return actLastName;
	}

	public WebElement getActMobileNo() {
		return actMobileNo;
	}

	public WebElement getContactsButton() {
		return contactsButton;
	}

	public WebElement getCreateContactButton() {
		return createContactButton;
	}

	public WebElement getLastNameField() {
		return lastNameField;
	}

	public WebElement getMobileTextField() {
		return mobileTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

}
