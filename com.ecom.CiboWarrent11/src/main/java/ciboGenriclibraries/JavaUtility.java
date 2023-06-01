package ciboGenriclibraries;

import java.security.PublicKey;
import java.util.Date;
import java.util.Random;

public class JavaUtility
{
    public int getRandomNumber() 
     {
    	Random random = new Random();
	  int randno = random.nextInt(1000);
	   return randno;
    }
	public String currentSystemDate() 
	{
		Date date=new Date();
		String currentDate=date.toString();
		return currentDate;
	}
	public String getDateInformat()
	{
		Date date = new Date();
		String cdate = date.toString();
		String[] d = cdate.split("");
		int month=date.getMonth();
		String week = d[0];
		String cdate1=d[2];
		String year=d[5];
		String dateFormat=month+""+week+""+cdate1+""+year;
		return dateFormat;
	}
}

