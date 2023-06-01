package Practice;

import org.testng.annotations.Test;

public class ExcuteData 
{
@Test(dataProviderClass=DataProvidertest.class,dataProvider="data")
public void getData( String src,String dst)
{
	System.out.println("From--"+src+"to--"+dst);

	
}
@Test(dataProviderClass=Dataprovider1.class,dataProvider="data")
public void getdata(String src,String dst)
{
	System.out.println("From--"+src+ "to--"+dst);
}
@Test(dataProviderClass=Dataprovider2 .class,dataProvider="data")
public void getdata(String src,String dst,String price,String train,String train1)
{
	System.out.println("From--"+src+ "to--"+dst+"price--"+price+"train--"+train+"train1--"+train1);
}
}
