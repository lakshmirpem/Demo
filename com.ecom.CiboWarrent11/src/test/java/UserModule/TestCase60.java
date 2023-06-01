package UserModule;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.math3.genetics.OrderedCrossover;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ecom.Pom.Orderssadmin;
import com.ecom.Pom.UserLoginPage;

import ciboGenriclibraries.ExcelUtility;
import ciboGenriclibraries.FileUtility;
import ciboGenriclibraries.JavaUtility;
import ciboGenriclibraries.WebdriverUtility;
public class TestCase60 {

	public static void main(String[] args) throws InterruptedException, Throwable {
		ExcelUtility excel = new ExcelUtility();
		   FileUtility File = new FileUtility();
		 JavaUtility j = new JavaUtility();
		  WebdriverUtility wb = new WebdriverUtility();
		  String URl = File.getPropertyKeyvalue("url");
			 String Username = File.getPropertyKeyvalue("username");
			 String Password = File.getPropertyKeyvalue("password");
		// open Chrome Browser
		 System.setProperty("webdriver.gecko.driver","./Softwares/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		// implicit wait for the elements to display
		wb.waitpagegetload(driver);
		//Create reference variable of WebDriverWait class to give conditional waiting mechanism
		
		// maximize the window
     wb.waitForTitle(driver, "Panel");
// Enter the Admin URl
		driver.get(URl);
		// Enter the username in username textField
		driver.findElement(By.name("username")).sendKeys(Username);
		// Enter the password in password textfield
		driver.findElement(By.name("password")).sendKeys(Password);
		// click on login button
		driver.findElement(By.name("submit")).click();
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
		driver.findElement(By.xpath("//span[text()='Orders']")).click();
		//Verify My orders Page Should be Displayed
		wb.waitForTitle(driver, "Orders");
		String orderTitle=driver.getTitle();
		if(orderTitle.contains("Orders")) {
			System.out.println("My orders Page is Displayed");
		}
		else
			System.out.println("My orders Page is not Displayed");
		//click edit icon
		Thread.sleep(2000);
		Orderssadmin o = new Orderssadmin(driver);
		o.edit();
		//Verify View oders Page Should be Displayed
		wb.waitForTitle(driver, "View Orders");
		String viewOrderTitle=driver.getTitle();
		if(viewOrderTitle.contains("View Orders")) {
			System.out.println("View orders Page is Displayed");
		}
		else
			System.out.println("View orders Page is not Displayed");
		//verify Update order button is Displyed or not
		o.update();
		
		//verify View User Details button is Displayed or not
		if(driver.findElement(By.xpath("//button[.='View User Detials']")).isDisplayed()) {
			System.out.println("View User Details button is Displayed");
		}
		else
			System.out.println("View User Details button is Displayed is not Displayed");
		//click on Update order button
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
	else {
		System.out.println("order update child window  is not Displayed");
	    }
	wb.switchWindow(driver, "Login");
	UserLoginPage us = new UserLoginPage(driver);
	String URl1 = File.getPropertyKeyvalue("url");
	 String Username1 = File.getPropertyKeyvalue("username");
	 String Password1= File.getPropertyKeyvalue("password");
	 us.getUsername(Username1);
	 us.getpassword(Password1);
	 us.LoginButton();
	 driver.close();
	 Thread.sleep(2000);
		//driver.findElement(By.xpath("//button[.='Update Order Status']")).click();
		wb.switchWindow(driver, "View Order");
		driver.findElement(By.xpath("//button[.='Update Order Status']")).click();
		wb.switchWindow(driver,"Order Update");
	//Select the order statu
		Thread.sleep(2000);
	WebElement ele = driver.findElement(By.xpath("//select[@name='status']"));
	Select sel = new Select(ele);
	sel.selectByIndex(1);
	//write the comment
	driver.findElement(By.name("remark")).sendKeys("Your order is on the Way");
	//click on the submit button
	driver.findElement(By.name("update")).click();
	//verify the Form Details Updated Successfully alert is displayed and accept it
	wb.waitTillAlertPopup(driver);	
	driver.switchTo().alert().accept();
	//Switch back to Parent window
	driver.switchTo().window(parentWindow);
		// logout from the Application
		driver.findElement(By.xpath("//img[@class='profile-pic']")).click();
		driver.findElement(By.xpath("//a[text()=' Logout']")).click();
		driver.quit();
	}

}























