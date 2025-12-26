package genericLibraries_Utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {
	/**
	 * this method is used to maximize the window
	 * 
	 * @author Srinivas V
	 * @param driver
	 */
	public void maximizewindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * this method is used to wait for to load the page
	 * 
	 * @author Srinivas V
	 * @param driver
	 * @param seconds
	 */
	public void waitForPageLoad(WebDriver driver, int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	/**
	 * this method is used to wait until element is available on webpage
	 * 
	 * @author Srinivas V
	 * @param driver
	 * @param seconds
	 * @param element
	 */
	public void waitUntilElementToBeClickable(WebDriver driver, int seconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * this method is used to create an object for select class to call select class
	 * 
	 * @author Srinivas V
	 * @param element
	 * @return
	 */
	// select class methods
	public Select dropdown(WebElement element) {
		Select sel = new Select(element);
		return sel;
	}

	/**
	 * this method is used to select the value from dropdown
	 * 
	 * @author Srinivas V
	 * @param element
	 * @param value
	 */
	public void dropDownUsingValue(WebElement element, String value) {
		dropdown(element).selectByValue(value);
	}

	/** 
	 * this method is used to select the int index vaue from dropdown
	 * 
	 * @author Srinivas V
	 * @param element
	 * @param index
	 */
	public void dropDownUsingIndex(WebElement element, int index) {
		dropdown(element).selectByIndex(index);
	}

	/**
	 * this method is used to select the text from dropdown
	 * 
	 * @author Srinivas V
	 * @param element
	 * @param text
	 */
	public void dropdownUsingVisibleText(WebElement element, String text) {
		dropdown(element).selectByVisibleText(text);
	}

	/**
	 * this method is used to select the without any space text from the dropdown
	 * 
	 * @author Srinivas V
	 * @param element
	 * @param text
	 */
	public void dropdownUsingContainsVisibleText(WebElement element, String text) {
		dropdown(element).selectByContainsVisibleText(text);
	}

	/**
	 * this method is used to create an object for actions class
	 * 
	 * @author Srinivas V
	 * @param driver
	 * @return
	 */
	// actions class methods
	public Actions actions(WebDriver driver) {
		Actions act = new Actions(driver);
		return act;
	}

	/**
	 * this method is used to move mouse to element
	 * 
	 * @author Srinivas V
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver, WebElement element) {
		actions(driver).moveToElement(element).perform();
	}

	/**
	 * this method is used to move mouse to element and click on the element
	 * 
	 * @author Srinivas V
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAndClickOnElement(WebDriver driver, WebElement element) {
		actions(driver).moveToElement(element).click().perform();
	}

	/**
	 * this method is used to drag and drop the webelement
	 * 
	 * @author Srinivas V
	 * @param driver
	 * @param src
	 * @param dst
	 */
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dst) {
		actions(driver).dragAndDrop(src, dst).perform();
	}

	/**
	 * this method is used to scroll web page
	 * 
	 * @author Srinivas V
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollWebPage(WebDriver driver, int x, int y) {
		actions(driver).scrollByAmount(x, y).perform();
	}

	/**
	 * this method is used to scroll to the element
	 * 
	 * @author Srinivas V
	 * @param driver
	 * @param element
	 */
	public void scrollToElement(WebDriver driver, WebElement element) {
		actions(driver).scrollToElement(element).perform();
	}

	/**
	 * this method is used to double click on the webpage
	 * 
	 * @author Srinivas V
	 * @param driver
	 */
	public void doubleclick(WebDriver driver) {
		actions(driver).doubleClick().perform();
	}

	/**
	 * this method is used to double Click On Element
	 * 
	 * @author Srinivas V
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnElement(WebDriver driver, WebElement element) {
		actions(driver).doubleClick(element).perform();
	}

	/**
	 * this method is used to right Click On Web Page
	 * 
	 * @author Srinivas V
	 * @param driver
	 * @param element
	 */
	public void rightClickOnWebPage(WebDriver driver, WebElement element) {
		actions(driver).contextClick(element).perform();
	}

	/**
	 * this method is used to right Click On Element
	 * 
	 * @author Srinivas V
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver, WebElement element) {
		actions(driver).contextClick(element).perform();

	}

	/**
	 * this method is used to click And Hold web element
	 * 
	 * @author Srinivas V
	 * @param driver
	 * @param element
	 */
	public void clickAndHold(WebDriver driver, WebElement element) {
		actions(driver).clickAndHold(element).perform();
	}

	/**
	 * this method is used to click Hold And Release the element
	 * 
	 * @author Srinivas V
	 * @param driver
	 * @param element
	 */
	public void clickHoldAndRelease(WebDriver driver, WebElement element) {
		actions(driver).clickAndHold(element).release().perform();
	}

	/**
	 * this method is used to get the all windows
	 * 
	 * @author Srinivas V
	 * @param driver
	 * @param expTitle
	 */
	public void switchToWindow(WebDriver driver, String expTitle) {
		// String parent = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while (it.hasNext()) {
			String currentWin = it.next();
			String actualTitle = driver.switchTo().window(currentWin).getTitle();
			if (actualTitle.contains(expTitle)) {
				break;
			}
		}
	}

	/**
	 * this method is used to switch the parent window
	 * 
	 * @author Srinivas V
	 * @param driver
	 * @param ParentId
	 */
	public void switchToParentWindow(WebDriver driver, String ParentId) {
		driver.switchTo().window(ParentId);
	}

	/**
	 * this method is used to switch child frame by using inex value
	 * 
	 * @author Srinivas V
	 * @param driver
	 * @param index
	 */
	public void switchToChildFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * this method is used to switch child frame by using name
	 * 
	 * @author Srinivas V
	 * @param driver
	 * @param name
	 */
	public void switchToChildFrame(WebDriver driver, String name) {
		driver.switchTo().frame(name);
	}

	/**
	 * this method is used to switch child frame by using webelement
	 * 
	 * @author Srinivas V
	 * @param driver
	 * @param element
	 */
	public void switchToChildFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * this method is used to switch parent frame
	 * 
	 * @author Srinivas V
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	/**
	 * this method is used to switch main frame
	 * 
	 * @author Srinivas V
	 * @param driver
	 */
	public void switchToMainFrame(WebDriver driver) {
		driver.switchTo().defaultContent();

	}

	/**
	 * this method is used to accept the alert popup
	 * 
	 * @author Srinivas V
	 * @param driver
	 */
	// alert popup methods
	public void acceptAlertPopUp(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * this method is used to cancel the alert popup
	 * 
	 * @author Srinivas V
	 * @param driver
	 */
	public void cancelAlertPopUp(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * this method is used to get text from alter popup
	 * 
	 * @author Srinivas V
	 * @param driver
	 */
	public void getTextFromAlertPopup(WebDriver driver) {
		driver.switchTo().alert().getText();
	}

	/**
	 * this method is used to enter the value into alert text field
	 * 
	 * @author Srinivas V
	 * @param driver
	 * @param value
	 */
	public void enterValueIntoAlertTextField(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	/**
	 * typecasting to the javascript method
	 * 
	 * @author Srinivas V
	 * @param driver
	 * @return
	 */
	// javascriptExecutor methods
	public JavascriptExecutor javascriptExecutor(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;
	}

	/**
	 * this method is used to scroll height
	 * 
	 * @author Srinivas V
	 * @param driver
	 */
	public void scrollHeight(WebDriver driver) {
		javascriptExecutor(driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	/**
	 * this mehtod is used to scroll unit element is visible
	 * 
	 * @author Srinivas V
	 * @param driver
	 * @param element
	 */
	// scrollTillElement
	public void scrollUnitElementIsVisibleUsingJSE(WebDriver driver, WebElement element) {
		javascriptExecutor(driver).executeScript("arguments[0].scrollIntoView()", element);
	}

	/**
	 * this method is used to click on element
	 * 
	 * @author Srinivas V
	 * @param driver
	 * @param element
	 */
	// click on element
	public void clickOnElementUsingJSE(WebDriver driver, WebElement element) {
		javascriptExecutor(driver).executeScript("argument[0].click()", element);
	}

	/**
	 * this method is used to enter the value into text field
	 * 
	 * @author Srinivas V
	 * @param driver
	 * @param element
	 * @param value
	 */
	// sendkeys
	public void enterValueIntoTextFieldUsingJSE(WebDriver driver, WebElement element, String value) {
		javascriptExecutor(driver).executeScript("argument[0].value=arguments[1]", element, value);
	}

	/**
	 * this method is used to scroll to element x y location
	 * 
	 * @author Srinivas V
	 * @param driver
	 * @param element
	 */
	public void scrollToElementUsingXYCoOrdinate(WebDriver driver, WebElement element) {
		Point loc = element.getLocation();
		int x = loc.getX();
		int y = loc.getY();
		javascriptExecutor(driver).executeScript("window.scrollBy(" + x + "," + y + ")");
	}
	
	public void waitUntilEleToBeVisible(WebDriver driver, int Seconds, WebElement element) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Seconds));
		    wait.until(ExpectedConditions.visibilityOf(element));
		}

	//takesscreenshot
	public static String takeScreenshotWholePage(WebDriver driver, String fileName) throws IOException
	{
		String filepath=".\\screenshot\\"+fileName+new JavaUtils().sysDate()+".png";
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst=new File(filepath);
		FileUtils.copyDirectory(src, dst);
		String path = dst.getAbsolutePath();
		return path;
		
	}
}
