package com.ecom.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLogout 
{
@FindBy(xpath = "//a[.='Logout']")private WebElement logout;
public UserLogout(WebDriver driver) 
{
	PageFactory.initElements(driver, this);
}
public void Logoutbtn() 
{
	logout.click();
}
}
