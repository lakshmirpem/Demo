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

import com.ecom.Pom.AdminHomepage;
import com.ecom.Pom.AdminLoginPage;
import com.ecom.Pom.Adminlogout;
import com.ecom.Pom.ResturanutPage;
import com.ecom.Pom.addcategory;

import ciboGenriclibraries.ExcelUtility;
import ciboGenriclibraries.FileUtility;
import ciboGenriclibraries.JavaUtility;
import ciboGenriclibraries.WebdriverUtility;

public class TestCase46
{
public static void main(String[] args) throws IOException, InterruptedException
	{
		ExcelUtility excel = new ExcelUtility();
	   FileUtility File = new FileUtility();
	 JavaUtility j = new JavaUtility();
	  WebdriverUtility wb = new WebdriverUtility();
	  String URl = File.getPropertyKeyvalue("adminurl");
		 String Username = File.getPropertyKeyvalue("adminuser");
		 String Password = File.getPropertyKeyvalue("adminpassword");
		// open Chrome Browser
	  System.setProperty("webdriver.gecko.driver","./Softwares/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		// maximize the window
		wb.maximizewindow(driver);
		// Enter the Admin URl
		driver.get(URl);
		// Enter the username in username textField
		AdminLoginPage Adlogin = new AdminLoginPage(driver);
		Adlogin.getUsername(Username);
		// Enter the password in password textfield
		Adlogin.getPassword(Password);
		// click on login button
		Adlogin.getLoginBtn1();
		// verify whether adminPanel page is Displayed or not
		wb.waitForTitle(driver, "Panel");
		String title = driver.getTitle();
		if (title.contains("Admin Panel")) {
			System.out.println("Admin Panel Page is Disaplayed");
		} else {
			System.out.println("Admin Panel Page is not Displayed");
		}
		// click on the restaurant to see submodules
		
		Thread.sleep(2000);
		AdminHomepage Adhome = new AdminHomepage(driver);
		  Adhome.ResturantModule1();
		  
		  
		  Adhome.selectaddcat();
		 
		addcategory addcat = new addcategory(driver);
		  
		// Verify Add category Page is Displayed or not
		String categorytitle = driver.getTitle();
		if (categorytitle.contains("Add Category")) {
			System.out.println("Add Restaurant Category Page is Displayed");
		} else
			System.out.println("Add Category page is not displayed");
		// Write the category name In the category text field
		int randnum1=j.getRandomNumber();
		String categoryName = "IndianPure-Veg1";
		String categoryName1 = categoryName+""+randnum1;
		addcat.getAddcattf(categoryName1);
		// Click on Save button
		Thread.sleep(2000);
		addcat.getSavebtn();

		// Verify The added category is displayed inListed categories or not
		List<WebElement> listedCategoryNames = driver.findElements(By.xpath("//table//td[2]"));
		boolean ck = false;
		for (WebElement cName : listedCategoryNames) {
			if (cName.getText().contains(categoryName1)) {
				System.out.println(categoryName1 + " is displayed in Listed categories");
				ck = true;
				break;
			}

		}
		if (!ck) {
			System.out.println(categoryName1 + " is not in Listed Categories and Test Fails");
		}
		// logout from the Application
		Adminlogout Adminlogout = new Adminlogout(driver);
		Thread.sleep(2000);
		Adminlogout.getProfileicon();
		Adminlogout.getLogout();
		driver.close();
	}









}


