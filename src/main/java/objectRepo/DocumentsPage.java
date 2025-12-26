package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentsPage {

	//declaration
	@FindBy(xpath = "//img[@title='Create Document...']")
	private WebElement lookupimage;
	
	//initialization
	public DocumentsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getLookupimage() {
		return lookupimage;
	}
	
	//business logic
	public void ClickOnDocumentLookupImage() {
		lookupimage.click();
		}
	
}
