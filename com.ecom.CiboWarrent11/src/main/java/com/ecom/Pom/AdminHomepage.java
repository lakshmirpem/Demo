package com.ecom.Pom;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomepage 
{
@FindBy(xpath = "//span[.='Dashboard']")private WebElement Dashboard;
@FindBy(xpath = "//span[.='Users']")private WebElement Users;
@FindBy(xpath = "//span[.='Restaurant']")private WebElement Restaurant;
@FindBy(xpath = "//a[.='Add Category']")private WebElement selectaddcat;
@FindBy(xpath = "//span[.='Menu']")private WebElement Menu;
@FindBy(xpath = "//span[.='Orders']']")private WebElement Orders;
@FindBy(xpath = "//img[@class='profile-pic']") private WebElement Profile;
@FindBy(xpath = "//div[@class='media-body media-text-right']/h2[1]") private WebElement rcount;
public AdminHomepage(WebDriver driver) 
{
	PageFactory.initElements(driver, this);
}
public WebElement getDashboard() {
	return Dashboard;
}
public WebElement getUsers() {
	return Users;
}

public WebElement getMenu() {
	return Menu;
}
public void getOrders() 
{
	Orders.click();
}
public void selectaddcat()
{
	
	selectaddcat.click();
}
public void ResturantModule1() 
{
	Restaurant.click();
}
public void Dashboard() 
{
	Dashboard.click();
}
public String rcount()
{
	String c = rcount.getText();
	return c;
}

}



