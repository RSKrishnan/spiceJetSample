package test;

import java.io.IOException;

import org.testng.annotations.Test;

import base.ProjectSpecifiedMethod;
import pages.BookingPage;
import pages.HomePage;
import pages.LoginPage;
import test.*;

public class TC003_OneWayTrip extends ProjectSpecifiedMethod{

	@Test
	public void oneWayTest() throws IOException {
	
		
		HomePage obj=new HomePage(driver);
		obj.click_login();
		obj.enter_origin("DEL")
		.enter_dest("MAA")
		.select_date()
		.search_Flight()
		.pricecontinue_Btn();
		
		BookingPage obj1=new BookingPage(driver);
		obj1.enter_firstName("test")
		.enter_lastName("test1")
		.enter_contactDetail("9878987894")
		.continue_Button()		.continue_Button1();
	}
}
