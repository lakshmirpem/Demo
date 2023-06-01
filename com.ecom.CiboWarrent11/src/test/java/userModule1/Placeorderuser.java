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
import com.ecom.Pom.UserLoginPage;
import com.ecom.Pom.UserLogout;

import ciboGenriclibraries.ExcelUtility;
import ciboGenriclibraries.FileUtility;
import ciboGenriclibraries.JavaUtility;
import ciboGenriclibraries.WebdriverUtility;

public class Placeorderuser
{
	
		public static void main(String[] args) throws IOException, InterruptedException {
			ExcelUtility excel = new ExcelUtility();
			FileUtility File = new FileUtility();
			 JavaUtility j = new JavaUtility();
			  WebdriverUtility wb = new WebdriverUtility();
			  String URl = File.getPropertyKeyvalue("url");
				 String Username = File.getPropertyKeyvalue("username");
				 String Password = File.getPropertyKeyvalue("password");
					
			  System.setProperty("webdriver.gecko.driver","./Softwares/geckodriver.exe");
			
			// open the browser
			  WebDriver driver=new FirefoxDriver();
			   
			   //maximize the browser
			 	wb.maximizewindow(driver);
			 	
			 	// enter the url
			 	driver.get(URl);
			 	//implicitwait duration for 10sec
	           	wb.waitpagegetload(driver);
			 
		
		          
		     	//click on login module
			
			
			UserLoginPage ULP = new UserLoginPage(driver);
			ULP.LoginModule();
			ULP.getUsername(Username);
			ULP.getpassword(Password);
			ULP.LoginButton();
			
			
			// verify home page is displaying 
			wb.waitForTitle(driver,"Home");
			String title = driver.getTitle();
		
			
			System.out.println(title);
			
			if(title.contains("Home"))
			{
				System.out.println(" home page is displaying");
			}else
			{
				System.out.println("home is not displaying");
			} 
			
			//click on restaurant mod
		ResturanutPage Resturant = new ResturanutPage(driver);
		Resturant.Restaurants();
			
			
			
			//click on particular restaurant 
			Resturant.Selectresto();
			//select dish on click on add to cart button
			Resturant.Selectdish();
			//click on checkout button
			Resturant.Checkout();
			// select payment option
			Resturant.cod();
			//click on orderNow button
			Resturant.orderNow();
			
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
		if(dishname.contains("Pink Spaghetti Gamberoni"))
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
	UserLogout uslogout = new UserLogout(driver);
	uslogout.Logoutbtn();
		
		
		}

		
	}


