package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtils {

	private Properties prop;
	
	public PropertyUtils() {
		try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
			prop = new Properties();
			prop.load(fis);
			
		} catch (Exception e) {
			
			// e.getMessage();
			System.err.println("Issue in reading the config file");
			e.printStackTrace();
		}
	}
	
		public String getProperty(String keyName) {
			
			return prop.getProperty(keyName);
		}
		
		
		public void setProperty(String key, String val) {
			prop.setProperty(key, val);
		}
			
}


