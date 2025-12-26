package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries_Utility.WebDriverUtils;

public class LoginPage{

	//declaration
	@FindBy(name = "user_name")
	private WebElement username;
	
	@FindBy(xpath = "//input[@name='user_password']")
	private WebElement password;
	
	@FindBy(id = "submitButton")
	private WebElement loginbutton;
	
	//initialization
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	
	//utilization
	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}
	
	//business Logic
	
	public void loginPage(String Username, String Password) throws InterruptedException {
		//waitUntilEleToBeVisible(driver,10, username);
		username.sendKeys(Username);
		password.sendKeys(Password);
		Thread.sleep(1000);
		loginbutton.click();
	}
}
