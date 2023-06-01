package com.ecom.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage
{
	//Declration
	@FindBy(xpath = "//a[.='Login']")private WebElement loginmodue;
 @FindBy(name="username") private WebElement usernametxtf;
 @FindBy(name="password") private WebElement passwordtxtf;
 @FindBy(id="buttn") private WebElement loginbutt;
 //initialisation
 public UserLoginPage(WebDriver driver)
 {
	 
	 PageFactory.initElements(driver, this);
 }
 public void LoginModule() 
 {
	 loginmodue.click();
	
}
 //utilisation
 public void getUsername(String Username)
 {
	 usernametxtf.sendKeys(Username);
	 
 }
 public void getpassword(String Password) 
 {
	 passwordtxtf.sendKeys(Password);
}
 public void LoginButton() 
 {
	 loginbutt.click();
 }
} 

