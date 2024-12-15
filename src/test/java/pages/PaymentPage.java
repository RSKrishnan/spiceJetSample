package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecifiedMethod;

public class PaymentPage extends ProjectSpecifiedMethod {

	@FindBy(xpath = "(//*[starts-with(text(),'UPI')])[1]")
	WebElement upiOption;

	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-un1frt r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-6ity3w r-d9fdf6 r-9qu9m4 r-ah5dr5 r-1otgn73']")
	WebElement pay;

	
	@FindBy(xpath = "//div[@class='css-76zvg2 r-homxoj r-poiln3 r-1i10wst r-1kfrs79 r-glunga']")
	WebElement scanToPay;

	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public PaymentPage click_upiOption() {
		visibilityOfElement(upiOption);
		upiOption.click();
		return this;
	}

	public PaymentPage click_Payment() {
		visibilityOfElement(pay);
		scrollDown(pay);
		pay.click();
		return this;
	}

	public PaymentPage validate_login() throws IOException {
		String actual = "Scan QR Code to Pay";
		String expected = scanToPay.getText();
		Assert.assertEquals(actual, expected);
		takeScreenShot("QR Code");
		return this;
	}

}
