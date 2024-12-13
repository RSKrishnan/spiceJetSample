package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecifiedMethod;
import pages.HomePage;

public class TC006_ManageBooking extends ProjectSpecifiedMethod {

	@BeforeTest
	public void setup() throws IOException {
	//	browserLaunch();		
		testName="ManageBooking";
		testDescription="Testing the ManageBooking functionality";
		testAuthor="Ramakrishnan";
		testCategory="Smoke Testing";
		
		sheetName="ManageBookingTestData";
	}
	
	@Test(dataProvider="readData")
	public void manageBooking(String ticket,String lastName) throws IOException, InterruptedException {
		HomePage obj=new HomePage(driver);
		obj.click_manageBooking()
		.enter_ticketNum(ticket)
		.enter_lastNa(lastName)
		.enter_searchBooking();
	}
}
