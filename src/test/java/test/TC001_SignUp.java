package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecifiedMethod;
import pages.HomePage;

public class TC001_SignUp extends ProjectSpecifiedMethod {

	@BeforeTest
	public void setup() throws IOException {
		testName="SignUpTest";
		testDescription="Testing the SignUp functionality";
		testAuthor="Ramakrishnan";
		testCategory="Regression Testing";
		sheetName="SignUpTestData";
	}
	
	@Test(dataProvider="readData")
	public void signUpTest(String title,String firstName,String lastName,String contact,String emailID,String newpass,String conf) throws IOException {
		
		HomePage obj=new HomePage(driver);
		obj.click_sign()
		.enter_title(title)
		.enter_firstName(firstName)
		.enter_lastName(lastName)
		.enter_contact(contact)
		.enter_emailId(emailID)
		.enter_newPassword(newpass)
		.enter_confirmPassword(conf)
		.enter_termsCondition()
		.enter_submitBtn();
	}
}
