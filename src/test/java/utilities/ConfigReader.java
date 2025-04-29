package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public static Properties properties;
	
	public static void LoadProperties() throws FileNotFoundException
	{
		try
		{
			//System.getProperty("user.dir") + "/src/test/resources/config.properties";
			String path = System.getProperty("user.dir") + "/src/test/resources/configFiles/config.properties";
		FileInputStream fis = new FileInputStream(path);
		properties = new Properties();
		properties.load(fis);
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static String getproperty(String key)
	{
		return properties.getProperty(key);
	}
	
	

}
