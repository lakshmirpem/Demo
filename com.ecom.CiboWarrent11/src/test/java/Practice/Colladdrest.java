package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ecom.Pom.AdminHomepage;
import com.ecom.Pom.AdminLoginPage;
import com.ecom.Pom.Adminlogout;
import com.ecom.Pom.CollectionaddrestoPage;
import com.ecom.Pom.ResturanutPage;
import ciboGenriclibraries.ExcelUtility;
import ciboGenriclibraries.ExcelUtils;
import ciboGenriclibraries.FileUtility;
import ciboGenriclibraries.JavaUtility;
import ciboGenriclibraries.WebdriverUtility;

public class Colladdrest {

	public static void main(String[] args) throws Throwable 
	{
		ExcelUtility excel = new ExcelUtility();
		FileUtility File = new FileUtility();
		 JavaUtility j = new JavaUtility(); 
		  WebdriverUtility wb = new WebdriverUtility();
		  ExcelUtils e = new ExcelUtils();
		  String Adminurl = File.getPropertyKeyvalue("adminurl");
		  String Username = File.getPropertyKeyvalue("adminuser");
		  String Password = File.getPropertyKeyvalue("adminpassword");
	  System.setProperty("webdriver.gecko.driver","./Softwares/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		wb.maximizewindow(driver);
		wb.waitpagegetload(driver);
		driver.get(Adminurl);
		AdminLoginPage adminlogin=new AdminLoginPage(driver);
		adminlogin.getUsername(Username);
		adminlogin.getPassword(Password);
		adminlogin.getLoginBtn1();
		Thread.sleep(2000);
	ResturanutPage rest = new ResturanutPage(driver);
  AdminHomepage adhome=new AdminHomepage(driver);
  adhome.ResturantModule1();
	rest.Addresturauant();
	CollectionaddrestoPage cc = new CollectionaddrestoPage(driver);
	cc.Collectionaddresto1(e.restdata("Add"), driver, j);

	Thread.sleep(2000);
	adhome.Dashboard();
	String ad = adhome.rcount();
	System.out.println(ad);
	Thread.sleep(2000);
	Adminlogout logout = new Adminlogout(driver);
	logout.getProfileicon();
	logout.getLogout();
	driver.close();
	} 
	}	

	
	 



