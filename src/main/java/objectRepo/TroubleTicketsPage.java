package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTicketsPage {

	//declaration
	@FindBy(xpath = "//img[@title='Create Ticket...']")
	private WebElement lookupimage;
	
	//initialization
	public TroubleTicketsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getLookupimage() {
		return lookupimage;
	}
	//business logic
	public void ClickOnTroubleTicketsLookupImage() {
		lookupimage.click();
	}
}
