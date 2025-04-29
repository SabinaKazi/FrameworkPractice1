package Base;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigReader;

public class BaseTest {
	
	public static WebDriver driver;
	public static Logger logger;
	public static WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	@Parameters("browser")
	@BeforeClass
	public void SetUp(@Optional("chrome")String browser) throws FileNotFoundException, InterruptedException
	{
		ConfigReader.LoadProperties();
		
		//String browser = ConfigReader.getproperty("browser");
		String url = ConfigReader.getproperty("url");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		//driver = new ChromeDriver();
		//driver.get("https://www.flipkart.com/");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@AfterClass
	public void TearDown()
	{
	//	driver.close();
	}
	
	public static WebDriver getDriver() {
        return driver;
    }

}
