package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import base.ProjectSpecifiedMethod;

public class ListnerClass extends ProjectSpecifiedMethod implements ITestListener {

//	public void onTestSuccess(ITestResult result) {
//		// TODO Auto-generated method stub
//		test.log(Status.PASS,"Test passed");
//	}
	
	public void onTestFailure(ITestResult res) {
		if (res.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, res.getThrowable());
			TakesScreenshot tk=(TakesScreenshot)driver;
			File screenshotAs = tk.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(screenshotAs, new File("C:\\Automation\\MvnProject\\ScreenShots\\failed.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath("C:\\Automation\\MvnProject\\ScreenShots\\failed.png").build());
	}	
	}
}
