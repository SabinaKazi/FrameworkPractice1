package utilities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	private WebDriver driver;
	
	private WebDriverWait wait;
	
	public WaitUtils(WebDriver driver, int timeoutseconds)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutseconds));
	}
	
	//wait for visibility - 1
	public WebElement waitForVisibility(WebElement element)
	{
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	//wait for Clickable - 2
	public WebElement waitForClickability(WebElement element)
	{
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	//wait for Alert - 3
	public Alert waitForAlert()
	{
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	//wait for TitleContains - 4
	public boolean waitForTitleContains(String titlepart)
	{
		return wait.until(ExpectedConditions.titleContains(titlepart));
	}
	
		


}
