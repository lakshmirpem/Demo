package ciboGenriclibraries;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener
{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) 
	{
		 String testname = result.getMethod().getMethodName();
		 System.out.println("I'm listening");
		 TakesScreenshot tss = (TakesScreenshot)Baseclass.driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		LocalDateTime localdatetime = LocalDateTime.now();
		String cdate = localdatetime.toString().replace(" ", "_").replace(":", "_");
		File dst=new File("screenshot/"+""+testname+""+cdate+".png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	
	}

}
