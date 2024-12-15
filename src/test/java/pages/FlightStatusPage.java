package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecifiedMethod;

public class FlightStatusPage extends ProjectSpecifiedMethod {

	@FindBy(xpath = "//input[@value='Select Origin']")
	WebElement from;

	@FindBy(css = "div[data-testid='undefined-destination'] input[type='text']")
	WebElement to;

	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-1w50u8q r-ah5dr5 r-1otgn73 r-13qz1uu']")
	WebElement searchBtn;

	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1loqt21 r-13awgt0 r-1mlwlqe r-1udh08x r-1otgn73 r-1lgpqti']//img[@class='css-9pa8cd']")
	WebElement home;

	@FindBy(xpath = "//div[contains(text(),'Flight Status:')]")
	WebElement status;

	public FlightStatusPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public FlightStatusPage enter_ori(String origin) {
		from.sendKeys(origin);
		return this;
	}

	public FlightStatusPage enter_dest(String dest) {
		to.sendKeys(dest);
		return this;
	}

	public FlightStatusPage enter_searchBtn1() throws IOException {
		if (searchBtn.isEnabled())
			searchBtn.click();
		else
			System.out.println("Search button is not enabled");
		return this;
	}
	public FlightStatusPage validate_FlightStatus() throws InterruptedException, IOException {
		String expected = "Flight Status:";
		String actual = status.getText();
		visibilityOfElement(status);
		Assert.assertEquals(actual, expected);
		return this;
	}
	public HomePage click_home() throws IOException {
		takeScreenShot("5.1 FlightStatus");
		home.click();
		return new HomePage(driver);
	}

}
