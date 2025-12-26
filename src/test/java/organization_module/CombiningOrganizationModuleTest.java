package organization_module;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.testng.Assert.*;
import org.testng.annotations.Ignore;
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
import objectRepo.OrganizationValidatePage;
import objectRepo.OrganizationsPage;

public class CombiningOrganizationModuleTest extends BaseClass {

	@Ignore
	@Test(groups = "smoke", dependsOnGroups = "createOrganizationWithIndustryDropdownTest")
	public void createOrganizationWithMandatoryFieldTest() throws IOException, InterruptedException {

		JavaUtils jLib = new JavaUtils();

		String OrgName = eLib.readDataFromExcelFile("organizations", 0, 1) + jLib.getRandomNo();

		HomePage hp = new HomePage(driver);
		hp.ClickOnOrganizationLink();

		OrganizationsPage og = new OrganizationsPage(driver);
		og.ClickOnOrganizationLookupImage();

		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.CreatingNewOrganization(OrgName);

		OrganizationValidatePage ovp = new OrganizationValidatePage(driver);
		ovp.validation(OrgName, driver);

	}

	@Test(groups = "regression")
	public void createOrganizationWithIndustryDropdownTest()
			throws EncryptedDocumentException, IOException, InterruptedException {

		JavaUtils jLib = new JavaUtils();

		String OrgName = eLib.readDataFromExcelFile("organizations", 0, 1) + jLib.getRandomNo();
		String indDD = eLib.readDataFromExcelFile("organizations", 1, 1);

		HomePage hp = new HomePage(driver);
		hp.ClickOnOrganizationLink();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.ClickOnOrganizationLookupImage();

		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.CreatingNewOrganization(OrgName, indDD);

		WebElement actual = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		String act = actual.getText();
		wLib.waitUntilEleToBeVisible(driver, 10, actual);
		assertTrue(act.contains(OrgName));
		System.out.println("organization Page displayed very successfully");

	}

}