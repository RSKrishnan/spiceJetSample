package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecifiedMethod;
import pages.HomePage;

public class TC004_CheckIn extends ProjectSpecifiedMethod {

	@BeforeTest
	public void setup() throws IOException {
	//	readFromPropFile("browser&URL");
		
		testName="checkIN";
		testDescription="Testing the login functionality with positive and negative cases";
		testAuthor="Ramakrishnan";
		testCategory="Smoke Testing";
		
		sheetName="checkINTestData";
	}
	
	@Test(dataProvider="readData", groups = {"Smoke"})
	public void checkIN(String ticket,String mailId) {
		HomePage obj=new HomePage(driver);
		obj.click_checkIn()
		.enter_ticketNumber(ticket)
		.enter_emailId(mailId)
		.enter_searchBtn()
		.validate_Checkin();
	}


	
	
}
