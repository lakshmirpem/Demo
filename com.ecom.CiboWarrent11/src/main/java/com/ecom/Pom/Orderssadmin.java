package com.ecom.Pom;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Orderssadmin 
{
	@FindBy(xpath = "//table//td[.='Prawn Crackers']/..//a[2]") private WebElement editbtn;
	@FindBy(xpath = "//button[.='Update Order Status']") private WebElement update;
	@FindBy(xpath = "//button[.='View User Detials']") private WebElement Viewbtn;
	public Orderssadmin(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public void edit() 
	{
		editbtn.click();
	} 
	public void update() 
	{
		update.click();
	}
	public void viewuser() 
	{
		update.click();
	}

}
