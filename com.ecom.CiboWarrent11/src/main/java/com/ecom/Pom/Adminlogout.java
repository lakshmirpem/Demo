package com.ecom.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Adminlogout 
{
@FindBy(xpath = "//img[@class='profile-pic']")private WebElement profileicon;
@FindBy(xpath = "//a[text()=' Logout']")private WebElement logout;
public  Adminlogout(WebDriver driver) 
{
	PageFactory.initElements(driver, this);
}
public void getProfileicon()
{
	profileicon.click();;
}
public void getLogout()
{
	logout.click();
}
}

