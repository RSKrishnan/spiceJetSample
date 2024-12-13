package base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

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
	}
	
	@BeforeClass
	public void testDetails() {
		test = extent.createTest(testName,testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
	}
	
	@AfterMethod
	public void closebrowser() {
		browser_Close();
	}
	
	@Parameters({"browser"})
	@BeforeMethod
	public void launchAndLoadURL(String browser) {	
		browserLaunch(browser);		
	}
	
	@AfterSuite
	public void Close() {
		extent.flush();
	}
	
	@DataProvider(name="readData")
	public String[][] readData() throws IOException {
		String[][] data=readExcel(sheetName);
		return data;
	}
}
