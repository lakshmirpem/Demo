package com.ecom.Pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Myorderspage 
{
@FindBy(xpath = "//td[5]")private List<WebElement> items;


public Myorderspage(WebDriver driver) 
{
	PageFactory.initElements(driver,this);
	
}
public List<WebElement> getItems() {
	return items;
}
}
