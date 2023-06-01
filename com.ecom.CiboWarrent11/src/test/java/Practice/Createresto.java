package Practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

import ciboGenriclibraries.ExcelUtility;
import ciboGenriclibraries.FileUtility;
import ciboGenriclibraries.JavaUtility;
import ciboGenriclibraries.WebdriverUtility;

public class Createresto {

	public static void main(String[] args) throws Throwable
	{
		ExcelUtility excel = new ExcelUtility();
		FileUtility File = new FileUtility();
		 JavaUtility j = new JavaUtility();
		  WebdriverUtility wb = new WebdriverUtility();
	  String URl = File.getPropertyKeyvalue("url");
	 String Username = File.getPropertyKeyvalue("username");
	 String Password = File.getPropertyKeyvalue("password");
		FirefoxDriver driver = new FirefoxDriver();
		driver.get(URl);
		wb.maximizewindow(driver);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	    driver.findElement(By.xpath("//span[.='Restaurant']")).click();
	   WebElement element = driver.findElement(By.xpath("//a[.='Add Restaurant']"));
	   wb.selectElementinDropdownbyvisible1(element, "Add Restaurant");
	   String Restoname = excel.getdata("Sheet1", 1, 0);
	   driver.findElement(By.xpath("//input[@name='res_name']")).sendKeys(Restoname);
		

		
		
	}

}
