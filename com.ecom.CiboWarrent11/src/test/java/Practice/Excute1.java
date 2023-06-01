package Practice;

import org.testng.annotations.Test;

public class Excute1 
{
	
		@Test(dataProviderClass=Getdata.class,dataProvider="data20")
		public void getData( String src,String dst,String price)
		{
			System.out.println("From--"+src+"--to--"+dst+"--price--"+price);

			
		}
}
