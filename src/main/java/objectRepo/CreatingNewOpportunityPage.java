package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries_Utility.WebDriverUtils;

public class CreatingNewOpportunityPage extends WebDriverUtils{

	@FindBy(name = "potentialname")
	private WebElement OpportunityName;
	
	@FindBy(xpath = "//input[@id='related_to_display']/following-sibling::img")
	private WebElement Organizationlookup;
	
	@FindBy(id = "search_txt")
	private WebElement SearchBox;
	
	@FindBy(name = "search")
	private WebElement SearchNow;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveButton;
	
	//initialization
	public CreatingNewOpportunityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	//utilization
	public WebElement getOpportunityName() {
		return OpportunityName;
	}

	public WebElement getOrganizationlookup() {
		return Organizationlookup;
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
	
	//business logic
	public void CreateNewOpportunityPage(String optname, WebDriver driver, String orgname) throws InterruptedException {
		OpportunityName.sendKeys(optname);
		Organizationlookup.click();
		switchToWindow(driver, "Accounts&action");
		SearchBox.sendKeys(orgname);
		SearchNow.click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		Thread.sleep(2000);
		switchToWindow(driver, "Potentials&action");
		SaveButton.click();
		
		
	}
	
	
}
