package com.ecom.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage 
{
@FindBy(xpath = "//a[.='Login']")private WebElement Loginmodule;	
@FindBy(xpath = "//input[@name='username']")private WebElement usertf;
@FindBy(xpath = "//input[@name='password']") private WebElement passtf;
@FindBy(name="submit")private WebElement loginBtn;
public WebElement getLoginBtn() {
	return loginBtn;
}
public AdminLoginPage(WebDriver driver) 
{
	PageFactory.initElements(driver,this);
}
public void getUsername(String Username) 
{
	usertf.sendKeys(Username);
}
public void getPassword(String Password) 
{
	passtf.sendKeys(Password);
}

public void getLoginBtn1() 
{
	loginBtn.click();
}
public void LoginModule() 
{
	Loginmodule.click();
}

}
