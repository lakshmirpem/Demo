package userModule1;






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
//TC_18

import com.ecom.Pom.AdminHomepage;
import com.ecom.Pom.Adminlogout;
import com.ecom.Pom.addcategory;

import ciboGenriclibraries.ExcelUtility;
import ciboGenriclibraries.FileUtility;
import ciboGenriclibraries.JavaUtility;
import ciboGenriclibraries.WebdriverUtility;

public class TestCase18 {

	public static void main(String[] args) throws Throwable
	{
		ExcelUtility excel = new ExcelUtility();
		FileUtility File = new FileUtility();
		 JavaUtility j = new JavaUtility();
		  WebdriverUtility wb = new WebdriverUtility();
		  System.setProperty("webdriver.gecko.driver","./Softwares/geckodriver.exe");
		  WebDriver driver = new FirefoxDriver();
		  wb.waitpagegetload(driver);
		  String Adminurl = File.getPropertyKeyvalue("adminurl");
		  String Username = File.getPropertyKeyvalue("adminuser");
		  String Password = File.getPropertyKeyvalue("adminpassword");
		  String categoryName = excel.getdata("Sheet1", 1, 0);
	
		// maximize the window
		wb.maximizewindow(driver);
		
		// Enter the Admin URl
		driver.get(Adminurl);
		Thread.sleep(2000);
		// Enter the username in username textField
	com.ecom.Pom.AdminLoginPage adminlogin = new com.ecom.Pom.AdminLoginPage(driver);
		adminlogin.getUsername(Username);
		// Enter the password in password textfield
		adminlogin.getPassword(Password);
		// click on login button
		adminlogin.getLoginBtn().click();
		// verify whether adminPanel page is Displayed or not
		
		/*wb.waitForTitle(driver, "Panel");
		String title = driver.getTitle();
		if (title.contains("Admin Panel")) {
			System.out.println("Admin Panel Page is Disaplayed");
		} else {
			System.out.println("Admin Panel Page is not Displayed");
		}*/
		Thread.sleep(2000);
		// click on the restaurant to see submodules
		AdminHomepage adminhome = new AdminHomepage(driver);
		adminhome.ResturantModule1();
		Thread.sleep(2000);
		adminhome.selectaddcat();
		// click on Add category
		addcategory addcat = new addcategory(driver);
		Thread.sleep(2000);
		addcat.getAddcat(categoryName).click();
		// Verify Add category Page is Displayed or not
		String categorytitle = driver.getTitle();
		if (categorytitle.contains("Add Category")) {
			System.out.println("Add Restaurant Category Page is Displayed");
		} else
			System.out.println("Add Category page is not displayed");
		// Write the category name In the category text field
		
		addcat.getAddcat(categoryName);
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
			if (cName.contains(categoryName)) {
				System.out.println(categoryName + " is displayed in Listed categories");
				ck = true;
				break;
			}
			

		}
		if (!ck) {
			System.out.println(categoryName + " is not in Listed Categories and Test Fails");
		}
		// logout from the Application
		Adminlogout logoutad=new Adminlogout(driver);
		logoutad.getProfileicon();
		logoutad.getLogout();
		driver.close();
	}

}





















