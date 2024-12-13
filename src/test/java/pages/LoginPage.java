package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.ProjectSpecifiedMethod;

public class LoginPage extends ProjectSpecifiedMethod {
	@FindBy(xpath="//input[@data-testid='user-mobileno-input-box']")
	WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="(//div[@class='css-1dbjc4n r-1awozwy r-184aecr r-z2wwpe r-1loqt21 r-18u37iz r-tmtnm0 r-1777fci r-1x0uki6 r-1w50u8q r-ah5dr5 r-1otgn73'])[1]")
	WebElement loginBtn;
	
	@FindBy(xpath="//div[@class='css-1dbjc4n r-18u37iz r-1wtj0ep r-184en5c']//div[@class='css-1dbjc4n r-1loqt21 r-1otgn73']//*[name()='svg']//*[name()='g' and contains(@fill-rule,'evenodd')]//*[name()='path' and contains(@fill,'#000')]")
	WebElement cancel;
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	public LoginPage enter_username(String contactNumber) {
		username.sendKeys(contactNumber);
		return this;
	}
	public LoginPage enter_password(String psw) {
		password.sendKeys(psw);
		return this;
	}
	public HomePage login_button() throws IOException {
		
		loginBtn.click();
		if(loginBtn.isDisplayed())
		{
			cancel.click();
		}
		return new HomePage(driver);
	}	
}
