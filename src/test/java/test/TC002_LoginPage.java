package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecifiedMethod;
import pages.HomePage;

public class TC002_LoginPage extends ProjectSpecifiedMethod {

	@BeforeTest
	public void setup() throws IOException {
		readFromPropFile("browser&URL");
		
		testName="LoginTest";
		testDescription="Testing the login functionality with positive and negative cases";
		testAuthor="Ramakrishnan";
		testCategory="Smoke Testing";
		
		sheetName="LoginTestData";
	}
	
	@Test(dataProvider="readData")
	public void loginTest(String email,String password) throws IOException {	
		
		HomePage obj=new HomePage(driver);
		obj.click_login() //home page
		.enter_username(email)//login page
		.enter_password(password) //login page
		.login_button() //login page
		.validate_login();  //home page
	}
	
	
}
