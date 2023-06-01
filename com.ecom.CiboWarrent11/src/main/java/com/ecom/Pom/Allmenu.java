package com.ecom.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Allmenu 
{
	@FindBy(xpath = "//a[.='All Menues']")private WebElement allmenu;
	public Allmenu(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public WebElement getAllmenu() {
		return allmenu;
	}
	
}
