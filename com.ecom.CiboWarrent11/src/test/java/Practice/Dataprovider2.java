package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider2 
{
	public class DataProvidertest 
	{
		@Test(dataProvider = "data")
		public void getdata(String src,String dst,String price,String train,String train1)
		{
			System.out.println("From--"+src+ "to--"+dst+"price--"+price+"train--"+train+"train1--"+train1);
		}
		
		
	@DataProvider()
	public Object[][] data() 
	{
		Object[][] arr = new Object[5][5];
		arr[0][0]="Bengluru";
		arr[0][1]="hubli";
		arr[0][2]="500";
		arr[0][3]="chennai express";
		arr[0][4]="chennai express";

		

		arr[1][0]="davangere";
		arr[1][1]="mysore";
		arr[1][2]="davangereexpresss";
		arr[1][3]="300";
		arr[1][4]="chennai express";

		
		arr[2][0]="mysore";
		arr[2][1]="davangere";
		arr[2][2]="davangereexpresss";
		arr[2][3]="300";
		arr[2][4]="chennai express";

		
		
		arr[3][0]="Bengluru";
		arr[3][1]="davangere";
		arr[3][2]="davangereexpresss";
		arr[3][3]="400";
		arr[3][4]="chennai express";

		
		
		arr[4][0]="Bengluru";
		arr[4][1]="davangere";
		arr[4][2]="davangereexpresss";
		arr[4][3]="3849";
		arr[4][4]="chennai express";

		
		
		return arr;
		

		

		
	}

	}
}
