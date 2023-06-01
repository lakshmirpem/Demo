package com.ecom.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v111.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.This;

public class UserHomePage 
{
@FindBy(xpath="//a[.='Login']") private WebElement loginmodule;
@FindBy(xpath = "//a[.='Restaurants ']") private WebElement RestoModule;
@FindBy(xpath = "//a[.='Register']")private WebElement RegisterModule;
@FindBy(xpath = "//a[.='My Orders']")private WebElement MyordersModule;
@FindBy(xpath = "//a[.='Logout']")private WebElement LogoutModule;
public  UserHomePage(WebDriver dirver) 
{
	PageFactory.initElements(dirver,this);
}
public WebElement getLoginmodule() {
	return loginmodule;
}
public void getRestoModule() 
{
	RestoModule.click();;
}
public WebElement getRegisterModule() {
	return RegisterModule;
}
public void getMyordersModule() 
{
	 MyordersModule.click();;
}
}
