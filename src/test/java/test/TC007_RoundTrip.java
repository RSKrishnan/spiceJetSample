package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecifiedMethod;
import pages.HomePage;

public class TC007_RoundTrip extends ProjectSpecifiedMethod {

	@BeforeTest
	public void setup() throws IOException {
		testName = "RoundTrip";
		testDescription = "Testing the RoundTrip";
		testAuthor = "Ramakrishnan";
		testCategory = "Smoke Testing";
		sheetName = "OneWayTestData";
	}

	@Test(dataProvider = "readData")
	public void roundTripTest(String origin, String dest, String uName, String pWord) throws IOException

	{
		HomePage obj = new HomePage(driver);

		obj.click_roundTrip().enter_origin(origin).enter_dest(dest).select_date().select_returndate().search_Flight()

				.click_loginBtn().enter_uName(uName).enter_pWord(pWord).click_login().validate_login()
				.pricecontinue_Btn().click_primaryPax().continue_Button().continue_Button1()

				.click_upiOption().click_Payment().validate_login();

	}

}
