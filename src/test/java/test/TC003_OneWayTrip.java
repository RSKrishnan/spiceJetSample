package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecifiedMethod;
import pages.BookingPage;
import pages.HomePage;
import pages.LoginPage;
import test.*;

public class TC003_OneWayTrip extends ProjectSpecifiedMethod{

	@BeforeTest
	public void setup() throws IOException {
		testName="OnewayTrip";
		testDescription="Testing the OneWayTrip";
		testAuthor="Ramakrishnan";
		testCategory="Smoke Testing";
		sheetName="OneWayTestData";
	}
	
	@Test(dataProvider="readData")
	public void oneWayTest(String origin,String dest,String email,String password) throws IOException {
	
		
		HomePage obj=new HomePage(driver);
		obj.enter_origin(origin)
		.enter_dest(dest)
		.select_date()
		.search_Flight()
		.pricecontinue_Btn();
		
		obj.click_login() //home page
		.enter_username(email)//login page
		.enter_password(password) //login page
		.login_button() //login page
		.validate_login();
		
//		BookingPage obj1=new BookingPage(driver);
//		obj1.enter_firstName(firstName)
//		.enter_lastName(firstName)
//		.enter_contactDetail(contact)
//		.continue_Button()	
//		.continue_Button1();
	}
}
