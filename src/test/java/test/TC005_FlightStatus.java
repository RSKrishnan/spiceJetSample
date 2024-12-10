package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecifiedMethod;
import pages.HomePage;

public class TC005_FlightStatus extends ProjectSpecifiedMethod{

	@BeforeTest
	public void setup() throws IOException {
		//readFromPropFile("browser&URL");
		
		testName="FlightStatus";
		testDescription="Testing the FlightStatus functionality";
		testAuthor="Ramakrishnan";
		testCategory="Smoke Testing";
		
		sheetName="FlightStatusTestData";
	}
	
	@Test(dataProvider="readData")
	public void flightStatus(String origin,String dest) throws IOException, InterruptedException {
	HomePage obj=new HomePage(driver);
	obj.click_flightStatus()
	.enter_ori(origin)
	.enter_dest(dest)
	.enter_searchBtn1()
	.validate_FlightStatus()
	.click_home();
	}
}
