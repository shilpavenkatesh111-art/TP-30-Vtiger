package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries_Utility.WebDriverUtils;

public class CreateOrganizationPage extends WebDriverUtils{
	
	//declaration
	@FindBy(name = "accountname")
	private WebElement OrganizationName;

	
	@FindBy(name = "industry")
	private WebElement industry;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	
	//initialization
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOrganizationName() {
		return OrganizationName;
	}

	public WebElement getIndustry() {
		return industry;
	}
	
	public WebElement getSavebutton() {
		return savebutton;
	}
	
	//Business logic
	public void CreatingNewOrganization(String orgname) {
		OrganizationName.sendKeys(orgname);
		savebutton.click();

	}
		
	public void CreatingNewOrganization(String orgname, String Indd) {
		OrganizationName.sendKeys(orgname);
		dropdownUsingContainsVisibleText(industry, Indd);
		savebutton.click();
		
		
	}
	
}
