package contacts_module;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries_Utility.BaseClass;
import genericLibraries_Utility.JavaUtils;

import objectRepo.ContactsPage;
import objectRepo.CreateOrganizationPage;
import objectRepo.CreatingNewContactPage;
import objectRepo.HomePage;

import objectRepo.OrganizationsPage;


public class CreateContactswithOrganizationName extends BaseClass{
	@Test(groups = "regression")
public void createContactswithOrganizationName() throws IOException, InterruptedException {
	
//	WebDriver driver=null;
//	PropertyUtils pLib=new PropertyUtils();
//	ExcelUtils eLib=new ExcelUtils();
	JavaUtils jLib=new JavaUtils();
//	WebDriverUtils wLib=new WebDriverUtils();
//	//create random number
	Random r=new Random();
	int random = r.nextInt(500);
	
//	//read the data from the properties
//	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
//	Properties p=new Properties();
//	p.load(fis);
//	String BROWSER = pLib.readDataDromPropertyFile("browser");
//	String URL = pLib.readDataDromPropertyFile("url");
//	String USERNAME= pLib.readDataDromPropertyFile("username");
//	String PASSWORD = pLib.readDataDromPropertyFile("password");
//	
//	String BROWSER=p.getProperty("browser");
//	String URL=p.getProperty("url");
//	String USERNAME=p.getProperty("username");
//	String PASSWORD=p.getProperty("password");
	
	//read data from the excel
//	FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\Tp30 testdata.xlsx");
//	Workbook wb = WorkbookFactory.create(fi);
//	Sheet sh=wb.getSheet("contacts");
//	
//	String lastname=sh.getRow(1).getCell(1).getStringCellValue()+random;
//	String expOrgName=sh.getRow(2).getCell(1).getStringCellValue()+random;
	String lastName = eLib.readDataFromExcelFile("contacts", 1, 1)+jLib.getRandomNo();
	String expOrgName=eLib.readDataFromExcelFile("contacts", 2, 1)+jLib.getRandomNo();
	
	
	
	//launch the browser
//	if(BROWSER.contains("chrome")) {
//		driver=new ChromeDriver();
//	}
//	else if(BROWSER.contains("firefox")) {
//		driver=new FirefoxDriver();
//	}
//	else {
//		driver=new EdgeDriver();
//	}
//	
//	//maximize the browser
//	//driver.manage().window().maximize();
//	wLib.maximizewindow(driver);
	
	//enter the url
//	driver.get(URL);
//	
//	//wait for loading the page
//	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	wLib.waitForPageLoad(driver, 10);
	
	//	Login to application
//	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//	driver.findElement(By.id("submitButton")).click();
	
//	LoginPage lp=new LoginPage(driver);
//	lp.loginPage(USERNAME, PASSWORD);
	
//	Navigate to Home page click on Organization link
	//driver.findElement(By.linkText("Organizations")).click();
	HomePage hp=new HomePage(driver);
	hp.ClickOnOrganizationLink();
	
//	Click on 'Create Organization' lookup image
	//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	OrganizationsPage op=new OrganizationsPage(driver);
	op.ClickOnOrganizationLookupImage();
//	Enter mandatory fields with valid data
	//driver.findElement(By.name("accountname")).sendKeys(expOrgName);
	CreateOrganizationPage cop=new CreateOrganizationPage(driver);
	cop.CreatingNewOrganization(expOrgName);
	
//	click on 'Save' button
	//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	// validating the data what is actual result contains
	WebElement actual = driver.findElement(By.className("dvHeaderText"));
	String act = actual.getText();
	wLib.waitUntilEleToBeVisible(driver, 10, actual);
	Assert.assertTrue(act.contains(expOrgName));
	System.out.println("organization created successfully");
//	if(actual.contains(expOrgName)) {
//		System.out.println("organization created successfully");
//	}
//	else {
//		System.out.println("organization not created");
//	}
	
	
	//	Navigate to Home Page Click on Contacts link
	//driver.findElement(By.linkText("Contacts")).click();
	hp.ClickOnContactsLink();
	
	//	Click on Create Contact Lookup image
	//driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	ContactsPage cp=new ContactsPage(driver);
	cp.ClickOnContactLookupImage();
	
	//	Enter the 'Last Name' text field
	//driver.findElement(By.name("lastname")).sendKeys(lastName);
	CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
	cncp.CreateNewContactPage(lastName, expOrgName, driver);
	
	//	Click on 'Organization Name' lookup image
	//driver.findElement(RelativeLocator.with(By.xpath("//img[@alt='Select']")).below(By.name("lastname"))).click();
	//String parent = driver.getWindowHandle();
	
	//handle child window popup
//	Set<String> windows = driver.getWindowHandles();
//	
//	Iterator<String> it = windows.iterator();
//	
//	while(it.hasNext()){//it will check if there is other windows
//	String wid = it.next();
//	
//	String currentTitle = driver.switchTo().window(wid).getTitle();
//	if(currentTitle.contains("Accounts&action"))
//	{
//		break;
//	}
//	}
	
	//wLib.switchToWindow(driver, "Accounts&action");
	
	
//	driver.findElement(By.id("search_txt")).sendKeys(expOrgName);
//	driver.findElement(By.name("search")).click();
//	Click on 'Organization Name'
	//driver.findElement(By.xpath("//a[text()='"+expOrgName+"']")).click();
	
	//coming back to parent window
	//driver.switchTo().window(parent);
	//wLib.switchToWindow(driver,"Contacts&action");
	
//	click on 'Save' button
	//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

  //validating the actual result
	WebElement actual1 = driver.findElement(By.className("dvHeaderText"));
	
	String act1=actual1.getText();
	wLib.waitUntilEleToBeVisible(driver, 10, actual1);
	Assert.assertTrue(act1.contains(lastName));
	System.out.println("contact information is displayed successfully!");
//	if(actual1.contains(lastName)) {
//		System.out.println("contact information is displayed successfully!");
//	}
//	else {
//		System.out.println("does not exist!");
//	}

	//click on Administrator icon
   // driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
    
    //mousehover on 'signout' link and click on that
    //WebElement signout = driver.findElement(By.linkText("Sign Out"));
    
    //use actions class to move the element to signout and Click on 'SignOut'
//    Actions act=new Actions(driver);
//    act.moveToElement(signout).click().perform();
   // wLib.mouseHoverAndClickOnElement(driver, signout);
//	hp.ClickOnAdministratorLink();
//	hp.ClickOnSignoutLink(driver);
//	Thread.sleep(2000);
//	driver.quit();

}
}
