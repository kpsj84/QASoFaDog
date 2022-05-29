package Resources;

import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.IOException;

import SoFaDog.AndroidAutomation.Base;

public class Listeners implements ITestListener {
	
	@Override
	public void onTestStart(ITestResult result) {
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		String s = result.getName();
		try {
			Base.getScreenshot(s);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	
	@Override
	public void onStart(ITestContext context) {
		
	}
	
	@Override
	public void onFinish(ITestContext context) {
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
}
