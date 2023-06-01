package com.ecom.Pom;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ciboGenriclibraries.JavaUtility;

public class CollectionaddrestoPage 
{
@FindBy(name = "res_name")private WebElement retf;
@FindBy(name = "email")private WebElement etf;
@FindBy(name = "phone")private WebElement ptf;
@FindBy(name = "url")private WebElement utf;

public  CollectionaddrestoPage(WebDriver driver) 
{
	PageFactory.initElements(driver, this); 
}

public void Collectionaddresto1(HashMap<String, String> name,WebDriver driver,JavaUtility j)
{
	
	for(Entry<String, String> set:name.entrySet()) 
		
	{
		if(set.getValue().equalsIgnoreCase("Lakshmiveg")) 
		{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+""+j.getRandomNumber());

		}
		else 
		{
		driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
	}
	}
}

}

