package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ciboGenriclibraries.Ipathconstant;

public class Getdata
{
	@Test(dataProviderClass=Getdata.class,dataProvider="data20")
	public void getData( String src,String dst,String price)
	{
		System.out.println("From--"+src+"--to--"+dst+"--price--"+price);

		
	}
	@DataProvider
	public Object[][] data20() throws Throwable 
  {
	
	FileInputStream fis=new FileInputStream(Ipathconstant.excelpath);
	Workbook w = WorkbookFactory.create(fis);
	Sheet s = w.getSheet("DataProvider");
	int lastrow = s.getLastRowNum()+1;
	int lastcell = s.getRow(0).getLastCellNum();
	
	Object[][] obj = new Object[lastrow][lastcell];
	for(int i=0;i<lastrow;i++) 
	{
		for(int j=0;j<lastcell;j++)
		{
			obj[i][j]= s.getRow(i).getCell(j).getStringCellValue();
		} 

	}
	return obj;
	
}
	public HashMap<String,String> restdata(String Sheetname) throws Throwable 
	{
		FileInputStream fi = new FileInputStream(Ipathconstant.excelpath);
		Workbook w = WorkbookFactory.create(fi);
		Sheet s = w.getSheet(Sheetname);
		int count = s.getLastRowNum();
		HashMap<String, String> hmap = new HashMap<String, String>();
		for(int i=0;i<=count;i++) 
		{
			String key = s.getRow(i).getCell(0).getStringCellValue();
			String value = s.getRow(i).getCell(1).getStringCellValue();
		}
		return hmap;
	}

}
