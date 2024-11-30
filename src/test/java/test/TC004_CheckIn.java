package test;

import org.testng.annotations.Test;

import base.ProjectSpecifiedMethod;
import pages.HomePage;

public class TC004_CheckIn extends ProjectSpecifiedMethod {

	@Test
	public void checkIN() {
		HomePage obj=new HomePage(driver);
		obj.click_checkIn()
		.enter_ticketNumber()
		.enter_emailId()
		.enter_searchBtn()
		.validate_Checkin();
	}


	
	
}
