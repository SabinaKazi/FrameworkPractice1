package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.HomePage;
import utilities.ExcelReader;

public class TC002_FlipKartSearchDDT extends BaseTest {
	
	 @Test(dataProvider = "searchData")
	    public void testSearchProduct(String productName) throws InterruptedException {
	        HomePage home = new HomePage(driver);
	        home.SearchProduct(productName);
	        Thread.sleep(2000);
	        
	     // Assertion - Check title contains product name
	        assert driver.getTitle().toLowerCase().contains(productName.toLowerCase()) 
	            : "Search failed for product: " + productName;
	        
	        driver.navigate().back();
	        home.CloseLoginpopup();
	      
	       // home.clickonsearch();
	     
	    }

	    @DataProvider(name = "searchData")
	    public Object[][] getData() {
	       return ExcelReader.getData(System.getProperty("user.dir")+"/src/test/resources/testData/SearchData.xlsx", "Sheet2");
	    }

}
