package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.UtilityClass;

public class ProjectSpecifiedMethod extends UtilityClass{

	@BeforeMethod
	public void launchBrowser() {
		browser_Launch();
	}
	
	@AfterMethod
	public void closebrowser() {
		browser_Close();
	}
}
