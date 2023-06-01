package ciboGenriclibraries;

import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



 public class ExcelUtils{

 public Object[][] data20(String Sheetname) throws Throwable 
  {
	
	FileInputStream fis=new FileInputStream(Ipathconstant.excelpath);
	Workbook w = WorkbookFactory.create(fis);
	Sheet s = w.getSheet(Sheetname);
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
			hmap.put(key, value);
		}
		return hmap;
	}
}

