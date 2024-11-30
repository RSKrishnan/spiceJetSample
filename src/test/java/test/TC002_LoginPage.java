package test;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.Test;

import base.ProjectSpecifiedMethod;
import pages.HomePage;

public class TC002_LoginPage extends ProjectSpecifiedMethod {

	@Test()
	public void loginTest() throws IOException {	
		HomePage obj=new HomePage(driver);
		obj.click_login() //home page
		.enter_username("9967795789")//login page
		.enter_password("TestExample@1234") //login page
		.login_button() //login page
		.validate_login();  //home page
		
	}
}
