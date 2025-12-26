package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import genericLibraries_Utility.WebDriverUtils;

public class OrganizationValidatePage{

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement validate;
	
	public WebElement getValidate() {
		return validate;
	}	
	
	public OrganizationValidatePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void validation(String org, WebDriver driver) {
		WebDriverUtils wb=new WebDriverUtils();
		String actual=validate.getText();
		wb.waitUntilEleToBeVisible(driver, 10, validate);
		Assert.assertTrue(actual.contains(org));
//		if(actual.contains(org)) {
//			System.out.println("organization created successfully");
//		}
//		else {
//			System.out.println("organization not created");
//		}
	}


	
}
