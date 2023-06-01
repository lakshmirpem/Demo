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

import com.ecom.Pom.ResturanutPage;
import com.ecom.Pom.UserHomePage;
import com.ecom.Pom.UserLoginPage;
import com.ecom.Pom.UserLogout;

import ciboGenriclibraries.ExcelUtility;
import ciboGenriclibraries.FileUtility;
import ciboGenriclibraries.JavaUtility;
import ciboGenriclibraries.WebdriverUtility;

public class TestCase49 {

	public static void main(String[] args) throws IOException 
	{
		ExcelUtility excel = new ExcelUtility();
	   FileUtility File = new FileUtility();
	 JavaUtility j = new JavaUtility();
	  WebdriverUtility wb = new WebdriverUtility();
	  String URl = File.getPropertyKeyvalue("url");
		 String Username = File.getPropertyKeyvalue("username");
		 String Password = File.getPropertyKeyvalue("password");
		
		// open the browser
		 System.setProperty("webdriver.gecko.driver","./Softwares/geckodriver.exe");
		  WebDriver driver=new FirefoxDriver();
		   
		   //maximize the browser
		 	wb.maximizewindow(driver);
		 	
		 	// enter the url
		 	driver.get(URl);
		 	//implicitwait duration for 10sec
         	wb.waitpagegetload(driver);
         	
         	
     
		 
	          
	     	//click on login module
	UserLoginPage ulp = new UserLoginPage(driver);
	ulp.LoginModule();
	ulp.getUsername(Username);
		ulp.getpassword(Password);
		ulp.LoginButton();
		
		
		// verify home page is displaying 
		wb.waitForTitle(driver, "Home");
		String title = driver.getTitle();
		System.out.println(title);
		
		if(title.contains("Home"))
		{
			System.out.println(" home page is displaying");
		}else
		{
			System.out.println("home is not displaying");
		} 
		
		//click on restaurant module
		UserHomePage uhp = new UserHomePage(driver);
		uhp.getRegisterModule();
		//click on particular restaurant view menu button
		ResturanutPage rest = new ResturanutPage(driver);
		rest.Selectresto();
		rest.Selectdish();
		rest.Addtocart();
		rest.Checkout();
		
		// select payment option
		rest.cod();
		//click on orderNow button
         rest.orderNow();		
		//accept the alert popup
		driver.switchTo().alert().accept();
		
		//explicitwait for alretpresent in between 
		wb.waitTillAlertPopup(driver);
		//accept the alert popup
		driver.switchTo().alert().accept();
		
		
		//verify dish is ordered or not
	List<WebElement> dishnames = driver.findElements(By.xpath("//td[@data-column='Item']"));
	// w.until(ExpectedConditions.VisibilityOf().dishnames);
		boolean b=false;
	for(int i=0;i<dishnames.size();i++)
	{
		
	String dishname = dishnames.get(i).getText();
	if(dishname.contains("Yorkshire Lamb Patties"))
	{
		System.out.println(" dish is orderd");
		b= true;
		break;
	}
	}
	if(!b)
	{
		System.out.println(" dish is not oredred");
	}
	
	//logout the application
	UserLogout ul = new UserLogout(driver);
	ul.Logoutbtn();
		

	}

}


