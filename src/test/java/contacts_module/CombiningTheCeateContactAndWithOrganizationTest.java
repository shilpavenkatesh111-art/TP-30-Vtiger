package contacts_module;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

import genericLibraries_Utility.BaseClass;
import genericLibraries_Utility.ExcelUtils;
import genericLibraries_Utility.JavaUtils;
import genericLibraries_Utility.PropertyUtils;
import genericLibraries_Utility.WebDriverUtils;
import objectRepo.ContactsPage;
import objectRepo.CreateOrganizationPage;
import objectRepo.CreatingNewContactPage;
import objectRepo.HomePage;
import objectRepo.LoginPage;
import objectRepo.OrganizationsPage;

public class CombiningTheCeateContactAndWithOrganizationTest extends BaseClass {
	@Test(dependsOnMethods = "createContactswithOrganizationName", groups = "smoke")
	public void createContactsTest() throws IOException, InterruptedException {

		JavaUtils jLib = new JavaUtils();

		String LastName = eLib.readDataFromExcelFile("contacts", 0, 1) + jLib.getRandomNo();

		HomePage hp = new HomePage(driver);
		hp.ClickOnContactsLink();
		ContactsPage cp = new ContactsPage(driver);
		cp.ClickOnContactLookupImage();

		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.CreateNewContactPage(LastName);

		WebElement actEle = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		String actual = actEle.getText();
		wLib.waitUntilEleToBeVisible(driver, 10, actEle);

		assertTrue(actual.contains(LastName));
		System.out.println("contact created successfully!");

	}

	@Test(groups = "regression")
	public void createContactswithOrganizationName() throws IOException, InterruptedException {

		JavaUtils jLib = new JavaUtils();

		String lastName = eLib.readDataFromExcelFile("contacts", 1, 1) + jLib.getRandomNo();
		String expOrgName = eLib.readDataFromExcelFile("contacts", 2, 1) + jLib.getRandomNo();

		HomePage hp = new HomePage(driver);
		hp.ClickOnOrganizationLink();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.ClickOnOrganizationLookupImage();

		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.CreatingNewOrganization(expOrgName);

		WebElement actual = driver.findElement(By.className("dvHeaderText"));
		String act1 = actual.getText();
		wLib.waitUntilEleToBeVisible(driver, 10, actual);
		assertTrue(act1.contains(expOrgName));
		System.out.println("organization created successfully");

		hp.ClickOnContactsLink();
		ContactsPage cp = new ContactsPage(driver);
		cp.ClickOnContactLookupImage();

		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.CreateNewContactPage(lastName, expOrgName, driver);

		WebElement actual1 = driver.findElement(By.className("dvHeaderText"));
		String act = actual1.getText();
		wLib.waitUntilEleToBeVisible(driver, 10, actual1);
		assertTrue(act.contains(lastName));
		System.out.println("contact information is displayed successfully!");

	}

}
