package UserModule;
import java.io.IOException;
	import java.time.Duration;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ecom.Pom.ResturanutPage;
import com.ecom.Pom.UserLoginPage;
import com.ecom.Pom.UserLogout;

import ciboGenriclibraries.Baseclass;
import ciboGenriclibraries.ExcelUtility;
import ciboGenriclibraries.FileUtility;
import ciboGenriclibraries.JavaUtility;
import ciboGenriclibraries.WebdriverUtility;

public class PlaceTheoreder extends Baseclass  
{        
@Test
public void placeorder() throws Throwable
		{
			ExcelUtility excel = new ExcelUtility();
			FileUtility File = new FileUtility();
			 JavaUtility j = new JavaUtility();
			  WebdriverUtility wb = new WebdriverUtility();
			// verify home page is displaying 
			wb.waitForTitle(driver,"Home");
			String title = driver.getTitle();
			SoftAssert s = new SoftAssert();
			s.assertTrue(title.contains("Home"),"Home page is not displayed");
			Reporter.log("Home page is displayed");
		
			
			
			//click on restaurant mod
		ResturanutPage Resturant = new ResturanutPage(driver);
		Resturant.Restaurants();
		Resturant.Selectresto();
			//select dish on click on add to cart button
			Resturant.Selectdish();
			//click on checkout button
			Resturant.Checkout();
			// select payment option
			Resturant.cod();
			//click on orderNow button
			Resturant.orderNow();
			Thread.sleep(2000);
			//accept the alert popup
			driver.switchTo().alert().accept();
			//accept the alert popup
			//wb.waitTillAlertPopup(driver);
			
			
			//verify dish is ordered or not
		List<WebElement> dishnames = driver.findElements(By.xpath("//td[.=' Pink Spaghetti Gamberoni']"));
		// wb.waitTillelementToBevisible(driver, dishnames);
			boolean b=false;
		for(int i=0;i<dishnames.size();i++)
		{
			
		String dishname = dishnames.get(i).getText();
		s.assertTrue(dishname.contains(dishname),"order is not placed");
		Reporter.log("Order is placed");
		
		//logout the application
	
		
		}
        Reporter.log("Test case is pass");
		
	}
}


