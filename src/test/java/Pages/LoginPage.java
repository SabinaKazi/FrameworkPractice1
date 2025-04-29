package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.WaitUtils;

public class LoginPage {
	
	WebDriver driver;
	WaitUtils wait;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WaitUtils(driver,10);
	}
	
	@FindBy(xpath = "//a[@class='_1jKL3b']")
	WebElement login_tooltip;
	
	@FindBy(xpath = "//span[normalize-space()='Login']")
	WebElement loginbtn;
	
	@FindBy(xpath = "//span[@class='_1Mikcj']")
	WebElement signup_btn;
	
	@FindBy(xpath = "//input[@class='r4vIwl BV+Dqf']")
	WebElement Monumber_field;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement continue_btn;
	
	public void VerifyLoginfunctionality()
	{
		//WebElement tooltip = driver.findElement(By.cssSelector(".tooltip-class"));

		if(login_tooltip.isDisplayed())
		{
			login_tooltip.click();
		}
		else
		{
			Actions act = new Actions(driver);
			act.moveToElement(loginbtn);
		}
		/*
        if (tooltip.isDisplayed()) {
            WebElement tooltipElement = driver.findElement(By.id("tooltip-element-id"));
            tooltipElement.click();
        } else {
            throw new NoSuchElementException("Tooltip not visible");
        }
        */
	}
	
	/*
	public void HoverOnLoginButton()
	{
		Actions act = new Actions(driver);
		act.moveToElement(loginbtn);
		//wait.waitForVisibility(loginbtn);
		
	}
	*/
	
	public void ClickSignupButton()
	{
		
		signup_btn.click();
		//wait.waitForClickability(signup_btn);
	}
	
	
	public void EnterMobileNumber(String monum)
	{
		Monumber_field.sendKeys(monum);
		//Monumber_field.
		
	}
	
	public void ClickContinueButton()
	{
		continue_btn.click();
		//wait.waitForClickability(continue_btn);
	}
	
	
	
	

}
