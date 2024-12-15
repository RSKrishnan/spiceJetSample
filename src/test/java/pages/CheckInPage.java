package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecifiedMethod;

public class CheckInPage extends ProjectSpecifiedMethod{

	@FindBy(xpath="//input[@placeholder='e.g. W3X3H8']")
	WebElement ticketNumber;
	
	@FindBy(xpath="//input[@placeholder='john.doe@spicejet.com']")
	WebElement emailId;
	
	@FindBy(xpath="//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-1w50u8q r-ah5dr5 r-1otgn73 r-13qz1uu']")
	WebElement searchBtn;
	
	@FindBy(xpath="//div[@class='css-76zvg2 r-1ttbpl1 r-1enofrn r-1bymd8e']")
	WebElement msg;
	public CheckInPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
     public CheckInPage enter_ticketNumber(String ticket) {
		ticketNumber.sendKeys(ticket);
		return this;
	}
     public CheckInPage enter_emailId(String mailid) {
    	 emailId.sendKeys(mailid);
 		return this;
 	}
     public CheckInPage enter_searchBtn() {
    	 searchBtn.click();
 		return this;
 	}
     
     public void validate_Checkin() throws IOException {
    	  String actual=msg.getText();
    		String expected ="Invalid PNR or Ticket Number";
    		takeScreenShot("4.CheckInPage");
    	     Assert.assertEquals(actual, expected);
	}
   
     


}
