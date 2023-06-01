package com.ecom.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addmenu
{
public WebElement getAddmenu() {
		return addmenu;
	}
@FindBy(xpath = "//a[.='Add Menu']")private WebElement addmenu;
public Addmenu(WebDriver driver) 
{
	PageFactory.initElements(driver,this);
}

}
