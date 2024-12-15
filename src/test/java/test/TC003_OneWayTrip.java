package test;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecifiedMethod;
import pages.BookingPage;
import pages.HomePage;
import pages.LoginPage;
import test.*;

public class TC003_OneWayTrip extends ProjectSpecifiedMethod {

	@BeforeTest
	public void setup() throws IOException {
		testName = "OnewayTrip";
		testDescription = "Testing the OneWayTrip";
		testAuthor = "Ram";
		testCategory = "Regression Testing";
		sheetName = "OneWayTestData";
	}

	@Test(dataProvider = "readData")
	public void oneWayTest(String origin, String dest, String uName, String pWord) throws IOException {

		HomePage obj = new HomePage(driver);
		obj.enter_origin(origin).enter_dest(dest).select_date().search_Flight()

				.click_loginBtn().enter_uName(uName).enter_pWord(pWord).click_login().validate_login()
				.pricecontinue_Btn().click_primaryPax().continue_Button().continue_Button1()

				.click_upiOption().click_Payment().validate_login();

	}
}
