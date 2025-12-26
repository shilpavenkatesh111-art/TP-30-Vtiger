package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

	//declaration
	@FindBy (xpath = "//img[@title='Create Product...']")
	private WebElement lookupimage;
	
	//initialization
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getLookupimage() {
		return lookupimage;
	}
	
	//business logic
	public void ClickOnProductsLookupImage() {
		lookupimage.click();
	}
}
