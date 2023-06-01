package ciboGenriclibraries;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.ecom.Pom.AdminLoginPage;
import com.ecom.Pom.Adminlogout;
import com.ecom.Pom.UserHomePage;
import com.ecom.Pom.UserLoginPage;
import com.ecom.Pom.UserLogout;

public class Baseclass 
{
	public ExcelUtility excel = new ExcelUtility();
	public FileUtility File = new FileUtility();
	public JavaUtility j = new JavaUtility(); 
	public  WebdriverUtility wb = new WebdriverUtility();
	public static WebDriver driver;
	
	//@Parameters("Browser")
	  @BeforeClass(groups={"System","Integration"})
	  public void launchbrowse() throws Throwable 
	  {
		  
		  String Browser = File.getPropertyKeyvalue("Browser");
		   if(Browser.equalsIgnoreCase("Firefox")) { 
		  System.setProperty("webdriver.gecko.driver","./Softwares/geckodriver.exe");
		  driver=new FirefoxDriver();
		   } else if(Browser.equalsIgnoreCase("Chrome")) 
		   {
			   System.setProperty("webdriver.chrome.driver","./Softwares/chromedriver.exe");
				  driver=new ChromeDriver(); 
		   }else {
			   driver=new EdgeDriver();
		   }
		  wb.maximizewindow(driver);
		  System.out.println("openbrowser");
		  

		  
	  }
	  @BeforeMethod(groups={"System","Integration"})
	  public void logintoapp() throws Throwable
	  {
		  //Adminlogin
		   String Adminurl = File.getPropertyKeyvalue("adminurl");
		  String Username = File.getPropertyKeyvalue("adminuser");
		  String Password = File.getPropertyKeyvalue("adminpassword");
		  wb.waitpagegetload(driver) ;
		  driver.get(Adminurl);
		 AdminLoginPage adlogin = new AdminLoginPage(driver);
		 adlogin.getUsername(Username);
		 adlogin.getPassword(Password);
		 adlogin.getLoginBtn1();
		 System.out.println("logged in");	 
		 //userlogin
		  
		 /*String URL = File.getPropertyKeyvalue("url");
		  String USERNAME = File.getPropertyKeyvalue("username");
		  String PASSWORD = File.getPropertyKeyvalue("password");
		  wb.waitpagegetload(driver);
		  driver.get(URL);
		  UserLoginPage ul = new UserLoginPage(driver);
		  ul.LoginModule();
		  ul.getUsername(USERNAME);
		  ul.getpassword(PASSWORD);
		  ul.LoginButton(); */
		 
	  }
	  @AfterMethod(groups={"System","Integration"})
	  public void logoutapp() 
	  {
		  //Admin login
		  
		 Adminlogout adout = new Adminlogout(driver);
		 adout.getProfileicon();
		 adout.getLogout(); 
		 System.out.println("Loggedout");		 
		 //user Logout
	 /*UserLogout uout = new UserLogout(driver);
		 uout.Logoutbtn(); 
		  */
	  }
	  @AfterClass(groups={"System","Integration"})
	  public void CloseBrowser() 
	  {
		  driver.close();
		  System.out.println("Bowserclosed");
	  }
}
