package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecifiedMethod;

public class BookingPage extends ProjectSpecifiedMethod{

	@FindBy(xpath="//div[@class='css-1dbjc4n r-vlx1xi r-5360zw']//input[@type='text']")
	WebElement firstName;
	
	@FindBy(xpath="//div[@class='css-1dbjc4n r-mvpalk r-5360zw']//input[@type='text']")
	WebElement lastName;
		
	@FindBy(xpath="//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-6ity3w r-d9fdf6 r-9qu9m4 r-ah5dr5 r-1otgn73']")
	WebElement continueBtn;
	
	@FindBy(xpath="//div[@class='css-1dbjc4n r-18u37iz r-1hfyk0a']//input[@type='text']")
	WebElement contactDetail;
	
	@FindBy(xpath="(//*[text()='Continue'])[1]")
	WebElement continueBtn1;
	
	@FindBy(xpath="//*[text()='Trip Summary']")
	WebElement tripText;
	
	
	
	public BookingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
//	
//	public BookingPage enter_AboutBtn() {
//	AboutBtn.click();
//	return this;
//}
	public BookingPage enter_firstName(String fName) {
		firstName.sendKeys(fName);
		return this;
	}	
	public BookingPage enter_lastName(String lName) {
		lastName.sendKeys(lName);
		return this;
	}	
	public BookingPage enter_contactDetail(String cont) {
		contactDetail.sendKeys(cont);
		return this;
	}	
	public BookingPage continue_Button() {
		continueBtn.click();
		visibilityOfElement(tripText);
		return this;
	}	
	public PaymentPage continue_Button1() {
		continueBtn1.click();
		return new PaymentPage(driver);
	}
}
