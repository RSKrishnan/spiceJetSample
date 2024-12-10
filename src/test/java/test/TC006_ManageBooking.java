package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecifiedMethod;
import pages.HomePage;

public class TC006_ManageBooking extends ProjectSpecifiedMethod {

	@BeforeTest
	public void setup() throws IOException {
	//	readFromPropFile("browser&URL");
		
		testName="ManageBooking";
		testDescription="Testing the login functionality with positive and negative cases";
		testAuthor="Ramakrishnan";
		testCategory="Smoke Testing";
		
		sheetName="ManageBookingTestData";
	}
	
	@Test(dataProvider="readData", groups = {"Smoke"})
	public void manageBooking(String ticket,String lastName) throws IOException, InterruptedException {
		HomePage obj=new HomePage(driver);
		obj.click_manageBooking()
		.enter_ticketNum(ticket)
		.enter_lastNa(lastName)
		.enter_searchBooking();
	}
}
