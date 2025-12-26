 package genericLibraries_Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementationClass implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	public static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();// Very useful for parallel execution
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName(); //Gets the name of the test method
		test=report.createTest(methodName);// This line creates a new test entry in the Extent Report based on method name
//		test.log(Status.INFO, methodName+"execution starts");
		extentTest.set(test);//inside the thread ref variable storing the method name or test
		extentTest.get().log(Status.INFO, methodName+"execution starts");// this statement Adds a message to the Extent Report
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();//Gets the current test case from ThreadLocal, 
		extentTest.get().log(Status.PASS, "<b>"+methodName+"--> passed</b>");//Marks the test as PASSED in the report

		//Shows green color in Extent Report
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();// get test method name
		String fileName=methodName+new JavaUtils().sysDate();// test method name with current date/time, This makes the screenshot unique
		//String fileName = methodName + " " + System.currentTimeMillis();

		try {
		//Selenium takes a screenshot of the current browser screen
		//This happens at the failure moment

		TakesScreenshot ts=(TakesScreenshot) BaseClass.wdriver.get();//sdriver is the WebDriver object, So we first convert the browser driver into a screenshot-taking object.
		File src = ts.getScreenshotAs(OutputType.FILE);//screenshot store this file
		File dst = new File(".\\screenshot\\"+fileName+".png");//attaching failed screenshot into extent report
		//1. line decides where to save the screenshot, 2. .\\screenshot\\ → folder name, 3. fileName → test method name + date/time
		//4..png → image format
			FileUtils.copyFile(src, dst);// This line copies the screenshot From temporary memory (src) To permanent location (dst)
			//Save the screenshot permanently in the screenshot folder
			String path=dst.getAbsolutePath();// This line gets the full path of the saved screenshot. This path is needed to attach screenshot to Extent Report
			extentTest.get().addScreenCaptureFromPath(path);//This line attaches the screenshot to the Extent Report.
			//extentTest.get() → current test case, addScreenCaptureFromPath() → attach image, now screenshot appears in the report.
			extentTest.get().log(Status.FAIL, result.getThrowable());//this line Write the failure reason in the report, getThrowable() in more detail
			extentTest.get().log(Status.FAIL, "<i>"+methodName+"---> failed</i>");//Marks test as FAILED Displays message in report
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();// get test method name
		//extentTest.get().log(Status.WARNING, methodName+"----> skipped")
		extentTest.get().log(Status.SKIP, methodName+"----> skipped");// This line is used when a test case is skipped in TestNG.
		//1.extentTest.get() → Gets the correct test object from ThreadLocal, 2.log(Status.SKIP, …) → Logs a skipped message in the Extent Report
		//3. methodName + " ----> skipped" → Shows which test was skipped
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlreport=new ExtentSparkReporter(".\\ExtentReport\\report"+new JavaUtils().sysDate()+".html");//This line creates a new HTML report using ExtentSparkReporter.
		//ExtentSparkReporter → a class in ExtentReports used to generate a HTML report
		//".\\ExtentReport\\" → folder where the report will be saved
		//"report" → name of the report
		//new JavaUtils().sysDate() → adds current date and time to make the file unique
		//".html" → file type is HTML
		htmlreport.config().setDocumentTitle("TP-30");//is used to set the title of the Extent HTML report that appears on the browser tab.
		htmlreport.config().setTheme(Theme.DARK);//sets the visual theme of the report
		htmlreport.config().setReportName("VTiger");
		
		report=new ExtentReports();//this object is the main controller of the report
		report.attachReporter(htmlreport);//Attach the HTML report file to the main report, Without this, the report will not be generated
		report.setSystemInfo("base_browser", "chrome");
		report.setSystemInfo("base_platform", "windows"); //adding system information
		report.setSystemInfo("base_url", "http://localhost:8888");
		report.setSystemInfo("ReporterName", "Shilpa");
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
