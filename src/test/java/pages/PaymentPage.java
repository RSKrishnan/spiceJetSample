package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecifiedMethod;

public class PaymentPage extends ProjectSpecifiedMethod{

//	@FindBy(xpath="//div[@class='css-1dbjc4n r-18u37iz r-1n0xq6e r-u8s1d r-184en5c']")
//	public static WebElement cardNumberTxtBox;
//	
//	@FindBy(xpath="//div[@class='css-1dbjc4n r-1awozwy r-un1frt r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-6ity3w r-9qu9m4 r-ah5dr5 r-1otgn73']")
//	public static WebElement proceedToPayBtn;
//	
//	@FindBy(xpath="//iframe[@name='card_number_iframe_wRN0N66Ce6Tfog4u']")
//	public static WebElement cardNameTxtBox;
//	
//	@FindBy(xpath="//iframe[@name='card_number_iframe_wRN0N66Ce6Tfog4u']")
//	public static WebElement expMTxtBox;
//	
//	@FindBy(id="card_exp_year")
//	public static WebElement expYTxtBox;
//	
//	@FindBy(id="security_code")
//	public static WebElement codeTxtBox;
	
	public PaymentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
