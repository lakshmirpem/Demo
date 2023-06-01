package userModule1;


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
import org.testng.annotations.Test;

import com.ecom.Pom.AdminHomepage;
import com.ecom.Pom.AdminLoginPage;
import com.ecom.Pom.Adminlogout;

import ciboGenriclibraries.Baseclass;
import ciboGenriclibraries.ExcelUtility;
import ciboGenriclibraries.FileUtility;
import ciboGenriclibraries.JavaUtility;
import ciboGenriclibraries.WebdriverUtility;
public class TestCase60 extends Baseclass 
{

	@Test
	public void viewUpdate() throws Throwable
	{
		ExcelUtility excel = new ExcelUtility();
	   FileUtility File = new FileUtility();
	 JavaUtility j = new JavaUtility();
	  WebdriverUtility wb = new WebdriverUtility();
	  
		
		// open the browser
		
		// Enter the username in username textField
		
		// verify whether adminPanel page is Displayed or not
		wb.waitForTitle(driver, "Panel");
		String title = driver.getTitle();
		if (title.contains("Admin Panel")) {
			System.out.println("Admin Panel Page is Disaplayed");
		} else {
			System.out.println("Admin Panel Page is not Displayed");
		}
		// click on the orders module
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[.='Orders']")).click();
		
		//Verify My orders Page Should be Displayed
		wb.waitForTitle(driver, "Orders");
		String orderTitle=driver.getTitle();
		if(orderTitle.contains("Orders")) {
			System.out.println("orders Page is Displayed");
		}
		else
			System.out.println("orders Page is not Displayed");
		//click edit icon
		Thread.sleep(2000);
	
		driver.findElement(By.xpath("//table//td[.='Prawn Crackers']/..//a[2]")).click();
		//Verify View oders Page Should be Displayed
		Thread.sleep(2000);
		//wb.waitForTitle(driver, "View Orders");
		String viewOrderTitle=driver.getTitle();
		if(viewOrderTitle.contains("View Orders")) {
			System.out.println("View orders Page is Displayed");
		}
		else
			System.out.println("View orders Page is not Displayed");
		
		//verify Update order button is Displyed or not
		if(driver.findElement(By.xpath("//button[.='Update Order Status']")).isDisplayed()) {
			System.out.println("Update order button is Displayed");
		}
		else
			System.out.println("Update order button is not Displayed");
		
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
	Adminlogout ad = new Adminlogout(driver);
	ad.getProfileicon();
	ad.getLogout();
		
	}

}























