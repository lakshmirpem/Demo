package com.ecom.Pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ciboGenriclibraries.WebdriverUtility;

public class ResturanutPage
{
@FindBy(xpath ="//a[.='View Menu']" )private WebElement veiwmenubtn1;
@FindBy(xpath ="//input[@value='Add To Cart']" )private WebElement addtocartbtn;
@FindBy(xpath ="//a[.='Checkout']" )private WebElement checkoutbtn;
@FindBy(xpath = "//a[.='Restaurants ']")private WebElement restobtn;
@FindBy(xpath = "//a[.='Eataly']")private WebElement selectrest;
@FindBy(xpath = "//a[.='Pink Spaghetti Gamberoni']/../../../../../div[2]/input[@value='Add To Cart']") private WebElement selectdish;
@FindBy(xpath = "//span[.='Cash on Delivery']")private WebElement cod;
@FindBy(xpath = "//input[@value='Order Now']")private WebElement ordernow;
@FindBy(xpath = "//a[.='Add Restaurant']")private WebElement selectaddrest;
public ResturanutPage(WebDriver driver) 
{
	PageFactory.initElements(driver, this);
	
}
public void Viewmenu() 
{
	veiwmenubtn1.click();

}
public void Addtocart() 
{
	addtocartbtn.click();
}
public void Checkout() 
{
	checkoutbtn.click();
}
public void Restaurants() 
{
	restobtn.click();
}
public void Selectresto() 
{
	selectrest.click();
}
public void Selectdish() 
{
	selectdish.click();
}
public void cod() 
{
	cod.click();
}
public void orderNow() 
{
	ordernow.click();
}
public void Addresturauant() 
{
	selectaddrest.click();
}

}

