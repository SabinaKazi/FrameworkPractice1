package Pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
	@FindBy(xpath= "//input[@class='Pke_EE']")
	WebElement search_box;
	
	@FindBy(xpath="//span[@role=\"button\"]")
	WebElement closelogin_button;
	
//	@FindBy(xpath = "//button[@title='Search for Products, Brands and More']//*[name()='svg']")
//	WebElement search_icon;
	
	public void SearchProduct(String productname)
	{
		search_box.sendKeys(productname+ Keys.ENTER);
	}
	
	public void CloseLoginpopup()
	{
		try {
            if (closelogin_button.isDisplayed()) {
            	closelogin_button.click();
                System.out.println("Popup appeared and was closed.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("No popup appeared.");
        }
	
	}
	
	
}
