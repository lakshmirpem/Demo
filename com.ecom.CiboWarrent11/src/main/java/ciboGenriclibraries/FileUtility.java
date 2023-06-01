package ciboGenriclibraries;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility 
{
  public String getPropertyKeyvalue(String Key) throws IOException 
  {
	  FileInputStream fileinput = new FileInputStream(Ipathconstant.propertyFilepath);
	  Properties property = new Properties();
	  property.load(fileinput);
	 String value = property.getProperty(Key);
	 return value;
	 
  }
  
}
