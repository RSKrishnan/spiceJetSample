package utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class UtilityClass {
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports extent;
	public static ExtentTest test;
	public String testName, testDescription, testCategory, testAuthor;
	public String sheetName;
	
	public void browserLaunch() {		
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (prop.getProperty("browser").equalsIgnoreCase("headless-Chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--headless");
			driver = new ChromeDriver(option);
		}

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void browser_Close() {
		driver.close();
	}

	public void takeScreenShot(String name) throws IOException {
		File sc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sc, new File("C:\\Automation\\SpicyJetSample\\Snap\\" + name));
	}

	public void visibilityOfElement(WebElement els) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(els));
	}

	public static void readFromPropFile(String fileName) throws IOException {

		FileReader file = new FileReader("C:\\Automation\\SpicyJetSample\\src\\test\\resources\\testData\\"+ fileName + ".properties");
		prop = new Properties();
		prop.load(file);
	}
	
	public static String[][] readExcel(String sheetname) throws IOException {
		XSSFWorkbook book=new XSSFWorkbook("C:\\Automation\\SpicyJetSample\\src\\test\\resources\\testData\\SpicejetTestData.xlsx");
		XSSFSheet sheet= book.getSheet(sheetname);
		int rowCount = sheet.getLastRowNum();
		short colCount = sheet.getRow(0).getLastCellNum();
		
		String[][] data =new String[rowCount][colCount];
		for(int i=1;i<=rowCount;i++)
		{
			XSSFRow row=sheet.getRow(i);
			for(int j=0;j<colCount;j++)
			{
				XSSFCell cell=row.getCell(j);
				data[i-1][j]=cell.getStringCellValue();
			}
		}
		book.close();
		return data;
	}
}
