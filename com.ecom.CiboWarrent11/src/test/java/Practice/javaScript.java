package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ciboGenriclibraries.JavaScriptUtility;

public class javaScript 
{
public static void main(String[] args) throws InterruptedException 
{
	WebDriver driver=new FirefoxDriver();
	driver.get("https://phptravels.com/");
	driver.manage().window().maximize();
	JavaScriptUtility js = new JavaScriptUtility(driver);
	js.launchApplication("https://phptravels.com/");
	String url = js.getUrlofCurrentPage();
	System.out.println(url);
	String tittle = js.getTitleofCurrentPage();
	System.out.println(tittle);
	js.scrollDown();
	Thread.sleep(3000);
	js.Scrollup();
	js.scrollTillElement(driver.findElement(By.xpath("//div[.='Product']")));
}
}
