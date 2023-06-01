package Testscrpts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ecom.Pom.AdminHomepage;
import com.ecom.Pom.AdminLoginPage;
import com.ecom.Pom.Adminlogout;
import com.ecom.Pom.CollectionaddrestoPage;
import com.ecom.Pom.ResturanutPage;
import com.ecom.Pom.addresturanut;

import ciboGenriclibraries.Baseclass;
import ciboGenriclibraries.ExcelUtility;
import ciboGenriclibraries.ExcelUtils;
import ciboGenriclibraries.FileUtility;
import ciboGenriclibraries.JavaUtility;
import ciboGenriclibraries.WebdriverUtility;
@Listeners(ciboGenriclibraries.Listeners.class)
public class AddResturant extends Baseclass
{
//Welcome to this application
     @Test(groups="Integration")
	public void Admin() throws Throwable
	{
		ExcelUtility excel = new ExcelUtility();
		FileUtility File = new FileUtility();
		 JavaUtility j = new JavaUtility(); 
		  WebdriverUtility wb = new WebdriverUtility();
		  ExcelUtils e = new ExcelUtils();
		  
		Thread.sleep(2000);
	ResturanutPage rest = new ResturanutPage(driver);
  AdminHomepage adhome=new AdminHomepage(driver);
  adhome.ResturantModule1();
	rest.Addresturauant();
	
	
	CollectionaddrestoPage cc = new CollectionaddrestoPage(driver);
	cc.Collectionaddresto1(e.restdata("Add"), driver, j);
	addresturanut a = new addresturanut(driver) ;
	a.getOpenhour();
	a.getClosehour();
	a.getOpendays();
	a.getUpload();
	a.getCname();
	a.getAddresto();
	a.save();
	Thread.sleep(2000);

	adhome.Dashboard();
	String ad = adhome.rcount();
	System.out.println(ad);
	Thread.sleep(2000);
	
	} 
	}	

	
	 



