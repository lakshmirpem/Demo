package com.ecom.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Allresto 
{
	@FindBy(xpath = "//a[.='All Restaurants']")private WebElement allrest;
	public Allresto(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public WebElement getAddcat() {
		return allrest;
	}
	public void allresturaunt()
	{
		allrest.click();
	}
}
