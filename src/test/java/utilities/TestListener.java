package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Base.BaseTest;

public class TestListener extends BaseTest implements ITestListener {
	
	
	
	 @Override
	    public void onTestFailure(ITestResult result) {
	        WebDriver driver = getDriver(); // from BaseTest
	        String testName = result.getName();

	        String screenshotPath = ScreenshotUtils.takeScreenshot(driver, testName);
	        System.out.println("Screenshot saved at: " + screenshotPath);
	    }

}
