package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries_Utility.WebDriverUtils;

public class CreatingNewContactPage extends WebDriverUtils {

	// declaration
	@FindBy(name = "lastname")
	private WebElement LastName;

	@FindBy(xpath = "//input[@name='account_id']/following-sibling::img[@src='themes/softed/images/select.gif']")
	private WebElement OrganizationNamelookupImage;

	@FindBy(id = "search_txt")
	private WebElement SearchBox;

	@FindBy(name = "search")
	private WebElement SearchNow;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveButton;

	// initialization
	public CreatingNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization
	public WebElement getLastName() {
		return LastName;
	}

	public WebElement getOrganizationNamelookupImage() {
		return OrganizationNamelookupImage;
	}

	public WebElement getSearchBox() {
		return SearchBox;
	}

	public WebElement getSearchNow() {
		return SearchNow;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}

	// business logic

	public void CreateNewContactPage(String lastname) {
		LastName.sendKeys(lastname);
		SaveButton.click();

	}

	public void CreateNewContactPage(String lastname, String org, WebDriver driver) {
		LastName.sendKeys(lastname);
		OrganizationNamelookupImage.click();
		switchToWindow(driver, "Accounts&action");
		SearchBox.sendKeys(org);
		SearchNow.click();
		driver.findElement(By.xpath("//a[text()='" + org + "']")).click();
		switchToWindow(driver, "Contacts&action=");
		SaveButton.click();
	}

}
