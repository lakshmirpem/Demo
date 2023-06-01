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

import com.ecom.Pom.Myorderspage;
import com.ecom.Pom.UserHomePage;
import com.ecom.Pom.UserLoginPage;
import com.ecom.Pom.UserLogout;

import ciboGenriclibraries.ExcelUtility;
import ciboGenriclibraries.FileUtility;
import ciboGenriclibraries.JavaUtility;
import ciboGenriclibraries.WebdriverUtility;

public class Test48 {

	public static void main(String[] args) throws InterruptedException, IOException 
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
		 
	WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(10));
	          
	   UserLoginPage lp = new UserLoginPage(driver);
	   UserHomePage ush=new UserHomePage(driver);
	   ush.getLoginmodule().click();
	   lp.getUsername(Username);
	   lp.getpassword(Password);
	   lp.LoginButton();
		
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
		
		//click on my orders module
		
		ush.getMyordersModule();
		
		
		//WebElement deleteitem = driver.findElement(By.xpath("//td[.=' 2023-05-15 14:52:35']/following-sibling::td[1]"));
		//deleteitem.click(); 
		
		
		//driver.switchTo().alert().accept();
		
		Myorderspage Myor = new Myorderspage(driver);
		List<WebElement> items = Myor.getItems();
		boolean f= false;
		for(int i=0;i<items.size();i++)
		{
			String itemsname = items.get(i).getText();
			if(itemsname.contains("2023-05-15 14:52:35"))
			{
				System.out.println(" dish is not deleted");
				f= true;
				break;
			}
		}
		if(!f)
		{
			System.out.println(" dish is deleted");
		}
		
	
		
		
		
		//logout the application
		UserLogout uslogout = new UserLogout(driver);
		uslogout.Logoutbtn();
		
	
	}


}

