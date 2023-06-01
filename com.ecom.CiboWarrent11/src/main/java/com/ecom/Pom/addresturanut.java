package com.ecom.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ciboGenriclibraries.WebdriverUtility;

public class addresturanut 
{
@FindBy(xpath="//a[.='Add Restaurant']") private WebElement addresto;
@FindBy(xpath = "//input[@name='res_name']")private WebElement rnametf;
@FindBy(xpath = "//input[@name='email']")private WebElement remail;
@FindBy(xpath = "//input[@name='phone']")private WebElement rphone;
@FindBy(xpath = "//input[@name='url']")private WebElement rurl;
@FindBy(xpath = "//select[@name='c_hr']")private WebElement closehour;
@FindBy(xpath = "//select[@name='o_hr']")private WebElement openhour;
@FindBy(xpath = "//select[@name='o_days']")private WebElement opendays;
@FindBy(xpath = "//input[@name='file']")private WebElement upload;
@FindBy(xpath = "//select[@name='c_name']")private WebElement cname;
@FindBy(xpath = "//textarea[@name='address']")private WebElement address;
@FindBy(xpath ="//input[@name='submit']")private WebElement savebtn;


public addresturanut(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public WebElement getAddresto() {
	return addresto;
}
public void rname(String name) 
{
	rnametf.sendKeys(name);
}
public void email(String email) 
{
	remail.sendKeys(email);
}
public void Phone(String phone) 
{
	rphone.sendKeys(phone);
}
public void url(String url) 
{
	rurl.sendKeys(url);
}
public void closehour(WebdriverUtility wb,int index) 
{
	wb.selectElementinDropdown(closehour, index);

}
public void openhour(WebdriverUtility wb,int index) 
{
	wb.selectElementinDropdown(openhour, index);

}
public void opendays(WebdriverUtility wb,int index) 
{
	
	
	wb.selectElementinDropdown(opendays, index);

}
public void upload(String path) 
{
	upload.sendKeys(path);
}
public void cname(WebdriverUtility wb,String name) 
{
	wb.selectElementinDropdownbyvisible1(cname, name);

}
public WebElement getClosehour() {
	return closehour;
}
public WebElement getOpenhour() {
	return openhour;
}
public WebElement getOpendays() {
	return opendays;
}
public WebElement getUpload() {
	return upload;
}
public WebElement getCname() {
	return cname;
}
public void address(String adrs) 
{
	address.sendKeys(adrs);
}
public void save() 
{
	savebtn.click();
}


}
