package ciboGenriclibraries;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility 
{
    JavascriptExecutor js;
    public JavaScriptUtility(WebDriver driver) 
    {
		js=(JavascriptExecutor)driver;
	}
    public void Scrollup() 
	{
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
    public void scrollTillElement(WebElement element) 
	{
		js.executeScript("arguments[0].scrollby(0,document.body.scrollHeigth)");
	}
    public void scrollDown() 
    {
    	js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
    public void launchApplication(String url) 
    {
    	js.executeScript("window.location=arguments[0]",url);
	}
    public void sendkeys(WebElement element,String data) 
    {
    	js.executeScript("arguments[0].value=arguments[1]",element,data);
	}
    public void click(WebElement element) 
    {
    	js.executeScript("arguments[0].click()",element);
	}
    public void clickElementById(String elementId) 
    {
    	js.executeScript("document.getElementById('elementId').click()");
	}
    public void getThetext(WebElement element)
    {
		js.executeScript("return arguments[0].value;", element);
	}
    public String getUrlofCurrentPage() 
    {
		String url = (String)js.executeScript("return window.location.href");
		return url;
	}
    public String getTitleofCurrentPage() 
    {
String title = (String)js.executeScript("return document.title");
		return title;
	}
    
    
}
