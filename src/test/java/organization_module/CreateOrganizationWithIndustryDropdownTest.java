package organization_module;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries_Utility.BaseClass;
import genericLibraries_Utility.ExcelUtils;
import genericLibraries_Utility.JavaUtils;
import genericLibraries_Utility.PropertyUtils;
import genericLibraries_Utility.WebDriverUtils;
import objectRepo.CreateOrganizationPage;
import objectRepo.HomePage;
import objectRepo.LoginPage;
import objectRepo.OrganizationsPage;

public class CreateOrganizationWithIndustryDropdownTest extends BaseClass{
	@Test(groups = "smoke")
	public  void createOrganizationWithIndustryDropdownTest() throws EncryptedDocumentException, IOException, InterruptedException {
//		WebDriver driver = null;
//
//		PropertyUtils pLib = new PropertyUtils();
//		ExcelUtils eLib = new ExcelUtils();
		JavaUtils jLib = new JavaUtils();
//		WebDriverUtils wLib=new WebDriverUtils();

		// creating the random object to correct the duplicate values
		//	Random ran = new Random();
		//	int next = ran.nextInt(500);

		// read data from property file
		//		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		//		Properties pObj=new Properties();
		//		pObj.load(fis);
				
		//		String BROWSER=pObj.getProperty("browser");
		//		String URL=pObj.getProperty("url");
		//		String USERNAME=pObj.getProperty("username");
		//		String PASSWORD=pObj.getProperty("password");

//		String BROWSER = pLib.readDataDromPropertyFile("browser");
//		String URL = pLib.readDataDromPropertyFile("url");
//		String USERNAME = pLib.readDataDromPropertyFile("username");
//		String PASSWORD = pLib.readDataDromPropertyFile("password");

		// Read the data from excel file
		//		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\Tp30 testdata.xlsx");
		//		Workbook wb = WorkbookFactory.create(fi);
		//		Sheet sh = wb.getSheet("organizations");
					
		//		String OrgName = sh.getRow(0).getCell(1).getStringCellValue()+next;
		//		String indDD = sh.getRow(1).getCell(1).getStringCellValue();
		String OrgName = eLib.readDataFromExcelFile("organizations", 0, 1) + jLib.getRandomNo();
		String indDD = eLib.readDataFromExcelFile("organizations", 1, 1);

		//launch the browser
//		if (BROWSER.equalsIgnoreCase("chrome")) {
//			driver = new ChromeDriver();
//		} 
//		
//		else if (BROWSER.equalsIgnoreCase("firefox")) {
//			driver = new FirefoxDriver();
//		} 
//		
//		else {
//			driver = new EdgeDriver();
//		}

		//maximize the browser
		//driver.manage().window().maximize();
//		wLib.maximizewindow(driver);
//
//		//enter the url
//		driver.get(URL);
//
//		//wait for loading the page
//		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		wLib.waitForPageLoad(driver, 10);

		//	Login to application	
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
//		LoginPage lp=new LoginPage(driver);
//		lp.loginPage(USERNAME, PASSWORD);

		//	Navigate to Home page click on Organization link
		//driver.findElement(By.linkText("Organizations")).click();
		HomePage hp=new HomePage(driver);
		hp.ClickOnOrganizationLink();

		//	Click on 'Create Organization' lookup image
		//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		OrganizationsPage op=new OrganizationsPage(driver);
		op.ClickOnOrganizationLookupImage();

		//	Enter mandatory fields with valid data
		//driver.findElement(By.name("accountname")).sendKeys(OrgName);
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.CreatingNewOrganization(OrgName, indDD);

		//	Click on 'Industry' dropdown and select 'Healthcare' from dropdown
		//WebElement industry = driver.findElement(By.name("industry"));
//		Select sel = new Select(industry);
//		sel.selectByContainsVisibleText(indDD);
		//wLib.dropdownUsingContainsVisibleText(industry, indDD);

		//	click on 'Save' button
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// validating the data what is actual result contains
		WebElement actual = driver.findElement(By.className("dvHeaderText"));
		
		String act = actual.getText();
		wLib.waitUntilEleToBeVisible(driver, 10, actual);
		Assert.assertTrue(act.contains(OrgName));
		System.out.println("organization Page displayed successfully");
//		if (actual.contains(OrgName)) {
//			System.out.println("organization Page displayed successfully");
//		} else {
//			System.out.println("organization not created");
//		}
		// Click on 'Administrator
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//	step 6: Click on 'SignOut'
//mousehover on 'signout' link and click on that
		//WebElement signout = driver.findElement(By.linkText("Sign Out"));

//use actions class to move the element to signout and Click on 'SignOut'
//		Actions act = new Actions(driver);
//		act.moveToElement(signout).click().perform();
		//wLib.mouseHoverAndClickOnElement(driver, signout);
//		hp.ClickOnAdministratorLink();
//		hp.ClickOnSignoutLink(driver);
//		
//		Thread.sleep(2000);
//		driver.quit();
	}
}
