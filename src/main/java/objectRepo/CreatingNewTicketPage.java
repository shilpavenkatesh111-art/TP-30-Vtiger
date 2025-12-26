package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries_Utility.WebDriverUtils;

public class CreatingNewTicketPage extends WebDriverUtils{
	
	//declaration
	@FindBy(name = "ticket_title")
	private WebElement Title;
	
	@FindBy(name = "ticketpriorities")
	private WebElement Priority;
	
	@FindBy(name = "ticketseverities")
	private WebElement	Severity;
	
	@FindBy(name = "ticketcategories")
	private WebElement Category;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveButton;
	
	//initialization	
	public CreatingNewTicketPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	//utilization	
	public WebElement getTitle() {
		return Title;
	}


	public WebElement getPriority() {
		return Priority;
	}


	public WebElement getSeverity() {
		return Severity;
	}


	public WebElement getCategory() {
		return Category;
	}


	public WebElement getSaveButton() {
		return SaveButton;
	}
	
	//business logic
	public void CreateNewTicketPage(String title, String priorty, String severty, String catgory) {
		Title.sendKeys(title);
		dropdownUsingContainsVisibleText(Priority, priorty);
		dropdownUsingContainsVisibleText(Severity, severty);
		dropdownUsingContainsVisibleText(Category, catgory);
		SaveButton.click();
	}
	
}
