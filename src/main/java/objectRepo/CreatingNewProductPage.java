package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries_Utility.WebDriverUtils;

public class CreatingNewProductPage extends WebDriverUtils{

	//declaration
	@FindBy(name = "productname")
	private WebElement ProductName;

	@FindBy(id = "jscal_field_sales_start_date")
	private WebElement SalesStartDate;

	@FindBy(name = "productcategory")
	private WebElement ProductCategory;
	
	@FindBy(id = "jscal_field_sales_end_date")
	private WebElement SalesEndDate;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveButton;
	
	//initialization
	public CreatingNewProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	//utilization	
	public WebElement getProductName() {
		return ProductName;
	}

	public WebElement getSalesStartDate() {
		return SalesStartDate;
	}

	public WebElement getProductCategory() {
		return ProductCategory;
	}

	public WebElement getSalesEndDate() {
		return SalesEndDate;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}
	
	//business logic
	public void CreateNewProductPage(String Pname) {
		ProductName.sendKeys(Pname);
		SaveButton.click();	
	}
	
	public void CreateNewProductPage(String Pname, String startdate, WebDriver driver, String product, String enddate){
		ProductName.sendKeys(Pname);
		SalesStartDate.sendKeys(startdate);
		scrollWebPage(driver, 0, 200);
        dropdownUsingVisibleText(ProductCategory, product);
		SalesEndDate.sendKeys(enddate);
		SaveButton.click();	
	}
	
	
}