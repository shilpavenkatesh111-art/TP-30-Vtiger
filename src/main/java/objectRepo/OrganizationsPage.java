package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	//declaration
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement lookupimage;
	
	//initialization
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getLookupimage() {
		return lookupimage;
	}
	
	//business logic
	public void ClickOnOrganizationLookupImage() {
		lookupimage.click();
	}
	
}
