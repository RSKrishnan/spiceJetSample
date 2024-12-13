package pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecifiedMethod;

public class SignUpPage extends ProjectSpecifiedMethod {

	@FindBy(xpath="//div[@class='col-sm-4 mt-2 px-sm-4']//select[contains(@class,'form-control form-select')]")
	WebElement tit;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="last_name")
	WebElement lastName;
	
	@FindBy(xpath="//input[@placeholder='+91 01234 56789']")
	WebElement contact;
	
	@FindBy(id="email_id")
	WebElement emailId;
	
	@FindBy(id="new-password")
	WebElement newPassword;
	
	@FindBy(id="c-password")
	WebElement confirmPassword;
	
	@FindBy(xpath="//input[@id='defaultCheck1']")
	WebElement termsCondition;
	
	@FindBy(xpath="//button[normalize-space()='Submit']")
	WebElement submitBtn;	
	public SignUpPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		String parentWindow=driver.getWindowHandle();
		 Set<String> windowHandles=driver.getWindowHandles();
		 Iterator<String> iterator = windowHandles.iterator();
		 while(iterator.hasNext())
		 {
			 String next=iterator.next();
			 if(!parentWindow.equals(next))
				 driver.switchTo().window(next);
		 }
	}
	public SignUpPage enter_title(String title) {
		tit.sendKeys(title);
		return this;
	}	
	public SignUpPage enter_firstName(String FName) {
		firstName.sendKeys(FName);
		return this;
	}	
	public SignUpPage enter_lastName(String LName) {
		lastName.sendKeys(LName);
		return this;
	}	
	public SignUpPage enter_contact(String cont) {
		contact.sendKeys(cont);
		return this;
	}	
	public SignUpPage enter_emailId(String email) {
		emailId.sendKeys(email);
		return this;
	}	
	public SignUpPage enter_newPassword(String nPassword) {
		newPassword.sendKeys(nPassword);
		return this;
	}	
	public SignUpPage enter_confirmPassword(String cPassword) {
		confirmPassword.sendKeys(cPassword);
		return this;
	}	
	public SignUpPage enter_termsCondition() {
		//need to validate whether the check box is enabled or not
		if (termsCondition.isEnabled()) {
			termsCondition.click();
		} else {
			System.out.println("Terms and condition is not clickable");
		}
		return this;
	}	
	public HomePage enter_submitBtn() throws IOException {
		submitBtn.click();
		driver.close();
		return new HomePage(driver);
	}
}
