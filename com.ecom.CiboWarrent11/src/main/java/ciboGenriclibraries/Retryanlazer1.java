package ciboGenriclibraries;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retryanlazer1 implements IRetryAnalyzer
{
 int counter=0;
 int retrylimit=2;
 
	public boolean retry(ITestResult result) 
	{
		if(counter<retrylimit) 
		{
			counter++;
			return  true;
		}
		
	
		return false;
	}

	
}

