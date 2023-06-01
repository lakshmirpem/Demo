package ciboGenriclibraries;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author User
 *
 */

public class ExcelUtility {
	/**
	 * this method is used for insert the data into Excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public void insertdata(String sheetName, int rowNo, int cellNo, String data) throws EncryptedDocumentException, IOException {
		
		FileInputStream fileInputStream = new FileInputStream(Ipathconstant.excelpath);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.createRow(rowNo);
		Cell cell = row.createCell(cellNo);
		cell.setCellValue(data);
		FileOutputStream fileOutputSream = new FileOutputStream(Ipathconstant.excelpath);
		workbook.write(fileOutputSream);
		workbook.close();
		
	}
	/**
	 * this method is used for get data from excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String getdata(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fileInputStream = new FileInputStream(Ipathconstant.excelpath);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		DataFormatter dataFormatter = new DataFormatter();
		String data = dataFormatter.formatCellValue(cell);
		return data;
		
	}
	/**
	 * this method is used to get count of rowscreated in excel shett
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowNumber(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fileInputStream = new FileInputStream(Ipathconstant.excelpath);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		int row=sheet.getLastRowNum();
		return row;
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


