package Testscrpts;

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

import com.ecom.Pom.Myorderspage;
import com.ecom.Pom.UserHomePage;
import com.ecom.Pom.UserLoginPage;
import com.ecom.Pom.UserLogout;

import ciboGenriclibraries.Baseclass;
import ciboGenriclibraries.ExcelUtility;
import ciboGenriclibraries.FileUtility;
import ciboGenriclibraries.JavaUtility;
import ciboGenriclibraries.WebdriverUtility;

public class Test48 extends Baseclass
{  

	@Test(groups="System")
	public void Myorder() throws IOException, InterruptedException
	{
		
		ExcelUtility excel = new ExcelUtility();
		FileUtility File = new FileUtility();
		 JavaUtility j = new JavaUtility();
		  WebdriverUtility wb = new WebdriverUtility();
		 wb.waitForTitle(driver, "Home");
		String title = driver.getTitle();
		SoftAssert s = new SoftAssert();
		s.assertTrue(title.contains("Home"),"Home page  not is displayed");
		Reporter.log("home page is displyed");
		UserHomePage ush = new UserHomePage(driver);
		ush.getMyordersModule();
		
		
		//WebElement deleteitem = driver.findElement(By.xpath("//td[.=' 2023-05-15 14:52:35']/following-sibling::td[1]"));
		//deleteitem.click(); 
		
		
		//driver.switchTo().alert().accept();
		
		Myorderspage Myor = new Myorderspage(driver);
		List<WebElement> items = Myor.getItems();
		boolean b=false;
		for(int i=0;i<items.size();i++)
		{
			String itemsname = items.get(i).getText();
	       s.assertTrue(itemsname.contains("2023-05-15 14:52:35"),"dish is deleted");
	       Reporter.log("dish is not deleted");
	        b=true;

	       break;

		}
		
		
		Reporter.log("Testcase is pass");
	}
}
	
		
		
		
		
	
	



