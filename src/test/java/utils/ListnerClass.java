package utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.ProjectSpecifiedMethod;

public class ListnerClass extends ProjectSpecifiedMethod implements ITestListener {


	public void onFinish(ITestContext context) {
	}

	public void onStart(ITestContext context) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestStart(ITestResult result) {
	}

	public void onTestSuccess(ITestResult result) {
	}

	public void onTestFailure(ITestResult res) {
		if (res.getStatus() == ITestResult.FAILURE)
		{
		
			test.fail(res.getThrowable());
			String filepath = null;
			try {
				filepath = takeScreenShot(res.getMethod().getMethodName());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			test.addScreenCaptureFromPath(filepath, res.getMethod().getMethodName());
		}	
	}
}
