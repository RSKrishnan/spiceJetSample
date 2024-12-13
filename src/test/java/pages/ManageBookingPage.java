package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecifiedMethod;

public class ManageBookingPage extends ProjectSpecifiedMethod {

	@FindBy(xpath = "//input[@placeholder='e.g. W3X3H8']")
	WebElement ticketNum;

	@FindBy(xpath = "//input[@placeholder='john.doe@spicejet.com / Doe']")
	WebElement lastNa;

	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1pcd2l5 r-1uwte3a']//div[3]")
	WebElement srBook;

	@FindBy(xpath = "//*[.='Invalid PNR or Ticket Number']")
	WebElement invalidText;
	
	public ManageBookingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ManageBookingPage enter_ticketNum(String ticket) {
		ticketNum.sendKeys(ticket);
		return this;
	}

	public ManageBookingPage enter_lastNa(String lastName) {
		lastNa.sendKeys(lastName);
		return this;
	}
	//need to use explict wait 
	public ManageBookingPage enter_searchBooking() throws IOException, InterruptedException {
		takeScreenShot("6.ManageBooking");
		srBook.click();
		visibilityOfElement(invalidText);
		return this;
	}

	public void validate_FlightStatus() throws InterruptedException {
		String expected = "Invalid PNR or Ticket Number";
		String actual = invalidText.getText();
		Assert.assertEquals(actual, expected);
	}

}
