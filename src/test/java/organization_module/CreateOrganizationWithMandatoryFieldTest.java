package organization_module;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
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
import objectRepo.OrganizationValidatePage;
import objectRepo.OrganizationsPage;

public class CreateOrganizationWithMandatoryFieldTest extends BaseClass {
	@Test(groups = "regression")
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
		System.out.println("organization created successfully");
		
	}

	@Test
	public void regional() {
		System.out.println("---regional test----");
		
	}
}
