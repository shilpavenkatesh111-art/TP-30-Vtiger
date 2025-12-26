package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {
	//declaration
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement lookupimage;
	
	//initialization
	public OpportunitiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getLookupimage() {
		return lookupimage;
	}
	
	//business logic
	public void ClickOnOpportunitiesLookupImage() {
		lookupimage.click();
	}
	
}
