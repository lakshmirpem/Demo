package Practice;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.annotations.Test;

import ciboGenriclibraries.ExcelUtility;
import ciboGenriclibraries.ExcelUtils;

public class Getdata1 
{
@Test(dataProviderClass=Getdata.class,dataProvider="data20")
public void getData( String src,String dst,String price)
{
	System.out.println("From--"+src+"--to--"+dst+"--price--"+price);

	
}

public void data1() throws Throwable 
{

ExcelUtils e = new ExcelUtils(); 
e.data20("DataProvider");
}
}
