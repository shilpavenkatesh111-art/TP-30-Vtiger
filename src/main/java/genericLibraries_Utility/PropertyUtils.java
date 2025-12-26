package genericLibraries_Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
	/**
	 * This method is used to read data from property file
	 * @author Srinivas V
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String readDataDromPropertyFile(String key) throws IOException 
	{
		FileInputStream fis = new FileInputStream(IpathConstants.propertypath);
		Properties pObj=new Properties();
		pObj.load(fis);
		String value=pObj.getProperty(key);
		return value;
	}

}
