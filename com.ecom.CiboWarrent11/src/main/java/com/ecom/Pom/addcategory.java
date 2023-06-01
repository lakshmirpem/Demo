package com.ecom.Pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addcategory 
{
@FindBy(xpath = "//a[.='Add Category']")private WebElement addcat;
@FindBy(xpath = "//input[@name='c_name']")private WebElement addcattf;
@FindBy(xpath = "//input[@value='Save']")private WebElement savebtn;
@FindBy(xpath = "//a[.='Cancel']" )private WebElement cancelbtn;
@FindBy(xpath = "//table//td[2]")private List<WebElement> listedCategoryNames;
public WebElement getAddcat(String categoryName)
{
	addcattf.sendKeys(categoryName);
	return addcat;
}
public void getAddcattf(String c_name) 
{
	addcattf.sendKeys(c_name);
}
public void getSavebtn() 
{
	savebtn.click();
}
public void getCancelbtn() 
{
	cancelbtn.click();
}
public addcategory(WebDriver driver) 
{
	PageFactory.initElements(driver,this); 
	
}
public List<WebElement> getListedCategoryNames() {
	return listedCategoryNames;
}

}
