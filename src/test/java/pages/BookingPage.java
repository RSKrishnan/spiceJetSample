package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecifiedMethod;

public class BookingPage extends ProjectSpecifiedMethod {

	@FindBy(xpath="//div[normalize-space()='Hi Test']")
	WebElement account;
	
	@FindBy(xpath = "(//*[contains(text(),'Login')])[2]")
	WebElement loginBtn;

	@FindBy(xpath = "//input[@type='number']")
	WebElement uNam;

	@FindBy(xpath = "//input[@type='password']")
	WebElement Word;

	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-184aecr r-z2wwpe r-1loqt21 r-18u37iz r-tmtnm0 r-1777fci r-1x0uki6 r-1w50u8q r-ah5dr5 r-1otgn73']")
	WebElement login;

	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep r-19h5ruw']//div[@class='css-1dbjc4n r-zso239']")
	WebElement primaryPax;

	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-6ity3w r-d9fdf6 r-9qu9m4 r-ah5dr5 r-1otgn73']")
	WebElement continueBtn;

	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-6ity3w r-d9fdf6 r-9qu9m4 r-ah5dr5 r-1otgn73']")
	WebElement continueBtn1;

	@FindBy(xpath = "//*[text()='Trip Summary']")
	WebElement tripText;

	@FindBy(xpath="//div[@class='css-1dbjc4n r-1awozwy r-1xfd6ze r-1loqt21 r-18u37iz r-1777fci r-1w50u8q r-ah5dr5 r-1otgn73']")
	 WebElement priceContinueBtn;
	
	public BookingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public BookingPage click_loginBtn() {
		visibilityOfElement(priceContinueBtn);
		loginBtn.click();
		return this;
	}

	public BookingPage enter_uName(String uName) {
		uNam.sendKeys(uName);
		return this;
	}

	public BookingPage enter_pWord(String pWord) {
		Word.sendKeys(pWord);
		return this;
	}

	public BookingPage click_login() {
		login.click();
		visibilityOfElement(priceContinueBtn);
		return this;
	}
	
	public BookingPage validate_login() throws IOException {
		String actual ="Hi Test";
		String expected=account.getText();
		Assert.assertEquals(actual, expected);
		return this;
	}
	
	public BookingPage click_primaryPax() {
		primaryPax.click();
		return this;
	}

	public BookingPage continue_Button() {
		continueBtn.click();
		return this;
	}

	public PaymentPage continue_Button1() {
		visibilityOfElement(tripText);
		scrollDown(continueBtn1);
		continueBtn1.click();
		return new PaymentPage(driver);
	}
	
	public BookingPage pricecontinue_Btn() throws IOException {
		takeScreenShot("Flight Booking");
		priceContinueBtn.click();
		return this;
	}	
}
