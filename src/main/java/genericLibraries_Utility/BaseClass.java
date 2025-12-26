package genericLibraries_Utility;

import java.io.IOException;

import java.sql.SQLException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import objectRepo.HomePage;
import objectRepo.LoginPage;

public class BaseClass {
	
	public DataBaseUtils dLib=new DataBaseUtils();
	public PropertyUtils pLib=new PropertyUtils();
	public ExcelUtils eLib=new ExcelUtils();
	public WebDriverUtils wLib=new WebDriverUtils();
	public JavaUtils jLib=new JavaUtils();
	//public static WebDriver sdriver;// So that it can be accessed from anywhere, Especially from Listeners class
	public WebDriver driver;
	public static ThreadLocal<WebDriver> wdriver=new ThreadLocal<WebDriver>();
	@BeforeSuite(alwaysRun = true)
public void connectToDB() throws SQLException {
	dLib.connectToDB();
	System.out.println("--connected to DB--");
}

//@Parameters("BROWSER")

@BeforeClass(alwaysRun = true)
public void launchBrowser() throws IOException {
//public void launchBrowser(@Optional("chrome")String BROWSER) throws IOException {//if we not provide any parameter inside the suite.xml
	//the controller will check there if it is not there it will come to the base class and here it will find parameter and @optional
	//there we are providing the which browser wants to execute, then all test scripts execute in that browser
	
	String BROWSER = pLib.readDataDromPropertyFile("browser");
	String URL=pLib.readDataDromPropertyFile("url");
	if(BROWSER.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("edge")) {
		System.setProperty("webdriver.edge.driver", "C:\\drivers\\msedgedriver.exe");
		driver=new EdgeDriver();
	}
	
	else  if(BROWSER.equalsIgnoreCase("firefox")){
		driver=new FirefoxDriver();
	}
	
	//sdriver=driver;//this sdriver we using to take the screenshot in the implementation class, because the driver take only for the url session id, not support for the takescreenshot
	wdriver.set(driver);
	wLib.maximizewindow(driver);
	driver.get(URL);
	wLib.waitForPageLoad(driver, 10);
	System.out.println("--browser opened--");
}

@BeforeMethod(alwaysRun = true)
public void loginToApplication() throws IOException, InterruptedException {
	String USERNAME=pLib.readDataDromPropertyFile("username");
	String PASSWORD=pLib.readDataDromPropertyFile("password");
	LoginPage lp=new LoginPage(driver);
	lp.loginPage(USERNAME, PASSWORD);
	
	System.out.println("--loggedin to the application--");
}

@AfterMethod(alwaysRun = true)
public void logoutFromApplication() { 
	HomePage hp=new HomePage(driver);
	//hp.ClickOnAdministratorLink();
	hp.ClickOnSignoutLink(driver);
	System.out.println("--loggedout from the application--");
}


@AfterClass(alwaysRun = true)
public void closeBrowser() throws InterruptedException {
	Thread.sleep(2000);
	driver.quit();
	System.out.println("--browser closed--");
}

@AfterSuite(alwaysRun = true)
public void disconnectDB() throws SQLException {
	dLib.disconnetDB();
	
	System.out.println("--disconneted from DB--");
}
}
