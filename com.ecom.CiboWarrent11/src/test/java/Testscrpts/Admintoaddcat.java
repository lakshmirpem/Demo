package Testscrpts;






import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
//TC_18
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ecom.Pom.AdminHomepage;
import com.ecom.Pom.Adminlogout;
import com.ecom.Pom.addcategory;

import ciboGenriclibraries.Baseclass;
import ciboGenriclibraries.ExcelUtility;
import ciboGenriclibraries.FileUtility;
import ciboGenriclibraries.JavaUtility;
import ciboGenriclibraries.WebdriverUtility;
@Listeners(ciboGenriclibraries.Listeners.class)
public class Admintoaddcat extends Baseclass 
{
@Test (retryAnalyzer=ciboGenriclibraries.Retryanlazer1.class)        // (groups="Integration")
public void addcattestng()throws Throwable, Throwable
	{
		ExcelUtility excel = new ExcelUtility();
		FileUtility File = new FileUtility();
		 JavaUtility j = new JavaUtility();
		  WebdriverUtility wb = new WebdriverUtility();
		  
	
		
		
		wb.waitForTitle(driver, "Panel");
		String title = driver.getTitle();
		SoftAssert s = new SoftAssert();
		s.assertTrue(title.contains("Panel"),"Admin home page is not displayed");
		Reporter.log("Admin home page is displayed");
		Thread.sleep(2000);
		// click on the restaurant to see submodules
		AdminHomepage adminhome = new AdminHomepage(driver);
		adminhome.ResturantModule1();
		s.fail();
		Thread.sleep(2000);
		adminhome.selectaddcat();
		// click on Add category
		addcategory addcat = new addcategory(driver);
		Thread.sleep(2000);
		String categoryName = excel.getdata("Sheet1", 1, 0);
		addcat.getAddcat(categoryName).click();
		
		
		// Click on Save button
		Thread.sleep(2000);
		addcat.getSavebtn();

		// Verify The added category is displayed inListed categories or not
		List<WebElement> list = addcat.getListedCategoryNames();
		boolean ck = false;
		for (int i=0;i<list.size();i++) 
		{
			String cName = list.get(i).getText();
			
			excel.insertdata("Sheet1", i, 0, cName);
			s.assertTrue(cName.contains(categoryName),"The added category is not added");
			Reporter.log("The added category is added");
				ck = true;
				break;
			
			}
		s.assertAll();
			Reporter.log("Test case is pass");

		
		// logout from the Application
		
	}

}





















