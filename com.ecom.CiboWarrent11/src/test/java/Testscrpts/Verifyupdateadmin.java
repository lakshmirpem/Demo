package Testscrpts;


import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ecom.Pom.AdminHomepage;
import com.ecom.Pom.AdminLoginPage;
import com.ecom.Pom.Orderssadmin;

import ciboGenriclibraries.Baseclass;
import ciboGenriclibraries.ExcelUtility;
import ciboGenriclibraries.FileUtility;
import ciboGenriclibraries.JavaUtility;
import ciboGenriclibraries.WebdriverUtility;
public class Verifyupdateadmin extends Baseclass
{
	@Test (retryAnalyzer=ciboGenriclibraries.Retryanlazer1.class) //(groups={"System","Integration"})

	public void verifyuser() throws Throwable 
	{
		
		// verify whether adminPanel page is Displayed or not
		wb.waitForTitle(driver, "Panel");
		String title = driver.getTitle();
		SoftAssert s = new SoftAssert();
		s.assertTrue(title.contains("Panel"),"Admin home page is not displayed");
		Reporter.log("Admin home page is displayed");
		// click on the orders module
		Thread.sleep(2000);
		AdminHomepage ad = new AdminHomepage(driver);
		Thread.sleep(2000);
		ad.getOrders();
		
		//Verify My orders Page Should be Displayed
		wb.waitForTitle(driver, "Orders");
		String orderTitle=driver.getTitle();
		s.assertTrue(orderTitle.contains("Orders"),"Orders page is not displayed");
		Reporter.log("Oredrers page is displayed");
		//click edit icon
		Thread.sleep(2000);
		Orderssadmin o = new Orderssadmin(driver);
		o.edit();
	
		//Verify View oders Page Should be Displayed
		wb.waitForTitle(driver, "View Orders");
		String viewOrderTitle=driver.getTitle();
		s.assertTrue(viewOrderTitle.contains("View Orders"),"view Orders page is not displayed");
		Reporter.log(" view Oredrers page is displayed",true);
		o.update();
		
		
		//verify Update order button is Displyed or not
	
		
		//verify View User Details button is Displayed or not
		if(driver.findElement(By.xpath("//button[.='View User Detials']")).isDisplayed()) {
			System.out.println("View User Details button is Displayed");
		}
		else {
			System.out.println("View User Details button is Displayed is not Displayed");
		}
		//click on Update order button
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[.='Update Order Status']")).click();
		//Switch to child window and verify Order update child window is opened or not
	String parentWindow = driver.getWindowHandle();
	Set<String> childWindow = driver.getWindowHandles();
	String chtitle=null;
	for (String cw : childWindow) {
		driver.switchTo().window(cw);
		 chtitle = driver.getTitle();	
	}
	if(chtitle.contains("Order update")) {
		System.out.println("order update child window  is Displayed");
	}
	else
		System.out.println("order update child window  is not Displayed");
	
	//Select the order status
	Select sel=new Select(driver.findElement(By.name("status")));
	sel.selectByVisibleText("On the way");
	//write the comment
	driver.findElement(By.name("remark")).sendKeys("Your order is on the Way");
	//click on the submit button
	driver.findElement(By.name("update")).click();
	//verify the Form Details Updated Successfully alert is displayed and accept it
wb.waitForTitle(driver, chtitle);	
driver.switchTo().alert().accept();
	//Switch back to Parent window
	driver.switchTo().window(parentWindow);
		// logout from the Application
		driver.findElement(By.xpath("//img[@class='profile-pic']")).click();
		driver.findElement(By.xpath("//a[text()=' Logout']")).click();
		driver.quit();
	}

}























