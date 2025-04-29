package testCases;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.LoginPage;
import utilities.ConfigReader;
import utilities.Logs;

public class TC001_LoginTest extends BaseTest{
	
	//WebDriver driver;
	
	

	@Test
	public void VerifyLoginPage() throws InterruptedException, FileNotFoundException
	{
	
		ConfigReader.LoadProperties();
		String monum = ConfigReader.getproperty("monum");
		
		//Create object of login page to call action methods
		LoginPage lp = new LoginPage(driver);
		
		//Thread.sleep(3000);
		//hover to login button
		Logs.info("Hover to login button");
		lp.VerifyLoginfunctionality();
		
		//clicks on signup button
	//	Logs.info("Click on signup button");
		//lp.ClickSignupButton();
		
		//Enter mobile number in field
		Logs.info("Entered mobile number");
		lp.EnterMobileNumber("8999057894");
		Thread.sleep(5000);
		//clicks on continue button
		
		Logs.info("Clicked on continue button");
		lp.ClickContinueButton();
		
		/*
		WebElement loginbtn = driver.findElement(By.xpath("//span[normalize-space()='Login']"));
		
		Actions act = new Actions(driver);
		
		//move cursor to login btn
		act.moveToElement(loginbtn).perform();
		
		//click on signup btn
		WebElement signup_btn = driver.findElement(By.xpath("//span[@class='_1Mikcj']"));
		signup_btn.click();
		
		String signup_title =  driver.getTitle();
		System.out.println(signup_title);
		//Verify signup page open or not
	
		
		Assert.assertEquals("Online Shopping India | Buy Mobiles, Electronics, Appliances, Clothing and More Online at Flipkart.com", signup_title);
	
		
		//ENter mobile number
		WebElement Monumber_field = driver.findElement(By.xpath("//input[@class='r4vIwl BV+Dqf']"));
		Monumber_field.sendKeys("8999057894");
		
		//click on continue
		WebElement continue_btn = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		continue_btn.click();
		
		*/
		
		
		
		
		
	}
	
	
	
	
	

}
