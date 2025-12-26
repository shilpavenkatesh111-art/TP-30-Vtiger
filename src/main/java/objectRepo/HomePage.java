package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries_Utility.WebDriverUtils;

public class HomePage extends WebDriverUtils{
	
	//declaration
	@FindBy(linkText = "Organizations")
	private WebElement organization;
	
	@FindBy(linkText = "Contacts")
	private WebElement contact;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunity;
	
	@FindBy(linkText = "Products")
	private WebElement Product;
	
	@FindBy(linkText = "Documents")
	private WebElement Document;
	
	@FindBy(linkText = "Trouble Tickets")
	private WebElement TroubleTickets;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']") 
	private WebElement Administrator;
	
	@FindBy(linkText = "Sign Out")
	private WebElement Signout;
	
	//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getOrganization() {
		return organization;
	}

	public WebElement getContact() {
		return contact;
	}

	public WebElement getOpportunity() {
		return opportunity;
	}

	public WebElement getProduct() {
		return Product;
	}

	public WebElement getDocument() {
		return Document;
	}
	
	public WebElement getTroubleTickets() {
		return TroubleTickets;
	}
	
	public WebElement getAdministrator() {
		return Administrator;
	}
	
	public WebElement getSignout() {
		return Signout;
	}
	
	//business logic
	public void ClickOnOrganizationLink() {
		organization.click();
		
	}
	
	public void ClickOnContactsLink() {
		contact.click();
	}
	public void ClickOnOpportunityLink() {
		opportunity.click();
		
	}
	
	public void ClickOnProductLink(){
		Product.click();
	} 
		
	public void ClickOnDocumentLink() {
		Document.click();
	}
	
	public void ClickOnTroubleTicketsLink() {
		TroubleTickets.click();
	}
	
//	public void ClickOnAdministratorLink() {
//		Administrator.click();
//	}
	
	public void ClickOnSignoutLink(WebDriver driver) {
		//mouseHoverAndClickOnElement(driver, Signout);
		mouseHover(driver, Administrator);
		Signout.click();
//		Administrator.click();
//		waitUntilEleToBeVisible(driver, 10, Signout);
//		Signout.click();
	}
	
	}


