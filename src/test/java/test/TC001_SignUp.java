package test;

import org.testng.annotations.Test;

import base.ProjectSpecifiedMethod;
import pages.HomePage;

public class TC001_SignUp extends ProjectSpecifiedMethod {

	@Test
	public void signUpTest() {
		
		HomePage obj=new HomePage(driver);
		obj.click_sign()
		.enter_title("MR")
		.enter_firstName("Ram")
		.enter_lastName("test")
		.enter_contact("9999999999")
		.enter_emailId("testExample@example.com")
		.enter_newPassword("TestExample@123")
		.enter_confirmPassword("TestExample@123")
		//need to scroll down
		.enter_termsCondition()
		.enter_submitBtn();
	}
}
