package contacts_module;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericLibraries_Utility.BaseClass;
import genericLibraries_Utility.ExcelUtils;
import genericLibraries_Utility.JavaUtils;
import genericLibraries_Utility.ListenersImplementationClass;
import genericLibraries_Utility.PropertyUtils;
import genericLibraries_Utility.WebDriverUtils;
import objectRepo.ContactsPage;
import objectRepo.CreatingNewContactPage;
import objectRepo.HomePage;
import objectRepo.LoginPage;
@Listeners(genericLibraries_Utility.ListenersImplementationClass.class)
public class CreateContactsTest extends BaseClass{
	@Test(groups = "smoke")
public void createContactsTest() throws IOException, InterruptedException {
//	WebDriver driver=null;
//	
//	PropertyUtils pLib=new PropertyUtils();
//	ExcelUtils eLib=new ExcelUtils();
		//JavaUtils jLib=new JavaUtils();
//	WebDriverUtils wLib=new WebDriverUtils();
	
//	Random ran=new Random();
//	int random = ran.nextInt(500);
	
	//read data from property file
//			FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
//			Properties pObj=new Properties();
//			pObj.load(fis);
			
//			String BROWSER = pLib.readDataDromPropertyFile("browser");
//			String URL = pLib.readDataDromPropertyFile("url");
//			String USERNAME= pLib.readDataDromPropertyFile("username");
//			String PASSWORD = pLib.readDataDromPropertyFile("password");
			
	//Read the data from excel file
//			FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\Tp30 testdata.xlsx");
//			Workbook wb = WorkbookFactory.create(fi);
//			Sheet sh = wb.getSheet("contacts");
//			String LastName = sh.getRow(0).getCell(1).getStringCellValue()+random;
			String LastName = eLib.readDataFromExcelFile("contacts", 0, 1)+jLib.getRandomNo();
			
	//launch the browser
//			if(BROWSER.contains("chrome")) {
//				driver=new ChromeDriver();
//			}
//			else if(BROWSER.contains("firefox")) {
//				driver=new FirefoxDriver();
//			}
//			else {
//				driver=new EdgeDriver();
//			}
			
	//maximize the browser
	//driver.manage().window().maximize();
//	wLib.maximizewindow(driver);
//	
//	//enter the url
//	driver.get(URL);
//		
//	//wait for to load the page
//	wLib.waitForPageLoad(driver, 10);
	
//	step 1: Login to application
//	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//	driver.findElement(By.id("submitButton")).click();
//	LoginPage lp=new LoginPage(driver);
//	lp.loginPage(USERNAME, PASSWORD);
	
//	step 2: Navigate to Home Page Click on Contacts link
	//driver.findElement(By.linkText("Contacts")).click();
	HomePage hp=new HomePage(driver);
	hp.ClickOnContactsLink();
	
// 	step 3: Click on Create Contact Lookup page
	//driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	ContactsPage cp=new ContactsPage(driver);
	cp.ClickOnContactLookupImage();
	
//	step 4: Enter the 'Last Name' text field
	//driver.findElement(By.name("lastname")).sendKeys(LastName);
	CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
	cncp.CreateNewContactPage(LastName);
	
//	step 5: click on 'Save' button
	//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
//  step 6: validating the result
	WebElement actual = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
	String act = actual.getText();
	
	wLib.waitUntilEleToBeVisible(driver, 10, actual);
	Assert.assertTrue(act.contains(LastName));
	System.out.println("contact created successfully!");
	ListenersImplementationClass.extentTest.get().log(Status.PASS, "create contact successfully passed");
	
//
//    if(actual.contains(LastName)) {
//    	System.out.println("contact created successfully!");
//    }
//    else {
//    	System.out.println("contacts not created");
//    }
    //Signout
    //click on Administrator icon
   // driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//    hp.ClickOnAdministratorLink();
    //mousehover on 'signout' link and click on that
    //WebElement signout = driver.findElement(By.linkText("Sign Out"));
    
    //use actions class to move the element to signout
//    Actions act=new Actions(driver);
//    act.moveToElement(signout).click().perform();
//    hp.ClickOnSignoutLink(driver);
   // wLib.mouseHoverAndClickOnElement(driver, signout);
//    Thread.sleep(2000);
//    driver.quit();


}
}
