package base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.UtilityClass;

public class ProjectSpecifiedMethod extends UtilityClass{

	@BeforeSuite
	public void reportInitialization() throws IOException {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("SpicyJet Test Results");
		extent = new ExtentReports();
		extent.attachReporter(reporter); 
		readFromPropFile("browser&URL");
		browserLaunch();
	}
	
	@BeforeClass
	public void testDetails() {
		test = extent.createTest(testName,testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
	}
	
//	@BeforeMethod
//	public void launchAndLoadURL() {
//		browserLaunch();
//	}
//	@AfterMethod
//	public void closebrowser() {
//		browser_Close();
//	}
	
	@AfterSuite
	public void Close() {
		extent.flush();
		browser_Close();
	}
	
	@DataProvider(name="readData")
	public String[][] readData() throws IOException {
		String[][] data=readExcel(sheetName);
		return data;
	}
}
