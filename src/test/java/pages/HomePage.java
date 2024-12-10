package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecifiedMethod;

public class HomePage extends ProjectSpecifiedMethod {

	@FindBy(xpath="//div[contains(text(),'Login')]")
	WebElement login;
	
	@FindBy(xpath="//div[normalize-space()='Hi Test']")
	WebElement account;
	
	@FindBy(xpath="//div[contains(text(),'Signup')]")
	WebElement signUp;
	//oneway search
	@FindBy(xpath="//div[@data-testid='to-testID-origin']//input[@type='text']")
	WebElement origin;
	
	@FindBy(xpath="//div[@data-testid='to-testID-destination']//input[@type='text']")
	WebElement dest;
	
	@FindBy(css="div[class='css-1dbjc4n r-1euycsn'] div:nth-child(3) div:nth-child(1) div:nth-child(3) div:nth-child(3) div:nth-child(7) div:nth-child(1) div:nth-child(1)")
	WebElement date;
	
	@FindBy(xpath="//div[@class='css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-1g94qm0 r-1w50u8q r-ah5dr5 r-1otgn73']")
	 WebElement searchFlight;
	
	@FindBy(xpath="//div[@class='css-1dbjc4n r-1awozwy r-1xfd6ze r-1loqt21 r-18u37iz r-1777fci r-1w50u8q r-ah5dr5 r-1otgn73']")
	 WebElement priceContinueBtn;
	
	@FindBy(xpath="//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1ozqkpa'][normalize-space()='check-in']")
	WebElement checkIn;
	
	@FindBy(xpath="//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1ozqkpa'][normalize-space()='flight status']")
	WebElement flightStatus;
	
	@FindBy(xpath="//*[text()='manage booking']")
	WebElement manageBook;
	
	
	
	public HomePage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public LoginPage click_login() throws IOException {
		takeScreenShot("1.Homepage.jpg");
		login.click();
		return new LoginPage(driver);
	}	
	public SignUpPage click_sign()
	{
		signUp.click();
		return new SignUpPage(driver);		
	}
	public void validate_login() {
		String actual ="Hi Test";
		String expected=account.getText();
		Assert.assertEquals(actual, expected);
	}	
	public HomePage enter_origin(String org) {
		origin.sendKeys(org);
		return this;
	}	
	public HomePage enter_dest(String des) {
		dest.sendKeys(des);
		return this;
	}	
	public HomePage select_date() {
		date.click();
		return this;
	}	
	public HomePage search_Flight() {
		searchFlight.click();
		return this;
	}	
	public BookingPage pricecontinue_Btn() {
		priceContinueBtn.click();
		return new BookingPage(driver);
	}	
	public CheckInPage click_checkIn()
	{
		checkIn.click();
		return new CheckInPage(driver);		
	}	
	public FlightStatusPage click_flightStatus()
	{
		flightStatus.click();
		return new FlightStatusPage(driver);		
	}
	
	public ManageBookingPage click_manageBooking()
	{
		manageBook.click();
		return new ManageBookingPage(driver);		
	}
	
}
