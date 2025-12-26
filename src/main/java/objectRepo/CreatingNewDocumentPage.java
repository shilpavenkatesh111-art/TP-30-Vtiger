package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries_Utility.WebDriverUtils;

public class CreatingNewDocumentPage extends WebDriverUtils{

	//declaration
	@FindBy(name = "notes_title")
	private WebElement Title;
	
	@FindBy(xpath = "//iframe[@title='Rich text editor, notecontent, press ALT 0 for help.']")
	private WebElement frame;
	
	@FindBy(xpath = "//body[@class='cke_show_borders']")
	private WebElement Description;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveButton;	
	
	
	//initialization
	public CreatingNewDocumentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	//utilization
	public WebElement getTitle() {
		return Title;
	}

	public WebElement getDescription() {
		return Description;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}
	
	//business logic
	public void CreateNewDocumentPage(String title, WebDriver driver) {
		Title.sendKeys(title);
		switchToChildFrame(driver, frame);
		Description.sendKeys("Providing the necessary details about the company");
		switchToMainFrame(driver);
		SaveButton.click();
		
		
	}
}
