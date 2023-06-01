package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider1
{
	
		@Test(dataProvider = "data")
		public void getdata(String src,String dst)
		{
			System.out.println("From--"+src+ "to--"+dst);
		}
		
		
	@DataProvider()
	public Object[][] data() 
	{
		Object[][] arr = new Object[3][2];
		arr[0][0]="Bengluru";
		arr[0][1]="hubli";
		
		arr[1][0]="Qsipders";
		arr[1][1]="testyantra";
		
		arr[2][0]="davangere";
		arr[2][1]="mysore";


		return arr;

		

		
	}

	}


