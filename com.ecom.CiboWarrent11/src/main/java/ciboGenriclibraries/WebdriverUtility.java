package ciboGenriclibraries;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility 
{
public void maximizewindow(WebDriver driver) 
{
	driver.manage().window().maximize();
}
public void minimizewindow(WebDriver driver) 
{
	driver.manage().window().minimize();
}
public void waitpagegetload(WebDriver driver) 
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Ipathconstant.implicitWaitDuration));
	
}
public void waitTillelementToBevisible(WebDriver driver,WebElement element) 
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Ipathconstant.explicitWaitDuration));
	wait.until(ExpectedConditions.visibilityOf(element));
	
}
public void waitTillelementToclickable(WebDriver driver,WebElement element) 
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Ipathconstant.explicitWaitDuration));
	wait.until(ExpectedConditions.elementToBeClickable(element));
	
}
public void waitTillAlertPopup(WebDriver driver) 
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Ipathconstant.explicitWaitDuration));
	wait.until(ExpectedConditions.alertIsPresent());
	
}
public void waitForTitle(WebDriver driver,String title) 
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Ipathconstant.explicitWaitDuration));
	wait.until(ExpectedConditions.titleContains(title));
	
}
public void waitForURL(WebDriver driver,String url) 
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Ipathconstant.explicitWaitDuration));
	wait.until(ExpectedConditions.urlContains(url));
	
}
public void ignoreNoSuchElement(WebDriver driver) 
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Ipathconstant.explicitWaitDuration));
	wait.ignoring(NoSuchElementException.class);
	
}
public void selectElementinDropdown(WebElement element,int index) 
{
	Select s = new Select(element);
	s.selectByIndex(index);
}
public void selectElementinDropdownbyvalue(WebElement element,String value) 
{
	Select s = new Select(element);
	s.selectByValue(value);
}
public void selectElementinDropdownbyvisible1(WebElement element,String text) 
{
	Select s = new Select(element);
	s.selectByVisibleText(text);

}
public void getAllOptions(WebElement element) 
{
	Select s = new Select(element);
	List<WebElement> opt = s.getOptions();
	for(WebElement options:opt) 
	{
		String text1=options.getText();
	}
     
}
public void moseHover(WebElement element,WebDriver driver) 
{
	Actions a = new Actions(driver);
	a.moveToElement(element).perform();
	
}
public void rigthclick(WebElement element,WebDriver driver) 
{
	Actions a = new Actions(driver);
	a.contextClick(element).perform();
	
}
public void doubleclick(WebElement element,WebDriver driver) 
{
	Actions a = new Actions(driver);
	a.doubleClick(element).perform();
	
}
public void switchFrame(WebDriver driver,int index) 
{
	driver.switchTo().frame(index);
}
public void switchFrame(WebDriver driver,String id) 
{
	driver.switchTo().frame(id);
}
public void switchFrame(WebDriver driver,WebElement element) 
{
	driver.switchTo().frame(element);
	
}
public void switchToAlertpopupandAccept(WebDriver driver,String text) 
{
	Alert alt = driver.switchTo().alert();
	if(alt.getText().trim().equalsIgnoreCase(text.trim())) 
	{
		
		System.out.println("alert is present"); 
	}else
	{
		System.out.println("alert is not present");
	}
	alt.accept();
}
public void switchToAlertpopupandDismiss(WebDriver driver,String text) 
{
	Alert alt = driver.switchTo().alert();
	if(alt.getText().trim().equalsIgnoreCase(text.trim())) 
	{
		
		System.out.println("alert is present");
	}else
	{
		System.out.println("alert is not present");
	}
	alt.dismiss();
}
public void fileUpload(WebElement element,String path)
{
	element.sendKeys(path);
}
public void customWait(int duration,WebElement element,long pollingTime) 
{
	int count=0;
	while(count<duration)
	{
		try {
			element.click();
			break;
			
		} catch (Exception e) {
			try {
				Thread.sleep(pollingTime);
			} catch (Exception e2) {
				e2.printStackTrace();
				}
		
	}		count++;
}
}
public String takesScreenshot(WebDriver driver,String screenshotname) throws IOException 
{
	TakesScreenshot tss = (TakesScreenshot)driver;
	File src = tss.getScreenshotAs(OutputType.FILE);
	LocalDateTime localDate = LocalDateTime.now();
	String dateTime = localDate.toString().replace(" ", "_").replace(":", "_");
	File dst = new File("./screenshot/"+screenshotname+""+localDate+".png");
	FileUtils.copyFile(src, dst);
	return screenshotname;
}
public void switchWindow(WebDriver driver,String title) 
{
	Set<String> set = driver.getWindowHandles();
	for(String wdw:set) 
	{
		driver.switchTo().window(wdw);
		String text = driver.getTitle();
		if(text.contains(title)) {
			break;
		}
		}
		
	}
public void switchWindow(String url,WebDriver driver) 
{
	Set<String> set = driver.getWindowHandles();
	Iterator<String> it = set.iterator();
	while (it.hasNext()) 
	{
		String wid = it.next();
		driver.switchTo().window(wid);
		String text = driver.getCurrentUrl();
		if(text.contains(url)) {
			break;
		}
		
	}
		
		
	}
	
}





