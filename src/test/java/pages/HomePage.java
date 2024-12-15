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
	
	@FindBy(xpath="//body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]/div[3]/div[1]/div[3]/div[3]/div[4]/div[1]/div[1]")
	WebElement date;
	
	@FindBy(xpath="//body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]/div[3]/div[1]/div[3]/div[3]/div[5]/div[1]")
	WebElement returndate;
	
	@FindBy(xpath="//div[@class='css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-1g94qm0 r-1w50u8q r-ah5dr5 r-1otgn73']")
	 WebElement searchFlight;
	
	@FindBy(xpath="//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1ozqkpa'][normalize-space()='check-in']")
	WebElement checkIn;
	
	@FindBy(xpath="//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1ozqkpa'][normalize-space()='flight status']")
	WebElement flightStatus;
	
	@FindBy(xpath="//*[text()='manage booking']")
	WebElement manageBook;
	
	@FindBy(xpath="//body/div[@id='react-root']/div[@id='main-container']/div[@class='css-1dbjc4n r-1niwhzg r-1jgb5lz r-r0h9e2 r-13qz1uu']/div[@class='css-1dbjc4n r-14lw9ot']/div[@class='css-1dbjc4n r-14lw9ot r-z2wwpe r-vgw6uq r-156q2ks r-11ict49 r-8uuktl r-136ojw6']/div[@class='css-1dbjc4n r-1pcd2l5 r-1uwte3a r-m611by r-bnwqim']/div[@class='css-1dbjc4n']/div[@class='css-1dbjc4n']/div[@class='css-1dbjc4n r-1d09ksm r-1inuy60 r-1qxgc49']/div[@class='css-1dbjc4n']/div[@class='css-1dbjc4n r-18u37iz r-1w6e6rj']/div[2]")
	WebElement roundTrip;
	
	public HomePage(WebDriver driver) throws IOException {
		takeScreenShot("1.Homepage");
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public LoginPage click_login() throws IOException {
		
		login.click();
		return new LoginPage(driver);
	}	
	public SignUpPage click_sign()
	{
		signUp.click();
		return new SignUpPage(driver);		
	}
	public void validate_login() throws IOException {
		String actual ="Hi Test";
		String expected=account.getText();
		Assert.assertEquals(actual, expected);
		takeScreenShot("2.LoginPage");
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

	public BookingPage search_Flight() throws IOException {
		takeScreenShot("Booking flight");
		searchFlight.click();
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
	
	public HomePage click_roundTrip() {
		roundTrip.click();
		return this;
	}
	public HomePage select_returndate() {
		returndate.click();
		return this;
	}
}
